package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.Transition;

/* compiled from: P */
/* loaded from: classes.dex */
class TranslationAnimationCreator {
    TranslationAnimationCreator() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Animator createAnimation(@NonNull View view, @NonNull TransitionValues transitionValues, int i3, int i16, float f16, float f17, float f18, float f19, @Nullable TimeInterpolator timeInterpolator, @NonNull Transition transition) {
        float f26;
        float f27;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        if (((int[]) transitionValues.view.getTag(com.tencent.mobileqq.R.id.f100855tm)) != null) {
            f26 = (r4[0] - i3) + translationX;
            f27 = (r4[1] - i16) + translationY;
        } else {
            f26 = f16;
            f27 = f17;
        }
        int round = i3 + Math.round(f26 - translationX);
        int round2 = i16 + Math.round(f27 - translationY);
        view.setTranslationX(f26);
        view.setTranslationY(f27);
        if (f26 == f18 && f27 == f19) {
            return null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f26, f18), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f27, f19));
        TransitionPositionListener transitionPositionListener = new TransitionPositionListener(view, transitionValues.view, round, round2, translationX, translationY);
        transition.addListener(transitionPositionListener);
        ofPropertyValuesHolder.addListener(transitionPositionListener);
        AnimatorUtils.addPauseListener(ofPropertyValuesHolder, transitionPositionListener);
        ofPropertyValuesHolder.setInterpolator(timeInterpolator);
        return ofPropertyValuesHolder;
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class TransitionPositionListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private final View mMovingView;
        private float mPausedX;
        private float mPausedY;
        private final int mStartX;
        private final int mStartY;
        private final float mTerminalX;
        private final float mTerminalY;
        private int[] mTransitionPosition;
        private final View mViewInHierarchy;

        TransitionPositionListener(View view, View view2, int i3, int i16, float f16, float f17) {
            this.mMovingView = view;
            this.mViewInHierarchy = view2;
            this.mStartX = i3 - Math.round(view.getTranslationX());
            this.mStartY = i16 - Math.round(view.getTranslationY());
            this.mTerminalX = f16;
            this.mTerminalY = f17;
            int[] iArr = (int[]) view2.getTag(com.tencent.mobileqq.R.id.f100855tm);
            this.mTransitionPosition = iArr;
            if (iArr != null) {
                view2.setTag(com.tencent.mobileqq.R.id.f100855tm, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.mTransitionPosition == null) {
                this.mTransitionPosition = new int[2];
            }
            this.mTransitionPosition[0] = Math.round(this.mStartX + this.mMovingView.getTranslationX());
            this.mTransitionPosition[1] = Math.round(this.mStartY + this.mMovingView.getTranslationY());
            this.mViewInHierarchy.setTag(com.tencent.mobileqq.R.id.f100855tm, this.mTransitionPosition);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.mPausedX = this.mMovingView.getTranslationX();
            this.mPausedY = this.mMovingView.getTranslationY();
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            this.mMovingView.setTranslationX(this.mPausedX);
            this.mMovingView.setTranslationY(this.mPausedY);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
            transition.removeListener(this);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(@NonNull Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition transition) {
        }
    }
}
