package com.tencent.luggage.wxa.b9;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.eclipsesource.mmv8.MultiContextV8;
import com.eclipsesource.mmv8.V8;
import com.eclipsesource.mmv8.V8Context;
import com.eclipsesource.mmv8.V8Locker;
import com.eclipsesource.mmv8.V8ScriptException;
import com.eclipsesource.mmv8.snapshot.CreateSnapshotResult;
import com.eclipsesource.mmv8.utils.MemoryManager;
import com.tencent.luggage.wxa.b9.a;
import com.tencent.luggage.wxa.b9.d;
import com.tencent.luggage.wxa.b9.e;
import com.tencent.luggage.wxa.b9.t;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mm.appbrand.v8.NativeBufferJNI;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a implements com.tencent.luggage.wxa.b9.d {

    /* renamed from: a, reason: collision with root package name */
    public MultiContextV8 f122085a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.b9.e f122086b;

    /* renamed from: c, reason: collision with root package name */
    public CountDownLatch f122087c;

    /* renamed from: d, reason: collision with root package name */
    public MemoryManager f122088d;

    /* renamed from: e, reason: collision with root package name */
    public j0 f122089e;

    /* renamed from: f, reason: collision with root package name */
    public h f122090f;

    /* renamed from: g, reason: collision with root package name */
    public String f122091g;

    /* renamed from: h, reason: collision with root package name */
    public String f122092h;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f122093i;

    /* renamed from: j, reason: collision with root package name */
    public String f122094j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f122095k;

    /* renamed from: l, reason: collision with root package name */
    public int f122096l;

    /* renamed from: m, reason: collision with root package name */
    public String f122097m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f122098n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f122099o;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f122101q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f122102r;

    /* renamed from: t, reason: collision with root package name */
    public final SparseArray f122104t;

    /* renamed from: u, reason: collision with root package name */
    public final ConcurrentLinkedQueue f122105u;

    /* renamed from: v, reason: collision with root package name */
    public final ConcurrentLinkedQueue f122106v;

    /* renamed from: w, reason: collision with root package name */
    public final d.a f122107w;

    /* renamed from: y, reason: collision with root package name */
    public static final AtomicInteger f122083y = new AtomicInteger(0);

    /* renamed from: z, reason: collision with root package name */
    public static Runnable f122084z = new RunnableC6041a();
    public static d.b A = new b();

    /* renamed from: p, reason: collision with root package name */
    public volatile int f122100p = -1;

    /* renamed from: s, reason: collision with root package name */
    public int f122103s = 0;

    /* renamed from: x, reason: collision with root package name */
    public final boolean[] f122108x = new boolean[1];

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements t.r {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f122109a;

        public c(int i3) {
            this.f122109a = i3;
        }

        @Override // com.tencent.luggage.wxa.b9.t.r
        public V8Context a() {
            if (a.this.f122085a != null) {
                return a.this.f122085a.createContext(this.f122109a);
            }
            throw new IllegalStateException("createContext mV8 not ready!");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d extends BaseThread {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f122111a;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.b9.a$d$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6042a implements e.a {
            public C6042a() {
            }

            @Override // com.tencent.luggage.wxa.b9.e.a
            public void a(V8ScriptException v8ScriptException) {
                a.this.a(v8ScriptException);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, CountDownLatch countDownLatch) {
            super(str);
            this.f122111a = countDownLatch;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            a.this.n();
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            a.this.f122100p = Process.myTid();
            a.f122084z.run();
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AbstractJSRuntime", "expansions file is ready");
            if (Integer.MIN_VALUE != a.this.f122107w.f122197m) {
                a aVar = a.this;
                aVar.a(aVar.f122107w.f122197m);
            }
            a aVar2 = a.this;
            aVar2.f122086b = aVar2.s();
            a.this.f122086b.a(new C6042a());
            this.f122111a.countDown();
            a.this.f122087c.countDown();
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AbstractJSRuntime", "prepareV8WhenThreadStart, tid[%d] JsRuntime[%d] JsLooper[%d]", Integer.valueOf(a.this.f122100p), Integer.valueOf(a.this.hashCode()), Integer.valueOf(a.this.f122086b.hashCode()));
            a aVar3 = a.this;
            aVar3.f122085a = aVar3.t();
            a.this.f122085a.getV8().setDelaySaveCodeCache(a.this.f122098n);
            a.this.f122085a.setMinimalCodeLength(a.this.f122103s);
            a.this.f122089e = new j0(a.this.f122085a);
            a.this.f122089e.b();
            a aVar4 = a.this;
            aVar4.f122088d = aVar4.f122085a.createMemoryManager();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AbstractJSRuntime", "v8 init cost:%d ms", Long.valueOf(currentTimeMillis2));
            g0.a(5, currentTimeMillis2, -1, null, -1, -1, -1);
            V8Locker v8Locker = a.this.f122085a.getV8Locker();
            if (v8Locker.hasLock()) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AbstractJSRuntime", "has lock release");
                v8Locker.release();
            }
            v8Locker.acquire();
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AbstractJSRuntime", "#loop before");
            a.this.f122086b.a(new Runnable() { // from class: com.tencent.luggage.wxa.b9.ab
                @Override // java.lang.Runnable
                public final void run() {
                    a.d.this.a();
                }
            });
            a.this.f122086b.f();
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AbstractJSRuntime", "#loop after");
            a.this.o();
            a.this.f122088d.release();
            a.this.f122089e.c();
            try {
                a.this.f122104t.clear();
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AbstractJSRuntime", "whenThreadEnd, mJSExceptionHandlerMap.clear() succeed, JsRuntime[%d]", Integer.valueOf(a.this.hashCode()));
            } catch (Throwable th5) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AbstractJSRuntime", "whenThreadEnd, mJSExceptionHandlerMap.clear(), JsRuntime[%d] get exception[%s]", Integer.valueOf(a.this.hashCode()), th5);
            }
            a.this.l();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements t.r {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f122114a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f122115b;

        public e(int i3, int i16) {
            this.f122114a = i3;
            this.f122115b = i16;
        }

        @Override // com.tencent.luggage.wxa.b9.t.r
        public V8Context a() {
            if (a.this.f122085a != null) {
                return a.this.f122085a.createContextFromSnapshot(this.f122114a, this.f122115b);
            }
            throw new IllegalStateException("createContext mV8 not ready!");
        }
    }

    public a(d.a aVar) {
        d.a aVar2;
        String str;
        this.f122091g = "RuntimeLooper";
        this.f122096l = CreateSnapshotResult.Success.INVALID_CONTEXT_INDEX;
        if (aVar != null) {
            if (!TextUtils.isEmpty(aVar.f122185a)) {
                aVar.f122185a = com.tencent.luggage.wxa.cp.x.b(aVar.f122185a, true);
            }
            this.f122092h = aVar.f122185a;
            this.f122093i = aVar.f122188d;
            this.f122094j = aVar.f122186b;
            this.f122095k = aVar.f122187c;
            this.f122096l = aVar.f122189e;
            this.f122101q = aVar.a();
            this.f122099o = aVar.f122192h;
            this.f122102r = aVar.f122193i;
            this.f122097m = aVar.f122195k;
            this.f122090f = aVar.f122200p;
            if (!w0.c(aVar.f122196l)) {
                this.f122091g = aVar.f122196l;
            }
            this.f122098n = aVar.f122198n;
        } else {
            this.f122101q = false;
            this.f122102r = false;
        }
        if (aVar == null) {
            aVar2 = new d.a();
        } else {
            aVar2 = aVar;
        }
        this.f122107w = aVar2;
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.f122101q);
        objArr[1] = Boolean.valueOf(this.f122102r);
        if (aVar != null) {
            str = aVar.toString();
        } else {
            str = "";
        }
        objArr[2] = str;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AbstractJSRuntime", "<init> hy: use native buffer: %b, hasGlobalTimer: %b, config: %s", objArr);
        this.f122104t = new SparseArray();
        this.f122105u = new ConcurrentLinkedQueue();
        this.f122106v = new ConcurrentLinkedQueue();
        u();
    }

    public void l() {
        com.tencent.luggage.wxa.zp.h.f146825d.b(new Runnable() { // from class: com.tencent.luggage.wxa.b9.aa
            @Override // java.lang.Runnable
            public final void run() {
                V8.clearSnapshotCacheIfIdle();
            }
        }, 30000L);
    }

    public final void m() {
        this.f122107w.getClass();
    }

    public final void n() {
        while (true) {
            Runnable runnable = (Runnable) this.f122106v.poll();
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (V8ScriptException e16) {
                    a(e16);
                } catch (UndeclaredThrowableException e17) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AbstractJSRuntime", "doPostedBeforeLooperEndJob UndeclaredThrowableException: %s %s", e17, e17.getCause());
                }
            } else {
                return;
            }
        }
    }

    public final void o() {
        while (true) {
            Runnable runnable = (Runnable) this.f122105u.poll();
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (V8ScriptException e16) {
                    a(e16);
                } catch (UndeclaredThrowableException e17) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AbstractJSRuntime", "doPostedCleanUpJob UndeclaredThrowableException: %s %s", e17, e17.getCause());
                }
            } else {
                return;
            }
        }
    }

    public h p() {
        if (this.f122090f == null) {
            if (this.f122101q) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AbstractJSRuntime", "hy: start load native buffer jni");
                this.f122090f = new NativeBufferJNI();
            } else {
                this.f122090f = new b0();
            }
        }
        return this.f122090f;
    }

    @Override // com.tencent.luggage.wxa.b9.d
    public void pause() {
        this.f122086b.pause();
        A.a(this);
    }

    public boolean q() {
        return this.f122102r;
    }

    public final void r() {
        if (this.f122086b == null && this.f122087c != null) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AbstractJSRuntime", "scheduleToJSThread but looper null");
            try {
                this.f122087c.await(30000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e16) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AbstractJSRuntime", "scheduleToJSThread latch.await InterruptedException:%s", e16);
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AbstractJSRuntime", "scheduleToJSThread but looper assigned");
        }
        if (this.f122086b == null) {
            f122084z.run();
            if (this.f122086b == null) {
                throw new IllegalStateException("JSRuntime not ready!");
            }
        }
    }

    public abstract com.tencent.luggage.wxa.b9.e s();

    public abstract MultiContextV8 t();

    public final void u() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f122087c = new CountDownLatch(1);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AbstractJSRuntime", "startLooper: " + hashCode());
        new d(String.format(Locale.US, "JS%s#%d", this.f122091g, Integer.valueOf(f122083y.getAndIncrement())), countDownLatch).start();
        try {
            countDownLatch.await(5000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e16) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AbstractJSRuntime", "init latch.await InterruptedException:%s", e16);
        }
    }

    @Override // com.tencent.luggage.wxa.b9.d
    public void b(Runnable runnable) {
        this.f122106v.add(runnable);
    }

    @Override // com.tencent.luggage.wxa.b9.d
    public void c(Runnable runnable) {
        this.f122105u.add(runnable);
    }

    @Override // com.tencent.luggage.wxa.b9.d
    public String d() {
        return this.f122086b.d();
    }

    @Override // com.tencent.luggage.wxa.b9.d
    public void e() {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AbstractJSRuntime", "quit() JsRuntime[%d]", Integer.valueOf(hashCode()));
        this.f122086b.e();
        A.b(this);
        this.f122100p = -1;
    }

    @Override // com.tencent.luggage.wxa.b9.d
    public long f() {
        return this.f122085a.getIsolatePtr();
    }

    @Override // com.tencent.luggage.wxa.b9.d
    public void h() {
        new u(this.f122085a, this).a();
    }

    @Override // com.tencent.luggage.wxa.b9.d
    public boolean i() {
        return this.f122086b.i();
    }

    @Override // com.tencent.luggage.wxa.b9.d
    public long j() {
        return this.f122085a.getUVLoopPtr();
    }

    @Override // com.tencent.luggage.wxa.b9.d
    public d.a k() {
        return this.f122107w;
    }

    @Override // com.tencent.luggage.wxa.b9.d
    public t b(int i3) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AbstractJSRuntime", "createMainContext, contextTag: %d, mainContextSnapshotIndex: %d", Integer.valueOf(i3), Integer.valueOf(this.f122096l));
        int i16 = CreateSnapshotResult.Success.INVALID_CONTEXT_INDEX;
        int i17 = this.f122096l;
        if (i16 != i17) {
            return a(i3, i17);
        }
        return c(i3);
    }

    @Override // com.tencent.luggage.wxa.b9.d
    public t c(int i3) {
        return new t(this, p(), new c(i3));
    }

    @Override // com.tencent.luggage.wxa.b9.d
    public boolean c() {
        return this.f122086b.c();
    }

    public final void a(long j3, long j16) {
        this.f122107w.getClass();
    }

    @Override // com.tencent.luggage.wxa.b9.d
    public void b() {
        this.f122086b.b();
    }

    @Override // com.tencent.luggage.wxa.b9.d
    public void a(int i3) {
        int i16 = this.f122100p;
        if (i16 > 0) {
            try {
                Process.setThreadPriority(i16, i3);
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AbstractJSRuntime", "setThreadPriority priority=%d tid=%d", Integer.valueOf(i3), Integer.valueOf(i16));
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AbstractJSRuntime", e16, "setThreadPriority priority=%d tid=%d", Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }
    }

    @Override // com.tencent.luggage.wxa.b9.d
    public void a() {
        this.f122086b.a();
        A.c(this);
    }

    @Override // com.tencent.luggage.wxa.b9.d
    public void a(Runnable runnable) {
        a(runnable, false);
    }

    @Override // com.tencent.luggage.wxa.b9.d
    public void a(Runnable runnable, boolean z16) {
        r();
        this.f122086b.a(runnable, z16);
    }

    @Override // com.tencent.luggage.wxa.b9.d
    public void a(Runnable runnable, long j3) {
        a(runnable, j3, false);
    }

    @Override // com.tencent.luggage.wxa.b9.d
    public void a(Runnable runnable, long j3, boolean z16) {
        r();
        this.f122086b.a(runnable, j3, z16);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.b9.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6041a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }
    }

    @Override // com.tencent.luggage.wxa.b9.d
    public final void a(int i3, com.tencent.luggage.wxa.ei.i iVar) {
        if (this.f122100p < 0) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AbstractJSRuntime", "setJsExceptionHandler after destroyed, JsRuntime[%d] stack=%s", Integer.valueOf(hashCode()), Log.getStackTraceString(new Throwable()));
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AbstractJSRuntime", "setJsExceptionHandler contextId[%d] JsRuntime[%d] JSThread.id[%d], currentThread.id[%d]", Integer.valueOf(i3), Integer.valueOf(hashCode()), Integer.valueOf(this.f122100p), Long.valueOf(Thread.currentThread().getId()));
        synchronized (this.f122104t) {
            this.f122104t.put(i3, iVar);
        }
    }

    public final void a(V8ScriptException v8ScriptException) {
        com.tencent.luggage.wxa.ei.i iVar;
        synchronized (this.f122104t) {
            iVar = (com.tencent.luggage.wxa.ei.i) this.f122104t.get(v8ScriptException.getContextTag());
        }
        if (iVar != null) {
            iVar.a(v8ScriptException.getJSMessage(), v8ScriptException.getJSStackTrace());
        } else {
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.AbstractJSRuntime", "publishJSException jsHandler null %s", v8ScriptException);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements d.b {
        @Override // com.tencent.luggage.wxa.b9.d.b
        public void a(com.tencent.luggage.wxa.b9.d dVar) {
        }

        @Override // com.tencent.luggage.wxa.b9.d.b
        public void b(com.tencent.luggage.wxa.b9.d dVar) {
        }

        @Override // com.tencent.luggage.wxa.b9.d.b
        public void c(com.tencent.luggage.wxa.b9.d dVar) {
        }
    }

    @Override // com.tencent.luggage.wxa.b9.d
    public t a(int i3, int i16) {
        return new t(this, p(), new e(i3, i16));
    }

    @Override // com.tencent.luggage.wxa.b9.d
    public void a(String str, boolean z16) {
        new u(this.f122085a, this).a(str, z16);
    }
}
