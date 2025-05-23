package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.ShapeDrawable;
import com.tencent.component.media.image.drawable.DrawableContainer;

/* compiled from: P */
/* loaded from: classes5.dex */
public class XfermodeDrawable extends DrawableContainer {
    private XfermodeState mState;

    public static Drawable create(Drawable drawable, Xfermode xfermode) {
        if (drawable != null && support(drawable)) {
            return new XfermodeDrawable(drawable, xfermode);
        }
        return drawable;
    }

    private static Paint obtainPaint(Drawable drawable) {
        if (drawable == null || (drawable instanceof XfermodeDrawable)) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getPaint();
        }
        if (drawable instanceof NinePatchDrawable) {
            return ((NinePatchDrawable) drawable).getPaint();
        }
        if (drawable instanceof ShapeDrawable) {
            return ((ShapeDrawable) drawable).getPaint();
        }
        if (drawable instanceof ImageDrawable) {
            return ((ImageDrawable) drawable).getPaint();
        }
        if (!(drawable instanceof DrawableContainer)) {
            return null;
        }
        return obtainPaint(((DrawableContainer) drawable).getDrawable());
    }

    public static boolean support(Drawable drawable) {
        if (drawable != null && obtainPaint(drawable) == null) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.component.media.image.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Paint obtainPaint = obtainPaint(this.mState.mDrawable);
        Xfermode xfermode = this.mState.mXfermode;
        if (obtainPaint != null && obtainPaint.getXfermode() != xfermode) {
            obtainPaint.setXfermode(xfermode);
        }
        super.draw(canvas);
    }

    public void setXfermode(Xfermode xfermode) {
        XfermodeState xfermodeState = this.mState;
        if (xfermodeState.mXfermode != xfermode) {
            xfermodeState.mXfermode = xfermode;
            invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class XfermodeState extends DrawableContainer.ContainerState {
        Xfermode mXfermode;

        XfermodeState(Drawable drawable, DrawableContainer drawableContainer, Xfermode xfermode) {
            super(drawable, drawableContainer);
            this.mXfermode = xfermode;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new XfermodeDrawable(this, null);
        }

        XfermodeState(XfermodeState xfermodeState, DrawableContainer drawableContainer, Resources resources) {
            super(xfermodeState, drawableContainer, resources);
            this.mXfermode = xfermodeState.mXfermode;
        }
    }

    public XfermodeDrawable(Drawable drawable) {
        this(drawable, (Xfermode) null);
    }

    public XfermodeDrawable(Drawable drawable, Xfermode xfermode) {
        if (support(drawable)) {
            XfermodeState xfermodeState = new XfermodeState(drawable, this, xfermode);
            this.mState = xfermodeState;
            setConstantState(xfermodeState);
        } else {
            throw new RuntimeException("No xfermode support for " + drawable.getClass().getSimpleName());
        }
    }

    XfermodeDrawable(XfermodeState xfermodeState, Resources resources) {
        this.mState = xfermodeState;
        setConstantState(xfermodeState);
    }
}
