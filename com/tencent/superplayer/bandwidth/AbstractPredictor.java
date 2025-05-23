package com.tencent.superplayer.bandwidth;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes26.dex */
public abstract class AbstractPredictor {
    private static final float DEFAULT_PREDICTION_SHAKE = 0.2f;
    private final ArrayList<AbstractPredictor> childPredictors = new ArrayList<>();
    protected long currentPredition;
    protected long prediction;

    /* JADX INFO: Access modifiers changed from: protected */
    public void addChildPredictor(AbstractPredictor abstractPredictor) {
        if (!this.childPredictors.contains(abstractPredictor)) {
            this.childPredictors.add(abstractPredictor);
        }
    }

    public void onIdle() {
        Iterator<AbstractPredictor> it = this.childPredictors.iterator();
        while (it.hasNext()) {
            it.next().onIdle();
        }
        this.currentPredition = 0L;
    }

    abstract long onSample(long j3);

    public void reset() {
        Iterator<AbstractPredictor> it = this.childPredictors.iterator();
        while (it.hasNext()) {
            it.next().reset();
        }
        this.prediction = 0L;
    }

    public void sample(long j3) {
        Iterator<AbstractPredictor> it = this.childPredictors.iterator();
        while (it.hasNext()) {
            it.next().sample(j3);
        }
        long onSample = onSample(j3);
        this.currentPredition = onSample;
        if (onSample < 0) {
            this.currentPredition = 0L;
        }
        float abs = (float) Math.abs(this.currentPredition - this.prediction);
        long j16 = this.prediction;
        if (abs / ((float) j16) < 0.2f) {
            this.prediction = Math.max(this.currentPredition, j16);
        } else {
            this.prediction = this.currentPredition;
        }
    }
}
