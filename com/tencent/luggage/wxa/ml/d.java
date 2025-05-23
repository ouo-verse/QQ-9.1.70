package com.tencent.luggage.wxa.ml;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.luggage.wxa.jl.c;
import com.tencent.luggage.wxa.ml.j;
import com.tencent.luggage.wxa.tj.d;
import com.tencent.luggage.wxa.xd.d0;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.WxaIconTransformation;
import com.tencent.mm.plugin.appbrand.ui.MaxHeightRecyclerView;
import com.tencent.mm.plugin.appbrand.ui.WxaDefaultIcon;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends Dialog implements m, com.tencent.luggage.wxa.tj.d {
    public static final c S = new c(null);
    public View C;
    public e D;
    public View E;
    public DialogInterface.OnShowListener F;
    public DialogInterface.OnDismissListener G;
    public r H;
    public d.c I;
    public j J;
    public String K;
    public final List L;
    public String M;
    public String N;
    public String O;
    public String P;
    public String Q;
    public int R;

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.wj.c f134648a;

    /* renamed from: b, reason: collision with root package name */
    public final View f134649b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f134650c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f134651d;

    /* renamed from: e, reason: collision with root package name */
    public Button f134652e;

    /* renamed from: f, reason: collision with root package name */
    public Button f134653f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f134654g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f134655h;

    /* renamed from: i, reason: collision with root package name */
    public ImageView f134656i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f134657j;

    /* renamed from: k, reason: collision with root package name */
    public LinearLayout f134658k;

    /* renamed from: l, reason: collision with root package name */
    public MaxHeightRecyclerView f134659l;

    /* renamed from: m, reason: collision with root package name */
    public TextView f134660m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e41.c.a(d.this.I, 2, d.this.c(false), 0, false, 12, null);
            r j3 = d.this.j();
            if (j3 != null) {
                j3.b(d.this);
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
            int i3;
            if (d.this.o()) {
                ArrayList c16 = d.this.c(true);
                d.c cVar = d.this.I;
                j.a l3 = d.this.l();
                if (l3 != null) {
                    i3 = l3.a();
                } else {
                    i3 = 0;
                }
                cVar.a(1, c16, i3, d.this.m().e());
                r j3 = d.this.j();
                if (j3 != null) {
                    j3.b(d.this);
                    return;
                }
                return;
            }
            if (d.this.m().c() && !d.this.m().b()) {
                ((ScrollView) d.this.k().findViewById(R.id.iig)).fullScroll(130);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c {
        public c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ml.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class ViewTreeObserverOnGlobalLayoutListenerC6481d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ double f134663a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f134664b;

        public ViewTreeObserverOnGlobalLayoutListenerC6481d(double d16, d dVar) {
            this.f134663a = d16;
            this.f134664b = dVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int dimensionPixelSize;
            View childAt;
            double d16 = this.f134663a;
            int i3 = 0;
            int i16 = 0;
            while (d16 > 0.0d) {
                RecyclerView.LayoutManager layoutManager = this.f134664b.f134659l.getLayoutManager();
                if (layoutManager != null && (childAt = layoutManager.getChildAt(i16)) != null) {
                    dimensionPixelSize = childAt.getMeasuredHeight();
                } else {
                    dimensionPixelSize = this.f134664b.getContext().getResources().getDimensionPixelSize(R.dimen.c3m);
                }
                if (d16 < 1.0d) {
                    dimensionPixelSize = (int) (dimensionPixelSize * d16);
                }
                i3 += dimensionPixelSize;
                d16 -= 1.0d;
                i16++;
            }
            this.f134664b.f134659l.setMaxHeight(i3);
            this.f134664b.f134659l.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, com.tencent.luggage.wxa.wj.c windowAndroid, d.c listener) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(windowAndroid, "windowAndroid");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f134648a = windowAndroid;
        View inflate = View.inflate(context, R.layout.dyg, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026and_request_dialog, null)");
        this.f134649b = inflate;
        View findViewById = inflate.findViewById(R.id.f115196vd);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.user_agreement_layout)");
        this.D = new e(context, findViewById);
        this.I = listener;
        this.K = "";
        ArrayList arrayList = new ArrayList();
        this.L = arrayList;
        View findViewById2 = inflate.findViewById(R.id.f73533tt);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.request_icon)");
        this.f134650c = (ImageView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.f73543tu);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.request_name)");
        this.f134651d = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.f73483to);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.request_cancel)");
        Button button = (Button) findViewById4;
        this.f134653f = button;
        button.setOnClickListener(new a());
        View findViewById5 = inflate.findViewById(R.id.f73553tv);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R.id.request_ok)");
        Button button2 = (Button) findViewById5;
        this.f134652e = button2;
        com.tencent.luggage.wxa.h6.l lVar = com.tencent.luggage.wxa.h6.l.f126905a;
        lVar.a(button2.getPaint());
        this.f134652e.setOnClickListener(new b());
        View findViewById6 = inflate.findViewById(R.id.f73513tr);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mRootView.findViewById(R.id.request_desc)");
        this.f134654g = (TextView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.f85464p1);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "mRootView.findViewById(R.id.simple_detail_desc)");
        this.f134655h = (TextView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.f73503tq);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "mRootView.findViewById(R.id.request_content)");
        this.f134658k = (LinearLayout) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.f73573tx);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "mRootView.findViewById(R.id.request_right_icon)");
        ImageView imageView = (ImageView) findViewById9;
        this.f134656i = imageView;
        c.a aVar = com.tencent.luggage.wxa.jl.c.f131190l;
        Integer valueOf = Integer.valueOf(R.string.z1m);
        Integer valueOf2 = Integer.valueOf(R.dimen.bh9);
        aVar.a(imageView, (r27 & 2) != 0 ? null : null, (r27 & 4) != 0 ? null : valueOf, (r27 & 8) != 0 ? false : false, (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? null : null, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? null : null, (r27 & 2048) != 0 ? null : null, (r27 & 4096) == 0 ? valueOf2 : null);
        View findViewById10 = inflate.findViewById(R.id.f73473tn);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "mRootView.findViewById(R.id.request_apply_wording)");
        TextView textView = (TextView) findViewById10;
        this.f134657j = textView;
        lVar.a(textView.getPaint());
        View findViewById11 = inflate.findViewById(R.id.f73563tw);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "mRootView.findViewById(R.id.request_recyclerview)");
        MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) findViewById11;
        this.f134659l = maxHeightRecyclerView;
        aVar.a(maxHeightRecyclerView, (r27 & 2) != 0 ? null : null, (r27 & 4) != 0 ? null : null, (r27 & 8) != 0 ? false : true, (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? null : null, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? null : null, (r27 & 2048) != 0 ? null : null, (r27 & 4096) == 0 ? null : null);
        this.f134659l.setLayoutManager(new LinearLayoutManager(context));
        j jVar = new j(arrayList);
        this.J = jVar;
        g();
        jVar.a(null);
        this.f134659l.setAdapter(this.J);
        this.f134659l.setItemAnimator(null);
        View findViewById12 = inflate.findViewById(R.id.i8d);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "mRootView.findViewById(R.id.request_loading)");
        this.E = findViewById12;
        View findViewById13 = inflate.findViewById(R.id.tjh);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "mRootView.findViewById(R.id.button_group)");
        this.C = findViewById13;
        View findViewById14 = inflate.findViewById(R.id.f73523ts);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "mRootView.findViewById(R.id.request_function)");
        TextView textView2 = (TextView) findViewById14;
        this.f134660m = textView2;
        aVar.a(textView2, (r27 & 2) != 0 ? null : Button.class, (r27 & 4) != 0 ? null : null, (r27 & 8) != 0 ? false : false, (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? null : null, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? null : null, (r27 & 2048) != 0 ? null : null, (r27 & 4096) == 0 ? valueOf2 : null);
        this.f134657j.setAccessibilityTraversalAfter(R.id.f73543tu);
        this.f134657j.setAccessibilityTraversalBefore(R.id.f73573tx);
        this.f134654g.setAccessibilityTraversalAfter(R.id.f73473tn);
        this.f134654g.setAccessibilityTraversalBefore(R.id.f73563tw);
        this.f134660m.setAccessibilityTraversalAfter(R.id.f73563tw);
        this.f134660m.setAccessibilityTraversalBefore(R.id.f73483to);
        this.R = 2;
    }

    @Override // com.tencent.luggage.wxa.rj.e
    public /* synthetic */ r a(com.tencent.luggage.wxa.ic.d dVar) {
        return com.tencent.luggage.wxa.rj.u.a(this, dVar);
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean b() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean c() {
        return true;
    }

    public final View d() {
        return this.C;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        n();
    }

    public final int e() {
        return this.f134649b.getMeasuredHeight();
    }

    public String f() {
        return this.Q;
    }

    public j.b g() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public View getContentView() {
        return this.f134649b;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public int getPosition() {
        return this.R;
    }

    public final Button h() {
        return this.f134652e;
    }

    public final Button i() {
        return this.f134653f;
    }

    public final r j() {
        return this.H;
    }

    public final View k() {
        return this.f134649b;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[LOOP:0: B:2:0x000a->B:13:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final j.a l() {
        boolean z16;
        for (j.a aVar : this.J.b()) {
            if (aVar != null) {
                z16 = true;
                if (aVar.b()) {
                    if (!z16) {
                        return aVar;
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        return null;
    }

    public final e m() {
        return this.D;
    }

    public void n() {
        DialogInterface.OnDismissListener onDismissListener = this.G;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this);
        }
    }

    public final boolean o() {
        if (!this.D.c()) {
            return true;
        }
        return this.D.b();
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void onCancel() {
        e41.c.a(this.I, 3, new ArrayList(), 0, false, 12, null);
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void onShown() {
        com.tencent.luggage.wxa.jl.a.a(this.f134649b);
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean a() {
        return false;
    }

    public final void d(int i3) {
        this.R = i3;
        if (i3 == 1) {
            this.f134649b.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.jab));
        } else {
            if (i3 != 2) {
                return;
            }
            this.f134649b.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.jaa));
        }
    }

    @Override // com.tencent.luggage.wxa.tj.d
    public void g(String str) {
        this.O = str;
        if (str != null) {
            this.f134655h.setVisibility(0);
            this.f134655h.setText(str);
        }
    }

    @Override // com.tencent.luggage.wxa.tj.d
    public void h(String str) {
        this.N = str;
        this.f134654g.setText(str);
    }

    @Override // com.tencent.luggage.wxa.tj.d
    public void i(String scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.K = scope;
    }

    @Override // com.tencent.luggage.wxa.tj.d
    public void j(String str) {
        if (str != null) {
            this.f134652e.setText(str);
        }
    }

    @Override // com.tencent.luggage.wxa.tj.d
    public void k(String str) {
        this.P = str;
        this.f134657j.setText(str);
    }

    public void m(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f134660m.setText("");
            this.f134660m.setVisibility(4);
        } else {
            this.f134660m.setText(str);
            this.f134660m.setVisibility(0);
        }
    }

    @Override // com.tencent.luggage.wxa.tj.d
    public void b(String str) {
        this.M = str;
        TextView textView = this.f134651d;
        if (str == null) {
            str = "";
        }
        textView.setText(str);
    }

    public final ArrayList c(boolean z16) {
        String e16;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.K)) {
            arrayList.add(this.K);
            return arrayList;
        }
        List<j.a> b16 = this.J.b();
        if (b16.size() == 1) {
            j.a aVar = (j.a) b16.get(0);
            if (aVar != null && (e16 = aVar.e()) != null) {
                arrayList.add(e16);
            }
            return arrayList;
        }
        for (j.a aVar2 : b16) {
            if ((aVar2 != null && aVar2.b() == z16) && aVar2.e() != null) {
                arrayList.add(aVar2.e());
            }
        }
        return arrayList;
    }

    @Override // com.tencent.luggage.wxa.tj.d
    public void l(String str) {
        if (str != null) {
            this.f134653f.setText(str);
        }
    }

    @Override // com.tencent.luggage.wxa.tj.d
    public void a(String str) {
        this.Q = str;
        AppBrandSimpleImageLoader.instance().attach(this.f134650c, f(), WxaDefaultIcon.get(), WxaIconTransformation.INSTANCE);
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void b(int i3) {
        t tVar = t.f134779a;
        Context context = getContentView().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "contentView.context");
        tVar.a(context, getContentView(), this.C, i3, this.f134648a, this.D.c());
        c(i3);
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void a(r rVar) {
        d(this.R);
        DialogInterface.OnShowListener onShowListener = this.F;
        if (onShowListener != null) {
            onShowListener.onShow(this);
        }
        this.H = rVar;
        Object systemService = getContext().getSystemService("window");
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager != null) {
            t tVar = t.f134779a;
            Context context = getContentView().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "contentView.context");
            tVar.a(context, getContentView(), this.C, windowManager.getDefaultDisplay().getRotation(), this.f134648a, this.D.c());
            c(windowManager.getDefaultDisplay().getRotation());
        }
    }

    @Override // com.tencent.luggage.wxa.rj.e
    public void b(com.tencent.luggage.wxa.ic.d component) {
        Intrinsics.checkNotNullParameter(component, "component");
        d(this.R);
        a(component).a(this);
    }

    public final void c(int i3) {
        this.f134659l.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC6481d((i3 == 1 || i3 == 3) ? 1.5d : 2.5d, this));
        this.f134659l.invalidate();
    }

    @Override // com.tencent.luggage.wxa.ml.q
    public void c(String wording) {
        Intrinsics.checkNotNullParameter(wording, "wording");
        this.D.c(wording);
    }

    @Override // com.tencent.luggage.wxa.ml.q
    public void a(d0 d0Var) {
        this.D.a(d0Var);
    }

    @Override // com.tencent.luggage.wxa.ml.q
    public void a(u uVar) {
        this.D.a(uVar);
    }

    @Override // com.tencent.luggage.wxa.tj.d
    public void a(int i3) {
        this.f134660m.setVisibility(i3);
    }

    @Override // com.tencent.luggage.wxa.tj.d
    public void a(View.OnClickListener onClickListener) {
        this.f134656i.setOnClickListener(onClickListener);
    }

    @Override // com.tencent.luggage.wxa.tj.d
    public void a(boolean z16) {
        this.f134656i.setVisibility(z16 ? 0 : 8);
    }

    @Override // com.tencent.luggage.wxa.tj.d
    public void a(List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.L.clear();
        this.L.addAll(list);
        this.J.notifyDataSetChanged();
        this.f134658k.setVisibility(0);
        this.E.setVisibility(8);
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
        l lVar = new l(d0Var, str, context, e(), cVar);
        lVar.c(getPosition());
        return lVar;
    }
}
