package com.tencent.ams.mosaic.jsengine.animation;

import android.animation.Animator;
import androidx.annotation.NonNull;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.jsengine.animation.layer.Layer;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.annotation.JSMethod;
import com.tencent.ams.mosaic.jsengine.annotation.MethodScope;
import com.tencent.ams.mosaic.jsengine.component.Component;

/* compiled from: P */
@JSAgent(methodScope = MethodScope.SPECIFIED)
/* loaded from: classes3.dex */
public interface Animation {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface TimingFunctionName {
        public static final String BEZIER_PATH = "BezierPath";
        public static final String EASE_IN = "EaseIn";
        public static final String EASE_IN_EASE_OUT = "EaseInEaseOut";
        public static final String EASE_OUT = "EaseOut";
        public static final String LINEAR = "Linear";
    }

    @JSMethod
    String getAnimID();

    Object getAnimator(@NonNull Layer layer);

    Animator getSystemAnimator(@NonNull Component component);

    void onAnimationStart(Layer layer);

    @JSMethod
    void setAnimID(String str);

    @JSMethod
    void setAnimStartListener(JSFunction jSFunction);

    @JSMethod
    void setAnimStopListener(JSFunction jSFunction);

    @JSMethod
    void setAutoReverses(boolean z16);

    @JSMethod
    void setBeginTime(float f16);

    @JSMethod
    void setDuration(float f16);

    @JSMethod
    void setFillMode(String str);

    @JSMethod
    void setRepeatCount(int i3);

    @JSMethod
    void setRepeatDuration(float f16);

    @JSMethod
    void setTimingFunction(@TimingFunctionName String str, float[] fArr);
}
