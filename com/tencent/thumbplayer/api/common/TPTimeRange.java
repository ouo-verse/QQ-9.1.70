package com.tencent.thumbplayer.api.common;

/* loaded from: classes26.dex */
public class TPTimeRange {
    private long mEndTimeMs;
    private long mStartTimeMs;

    public TPTimeRange(long j3, long j16) {
        this.mStartTimeMs = j3;
        this.mEndTimeMs = j16;
    }

    public long getEndTimeMs() {
        return this.mEndTimeMs;
    }

    public long getStartTimeMs() {
        return this.mStartTimeMs;
    }
}
