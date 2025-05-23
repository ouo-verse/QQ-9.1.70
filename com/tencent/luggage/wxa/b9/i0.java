package com.tencent.luggage.wxa.b9;

import android.text.TextUtils;
import com.eclipsesource.mmv8.V8RuntimeException;
import com.eclipsesource.mmv8.V8ScriptException;
import com.tencent.luggage.wxa.b9.e;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class i0 implements e {

    /* renamed from: o, reason: collision with root package name */
    public static final ThreadLocal f122207o = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    public final String f122208a;

    /* renamed from: b, reason: collision with root package name */
    public final Thread f122209b;

    /* renamed from: e, reason: collision with root package name */
    public boolean f122212e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f122213f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f122214g;

    /* renamed from: h, reason: collision with root package name */
    public e.a f122215h;

    /* renamed from: c, reason: collision with root package name */
    public final s f122210c = s.f122275c.a();

    /* renamed from: d, reason: collision with root package name */
    public a f122211d = a.NONE;

    /* renamed from: i, reason: collision with root package name */
    public r f122216i = new r();

    /* renamed from: j, reason: collision with root package name */
    public Runnable f122217j = null;

    /* renamed from: k, reason: collision with root package name */
    public Queue f122218k = new LinkedList();

    /* renamed from: l, reason: collision with root package name */
    public Queue f122219l = new LinkedList();

    /* renamed from: m, reason: collision with root package name */
    public boolean f122220m = false;

    /* renamed from: n, reason: collision with root package name */
    public int f122221n = -1;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum a {
        NONE,
        RESUME,
        ENQUEUE
    }

    public i0(String str, boolean z16) {
        String str2 = str + "@" + hashCode();
        this.f122208a = str2;
        this.f122209b = Thread.currentThread();
        this.f122214g = z16;
        com.tencent.luggage.wxa.tn.w.d(str2, "V8JSRuntimeLooper <init> ignoreRemainingTaskWhenLoopEnd?%b", Boolean.valueOf(z16));
        String a16 = com.tencent.luggage.wxa.tn.d0.a(false);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("from=");
        sb5.append(TextUtils.isEmpty(a16) ? com.tencent.luggage.wxa.tn.d0.a() : a16);
        com.tencent.luggage.wxa.tn.w.d(str2, sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String k() {
        return "loopOuter: isPaused=" + j() + ", waitCondition=" + v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String l() {
        return "loopInner: mTaskQueueNotifyReason=" + this.f122211d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String m() {
        return "copyToWriteUnsafe: task=" + this.f122210c.size() + ", copy=" + this.f122218k.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String n() {
        return "loopTask: copy=" + this.f122218k.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String o() {
        return "loopTaskInner: copy=" + this.f122218k.size();
    }

    @Override // com.tencent.luggage.wxa.b9.e
    public void f() {
        com.tencent.luggage.wxa.tn.w.d(this.f122208a, "loop start");
        while (!this.f122213f) {
            synchronized (this.f122210c) {
                a(new Function0() { // from class: com.tencent.luggage.wxa.b9.ac
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        String k3;
                        k3 = i0.this.k();
                        return k3;
                    }
                });
                while (true) {
                    if (!j() && !v()) {
                        break;
                    }
                    try {
                        LockMethodProxy.wait(this.f122210c);
                        a(new Function0() { // from class: com.tencent.luggage.wxa.b9.ad
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                String l3;
                                l3 = i0.this.l();
                                return l3;
                            }
                        });
                        a aVar = a.RESUME;
                        a aVar2 = this.f122211d;
                        if (aVar == aVar2) {
                            com.tencent.luggage.wxa.tn.w.d(this.f122208a, "loop notify by reason:%s", aVar2);
                        }
                        this.f122211d = a.NONE;
                    } catch (InterruptedException unused) {
                        com.tencent.luggage.wxa.tn.w.d(this.f122208a, "wait interrupted ; loop end");
                        this.f122209b.interrupt();
                        u();
                    }
                }
                this.f122218k.clear();
                this.f122210c.a(this.f122218k, this.f122212e);
                a(new Function0() { // from class: com.tencent.luggage.wxa.b9.ae
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        String m3;
                        m3 = i0.this.m();
                        return m3;
                    }
                });
            }
            p();
        }
        q();
        synchronized (this.f122210c) {
            this.f122210c.clear();
        }
    }

    public final int g() {
        int size;
        synchronized (this.f122210c) {
            size = this.f122210c.size();
        }
        return size;
    }

    public void h() {
        for (Runnable runnable : this.f122219l) {
            if (this.f122214g && this.f122213f) {
                com.tencent.luggage.wxa.tn.w.d(this.f122208a, "LoopTask break for mLooperEnd");
                return;
            } else {
                b(runnable);
                if (this.f122216i.f122273a) {
                    this.f122216i.f122274b.pollFirst();
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.b9.e
    public boolean i() {
        if (Thread.currentThread().getId() == this.f122209b.getId()) {
            return true;
        }
        return false;
    }

    public synchronized boolean j() {
        boolean z16;
        if (this.f122212e) {
            if (!this.f122210c.c()) {
                z16 = true;
            }
        }
        z16 = false;
        return z16;
    }

    public void p() {
        a(new Function0() { // from class: com.tencent.luggage.wxa.b9.af
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String n3;
                n3 = i0.this.n();
                return n3;
            }
        });
        this.f122221n = -1;
        this.f122220m = false;
        for (Runnable runnable : this.f122218k) {
            a(new Function0() { // from class: com.tencent.luggage.wxa.b9.ag
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String o16;
                    o16 = i0.this.o();
                    return o16;
                }
            });
            if (this.f122214g && this.f122213f) {
                com.tencent.luggage.wxa.tn.w.d(this.f122208a, "LoopTask break for mLooperEnd");
                return;
            }
            this.f122221n++;
            b(runnable);
            if (this.f122216i.f122273a) {
                this.f122216i.f122274b.pollFirst();
            }
            if (this.f122220m) {
                return;
            }
        }
    }

    @Override // com.tencent.luggage.wxa.b9.e
    public void pause() {
        com.tencent.luggage.wxa.tn.w.d(this.f122208a, "pause instance: queue.size:%d", Integer.valueOf(g()));
        synchronized (this) {
            this.f122212e = true;
        }
    }

    public void q() {
        com.tencent.luggage.wxa.tn.w.d(this.f122208a, "loop end");
        Runnable runnable = this.f122217j;
        if (runnable != null) {
            runnable.run();
        }
    }

    public boolean v() {
        return this.f122210c.isEmpty();
    }

    public static /* synthetic */ String b(boolean z16) {
        return "scheduleDelayed: ignorePause=" + z16 + ", from=" + com.tencent.luggage.wxa.tn.d0.a(false);
    }

    public void a(Function0 function0) {
        ((com.tencent.luggage.wxa.w9.c) com.tencent.luggage.wxa.eo.g.a(com.tencent.luggage.wxa.w9.c.class)).a(this.f122208a, true, 100, function0);
    }

    @Override // com.tencent.luggage.wxa.b9.e
    public boolean c() {
        if (this.f122213f) {
            this.f122220m = true;
            return true;
        }
        synchronized (this.f122210c) {
            while (true) {
                if (!j() && !v()) {
                    break;
                }
                try {
                    LockMethodProxy.wait(this.f122210c);
                    a aVar = a.RESUME;
                    a aVar2 = this.f122211d;
                    if (aVar == aVar2) {
                        com.tencent.luggage.wxa.tn.w.d(this.f122208a, "loop notify by reason:%s", aVar2);
                    }
                    this.f122211d = a.NONE;
                } catch (InterruptedException unused) {
                    com.tencent.luggage.wxa.tn.w.d(this.f122208a, "wait interrupted ; loop end");
                    this.f122209b.interrupt();
                    u();
                }
            }
            this.f122219l.clear();
            this.f122210c.a(this.f122219l, this.f122212e);
        }
        h();
        return false;
    }

    @Override // com.tencent.luggage.wxa.b9.e
    public String d() {
        return (String) this.f122216i.f122274b.peek();
    }

    @Override // com.tencent.luggage.wxa.b9.e
    public void e() {
        com.tencent.luggage.wxa.tn.w.d(this.f122208a, "quit");
        r();
        this.f122213f = true;
        this.f122209b.interrupt();
    }

    @Override // com.tencent.luggage.wxa.b9.e
    public void a(Runnable runnable, final boolean z16) {
        if (runnable == null) {
            return;
        }
        if (this.f122213f) {
            com.tencent.luggage.wxa.tn.w.d(this.f122208a, "schedule but looper end");
            return;
        }
        if (Thread.currentThread().getId() == this.f122209b.getId()) {
            b(runnable);
            if (this.f122216i.f122273a) {
                this.f122216i.f122274b.remove(null);
            }
        } else {
            synchronized (this.f122210c) {
                a(new Function0() { // from class: com.tencent.luggage.wxa.b9.ai
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return i0.a(z16);
                    }
                });
                this.f122210c.a(runnable, z16);
                if (!j()) {
                    this.f122211d = a.ENQUEUE;
                    this.f122210c.notify();
                }
                if (z16 && this.f122212e) {
                    com.tencent.luggage.wxa.tn.w.d(this.f122208a, "schedule: important task in pause state. queue.size:[%d]", Integer.valueOf(g()));
                }
            }
        }
        t();
    }

    @Override // com.tencent.luggage.wxa.b9.e
    public void b() {
        Iterator it = this.f122218k.iterator();
        int i3 = -1;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Runnable runnable = (Runnable) it.next();
            if (this.f122214g && this.f122213f) {
                com.tencent.luggage.wxa.tn.w.d(this.f122208a, "LoopTask break for mLooperEnd");
                break;
            }
            i3++;
            if (i3 > this.f122221n) {
                this.f122221n = i3;
                b(runnable);
                if (this.f122216i.f122273a) {
                    this.f122216i.f122274b.pollFirst();
                }
                if (this.f122220m) {
                    break;
                }
            }
        }
        this.f122220m = true;
    }

    public final void b(Runnable runnable) {
        try {
            runnable.run();
        } catch (V8ScriptException e16) {
            if (this.f122215h != null) {
                this.f122215h.a(e16);
            }
            if (e16.getCause() != null) {
                com.tencent.luggage.wxa.tn.w.b(this.f122208a, "runTask V8ScriptException: %s, %s", e16, e16.getCause());
            }
        } catch (V8RuntimeException e17) {
            com.tencent.luggage.wxa.tn.w.a(this.f122208a, e17, "runTask", new Object[0]);
        } catch (UndeclaredThrowableException e18) {
            com.tencent.luggage.wxa.tn.w.b(this.f122208a, "runTask UndeclaredThrowableException: %s %s", e18, e18.getCause());
        } catch (Throwable th5) {
            com.tencent.luggage.wxa.tn.w.a(this.f122208a, th5, "runTask", new Object[0]);
            throw th5;
        }
    }

    public static /* synthetic */ String a(boolean z16) {
        return "schedule: ignorePause=" + z16 + ", from=" + com.tencent.luggage.wxa.tn.d0.a(false);
    }

    @Override // com.tencent.luggage.wxa.b9.e
    public void a(Runnable runnable, long j3, final boolean z16) {
        if (runnable == null) {
            return;
        }
        if (j3 == 0) {
            if (this.f122213f) {
                com.tencent.luggage.wxa.tn.w.d(this.f122208a, "scheduleDelayed but looper end");
                return;
            }
            synchronized (this.f122210c) {
                a(new Function0() { // from class: com.tencent.luggage.wxa.b9.ah
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return i0.b(z16);
                    }
                });
                this.f122210c.a(runnable, z16);
                if (!j()) {
                    this.f122210c.notify();
                }
                if (z16 && this.f122212e) {
                    com.tencent.luggage.wxa.tn.w.d(this.f122208a, "scheduleDelayed: important task in pause state. queue.size:[%d]", Integer.valueOf(g()));
                }
            }
            t();
            return;
        }
        throw new IllegalStateException("V8JSRuntimeLooper#scheduleDelayed not support.");
    }

    public void r() {
    }

    public void s() {
    }

    public void t() {
    }

    public void u() {
    }

    @Override // com.tencent.luggage.wxa.b9.e
    public void a() {
        com.tencent.luggage.wxa.tn.w.d(this.f122208a, "resume instance: queue.size:%d", Integer.valueOf(g()));
        synchronized (this) {
            this.f122212e = false;
        }
        s();
        synchronized (this.f122210c) {
            this.f122211d = a.RESUME;
            this.f122210c.notify();
        }
    }

    @Override // com.tencent.luggage.wxa.b9.e
    public void a(e.a aVar) {
        this.f122215h = aVar;
    }

    @Override // com.tencent.luggage.wxa.b9.e
    public void a(Runnable runnable) {
        this.f122217j = runnable;
    }
}
