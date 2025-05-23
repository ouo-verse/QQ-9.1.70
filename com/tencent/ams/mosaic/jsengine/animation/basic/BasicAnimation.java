package com.tencent.ams.mosaic.jsengine.animation.basic;

import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.jsengine.animation.Animation;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.annotation.JSMethod;
import com.tencent.ams.mosaic.jsengine.annotation.MethodScope;

/* compiled from: P */
@JSAgent(methodScope = MethodScope.SPECIFIED)
/* loaded from: classes3.dex */
public interface BasicAnimation extends Animation {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface KeyPath {
        public static final String BACKGROUND_COLOR = "backgroundColor";
        public static final String OPACITY = "opacity";
        public static final String POSITION = "position";
        public static final String ROTATION = "rotation";
        public static final String ROTATION_X = "rotationX";
        public static final String ROTATION_Y = "rotationY";
        public static final String SCALE = "scale";
        public static final String SCALE_X = "scaleX";
        public static final String SCALE_Y = "scaleY";
        public static final String TEXT_COLOR = "textColor";
    }

    @JSMethod
    void setAnimationParams(@KeyPath String str, JSObject jSObject, JSObject jSObject2);
}
