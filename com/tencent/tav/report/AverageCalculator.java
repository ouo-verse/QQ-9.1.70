package com.tencent.tav.report;

/* compiled from: P */
/* loaded from: classes26.dex */
class AverageCalculator {
    private long totalNum = 0;
    private long count = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getAvg() {
        long j3 = this.count;
        if (j3 == 0) {
            return 0L;
        }
        return this.totalNum / j3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getCount() {
        return this.count;
    }

    long getTotalNum() {
        return this.totalNum;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.count = 0L;
        this.totalNum = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tick(long j3) {
        this.totalNum += j3;
        this.count++;
    }
}
