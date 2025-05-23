package com.tencent.luggage.wxa.bk;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class q {

    /* renamed from: a */
    public static final q f123029a = new q();

    public final void a(com.tencent.luggage.wxa.p5.e pageView, int i3, String str, long j3, int i16, int i17) {
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        String appId = pageView.getAppId();
        int C1 = pageView.getRuntime().C1();
        int l06 = pageView.getRuntime().l0() + 1;
        String A0 = pageView.A0();
        if (A0 == null) {
            A0 = "";
        }
        String a16 = com.tencent.luggage.wxa.aa.m.a(A0);
        e L1 = pageView.getRuntime().L1();
        int i18 = L1.f122984c;
        String str2 = L1.f122985d;
        String str3 = str2 != null ? str2 : "";
        int i19 = L1.f122982a;
        String str4 = L1.f122983b;
        int i26 = L1.f122986e;
        int i27 = pageView.getRuntime().S().I + 1000;
        String j16 = pageView.getRuntime().S().j();
        com.tencent.luggage.wxa.zj.d dVar = (com.tencent.luggage.wxa.zj.d) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.d.class);
        if (dVar != null) {
            dVar.a(13539, Integer.valueOf(i18), str3, j16, appId, Integer.valueOf(C1), Integer.valueOf(l06), Integer.valueOf(i26), a16, Integer.valueOf(i3), str, Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i19), str4, Integer.valueOf(i27));
        }
    }
}
