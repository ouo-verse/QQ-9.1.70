package com.tencent.local_edit.andserver.error;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ServerInternalException extends HttpException {
    public ServerInternalException(String str) {
        super(500, String.format("%s, %s.", "Server internal error", str));
    }

    public ServerInternalException(String str, Throwable th5) {
        super(500, String.format("%s, %s.", "Server internal error", str), th5);
    }

    public ServerInternalException(Throwable th5) {
        super(500, String.format("%s.", "Server internal error"), th5);
    }
}
