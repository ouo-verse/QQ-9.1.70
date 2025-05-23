package com.tencent.ams.mosaic.jsengine.animation;

import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.annotation.JSMethod;
import com.tencent.ams.mosaic.jsengine.annotation.MethodScope;

@JSAgent(methodScope = MethodScope.SPECIFIED)
/* loaded from: classes3.dex */
public interface AnimationProperty {
    @JSMethod
    void setOpacity(float f16);

    @JSMethod
    void setPosition(float f16, float f17);

    @JSMethod
    void setPositionOffset(float f16, float f17);

    @JSMethod
    void setRotation(float f16);

    @JSMethod
    void setScale(float f16);
}
