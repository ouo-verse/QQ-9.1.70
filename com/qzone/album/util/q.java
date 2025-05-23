package com.qzone.album.util;

/* compiled from: P */
/* loaded from: classes39.dex */
public class q {
    public static boolean a(String str) {
        if (com.qzone.album.env.common.a.m().F(str)) {
            boolean p16 = com.qzone.album.env.common.a.m().p(str, false);
            if (p16) {
                com.qzone.album.env.common.a.m().M(str, false);
            }
            return p16;
        }
        com.qzone.album.env.common.a.m().M(str, false);
        return true;
    }

    public static boolean b(String str) {
        if (com.qzone.album.env.common.a.m().F(str)) {
            return false;
        }
        com.qzone.album.env.common.a.m().M(str, true);
        return true;
    }

    public static boolean c(String str) {
        return !com.qzone.album.env.common.a.m().F(str);
    }

    public static void d(String str) {
        com.qzone.album.env.common.a.m().M(str, true);
    }

    public static void e(String str) {
        com.qzone.album.env.common.a.m().M(str, true);
    }
}
