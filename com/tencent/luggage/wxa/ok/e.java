package com.tencent.luggage.wxa.ok;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.ui.statusbar.a;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends LinearLayout implements a.d {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.c5.e f136583a;

    /* renamed from: b, reason: collision with root package name */
    public final d[] f136584b;

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray f136585c;

    /* renamed from: d, reason: collision with root package name */
    public final SparseArray f136586d;

    /* renamed from: e, reason: collision with root package name */
    public int f136587e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f136589a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f136590b;

        public b(int i3, String str) {
            this.f136589a = i3;
            this.f136590b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.b(this.f136589a, this.f136590b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f136592a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f136593b;

        public c(String str, String str2) {
            this.f136592a = str;
            this.f136593b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.b(this.f136592a, this.f136593b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d extends TextView {
        public d(Context context) {
            super(context);
            a();
        }

        public final void a() {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            int a16 = com.tencent.luggage.wxa.kn.a.a(getContext(), 5);
            layoutParams.setMargins(0, a16, 0, a16);
            setLayoutParams(layoutParams);
            setTextSize(1, 12.0f);
            setTextColor(getContext().getResources().getColor(R.color.bgr));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ok.e$e, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6558e extends TextView {

        /* renamed from: a, reason: collision with root package name */
        public String f136596a;

        /* renamed from: b, reason: collision with root package name */
        public String f136597b;

        public C6558e(Context context) {
            super(context);
            a();
        }

        public final void a() {
            setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            setTextSize(1, 12.0f);
            setTextColor(getContext().getResources().getColor(R.color.anr));
        }

        public final void b(String str) {
            this.f136597b = str;
            b();
        }

        public final void b() {
            setText(String.format("%s: %s", this.f136596a, this.f136597b));
        }

        public final void a(String str) {
            this.f136596a = str;
            b();
        }
    }

    public e(Context context, com.tencent.luggage.wxa.c5.e eVar) {
        super(context);
        this.f136583a = eVar;
        this.f136585c = new SparseArray();
        this.f136586d = new SparseArray();
        this.f136584b = new d[4];
        g();
    }

    public final void b() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 2);
        TextView textView = new TextView(getContext());
        View view = new View(getContext());
        textView.setTextColor(-1);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(1, 14.0f);
        textView.setText(getContext().getString(R.string.z0k));
        addView(textView);
        layoutParams2.setMargins(0, com.tencent.luggage.wxa.kn.a.a(getContext(), 10), 0, 0);
        view.setLayoutParams(layoutParams2);
        view.setBackgroundColor(1728053247);
        addView(view);
    }

    public final void c() {
        setVisibility(0);
        setAlpha(0.0f);
        animate().alpha(1.0f).setDuration(500L).setStartDelay(500L).setListener(null);
    }

    public final void d() {
        animate().alpha(0.0f).setDuration(500L).setListener(new a());
    }

    public void e() {
        com.tencent.luggage.wxa.qj.b.a(this.f136583a.getAppId());
        d();
    }

    public final void f() {
        int i3 = getContext().getResources().getDisplayMetrics().widthPixels;
        int a16 = com.tencent.luggage.wxa.kn.a.a(getContext(), 10);
        int a17 = com.tencent.luggage.wxa.kn.a.a(getContext(), 4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((i3 * 3) / 5, -2);
        layoutParams.gravity = 53;
        setLayoutParams(layoutParams);
        h();
        setPadding(a16, a16, a16, a16);
        setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(a17);
        gradientDrawable.setColor(-652403418);
        setBackground(gradientDrawable);
    }

    public final void g() {
        setClickable(false);
        f();
        b();
        a();
        com.tencent.mm.ui.statusbar.a.a((Activity) getContext()).a(this);
    }

    public final void h() {
        if (getLayoutParams() != null && (getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) getLayoutParams()).topMargin = com.tencent.luggage.wxa.il.b.a(getContext()) + this.f136587e;
            requestLayout();
        }
    }

    public void i() {
        com.tencent.luggage.wxa.qj.b.b(this.f136583a);
        c();
    }

    public final void a() {
        for (int i3 = 0; i3 < 4; i3++) {
            d dVar = new d(getContext());
            dVar.setText(getContext().getString(com.tencent.luggage.wxa.qj.d.f138912a[i3]));
            this.f136584b[i3] = dVar;
            addView(dVar);
        }
    }

    public final C6558e c(int i3, String str) {
        C6558e c6558e = new C6558e(getContext());
        c6558e.a(str);
        int i16 = (i3 / 100) - 1;
        if (i16 >= 4) {
            w.b("MicroMsg.AppBrandUIPerformancePanel", "insertPerformanceLabelView group index is invalid.");
            return null;
        }
        if (i16 == 3) {
            addView(c6558e);
        } else {
            addView(c6558e, indexOfChild(this.f136584b[i16 + 1]));
        }
        this.f136586d.put(i3, c6558e);
        return c6558e;
    }

    public void a(int i3, String str) {
        com.tencent.luggage.wxa.tk.l.a(new b(i3, str));
    }

    public void a(String str, String str2) {
        com.tencent.luggage.wxa.tk.l.a(new c(str, str2));
    }

    @Override // com.tencent.mm.ui.statusbar.a.d
    public void a(int i3) {
        this.f136587e = i3;
        h();
    }

    public final void b(int i3, String str) {
        Integer num = (Integer) com.tencent.luggage.wxa.qj.d.f138913b.get(i3);
        if (num == null) {
            w.b("MicroMsg.AppBrandUIPerformancePanel", "insertPerformanceData no such performance type: %d", Integer.valueOf(i3));
            return;
        }
        String string = getContext().getString(num.intValue());
        C6558e c6558e = (C6558e) this.f136586d.get(i3);
        if (c6558e == null) {
            c6558e = c(i3, string);
        }
        if (c6558e != null) {
            c6558e.b(str);
        } else {
            w.b("MicroMsg.AppBrandUIPerformancePanel", "insertPerformanceData label view is null.");
        }
    }

    public final void b(String str, String str2) {
        C6558e c6558e = (C6558e) this.f136585c.get(str.hashCode());
        if (c6558e == null) {
            c6558e = new C6558e(getContext());
            c6558e.a(str);
            addView(c6558e);
            this.f136585c.put(str.hashCode(), c6558e);
        }
        c6558e.b(str2);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e.this.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
