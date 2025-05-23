package com.tencent.qqlive.tvkplayer.api.richmedia.async;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKRichMediaTimeRange {
    private long mEndTimeMs;
    private long mStartTimeMs;

    public TVKRichMediaTimeRange(long j3, long j16) {
        this.mStartTimeMs = j3;
        this.mEndTimeMs = j16;
    }

    public long getEndTimeMs() {
        return this.mEndTimeMs;
    }

    public long getStartTimeMs() {
        return this.mStartTimeMs;
    }

    public void setEndTimeMs(long j3) {
        this.mEndTimeMs = j3;
    }

    public void setStartTimeMs(long j3) {
        this.mStartTimeMs = j3;
    }
}
