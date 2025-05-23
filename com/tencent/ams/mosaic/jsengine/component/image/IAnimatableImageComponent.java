package com.tencent.ams.mosaic.jsengine.component.image;

import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public interface IAnimatableImageComponent {
    boolean isAnimatable();

    boolean isRunning();

    void setAnimationCallback(JSFunction jSFunction, JSFunction jSFunction2);

    void setAutoPlay(boolean z16);

    void setRepeatCount(int i3);

    boolean start();

    boolean stop();
}
