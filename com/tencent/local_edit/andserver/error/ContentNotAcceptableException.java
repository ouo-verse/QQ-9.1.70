package com.tencent.local_edit.andserver.error;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ContentNotAcceptableException extends HttpException {
    public ContentNotAcceptableException() {
        super(406, "Could not find acceptable representation.");
    }

    public ContentNotAcceptableException(String str, Throwable th5) {
        super(406, str, th5);
    }
}
