package com.qzone.album.base;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Boolean> f42056a = new HashMap<>();

    public static boolean a(String str) {
        Boolean bool = f42056a.get(str);
        if (bool == null) {
            bool = Boolean.valueOf(u4.a.z().A(str, false));
        }
        return bool.booleanValue();
    }

    public static void b(String str, boolean z16) {
        f42056a.put(str, Boolean.valueOf(z16));
        u4.a.z().f0(str, z16);
    }
}
