package com.tencent.luggage.wxa.yl;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public Paint f146016a;

    /* renamed from: b, reason: collision with root package name */
    public Drawable f146017b;

    /* renamed from: c, reason: collision with root package name */
    public RectF f146018c;

    /* renamed from: d, reason: collision with root package name */
    public float f146019d;

    /* renamed from: e, reason: collision with root package name */
    public int f146020e = com.tencent.luggage.wxa.kn.a.c(z.c(), R.dimen.bht);

    public a(Drawable drawable) {
        this.f146017b = drawable;
        Paint paint = new Paint(1);
        this.f146016a = paint;
        paint.setColor(z.j().getColor(R.color.bwt));
    }

    public void a(float f16) {
        this.f146019d = f16;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f146017b;
        Rect bounds = drawable.getBounds();
        int save = canvas.save();
        canvas.rotate(this.f146019d, ((bounds.right - bounds.left) * 0.5f) + bounds.left, ((bounds.bottom - bounds.top) * 0.5f) + bounds.top);
        canvas.drawOval(this.f146018c, this.f146016a);
        drawable.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f146020e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f146020e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f146017b;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        Drawable drawable = this.f146017b;
        if (drawable != null) {
            drawable.setAlpha(i3);
        }
        this.f146016a.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i3, int i16, int i17, int i18) {
        Drawable drawable = this.f146017b;
        if (drawable != null) {
            drawable.setBounds(i3, i16, i17, i18);
        }
        this.f146018c = new RectF(i3, i16, i17, i18);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f146016a.setColorFilter(colorFilter);
    }
}
