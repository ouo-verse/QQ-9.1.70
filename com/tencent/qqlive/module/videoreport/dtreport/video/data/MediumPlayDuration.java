package com.tencent.qqlive.module.videoreport.dtreport.video.data;

/* loaded from: classes22.dex */
public class MediumPlayDuration {
    private long mLastPlayedTime;
    private long mMediumPlayedTime;
    private float mSpeedRatio = 1.0f;
    private long mSumMediumPlayedTime;

    public long getLastPlayedTime() {
        return this.mLastPlayedTime;
    }

    public long getMediumPlayedTime() {
        return this.mMediumPlayedTime;
    }

    public float getSpeedRatio() {
        return this.mSpeedRatio;
    }

    public long getSumMediumPlayedTime() {
        return this.mSumMediumPlayedTime;
    }

    public void setLastPlayedTime(long j3) {
        this.mLastPlayedTime = j3;
    }

    public void setMediumPlayedTime(long j3) {
        this.mMediumPlayedTime = j3;
    }

    public void setSpeedRatio(float f16) {
        this.mSpeedRatio = f16;
    }

    public void setSumMediumPlayedTime(long j3) {
        this.mSumMediumPlayedTime = j3;
    }
}
