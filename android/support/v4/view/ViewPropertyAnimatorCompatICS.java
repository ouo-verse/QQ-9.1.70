package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.animation.Interpolator;

/* loaded from: classes.dex */
class ViewPropertyAnimatorCompatICS {
    ViewPropertyAnimatorCompatICS() {
    }

    public static void alpha(View view, float f16) {
        view.animate().alpha(f16);
    }

    public static void alphaBy(View view, float f16) {
        view.animate().alphaBy(f16);
    }

    public static void cancel(View view) {
        view.animate().cancel();
    }

    public static long getDuration(View view) {
        return view.animate().getDuration();
    }

    public static long getStartDelay(View view) {
        return view.animate().getStartDelay();
    }

    public static void rotation(View view, float f16) {
        view.animate().rotation(f16);
    }

    public static void rotationBy(View view, float f16) {
        view.animate().rotationBy(f16);
    }

    public static void rotationX(View view, float f16) {
        view.animate().rotationX(f16);
    }

    public static void rotationXBy(View view, float f16) {
        view.animate().rotationXBy(f16);
    }

    public static void rotationY(View view, float f16) {
        view.animate().rotationY(f16);
    }

    public static void rotationYBy(View view, float f16) {
        view.animate().rotationYBy(f16);
    }

    public static void scaleX(View view, float f16) {
        view.animate().scaleX(f16);
    }

    public static void scaleXBy(View view, float f16) {
        view.animate().scaleXBy(f16);
    }

    public static void scaleY(View view, float f16) {
        view.animate().scaleY(f16);
    }

    public static void scaleYBy(View view, float f16) {
        view.animate().scaleYBy(f16);
    }

    public static void setDuration(View view, long j3) {
        view.animate().setDuration(j3);
    }

    public static void setInterpolator(View view, Interpolator interpolator) {
        view.animate().setInterpolator(interpolator);
    }

    public static void setListener(final View view, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener(new AnimatorListenerAdapter() { // from class: android.support.v4.view.ViewPropertyAnimatorCompatICS.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    ViewPropertyAnimatorListener.this.onAnimationCancel(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ViewPropertyAnimatorListener.this.onAnimationEnd(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    ViewPropertyAnimatorListener.this.onAnimationStart(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    public static void setStartDelay(View view, long j3) {
        view.animate().setStartDelay(j3);
    }

    public static void start(View view) {
        view.animate().start();
    }

    public static void translationX(View view, float f16) {
        view.animate().translationX(f16);
    }

    public static void translationXBy(View view, float f16) {
        view.animate().translationXBy(f16);
    }

    public static void translationY(View view, float f16) {
        view.animate().translationY(f16);
    }

    public static void translationYBy(View view, float f16) {
        view.animate().translationYBy(f16);
    }

    public static void x(View view, float f16) {
        view.animate().x(f16);
    }

    public static void xBy(View view, float f16) {
        view.animate().xBy(f16);
    }

    public static void y(View view, float f16) {
        view.animate().y(f16);
    }

    public static void yBy(View view, float f16) {
        view.animate().yBy(f16);
    }
}
