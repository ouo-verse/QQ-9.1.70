package mk0;

import android.animation.Animator;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class a implements Animator.AnimatorListener {
    @Override // android.animation.Animator.AnimatorListener
    public abstract void onAnimationEnd(Animator animator);

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator, boolean z16) {
        onAnimationEnd(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public abstract void onAnimationStart(Animator animator);

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator, boolean z16) {
        onAnimationStart(animator);
    }
}
