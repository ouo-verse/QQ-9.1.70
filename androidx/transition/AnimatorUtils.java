package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
class AnimatorUtils {

    /* compiled from: P */
    /* loaded from: classes.dex */
    interface AnimatorPauseListenerCompat {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }

    AnimatorUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addPauseListener(@NonNull Animator animator, @NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        animator.addPauseListener(animatorListenerAdapter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void pause(@NonNull Animator animator) {
        animator.pause();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void resume(@NonNull Animator animator) {
        animator.resume();
    }
}
