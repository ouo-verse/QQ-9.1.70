package com.tencent.component.animation.rebound;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface SpringListener {
    void onSpringActivate(Spring spring);

    void onSpringAtRest(Spring spring);

    void onSpringEndStateChange(Spring spring);

    void onSpringUpdate(Spring spring);
}
