package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RMCodecAbility {
    public PttFormatType audioCodecFormat;
    public RMCodecType codecType;
    public Integer pictureFormat;
    public VideoCodecFormatType videoCodecFormat;

    public RMCodecAbility() {
        this.codecType = RMCodecType.values()[0];
    }

    public PttFormatType getAudioCodecFormat() {
        return this.audioCodecFormat;
    }

    public RMCodecType getCodecType() {
        return this.codecType;
    }

    public Integer getPictureFormat() {
        return this.pictureFormat;
    }

    public VideoCodecFormatType getVideoCodecFormat() {
        return this.videoCodecFormat;
    }

    public RMCodecAbility(Integer num, VideoCodecFormatType videoCodecFormatType, PttFormatType pttFormatType, RMCodecType rMCodecType) {
        RMCodecType rMCodecType2 = RMCodecType.values()[0];
        this.pictureFormat = num;
        this.videoCodecFormat = videoCodecFormatType;
        this.audioCodecFormat = pttFormatType;
        this.codecType = rMCodecType;
    }
}
