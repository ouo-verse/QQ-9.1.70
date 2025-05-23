package com.tencent.ams.mosaic.jsengine.component.scratch;

import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public interface ScratchCardComponent extends GestureComponent {
    void setBottomPadding(float f16);

    void setGuideAnimationTimeMillis(int i3);

    void setGuideStrokeWidth(int i3);

    void setInteractListeners(JSObject jSObject);

    void setRewardDisplayType(int i3);

    void setRewardSubTitle(String str);

    void setRewardTitle(String str);

    void setSmallCardBackgroundUrl(String str);

    void setSmallCardIconUrl(String str);

    void setSubTitle(String str);

    void setSuccessVibrate(boolean z16);

    void setTextBottomMargin(float f16);

    void setTitle(String str);

    void start();

    void stop();
}
