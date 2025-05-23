package com.tencent.ams.mosaic.jsengine.animation.group;

import com.tencent.ams.mosaic.jsengine.animation.Animation;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.annotation.JSMethod;
import com.tencent.ams.mosaic.jsengine.annotation.MethodScope;

/* compiled from: P */
@JSAgent(methodScope = MethodScope.SPECIFIED)
/* loaded from: classes3.dex */
public interface GroupAnimation extends Animation {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface PlayBackOrder {
        public static final String PARALLEL = "Parallel";
        public static final String SERIAL = "Serial";
    }

    @JSMethod
    void addAnimation(Animation animation);

    @JSMethod
    void setAnimGroup(Animation[] animationArr);

    @JSMethod
    void setPlayBackOrder(@PlayBackOrder String str);
}
