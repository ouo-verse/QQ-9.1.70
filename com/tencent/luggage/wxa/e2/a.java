package com.tencent.luggage.wxa.e2;

import android.app.Activity;
import android.content.Context;
import android.view.WindowInsets;
import com.tencent.luggage.wxa.lo.k;
import com.tencent.luggage.wxa.r4.d;
import com.tencent.luggage.wxa.tk.g;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.e2.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6146a {

        /* renamed from: a, reason: collision with root package name */
        public volatile boolean f124470a = false;
    }

    public static void a(C6146a c6146a, Runnable runnable) {
        boolean z16;
        if (runnable == null) {
            return;
        }
        if (c6146a != null) {
            if (c6146a.f124470a) {
                return;
            }
            synchronized (a.class) {
                z16 = !c6146a.f124470a ? c6146a.f124470a = true : false;
            }
            if (z16) {
                runnable.run();
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public static int a(d dVar) {
        Activity L;
        WindowInsets a16;
        int stableInsetTop;
        if (dVar.getRuntime() != null && dVar.h(com.tencent.luggage.wxa.w1.a.class) != null) {
            if (((com.tencent.luggage.wxa.w1.b) dVar.h(com.tencent.luggage.wxa.w1.b.class)) != null) {
                if ((dVar.D() instanceof WindowAndroidActivityImpl) && (L = dVar.L()) != null && (a16 = k.a(L)) != null && (stableInsetTop = a16.getStableInsetTop()) > 0) {
                    return g.a((Context) L, stableInsetTop);
                }
            } else {
                w.a("MicroMsg.WAGameCommonUtil", new com.tencent.luggage.wxa.w1.d(), "hy: not game service", new Object[0]);
            }
        }
        return 0;
    }
}
