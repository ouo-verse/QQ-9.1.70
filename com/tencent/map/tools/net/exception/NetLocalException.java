package com.tencent.map.tools.net.exception;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes9.dex */
public class NetLocalException extends IOException {
    private static final long serialVersionUID = -7835439581999472641L;

    public NetLocalException() {
    }

    public NetLocalException(String str) {
        super(str);
    }

    public NetLocalException(String str, Throwable th5) {
        super(str);
        initCause(th5);
    }
}
