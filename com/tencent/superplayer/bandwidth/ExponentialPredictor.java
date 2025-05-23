package com.tencent.superplayer.bandwidth;

/* loaded from: classes26.dex */
public class ExponentialPredictor extends AbstractPredictor {
    private final float weight;

    public ExponentialPredictor(float f16) {
        this.weight = f16;
    }

    @Override // com.tencent.superplayer.bandwidth.AbstractPredictor
    public long onSample(long j3) {
        if (this.currentPredition > 0) {
            float f16 = this.weight;
            return (((float) j3) * f16) + ((1.0f - f16) * ((float) r0));
        }
        return j3;
    }

    public String toString() {
        return "ExponentialPredictor(" + this.weight + ')';
    }
}
