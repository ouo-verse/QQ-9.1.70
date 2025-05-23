package com.tencent.luggage.wxa.ml;

import android.content.Context;
import android.graphics.Color;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.wk.d;
import com.tencent.luggage.wxa.xd.d0;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l implements m, com.tencent.luggage.wxa.rj.f {
    public static final d C = new d(null);

    /* renamed from: a, reason: collision with root package name */
    public final d0 f134761a;

    /* renamed from: b, reason: collision with root package name */
    public final String f134762b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f134763c;

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.wj.c f134764d;

    /* renamed from: e, reason: collision with root package name */
    public r f134765e;

    /* renamed from: f, reason: collision with root package name */
    public final int f134766f;

    /* renamed from: g, reason: collision with root package name */
    public int f134767g;

    /* renamed from: h, reason: collision with root package name */
    public int f134768h;

    /* renamed from: i, reason: collision with root package name */
    public final View f134769i;

    /* renamed from: j, reason: collision with root package name */
    public final ImageView f134770j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f134771k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f134772l;

    /* renamed from: m, reason: collision with root package name */
    public final View f134773m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements View.OnLayoutChangeListener {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ml.l$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class RunnableC6484a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ l f134775a;

            public RunnableC6484a(l lVar) {
                this.f134775a = lVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f134775a.f134769i.getLayoutParams().height = this.f134775a.f134767g;
            }
        }

        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            if (Math.abs(i18 - i16) > l.this.f134767g && l.this.f134767g >= l.this.f134766f) {
                l.this.f134769i.post(new RunnableC6484a(l.this));
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
            r rVar = l.this.f134765e;
            if (rVar != null) {
                rVar.b(l.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements d.a {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.wk.d.a
        public final void a(String str) {
            d0 d0Var = l.this.f134761a;
            if (d0Var != null) {
                d0Var.a(l.this.f(), str, "", null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d {
        public d() {
        }

        public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public l(d0 d0Var, String str, Context context, int i3, com.tencent.luggage.wxa.wj.c windowAndroid) {
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(windowAndroid, "windowAndroid");
        this.f134761a = d0Var;
        this.f134762b = str;
        this.f134763c = context;
        this.f134764d = windowAndroid;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(com.tencent.luggage.wxa.lo.o.a(context, 360), i3);
        this.f134766f = coerceAtLeast;
        this.f134767g = e();
        if (d0Var == null) {
            w.f("Luggage.FULL.DialogExplainDialog", "<init> get NULL webviewOpener");
        }
        this.f134768h = 2;
        View inflate = View.inflate(context, R.layout.f167651dy4, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026ber_explain_dialog, null)");
        this.f134773m = inflate;
        View findViewById = inflate.findViewById(R.id.f2445096);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026e_number_explain_content)");
        this.f134769i = findViewById;
        findViewById.setMinimumHeight(coerceAtLeast);
        findViewById.addOnLayoutChangeListener(new a());
        View findViewById2 = inflate.findViewById(R.id.f2446097);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026mber_explain_dialog_back)");
        ImageView imageView = (ImageView) findViewById2;
        this.f134770j = imageView;
        com.tencent.luggage.wxa.jl.c.f131190l.a(imageView, (r27 & 2) != 0 ? null : null, (r27 & 4) != 0 ? null : null, (r27 & 8) != 0 ? false : false, (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? null : null, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? null : 17, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? null : null, (r27 & 2048) != 0 ? null : null, (r27 & 4096) == 0 ? Integer.valueOf(R.dimen.bh9) : null);
        if (imageView != null) {
            imageView.setOnClickListener(new b());
        }
        View findViewById3 = inflate.findViewById(R.id.f2448099);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026ber_explain_dialog_title)");
        TextView textView = (TextView) findViewById3;
        this.f134771k = textView;
        textView.setText(inflate.getContext().getText(R.string.z3u));
        View findViewById4 = inflate.findViewById(R.id.f2447098);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026r_explain_dialog_content)");
        TextView textView2 = (TextView) findViewById4;
        this.f134772l = textView2;
        textView2.setText(com.tencent.luggage.wxa.wk.d.a(str, false, (d.a) new c()));
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setLinkTextColor(Color.parseColor("#FF576B95"));
        ViewCompat.enableAccessibleClickableSpanSupport(textView2);
    }

    @Override // com.tencent.luggage.wxa.rj.e
    public /* synthetic */ r a(com.tencent.luggage.wxa.ic.d dVar) {
        return com.tencent.luggage.wxa.rj.u.a(this, dVar);
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean b() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean c() {
        return true;
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        r rVar = this.f134765e;
        if (rVar != null) {
            rVar.b(this);
        }
    }

    public final Context f() {
        return this.f134763c;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public View getContentView() {
        return this.f134773m;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public int getPosition() {
        return this.f134768h;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void onShown() {
        com.tencent.luggage.wxa.jl.a.a(this.f134773m);
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean a() {
        return false;
    }

    public final void d() {
        Object systemService = this.f134763c.getSystemService("window");
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager != null) {
            t tVar = t.f134779a;
            Context context = getContentView().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "contentView.context");
            t.a(tVar, context, getContentView(), null, windowManager.getDefaultDisplay().getRotation(), this.f134764d, false, 32, null);
        }
    }

    public final int e() {
        int i3 = (int) (this.f134763c.getResources().getDisplayMetrics().heightPixels * (2 == this.f134763c.getResources().getConfiguration().orientation ? 1.0f : 0.75f));
        w.d("Luggage.FULL.DialogExplainDialog", "calculateMaxHeight, maxHeight: " + i3);
        return i3;
    }

    @Override // com.tencent.luggage.wxa.rj.e
    public void b(com.tencent.luggage.wxa.ic.d component) {
        Intrinsics.checkNotNullParameter(component, "component");
        c(this.f134768h);
        a(component).a(this);
    }

    public final void c(int i3) {
        this.f134768h = i3;
        if (i3 == 1) {
            this.f134773m.setBackground(ContextCompat.getDrawable(this.f134763c, R.drawable.jab));
        } else {
            if (i3 != 2) {
                return;
            }
            this.f134773m.setBackground(ContextCompat.getDrawable(this.f134763c, R.drawable.jaa));
        }
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void a(r rVar) {
        this.f134765e = rVar;
        d();
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void b(int i3) {
        d();
        this.f134767g = e();
    }

    @Override // android.content.DialogInterface
    public void cancel() {
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void onCancel() {
    }
}
