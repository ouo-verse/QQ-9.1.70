package com.tencent.mobileqq.mini.statistics;

/* compiled from: P */
/* loaded from: classes33.dex */
public class AverageStatistics implements Statistic {
    private int mCount;
    private float mTotal;

    @Override // com.tencent.mobileqq.mini.statistics.Statistic
    public void addSample(float f16) {
        this.mTotal += f16;
        this.mCount++;
    }

    @Override // com.tencent.mobileqq.mini.statistics.Statistic
    public float calculate() {
        int i3 = this.mCount;
        if (i3 == 0) {
            return 0.0f;
        }
        return this.mTotal / i3;
    }

    @Override // com.tencent.mobileqq.mini.statistics.Statistic
    public void reset() {
        this.mCount = 0;
        this.mTotal = 0;
    }
}
