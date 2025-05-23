package com.tencent.luggage.wxa.ei;

import android.util.Log;
import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.xweb.XWebSdk;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f124907a;

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f124908b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final com.tencent.luggage.wxa.zj.b f124909a = (com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class);
    }

    public static boolean a() {
        return true;
    }

    public static Boolean b() {
        if (f124907a == null) {
            f124907a = Boolean.valueOf(XWebSdk.hasXWebFeature(2009));
        }
        return Boolean.valueOf(f124907a.booleanValue());
    }

    public static synchronized boolean a(com.tencent.luggage.wxa.ic.l lVar) {
        synchronized (z.class) {
            boolean z16 = false;
            if (lVar == null) {
                a.f124909a.a(1355L, 6L);
                com.tencent.luggage.wxa.tn.w.d("Luggage.NativeTransLogic", "isServiceOpen component null");
                return false;
            }
            boolean a16 = a((com.tencent.luggage.wxa.ic.d) lVar);
            boolean a17 = a();
            if (a17 && a16) {
                a.f124909a.a(1355L, 4L);
            } else if (a17 && !a16) {
                a.f124909a.a(1355L, 5L);
            }
            com.tencent.luggage.wxa.tn.w.d("Luggage.NativeTransLogic", "isServiceOpen isExprOpen:%b isLibMatch:%b", Boolean.valueOf(a()), Boolean.valueOf(a16));
            if (a16 && a17) {
                z16 = true;
            }
            return z16;
        }
    }

    public static void b(j jVar, final int i3, final String str) {
        com.tencent.luggage.wxa.tn.w.d("Luggage.NativeTransLogic", "initNativeTransComponentId componentId: %d appId:%s , stack: %s", Integer.valueOf(i3), str, Log.getStackTraceString(new Throwable()));
        jVar.evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.id = " + i3 + "; };(function(){ return typeof ntrans })();", new ValueCallback() { // from class: l21.c
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                w.d("Luggage.NativeTransLogic", "initNativeTransComponentId componentId:%d, appId:%s, typeof ntrans:%s", Integer.valueOf(i3), str, (String) obj);
            }
        });
    }

    public static synchronized boolean a(com.tencent.luggage.wxa.kj.v vVar) {
        boolean z16;
        synchronized (z.class) {
            boolean a16 = a();
            boolean booleanValue = b().booleanValue();
            boolean a17 = a((com.tencent.luggage.wxa.ic.d) vVar);
            if (a16 && booleanValue && a17) {
                a.f124909a.a(1355L, 0L);
            } else if (a16 && !booleanValue) {
                a.f124909a.a(1355L, 1L);
            } else if (a16 && !a17) {
                a.f124909a.a(1355L, 2L);
            } else if (a16 && !a17 && !booleanValue) {
                a.f124909a.a(1355L, 3L);
            }
            z16 = false;
            com.tencent.luggage.wxa.tn.w.d("Luggage.NativeTransLogic", "isWebViewOpen exprOpen:%b webviewMatch:%b libMatch:%b", Boolean.valueOf(a16), Boolean.valueOf(booleanValue), Boolean.valueOf(a17));
            if (a16 && booleanValue && a17) {
                z16 = true;
            }
        }
        return z16;
    }

    public static boolean a(com.tencent.luggage.wxa.ic.d dVar) {
        if (f124908b == null) {
            f124908b = Boolean.valueOf(Boolean.parseBoolean(dVar.i().h("nativeTrans")));
        }
        return f124908b.booleanValue();
    }

    public static void a(j jVar, final int i3, final String str) {
        com.tencent.luggage.wxa.tn.w.d("Luggage.NativeTransLogic", "enableXwebNativeTrans componentId:%s ,appId:%s , stack:%s", Integer.valueOf(i3), str, Log.getStackTraceString(new Throwable()));
        jVar.evaluateJavascript("xweb.enableNativeTrans()", null);
        jVar.evaluateJavascript(";(function(){ return typeof ntrans })();", new ValueCallback() { // from class: l21.d
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                w.d("Luggage.NativeTransLogic", "enableXwebNativeTrans componentId:%s, appId:%s, typeof ntrans:%s", Integer.valueOf(i3), str, (String) obj);
            }
        });
    }

    public static void a(j jVar, final int i3, final int i16, final String str) {
        com.tencent.luggage.wxa.tn.w.d("Luggage.NativeTransLogic", "initNativeTransServiceId serviceId:%d, componentId:%d, appId:%s, stack:%s", Integer.valueOf(i3), Integer.valueOf(i16), str, Log.getStackTraceString(new Throwable()));
        jVar.evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.serviceId = " + i3 + "; };(function(){ return typeof ntrans})();", new ValueCallback() { // from class: l21.e
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                w.d("Luggage.NativeTransLogic", "initNativeTransServiceId, serviceId:%d, componentId:%d, appId:%s, typeof ntrans:%s", Integer.valueOf(i3), Integer.valueOf(i16), str, (String) obj);
            }
        });
    }
}
