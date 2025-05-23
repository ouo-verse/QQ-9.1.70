package com.tencent.superplayer.bandwidth;

/* loaded from: classes26.dex */
public class DoubleExponentialPredictor extends AbstractPredictor {
    private final ExponentialPredictor firstExponential;
    private final ExponentialPredictor secondExponential;
    private final float weight;

    public DoubleExponentialPredictor(float f16) {
        this.weight = f16;
        this.firstExponential = new ExponentialPredictor(f16);
        this.secondExponential = new ExponentialPredictor(f16);
    }

    @Override // com.tencent.superplayer.bandwidth.AbstractPredictor
    public void onIdle() {
        super.onIdle();
        this.firstExponential.onIdle();
        this.secondExponential.onIdle();
    }

    @Override // com.tencent.superplayer.bandwidth.AbstractPredictor
    public long onSample(long j3) {
        this.firstExponential.sample(j3);
        long j16 = this.firstExponential.currentPredition;
        this.secondExponential.sample(j16);
        long j17 = (2 * j16) - this.secondExponential.currentPredition;
        float f16 = this.weight;
        return ((float) j17) + ((f16 / (1.0f - f16)) * ((float) (j16 - r0)));
    }

    @Override // com.tencent.superplayer.bandwidth.AbstractPredictor
    public void reset() {
        super.reset();
        this.firstExponential.reset();
        this.secondExponential.reset();
    }

    public String toString() {
        return "DoubleExponentialPredictor(" + this.weight + ')';
    }
}
