package com.tencent.luggage.wxa.eo;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.tencent.luggage.wxa.eo.d;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g {

    /* renamed from: b, reason: collision with root package name */
    public static Application f125019b;

    /* renamed from: c, reason: collision with root package name */
    public static com.tencent.luggage.wxa.eo.f f125020c;

    /* renamed from: a, reason: collision with root package name */
    public static final int f125018a = Runtime.getRuntime().availableProcessors();

    /* renamed from: d, reason: collision with root package name */
    public static ForkJoinPool f125021d = null;

    /* renamed from: e, reason: collision with root package name */
    public static ForkJoinPool f125022e = null;

    /* renamed from: f, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.go.a[] f125023f = {null};

    /* renamed from: g, reason: collision with root package name */
    public static final boolean[] f125024g = {false};

    /* renamed from: h, reason: collision with root package name */
    public static final Set f125025h = new LinkedHashSet(64);

    /* renamed from: i, reason: collision with root package name */
    public static boolean f125026i = false;

    /* renamed from: j, reason: collision with root package name */
    public static final boolean[] f125027j = {false};

    /* renamed from: k, reason: collision with root package name */
    public static final boolean[] f125028k = {false};

    /* renamed from: l, reason: collision with root package name */
    public static boolean f125029l = false;

    /* renamed from: m, reason: collision with root package name */
    public static final boolean[] f125030m = {false};

    /* renamed from: n, reason: collision with root package name */
    public static final Handler f125031n = new Handler(Looper.getMainLooper());

    /* renamed from: o, reason: collision with root package name */
    public static final ThreadLocal f125032o = new ThreadLocal();

    /* renamed from: p, reason: collision with root package name */
    public static final Runnable f125033p = new a();

    /* renamed from: q, reason: collision with root package name */
    public static final Runnable f125034q = new b();

    /* renamed from: r, reason: collision with root package name */
    public static final Runnable f125035r = new c();

    /* renamed from: s, reason: collision with root package name */
    public static final Application.ActivityLifecycleCallbacks f125036s = new d();

    /* renamed from: t, reason: collision with root package name */
    public static final Map f125037t = new ConcurrentHashMap(64);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            synchronized (g.f125030m) {
                g.f125030m[0] = g.f125029l;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            w.d("MicroMsg.ServiceManager", "[+] Notify task for delayed ASYNC preload FeatureServices triggered.");
            if (g.j()) {
                try {
                    com.tencent.luggage.wxa.so.h.a("preloadServicesWithAsyncModeOnDemand");
                    g.f125031n.removeCallbacks(g.f125035r);
                    w.d("MicroMsg.ServiceManager", "[+] Notify ASYNC preload FeatureServices was actually executed.");
                    g.a(true, false);
                } finally {
                    g.f125031n.removeCallbacks(g.f125034q);
                    com.tencent.luggage.wxa.so.h.a();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            w.f("MicroMsg.ServiceManager", "[!] Watchdog task for delayed ASYNC preload FeatureServices triggered.");
            if (g.j()) {
                w.f("MicroMsg.ServiceManager", "[!] Watchdog task for delayed ASYNC preload FeatureServices actually post notify task.");
                g.f125031n.removeCallbacks(g.f125034q);
                g.f125031n.postAtFrontOfQueue(g.f125034q);
                g.f125019b.unregisterActivityLifecycleCallbacks(g.f125036s);
                g.f125031n.removeCallbacks(g.f125035r);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Callable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f125040a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f125041b;

        public e(Class cls, boolean z16) {
            this.f125040a = cls;
            this.f125041b = z16;
        }

        /* JADX WARN: Not initialized variable reg: 8, insn: 0x0057: MOVE (r0 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]) (LINE:88), block:B:16:0x0056 */
        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.eo.c call() {
            com.tencent.luggage.wxa.eo.d dVar;
            Object obj;
            com.tencent.luggage.wxa.eo.d dVar2;
            Object obj2 = null;
            try {
                try {
                    dVar2 = (com.tencent.luggage.wxa.eo.d) g.f125020c.b(this.f125040a);
                    dVar = (com.tencent.luggage.wxa.eo.d) g.f125032o.get();
                } catch (com.tencent.luggage.wxa.eo.h e16) {
                    e = e16;
                    dVar = null;
                } catch (Throwable th5) {
                    th = th5;
                    g.f125032o.set(obj2);
                    throw th;
                }
                try {
                    g.f125032o.set(dVar2);
                    g.a(dVar, dVar2, d.e.INITIALIZED, this.f125041b, false, false);
                    g.f125032o.set(dVar);
                    return dVar2;
                } catch (com.tencent.luggage.wxa.eo.h e17) {
                    e = e17;
                    w.a("MicroMsg.ServiceManager", e, "[-] Fail to get feature service instance of '%s'", this.f125040a.getName());
                    g.f125032o.set(dVar);
                    return null;
                }
            } catch (Throwable th6) {
                th = th6;
                obj2 = obj;
                g.f125032o.set(obj2);
                throw th;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ca.i f125042a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Throwable f125043b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d.e f125044c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f125045d;

        public f(com.tencent.luggage.wxa.ca.i iVar, Throwable th5, d.e eVar, boolean z16) {
            this.f125042a = iVar;
            this.f125043b = th5;
            this.f125044c = eVar;
            this.f125045d = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.eo.d dVar = (com.tencent.luggage.wxa.eo.d) this.f125042a.get();
            if (dVar != null) {
                dVar.b(this.f125043b);
                g.a(null, dVar, this.f125044c, true, this.f125045d, false);
                return;
            }
            throw new com.tencent.luggage.wxa.eo.e(String.format(Locale.ENGLISH, "fail to get instance from '%s'", this.f125042a));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.eo.g$g, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6181g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.eo.d f125046a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Throwable f125047b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f125048c;

        public RunnableC6181g(com.tencent.luggage.wxa.eo.d dVar, Throwable th5, boolean z16) {
            this.f125046a = dVar;
            this.f125047b = th5;
            this.f125048c = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f125046a.b(this.f125047b);
            g.a(null, this.f125046a, d.e.INITIALIZED, this.f125048c, true, false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f125049a;

        public h(boolean z16) {
            this.f125049a = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.b(this.f125049a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum i {
        INSTANCE;


        /* renamed from: a, reason: collision with root package name */
        public final byte[] f125052a = new byte[0];

        /* renamed from: b, reason: collision with root package name */
        public final List f125053b = new ArrayList(2);

        /* renamed from: c, reason: collision with root package name */
        public int f125054c = 0;

        i() {
        }

        public final Looper b() {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("wc_lp_srvinit_" + this.f125053b.size(), -8);
            baseHandlerThread.start();
            return baseHandlerThread.getLooper();
        }

        public Handler c() {
            synchronized (this.f125052a) {
                if (this.f125053b.size() < 2) {
                    Handler handler = new Handler(b());
                    this.f125053b.add(handler);
                    return handler;
                }
                if (this.f125054c >= this.f125053b.size()) {
                    this.f125054c = 0;
                }
                List list = this.f125053b;
                int i3 = this.f125054c;
                this.f125054c = i3 + 1;
                return (Handler) list.get(i3);
            }
        }

        public Looper d() {
            return c().getLooper();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum j implements ForkJoinPool.ForkJoinWorkerThreadFactory {
        INSTANCE;


        /* renamed from: a, reason: collision with root package name */
        public final Field f125057a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicInteger f125058b = new AtomicInteger(0);

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a extends ForkJoinWorkerThread {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ForkJoinPool f125059a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(ForkJoinPool forkJoinPool, ForkJoinPool forkJoinPool2) {
                super(forkJoinPool);
                this.f125059a = forkJoinPool2;
            }

            @Override // java.util.concurrent.ForkJoinWorkerThread
            public void onStart() {
                super.onStart();
                if (j.this.f125057a != null) {
                    Looper d16 = i.INSTANCE.d();
                    try {
                        ThreadLocal threadLocal = (ThreadLocal) j.this.f125057a.get(null);
                        if (threadLocal == null) {
                            threadLocal = new ThreadLocal();
                            j.this.f125057a.set(null, threadLocal);
                        }
                        threadLocal.set(d16);
                    } catch (Throwable th5) {
                        w.a("MicroMsg.ServiceManager", th5, "Fail to set Looper to init thread.", new Object[0]);
                    }
                }
                w.d("MicroMsg.ServiceManager", "[+] FJPThread, tid: %s, name: %s, java_tid: %s, priority: %s, alive_thread_count: %s", Integer.valueOf(Process.myTid()), getName(), Long.valueOf(getId()), Integer.valueOf(getPriority()), Integer.valueOf(this.f125059a.getActiveThreadCount()));
            }
        }

        j() {
            Field field;
            try {
                field = Looper.class.getDeclaredField("sThreadLocal");
                field.setAccessible(true);
            } catch (Throwable th5) {
                w.a("MicroMsg.ServiceManager", th5, "Fail to get Looper TLS field.", new Object[0]);
                field = null;
            }
            this.f125057a = field;
        }

        @Override // java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory
        public ForkJoinWorkerThread newThread(ForkJoinPool forkJoinPool) {
            int andIncrement = this.f125058b.getAndIncrement();
            a aVar = new a(forkJoinPool, forkJoinPool);
            aVar.setName("wc_srvinit_" + andIncrement);
            aVar.setPriority(6);
            return aVar;
        }
    }

    public static boolean j() {
        boolean a16;
        a("isAccountInitialized");
        com.tencent.luggage.wxa.go.a[] aVarArr = f125023f;
        synchronized (aVarArr) {
            a16 = aVarArr[0].a();
        }
        return a16;
    }

    public static boolean k() {
        boolean z16;
        boolean[] zArr = f125028k;
        synchronized (zArr) {
            z16 = zArr[0];
        }
        return z16;
    }

    public static boolean l() {
        boolean b16;
        a("isAccountInitialized");
        com.tencent.luggage.wxa.go.a[] aVarArr = f125023f;
        synchronized (aVarArr) {
            b16 = aVarArr[0].b();
        }
        return b16;
    }

    public static boolean m() {
        boolean z16;
        synchronized (f125025h) {
            z16 = f125026i;
        }
        return z16;
    }

    public static boolean n() {
        boolean z16;
        boolean[] zArr = f125030m;
        synchronized (zArr) {
            z16 = zArr[0];
        }
        return z16;
    }

    public static void o() {
        boolean[] zArr = f125028k;
        synchronized (zArr) {
            zArr[0] = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object b(Callable callable) {
        ThreadLocal threadLocal;
        ThreadLocal threadLocal2;
        if (Looper.myLooper() == null) {
            Field field = j.INSTANCE.f125057a;
            if (field == null) {
                w.b("MicroMsg.ServiceManager", "[-] Fail to get Looper TLS field at last, invoke action without looper.");
                return a(callable);
            }
            try {
                threadLocal = (ThreadLocal) field.get(null);
                if (threadLocal == null) {
                    try {
                        threadLocal2 = new ThreadLocal();
                        try {
                            field.set(null, threadLocal2);
                            threadLocal = threadLocal2;
                        } catch (Throwable th5) {
                            th = th5;
                            try {
                                w.a("MicroMsg.ServiceManager", th, "[-] Fail to inject companion Looper.", new Object[0]);
                                threadLocal = null;
                                Object a16 = a(callable);
                                if (threadLocal != null) {
                                }
                                return a16;
                            } catch (Throwable th6) {
                                th = th6;
                                if (threadLocal2 != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        threadLocal2 = threadLocal;
                        w.a("MicroMsg.ServiceManager", th, "[-] Fail to inject companion Looper.", new Object[0]);
                        threadLocal = null;
                        Object a162 = a(callable);
                        if (threadLocal != null) {
                        }
                        return a162;
                    }
                }
                threadLocal.set(i.INSTANCE.d());
            } catch (Throwable th8) {
                th = th8;
                threadLocal = null;
            }
            try {
                Object a1622 = a(callable);
                if (threadLocal != null) {
                    threadLocal.set(null);
                }
                return a1622;
            } catch (Throwable th9) {
                th = th9;
                threadLocal2 = threadLocal;
                if (threadLocal2 != null) {
                    threadLocal2.set(null);
                }
                throw th;
            }
        }
        return a(callable);
    }

    public static void a(Application application, com.tencent.luggage.wxa.eo.f fVar, com.tencent.luggage.wxa.go.a aVar) {
        boolean[] zArr = f125024g;
        synchronized (zArr) {
            if (!zArr[0]) {
                f125019b = application;
                Objects.requireNonNull(fVar);
                f125020c = fVar;
                j jVar = j.INSTANCE;
                f125021d = new ForkJoinPool(6, jVar, null, false);
                f125022e = new ForkJoinPool(6, jVar, null, false);
                com.tencent.luggage.wxa.go.a[] aVarArr = f125023f;
                synchronized (aVarArr) {
                    aVarArr[0] = aVar;
                }
                if (com.tencent.luggage.wxa.z8.c.a(f125019b) == com.tencent.luggage.wxa.z8.c.f146390e) {
                    application.registerActivityLifecycleCallbacks(f125036s);
                    f125031n.post(f125033p);
                }
                zArr[0] = true;
            } else {
                w.f("MicroMsg.ServiceManager", "Already initialized.");
            }
        }
    }

    public static void b(boolean z16) {
        a("calling preloadServicesWithAsyncMode()");
        boolean[] zArr = f125027j;
        if (zArr[0]) {
            return;
        }
        synchronized (zArr) {
            if (zArr[0]) {
                return;
            }
            zArr[0] = true;
            a(f125020c.b(com.tencent.luggage.wxa.fo.a.ASYNC), d.e.INITIALIZED, z16, false);
        }
    }

    public static void a(Throwable th5) {
        throw th5;
    }

    public static Object a(Callable callable) {
        try {
            return callable.call();
        } catch (Throwable th5) {
            a(th5);
            return null;
        }
    }

    public static void a(String str) {
        boolean[] zArr = f125024g;
        if (zArr[0]) {
            return;
        }
        synchronized (zArr) {
            if (!zArr[0]) {
                throw new IllegalStateException("please call initialize(...) first before " + str);
            }
        }
    }

    public static boolean b(Class cls) {
        boolean z16;
        Boolean bool = (Boolean) f125037t.get(cls);
        if (bool == null) {
            Iterator it = com.tencent.luggage.wxa.ca.b.a(cls).a().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z16 = false;
                    break;
                }
                if (com.tencent.luggage.wxa.ca.b.c(f125019b, (com.tencent.luggage.wxa.ca.i) it.next())) {
                    z16 = true;
                    break;
                }
            }
            f125037t.put(cls, Boolean.valueOf(z16));
            bool = Boolean.valueOf(z16);
        }
        return bool.booleanValue();
    }

    public static com.tencent.luggage.wxa.eo.c a(Class cls) {
        return a(cls, false);
    }

    public static com.tencent.luggage.wxa.eo.c a(Class cls, boolean z16) {
        a("calling getService(...)");
        return (com.tencent.luggage.wxa.eo.c) b(new e(cls, z16));
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Application.ActivityLifecycleCallbacks {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements ViewTreeObserver.OnGlobalLayoutListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f125038a;

            public a(View view) {
                this.f125038a = view;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                w.d("MicroMsg.ServiceManager", "[+] onGlobalLayout called.");
                this.f125038a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (g.j()) {
                    g.f125031n.removeCallbacks(g.f125035r);
                    g.f125031n.removeCallbacks(g.f125034q);
                    g.f125031n.postAtFrontOfQueue(g.f125034q);
                    g.f125019b.unregisterActivityLifecycleCallbacks(g.f125036s);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            boolean unused = g.f125029l = true;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            View decorView;
            if (com.tencent.luggage.wxa.z8.c.a(g.f125019b) != com.tencent.luggage.wxa.z8.c.f146390e) {
                return;
            }
            if (!g.j()) {
                w.h("MicroMsg.ServiceManager", "not login, don't regard this ui '%s' as first screen, skip notify this time.", activity);
                return;
            }
            Window window = activity.getWindow();
            if (window == null) {
                w.b("MicroMsg.ServiceManager", "fail to get window of '%s', notify account init now.", activity);
                decorView = null;
            } else {
                decorView = window.getDecorView();
                if (decorView == null) {
                    w.b("MicroMsg.ServiceManager", "fail to get decor view of '%s', notify account init now.", activity);
                }
            }
            if (decorView != null) {
                if (decorView.getViewTreeObserver() != null) {
                    decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(decorView));
                    return;
                } else {
                    w.b("MicroMsg.ServiceManager", "fail to get view tree observer of '%s', notify account init now.", activity);
                    g.f125031n.postAtFrontOfQueue(g.f125034q);
                    return;
                }
            }
            g.f125031n.postAtFrontOfQueue(g.f125034q);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }

    public static void a(com.tencent.luggage.wxa.eo.d dVar, com.tencent.luggage.wxa.eo.d dVar2, d.e eVar, boolean z16, boolean z17, boolean z18) {
        boolean z19;
        d.e eVar2;
        Application application = f125019b;
        com.tencent.luggage.wxa.eo.f fVar = f125020c;
        ForkJoinPool forkJoinPool = f125021d;
        d.e eVar3 = d.e.INACTIVE;
        d.e eVar4 = d.e.ACTIVATED;
        if (dVar2.a(application, fVar, forkJoinPool, dVar, eVar3, eVar4, z17, true, z18)) {
            Set set = f125025h;
            synchronized (set) {
                set.add(dVar2);
            }
        }
        if (k()) {
            z19 = false;
        } else if (z17) {
            z19 = j();
        } else {
            z19 = m();
        }
        if (z19) {
            dVar2.a(f125019b, f125020c, f125022e, dVar, eVar4, eVar, z17, z16, z18);
        } else {
            if (!k() || eVar == (eVar2 = d.e.INITIALIZED)) {
                return;
            }
            dVar2.a(f125019b, f125020c, f125021d, dVar, eVar2, eVar, z17, z16, z18);
        }
    }

    public static void a(Future future) {
        try {
            future.get();
        } catch (Throwable th5) {
            th = th5;
            Throwable cause = th.getCause();
            while ((cause instanceof ExecutionException) && cause.getCause() != null) {
                cause = cause.getCause();
            }
            if (cause != null) {
                th = cause;
            }
            a(th);
        }
    }

    public static void a(Collection collection, boolean z16) {
        if (z16) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                a((Future) it.next());
            }
            return;
        }
        Iterator it5 = collection.iterator();
        while (it5.hasNext()) {
            Future future = (Future) it5.next();
            while (true) {
                try {
                    a(future);
                    break;
                } catch (Throwable th5) {
                    if (!(th5 instanceof InterruptedException)) {
                        a(th5);
                    }
                }
            }
        }
    }

    public static void a(Iterable iterable, d.e eVar, boolean z16, boolean z17) {
        w.d("MicroMsg.ServiceManager", "[+] preload feature service: '%s', dest_status: %s, wait: %s, callAccountInitNowIfPossible: %s", iterable, eVar, Boolean.valueOf(z16), Boolean.valueOf(z17));
        Throwable th5 = new Throwable();
        ArrayList arrayList = new ArrayList(512);
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            f fVar = new f((com.tencent.luggage.wxa.ca.i) it.next(), th5, eVar, z17);
            if (z16) {
                arrayList.add(f125021d.submit((Runnable) fVar));
            } else {
                f125022e.execute(fVar);
            }
        }
        if (z16) {
            a((Collection) arrayList, true);
        }
    }

    public static void a(boolean z16, boolean z17) {
        a("calling initializeAccountForActivatedServices()");
        try {
            com.tencent.luggage.wxa.so.h.a("initializeAccountForActivatedServices(" + z16 + "," + z17 + ")");
            o();
            if (!z16 && (l() || n())) {
                w.d("MicroMsg.ServiceManager", "[+] initializeAccountForActivatedServices(%s,%s), delay actual works to stage after first screen or 5s later.", Boolean.valueOf(z16), Boolean.valueOf(z17));
                Handler handler = f125031n;
                Runnable runnable = f125035r;
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 5000L);
                w.d("MicroMsg.ServiceManager", "[+] ASYNC preload onAccountInitialized() watchdog task posted.");
                return;
            }
            if (f125026i) {
                return;
            }
            Throwable th5 = new Throwable();
            ArrayList arrayList = new ArrayList(128);
            Set set = f125025h;
            synchronized (set) {
                if (f125026i) {
                    return;
                }
                f125026i = true;
                Iterator it = set.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.tencent.luggage.wxa.eo.d dVar = (com.tencent.luggage.wxa.eo.d) it.next();
                    if (k()) {
                        w.f("MicroMsg.ServiceManager", "[-] account release was notified, skip notifying account init for rest services.");
                        break;
                    } else if (!dVar.b(d.e.INITIALIZED)) {
                        RunnableC6181g runnableC6181g = new RunnableC6181g(dVar, th5, z17);
                        if (z17) {
                            arrayList.add(f125022e.submit((Runnable) runnableC6181g));
                        } else {
                            runnableC6181g.run();
                        }
                    }
                }
                h hVar = new h(z17);
                if (z17) {
                    arrayList.add(f125022e.submit((Runnable) hVar));
                } else {
                    hVar.run();
                }
                if (z17) {
                    a((Collection) arrayList, true);
                }
                w.d("MicroMsg.ServiceManager", "[+] initializeAccountForActivatedServices actually executed.");
            }
        } finally {
            com.tencent.luggage.wxa.so.h.a();
        }
    }
}
