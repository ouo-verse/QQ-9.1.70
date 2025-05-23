package com.nineoldandroids.view;

import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public abstract class ViewPropertyAnimator {
    private static final WeakHashMap<View, ViewPropertyAnimator> ANIMATORS = new WeakHashMap<>(0);

    public static ViewPropertyAnimator animate(View view) {
        WeakHashMap<View, ViewPropertyAnimator> weakHashMap = ANIMATORS;
        ViewPropertyAnimator viewPropertyAnimator = weakHashMap.get(view);
        if (viewPropertyAnimator == null) {
            ViewPropertyAnimatorPreHC viewPropertyAnimatorPreHC = new ViewPropertyAnimatorPreHC(view);
            weakHashMap.put(view, viewPropertyAnimatorPreHC);
            return viewPropertyAnimatorPreHC;
        }
        return viewPropertyAnimator;
    }

    public abstract ViewPropertyAnimator alpha(float f16);

    public abstract ViewPropertyAnimator alphaBy(float f16);

    public abstract void cancel();

    public abstract long getDuration();

    public abstract long getStartDelay();

    public abstract ViewPropertyAnimator rotation(float f16);

    public abstract ViewPropertyAnimator rotationBy(float f16);

    public abstract ViewPropertyAnimator rotationX(float f16);

    public abstract ViewPropertyAnimator rotationXBy(float f16);

    public abstract ViewPropertyAnimator rotationY(float f16);

    public abstract ViewPropertyAnimator rotationYBy(float f16);

    public abstract ViewPropertyAnimator scaleX(float f16);

    public abstract ViewPropertyAnimator scaleXBy(float f16);

    public abstract ViewPropertyAnimator scaleY(float f16);

    public abstract ViewPropertyAnimator scaleYBy(float f16);

    public abstract ViewPropertyAnimator setDuration(long j3);

    public abstract ViewPropertyAnimator setInterpolator(Interpolator interpolator);

    public abstract ViewPropertyAnimator setListener(Animator.AnimatorListener animatorListener);

    public abstract ViewPropertyAnimator setStartDelay(long j3);

    public abstract void start();

    public abstract ViewPropertyAnimator translationX(float f16);

    public abstract ViewPropertyAnimator translationXBy(float f16);

    public abstract ViewPropertyAnimator translationY(float f16);

    public abstract ViewPropertyAnimator translationYBy(float f16);

    public abstract ViewPropertyAnimator x(float f16);

    public abstract ViewPropertyAnimator xBy(float f16);

    public abstract ViewPropertyAnimator y(float f16);

    public abstract ViewPropertyAnimator yBy(float f16);
}
