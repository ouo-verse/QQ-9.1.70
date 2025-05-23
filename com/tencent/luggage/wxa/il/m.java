package com.tencent.luggage.wxa.il;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.h0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;

/* compiled from: P */
/* loaded from: classes8.dex */
public class m extends ProgressBar {

    /* renamed from: a, reason: collision with root package name */
    public boolean f130717a;

    /* renamed from: b, reason: collision with root package name */
    public float f130718b;

    /* renamed from: c, reason: collision with root package name */
    public float f130719c;

    /* renamed from: d, reason: collision with root package name */
    public float f130720d;

    /* renamed from: e, reason: collision with root package name */
    public float f130721e;

    /* renamed from: f, reason: collision with root package name */
    public float f130722f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f130723g;

    /* renamed from: h, reason: collision with root package name */
    public b0 f130724h;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends b0 {
        public a(Looper looper) {
            super(looper);
        }

        @Override // com.tencent.luggage.wxa.tn.b0
        public void d(Message message) {
            switch (message.what) {
                case 1000:
                    m.this.c();
                    return;
                case 1001:
                    m.this.d();
                    return;
                case 1002:
                    m.this.a();
                    return;
                case 1003:
                    m.this.b();
                    return;
                default:
                    return;
            }
        }
    }

    public m(Context context) {
        this(context, null);
        f();
    }

    public void e() {
        w.a("MicroMsg.MMFalseProgressBar", "[cpan] finish");
        b0 b0Var = this.f130724h;
        if (b0Var != null) {
            b0Var.b(1002);
        }
    }

    public final void f() {
        if (h0.m(z.c())) {
            this.f130719c = 4.0f;
            this.f130720d = 1.0f;
            this.f130721e = 0.3f;
            this.f130722f = 50.0f;
            return;
        }
        this.f130719c = 2.0f;
        this.f130720d = 0.5f;
        this.f130721e = 0.15f;
        this.f130722f = 50.0f;
    }

    public void g() {
        w.a("MicroMsg.MMFalseProgressBar", "[cpan] start");
        if (!this.f130723g || this.f130717a) {
            return;
        }
        this.f130717a = true;
        f();
        b0 b0Var = this.f130724h;
        if (b0Var != null) {
            b0Var.b(1000);
            this.f130724h.b(1001);
        }
    }

    public final void a() {
        Float valueOf;
        if (this.f130717a) {
            float f16 = this.f130718b;
            if (f16 < 950.0f) {
                float f17 = f16 + this.f130722f;
                this.f130718b = f17;
                this.f130718b = f17 <= 950.0f ? f17 : 950.0f;
                valueOf = Float.valueOf(1.0f);
            } else {
                float f18 = f16 + 1.0f;
                this.f130718b = f18;
                valueOf = Float.valueOf(((1000.0f - f18) * 0.01f) + 0.3f);
            }
            b0 b0Var = this.f130724h;
            if (b0Var != null) {
                if (this.f130718b < 1000.0f) {
                    b0Var.a(1002, 10L);
                } else {
                    this.f130718b = 1000.0f;
                    b0Var.c(1002);
                    this.f130724h.a(1003, 10L);
                }
            }
            setAlpha(valueOf.floatValue());
            setProgress((int) this.f130718b);
        }
    }

    public final void b() {
        this.f130718b = 0.0f;
        this.f130717a = false;
        postInvalidateDelayed(200L);
        setVisibility(8);
    }

    public final void c() {
        setVisibility(0);
        setAlpha(1.0f);
    }

    public final void d() {
        float f16 = this.f130718b;
        if (f16 < 600.0f) {
            this.f130718b = f16 + this.f130719c;
        } else if (f16 >= 600.0f && f16 < 800.0f) {
            this.f130718b = f16 + this.f130720d;
        } else if (f16 >= 800.0f && f16 < 920.0f) {
            this.f130718b = f16 + this.f130721e;
        }
        b0 b0Var = this.f130724h;
        if (b0Var != null) {
            if (this.f130718b < 920.0f) {
                b0Var.a(1001, 10L);
            } else {
                b0Var.c(1001);
            }
        }
        setProgress((int) this.f130718b);
    }

    public m(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public m(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f130717a = false;
        this.f130718b = 0.0f;
        this.f130723g = true;
        this.f130724h = new a(Looper.getMainLooper());
        setMax(1000);
        f();
    }
}
