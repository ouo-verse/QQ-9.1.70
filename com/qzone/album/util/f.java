package com.qzone.album.util;

import com.qzone.util.am;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static String f44366a = "f";

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Long> f44367b = new ConcurrentHashMap<>(new HashMap(8));

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a {
        public static void b(String... strArr) {
            f.d(strArr);
        }

        public static void a(String... strArr) {
            for (String str : strArr) {
                f.c(str, "qzone_photo_list");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str, String str2) {
        Long remove;
        if (am.h(str) || (remove = f44367b.remove(str)) == null) {
            return;
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() - remove.longValue());
        com.qzone.proxy.feedcomponent.util.j.a(f44366a, 2, "mtaSubKey = " + str2 + ", mtaValue = " + str + ", timeCostMs = " + currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String... strArr) {
        long currentTimeMillis = System.currentTimeMillis();
        for (String str : strArr) {
            f44367b.put(str, Long.valueOf(currentTimeMillis));
        }
    }
}
