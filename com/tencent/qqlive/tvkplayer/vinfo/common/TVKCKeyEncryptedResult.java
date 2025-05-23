package com.tencent.qqlive.tvkplayer.vinfo.common;

import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKCKeyEncryptedResult {
    public byte[] mCKey;
    public byte[] mCipher;

    @Nullable
    public byte[] getCKey() {
        return this.mCKey;
    }

    @Nullable
    public byte[] getCipher() {
        return this.mCipher;
    }

    public void setCKey(@Nullable byte[] bArr) {
        this.mCKey = bArr;
    }

    public void setCipher(@Nullable byte[] bArr) {
        this.mCipher = bArr;
    }
}
