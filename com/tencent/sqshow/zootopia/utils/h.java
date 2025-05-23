package com.tencent.sqshow.zootopia.utils;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes34.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Long> f373279a = new HashMap<>();

    public static synchronized boolean a() {
        boolean c16;
        synchronized (h.class) {
            c16 = c("default", 500L);
        }
        return c16;
    }

    public static synchronized boolean b(String str) {
        boolean c16;
        synchronized (h.class) {
            c16 = c(str, 500L);
        }
        return c16;
    }

    public static boolean c(String str, long j3) {
        long currentTimeMillis = System.currentTimeMillis();
        long longValue = currentTimeMillis - (f373279a.containsKey(str) ? f373279a.get(str).longValue() : 0L);
        boolean z16 = longValue >= 0 && longValue <= j3;
        f373279a.put(str, Long.valueOf(currentTimeMillis));
        return z16;
    }
}
