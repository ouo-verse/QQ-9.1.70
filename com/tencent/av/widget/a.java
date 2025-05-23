package com.tencent.av.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends ClipDrawable {

    /* renamed from: d, reason: collision with root package name */
    private Drawable f77226d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f77227e;

    /* renamed from: f, reason: collision with root package name */
    private int f77228f;

    /* renamed from: h, reason: collision with root package name */
    private int f77229h;

    /* renamed from: i, reason: collision with root package name */
    private final Rect f77230i;

    /* renamed from: m, reason: collision with root package name */
    private final Rect f77231m;

    public a(Drawable drawable, Drawable drawable2, int i3, int i16) {
        super(drawable, i3, 1);
        this.f77230i = new Rect();
        this.f77231m = new Rect();
        this.f77226d = drawable;
        this.f77227e = drawable2;
        this.f77228f = i3;
        this.f77229h = i16;
    }

    private float a(float f16, float f17) {
        int i3 = this.f77229h;
        return b(0.0f, f17, f16, (i3 / 2) + 0, f17 - (i3 / 2));
    }

    private float b(float f16, float f17, float f18, float f19, float f26) {
        float f27 = (f17 + f16) / 2.0f;
        float f28 = (f26 + f19) / 2.0f;
        return f28 + (((f18 - f27) * (f28 - f19)) / (f27 - f16));
    }

    @Override // android.graphics.drawable.ClipDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect rect = this.f77230i;
        Rect rect2 = this.f77231m;
        Rect bounds = getBounds();
        float level = getLevel() / 10000.0f;
        rect.set(bounds);
        rect2.set(bounds);
        if ((this.f77228f & 1) != 0) {
            float a16 = a(bounds.left + (bounds.width() * level), bounds.width());
            rect.right = ((int) (a16 - (this.f77229h / 2))) + (bounds.width() / 45);
            rect2.left = ((int) (a16 + (this.f77229h / 2))) - (bounds.width() / 45);
        }
        if ((this.f77228f & 2) != 0) {
            float a17 = a(bounds.top + (bounds.height() * level), bounds.height());
            rect.bottom = ((int) (a17 - (this.f77229h / 2))) + (bounds.height() / 45);
            rect2.top = ((int) (a17 + (this.f77229h / 2))) - (bounds.height() / 45);
        }
        canvas.save();
        canvas.clipRect(rect);
        this.f77226d.draw(canvas);
        canvas.restore();
        canvas.save();
        canvas.clipRect(rect2);
        this.f77227e.draw(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f77227e.setBounds(rect);
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.ClipDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        this.f77227e.setLevel(i3);
        return super.onLevelChange(i3);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        this.f77227e.setState(iArr);
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f77227e.setAlpha(i3);
        super.setAlpha(i3);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f77227e.setColorFilter(colorFilter);
        super.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        this.f77227e.setVisible(z16, z17);
        return super.setVisible(z16, z17);
    }
}
