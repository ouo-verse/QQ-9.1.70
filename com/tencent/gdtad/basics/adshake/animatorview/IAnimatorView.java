package com.tencent.gdtad.basics.adshake.animatorview;

import com.tencent.gdtad.basics.adshake.animatorview.animator.Animator;
import com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface IAnimatorView {
    void addLayer(int i3, AnimatorLayer animatorLayer);

    void addLayer(AnimatorLayer animatorLayer);

    void clearCanvas();

    void clearLayers();

    boolean isUserStarted();

    void pauseAnimation();

    void removeLayer(AnimatorLayer animatorLayer);

    void resumeAnimation();

    void setAnimationListener(Animator.AnimatorListener animatorListener);

    void startAnimation();

    void stopAnimation();

    void stopAnimation(boolean z16, boolean z17);
}
