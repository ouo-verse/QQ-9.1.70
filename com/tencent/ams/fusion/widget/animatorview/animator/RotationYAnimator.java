package com.tencent.ams.fusion.widget.animatorview.animator;

import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RotationYAnimator extends RotationAnimator {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "RotationYAnimator";
    private final Camera mCamera;
    private float mLocationX;
    private float mLocationY;
    private float mLocationZ;

    public RotationYAnimator(AnimatorLayer animatorLayer) {
        super(animatorLayer);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) animatorLayer);
            return;
        }
        this.mLocationX = 0.0f;
        this.mLocationY = 0.0f;
        this.mLocationZ = -8.0f;
        this.mCamera = new Camera();
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.RotationAnimator
    protected void postRotation(Canvas canvas, AnimatorLayer animatorLayer, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, canvas, animatorLayer, Float.valueOf(f16));
            return;
        }
        Matrix matrix = new Matrix();
        resetMatrix(animatorLayer, matrix);
        this.mCamera.save();
        this.mCamera.setLocation(this.mLocationX, this.mLocationY, this.mLocationZ);
        this.mCamera.rotateY(f16);
        this.mCamera.getMatrix(matrix);
        this.mCamera.restore();
        if (animatorLayer.isMatrixNeedPreTranslate()) {
            matrix.preTranslate(animatorLayer.getX(), animatorLayer.getY());
        }
        float px5 = animatorLayer.getPx();
        float py5 = animatorLayer.getPy();
        matrix.preTranslate(-px5, -py5);
        matrix.postTranslate(px5, py5);
        animatorLayer.setMatrix(matrix);
        animatorLayer.setMatrixChanged(true);
        animatorLayer.postRotationY(f16);
    }

    public RotationYAnimator setLocation(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RotationYAnimator) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
        }
        this.mLocationX = f16;
        this.mLocationY = f17;
        this.mLocationZ = f18;
        return this;
    }
}
