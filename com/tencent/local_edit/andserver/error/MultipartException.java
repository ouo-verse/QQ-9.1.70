package com.tencent.local_edit.andserver.error;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MultipartException extends HttpException {
    public MultipartException(String str) {
        super(400, str);
    }

    public MultipartException(String str, Throwable th5) {
        super(400, str, th5);
    }
}
