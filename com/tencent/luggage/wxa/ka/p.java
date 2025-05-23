package com.tencent.luggage.wxa.ka;

import android.app.Application;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final d[] f131870a = {null};

    /* renamed from: b, reason: collision with root package name */
    public static final boolean[] f131871b = {false};

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.la.e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Application f131872a;

        public a(Application application) {
            this.f131872a = application;
        }

        @Override // com.tencent.luggage.wxa.la.e
        public void a(String str, Class cls) {
            h.b().a(com.tencent.luggage.wxa.ta.d.a(str, this.f131872a.getPackageName()), str, cls);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements com.tencent.luggage.wxa.la.f {
        @Override // com.tencent.luggage.wxa.la.f
        public void a(com.tencent.luggage.wxa.qa.a aVar) {
            com.tencent.luggage.wxa.qa.c.a(aVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f131873a;

        public c(String str) {
            this.f131873a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.b().g(this.f131873a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d {
        com.tencent.luggage.wxa.la.d a();

        Application b();

        com.tencent.luggage.wxa.la.c c();
    }

    public static void a(d dVar) {
        d[] dVarArr = f131870a;
        synchronized (dVarArr) {
            dVarArr[0] = dVar;
        }
    }

    public static boolean b(String str) {
        return h.b().c(str);
    }

    public static void a() {
        d dVar;
        boolean[] zArr = f131871b;
        if (zArr[0]) {
            return;
        }
        synchronized (zArr) {
            if (zArr[0]) {
                return;
            }
            d[] dVarArr = f131870a;
            synchronized (dVarArr) {
                dVar = dVarArr[0];
                if (dVar == null) {
                    throw new IllegalStateException("Please call IPCInvokerBoot.prepare(...) first.");
                }
            }
            Application b16 = dVar.b();
            com.tencent.luggage.wxa.er.a.a(b16);
            n.a(b16);
            dVar.c();
            n.a((com.tencent.luggage.wxa.la.c) null);
            a aVar = new a(b16);
            com.tencent.luggage.wxa.la.d a16 = dVar.a();
            com.tencent.luggage.wxa.er.a.a(a16);
            a16.a(aVar);
            a16.a(new b());
            a16.b(aVar);
            com.tencent.luggage.wxa.ta.c.c("IPC.IPCInvokerBoot", "setup IPCInvoker(process : %s, application : %s)", n.c(), Integer.valueOf(b16.hashCode()));
            zArr[0] = true;
        }
    }

    public static void a(String str) {
        if (b(str)) {
            return;
        }
        s.a(new c(str), "connectRemoteService");
    }
}
