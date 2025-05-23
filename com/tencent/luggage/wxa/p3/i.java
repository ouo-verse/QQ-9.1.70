package com.tencent.luggage.wxa.p3;

import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.luggage.wxa.bj.a;
import com.tencent.luggage.wxa.hn.e9;
import com.tencent.luggage.wxa.hn.s8;
import com.tencent.luggage.wxa.hn.t8;
import com.tencent.luggage.wxa.hn.xa;
import com.tencent.luggage.wxa.n3.b0;
import com.tencent.luggage.wxa.n3.q0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class i implements com.tencent.luggage.wxa.bj.c, com.tencent.luggage.wxa.p3.d {

    /* renamed from: f, reason: collision with root package name */
    public static final a f137164f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Lazy f137165a;

    /* renamed from: b, reason: collision with root package name */
    public final ReentrantLock f137166b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.p3.b f137167c;

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.p3.c f137168d;

    /* renamed from: e, reason: collision with root package name */
    public final SparseArray f137169e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function0 {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "TdiCgiServiceBase|" + i.this.i();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements com.tencent.luggage.wxa.p3.c {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.p3.c
        public void a(int i3, int i16, byte[] resp) {
            Object obj;
            Intrinsics.checkNotNullParameter(resp, "resp");
            w.d(i.this.f(), "onReceiveAppResponse taskid:" + i3 + " error:" + i16);
            if (i16 != 0) {
                w.b(i.this.f(), "onReceiveAppResponse taskid:" + i3 + " error:" + i16 + " fail");
            }
            SparseArray sparseArray = i.this.f137169e;
            i iVar = i.this;
            synchronized (sparseArray) {
                obj = iVar.f137169e.get(i3);
                iVar.f137169e.remove(i3);
                Unit unit = Unit.INSTANCE;
            }
            com.tencent.luggage.wxa.p3.c cVar = (com.tencent.luggage.wxa.p3.c) obj;
            if (cVar != null) {
                cVar.a(i3, i16, resp);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements com.tencent.luggage.wxa.p3.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f137172a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f137173b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Class f137174c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f137175d;

        public d(AtomicReference atomicReference, i iVar, Class cls, CountDownLatch countDownLatch) {
            this.f137172a = atomicReference;
            this.f137173b = iVar;
            this.f137174c = cls;
            this.f137175d = countDownLatch;
        }

        @Override // com.tencent.luggage.wxa.p3.c
        public void a(int i3, int i16, byte[] resp) {
            Intrinsics.checkNotNullParameter(resp, "resp");
            if (i16 == 0) {
                AtomicReference atomicReference = this.f137172a;
                t8 a16 = this.f137173b.a(resp, this.f137174c);
                Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type RESP of com.tencent.luggage.login.account.tdi.TdiCgiServiceBase.sync");
                atomicReference.set(a16);
            }
            this.f137175d.countDown();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements com.tencent.luggage.wxa.uo.b {
        public e() {
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean call(Void r46) {
            com.tencent.luggage.wxa.xo.b b16 = com.tencent.luggage.wxa.xo.h.b();
            if (i.this.b()) {
                b16.a(Boolean.TRUE);
            } else {
                b16.a("boot failed");
            }
            return Boolean.TRUE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.fn.b f137178c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f137179d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f137180e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.n3.w f137181f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Class f137182g;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements com.tencent.luggage.wxa.p3.c {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f137183a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ i f137184b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Class f137185c;

            public a(com.tencent.luggage.wxa.xo.b bVar, i iVar, Class cls) {
                this.f137183a = bVar;
                this.f137184b = iVar;
                this.f137185c = cls;
            }

            @Override // com.tencent.luggage.wxa.p3.c
            public void a(int i3, int i16, byte[] resp) {
                Intrinsics.checkNotNullParameter(resp, "resp");
                if (i16 == 0) {
                    this.f137183a.a(this.f137184b.a(resp, this.f137185c));
                    return;
                }
                this.f137183a.a(new com.tencent.luggage.wxa.bj.a(a.EnumC6074a.TRANSFER, i16, "sendTdiRequest(" + i3 + ")(" + resp + ") fail"));
            }
        }

        public f(com.tencent.luggage.wxa.fn.b bVar, int i3, String str, com.tencent.luggage.wxa.n3.w wVar, Class cls) {
            this.f137178c = bVar;
            this.f137179d = i3;
            this.f137180e = str;
            this.f137181f = wVar;
            this.f137182g = cls;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final t8 call(Boolean bool) {
            com.tencent.luggage.wxa.xo.b b16 = com.tencent.luggage.wxa.xo.h.b();
            i.this.a(this.f137178c);
            i.this.b(this.f137178c);
            com.tencent.luggage.wxa.n3.b a16 = i.this.a(this.f137179d, this.f137180e, this.f137181f, this.f137178c);
            i iVar = i.this;
            iVar.a(a16, new a(b16, iVar, this.f137182g));
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f137187c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Class f137188d;

        public g(String str, Class cls) {
            this.f137187c = str;
            this.f137188d = cls;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final t8 call(t8 t8Var) {
            try {
                return i.this.a(this.f137187c, t8Var, this.f137188d);
            } catch (com.tencent.luggage.wxa.bj.a e16) {
                com.tencent.luggage.wxa.xo.h.a().a(e16);
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.luggage.wxa.p3.b bVar = i.this.f137167c;
            if (bVar != null) {
                bVar.destroy();
            }
            i.this.f137167c = null;
            SparseArray sparseArray = i.this.f137169e;
            i iVar = i.this;
            synchronized (sparseArray) {
                int size = iVar.f137169e.size();
                w.d(iVar.f(), "uninstall mTdiCgiCallbackMap size=[%d]", Integer.valueOf(size));
                for (int i3 = 0; i3 < size; i3++) {
                    int keyAt = iVar.f137169e.keyAt(i3);
                    com.tencent.luggage.wxa.p3.c cVar = (com.tencent.luggage.wxa.p3.c) iVar.f137169e.get(keyAt);
                    if (cVar != null) {
                        cVar.a(keyAt, -2, new byte[0]);
                    }
                }
                iVar.f137169e.clear();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public i() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new b());
        this.f137165a = lazy;
        this.f137166b = new ReentrantLock();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("tdi_thread_name");
        baseHandlerThread.start();
        com.tencent.luggage.wxa.yo.f.a("tdi_thread_name", new com.tencent.luggage.wxa.yo.g(baseHandlerThread.getLooper(), "tdi_thread_name"));
        this.f137168d = new c();
        this.f137169e = new SparseArray();
    }

    public abstract s8 a(String str, String str2, com.tencent.luggage.wxa.fn.b bVar);

    public abstract xa a(t8 t8Var);

    public abstract void a(com.tencent.luggage.wxa.fn.b bVar);

    public abstract void b(com.tencent.luggage.wxa.fn.b bVar);

    public abstract byte[] b(t8 t8Var);

    public abstract Class c();

    public final String f() {
        return (String) this.f137165a.getValue();
    }

    public abstract String i();

    public int n() {
        return com.tencent.luggage.wxa.p3.a.f137135a.c();
    }

    public com.tencent.luggage.wxa.n3.w o() {
        return com.tencent.luggage.wxa.n3.w.SHORT;
    }

    public String r() {
        return com.tencent.luggage.wxa.p3.a.f137135a.d();
    }

    @Override // com.tencent.luggage.wxa.p3.d
    public void z() {
        h hVar = new h();
        if (this.f137166b.isLocked()) {
            hVar.run();
            return;
        }
        try {
            this.f137166b.lock();
            hVar.run();
        } finally {
            this.f137166b.unlock();
        }
    }

    public final boolean b() {
        if (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            try {
                this.f137166b.lock();
                if (this.f137167c != null) {
                    return true;
                }
                w.b(f(), "boot get null mTdiCgi, wait");
                this.f137166b.unlock();
                if (q0.f135244a.a()) {
                    int a16 = q0.a(false, null, false, 7, null);
                    String f16 = f();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("boot await done ret:");
                    sb5.append(0);
                    sb5.append(" null==mTdiCgi? ");
                    sb5.append(this.f137167c == null);
                    w.d(f16, sb5.toString());
                    Unit unit = Unit.INSTANCE;
                    if (a16 == 0) {
                        return true;
                    }
                }
                return false;
            } finally {
                this.f137166b.unlock();
            }
        }
        throw new IllegalStateException("Must invoke in worker thread");
    }

    public void a(com.tencent.luggage.wxa.p3.b tdiCgi) {
        Intrinsics.checkNotNullParameter(tdiCgi, "tdiCgi");
        com.tencent.luggage.wxa.er.a.b(tdiCgi instanceof p);
        try {
            this.f137166b.lock();
            com.tencent.luggage.wxa.p3.b bVar = this.f137167c;
            if (bVar != null) {
                if (!(bVar.c())) {
                }
            }
            w.d(f(), hashCode() + " installTdiCgi: " + tdiCgi + " stack=[%s]", Log.getStackTraceString(new Throwable()));
            z();
            this.f137167c = tdiCgi;
            Intrinsics.checkNotNull(tdiCgi);
            tdiCgi.a(this.f137168d);
        } finally {
            this.f137166b.unlock();
        }
    }

    @Override // com.tencent.luggage.wxa.p3.d
    public com.tencent.luggage.wxa.xo.d b(int i3, String url, com.tencent.luggage.wxa.n3.w networkType, com.tencent.luggage.wxa.fn.b bVar, Class respClazz) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(networkType, "networkType");
        Intrinsics.checkNotNullParameter(respClazz, "respClazz");
        com.tencent.luggage.wxa.xo.d b16 = com.tencent.luggage.wxa.xo.h.c().b("tdi_thread_name").b(new e()).b("tdi_thread_name").b(new f(bVar, i3, url, networkType, respClazz));
        Intrinsics.checkNotNullExpressionValue(b16, "override fun <RESP : Res\u2026 null\n            }\n    }");
        return b16;
    }

    public final int a(com.tencent.luggage.wxa.n3.b bVar, com.tencent.luggage.wxa.p3.c cVar) {
        com.tencent.luggage.wxa.p3.b bVar2 = this.f137167c;
        if (bVar2 == null) {
            return -1;
        }
        int a16 = bVar2.a(bVar);
        String f16 = f();
        String str = bVar.a() + " sendTdiRequest taskId[%d] cmdId[%d] url[%s] tdi[%s]";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(a16);
        objArr[1] = Integer.valueOf(bVar.a());
        objArr[2] = bVar.e();
        String canonicalName = bVar2.getClass().getCanonicalName();
        if (canonicalName == null) {
            canonicalName = "null";
        }
        objArr[3] = canonicalName;
        w.d(f16, str, objArr);
        if (a16 == 0) {
            w.f(f(), "taskId==0, is this right?");
        }
        if (a16 != -1 && a16 != 0) {
            synchronized (this.f137169e) {
                Intrinsics.checkNotNull(this.f137167c);
                this.f137169e.put(a16, cVar);
                Unit unit = Unit.INSTANCE;
            }
        } else {
            cVar.a(a16, -3, new byte[0]);
        }
        return a16;
    }

    @Override // com.tencent.luggage.wxa.bj.c
    public com.tencent.luggage.wxa.xo.d b(String str, String str2, com.tencent.luggage.wxa.fn.b bVar, Class respClazz) {
        Intrinsics.checkNotNullParameter(respClazz, "respClazz");
        a(bVar);
        s8 a16 = a(str, str2, bVar);
        int n3 = n();
        String r16 = r();
        com.tencent.luggage.wxa.n3.w o16 = o();
        Class c16 = c();
        Intrinsics.checkNotNull(c16);
        com.tencent.luggage.wxa.xo.d b16 = b(n3, r16, o16, a16, c16).b(new g(str, respClazz));
        Intrinsics.checkNotNullExpressionValue(b16, "override fun <RESP : Res\u2026     null\n        }\n    }");
        return b16;
    }

    public com.tencent.luggage.wxa.n3.b a(int i3, String url, com.tencent.luggage.wxa.n3.w networkType, com.tencent.luggage.wxa.fn.b bVar) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(networkType, "networkType");
        b0 b0Var = b0.SESSION;
        byte[] b16 = bVar != null ? bVar.b() : null;
        if (b16 == null) {
            b16 = new byte[0];
        }
        return new com.tencent.luggage.wxa.n3.b(i3, b0Var, b16, url, networkType, 30000);
    }

    @Override // com.tencent.luggage.wxa.p3.d
    public t8 a(int i3, String url, com.tencent.luggage.wxa.n3.w networkType, com.tencent.luggage.wxa.fn.b bVar, Class respClazz) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(networkType, "networkType");
        Intrinsics.checkNotNullParameter(respClazz, "respClazz");
        com.tencent.luggage.wxa.er.a.a(bVar);
        if (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            AtomicReference atomicReference = new AtomicReference();
            if (b()) {
                a(bVar);
                b(bVar);
                a(a(i3, url, networkType, bVar), new d(atomicReference, this, respClazz, countDownLatch));
                try {
                    if (!countDownLatch.await(60L, TimeUnit.SECONDS)) {
                        w.h(f(), "cmd[%d]url[%s] timeout", Integer.valueOf(i3), url);
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
                return (t8) atomicReference.get();
            }
            throw new com.tencent.luggage.wxa.bj.a(a.EnumC6074a.SEND, -1, "Boot failed");
        }
        throw new IllegalStateException("Must invoke in worker thread");
    }

    @Override // com.tencent.luggage.wxa.bj.c
    public t8 a(String str, String str2, com.tencent.luggage.wxa.fn.b bVar, Class respClazz) {
        Intrinsics.checkNotNullParameter(respClazz, "respClazz");
        w.d(i(), "sync: process=[%s] url=[%s] appId=[%s],req=[%s], resp class=[%s]", z.i(), str, str2, bVar, respClazz.getSimpleName());
        if (bVar == null) {
            w.f(f(), "sync: req is null, abort");
            return null;
        }
        a(bVar);
        b(bVar);
        s8 a16 = a(str, str2, bVar);
        int n3 = n();
        String r16 = r();
        com.tencent.luggage.wxa.n3.w o16 = o();
        Class c16 = c();
        Intrinsics.checkNotNull(c16);
        try {
            return a(str, a(n3, r16, o16, a16, c16), respClazz);
        } catch (com.tencent.luggage.wxa.bj.a e16) {
            w.b(f(), "sync failed exception=[%s] stack=[%s]", e16, Log.getStackTraceString(e16));
            return null;
        }
    }

    public final t8 a(byte[] resp, Class respClazz) {
        Intrinsics.checkNotNullParameter(resp, "resp");
        Intrinsics.checkNotNullParameter(respClazz, "respClazz");
        return a(respClazz, resp);
    }

    public final t8 a(String str, t8 t8Var, Class cls) {
        String f16;
        if ((t8Var != null ? t8Var.e() : null) != null) {
            xa a16 = a(t8Var);
            if ((a16 != null ? a16.f129028d : 0) != 0) {
                String f17 = f();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("processTransResp, transResp: [");
                sb5.append(t8Var.e().f127731d);
                sb5.append(", ");
                e9 e9Var = t8Var.e().f127732e;
                sb5.append(e9Var != null ? e9Var.f() : null);
                sb5.append(", ");
                xa a17 = a(t8Var);
                Intrinsics.checkNotNull(a17);
                sb5.append(a17);
                sb5.append("] url=");
                sb5.append(str);
                w.b(f17, sb5.toString());
                int i3 = t8Var.e().f127731d;
                e9 e9Var2 = t8Var.e().f127732e;
                f16 = e9Var2 != null ? e9Var2.f() : null;
                xa a18 = a(t8Var);
                Intrinsics.checkNotNull(a18);
                throw new com.tencent.luggage.wxa.n3.i(i3, f16, a18);
            }
            if (t8Var.e().f127731d != 0) {
                e9 e9Var3 = t8Var.e().f127732e;
                f16 = e9Var3 != null ? e9Var3.f() : null;
                w.b(f(), "processTransResp, baseResponse=[" + t8Var.e().f127731d + " \"" + f16 + "\"] url=" + str);
                throw new com.tencent.luggage.wxa.bj.a(a.EnumC6074a.TRANSFER, t8Var.e().f127731d, f16);
            }
            t8 a19 = a(cls, b(t8Var));
            if (a19 != null) {
                return a19;
            }
            w.b(f(), "processTransResp, decode failed, url=" + str);
            throw new com.tencent.luggage.wxa.bj.a(a.EnumC6074a.DECODE, 0, null);
        }
        w.b(f(), "processTransResp: recv failed url:" + str + " [%s]", Log.getStackTraceString(new Throwable()));
        throw new com.tencent.luggage.wxa.bj.a(a.EnumC6074a.DECODE, 0, null);
    }

    public final t8 a(Class cls, byte[] bArr) {
        t8 t8Var;
        if (cls != null) {
            try {
                t8Var = (t8) cls.newInstance();
            } catch (Exception unused) {
                String f16 = f();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("RespData decode failed for response class ");
                sb5.append(cls);
                sb5.append(" buf:");
                sb5.append(bArr != null ? Integer.valueOf(bArr.length) : null);
                w.b(f16, sb5.toString());
                return null;
            }
        } else {
            t8Var = null;
        }
        if (t8Var != null) {
            t8Var.a(bArr);
        }
        w.a(f(), "RespData decode done for response class " + cls);
        return t8Var;
    }
}
