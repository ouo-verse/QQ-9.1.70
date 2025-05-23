package com.tencent.thumbplayer.api.common;

/* loaded from: classes26.dex */
public class TPProgramInfo {
    private boolean mActivated;
    private long mBandwidth;
    private int mProgramId;
    private String mResolution;
    private String mUrl;

    public long getBandwidth() {
        return this.mBandwidth;
    }

    public int getProgramId() {
        return this.mProgramId;
    }

    public String getResolution() {
        return this.mResolution;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public boolean isActivated() {
        return this.mActivated;
    }

    public void setActivated(boolean z16) {
        this.mActivated = z16;
    }

    public void setBandwidth(long j3) {
        this.mBandwidth = j3;
    }

    public void setProgramId(int i3) {
        this.mProgramId = i3;
    }

    public void setResolution(String str) {
        this.mResolution = str;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }
}
