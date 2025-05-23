package com.tencent.qqmini.sdk.statistics;

/* compiled from: P */
/* loaded from: classes23.dex */
public class VarianceStatistics implements Statistic {
    private int mIndex = 0;
    private final float[] mSamples;

    public VarianceStatistics(int i3) {
        this.mSamples = new float[i3];
    }

    @Override // com.tencent.qqmini.sdk.statistics.Statistic
    public void addSample(float f16) {
        float[] fArr = this.mSamples;
        int i3 = this.mIndex;
        fArr[i3 % fArr.length] = f16;
        this.mIndex = i3 + 1;
    }

    @Override // com.tencent.qqmini.sdk.statistics.Statistic
    public float calculate() {
        int i3 = this.mIndex;
        float[] fArr = this.mSamples;
        if (i3 >= fArr.length) {
            i3 = fArr.length;
        }
        float f16 = 0.0f;
        if (i3 == 0) {
            return 0.0f;
        }
        float f17 = 0.0f;
        for (int i16 = 0; i16 < i3; i16++) {
            f17 += this.mSamples[i16];
        }
        float f18 = i3;
        float f19 = f17 / f18;
        for (int i17 = 0; i17 < i3; i17++) {
            float f26 = this.mSamples[i17] - f19;
            f16 += f26 * f26;
        }
        return f16 / f18;
    }

    @Override // com.tencent.qqmini.sdk.statistics.Statistic
    public void reset() {
        this.mIndex = 0;
    }
}
