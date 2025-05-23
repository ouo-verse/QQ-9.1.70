package com.google.android.material.floatingactionbutton;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.shape.g;
import com.google.android.material.shape.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class c extends Drawable {

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final Paint f33679b;

    /* renamed from: h, reason: collision with root package name */
    @Dimension
    float f33685h;

    /* renamed from: i, reason: collision with root package name */
    @ColorInt
    private int f33686i;

    /* renamed from: j, reason: collision with root package name */
    @ColorInt
    private int f33687j;

    /* renamed from: k, reason: collision with root package name */
    @ColorInt
    private int f33688k;

    /* renamed from: l, reason: collision with root package name */
    @ColorInt
    private int f33689l;

    /* renamed from: m, reason: collision with root package name */
    @ColorInt
    private int f33690m;

    /* renamed from: o, reason: collision with root package name */
    private g f33692o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    private ColorStateList f33693p;

    /* renamed from: a, reason: collision with root package name */
    private final h f33678a = h.k();

    /* renamed from: c, reason: collision with root package name */
    private final Path f33680c = new Path();

    /* renamed from: d, reason: collision with root package name */
    private final Rect f33681d = new Rect();

    /* renamed from: e, reason: collision with root package name */
    private final RectF f33682e = new RectF();

    /* renamed from: f, reason: collision with root package name */
    private final RectF f33683f = new RectF();

    /* renamed from: g, reason: collision with root package name */
    private final b f33684g = new b();

    /* renamed from: n, reason: collision with root package name */
    private boolean f33691n = true;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private class b extends Drawable.ConstantState {
        b() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return c.this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(g gVar) {
        this.f33692o = gVar;
        Paint paint = new Paint(1);
        this.f33679b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    @NonNull
    private Shader a() {
        copyBounds(this.f33681d);
        float height = this.f33685h / r0.height();
        return new LinearGradient(0.0f, r0.top, 0.0f, r0.bottom, new int[]{ColorUtils.compositeColors(this.f33686i, this.f33690m), ColorUtils.compositeColors(this.f33687j, this.f33690m), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.f33687j, 0), this.f33690m), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.f33689l, 0), this.f33690m), ColorUtils.compositeColors(this.f33689l, this.f33690m), ColorUtils.compositeColors(this.f33688k, this.f33690m)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }

    @NonNull
    protected RectF b() {
        this.f33683f.set(getBounds());
        return this.f33683f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f33690m = colorStateList.getColorForState(getState(), this.f33690m);
        }
        this.f33693p = colorStateList;
        this.f33691n = true;
        invalidateSelf();
    }

    public void d(@Dimension float f16) {
        if (this.f33685h != f16) {
            this.f33685h = f16;
            this.f33679b.setStrokeWidth(f16 * 1.3333f);
            this.f33691n = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f33691n) {
            this.f33679b.setShader(a());
            this.f33691n = false;
        }
        float strokeWidth = this.f33679b.getStrokeWidth() / 2.0f;
        copyBounds(this.f33681d);
        this.f33682e.set(this.f33681d);
        float min = Math.min(this.f33692o.r().a(b()), this.f33682e.width() / 2.0f);
        if (this.f33692o.u(b())) {
            this.f33682e.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f33682e, min, min, this.f33679b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(@ColorInt int i3, @ColorInt int i16, @ColorInt int i17, @ColorInt int i18) {
        this.f33686i = i3;
        this.f33687j = i16;
        this.f33688k = i17;
        this.f33689l = i18;
    }

    public void f(g gVar) {
        this.f33692o = gVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.f33684g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.f33685h > 0.0f) {
            return -3;
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.f33692o.u(b())) {
            outline.setRoundRect(getBounds(), this.f33692o.r().a(b()));
            return;
        }
        copyBounds(this.f33681d);
        this.f33682e.set(this.f33681d);
        this.f33678a.d(this.f33692o, 1.0f, this.f33682e, this.f33680c);
        if (this.f33680c.isConvex()) {
            outline.setConvexPath(this.f33680c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        if (this.f33692o.u(b())) {
            int round = Math.round(this.f33685h);
            rect.set(round, round, round, round);
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f33693p;
        if ((colorStateList != null && colorStateList.isStateful()) || super.isStateful()) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f33691n = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.f33693p;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.f33690m)) != this.f33690m) {
            this.f33691n = true;
            this.f33690m = colorForState;
        }
        if (this.f33691n) {
            invalidateSelf();
        }
        return this.f33691n;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i3) {
        this.f33679b.setAlpha(i3);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f33679b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
