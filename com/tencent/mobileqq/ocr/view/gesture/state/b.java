package com.tencent.mobileqq.ocr.view.gesture.state;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.mobileqq.ocr.view.gesture.Settings;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static final Matrix f255066e;

    /* renamed from: f, reason: collision with root package name */
    private static final RectF f255067f;

    /* renamed from: a, reason: collision with root package name */
    private final Settings f255068a;

    /* renamed from: b, reason: collision with root package name */
    private float f255069b;

    /* renamed from: c, reason: collision with root package name */
    private float f255070c;

    /* renamed from: d, reason: collision with root package name */
    private float f255071d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21074);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f255066e = new Matrix();
            f255067f = new RectF();
        }
    }

    public b(Settings settings) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) settings);
        } else {
            this.f255068a = settings;
        }
    }

    public float a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, (Object) this)).floatValue();
        }
        return this.f255071d;
    }

    public float b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
        }
        return this.f255070c;
    }

    public float c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Float) iPatchRedirector.redirect((short) 3, (Object) this)).floatValue();
        }
        return this.f255069b;
    }

    public float d(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16), Float.valueOf(f17))).floatValue();
        }
        return com.tencent.mobileqq.ocr.view.gesture.utils.b.e(f16, this.f255069b / f17, this.f255070c * f17);
    }

    public b e(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
        }
        float i3 = this.f255068a.i();
        float h16 = this.f255068a.h();
        float m3 = this.f255068a.m();
        float l3 = this.f255068a.l();
        float f16 = 1.0f;
        if (i3 != 0.0f && h16 != 0.0f && m3 != 0.0f && l3 != 0.0f) {
            this.f255069b = this.f255068a.k();
            this.f255070c = this.f255068a.j();
            float f17 = cVar.f();
            if (!c.c(f17, 0.0f)) {
                if (this.f255068a.f() == 3) {
                    Matrix matrix = f255066e;
                    matrix.setRotate(-f17);
                    RectF rectF = f255067f;
                    rectF.set(0.0f, 0.0f, m3, l3);
                    matrix.mapRect(rectF);
                    m3 = rectF.width();
                    l3 = rectF.height();
                } else {
                    Matrix matrix2 = f255066e;
                    matrix2.setRotate(f17);
                    RectF rectF2 = f255067f;
                    rectF2.set(0.0f, 0.0f, i3, h16);
                    matrix2.mapRect(rectF2);
                    i3 = rectF2.width();
                    h16 = rectF2.height();
                }
            }
            int f18 = this.f255068a.f();
            if (f18 != 0) {
                if (f18 != 1) {
                    if (f18 != 2) {
                        if (f18 != 3) {
                            float f19 = this.f255069b;
                            if (f19 > 0.0f) {
                                f16 = f19;
                            }
                            this.f255071d = f16;
                        } else {
                            this.f255071d = Math.max(m3 / i3, l3 / h16);
                        }
                    } else {
                        this.f255071d = Math.min(m3 / i3, l3 / h16);
                    }
                } else {
                    this.f255071d = l3 / h16;
                }
            } else {
                this.f255071d = m3 / i3;
            }
            if (this.f255069b <= 0.0f) {
                this.f255069b = this.f255071d;
            }
            if (this.f255070c <= 0.0f) {
                this.f255070c = this.f255071d;
            }
            if (this.f255071d > this.f255070c) {
                if (this.f255068a.x()) {
                    this.f255070c = this.f255071d;
                } else {
                    this.f255071d = this.f255070c;
                }
            }
            float f26 = this.f255069b;
            float f27 = this.f255070c;
            if (f26 > f27) {
                this.f255069b = f27;
            }
            if (this.f255071d < this.f255069b) {
                if (this.f255068a.x()) {
                    this.f255069b = this.f255071d;
                } else {
                    this.f255071d = this.f255069b;
                }
            }
            return this;
        }
        this.f255071d = 1.0f;
        this.f255070c = 1.0f;
        this.f255069b = 1.0f;
        return this;
    }
}
