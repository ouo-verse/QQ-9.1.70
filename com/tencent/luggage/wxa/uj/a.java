package com.tencent.luggage.wxa.uj;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
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
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.xd.d0;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.WxaIconTransformation;
import com.tencent.mm.ui.widget.dialog.DialogLeakFix;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends Dialog implements com.tencent.luggage.wxa.ml.m, com.tencent.luggage.wxa.ml.q {
    public static final c Q = new c(null);
    public TextView C;
    public View D;
    public View E;
    public DialogInterface.OnShowListener F;
    public com.tencent.luggage.wxa.ml.r G;
    public d H;
    public String I;
    public Drawable J;
    public String K;
    public String L;
    public String M;
    public String N;
    public String O;
    public int P;

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.wj.c f142429a;

    /* renamed from: b, reason: collision with root package name */
    public View f142430b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.ml.e f142431c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f142432d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f142433e;

    /* renamed from: f, reason: collision with root package name */
    public Button f142434f;

    /* renamed from: g, reason: collision with root package name */
    public Button f142435g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f142436h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f142437i;

    /* renamed from: j, reason: collision with root package name */
    public ImageView f142438j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f142439k;

    /* renamed from: l, reason: collision with root package name */
    public LinearLayout f142440l;

    /* renamed from: m, reason: collision with root package name */
    public RecyclerView f142441m;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.uj.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class ViewOnClickListenerC6802a implements View.OnClickListener {
        public ViewOnClickListenerC6802a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            d f16 = a.this.f();
            if (f16 != null) {
                g41.a.a(f16, 2, false, 2, null);
            }
            com.tencent.luggage.wxa.ml.r rVar = a.this.G;
            if (rVar != null) {
                rVar.b(a.this);
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
            if (!a.this.l()) {
                if (a.this.f142431c.c() && !a.this.f142431c.b()) {
                    ((ScrollView) a.this.i().findViewById(R.id.iig)).fullScroll(130);
                    return;
                }
                return;
            }
            d f16 = a.this.f();
            if (f16 != null) {
                f16.a(1, a.this.j());
            }
            com.tencent.luggage.wxa.ml.r rVar = a.this.G;
            if (rVar != null) {
                rVar.b(a.this);
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
    /* loaded from: classes8.dex */
    public interface d {
        void a(int i3, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            DialogLeakFix.clearReferencesOnDismiss(a.this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, com.tencent.luggage.wxa.wj.c windowAndroid) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(windowAndroid, "windowAndroid");
        this.f142429a = windowAndroid;
        View inflate = View.inflate(context, R.layout.dyg, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026and_request_dialog, null)");
        this.f142430b = inflate;
        View findViewById = inflate.findViewById(R.id.f115196vd);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.user_agreement_layout)");
        this.f142431c = new com.tencent.luggage.wxa.ml.e(context, findViewById);
        View findViewById2 = this.f142430b.findViewById(R.id.f73533tt);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.request_icon)");
        this.f142432d = (ImageView) findViewById2;
        View findViewById3 = this.f142430b.findViewById(R.id.f73543tu);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.request_name)");
        this.f142433e = (TextView) findViewById3;
        View findViewById4 = this.f142430b.findViewById(R.id.f73483to);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.request_cancel)");
        Button button = (Button) findViewById4;
        this.f142435g = button;
        button.setOnClickListener(new ViewOnClickListenerC6802a());
        View findViewById5 = this.f142430b.findViewById(R.id.f73553tv);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R.id.request_ok)");
        Button button2 = (Button) findViewById5;
        this.f142434f = button2;
        com.tencent.luggage.wxa.h6.l lVar = com.tencent.luggage.wxa.h6.l.f126905a;
        lVar.a(button2.getPaint());
        this.f142434f.setOnClickListener(new b());
        View findViewById6 = this.f142430b.findViewById(R.id.f73513tr);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mRootView.findViewById(R.id.request_desc)");
        this.f142436h = (TextView) findViewById6;
        View findViewById7 = this.f142430b.findViewById(R.id.f85464p1);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "mRootView.findViewById(R.id.simple_detail_desc)");
        this.f142437i = (TextView) findViewById7;
        View findViewById8 = this.f142430b.findViewById(R.id.f73503tq);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "mRootView.findViewById(R.id.request_content)");
        this.f142440l = (LinearLayout) findViewById8;
        View findViewById9 = this.f142430b.findViewById(R.id.f73573tx);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "mRootView.findViewById(R.id.request_right_icon)");
        ImageView imageView = (ImageView) findViewById9;
        this.f142438j = imageView;
        c.a aVar = com.tencent.luggage.wxa.jl.c.f131190l;
        Integer valueOf = Integer.valueOf(R.dimen.bh9);
        aVar.a(imageView, (r27 & 2) != 0 ? null : null, (r27 & 4) != 0 ? null : null, (r27 & 8) != 0 ? false : false, (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? null : null, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? null : null, (r27 & 2048) != 0 ? null : null, (r27 & 4096) == 0 ? valueOf : null);
        View findViewById10 = this.f142430b.findViewById(R.id.f73473tn);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "mRootView.findViewById(R.id.request_apply_wording)");
        TextView textView = (TextView) findViewById10;
        this.f142439k = textView;
        lVar.a(textView.getPaint());
        View findViewById11 = this.f142430b.findViewById(R.id.f73563tw);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "mRootView.findViewById(R.id.request_recyclerview)");
        RecyclerView recyclerView = (RecyclerView) findViewById11;
        this.f142441m = recyclerView;
        aVar.a(recyclerView, (r27 & 2) != 0 ? null : null, (r27 & 4) != 0 ? null : null, (r27 & 8) != 0 ? false : true, (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? null : null, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? null : null, (r27 & 2048) != 0 ? null : null, (r27 & 4096) == 0 ? null : null);
        this.f142441m.setLayoutManager(new LinearLayoutManager(context));
        this.f142441m.setItemAnimator(null);
        View findViewById12 = this.f142430b.findViewById(R.id.i8d);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "mRootView.findViewById(R.id.request_loading)");
        this.E = findViewById12;
        View findViewById13 = this.f142430b.findViewById(R.id.tjh);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "mRootView.findViewById(R.id.button_group)");
        this.D = findViewById13;
        View findViewById14 = this.f142430b.findViewById(R.id.f73523ts);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "mRootView.findViewById(R.id.request_function)");
        TextView textView2 = (TextView) findViewById14;
        this.C = textView2;
        aVar.a(textView2, (r27 & 2) != 0 ? null : Button.class, (r27 & 4) != 0 ? null : null, (r27 & 8) != 0 ? false : false, (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? null : null, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? null : null, (r27 & 2048) != 0 ? null : null, (r27 & 4096) == 0 ? valueOf : null);
        this.P = 2;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean b() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean c() {
        return true;
    }

    public final LinearLayout d() {
        return this.f142440l;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            new b0(Looper.getMainLooper()).a((Runnable) new e());
            return;
        }
        try {
            super.dismiss();
        } finally {
            k();
            new b0(Looper.getMainLooper()).a((Runnable) new f());
        }
    }

    public final TextView e() {
        return this.C;
    }

    public final d f() {
        return this.H;
    }

    public final View g() {
        return this.E;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public View getContentView() {
        return this.f142430b;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public int getPosition() {
        return this.P;
    }

    public final RecyclerView h() {
        return this.f142441m;
    }

    public final View i() {
        return this.f142430b;
    }

    public boolean j() {
        return this.f142431c.b();
    }

    public abstract void k();

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k(String str) {
        boolean z16;
        boolean isBlank;
        this.O = str;
        this.f142439k.setText(str);
        TextView textView = this.f142439k;
        int i3 = 0;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    i3 = 8;
                }
                textView.setVisibility(i3);
            }
        }
        z16 = true;
        if (z16) {
        }
        textView.setVisibility(i3);
    }

    public final boolean l() {
        if (!this.f142431c.c()) {
            return true;
        }
        return j();
    }

    public final void m(String str) {
        this.K = str;
        this.f142438j.setContentDescription(str);
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void onCancel() {
        d dVar = this.H;
        if (dVar != null) {
            g41.a.a(dVar, 3, false, 2, null);
        }
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void onShown() {
        com.tencent.luggage.wxa.jl.a.a(this.f142430b);
    }

    public final void a(d dVar) {
        this.H = dVar;
    }

    @Override // com.tencent.luggage.wxa.ml.q
    public void c(String wording) {
        Intrinsics.checkNotNullParameter(wording, "wording");
        this.f142431c.c(wording);
    }

    public final void g(String str) {
        this.N = str;
        if (str != null) {
            this.f142437i.setVisibility(0);
            this.f142437i.setText(str);
        }
    }

    public final void h(String str) {
        this.M = str;
        this.f142436h.setText(str);
    }

    public final void a(String str) {
        this.I = str;
        AppBrandSimpleImageLoader.instance().attach(this.f142432d, this.I, R.drawable.ojy, WxaIconTransformation.INSTANCE);
    }

    public final void b(View.OnClickListener onClickListener) {
        this.f142438j.setOnClickListener(onClickListener);
    }

    public final void c(int i3) {
        this.P = i3;
        if (i3 == 1) {
            this.f142430b.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.jab));
        } else {
            if (i3 != 2) {
                return;
            }
            this.f142430b.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.jaa));
        }
    }

    public final void b(String str) {
        this.L = str;
        TextView textView = this.f142433e;
        if (str == null) {
            str = "";
        }
        textView.setText(str);
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void b(int i3) {
        com.tencent.luggage.wxa.ml.t tVar = com.tencent.luggage.wxa.ml.t.f134779a;
        Context context = this.f142430b.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
        tVar.a(context, this.f142430b, this.D, i3, this.f142429a, this.f142431c.c());
    }

    public final void c(boolean z16) {
        this.f142438j.setVisibility(z16 ? 0 : 8);
    }

    public final void a(Drawable drawable) {
        this.J = drawable;
        this.f142438j.setVisibility(8);
        if (drawable != null) {
            this.f142438j.setImageDrawable(this.J);
            this.f142438j.setVisibility(0);
        }
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void a(com.tencent.luggage.wxa.ml.r rVar) {
        DialogInterface.OnShowListener onShowListener = this.F;
        if (onShowListener != null) {
            onShowListener.onShow(this);
        }
        this.G = rVar;
        Object systemService = getContext().getSystemService("window");
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager != null) {
            com.tencent.luggage.wxa.ml.t tVar = com.tencent.luggage.wxa.ml.t.f134779a;
            Context context = this.f142430b.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
            tVar.a(context, this.f142430b, this.D, windowManager.getDefaultDisplay().getRotation(), this.f142429a, this.f142431c.c());
        }
    }

    @Override // com.tencent.luggage.wxa.ml.q
    public void a(d0 d0Var) {
        this.f142431c.a(d0Var);
    }
}
