package com.tencent.thumbplayer.api.common;

/* loaded from: classes26.dex */
public class TPHlsTag implements ITPContainerInfo {
    private String mCodecs;
    private String mGroupId;
    private String mLanguage;
    private String mName;
    private String mResolution;
    private long mBandwidth = 0;
    private float mFrameRate = 0.0f;

    public long getBandwidth() {
        return this.mBandwidth;
    }

    public String getCodecs() {
        return this.mCodecs;
    }

    @Override // com.tencent.thumbplayer.api.common.ITPContainerInfo
    public int getContainerType() {
        return 1;
    }

    public float getFrameRate() {
        return this.mFrameRate;
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public String getLanguage() {
        return this.mLanguage;
    }

    public String getName() {
        return this.mName;
    }

    public String getResolution() {
        return this.mResolution;
    }

    public void setBandwidth(long j3) {
        this.mBandwidth = j3;
    }

    public void setCodecs(String str) {
        this.mCodecs = str;
    }

    public void setFrameRate(float f16) {
        this.mFrameRate = f16;
    }

    public void setGroupId(String str) {
        this.mGroupId = str;
    }

    public void setLanguage(String str) {
        this.mLanguage = str;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setResolution(String str) {
        this.mResolution = str;
    }

    public String toString() {
        return "HlsTag, name=" + this.mName + ", language=" + this.mLanguage + ", groupId=" + this.mGroupId + ", bandwidth=" + this.mBandwidth + ", resolution=" + this.mResolution + ", frameRate=" + this.mFrameRate + ", codecs=" + this.mCodecs;
    }
}
