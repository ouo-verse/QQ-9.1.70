package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.animation.Animator;

/* compiled from: P */
/* loaded from: classes21.dex */
public abstract class b implements Animator.AnimatorListener {
    @Override // android.animation.Animator.AnimatorListener
    public abstract void onAnimationEnd(Animator animator);

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator, boolean z16) {
        onAnimationEnd(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator, boolean z16) {
        onAnimationStart(animator);
    }
}
