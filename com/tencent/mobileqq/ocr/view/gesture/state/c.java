package com.tencent.mobileqq.ocr.view.gesture.state;

import android.graphics.Matrix;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Matrix f255072a;

    /* renamed from: b, reason: collision with root package name */
    private final float[] f255073b;

    /* renamed from: c, reason: collision with root package name */
    protected float f255074c;

    /* renamed from: d, reason: collision with root package name */
    protected float f255075d;

    /* renamed from: e, reason: collision with root package name */
    private float f255076e;

    /* renamed from: f, reason: collision with root package name */
    private float f255077f;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f255072a = new Matrix();
        this.f255073b = new float[9];
        this.f255076e = 1.0f;
    }

    public static int a(float f16, float f17) {
        if (f16 > f17 + 0.001f) {
            return 1;
        }
        if (f16 < f17 - 0.001f) {
            return -1;
        }
        return 0;
    }

    public static boolean c(float f16, float f17) {
        if (f16 >= f17 - 0.001f && f16 <= f17 + 0.001f) {
            return true;
        }
        return false;
    }

    private void p(boolean z16, boolean z17) {
        this.f255072a.getValues(this.f255073b);
        float[] fArr = this.f255073b;
        this.f255074c = fArr[2];
        this.f255075d = fArr[5];
        if (z16) {
            this.f255076e = (float) Math.hypot(fArr[1], fArr[4]);
        }
        if (z17) {
            float[] fArr2 = this.f255073b;
            this.f255077f = (float) Math.toDegrees(Math.atan2(fArr2[3], fArr2[4]));
        }
    }

    public c b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (c) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        c cVar = new c();
        cVar.m(this);
        return cVar;
    }

    public void d(Matrix matrix) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) matrix);
        } else {
            matrix.set(this.f255072a);
        }
    }

    public Matrix e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Matrix) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f255072a;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (c(cVar.f255074c, this.f255074c) && c(cVar.f255075d, this.f255075d) && c(cVar.f255076e, this.f255076e) && c(cVar.f255077f, this.f255077f)) {
            return true;
        }
        return false;
    }

    public float f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
        }
        return this.f255077f;
    }

    public float g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Float) iPatchRedirector.redirect((short) 3, (Object) this)).floatValue();
        }
        return this.f255074c;
    }

    public float h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
        }
        return this.f255075d;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        float f16 = this.f255074c;
        int i18 = 0;
        if (f16 != 0.0f) {
            i3 = Float.floatToIntBits(f16);
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        float f17 = this.f255075d;
        if (f17 != 0.0f) {
            i16 = Float.floatToIntBits(f17);
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        float f18 = this.f255076e;
        if (f18 != 0.0f) {
            i17 = Float.floatToIntBits(f18);
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        float f19 = this.f255077f;
        if (f19 != 0.0f) {
            i18 = Float.floatToIntBits(f19);
        }
        return i27 + i18;
    }

    public float i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, (Object) this)).floatValue();
        }
        return this.f255076e;
    }

    public void j(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
        } else {
            this.f255072a.postRotate(f16, f17, f18);
            p(false, true);
        }
    }

    public void k(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
        } else {
            this.f255072a.postRotate((-this.f255077f) + f16, f17, f18);
            p(false, true);
        }
    }

    public void l(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        while (f19 < -180.0f) {
            f19 += 360.0f;
        }
        while (f19 > 180.0f) {
            f19 -= 360.0f;
        }
        this.f255074c = f16;
        this.f255075d = f17;
        this.f255076e = f18;
        this.f255077f = f19;
        this.f255072a.reset();
        if (f18 != 1.0f) {
            this.f255072a.postScale(f18, f18);
        }
        if (f19 != 0.0f) {
            this.f255072a.postRotate(f19);
        }
        this.f255072a.postTranslate(f16, f17);
    }

    public void m(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) cVar);
            return;
        }
        this.f255074c = cVar.f255074c;
        this.f255075d = cVar.f255075d;
        this.f255076e = cVar.f255076e;
        this.f255077f = cVar.f255077f;
        this.f255072a.set(cVar.f255072a);
    }

    public void n(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.f255072a.postTranslate(f16, f17);
            p(false, false);
        }
    }

    public void o(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.f255072a.postTranslate((-this.f255074c) + f16, (-this.f255075d) + f17);
            p(false, false);
        }
    }

    public void q(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
        } else {
            this.f255072a.postScale(f16, f16, f17, f18);
            p(true, false);
        }
    }

    public void r(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            return;
        }
        Matrix matrix = this.f255072a;
        float f19 = this.f255076e;
        matrix.postScale(f16 / f19, f16 / f19, f17, f18);
        p(true, false);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return "{x=" + this.f255074c + ",y=" + this.f255075d + ",zoom=" + this.f255076e + ",rotation=" + this.f255077f + "}";
    }
}
