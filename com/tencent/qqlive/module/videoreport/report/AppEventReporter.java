package com.tencent.qqlive.module.videoreport.report;

import android.app.Activity;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.IAdditionalReportListener;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.ISessionChangeListener;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.SessionChangeReason;
import com.tencent.qqlive.module.videoreport.appstatus.AppStatusManager;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.qqlive.module.videoreport.detection.DetectInterceptorsMonitor;
import com.tencent.qqlive.module.videoreport.detection.DetectionInterceptors;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTEventDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.time.app.AppForegroundSession;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.PageManager;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.staging.CustomEventStagingManager;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import com.tencent.qqlive.module.videoreport.utils.SPUtils;
import com.tencent.qqlive.module.videoreport.utils.UssnUtils;
import com.tencent.qqlive.module.videoreport.utils.reuse.ReusablePool;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AppEventReporter extends DefaultEventListener {
    private static final int DELAY_CHECK_APP_OUT_INTERVAL = 2000;
    private static final String TAG = "app.AppEventReporter";
    private String mActiveInfo;
    private int mActivityCount;
    private final HashSet<Integer> mActivityHashCode;
    private String mActivityName;
    private boolean mAppForegroundReported;
    private AppForegroundSession mAppForegroundSession;
    private Runnable mAppInReportRunnable;
    private Runnable mAppOutDelayCheckRunnable;
    private long mColdUsStamp;
    private IAdditionalReportListener mEventAdditionalReport;
    private boolean mFirstActivityResumed;
    private boolean mHasVstReport;
    private DetectInterceptorsMonitor mInterceptorMonitor;
    private boolean mIsActive;
    private boolean mIsColdStart;
    private boolean mIsNeedInterceptForegroundSession;
    private long mLastGenerateTime;
    private boolean mLastHeartBeatReport;
    private final ListenerMgr<IAppEventListener> mListenerMgr;
    private boolean mNoForegroundActivity;
    private final HashSet<Integer> mResumeActivityHashCode;
    private int mResumedCount;
    private long mScheduleAppOutStamp;
    private final ListenerMgr<ISessionChangeListener> mSessionChangeListener;
    private String mUsId;
    private long mUsStamp;
    private long mUssn;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface IAppEventListener {
        void onAppIn();

        void onAppOut(boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        private static final AppEventReporter INSTANCE;

        static {
            AppEventReporter appEventReporter = new AppEventReporter();
            INSTANCE = appEventReporter;
            appEventReporter.init();
        }

        InstanceHolder() {
        }
    }

    private void appActivatedDataSender() {
        Log.i(TAG, "appActivatedDataSender(), act report");
        FinalData finalData = getFinalData(EventKey.ACT);
        IEventDynamicParams eventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
        if (eventDynamicParams != null) {
            eventDynamicParams.setEventDynamicParams(EventKey.ACT, finalData.getEventParams());
        }
        FinalDataTarget.handle(null, finalData);
    }

    private void appInDataSender() {
        if (!this.mAppForegroundReported) {
            this.mAppForegroundReported = true;
            ThreadUtils.execTask(this.mAppInReportRunnable, true);
            this.mListenerMgr.startNotify(new ListenerMgr.INotifyCallback<IAppEventListener>() { // from class: com.tencent.qqlive.module.videoreport.report.AppEventReporter.4
                @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
                public void onNotify(IAppEventListener iAppEventListener) {
                    iAppEventListener.onAppIn();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appOutDataSender(boolean z16) {
        if (this.mAppForegroundReported) {
            this.mAppForegroundReported = false;
            this.mNoForegroundActivity = true;
            this.mLastGenerateTime = SystemClock.uptimeMillis();
            Log.i(TAG, "appOutDataSender(), \u540e\u53f0\u4e0a\u62a5");
            stopAppForegroundSession(z16 ? SystemClock.uptimeMillis() - this.mScheduleAppOutStamp : 0L);
            AppStatusManager.getInstance().onAppOut();
            this.mListenerMgr.startNotify(new ListenerMgr.INotifyCallback<IAppEventListener>() { // from class: com.tencent.qqlive.module.videoreport.report.AppEventReporter.5
                @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
                public void onNotify(IAppEventListener iAppEventListener) {
                    iAppEventListener.onAppOut(true);
                }
            });
        }
    }

    private void appStartDataSender(Activity activity) {
        SessionChangeReason sessionChangeReason;
        if (this.mNoForegroundActivity) {
            if (this.mLastGenerateTime != -1 && !isExceedVisitBackgroundTime()) {
                if (isVstAdditionalReport()) {
                    updateAppEventParams(activity);
                    onAppVisit(SessionChangeReason.ADDITIONAL_SESSION_REENTER_FOREGROUND);
                }
            } else {
                if (this.mLastGenerateTime > 0) {
                    sessionChangeReason = SessionChangeReason.REENTER_FOREGROUND_AND_TIMEOUT;
                } else {
                    sessionChangeReason = SessionChangeReason.APP_START_UP;
                }
                updateAppEventParams(activity);
                onAppVisit(sessionChangeReason);
            }
        }
        this.mNoForegroundActivity = false;
        AppStatusManager.getInstance().onAppIn();
        if (!this.mHasVstReport && !interceptAppEvent(activity, "report visit")) {
            updateAppEventParams(activity);
            reportVst(EventKey.VST);
            this.mHasVstReport = true;
        }
    }

    private void calculateAfterResume(final Activity activity) {
        if (this.mResumeActivityHashCode.contains(Integer.valueOf(activity.hashCode()))) {
            Log.i(TAG, "activity: " + activity + " resume has been detected");
            return;
        }
        this.mResumeActivityHashCode.add(Integer.valueOf(activity.hashCode()));
        this.mResumedCount++;
        appStartDataSender(activity);
        appInDataSender();
        CustomEventStagingManager.getInstance().supplementReportsEvent();
        if (!this.mLastHeartBeatReport) {
            this.mLastHeartBeatReport = true;
            reportAppLastHeartBeat();
        }
        ThreadUtils.execTask(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.report.AppEventReporter.3
            @Override // java.lang.Runnable
            public void run() {
                AppEventReporter.this.doActReport(activity);
            }
        });
    }

    private void calculateAfterStarted(Activity activity) {
        if (this.mActivityHashCode.contains(Integer.valueOf(activity.hashCode()))) {
            Log.i(TAG, "activity: " + activity + " started has been detected");
            return;
        }
        this.mActivityCount++;
        this.mActivityHashCode.add(Integer.valueOf(activity.hashCode()));
    }

    private void cancelDelayCheckAppOut() {
        ThreadUtils.removeOnUiThread(this.mAppOutDelayCheckRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void doActReport(Activity activity) {
        if (!this.mFirstActivityResumed) {
            this.mFirstActivityResumed = true;
            this.mIsActive = isDeviceActivated();
        }
        if (this.mIsActive) {
            return;
        }
        if (interceptAppEvent(activity, "report active")) {
            return;
        }
        setDeviceActivated();
        appActivatedDataSender();
        this.mIsActive = true;
    }

    private FinalData getFinalData(String str) {
        FinalData finalData = (FinalData) ReusablePool.obtain(FinalData.class);
        finalData.put(DTParamKey.REPORT_KEY_ACT_NAME, getActivityName());
        finalData.put(DTParamKey.REPORT_KEY_ACT_INFO, getActiveInfo());
        finalData.setEventKey(str);
        return finalData;
    }

    public static AppEventReporter getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        EventCollector.getInstance().registerEventListener(this);
    }

    private boolean interceptAppEvent(Activity activity, String str) {
        boolean ignoreAppEvent = DetectionInterceptors.ignoreAppEvent(activity);
        if (ignoreAppEvent && VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "interceptAppEvent(), activity intercepted, from = " + str + ", activity = " + activity);
        }
        return ignoreAppEvent;
    }

    private boolean isDeviceActivated() {
        if (ReportUtils.getContext() != null) {
            boolean booleanValue = ((Boolean) SPUtils.get(ReportUtils.getContext(), SPUtils.PREF_DEVICE_ACTIVATED, Boolean.FALSE)).booleanValue();
            Log.i(TAG, "isDeviceActivated()," + this.mIsActive);
            return booleanValue;
        }
        return false;
    }

    private boolean isExceedVisitBackgroundTime() {
        if (SystemClock.uptimeMillis() > this.mLastGenerateTime + VideoReportInner.getInstance().getConfiguration().getVisitBackgroundTime()) {
            return true;
        }
        return false;
    }

    private boolean isVstAdditionalReport() {
        IAdditionalReportListener iAdditionalReportListener = this.mEventAdditionalReport;
        if (iAdditionalReportListener != null && iAdditionalReportListener.shouldAdditionalReport(EventKey.ORIGIN_VST)) {
            return true;
        }
        return false;
    }

    private void onAppVisit(SessionChangeReason sessionChangeReason) {
        startNewSession(sessionChangeReason);
        this.mHasVstReport = false;
        PageManager.getInstance().resetPagePath();
        reportVst(EventKey.ORIGIN_VST);
    }

    private void reportAppLastHeartBeat() {
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.report.AppEventReporter.7
            @Override // java.lang.Runnable
            public void run() {
                if (AppEventReporter.this.mAppForegroundSession != null) {
                    AppForegroundSession.reportLastHeartBeat(AppEventReporter.this.mAppForegroundSession.getAppSessionId());
                }
            }
        });
    }

    private void reportVst(String str) {
        Log.i(TAG, "appStartDataSender(), vst report");
        FinalData finalData = getFinalData(str);
        IEventDynamicParams eventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
        if (eventDynamicParams != null) {
            eventDynamicParams.setEventDynamicParams(str, finalData.getEventParams());
        }
        FinalDataTarget.handle(null, finalData);
    }

    private void scheduleDelayCheckAppOut() {
        this.mScheduleAppOutStamp = SystemClock.uptimeMillis();
        ThreadUtils.runOnUiThreadDelay(this.mAppOutDelayCheckRunnable, 2000L);
    }

    private void setDeviceActivated() {
        if (ReportUtils.getContext() != null) {
            SPUtils.put(ReportUtils.getContext(), SPUtils.PREF_DEVICE_ACTIVATED, Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAppForegroundSession() {
        AppForegroundSession appForegroundSession = this.mAppForegroundSession;
        if (appForegroundSession == null) {
            this.mAppForegroundSession = new AppForegroundSession(this.mInterceptorMonitor);
        } else {
            appForegroundSession.reset();
        }
        this.mAppForegroundSession.start();
    }

    private void stopAppForegroundSession(long j3) {
        ThreadUtils.removeOnUiThread(this.mAppInReportRunnable);
        AppForegroundSession appForegroundSession = this.mAppForegroundSession;
        if (appForegroundSession != null) {
            appForegroundSession.stopToReport(j3);
        }
    }

    private void updateAppEventParams(Activity activity) {
        if (DTEventDynamicParams.getInstance().getDTParamProvider() != null) {
            this.mActiveInfo = DTEventDynamicParams.getInstance().getDTParamProvider().getActiveInfo();
        }
        this.mActivityName = getActivityName(activity);
    }

    public String getActiveInfo() {
        return this.mActiveInfo;
    }

    public String getActivityName() {
        return this.mActivityName;
    }

    public long getColdUsStamp() {
        return this.mColdUsStamp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUsId() {
        return this.mUsId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getUsStamp() {
        return this.mUsStamp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getUssn() {
        return this.mUssn;
    }

    public boolean isAppInForeground() {
        return !this.mNoForegroundActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isColdStart() {
        return this.mIsColdStart;
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onActivityCreate(Activity activity) {
        super.onActivityCreate(activity);
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "onActivityCreate(), activity=" + activity);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onActivityDestroyed(Activity activity) {
        super.onActivityDestroyed(activity);
        Log.i(TAG, "onActivityDestroyed(), activity=" + activity);
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onActivityPause(Activity activity) {
        super.onActivityPause(activity);
        Log.i(TAG, "onActivityPause(), activity=" + activity);
        if (!this.mResumeActivityHashCode.remove(Integer.valueOf(activity.hashCode()))) {
            Log.i(TAG, "onActivityPause(), activity does not match\uff0c miss onResume");
        }
        this.mResumedCount--;
        scheduleDelayCheckAppOut();
    }

    public void onActivityPreResume(Activity activity) {
        if (activity != null) {
            Log.i(TAG, "onActivityPreResume(), activity=" + activity);
            calculateAfterResume(activity);
        }
    }

    public void onActivityPreStarted(Activity activity) {
        if (activity != null) {
            Log.i(TAG, "onActivityPreStarted(), activity=" + activity);
            calculateAfterStarted(activity);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onActivityResume(Activity activity) {
        Log.i(TAG, "onActivityResume(), activity=" + activity);
        calculateAfterResume(activity);
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onActivityStarted(Activity activity) {
        Log.i(TAG, "onActivityStarted(), activity=" + activity);
        calculateAfterStarted(activity);
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onActivityStopped(Activity activity) {
        Log.i(TAG, "onActivityStopped(), activity=" + activity);
        if (!this.mActivityHashCode.remove(Integer.valueOf(activity.hashCode()))) {
            String string = activity.getApplicationContext().getString(R.string.f16232204, activity.toString());
            if (VideoReportInner.getInstance().isDebugMode()) {
                Toast.makeText(activity.getApplicationContext(), string, 1).show();
            }
            Log.e(TAG, string);
            return;
        }
        int i3 = this.mActivityCount - 1;
        this.mActivityCount = i3;
        if (i3 <= 0) {
            appOutDataSender();
        }
        cancelDelayCheckAppOut();
    }

    public void register(IAppEventListener iAppEventListener) {
        this.mListenerMgr.register(iAppEventListener);
    }

    public void registerSessionChangeListener(ISessionChangeListener iSessionChangeListener) {
        this.mSessionChangeListener.register(iSessionChangeListener);
    }

    public void setEventAdditionalReport(IAdditionalReportListener iAdditionalReportListener) {
        this.mEventAdditionalReport = iAdditionalReportListener;
    }

    public void startNewSession(final SessionChangeReason sessionChangeReason) {
        boolean z16 = false;
        if (sessionChangeReason == SessionChangeReason.REENTER_FOREGROUND_AND_TIMEOUT && this.mIsNeedInterceptForegroundSession) {
            this.mIsNeedInterceptForegroundSession = false;
            return;
        }
        if (sessionChangeReason == SessionChangeReason.CALL_UP_FROM_OUTER && this.mLastGenerateTime > 0 && isExceedVisitBackgroundTime()) {
            this.mIsNeedInterceptForegroundSession = true;
        }
        SessionChangeReason sessionChangeReason2 = SessionChangeReason.APP_START_UP;
        if (sessionChangeReason == sessionChangeReason2 && !TextUtils.isEmpty(this.mUsId)) {
            return;
        }
        this.mUsId = ReportUtils.generateSessionId();
        this.mUsStamp = System.currentTimeMillis();
        this.mUssn = UssnUtils.generateUssn();
        if (this.mColdUsStamp == -1) {
            this.mColdUsStamp = this.mUsStamp;
        }
        if (sessionChangeReason == sessionChangeReason2) {
            z16 = true;
        }
        this.mIsColdStart = z16;
        this.mSessionChangeListener.startNotify(new ListenerMgr.INotifyCallback<ISessionChangeListener>() { // from class: com.tencent.qqlive.module.videoreport.report.AppEventReporter.6
            @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
            public void onNotify(ISessionChangeListener iSessionChangeListener) {
                iSessionChangeListener.changeSession(sessionChangeReason);
            }
        });
    }

    public void unregister(IAppEventListener iAppEventListener) {
        this.mListenerMgr.unregister(iAppEventListener);
    }

    AppEventReporter() {
        this.mActivityCount = 0;
        this.mResumedCount = 0;
        this.mLastGenerateTime = -1L;
        this.mIsNeedInterceptForegroundSession = false;
        this.mNoForegroundActivity = true;
        this.mFirstActivityResumed = false;
        this.mLastHeartBeatReport = false;
        this.mAppForegroundReported = false;
        this.mIsColdStart = true;
        this.mUsId = "";
        this.mUssn = 0L;
        this.mActivityName = "";
        this.mActiveInfo = "";
        this.mUsStamp = System.currentTimeMillis();
        this.mColdUsStamp = -1L;
        this.mScheduleAppOutStamp = 0L;
        this.mListenerMgr = new ListenerMgr<>();
        this.mSessionChangeListener = new ListenerMgr<>();
        this.mActivityHashCode = new HashSet<>();
        this.mResumeActivityHashCode = new HashSet<>();
        this.mInterceptorMonitor = new DetectInterceptorsMonitor();
        this.mAppInReportRunnable = new Runnable() { // from class: com.tencent.qqlive.module.videoreport.report.AppEventReporter.1
            @Override // java.lang.Runnable
            public void run() {
                if (VideoReportInner.getInstance().isDebugMode()) {
                    Log.d(AppEventReporter.TAG, "appInDataSender(), \u524d\u53f0\u4e0a\u62a5");
                }
                AppEventReporter.this.startAppForegroundSession();
            }
        };
        this.mAppOutDelayCheckRunnable = new Runnable() { // from class: com.tencent.qqlive.module.videoreport.report.AppEventReporter.2
            @Override // java.lang.Runnable
            public void run() {
                if (AppEventReporter.this.mResumedCount == 0) {
                    if (VideoReportInner.getInstance().isDebugMode()) {
                        Log.d(AppEventReporter.TAG, "scheduleDelayCheckAppOut(), \u6ee1\u8db3\u6761\u4ef6\uff0c\u8865\u5145appOut\u4e8b\u4ef6");
                    }
                    AppEventReporter.this.appOutDataSender(true);
                }
            }
        };
    }

    private String getActivityName(Activity activity) {
        return activity == null ? "" : activity.getClass().getCanonicalName();
    }

    public void appOutDataSender() {
        appOutDataSender(false);
    }
}
