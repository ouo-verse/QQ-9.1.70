package com.tencent.luggage.wxa.ii;

import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public static final y f130598a = new y();

    public final boolean a() {
        boolean z16;
        String a16 = com.tencent.luggage.wxa.gd.a.a(com.tencent.luggage.wxa.tn.z.c());
        if (a16 != null && a16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        if (com.tencent.luggage.wxa.cp.x.d(a16) && Intrinsics.areEqual("43bff1e72298b0ea0b73e2960d3c97b8", com.tencent.mm.plugin.appbrand.appcache.a.b(a16))) {
            return true;
        }
        try {
            InputStream open = com.tencent.luggage.wxa.tn.z.b().open("wasae.dat");
            Intrinsics.checkNotNullExpressionValue(open, "getAssets().open(WxapkgEncryptConstants.FILENAME)");
            return com.tencent.luggage.wxa.tn.o.a(open, a16, false);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.h("WxaEncryptPkgKeyInstaller", "ensureKeyInstalled", e16);
            return false;
        }
    }
}
