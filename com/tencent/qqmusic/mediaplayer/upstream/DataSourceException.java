package com.tencent.qqmusic.mediaplayer.upstream;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DataSourceException extends Exception {
    private final int errorCode;

    public DataSourceException(int i3, String str, Throwable th5) {
        super(str, th5);
        this.errorCode = i3;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "DataSourceException{errorCode=" + this.errorCode + "\nmessage=" + getMessage() + '}';
    }
}
