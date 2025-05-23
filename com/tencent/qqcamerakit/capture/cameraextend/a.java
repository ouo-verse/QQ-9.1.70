package com.tencent.qqcamerakit.capture.cameraextend;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqcamerakit.capture.c;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static int f344866d;

    /* renamed from: a, reason: collision with root package name */
    private int f344867a;

    /* renamed from: b, reason: collision with root package name */
    private Matrix f344868b;

    /* renamed from: c, reason: collision with root package name */
    private Matrix f344869c;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f344867a = 90;
        this.f344868b = new Matrix();
        this.f344869c = new Matrix();
    }

    public static Rect a(Matrix matrix, float f16, float f17, int i3, int i16, float f18) {
        int intValue = Float.valueOf(c() * f18).intValue();
        int i17 = intValue / 2;
        RectF rectF = new RectF(b(((int) f16) - i17, 0, i3 - intValue), b(((int) f17) - i17, 0, i16 - intValue), r3 + intValue, r4 + intValue);
        matrix.mapRect(rectF);
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    private static int b(int i3, int i16, int i17) {
        if (i3 > i17) {
            return i17;
        }
        if (i3 < i16) {
            return i16;
        }
        return i3;
    }

    private static int c() {
        int i3 = f344866d;
        if (i3 == 0) {
            int dimension = (int) com.tencent.qqcamerakit.capture.c.d().getResources().getDimension(R.dimen.c5y);
            f344866d = dimension;
            return dimension;
        }
        return i3;
    }

    public static void e(Matrix matrix, boolean z16, int i3, int i16, int i17, int i18, int i19) {
        boolean z17;
        float f16;
        matrix.reset();
        if (i16 < i17) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && i18 != 0) {
            i16 = (i19 * i17) / i18;
        }
        if (z16) {
            f16 = -1.0f;
        } else {
            f16 = 1.0f;
        }
        matrix.setScale(f16, 1.0f);
        matrix.postRotate(i3);
        float f17 = i16;
        float f18 = i17;
        matrix.postScale(f17 / 2000.0f, f18 / 2000.0f);
        matrix.postTranslate(f17 / 2.0f, f18 / 2.0f);
    }

    public Matrix d(int i3, int i16, int i17, int i18, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Matrix) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19));
        }
        Matrix matrix = new Matrix();
        this.f344869c = matrix;
        if (i19 == 1) {
            z16 = true;
        }
        e(matrix, z16, this.f344867a, i17, i18, i3, i16);
        this.f344869c.invert(this.f344868b);
        return this.f344868b;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.qqcamerakit.capture.cameraextend.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static class C9360a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public float f344870a;

        /* renamed from: b, reason: collision with root package name */
        public float f344871b;

        /* renamed from: c, reason: collision with root package name */
        public int f344872c;

        /* renamed from: d, reason: collision with root package name */
        public int f344873d;

        /* renamed from: e, reason: collision with root package name */
        public int f344874e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f344875f;

        /* renamed from: g, reason: collision with root package name */
        public c.a f344876g;

        /* renamed from: h, reason: collision with root package name */
        public Rect f344877h;

        /* renamed from: i, reason: collision with root package name */
        public Rect f344878i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f344879j;

        public C9360a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.f344875f = z16;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, z16);
            }
        }

        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (this.f344873d > 0 && this.f344872c > 0 && this.f344870a > 0.01f && this.f344871b > 0.01f) {
                return true;
            }
            return false;
        }

        public C9360a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.f344875f = false;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }
}
