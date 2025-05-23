package com.tencent.gdtad.basics.adshake.animatorview.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import com.tencent.ams.fusion.widget.animatorview.AnimatorConfig;
import com.tencent.ams.fusion.widget.animatorview.AnimatorUtils;
import com.tencent.gdtad.basics.adshake.animatorview.animator.Animator;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class AnimatorLayer implements AnimatorAction, Animator.AnimatorListener {
    protected static final int ALPHA_OPAQUE = 255;
    public static final float NOT_SET = Float.MIN_VALUE;
    protected Animator mAnimator;
    protected Animator.AnimatorListener mAnimatorListener;
    protected int mBottomMargin;
    protected View mCanvasView;
    protected float mDistanceX;
    protected float mDistanceY;
    protected int mHeight;
    protected Matrix mMatrix;
    protected boolean mMatrixChanged;
    protected final Paint mPaint;
    protected AnimatorLayer mParent;
    protected float mRotationDegrees;
    protected float mRotationPx;
    protected float mRotationPy;
    protected float mRotationXDegrees;
    protected float mRotationXPx;
    protected float mRotationXPy;
    protected float mRotationYDegrees;
    protected String mTag;
    protected int mWidth;
    protected float mX = Float.MIN_VALUE;
    protected float mY = Float.MIN_VALUE;
    protected float mCenterX = Float.MIN_VALUE;
    protected float mCenterY = Float.MIN_VALUE;
    protected float mPx = Float.MIN_VALUE;
    protected float mPy = Float.MIN_VALUE;
    protected int mAlign = 1;
    protected int mAlpha = 255;
    protected float mScaleX = 1.0f;
    protected float mScaleY = 1.0f;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface AlignType {
        public static final int ALIGN_BOTTOM = 2;
        public static final int ALIGN_TOP = 1;
    }

    public AnimatorLayer() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(true);
    }

    private String getLogTag() {
        return getClass().getSimpleName();
    }

    protected int adapterGrayColor(int i3) {
        if (AnimatorConfig.isGrayModeOn()) {
            return AnimatorUtils.convertGrayColor(i3);
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void assignParent(AnimatorLayer animatorLayer) {
        this.mParent = animatorLayer;
    }

    public void clear() {
        Animator animator = this.mAnimator;
        if (animator != null) {
            animator.removeAnimatorListener(this);
        }
        this.mCanvasView = null;
    }

    public abstract void draw(Canvas canvas);

    public int getAlign() {
        return this.mAlign;
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public Animator getAnimator() {
        return this.mAnimator;
    }

    public int getBottomMargin() {
        return this.mBottomMargin;
    }

    public View getCanvasView() {
        return this.mCanvasView;
    }

    public float getCenterX() {
        float f16 = this.mCenterX;
        if (f16 != Float.MIN_VALUE) {
            return f16 + this.mDistanceX;
        }
        float f17 = this.mX;
        if (f17 == Float.MIN_VALUE) {
            QLog.i(getTag(), 1, "getCenterX failed: not set 'centerX' and 'x'");
            return 0.0f;
        }
        return f17 + (getWidth() / 2.0f) + this.mDistanceX;
    }

    public float getCenterY() {
        float f16;
        float f17 = this.mCenterY;
        if (f17 != Float.MIN_VALUE) {
            f16 = this.mDistanceY;
        } else {
            float f18 = this.mY;
            if (f18 == Float.MIN_VALUE) {
                return 0.0f;
            }
            f17 = f18 + (getHeight() / 2.0f);
            f16 = this.mDistanceY;
        }
        return f17 + f16;
    }

    public float getDistanceX() {
        return this.mDistanceX;
    }

    public float getDistanceY() {
        return this.mDistanceY;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public Matrix getMatrix() {
        if (this.mMatrix == null) {
            this.mMatrix = new Matrix();
        }
        return this.mMatrix;
    }

    public Paint getPaint() {
        return this.mPaint;
    }

    public AnimatorLayer getParent() {
        return this.mParent;
    }

    public float getPx() {
        float f16 = this.mPx;
        if (f16 == Float.MIN_VALUE) {
            return getCenterX();
        }
        return f16;
    }

    public float getPy() {
        float f16 = this.mPy;
        if (f16 == Float.MIN_VALUE) {
            return getCenterY();
        }
        return f16;
    }

    public float getRotationDegrees() {
        return this.mRotationDegrees;
    }

    public float getRotationPx() {
        return this.mRotationPx;
    }

    public float getRotationPy() {
        return this.mRotationPy;
    }

    public float getRotationXDegrees() {
        return this.mRotationXDegrees;
    }

    public float getRotationXPx() {
        return this.mRotationXPx;
    }

    public float getRotationXPy() {
        return this.mRotationXPy;
    }

    public float getRotationYDegrees() {
        return this.mRotationYDegrees;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public String getTag() {
        return this.mTag;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public float getX() {
        float f16;
        float f17 = this.mX;
        if (f17 != Float.MIN_VALUE) {
            f16 = this.mDistanceX;
        } else {
            float f18 = this.mCenterX;
            if (f18 == Float.MIN_VALUE) {
                return 0.0f;
            }
            f17 = f18 - (getWidth() / 2.0f);
            f16 = this.mDistanceX;
        }
        return f17 + f16;
    }

    public float getY() {
        View view;
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
        return true;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator.AnimatorListener
    public void onAnimationFinish() {
        Animator.AnimatorListener animatorListener = this.mAnimatorListener;
        if (animatorListener != null) {
            animatorListener.onAnimationFinish();
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    public void postAlpha(int i3) {
        this.mAlpha = i3;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    public void postRotation(float f16, float f17, float f18) {
        this.mRotationDegrees = f16;
        this.mRotationPx = f17;
        this.mRotationPy = f18;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    public void postRotationX(float f16, float f17, float f18) {
        this.mRotationXDegrees = f16;
        this.mRotationXPx = f17;
        this.mRotationXPy = f18;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    public void postRotationY(float f16) {
        this.mRotationYDegrees = f16;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    public void postScale(float f16, float f17, float f18, float f19, float f26) {
        this.mScaleX = f16;
        this.mScaleY = f17;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    public void postTranslate(float f16, float f17) {
        this.mDistanceX = f16;
        this.mDistanceY = f17;
    }

    public void reset() {
        this.mAlpha = 255;
        this.mDistanceX = 0.0f;
        this.mDistanceY = 0.0f;
        this.mMatrix = null;
    }

    public void setAlign(int i3) {
        this.mAlign = i3;
    }

    public void setAnimator(Animator animator) {
        if (animator != null) {
            animator.addAnimatorListener(this);
        }
        this.mAnimator = animator;
    }

    public void setAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.mAnimatorListener = animatorListener;
    }

    public void setBottomMargin(int i3) {
        this.mBottomMargin = i3;
    }

    public void setCanvasView(View view) {
        this.mCanvasView = view;
    }

    public AnimatorLayer setCenterX(float f16) {
        this.mCenterX = f16;
        return this;
    }

    public AnimatorLayer setCenterY(float f16) {
        this.mCenterY = f16;
        return this;
    }

    public AnimatorLayer setHeight(int i3) {
        this.mHeight = i3;
        return this;
    }

    public void setMatrix(Matrix matrix) {
        this.mMatrix = matrix;
    }

    public void setMatrixChanged(boolean z16) {
        this.mMatrixChanged = z16;
    }

    public void setPx(float f16) {
        this.mPx = f16;
    }

    public void setPy(float f16) {
        this.mPy = f16;
    }

    public void setTag(String str) {
        this.mTag = str;
    }

    public AnimatorLayer setWidth(int i3) {
        this.mWidth = i3;
        return this;
    }

    public AnimatorLayer setX(float f16) {
        this.mX = f16;
        return this;
    }

    public AnimatorLayer setY(float f16) {
        this.mY = f16;
        return this;
    }
}
