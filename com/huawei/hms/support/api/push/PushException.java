package com.huawei.hms.support.api.push;

/* loaded from: classes2.dex */
public class PushException extends RuntimeException {
    public static final String EXCEPTION_SEND_FAILED = "send message failed";

    public PushException() {
    }

    public PushException(String str, Throwable th5) {
        super(str, th5);
    }

    public PushException(String str) {
        super(str);
    }

    public PushException(Throwable th5) {
        super(th5);
    }
}
