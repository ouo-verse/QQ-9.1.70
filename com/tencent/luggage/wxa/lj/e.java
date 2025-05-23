package com.tencent.luggage.wxa.lj;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.kj.h1;
import com.tencent.luggage.wxa.kj.i1;
import com.tencent.luggage.wxa.kj.k1;
import com.tencent.luggage.wxa.kl.b;
import com.tencent.luggage.wxa.kl.i;
import com.tencent.luggage.wxa.lj.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e {

    /* renamed from: k, reason: collision with root package name */
    public static final a f133452k = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ic.g f133453a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.lj.c f133454b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.lj.d f133455c;

    /* renamed from: d, reason: collision with root package name */
    public final l f133456d;

    /* renamed from: e, reason: collision with root package name */
    public final g f133457e;

    /* renamed from: f, reason: collision with root package name */
    public final Lazy f133458f;

    /* renamed from: g, reason: collision with root package name */
    public i f133459g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.lj.a f133460h;

    /* renamed from: i, reason: collision with root package name */
    public final c f133461i;

    /* renamed from: j, reason: collision with root package name */
    public com.tencent.luggage.wxa.kj.v f133462j;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class c {

        /* renamed from: a, reason: collision with root package name */
        public final SparseArray f133471a = new SparseArray();

        public c() {
        }

        public final void a(com.tencent.luggage.wxa.kj.v page, b context) {
            Intrinsics.checkNotNullParameter(page, "page");
            Intrinsics.checkNotNullParameter(context, "context");
            this.f133471a.put(page.hashCode(), context);
        }

        public final b b(com.tencent.luggage.wxa.kj.v page) {
            Intrinsics.checkNotNullParameter(page, "page");
            b bVar = (b) this.f133471a.get(page.hashCode(), null);
            if (bVar == null) {
                b bVar2 = new b(e.this, page);
                a(page, bVar2);
                return bVar2;
            }
            return bVar;
        }

        public final b c(com.tencent.luggage.wxa.kj.v page) {
            Intrinsics.checkNotNullParameter(page, "page");
            int indexOfKey = this.f133471a.indexOfKey(page.hashCode());
            if (indexOfKey >= 0) {
                b bVar = (b) this.f133471a.valueAt(indexOfKey);
                this.f133471a.removeAt(indexOfKey);
                return bVar;
            }
            return null;
        }

        public final b a(com.tencent.luggage.wxa.kj.v page) {
            Intrinsics.checkNotNullParameter(page, "page");
            return (b) this.f133471a.get(page.hashCode(), null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends Lambda implements Function0 {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements i.a {

            /* renamed from: a, reason: collision with root package name */
            public final byte[] f133474a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e f133475b;

            public a(e eVar) {
                this.f133475b = eVar;
                int size = i.a.EnumC6399a.b().size();
                byte[] bArr = new byte[size];
                for (int i3 = 0; i3 < size; i3++) {
                    bArr[i3] = 0;
                }
                this.f133474a = bArr;
            }

            public boolean a() {
                int sum;
                boolean z16;
                sum = ArraysKt___ArraysKt.sum(this.f133474a);
                if (sum >= 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("expectedCapsuleVisibility(appId:");
                sb5.append(this.f133475b.f133453a.getAppId());
                sb5.append(") result:");
                boolean z17 = !z16;
                sb5.append(z17);
                w.d("AppBrandCapsuleBarManager", sb5.toString());
                return z17;
            }

            @Override // com.tencent.luggage.wxa.kl.i.a
            public boolean b(boolean z16, i.a.EnumC6399a reason) {
                int sum;
                boolean z17;
                Intrinsics.checkNotNullParameter(reason, "reason");
                this.f133474a[reason.ordinal()] = !z16 ? 1 : 0;
                sum = ArraysKt___ArraysKt.sum(this.f133474a);
                if (sum >= 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("calculateCapsuleVisibility(appId:");
                sb5.append(this.f133475b.f133453a.getAppId());
                sb5.append(", expected:");
                sb5.append(z16);
                sb5.append(", reason:");
                sb5.append(reason);
                sb5.append(") result:");
                boolean z18 = !z17;
                sb5.append(z18);
                w.d("AppBrandCapsuleBarManager", sb5.toString());
                return z18;
            }
        }

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a invoke() {
            return new a(e.this);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.lj.e$e, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6445e extends Lambda implements Function1 {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.lj.e$e$a */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f133477a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(e eVar) {
                super(0);
                this.f133477a = eVar;
            }

            public final void a() {
                i iVar = this.f133477a.f133459g;
                if (iVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("blinkWrapper");
                    iVar = null;
                }
                iVar.g();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.lj.e$e$b */
        /* loaded from: classes8.dex */
        public static final class b extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f133478a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(e eVar) {
                super(0);
                this.f133478a = eVar;
            }

            public final void a() {
                i iVar = this.f133478a.f133459g;
                if (iVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("blinkWrapper");
                    iVar = null;
                }
                iVar.h();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.lj.e$e$c */
        /* loaded from: classes8.dex */
        public static final class c extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f133479a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(e eVar) {
                super(0);
                this.f133479a = eVar;
            }

            public final void a() {
                i iVar = this.f133479a.f133459g;
                if (iVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("blinkWrapper");
                    iVar = null;
                }
                iVar.f();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public C6445e() {
            super(1);
        }

        public final void a(com.tencent.luggage.wxa.e5.h lifecycle) {
            Intrinsics.checkNotNullParameter(lifecycle, "$this$lifecycle");
            lifecycle.a(new a(e.this));
            lifecycle.c(new b(e.this));
            lifecycle.b(new c(e.this));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.e5.h) obj);
            return Unit.INSTANCE;
        }
    }

    public e(com.tencent.luggage.wxa.ic.g runtime) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        this.f133453a = runtime;
        this.f133456d = new l(runtime);
        this.f133457e = new g();
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new d());
        this.f133458f = lazy;
        this.f133461i = new c();
    }

    public final AppBrandOptionButton g() {
        com.tencent.luggage.wxa.lj.d dVar = this.f133455c;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("capsuleBarView");
            dVar = null;
        }
        AppBrandOptionButton optionBtn = dVar.getOptionBtn();
        Intrinsics.checkNotNullExpressionValue(optionBtn, "capsuleBarView.optionBtn");
        return optionBtn;
    }

    public final void h() {
        if (this.f133454b != null) {
            d().setVisibility(4);
        }
    }

    public final void i() {
        boolean z16;
        if (this.f133454b != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.luggage.wxa.er.a.b(z16);
        e().b(false, i.a.EnumC6399a.EnforceFlag);
        h();
    }

    public final void j() {
        i1 a16 = this.f133453a.a(h1.CAPSULE_BAR);
        if (a16 == null) {
            a16 = new i1.a();
        }
        Context F = this.f133453a.F();
        Intrinsics.checkNotNullExpressionValue(F, "runtime.appContext");
        View b16 = a16.b(F, com.tencent.luggage.wxa.lj.d.class);
        Intrinsics.checkNotNullExpressionValue(b16, "widgetFactory.onCreateWi\u2026eBarImplView::class.java)");
        this.f133455c = (com.tencent.luggage.wxa.lj.d) b16;
        com.tencent.luggage.wxa.ic.g gVar = this.f133453a;
        i iVar = new i(this.f133453a);
        this.f133459g = iVar;
        com.tencent.luggage.wxa.e5.l.f124555a.a(this.f133453a, new C6445e());
        Unit unit = Unit.INSTANCE;
        com.tencent.luggage.wxa.lj.a a17 = a.b.a(gVar, iVar);
        Intrinsics.checkNotNullExpressionValue(a17, "create(runtime,\n        \u2026}\n            }\n        )");
        this.f133460h = a17;
        View b17 = a16.b(F, com.tencent.luggage.wxa.lj.c.class);
        Intrinsics.checkNotNullExpressionValue(b17, "widgetFactory.onCreateWi\u2026tainerLayout::class.java)");
        this.f133454b = (com.tencent.luggage.wxa.lj.c) b17;
        d().setWindowAndroid(this.f133453a.n0());
        com.tencent.luggage.wxa.lj.c d16 = d();
        com.tencent.luggage.wxa.lj.d dVar = this.f133455c;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("capsuleBarView");
            dVar = null;
        }
        d16.addView(dVar);
        this.f133453a.R().a(d());
    }

    public final boolean k() {
        i iVar = this.f133459g;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blinkWrapper");
            iVar = null;
        }
        return iVar.d();
    }

    public final void l() {
        i iVar = this.f133459g;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blinkWrapper");
            iVar = null;
        }
        iVar.g();
        d().setVisibility(4);
    }

    public final void m() {
        int i3;
        i iVar = this.f133459g;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blinkWrapper");
            iVar = null;
        }
        iVar.h();
        com.tencent.luggage.wxa.lj.c d16 = d();
        if (e().a()) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        d16.setVisibility(i3);
    }

    public final void n() {
        com.tencent.luggage.wxa.lj.d dVar = this.f133455c;
        if (dVar != null) {
            dVar.d();
        }
    }

    public final void o() {
        com.tencent.luggage.wxa.lj.d dVar = this.f133455c;
        if (dVar != null) {
            dVar.e();
        }
    }

    public final void b(com.tencent.luggage.wxa.kj.v page) {
        Intrinsics.checkNotNullParameter(page, "page");
        this.f133461i.a(page, new b(this, page));
    }

    public final com.tencent.luggage.wxa.lj.a c() {
        com.tencent.luggage.wxa.lj.a aVar = this.f133460h;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("blinkHelperExport");
        return null;
    }

    public final com.tencent.luggage.wxa.lj.c d() {
        com.tencent.luggage.wxa.lj.c cVar = this.f133454b;
        if (cVar != null) {
            return cVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("capsuleBarContainerLayout");
        return null;
    }

    public final d.a e() {
        return (d.a) this.f133458f.getValue();
    }

    public final l f() {
        return this.f133456d;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class b extends com.tencent.luggage.wxa.wj.b implements b.e, View.OnLayoutChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final com.tencent.luggage.wxa.kj.v f133463a;

        /* renamed from: b, reason: collision with root package name */
        public int f133464b;

        /* renamed from: c, reason: collision with root package name */
        public View.OnClickListener f133465c;

        /* renamed from: d, reason: collision with root package name */
        public r f133466d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f133467e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ e f133468f;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements g.c {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f133469a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f133470b;

            public a(e eVar, b bVar) {
                this.f133469a = eVar;
                this.f133470b = bVar;
            }

            @Override // com.tencent.luggage.wxa.xd.g.c
            public final void onDestroy() {
                this.f133469a.a(this.f133470b.l());
            }
        }

        public b(e eVar, com.tencent.luggage.wxa.kj.v page) {
            Intrinsics.checkNotNullParameter(page, "page");
            this.f133468f = eVar;
            this.f133463a = page;
            this.f133464b = -1;
            page.a(new a(eVar, this));
            page.W().setCapsuleBarInteractionDelegate(this);
        }

        @Override // com.tencent.luggage.wxa.kl.b.e
        public void a(int i3) {
            this.f133464b = i3;
            if (this.f133467e) {
                com.tencent.luggage.wxa.lj.d dVar = this.f133468f.f133455c;
                if (dVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("capsuleBarView");
                    dVar = null;
                }
                dVar.setStyleColor(this.f133464b);
            }
        }

        @Override // com.tencent.luggage.wxa.kl.b.e
        public void b(View.OnClickListener onClickListener) {
            com.tencent.luggage.wxa.ic.g runtime = this.f133463a.getRuntime();
            Intrinsics.checkNotNullExpressionValue(runtime, "page.runtime");
            this.f133466d = new r(onClickListener, runtime);
            if (this.f133467e) {
                com.tencent.luggage.wxa.lj.d dVar = this.f133468f.f133455c;
                if (dVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("capsuleBarView");
                    dVar = null;
                }
                dVar.setOptionButtonOnClickListener(this.f133466d);
            }
        }

        @Override // com.tencent.luggage.wxa.kl.b.e
        public void c(int i3) {
            k();
        }

        @Override // com.tencent.luggage.wxa.wj.b
        public void i() {
            this.f133468f.l();
        }

        @Override // com.tencent.luggage.wxa.wj.b
        public void j() {
            this.f133468f.m();
        }

        public final void k() {
            int i3;
            int visibility;
            ViewGroup.LayoutParams layoutParams;
            com.tencent.luggage.wxa.lj.d dVar = this.f133468f.f133455c;
            ViewGroup.MarginLayoutParams marginLayoutParams = null;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("capsuleBarView");
                dVar = null;
            }
            if (dVar.getCapsuleContentAreaView().isLaidOut()) {
                this.f133463a.W().getCapsuleView().setFixedWidth(dVar.getCapsuleContentAreaView().getMeasuredWidth());
                this.f133463a.W().getCapsuleView().setFixedHeight(dVar.getCapsuleContentAreaView().getMeasuredHeight());
            }
            AppBrandCapsuleBarPlaceHolderView capsuleView = this.f133463a.W().getCapsuleView();
            if (capsuleView != null && (layoutParams = capsuleView.getLayoutParams()) != null) {
                e eVar = this.f133468f;
                View capsuleContentAreaView = dVar.getCapsuleContentAreaView();
                FrameLayout.LayoutParams a16 = eVar.a(layoutParams, 21);
                a16.width = -2;
                capsuleContentAreaView.setLayoutParams(a16);
            }
            ViewGroup.LayoutParams layoutParams2 = this.f133463a.W().getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            }
            if (marginLayoutParams != null) {
                i3 = marginLayoutParams.topMargin;
            } else {
                i3 = 0;
            }
            ViewGroup.LayoutParams layoutParams3 = dVar.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
            layoutParams4.topMargin = i3;
            layoutParams4.gravity = 5;
            ViewGroup.LayoutParams layoutParams5 = dVar.getLayoutParams();
            if (layoutParams5 != null && layoutParams5.height != this.f133463a.W().getMeasuredHeight() && ViewCompat.isLaidOut(this.f133463a.W())) {
                layoutParams5.height = this.f133463a.W().getMeasuredHeight();
            }
            dVar.requestLayout();
            AppBrandCapsuleBarPlaceHolderView capsuleView2 = this.f133463a.W().getCapsuleView();
            if (capsuleView2 != null && dVar.getVisibility() != (visibility = capsuleView2.getVisibility())) {
                dVar.setVisibility(visibility);
            }
        }

        public final com.tencent.luggage.wxa.kj.v l() {
            return this.f133463a;
        }

        public final void m() {
            Object obj;
            boolean z16 = true;
            this.f133467e = true;
            com.tencent.luggage.wxa.wj.d h06 = this.f133463a.h0();
            if (h06 == null || !h06.b()) {
                z16 = false;
            }
            if (z16) {
                i();
            } else {
                j();
            }
            com.tencent.luggage.wxa.wj.d h07 = this.f133463a.h0();
            if (h07 != null) {
                h07.a(this);
            }
            com.tencent.luggage.wxa.lj.d dVar = this.f133468f.f133455c;
            View view = null;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("capsuleBarView");
                dVar = null;
            }
            dVar.addOnLayoutChangeListener(this);
            AppBrandCapsuleBarPlaceHolderView capsuleView = this.f133463a.W().getCapsuleView();
            if (capsuleView != null) {
                obj = capsuleView.getParent();
            } else {
                obj = null;
            }
            if (obj instanceof View) {
                view = (View) obj;
            }
            if (view != null) {
                view.addOnLayoutChangeListener(this);
            }
            this.f133463a.W().addOnLayoutChangeListener(this);
            a(this.f133465c);
            b(this.f133466d);
            a(this.f133464b);
            k();
        }

        public final void n() {
            Object obj;
            this.f133467e = false;
            com.tencent.luggage.wxa.wj.d h06 = this.f133463a.h0();
            if (h06 != null) {
                h06.b(this);
            }
            com.tencent.luggage.wxa.lj.d dVar = this.f133468f.f133455c;
            View view = null;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("capsuleBarView");
                dVar = null;
            }
            dVar.removeOnLayoutChangeListener(this);
            AppBrandCapsuleBarPlaceHolderView capsuleView = this.f133463a.W().getCapsuleView();
            if (capsuleView != null) {
                obj = capsuleView.getParent();
            } else {
                obj = null;
            }
            if (obj instanceof View) {
                view = (View) obj;
            }
            if (view != null) {
                view.removeOnLayoutChangeListener(this);
            }
            this.f133463a.W().removeOnLayoutChangeListener(this);
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            if (this.f133467e) {
                if (i3 != i19 || i16 != i26 || i17 != i27 || i18 != i28) {
                    k();
                }
            }
        }

        @Override // com.tencent.luggage.wxa.kl.b.e
        public void a(View.OnClickListener onClickListener) {
            this.f133465c = onClickListener;
            if (this.f133467e) {
                com.tencent.luggage.wxa.lj.d dVar = this.f133468f.f133455c;
                if (dVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("capsuleBarView");
                    dVar = null;
                }
                dVar.setHomeButtonOnClickListener(this.f133465c);
            }
        }

        @Override // com.tencent.luggage.wxa.kl.i.a
        public boolean b(boolean z16, i.a.EnumC6399a reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return this.f133468f.e().b(z16, reason);
        }
    }

    public final void b() {
        com.tencent.luggage.wxa.lj.d dVar = this.f133455c;
        if (dVar != null) {
            dVar.destroy();
        }
        i iVar = this.f133459g;
        if (iVar != null) {
            iVar.f();
        }
    }

    public final void a() {
        if (this.f133454b != null) {
            d().cancelPendingInputEvents();
        }
    }

    public final void a(Context newBase) {
        Intrinsics.checkNotNullParameter(newBase, "newBase");
        d().a(newBase);
    }

    public final void a(AppBrandCapsuleBarPlaceHolderView appBrandCapsuleBarPlaceHolderView) {
        if (appBrandCapsuleBarPlaceHolderView != null) {
            com.tencent.luggage.wxa.lj.d dVar = this.f133455c;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("capsuleBarView");
                dVar = null;
            }
            appBrandCapsuleBarPlaceHolderView.setFixedWidth(dVar.getCapsuleContentAreaView().getMeasuredWidth());
        }
    }

    public final View a(int i3) {
        return d().findViewById(i3);
    }

    public final void a(com.tencent.luggage.wxa.kj.v page, k1 type) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(type, "type");
        com.tencent.luggage.wxa.kj.v vVar = this.f133462j;
        if (vVar != null) {
            c cVar = this.f133461i;
            Intrinsics.checkNotNull(vVar);
            b a16 = cVar.a(vVar);
            if (a16 != null) {
                a16.n();
            }
        }
        this.f133462j = page;
        this.f133461i.b(page).m();
    }

    public final void a(com.tencent.luggage.wxa.kj.v vVar) {
        if (Intrinsics.areEqual(vVar, this.f133462j)) {
            this.f133462j = null;
        }
        b c16 = this.f133461i.c(vVar);
        if (c16 != null) {
            c16.n();
        }
    }

    public final FrameLayout.LayoutParams a(ViewGroup.LayoutParams layoutParams, int i3) {
        FrameLayout.LayoutParams layoutParams2;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            layoutParams2 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        } else {
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        }
        layoutParams2.gravity = i3;
        return layoutParams2;
    }
}
