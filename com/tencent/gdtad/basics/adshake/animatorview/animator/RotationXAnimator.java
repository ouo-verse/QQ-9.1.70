package com.tencent.gdtad.basics.adshake.animatorview.animator;

import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer;

/* compiled from: P */
/* loaded from: classes6.dex */
public class RotationXAnimator extends RotationAnimator {
    private static final String TAG = "RotationXAnimator";
    private final Camera mCamera;

    public RotationXAnimator(AnimatorLayer animatorLayer) {
        super(animatorLayer);
        this.mCamera = new Camera();
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.RotationAnimator
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
        this.mCamera.save();
        this.mCamera.rotateX(f16);
        this.mCamera.setLocation(0.0f, 0.0f, -4.0f);
        this.mCamera.getMatrix(matrix);
        this.mCamera.restore();
        matrix.preTranslate(animatorLayer.getX(), animatorLayer.getY());
        matrix.preTranslate(-centerX, -centerY);
        matrix.postTranslate(centerX, centerY);
        animatorLayer.setMatrix(matrix);
        animatorLayer.postRotationX(f16, centerX, centerY);
    }
}
