package com.tencent.ams.mosaic.jsengine.component.slide;

import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public interface SlideComponent extends GestureComponent {
    void setBottomPadding(float f16);

    void setIconUrl(String str);

    void setInteractListeners(JSObject jSObject);

    void setSubTitle(String str);

    void setSuccessVibrate(boolean z16);

    void setTitle(String str);

    void start();

    void stop();
}
