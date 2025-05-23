package com.tencent.mobileqq.armap.sensor.rotation;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static e f199809e;

    /* renamed from: f, reason: collision with root package name */
    private static e f199810f;

    /* renamed from: g, reason: collision with root package name */
    private static e f199811g;

    /* renamed from: a, reason: collision with root package name */
    public float f199812a;

    /* renamed from: b, reason: collision with root package name */
    public float f199813b;

    /* renamed from: c, reason: collision with root package name */
    public float f199814c;

    /* renamed from: d, reason: collision with root package name */
    public float f199815d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70898);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
            return;
        }
        f199809e = new e();
        f199810f = new e();
        f199811g = new e();
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public e a(Matrix4 matrix4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (e) iPatchRedirector.redirect((short) 1, (Object) this, (Object) matrix4);
        }
        float[] fArr = matrix4.val;
        float f16 = this.f199812a;
        float f17 = fArr[0] * f16;
        float f18 = this.f199813b;
        float f19 = f17 + (fArr[4] * f18);
        float f26 = this.f199814c;
        float f27 = f19 + (fArr[8] * f26);
        float f28 = this.f199815d;
        return b(f27 + (fArr[12] * f28), (fArr[1] * f16) + (fArr[5] * f18) + (fArr[9] * f26) + (fArr[13] * f28), (fArr[2] * f16) + (fArr[6] * f18) + (fArr[10] * f26) + (fArr[14] * f28), (f16 * fArr[3]) + (f18 * fArr[7]) + (f26 * fArr[11]) + (f28 * fArr[15]));
    }

    public e b(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (e) iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
        }
        this.f199812a = f16;
        this.f199813b = f17;
        this.f199814c = f18;
        this.f199815d = f19;
        return this;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (Float.floatToIntBits(this.f199812a) == Float.floatToIntBits(eVar.f199812a) && Float.floatToIntBits(this.f199813b) == Float.floatToIntBits(eVar.f199813b) && Float.floatToIntBits(this.f199814c) == Float.floatToIntBits(eVar.f199814c) && Float.floatToIntBits(this.f199815d) == Float.floatToIntBits(eVar.f199815d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return ((((((Float.floatToIntBits(this.f199812a) + 31) * 31) + Float.floatToIntBits(this.f199813b)) * 31) + Float.floatToIntBits(this.f199814c)) * 31) + Float.floatToIntBits(this.f199815d);
    }
}
