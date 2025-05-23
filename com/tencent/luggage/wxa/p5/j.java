package com.tencent.luggage.wxa.p5;

import com.tencent.xweb.XWebSdk;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f137350a = new j();

    public final void a(f rt5) {
        Intrinsics.checkNotNullParameter(rt5, "rt");
        com.tencent.luggage.wxa.zj.f fVar = com.tencent.luggage.wxa.zj.f.f146728a;
        int i3 = 2;
        Object[] objArr = new Object[2];
        objArr[0] = rt5.S().k();
        if (!XWebSdk.isSysWebView()) {
            if (XWebSdk.isXWebView()) {
                i3 = 1;
            } else {
                i3 = 0;
            }
        }
        objArr[1] = Integer.valueOf(i3);
        fVar.a(10083, objArr);
    }
}
