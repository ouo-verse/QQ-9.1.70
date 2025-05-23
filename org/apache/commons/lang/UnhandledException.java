package org.apache.commons.lang;

import org.apache.commons.lang.exception.NestableRuntimeException;

/* compiled from: P */
/* loaded from: classes29.dex */
public class UnhandledException extends NestableRuntimeException {
    private static final long serialVersionUID = 1832101364842773720L;

    public UnhandledException(Throwable th5) {
        super(th5);
    }

    public UnhandledException(String str, Throwable th5) {
        super(str, th5);
    }
}
