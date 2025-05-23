package com.tencent.thumbplayer.api.common;

import androidx.annotation.Nullable;

/* loaded from: classes26.dex */
public class TPVideoSeiInfo {
    private int mCodecType = -1;
    private int mSeiType = -1;
    private byte[] mSeiData = null;

    public int getCodecType() {
        return this.mCodecType;
    }

    @Nullable
    public byte[] getSeiData() {
        return this.mSeiData;
    }

    public int getSeiType() {
        return this.mSeiType;
    }

    public void setCodecType(int i3) {
        this.mCodecType = i3;
    }

    public void setSeiData(byte[] bArr) {
        this.mSeiData = bArr;
    }

    public void setSeiType(int i3) {
        this.mSeiType = i3;
    }
}
