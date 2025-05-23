package com.tencent.thumbplayer.api.resourceloader;

/* loaded from: classes26.dex */
public class TPResourceLoaderMediaContentInfo {
    private final long mContentLength;
    private final String mContentType;
    private final int mRetCode;

    /* loaded from: classes26.dex */
    public static class Builder {
        public TPResourceLoaderMediaContentInfo buildErrorContentInfo() {
            return new TPResourceLoaderMediaContentInfo("", 0L, -2);
        }

        public TPResourceLoaderMediaContentInfo buildSuccessfulContentInfo(String str, long j3) {
            return new TPResourceLoaderMediaContentInfo(str, j3, 0);
        }

        public TPResourceLoaderMediaContentInfo buildTryAgainContentInfo() {
            return new TPResourceLoaderMediaContentInfo("", 0L, -1);
        }
    }

    public long getContentLength() {
        return this.mContentLength;
    }

    public String getContentType() {
        return this.mContentType;
    }

    public int getRetCode() {
        return this.mRetCode;
    }

    TPResourceLoaderMediaContentInfo(String str, long j3, int i3) {
        this.mContentType = str;
        this.mContentLength = j3;
        this.mRetCode = i3;
    }
}
