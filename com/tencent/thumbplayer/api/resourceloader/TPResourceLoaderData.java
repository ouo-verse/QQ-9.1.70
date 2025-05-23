package com.tencent.thumbplayer.api.resourceloader;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes26.dex */
public class TPResourceLoaderData {
    private final byte[] mData;
    private final int mRetCode;

    /* loaded from: classes26.dex */
    public static class Builder {
        public TPResourceLoaderData buildErrorData() {
            return new TPResourceLoaderData(null, -2);
        }

        public TPResourceLoaderData buildSuccessfulData(@NonNull byte[] bArr) {
            return new TPResourceLoaderData(bArr, 0);
        }

        public TPResourceLoaderData buildTryAgainData() {
            return new TPResourceLoaderData(null, -1);
        }
    }

    public byte[] getData() {
        return this.mData;
    }

    public int getRetCode() {
        return this.mRetCode;
    }

    TPResourceLoaderData(@Nullable byte[] bArr, int i3) {
        this.mData = bArr;
        this.mRetCode = i3;
    }
}
