package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* compiled from: P */
/* loaded from: classes32.dex */
public class f {

    /* renamed from: c, reason: collision with root package name */
    private Paint f68925c;

    /* renamed from: a, reason: collision with root package name */
    private int f68923a = -1;

    /* renamed from: b, reason: collision with root package name */
    private int f68924b = 6;

    /* renamed from: d, reason: collision with root package name */
    private float f68926d = 0.0f;

    /* renamed from: e, reason: collision with root package name */
    private float f68927e = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    private float f68928f = 0.0f;

    /* renamed from: g, reason: collision with root package name */
    private RectF f68929g = new RectF();

    public boolean c(int i3, int i16, float f16, float f17, float f18) {
        this.f68924b = i16;
        this.f68926d = f17;
        this.f68927e = f18;
        this.f68923a = i3;
        if (this.f68925c == null) {
            Paint paint = new Paint();
            this.f68925c = paint;
            paint.setAntiAlias(true);
        }
        this.f68925c.setColor(this.f68923a);
        this.f68928f = f16;
        return true;
    }

    public int d(float f16) {
        int i3;
        if (this.f68929g.isEmpty()) {
            return 0;
        }
        float height = this.f68929g.height() / (this.f68924b + 1);
        float f17 = 0.0f;
        int i16 = 0;
        float f18 = 0.0f;
        while (true) {
            i3 = this.f68924b;
            if (i16 >= i3) {
                break;
            }
            f18 = (i16 * height) + height + this.f68929g.top;
            if (f16 <= f18) {
                break;
            }
            i16++;
            f17 = f18;
        }
        if (i16 == i3) {
            return i3 - 1;
        }
        if (i16 == 0) {
            return 0;
        }
        return f16 - f17 > f18 - f16 ? i16 : i16 - 1;
    }

    public void f(RectF rectF) {
        if (rectF != null) {
            this.f68929g.set(rectF);
        }
    }

    public void a(Canvas canvas, int i3, int i16, int i17, int i18) {
        if (canvas == null) {
            return;
        }
        float width = (this.f68929g.width() - this.f68927e) - this.f68926d;
        float height = this.f68929g.height() / (this.f68924b + 1);
        float f16 = (width / 2.0f) + this.f68926d;
        int i19 = 0;
        while (true) {
            int i26 = this.f68924b;
            if (i19 >= i26) {
                return;
            }
            float f17 = (i19 * height) + height + this.f68929g.top;
            if (i19 != i26 - 1 || i19 != i16) {
                if (i19 == i26 - 1) {
                    int alpha = this.f68925c.getAlpha();
                    this.f68925c.setAlpha(i3);
                    canvas.drawCircle(f16, f17, this.f68928f, this.f68925c);
                    this.f68925c.setAlpha(alpha);
                } else if (i19 == i16) {
                    int alpha2 = this.f68925c.getAlpha();
                    this.f68925c.setAlpha(i17);
                    canvas.drawCircle(f16, f17, this.f68928f, this.f68925c);
                    this.f68925c.setAlpha(alpha2);
                } else {
                    int alpha3 = this.f68925c.getAlpha();
                    this.f68925c.setAlpha(i18);
                    canvas.drawCircle(f16, f17, this.f68928f, this.f68925c);
                    this.f68925c.setAlpha(alpha3);
                }
            }
            i19++;
        }
    }

    public RectF b(int i3) {
        if (i3 < 0 || i3 >= this.f68924b || this.f68929g.isEmpty()) {
            return null;
        }
        float height = this.f68929g.height() / (this.f68924b + 1);
        float width = this.f68929g.width() / 2.0f;
        float f16 = height + (i3 * height) + this.f68929g.top;
        float f17 = this.f68928f;
        return new RectF(width - f17, f16 - f17, width + f17, f16 + f17);
    }

    public void e() {
    }
}
