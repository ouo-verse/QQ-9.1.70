package com.nineoldandroids.view.animation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public final class AnimatorProxy extends Animation {
    public static final boolean NEEDS_PROXY;
    private static final WeakHashMap<View, AnimatorProxy> PROXIES;
    private boolean mHasPivot;
    private float mPivotX;
    private float mPivotY;
    private float mRotationX;
    private float mRotationY;
    private float mRotationZ;
    private float mTranslationX;
    private float mTranslationY;
    private final WeakReference<View> mView;
    private final Camera mCamera = new Camera();
    private float mAlpha = 1.0f;
    private float mScaleX = 1.0f;
    private float mScaleY = 1.0f;
    private final RectF mBefore = new RectF();
    private final RectF mAfter = new RectF();
    private final Matrix mTempMatrix = new Matrix();

    static {
        boolean z16;
        if (Integer.valueOf(Build.VERSION.SDK).intValue() < 11) {
            z16 = true;
        } else {
            z16 = false;
        }
        NEEDS_PROXY = z16;
        PROXIES = new WeakHashMap<>();
    }

    AnimatorProxy(View view) {
        setDuration(0L);
        setFillAfter(true);
        view.setAnimation(this);
        this.mView = new WeakReference<>(view);
    }

    private void computeRect(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        Matrix matrix = this.mTempMatrix;
        matrix.reset();
        transformMatrix(matrix, view);
        this.mTempMatrix.mapRect(rectF);
        rectF.offset(view.getLeft(), view.getTop());
        float f16 = rectF.right;
        float f17 = rectF.left;
        if (f16 < f17) {
            rectF.right = f17;
            rectF.left = f16;
        }
        float f18 = rectF.bottom;
        float f19 = rectF.top;
        if (f18 < f19) {
            rectF.top = f18;
            rectF.bottom = f19;
        }
    }

    private void invalidateAfterUpdate() {
        View view = this.mView.get();
        if (view != null && view.getParent() != null) {
            RectF rectF = this.mAfter;
            computeRect(rectF, view);
            rectF.union(this.mBefore);
            ((View) view.getParent()).invalidate((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
        }
    }

    private void prepareForUpdate() {
        View view = this.mView.get();
        if (view != null) {
            computeRect(this.mBefore, view);
        }
    }

    private void transformMatrix(Matrix matrix, View view) {
        float f16;
        float f17;
        float width = view.getWidth();
        float height = view.getHeight();
        boolean z16 = this.mHasPivot;
        if (z16) {
            f16 = this.mPivotX;
        } else {
            f16 = width / 2.0f;
        }
        if (z16) {
            f17 = this.mPivotY;
        } else {
            f17 = height / 2.0f;
        }
        float f18 = this.mRotationX;
        float f19 = this.mRotationY;
        float f26 = this.mRotationZ;
        if (f18 != 0.0f || f19 != 0.0f || f26 != 0.0f) {
            Camera camera2 = this.mCamera;
            camera2.save();
            camera2.rotateX(f18);
            camera2.rotateY(f19);
            camera2.rotateZ(-f26);
            camera2.getMatrix(matrix);
            camera2.restore();
            matrix.preTranslate(-f16, -f17);
            matrix.postTranslate(f16, f17);
        }
        float f27 = this.mScaleX;
        float f28 = this.mScaleY;
        if (f27 != 1.0f || f28 != 1.0f) {
            matrix.postScale(f27, f28);
            matrix.postTranslate((-(f16 / width)) * ((f27 * width) - width), (-(f17 / height)) * ((f28 * height) - height));
        }
        matrix.postTranslate(this.mTranslationX, this.mTranslationY);
    }

    public static AnimatorProxy wrap(View view) {
        WeakHashMap<View, AnimatorProxy> weakHashMap = PROXIES;
        AnimatorProxy animatorProxy = weakHashMap.get(view);
        if (animatorProxy == null || animatorProxy != view.getAnimation()) {
            AnimatorProxy animatorProxy2 = new AnimatorProxy(view);
            weakHashMap.put(view, animatorProxy2);
            return animatorProxy2;
        }
        return animatorProxy;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f16, Transformation transformation) {
        View view = this.mView.get();
        if (view != null) {
            transformation.setAlpha(this.mAlpha);
            transformMatrix(transformation.getMatrix(), view);
        }
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public float getPivotX() {
        return this.mPivotX;
    }

    public float getPivotY() {
        return this.mPivotY;
    }

    public float getRotation() {
        return this.mRotationZ;
    }

    public float getRotationX() {
        return this.mRotationX;
    }

    public float getRotationY() {
        return this.mRotationY;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public int getScrollX() {
        View view = this.mView.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollX();
    }

    public int getScrollY() {
        View view = this.mView.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollY();
    }

    public float getTranslationX() {
        return this.mTranslationX;
    }

    public float getTranslationY() {
        return this.mTranslationY;
    }

    public float getX() {
        if (this.mView.get() == null) {
            return 0.0f;
        }
        return r0.getLeft() + this.mTranslationX;
    }

    public float getY() {
        if (this.mView.get() == null) {
            return 0.0f;
        }
        return r0.getTop() + this.mTranslationY;
    }

    public void setAlpha(float f16) {
        if (this.mAlpha != f16) {
            this.mAlpha = f16;
            View view = this.mView.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void setPivotX(float f16) {
        if (!this.mHasPivot || this.mPivotX != f16) {
            prepareForUpdate();
            this.mHasPivot = true;
            this.mPivotX = f16;
            invalidateAfterUpdate();
        }
    }

    public void setPivotY(float f16) {
        if (!this.mHasPivot || this.mPivotY != f16) {
            prepareForUpdate();
            this.mHasPivot = true;
            this.mPivotY = f16;
            invalidateAfterUpdate();
        }
    }

    public void setRotation(float f16) {
        if (this.mRotationZ != f16) {
            prepareForUpdate();
            this.mRotationZ = f16;
            invalidateAfterUpdate();
        }
    }

    public void setRotationX(float f16) {
        if (this.mRotationX != f16) {
            prepareForUpdate();
            this.mRotationX = f16;
            invalidateAfterUpdate();
        }
    }

    public void setRotationY(float f16) {
        if (this.mRotationY != f16) {
            prepareForUpdate();
            this.mRotationY = f16;
            invalidateAfterUpdate();
        }
    }

    public void setScaleX(float f16) {
        if (this.mScaleX != f16) {
            prepareForUpdate();
            this.mScaleX = f16;
            invalidateAfterUpdate();
        }
    }

    public void setScaleY(float f16) {
        if (this.mScaleY != f16) {
            prepareForUpdate();
            this.mScaleY = f16;
            invalidateAfterUpdate();
        }
    }

    public void setScrollX(int i3) {
        View view = this.mView.get();
        if (view != null) {
            view.scrollTo(i3, view.getScrollY());
        }
    }

    public void setScrollY(int i3) {
        View view = this.mView.get();
        if (view != null) {
            view.scrollTo(view.getScrollX(), i3);
        }
    }

    public void setTranslationX(float f16) {
        if (this.mTranslationX != f16) {
            prepareForUpdate();
            this.mTranslationX = f16;
            invalidateAfterUpdate();
        }
    }

    public void setTranslationY(float f16) {
        if (this.mTranslationY != f16) {
            prepareForUpdate();
            this.mTranslationY = f16;
            invalidateAfterUpdate();
        }
    }

    public void setX(float f16) {
        if (this.mView.get() != null) {
            setTranslationX(f16 - r0.getLeft());
        }
    }

    public void setY(float f16) {
        if (this.mView.get() != null) {
            setTranslationY(f16 - r0.getTop());
        }
    }
}
