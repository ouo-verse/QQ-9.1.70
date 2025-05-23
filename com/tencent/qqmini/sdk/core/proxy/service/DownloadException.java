package com.tencent.qqmini.sdk.core.proxy.service;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DownloadException extends RuntimeException {
    private int code;

    public DownloadException(int i3, String str) {
        super(str);
        this.code = i3;
    }

    public int getCode() {
        return this.code;
    }
}
