package com.tencent.mobileqq.shortvideo.mtveffects;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RandomTime {
    public long mEndPos;
    public boolean mLoop;
    public long mStartPos;

    public RandomTime() {
        this.mStartPos = -1L;
        this.mEndPos = -1L;
        this.mLoop = true;
    }

    public boolean isLoop() {
        return this.mLoop;
    }

    public void reset() {
        this.mStartPos = -1L;
        this.mEndPos = -1L;
    }

    public RandomTime(boolean z16) {
        this.mStartPos = -1L;
        this.mEndPos = -1L;
        this.mLoop = z16;
    }
}
