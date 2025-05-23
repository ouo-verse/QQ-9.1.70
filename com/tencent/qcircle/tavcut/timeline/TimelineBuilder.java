package com.tencent.qcircle.tavcut.timeline;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TimelineBuilder {
    private String mMaxDurationTps;
    private long mMaxSelectDurationMs = -1;
    private long mMinSelectDurationMs = -1;
    private boolean mLockMode = false;
    private boolean mSliderBarMode = true;
    private boolean mShowMask = true;
    private boolean mShowDuration = true;

    public String getMaxDurationTps() {
        return this.mMaxDurationTps;
    }

    public long getMaxSelectDurationMs() {
        return this.mMaxSelectDurationMs;
    }

    public long getMinSelectDurationMs() {
        return this.mMinSelectDurationMs;
    }

    public boolean isLockMode() {
        return this.mLockMode;
    }

    public boolean isShowDuration() {
        return this.mShowDuration;
    }

    public boolean isShowMask() {
        return this.mShowMask;
    }

    public boolean isSliderBarMode() {
        return this.mSliderBarMode;
    }

    public TimelineBuilder setLockMode(boolean z16) {
        this.mLockMode = z16;
        return this;
    }

    public TimelineBuilder setMaxDurationTps(String str) {
        this.mMaxDurationTps = str;
        return this;
    }

    public TimelineBuilder setMaxSelectDurationMs(long j3) {
        this.mMaxSelectDurationMs = j3;
        return this;
    }

    public TimelineBuilder setMinSelectDurationMs(long j3) {
        this.mMinSelectDurationMs = j3;
        return this;
    }

    public TimelineBuilder setShowDuration(boolean z16) {
        this.mShowDuration = z16;
        return this;
    }

    public TimelineBuilder setShowMask(boolean z16) {
        this.mShowMask = z16;
        return this;
    }

    public TimelineBuilder setSliderBarMode(boolean z16) {
        this.mSliderBarMode = z16;
        return this;
    }
}
