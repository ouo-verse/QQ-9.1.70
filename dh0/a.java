package dh0;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class a extends Drawable {

    /* renamed from: b, reason: collision with root package name */
    private ColorFilter f393819b;

    /* renamed from: c, reason: collision with root package name */
    private ColorStateList f393820c;

    /* renamed from: e, reason: collision with root package name */
    private PorterDuffColorFilter f393822e;

    /* renamed from: a, reason: collision with root package name */
    int f393818a = 255;

    /* renamed from: d, reason: collision with root package name */
    private PorterDuff.Mode f393821d = PorterDuff.Mode.SRC_IN;

    /* renamed from: f, reason: collision with root package name */
    private final b f393823f = new b();

    /* compiled from: P */
    /* loaded from: classes38.dex */
    private class b extends Drawable.ConstantState {
        b() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return a.this;
        }
    }

    private boolean c() {
        ColorStateList colorStateList = this.f393820c;
        if (colorStateList != null && this.f393821d != null) {
            this.f393822e = new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), this.f393821d);
            return true;
        }
        boolean z16 = this.f393822e != null;
        this.f393822e = null;
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ColorFilter a() {
        ColorFilter colorFilter = this.f393819b;
        return colorFilter != null ? colorFilter : this.f393822e;
    }

    protected abstract void b(Canvas canvas, int i3, int i16);

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.width() == 0 || bounds.height() == 0) {
            return;
        }
        int save = canvas.save();
        canvas.translate(bounds.left, bounds.top);
        b(canvas, bounds.width(), bounds.height());
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f393818a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f393819b;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f393823f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f393820c;
        return colorStateList != null && colorStateList.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        return c();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (this.f393818a != i3) {
            this.f393818a = i3;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f393819b = colorFilter;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i3) {
        setTintList(ColorStateList.valueOf(i3));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f393820c = colorStateList;
        if (c()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f393821d = mode;
        if (c()) {
            invalidateSelf();
        }
    }
}
