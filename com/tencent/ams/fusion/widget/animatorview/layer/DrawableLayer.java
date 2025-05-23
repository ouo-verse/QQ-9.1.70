package com.tencent.ams.fusion.widget.animatorview.layer;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DrawableLayer extends AnimatorLayer {
    static IPatchRedirector $redirector_;
    private Drawable mDrawable;
    private float mScaleX;
    private float mScaleY;
    private float mStartCenterX;
    private float mStartCenterY;

    public DrawableLayer() {
        this(null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        int x16 = (int) getX();
        int y16 = (int) getY();
        drawable.setBounds(x16, y16, getWidth() + x16, getHeight() + y16);
        drawable.draw(canvas);
    }

    public Drawable getDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mDrawable;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        float f16 = this.mScaleY;
        if (f16 > 0.0f) {
            return (int) (f16 * this.mHeight);
        }
        return super.getHeight();
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        float f16 = this.mScaleX;
        if (f16 > 0.0f) {
            return (int) (f16 * this.mWidth);
        }
        return super.getWidth();
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            super.postAlpha(i3);
            this.mDrawable.setAlpha(this.mAlpha);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postScale(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.mScaleX = f16;
        this.mScaleY = f17;
        if (this.mStartCenterX == 0.0f) {
            this.mStartCenterX = getCenterX();
        }
        if (this.mStartCenterY == 0.0f) {
            this.mStartCenterY = getCenterY();
        }
        this.mX = this.mStartCenterX - ((this.mScaleX * this.mWidth) / 2.0f);
        this.mY = this.mStartCenterY - ((this.mScaleY * this.mHeight) / 2.0f);
    }

    public void setDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable);
        } else {
            this.mDrawable = adapterGrayDrawable(drawable);
        }
    }

    public DrawableLayer(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            setDrawable(drawable);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable);
        }
    }
}
