package com.tencent.ams.mosaic.jsengine.animation.frame;

import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.jsengine.animation.Animation;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.annotation.JSMethod;
import com.tencent.ams.mosaic.jsengine.annotation.MethodScope;

/* compiled from: P */
@JSAgent(methodScope = MethodScope.SPECIFIED)
/* loaded from: classes3.dex */
public interface FrameAnimation extends Animation {
    @JSMethod
    void setFrameProgressListener(JSFunction jSFunction);

    @JSMethod
    void setFrameRate(int i3);
}
