package com.tencent.ecommerce.richtext.ui.dom.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: d, reason: collision with root package name */
    private RectF f105344d;

    /* renamed from: e, reason: collision with root package name */
    protected float f105345e;

    /* renamed from: h, reason: collision with root package name */
    private float f105348h;

    /* renamed from: i, reason: collision with root package name */
    private float f105349i;

    /* renamed from: j, reason: collision with root package name */
    private float f105350j;

    /* renamed from: k, reason: collision with root package name */
    private float f105351k;

    /* renamed from: l, reason: collision with root package name */
    private float f105352l;

    /* renamed from: m, reason: collision with root package name */
    private float f105353m;

    /* renamed from: n, reason: collision with root package name */
    private float f105354n;

    /* renamed from: o, reason: collision with root package name */
    private float f105355o;

    /* renamed from: a, reason: collision with root package name */
    private float f105341a = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    private float f105342b = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    private float f105343c = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    private boolean f105346f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f105347g = false;

    public final void a(@NonNull Canvas canvas, @NonNull Paint paint, float f16) {
        if (l()) {
            canvas.drawArc(this.f105348h, this.f105349i, this.f105350j, this.f105351k, f16, 45.0f, false, paint);
        } else {
            canvas.drawLine(i(), j(), g(), h(), paint);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float b() {
        return this.f105345e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RectF c() {
        return this.f105344d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float d() {
        return this.f105341a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float e() {
        return this.f105343c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float f() {
        return this.f105342b;
    }

    public final float g() {
        return this.f105354n;
    }

    public final float h() {
        return this.f105355o;
    }

    public final float i() {
        return this.f105352l;
    }

    public final float j() {
        return this.f105353m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return this.f105346f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return this.f105347g;
    }

    protected abstract void m();

    protected abstract void n();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void o(float f16, float f17, float f18, @NonNull RectF rectF, float f19) {
        boolean z16;
        boolean z17;
        RectF rectF2;
        boolean z18 = false;
        if (l.a(this.f105341a, f16) && l.a(this.f105342b, f17) && l.a(this.f105343c, f18) && l.a(this.f105345e, f19) && ((rectF2 = this.f105344d) == null || !rectF2.equals(rectF))) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.f105341a = f16;
            this.f105342b = f17;
            this.f105343c = f18;
            this.f105344d = rectF;
            this.f105345e = f19;
            if (f16 > 0.0f && !l.a(0.0f, f16)) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.f105347g = z17;
            if (z17 && f() >= 0.0f && e() >= 0.0f && d() > f() && d() > e()) {
                z18 = true;
            }
            this.f105346f = z18;
            if (this.f105347g) {
                m();
            }
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void p(float f16) {
        this.f105351k = f16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void q(float f16) {
        this.f105348h = f16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void r(float f16) {
        this.f105350j = f16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void s(float f16) {
        this.f105349i = f16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void t(float f16) {
        this.f105354n = f16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void u(float f16) {
        this.f105355o = f16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void v(float f16) {
        this.f105352l = f16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void w(float f16) {
        this.f105353m = f16;
    }
}
