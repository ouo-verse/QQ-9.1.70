package com.tencent.qqmini.sdk.report;

import android.os.SystemClock;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

/* loaded from: classes23.dex */
public class MiniAppPrelaunchRecorder {
    private static final String TAG = "MiniAppPrelaunchRecorder";
    private static volatile MiniAppPrelaunchRecorder sInstance;
    private volatile boolean mIsCheckinColdStart = true;
    private volatile long mOnFlutterTaskDoneTime;
    private volatile long mOnMiniAppStartTime;
    private volatile boolean mOnPrelaunch;

    MiniAppPrelaunchRecorder() {
        reset();
    }

    public static MiniAppPrelaunchRecorder get() {
        if (sInstance == null) {
            synchronized (MiniAppPrelaunchRecorder.class) {
                if (sInstance == null) {
                    sInstance = new MiniAppPrelaunchRecorder();
                }
            }
        }
        return sInstance;
    }

    public static void release() {
        sInstance = null;
    }

    private void reset() {
        this.mOnPrelaunch = false;
        this.mOnFlutterTaskDoneTime = 0L;
        this.mOnMiniAppStartTime = 0L;
    }

    public boolean isCheckinColdStart() {
        boolean z16 = this.mIsCheckinColdStart;
        if (z16) {
            this.mIsCheckinColdStart = false;
        }
        return z16;
    }

    public boolean isPrelaunchSuccess() {
        boolean z16;
        if (this.mOnPrelaunch && this.mOnFlutterTaskDoneTime > 0 && this.mOnMiniAppStartTime > 0 && this.mOnMiniAppStartTime > this.mOnFlutterTaskDoneTime) {
            z16 = true;
        } else {
            z16 = false;
        }
        reset();
        if (QMLog.isColorLevel()) {
            QMLog.i(TAG, "isPrelaunchSuccess " + z16);
        }
        return z16;
    }

    public void onFlutterTaskDone() {
        if (this.mOnPrelaunch) {
            this.mOnFlutterTaskDoneTime = SystemClock.elapsedRealtime();
            if (QMLog.isColorLevel()) {
                QMLog.i(TAG, "onFlutterTaskDone");
            }
        }
    }

    public void onMiniAppStart(String str) {
        if ("1108164955".equals(str) && this.mOnPrelaunch) {
            this.mOnMiniAppStartTime = SystemClock.elapsedRealtime();
            if (QMLog.isColorLevel()) {
                QMLog.i(TAG, "onMiniAppStart");
            }
        }
    }

    public void onPrelaunch(String str) {
        if (!"1108164955".equals(str)) {
            return;
        }
        this.mOnPrelaunch = true;
        if (QMLog.isColorLevel()) {
            QMLog.i(TAG, "onPrelaunch");
        }
    }
}
