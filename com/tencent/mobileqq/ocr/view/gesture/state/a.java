package com.tencent.mobileqq.ocr.view.gesture.state;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.mobileqq.ocr.view.gesture.Settings;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static final Matrix f255056f;

    /* renamed from: g, reason: collision with root package name */
    private static final float[] f255057g;

    /* renamed from: h, reason: collision with root package name */
    private static final Point f255058h;

    /* renamed from: i, reason: collision with root package name */
    private static final Rect f255059i;

    /* renamed from: j, reason: collision with root package name */
    private static final RectF f255060j;

    /* renamed from: a, reason: collision with root package name */
    private final Settings f255061a;

    /* renamed from: b, reason: collision with root package name */
    private final RectF f255062b;

    /* renamed from: c, reason: collision with root package name */
    private float f255063c;

    /* renamed from: d, reason: collision with root package name */
    private float f255064d;

    /* renamed from: e, reason: collision with root package name */
    private float f255065e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21066);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f255056f = new Matrix();
        f255057g = new float[2];
        f255058h = new Point();
        f255059i = new Rect();
        f255060j = new RectF();
    }

    public a(Settings settings) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) settings);
        } else {
            this.f255062b = new RectF();
            this.f255061a = settings;
        }
    }

    private void a(RectF rectF, Rect rect) {
        if (rectF.width() < rect.width()) {
            this.f255062b.left = rectF.left - (rect.width() - rectF.width());
            this.f255062b.right = rectF.left;
        } else {
            RectF rectF2 = this.f255062b;
            rectF2.left = rectF.left;
            rectF2.right = rectF.right - rect.width();
        }
        if (rectF.height() < rect.height()) {
            this.f255062b.top = rectF.top - (rect.height() - rectF.height());
            this.f255062b.bottom = rectF.top;
            return;
        }
        RectF rectF3 = this.f255062b;
        rectF3.top = rectF.top;
        rectF3.bottom = rectF.bottom - rect.height();
    }

    private void b(RectF rectF, Rect rect) {
        if (rectF.width() < rect.width()) {
            this.f255062b.left = rectF.left - (rect.width() - rectF.width());
            this.f255062b.right = rectF.left;
        } else {
            RectF rectF2 = this.f255062b;
            float f16 = rect.left;
            rectF2.right = f16;
            rectF2.left = f16;
        }
        if (rectF.height() < rect.height()) {
            this.f255062b.top = rectF.top - (rect.height() - rectF.height());
            this.f255062b.bottom = rectF.top;
            return;
        }
        RectF rectF3 = this.f255062b;
        float f17 = rect.top;
        rectF3.bottom = f17;
        rectF3.top = f17;
    }

    private void c(RectF rectF, Rect rect) {
        this.f255062b.left = rectF.left - rect.width();
        RectF rectF2 = this.f255062b;
        rectF2.right = rectF.right;
        rectF2.top = rectF.top - rect.height();
        this.f255062b.bottom = rectF.bottom;
    }

    private void d(Rect rect) {
        com.tencent.mobileqq.ocr.view.gesture.utils.a.a(this.f255061a, f255058h);
        float[] fArr = f255057g;
        fArr[0] = r1.x;
        fArr[1] = r1.y;
        if (!c.c(this.f255063c, 0.0f)) {
            Matrix matrix = f255056f;
            matrix.setRotate(-this.f255063c, this.f255064d, this.f255065e);
            matrix.mapPoints(fArr);
        }
        this.f255062b.left = fArr[0] - rect.width();
        RectF rectF = this.f255062b;
        rectF.right = fArr[0];
        rectF.top = fArr[1] - rect.height();
        this.f255062b.bottom = fArr[1];
    }

    public void e(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        float[] fArr = f255057g;
        fArr[0] = f16;
        fArr[1] = f17;
        float f18 = this.f255063c;
        if (f18 != 0.0f) {
            Matrix matrix = f255056f;
            matrix.setRotate(-f18, this.f255064d, this.f255065e);
            matrix.mapPoints(fArr);
        }
        this.f255062b.union(fArr[0], fArr[1]);
    }

    public void f(RectF rectF) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rectF);
            return;
        }
        float f16 = this.f255063c;
        if (f16 == 0.0f) {
            rectF.set(this.f255062b);
            return;
        }
        Matrix matrix = f255056f;
        matrix.setRotate(f16, this.f255064d, this.f255065e);
        matrix.mapRect(rectF, this.f255062b);
    }

    public void g(float f16, float f17, float f18, float f19, PointF pointF) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), pointF);
            return;
        }
        float[] fArr = f255057g;
        fArr[0] = f16;
        fArr[1] = f17;
        float f26 = this.f255063c;
        if (f26 != 0.0f) {
            Matrix matrix = f255056f;
            matrix.setRotate(-f26, this.f255064d, this.f255065e);
            matrix.mapPoints(fArr);
        }
        float f27 = fArr[0];
        RectF rectF = this.f255062b;
        fArr[0] = com.tencent.mobileqq.ocr.view.gesture.utils.b.e(f27, rectF.left - f18, rectF.right + f18);
        float f28 = fArr[1];
        RectF rectF2 = this.f255062b;
        fArr[1] = com.tencent.mobileqq.ocr.view.gesture.utils.b.e(f28, rectF2.top - f19, rectF2.bottom + f19);
        float f29 = this.f255063c;
        if (f29 != 0.0f) {
            Matrix matrix2 = f255056f;
            matrix2.setRotate(f29, this.f255064d, this.f255065e);
            matrix2.mapPoints(fArr);
        }
        pointF.set(fArr[0], fArr[1]);
    }

    public void h(float f16, float f17, PointF pointF) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16), Float.valueOf(f17), pointF);
        } else {
            g(f16, f17, 0.0f, 0.0f, pointF);
        }
    }

    public a i(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
        }
        RectF rectF = f255060j;
        Settings settings = this.f255061a;
        Rect rect = f255059i;
        com.tencent.mobileqq.ocr.view.gesture.utils.a.d(settings, rect);
        rectF.set(rect);
        if (this.f255061a.f() == 3) {
            this.f255063c = cVar.f();
            this.f255064d = rectF.centerX();
            this.f255065e = rectF.centerY();
            if (!c.c(this.f255063c, 0.0f)) {
                Matrix matrix = f255056f;
                matrix.setRotate(-this.f255063c, this.f255064d, this.f255065e);
                matrix.mapRect(rectF);
            }
        } else {
            this.f255063c = 0.0f;
            this.f255065e = 0.0f;
            this.f255064d = 0.0f;
        }
        Matrix matrix2 = f255056f;
        cVar.d(matrix2);
        if (!c.c(this.f255063c, 0.0f)) {
            matrix2.postRotate(-this.f255063c, this.f255064d, this.f255065e);
        }
        com.tencent.mobileqq.ocr.view.gesture.utils.a.b(matrix2, this.f255061a, rect);
        int d16 = this.f255061a.d();
        if (d16 != 0) {
            if (d16 != 1) {
                if (d16 != 2) {
                    if (d16 != 3) {
                        this.f255062b.set(-5.3687091E8f, -5.3687091E8f, 5.3687091E8f, 5.3687091E8f);
                    } else {
                        d(rect);
                    }
                } else {
                    c(rectF, rect);
                }
            } else {
                a(rectF, rect);
            }
        } else {
            b(rectF, rect);
        }
        if (this.f255061a.f() != 3) {
            cVar.d(matrix2);
            rectF.set(0.0f, 0.0f, this.f255061a.i(), this.f255061a.h());
            matrix2.mapRect(rectF);
            float[] fArr = f255057g;
            fArr[1] = 0.0f;
            fArr[0] = 0.0f;
            matrix2.mapPoints(fArr);
            this.f255062b.offset(fArr[0] - rectF.left, fArr[1] - rectF.top);
        }
        return this;
    }
}
