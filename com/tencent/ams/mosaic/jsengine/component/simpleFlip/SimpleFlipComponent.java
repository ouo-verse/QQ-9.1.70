package com.tencent.ams.mosaic.jsengine.component.simpleFlip;

import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public interface SimpleFlipComponent {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface InteractStatus {
        public static final int PROGRESS = 2;
        public static final int START = 1;
        public static final int SUCCESS = 3;
    }

    void setBottomPadding(float f16);

    void setFlipAngle(int i3);

    void setGestureClickHotArea(int i3, int i16, int i17, int i18);

    void setHotAreaClickListener(JSFunction jSFunction);

    void setInteractListener(JSFunction jSFunction);

    void setReverseAngle(int i3);

    void setSubTitle(String str);

    void setSuccessVibrate(boolean z16);

    void setTitle(String str);

    void start();

    void stop();
}
