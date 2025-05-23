package com.tencent.mobileqq.guild.util;

import android.util.LruCache;
import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes14.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private static final LruCache<String, Long> f235573a = new LruCache<>(10);

    public static boolean a(@NonNull View view) {
        if (view.getId() == -1) {
            return c(String.valueOf(view.hashCode()));
        }
        return c(String.valueOf(view.getId()));
    }

    public static boolean b(@NonNull View view, long j3) {
        if (view.getId() == -1) {
            return d(String.valueOf(view.hashCode()), j3);
        }
        return d(String.valueOf(view.getId()), j3);
    }

    public static boolean c(@NonNull String str) {
        return d(str, 500L);
    }

    public static boolean d(@NonNull String str, long j3) {
        LruCache<String, Long> lruCache = f235573a;
        Long l3 = lruCache.get(str);
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (l3 == null) {
            lruCache.put(str, valueOf);
            return false;
        }
        if (Math.abs(valueOf.longValue() - l3.longValue()) >= j3) {
            lruCache.put(str, valueOf);
            return false;
        }
        return true;
    }

    public static void e(@NonNull String str) {
        f235573a.remove(str);
    }
}
