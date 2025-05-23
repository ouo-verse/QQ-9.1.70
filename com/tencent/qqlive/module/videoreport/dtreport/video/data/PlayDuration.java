package com.tencent.qqlive.module.videoreport.dtreport.video.data;

/* loaded from: classes22.dex */
public class PlayDuration {
    private long mLastStashPlayedTime;
    private long mSumPlayDuration;

    public long getLastStashPlayedTime() {
        return this.mLastStashPlayedTime;
    }

    public long getSumPlayDuration() {
        return this.mSumPlayDuration;
    }

    public void setLastStashPlayedTime(long j3) {
        this.mLastStashPlayedTime = j3;
    }

    public void setSumPlayDuration(long j3) {
        this.mSumPlayDuration = j3;
    }
}
