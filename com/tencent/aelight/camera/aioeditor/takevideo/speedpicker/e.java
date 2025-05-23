package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private Paint f68918b;

    /* renamed from: a, reason: collision with root package name */
    private int f68917a = 0;

    /* renamed from: c, reason: collision with root package name */
    private RectF f68919c = new RectF();

    /* renamed from: d, reason: collision with root package name */
    private float f68920d = 0.0f;

    /* renamed from: e, reason: collision with root package name */
    private float f68921e = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    private float f68922f = 1.0f;

    public void b(int i3, float f16, float f17) {
        this.f68917a = i3;
        this.f68920d = f16;
        this.f68921e = f17;
        if (this.f68918b == null) {
            Paint paint = new Paint();
            this.f68918b = paint;
            paint.setAntiAlias(true);
        }
        this.f68918b.setColor(this.f68917a);
    }

    public void d(RectF rectF) {
        this.f68919c.set(rectF);
    }

    public void a(Canvas canvas, int i3) {
        if (canvas == null) {
            return;
        }
        this.f68918b.setAlpha(i3);
        float width = (this.f68919c.width() - this.f68920d) - this.f68921e;
        float f16 = this.f68922f * width;
        canvas.save();
        RectF rectF = this.f68919c;
        float f17 = rectF.left;
        float f18 = this.f68920d;
        float f19 = rectF.top;
        RectF rectF2 = new RectF(f17 + f18, f19, f17 + f18 + width, f19 + f16);
        float f26 = rectF2.left;
        float f27 = rectF2.top;
        float f28 = f16 / 2.0f;
        canvas.clipRect(f26, f27, rectF2.right, f27 + f28);
        canvas.drawOval(rectF2, this.f68918b);
        canvas.restore();
        canvas.save();
        float f29 = this.f68919c.bottom;
        float f36 = f29 - f16;
        rectF2.top = f36;
        rectF2.bottom = f29;
        canvas.clipRect(rectF2.left, f36 + f28, rectF2.right, f29);
        canvas.drawOval(rectF2, this.f68918b);
        canvas.restore();
        rectF2.top = Math.round(this.f68919c.top + f28);
        rectF2.bottom = Math.round(this.f68919c.bottom - f28);
        canvas.drawRect(rectF2, this.f68918b);
    }

    public void c() {
    }
}
