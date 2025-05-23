package org.junit.internal;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Classes {
    public static Class<?> getClass(String str) throws ClassNotFoundException {
        return Class.forName(str, true, Thread.currentThread().getContextClassLoader());
    }
}
