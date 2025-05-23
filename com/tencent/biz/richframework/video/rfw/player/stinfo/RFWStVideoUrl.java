package com.tencent.biz.richframework.video.rfw.player.stinfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWStVideoUrl {
    private boolean mHasWatermark;
    private int mHeight;
    private int mLevelType;
    private String mPlayUrl = "";
    private int mTransStatus;
    private float mVideoClarityScore;
    private int mVideoPrior;
    private int mVideoRate;
    private int mWidth;

    public int getHeight() {
        return this.mHeight;
    }

    public int getLevelType() {
        return this.mLevelType;
    }

    public String getPlayUrl() {
        return this.mPlayUrl;
    }

    public int getTransStatus() {
        return this.mTransStatus;
    }

    public float getVideoClarityScore() {
        return this.mVideoClarityScore;
    }

    public int getVideoPrior() {
        return this.mVideoPrior;
    }

    public int getVideoRate() {
        return this.mVideoRate;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isHasWatermark() {
        return this.mHasWatermark;
    }

    public RFWStVideoUrl setHasWatermark(boolean z16) {
        this.mHasWatermark = z16;
        return this;
    }

    public RFWStVideoUrl setHeight(int i3) {
        this.mHeight = i3;
        return this;
    }

    public RFWStVideoUrl setLevelType(int i3) {
        this.mLevelType = i3;
        return this;
    }

    public RFWStVideoUrl setPlayUrl(String str) {
        this.mPlayUrl = str;
        return this;
    }

    public RFWStVideoUrl setTransStatus(int i3) {
        this.mTransStatus = i3;
        return this;
    }

    public RFWStVideoUrl setVideoClarityScore(float f16) {
        this.mVideoClarityScore = f16;
        return this;
    }

    public RFWStVideoUrl setVideoPrior(int i3) {
        this.mVideoPrior = i3;
        return this;
    }

    public RFWStVideoUrl setVideoRate(int i3) {
        this.mVideoRate = i3;
        return this;
    }

    public RFWStVideoUrl setWidth(int i3) {
        this.mWidth = i3;
        return this;
    }
}
