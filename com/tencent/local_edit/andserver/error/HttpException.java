package com.tencent.local_edit.andserver.error;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HttpException extends RuntimeException {
    private int mStatusCode;

    public HttpException(int i3, String str) {
        super(str);
        this.mStatusCode = i3;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public HttpException(int i3, String str, Throwable th5) {
        super(str, th5);
        this.mStatusCode = i3;
    }

    public HttpException(int i3, Throwable th5) {
        super(th5);
        this.mStatusCode = i3;
    }
}
