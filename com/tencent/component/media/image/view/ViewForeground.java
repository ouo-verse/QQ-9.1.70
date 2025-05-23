package com.tencent.component.media.image.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ViewForeground {
    private Context mContext;
    private Drawable mDrawable;
    private int mDrawableHeight;
    private int mDrawableWidth;
    private boolean mForegroundBoundsChanged;
    private boolean mForegroundInPadding;
    private View mView;

    public ViewForeground(View view) {
        this.mForegroundBoundsChanged = false;
        this.mForegroundInPadding = true;
        this.mContext = view.getContext();
        this.mView = view;
    }

    private void updateDrawable(Drawable drawable) {
        View view = this.mView;
        Drawable drawable2 = this.mDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            view.unscheduleDrawable(this.mDrawable);
        }
        this.mDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(view);
            if (drawable.isStateful()) {
                drawable.setState(view.getDrawableState());
            }
            this.mDrawableWidth = drawable.getIntrinsicWidth();
            this.mDrawableHeight = drawable.getIntrinsicHeight();
            return;
        }
        this.mDrawableHeight = -1;
        this.mDrawableWidth = -1;
    }

    public void boundsChanged() {
        this.mForegroundBoundsChanged = true;
    }

    public void draw(Canvas canvas) {
        int i3;
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            View view = this.mView;
            if (this.mForegroundBoundsChanged) {
                int i16 = 0;
                this.mForegroundBoundsChanged = false;
                int width = view.getWidth();
                int height = view.getHeight();
                if (this.mForegroundInPadding) {
                    i16 = view.getPaddingLeft();
                    width -= view.getPaddingRight();
                    i3 = view.getPaddingTop();
                    height -= view.getPaddingBottom();
                } else {
                    i3 = 0;
                }
                drawable.setBounds(i16, i3, width, height);
            }
            drawable.draw(canvas);
        }
    }

    public void drawableStateChanged() {
        Drawable drawable = this.mDrawable;
        if (drawable != null && drawable.isStateful()) {
            this.mDrawable.setState(this.mView.getDrawableState());
        }
    }

    public Drawable getDrawable() {
        return this.mDrawable;
    }

    public void setDrawable(int i3) {
        setDrawable(this.mContext.getResources().getDrawable(i3));
    }

    public void setForegroundInPadding(boolean z16) {
        if (this.mForegroundInPadding != z16) {
            this.mForegroundInPadding = z16;
            boundsChanged();
        }
    }

    public void setDrawable(Drawable drawable) {
        if (this.mDrawable != drawable) {
            View view = this.mView;
            int i3 = this.mDrawableWidth;
            int i16 = this.mDrawableHeight;
            updateDrawable(drawable);
            if (i3 != this.mDrawableWidth || i16 != this.mDrawableHeight) {
                view.requestLayout();
            }
            view.invalidate();
        }
    }

    public ViewForeground(View view, Drawable drawable) {
        this(view);
        setDrawable(drawable);
    }

    public ViewForeground(View view, int i3) {
        this(view);
        setDrawable(i3);
    }
}
