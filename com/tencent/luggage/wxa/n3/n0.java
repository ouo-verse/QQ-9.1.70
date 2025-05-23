package com.tencent.luggage.wxa.n3;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum n0 {
    ;


    /* renamed from: a, reason: collision with root package name */
    public static final String[] f135225a = {"/cgi-bin/micromsg-bin/rcptinfoquery", "/cgi-bin/mmoc-bin/hardware/getwerunuserstate"};

    public static n0 valueOf(String str) {
        com.tencent.luggage.wxa.k0.d.a(Enum.valueOf(n0.class, str));
        return null;
    }

    public static boolean a(String str) {
        for (String str2 : f135225a) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
