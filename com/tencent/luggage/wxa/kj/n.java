package com.tencent.luggage.wxa.kj;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.wxa.fd.b;
import com.tencent.luggage.wxa.fr.a;
import com.tencent.luggage.wxa.kj.p;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class n extends com.tencent.luggage.wxa.fr.a {
    public p P;
    public View Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public int U;
    public final Map V;
    public final Set W;

    /* renamed from: a0, reason: collision with root package name */
    public int f132250a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f132251b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f132252c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f132253d0;

    /* renamed from: e0, reason: collision with root package name */
    public final boolean[] f132254e0;

    /* renamed from: f0, reason: collision with root package name */
    public final a.d f132255f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f132256g0;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f132257a;

        public a(Runnable runnable) {
            this.f132257a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.a(this.f132257a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f132259a;

        public b(Runnable runnable) {
            this.f132259a = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            this.f132259a.run();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f132259a.run();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            n.this.setScrimColor(0);
            n.this.m();
            n nVar = n.this;
            nVar.a(nVar.f132255f0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.P == null) {
                return;
            }
            n.this.P.a(n.this, "scene_swipe_back");
        }
    }

    public n(Context context, p pVar) {
        super(context);
        this.R = true;
        this.S = false;
        this.T = false;
        this.V = new HashMap();
        this.W = new HashSet();
        this.f132252c0 = false;
        this.f132253d0 = false;
        this.f132254e0 = new boolean[]{false};
        this.f132255f0 = new d();
        this.f132256g0 = false;
        this.P = pVar;
        int o16 = getPageContainer().o();
        if (o16 > 0) {
            setEdgeSize(o16);
            this.U = o16;
        } else {
            this.U = super.getEdgeSize();
        }
    }

    private String getLocalClassName() {
        return getClass().getName().replaceFirst(Pattern.quote("com.tencent.mm.plugin.appbrand"), "");
    }

    public final void A() {
        if (this.R) {
            this.R = false;
            this.S = false;
            v();
        }
    }

    public void C() {
        if (this.P.r()) {
            if (p()) {
                setEnableGesture(false);
            } else {
                setEnableGesture(this.P.e());
            }
        } else if (!this.P.getRuntime().x0() && !p()) {
            setEnableGesture(this.P.p());
        } else {
            setEnableGesture(false);
        }
        setEdgeTrackingEnabled(1);
        setOrientation(this.P.l(this));
        D();
        a(1.0f);
        this.f132254e0[0] = false;
        this.f132252c0 = false;
        this.f132253d0 = false;
        super.d();
    }

    public final void D() {
        setEdgeSize(this.U);
    }

    public boolean E() {
        return getCurrentPageView().o1();
    }

    public abstract v a(int i3, boolean z16);

    public abstract void a(long j3, String str, k1 k1Var);

    public abstract void a(String str, v vVar);

    public abstract void a(String str, String str2, int[] iArr);

    public abstract boolean a(String str);

    public String getAppId() {
        return this.P.getAppId();
    }

    public p getContainer() {
        return this.P;
    }

    public final View getContentView() {
        return this.Q;
    }

    public abstract v getCurrentPageView();

    public final int getCurrentRenderPagesCount() {
        v currentPageView = getCurrentPageView();
        if (currentPageView == null) {
            return 1;
        }
        return currentPageView.d0();
    }

    public abstract String getCurrentUrl();

    public b.e getPageConfig() {
        return getCurrentPageView().r0();
    }

    public final p getPageContainer() {
        return this.P;
    }

    public final com.tencent.luggage.wxa.ic.g getRuntime() {
        return this.P.getRuntime();
    }

    public abstract View h();

    public final void i() {
        if (this.R) {
            setVisibility(4);
        }
    }

    public final void j() {
        com.tencent.luggage.wxa.ol.q b16 = com.tencent.luggage.wxa.ol.q.b(getContentView());
        if (b16 != null) {
            b16.b();
        }
    }

    public final void k() {
        com.tencent.luggage.wxa.h6.h.a(getContext());
        j();
    }

    public void l() {
        com.tencent.luggage.wxa.e5.g.a("AppBrandPageProfile| " + getLocalClassName() + " initView()", new c());
    }

    public final void m() {
        this.Q = h();
        addView(getContentView());
        setContentView(getContentView());
    }

    public final void n() {
        Iterator it = this.W.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.W.clear();
    }

    public boolean o() {
        return this.f132256g0;
    }

    @Override // android.view.View
    public final void onAnimationEnd() {
        super.onAnimationEnd();
        n();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        if (this.R) {
            this.S = true;
        }
        v currentPageView = getCurrentPageView();
        if (currentPageView != null) {
            currentPageView.a(configuration);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        boolean z16;
        if (!this.T && this.R && !this.S && this.f132250a0 > 0 && this.f132251b0 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.f132250a0, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f132251b0, 1073741824));
            return;
        }
        super.onMeasure(i3, i16);
        this.f132250a0 = getMeasuredWidth();
        this.f132251b0 = getMeasuredHeight();
    }

    public final boolean p() {
        if (getCurrentPageView().d0() > 1) {
            return true;
        }
        return false;
    }

    public boolean q() {
        return this.f132252c0;
    }

    public final void r() {
        v currentPageView = getCurrentPageView();
        if (currentPageView != null) {
            currentPageView.F();
        }
    }

    public void setForceDisableMeasureCache(boolean z16) {
        this.T = z16;
    }

    public abstract void setInitialUrl(String str);

    public void setIsAnimating(boolean z16) {
        v currentPageView = getCurrentPageView();
        if (currentPageView != null) {
            currentPageView.i(z16);
        }
    }

    public final void show() {
        setVisibility(0);
    }

    public void t() {
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandPage", "onPageBackground: %s", getCurrentUrl());
        B();
    }

    public void u() {
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandPage", "onPageDestroy: %s", getCurrentUrl());
    }

    public void v() {
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandPage", "onPageForeground: %s", getCurrentUrl());
        C();
        show();
    }

    public void w() {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPage", "onSwipeBack %s", Log.getStackTraceString(new Throwable()));
        this.f132252c0 = true;
        post(new e());
    }

    public final void x() {
        if (!this.R) {
            this.R = true;
            t();
        }
    }

    public final void y() {
        g();
        this.P = null;
    }

    public final void z() {
        u();
    }

    public final boolean b(String str) {
        return getCurrentPageView().l(str);
    }

    public final void a(v vVar) {
        vVar.a(this);
        vVar.g(getCurrentUrl());
    }

    public final void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            com.tencent.luggage.wxa.zp.h.f146825d.a(new a(runnable));
            return;
        }
        Object tag = getTag(p.R);
        if (tag instanceof Animator) {
            ((Animator) tag).addListener(new b(runnable));
        } else if (getAnimation() == null) {
            runnable.run();
        } else {
            this.W.add(runnable);
        }
    }

    public void a(long j3, String str) {
        throw new UnsupportedOperationException();
    }

    public boolean a(long j3, String str, k1 k1Var, JSONObject jSONObject) {
        com.tencent.luggage.wxa.er.a.b(E());
        if (!getCurrentPageView().a(j3, str, k1Var, jSONObject, true)) {
            return false;
        }
        a(str, getCurrentPageView());
        a(j3, "onAppRoute", k1Var, null, jSONObject);
        return true;
    }

    public int a(int i3, JSONObject jSONObject, boolean z16) {
        v currentPageView = getCurrentPageView();
        if (currentPageView == null || !currentPageView.o1()) {
            return 0;
        }
        k1 k1Var = k1.NAVIGATE_BACK;
        long hash = Objects.hash(Integer.valueOf(k1Var.ordinal()), Long.valueOf(com.tencent.luggage.wxa.tn.w0.a()));
        int a16 = currentPageView.a(hash, i3, z16);
        a(getCurrentPageView().A0(), getCurrentPageView());
        if (z16) {
            a(hash, "onAppRoute", k1Var, null, jSONObject);
        }
        return a16;
    }

    public final void B() {
    }

    public void g() {
    }

    public void s() {
    }

    public void a(v vVar, r rVar) {
        if (rVar == null || rVar.getParent() != null) {
            return;
        }
        View view = this.Q;
        if (view instanceof ViewGroup) {
            ((ViewGroup) view).addView(rVar, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d extends com.tencent.luggage.wxa.fr.b {

        /* renamed from: a, reason: collision with root package name */
        public int f132262a = -1;

        public d() {
        }

        @Override // com.tencent.luggage.wxa.fr.a.d
        public void a(int i3, float f16) {
            if (n.this.getContainer() != null) {
                n currentPage = n.this.getContainer().getCurrentPage();
                n nVar = n.this;
                if (currentPage == nVar) {
                    if (nVar.P.a("scene_swipe_back", (Runnable) null)) {
                        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPage", "[onScrollStateChange] navigate back be intercepted");
                        n.this.d();
                        return;
                    }
                    p container = n.this.getContainer();
                    n d16 = n.this.P.d(n.this);
                    if (container == null) {
                        com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrandPage", "onScrollStateChange, null == pageContainer");
                    } else {
                        float f17 = 100.0f * f16;
                        int ceil = (int) Math.ceil(f17);
                        if (ceil == 0 || -1 == this.f132262a) {
                            if (n.this.f132252c0) {
                                container.a(k1.NAVIGATE_BACK, n.this, d16);
                            } else {
                                container.c(k1.NAVIGATE_BACK, n.this, d16);
                            }
                        } else if (100 > ceil) {
                            container.a(k1.NAVIGATE_BACK, n.this, d16, f17);
                        }
                        this.f132262a = ceil;
                    }
                    if (i3 != 0) {
                        n.this.f132252c0 = true;
                        n.this.f132253d0 = false;
                    } else {
                        n.this.f132252c0 = false;
                        this.f132262a = -1;
                    }
                    if (Float.compare(1.0f, f16) <= 0) {
                        n nVar2 = n.this;
                        if (!nVar2.f132254e0[0]) {
                            if (d16 != null) {
                                nVar2.a(d16.getContentView(), 0.0f);
                            }
                            n.this.w();
                            n.this.f132254e0[0] = true;
                        }
                    } else if (d16 != null) {
                        d16.a(f16);
                    }
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPage", "scrollPercent %f", Float.valueOf(f16));
                    d();
                    return;
                }
            }
            n.this.setEnableGesture(false);
        }

        @Override // com.tencent.luggage.wxa.fr.a.d
        public boolean c() {
            if (n.this.getContainer() != null && n.this.getContainer().getRuntime() != null) {
                d();
            }
            return false;
        }

        public final com.tencent.luggage.wxa.ic.e0 d() {
            if (n.this.getContainer().r()) {
                n.this.getContainer().getRuntime().f0();
                return null;
            }
            if (n.this.getContainer().getRuntime().l()) {
                n.this.getContainer().getRuntime().f0();
                return null;
            }
            return null;
        }

        @Override // com.tencent.luggage.wxa.fr.b, com.tencent.luggage.wxa.fr.a.d
        public int a(boolean z16) {
            n.this.D();
            if (n.this.getContainer() != null && n.this.getContainer().getRuntime() != null) {
                d();
                return super.a(z16);
            }
            return super.a(z16);
        }

        @Override // com.tencent.luggage.wxa.fr.a.d
        public void a(View view, int i3, int i16) {
            if (n.this.getContainer() == null || n.this.getContainer().getRuntime() == null) {
                return;
            }
            d();
        }

        @Override // com.tencent.luggage.wxa.fr.a.d
        public void a(int i3) {
            if (n.this.getContainer() == null || n.this.getContainer().getRuntime() == null) {
                return;
            }
            d();
        }

        @Override // com.tencent.luggage.wxa.fr.a.d
        public void a(MotionEvent motionEvent) {
            if (n.this.getContainer() == null || n.this.getContainer().getRuntime() == null) {
                return;
            }
            d();
        }
    }

    public final void a(long j3, String str, k1 k1Var, p.m0 m0Var, JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        boolean equals = "onAppRouteDone".equals(str);
        String currentUrl = getCurrentUrl();
        String b16 = com.tencent.luggage.wxa.h6.o.b(currentUrl);
        Map d16 = com.tencent.luggage.wxa.h6.o.d(currentUrl);
        hashMap.put("path", b16);
        hashMap.put("query", d16);
        hashMap.put("rawPath", currentUrl);
        Map a16 = this.P.H.a(j3);
        boolean z16 = a16 != null && (a16.get("overrideEntryPagePath") instanceof Boolean) && ((Boolean) a16.get("overrideEntryPagePath")).booleanValue();
        hashMap.put("overrideEntryPagePath", Boolean.valueOf(z16));
        hashMap.put("openType", this.P.H.a(j3, k1Var, equals).toString());
        if (m0Var != null) {
            hashMap.put("pipMode", m0Var.f132363a);
        }
        if (!equals) {
            hashMap.put("qualityData", a16);
            hashMap.put("resizing", Boolean.valueOf(getCurrentPageView().p1()));
            if (k1.NAVIGATE_BACK != k1Var) {
                if (this.P.getAppConfig().f() != null) {
                    hashMap.put("page", this.P.getAppConfig().f().opt(b16));
                }
                if (this.P.getAppConfig().e() != null) {
                    hashMap.put("preloadRule", this.P.getAppConfig().e().opt(StringUtils.substring(b16, 0, b16.lastIndexOf(".html"))));
                }
            }
        }
        getCurrentPageView().a(equals, hashMap, k1Var, jSONObject);
        int optInt = getCurrentPageView().o1() ? ((JSONObject) hashMap.get("singlePageData")).optInt("pageId", 0) : getCurrentPageView().getComponentId();
        com.tencent.luggage.wxa.h6.f.a((Map) hashMap);
        String jSONObject2 = new JSONObject(hashMap).toString();
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPage", "dispatchRoute, appId:%s, event:%s, type:%s, webviewId:%d, pageId:%d, rawPath:%s, data:%s overrideEntryPagePath:%s", getAppId(), str, k1Var.toString(), Integer.valueOf(getCurrentPageView().getComponentId()), Integer.valueOf(optInt), currentUrl, jSONObject2, "" + z16);
        getCurrentPageView().a(str, jSONObject2, (int[]) null);
    }

    public final void a(long j3, k1 k1Var, p.m0 m0Var) {
        a(j3, k1Var, m0Var, (JSONObject) null);
    }

    public final void a(long j3, k1 k1Var, p.m0 m0Var, JSONObject jSONObject) {
        a(j3, "onAppRoute", k1Var, m0Var, jSONObject);
    }

    public final void a(long j3, k1 k1Var) {
        if (this.P == null) {
            return;
        }
        s();
        a(j3, "onAppRouteDone", k1Var, null, null);
        this.P.a(getCurrentPageView());
        this.P.H.c(j3);
    }

    public boolean a(int[] iArr, int i3) {
        if (iArr == null || iArr.length == 0) {
            return true;
        }
        for (int i16 : iArr) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    public final void a(View view, float f16) {
        view.clearAnimation();
        view.setTranslationX(f16);
    }

    public final void a(float f16) {
        if (this.R) {
            if (f16 >= 0.0f) {
                show();
            } else {
                i();
            }
        }
        a((View) this, (getWidth() / 4.0f) * (1.0f - f16) * (-1.0f));
    }

    public com.tencent.luggage.wxa.nj.g a(com.tencent.luggage.wxa.nj.i iVar) {
        com.tencent.luggage.wxa.nj.g gVar;
        synchronized (this.V) {
            gVar = (com.tencent.luggage.wxa.nj.g) this.V.get(iVar);
        }
        return gVar;
    }

    public void a(com.tencent.luggage.wxa.nj.i iVar, com.tencent.luggage.wxa.nj.g gVar) {
        if (iVar == null) {
            return;
        }
        synchronized (this.V) {
            if (gVar == null) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPage", "[registerNavigateBackInterceptionInfo] remove " + iVar);
            } else {
                this.V.put(iVar, gVar);
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPage", "[registerNavigateBackInterceptionInfo] add " + iVar);
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPage", "[registerNavigateBackInterceptionInfo] navigateBackInterceptionInfos size=" + this.V.size());
        }
    }

    public void a(boolean z16) {
        this.f132256g0 = z16;
    }
}
