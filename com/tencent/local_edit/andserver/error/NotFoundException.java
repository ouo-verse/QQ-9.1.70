package com.tencent.local_edit.andserver.error;

/* compiled from: P */
/* loaded from: classes7.dex */
public class NotFoundException extends HttpException {
    public NotFoundException() {
        super(404, String.format("The resource [%s] is not found.", ""));
    }

    public NotFoundException(String str) {
        super(404, String.format("The resource [%s] is not found.", str));
    }

    public NotFoundException(String str, Throwable th5) {
        super(404, String.format("The resource [%s] is not found.", str), th5);
    }

    public NotFoundException(Throwable th5) {
        super(404, String.format("The resource [%s] is not found.", ""), th5);
    }
}
