package com.tencent.state.square.like;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.widget.LinearLayout;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/state/square/like/SquareOperateLikePanel$setSelectLikeType$2$3", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareOperateLikePanel$setSelectLikeType$2$3 extends AnimatorListenerAdapter {
    final /* synthetic */ LinearLayout $heartContainer;
    final /* synthetic */ AnimatorSet $translationAnimatorSet;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SquareOperateLikePanel$setSelectLikeType$2$3(LinearLayout linearLayout, AnimatorSet animatorSet) {
        this.$heartContainer = linearLayout;
        this.$translationAnimatorSet = animatorSet;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        this.$heartContainer.postDelayed(new Runnable() { // from class: com.tencent.state.square.like.SquareOperateLikePanel$setSelectLikeType$2$3$onAnimationEnd$1
            @Override // java.lang.Runnable
            public final void run() {
                SquareOperateLikePanel$setSelectLikeType$2$3.this.$translationAnimatorSet.start();
            }
        }, 200L);
    }
}
