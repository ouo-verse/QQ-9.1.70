package com.tencent.ams.mosaic.jsengine.animation;

import com.tencent.ams.mosaic.jsengine.animation.Animation;
import com.tencent.ams.mosaic.jsengine.animation.timefunction.TimingFunction;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
interface IAnimationFactory {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface AnimationType {
        public static final String BASIC = "Basic";
        public static final String CUSTOM = "Custom";
        public static final String FRAME = "Frame";

        /* renamed from: GROUP, reason: collision with root package name */
        public static final String f70702GROUP = "Group";
    }

    Animation createAnimation(@AnimationType String str);

    TimingFunction createTimingFunction(@Animation.TimingFunctionName String str, float[] fArr);
}
