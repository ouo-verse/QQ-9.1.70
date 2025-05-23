package com.tencent.ams.mosaic.jsengine.animation.custom;

import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.jsengine.animation.Animation;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.annotation.JSMethod;
import com.tencent.ams.mosaic.jsengine.annotation.MethodScope;

/* compiled from: P */
@JSAgent(methodScope = MethodScope.SPECIFIED)
/* loaded from: classes3.dex */
public interface CustomAnimation extends Animation {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface KeyPath {
        public static final String COLOR_FILTER = "colorFilter";
        public static final String MASK_COLOR = "maskColor";
    }

    @JSMethod
    void setAnimationParams(@KeyPath String str, JSObject jSObject, JSObject jSObject2);
}
