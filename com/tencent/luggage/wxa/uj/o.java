package com.tencent.luggage.wxa.uj;

import android.content.Context;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.luggage.wxa.ol.x;
import com.tencent.luggage.wxa.rj.u;
import com.tencent.luggage.wxa.uj.a;
import com.tencent.luggage.wxa.uj.i;
import com.tencent.luggage.wxa.xd.d0;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class o extends com.tencent.luggage.wxa.uj.a implements com.tencent.luggage.wxa.ce.a {
    public final String R;
    public com.tencent.luggage.wxa.uj.j S;
    public ArrayList T;
    public Function1 U;
    public Function0 V;
    public Function0 W;
    public Function0 X;
    public Function0 Y;
    public Function0 Z;

    /* renamed from: a0, reason: collision with root package name */
    public Function1 f142514a0;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements a.d {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.uj.a.d
        public void a(int i3, boolean z16) {
            ArrayList arrayList;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        o.this.q().invoke();
                        return;
                    }
                    return;
                }
                o.this.r().invoke();
                return;
            }
            o.this.o().invoke(Boolean.valueOf(o.this.j()));
            com.tencent.luggage.wxa.uj.j jVar = o.this.S;
            if (jVar != null) {
                arrayList = jVar.b();
            } else {
                arrayList = null;
            }
            Intrinsics.checkNotNull(arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                com.tencent.luggage.wxa.uj.k phoneItem = (com.tencent.luggage.wxa.uj.k) it.next();
                if (phoneItem.i()) {
                    Function1 u16 = o.this.u();
                    Intrinsics.checkNotNullExpressionValue(phoneItem, "phoneItem");
                    u16.invoke(phoneItem);
                    return;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            o.this.s().invoke();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (o.this.v().size() == 1) {
                o.this.p().invoke();
            } else {
                o.this.t().invoke();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final j f142524a = new j();

        public j() {
            super(1);
        }

        public final void a(com.tencent.luggage.wxa.uj.k it) {
            Intrinsics.checkNotNullParameter(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.uj.k) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            o oVar = o.this;
            String m3 = oVar.m();
            Context context = o.this.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            oVar.S = new com.tencent.luggage.wxa.uj.j(m3, context, o.this.v());
            o.this.h().setAdapter(o.this.S);
            if (o.this.v().size() == 0) {
                o.this.g().setVisibility(0);
                o.this.h().setVisibility(8);
                o.this.e().setVisibility(8);
                return;
            }
            if (o.this.v().size() == 1) {
                o.this.g().setVisibility(8);
                o.this.h().setVisibility(0);
                RecyclerView.Adapter adapter = o.this.h().getAdapter();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
                o.this.e().setVisibility(0);
                o.this.e().setText(o.this.getContext().getString(R.string.z4e));
                if (!n.f142511a.b().L()) {
                    o.this.e().setVisibility(8);
                    return;
                }
                return;
            }
            o.this.g().setVisibility(8);
            o.this.h().setVisibility(0);
            o.this.e().setVisibility(0);
            RecyclerView.Adapter adapter2 = o.this.h().getAdapter();
            if (adapter2 != null) {
                adapter2.notifyDataSetChanged();
            }
            o.this.e().setText(o.this.getContext().getString(R.string.z4c));
            if (!n.f142511a.b().L()) {
                o.this.e().setVisibility(8);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            o.this.s().invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(Context context, String appId, com.tencent.luggage.wxa.wj.c windowAndroid) {
        super(context, windowAndroid);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(windowAndroid, "windowAndroid");
        this.R = appId;
        this.T = new ArrayList();
        this.U = d.f142518a;
        this.V = g.f142521a;
        this.W = f.f142520a;
        this.X = h.f142522a;
        this.Y = e.f142519a;
        this.Z = i.f142523a;
        this.f142514a0 = j.f142524a;
        a(new a());
        b(new b());
        e().setOnClickListener(new c());
        d().setVisibility(0);
    }

    @Override // com.tencent.luggage.wxa.rj.e
    public /* synthetic */ com.tencent.luggage.wxa.ml.r a(com.tencent.luggage.wxa.ic.d dVar) {
        return u.a(this, dVar);
    }

    @Override // com.tencent.luggage.wxa.ce.a
    public void b(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.Z = function0;
    }

    @Override // com.tencent.luggage.wxa.ce.a
    public void c(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.V = function0;
    }

    @Override // com.tencent.luggage.wxa.ce.a
    public void d(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.Y = function0;
    }

    @Override // com.tencent.luggage.wxa.ce.a
    public void e(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.W = function0;
    }

    @Override // com.tencent.luggage.wxa.ce.a
    public void f(String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        g(desc);
    }

    @Override // com.tencent.luggage.wxa.uj.a
    public void k() {
        onCancel();
    }

    public final String m() {
        return this.R;
    }

    public final int n() {
        return i().getMeasuredHeight();
    }

    public Function1 o() {
        return this.U;
    }

    public Function0 p() {
        return this.Y;
    }

    public Function0 q() {
        return this.W;
    }

    public Function0 r() {
        return this.V;
    }

    public Function0 s() {
        return this.X;
    }

    public Function0 t() {
        return this.Z;
    }

    public Function1 u() {
        return this.f142514a0;
    }

    public ArrayList v() {
        return this.T;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean a() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.ce.a
    public void b(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.f142514a0 = function1;
    }

    @Override // com.tencent.luggage.wxa.ce.a
    public void d(String wording) {
        Intrinsics.checkNotNullParameter(wording, "wording");
        k(wording);
    }

    @Override // com.tencent.luggage.wxa.ce.a
    public void e(String wording) {
        Intrinsics.checkNotNullParameter(wording, "wording");
        h(wording);
    }

    @Override // com.tencent.luggage.wxa.ce.a
    public void b(boolean z16) {
        super.c(z16);
        if (z16) {
            super.a(com.tencent.luggage.wxa.lo.m.a(getContext(), R.drawable.m8n, ContextCompat.getColor(getContext(), R.color.ai7)));
            super.m(getContext().getString(R.string.z1m));
            super.b(new l());
            return;
        }
        super.b((View.OnClickListener) null);
    }

    @Override // com.tencent.luggage.wxa.ce.a
    public void a(ArrayList value) {
        Intrinsics.checkNotNullParameter(value, "value");
        v().clear();
        v().addAll(value);
        com.tencent.luggage.wxa.tk.l.a(new k());
    }

    @Override // com.tencent.luggage.wxa.ce.a
    public void a(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.U = function1;
    }

    @Override // com.tencent.luggage.wxa.ce.a
    public void a(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.X = function0;
    }

    @Override // com.tencent.luggage.wxa.rj.g
    public com.tencent.luggage.wxa.rj.f a(com.tencent.luggage.wxa.ic.d component, String str, d0 d0Var) {
        com.tencent.luggage.wxa.wj.c D;
        Intrinsics.checkNotNullParameter(component, "component");
        com.tencent.luggage.wxa.ic.g runtime = component.getRuntime();
        if (runtime == null || (D = runtime.n0()) == null) {
            D = component.D();
            Intrinsics.checkNotNull(D);
        }
        com.tencent.luggage.wxa.wj.c cVar = D;
        Intrinsics.checkNotNullExpressionValue(cVar, "component.runtime?.windo\u2026component.windowAndroid!!");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "this.context");
        com.tencent.luggage.wxa.ml.l lVar = new com.tencent.luggage.wxa.ml.l(d0Var, str, context, n(), cVar);
        lVar.c(getPosition());
        return lVar;
    }

    @Override // com.tencent.luggage.wxa.rj.e
    public void b(com.tencent.luggage.wxa.ic.d component) {
        Intrinsics.checkNotNullParameter(component, "component");
        super.c(super.getPosition());
        a(component).a(this);
    }

    @Override // com.tencent.luggage.wxa.ce.a
    public com.tencent.luggage.wxa.rj.e a(com.tencent.luggage.wxa.ic.d component, String appId, q qVar, com.tencent.luggage.wxa.uj.k phoneItem, i.a aVar) {
        com.tencent.luggage.wxa.wj.c D;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(phoneItem, "phoneItem");
        com.tencent.luggage.wxa.ic.g runtime = component.getRuntime();
        if (runtime == null || (D = runtime.n0()) == null) {
            D = component.D();
            Intrinsics.checkNotNull(D);
        }
        com.tencent.luggage.wxa.wj.c cVar = D;
        Intrinsics.checkNotNullExpressionValue(cVar, "component.runtime?.windo\u2026component.windowAndroid!!");
        int n3 = n();
        int a16 = x.a(getContext()) + com.tencent.luggage.wxa.lo.o.a(getContext(), 150);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "this.context");
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(n3, a16);
        return new t(context, coerceAtLeast, cVar, appId, qVar, phoneItem, aVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final e f142519a = new e();

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final f f142520a = new f();

        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final g f142521a = new g();

        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final h f142522a = new h();

        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final i f142523a = new i();

        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final d f142518a = new d();

        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Boolean) obj).booleanValue());
            return Unit.INSTANCE;
        }

        public final void a(boolean z16) {
        }
    }
}
