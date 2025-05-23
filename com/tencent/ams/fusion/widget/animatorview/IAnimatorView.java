package com.tencent.ams.fusion.widget.animatorview;

import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IAnimatorView {
    void addLayer(int i3, AnimatorLayer animatorLayer);

    void addLayer(AnimatorLayer animatorLayer);

    void clearCanvas();

    void clearLayers();

    List<AnimatorLayer> getLayerList();

    boolean isUserStarted();

    void pauseAnimation();

    void removeLayer(AnimatorLayer animatorLayer);

    void resumeAnimation();

    void setAnimationListener(Animator.AnimatorListener animatorListener);

    void startAnimation();

    void stopAnimation();

    void stopAnimation(boolean z16, boolean z17);
}
