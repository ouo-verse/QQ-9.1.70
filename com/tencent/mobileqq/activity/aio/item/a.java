package com.tencent.mobileqq.activity.aio.item;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.Gravity;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends Drawable {

    /* renamed from: g, reason: collision with root package name */
    private static final RectF f179431g = new RectF();

    /* renamed from: h, reason: collision with root package name */
    private static final Rect f179432h = new Rect();

    /* renamed from: a, reason: collision with root package name */
    private Paint f179433a;

    /* renamed from: b, reason: collision with root package name */
    private float f179434b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f179435c = false;

    /* renamed from: d, reason: collision with root package name */
    private Paint f179436d;

    /* renamed from: e, reason: collision with root package name */
    private Rect f179437e;

    /* renamed from: f, reason: collision with root package name */
    private String f179438f;

    public a(int i3, float f16) {
        Paint paint = new Paint(1);
        this.f179433a = paint;
        paint.setColor(i3);
        this.f179434b = f16;
    }

    public void a(int i3, int i16) {
        this.f179435c = true;
        Paint paint = new Paint(1);
        this.f179436d = paint;
        paint.setTextSize(i3);
        this.f179436d.setColor(i16);
        this.f179437e = new Rect();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f16;
        float f17;
        int level = getLevel();
        if (level == 0) {
            return;
        }
        Rect rect = f179432h;
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int i3 = height - (((10000 - level) * height) / 10000);
        int height2 = canvas.getHeight();
        Gravity.apply(48, width, i3, bounds, rect);
        if (width > 0 && i3 > 0) {
            this.f179438f = (100 - (level / 100)) + "%";
            canvas.save();
            if (this.f179435c) {
                Paint paint = this.f179436d;
                String str = this.f179438f;
                paint.getTextBounds(str, 0, str.length(), this.f179437e);
                f16 = (canvas.getWidth() - this.f179437e.width()) / 2;
                f17 = (height2 + this.f179437e.height()) / 2;
                canvas.drawText(this.f179438f, f16, f17, this.f179436d);
            } else {
                f16 = 0.0f;
                f17 = 0.0f;
            }
            canvas.clipRect(rect);
            RectF rectF = f179431g;
            rectF.set(bounds);
            float f18 = this.f179434b;
            canvas.drawRoundRect(rectF, f18, f18, this.f179433a);
            if (this.f179435c) {
                canvas.drawText(this.f179438f, f16, f17, this.f179436d);
            }
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
