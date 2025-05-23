package com.tencent.mobileqq.qcircle.api.animation;

import com.tencent.biz.richframework.animation.drawable.AnimationDrawableCreateOption;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleAnimationHelper {
    public static AnimationDrawableCreateOption.Builder getDefaultBuilder(String str) {
        return new AnimationDrawableCreateOption.Builder(str, QCircleAnimationConfig.getDefaultAnimationStrategy());
    }
}
