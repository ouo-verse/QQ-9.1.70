package com.tencent.thumbplayer.api.common;

/* loaded from: classes26.dex */
public class TPVideoPacketBuffer {
    private byte[] mData;
    private TPDolbyVisionInfo mDolbyVisionInfo;
    private long mDtsMs;
    private long mPtsMs;

    public byte[] getData() {
        return this.mData;
    }

    public TPDolbyVisionInfo getDolbyVisionInfo() {
        return this.mDolbyVisionInfo;
    }

    public long getDtsMs() {
        return this.mDtsMs;
    }

    public long getPtsMs() {
        return this.mPtsMs;
    }

    public void setData(byte[] bArr) {
        this.mData = bArr;
    }

    public void setDolbyVisionInfo(TPDolbyVisionInfo tPDolbyVisionInfo) {
        this.mDolbyVisionInfo = tPDolbyVisionInfo;
    }

    public void setDtsMs(long j3) {
        this.mDtsMs = j3;
    }

    public void setPtsMs(long j3) {
        this.mPtsMs = j3;
    }
}
