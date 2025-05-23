package com.tencent.ams.fusion.widget.cny2025.twist;

import com.tencent.ams.fusion.widget.animatorview.Logger;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.GroupAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.ProgressAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.RotationAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.ScaleAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.SequentialAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes3.dex */
public class CNYTwistAnimationHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "CNYTwistAnimationHelper";

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class ArrowAnimationConfig {
        static IPatchRedirector $redirector_;
        public final long duration;
        public final float fromProgress;
        public final float toProgress;

        public ArrowAnimationConfig(float f16, float f17, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16), Float.valueOf(f17), Long.valueOf(j3));
                return;
            }
            this.fromProgress = f16;
            this.toProgress = f17;
            this.duration = j3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class IconAnimationConfig {
        static IPatchRedirector $redirector_;
        public final long duration;
        public final float fromDegrees;
        public final double fromScale;
        public final float fromX;
        public final float fromY;
        public final float toDegrees;
        public final double toScale;
        public final float toX;
        public final float toY;

        public IconAnimationConfig(float f16, float f17, float f18, float f19, float f26, float f27, double d16, double d17, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Float.valueOf(f26), Float.valueOf(f27), Double.valueOf(d16), Double.valueOf(d17), Long.valueOf(j3));
                return;
            }
            this.fromX = f16;
            this.toX = f17;
            this.fromY = f18;
            this.toY = f19;
            this.fromDegrees = f26;
            this.toDegrees = f27;
            this.fromScale = d16;
            this.toScale = d17;
            this.duration = j3;
        }
    }

    public CNYTwistAnimationHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void createArrowAnimation(CNYTwistArrowLayer cNYTwistArrowLayer, ArrowAnimationConfig[] arrowAnimationConfigArr, int i3) {
        if (cNYTwistArrowLayer == null) {
            Logger.e(TAG, "createArrowAnimation, arrowLayer is null");
            return;
        }
        if (arrowAnimationConfigArr != null && arrowAnimationConfigArr.length != 0) {
            SequentialAnimator sequentialAnimator = new SequentialAnimator(cNYTwistArrowLayer);
            sequentialAnimator.setRepeatCount(i3);
            sequentialAnimator.setRepeatMode(1);
            for (ArrowAnimationConfig arrowAnimationConfig : arrowAnimationConfigArr) {
                if (arrowAnimationConfig == null) {
                    Logger.e(TAG, "createArrowAnimation, config is null, continue");
                } else {
                    ProgressAnimator progressAnimator = new ProgressAnimator(cNYTwistArrowLayer, arrowAnimationConfig.fromProgress, arrowAnimationConfig.toProgress);
                    progressAnimator.setDuration(arrowAnimationConfig.duration);
                    sequentialAnimator.addAnimator(progressAnimator);
                }
            }
            cNYTwistArrowLayer.setAnimator(sequentialAnimator);
            return;
        }
        Logger.e(TAG, "createArrowAnimation, configs is null");
    }

    public static void createArrowsAnimation(CNYTwistArrowLayer cNYTwistArrowLayer, ArrowAnimationConfig[] arrowAnimationConfigArr, CNYTwistArrowLayer cNYTwistArrowLayer2, ArrowAnimationConfig[] arrowAnimationConfigArr2, int i3) {
        if (cNYTwistArrowLayer != null && arrowAnimationConfigArr != null) {
            createArrowAnimation(cNYTwistArrowLayer, arrowAnimationConfigArr, i3);
        } else {
            Logger.i(TAG, "createArrowsAnimation, leftArrowLayer or leftArrowConfigs is null, leftArrowLayer = " + cNYTwistArrowLayer + ", leftArrowConfigs = " + Arrays.toString(arrowAnimationConfigArr));
        }
        if (cNYTwistArrowLayer2 != null && arrowAnimationConfigArr2 != null) {
            createArrowAnimation(cNYTwistArrowLayer2, arrowAnimationConfigArr2, i3);
            return;
        }
        Logger.i(TAG, "createArrowsAnimation, rightArrowLayer or rightArrowConfigs is null, rightArrowLayer = " + cNYTwistArrowLayer2 + ", rightArrowConfigs = " + arrowAnimationConfigArr2);
    }

    private static void createIconAnimation(AnimatorLayer animatorLayer, IconAnimationConfig[] iconAnimationConfigArr, int i3) {
        int i16;
        int i17;
        int i18;
        boolean z16;
        if (animatorLayer == null) {
            Logger.e(TAG, "createIconAnimation, iconLayer is null");
            return;
        }
        if (iconAnimationConfigArr != null && iconAnimationConfigArr.length != 0) {
            SequentialAnimator sequentialAnimator = new SequentialAnimator(animatorLayer);
            sequentialAnimator.setRepeatCount(i3);
            boolean z17 = true;
            sequentialAnimator.setRepeatMode(1);
            int length = iconAnimationConfigArr.length;
            int i19 = 0;
            int i26 = 0;
            while (i26 < length) {
                IconAnimationConfig iconAnimationConfig = iconAnimationConfigArr[i26];
                if (iconAnimationConfig == null) {
                    Logger.i(TAG, "createIconAnimation, config is null, continue");
                    z16 = z17;
                    i16 = length;
                    i18 = i19;
                    i17 = i26;
                } else {
                    GroupAnimator groupAnimator = new GroupAnimator(animatorLayer, new Animator[i19]);
                    groupAnimator.setPathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
                    XYMoveAnimator xYMoveAnimator = new XYMoveAnimator(animatorLayer, iconAnimationConfig.fromX, iconAnimationConfig.toX, iconAnimationConfig.fromY, iconAnimationConfig.toY);
                    RotationAnimator rotationAnimator = new RotationAnimator(animatorLayer);
                    rotationAnimator.setRotationDegrees(iconAnimationConfig.fromDegrees, iconAnimationConfig.toDegrees);
                    int width = animatorLayer.getWidth();
                    int height = animatorLayer.getHeight();
                    double d16 = width;
                    i16 = length;
                    double d17 = iconAnimationConfig.fromScale;
                    i17 = i26;
                    double d18 = iconAnimationConfig.toScale;
                    double d19 = height;
                    ScaleAnimator scaleAnimator = new ScaleAnimator(animatorLayer, (int) (d16 * d17), (int) (d16 * d18), (int) (d17 * d19), (int) (d19 * d18));
                    i18 = 0;
                    z16 = true;
                    groupAnimator.addAnimators(xYMoveAnimator, rotationAnimator, scaleAnimator);
                    groupAnimator.setDuration(iconAnimationConfig.duration);
                    sequentialAnimator.addAnimator(groupAnimator);
                }
                i26 = i17 + 1;
                i19 = i18;
                z17 = z16;
                length = i16;
            }
            animatorLayer.setAnimator(sequentialAnimator);
            return;
        }
        Logger.e(TAG, "createIconAnimation, iconConfigs is null");
    }

    public static void createIconsAnimation(AnimatorLayer animatorLayer, IconAnimationConfig iconAnimationConfig, AnimatorLayer animatorLayer2, IconAnimationConfig iconAnimationConfig2, int i3) {
        if (animatorLayer != null && iconAnimationConfig != null) {
            createIconAnimation(animatorLayer, new IconAnimationConfig[]{iconAnimationConfig}, i3);
        } else {
            Logger.e(TAG, "createIconsAnimation, leftIconLayer or leftIconConfig is null, leftIconLayer = " + animatorLayer + ", leftIconConfig = " + iconAnimationConfig);
        }
        if (animatorLayer2 != null && iconAnimationConfig2 != null) {
            createIconAnimation(animatorLayer2, new IconAnimationConfig[]{iconAnimationConfig2}, i3);
            return;
        }
        Logger.e(TAG, "createIconsAnimation, rightIconLayer or rightIconConfig is null, rightIconLayer = " + animatorLayer2 + ", rightIconConfig = " + iconAnimationConfig2);
    }

    public static void createIconsAnimation(AnimatorLayer animatorLayer, IconAnimationConfig[] iconAnimationConfigArr, AnimatorLayer animatorLayer2, IconAnimationConfig[] iconAnimationConfigArr2, int i3) {
        if (animatorLayer != null && iconAnimationConfigArr != null) {
            createIconAnimation(animatorLayer, iconAnimationConfigArr, i3);
        } else {
            Logger.e(TAG, "createIconsAnimation, leftIconLayer or leftIconConfigs is null, leftIconLayer = " + animatorLayer + ", leftIconConfigs = " + Arrays.toString(iconAnimationConfigArr));
        }
        if (animatorLayer2 != null && iconAnimationConfigArr2 != null) {
            createIconAnimation(animatorLayer2, iconAnimationConfigArr2, i3);
            return;
        }
        Logger.e(TAG, "createIconsAnimation, rightIconLayer or rightIconConfigs is null, rightIconLayer = " + animatorLayer2 + ", rightIconConfigs = " + Arrays.toString(iconAnimationConfigArr2));
    }
}
