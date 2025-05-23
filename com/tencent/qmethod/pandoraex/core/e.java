package com.tencent.qmethod.pandoraex.core;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, Long> f344036a = new ConcurrentHashMap();

    public static void a() {
        f344036a.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean b(String str, String str2, long j3, String str3) {
        Long l3 = f344036a.get(com.tencent.qmethod.pandoraex.api.b.c(str, str2, str3));
        if (l3 == null) {
            return true;
        }
        if (j3 != 0 && Math.abs(System.currentTimeMillis() - l3.longValue()) > Math.abs(j3)) {
            return true;
        }
        return false;
    }

    public static boolean c(String str, long j3) {
        long j16;
        if (j3 == 0) {
            return false;
        }
        Context b16 = com.tencent.qmethod.pandoraex.api.q.b();
        String str2 = str + "_last_cache_time";
        if (!com.tencent.qmethod.pandoraex.api.r.c(b16, str2).booleanValue()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            j16 = Long.parseLong(com.tencent.qmethod.pandoraex.api.r.j(b16, str2).trim());
        } catch (Exception e16) {
            o.d("CacheTimeUtils", "isStorageCacheExceed err: ", e16);
            j16 = currentTimeMillis;
        }
        long abs = Math.abs(currentTimeMillis - j16);
        if (abs < j3) {
            return false;
        }
        o.a("CacheTimeUtils", "StorageCache is exceed: currTime is " + currentTimeMillis + " lastTime is " + j16 + " absInterval is " + abs + " cacheTime is " + j3);
        return true;
    }

    public static void d(String str, long j3) {
        if (c(str, j3)) {
            com.tencent.qmethod.pandoraex.api.r.p(com.tencent.qmethod.pandoraex.api.q.b(), str + "_last_cache_time", String.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void e(String str, String str2, String str3) {
        f344036a.put(com.tencent.qmethod.pandoraex.api.b.c(str, str2, str3), Long.valueOf(System.currentTimeMillis()));
    }
}
