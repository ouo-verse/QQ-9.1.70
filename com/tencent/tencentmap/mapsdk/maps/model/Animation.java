package com.tencent.tencentmap.mapsdk.maps.model;

import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface Animation {
    AnimationListener getAnimationListener();

    long getDuration();

    Interpolator getInterpolator();

    void setAnimationListener(AnimationListener animationListener);

    void setDuration(long j3);

    void setInterpolator(Interpolator interpolator);
}
