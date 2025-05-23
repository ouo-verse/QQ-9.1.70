package com.tencent.mobileqq.utils;

import android.os.SystemClock;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ei {

    /* renamed from: a, reason: collision with root package name */
    public static ConcurrentHashMap<String, Long> f307721a = new ConcurrentHashMap<>(new HashMap(8));

    /* renamed from: b, reason: collision with root package name */
    public static long f307722b = 0;

    public static long b(String str, String str2) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (str != null) {
            Long remove = f307721a.remove(str);
            if (remove != null) {
                long longValue = uptimeMillis - remove.longValue();
                f307722b = longValue;
                return longValue;
            }
            return -1L;
        }
        if (str2 != null) {
            f307722b = 0L;
            f307721a.put(str2, Long.valueOf(uptimeMillis));
            return -1L;
        }
        return -1L;
    }

    public static void a(String str, String str2) {
    }
}
