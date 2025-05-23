package com.tencent.mobileqq.activity.about.modelviewer;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a implements Interpolator {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static final a f177710f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f177711g;

    /* renamed from: h, reason: collision with root package name */
    public static final a f177712h;

    /* renamed from: i, reason: collision with root package name */
    public static final a f177713i;

    /* renamed from: j, reason: collision with root package name */
    public static final a f177714j;

    /* renamed from: k, reason: collision with root package name */
    public static final a f177715k;

    /* renamed from: a, reason: collision with root package name */
    protected PointF f177716a;

    /* renamed from: b, reason: collision with root package name */
    protected PointF f177717b;

    /* renamed from: c, reason: collision with root package name */
    protected PointF f177718c;

    /* renamed from: d, reason: collision with root package name */
    protected PointF f177719d;

    /* renamed from: e, reason: collision with root package name */
    protected PointF f177720e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67626);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f177710f = new a(0.25d, 0.1d, 0.25d, 1.0d);
        f177711g = new a(0.0d, 0.0d, 0.58d, 1.0d);
        f177712h = new a(0.23d, 1.0d, 0.32d, 1.0d);
        f177713i = new a(0.42d, 0.0d, 1.0d, 1.0d);
        f177714j = new a(0.42d, 0.0d, 0.58d, 1.0d);
        f177715k = new a(0.34d, 1.56d, 0.64d, 1.0d);
    }

    public a(PointF pointF, PointF pointF2) throws IllegalArgumentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) pointF, (Object) pointF2);
            return;
        }
        this.f177718c = new PointF();
        this.f177719d = new PointF();
        this.f177720e = new PointF();
        float f16 = pointF.x;
        if (f16 >= 0.0f && f16 <= 1.0f) {
            float f17 = pointF2.x;
            if (f17 >= 0.0f && f17 <= 1.0f) {
                this.f177716a = pointF;
                this.f177717b = pointF2;
                return;
            }
            throw new IllegalArgumentException("endX value must be in the range [0, 1]");
        }
        throw new IllegalArgumentException("startX value must be in the range [0, 1]");
    }

    private float a(float f16) {
        PointF pointF = this.f177720e;
        PointF pointF2 = this.f177716a;
        float f17 = pointF2.x * 3.0f;
        pointF.x = f17;
        PointF pointF3 = this.f177719d;
        float f18 = ((this.f177717b.x - pointF2.x) * 3.0f) - f17;
        pointF3.x = f18;
        PointF pointF4 = this.f177718c;
        float f19 = (1.0f - pointF.x) - f18;
        pointF4.x = f19;
        return f16 * (pointF.x + ((pointF3.x + (f19 * f16)) * f16));
    }

    private float c(float f16) {
        return this.f177720e.x + (f16 * ((this.f177719d.x * 2.0f) + (this.f177718c.x * 3.0f * f16)));
    }

    protected float b(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16))).floatValue();
        }
        PointF pointF = this.f177720e;
        PointF pointF2 = this.f177716a;
        float f17 = pointF2.y * 3.0f;
        pointF.y = f17;
        PointF pointF3 = this.f177719d;
        float f18 = ((this.f177717b.y - pointF2.y) * 3.0f) - f17;
        pointF3.y = f18;
        PointF pointF4 = this.f177718c;
        float f19 = (1.0f - pointF.y) - f18;
        pointF4.y = f19;
        return f16 * (pointF.y + ((pointF3.y + (f19 * f16)) * f16));
    }

    protected float d(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16))).floatValue();
        }
        float f17 = f16;
        for (int i3 = 1; i3 < 14; i3++) {
            float a16 = a(f17) - f16;
            if (Math.abs(a16) < 0.001d) {
                break;
            }
            f17 -= a16 / c(f17);
        }
        return f17;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16))).floatValue();
        }
        return b(d(f16));
    }

    public a(float f16, float f17, float f18, float f19) {
        this(new PointF(f16, f17), new PointF(f18, f19));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
    }

    public a(double d16, double d17, double d18, double d19) {
        this((float) d16, (float) d17, (float) d18, (float) d19);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, Double.valueOf(d16), Double.valueOf(d17), Double.valueOf(d18), Double.valueOf(d19));
    }
}
