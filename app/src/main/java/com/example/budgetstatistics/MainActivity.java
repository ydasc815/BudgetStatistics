package com.example.budgetstatistics;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.hookedonplay.decoviewlib.DecoView;
import com.hookedonplay.decoviewlib.charts.DecoDrawEffect;
import com.hookedonplay.decoviewlib.charts.SeriesItem;
import com.hookedonplay.decoviewlib.events.DecoEvent;

public class MainActivity extends AppCompatActivity {

    private int BackIndex;
    private int Series1Index;
    private int Series2Index;
    private int Series3Index;
    private int Series4Index;
    private DecoView decoView;
    private final float seriesMax = 50f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decoView = findViewById(R.id.dynamic_arc_view);

        createBackSeries();
        createBackSeries1();
        createBackSeries2();
        createBackSeries3();
        createBackSeries4();
        createEvents();
    }
    private void createBackSeries(){
        SeriesItem seriesItem = new SeriesItem.Builder(Color.parseColor("#FFE2E2E2"))
                .setRange(0, seriesMax, 0)
                .setInitialVisibility(true)
                .build();
        BackIndex = decoView.addSeries(seriesItem);
    }
    private void createBackSeries1(){
        final SeriesItem seriesItem = new SeriesItem.Builder(Color.parseColor("#FFAA00"))
                .setRange(0, seriesMax, 38)
                .setInitialVisibility(false)
                .build();
        final TextView textPercentage = findViewById(R.id.textPercentage);
        seriesItem.addArcSeriesItemListener(new SeriesItem.SeriesItemListener() {
            @Override
            public void onSeriesItemAnimationProgress(float percentComplete, float currentPosition) {
                float percentFilled = ((currentPosition - seriesItem.getMinValue()) / (seriesItem.getMaxValue() - seriesItem.getMinValue()));
                textPercentage.setText("Savings : "+"\n"+ (100 - (percentFilled * 100f)) + "%");
            }

            @Override
            public void onSeriesItemDisplayProgress(float v) {

            }
        });
        Series1Index = decoView.addSeries(seriesItem);
    }
    private void createBackSeries2() {
        final SeriesItem seriesItem = new SeriesItem.Builder(Color.parseColor("#DF4141"))
                .setRange(0, seriesMax, 28)
                .setInitialVisibility(false)
                .build();

        //final TextView textActivity2 = (TextView) findViewById(R.id.textActivity2);

        seriesItem.addArcSeriesItemListener(new SeriesItem.SeriesItemListener() {
            @Override
            public void onSeriesItemAnimationProgress(float percentComplete, float currentPosition) {
                //textActivity2.setText(String.format("%.0f Km", currentPosition));
            }

            @Override
            public void onSeriesItemDisplayProgress(float percentComplete) {

            }
        });

        Series2Index = decoView.addSeries(seriesItem);
    }

    private void createBackSeries3() {
        final SeriesItem seriesItem = new SeriesItem.Builder(Color.parseColor("#2185AB"))
                .setRange(0, seriesMax, 14)
                .setInitialVisibility(false)
                .build();

        //final TextView textActivity3 = (TextView) findViewById(R.id.textActivity3);

        seriesItem.addArcSeriesItemListener(new SeriesItem.SeriesItemListener() {
            @Override
            public void onSeriesItemAnimationProgress(float percentComplete, float currentPosition) {
                //textActivity3.setText(String.format("%.2f Km", currentPosition));
            }

            @Override
            public void onSeriesItemDisplayProgress(float percentComplete) {

            }
        });

        Series3Index = decoView.addSeries(seriesItem);
    }
    private void createBackSeries4() {
        final SeriesItem seriesItem = new SeriesItem.Builder(Color.parseColor("#55D880"))
                .setRange(0, seriesMax, 0)
                .setInitialVisibility(false)
                .build();

        //final TextView textActivity2 = (TextView) findViewById(R.id.textActivity2);

        seriesItem.addArcSeriesItemListener(new SeriesItem.SeriesItemListener() {
            @Override
            public void onSeriesItemAnimationProgress(float percentComplete, float currentPosition) {
                //textActivity2.setText(String.format("%.0f Km", currentPosition));
            }

            @Override
            public void onSeriesItemDisplayProgress(float percentComplete) {

            }
        });

        Series4Index = decoView.addSeries(seriesItem);
    }

    private void createEvents() {
        //decoView.executeReset();

        decoView.addEvent(new DecoEvent.Builder(seriesMax)
                .setIndex(BackIndex)
                .setDuration(3000)
                .setDelay(100)
                .build());

        decoView.addEvent(new DecoEvent.Builder(DecoDrawEffect.EffectType.EFFECT_SPIRAL_OUT)
                .setIndex(Series1Index)
                .setDuration(2000)
                .setDelay(1250)
                .build());

        decoView.addEvent(new DecoEvent.Builder(46f)
                .setIndex(Series1Index)
                .setDelay(3250)
                .build());

        decoView.addEvent(new DecoEvent.Builder(DecoDrawEffect.EffectType.EFFECT_SPIRAL_OUT)
                .setIndex(Series2Index)
                .setDuration(1000)
                .setEffectRotations(1)
                .setDelay(7000)
                .build());

        decoView.addEvent(new DecoEvent.Builder(38f)
                .setIndex(Series2Index)
                .setDelay(8500)
                .build());

        decoView.addEvent(new DecoEvent.Builder(DecoDrawEffect.EffectType.EFFECT_SPIRAL_OUT)
                .setIndex(Series3Index)
                .setDuration(1000)
                .setEffectRotations(1)
                .setDelay(12500)
                .build());

        decoView.addEvent(new DecoEvent.Builder(28f)
                .setIndex(Series3Index)
                .setDelay(14000)
                .build());
        decoView.addEvent(new DecoEvent.Builder(DecoDrawEffect.EffectType.EFFECT_SPIRAL_OUT)
                .setIndex(Series4Index)
                .setDuration(1000)
                .setEffectRotations(1)
                .setDelay(14000)
                .build());

        decoView.addEvent(new DecoEvent.Builder(14f)
                .setIndex(Series4Index)
                .setDelay(15000)
                .build());

//        decoView.addEvent(new DecoEvent.Builder(0).setIndex(Series3Index).setDelay(18000).build());
//
//        decoView.addEvent(new DecoEvent.Builder(0).setIndex(Series2Index).setDelay(18000).build());

//        decoView.addEvent(new DecoEvent.Builder(0)
//                .setIndex(Series1Index)
//                .setDelay(20000)
//                .setDuration(1000)
//                .setInterpolator(new AnticipateInterpolator())
//                .setListener(new DecoEvent.ExecuteEventListener() {
//                    @Override
//                    public void onEventStart(DecoEvent decoEvent) {
//
//                    }
//
//                    @Override
//                    public void onEventEnd(DecoEvent decoEvent) {
//                        resetText();
//                    }
//                })
//                .build());

//        decoView.addEvent(new DecoEvent.Builder(DecoDrawEffect.EffectType.EFFECT_SPIRAL_EXPLODE)
//                .setIndex(Series1Index)
//                .setDelay(21000)
//                .setDuration(3000)
//                .setDisplayText("GOAL!")
//                .setListener(new DecoEvent.ExecuteEventListener() {
//                    @Override
//                    public void onEventStart(DecoEvent decoEvent) {
//
//                    }
//
//                    @Override
//                    public void onEventEnd(DecoEvent decoEvent) {
//                        createEvents();
//                    }
//                })
//                .build());
//
//        resetText();
    }

//    private void resetText() {
//        ((TextView) findViewById(R.id.textActivity1)).setText("");
//        ((TextView) findViewById(R.id.textActivity2)).setText("");
//        ((TextView) findViewById(R.id.textActivity3)).setText("");
//        ((TextView) findViewById(R.id.textPercentage)).setText("");
//        ((TextView) findViewById(R.id.textRemaining)).setText("");
//    }
}


