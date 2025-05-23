package dh0;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d extends a {

    /* renamed from: g, reason: collision with root package name */
    private Drawable f393833g;

    /* renamed from: h, reason: collision with root package name */
    private int f393834h = -1;

    public d(Drawable drawable) {
        this.f393833g = drawable;
    }

    @Override // dh0.a
    protected void b(Canvas canvas, int i3, int i16) {
        this.f393833g.setAlpha(this.f393818a);
        ColorFilter a16 = a();
        if (a16 != null) {
            this.f393833g.setColorFilter(a16);
        }
        int intrinsicHeight = this.f393833g.getIntrinsicHeight();
        float f16 = i16 / intrinsicHeight;
        canvas.scale(f16, f16);
        float f17 = i3 / f16;
        int i17 = this.f393834h;
        if (i17 < 0) {
            int intrinsicWidth = this.f393833g.getIntrinsicWidth();
            int i18 = 0;
            while (i18 < f17) {
                int i19 = i18 + intrinsicWidth;
                this.f393833g.setBounds(i18, 0, i19, intrinsicHeight);
                this.f393833g.draw(canvas);
                i18 = i19;
            }
            return;
        }
        float f18 = f17 / i17;
        for (int i26 = 0; i26 < this.f393834h; i26++) {
            float f19 = (i26 + 0.5f) * f18;
            float intrinsicWidth2 = this.f393833g.getIntrinsicWidth() / 2.0f;
            this.f393833g.setBounds(Math.round(f19 - intrinsicWidth2), 0, Math.round(f19 + intrinsicWidth2), intrinsicHeight);
            this.f393833g.draw(canvas);
        }
    }

    public Drawable d() {
        return this.f393833g;
    }

    @Override // dh0.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public void e(int i3) {
        this.f393834h = i3;
        invalidateSelf();
    }

    @Override // dh0.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // dh0.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    @Override // dh0.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable.ConstantState getConstantState() {
        return super.getConstantState();
    }

    @Override // dh0.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // dh0.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isStateful() {
        return super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f393833g = this.f393833g.mutate();
        return this;
    }

    @Override // dh0.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i3) {
        super.setAlpha(i3);
    }

    @Override // dh0.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // dh0.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setTint(int i3) {
        super.setTint(i3);
    }

    @Override // dh0.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // dh0.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }
}
