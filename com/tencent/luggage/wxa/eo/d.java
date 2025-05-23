package com.tencent.luggage.wxa.eo;

import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d implements com.tencent.luggage.wxa.eo.c {

    /* renamed from: a, reason: collision with root package name */
    public final ReentrantLock f124979a = new ReentrantLock();

    /* renamed from: b, reason: collision with root package name */
    public volatile e f124980b = e.INACTIVE;

    /* renamed from: c, reason: collision with root package name */
    public volatile f f124981c = null;

    /* renamed from: d, reason: collision with root package name */
    public volatile Throwable f124982d = null;

    /* renamed from: e, reason: collision with root package name */
    public volatile Throwable f124983e = null;

    /* renamed from: f, reason: collision with root package name */
    public volatile d f124984f = null;

    /* renamed from: g, reason: collision with root package name */
    public final ThreadLocal f124985g = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends ThreadLocal {
        public a() {
        }

        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C6180d initialValue() {
            return new C6180d(null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Callable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.eo.f f124987a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Class f124988b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Throwable f124989c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f124990d;

        public b(com.tencent.luggage.wxa.eo.f fVar, Class cls, Throwable th5, boolean z16) {
            this.f124987a = fVar;
            this.f124988b = cls;
            this.f124989c = th5;
            this.f124990d = z16;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            try {
                d dVar = (d) this.f124987a.b(this.f124988b);
                dVar.b(this.f124989c);
                g.a(d.this, dVar, e.INITIALIZED, false, this.f124990d, true);
                return null;
            } catch (h e16) {
                w.a("MicroMsg.FeatureService", e16, "Depended service '%s' of '%s' was not registered on current process: '%s'.", this.f124988b.getName(), d.this.getClass().getName(), com.tencent.luggage.wxa.so.d.a(z.c()));
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Callable {
        public c() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            try {
                f fVar = d.this.f124981c;
                d.this.f124979a.unlock();
                fVar.invoke();
                d.this.f124979a.lock();
                return null;
            } catch (Throwable th5) {
                d.this.f124979a.lock();
                throw th5;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum e {
        ERROR,
        INACTIVE,
        ACTIVATED,
        INITIALIZED
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f extends RecursiveAction {

        /* renamed from: a, reason: collision with root package name */
        public final Context f125001a;

        /* renamed from: b, reason: collision with root package name */
        public final com.tencent.luggage.wxa.eo.f f125002b;

        /* renamed from: c, reason: collision with root package name */
        public final ForkJoinPool f125003c;

        /* renamed from: d, reason: collision with root package name */
        public final d f125004d;

        /* renamed from: e, reason: collision with root package name */
        public final e f125005e;

        /* renamed from: f, reason: collision with root package name */
        public final e f125006f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f125007g;

        /* renamed from: h, reason: collision with root package name */
        public volatile c f125008h = null;

        /* renamed from: i, reason: collision with root package name */
        public final Runnable f125009i = new b();

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Callable {
            public a() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() {
                boolean z16;
                synchronized (f.this) {
                    if (f.this.f125008h != null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                }
                if (z16) {
                    f.this.join();
                    return null;
                }
                f.this.invoke();
                return null;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.invoke();
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class c extends RecursiveAction {
            public c() {
            }

            @Override // java.util.concurrent.RecursiveAction
            public void compute() {
                boolean z16;
                try {
                    f fVar = f.this;
                    w.d("MicroMsg.FeatureService", "[+] feature_service_transit_start: '%s'(%s => %s) of '%s' was invoked on thread: %s(%s)", fVar, fVar.f125005e, f.this.f125006f, d.this, Thread.currentThread().getName(), Integer.valueOf(Process.myTid()));
                    if (f.this.f125005e == f.this.f125006f) {
                        f fVar2 = f.this;
                        w.d("MicroMsg.FeatureService", "[+] feature_service_transit_end: '%s'(%s => %s) of '%s' was invoked on thread: %s(%s)", fVar2, fVar2.f125005e, f.this.f125006f, d.this, Thread.currentThread().getName(), Integer.valueOf(Process.myTid()));
                        return;
                    }
                    if (f.this.f125005e != e.INACTIVE) {
                        e eVar = f.this.f125005e;
                        e eVar2 = e.ACTIVATED;
                        if (eVar == eVar2) {
                            if (f.this.f125006f == e.INITIALIZED) {
                                f.this.d();
                                z16 = false;
                            }
                            z16 = true;
                        } else if (f.this.f125005e == e.INITIALIZED) {
                            if (f.this.f125006f == eVar2) {
                                f.this.e();
                                z16 = false;
                            }
                            z16 = true;
                        } else {
                            throw new IllegalStateException("Illegal from-status: " + f.this.f125005e);
                        }
                    } else {
                        if (f.this.f125006f == e.ACTIVATED) {
                            f.this.c();
                        } else {
                            if (f.this.f125006f == e.INITIALIZED) {
                                f.this.c();
                                f.this.d();
                            }
                            z16 = true;
                        }
                        z16 = false;
                    }
                    if (!z16) {
                        f fVar3 = f.this;
                        w.d("MicroMsg.FeatureService", "[+] feature_service_transit_end: '%s'(%s => %s) of '%s' was invoked on thread: %s(%s)", fVar3, fVar3.f125005e, f.this.f125006f, d.this, Thread.currentThread().getName(), Integer.valueOf(Process.myTid()));
                        return;
                    }
                    throw new IllegalStateException(String.format("Found bad route: %s => %s", f.this.f125005e, f.this.f125006f));
                } catch (Throwable th5) {
                    f fVar4 = f.this;
                    w.d("MicroMsg.FeatureService", "[+] feature_service_transit_end: '%s'(%s => %s) of '%s' was invoked on thread: %s(%s)", fVar4, fVar4.f125005e, f.this.f125006f, d.this, Thread.currentThread().getName(), Integer.valueOf(Process.myTid()));
                    throw th5;
                }
            }

            public /* synthetic */ c(f fVar, a aVar) {
                this();
            }
        }

        public f(Context context, com.tencent.luggage.wxa.eo.f fVar, ForkJoinPool forkJoinPool, d dVar, e eVar, e eVar2, boolean z16) {
            this.f125001a = context;
            this.f125002b = fVar;
            this.f125003c = forkJoinPool;
            this.f125004d = dVar;
            this.f125005e = eVar;
            this.f125006f = eVar2;
            this.f125007g = z16;
        }

        @Override // java.util.concurrent.RecursiveAction
        public void compute() {
            boolean z16 = true;
            if (this.f125008h == null) {
                synchronized (this) {
                    if (this.f125008h == null) {
                        this.f125008h = new c(this, null);
                        z16 = false;
                    }
                }
            }
            if (z16) {
                this.f125008h.join();
            } else {
                this.f125008h.invoke();
            }
        }

        public Runnable a() {
            return this.f125009i;
        }

        public final void b() {
            try {
                d.this.f124979a.lock();
                if (d.this.f124981c != null) {
                    if (d.this.f124981c.f125006f == this.f125005e) {
                        d.this.a0();
                    }
                    d.this.f124981c = null;
                }
            } finally {
                d.this.f124979a.unlock();
            }
        }

        public final void c() {
            d.this.e(this.f125004d);
            d.this.d(this.f125004d);
            d.this.a(this.f125002b, this.f125003c, this.f125007g);
            d.this.k(this.f125001a);
        }

        public final void d() {
            if (g.j() && !g.k()) {
                d.this.i(this.f125001a);
            } else {
                b();
            }
        }

        public final void e() {
            if (g.j()) {
                d.this.j(this.f125001a);
            } else {
                b();
            }
        }

        public void f() {
            g.b(new a());
        }
    }

    public final Throwable G() {
        try {
            this.f124979a.lock();
            return this.f124983e;
        } finally {
            this.f124979a.unlock();
        }
    }

    public final e Y() {
        a0();
        return this.f124980b;
    }

    public final e Z() {
        return this.f124980b;
    }

    public final void a0() {
        try {
            com.tencent.luggage.wxa.so.h.a("joinTransitTaskLocked: " + this);
            while (this.f124981c != null && this.f124982d == null) {
                try {
                    w.d("MicroMsg.FeatureService", "[+] '%s' was joined by '%s'", this, this.f124981c.f125004d);
                    f fVar = this.f124981c;
                    this.f124979a.unlock();
                    fVar.f();
                    this.f124979a.lock();
                } catch (Throwable th5) {
                    this.f124979a.lock();
                    throw th5;
                }
            }
            if (this.f124982d != null) {
                c(this.f124982d);
            }
        } finally {
            com.tencent.luggage.wxa.so.h.a();
        }
    }

    public final void d(d dVar) {
        try {
            this.f124979a.lock();
            this.f124984f = dVar;
        } finally {
            this.f124979a.unlock();
        }
    }

    public final d e() {
        try {
            this.f124979a.lock();
            return this.f124984f;
        } finally {
            this.f124979a.unlock();
        }
    }

    public final void i(Context context) {
        C6180d c6180d = (C6180d) this.f124985g.get();
        try {
            com.tencent.luggage.wxa.so.h.a("FS: notifyOnAccountInitialized: " + this);
            c6180d.f124994b = true;
            l(context);
            a(e.INITIALIZED, (Throwable) null);
        } finally {
            try {
            } finally {
            }
        }
    }

    public final void j(Context context) {
        C6180d c6180d = (C6180d) this.f124985g.get();
        try {
            com.tencent.luggage.wxa.so.h.a("FS: notifyOnAccountReleased: " + this);
            c6180d.f124995c = true;
            m(context);
            a(e.ACTIVATED, (Throwable) null);
        } finally {
            try {
            } finally {
            }
        }
    }

    public final void k(Context context) {
        C6180d c6180d = (C6180d) this.f124985g.get();
        try {
            com.tencent.luggage.wxa.so.h.a("FS: notifyOnCreate: " + this);
            c6180d.f124993a = true;
            n(context);
            a(e.ACTIVATED, (Throwable) null);
        } finally {
            try {
            } finally {
            }
        }
    }

    public static void c(Throwable th5) {
        throw th5;
    }

    public final void b(Throwable th5) {
        try {
            this.f124979a.lock();
            if (this.f124981c == null) {
                this.f124983e = th5;
            }
        } finally {
            this.f124979a.unlock();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.eo.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6180d {

        /* renamed from: a, reason: collision with root package name */
        public boolean f124993a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f124994b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f124995c;

        public C6180d() {
            this.f124993a = false;
            this.f124994b = false;
            this.f124995c = false;
        }

        public /* synthetic */ C6180d(a aVar) {
            this();
        }
    }

    public final void e(d dVar) {
        for (d dVar2 = dVar; dVar2 != null; dVar2 = dVar2.e()) {
            if (dVar2 == this) {
                throw new com.tencent.luggage.wxa.eo.e(String.format("circular dependency found between '%s' and '%s'", dVar, this));
            }
        }
    }

    public final void a(Throwable th5) {
        Throwable G = G();
        if (G == null) {
            c(th5);
            return;
        }
        Throwable th6 = th5;
        while (th6.getCause() != null) {
            th6 = th6.getCause();
        }
        StackTraceElement[] stackTrace = th6.getStackTrace();
        StackTraceElement[] stackTrace2 = G.getStackTrace();
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[stackTrace.length + stackTrace2.length + 1];
        System.arraycopy(stackTrace, 0, stackTraceElementArr, 0, stackTrace.length);
        stackTraceElementArr[stackTrace.length] = new StackTraceElement("________________________________Stacktraces.below.indicate.where.the.transit.task.being.submitted", "________________________________", "DividingLine", 0);
        System.arraycopy(stackTrace2, 0, stackTraceElementArr, stackTrace.length + 1, stackTrace2.length);
        th6.setStackTrace(stackTraceElementArr);
        c(th5);
    }

    public final boolean b(e eVar) {
        try {
            this.f124979a.lock();
            if (this.f124981c != null) {
                return this.f124981c.f125006f == eVar;
            }
            return Z() == eVar;
        } finally {
            this.f124979a.unlock();
        }
    }

    public final void b(e eVar, Throwable th5) {
        this.f124980b = eVar;
        this.f124982d = th5;
        if (th5 == null) {
            this.f124981c = null;
        }
    }

    public final void a(com.tencent.luggage.wxa.eo.f fVar, ForkJoinPool forkJoinPool, boolean z16) {
        com.tencent.luggage.wxa.fo.b bVar = (com.tencent.luggage.wxa.fo.b) getClass().getAnnotation(com.tencent.luggage.wxa.fo.b.class);
        if (bVar != null) {
            Class[] dependencies = bVar.dependencies();
            HashSet hashSet = new HashSet(dependencies.length);
            if (dependencies.length > 0) {
                for (Class cls : dependencies) {
                    if (!hashSet.contains(cls)) {
                        if (getClass().isAssignableFrom(cls)) {
                            w.h("MicroMsg.FeatureService", "[!] '%s' depends on itself.", getClass().getName());
                        } else {
                            hashSet.add(cls);
                        }
                    }
                }
            }
            w.d("MicroMsg.FeatureService", "[+] resolve dependencies '%s' of '%s'.", hashSet, this);
            if (hashSet.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList(hashSet.size());
            Throwable th5 = new Throwable(G());
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                arrayList.add(forkJoinPool.submit((Callable) new b(fVar, (Class) it.next(), th5, z16)));
            }
            g.a((Collection) arrayList, false);
            return;
        }
        throw new NullPointerException("Fail to get RegisterFeatureService annotation from class '" + getClass().getName() + "'");
    }

    public void l(Context context) {
    }

    public void m(Context context) {
    }

    public void n(Context context) {
    }

    public final boolean a(e eVar) {
        C6180d c6180d = (C6180d) this.f124985g.get();
        if (c6180d.f124993a && eVar == e.ACTIVATED) {
            return true;
        }
        if (c6180d.f124994b && (eVar == e.ACTIVATED || eVar == e.INITIALIZED)) {
            return true;
        }
        if (c6180d.f124995c) {
            return eVar == e.ACTIVATED || eVar == e.INITIALIZED;
        }
        return false;
    }

    public final boolean a(Context context, com.tencent.luggage.wxa.eo.f fVar, ForkJoinPool forkJoinPool, d dVar, e eVar, e eVar2, boolean z16, boolean z17, boolean z18) {
        if (a(eVar2)) {
            if (!z18) {
                return false;
            }
            throw new com.tencent.luggage.wxa.eo.e("Reentered lifecycle method of '" + this + "' when resolve '" + dVar + "'");
        }
        try {
            this.f124979a.lock();
            e Z = Z();
            if (((eVar.ordinal() <= eVar2.ordinal() && Z.ordinal() >= eVar2.ordinal()) || (eVar.ordinal() >= eVar2.ordinal() && Z.ordinal() <= eVar2.ordinal())) && eVar != e.INITIALIZED) {
                return false;
            }
            if (this.f124981c != null && !z17) {
                return false;
            }
            e Y = Y();
            if (Y == e.ERROR) {
                throw new com.tencent.luggage.wxa.eo.e("re-init error occurred feature service.", this.f124982d);
            }
            if (Y != eVar || Y == eVar2) {
                return false;
            }
            this.f124981c = new f(context, fVar, forkJoinPool, dVar, eVar, eVar2, z16);
            w.d("MicroMsg.FeatureService", "[+] Create transit task '%s' for transiting(%s => %s) of '%s', wait:%s, on_thread:%s(%s)", this.f124981c, eVar, eVar2, this, Boolean.valueOf(z17), Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()));
            if (z17) {
                if (Looper.myLooper() != null) {
                    try {
                        f fVar2 = this.f124981c;
                        this.f124979a.unlock();
                        fVar2.invoke();
                        this.f124979a.lock();
                    } catch (Throwable th5) {
                        this.f124979a.lock();
                        throw th5;
                    }
                } else {
                    g.b(new c());
                }
            } else {
                forkJoinPool.execute(this.f124981c.a());
            }
            return true;
        } finally {
            this.f124979a.unlock();
        }
    }

    public final void a(e eVar, Throwable th5) {
        try {
            this.f124979a.lock();
            b(eVar, th5);
        } finally {
            this.f124979a.unlock();
        }
    }
}
