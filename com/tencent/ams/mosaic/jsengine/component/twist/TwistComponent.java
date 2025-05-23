package com.tencent.ams.mosaic.jsengine.component.twist;

import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public interface TwistComponent {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface InteractStatus {
        public static final int PROGRESS = 2;
        public static final int START = 1;
        public static final int SUCCESS = 3;
    }

    void setBottomPadding(float f16);

    void setEnableShowBgShadow(boolean z16);

    void setFreeModeClickListener(JSFunction jSFunction);

    void setInteractListener(JSFunction jSFunction);

    void setReverseAngle(int i3);

    void setRewardDisplayType(int i3);

    void setRewardIconUrl(String str);

    void setRewardSubTitle(String str);

    void setRewardThemeColor(String str);

    void setRewardTitle(String str);

    void setSubTitle(String str);

    void setSuccessVibrate(boolean z16);

    void setTextBottomMargin(float f16);

    void setTitle(String str);

    void setTwistAngle(int i3);

    void setTwistDirection(int i3);

    void start();

    void stop();
}
