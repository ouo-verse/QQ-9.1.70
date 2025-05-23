package com.tencent.qqlive.module.videoreport.detection;

import android.app.Activity;
import android.os.SystemClock;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.time.app.AppForegroundInterceptActivities;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.AppEventReporter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DetectInterceptorsMonitor extends DefaultEventListener implements AppEventReporter.IAppEventListener {
    private static final String TAG = "DetectInterceptorsMonitor";
    private String mCurrentActivityStr;
    private boolean mIsForeground;
    private long mInterceptDuration = 0;
    private long mStartTime = 0;
    private ActivityInterceptStateMachine mInterceptState = new ActivityInterceptStateMachine();
    private AppForegroundInterceptActivities mInterceptActivities = new AppForegroundInterceptActivities();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    @interface ActivityInterceptState {
        public static final int CONTINUOUS_INTERCEPT = 1;
        public static final int FIRST_INTERCEPT = 2;
        public static final int NON_INTERCEPT = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class ActivityInterceptStateMachine {
        private boolean mIsActivityIntercept;
        private boolean mIsLastActivityIntercept;

        @ActivityInterceptState
        private int mState = 0;

        ActivityInterceptStateMachine() {
        }

        @ActivityInterceptState
        public int getState() {
            return this.mState;
        }

        public boolean isIntercept() {
            if (this.mState != 0) {
                return true;
            }
            return false;
        }

        public void onActivityPause(Activity activity) {
            this.mIsLastActivityIntercept = this.mIsActivityIntercept;
        }

        public void onActivityResume(Activity activity) {
            boolean ignoreAppEvent = DetectionInterceptors.ignoreAppEvent(activity);
            this.mIsActivityIntercept = ignoreAppEvent;
            if (!ignoreAppEvent) {
                this.mState = 0;
            } else if (!this.mIsLastActivityIntercept) {
                this.mState = 2;
            } else {
                this.mState = 1;
            }
        }

        public void onAppOut() {
            this.mIsLastActivityIntercept = false;
        }
    }

    public DetectInterceptorsMonitor() {
        init();
    }

    private void init() {
        EventCollector.getInstance().registerEventListener(this);
    }

    private void resetMonitorTime() {
        this.mStartTime = SystemClock.uptimeMillis();
    }

    public void clearInterceptActivities() {
        this.mInterceptActivities.clear();
    }

    public String getInterceptActivities() {
        return this.mInterceptActivities.get();
    }

    public long getInterceptDuration() {
        triggerTiming("inquire");
        return this.mInterceptDuration;
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onActivityPause(Activity activity) {
        triggerTiming("activity pause: " + this.mCurrentActivityStr);
        this.mInterceptState.onActivityPause(activity);
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onActivityResume(Activity activity) {
        this.mCurrentActivityStr = activity.getClass().getCanonicalName();
        this.mInterceptState.onActivityResume(activity);
        if (this.mInterceptState.isIntercept()) {
            if (2 == this.mInterceptState.getState()) {
                resetMonitorTime();
            }
            this.mInterceptActivities.onIntercept(activity);
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.d(TAG, "Intercept duration start timing: " + this.mCurrentActivityStr);
            }
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.report.AppEventReporter.IAppEventListener
    public void onAppIn() {
        this.mIsForeground = true;
        resetMonitorTime();
    }

    @Override // com.tencent.qqlive.module.videoreport.report.AppEventReporter.IAppEventListener
    public void onAppOut(boolean z16) {
        triggerTiming("app out");
        this.mInterceptState.onAppOut();
        this.mIsForeground = false;
    }

    synchronized void triggerTiming(String str) {
        if (!this.mIsForeground) {
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.d(TAG, "Interrupt intercept duration updating for app is background now, from: " + str);
            }
            return;
        }
        if (!this.mInterceptState.isIntercept()) {
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.d(TAG, "Interrupt intercept duration updating for activity not intercept, Activity: " + this.mCurrentActivityStr + ", from: " + str);
            }
            return;
        }
        this.mInterceptDuration += SystemClock.uptimeMillis() - this.mStartTime;
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "Intercept duration update: " + this.mInterceptDuration + ", from: " + str);
        }
        resetMonitorTime();
    }
}
