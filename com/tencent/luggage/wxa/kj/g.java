package com.tencent.luggage.wxa.kj;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.collection.ArraySet;
import androidx.core.util.Consumer;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.dm.a;
import com.tencent.luggage.wxa.fd.b;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.mobileqq.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function0;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g extends n {

    /* renamed from: h0, reason: collision with root package name */
    public String f132168h0;

    /* renamed from: i0, reason: collision with root package name */
    public final SparseIntArray f132169i0;

    /* renamed from: j0, reason: collision with root package name */
    public ViewGroup f132170j0;

    /* renamed from: k0, reason: collision with root package name */
    public com.tencent.luggage.wxa.dm.a f132171k0;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f132172l0;

    /* renamed from: m0, reason: collision with root package name */
    public FrameLayout f132173m0;

    /* renamed from: n0, reason: collision with root package name */
    public v f132174n0;

    /* renamed from: o0, reason: collision with root package name */
    public Map f132175o0;

    /* renamed from: p0, reason: collision with root package name */
    public SparseArray f132176p0;

    /* renamed from: q0, reason: collision with root package name */
    public boolean f132177q0;

    /* renamed from: r0, reason: collision with root package name */
    public boolean f132178r0;

    /* renamed from: s0, reason: collision with root package name */
    public final Runnable f132179s0;

    /* renamed from: t0, reason: collision with root package name */
    public final Runnable f132180t0;

    /* renamed from: u0, reason: collision with root package name */
    public final LinkedList f132181u0;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.H();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ViewCompat.isAttachedToWindow(g.this) && (g.this.f132171k0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && ((ViewGroup.MarginLayoutParams) g.this.f132171k0.getLayoutParams()).topMargin != g.this.f132171k0.getTop()) {
                g.this.f132171k0.requestLayout();
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
            v currentPageView;
            com.tencent.luggage.wxa.kl.b W;
            if (g.this.f132178r0 || (currentPageView = g.this.getCurrentPageView()) == null || (W = currentPageView.W()) == null) {
                return;
            }
            currentPageView.u0().a(W.getTop() + W.getMeasuredHeight());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements a.r {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b.k f132185a;

        public d(b.k kVar) {
            this.f132185a = kVar;
        }

        @Override // com.tencent.luggage.wxa.dm.a.r
        public void a(int i3, String str) {
            g.this.getContainer().n(str);
            HashMap hashMap = new HashMap();
            hashMap.put("pagePath", str);
            hashMap.put("text", ((b.l) this.f132185a.f125674g.get(i3)).f125676b);
            hashMap.put("index", Integer.valueOf(i3));
            v currentPageView = g.this.getCurrentPageView();
            if (currentPageView != null) {
                currentPageView.a(new i().setData(hashMap), (int[]) null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f132187a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean[] f132188b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f132189c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.f132187a.a(g.this, eVar.f132189c);
            }
        }

        public e(j jVar, boolean[] zArr, String str) {
            this.f132187a = jVar;
            this.f132188b = zArr;
            this.f132189c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            j jVar = this.f132187a;
            if (jVar != null) {
                if (!this.f132188b[0]) {
                    g.this.post(new a());
                } else {
                    jVar.a(g.this, this.f132189c);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f extends k {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f132192c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f132193d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Runnable f132194e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(long j3, String str, Runnable runnable) {
            super(null);
            this.f132192c = j3;
            this.f132193d = str;
            this.f132194e = runnable;
        }

        @Override // com.tencent.luggage.wxa.kj.g.k
        public void c() {
            g.this.b(this.f132192c, this.f132193d);
            Runnable runnable = this.f132194e;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.kj.g$g, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6390g implements g.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f132196a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f132197b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k f132198c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f132199d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f132200e;

        public C6390g(v vVar, AtomicBoolean atomicBoolean, k kVar, long j3, String str) {
            this.f132196a = vVar;
            this.f132197b = atomicBoolean;
            this.f132198c = kVar;
            this.f132199d = j3;
            this.f132200e = str;
        }

        @Override // com.tencent.luggage.wxa.xd.g.f
        public void onReady() {
            this.f132196a.b(this);
            if (this.f132197b.get()) {
                this.f132198c.run();
            } else {
                g.this.post(this.f132198c);
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandMultiplePage", "Tab[%s][%s] onReady received, time: %d", g.this.getAppId(), this.f132200e, Long.valueOf(System.currentTimeMillis() - this.f132199d));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        public final Iterator f132202a;

        public h() {
            this.f132202a = g.this.f132175o0.values().iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public v next() {
            return (v) this.f132202a.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f132202a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i extends com.tencent.luggage.wxa.xd.p {
        private static final int CTRL_INDEX = 390;
        private static final String NAME = "onTabItemTap";
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface j {
        void a(g gVar, String str);

        void b(g gVar, String str);

        void c(g gVar, String str);
    }

    public g(Context context, p pVar) {
        super(context, pVar);
        this.f132169i0 = new SparseIntArray();
        this.f132172l0 = false;
        this.f132175o0 = new HashMap();
        this.f132176p0 = new SparseArray();
        this.f132177q0 = false;
        this.f132178r0 = false;
        this.f132179s0 = new a();
        this.f132180t0 = new c();
        this.f132181u0 = new LinkedList();
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public boolean E() {
        if (super.E() && this.f132172l0) {
            return true;
        }
        return false;
    }

    public final com.tencent.luggage.wxa.dm.a G() {
        com.tencent.luggage.wxa.dm.a aVar = (com.tencent.luggage.wxa.dm.a) getContainer().getDecorWidgetFactory().b(getContext(), com.tencent.luggage.wxa.dm.a.class);
        aVar.setId(R.id.srd);
        b.k i3 = getContainer().getAppConfig().i();
        aVar.setPosition(i3.f125668a);
        aVar.a(i3.f125669b, i3.f125670c, i3.f125671d, i3.f125672e);
        Iterator it = i3.f125674g.iterator();
        while (it.hasNext()) {
            b.l lVar = (b.l) it.next();
            aVar.a(lVar.f125675a, lVar.f125676b, lVar.f125677c, lVar.f125678d, (com.tencent.luggage.wxa.dm.b) getContainer().getDecorWidgetFactory().b(getContext(), com.tencent.luggage.wxa.dm.b.class));
        }
        aVar.setClickListener(new d(i3));
        return aVar;
    }

    public final void H() {
        if (this.f132178r0 || getCurrentPageView() == null || this.f132177q0 || !"top".equals(this.f132171k0.getPosition()) || !(this.f132171k0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f132171k0.getLayoutParams();
        com.tencent.luggage.wxa.kl.b W = getCurrentPageView().W();
        int top = W.getTop() + W.getMeasuredHeight();
        if (marginLayoutParams.topMargin != top) {
            marginLayoutParams.topMargin = top;
            this.f132171k0.setLayoutParams(marginLayoutParams);
            post(new b());
        }
        getCurrentPageView().d(this.f132171k0.getMeasuredHeight());
    }

    public Iterator I() {
        return new h();
    }

    public final void J() {
        if (this.f132178r0) {
            return;
        }
        post(this.f132179s0);
    }

    public final void K() {
        if (this.f132178r0) {
            return;
        }
        removeCallbacks(this.f132180t0);
        post(this.f132180t0);
    }

    public final void L() {
        r rVar;
        if (this.f132176p0.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < this.f132176p0.size(); i3++) {
            ((r) this.f132176p0.valueAt(i3)).setVisibility(4);
        }
        v currentPageView = getCurrentPageView();
        if (currentPageView != null && (rVar = (r) this.f132176p0.get(currentPageView.hashCode())) != null) {
            rVar.setVisibility(0);
        }
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void g() {
        this.f132178r0 = true;
        super.g();
        v vVar = this.f132174n0;
        if (vVar != null) {
            vVar.e();
        }
        a(new Consumer() { // from class: b31.g
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                ((com.tencent.luggage.wxa.kj.v) obj).e();
            }
        });
        b(false);
        removeCallbacks(this.f132179s0);
        removeCallbacks(this.f132180t0);
        com.tencent.luggage.wxa.dm.a aVar = this.f132171k0;
        if (aVar != null) {
            aVar.setClickListener(null);
            this.f132171k0.a();
            this.f132171k0 = null;
        }
        this.f132173m0 = null;
        this.f132175o0.clear();
        removeAllViews();
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public synchronized v getCurrentPageView() {
        return c(false);
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public String getCurrentUrl() {
        return this.f132168h0;
    }

    public com.tencent.luggage.wxa.dm.a getTabBar() {
        return this.f132171k0;
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public View h() {
        if (this.f132170j0 == null) {
            this.f132170j0 = F();
            v d16 = getContainer().d(this.f132168h0);
            this.f132174n0 = d16;
            a(d16);
        }
        return this.f132170j0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onDescendantInvalidated(View view, View view2) {
        super.onDescendantInvalidated(view, view2);
        if (view2 instanceof com.tencent.luggage.wxa.kl.d) {
            J();
            K();
        }
    }

    @Override // com.tencent.luggage.wxa.kj.n, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        J();
        K();
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void s() {
        getCurrentPageView().T0();
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void setInitialUrl(String str) {
        this.f132168h0 = str;
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void t() {
        super.t();
        getCurrentPageView().V0();
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void u() {
        super.u();
        v vVar = this.f132174n0;
        if (vVar != null) {
            vVar.X0();
        }
        a(new Consumer() { // from class: b31.h
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                ((com.tencent.luggage.wxa.kj.v) obj).X0();
            }
        });
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void v() {
        super.v();
        getCurrentPageView().a1();
    }

    public final ViewGroup F() {
        l lVar = new l(getContext());
        this.f132173m0 = new FrameLayout(getContext());
        this.f132171k0 = (com.tencent.luggage.wxa.dm.a) com.tencent.luggage.wxa.e5.g.a("createTabBar", new Function0() { // from class: b31.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return com.tencent.luggage.wxa.kj.g.this.G();
            }
        });
        if (getContainer().getAppConfig().i().f125673f) {
            this.f132171k0.setVisibility(8);
            this.f132172l0 = true;
        }
        if ("top".equals(getContainer().getAppConfig().i().f125668a)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(10);
            lVar.addView(this.f132173m0, layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(10);
            lVar.addView(this.f132171k0, layoutParams2);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams3.addRule(12);
            lVar.addView(this.f132171k0, layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams4.addRule(2, this.f132171k0.getId());
            layoutParams4.removeRule(12);
            lVar.addView(this.f132173m0, layoutParams4);
        }
        return lVar;
    }

    public final void b(long j3, String str) {
        this.f132177q0 = false;
        String b16 = com.tencent.luggage.wxa.h6.o.b(str);
        v vVar = (v) this.f132175o0.get(b16);
        com.tencent.luggage.wxa.er.a.b(StringUtils.equals(vVar.A0(), b16));
        if (!b(vVar)) {
            vVar.getContentView().setVisibility(4);
        }
        v vVar2 = null;
        for (v vVar3 : this.f132175o0.values()) {
            if (vVar3.getContentView().getVisibility() == 0 && vVar != vVar3) {
                vVar2 = vVar3;
            }
        }
        vVar.getContentView().bringToFront();
        vVar.getContentView().setVisibility(0);
        if (vVar2 != null) {
            vVar2.getContentView().setVisibility(4);
        }
        if (vVar2 != null) {
            vVar2.V0();
        }
        vVar.a1();
        L();
    }

    public final synchronized v c(String str) {
        v vVar;
        vVar = this.f132174n0;
        if (vVar != null) {
            this.f132174n0 = null;
        } else {
            vVar = getContainer().d(str);
            vVar.a((n) this);
        }
        this.f132175o0.put(str, vVar);
        this.f132173m0.addView(vVar.getContentView(), 0);
        return vVar;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class k implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public boolean f132204a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f132205b;

        public k() {
            this.f132204a = false;
            this.f132205b = false;
        }

        public final boolean a() {
            if (!this.f132204a && !this.f132205b) {
                return true;
            }
            return false;
        }

        public void b() {
            this.f132205b = true;
        }

        public abstract void c();

        @Override // java.lang.Runnable
        public final void run() {
            if (!a()) {
                return;
            }
            this.f132204a = true;
            c();
        }

        public /* synthetic */ k(a aVar) {
            this();
        }
    }

    public final void a(long j3, String str, j jVar, k1 k1Var) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandMultiplePage", "AppBrandPageProfile| loadUrl, appId:%s, url:%s", getAppId(), str);
        if (StringUtils.equals(str, this.f132168h0) && this.f132169i0.get(str.hashCode(), 0) == 1) {
            if (jVar != null) {
                jVar.c(this, str);
                jVar.a(this, str);
                return;
            }
            return;
        }
        int a16 = this.f132171k0.a(str);
        if (a16 < 0) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandMultiplePage", "loadUrl, index not found, appId:%s, url:%s", getAppId(), str);
            if (jVar != null) {
                jVar.b(this, str);
                return;
            }
            return;
        }
        b(true);
        v c16 = c(true);
        this.f132168h0 = str;
        this.f132169i0.put(str.hashCode(), 1);
        this.f132171k0.a(a16);
        if (this.f132175o0.get(com.tencent.luggage.wxa.h6.o.b(str)) == null) {
            if (c16 != null && c16.o1() && c16.l(str)) {
                this.f132175o0.put(com.tencent.luggage.wxa.h6.o.b(str), c16);
            } else {
                c16 = c(com.tencent.luggage.wxa.h6.o.b(str));
            }
            boolean[] zArr = new boolean[1];
            a(c16, str, new e(jVar, zArr, str), j3, k1Var);
            if (jVar != null) {
                jVar.c(this, str);
                zArr[0] = true;
                return;
            }
            return;
        }
        String b16 = com.tencent.luggage.wxa.h6.o.b(str);
        v vVar = (v) this.f132175o0.get(b16);
        if (vVar.o1() && !StringUtils.equals(vVar.A0(), b16)) {
            vVar.a(j3, str, k1.SWITCH_TAB, (JSONObject) null, false);
        }
        if (jVar != null) {
            jVar.c(this, str);
        }
        b(j3, str);
        if (jVar != null) {
            jVar.a(this, str);
        }
    }

    public synchronized v c(boolean z16) {
        if (!z16) {
            v vVar = this.f132174n0;
            if (vVar != null) {
                return vVar;
            }
        }
        return (v) this.f132175o0.get(com.tencent.luggage.wxa.h6.o.b(this.f132168h0));
    }

    public final void b(boolean z16) {
        Iterator it = this.f132181u0.iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            removeCallbacks(kVar);
            if (z16) {
                kVar.run();
            } else {
                kVar.b();
            }
        }
        this.f132181u0.clear();
    }

    public static boolean b(v vVar) {
        View contentView = vVar.getContentView();
        ViewParent parent = contentView.getParent();
        if (!(parent instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        return viewGroup.getChildAt(viewGroup.getChildCount() - 1) == contentView;
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void a(long j3, String str, k1 k1Var) {
        a(j3, str, (j) null, k1Var);
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void a(String str, v vVar) {
        this.f132168h0 = str;
        this.f132169i0.put(str.hashCode(), 1);
        this.f132175o0.put(com.tencent.luggage.wxa.h6.o.b(str), vVar);
    }

    public final void a(v vVar, String str, Runnable runnable, long j3, k1 k1Var) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandMultiplePage", "loadAndWait appId[%s] url[%s]", getAppId(), str);
        f fVar = new f(j3, str, runnable);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        try {
            vVar.a(new C6390g(vVar, atomicBoolean, fVar, System.currentTimeMillis(), str));
            if (this.f132175o0.size() > 1) {
                a(fVar, 500L);
            }
            this.f132177q0 = true;
            if (vVar.o1() && !StringUtils.isEmpty(vVar.o0())) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandMultiplePage", "[perf] customRoute[switchTab] in loadAndWait");
                vVar.a(j3, str, k1.SWITCH_TAB, (JSONObject) null, false);
            } else {
                vVar.a(j3, str, k1Var);
            }
        } finally {
            atomicBoolean.set(true);
        }
    }

    public final void a(k kVar, long j3) {
        this.f132181u0.addLast(kVar);
        postDelayed(kVar, j3);
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public boolean a(String str) {
        return this.f132171k0.a(str) != -1;
    }

    public final void a(Consumer consumer) {
        Iterator it = new ArraySet(this.f132175o0.values()).iterator();
        while (it.hasNext()) {
            consumer.accept((v) it.next());
        }
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void a(final String str, final String str2, final int[] iArr) {
        v vVar = this.f132174n0;
        if (vVar != null && a(iArr, vVar.getComponentId())) {
            this.f132174n0.a(str, str2);
        }
        a(new Consumer() { // from class: b31.j
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                com.tencent.luggage.wxa.kj.g.this.a(iArr, str, str2, (com.tencent.luggage.wxa.kj.v) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int[] iArr, String str, String str2, v vVar) {
        if (a(iArr, vVar.getComponentId())) {
            vVar.a(str, str2);
        }
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public v a(int i3, boolean z16) {
        for (v vVar : this.f132175o0.values()) {
            if (z16 && vVar.o1()) {
                if (vVar.a(i3)) {
                    return vVar;
                }
            } else if (vVar.getComponentId() == i3) {
                return vVar;
            }
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void a(v vVar, r rVar) {
        if (vVar == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandMultiplePage", "getCurrentFullScreenView err, pageView is null");
            return;
        }
        if (rVar == null || rVar.getParent() != null) {
            return;
        }
        ViewGroup viewGroup = this.f132170j0;
        if (viewGroup instanceof ViewGroup) {
            viewGroup.addView(rVar, new ViewGroup.LayoutParams(-1, -1));
            this.f132176p0.put(vVar.hashCode(), rVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class l extends RelativeLayout implements a.p {
        public l(Context context) {
            super(context);
        }

        @Override // com.tencent.luggage.wxa.dm.a.p
        public void a(com.tencent.luggage.wxa.dm.a aVar, boolean z16) {
            if (z16 && !"top".equals(g.this.getContainer().getAppConfig().i().f125668a) && g.this.f132173m0 != null && (g.this.f132173m0.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) g.this.f132173m0.getLayoutParams();
                layoutParams.removeRule(2);
                layoutParams.addRule(12);
                g.this.f132171k0.bringToFront();
                g.this.f132173m0.requestLayout();
            }
        }

        @Override // com.tencent.luggage.wxa.dm.a.p
        public void c(com.tencent.luggage.wxa.dm.a aVar, boolean z16) {
            if (!g.this.f132178r0 && g.this.f132173m0 != null && (g.this.f132173m0.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) g.this.f132173m0.getLayoutParams();
                if (layoutParams.getRule(2) != g.this.f132171k0.getId()) {
                    layoutParams.addRule(2, g.this.f132171k0.getId());
                    layoutParams.removeRule(12);
                    g.this.f132173m0.requestLayout();
                }
            }
        }

        @Override // com.tencent.luggage.wxa.dm.a.p
        public void d(com.tencent.luggage.wxa.dm.a aVar, boolean z16) {
            g.this.f132171k0.bringToFront();
        }

        @Override // com.tencent.luggage.wxa.dm.a.p
        public void b(com.tencent.luggage.wxa.dm.a aVar, boolean z16) {
        }
    }
}
