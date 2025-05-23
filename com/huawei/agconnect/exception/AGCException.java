package com.huawei.agconnect.exception;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class AGCException extends Exception {
    private int code;
    private String errMsg;

    public AGCException(String str, int i3) {
        this.code = i3;
        this.errMsg = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return " code: " + this.code + " message: " + this.errMsg;
    }
}
