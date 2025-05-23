package com.qq.e.comm.util;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AdError {
    private int errorCode;
    private String errorMsg;
    private int subErrorCode;

    public AdError() {
    }

    public AdError(int i3, String str) {
        this.errorCode = i3;
        this.errorMsg = str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public int getSubErrorCode() {
        return this.subErrorCode;
    }

    public void setSubErrorCode(int i3) {
        this.subErrorCode = i3;
    }
}
