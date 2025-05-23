package com.tencent.mobileqq.mini.statistics;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MaxStatistics implements Statistic {
    private float mMax = Float.MIN_VALUE;

    @Override // com.tencent.mobileqq.mini.statistics.Statistic
    public void addSample(float f16) {
        if (f16 > this.mMax) {
            this.mMax = f16;
        }
    }

    @Override // com.tencent.mobileqq.mini.statistics.Statistic
    public float calculate() {
        return this.mMax;
    }

    @Override // com.tencent.mobileqq.mini.statistics.Statistic
    public void reset() {
        this.mMax = Float.MIN_VALUE;
    }
}
