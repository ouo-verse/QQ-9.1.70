package com.tencent.state;

import android.view.animation.Animation;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/AnimListener;", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface AnimListener extends Animation.AnimationListener {
    @Override // android.view.animation.Animation.AnimationListener
    void onAnimationEnd(Animation animation);

    @Override // android.view.animation.Animation.AnimationListener
    void onAnimationRepeat(Animation animation);

    @Override // android.view.animation.Animation.AnimationListener
    void onAnimationStart(Animation animation);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class DefaultImpls {
        public static void onAnimationEnd(AnimListener animListener, Animation animation) {
        }

        public static void onAnimationRepeat(AnimListener animListener, Animation animation) {
        }

        public static void onAnimationStart(AnimListener animListener, Animation animation) {
        }
    }
}
