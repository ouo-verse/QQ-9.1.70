package com.tencent.thumbplayer.api.capability;

/* loaded from: classes26.dex */
public class TPAudioCapabilityQueryParams {
    private long mChannelLayout;
    private int mCodecType;
    private int mDecoderType;
    private int mHOAOrder;
    private int mObjectCount;
    private int mSampleRate;

    public TPAudioCapabilityQueryParams(int i3, int i16, int i17, long j3, int i18) {
        this.mCodecType = i3;
        this.mDecoderType = i16;
        this.mSampleRate = i17;
        this.mChannelLayout = j3;
        this.mObjectCount = i18;
    }

    public long getChannelLayout() {
        return this.mChannelLayout;
    }

    public int getCodecType() {
        return this.mCodecType;
    }

    public int getDecoderType() {
        return this.mDecoderType;
    }

    public int getHOAOrder() {
        return this.mHOAOrder;
    }

    public int getObjectCount() {
        return this.mObjectCount;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public TPAudioCapabilityQueryParams(int i3, int i16, int i17, int i18) {
        this.mCodecType = i3;
        this.mDecoderType = i16;
        this.mSampleRate = i17;
        this.mHOAOrder = i18;
    }
}
