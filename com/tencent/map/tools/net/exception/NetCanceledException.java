package com.tencent.map.tools.net.exception;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes9.dex */
public class NetCanceledException extends IOException {
    private static final long serialVersionUID = -7835439581999472741L;

    public NetCanceledException() {
    }

    public NetCanceledException(String str) {
        super(str);
    }

    public NetCanceledException(String str, Throwable th5) {
        super(str);
        initCause(th5);
    }
}
