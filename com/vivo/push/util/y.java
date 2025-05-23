package com.vivo.push.util;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class y {
    public static int a(com.vivo.push.b.c cVar) {
        ad b16 = ad.b();
        int b17 = cVar.b();
        long currentTimeMillis = System.currentTimeMillis();
        int b18 = b16.b("com.vivo.push_preferences.operate." + b17 + "OPERATE_COUNT", 0);
        long b19 = currentTimeMillis - b16.b("com.vivo.push_preferences.operate." + b17 + "START_TIME", 0L);
        if (b19 <= 86400000 && b19 >= 0) {
            if (b18 >= cVar.d()) {
                return 1001;
            }
            b16.a("com.vivo.push_preferences.operate." + b17 + "OPERATE_COUNT", b18 + 1);
        } else {
            b16.a("com.vivo.push_preferences.operate." + b17 + "START_TIME", System.currentTimeMillis());
            b16.a("com.vivo.push_preferences.operate." + b17 + "OPERATE_COUNT", 1);
        }
        return 0;
    }
}
