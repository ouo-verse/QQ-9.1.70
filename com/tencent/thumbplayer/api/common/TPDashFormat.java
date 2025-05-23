package com.tencent.thumbplayer.api.common;

/* loaded from: classes26.dex */
public class TPDashFormat implements ITPContainerInfo {
    private String mCodecs;
    private String mLabel;
    private String mLanguage;
    private String mMimeType;
    private String mRepresentationId;
    private int mWidth = 0;
    private int mHeight = 0;
    private int mBandwidth = 0;
    private int mChannels = 0;
    private int mSamplingRate = 0;
    private float mFrameRate = 0.0f;

    public int getBandwidth() {
        return this.mBandwidth;
    }

    public int getChannels() {
        return this.mChannels;
    }

    public String getCodecs() {
        return this.mCodecs;
    }

    @Override // com.tencent.thumbplayer.api.common.ITPContainerInfo
    public int getContainerType() {
        return 2;
    }

    public float getFrameRate() {
        return this.mFrameRate;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public String getLanguage() {
        return this.mLanguage;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public String getRepresentationId() {
        return this.mRepresentationId;
    }

    public int getSamplingRate() {
        return this.mSamplingRate;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setBandwidth(int i3) {
        this.mBandwidth = i3;
    }

    public void setChannels(int i3) {
        this.mChannels = i3;
    }

    public void setCodecs(String str) {
        this.mCodecs = str;
    }

    public void setFrameRate(float f16) {
        this.mFrameRate = f16;
    }

    public void setHeight(int i3) {
        this.mHeight = i3;
    }

    public void setLabel(String str) {
        this.mLabel = str;
    }

    public void setLanguage(String str) {
        this.mLanguage = str;
    }

    public void setMimeType(String str) {
        this.mMimeType = str;
    }

    public void setRepresentationId(String str) {
        this.mRepresentationId = str;
    }

    public void setSamplingRate(int i3) {
        this.mSamplingRate = i3;
    }

    public void setWidth(int i3) {
        this.mWidth = i3;
    }

    public String toString() {
        return "DashFormat, representationId=" + this.mRepresentationId + ", codecs=" + this.mCodecs + ", mimeType=" + this.mMimeType + ", language=" + this.mLanguage + ", label=" + this.mLabel + ", width=" + this.mWidth + ", height=" + this.mHeight + ", bandwidth=" + this.mBandwidth + ", channels=" + this.mChannels + ", frameRate=" + this.mFrameRate;
    }
}
