package com.tencent.ams.mosaic.jsengine.component.lottie;

import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.component.Component;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public interface LottieComponent extends Component {
    boolean isRunning();

    void setAnimationCallback(JSFunction jSFunction);

    void setAutoPlay(boolean z16);

    void setJsonString(String str);

    void setRepeatCount(int i3);

    void setSrc(String str);

    void start();

    void stop();
}
