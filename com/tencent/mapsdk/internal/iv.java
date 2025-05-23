package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.model.AlphaAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.Animation;
import com.tencent.tencentmap.mapsdk.maps.model.AnimationSet;
import com.tencent.tencentmap.mapsdk.maps.model.EmergeAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IAnimationSet;
import com.tencent.tencentmap.mapsdk.maps.model.RotateAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.ScaleAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.TranslateAnimation;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class iv {
    private static double[] a(double d16, double d17, int i3) {
        double d18 = d16 + d17;
        double abs = Math.abs(d17) / 2.0d;
        double sqrt = Math.sqrt((4.0d * abs) / 3.141592653589793d);
        int i16 = i3 >> 1;
        int i17 = i16 << 1;
        double[] dArr = new double[i17];
        int i18 = i16 - 1;
        dArr[i18] = d16 + (d17 / 2.0d);
        dArr[i17 - 1] = d18;
        double d19 = sqrt / i16;
        int i19 = 0;
        while (i19 < i18) {
            int i26 = i19 + 1;
            double d26 = sqrt - (i26 * d19);
            double acos = Math.acos(d26 / sqrt);
            double sin = (((acos * abs) * 2.0d) / 3.141592653589793d) - ((d26 * (Math.sin(acos) * sqrt)) / 2.0d);
            if (d17 < 0.0d) {
                sin = -sin;
            }
            dArr[i19] = d16 + sin;
            dArr[(i17 - 2) - i19] = d18 - sin;
            i19 = i26;
        }
        return dArr;
    }

    private static double[] b(double d16, double d17, int i3) {
        double d18 = d16 + d17;
        double[] dArr = new double[i3];
        double d19 = i3;
        double d26 = ((d17 * 2.0d) / d19) / d19;
        double d27 = d26 / 2.0d;
        int i16 = i3 - 1;
        dArr[i16] = d18;
        dArr[0] = d16 + d27;
        for (int i17 = 1; i17 < i16; i17++) {
            dArr[i17] = dArr[i17 - 1] + (i17 * d26) + d27;
        }
        return dArr;
    }

    public static double[] a(double d16, double d17) {
        double d18 = d16 + d17;
        double[] dArr = new double[20];
        dArr[9] = (d17 / 2.0d) + d16;
        dArr[19] = d18;
        double d19 = (d17 / 10.0d) / 10.0d;
        double d26 = d19 / 2.0d;
        dArr[0] = d16 + d26;
        dArr[18] = d18 - d26;
        for (int i3 = 1; i3 < 9; i3++) {
            double d27 = (i3 * d19) + d26;
            dArr[i3] = dArr[i3 - 1] + d27;
            dArr[18 - i3] = dArr[19 - i3] - d27;
        }
        return dArr;
    }

    public static <A extends Animation> hw a(bp bpVar, A a16) {
        Animation animation = null;
        if (bpVar == null || a16 == null) {
            return null;
        }
        if (a16 instanceof hw) {
            return (hw) a16;
        }
        Class<?> cls = a16.getClass();
        if (cls == AlphaAnimation.class) {
            AlphaAnimation alphaAnimation = (AlphaAnimation) a16;
            animation = bpVar.createAlphaAnimation(alphaAnimation.mFromAlpha, alphaAnimation.mToAlpha);
        } else if (cls == ScaleAnimation.class) {
            ScaleAnimation scaleAnimation = (ScaleAnimation) a16;
            animation = bpVar.createScaleAnimation(scaleAnimation.mFromX, scaleAnimation.mToX, scaleAnimation.mFromY, scaleAnimation.mToY);
        } else if (cls == EmergeAnimation.class) {
            animation = bpVar.createEmergeAnimation(((EmergeAnimation) a16).mStartPoint);
        } else if (cls == AnimationSet.class) {
            AnimationSet animationSet = (AnimationSet) a16;
            IAnimationSet createAnimationSet = bpVar.createAnimationSet(animationSet.mShareInterpolator);
            Iterator<Animation> it = animationSet.mAnimations.iterator();
            while (it.hasNext()) {
                ((hx) createAnimationSet).addAnimation(a(bpVar, it.next()));
            }
            animation = createAnimationSet;
        } else if (cls == RotateAnimation.class) {
            RotateAnimation rotateAnimation = (RotateAnimation) a16;
            animation = bpVar.createRotateAnimation(rotateAnimation.mFromDegree, rotateAnimation.mToDegree, rotateAnimation.mPivoteX, rotateAnimation.mPivoteY, rotateAnimation.mPivoteZ);
        } else if (cls == TranslateAnimation.class) {
            animation = bpVar.createTranslateAnimation(((TranslateAnimation) a16).mTargetLatLng);
        }
        if (animation != null) {
            animation.setDuration(a16.getDuration());
            animation.setInterpolator(a16.getInterpolator());
            animation.setAnimationListener(a16.getAnimationListener());
        }
        return (hw) animation;
    }
}
