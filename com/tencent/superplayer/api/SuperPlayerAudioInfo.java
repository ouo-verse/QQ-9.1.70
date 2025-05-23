package com.tencent.superplayer.api;

/* loaded from: classes26.dex */
public class SuperPlayerAudioInfo implements Cloneable {
    private int mAudioSampleRateHZ = -1;
    private long mAudioChannelLayout = -1;
    private int mAuidoOutPutFormat = -1;
    private int mAudioSampleFrameSizeByte = -1;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public long getAudioChannelLayout() {
        return this.mAudioChannelLayout;
    }

    public int getAudioSampleFrameSize() {
        return this.mAudioSampleFrameSizeByte;
    }

    public int getAudioSampleRateHZ() {
        return this.mAudioSampleRateHZ;
    }

    public int getAuidoOutPutFormat() {
        return this.mAuidoOutPutFormat;
    }

    public void setAudioChannelLayout(long j3) {
        this.mAudioChannelLayout = j3;
    }

    public void setAudioSampleFrameSize(int i3) {
        this.mAudioSampleFrameSizeByte = i3;
    }

    public void setAudioSampleRateHZ(int i3) {
        this.mAudioSampleRateHZ = i3;
    }

    public void setAuidoOutPutFormat(int i3) {
        this.mAuidoOutPutFormat = i3;
    }

    public String toString() {
        return "SuperPlayerAudioInfo[ mAudioSampleRateHZ:" + this.mAudioSampleRateHZ + "\nmAudioChannelLayout:" + this.mAudioChannelLayout + "\nmAuidoOutPutFormat:" + this.mAuidoOutPutFormat + "\nmAudioSampleFrameSizeByte:" + this.mAudioSampleFrameSizeByte + "\n]";
    }
}
