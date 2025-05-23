package com.tencent.ams.fusion.widget.animatorview.animator;

import android.animation.TimeInterpolator;
import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RotationAnimator extends Animator {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "RotationAnimator";
    private float mRotationDegreeEnd;
    private float mRotationDegreeStart;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface OnRotationChangeListener {
        void onChange(float f16);
    }

    public RotationAnimator(AnimatorLayer animatorLayer) {
        super(animatorLayer);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) animatorLayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float computeRotation(float f16) {
        float rotation;
        float f17;
        boolean z16;
        TimeInterpolator timeInterpolator = this.mInterpolator;
        if (timeInterpolator != null) {
            f16 = timeInterpolator.getInterpolation(f16);
        }
        if (getRepeatMode() == 2) {
            if (getRepeatIndex() % 2 != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
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

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator
    public int getRenderPriority() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator
    protected void onPostAnimation(Canvas canvas, AnimatorLayer animatorLayer, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, canvas, animatorLayer, Boolean.valueOf(z16));
        } else if (z16) {
            postRotation(canvas, animatorLayer, getFinishRotation());
        } else {
            postRotation(canvas, animatorLayer, computeRotation(getProgress()));
        }
    }

    protected void postRotation(Canvas canvas, AnimatorLayer animatorLayer, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, canvas, animatorLayer, Float.valueOf(f16));
            return;
        }
        Matrix matrix = animatorLayer.getMatrix();
        resetMatrix(animatorLayer, matrix);
        matrix.postRotate(f16, animatorLayer.getPx(), animatorLayer.getPy());
        animatorLayer.postRotation(f16);
    }

    public void setOnRotationChangeListener(OnRotationChangeListener onRotationChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) onRotationChangeListener);
        } else if (onRotationChangeListener != null) {
            setAnimatorProgressListener(new Animator.AnimatorProgressListener(onRotationChangeListener) { // from class: com.tencent.ams.fusion.widget.animatorview.animator.RotationAnimator.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ OnRotationChangeListener val$onRotationChangeListener;

                {
                    this.val$onRotationChangeListener = onRotationChangeListener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RotationAnimator.this, (Object) onRotationChangeListener);
                    }
                }

                @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorProgressListener
                public void onAnimationProgressUpdate(float f16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Float.valueOf(f16));
                    } else {
                        this.val$onRotationChangeListener.onChange(RotationAnimator.this.computeRotation(f16));
                    }
                }

                @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorProgressListener
                public int updateInterval() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        return ((Integer) iPatchRedirector2.redirect((short) 3, (Object) this)).intValue();
                    }
                    return 0;
                }
            });
        }
    }

    public RotationAnimator setRotationDegrees(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RotationAnimator) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17));
        }
        this.mRotationDegreeStart = f16;
        this.mRotationDegreeEnd = f17;
        return this;
    }
}
