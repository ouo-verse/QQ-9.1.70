package com.tencent.ams.mosaic.jsengine.component.halfarcslope;

import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public interface HalfArcSlopeComponent {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface FailReason {
        public static final int NONE = 0;
        public static final int NOT_INTERACTIVE = 1;
        public static final int SLOPE_DO_NOT_REACH_THRESHOLD = 4;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface InteractType {
        public static final int CLICK = 1;
        public static final int TILT = 9;
        public static final int UNKNOWN = 0;
    }

    void notifyAppViewChanged(String str);

    void notifyAppViewVisibilityChanged(String str, boolean z16);

    void setAppViewShowOnTop(String[] strArr);

    void setBigBallCenterYBottomMargin(int i3);

    void setBigBallRadius(int i3);

    void setInteractListeners(JSObject jSObject);

    void setInteractiveTypeArray(int[] iArr);

    void setReverseTitle(String str);

    void setRingCenterYBottomMargin(int i3);

    void setRingRadius(int i3);

    void setSlopeAngle(int i3);

    void setSlopeReverseAngle(int i3);

    void setSubTitle(String str);

    void setTitle(String str);

    void start();

    void stop();
}
