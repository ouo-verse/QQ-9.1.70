package com.tencent.mobileqq.vasgift.utils;

import android.util.LruCache;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final LruCache<String, Long> f312014a = new LruCache<>(10);

    public static boolean a(@NonNull String str) {
        LruCache<String, Long> lruCache = f312014a;
        Long l3 = lruCache.get(str);
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (l3 == null) {
            lruCache.put(str, valueOf);
            return false;
        }
        if (Math.abs(valueOf.longValue() - l3.longValue()) >= 500) {
            lruCache.put(str, valueOf);
            return false;
        }
        return true;
    }
}
