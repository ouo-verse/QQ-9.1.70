package com.tencent.ad.tangram.app.tracer;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdAppLaunchTracerResult {
    public static final int LAUNCH_FAILED = 2;
    public static final int LAUNCH_FAILED_WITH_CONFIRMATION = 4;
    public static final int LAUNCH_SUCCESS = 1;
    public static final int LAUNCH_SUCCESS_WITH_CONFIRMATION = 3;
    private static final String TAG = "AdAppLaunchTracerResult";
    public static final int UNKNOWN = 0;
    private int mAction;
    private int mError;

    public AdAppLaunchTracerResult(int i3, int i16) {
        this.mError = i3;
        this.mAction = i16;
    }

    private static String getActionMessage(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return "UNKNOWN";
                    }
                    return "LAUNCH_FAILED_WITH_CONFIRMATION";
                }
                return "LAUNCH_SUCCESS_WITH_CONFIRMATION";
            }
            return "LAUNCH_FAILED";
        }
        return "LAUNCH_SUCCESS";
    }

    public int getAction() {
        return this.mAction;
    }

    public int getError() {
        return this.mError;
    }

    public boolean isSuccess() {
        if (this.mError == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "AdAppLaunchTracerResult(error=" + this.mError + ", action=" + getActionMessage(this.mAction) + ", )";
    }
}
