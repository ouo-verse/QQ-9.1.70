package com.tencent.mobileqq.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class l extends Drawable implements Drawable.Callback {

    /* renamed from: d, reason: collision with root package name */
    private boolean f316926d;

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        super.getChangingConfigurations();
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f316926d && super.mutate() == this) {
            throw null;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
        scheduleSelf(runnable, j3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
