package com.tencent.thumbplayer.api.common;

/* loaded from: classes26.dex */
public class TPAudioFrameBuffer {
    public static final int EVENT_FLAG_EOS = 1;
    public static final int EVENT_FLAG_FLUSH = 2;
    private long mChannelLayout;
    private int mChannels;
    private byte[][] mData;
    private int[] mDataSize;
    private int mEventFlag;
    private int mFormat;
    private int mNbSamples;
    private long mPtsMs;
    private int mSampleRate;

    public long getChannelLayout() {
        return this.mChannelLayout;
    }

    public int getChannels() {
        return this.mChannels;
    }

    public byte[][] getData() {
        return this.mData;
    }

    public int[] getDataSize() {
        return this.mDataSize;
    }

    public int getEventFlag() {
        return this.mEventFlag;
    }

    public int getFormat() {
        return this.mFormat;
    }

    public int getNbSamples() {
        return this.mNbSamples;
    }

    public long getPtsMs() {
        return this.mPtsMs;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public void setChannelLayout(long j3) {
        this.mChannelLayout = j3;
    }

    public void setChannels(int i3) {
        this.mChannels = i3;
    }

    public void setData(byte[][] bArr) {
        this.mData = bArr;
    }

    public void setDataSize(int[] iArr) {
        this.mDataSize = iArr;
    }

    public void setEventFlag(int i3) {
        this.mEventFlag = i3;
    }

    public void setFormat(int i3) {
        this.mFormat = i3;
    }

    public void setNbSamples(int i3) {
        this.mNbSamples = i3;
    }

    public void setPtsMs(long j3) {
        this.mPtsMs = j3;
    }

    public void setSampleRate(int i3) {
        this.mSampleRate = i3;
    }
}
