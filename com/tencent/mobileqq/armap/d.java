package com.tencent.mobileqq.armap;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d extends com.tencent.mobileqq.portal.a {
    static IPatchRedirector $redirector_;
    protected RectF G;
    public int H;
    public Context I;
    public View J;
    public int K;
    public int L;
    public long M;
    public long N;
    public int P;
    public boolean Q;
    private Interpolator R;
    public int S;
    public int T;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements Interpolator {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Float) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16))).floatValue();
            }
            double d16 = f16;
            if (d16 < 0.2094d) {
                double d17 = d16 - 0.18d;
                return (float) (((-34.0d) * d17 * d17) + 1.08d);
            }
            if (d16 < 0.404d) {
                double d18 = d16 - 0.34d;
                return (float) ((5.9d * d18 * d18) + 0.95d);
            }
            if (d16 < 0.6045d) {
                double d19 = d16 - 0.53d;
                return (float) (((-3.0d) * d19 * d19) + 1.02d);
            }
            if (d16 < 0.8064d) {
                double d26 = d16 - 0.72d;
                return (float) ((d26 * d26) + 0.99d);
            }
            double d27 = d16 - 0.915d;
            return (float) (((-0.3d) * d27 * d27) + 1.001d);
        }
    }

    public d(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            return;
        }
        this.G = new RectF();
        this.H = 0;
        this.K = 2;
        this.L = 0;
        this.M = 0L;
        this.N = 1L;
        this.P = 0;
        this.Q = false;
        this.S = 0;
        this.T = 0;
        this.J = view;
        this.I = view.getContext();
    }

    private void g(long j3) {
        this.N = j3;
        this.M = AnimationUtils.currentAnimationTimeMillis();
        this.Q = true;
    }

    private void k() {
        m(this.H);
        this.Q = false;
        this.M = -1L;
        this.N = 1L;
        this.K = 2;
    }

    @Override // com.tencent.mobileqq.portal.a
    public boolean b(Canvas canvas) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) canvas)).booleanValue();
        }
        l();
        canvas.save();
        canvas.translate(0.0f, this.P);
        i(canvas);
        if (this.f259364m != null) {
            z16 = super.b(canvas);
        } else {
            z16 = false;
        }
        f(canvas);
        canvas.restore();
        if (!this.Q && !z16) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.portal.a
    public void c(int i3, int i16, int i17, int i18, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), view);
        } else {
            super.c(i3, i16, i17, i18, view);
            this.H = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) canvas);
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.T = this.f259361f;
        this.S = this.H;
        this.K = 3;
        this.R = new a();
        g(1500L);
    }

    protected void i(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) canvas);
        }
    }

    public RectF j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (RectF) iPatchRedirector.redirect((short) 1, (Object) this, i3);
        }
        float f16 = i3;
        this.G.set(this.f259360e - 0.0f, (this.f259361f - 0.0f) - f16, r1 + this.f259362h + 0.0f, ((r4 + this.f259363i) + 0.0f) - f16);
        return this.G;
    }

    public void l() {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (!this.Q) {
            return;
        }
        float currentAnimationTimeMillis = (((float) (AnimationUtils.currentAnimationTimeMillis() - this.M)) * 1.0f) / ((float) this.N);
        Interpolator interpolator = this.R;
        if (interpolator != null) {
            f16 = interpolator.getInterpolation(currentAnimationTimeMillis);
        } else {
            f16 = currentAnimationTimeMillis;
        }
        m((int) (this.T + ((this.S - r2) * f16)));
        if (currentAnimationTimeMillis > 0.99d) {
            int i3 = this.K;
            if (i3 != 1) {
                if (i3 != 3) {
                    k();
                    return;
                } else {
                    this.K = 2;
                    return;
                }
            }
            this.K = 3;
            h();
        }
    }

    public void m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        if (this.Q) {
            i3 = (int) (i3 + (this.H * (this.D - 1.0f)));
        }
        this.f259361f = i3;
    }
}
