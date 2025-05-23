package com.tencent.qqlive.module.videoreport.collect;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TouchEventLimiter {
    private long count;
    private long lastKey;
    private long threshold = 1;

    public boolean allow(long j3) {
        if (j3 != this.lastKey) {
            this.lastKey = j3;
            this.threshold = 1L;
            this.count = 0L;
            return true;
        }
        long j16 = this.count + 1;
        this.count = j16;
        long j17 = this.threshold;
        if (j16 >= j17) {
            this.threshold = j17 * 2;
            this.count = 0L;
            return true;
        }
        return false;
    }
}
