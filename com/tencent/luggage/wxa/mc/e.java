package com.tencent.luggage.wxa.mc;

import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface e {

    /* renamed from: x, reason: collision with root package name */
    public static final int[] f134277x = {0, 6};

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f134278y = {1, 2, 999};

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum a {
        ;

        public static boolean b(int i3) {
            return com.tencent.luggage.wxa.u9.a.a(e.f134277x, i3);
        }

        public static a valueOf(String str) {
            com.tencent.luggage.wxa.k0.d.a(Enum.valueOf(a.class, str));
            return null;
        }

        public static boolean a(int i3) {
            return com.tencent.luggage.wxa.u9.a.a(e.f134278y, i3);
        }

        public static boolean a(String str, String str2) {
            return StringUtils.equals(str, "WeApp_Admin") || StringUtils.equals(str, "WeApp_Admin@app") || StringUtils.equals(str2, "wx1a919f7634c69370");
        }
    }
}
