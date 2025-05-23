package com.tencent.luggage.wxa.o4;

import com.tencent.luggage.wxa.ei.j;
import com.tencent.luggage.wxa.ei.n;
import com.tencent.luggage.wxa.ei.q;
import com.tencent.luggage.wxa.ei.v;
import com.tencent.luggage.wxa.eo.g;
import com.tencent.luggage.wxa.tk.k;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.tcp.libmmtcp.TcpNative;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public TcpNative f136164a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f136165b = true;

    /* renamed from: c, reason: collision with root package name */
    public final d f136166c = new d(new c());

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements TcpNative.NativeCallBackInterface {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f136167a;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.o4.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6534a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f136169a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f136170b;

            public RunnableC6534a(String str, long j3) {
                this.f136169a = str;
                this.f136170b = j3;
            }

            @Override // java.lang.Runnable
            public void run() {
                w.a("Luggage.TcpNativeInstallHelper", "mmtcp jsThreadHandler run onCallBack apiName:%s,engineId:%d", this.f136169a, Long.valueOf(this.f136170b));
                e.this.f136164a.update(this.f136170b);
            }
        }

        public a(WeakReference weakReference) {
            this.f136167a = weakReference;
        }

        @Override // com.tencent.mm.tcp.libmmtcp.TcpNative.NativeCallBackInterface
        public void onCallBack(long j3, String str) {
            ((q) this.f136167a.get()).a(new RunnableC6534a(str, j3));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f136172a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TcpNative.NativeCallBackInterface f136173b;

        public b(j jVar, TcpNative.NativeCallBackInterface nativeCallBackInterface) {
            this.f136172a = jVar;
            this.f136173b = nativeCallBackInterface;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d("Luggage.TcpNativeInstallHelper", "createTcpBinding InitCallBack ");
            if (e.this.f136164a != null) {
                w.d("Luggage.TcpNativeInstallHelper", "createTcpBinding tcpNative != null");
                return;
            }
            v vVar = (v) this.f136172a.a(v.class);
            if (vVar == null) {
                w.b("Luggage.TcpNativeInstallHelper", "createTcpBinding v8Addon is null");
                return;
            }
            if (e.this.f136165b) {
                e.this.f136164a = new TcpNative(vVar.f(), vVar.B(), vVar.j());
            } else {
                e.this.f136164a = new TcpNative(vVar.f(), vVar.B(), 0L);
            }
            w.d("Luggage.TcpNativeInstallHelper", "createTcpBinding InitCallBack ret:%d", Integer.valueOf(e.this.f136164a.setCallBack(this.f136173b)));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (e.this) {
                if (e.this.f136164a != null) {
                    w.d("Luggage.TcpNativeInstallHelper", "DestroyTask destoryTcp");
                    e.this.f136164a.destoryTcp();
                    e.this.f136164a = null;
                } else {
                    w.d("Luggage.TcpNativeInstallHelper", "DestroyTask tcpNative is null");
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
        w.d("Luggage.TcpNativeInstallHelper", "createTcpBinding");
        if (jVar == null) {
            w.b("Luggage.TcpNativeInstallHelper", "createTcpBinding jsruntime is null");
            return;
        }
        com.tencent.luggage.wxa.jo.a.a();
        q qVar = (q) jVar.a(q.class);
        if (qVar == null) {
            w.b("Luggage.TcpNativeInstallHelper", "createTcpBinding jsThreadHandler is null");
        } else {
            com.tencent.luggage.wxa.k0.d.a(g.a(com.tencent.luggage.wxa.o4.d.class));
            qVar.d(new b(jVar, new a(new WeakReference(qVar))));
        }
    }

    public void a(j jVar) {
        w.d("Luggage.TcpNativeInstallHelper", "destroyTcpBinding");
        if (jVar == null) {
            w.b("Luggage.TcpNativeInstallHelper", "destroyTcpBinding jsruntime is null");
        } else {
            ((n) jVar.a(n.class)).b(this.f136166c);
        }
    }
}
