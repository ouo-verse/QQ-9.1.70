package com.tencent.luggage.wxa.b9;

import com.eclipsesource.mmv8.ILoadLibraryDelegate;
import com.eclipsesource.mmv8.V8;
import com.tencent.luggage.wxa.b9.d;
import com.tencent.luggage.wxa.tn.w0;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f122226a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements ILoadLibraryDelegate {
        @Override // com.eclipsesource.mmv8.ILoadLibraryDelegate
        public void loadLibrary(String str) {
            try {
                w0.c();
                j.c();
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.JSRuntimeCreator", e16, "", new Object[0]);
                if (com.tencent.luggage.wxa.tn.e.f141559a || com.tencent.luggage.wxa.tn.e.f141565g) {
                    throw e16;
                }
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JSRuntimeCreator", "load so done");
        }
    }

    static {
        V8.setLoadLibraryDelegate(new a());
        f122226a = false;
    }

    public static l b(d.a aVar) {
        return l.a(aVar);
    }

    public static h0 c(d.a aVar) {
        return h0.a(aVar);
    }

    public static h0 a(d.a aVar) {
        return b.b(aVar);
    }

    public static long b() {
        c();
        return V8.getNativeTransManager();
    }

    public static void c() {
        synchronized (j.class) {
            if (f122226a) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.JSRuntimeCreator", "loadJSRuntimeSo already");
                return;
            }
            try {
                g0.a(6, e0.a(), -1, null, -1, -1, -1);
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.JSRuntimeCreator", e16, "", new Object[0]);
                if (com.tencent.luggage.wxa.tn.e.f141559a || com.tencent.luggage.wxa.tn.e.f141565g) {
                    throw e16;
                }
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JSRuntimeCreator", "loadJSRuntimeSo done");
            synchronized (j.class) {
                f122226a = true;
            }
        }
    }
}
