package com.tencent.qmethod.pandoraex.core;

import android.content.Context;
import android.os.SystemClock;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile long f344023a;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f344024b = new Object();

    public static void a() {
        synchronized (f344024b) {
            f344023a = 0L;
            Context b16 = com.tencent.qmethod.pandoraex.api.q.b();
            if (b16 != null) {
                com.tencent.qmethod.pandoraex.api.r.k(b16, "key_background_time");
            }
        }
    }

    public static long b() {
        long c16 = c();
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis > c16) {
            return uptimeMillis - c16;
        }
        return 0L;
    }

    public static long c() {
        long j3;
        synchronized (f344024b) {
            Context b16 = com.tencent.qmethod.pandoraex.api.q.b();
            if (b16 != null && com.tencent.qmethod.pandoraex.api.r.c(b16, "key_background_time").booleanValue()) {
                long longValue = com.tencent.qmethod.pandoraex.api.r.g(b16, "key_background_time").longValue();
                if (longValue > f344023a) {
                    f344023a = longValue;
                }
            }
            j3 = f344023a;
        }
        return j3;
    }

    public static void d() {
        synchronized (f344024b) {
            f344023a = SystemClock.uptimeMillis();
            if (com.tencent.qmethod.pandoraex.api.q.b() != null) {
                com.tencent.qmethod.pandoraex.api.r.o(com.tencent.qmethod.pandoraex.api.q.b(), "key_background_time", Long.valueOf(f344023a));
            }
        }
    }
}
