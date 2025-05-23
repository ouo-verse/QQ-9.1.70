package com.tencent.mm.plugin.sight.base;

import com.tencent.luggage.wxa.aa.h;
import com.tencent.luggage.wxa.i6.a;
import com.tencent.luggage.wxa.y8.i;
import com.tencent.luggage.wxa.ym.b;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class SightVideoJNI {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f152517a = new Object();

    static {
        h.b("wechatsight_v7a", SightVideoJNI.class.getClassLoader());
        if ((a.a() >> 12) >= 4) {
            b.f146038a = 3;
            b.f146039b = 3;
            b.f146040c = 544000;
        } else {
            b.f146038a = 1;
            b.f146039b = 1;
            b.f146040c = 640000;
        }
    }

    public static int a(String str, int i3, int i16, int i17, double d16, int i18) {
        return shouldRemuxing(i.a(str, false), i3, i16, i17, d16, i18);
    }

    private static native int remuxing(String str, String str2, int i3, int i16, int i17, int i18, int i19, int i26, float f16, float f17, byte[] bArr, int i27, boolean z16, int i28, int i29, String str3, boolean z17);

    private static native int shouldRemuxing(String str, int i3, int i16, int i17, double d16, int i18);

    public static int a(String str, String str2, int i3, int i16, int i17, int i18, int i19, int i26, float f16, float f17, byte[] bArr, int i27, boolean z16, int i28, int i29) {
        return remuxing(i.a(str, false), i.a(str2, true), i3, i16, i17, i18, i19, i26, f16, f17, bArr, i27, z16, i28, i29, com.tencent.luggage.wxa.zm.a.b(), true);
    }
}
