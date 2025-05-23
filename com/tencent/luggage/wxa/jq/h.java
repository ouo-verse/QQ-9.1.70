package com.tencent.luggage.wxa.jq;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.luggage.wxa.zp.g;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.time.DurationKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h extends FutureTask implements RunnableScheduledFuture, g, Delayed, c {
    public static final com.tencent.luggage.wxa.fq.a E = new a();
    public static final AtomicLong F = new AtomicLong();
    public static final com.tencent.luggage.wxa.hq.b G = com.tencent.luggage.wxa.gq.h.f126817a;
    public static final long H = Looper.getMainLooper().getThread().getId();
    public final int C;
    public Throwable D;

    /* renamed from: a, reason: collision with root package name */
    public boolean f131221a;

    /* renamed from: b, reason: collision with root package name */
    public long f131222b;

    /* renamed from: c, reason: collision with root package name */
    public long f131223c;

    /* renamed from: d, reason: collision with root package name */
    public Thread f131224d;

    /* renamed from: e, reason: collision with root package name */
    public long f131225e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.zp.f f131226f;

    /* renamed from: g, reason: collision with root package name */
    public final long f131227g;

    /* renamed from: h, reason: collision with root package name */
    public volatile long f131228h;

    /* renamed from: i, reason: collision with root package name */
    public final long f131229i;

    /* renamed from: j, reason: collision with root package name */
    public Object f131230j;

    /* renamed from: k, reason: collision with root package name */
    public String f131231k;

    /* renamed from: l, reason: collision with root package name */
    public com.tencent.luggage.wxa.gq.g f131232l;

    /* renamed from: m, reason: collision with root package name */
    public com.tencent.luggage.wxa.iq.d f131233m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements com.tencent.luggage.wxa.fq.a {
        @Override // com.tencent.luggage.wxa.fq.a
        public void a(h hVar, long j3, long j16) {
            com.tencent.luggage.wxa.bq.c cVar = com.tencent.luggage.wxa.cq.b.f123843a;
            if (cVar != null) {
                cVar.a(hVar, j3, j16);
            }
        }

        @Override // com.tencent.luggage.wxa.fq.a
        public void b(h hVar) {
            com.tencent.luggage.wxa.bq.c cVar = com.tencent.luggage.wxa.cq.b.f123843a;
            if (cVar != null) {
                cVar.b(hVar);
            }
        }

        @Override // com.tencent.luggage.wxa.fq.a
        public void c(h hVar) {
            com.tencent.luggage.wxa.bq.c cVar = com.tencent.luggage.wxa.cq.b.f123843a;
            if (cVar != null) {
                cVar.c(hVar);
            }
        }

        @Override // com.tencent.luggage.wxa.fq.a
        public void d(h hVar) {
            com.tencent.luggage.wxa.bq.c cVar = com.tencent.luggage.wxa.cq.b.f123843a;
            if (cVar != null) {
                cVar.d(hVar);
            }
        }

        @Override // com.tencent.luggage.wxa.fq.a
        public void e(h hVar) {
            com.tencent.luggage.wxa.bq.c cVar = com.tencent.luggage.wxa.cq.b.f123843a;
            if (cVar != null) {
                cVar.e(hVar);
            }
        }

        @Override // com.tencent.luggage.wxa.fq.a
        public void f(h hVar) {
            com.tencent.luggage.wxa.bq.c cVar = com.tencent.luggage.wxa.cq.b.f123843a;
            if (cVar != null) {
                cVar.f(hVar);
            }
        }

        @Override // com.tencent.luggage.wxa.fq.a
        public void a(h hVar) {
            com.tencent.luggage.wxa.bq.c cVar = com.tencent.luggage.wxa.cq.b.f123843a;
            if (cVar != null) {
                cVar.a(hVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f131234a;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.zp.f.values().length];
            f131234a = iArr;
            try {
                iArr[com.tencent.luggage.wxa.zp.f.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f131234a[com.tencent.luggage.wxa.zp.f.COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public h(Runnable runnable, long j3, boolean z16) {
        super(runnable, null);
        com.tencent.luggage.wxa.fq.a aVar;
        this.f131221a = true;
        this.f131222b = 0L;
        this.f131223c = 0L;
        this.f131225e = 0L;
        this.f131226f = com.tencent.luggage.wxa.zp.f.CREATED;
        this.f131227g = F.getAndIncrement();
        this.f131230j = runnable;
        this.f131228h = j3;
        this.f131229i = 0L;
        this.f131231k = getKey();
        int hashCode = runnable.hashCode();
        this.C = hashCode;
        this.f131221a = z16;
        if (z16 && (aVar = E) != null) {
            aVar.e(this);
        }
        com.tencent.luggage.wxa.zp.d.f146812a.a(getKey(), hashCode, i(), j3 - System.nanoTime(), 0L, "", z16);
    }

    public final void a(Looper looper) {
        g.d dVar = com.tencent.luggage.wxa.zp.a.f146777j;
        if (!dVar.c() || H == Thread.currentThread().getId() || Looper.myLooper() == null || looper != null) {
            return;
        }
        dVar.a(Thread.currentThread(), getKey());
        if (dVar.b()) {
            try {
                ((ThreadLocal) com.tencent.luggage.wxa.mq.c.a(Looper.class, "sThreadLocal")).set(null);
                return;
            } catch (Exception e16) {
                this.D = e16;
                return;
            }
        }
        if (dVar.a()) {
            this.D = new RuntimeException("this task has prepared looper, is not " + getKey());
        }
    }

    public final boolean b() {
        boolean isPeriodic = isPeriodic();
        if (!b(isPeriodic)) {
            cancel(false);
        } else if (!isPeriodic) {
            super.run();
        } else if (super.runAndReset()) {
            m();
            return true;
        }
        return false;
    }

    public Object c() {
        return this.f131230j;
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
    public boolean cancel(boolean z16) {
        com.tencent.luggage.wxa.fq.a aVar;
        if (super.cancel(z16)) {
            this.f131226f = com.tencent.luggage.wxa.zp.f.CANCEL;
            if (this.f131221a && (aVar = E) != null) {
                aVar.f(this);
            }
            com.tencent.luggage.wxa.zp.d.f146812a.a(getKey(), this.C, i(), 0L, 0L, "", this.f131221a);
            com.tencent.luggage.wxa.iq.d dVar = this.f131233m;
            if (dVar != null) {
                dVar.b(this);
                return true;
            }
            return true;
        }
        return false;
    }

    public int d() {
        return this.C;
    }

    @Override // java.util.concurrent.FutureTask
    public void done() {
        super.done();
        this.f131230j = null;
    }

    public com.tencent.luggage.wxa.gq.g e() {
        if (this.f131232l == null) {
            this.f131232l = G.a(this.f131231k);
        }
        return this.f131232l;
    }

    public com.tencent.luggage.wxa.iq.d f() {
        return this.f131233m;
    }

    public void finalize() {
        super.finalize();
        com.tencent.luggage.wxa.zp.f fVar = this.f131226f;
        if (fVar == com.tencent.luggage.wxa.zp.f.CREATED || fVar == com.tencent.luggage.wxa.zp.f.WAITING) {
            cancel(false);
        }
    }

    public com.tencent.luggage.wxa.hq.b g() {
        return G;
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(this.f131228h - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override // com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.f
    public String getKey() {
        String str = this.f131231k;
        if (str == null) {
            Object obj = this.f131230j;
            if (obj instanceof f) {
                return ((f) obj).getKey();
            }
            return obj.getClass().getName();
        }
        return str;
    }

    public long[] h() {
        if (this.f131226f == com.tencent.luggage.wxa.zp.f.COMPLETE) {
            return new long[]{this.f131225e, this.f131222b};
        }
        return new long[2];
    }

    public com.tencent.luggage.wxa.zp.f i() {
        return this.f131226f;
    }

    @Override // java.util.concurrent.RunnableScheduledFuture
    public boolean isPeriodic() {
        if (this.f131229i != 0) {
            return true;
        }
        return false;
    }

    public Throwable j() {
        return this.D;
    }

    public boolean k() {
        long a16 = G.a(e(), TimeUnit.NANOSECONDS);
        if (a16 >= 0) {
            this.f131228h = System.nanoTime() + a16;
            return true;
        }
        return false;
    }

    public boolean l() {
        return G.c(e());
    }

    public void m() {
        long j3 = this.f131229i;
        if (j3 > 0) {
            this.f131228h += j3;
        } else {
            this.f131228h = a(-j3);
        }
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        com.tencent.luggage.wxa.fq.a aVar;
        com.tencent.luggage.wxa.fq.a aVar2;
        com.tencent.luggage.wxa.fq.a aVar3;
        if (isCancelled()) {
            return;
        }
        if (!l()) {
            if (k()) {
                a(com.tencent.luggage.wxa.zp.f.WAITING);
                this.f131233m.a(this);
                if (this.f131221a && (aVar3 = E) != null) {
                    aVar3.d(this);
                }
                com.tencent.luggage.wxa.zp.d.f146812a.a(getKey(), this.C, e().b(), this.f131228h - System.nanoTime(), f().getName());
                return;
            }
            this.f131226f = com.tencent.luggage.wxa.zp.f.THROW;
            if (this.f131221a && (aVar2 = E) != null) {
                aVar2.b(this);
            }
            com.tencent.luggage.wxa.zp.d.f146812a.a(getKey(), this.C, i(), 0L, 0L, f().getName(), this.f131221a);
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        this.f131222b = uptimeMillis;
        this.f131223c -= uptimeMillis;
        this.f131225e = SystemClock.currentThreadTimeMillis();
        this.f131226f = com.tencent.luggage.wxa.zp.f.RUNNING;
        com.tencent.luggage.wxa.zp.d.f146812a.a(getKey(), this.C, i(), this.f131222b, this.f131225e, f().getName(), this.f131221a);
        if (this.f131221a && (aVar = E) != null) {
            aVar.a(this);
        }
        Looper myLooper = Looper.myLooper();
        this.f131224d = Thread.currentThread();
        try {
            boolean b16 = b();
            this.f131222b = SystemClock.uptimeMillis() - this.f131222b;
            this.f131225e = SystemClock.currentThreadTimeMillis() - this.f131225e;
            if (this.f131226f != com.tencent.luggage.wxa.zp.f.ERROR) {
                this.f131226f = com.tencent.luggage.wxa.zp.f.COMPLETE;
            }
            com.tencent.luggage.wxa.fq.a aVar4 = E;
            if (aVar4 != null) {
                int i3 = b.f131234a[this.f131226f.ordinal()];
                if (i3 != 1) {
                    if (i3 == 2) {
                        if (this.f131221a) {
                            aVar4.a(this, this.f131225e, this.f131222b);
                        }
                        com.tencent.luggage.wxa.zp.d.f146812a.a(getKey(), this.C, i(), this.f131222b, this.f131225e, f().getName(), this.f131221a);
                    }
                } else {
                    if (this.f131221a) {
                        aVar4.c(this);
                    }
                    com.tencent.luggage.wxa.zp.d.f146812a.a(getKey(), this.C, j());
                }
            }
            if (b16) {
                if (this.f131221a && aVar4 != null) {
                    aVar4.e(this);
                }
                this.f131233m.a(this);
            }
            a(myLooper);
            a();
        } catch (Throwable th5) {
            this.f131222b = SystemClock.uptimeMillis() - this.f131222b;
            this.f131225e = SystemClock.currentThreadTimeMillis() - this.f131225e;
            if (this.f131226f != com.tencent.luggage.wxa.zp.f.ERROR) {
                this.f131226f = com.tencent.luggage.wxa.zp.f.COMPLETE;
            }
            com.tencent.luggage.wxa.fq.a aVar5 = E;
            if (aVar5 != null) {
                int i16 = b.f131234a[this.f131226f.ordinal()];
                if (i16 != 1) {
                    if (i16 == 2) {
                        if (this.f131221a) {
                            aVar5.a(this, this.f131225e, this.f131222b);
                        }
                        com.tencent.luggage.wxa.zp.d.f146812a.a(getKey(), this.C, i(), this.f131222b, this.f131225e, f().getName(), this.f131221a);
                    }
                } else {
                    if (this.f131221a) {
                        aVar5.c(this);
                    }
                    com.tencent.luggage.wxa.zp.d.f146812a.a(getKey(), this.C, j());
                }
            }
            a(myLooper);
            a();
            throw th5;
        }
    }

    @Override // java.util.concurrent.FutureTask
    public void setException(Throwable th5) {
        super.setException(th5);
        this.f131226f = com.tencent.luggage.wxa.zp.f.ERROR;
        this.D = th5;
    }

    public boolean b(boolean z16) {
        return !this.f131233m.isShutdown();
    }

    public final void a() {
        Throwable th5 = this.D;
        if (th5 != null) {
            if (!(th5 instanceof RuntimeException)) {
                if (th5 instanceof Error) {
                    throw ((Error) th5);
                }
                throw new Error(this.D);
            }
            throw ((RuntimeException) th5);
        }
    }

    public void a(com.tencent.luggage.wxa.iq.d dVar) {
        this.f131233m = dVar;
        this.f131223c = SystemClock.uptimeMillis();
    }

    public h(Runnable runnable, long j3, long j16, boolean z16) {
        super(runnable, null);
        com.tencent.luggage.wxa.fq.a aVar;
        this.f131221a = true;
        this.f131222b = 0L;
        this.f131223c = 0L;
        this.f131225e = 0L;
        this.f131226f = com.tencent.luggage.wxa.zp.f.CREATED;
        this.f131227g = F.getAndIncrement();
        this.f131230j = runnable;
        this.f131228h = j3;
        this.f131229i = j16;
        this.f131231k = getKey();
        int hashCode = runnable.hashCode();
        this.C = hashCode;
        this.f131221a = z16;
        if (z16 && (aVar = E) != null) {
            aVar.e(this);
        }
        com.tencent.luggage.wxa.zp.d.f146812a.a(getKey(), hashCode, i(), j3 - System.nanoTime(), 0L, "", z16);
    }

    public final long a(long j3) {
        long nanoTime = System.nanoTime();
        if (j3 >= DurationKt.MAX_MILLIS) {
            j3 = 4611686018427387903L;
        }
        return nanoTime + j3;
    }

    public void a(com.tencent.luggage.wxa.zp.f fVar) {
        this.f131226f = fVar;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(Delayed delayed) {
        if (delayed == this) {
            return 0;
        }
        if (delayed instanceof h) {
            h hVar = (h) delayed;
            long j3 = this.f131228h - hVar.f131228h;
            if (j3 < 0) {
                return -1;
            }
            return (j3 <= 0 && this.f131227g < hVar.f131227g) ? -1 : 1;
        }
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long delay = getDelay(timeUnit) - delayed.getDelay(timeUnit);
        if (delay < 0) {
            return -1;
        }
        return delay > 0 ? 1 : 0;
    }

    public h(Callable callable, long j3, boolean z16) {
        super(callable);
        com.tencent.luggage.wxa.fq.a aVar;
        this.f131221a = true;
        this.f131222b = 0L;
        this.f131223c = 0L;
        this.f131225e = 0L;
        this.f131226f = com.tencent.luggage.wxa.zp.f.CREATED;
        this.f131227g = F.getAndIncrement();
        this.f131230j = callable;
        this.f131228h = j3;
        this.f131229i = 0L;
        this.f131231k = getKey();
        int hashCode = callable.hashCode();
        this.C = hashCode;
        this.f131221a = z16;
        if (z16 && (aVar = E) != null) {
            aVar.e(this);
        }
        com.tencent.luggage.wxa.zp.d.f146812a.a(getKey(), hashCode, i(), j3 - System.nanoTime(), 0L, "", z16);
    }
}
