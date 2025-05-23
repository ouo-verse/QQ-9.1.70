package com.tencent.util;

import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.graphics.PointF;
import android.view.animation.Animation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class AnimateUtils {
    static IPatchRedirector $redirector_ = null;
    private static float END_TENSION = 0.0f;
    private static final int NB_SAMPLES = 100;
    private static final float[] SPLINE;
    private static float START_TENSION;
    private static float sViscousFluidNormalize;
    private static float sViscousFluidScale;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class AnimationAdapter implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        public AnimationAdapter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* compiled from: P */
    @TargetApi(11)
    /* loaded from: classes27.dex */
    public static class BezierEvaluator implements TypeEvaluator<PointF> {
        static IPatchRedirector $redirector_;
        private PointF mPointF;

        public BezierEvaluator(PointF pointF) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) pointF);
            } else {
                this.mPointF = pointF;
            }
        }

        private PointF calculateBezierPointForQuadratic(float f16, PointF pointF, PointF pointF2, PointF pointF3) {
            PointF pointF4 = new PointF();
            float f17 = 1.0f - f16;
            float f18 = f17 * f17;
            float f19 = 2.0f * f16 * f17;
            float f26 = f16 * f16;
            pointF4.x = (pointF.x * f18) + (pointF2.x * f19) + (pointF3.x * f26);
            pointF4.y = (f18 * pointF.y) + (f19 * pointF2.y) + (f26 * pointF3.y);
            return pointF4;
        }

        @Override // android.animation.TypeEvaluator
        public PointF evaluate(float f16, PointF pointF, PointF pointF2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? calculateBezierPointForQuadratic(f16, pointF, this.mPointF, pointF2) : (PointF) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), pointF, pointF2);
        }
    }

    static {
        float f16;
        float f17;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42332);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        START_TENSION = 0.4f;
        END_TENSION = 1.0f - 0.4f;
        SPLINE = new float[101];
        float f18 = 0.0f;
        for (int i3 = 0; i3 <= 100; i3++) {
            float f19 = i3 / 100.0f;
            float f26 = 1.0f;
            while (true) {
                float f27 = ((f26 - f18) / 2.0f) + f18;
                float f28 = 1.0f - f27;
                f16 = 3.0f * f27 * f28;
                f17 = f27 * f27 * f27;
                float f29 = (((f28 * START_TENSION) + (END_TENSION * f27)) * f16) + f17;
                if (Math.abs(f29 - f19) < 1.0E-5d) {
                    break;
                } else if (f29 > f19) {
                    f26 = f27;
                } else {
                    f18 = f27;
                }
            }
            SPLINE[i3] = f16 + f17;
        }
        SPLINE[100] = 1.0f;
        sViscousFluidScale = 8.0f;
        sViscousFluidNormalize = 1.0f;
        sViscousFluidNormalize = 1.0f / viscousFluid(1.0f);
    }

    AnimateUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static float viscousFluid(float f16) {
        float exp;
        float f17 = f16 * sViscousFluidScale;
        if (f17 < 1.0f) {
            exp = f17 - (1.0f - ((float) Math.exp(-f17)));
        } else {
            exp = 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - f17))) * 0.63212055f);
        }
        return exp * sViscousFluidNormalize;
    }
}
