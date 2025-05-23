package com.tencent.luggage.wxa.vj;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.luggage.wxa.ag.b;
import com.tencent.luggage.wxa.ag.i;
import com.tencent.luggage.wxa.ag.j;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.kj.k1;
import com.tencent.luggage.wxa.kj.p;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.p004if.b0;
import com.tencent.luggage.wxa.p004if.p;
import com.tencent.luggage.wxa.p004if.r;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.uk.f0;
import com.tencent.luggage.wxa.vj.a;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f {
    public volatile boolean A;

    /* renamed from: b, reason: collision with root package name */
    public final Context f143576b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ic.g f143577c;

    /* renamed from: d, reason: collision with root package name */
    public final p f143578d;

    /* renamed from: e, reason: collision with root package name */
    public final o f143579e;

    /* renamed from: a, reason: collision with root package name */
    public final String f143575a = "MicroMsg.AppBrand.AppBrandPipManager#" + hashCode();

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.il.f f143580f = null;

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f143581g = false;

    /* renamed from: h, reason: collision with root package name */
    public final Map f143582h = new ConcurrentHashMap();

    /* renamed from: i, reason: collision with root package name */
    public final Map f143583i = new ConcurrentHashMap();

    /* renamed from: j, reason: collision with root package name */
    public View f143584j = null;

    /* renamed from: k, reason: collision with root package name */
    public com.tencent.luggage.wxa.vj.b f143585k = null;

    /* renamed from: l, reason: collision with root package name */
    public com.tencent.luggage.wxa.ag.i f143586l = null;

    /* renamed from: m, reason: collision with root package name */
    public String f143587m = null;

    /* renamed from: n, reason: collision with root package name */
    public com.tencent.luggage.wxa.kj.n f143588n = null;

    /* renamed from: o, reason: collision with root package name */
    public boolean f143589o = true;

    /* renamed from: p, reason: collision with root package name */
    public a.d f143590p = null;

    /* renamed from: q, reason: collision with root package name */
    public j.a f143591q = null;

    /* renamed from: r, reason: collision with root package name */
    public volatile boolean f143592r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f143593s = false;

    /* renamed from: t, reason: collision with root package name */
    public volatile Integer f143594t = null;

    /* renamed from: u, reason: collision with root package name */
    public boolean f143595u = false;

    /* renamed from: v, reason: collision with root package name */
    public boolean f143596v = false;

    /* renamed from: w, reason: collision with root package name */
    public f0 f143597w = null;

    /* renamed from: x, reason: collision with root package name */
    public f0 f143598x = null;

    /* renamed from: y, reason: collision with root package name */
    public p.a f143599y = null;

    /* renamed from: z, reason: collision with root package name */
    public final b0 f143600z = new b0(new g(), f());

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends e.c {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            com.tencent.luggage.wxa.ag.j jVar;
            w.d(f.this.f143575a, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            if (f.this.f143590p != null && (jVar = f.this.f143590p.f143527h) != null) {
                jVar.release();
            }
            f.this.f143578d.setPipPageLifeCycleListener(null);
            com.tencent.luggage.wxa.ic.e.b(f.this.f143577c.getAppId(), this);
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onPause(e.d dVar) {
            w.d(f.this.f143575a, "onPause, type: " + dVar);
            f.this.A = true;
            if (f.this.f143593s) {
                w.d(f.this.f143575a, "pipVideo has stopped, skip");
                return;
            }
            if (f.this.f143590p == null) {
                return;
            }
            if (f.this.f143587m != null) {
                f.this.a(MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
            }
            com.tencent.luggage.wxa.ag.j jVar = f.this.f143590p.f143527h;
            if (jVar != null) {
                if (jVar.c()) {
                    w.d(f.this.f143575a, "background play enabled, skip");
                    return;
                }
                r g16 = jVar.g();
                w.d(f.this.f143575a, "onPause, autoPauseStrategy: %s", g16);
                if (!g16.a(f.this.f143577c.h0(), dVar)) {
                    w.d(f.this.f143575a, "onPause, not need pause video play");
                } else {
                    w.d(f.this.f143575a, "onPause, pause");
                    jVar.pause();
                }
            }
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onResume() {
            w.d(f.this.f143575a, "onResume");
            f.this.A = false;
            if (f.this.f143593s) {
                w.d(f.this.f143575a, "pipVideo has stopped, skip");
                return;
            }
            if (f.this.f143590p == null) {
                return;
            }
            if (f.this.f143587m != null) {
                f.this.c("onResume");
            }
            com.tencent.luggage.wxa.ag.j jVar = f.this.f143590p.f143527h;
            if (jVar != null) {
                if (jVar.c()) {
                    w.d(f.this.f143575a, "background play enabled, skip");
                } else {
                    w.d(f.this.f143575a, "onResume, start");
                    jVar.start();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements p.n0 {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.kj.p.n0
        public void a(com.tencent.luggage.wxa.kj.n nVar) {
            w.d(f.this.f143575a, "onPageDestroy, page: " + f.b(nVar));
            if (nVar.o()) {
                w.d(f.this.f143575a, "onPageDestroy, " + f.b(nVar) + " is PipVideoRelated");
            } else {
                v currentPageView = nVar.getCurrentPageView();
                w.d(f.this.f143575a, "onPageDestroy, remove " + currentPageView + " from mPageView2PageScopedPipInfoMap");
                f.this.f143582h.remove(Integer.valueOf(currentPageView.hashCode()));
            }
            if (f.this.f143588n != null && nVar == f.this.f143588n) {
                f.this.f143589o = false;
                f.this.f143578d.setPipVideoRelatedPage(f.this.f143588n);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements p.f0 {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements p.e0 {
            public a() {
            }

            @Override // com.tencent.luggage.wxa.kj.p.e0
            public v a(com.tencent.luggage.wxa.kj.p pVar, String str) {
                return null;
            }

            @Override // com.tencent.luggage.wxa.kj.p.e0
            public boolean a(v vVar, String str) {
                return false;
            }

            @Override // com.tencent.luggage.wxa.kj.p.e0
            public boolean a(String str) {
                return false;
            }

            @Override // com.tencent.luggage.wxa.kj.p.e0
            public boolean a(String str, k1 k1Var, com.tencent.luggage.wxa.kj.p pVar, p.h0 h0Var) {
                return false;
            }

            @Override // com.tencent.luggage.wxa.kj.p.e0
            public com.tencent.luggage.wxa.kj.n a(String str, k1 k1Var, com.tencent.luggage.wxa.kj.p pVar, Callable callable) {
                if (e.this.a(str, k1Var)) {
                    return f.this.f143588n;
                }
                return null;
            }
        }

        public e() {
        }

        @Override // com.tencent.luggage.wxa.kj.p.f0
        public p.e0 a(p.e0 e0Var) {
            if (e0Var == null) {
                e0Var = new a();
            }
            return new b(e0Var);
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b implements p.e0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ p.e0 f143618a;

            public b(p.e0 e0Var) {
                this.f143618a = e0Var;
            }

            @Override // com.tencent.luggage.wxa.kj.p.e0
            public com.tencent.luggage.wxa.kj.n a(String str, k1 k1Var, com.tencent.luggage.wxa.kj.p pVar, Callable callable) {
                if (e.this.a(str, k1Var)) {
                    return f.this.f143588n;
                }
                return this.f143618a.a(str, k1Var, pVar, callable);
            }

            @Override // com.tencent.luggage.wxa.kj.p.e0
            public boolean a(v vVar, String str) {
                return this.f143618a.a(vVar, str);
            }

            @Override // com.tencent.luggage.wxa.kj.p.e0
            public v a(com.tencent.luggage.wxa.kj.p pVar, String str) {
                return this.f143618a.a(pVar, str);
            }

            @Override // com.tencent.luggage.wxa.kj.p.e0
            public boolean a(String str, k1 k1Var, com.tencent.luggage.wxa.kj.p pVar, p.h0 h0Var) {
                return this.f143618a.a(str, k1Var, pVar, h0Var);
            }

            @Override // com.tencent.luggage.wxa.kj.p.e0
            public boolean a(String str) {
                return this.f143618a.a(str);
            }
        }

        public final boolean a(String str, k1 k1Var) {
            if (k1.NAVIGATE_TO != k1Var || f.this.f143589o || f.this.f143588n == null || !f.this.f143588n.getCurrentUrl().equals(str)) {
                return false;
            }
            w.d(f.this.f143575a, "onCreatePage, reuse " + f.b(f.this.f143588n));
            return true;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.vj.f$f, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6854f implements p.a {

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ boolean f143620b = true;

        public C6854f() {
        }

        public final boolean a() {
            if (f.this.A) {
                w.d(f.this.f143575a, "interceptAudioFocusChange, runtime paused");
                return true;
            }
            if (f.this.f143590p == null) {
                w.a(f.this.f143575a, "interceptAudioFocusChange, mPipVideoSession is null");
                return true;
            }
            if (f.this.f143587m != null && (!f.this.f143595u || !f.this.f143596v)) {
                return false;
            }
            w.a(f.this.f143575a, "interceptAudioFocusChange, mPipVideoRelatedKey is null or is transfering from");
            return true;
        }

        @Override // com.tencent.luggage.wxa.if.p.a
        public void onPause() {
            w.d(f.this.f143575a, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
            if (a()) {
                return;
            }
            if (!f143620b && f.this.f143590p == null) {
                throw new AssertionError();
            }
            f.this.f143590p.f143527h.pause();
        }

        @Override // com.tencent.luggage.wxa.if.p.a
        public void onResume() {
            w.d(f.this.f143575a, "onResume");
            if (a()) {
                return;
            }
            if (!f143620b && f.this.f143590p == null) {
                throw new AssertionError();
            }
            f.this.f143590p.f143527h.start();
        }

        @Override // com.tencent.luggage.wxa.if.p.a
        public void onStop() {
            w.d(f.this.f143575a, DKHippyEvent.EVENT_STOP);
            if (a()) {
                return;
            }
            if (!f143620b && f.this.f143590p == null) {
                throw new AssertionError();
            }
            f.this.f143590p.f143527h.pause();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements Function0 {
        public g() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.ic.g invoke() {
            return f.this.f143577c;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            w.d(f.this.f143575a, "onCloseButtonClick");
            if (f.this.f143592r) {
                w.f(f.this.f143575a, "onCloseButtonClick when mPipClickProcessing, return");
            } else {
                if (f.this.f143595u) {
                    w.f(f.this.f143575a, "onCloseButtonClick when mIsTransfering, return");
                    return;
                }
                if (f.this.f143590p != null) {
                    f.t(f.this);
                }
                f.this.b();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            w.d(f.this.f143575a, "onClick, mIsPipVideoRelatedPagePushed: " + f.this.f143589o + ", mPipVideoRelatedPage: " + f.b(f.this.f143588n));
            if (f.this.f143595u) {
                w.d(f.this.f143575a, "onClick when mIsTransfering, return");
                return;
            }
            if (!f.this.f143592r && f.this.f143588n != null) {
                if (f.this.f143589o) {
                    f.this.f143578d.b(f.this.f143588n, "scene_other");
                } else {
                    f.this.f143578d.j(f.this.f143588n.getCurrentUrl());
                }
                f.this.f143592r = true;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d(f.this.f143575a, "transferFrom, dismissTask run");
            f.this.f143597w = null;
            if (f.this.f143580f != null && f.this.f143584j != null && f.this.f143586l != null) {
                f.this.f143580f.b(f.this.f143584j);
                f.this.f143586l.a(f.this.f143584j);
                f.this.f143580f.setVisibility(4);
                f.this.f143584j = null;
                f.this.f143585k = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d(f.this.f143575a, "transferTo, showTask run");
            if (f.this.f143580f == null) {
                return;
            }
            f.this.f143580f.a(true);
            f.this.f143580f.setVisibility(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d(f.this.f143575a, "transferTo, hideTask run");
            if (f.this.f143580f == null) {
                return;
            }
            f.this.f143580f.setVisibility(4);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable c16;
            w.d(f.this.f143575a, "transferTo, run pendingCancelableShowTask");
            if (f.this.f143598x == null) {
                w.d(f.this.f143575a, "transferTo, pendingCancelableShowTask is null");
                return;
            }
            f.this.f143598x.a();
            if (!f.this.f143598x.d() && (c16 = f.this.f143598x.c()) != null) {
                w.d(f.this.f143575a, "transferTo, run extraTask");
                c16.run();
            }
            f.this.f143598x = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface o {
        void a(com.tencent.luggage.wxa.il.f fVar);
    }

    public f(Context context, com.tencent.luggage.wxa.ic.g gVar, o oVar) {
        this.f143576b = context;
        this.f143577c = gVar;
        this.f143578d = gVar.Y();
        this.f143579e = oVar;
        this.A = !gVar.B0();
    }

    public static /* synthetic */ com.tencent.luggage.wxa.vj.d t(f fVar) {
        fVar.getClass();
        return null;
    }

    public final void a() {
    }

    public final j.a h() {
        if (this.f143591q == null) {
            this.f143591q = new d();
        }
        return this.f143591q;
    }

    public final p.f0 i() {
        return new e();
    }

    public final p.n0 j() {
        return new b();
    }

    public com.tencent.luggage.wxa.il.f k() {
        if (this.f143580f == null) {
            com.tencent.luggage.wxa.il.f fVar = new com.tencent.luggage.wxa.il.f(this.f143576b);
            this.f143580f = fVar;
            fVar.setVisibility(4);
            this.f143580f.setOnCloseButtonClickListener(new h());
            this.f143580f.setOnClickListener(new i());
            this.f143579e.a(this.f143580f);
            ViewGroup.LayoutParams layoutParams = this.f143580f.getLayoutParams();
            layoutParams.width = com.tencent.luggage.wxa.il.f.T;
            layoutParams.height = com.tencent.luggage.wxa.il.f.U;
            this.f143580f.setLayoutParams(layoutParams);
            a();
        }
        return this.f143580f;
    }

    public com.tencent.luggage.wxa.il.f l() {
        return this.f143580f;
    }

    public final void m() {
        this.f143578d.setPipPageLifeCycleListener(j());
        this.f143578d.setOnPageSwitchListener(g());
        com.tencent.luggage.wxa.ic.e.a(this.f143577c.getAppId(), e());
        this.f143578d.setDelegateWrapperFactory(i());
    }

    public final boolean n() {
        Set set;
        Integer num = this.f143594t;
        if (num != null) {
            return (this.f143583i.isEmpty() || (set = (Set) this.f143583i.get(num)) == null || set.isEmpty()) ? false : true;
        }
        w.f(this.f143575a, "isVideoInPipVideoTargetPageViewPlaying, pipVideoTargetPageViewId is null");
        return false;
    }

    public void o() {
        this.f143582h.clear();
        this.f143583i.clear();
    }

    public String c() {
        return this.f143577c.getAppId();
    }

    public final com.tencent.luggage.wxa.vj.a d() {
        for (com.tencent.luggage.wxa.vj.a aVar : this.f143582h.values()) {
            if (aVar.d()) {
                return aVar;
            }
        }
        return null;
    }

    public final e.c e() {
        return new a();
    }

    public final p.a f() {
        if (this.f143599y == null) {
            this.f143599y = new C6854f();
        }
        return this.f143599y;
    }

    public final p.i0 g() {
        return new c();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements p.i0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f143603a = false;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (f.this.a(false)) {
                    f.t(f.this);
                    f.this.a("onPageSwitchEnd 1");
                    w.d(f.this.f143575a, "onPageSwitchEnd, clearPipVideoRelated");
                    f.this.a(true, true);
                }
            }
        }

        public c() {
        }

        @Override // com.tencent.luggage.wxa.kj.p.i0
        public void a(k1 k1Var, com.tencent.luggage.wxa.kj.n nVar, com.tencent.luggage.wxa.kj.n nVar2, float f16) {
            if (!f.this.f143595u || f.this.f143587m == null || f.this.f143585k == null) {
                return;
            }
            if (f.this.f143596v) {
                f.this.f143585k.b(100.0f - f16);
            } else {
                f.this.f143585k.b(f16);
            }
        }

        @Override // com.tencent.luggage.wxa.kj.p.i0
        public void b(k1 k1Var, com.tencent.luggage.wxa.kj.n nVar, com.tencent.luggage.wxa.kj.n nVar2) {
            boolean z16;
            String b16 = f.b(nVar);
            String b17 = f.b(nVar2);
            w.d(f.this.f143575a, "onPageSwitchCancel, type: %s, oldPage: %s, newPage: %s", k1Var, b16, b17);
            if (f.this.f143595u && f.this.f143588n != null && f.this.f143580f != null) {
                f.this.f143594t = null;
                w.d(f.this.f143575a, "onPageSwitchCancel, mPipVideoTargetPageViewId about null");
                if (nVar == f.this.f143588n && f.this.a(true)) {
                    f.t(f.this);
                    f.this.a("onPageSwitchCancel");
                    f.this.a(false, false);
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (f.this.f143596v && f.this.f143585k != null) {
                    f.this.f143585k.d();
                }
                f.this.f143595u = false;
                f.this.f143596v = false;
                f.this.f143580f.b(true ^ z16);
                return;
            }
            if (!f.this.f143595u) {
                if (nVar != null) {
                    f.this.f143594t = Integer.valueOf(nVar.getCurrentPageView().hashCode());
                    w.d(f.this.f143575a, "onPageSwitchCancel, mPipVideoTargetPageViewId: %d(%s)", f.this.f143594t, b17);
                    return;
                } else {
                    w.f(f.this.f143575a, "onPageSwitchCancel, oldPage is null");
                    return;
                }
            }
            w.d(f.this.f143575a, "onPageSwitchCancel, isTransfering but mPipVideoRelatedPage or mPipContainerView is null");
        }

        @Override // com.tencent.luggage.wxa.kj.p.i0
        public p.m0 c(k1 k1Var, com.tencent.luggage.wxa.kj.n nVar, com.tencent.luggage.wxa.kj.n nVar2) {
            a.d b16;
            boolean z16;
            String b17 = f.b(nVar);
            String b18 = f.b(nVar2);
            w.d(f.this.f143575a, "onPageSwitchStart, pageOpenType: %s, oldPage: %s, page: %s", k1Var, b17, b18);
            if (nVar == null || nVar2 == null) {
                return null;
            }
            if (f.this.f143587m == null || f.this.f143588n == null) {
                com.tencent.luggage.wxa.vj.a d16 = f.this.d();
                if (d16 == null || nVar2.equals(d16.a()) || (b16 = d16.b()) == null) {
                    return null;
                }
                com.tencent.luggage.wxa.ag.h hVar = b16.f143526g;
                i.a aVar = b16.f143524e;
                com.tencent.luggage.wxa.ag.j jVar = b16.f143527h;
                if (hVar == null || aVar == null || jVar == null) {
                    return null;
                }
                b.EnumC6005b enumC6005b = b16.f143521b;
                boolean b19 = f.this.b(k1Var, enumC6005b);
                boolean a16 = f.this.a(k1Var, enumC6005b);
                if (b19 || a16) {
                    w.d(f.this.f143575a, "onPageSwitchStart, transferTo");
                    if (f.this.a(nVar.getCurrentPageView(), hVar, aVar, jVar)) {
                        f.this.f143594t = Integer.valueOf(nVar2.getCurrentPageView().hashCode());
                        w.d(f.this.f143575a, "onPageSwitchStart, mPipVideoTargetPageViewId: %d(%s)", f.this.f143594t, b18);
                        f.this.a(d16, b16);
                        f.this.f143593s = false;
                        if (f.this.f143590p != null) {
                            f.t(f.this);
                        }
                        f.this.f143595u = true;
                        f.this.f143596v = false;
                        f.this.f143580f.c();
                        return p.m0.MIN;
                    }
                    return null;
                }
                return null;
            }
            if (nVar2 == f.this.f143588n) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f143603a = z16;
            if (z16 || k1.RE_LAUNCH == k1Var || k1.AUTO_RE_LAUNCH == k1Var) {
                if (f.this.f143585k != null) {
                    f.this.f143594t = null;
                    w.d(f.this.f143575a, "onPageSwitchStart, mPipVideoTargetPageViewId about null");
                    f.this.f143595u = true;
                    f.this.f143596v = true;
                    f.this.f143580f.c();
                    return p.m0.MAX;
                }
                w.f(f.this.f143575a, "onPageSwitchStart, null == mPipContainerOnPageSwitchHandler");
            }
            f.this.f143594t = Integer.valueOf(nVar2.getCurrentPageView().hashCode());
            w.d(f.this.f143575a, "onPageSwitchStart, mPipVideoTargetPageViewId: %d(%s)", f.this.f143594t, b18);
            return null;
        }

        @Override // com.tencent.luggage.wxa.kj.p.i0
        public void a(k1 k1Var, com.tencent.luggage.wxa.kj.n nVar, com.tencent.luggage.wxa.kj.n nVar2) {
            v currentPageView;
            com.tencent.luggage.wxa.vj.a aVar;
            w.d(f.this.f143575a, "onPageSwitchEnd, pageOpenType: %s, oldPage: %s, page: %s", k1Var, f.b(nVar), f.b(nVar2));
            if (nVar != null && (currentPageView = nVar.getCurrentPageView()) != null && (aVar = (com.tencent.luggage.wxa.vj.a) f.this.f143582h.get(Integer.valueOf(currentPageView.hashCode()))) != null && k1.NAVIGATE_BACK == k1Var && nVar != f.this.f143588n) {
                aVar.f();
            }
            if (f.this.f143595u && f.this.f143596v) {
                w.d(f.this.f143575a, "onPageSwitchEnd, tryTransferFrom, isBack: " + this.f143603a);
                if (f.this.a(true)) {
                    f.t(f.this);
                    f.this.a("onPageSwitchEnd 0");
                    if (!this.f143603a) {
                        w.d(f.this.f143575a, "onPageSwitchEnd, clearPipVideoRelated");
                    }
                    f fVar = f.this;
                    boolean z16 = !this.f143603a;
                    fVar.a(z16, z16);
                }
                f.this.f143592r = false;
                f.this.f143596v = false;
                f.this.f143595u = false;
            }
            if (f.this.f143595u && f.this.f143587m != null && f.this.f143585k != null) {
                f.this.f143585k.d();
                f.this.f143595u = false;
                if (f.this.f143580f != null) {
                    f.this.f143580f.b(true);
                }
                f.this.c("onPageSwitchEnd");
            }
            if (!f.this.n() || f.this.f143587m == null || f.this.f143580f == null) {
                return;
            }
            w.d(f.this.f143575a, "onPageSwitchEnd, transferFrom for other video is playing");
            f.this.f143580f.post(new a());
        }
    }

    public final void c(String str) {
        w.a(this.f143575a, str + ", requestAudioFocus");
        this.f143600z.b();
    }

    public final void b(int i3, j.b bVar, String str) {
        com.tencent.luggage.wxa.vj.a b16 = b(i3);
        if (b16 == null) {
            return;
        }
        b16.b(bVar, str);
    }

    public boolean b(String str) {
        return Objects.equals(this.f143587m, str);
    }

    public final com.tencent.luggage.wxa.vj.a b(int i3) {
        com.tencent.luggage.wxa.vj.a aVar = (com.tencent.luggage.wxa.vj.a) this.f143582h.get(Integer.valueOf(i3));
        if (aVar != null) {
            return aVar;
        }
        w.f(this.f143575a, "getPageScopedPipInfo, null == pageScopedPipInfo");
        return null;
    }

    public final com.tencent.luggage.wxa.vj.a b(v vVar) {
        return b(vVar.hashCode());
    }

    public final boolean b(k1 k1Var, b.EnumC6005b enumC6005b) {
        return (b.EnumC6005b.PUSH == enumC6005b || b.EnumC6005b.PUSH_AND_POP == enumC6005b) && k1.NAVIGATE_TO == k1Var;
    }

    public final void b() {
        if (a(false)) {
            a("exitPip");
            w.d(this.f143575a, "exitPip, clearPipVideoRelated");
            a(true, true);
        }
        com.tencent.luggage.wxa.il.f fVar = this.f143580f;
        if (fVar != null) {
            fVar.setVisibility(4);
        }
    }

    public void a(Configuration configuration) {
        w.d(this.f143575a, "onConfigurationChanged: newConfig: " + configuration);
        com.tencent.luggage.wxa.vj.b bVar = this.f143585k;
        if (bVar != null) {
            bVar.a(configuration);
        }
    }

    public void a(v vVar) {
        if (((com.tencent.luggage.wxa.vj.a) this.f143582h.get(Integer.valueOf(vVar.hashCode()))) != null) {
            return;
        }
        com.tencent.luggage.wxa.vj.a aVar = new com.tencent.luggage.wxa.vj.a(vVar);
        aVar.a(h());
        w.d(this.f143575a, "createPageScopedPipInfoIfNeed for " + b(vVar.b0()));
        this.f143582h.put(Integer.valueOf(vVar.hashCode()), aVar);
    }

    public final void b(int i3, String str, String str2) {
        Set set = (Set) this.f143583i.get(Integer.valueOf(i3));
        if (set != null) {
            w.d(this.f143575a, str2 + ", mPageView2VideosMap remove " + str + " for " + i3);
            set.remove(str);
        }
    }

    public static String b(com.tencent.luggage.wxa.kj.n nVar) {
        if (nVar == null) {
            return "null";
        }
        return nVar.getClass().getSimpleName() + "@" + nVar.hashCode() + "(" + nVar.getCurrentUrl() + ")";
    }

    public void a(v vVar, String str, int i3, com.tencent.luggage.wxa.ag.b bVar, com.tencent.luggage.wxa.ag.h hVar, i.a aVar, com.tencent.luggage.wxa.ag.d dVar, com.tencent.luggage.wxa.vj.c cVar) {
        com.tencent.luggage.wxa.vj.a b16 = b(vVar);
        if (b16 == null) {
            return;
        }
        b16.a(str, i3, bVar, hVar, aVar, dVar, cVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements j.a {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.f143580f.f();
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.f143580f.e();
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (f.this.f143586l != null && f.this.f143584j != null) {
                    f.this.f143586l.a(f.this.f143584j, null);
                }
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.vj.f$d$d, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6852d implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f143610a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ float f143611b;

            public RunnableC6852d(boolean z16, float f16) {
                this.f143610a = z16;
                this.f143611b = f16;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f143610a) {
                    f.this.f143580f.a(this.f143611b);
                } else {
                    f.this.f143580f.d();
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class e implements Runnable {
            public e() {
            }

            @Override // java.lang.Runnable
            public void run() {
                w.d(f.this.f143575a, "onPlayEnd, onPlayEndWorkaround");
                if (f.this.f143586l != null && f.this.f143584j != null) {
                    f.this.f143586l.b(f.this.f143584j);
                }
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.vj.f$d$f, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6853f implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f143614a;

            public RunnableC6853f(boolean z16) {
                this.f143614a = z16;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (f.this.a(false)) {
                    f.t(f.this);
                    f.this.a("processTransferFromOnPlay");
                    w.d(f.this.f143575a, "processTransferFromOnPlay, clearPipVideoRelated");
                    f.this.a(true, true);
                }
            }
        }

        public d() {
        }

        @Override // com.tencent.luggage.wxa.ag.j.a
        public void a(com.tencent.luggage.wxa.ag.j jVar, boolean z16) {
            String key = jVar.getKey();
            w.d(f.this.f143575a, "onPlay, key: " + key);
            if (f.this.A) {
                w.d(f.this.f143575a, "onPlay, runtime paused");
                return;
            }
            Integer d16 = jVar.d();
            if (d16 == null) {
                w.f(f.this.f143575a, "onPlay, pageViewId is null");
            } else {
                a.d a16 = f.this.a(d16.intValue(), key);
                if (a16 != null && b.EnumC6005b.a(a16.f143521b)) {
                    f.this.a(d16.intValue(), jVar.getType(), key);
                }
            }
            f.t(f.this);
            if (!f.this.n() || f.this.f143587m == null || !f.this.f143587m.equals(key) || f.this.f143580f == null) {
                if (f.this.f143587m == null || !f.this.f143587m.equals(key)) {
                    if (d16 != null) {
                        f.this.a(d16.intValue(), key, "onPlay");
                    }
                    if ((f.this.f143595u && f.this.f143596v) || f.this.f143587m == null || f.this.f143580f == null) {
                        return;
                    }
                    a(z16);
                    return;
                }
                w.d(f.this.f143575a, "onPlay, mark pip video play");
                com.tencent.luggage.wxa.zp.h.f146825d.a(new c());
                f.this.f143593s = false;
                f.this.c("onPlay");
                return;
            }
            w.d(f.this.f143575a, "processTransferFromOnPlay for other video is playing");
            a(z16);
        }

        @Override // com.tencent.luggage.wxa.ag.j.a
        public void b(com.tencent.luggage.wxa.ag.j jVar) {
            String key = jVar.getKey();
            w.d(f.this.f143575a, "onError, key: " + key);
        }

        @Override // com.tencent.luggage.wxa.ag.j.a
        public void c(com.tencent.luggage.wxa.ag.j jVar) {
            String key = jVar.getKey();
            w.d(f.this.f143575a, "onStop, key: " + key);
            if (f.this.f143587m != null && f.this.f143587m.equals(key) && f.this.f143580f != null) {
                a(DKHippyEvent.EVENT_STOP);
            }
            Integer d16 = jVar.d();
            if (d16 != null) {
                f.this.b(d16.intValue(), jVar.getType(), key);
                if (f.this.f143587m == null || !f.this.f143587m.equals(key)) {
                    f.this.b(d16.intValue(), key, DKHippyEvent.EVENT_STOP);
                    return;
                }
                return;
            }
            w.f(f.this.f143575a, "onStop, pageViewId is null");
        }

        @Override // com.tencent.luggage.wxa.ag.j.a
        public void d(com.tencent.luggage.wxa.ag.j jVar) {
            String key = jVar.getKey();
            w.d(f.this.f143575a, "onLoadEnd, key: " + key);
            if (f.this.f143587m != null && f.this.f143587m.equals(key) && f.this.f143580f != null) {
                f.this.f143580f.post(new b());
                jVar.start();
            }
        }

        @Override // com.tencent.luggage.wxa.ag.j.a
        public void e(com.tencent.luggage.wxa.ag.j jVar) {
            String key = jVar.getKey();
            w.a(f.this.f143575a, "onPlayEndSoon, key: " + key);
        }

        @Override // com.tencent.luggage.wxa.ag.j.a
        public void f(com.tencent.luggage.wxa.ag.j jVar) {
            String key = jVar.getKey();
            w.d(f.this.f143575a, "onLoading, key: " + key);
            if (f.this.f143587m != null && f.this.f143587m.equals(key) && f.this.f143580f != null) {
                f.this.f143580f.post(new a());
            }
        }

        @Override // com.tencent.luggage.wxa.ag.j.a
        public void g(com.tencent.luggage.wxa.ag.j jVar) {
            String key = jVar.getKey();
            w.d(f.this.f143575a, "onPause, key: " + key);
            if (f.this.A) {
                w.d(f.this.f143575a, "onPause, runtime paused");
                return;
            }
            Integer d16 = jVar.d();
            if (d16 != null) {
                f.this.b(d16.intValue(), jVar.getType(), key);
                if (f.this.f143587m == null || !f.this.f143587m.equals(key)) {
                    f.this.b(d16.intValue(), key, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
                    return;
                }
                return;
            }
            w.f(f.this.f143575a, "onPause, pageViewId is null");
        }

        @Override // com.tencent.luggage.wxa.ag.j.a
        public void a(com.tencent.luggage.wxa.ag.j jVar, float f16) {
            String key = jVar.getKey();
            if (f.this.f143587m == null || !f.this.f143587m.equals(key) || f.this.f143590p == null || f.this.f143580f == null) {
                return;
            }
            f.this.f143580f.post(new RunnableC6852d(f.this.f143590p.f143522c, f16));
        }

        @Override // com.tencent.luggage.wxa.ag.j.a
        public void a(com.tencent.luggage.wxa.ag.j jVar) {
            String key = jVar.getKey();
            w.d(f.this.f143575a, "onPlayEnd, key: " + key);
            if (f.this.f143587m != null && f.this.f143587m.equals(key) && f.this.f143580f != null) {
                a(HippyQQPagView.EventName.ON_PLAY_END);
            }
            Integer d16 = jVar.d();
            if (d16 == null) {
                w.f(f.this.f143575a, "onPlayEnd, pageViewId is null");
            } else {
                f.this.b(d16.intValue(), jVar.getType(), key);
                if (f.this.f143587m == null || !f.this.f143587m.equals(key)) {
                    f.this.b(d16.intValue(), key, HippyQQPagView.EventName.ON_PLAY_END);
                }
            }
            if (f.this.f143586l != null) {
                com.tencent.luggage.wxa.zp.h.f146825d.a(new e());
            }
        }

        public final void a(boolean z16) {
            f.this.f143580f.post(new RunnableC6853f(z16));
        }

        public final void a(String str) {
            f.this.a(str);
            f.this.f143593s = true;
        }
    }

    public final void a(int i3, j.b bVar, String str) {
        com.tencent.luggage.wxa.vj.a b16 = b(i3);
        if (b16 == null) {
            return;
        }
        if (!this.f143581g) {
            m();
            this.f143581g = true;
        }
        b16.a(bVar, str);
    }

    public void a(v vVar, j.b bVar, String str) {
        com.tencent.luggage.wxa.vj.a b16 = b(vVar);
        if (b16 == null) {
            return;
        }
        b16.b(bVar, str);
    }

    public com.tencent.luggage.wxa.vj.e a(int i3) {
        w.d(this.f143575a, "exitPip, viewId: " + i3);
        if (this.f143592r) {
            w.f(this.f143575a, "exitPip when mPipClickProcessing, return");
            return com.tencent.luggage.wxa.vj.e.FAIL_SINCE_IS_EXITING;
        }
        String str = this.f143587m;
        if (str != null && str.contains(String.valueOf(i3))) {
            com.tencent.luggage.wxa.il.f fVar = this.f143580f;
            if (fVar != null) {
                fVar.post(new j());
            }
            return com.tencent.luggage.wxa.vj.e.SUCCESS;
        }
        return com.tencent.luggage.wxa.vj.e.FAIL_SINCE_NOT_IN_PIP;
    }

    public final a.d a(int i3, String str) {
        com.tencent.luggage.wxa.vj.a aVar = (com.tencent.luggage.wxa.vj.a) this.f143582h.get(Integer.valueOf(i3));
        if (aVar == null) {
            w.f(this.f143575a, "getPipVideoSession, null == pageScopedPipInfo");
            return null;
        }
        return aVar.a(str);
    }

    public final boolean a(k1 k1Var, b.EnumC6005b enumC6005b) {
        return (b.EnumC6005b.POP == enumC6005b || b.EnumC6005b.PUSH_AND_POP == enumC6005b) && k1.NAVIGATE_BACK == k1Var;
    }

    public final boolean a(boolean z16) {
        if (this.f143580f == null || this.f143586l == null || this.f143584j == null) {
            return false;
        }
        f0 f0Var = this.f143598x;
        if (f0Var != null) {
            f0Var.b();
            this.f143598x = null;
        }
        k kVar = new k();
        w.d(this.f143575a, "transferFrom");
        if (z16) {
            com.tencent.luggage.wxa.ag.i iVar = this.f143586l;
            View view = this.f143584j;
            f0 f0Var2 = new f0(kVar);
            this.f143597w = f0Var2;
            iVar.b(view, f0Var2);
            return true;
        }
        this.f143586l.b(this.f143584j, null);
        kVar.run();
        return true;
    }

    public final boolean a(v vVar, com.tencent.luggage.wxa.ag.h hVar, i.a aVar, com.tencent.luggage.wxa.ag.j jVar) {
        if (k() == null) {
            return false;
        }
        f0 f0Var = this.f143597w;
        if (f0Var != null) {
            f0Var.run();
            this.f143597w = null;
        }
        this.f143586l = aVar.a(hVar);
        l lVar = new l();
        m mVar = new m();
        w.d(this.f143575a, "createVideoContainerView");
        this.f143584j = this.f143586l.a(this.f143576b);
        a.d a16 = a(jVar.d().intValue(), jVar.getKey());
        this.f143580f.a(a16 != null ? a16.f143523d : null);
        this.f143580f.d();
        com.tencent.luggage.wxa.vj.b bVar = this.f143585k;
        if (bVar != null) {
            bVar.f();
        }
        com.tencent.luggage.wxa.il.f k3 = k();
        View view = this.f143584j;
        f0 f0Var2 = new f0(lVar, 2, mVar);
        this.f143598x = f0Var2;
        this.f143585k = new com.tencent.luggage.wxa.vj.b(vVar, k3, view, hVar, jVar, f0Var2);
        this.f143580f.a(this.f143584j);
        if (!this.f143586l.a().a()) {
            this.f143580f.b();
        }
        if (this.f143585k.e()) {
            w.d(this.f143575a, "transferTo");
            this.f143580f.a(false);
            this.f143580f.setVisibility(0);
            this.f143586l.a(this.f143584j, new n());
            jVar.start();
            return true;
        }
        this.f143580f.b(this.f143584j);
        return false;
    }

    public final void a(com.tencent.luggage.wxa.vj.a aVar, a.d dVar) {
        com.tencent.luggage.wxa.ag.d dVar2;
        this.f143587m = aVar.c();
        com.tencent.luggage.wxa.kj.n a16 = aVar.a();
        this.f143588n = a16;
        if (a16 != null) {
            a16.a(true);
            b(this.f143588n.getCurrentPageView().hashCode(), this.f143587m, "setPipVideoRelated");
        }
        this.f143590p = dVar;
        if (this.f143587m == null || dVar == null || this.f143588n == null || (dVar2 = dVar.f143525f) == null) {
            return;
        }
        dVar2.b(dVar.f143520a).a(this.f143588n);
    }

    public final void a(boolean z16, boolean z17) {
        a.d dVar;
        com.tencent.luggage.wxa.ag.j jVar;
        a.d dVar2;
        com.tencent.luggage.wxa.ag.d dVar3;
        w.d(this.f143575a, "clearPipVideoRelated, mayPause: " + z16 + ", mayDestroyPage: " + z17);
        if (this.f143587m != null && (dVar2 = this.f143590p) != null && this.f143588n != null && (dVar3 = dVar2.f143525f) != null) {
            dVar3.a(dVar2.f143520a).a(this.f143588n);
        }
        String str = this.f143587m;
        this.f143587m = null;
        com.tencent.luggage.wxa.kj.n nVar = this.f143588n;
        if (nVar != null) {
            int hashCode = nVar.getCurrentPageView().hashCode();
            a(hashCode, str, "clearPipVideoRelated");
            if (z17) {
                com.tencent.luggage.wxa.kj.n currentPage = this.f143578d.getCurrentPage();
                if (currentPage == null) {
                    w.f(this.f143575a, "clearPipVideoRelated, curPage is null");
                } else {
                    k1 k1Var = k1.DISMISS_PIP;
                    long hash = Objects.hash(Integer.valueOf(k1Var.ordinal()), Long.valueOf(w0.a()));
                    currentPage.a(hash, k1Var, (p.m0) null);
                    currentPage.a(hash, k1Var);
                }
            }
            this.f143588n.a(false);
            if (z16 && (dVar = this.f143590p) != null && (jVar = dVar.f143527h) != null) {
                jVar.pause();
            }
            if (z17 && !this.f143589o) {
                w.d(this.f143575a, "clearPipVideoRelated, performDestroy and performCleanup");
                this.f143588n.z();
                this.f143588n.y();
                a.d dVar4 = this.f143590p;
                if (dVar4 != null) {
                    dVar4.a();
                }
                b(hashCode, str, "clearPipVideoRelated");
            }
        }
        this.f143588n = null;
        this.f143578d.setPipVideoRelatedPage(null);
        this.f143589o = true;
        this.f143590p = null;
    }

    public final void a(int i3, String str, String str2) {
        Set set = (Set) this.f143583i.get(Integer.valueOf(i3));
        if (set == null) {
            set = new HashSet();
            this.f143583i.put(Integer.valueOf(i3), set);
        }
        w.d(this.f143575a, str2 + ", mPageView2VideosMap add " + str + " for " + i3);
        set.add(str);
    }

    public final void a(String str) {
        w.a(this.f143575a, str + ", abandonAudioFocus");
        this.f143600z.a();
    }
}
