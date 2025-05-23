package com.tencent.thumbplayer.core.codec.capability;

/* loaded from: classes26.dex */
public class TPMediaCodecAudioDecoderQueryParams {
    private int mChannelLayout;
    private int mHOAOrder;
    private String mMimeType;
    private int mObjectCount;
    private int mSampleRate;

    public TPMediaCodecAudioDecoderQueryParams(String str, int i3, int i16, int i17) {
        this.mHOAOrder = 0;
        this.mMimeType = str;
        this.mSampleRate = i3;
        this.mChannelLayout = i16;
        this.mObjectCount = i17;
    }

    public int getChannelLayout() {
        return this.mChannelLayout;
    }

    public int getHOAOrder() {
        return this.mHOAOrder;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public int getObjectCount() {
        return this.mObjectCount;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public TPMediaCodecAudioDecoderQueryParams(String str, int i3, int i16) {
        this.mChannelLayout = 0;
        this.mObjectCount = 0;
        this.mMimeType = str;
        this.mSampleRate = i3;
        this.mHOAOrder = i16;
    }
}
