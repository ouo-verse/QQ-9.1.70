package com.tencent.luggage.wxa.kj;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.fd.b;
import com.tencent.luggage.wxa.kl.b;
import com.tencent.luggage.wxa.kl.i;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a1 extends FrameLayout implements b.g {

    /* renamed from: a, reason: collision with root package name */
    public v f132069a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.kl.d f132070b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.kl.b f132071c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f132072d;

    public a1(Context context, v vVar) {
        super(context);
        this.f132072d = false;
        this.f132069a = vVar;
        b();
    }

    public final void a(Context context) {
        com.tencent.luggage.wxa.kl.d dVar = this.f132070b;
        if (dVar != null) {
            dVar.a(context);
        }
    }

    public final void b() {
        b.e r06 = this.f132069a.r0();
        if (r06 == null) {
            return;
        }
        if (r06.a()) {
            com.tencent.luggage.wxa.kl.d dVar = new com.tencent.luggage.wxa.kl.d(getContext());
            this.f132070b = dVar;
            dVar.setWindowAndroid(this.f132069a.D());
            this.f132070b.setActuallyVisible(false);
            com.tencent.luggage.wxa.kl.b bVar = (com.tencent.luggage.wxa.kl.b) this.f132069a.g0().b(getContext(), com.tencent.luggage.wxa.kl.b.class);
            this.f132071c = bVar;
            bVar.setFullscreenMode(false);
            this.f132071c.a(true, i.a.EnumC6399a.PageConfig);
            try {
                this.f132069a.getRuntime().I().a(this.f132071c.getCapsuleView());
            } catch (NullPointerException unused) {
            }
            d();
            this.f132070b.addView(this.f132071c);
            addView(this.f132070b, -1, -2);
        }
        setBackgroundColor(com.tencent.luggage.wxa.tk.g.a(r06.f125688h, -1));
    }

    public final void c() {
        if (this.f132071c != null) {
            if (getVisibility() == 0 && ViewCompat.isAttachedToWindow(this)) {
                this.f132071c.setLoadingIconVisibility(true);
                this.f132070b.setActuallyVisible(true);
            } else {
                this.f132071c.setLoadingIconVisibility(false);
                this.f132070b.setActuallyVisible(false);
            }
        }
    }

    public final void d() {
        if (this.f132071c == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.f132069a.W().getMainTitle())) {
            this.f132071c.setMainTitle(this.f132069a.W().getMainTitle());
        } else {
            this.f132071c.setMainTitle(getContext().getString(R.string.ywk));
        }
        this.f132071c.setNavHidden(this.f132069a.W().m());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        if (i3 == 0) {
            setWillNotDraw(true);
            return;
        }
        int i16 = i3 | (-16777216);
        setWillNotDraw(false);
        super.setBackgroundColor(i16);
        com.tencent.luggage.wxa.kl.b bVar = this.f132071c;
        if (bVar != null) {
            bVar.setBackgroundAlpha(1.0d);
            this.f132071c.setBackgroundColor(i16);
            this.f132071c.setForegroundStyle(!com.tencent.luggage.wxa.lo.m.a(i16));
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        c();
    }

    @Override // com.tencent.luggage.wxa.kl.b.g
    public void a(boolean z16) {
        this.f132072d = z16;
    }

    public void a() {
        removeAllViews();
        com.tencent.luggage.wxa.kl.b bVar = this.f132071c;
        if (bVar != null) {
            bVar.destroy();
        }
    }
}
