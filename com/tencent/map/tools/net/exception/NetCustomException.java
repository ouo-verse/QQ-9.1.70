package com.tencent.map.tools.net.exception;

/* compiled from: P */
/* loaded from: classes9.dex */
public class NetCustomException extends Exception {
    private static final long serialVersionUID = -5614711401833110994L;
    private Exception exception;
    private int netCode;

    public NetCustomException() {
    }

    public Exception getException() {
        return this.exception;
    }

    public int getNetCode() {
        return this.netCode;
    }

    public NetCustomException(String str, Exception exc, int i3) {
        super(str);
        this.exception = exc;
        this.netCode = i3;
    }
}
