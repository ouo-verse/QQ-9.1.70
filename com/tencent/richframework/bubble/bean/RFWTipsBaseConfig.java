package com.tencent.richframework.bubble.bean;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFWTipsBaseConfig {
    private int mBottomMargin;
    private long mDuration;
    private int mLeftMargin;
    private int mPriority = 100;
    private int mRightMargin;
    private String mTitle;
    private int mTopMargin;

    public int getBottomMargin() {
        return this.mBottomMargin;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public int getLeftMargin() {
        return this.mLeftMargin;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int getRightMargin() {
        return this.mRightMargin;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public int getTopMargin() {
        return this.mTopMargin;
    }

    public void setDuration(long j3) {
        this.mDuration = j3;
    }

    public void setMargin(int i3, int i16, int i17, int i18) {
        this.mLeftMargin = i3;
        this.mRightMargin = i16;
        this.mTopMargin = i17;
        this.mBottomMargin = i18;
    }
}
