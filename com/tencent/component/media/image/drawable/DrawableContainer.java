package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.annotation.Public;

/* compiled from: P */
@Public
/* loaded from: classes5.dex */
public abstract class DrawableContainer extends Drawable implements Drawable.Callback {
    private boolean mMutated;
    private ContainerState mState;

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mState.mDrawable.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        ContainerState containerState = this.mState;
        return changingConfigurations | containerState.mChangingConfigurations | containerState.mDrawable.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.mState.canConstantState()) {
            this.mState.mChangingConfigurations = getChangingConfigurations();
            return this.mState;
        }
        return null;
    }

    public Drawable getDrawable() {
        return this.mState.mDrawable;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mState.mDrawable.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mState.mDrawable.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        Drawable drawable = this.mState.mDrawable;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        Drawable drawable = this.mState.mDrawable;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.mState.mDrawable.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.mState.mDrawable.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.mState.mDrawable.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mState.mDrawable.mutate();
            this.mMutated = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.mState.mDrawable.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        this.mState.mDrawable.setLevel(i3);
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean state = this.mState.mDrawable.setState(iArr);
        onBoundsChange(getBounds());
        return state;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
        scheduleSelf(runnable, j3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.mState.mDrawable.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mState.mDrawable.setColorFilter(colorFilter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Public
    public void setConstantState(ContainerState containerState) {
        this.mState = containerState;
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        this.mState.mDrawable.setDither(z16);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        boolean visible = super.setVisible(z16, z17);
        this.mState.mDrawable.setVisible(z16, z17);
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static abstract class ContainerState extends Drawable.ConstantState {
        private boolean mCanConstantState;
        int mChangingConfigurations;
        private boolean mCheckedConstantState;
        Drawable mDrawable;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ContainerState(Drawable drawable, DrawableContainer drawableContainer) {
            this.mDrawable = drawable;
            drawable.setCallback(drawableContainer);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean canConstantState() {
            boolean z16;
            if (!this.mCheckedConstantState) {
                if (this.mDrawable.getConstantState() != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.mCanConstantState = z16;
                this.mCheckedConstantState = true;
            }
            return this.mCanConstantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ContainerState(ContainerState containerState, DrawableContainer drawableContainer, Resources resources) {
            Drawable drawable;
            if (containerState == null || (drawable = containerState.mDrawable) == null || drawable.getConstantState() == null) {
                return;
            }
            if (resources != null) {
                this.mDrawable = containerState.mDrawable.getConstantState().newDrawable(resources);
            } else {
                this.mDrawable = containerState.mDrawable.getConstantState().newDrawable();
            }
            this.mDrawable.setCallback(drawableContainer);
            this.mCanConstantState = true;
            this.mCheckedConstantState = true;
        }
    }
}
