package com.tencent.map.tools.net.exception;

/* compiled from: P */
/* loaded from: classes9.dex */
public class NetUnavailableException extends NetErrorException {
    private static final long serialVersionUID = 2783283891376573878L;

    public NetUnavailableException() {
    }

    public NetUnavailableException(String str) {
        super(str);
    }

    public NetUnavailableException(String str, Throwable th5) {
        super(str);
        initCause(th5);
    }
}
