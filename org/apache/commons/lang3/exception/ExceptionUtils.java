package org.apache.commons.lang3.exception;

import java.lang.reflect.UndeclaredThrowableException;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ExceptionUtils {
    public static boolean hasCause(Throwable th5, Class<? extends Throwable> cls) {
        if (th5 instanceof UndeclaredThrowableException) {
            th5 = th5.getCause();
        }
        return cls.isInstance(th5);
    }

    public static <R> R rethrow(Throwable th5) {
        return (R) typeErasure(th5);
    }

    public static <R> R wrapAndThrow(Throwable th5) {
        if (!(th5 instanceof RuntimeException)) {
            if (th5 instanceof Error) {
                throw ((Error) th5);
            }
            throw new UndeclaredThrowableException(th5);
        }
        throw ((RuntimeException) th5);
    }

    private static <R, T extends Throwable> R typeErasure(Throwable th5) throws Throwable {
        throw th5;
    }
}
