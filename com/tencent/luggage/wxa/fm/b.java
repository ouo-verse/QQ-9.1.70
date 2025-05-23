package com.tencent.luggage.wxa.fm;

import com.tencent.luggage.wxa.b9.j;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.xweb.XWebSdk;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f126256a;

    public static void a() {
        if (f126256a) {
            w.d("MicroMsg.XWebNativeTransInitLogic", "bind already");
            return;
        }
        w.d("MicroMsg.XWebNativeTransInitLogic", "bind");
        XWebSdk.bindNativeTrans(j.b());
        f126256a = true;
    }
}
