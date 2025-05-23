package com.tencent.liteav.base;

import android.os.StrictMode;
import java.io.Closeable;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class b implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private final StrictMode.ThreadPolicy f118884a;

    /* renamed from: b, reason: collision with root package name */
    private final StrictMode.VmPolicy f118885b;

    b(StrictMode.ThreadPolicy threadPolicy) {
        this.f118884a = threadPolicy;
        this.f118885b = null;
    }

    public static b a() {
        return new b(StrictMode.allowThreadDiskWrites(), (byte) 0);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        StrictMode.ThreadPolicy threadPolicy = this.f118884a;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        StrictMode.VmPolicy vmPolicy = this.f118885b;
        if (vmPolicy != null) {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }

    b(StrictMode.ThreadPolicy threadPolicy, byte b16) {
        this(threadPolicy);
    }
}
