package com.tencent.mobileqq.qcircle.api.animation;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleAnimationConfig {
    private static QCircleDefaultAnimationStrategy sDefaultAnimationStrategy;

    public static QCircleDefaultAnimationStrategy getDefaultAnimationStrategy() {
        if (sDefaultAnimationStrategy == null) {
            sDefaultAnimationStrategy = new QCircleDefaultAnimationStrategy();
        }
        return sDefaultAnimationStrategy;
    }
}
