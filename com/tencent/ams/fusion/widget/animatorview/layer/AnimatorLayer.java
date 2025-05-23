package com.tencent.ams.fusion.widget.animatorview.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.ams.fusion.widget.animatorview.AnimatorConfig;
import com.tencent.ams.fusion.widget.animatorview.AnimatorUtils;
import com.tencent.ams.fusion.widget.animatorview.Logger;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.render.IAnimatorRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class AnimatorLayer implements Animator.AnimatorListener, AnimatorAction {
    static IPatchRedirector $redirector_ = null;
    protected static final int ALPHA_OPAQUE = 255;
    public static final float NOT_SET = Float.MIN_VALUE;
    protected int mAlign;
    protected int mAlpha;
    protected Animator mAnimator;
    protected Animator.AnimatorListener mAnimatorListener;
    private IAnimatorRender mAnimatorRender;
    protected int mBottomMargin;
    protected View mCanvasView;
    protected float mCenterX;
    protected float mCenterY;
    protected float mDistanceX;
    protected float mDistanceY;
    protected int mHeight;
    protected Matrix mMatrix;
    protected boolean mMatrixChanged;
    protected final Paint mPaint;
    protected AnimatorLayer mParent;
    protected float mPx;
    protected float mPy;
    protected float mRotationDegrees;
    protected float mRotationXDegrees;
    protected float mRotationYDegrees;
    protected float mScaleX;
    protected float mScaleY;
    protected Object mTag;
    protected int mWidth;
    protected float mX;
    protected float mY;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface AlignType {
        public static final int ALIGN_BOTTOM = 2;
        public static final int ALIGN_TOP = 1;
    }

    public AnimatorLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mX = Float.MIN_VALUE;
        this.mY = Float.MIN_VALUE;
        this.mCenterX = Float.MIN_VALUE;
        this.mCenterY = Float.MIN_VALUE;
        this.mPx = Float.MIN_VALUE;
        this.mPy = Float.MIN_VALUE;
        this.mAlign = 1;
        this.mAlpha = 255;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(true);
    }

    private String getLogTag() {
        return getClass().getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap adapterGrayBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return (Bitmap) iPatchRedirector.redirect((short) 51, (Object) this, (Object) bitmap);
        }
        if (AnimatorConfig.isGrayModeOn()) {
            return AnimatorUtils.convertGrayBitmap(bitmap);
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int adapterGrayColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Integer) iPatchRedirector.redirect((short) 52, (Object) this, i3)).intValue();
        }
        if (AnimatorConfig.isGrayModeOn()) {
            return AnimatorUtils.convertGrayColor(i3);
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable adapterGrayDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return (Drawable) iPatchRedirector.redirect((short) 53, (Object) this, (Object) drawable);
        }
        if (AnimatorConfig.isGrayModeOn()) {
            return AnimatorUtils.convertGrayDrawable(drawable);
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void assignParent(AnimatorLayer animatorLayer) {
        this.mParent = animatorLayer;
    }

    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this);
            return;
        }
        Animator animator = this.mAnimator;
        if (animator != null) {
            animator.removeAnimatorListener(this);
        }
        this.mCanvasView = null;
    }

    public abstract void draw(Canvas canvas);

    public int getAlign() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        return this.mAlign;
    }

    public int getAlpha() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Integer) iPatchRedirector.redirect((short) 37, (Object) this)).intValue();
        }
        return this.mAlpha;
    }

    public Animator getAnimator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (Animator) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        return this.mAnimator;
    }

    public int getBottomMargin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        return this.mBottomMargin;
    }

    public View getCanvasView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (View) iPatchRedirector.redirect((short) 45, (Object) this);
        }
        return this.mCanvasView;
    }

    public float getCenterX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Float) iPatchRedirector.redirect((short) 12, (Object) this)).floatValue();
        }
        float f16 = this.mCenterX;
        if (f16 != Float.MIN_VALUE) {
            return f16 + this.mDistanceX;
        }
        float f17 = this.mX;
        if (f17 == Float.MIN_VALUE) {
            Logger.w(getLogTag(), "getCenterX failed: not set 'centerX' and 'x'");
            return 0.0f;
        }
        return f17 + (getWidth() / 2.0f) + this.mDistanceX;
    }

    public float getCenterY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Float) iPatchRedirector.redirect((short) 14, (Object) this)).floatValue();
        }
        float f16 = this.mCenterY;
        if (f16 != Float.MIN_VALUE) {
            return f16 + this.mDistanceY;
        }
        float f17 = this.mY;
        if (f17 == Float.MIN_VALUE) {
            return 0.0f;
        }
        return f17 + (getHeight() / 2.0f) + this.mDistanceY;
    }

    public float getDistanceX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Float) iPatchRedirector.redirect((short) 35, (Object) this)).floatValue();
        }
        return this.mDistanceX;
    }

    public float getDistanceY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Float) iPatchRedirector.redirect((short) 36, (Object) this)).floatValue();
        }
        return this.mDistanceY;
    }

    public int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this)).intValue();
        }
        return this.mHeight;
    }

    public Matrix getMatrix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (Matrix) iPatchRedirector.redirect((short) 47, (Object) this);
        }
        if (this.mMatrix == null) {
            this.mMatrix = new Matrix();
        }
        return this.mMatrix;
    }

    public Paint getPaint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return (Paint) iPatchRedirector.redirect((short) 48, (Object) this);
        }
        return this.mPaint;
    }

    public AnimatorLayer getParent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 50, (Object) this);
        }
        return this.mParent;
    }

    public float getPx() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Float) iPatchRedirector.redirect((short) 17, (Object) this)).floatValue();
        }
        float f16 = this.mPx;
        if (f16 == Float.MIN_VALUE) {
            return getCenterX();
        }
        return f16;
    }

    public float getPy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Float) iPatchRedirector.redirect((short) 19, (Object) this)).floatValue();
        }
        float f16 = this.mPy;
        if (f16 == Float.MIN_VALUE) {
            return getCenterY();
        }
        return f16;
    }

    public float getRotationDegrees() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Float) iPatchRedirector.redirect((short) 11, (Object) this)).floatValue();
        }
        return this.mRotationDegrees;
    }

    public float getRotationXDegrees() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Float) iPatchRedirector.redirect((short) 9, (Object) this)).floatValue();
        }
        return this.mRotationXDegrees;
    }

    public float getRotationYDegrees() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Float) iPatchRedirector.redirect((short) 10, (Object) this)).floatValue();
        }
        return this.mRotationYDegrees;
    }

    public float getScaleX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Float) iPatchRedirector.redirect((short) 28, (Object) this)).floatValue();
        }
        return this.mScaleX;
    }

    public float getScaleY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Float) iPatchRedirector.redirect((short) 29, (Object) this)).floatValue();
        }
        return this.mScaleY;
    }

    public Object getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return iPatchRedirector.redirect((short) 49, (Object) this);
        }
        return this.mTag;
    }

    public int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this)).intValue();
        }
        return this.mWidth;
    }

    public float getX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Float) iPatchRedirector.redirect((short) 20, (Object) this)).floatValue();
        }
        float f16 = this.mX;
        if (f16 != Float.MIN_VALUE) {
            return f16 + this.mDistanceX;
        }
        float f17 = this.mCenterX;
        if (f17 == Float.MIN_VALUE) {
            return 0.0f;
        }
        return (f17 - (getWidth() / 2.0f)) + this.mDistanceX;
    }

    public float getY() {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Float) iPatchRedirector.redirect((short) 22, (Object) this)).floatValue();
        }
        if (this.mAlign == 2 && (view = this.mCanvasView) != null) {
            return (view.getHeight() - this.mBottomMargin) - getHeight();
        }
        float f16 = this.mY;
        if (f16 != Float.MIN_VALUE) {
            return f16 + this.mDistanceY;
        }
        float f17 = this.mCenterY;
        if (f17 == Float.MIN_VALUE) {
            return 0.0f;
        }
        return (f17 - (getHeight() / 2.0f)) + this.mDistanceY;
    }

    public boolean isMatrixNeedPreTranslate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this)).booleanValue();
        }
        return true;
    }

    public boolean isStartDraw() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return ((Boolean) iPatchRedirector.redirect((short) 54, (Object) this)).booleanValue();
        }
        IAnimatorRender iAnimatorRender = this.mAnimatorRender;
        if (iAnimatorRender != null) {
            return iAnimatorRender.isUserStarted();
        }
        return false;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
    public void onAnimationFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this);
            return;
        }
        Animator.AnimatorListener animatorListener = this.mAnimatorListener;
        if (animatorListener != null) {
            animatorListener.onAnimationFinish();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.mAlpha = i3;
            this.mPaint.setAlpha(i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postRotation(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        } else {
            this.mRotationDegrees = f16;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postRotationX(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
        } else {
            this.mRotationXDegrees = f16;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postRotationY(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
        } else {
            this.mRotationYDegrees = f16;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postScale(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.mScaleX = f16;
            this.mScaleY = f17;
        }
    }

    public void postTaskOnRenderThread(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 56)) {
            postTaskOnRenderThread(runnable, false);
        } else {
            iPatchRedirector.redirect((short) 56, (Object) this, (Object) runnable);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postTranslate(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.mDistanceX = f16;
            this.mDistanceY = f17;
        }
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this);
            return;
        }
        this.mAlpha = 255;
        this.mDistanceX = 0.0f;
        this.mDistanceY = 0.0f;
        this.mMatrix = null;
    }

    public void setAlign(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
        } else {
            this.mAlign = i3;
        }
    }

    public void setAnimator(Animator animator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) animator);
            return;
        }
        if (animator != null) {
            animator.addAnimatorListener(this);
        }
        this.mAnimator = animator;
    }

    public void setAnimatorListener(Animator.AnimatorListener animatorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) animatorListener);
        } else {
            this.mAnimatorListener = animatorListener;
        }
    }

    public void setAnimatorRender(IAnimatorRender iAnimatorRender) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, (Object) iAnimatorRender);
        } else {
            this.mAnimatorRender = iAnimatorRender;
        }
    }

    public void setBottomMargin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
        } else {
            this.mBottomMargin = i3;
        }
    }

    public void setCanvasView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) view);
        } else {
            this.mCanvasView = view;
        }
    }

    public AnimatorLayer setCenterX(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16));
        }
        this.mCenterX = f16;
        return this;
    }

    public AnimatorLayer setCenterY(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 15, this, Float.valueOf(f16));
        }
        this.mCenterY = f16;
        return this;
    }

    public AnimatorLayer setHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 34, (Object) this, i3);
        }
        this.mHeight = i3;
        return this;
    }

    public void setMatrix(Matrix matrix) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) matrix);
        } else {
            this.mMatrix = matrix;
        }
    }

    public void setMatrixChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, z16);
        } else {
            this.mMatrixChanged = z16;
        }
    }

    public void setPaintColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setColor(i3);
        }
    }

    public void setPx(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Float.valueOf(f16));
        } else {
            this.mPx = f16;
        }
    }

    public void setPy(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Float.valueOf(f16));
        } else {
            this.mPy = f16;
        }
    }

    public void setTag(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, obj);
        } else {
            this.mTag = obj;
        }
    }

    public AnimatorLayer setWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 32, (Object) this, i3);
        }
        this.mWidth = i3;
        return this;
    }

    public AnimatorLayer setX(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 21, this, Float.valueOf(f16));
        }
        this.mX = f16;
        return this;
    }

    public AnimatorLayer setY(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 23, this, Float.valueOf(f16));
        }
        this.mY = f16;
        return this;
    }

    public void postTaskOnRenderThread(Runnable runnable, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, this, runnable, Boolean.valueOf(z16));
            return;
        }
        IAnimatorRender iAnimatorRender = this.mAnimatorRender;
        if (iAnimatorRender != null) {
            iAnimatorRender.postTaskOnRenderThread(runnable, z16);
        }
    }
}
