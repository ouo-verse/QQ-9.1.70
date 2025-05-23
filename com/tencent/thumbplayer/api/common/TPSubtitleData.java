package com.tencent.thumbplayer.api.common;

/* loaded from: classes26.dex */
public abstract class TPSubtitleData {
    private long mStartTimeMs;

    public abstract int getDataType();

    public long getStartTimeMs() {
        return this.mStartTimeMs;
    }

    public void setStartTimeMs(long j3) {
        this.mStartTimeMs = j3;
    }
}
