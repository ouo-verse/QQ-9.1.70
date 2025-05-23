package org.junit.internal;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Throwables {
    Throwables() {
    }

    public static Exception rethrowAsException(Throwable th5) throws Exception {
        rethrow(th5);
        return null;
    }

    private static <T extends Throwable> void rethrow(Throwable th5) throws Throwable {
        throw th5;
    }
}
