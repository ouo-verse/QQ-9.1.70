package com.tencent.qmethod.pandoraex.api;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.core.collector.CollectorCore;
import com.tencent.qmethod.pandoraex.monitor.SilentCallMonitor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f343925a = false;

    /* renamed from: b, reason: collision with root package name */
    private static Context f343926b = null;

    /* renamed from: c, reason: collision with root package name */
    private static j f343927c = null;

    /* renamed from: d, reason: collision with root package name */
    private static n f343928d = null;

    /* renamed from: e, reason: collision with root package name */
    private static o f343929e = null;

    /* renamed from: f, reason: collision with root package name */
    private static f f343930f = null;

    /* renamed from: g, reason: collision with root package name */
    private static k f343931g = null;

    /* renamed from: h, reason: collision with root package name */
    private static m f343932h = null;

    /* renamed from: i, reason: collision with root package name */
    private static String f343933i = "";

    /* renamed from: j, reason: collision with root package name */
    private static boolean f343934j = false;

    /* renamed from: k, reason: collision with root package name */
    private static int f343935k = 100;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f343936l = false;

    /* renamed from: m, reason: collision with root package name */
    private static final AtomicBoolean f343937m = new AtomicBoolean(false);

    /* renamed from: n, reason: collision with root package name */
    private static boolean f343938n = false;

    /* renamed from: o, reason: collision with root package name */
    private static boolean f343939o = false;

    /* renamed from: p, reason: collision with root package name */
    static boolean f343940p = false;

    public static f a() {
        return f343930f;
    }

    public static Context b() {
        return f343926b;
    }

    public static int c() {
        return f343935k;
    }

    public static boolean d() {
        return f343939o;
    }

    public static j e() {
        return f343927c;
    }

    public static String f() {
        return f343933i;
    }

    public static k g() {
        return f343931g;
    }

    public static m h() {
        return f343932h;
    }

    public static boolean i() {
        return f343936l;
    }

    public static n j() {
        return f343928d;
    }

    public static o k() {
        return f343929e;
    }

    public static boolean l(a aVar) {
        AtomicBoolean atomicBoolean = f343937m;
        if (atomicBoolean.compareAndSet(false, true)) {
            if (aVar.f343941a == null) {
                atomicBoolean.set(false);
                return false;
            }
            f343926b = aVar.f343941a;
            f343927c = aVar.f343942b;
            f343928d = aVar.f343943c;
            f343929e = aVar.f343944d;
            f343930f = aVar.f343945e;
            f343934j = aVar.f343949i;
            f343936l = aVar.f343950j;
            f343931g = aVar.f343946f;
            f343932h = aVar.f343947g;
            f343935k = aVar.f343955o;
            f343933i = f343926b.getPackageName();
            f343939o = aVar.f343954n;
            a.d(aVar);
            aVar.getClass();
            if (aVar.f343951k) {
                if (!TextUtils.isEmpty(aVar.f343952l)) {
                    r.u(f343926b, aVar.f343953m, aVar.f343952l);
                } else {
                    r.t(f343926b, aVar.f343953m);
                }
            }
            if (aVar.f343948h != null) {
                r.s(aVar.f343948h);
            }
            if (!aVar.f343957q) {
                new CollectorCore(f343926b).g();
            }
            com.tencent.qmethod.pandoraex.core.a.e();
            long nanoTime = System.nanoTime();
            if (aVar.f343956p != null) {
                com.tencent.qmethod.pandoraex.core.f.c(aVar.f343956p);
            }
            f343927c.d("TraceUtil", "config cost = " + ((System.nanoTime() - nanoTime) / 1000000.0d));
        }
        return true;
    }

    public static boolean m() {
        return f343940p;
    }

    public static boolean n() {
        return false;
    }

    public static void o() {
        com.tencent.qmethod.pandoraex.core.c.d();
        SilentCallMonitor.clearUserInteractionTime();
        com.tencent.qmethod.pandoraex.core.o.a("PandoraEx", "PandoraEx is onApplicationBackground");
    }

    public static void p() {
        com.tencent.qmethod.pandoraex.core.c.a();
        SilentCallMonitor.onApplicationForeground();
        com.tencent.qmethod.pandoraex.core.o.a("PandoraEx", "PandoraEx is onApplicationForeground");
    }

    public static void q(boolean z16) {
        com.tencent.qmethod.pandoraex.core.s.c(z16);
    }

    public static void r(boolean z16) {
        f343940p = z16;
    }

    public static void s(Boolean bool) {
        f343939o = bool.booleanValue();
    }

    public static boolean t() {
        boolean g16 = com.tencent.qmethod.pandoraex.core.m.g(f343926b);
        f343938n = g16;
        return g16;
    }

    public static void u(k kVar) {
        f343931g = kVar;
    }

    public static boolean v(b bVar) {
        return com.tencent.qmethod.pandoraex.core.f.d(bVar);
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Context f343941a;

        /* renamed from: b, reason: collision with root package name */
        private j f343942b;

        /* renamed from: c, reason: collision with root package name */
        private n f343943c;

        /* renamed from: d, reason: collision with root package name */
        private o f343944d;

        /* renamed from: e, reason: collision with root package name */
        private f f343945e;

        /* renamed from: f, reason: collision with root package name */
        private k f343946f;

        /* renamed from: g, reason: collision with root package name */
        private m f343947g;

        /* renamed from: h, reason: collision with root package name */
        private g f343948h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f343949i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f343950j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f343951k;

        /* renamed from: l, reason: collision with root package name */
        private String f343952l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f343953m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f343954n;

        /* renamed from: p, reason: collision with root package name */
        private Constant$DefaultConfig f343956p;

        /* renamed from: o, reason: collision with root package name */
        private int f343955o = 100;

        /* renamed from: q, reason: collision with root package name */
        private boolean f343957q = false;

        public a(Context context) {
            this.f343941a = context;
        }

        static /* synthetic */ i d(a aVar) {
            aVar.getClass();
            return null;
        }

        public a A(g gVar) {
            this.f343948h = gVar;
            return this;
        }

        public a C(String str) {
            this.f343952l = str;
            return this;
        }

        public a D(boolean z16) {
            this.f343951k = true;
            this.f343953m = z16;
            return this;
        }

        public a E(o oVar) {
            this.f343944d = oVar;
            return this;
        }

        public a s(f fVar) {
            this.f343945e = fVar;
            return this;
        }

        public a t(int i3) {
            this.f343955o = i3;
            return this;
        }

        public a u(boolean z16) {
            this.f343957q = z16;
            return this;
        }

        public a v(boolean z16) {
            this.f343949i = z16;
            return this;
        }

        public a w(boolean z16) {
            this.f343950j = z16;
            return this;
        }

        public a x(j jVar) {
            this.f343942b = jVar;
            return this;
        }

        public a y(m mVar) {
            this.f343947g = mVar;
            return this;
        }

        public a z(n nVar) {
            this.f343943c = nVar;
            return this;
        }

        @NotNull
        public a B(@Nullable i iVar) {
            return this;
        }
    }
}
