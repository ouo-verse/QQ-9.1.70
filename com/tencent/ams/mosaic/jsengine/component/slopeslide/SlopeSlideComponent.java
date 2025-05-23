package com.tencent.ams.mosaic.jsengine.component.slopeslide;

import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public interface SlopeSlideComponent extends GestureComponent {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface InteractType {
        public static final int CLICK = 1;
        public static final int SLIDE = 2;
        public static final int SLOPE = 3;
        public static final int UNKNOWN = 0;
    }

    void setBottomPadding(float f16);

    void setEnableShowBgShadow(boolean z16);

    void setFreeModeClickListener(JSFunction jSFunction);

    void setIconData(String str);

    void setIconUrl(String str);

    void setInteractListeners(JSObject jSObject);

    void setInteractiveType(int i3);

    void setReverseAngle(float f16);

    void setReverseTitle(String str);

    void setRewardDisplayType(int i3);

    void setRewardIconUrl(String str);

    void setRewardSubTitle(String str);

    void setRewardThemeColor(String str);

    void setRewardTitle(String str);

    void setSlopeAngle(float f16);

    void setSubTitle(String str);

    void setSuccessVibrate(boolean z16);

    void setTextBottomMargin(float f16);

    void setTitle(String str);

    void start();

    void stop();
}
