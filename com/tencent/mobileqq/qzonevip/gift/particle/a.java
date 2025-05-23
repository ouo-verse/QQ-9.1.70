package com.tencent.mobileqq.qzonevip.gift.particle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public float f280181a;

    /* renamed from: b, reason: collision with root package name */
    public float f280182b;

    /* renamed from: c, reason: collision with root package name */
    public float f280183c;

    /* renamed from: d, reason: collision with root package name */
    public float f280184d;

    /* renamed from: e, reason: collision with root package name */
    public int f280185e;

    /* renamed from: f, reason: collision with root package name */
    public Bitmap f280186f;

    /* renamed from: g, reason: collision with root package name */
    public long f280187g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f280188h;

    /* renamed from: i, reason: collision with root package name */
    public int f280189i;

    /* renamed from: j, reason: collision with root package name */
    public long f280190j;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f280184d = 1.0f;
        this.f280185e = 255;
        this.f280188h = false;
        this.f280189i = 0;
        this.f280187g = System.currentTimeMillis();
    }

    public void a(Canvas canvas, Paint paint, Matrix matrix) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, canvas, paint, matrix);
            return;
        }
        if (this.f280186f == null) {
            return;
        }
        int width = (int) (r0.getWidth() * this.f280184d);
        int height = (int) (this.f280186f.getHeight() * this.f280184d);
        if (matrix == null) {
            matrix = new Matrix();
        }
        paint.setAlpha(this.f280185e);
        matrix.reset();
        float f16 = this.f280184d;
        matrix.setScale(f16, f16);
        matrix.postRotate(this.f280183c, width / 2, height / 2);
        matrix.postTranslate(this.f280181a, this.f280182b);
        canvas.drawBitmap(this.f280186f, matrix, paint);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return " mDx = " + this.f280181a + " mDy = " + this.f280182b + " mScale = " + this.f280184d + " mRotation = " + this.f280183c + " mDuration = " + this.f280190j + " mAlpha = " + this.f280185e;
    }
}
