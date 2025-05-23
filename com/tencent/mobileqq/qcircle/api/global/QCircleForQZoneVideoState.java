package com.tencent.mobileqq.qcircle.api.global;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleForQZoneVideoState {
    private static int sCurrentFeedPos = 0;
    private static boolean sIsDisallowInterceptEvent = false;
    private static boolean sIsMixMode = false;

    public static int getCurrentFeedPos() {
        return sCurrentFeedPos;
    }

    public static boolean isDisallowInterceptEvent() {
        return sIsDisallowInterceptEvent;
    }

    public static boolean isMixMode() {
        return sIsMixMode;
    }

    public static void setCurrentFeedPos(int i3) {
        sCurrentFeedPos = i3;
    }

    public static void setIsDisallowInterceptEvent(boolean z16) {
        sIsDisallowInterceptEvent = z16;
    }

    public static void setIsMixMode(boolean z16) {
        sIsMixMode = z16;
    }
}
