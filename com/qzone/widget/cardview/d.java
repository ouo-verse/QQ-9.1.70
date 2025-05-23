package com.qzone.widget.cardview;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* compiled from: P */
/* loaded from: classes37.dex */
class d extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private float f60718a;

    /* renamed from: c, reason: collision with root package name */
    private final RectF f60720c;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f60721d;

    /* renamed from: e, reason: collision with root package name */
    private float f60722e;

    /* renamed from: h, reason: collision with root package name */
    private ColorStateList f60725h;

    /* renamed from: i, reason: collision with root package name */
    private PorterDuffColorFilter f60726i;

    /* renamed from: j, reason: collision with root package name */
    private ColorStateList f60727j;

    /* renamed from: f, reason: collision with root package name */
    private boolean f60723f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f60724g = true;

    /* renamed from: k, reason: collision with root package name */
    private PorterDuff.Mode f60728k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f60719b = new Paint(5);

    public d(ColorStateList colorStateList, float f16) {
        this.f60718a = f16;
        d(colorStateList);
        this.f60720c = new RectF();
        this.f60721d = new Rect();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b() {
        return this.f60722e;
    }

    public float c() {
        return this.f60718a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z16;
        Paint paint = this.f60719b;
        if (this.f60726i == null || paint.getColorFilter() != null) {
            z16 = false;
        } else {
            paint.setColorFilter(this.f60726i);
            z16 = true;
        }
        RectF rectF = this.f60720c;
        float f16 = this.f60718a;
        canvas.drawRoundRect(rectF, f16, f16, paint);
        if (z16) {
            paint.setColorFilter(null);
        }
    }

    public void e(ColorStateList colorStateList) {
        d(colorStateList);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(float f16, boolean z16, boolean z17) {
        if (f16 == this.f60722e && this.f60723f == z16 && this.f60724g == z17) {
            return;
        }
        this.f60722e = f16;
        this.f60723f = z16;
        this.f60724g = z17;
        h(null);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(float f16) {
        if (f16 == this.f60718a) {
            return;
        }
        this.f60718a = f16;
        h(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f60721d, this.f60718a);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f60727j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f60725h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        h(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f60725h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z16 = colorForState != this.f60719b.getColor();
        if (z16) {
            this.f60719b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f60727j;
        if (colorStateList2 == null || (mode = this.f60728k) == null) {
            return z16;
        }
        this.f60726i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f60719b.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f60719b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f60727j = colorStateList;
        this.f60726i = a(colorStateList, this.f60728k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f60728k = mode;
        this.f60726i = a(this.f60727j, mode);
        invalidateSelf();
    }

    private void h(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f60720c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f60721d.set(rect);
        if (this.f60723f) {
            this.f60721d.inset((int) Math.ceil(e.a(this.f60722e, this.f60718a, this.f60724g)), (int) Math.ceil(e.b(this.f60722e, this.f60718a, this.f60724g)));
            this.f60720c.set(this.f60721d);
        }
    }

    private void d(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f60725h = colorStateList;
        this.f60719b.setColor(colorStateList.getColorForState(getState(), this.f60725h.getDefaultColor()));
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
