package com.tencent.tfd.sdk.wxa;

import java.io.Closeable;

/* compiled from: P */
/* renamed from: com.tencent.tfd.sdk.wxa.volatile, reason: invalid class name */
/* loaded from: classes26.dex */
public final class Cvolatile {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
