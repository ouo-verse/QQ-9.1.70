package com.tencent.mobileqq.ocr.view.gesture.state;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.mobileqq.ocr.view.gesture.Settings;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static final c f255078f;

    /* renamed from: g, reason: collision with root package name */
    private static final Rect f255079g;

    /* renamed from: h, reason: collision with root package name */
    private static final RectF f255080h;

    /* renamed from: i, reason: collision with root package name */
    private static final Point f255081i;

    /* renamed from: j, reason: collision with root package name */
    private static final PointF f255082j;

    /* renamed from: a, reason: collision with root package name */
    private final Settings f255083a;

    /* renamed from: b, reason: collision with root package name */
    private final b f255084b;

    /* renamed from: c, reason: collision with root package name */
    private final a f255085c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f255086d;

    /* renamed from: e, reason: collision with root package name */
    private float f255087e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21091);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
            return;
        }
        f255078f = new c();
        f255079g = new Rect();
        f255080h = new RectF();
        f255081i = new Point();
        f255082j = new PointF();
    }

    public d(Settings settings) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) settings);
            return;
        }
        this.f255086d = true;
        this.f255083a = settings;
        this.f255084b = new b(settings);
        this.f255085c = new a(settings);
    }

    private float a(float f16, float f17, float f18, float f19, float f26) {
        float f27;
        if (f26 == 0.0f) {
            return f16;
        }
        float f28 = (f16 + f17) * 0.5f;
        if (f28 < f18 && f16 < f17) {
            f27 = (f18 - f28) / f26;
        } else if (f28 > f19 && f16 > f17) {
            f27 = (f28 - f19) / f26;
        } else {
            f27 = 0.0f;
        }
        if (f27 == 0.0f) {
            return f16;
        }
        if (f27 > 1.0f) {
            f27 = 1.0f;
        }
        return f16 - (((float) Math.sqrt(f27)) * (f16 - f17));
    }

    private float c(float f16, float f17, float f18, float f19, float f26) {
        float f27;
        if (f26 == 1.0f) {
            return f16;
        }
        float f28 = f18 / f26;
        float f29 = f26 * f19;
        if (f16 < f18 && f16 < f17) {
            f27 = (f18 - f16) / (f18 - f28);
        } else if (f16 > f19 && f16 > f17) {
            f27 = (f16 - f19) / (f29 - f19);
        } else {
            f27 = 0.0f;
        }
        if (f27 == 0.0f) {
            return f16;
        }
        return f16 + (((float) Math.sqrt(f27)) * (f17 - f16));
    }

    public void b(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
        } else if (this.f255087e > 0.0f) {
            cVar.l(cVar.g(), cVar.h(), cVar.i() * this.f255087e, cVar.f());
        }
    }

    public void d(c cVar, RectF rectF) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) cVar, (Object) rectF);
        } else {
            this.f255085c.i(cVar).f(rectF);
        }
    }

    public boolean e(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar)).booleanValue();
        }
        this.f255086d = true;
        return i(cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(c cVar, c cVar2, float f16, float f17, boolean z16, boolean z17, boolean z18) {
        float f18;
        float f19;
        boolean z19;
        float c16;
        float f26;
        float d16;
        float f27;
        float f28;
        float f29;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, cVar, cVar2, Float.valueOf(f16), Float.valueOf(f17), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18))).booleanValue();
        }
        if (!this.f255083a.B()) {
            return false;
        }
        if (!Float.isNaN(f16) && !Float.isNaN(f17)) {
            f18 = f16;
            f19 = f17;
        } else {
            Settings settings = this.f255083a;
            Point point = f255081i;
            com.tencent.mobileqq.ocr.view.gesture.utils.a.a(settings, point);
            f18 = point.x;
            f19 = point.y;
        }
        if (z18 && this.f255083a.C()) {
            float round = Math.round(cVar.f() / 90.0f) * 90.0f;
            if (!c.c(round, cVar.f())) {
                cVar.k(round, f18, f19);
                z19 = true;
                this.f255084b.e(cVar);
                c16 = this.f255084b.c();
                float b16 = this.f255084b.b();
                if (!z17) {
                    f26 = this.f255083a.p();
                } else {
                    f26 = 1.0f;
                }
                d16 = this.f255084b.d(cVar.i(), f26);
                if (cVar2 != null) {
                    d16 = c(d16, cVar2.i(), c16, b16, f26);
                }
                if (!c.c(d16, cVar.i())) {
                    cVar.r(d16, f18, f19);
                    z19 = true;
                }
                float f36 = 0.0f;
                if (!z16) {
                    f27 = this.f255083a.n();
                } else {
                    f27 = 0.0f;
                }
                if (z16) {
                    f36 = this.f255083a.o();
                }
                float f37 = f36;
                this.f255085c.i(cVar);
                a aVar = this.f255085c;
                float g16 = cVar.g();
                float h16 = cVar.h();
                PointF pointF = f255082j;
                aVar.g(g16, h16, f27, f37, pointF);
                float f38 = pointF.x;
                float f39 = pointF.y;
                if (d16 >= c16) {
                    float sqrt = (float) Math.sqrt((((d16 * f26) / c16) - 1.0f) / (f26 - 1.0f));
                    this.f255085c.h(f38, f39, pointF);
                    float f46 = pointF.x;
                    float f47 = pointF.y;
                    f29 = f47 + (sqrt * (f39 - f47));
                    f28 = f46 + ((f38 - f46) * sqrt);
                } else {
                    f28 = f38;
                    f29 = f39;
                }
                if (cVar2 != null) {
                    a aVar2 = this.f255085c;
                    RectF rectF = f255080h;
                    aVar2.f(rectF);
                    f28 = a(f28, cVar2.g(), rectF.left, rectF.right, f27);
                    f29 = a(f29, cVar2.h(), rectF.top, rectF.bottom, f37);
                }
                if (!c.c(f28, cVar.g()) && c.c(f29, cVar.h())) {
                    return z19;
                }
                cVar.o(f28, f29);
                return true;
            }
        }
        z19 = false;
        this.f255084b.e(cVar);
        c16 = this.f255084b.c();
        float b162 = this.f255084b.b();
        if (!z17) {
        }
        d16 = this.f255084b.d(cVar.i(), f26);
        if (cVar2 != null) {
        }
        if (!c.c(d16, cVar.i())) {
        }
        float f362 = 0.0f;
        if (!z16) {
        }
        if (z16) {
        }
        float f372 = f362;
        this.f255085c.i(cVar);
        a aVar3 = this.f255085c;
        float g162 = cVar.g();
        float h162 = cVar.h();
        PointF pointF2 = f255082j;
        aVar3.g(g162, h162, f27, f372, pointF2);
        float f382 = pointF2.x;
        float f392 = pointF2.y;
        if (d16 >= c16) {
        }
        if (cVar2 != null) {
        }
        if (!c.c(f28, cVar.g())) {
        }
        cVar.o(f28, f29);
        return true;
    }

    public c g(c cVar, c cVar2, float f16, float f17, boolean z16, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (c) iPatchRedirector.redirect((short) 7, this, cVar, cVar2, Float.valueOf(f16), Float.valueOf(f17), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
        }
        c cVar3 = f255078f;
        cVar3.m(cVar);
        if (f(cVar3, cVar2, f16, f17, z16, z17, z18)) {
            return cVar3.b();
        }
        return null;
    }

    public c h(c cVar, float f16, float f17) {
        float b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (c) iPatchRedirector.redirect((short) 6, this, cVar, Float.valueOf(f16), Float.valueOf(f17));
        }
        this.f255084b.e(cVar);
        float a16 = this.f255084b.a();
        if (this.f255083a.e() > 0.0f) {
            b16 = this.f255083a.e();
        } else {
            b16 = this.f255084b.b();
        }
        if (cVar.i() < (a16 + b16) * 0.5f) {
            a16 = b16;
        }
        c b17 = cVar.b();
        b17.r(a16, f16, f17);
        return b17;
    }

    public boolean i(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar)).booleanValue();
        }
        boolean z16 = false;
        if (this.f255086d) {
            cVar.l(0.0f, 0.0f, this.f255084b.e(cVar).a(), 0.0f);
            com.tencent.mobileqq.ocr.view.gesture.utils.a.c(cVar, this.f255083a, f255079g);
            cVar.o(r2.left, r2.top);
            if (!this.f255083a.s() || !this.f255083a.t()) {
                z16 = true;
            }
            this.f255086d = z16;
            return !z16;
        }
        f(cVar, cVar, Float.NaN, Float.NaN, false, false, true);
        return false;
    }
}
