package com.tencent.timi.game.utils;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Long> f380309a = new HashMap<>();

    public static synchronized boolean a() {
        boolean c16;
        synchronized (o.class) {
            c16 = c("default");
        }
        return c16;
    }

    public static synchronized boolean b(int i3) {
        boolean d16;
        synchronized (o.class) {
            d16 = d("default", i3);
        }
        return d16;
    }

    public static synchronized boolean c(String str) {
        boolean d16;
        synchronized (o.class) {
            d16 = d(str, 500);
        }
        return d16;
    }

    public static synchronized boolean d(String str, int i3) {
        long j3;
        boolean z16;
        synchronized (o.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (f380309a.containsKey(str)) {
                j3 = f380309a.get(str).longValue();
            } else {
                j3 = 0;
            }
            long j16 = currentTimeMillis - j3;
            if (j16 >= 0 && j16 <= i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            f380309a.put(str, Long.valueOf(currentTimeMillis));
        }
        return z16;
    }

    public static boolean e(String str, long j3) {
        long j16;
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis();
        if (f380309a.containsKey(str)) {
            j16 = f380309a.get(str).longValue();
        } else {
            j16 = 0;
        }
        long j17 = currentTimeMillis - j16;
        if (j17 >= 0 && j17 <= j3) {
            z16 = true;
        } else {
            z16 = false;
        }
        f380309a.put(str, Long.valueOf(currentTimeMillis));
        return z16;
    }

    public static boolean f(String str, long j3) {
        long j16;
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis();
        if (f380309a.containsKey(str)) {
            j16 = f380309a.get(str).longValue();
        } else {
            j16 = 0;
        }
        long j17 = currentTimeMillis - j16;
        if (j17 >= 0 && j17 <= j3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            f380309a.put(str, Long.valueOf(currentTimeMillis));
        }
        return z16;
    }
}
