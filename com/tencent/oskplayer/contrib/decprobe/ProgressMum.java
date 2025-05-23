package com.tencent.oskplayer.contrib.decprobe;

import android.util.Pair;
import com.tencent.oskplayer.support.log.Logger;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes34.dex */
public class ProgressMum {
    public static final String LOG_TAG = "ProgressMum";
    private static final float STEP_MAX = 100.0f;
    float currentStep = 0.0f;
    int mMaxStep = 100;
    String name = "";
    ArrayList<Pair<ProgressMum, Float>> subProgreses = new ArrayList<>();

    public static void nestingTest() {
        ProgressMum progressMum = new ProgressMum();
        ProgressMum progressMum2 = new ProgressMum();
        ProgressMum progressMum3 = new ProgressMum();
        ProgressMum progressMum4 = new ProgressMum();
        progressMum4.addProgress(progressMum, 0.5f);
        progressMum4.addProgress(progressMum2, 0.5f);
        ProgressMum progressMum5 = new ProgressMum();
        progressMum5.addProgress(progressMum4, 0.2f);
        progressMum5.addProgress(progressMum3, 0.8f);
        progressMum.updateStep(50);
        progressMum2.updateStep(50);
        Logger.g().i(LOG_TAG, progressMum5.getProgress() + "");
    }

    public static void test() {
        ProgressMum progressMum = new ProgressMum();
        ProgressMum progressMum2 = new ProgressMum();
        ProgressMum progressMum3 = new ProgressMum();
        ProgressMum progressMum4 = new ProgressMum();
        progressMum4.addProgress(progressMum, 0.1f);
        progressMum4.addProgress(progressMum2, 0.2f);
        progressMum4.addProgress(progressMum3, 0.7f);
        progressMum.setMaxStep(1000);
        progressMum.updateStep(100);
        progressMum2.updateStep(0);
        progressMum3.updateStep(0);
        Logger.g().i(LOG_TAG, progressMum4.getProgress() + "");
    }

    public void addProgress(ProgressMum progressMum, float f16) {
        this.subProgreses.add(new Pair<>(progressMum, Float.valueOf(f16)));
    }

    public int getMaxStep() {
        return this.mMaxStep;
    }

    public float getProgress() {
        if (this.subProgreses.size() > 0) {
            Iterator<Pair<ProgressMum, Float>> it = this.subProgreses.iterator();
            float f16 = 0.0f;
            while (it.hasNext()) {
                Pair<ProgressMum, Float> next = it.next();
                f16 += ((ProgressMum) next.first).getProgress() * 100.0f * ((Float) next.second).floatValue();
            }
            this.currentStep = f16;
        }
        return this.currentStep / 100.0f;
    }

    @Deprecated
    public void markFinishForce() {
        updateStep(getMaxStep());
    }

    public void setMaxStep(int i3) {
        this.mMaxStep = i3;
    }

    public void updateStep(int i3) {
        if (this.subProgreses.size() == 0) {
            this.currentStep = (i3 / this.mMaxStep) * 100.0f;
        }
    }
}
