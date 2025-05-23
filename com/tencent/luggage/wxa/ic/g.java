package com.tencent.luggage.wxa.ic;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.util.Log;
import android.util.Printer;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.kj.h1;
import com.tencent.luggage.wxa.kj.i1;
import com.tencent.luggage.wxa.kj.k1;
import com.tencent.luggage.wxa.kj.p;
import com.tencent.luggage.wxa.qc.c;
import com.tencent.luggage.wxa.tn.e0;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.vj.f;
import com.tencent.luggage.wxa.wj.c;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.WxaIconTransformation;
import com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.joor.Reflect;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g implements com.tencent.luggage.wxa.uk.s, com.tencent.luggage.wxa.yi.g {
    public final com.tencent.luggage.wxa.ka.u A0;
    public final com.tencent.luggage.wxa.ka.v B0;
    public boolean C;
    public final com.tencent.luggage.wxa.tn.e0 C0;
    public com.tencent.luggage.wxa.ml.g D;
    public final Deque D0;
    public com.tencent.luggage.wxa.ml.g E;
    public final com.tencent.luggage.wxa.ln.a E0;
    public com.tencent.luggage.wxa.ml.g F;
    public SparseArray F0;
    public com.tencent.luggage.wxa.lj.e G;
    public com.tencent.luggage.wxa.uk.j0 G0;
    public volatile boolean H;
    public com.tencent.luggage.wxa.il.n H0;
    public final com.tencent.luggage.wxa.rc.r[] I;
    public AtomicBoolean J;
    public final ConcurrentLinkedDeque K;
    public final k0 L;
    public final ConcurrentSkipListSet M;
    public final l0 N;
    public final ConcurrentSkipListSet O;
    public final ConcurrentSkipListSet P;
    public final LinkedHashSet Q;
    public final com.tencent.luggage.wxa.ic.r R;
    public com.tencent.luggage.wxa.uk.i S;
    public volatile com.tencent.luggage.wxa.qc.c T;
    public volatile LifecycleOwner U;
    public volatile LifecycleScope V;
    public com.tencent.luggage.wxa.xi.a W;
    public volatile boolean X;
    public volatile boolean Y;
    public volatile boolean Z;

    /* renamed from: a, reason: collision with root package name */
    public final Context f129749a;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f129750a0;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.ic.v f129751b;

    /* renamed from: b0, reason: collision with root package name */
    public final AtomicBoolean f129752b0;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.wj.c f129753c;

    /* renamed from: c0, reason: collision with root package name */
    public final com.tencent.luggage.wxa.h6.b f129754c0;

    /* renamed from: d, reason: collision with root package name */
    public final p0 f129755d;

    /* renamed from: d0, reason: collision with root package name */
    public Runnable f129756d0;

    /* renamed from: e, reason: collision with root package name */
    public final Printer f129757e;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f129758e0;

    /* renamed from: f, reason: collision with root package name */
    public final q0 f129759f;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f129760f0;

    /* renamed from: g, reason: collision with root package name */
    public volatile String f129761g;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f129762g0;

    /* renamed from: h, reason: collision with root package name */
    public g f129763h;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f129764h0;

    /* renamed from: i, reason: collision with root package name */
    public volatile com.tencent.luggage.wxa.fd.i f129765i;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f129766i0;

    /* renamed from: j, reason: collision with root package name */
    public volatile com.tencent.luggage.wxa.ic.l f129767j;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f129768j0;

    /* renamed from: k, reason: collision with root package name */
    public volatile com.tencent.luggage.wxa.kj.p f129769k;

    /* renamed from: k0, reason: collision with root package name */
    public long f129770k0;

    /* renamed from: l, reason: collision with root package name */
    public com.tencent.luggage.wxa.il.g f129771l;

    /* renamed from: l0, reason: collision with root package name */
    public long f129772l0;

    /* renamed from: m, reason: collision with root package name */
    public com.tencent.luggage.wxa.ok.j f129773m;

    /* renamed from: m0, reason: collision with root package name */
    public com.tencent.luggage.wxa.vj.f f129774m0;

    /* renamed from: n0, reason: collision with root package name */
    public com.tencent.luggage.wxa.il.e f129775n0;

    /* renamed from: o0, reason: collision with root package name */
    public com.tencent.luggage.wxa.kj.f f129776o0;

    /* renamed from: p0, reason: collision with root package name */
    public JSONArray f129777p0;

    /* renamed from: q0, reason: collision with root package name */
    public JSONArray f129778q0;

    /* renamed from: r0, reason: collision with root package name */
    public JSONArray f129779r0;

    /* renamed from: s0, reason: collision with root package name */
    public JSONArray f129780s0;

    /* renamed from: t0, reason: collision with root package name */
    public JSONObject f129781t0;

    /* renamed from: u0, reason: collision with root package name */
    public JSONObject f129782u0;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f129783v0;

    /* renamed from: w0, reason: collision with root package name */
    public int f129784w0;

    /* renamed from: x0, reason: collision with root package name */
    public LinkedList f129785x0;

    /* renamed from: y0, reason: collision with root package name */
    public ConcurrentLinkedQueue f129786y0;

    /* renamed from: z0, reason: collision with root package name */
    public ExecutorService f129787z0;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.this.t0()) {
                return;
            }
            if (g.this.r0()) {
                g.this.E0.b();
            }
            g.this.p1();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            gVar.f129769k = gVar.t();
            g.this.f129769k.setOnReadyListener(new p.j0() { // from class: com.tencent.luggage.wxa.ic.am
                @Override // com.tencent.luggage.wxa.kj.p.j0
                public final void a() {
                    g.b.this.a();
                }
            });
            g.this.f129769k.setPageDidPushInCallback(new p.k0() { // from class: com.tencent.luggage.wxa.ic.an
                @Override // com.tencent.luggage.wxa.kj.p.k0
                public final void a(com.tencent.luggage.wxa.kj.n nVar, k1 k1Var) {
                    g.b.this.a(nVar, k1Var);
                }
            });
            o0 o0Var = o0.AppBrandPageContainer;
            g gVar2 = g.this;
            o0Var.a(gVar2, gVar2.f129769k);
            g.this.f129769k.h(g.this.f129765i.f125813f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            g.this.i1();
            g.this.a((Configuration) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(com.tencent.luggage.wxa.kj.n nVar, k1 k1Var) {
            if (k1.APP_LAUNCH == k1Var) {
                g.this.E0.b();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.gi.b.c(g.this.getAppId(), com.tencent.luggage.wxa.ik.a.f130645z);
            com.tencent.luggage.wxa.gi.b.c(g.this.getAppId(), com.tencent.luggage.wxa.ik.a.P);
            g.this.f129767j.p();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Runnable {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.p0();
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.Y = true;
                g.this.T0();
                LinkedList linkedList = new LinkedList(g.this.M);
                g.this.M.clear();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ((g0) it.next()).a();
                }
            }
        }

        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = new a();
            if (!g.this.f(aVar)) {
                aVar.run();
            }
            com.tencent.luggage.wxa.e5.g.a("onReady", new b());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.a((com.tencent.luggage.wxa.fd.i) null, "performServiceReconnected");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f129795a;

        public f(int i3) {
            this.f129795a = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.this.f129751b == null) {
                g.this.a(this.f129795a);
            } else {
                g.this.f129751b.c(g.this);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ic.g$g, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6296g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f129797a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f129798b;

        public RunnableC6296g(Runnable runnable, Object obj) {
            this.f129797a = runnable;
            this.f129798b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.h6.h.a(g.this.L());
            if (g.this.s0() && !g.this.t0()) {
                if (g.this.f129751b != null && g.this.f129751b.b(g.this)) {
                    g.this.f129751b.a(g.this, this.f129798b, this.f129797a);
                    return;
                }
                g.this.y();
                Runnable runnable = this.f129797a;
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            }
            if (g.this.f129751b == null) {
                g.this.a(1);
            } else {
                g.this.f129751b.c(g.this);
            }
            Runnable runnable2 = this.f129797a;
            if (runnable2 != null) {
                runnable2.run();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements com.tencent.luggage.wxa.ka.u {
        public h() {
        }

        @Override // com.tencent.luggage.wxa.ka.u
        public void a() {
            g.this.J.set(true);
            g.this.W0();
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "onDisconnect: appId=[%s]", g.this.getAppId());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i implements com.tencent.luggage.wxa.ka.v {
        public i() {
        }

        @Override // com.tencent.luggage.wxa.ka.v
        public void a() {
            if (g.this.J.getAndSet(false)) {
                g.this.b1();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class j implements e0.a {
        public j() {
        }

        @Override // com.tencent.luggage.wxa.tn.e0.a
        public boolean a() {
            g.this.a("onResourcePrepareTimeout", new Object[0]);
            g.this.U0();
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class k extends ConcurrentLinkedDeque {
        public k() {
        }

        @Override // java.util.concurrent.ConcurrentLinkedDeque, java.util.AbstractCollection, java.util.Collection, java.util.Deque, java.util.Queue
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(com.tencent.luggage.wxa.xd.l lVar) {
            boolean add = super.add(lVar);
            if (lVar instanceof com.tencent.luggage.wxa.fd.q) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "mConfigs.add(AppBrandSysConfig[%s]) appId[%s], ret[%b]", lVar.getClass().getName(), g.this.getAppId(), Boolean.valueOf(add));
                com.tencent.luggage.wxa.mc.k0.a(g.this, true);
            }
            return add;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class l implements Runnable {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a extends AppBrandSimpleImageLoader.f {

            /* renamed from: a, reason: collision with root package name */
            public final com.tencent.luggage.wxa.vo.a f129805a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.wj.c f129806b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ c.a f129807c;

            public a(com.tencent.luggage.wxa.wj.c cVar, c.a aVar) {
                this.f129806b = cVar;
                this.f129807c = aVar;
                g gVar = g.this;
                com.tencent.luggage.wxa.vo.a aVar2 = new com.tencent.luggage.wxa.vo.a() { // from class: com.tencent.luggage.wxa.ic.ao
                    @Override // com.tencent.luggage.wxa.vo.a
                    public final void g() {
                        AppBrandSimpleImageLoader.instance().cancel(AppBrandSimpleImageLoader.m.this);
                    }
                };
                this.f129805a = aVar2;
                gVar.b(aVar2);
            }

            @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.f, com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
            public void a(Bitmap bitmap) {
                this.f129806b.setWindowDescription(new c.a(this.f129807c.c(), bitmap, this.f129807c.d()));
                g.this.a(this.f129805a);
            }
        }

        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a aVar;
            com.tencent.luggage.wxa.wj.c n06 = g.this.n0();
            if (n06 == null) {
                return;
            }
            com.tencent.luggage.wxa.fd.b E = g.this.E();
            if (E == null) {
                aVar = new c.a(g.this.S().f125809b);
            } else {
                aVar = new c.a(g.this.S().f125809b, null, com.tencent.luggage.wxa.tk.g.a(E.b().f125685e, -16777216));
            }
            n06.setWindowDescription(aVar);
            AppBrandSimpleImageLoader.instance().load(new a(n06, aVar), g.this.S().f125810c, WxaIconTransformation.INSTANCE);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class m implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z f129809a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f129810b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f129811c;

        public m(z zVar, int i3, int i16) {
            this.f129809a = zVar;
            this.f129810b = i3;
            this.f129811c = i16;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            Set copyOnWriteArraySet;
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "addKeyEventObserver#scheduled");
            z zVar = this.f129809a;
            zVar.f130018b = this.f129810b;
            zVar.f130017a = this.f129811c;
            if (g.this.F0.get(this.f129809a.f130017a) != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                copyOnWriteArraySet = (Set) g.this.F0.get(this.f129809a.f130017a);
            } else {
                copyOnWriteArraySet = new CopyOnWriteArraySet();
            }
            copyOnWriteArraySet.add(this.f129809a);
            if (!z16) {
                g.this.F0.put(this.f129809a.f130017a, copyOnWriteArraySet);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class n implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z f129813a;

        public n(z zVar) {
            this.f129813a = zVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Set set = (Set) g.this.F0.get(this.f129813a.f130017a);
            if (set != null) {
                set.remove(this.f129813a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class o implements Comparator {
        public o() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(g0 g0Var, g0 g0Var2) {
            if (g0Var == g0Var2) {
                return 0;
            }
            return g0Var.hashCode() - g0Var2.hashCode();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class p implements Comparator {
        public p() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f0 f0Var, f0 f0Var2) {
            if (f0Var == f0Var2) {
                return 0;
            }
            return f0Var.hashCode() - f0Var2.hashCode();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class q implements Comparator {
        public q() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Runnable runnable, Runnable runnable2) {
            if (runnable == runnable2) {
                return 0;
            }
            return runnable.hashCode() - runnable2.hashCode();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class r implements LifecycleOwner {

        /* renamed from: a, reason: collision with root package name */
        public final Lifecycle f129818a = new LifecycleRegistry(this);

        public r() {
        }

        @Override // androidx.lifecycle.LifecycleOwner
        public Lifecycle getLifecycle() {
            return this.f129818a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class s implements w {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConcurrentLinkedQueue f129820a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x f129821b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ w f129822c;

        public s(ConcurrentLinkedQueue concurrentLinkedQueue, x xVar, w wVar) {
            this.f129820a = concurrentLinkedQueue;
            this.f129821b = xVar;
            this.f129822c = wVar;
        }

        @Override // com.tencent.luggage.wxa.ic.g.w
        public void a() {
            if (!this.f129820a.remove(this.f129821b)) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandRuntime", "AppBrandRuntime[%s].prepare() duplicate ready() called, PrepareProcess[%s]", g.this.getAppId(), this.f129821b);
                return;
            }
            g.this.a("prepare() PrepareProcess[%s] done", this.f129821b);
            if (this.f129820a.isEmpty()) {
                this.f129822c.a();
                g.this.v();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class t implements ViewGroup.OnHierarchyChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f129824a;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.ic.g$t$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C6297a implements c.InterfaceC6640c {
                public C6297a() {
                }

                @Override // com.tencent.luggage.wxa.qc.c.InterfaceC6640c
                public void a(String str, com.tencent.luggage.wxa.qc.b bVar) {
                    if (com.tencent.luggage.wxa.qc.b.FOREGROUND == bVar) {
                        g.this.Y().setActuallyVisible(true);
                        g.this.c0().b(this);
                    }
                }
            }

            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (g.this.B0()) {
                    g.this.Y().setActuallyVisible(true);
                } else {
                    g.this.c0().a(new C6297a());
                }
            }
        }

        public t(int i3) {
            this.f129824a = i3;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (view2.hashCode() != this.f129824a && g.this.C) {
                view2.setImportantForAccessibility(4);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (g.this.C) {
                view2.setImportantForAccessibility(0);
            }
            if (view2.hashCode() == this.f129824a) {
                g.this.C = false;
                g.this.f129771l.a();
                for (int i3 = 0; i3 < g.this.f129771l.getChildCount(); i3++) {
                    g.this.f129771l.getChildAt(i3).setImportantForAccessibility(0);
                }
                if (!g.this.t0()) {
                    a aVar = new a();
                    g.this.Y0();
                    if (g.this.Y() == null) {
                        g.this.c(aVar);
                    } else {
                        aVar.run();
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class u implements Function0 {
        public u() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke() {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "hideSplash complete, appId:%s", g.this.getAppId());
            g.this.f129773m = null;
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class v implements MessageQueue.IdleHandler {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Configuration f129829a;

        public v(Configuration configuration) {
            this.f129829a = configuration;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            g.this.a(this.f129829a);
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface w {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class x {

        /* renamed from: a, reason: collision with root package name */
        public w f129831a;

        public void a() {
        }

        public String b() {
            return getClass().getName();
        }

        public abstract void c();

        public void d() {
            w wVar = this.f129831a;
            if (wVar != null) {
                wVar.a();
            }
        }

        public boolean e() {
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class y implements w, com.tencent.luggage.wxa.vo.a {

        /* renamed from: a, reason: collision with root package name */
        public final String f129832a;

        /* renamed from: b, reason: collision with root package name */
        public volatile boolean f129833b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final long f129835a = w0.a();

            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.tencent.luggage.wxa.lk.j.b(g.this.f129765i.f125808a, g.this.f129784w0);
                com.tencent.luggage.wxa.lk.j.b(g.this.f129765i.f125808a, g.this.f129765i.f125820m);
                if (!y.this.f129833b) {
                    g.this.f129786y0 = null;
                    g.this.a("RuntimePrepareAllDoneInitNotify run() waited %dms", Long.valueOf(w0.a() - this.f129835a));
                    y.this.b();
                    g.this.q0();
                    com.tencent.luggage.wxa.lk.j.c(g.this.getAppId());
                    return;
                }
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "PrepareAllDoneInitNotify.done() hash[%d] check2 dead appId[%s]", Integer.valueOf(hashCode()), g.this.getAppId());
            }
        }

        public y() {
            this.f129832a = "MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify";
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "<init> appId[%s] hash[%d]", g.this.getAppId(), Integer.valueOf(hashCode()));
            g.this.b((com.tencent.luggage.wxa.vo.a) this);
            this.f129833b = false;
        }

        @Override // com.tencent.luggage.wxa.vo.a
        public void g() {
            this.f129833b = true;
        }

        @Override // com.tencent.luggage.wxa.ic.g.w
        public void a() {
            if (this.f129833b) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "PrepareAllDoneInitNotify.done() hash[%d] check1 dead appId[%s]", Integer.valueOf(hashCode()), g.this.getAppId());
                return;
            }
            g.this.a("RuntimePrepareAllDoneInitNotify enqueue", new Object[0]);
            a aVar = new a();
            b();
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile|dump main thread stacktrace tid  " + Looper.getMainLooper().getThread().getId());
            for (StackTraceElement stackTraceElement : Looper.getMainLooper().getThread().getStackTrace()) {
                g.this.f129757e.println("AppBrandRuntimeProfile|dump main thread stacktrace    " + stackTraceElement.toString());
            }
            g.this.f129755d.a((Runnable) aVar, true);
            g.this.a((com.tencent.luggage.wxa.vo.a) this);
        }

        public final void b() {
            try {
                g.this.f129755d.a(g.this.f129757e, "AppBrandRuntimeProfile|dump mUiHandler");
            } catch (Throwable th5) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandRuntime_$_RuntimePrepareAllDoneInitNotify", "dumpUiThreadInQueueMessages get exception:%s", th5);
            }
        }

        public /* synthetic */ y(g gVar, k kVar) {
            this();
        }
    }

    public g(Context context) {
        this.f129757e = new Printer() { // from class: com.tencent.luggage.wxa.ic.ak
            @Override // android.util.Printer
            public final void println(String str) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", str);
            }
        };
        this.H = false;
        this.I = new com.tencent.luggage.wxa.rc.r[]{null};
        this.J = new AtomicBoolean(false);
        this.K = new k();
        this.L = new k0();
        this.M = new ConcurrentSkipListSet(new o());
        this.N = new l0();
        this.O = new ConcurrentSkipListSet(new p());
        this.P = new ConcurrentSkipListSet(new q());
        this.Q = new LinkedHashSet();
        this.R = new com.tencent.luggage.wxa.ic.r();
        this.f129750a0 = false;
        this.f129752b0 = new AtomicBoolean(false);
        this.f129764h0 = false;
        this.f129766i0 = true;
        this.f129770k0 = 0L;
        this.f129772l0 = 0L;
        this.f129777p0 = null;
        this.f129778q0 = null;
        this.f129779r0 = null;
        this.f129780s0 = null;
        this.f129781t0 = null;
        this.f129782u0 = null;
        this.f129783v0 = false;
        this.f129785x0 = new LinkedList();
        this.f129786y0 = null;
        this.A0 = new h();
        this.B0 = new i();
        this.C0 = new com.tencent.luggage.wxa.tn.e0(Looper.getMainLooper(), (e0.a) new j(), false);
        this.D0 = new LinkedBlockingDeque();
        this.E0 = new com.tencent.luggage.wxa.ln.a(2, new Runnable() { // from class: com.tencent.luggage.wxa.ic.al
            @Override // java.lang.Runnable
            public final void run() {
                g.this.h1();
            }
        });
        this.F0 = new SparseArray();
        this.G0 = null;
        this.f129749a = context;
        p0 p0Var = new p0();
        this.f129755d = p0Var;
        this.f129759f = new q0();
        this.f129754c0 = new com.tencent.luggage.wxa.h6.b(p0Var, new Runnable() { // from class: com.tencent.luggage.wxa.ic.ab
            @Override // java.lang.Runnable
            public final void run() {
                g.this.R0();
            }
        });
        com.tencent.luggage.wxa.il.g a16 = a(context);
        this.f129771l = a16;
        a16.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f129768j0 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0() {
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0() {
        a((w) new y(this, null));
    }

    public final void A() {
        B();
    }

    public final boolean A0() {
        boolean z16;
        synchronized (this) {
            z16 = this.Z;
        }
        return z16;
    }

    public final void B() {
        this.f129754c0.a();
        boolean e16 = e1();
        boolean s06 = s0();
        boolean B0 = B0();
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "dispatchResumeImpl(%s), initialized:%b, resumed:%b, pendingPauseRemoved:%b", this, Boolean.valueOf(s06), Boolean.valueOf(B0), Boolean.valueOf(e16));
        if (s06 && !B0) {
            a("onResume", new Object[0]);
            if (!t0() && !this.f129758e0) {
                this.f129750a0 = true;
                com.tencent.luggage.wxa.ic.e.k(this.f129761g);
                com.tencent.luggage.wxa.ic.e.j(this.f129761g);
                com.tencent.luggage.wxa.ic.e.a(this.f129761g, e.b.ON_RESUME);
                a(Lifecycle.Event.ON_START);
                a(Lifecycle.Event.ON_RESUME);
                boolean z16 = this.f129760f0;
                this.f129769k.l();
                this.T.k();
                this.f129767j.c(z16);
                V0();
                if (z16) {
                    c1();
                }
                this.S.c();
                g1();
                f1();
                com.tencent.luggage.wxa.zd.d.b(this.f129767j);
                return;
            }
            if (this.f129758e0 && O0()) {
                return;
            }
            this.f129750a0 = true;
            d1();
        }
    }

    public final boolean B0() {
        return this.f129750a0;
    }

    public boolean C() {
        return false;
    }

    public boolean C0() {
        boolean z16;
        String simpleName;
        com.tencent.luggage.wxa.ok.j jVar = this.f129773m;
        if (jVar instanceof com.tencent.luggage.wxa.ok.k) {
            z16 = ((com.tencent.luggage.wxa.ok.k) jVar).d();
        } else {
            z16 = false;
        }
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(z16);
        objArr[1] = getAppId();
        com.tencent.luggage.wxa.ok.j jVar2 = this.f129773m;
        if (jVar2 == null) {
            simpleName = "null";
        } else {
            simpleName = jVar2.getClass().getSimpleName();
        }
        objArr[2] = simpleName;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "isShowingSplashAd[AppBrandSplashAd]:%s, appId:%s, splash:%s", objArr);
        return z16;
    }

    public void D() {
        b(1);
    }

    public com.tencent.luggage.wxa.fd.b E() {
        return (com.tencent.luggage.wxa.fd.b) a(com.tencent.luggage.wxa.fd.b.class, false);
    }

    public final Context F() {
        return this.f129749a;
    }

    public final void F0() {
        synchronized (this) {
            if (!this.Z) {
                this.Z = true;
                this.f129750a0 = true;
                this.C = false;
                this.P.clear();
                this.W = null;
            } else {
                throw new RuntimeException("Already invoked launch()");
            }
        }
        long a16 = w0.a();
        this.f129770k0 = a16;
        try {
            a("launch start", new Object[0]);
            this.f129765i.C = false;
            P0();
            if (!t0() && !w0()) {
                com.tencent.luggage.wxa.e5.g.a("AppBrandRuntimeProfile| onCreatePrivate" + getAppId(), new Runnable() { // from class: com.tencent.luggage.wxa.ic.ad
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.this.w();
                    }
                });
                this.f129784w0 = com.tencent.luggage.wxa.lk.j.b(getAppId(), "public:prepare", "\u5c0f\u7a0b\u5e8f\u542f\u52a8\u8d44\u6e90\u51c6\u5907");
                com.tencent.luggage.wxa.e5.g.a("AppBrandRuntimeProfile| prepare(AllDoneInitNotify)" + getAppId(), new Runnable() { // from class: com.tencent.luggage.wxa.ic.ae
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.this.E0();
                    }
                });
                com.tencent.luggage.wxa.e5.g.a("AppBrandRuntimeProfile| showSplash " + getAppId(), new Runnable() { // from class: com.tencent.luggage.wxa.ic.af
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.this.n1();
                    }
                });
                o1();
                a("launch end, cost:%dms", Long.valueOf(w0.a() - a16));
                return;
            }
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| finish() called during onLaunch, appId:%s", getAppId());
            a("launch end, cost:%dms", Long.valueOf(w0.a() - a16));
        } catch (Throwable th5) {
            a("launch end, cost:%dms", Long.valueOf(w0.a() - a16));
            throw th5;
        }
    }

    public final String G() {
        if (S() == null) {
            return "";
        }
        return S().f125809b;
    }

    public final ExecutorService G0() {
        return com.tencent.luggage.wxa.zp.h.f146825d.a(String.format("appbrand_runtime_%s", Integer.valueOf(hashCode())), 6, 12, new LinkedBlockingQueue());
    }

    public com.tencent.luggage.wxa.ml.r H() {
        if (this.F == null) {
            com.tencent.luggage.wxa.ml.g gVar = new com.tencent.luggage.wxa.ml.g(this.f129749a, ((com.tencent.luggage.wxa.ml.g) N()).getShareContext());
            this.F = gVar;
            gVar.setShouldBringSelfToFrontWhenDialogShown(false);
            o0.AuthorizeDialogContainer.a(this, this.F);
        }
        return this.F;
    }

    public void H0() {
        this.f129767j.getJsRuntime().evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.log('xxx ntrans ntrans_init_service start'); }\n", null);
        this.f129767j.getJsRuntime().evaluateJavascript("if (typeof ntrans !== 'undefined') { ntrans.serviceId = ntrans.id; }\n", null);
    }

    public final com.tencent.luggage.wxa.lj.e I() {
        return this.G;
    }

    public void I0() {
        Object[] objArr = new Object[3];
        boolean z16 = false;
        objArr[0] = getAppId();
        objArr[1] = Boolean.valueOf(this.Y);
        if (this.f129773m != null) {
            z16 = true;
        }
        objArr[2] = Boolean.valueOf(z16);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile|onBackPressed, appId:%s, mInitReady:%b, mSplash?:%b", objArr);
        if (this.f129773m != null && !this.Y) {
            com.tencent.luggage.wxa.ic.e.a(getAppId(), e.d.BACK);
            D();
            return;
        }
        com.tencent.luggage.wxa.ml.g gVar = this.F;
        if (gVar != null && gVar.a()) {
            return;
        }
        com.tencent.luggage.wxa.ml.g gVar2 = this.E;
        if (gVar2 != null && gVar2.a()) {
            return;
        }
        com.tencent.luggage.wxa.ml.g gVar3 = this.D;
        if ((gVar3 == null || !gVar3.a()) && this.f129769k != null) {
            this.f129769k.i();
        }
    }

    public final Collection J() {
        return this.K;
    }

    public final com.tencent.luggage.wxa.il.g K() {
        return this.f129771l;
    }

    public final Activity L() {
        return com.tencent.luggage.wxa.bo.a.a(this.f129749a);
    }

    public void L0() {
        a("onDetachFromStack", new Object[0]);
        this.f129763h = null;
        this.T.f();
        com.tencent.luggage.wxa.ic.e.g(getAppId());
    }

    public i1 M() {
        return null;
    }

    public com.tencent.luggage.wxa.ml.r N() {
        if (this.D == null) {
            com.tencent.luggage.wxa.ml.g gVar = new com.tencent.luggage.wxa.ml.g(this.f129749a);
            this.D = gVar;
            gVar.setShouldBringSelfToFrontWhenDialogShown(false);
            o0.LegacyDialogContainer.a(this, this.D);
        }
        return this.D;
    }

    public String O() {
        if (this.f129765i == null) {
            return "";
        }
        if (w0.c(this.f129765i.f125813f)) {
            if (E() == null) {
                return "";
            }
            return E().c();
        }
        return this.f129765i.f125813f;
    }

    public boolean O0() {
        return false;
    }

    public com.tencent.luggage.wxa.rc.r P() {
        if (this.I[0] == null) {
            if (!t0() && !w0()) {
                synchronized (this.I) {
                    if (this.I[0] == null) {
                        a("getFileSystem-installFileSystem(forceCreate=true)", new Object[0]);
                        b(true);
                    }
                }
            } else {
                return null;
            }
        }
        return this.I[0];
    }

    public final g Q() {
        return this.f129763h;
    }

    public final com.tencent.luggage.wxa.kj.f R() {
        return this.f129776o0;
    }

    public void R0() {
        a("StayPausedAndWaitForInitializationTimeout", new Object[0]);
        D();
    }

    public com.tencent.luggage.wxa.fd.i S() {
        return this.f129765i;
    }

    public LifecycleOwner T() {
        return this.U;
    }

    public void T0() {
        H0();
    }

    public LifecycleScope U() {
        return this.V;
    }

    public void U0() {
        b0().a();
    }

    public boolean V() {
        return false;
    }

    public com.tencent.luggage.wxa.xi.a W() {
        return this.W;
    }

    public com.tencent.luggage.wxa.il.n X() {
        if (this.H0 == null) {
            this.H0 = new com.tencent.luggage.wxa.il.n();
        }
        return this.H0;
    }

    public com.tencent.luggage.wxa.kj.p Y() {
        return this.f129769k;
    }

    public com.tencent.luggage.wxa.vj.f Z() {
        if (Y() == null) {
            return null;
        }
        com.tencent.luggage.wxa.vj.f fVar = this.f129774m0;
        if (fVar != null) {
            return fVar;
        }
        com.tencent.luggage.wxa.vj.f fVar2 = new com.tencent.luggage.wxa.vj.f(this.f129749a, this, new f.o() { // from class: com.tencent.luggage.wxa.ic.ag
            @Override // com.tencent.luggage.wxa.vj.f.o
            public final void a(com.tencent.luggage.wxa.il.f fVar3) {
                g.this.a(fVar3);
            }
        });
        this.f129774m0 = fVar2;
        return fVar2;
    }

    public final void Z0() {
        com.tencent.luggage.wxa.e5.g.a(getAppId() + ":performInitPageContainer", new b());
    }

    public abstract void a(com.tencent.luggage.wxa.fd.i iVar, Object obj);

    public abstract void a(boolean z16, int i3);

    public abstract void a(boolean z16, int i3, boolean z17);

    public void a(boolean z16, String str, com.tencent.luggage.wxa.mc.a0 a0Var) {
    }

    public final com.tencent.luggage.wxa.vj.f a0() {
        return this.f129774m0;
    }

    public final void a1() {
        com.tencent.luggage.wxa.e5.g.a(getAppId() + ":performInitService", new c());
    }

    public void b(com.tencent.luggage.wxa.ic.l lVar) {
    }

    public abstract void b(Object obj);

    public final m0 b0() {
        return this.N;
    }

    public final void b1() {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "onServiceReconnected: %s", this.f129761g);
        if (s0()) {
            X0();
            com.tencent.luggage.wxa.ic.e.i(this.f129761g);
        } else {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandRuntime", "Main Process Restarted, start prepare again");
            e(new e());
        }
    }

    public com.tencent.luggage.wxa.qc.c c0() {
        return this.T;
    }

    public final void c1() {
        this.f129769k.a(O(), true);
    }

    public com.tencent.luggage.wxa.xd.l d(Class cls) {
        return null;
    }

    public final g d0() {
        com.tencent.luggage.wxa.ic.v vVar = this.f129751b;
        if (vVar == null) {
            return null;
        }
        return vVar.a(this);
    }

    public final void d1() {
        a((com.tencent.luggage.wxa.fd.i) null, "");
    }

    public com.tencent.luggage.wxa.ya.a e(Class cls) {
        return null;
    }

    public com.tencent.luggage.wxa.ic.v e0() {
        return this.f129751b;
    }

    public final boolean e1() {
        if (this.f129756d0 != null) {
            try {
                Iterator it = this.D0.iterator();
                while (it.hasNext()) {
                    if (it.next() == this.f129756d0) {
                        it.remove();
                        this.f129756d0 = null;
                        return true;
                    }
                }
                return false;
            } finally {
                this.f129756d0 = null;
            }
        }
        return false;
    }

    public boolean f(Runnable runnable) {
        return false;
    }

    public final e0 f0() {
        return null;
    }

    public final void f1() {
        this.f129758e0 = false;
        this.f129760f0 = false;
    }

    public void finalize() {
        super.finalize();
        this.f129755d.a((Object) null);
    }

    public abstract void g(int i3);

    public com.tencent.luggage.wxa.uk.j0 g0() {
        return this.G0;
    }

    public void g1() {
        d(new l());
    }

    @Override // com.tencent.luggage.wxa.yi.g
    public String getAppId() {
        return this.f129761g;
    }

    @Override // com.tencent.luggage.wxa.yi.g
    public com.tencent.luggage.wxa.qc.b getAppState() {
        return c0().b();
    }

    public com.tencent.luggage.wxa.ic.l h0() {
        return this.f129767j;
    }

    public final void h1() {
        while (!this.D0.isEmpty()) {
            e((Runnable) this.D0.removeFirst());
        }
    }

    public com.tencent.luggage.wxa.ok.j i0() {
        return this.f129773m;
    }

    public final void i1() {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile|appId:%s, launch -> ready, cost %d", getAppId(), Long.valueOf(w0.a() - this.f129770k0));
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile|appId:%s, initRuntimeImpl -> ready, cost %d", getAppId(), Long.valueOf(w0.a() - this.f129772l0));
        c(new d());
    }

    public abstract com.tencent.luggage.wxa.fd.q j0();

    public final void j1() {
        if (t1()) {
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandRuntime", "setWillRelaunch appId:%s, ignore by willRestart", getAppId());
        } else {
            this.f129760f0 = true;
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "setWillRelaunch appId:%s", getAppId());
        }
    }

    public com.tencent.luggage.wxa.ml.r k0() {
        if (this.E == null) {
            com.tencent.luggage.wxa.ml.g gVar = new com.tencent.luggage.wxa.ml.g(this.f129749a, ((com.tencent.luggage.wxa.ml.g) N()).getShareContext());
            this.E = gVar;
            gVar.setShouldBringSelfToFrontWhenDialogShown(false);
            o0.UpperDialogContainer.a(this, this.E);
        }
        return this.E;
    }

    public final void k1() {
        this.f129758e0 = true;
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandRuntime", "setWillRestart");
    }

    public int l0() {
        return this.f129765i.f125811d;
    }

    public boolean l1() {
        if (this.T != null && this.T.l()) {
            return true;
        }
        return false;
    }

    public boolean m0() {
        return s1();
    }

    public boolean m1() {
        return true;
    }

    public com.tencent.luggage.wxa.wj.c n0() {
        String name;
        if (e0() == null) {
            Object[] objArr = new Object[2];
            objArr[0] = getAppId();
            com.tencent.luggage.wxa.wj.c cVar = this.f129753c;
            if (cVar == null) {
                name = null;
            } else {
                name = cVar.getClass().getName();
            }
            objArr[1] = name;
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandRuntime", "getWindowAndroid getRuntimeContainer is NULL appId[%s], return default %s", objArr);
            com.tencent.luggage.wxa.wj.c cVar2 = this.f129753c;
            if (cVar2 != null) {
                return cVar2;
            }
            WindowAndroidActivityImpl windowAndroidActivityImpl = new WindowAndroidActivityImpl();
            this.f129753c = windowAndroidActivityImpl;
            return windowAndroidActivityImpl;
        }
        return e0().h();
    }

    public void n1() {
        String simpleName;
        com.tencent.luggage.wxa.ok.j jVar = this.f129773m;
        if (jVar != null) {
            com.tencent.luggage.wxa.ok.a.a(jVar);
            this.f129773m = null;
        }
        com.tencent.luggage.wxa.lk.j.c(this.f129765i.f125808a, "public:prepare", "Loading\u9875\u5c55\u793a");
        com.tencent.luggage.wxa.ok.j r16 = r();
        if (r16 == null) {
            return;
        }
        r16.a(S().f125810c, S().f125809b);
        View view = r16.getView();
        view.sendAccessibilityEvent(32768);
        for (int i3 = 0; i3 < this.f129771l.getChildCount(); i3++) {
            View childAt = this.f129771l.getChildAt(i3);
            if (r16.getView() != childAt) {
                childAt.setImportantForAccessibility(4);
            }
        }
        o0.LoadingSplash.a(this, view);
        this.C = true;
        this.f129771l.a(view);
        this.f129773m = r16;
        Object[] objArr = new Object[2];
        objArr[0] = getAppId();
        com.tencent.luggage.wxa.ok.j jVar2 = this.f129773m;
        if (jVar2 == null) {
            simpleName = "null";
        } else {
            simpleName = jVar2.getClass().getSimpleName();
        }
        objArr[1] = simpleName;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "showSplash[AppBrandSplashAd], appId:%s, splash:%s", objArr);
        this.f129771l.setOnHierarchyChangeListener(new t(view.hashCode()));
    }

    public boolean o0() {
        if (this.f129756d0 != null) {
            return true;
        }
        return false;
    }

    public final void o1() {
        this.C0.a(10000L);
    }

    public void p0() {
        String str = null;
        if (t0()) {
            com.tencent.luggage.wxa.ok.j jVar = this.f129773m;
            if (jVar != null) {
                com.tencent.luggage.wxa.ok.a.a(jVar);
            }
            this.f129773m = null;
            return;
        }
        if (this.f129773m == null) {
            return;
        }
        if ((com.tencent.luggage.wxa.tn.e.f141559a || com.tencent.luggage.wxa.tn.e.f141565g) && com.tencent.luggage.wxa.ok.a.f136554a.a()) {
            return;
        }
        com.tencent.luggage.wxa.lk.j.c(this.f129765i.f125808a, "public:prepare", "Loading\u9875\u9690\u85cf");
        Object[] objArr = new Object[3];
        objArr[0] = getAppId();
        com.tencent.luggage.wxa.ok.j jVar2 = this.f129773m;
        if (jVar2 != null) {
            str = jVar2.getClass().getName();
        }
        objArr[1] = str;
        objArr[2] = Log.getStackTraceString(new Throwable());
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "hideSplash[AppBrandSplashAd], appId:%s, splash:%s, stack:%s", objArr);
        u uVar = new u();
        if (this.f129773m instanceof com.tencent.luggage.wxa.ok.m) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "[weishi] hideSplash, hideLoadingSplashFromRuntime, appId:%s", getAppId());
            ((com.tencent.luggage.wxa.ok.m) this.f129773m).b(uVar);
        } else {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "hideSplash, animateHide, appId:%s", getAppId());
            this.f129773m.c(uVar);
        }
    }

    public final void p1() {
        this.C0.f();
    }

    public abstract com.tencent.luggage.wxa.rc.r q();

    public final void q0() {
        if (t0()) {
            return;
        }
        if (s0()) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandRuntime", "initRuntime, mInitialized TRUE !!!  go check callee %s", w0.a(new Throwable()));
        } else {
            a("initRuntime", new Object[0]);
            new a().run();
        }
    }

    public com.tencent.luggage.wxa.ok.j r() {
        return null;
    }

    public final boolean r0() {
        a("initRuntimeImpl", new Object[0]);
        this.f129772l0 = w0.a();
        b(false);
        N0();
        if (w0() || t0()) {
            return false;
        }
        if (this.f129767j == null) {
            a("initRuntimeImpl-createService", new Object[0]);
            this.f129767j = u();
        }
        a(this.f129767j);
        this.W = s();
        this.f129775n0 = new com.tencent.luggage.wxa.il.e(this.f129749a);
        this.f129776o0 = new com.tencent.luggage.wxa.kj.f(this.f129775n0);
        o0.GlobalNativeWidgetContainerView.a(this, this.f129775n0);
        com.tencent.luggage.wxa.lj.e p16 = p();
        this.G = p16;
        p16.j();
        boolean m16 = m1();
        a("initRuntimeImpl, initServiceBeforePage:%b", Boolean.valueOf(m16));
        if (m16) {
            com.tencent.luggage.wxa.lk.j.a(this.f129765i.f125808a, "public:prepare", "AppService\u521d\u59cb\u5316");
            a1();
            com.tencent.luggage.wxa.lk.j.c(this.f129765i.f125808a);
            com.tencent.luggage.wxa.lk.j.a(this.f129765i.f125808a, "public:prepare", "WebView/Skyline\u5bb9\u5668\u548cUI\u521d\u59cb\u5316");
            Z0();
            com.tencent.luggage.wxa.lk.j.c(this.f129765i.f125808a);
        } else {
            com.tencent.luggage.wxa.lk.j.a(this.f129765i.f125808a, "public:prepare", "WebView/Skyline\u5bb9\u5668\u548cUI\u521d\u59cb\u5316");
            Z0();
            com.tencent.luggage.wxa.lk.j.c(this.f129765i.f125808a);
            com.tencent.luggage.wxa.lk.j.a(this.f129765i.f125808a, "public:prepare", "AppService\u521d\u59cb\u5316");
            a1();
            com.tencent.luggage.wxa.lk.j.c(this.f129765i.f125808a);
        }
        com.tencent.luggage.wxa.uk.i iVar = new com.tencent.luggage.wxa.uk.i();
        this.S = iVar;
        iVar.a(this.f129767j);
        this.G0 = new com.tencent.luggage.wxa.uk.j0(this);
        g1();
        this.T.g();
        a("initRuntimeImpl end", new Object[0]);
        com.tencent.luggage.wxa.lk.j.c(getAppId(), "internal:prepare", "onPostInit");
        S0();
        com.tencent.luggage.wxa.lk.j.c(getAppId());
        com.tencent.luggage.wxa.lk.j.b(getAppId(), this.f129765i.f125819l);
        return true;
    }

    public boolean r1() {
        return true;
    }

    public abstract com.tencent.luggage.wxa.xi.a s();

    public void s(g gVar) {
        this.f129763h = gVar;
    }

    public final boolean s0() {
        return this.E0.d();
    }

    public final boolean s1() {
        return this.f129760f0;
    }

    public final boolean t0() {
        return this.f129752b0.get();
    }

    public final boolean t1() {
        return this.f129758e0;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "[AppBrandRuntime::%s::%s::%d::@%d]", getAppId(), G(), Integer.valueOf(l0()), Integer.valueOf(hashCode()));
    }

    public final boolean u0() {
        return true;
    }

    public boolean v0() {
        return false;
    }

    public final boolean w0() {
        return this.X;
    }

    public boolean x0() {
        return this.f129768j0;
    }

    public final void y() {
        Runnable runnable = new Runnable() { // from class: com.tencent.luggage.wxa.ic.aa
            @Override // java.lang.Runnable
            public final void run() {
                g.this.D0();
            }
        };
        this.f129756d0 = runnable;
        c(runnable);
        if (!B0()) {
            this.f129756d0 = null;
        } else {
            this.f129754c0.a(TimeUnit.MINUTES.toMillis(30L));
        }
    }

    public boolean y0() {
        return false;
    }

    public final void z() {
        com.tencent.luggage.wxa.er.a.a(c0());
        c0().h();
        WindowAndroidActivityImpl b16 = WindowAndroidActivityImpl.b(n0());
        if (b16 != null && B0() && b16.q()) {
            a("dispatchResetToTopOfStack runtime isResumed but activity already paused and stopped?:%b, dispatchPause manually", Boolean.valueOf(b16.r()));
            if (com.tencent.luggage.wxa.ic.e.d(getAppId()) == e.d.LAUNCH_MINI_PROGRAM) {
                com.tencent.luggage.wxa.ic.e.k(getAppId());
            }
            y();
            if (b16.r()) {
                c0().e();
            }
        }
    }

    public boolean z0() {
        com.tencent.luggage.wxa.ic.v vVar = this.f129751b;
        if (vVar != null && vVar.b(this)) {
            return true;
        }
        return false;
    }

    public com.tencent.luggage.wxa.xd.m c(Class cls) {
        if (cls == null) {
            return null;
        }
        synchronized (this.Q) {
            Iterator it = this.Q.iterator();
            while (it.hasNext()) {
                com.tencent.luggage.wxa.xd.m mVar = (com.tencent.luggage.wxa.xd.m) it.next();
                if (cls.isInstance(mVar)) {
                    return mVar;
                }
            }
            return null;
        }
    }

    public void e(int i3) {
    }

    public final boolean k() {
        return this.f129783v0;
    }

    public final boolean l() {
        if (r1()) {
            throw new RuntimeException("Stub!");
        }
        return this.f129764h0 && !x0();
    }

    public final boolean m() {
        if (!this.f129766i0) {
            return false;
        }
        Activity L = L();
        return ((L != null && L.isFinishing()) || this.f129769k == null || this.f129769k.getCurrentPage() == null || this.f129769k.getCurrentPage().q()) ? false : true;
    }

    public final void n() {
        ConcurrentLinkedQueue concurrentLinkedQueue = this.f129786y0;
        this.f129786y0 = null;
        if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "cancelAllPrepareProcesses empty list appId[%s]", getAppId());
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "cancelAllPrepareProcesses size[%d] appId[%s]", Integer.valueOf(concurrentLinkedQueue.size()), getAppId());
        while (!concurrentLinkedQueue.isEmpty()) {
            x xVar = (x) concurrentLinkedQueue.poll();
            if (xVar != null) {
                xVar.a();
            }
        }
    }

    public void o() {
        a((Object) null);
    }

    public com.tencent.luggage.wxa.lj.e p() {
        return new com.tencent.luggage.wxa.lj.e(this);
    }

    public com.tencent.luggage.wxa.kj.p t() {
        return new com.tencent.luggage.wxa.kj.p(this.f129749a, this);
    }

    public com.tencent.luggage.wxa.ic.l u() {
        return new com.tencent.luggage.wxa.ic.l();
    }

    public final void v() {
        ExecutorService executorService = this.f129787z0;
        if (executorService == null || executorService.isShutdown()) {
            return;
        }
        this.f129787z0.shutdownNow();
    }

    public final void w() {
        a("appOnCreate", new Object[0]);
        String g16 = com.tencent.luggage.wxa.tn.z.g();
        com.tencent.luggage.wxa.ka.o.a(g16, this.A0);
        com.tencent.luggage.wxa.ka.o.a(g16, this.B0);
        a(com.tencent.luggage.wxa.ee.g.class, new com.tencent.luggage.wxa.ic.s());
        a(com.tencent.luggage.wxa.bj.d.class, new com.tencent.luggage.wxa.bj.f(this));
        a(com.tencent.luggage.wxa.hd.b.class, new com.tencent.luggage.wxa.ni.e(this));
        a(com.tencent.luggage.wxa.hd.a.class, new com.tencent.luggage.wxa.ni.d(this));
        com.tencent.luggage.wxa.e5.g.a("AppBrandRuntimeProfile|onCreate", new Runnable() { // from class: com.tencent.luggage.wxa.ic.ah
            @Override // java.lang.Runnable
            public final void run() {
                g.this.J0();
            }
        });
        com.tencent.luggage.wxa.oi.a.c(getAppId());
        this.T.i();
        com.tencent.luggage.wxa.ic.e.k(this.f129761g);
        com.tencent.luggage.wxa.ic.e.e(this.f129761g);
        com.tencent.luggage.wxa.ic.e.a(this.f129761g, e.b.ON_CREATE);
        ((LifecycleRegistry) T().getLifecycle()).setCurrentState(Lifecycle.State.RESUMED);
        g1();
    }

    public final void x() {
        a(1);
    }

    public void d(com.tencent.luggage.wxa.fd.i iVar) {
        this.f129765i = iVar;
    }

    public final com.tencent.luggage.wxa.ya.a f(Class cls) {
        com.tencent.luggage.wxa.ya.a a16 = this.R.a(cls);
        if (a16 != null) {
            return (com.tencent.luggage.wxa.ya.a) cls.cast(a16);
        }
        com.tencent.luggage.wxa.ya.a e16 = e(cls);
        if (e16 != null) {
            this.R.a(cls, (com.tencent.luggage.wxa.ya.a) cls.cast(e16));
        } else if (cls == com.tencent.luggage.wxa.il.l.class) {
            return (com.tencent.luggage.wxa.ya.a) cls.cast(com.tencent.luggage.wxa.il.l.f130716q);
        }
        return (com.tencent.luggage.wxa.ya.a) cls.cast(e16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(int i3) {
        com.tencent.luggage.wxa.ok.j jVar = this.f129773m;
        if (jVar != null) {
            jVar.setProgress(i3);
        }
    }

    @Override // com.tencent.luggage.wxa.vo.b
    public void b(com.tencent.luggage.wxa.vo.a aVar) {
        this.f129759f.b(aVar);
    }

    public final void b(com.tencent.luggage.wxa.fd.i iVar) {
        if (iVar == null) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "null current config, ignored");
            return;
        }
        a("init start", new Object[0]);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile| init start config:%s", iVar);
        this.f129765i = iVar;
        this.f129761g = iVar.f125808a;
        if (this.H) {
            com.tencent.luggage.wxa.lk.j.a(this.f129761g, true);
        }
        this.T = new com.tencent.luggage.wxa.qc.c(this);
        this.T.m();
        this.T.a(new c.InterfaceC6640c() { // from class: com.tencent.luggage.wxa.ic.aj
            @Override // com.tencent.luggage.wxa.qc.c.InterfaceC6640c
            public final void a(String str, com.tencent.luggage.wxa.qc.b bVar) {
                g.this.b(str, bVar);
            }
        });
        this.U = new r();
        this.V = new LifecycleScope("Wxa#" + this.f129761g, this.U, 4);
        this.D0.clear();
        this.E0.a(2);
        this.Y = false;
        this.f129752b0.set(false);
        this.X = false;
        this.f129758e0 = false;
        this.f129760f0 = false;
        this.f129762g0 = false;
        M0();
        a("init end", new Object[0]);
    }

    public final void e(boolean z16) {
        this.f129766i0 = z16;
    }

    public final void d(boolean z16) {
        if (r1()) {
            return;
        }
        this.f129764h0 = z16;
        com.tencent.luggage.wxa.kj.n currentPage = Y() == null ? null : Y().getCurrentPage();
        if (currentPage != null) {
            currentPage.C();
        }
    }

    public final void e(Runnable runnable) {
        b(runnable, 0L);
    }

    public com.tencent.luggage.wxa.il.g a(Context context) {
        if (com.tencent.luggage.wxa.uk.n0.a(context)) {
            return new com.tencent.luggage.wxa.il.c(context);
        }
        return com.tencent.luggage.wxa.il.g.a(context);
    }

    public final void c(int i3) {
        e(false);
        com.tencent.luggage.wxa.ic.v e06 = e0();
        try {
            if (e0() != null) {
                e0().d(this);
            }
            b(i3);
        } finally {
            if (e06 instanceof com.tencent.luggage.wxa.ic.w) {
                ((com.tencent.luggage.wxa.ic.w) e06).d();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.uk.s
    public void a(com.tencent.luggage.wxa.vo.a aVar) {
        this.f129759f.a(aVar);
    }

    public final void d(Runnable runnable) {
        a(runnable, 0L);
    }

    public void f(final int i3) {
        e(new Runnable() { // from class: com.tencent.luggage.wxa.ic.ac
            @Override // java.lang.Runnable
            public final void run() {
                g.this.d(i3);
            }
        });
        b0().a(i3);
    }

    public final void a(String str, Object... objArr) {
        com.tencent.luggage.wxa.fd.i iVar = this.f129765i;
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.ENGLISH, str, objArr);
        }
        Object[] objArr2 = new Object[5];
        objArr2[0] = Integer.valueOf(hashCode());
        objArr2[1] = iVar == null ? "" : iVar.f125809b;
        objArr2[2] = iVar != null ? iVar.f125808a : "";
        objArr2[3] = Integer.valueOf(iVar == null ? -1 : iVar.f125811d);
        objArr2[4] = str;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "AppBrandRuntimeProfile|%d|%s|%s|%d| %s", objArr2);
    }

    public boolean d(String str) {
        if (this.f129777p0 == null) {
            return false;
        }
        for (int i3 = 0; i3 < this.f129777p0.length(); i3++) {
            if (this.f129777p0.optString(i3).equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void f(boolean z16) {
        this.f129768j0 = z16;
    }

    public final boolean c(com.tencent.luggage.wxa.fd.i iVar) {
        if (iVar == null) {
            return false;
        }
        if (!this.f129762g0) {
            return iVar.f125811d != this.f129765i.f125811d;
        }
        this.f129762g0 = false;
        return true;
    }

    public void a(com.tencent.luggage.wxa.ic.v vVar) {
        com.tencent.luggage.wxa.ic.v vVar2 = this.f129751b;
        if (vVar2 != null && vVar2 != vVar) {
            vVar2.d(this);
        }
        this.f129751b = vVar;
        if (vVar != null) {
            this.L.a(vVar);
        } else {
            this.L.a();
        }
    }

    public void c(Runnable runnable) {
        if (w0() || t0()) {
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandRuntime", "runOnRuntimeInitialized runtime[%s] finishing, stack %s", getAppId(), Log.getStackTraceString(new Throwable()));
        } else if (s0()) {
            e(runnable);
        } else {
            this.D0.offerLast(runnable);
        }
    }

    public void J0() {
    }

    public void K0() {
    }

    public void M0() {
    }

    public void N0() {
    }

    public void P0() {
    }

    public void Q0() {
    }

    public void S0() {
    }

    public void V0() {
    }

    public void W0() {
    }

    public void X0() {
    }

    public void Y0() {
    }

    public void q1() {
    }

    public final void a(d0 d0Var) {
        this.L.a(d0Var);
    }

    public final void a(w wVar) {
        com.tencent.luggage.wxa.so.h.a("AppBrandRuntime.prepare");
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue(this.f129785x0);
        this.f129786y0 = concurrentLinkedQueue;
        this.f129785x0 = new LinkedList();
        Iterator it = concurrentLinkedQueue.iterator();
        v();
        this.f129787z0 = G0();
        LinkedList linkedList = new LinkedList();
        while (it.hasNext()) {
            final x xVar = (x) it.next();
            xVar.f129831a = new s(concurrentLinkedQueue, xVar, wVar);
            if (xVar.e()) {
                com.tencent.luggage.wxa.so.h.a("AppBrandRuntime.prepare(" + xVar.b() + ") submit");
                try {
                    ExecutorService executorService = this.f129787z0;
                    Objects.requireNonNull(executorService);
                    executorService.execute(new Runnable() { // from class: com.tencent.luggage.wxa.ic.ai
                        @Override // java.lang.Runnable
                        public final void run() {
                            g.a(g.x.this);
                        }
                    });
                    com.tencent.luggage.wxa.so.h.a();
                } catch (RejectedExecutionException unused) {
                    a("try prepare but ThreadPool shut down", new Object[0]);
                    return;
                }
            } else {
                linkedList.add(xVar);
            }
        }
        Iterator it5 = linkedList.iterator();
        while (it5.hasNext()) {
            x xVar2 = (x) it5.next();
            com.tencent.luggage.wxa.lk.j.a(this.f129765i.f125808a, "internal:prepare", xVar2.b());
            com.tencent.luggage.wxa.so.h.a("AppBrandRuntime.prepare(" + xVar2.b() + ")");
            xVar2.c();
            com.tencent.luggage.wxa.so.h.a();
            com.tencent.luggage.wxa.lk.j.c(this.f129765i.f125808a);
        }
        com.tencent.luggage.wxa.so.h.a();
    }

    public boolean c(String str) {
        if (this.f129779r0 == null) {
            return false;
        }
        for (int i3 = 0; i3 < this.f129779r0.length(); i3++) {
            if (this.f129779r0.optString(i3).equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, com.tencent.luggage.wxa.qc.b bVar) {
        com.tencent.luggage.wxa.kj.j.a(this, bVar);
    }

    public final void b(x xVar) {
        this.f129785x0.add(xVar);
    }

    public final void c(boolean z16) {
        if (Y() != null) {
            Y().setActuallyVisible(z16);
        }
    }

    public void b(f0 f0Var) {
        if (f0Var == null) {
            return;
        }
        this.O.remove(f0Var);
    }

    public void b(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.P.add(runnable);
    }

    public final void b(com.tencent.luggage.wxa.fd.b bVar) {
        String appId = getAppId();
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.fd.z.class));
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "setConfigEntryPath before %s", null);
        String a16 = com.tencent.luggage.wxa.fd.v.a(appId);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "setConfigEntryPath configEntryPath : %s ", a16);
        if (TextUtils.isEmpty(a16)) {
            return;
        }
        if (!bVar.c(a16)) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrandRuntime", "setConfigEntryPath urlInPages is false");
        } else {
            bVar.S = a16;
            bVar.T = true;
        }
    }

    public final void b(boolean z16) {
        if (z16) {
            a("installFileSystem(forceCreate=true)-createFileSystem", new Object[0]);
            synchronized (this.I) {
                this.I[0] = q();
            }
            return;
        }
        com.tencent.luggage.wxa.rc.r[] rVarArr = this.I;
        if (rVarArr[0] == null) {
            synchronized (rVarArr) {
                if (this.I[0] == null) {
                    a("installFileSystem(forceCreate=false)-createFileSystem", new Object[0]);
                    this.I[0] = q();
                }
            }
        }
    }

    public g(com.tencent.luggage.wxa.wj.c cVar) {
        this(cVar.getContext());
        this.f129751b = null;
        this.f129753c = cVar;
    }

    public g(com.tencent.luggage.wxa.ic.v vVar) {
        this(vVar.cloneContext());
        this.f129751b = vVar;
        this.f129753c = null;
    }

    public static /* synthetic */ void a(x xVar) {
        com.tencent.luggage.wxa.so.h.a("AppBrandRuntime.prepare(" + xVar.b() + ")");
        xVar.c();
        com.tencent.luggage.wxa.so.h.a();
    }

    public boolean b(com.tencent.luggage.wxa.xd.m mVar) {
        if (mVar == null) {
            return false;
        }
        synchronized (this.Q) {
            this.Q.remove(mVar);
        }
        return true;
    }

    public final void a(com.tencent.luggage.wxa.fd.i iVar) {
        if (!s0()) {
            if (t0() || w0()) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandRuntime", "dispatchNewConfig FATAL!! appId[%s] config[%s]", getAppId(), iVar);
                return;
            } else {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandRuntime", "dispatchNewConfig appId[%s] config[%s] !mInitialized !mFinished !mFinishing, try reload", getAppId(), iVar);
                a(iVar, "dispatchNewConfigBeforeInitialized");
                return;
            }
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "dispatchNewConfig, appId[%s] config[%s]", getAppId(), iVar);
        if (c(iVar)) {
            k1();
        }
        d(iVar);
        if (t1() || t0()) {
            return;
        }
        Iterator it = new LinkedList(this.O).iterator();
        while (it.hasNext()) {
            ((f0) it.next()).a(this, S());
        }
    }

    public void b(Configuration configuration) {
        Looper.myQueue().addIdleHandler(new v(configuration));
        com.tencent.luggage.wxa.vj.f fVar = this.f129774m0;
        if (fVar != null) {
            fVar.a(configuration);
        }
        com.tencent.luggage.wxa.fg.g.a(getAppId(), configuration);
    }

    public final void b(String str) {
        ConcurrentLinkedQueue concurrentLinkedQueue = this.f129786y0;
        if (concurrentLinkedQueue != null && concurrentLinkedQueue.size() > 0) {
            Iterator it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "%s onResourcePrepareTimeout, process[%s]", str, ((x) it.next()).toString());
            }
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "%s onResourcePrepareTimeout, no pending processes", str);
    }

    public void b(int i3) {
        if (t0()) {
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandRuntime", "finish but destroyed, appId[%s]", getAppId());
        } else {
            this.X = true;
            e(new f(i3));
        }
    }

    public void a(f0 f0Var) {
        if (f0Var == null) {
            return;
        }
        this.O.add(f0Var);
    }

    public i1 a(h1 h1Var) {
        return M();
    }

    public final void a(com.tencent.luggage.wxa.wj.c cVar) {
        this.f129753c = cVar;
    }

    public final void b(com.tencent.luggage.wxa.fd.i iVar, Object obj) {
        a(iVar, obj);
    }

    public final void a(View view) {
        if (view == null) {
            return;
        }
        o0.RemoteDebugFloatView.a(this, view);
    }

    public final void b(Runnable runnable, long j3) {
        if (runnable == null) {
            return;
        }
        if (t0()) {
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandRuntime", "scheduleToUiThreadDelayed() but finished, stackTrace = %s", Log.getStackTraceString(new Throwable()));
            return;
        }
        if (j3 < 0) {
            j3 = 0;
        }
        if (com.tencent.luggage.wxa.tn.c0.b() && 0 == j3) {
            runnable.run();
        } else {
            this.f129755d.a(runnable, j3);
        }
    }

    public final void a(com.tencent.luggage.wxa.fd.b bVar) {
        b(bVar);
        J().add(bVar);
    }

    public final void a(Lifecycle.Event event) {
        if (Lifecycle.Event.ON_DESTROY != event || this.U.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
            ((LifecycleRegistry) this.U.getLifecycle()).handleLifecycleEvent(event);
        }
    }

    public com.tencent.luggage.wxa.xd.l a(Class cls, boolean z16) {
        com.tencent.luggage.wxa.xd.l lVar;
        Iterator descendingIterator = this.K.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                lVar = null;
                break;
            }
            lVar = (com.tencent.luggage.wxa.xd.l) descendingIterator.next();
            if (cls.isInstance(lVar)) {
                break;
            }
        }
        if (lVar == null && (lVar = d(cls)) != null) {
            this.K.add(lVar);
        }
        if (lVar != null || !z16) {
            return lVar;
        }
        try {
            com.tencent.luggage.wxa.xd.l lVar2 = (com.tencent.luggage.wxa.xd.l) Reflect.on((Class<?>) cls).create().get();
            if (lVar2 != null) {
                try {
                    J().add(lVar2);
                } catch (Exception unused) {
                    lVar = lVar2;
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandRuntime", "Make sure %s has default constructor", cls.getName());
                    return lVar;
                }
            }
            return lVar2;
        } catch (Exception unused2) {
        }
    }

    @Override // com.tencent.luggage.wxa.yi.g
    public com.tencent.luggage.wxa.xd.l a(Class cls) {
        return a(cls, !this.f129783v0);
    }

    public final void a(com.tencent.luggage.wxa.xd.l lVar) {
        a(lVar, false);
    }

    public final void a(com.tencent.luggage.wxa.xd.l lVar, boolean z16) {
        if (z16) {
            Class<?> cls = lVar.getClass();
            com.tencent.luggage.wxa.er.a.b(cls, com.tencent.luggage.wxa.xd.l.class);
            Iterator descendingIterator = this.K.descendingIterator();
            while (true) {
                if (!descendingIterator.hasNext()) {
                    break;
                } else if (cls.isInstance((com.tencent.luggage.wxa.xd.l) descendingIterator.next())) {
                    descendingIterator.remove();
                    break;
                }
            }
        }
        this.K.add(lVar);
    }

    public boolean a(com.tencent.luggage.wxa.xd.m mVar) {
        if (mVar == null) {
            return false;
        }
        synchronized (this.Q) {
            this.Q.add(mVar);
        }
        return true;
    }

    public final void a(Class cls, com.tencent.luggage.wxa.ya.a aVar) {
        this.R.a(cls, aVar);
    }

    public final void a(com.tencent.luggage.wxa.ic.l lVar) {
        com.tencent.luggage.wxa.er.a.a(lVar);
        if (this.f129767j != null && this.f129767j.R()) {
            if (lVar == null || lVar.getRuntime() == null || this == lVar.getRuntime()) {
                return;
            }
            com.tencent.luggage.wxa.er.a.a("attachRuntimeToService with other runtime's service!");
            return;
        }
        this.f129767j = lVar;
        this.f129767j.a0();
        b(lVar);
        this.f129767j.a(this);
    }

    public final void a(g0 g0Var) {
        if (g0Var == null) {
            return;
        }
        if (this.Y) {
            g0Var.a();
        } else {
            this.M.add(g0Var);
        }
    }

    public final void a(m0 m0Var) {
        this.N.a(m0Var);
    }

    public final void a(boolean z16) {
        boolean s06 = s0();
        boolean B0 = B0();
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "dispatchPauseImpl(%s), initialized:%b, resumed:%b, destroyed:%b, forDestroy:%b", this, Boolean.valueOf(s06), Boolean.valueOf(B0), Boolean.valueOf(t0()), Boolean.valueOf(z16));
        if (s06) {
            if ((z16 || !t0()) && B0) {
                a(MiniSDKConst.NOTIFY_EVENT_ONPAUSE, new Object[0]);
                this.f129750a0 = false;
                Q0();
                this.T.j();
                this.f129767j.X();
                this.f129769k.j();
                com.tencent.luggage.wxa.ic.e.h(this.f129761g);
                com.tencent.luggage.wxa.ic.e.a(this.f129761g, e.b.ON_PAUSE);
                a(Lifecycle.Event.ON_PAUSE);
                a(Lifecycle.Event.ON_STOP);
                this.S.b();
                com.tencent.luggage.wxa.zd.d.a(this.f129767j);
            }
        }
    }

    public final void a(int i3) {
        boolean andSet = this.f129752b0.getAndSet(true);
        a("dispatchDestroy, destroyed?[%b] initialized?[%b] initReady?[%b] reason[%d]", Boolean.valueOf(andSet), Boolean.valueOf(s0()), Boolean.valueOf(this.Y), Integer.valueOf(i3));
        if (andSet) {
            return;
        }
        synchronized (this) {
            this.Z = false;
        }
        if (B0()) {
            a(true);
        }
        n();
        e(i3);
        K0();
        this.f129759f.a();
        this.f129755d.a((Object) null);
        this.T.n();
        com.tencent.luggage.wxa.ic.e.f(this.f129761g);
        com.tencent.luggage.wxa.ic.e.a(this.f129761g, e.b.ON_DESTROY);
        a(Lifecycle.Event.ON_DESTROY);
        if (this.f129767j != null) {
            this.f129767j.e();
            this.f129767j = null;
        }
        if (this.f129769k != null) {
            this.f129769k.a();
            this.f129769k = null;
        }
        com.tencent.luggage.wxa.rc.r[] rVarArr = this.I;
        if (rVarArr[0] != null) {
            synchronized (rVarArr) {
                com.tencent.luggage.wxa.rc.r rVar = this.I[0];
                if (rVar != null) {
                    try {
                        rVar.release();
                        this.I[0] = null;
                    } catch (Throwable th5) {
                        this.I[0] = null;
                        throw th5;
                    }
                }
            }
        }
        com.tencent.luggage.wxa.oi.a.d(getAppId());
        String g16 = com.tencent.luggage.wxa.tn.z.g();
        com.tencent.luggage.wxa.ka.o.b(g16, this.A0);
        com.tencent.luggage.wxa.ka.o.b(g16, this.B0);
        com.tencent.luggage.wxa.h6.h.a(L());
        this.W = null;
        this.f129777p0 = null;
        this.f129778q0 = null;
        this.f129779r0 = null;
        this.f129780s0 = null;
        this.f129782u0 = null;
        this.f129781t0 = null;
        com.tencent.luggage.wxa.yi.f.b().a(this);
        com.tencent.luggage.wxa.yi.c.b().b(getAppId());
        com.tencent.luggage.wxa.yi.p.b().b(getAppId());
        com.tencent.luggage.wxa.yi.s.b().b(getAppId());
        com.tencent.luggage.wxa.ic.e.a(this.f129761g);
        this.f129771l.setOnHierarchyChangeListener(null);
        this.f129771l.removeAllViewsInLayout();
        com.tencent.luggage.wxa.ml.g gVar = this.E;
        if (gVar != null) {
            gVar.e();
            this.E = null;
        }
        com.tencent.luggage.wxa.ml.g gVar2 = this.D;
        if (gVar2 != null) {
            gVar2.e();
            this.D = null;
        }
        com.tencent.luggage.wxa.ml.g gVar3 = this.F;
        if (gVar3 != null) {
            gVar3.e();
            this.F = null;
        }
        com.tencent.luggage.wxa.lj.e eVar = this.G;
        if (eVar != null) {
            eVar.b();
        }
        com.tencent.luggage.wxa.vj.f fVar = this.f129774m0;
        if (fVar != null) {
            fVar.o();
            this.f129774m0 = null;
        }
        try {
            com.tencent.luggage.wxa.il.e eVar2 = this.f129775n0;
            if (eVar2 != null) {
                eVar2.removeAllViewsInLayout();
            }
            this.f129775n0 = null;
            this.f129776o0 = null;
            J().clear();
            synchronized (this.Q) {
                this.Q.clear();
            }
            com.tencent.luggage.wxa.mc.k0.a(this);
            this.R.a();
            this.f129756d0 = null;
            this.D0.clear();
            this.E0.a(2);
            this.f129755d.a((Object) null);
            p1();
            this.F0.clear();
            this.C = false;
            com.tencent.luggage.wxa.kj.s.a(this);
            com.tencent.luggage.wxa.fg.g.a(getAppId());
            this.M.clear();
            this.N.c();
            this.O.clear();
            this.f129751b = null;
            com.tencent.luggage.wxa.uk.i iVar = this.S;
            if (iVar != null) {
                iVar.a();
                this.S = null;
            }
            this.f129754c0.a();
            v();
            Iterator it = new LinkedList(this.P).iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            this.P.clear();
            com.tencent.luggage.wxa.il.n nVar = this.H0;
            if (nVar != null) {
                nVar.a();
            }
            a("dispatchDestroy, completed", new Object[0]);
        } catch (Throwable th6) {
            this.f129775n0 = null;
            this.f129776o0 = null;
            throw th6;
        }
    }

    public void a(com.tencent.luggage.wxa.fd.i iVar, String str) {
        if (!B0() && (iVar == null || !iVar.C)) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "reload but !isResumed, destroy and update config, appId:%s, reason:%s", getAppId(), str);
            a(1);
            if (iVar != null) {
                this.f129765i = iVar;
                return;
            }
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "reload --START-- appId:%s, reason:%s stacktrace=%s", getAppId(), str, Log.getStackTraceString(new Throwable()));
        com.tencent.luggage.wxa.ic.v vVar = this.f129751b;
        y();
        a(2);
        a(vVar);
        if (iVar == null) {
            iVar = S();
        }
        b(iVar);
        if (vVar != null) {
            vVar.e(this);
        }
        F0();
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "reload --END-- appId:%s", getAppId());
    }

    public final void a(Object obj) {
        a(obj, (Runnable) null);
    }

    public final void a(Object obj, Runnable runnable) {
        e(new RunnableC6296g(runnable, obj));
    }

    public final void a(Runnable runnable, boolean z16) {
        this.f129755d.a(runnable, z16);
    }

    public final void a(Runnable runnable, long j3) {
        if (runnable == null || t0()) {
            return;
        }
        if (j3 < 0) {
            j3 = 0;
        }
        com.tencent.luggage.wxa.uk.z a16 = com.tencent.luggage.wxa.uk.z.a(this.f129759f, runnable);
        b((com.tencent.luggage.wxa.vo.a) a16);
        com.tencent.luggage.wxa.zp.h.f146825d.a(a16, j3);
    }

    public void a(int i3, int i16, z zVar) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandRuntime", "addKeyEventObserver");
        e(new m(zVar, i16, i3));
    }

    public void a(z zVar) {
        e(new n(zVar));
    }

    public boolean a(int i3, KeyEvent keyEvent) {
        Set<z> set = (Set) this.F0.get(i3);
        boolean z16 = false;
        if (set == null) {
            return false;
        }
        for (z zVar : set) {
            int i16 = zVar.f130018b;
            if (i16 == -1 || i16 == keyEvent.getAction()) {
                z16 |= zVar.a(keyEvent);
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.tencent.luggage.wxa.il.f fVar) {
        o0.PipContainer.a(this, fVar);
    }

    public final void a(Configuration configuration) {
        com.tencent.luggage.wxa.kj.n currentPage;
        if (this.f129769k == null || (currentPage = this.f129769k.getCurrentPage()) == null) {
            return;
        }
        com.tencent.luggage.wxa.kl.d X = currentPage.getCurrentPageView().X();
        com.tencent.luggage.wxa.vj.f a06 = a0();
        com.tencent.luggage.wxa.il.f l3 = a06 != null ? a06.l() : null;
        if (l3 == null || X == null) {
            return;
        }
        int height = X.getHeight();
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandRuntime", "adjustPipContainerViewPositionRange, actionBarContainerHeight: " + height);
        l3.a(height, configuration);
    }
}
