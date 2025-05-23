package com.tencent.rfix.loader.so;

import java.io.Closeable;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class IOHelper {
    public static void closeQuietly(Object obj) {
        if (obj == null) {
            return;
        }
        try {
            if (obj instanceof Closeable) {
                ((Closeable) obj).close();
            } else if (obj instanceof AutoCloseable) {
                ((AutoCloseable) obj).close();
            }
        } catch (Throwable unused) {
        }
    }
}
