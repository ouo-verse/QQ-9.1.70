package org.apache.commons.lang.exception;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CloneFailedException extends NestableRuntimeException {
    private static final long serialVersionUID = 20091223;

    public CloneFailedException(String str) {
        super(str);
    }

    public CloneFailedException(Throwable th5) {
        super(th5);
    }

    public CloneFailedException(String str, Throwable th5) {
        super(str, th5);
    }
}
