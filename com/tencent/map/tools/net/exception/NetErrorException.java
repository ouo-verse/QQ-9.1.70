package com.tencent.map.tools.net.exception;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes9.dex */
public class NetErrorException extends IOException {
    public int errorCode;
    public int statusCode;

    public NetErrorException() {
    }

    public NetErrorException(String str) {
        super(str);
    }

    public NetErrorException(String str, Throwable th5) {
        super(str);
        initCause(th5);
    }
}
