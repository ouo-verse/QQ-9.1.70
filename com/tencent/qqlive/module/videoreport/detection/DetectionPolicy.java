package com.tencent.qqlive.module.videoreport.detection;

import android.app.Activity;
import com.tencent.qqlive.module.videoreport.DetectionMode;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;

/* loaded from: classes22.dex */
public class DetectionPolicy {
    private static final String TAG = "DetectionPolicy";

    @DetectionMode
    private static int sCurrentMode;
    private static DefaultPolicy sDefaultPolicy;
    private static IDetectionPolicy sDetectionImpl;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class BlacklistPolicyHolder {
        private static BlacklistPolicy sBlacklistPolicy = new BlacklistPolicy();

        BlacklistPolicyHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class WhitelistPolicyHolder {
        private static WhitelistPolicy sWhitelistPolicy = new WhitelistPolicy();

        WhitelistPolicyHolder() {
        }
    }

    static {
        DefaultPolicy defaultPolicy = new DefaultPolicy();
        sDefaultPolicy = defaultPolicy;
        sCurrentMode = 0;
        sDetectionImpl = defaultPolicy;
    }

    public static void addBlacklist(Activity activity) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            if (activity != null) {
                Log.i(TAG, "addBlacklist: activity = " + activity.getLocalClassName());
            }
            if (sCurrentMode != 1) {
                Log.e(TAG, "addBlacklist: currentMode = " + sCurrentMode + " is not BLACKLIST");
            }
        }
        BlacklistPolicyHolder.sBlacklistPolicy.addBlacklist(activity);
    }

    public static void addWhitelist(Activity activity) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            if (activity != null) {
                Log.i(TAG, "addWhitelist: activity = " + activity.getLocalClassName());
            }
            if (sCurrentMode != 2) {
                Log.e(TAG, "addBlacklist: currentMode = " + sCurrentMode + " is not WHITELIST");
            }
        }
        WhitelistPolicyHolder.sWhitelistPolicy.addWhitelist(activity);
    }

    public static boolean isAbleToDetect(Activity activity) {
        return sDetectionImpl.isAbleToDetect(activity);
    }

    public static void setDetectionMode(@DetectionMode int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                sCurrentMode = 0;
                sDetectionImpl = sDefaultPolicy;
                return;
            } else {
                sCurrentMode = 2;
                sDetectionImpl = WhitelistPolicyHolder.sWhitelistPolicy;
                return;
            }
        }
        sCurrentMode = 1;
        sDetectionImpl = BlacklistPolicyHolder.sBlacklistPolicy;
    }
}
