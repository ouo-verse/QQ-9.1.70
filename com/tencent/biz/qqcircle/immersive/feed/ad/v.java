package com.tencent.biz.qqcircle.immersive.feed.ad;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Long> f85767a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static HashMap<String, Long> f85768b = new HashMap<>();

    public static long a(String str) {
        long j3 = 0;
        if (!f85767a.containsKey(str)) {
            return 0L;
        }
        long currentTimeMillis = System.currentTimeMillis() - f85767a.get(str).longValue();
        if (f85768b.containsKey(str)) {
            j3 = f85768b.get(str).longValue();
        }
        long j16 = currentTimeMillis + j3;
        f85768b.put(str, Long.valueOf(j16));
        return j16;
    }

    public static void b(String str) {
        f85768b.put(str, 0L);
    }

    public static void c(String str) {
        f85767a.put(str, Long.valueOf(System.currentTimeMillis()));
    }
}
