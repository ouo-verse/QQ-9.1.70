package com.tencent.ams.fusion.widget.flipcard;

import android.graphics.Point;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface FlipCardInteractiveListener {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface FailReason {
        public static final int CLICK_DO_NOT_IN_CARD = 5;
        public static final int NONE = 0;
        public static final int NOT_INTERACTIVE = 1;
        public static final int SLIDE_DO_NOT_IN_HOTAREA = 3;
        public static final int SLIDE_DO_NOT_REACH_THRESHOLD = 2;
        public static final int SLOPE_DO_NOT_REACH_THRESHOLD = 4;
    }

    void onBackInteractProgress(float f16);

    void onEndAnimationFinish();

    void onEndAnimationStart();

    void onInteractFinish(int i3, boolean z16, Point point);

    void onInteractProgress(float f16);

    void onInteractResult(int i3, boolean z16, @FailReason int i16, Point point, float f16);

    void onInteractStart(int i3, Point point);

    void onSensorError();
}
