package com.tencent.luggage.wxa.mc;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean[] f134349a = {false};

    public static boolean a() {
        boolean[] zArr = f134349a;
        if (zArr[0]) {
            return true;
        }
        try {
            com.tencent.luggage.wxa.aa.h.b("appbrandcommon", p.class.getClassLoader());
            zArr[0] = true;
            return true;
        } catch (UnsatisfiedLinkError unused) {
            return false;
        }
    }
}
