package com.tencent.luggage.wxa.o4;

import com.tencent.luggage.wxa.ei.j;
import com.tencent.luggage.wxa.ei.n;
import com.tencent.luggage.wxa.ei.q;
import com.tencent.luggage.wxa.ei.v;
import com.tencent.luggage.wxa.eo.g;
import com.tencent.luggage.wxa.tk.k;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.udp.libmmudp.UdpNative;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public UdpNative f136177a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f136178b = true;

    /* renamed from: c, reason: collision with root package name */
    public final d f136179c = new d(new c());

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements UdpNative.NativeCallBackInterface {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f136180a;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.o4.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6535a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f136182a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f136183b;

            public RunnableC6535a(String str, long j3) {
                this.f136182a = str;
                this.f136183b = j3;
            }

            @Override // java.lang.Runnable
            public void run() {
                w.a("Luggage.UdpNativeInstallHelper", "mmudp jsThreadHandler run onCallBack apiName:%s,engineId:%d", this.f136182a, Long.valueOf(this.f136183b));
                f.this.f136177a.update(this.f136183b);
            }
        }

        public a(WeakReference weakReference) {
            this.f136180a = weakReference;
        }

        @Override // com.tencent.mm.udp.libmmudp.UdpNative.NativeCallBackInterface
        public void onCallBack(long j3, String str) {
            ((q) this.f136180a.get()).a(new RunnableC6535a(str, j3));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f136185a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UdpNative.NativeCallBackInterface f136186b;

        public b(j jVar, UdpNative.NativeCallBackInterface nativeCallBackInterface) {
            this.f136185a = jVar;
            this.f136186b = nativeCallBackInterface;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d("Luggage.UdpNativeInstallHelper", "createUdpBinding InitCallBack ");
            if (f.this.f136177a != null) {
                w.d("Luggage.UdpNativeInstallHelper", "createUdpBinding udpNative != null");
                return;
            }
            v vVar = (v) this.f136185a.a(v.class);
            if (vVar == null) {
                w.b("Luggage.UdpNativeInstallHelper", "createUdpBinding v8Addon is null");
                return;
            }
            if (f.this.f136178b) {
                f.this.f136177a = new UdpNative(vVar.f(), vVar.B(), vVar.j());
            } else {
                f.this.f136177a = new UdpNative(vVar.f(), vVar.B(), 0L);
            }
            w.d("Luggage.UdpNativeInstallHelper", "createUdpBinding InitCallBack ret:%d", Integer.valueOf(f.this.f136177a.setCallBack(this.f136186b)));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (f.this) {
                if (f.this.f136177a != null) {
                    w.d("Luggage.UdpNativeInstallHelper", "DestroyTask destoryUdp");
                    f.this.f136177a.destoryUdp();
                    f.this.f136177a = null;
                } else {
                    w.d("Luggage.UdpNativeInstallHelper", "DestroyTask udpNative is null");
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d extends k implements n.a {
        public d(Runnable runnable) {
            super(runnable);
        }

        @Override // com.tencent.luggage.wxa.ei.n.a
        public void onDestroy() {
            run();
        }
    }

    public void a(j jVar, com.tencent.luggage.wxa.xd.d dVar) {
        w.d("Luggage.UdpNativeInstallHelper", "createUdpBinding");
        if (jVar == null) {
            w.b("Luggage.UdpNativeInstallHelper", "createUdpBinding jsruntime is null");
            return;
        }
        com.tencent.luggage.wxa.ko.a.a();
        q qVar = (q) jVar.a(q.class);
        if (qVar == null) {
            w.b("Luggage.UdpNativeInstallHelper", "createUdpBinding jsThreadHandler is null");
        } else {
            com.tencent.luggage.wxa.k0.d.a(g.a(com.tencent.luggage.wxa.o4.d.class));
            qVar.d(new b(jVar, new a(new WeakReference(qVar))));
        }
    }

    public void a(j jVar) {
        w.d("Luggage.UdpNativeInstallHelper", "destroyUdpBinding");
        if (jVar == null) {
            w.b("Luggage.UdpNativeInstallHelper", "destroyUdpBinding jsruntime is null");
        } else {
            ((n) jVar.a(n.class)).b(this.f136179c);
        }
    }
}
