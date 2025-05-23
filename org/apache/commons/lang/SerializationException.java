package org.apache.commons.lang;

import org.apache.commons.lang.exception.NestableRuntimeException;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SerializationException extends NestableRuntimeException {
    private static final long serialVersionUID = 4029025366392702726L;

    public SerializationException() {
    }

    public SerializationException(String str) {
        super(str);
    }

    public SerializationException(Throwable th5) {
        super(th5);
    }

    public SerializationException(String str, Throwable th5) {
        super(str, th5);
    }
}
