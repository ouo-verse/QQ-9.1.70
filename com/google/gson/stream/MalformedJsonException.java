package com.google.gson.stream;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class MalformedJsonException extends IOException {
    private static final long serialVersionUID = 1;

    public MalformedJsonException(String str) {
        super(str);
    }

    public MalformedJsonException(String str, Throwable th5) {
        super(str);
        initCause(th5);
    }

    public MalformedJsonException(Throwable th5) {
        initCause(th5);
    }
}
