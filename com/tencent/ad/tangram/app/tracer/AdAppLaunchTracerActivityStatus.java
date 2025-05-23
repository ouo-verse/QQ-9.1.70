package com.tencent.ad.tangram.app.tracer;

import com.tencent.biz.common.util.WebViewConstants;

/* compiled from: P */
/* loaded from: classes3.dex */
final class AdAppLaunchTracerActivityStatus {
    public static final int ON_ACTIVITY_PAUSED = 3;
    public static final int ON_ACTIVITY_RESULT = 5;
    public static final int ON_ACTIVITY_RESUMED = 2;
    public static final int ON_ACTIVITY_STARTED = 1;
    public static final int ON_ACTIVITY_STOPPED = 4;
    public static final int ON_TOP_RESUMED_ACTIVITY_CHANGED_NOT_ON_TOP = 7;
    public static final int ON_TOP_RESUMED_ACTIVITY_CHANGED_ON_TOP = 6;
    public static final int UNKNOWN = 0;
    public int mStatus;
    public long mTimeMillis;

    public AdAppLaunchTracerActivityStatus(int i3) {
        this.mTimeMillis = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        this.mStatus = i3;
        this.mTimeMillis = System.currentTimeMillis();
    }

    public int getStatus() {
        return this.mStatus;
    }

    public long getTimeMillis() {
        return this.mTimeMillis;
    }

    public String toString() {
        switch (this.mStatus) {
            case 1:
                return "onActivityStarted";
            case 2:
                return "onActivityResumed";
            case 3:
                return "onActivityPaused";
            case 4:
                return "onActivityStopped";
            case 5:
                return "onActivityResult";
            case 6:
                return "onTopResumedActivityChanged_OnTop";
            case 7:
                return "onTopResumedActivityChanged_NotOnTop";
            default:
                return "unknown";
        }
    }
}
