package com.tencent.luggage.wxa.ml;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Vibrator;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.wk.d;
import com.tencent.luggage.wxa.xd.d0;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e implements q {

    /* renamed from: a, reason: collision with root package name */
    public final Context f134665a;

    /* renamed from: b, reason: collision with root package name */
    public final View f134666b;

    /* renamed from: c, reason: collision with root package name */
    public View f134667c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f134668d;

    /* renamed from: e, reason: collision with root package name */
    public CheckBox f134669e;

    /* renamed from: f, reason: collision with root package name */
    public View f134670f;

    /* renamed from: g, reason: collision with root package name */
    public d0 f134671g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f134672h;

    /* renamed from: i, reason: collision with root package name */
    public u f134673i;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e.this.f134669e.setChecked(!e.this.f134669e.isChecked());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int lineHeight = e.this.f134668d.getLineHeight();
            int height = e.this.f134669e.getHeight();
            if (lineHeight > height) {
                if (e.this.f134670f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.LayoutParams layoutParams = e.this.f134670f.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = (lineHeight - height) / 2;
                }
            } else if (e.this.f134668d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.LayoutParams layoutParams2 = e.this.f134668d.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = (height - lineHeight) / 2;
            }
            e.this.f134668d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements d.a {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.wk.d.a
        public final void a(String str) {
            d0 d0Var = e.this.f134671g;
            if (d0Var != null) {
                d0Var.a(e.this.f134665a, str, "", null);
            }
        }
    }

    public e(Context context, View view) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        this.f134665a = context;
        this.f134666b = view;
        this.f134667c = b(R.id.f115196vd);
        this.f134668d = (TextView) b(R.id.f115186vc);
        this.f134669e = (CheckBox) b(R.id.f115166va);
        this.f134670f = b(R.id.f115176vb);
        this.f134667c.setOnClickListener(new a());
        this.f134668d.getViewTreeObserver().addOnGlobalLayoutListener(new b());
    }

    @Override // com.tencent.luggage.wxa.ml.q
    public void a(d0 d0Var) {
        this.f134671g = d0Var;
    }

    public boolean b() {
        if (!this.f134672h) {
            return false;
        }
        if (this.f134669e.isChecked()) {
            return true;
        }
        d();
        u uVar = this.f134673i;
        if (uVar != null) {
            uVar.a();
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.ml.q
    public void c(String wording) {
        Intrinsics.checkNotNullParameter(wording, "wording");
        if (wording.length() == 0) {
            return;
        }
        a();
        this.f134668d.setText(com.tencent.luggage.wxa.wk.d.a(wording, false, (d.a) new c()));
        this.f134668d.setMovementMethod(LinkMovementMethod.getInstance());
        this.f134668d.setLinkTextColor(ContextCompat.getColor(this.f134665a, R.color.aud));
        ViewCompat.enableAccessibleClickableSpanSupport(this.f134668d);
        this.f134672h = true;
    }

    public final void d() {
        float dimensionPixelOffset = this.f134665a.getResources().getDimensionPixelOffset(R.dimen.bj8);
        float f16 = -dimensionPixelOffset;
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.f134666b, "translationX", 0.0f, f16, dimensionPixelOffset, f16, 0.0f).setDuration(300L);
        Intrinsics.checkNotNullExpressionValue(duration, "ofFloat(\n            vie\u2026       ).setDuration(300)");
        duration.setInterpolator(new LinearInterpolator());
        duration.start();
        if (ContextCompat.checkSelfPermission(z.c(), "android.permission.VIBRATE") == 0) {
            Object systemService = z.c().getSystemService("vibrator");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
            ((Vibrator) systemService).vibrate(100L);
        }
    }

    public final boolean e() {
        return this.f134667c.getVisibility() == 0 && this.f134669e.isChecked();
    }

    @Override // com.tencent.luggage.wxa.ml.q
    public void a(u uVar) {
        this.f134673i = uVar;
    }

    public final void a() {
        if (this.f134666b.getVisibility() != 0) {
            this.f134666b.setVisibility(0);
        }
    }

    public final View b(int i3) {
        return this.f134666b.findViewById(i3);
    }

    public final boolean c() {
        return this.f134672h && this.f134666b.getVisibility() == 0;
    }
}
