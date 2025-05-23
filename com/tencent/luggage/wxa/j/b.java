package com.tencent.luggage.wxa.j;

import android.os.SystemClock;
import java.io.Closeable;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {
    public static long a(long j3) {
        return SystemClock.elapsedRealtime() - j3;
    }

    public static long a() {
        return SystemClock.elapsedRealtime();
    }

    public static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException | IllegalStateException unused) {
        }
    }
}
