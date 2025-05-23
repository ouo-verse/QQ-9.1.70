package com.tencent.qqlive.tvkplayer.vinfo.common;

import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKCKeyDecryptedResult {

    @Nullable
    private byte[] mData;
    private int mRetCode;

    @Nullable
    public byte[] getData() {
        return this.mData;
    }

    public int getRetCode() {
        return this.mRetCode;
    }

    public void setData(@Nullable byte[] bArr) {
        this.mData = bArr;
    }

    public void setRetCode(int i3) {
        this.mRetCode = i3;
    }
}
