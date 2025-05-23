package com.tencent.gdtad.basics.adshake.animatorview.animator;

import android.animation.TimeInterpolator;
import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.gdtad.basics.adshake.animatorview.animator.Animator;
import com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes6.dex */
public class RotationAnimator extends Animator {
    protected float mCenterX;
    protected float mCenterY;
    protected int mRotationCenterType;
    private float mRotationDegreeEnd;
    private float mRotationDegreeStart;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface RotationCenterType {
        public static final int ABSOLUTE_POSITION = 1;
        public static final int RELATIVE_POSITION = 2;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements Animator.AnimatorProgressListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f108721a;

        a(b bVar) {
            this.f108721a = bVar;
        }

        @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator.AnimatorProgressListener
        public void onAnimationProgressUpdate(float f16) {
            this.f108721a.onChange(RotationAnimator.this.computeRotation(f16));
        }

        @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator.AnimatorProgressListener
        public int updateInterval() {
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface b {
        void onChange(float f16);
    }

    public RotationAnimator(AnimatorLayer animatorLayer) {
        super(animatorLayer);
        this.mRotationCenterType = 2;
    }

    private float computeRotation() {
        float rotation;
        float f16;
        float progress = getProgress();
        TimeInterpolator timeInterpolator = this.mInterpolator;
        if (timeInterpolator != null) {
            progress = timeInterpolator.getInterpolation(progress);
        }
        if (getRepeatMode() == 2) {
            if (getRepeatIndex() % 2 != 0) {
                rotation = getRotation() * (1.0f - progress);
                f16 = this.mRotationDegreeStart;
            } else {
                rotation = getRotation() * progress;
                f16 = this.mRotationDegreeStart;
            }
        } else {
            rotation = getRotation() * progress;
            f16 = this.mRotationDegreeStart;
        }
        return rotation + f16;
    }

    private float getFinishRotation() {
        if (getRepeatCount() > 1 && getRepeatMode() == 2) {
            if (getRepeatIndex() % 2 == 0) {
                return this.mRotationDegreeEnd;
            }
            return this.mRotationDegreeStart;
        }
        return this.mRotationDegreeEnd;
    }

    private float getRotation() {
        return this.mRotationDegreeEnd - this.mRotationDegreeStart;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator
    public int getRenderPriority() {
        return 1;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator
    protected void onPostAnimation(Canvas canvas, AnimatorLayer animatorLayer, boolean z16) {
        if (z16) {
            postRotation(canvas, animatorLayer, getFinishRotation());
        } else {
            postRotation(canvas, animatorLayer, computeRotation());
        }
    }

    protected void postRotation(Canvas canvas, AnimatorLayer animatorLayer, float f16) {
        float centerX;
        float centerY;
        Matrix matrix = animatorLayer.getMatrix();
        resetMatrix(animatorLayer, matrix);
        if (this.mRotationCenterType == 1) {
            centerX = this.mCenterX;
            centerY = this.mCenterY;
        } else {
            centerX = animatorLayer.getCenterX() + this.mCenterX;
            centerY = animatorLayer.getCenterY() + this.mCenterY;
        }
        matrix.postRotate(f16, centerX, centerY);
        animatorLayer.postRotation(f16, centerX, centerY);
    }

    public void setOnRotationChangeListener(b bVar) {
        if (bVar != null) {
            setAnimatorProgressListener(new a(bVar));
        }
    }

    public RotationAnimator setRotationCenter(float f16, float f17) {
        this.mRotationCenterType = 1;
        this.mCenterX = f16;
        this.mCenterY = f17;
        return this;
    }

    public RotationAnimator setRotationDegrees(float f16, float f17) {
        this.mRotationDegreeStart = f16;
        this.mRotationDegreeEnd = f17;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float computeRotation(float f16) {
        float rotation;
        float f17;
        TimeInterpolator timeInterpolator = this.mInterpolator;
        if (timeInterpolator != null) {
            f16 = timeInterpolator.getInterpolation(f16);
        }
        if (getRepeatMode() == 2) {
            if (getRepeatIndex() % 2 != 0) {
                rotation = getRotation() * (1.0f - f16);
                f17 = this.mRotationDegreeStart;
            } else {
                rotation = getRotation() * f16;
                f17 = this.mRotationDegreeStart;
            }
        } else {
            rotation = getRotation() * f16;
            f17 = this.mRotationDegreeStart;
        }
        return rotation + f17;
    }
}
