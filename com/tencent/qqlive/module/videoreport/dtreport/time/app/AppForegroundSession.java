package com.tencent.qqlive.module.videoreport.dtreport.time.app;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.qqlive.module.videoreport.constants.ParamKey;
import com.tencent.qqlive.module.videoreport.detection.DetectInterceptorsMonitor;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTEventKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.dtreport.time.base.HeartBeatProcessor;
import com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.AppEventReporter;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.report.PageReportPolicyManager;
import com.tencent.qqlive.module.videoreport.report.PageReporter;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqlive.module.videoreport.task.TimerTaskManager;
import com.tencent.qqlive.module.videoreport.utils.JsonUtils;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import com.tencent.qqlive.module.videoreport.utils.reuse.ReusablePool;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AppForegroundSession implements ITimeProcessor {
    private static final long DEFAULT_HEART_BEAT_INTERVAL = 60000;
    private static final long DEFAULT_TIME_PIN_INTERVAL = 5000;
    private static final long MIN_TIME_PIN_INTERVAL = 5000;
    private String mAppSessionId;
    private long mAppStartTime;
    private HeartBeatProcessor mCurrentHeartBeatProcessor;
    private long mForegroundDuration;
    private String mHeartBeatTaskKey;
    private DetectInterceptorsMonitor mInterceptorMonitor;
    private long mInterceptDuration = 0;
    private int mProcessorState = -1;
    private long mHeartBeatInterval = VideoReportInner.getInstance().getConfiguration().getAppTimeReportHeartBeatInterval() * 1000;
    private long mTimePinInterval = VideoReportInner.getInstance().getConfiguration().getAppTimeReportTimePinInterval() * 1000;

    public AppForegroundSession(DetectInterceptorsMonitor detectInterceptorsMonitor) {
        this.mInterceptorMonitor = detectInterceptorsMonitor;
        initHeartBeatProcessor();
        reset();
    }

    private long getHeartBeatInterval() {
        return this.mHeartBeatInterval;
    }

    private long getTimePinInterval() {
        return this.mTimePinInterval;
    }

    private void initHeartBeatProcessor() {
        if (this.mHeartBeatInterval <= 0) {
            this.mHeartBeatInterval = 60000L;
        }
        if (this.mTimePinInterval <= 0) {
            this.mTimePinInterval = 5000L;
        }
        if (this.mTimePinInterval < 5000) {
            this.mTimePinInterval = 5000L;
        }
        long j3 = this.mTimePinInterval;
        if (j3 > this.mHeartBeatInterval) {
            this.mHeartBeatInterval = j3;
        }
        HeartBeatProcessor heartBeatProcessor = new HeartBeatProcessor(true, j3);
        this.mCurrentHeartBeatProcessor = heartBeatProcessor;
        heartBeatProcessor.setHeartBeatCallback(new HeartBeatProcessor.IHeartBeatCallback() { // from class: com.tencent.qqlive.module.videoreport.dtreport.time.app.AppForegroundSession.2
            @Override // com.tencent.qqlive.module.videoreport.dtreport.time.base.HeartBeatProcessor.IHeartBeatCallback
            public void reportHeartBeat(final String str, long j16, long j17) {
                HashMap hashMap = new HashMap();
                hashMap.put(DTParamKey.REPORT_KEY_APP_SESSIONID, str);
                hashMap.put(DTParamKey.REPORT_KEY_APP_FOREGROUND_HEARTBEAT_DURATION, Long.valueOf(j16));
                AppForegroundSession.reportHeartBeat(hashMap);
                ThreadUtils.execTask(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.dtreport.time.app.AppForegroundSession.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AppHeartBeatSpUtils.removeSessionHeartBeat(str);
                    }
                });
            }

            @Override // com.tencent.qqlive.module.videoreport.dtreport.time.base.HeartBeatProcessor.IHeartBeatCallback
            public void saveHeartBeatInfo(final String str, final long j16, long j17) {
                ThreadUtils.execTask(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.dtreport.time.app.AppForegroundSession.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        HashMap hashMap = new HashMap();
                        hashMap.put(DTParamKey.REPORT_KEY_APP_SESSIONID, str);
                        hashMap.put(DTParamKey.REPORT_KEY_APP_FOREGROUND_HEARTBEAT_DURATION, Long.valueOf(j16));
                        AppHeartBeatSpUtils.saveSessionLastHeartBeat(str, JsonUtils.getJsonFromMap(hashMap));
                    }
                });
            }
        });
    }

    private void reportAppIn() {
        FinalData finalData = (FinalData) ReusablePool.obtain(FinalData.class);
        finalData.setEventKey(EventKey.APP_IN);
        finalData.put(DTParamKey.REPORT_KEY_APP_STARTTIME, Long.valueOf(System.currentTimeMillis()));
        finalData.put(DTParamKey.REPORT_KEY_SYS_ELAPSED_REALTIME, Long.valueOf(SystemClock.elapsedRealtime()));
        finalData.put(DTParamKey.REPORT_KEY_APP_HEARTBEAT_INTERVAL, Long.valueOf(getHeartBeatInterval() / 1000));
        finalData.put(DTParamKey.REPORT_KEY_APP_FILE_INTERVAL, Long.valueOf(getTimePinInterval() / 1000));
        finalData.put(DTParamKey.REPORT_KEY_APP_SESSIONID, getAppSessionId());
        finalData.put(DTParamKey.REPORT_KEY_ACT_NAME, AppEventReporter.getInstance().getActivityName());
        finalData.put(DTParamKey.REPORT_KEY_ACT_INFO, AppEventReporter.getInstance().getActiveInfo());
        IEventDynamicParams eventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
        if (eventDynamicParams != null) {
            eventDynamicParams.setEventDynamicParams(EventKey.APP_IN, finalData.getEventParams());
        }
        FinalDataTarget.handle(null, finalData);
    }

    private void reportAppOut(long j3) {
        long uptimeMillis = (SystemClock.uptimeMillis() - this.mAppStartTime) - j3;
        long interceptDuration = (uptimeMillis - this.mInterceptorMonitor.getInterceptDuration()) + this.mInterceptDuration;
        this.mInterceptorMonitor.onAppOut(false);
        String interceptActivities = this.mInterceptorMonitor.getInterceptActivities();
        this.mInterceptorMonitor.clearInterceptActivities();
        FinalData finalData = (FinalData) ReusablePool.obtain(FinalData.class);
        finalData.setEventKey(EventKey.APP_OUT);
        finalData.put(ParamKey.REPORT_KEY_LVTM, Long.valueOf(uptimeMillis));
        finalData.put(DTParamKey.REPORT_KEY_WHITE_LVTM, Long.valueOf(interceptDuration));
        finalData.put(DTParamKey.REPORT_KEY_ACTIVITY_BLACKLIST, interceptActivities);
        finalData.put(DTParamKey.REPORT_KEY_LVTM_DELTA, Long.valueOf(j3));
        finalData.put(DTParamKey.REPORT_KEY_APP_STOPTIME, Long.valueOf(System.currentTimeMillis() - j3));
        finalData.put(DTParamKey.REPORT_KEY_SYS_ELAPSED_REALTIME, Long.valueOf(SystemClock.elapsedRealtime() - j3));
        finalData.put(DTParamKey.REPORT_KEY_APP_SESSIONID, getAppSessionId());
        finalData.put(DTParamKey.REPORT_KEY_PAGE_LIST, PageReportPolicyManager.getSkipPageInfo());
        finalData.put("cur_pg", PageReporter.getInstance().getCurPageReportInfo(EventKey.APP_OUT));
        finalData.put(DTParamKey.REPORT_KEY_ACT_NAME, AppEventReporter.getInstance().getActivityName());
        finalData.put(DTParamKey.REPORT_KEY_ACT_INFO, AppEventReporter.getInstance().getActiveInfo());
        IEventDynamicParams eventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
        if (eventDynamicParams != null) {
            eventDynamicParams.setEventDynamicParams(EventKey.APP_OUT, finalData.getEventParams());
        }
        FinalDataTarget.handleInMainThread(null, finalData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportHeartBeat(Map<String, Object> map) {
        FinalData finalData = (FinalData) ReusablePool.obtain(FinalData.class);
        finalData.setEventKey(DTEventKey.APP_HEARTBEAT);
        finalData.putAll(map);
        IEventDynamicParams eventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
        if (eventDynamicParams != null) {
            eventDynamicParams.setEventDynamicParams(DTEventKey.APP_HEARTBEAT, finalData.getEventParams());
        }
        FinalDataTarget.handle(null, finalData);
    }

    public static void reportLastHeartBeat(final String str) {
        ThreadUtils.execTask(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.dtreport.time.app.AppForegroundSession.3
            @Override // java.lang.Runnable
            public void run() {
                Map<String, Object> mapForJson;
                Map<String, Object> lastHeartBeatMap = AppHeartBeatSpUtils.getLastHeartBeatMap();
                if (lastHeartBeatMap == null) {
                    return;
                }
                if (lastHeartBeatMap.containsKey(str)) {
                    HashMap hashMap = new HashMap();
                    String str2 = str;
                    hashMap.put(str2, lastHeartBeatMap.remove(str2));
                    AppHeartBeatSpUtils.saveSessionLastHeartBeat(hashMap);
                } else {
                    AppHeartBeatSpUtils.clearSessionHeartBeat();
                }
                for (Map.Entry<String, Object> entry : lastHeartBeatMap.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        String valueOf = String.valueOf(entry.getValue());
                        if (!TextUtils.isEmpty(valueOf) && (mapForJson = JsonUtils.getMapForJson(valueOf)) != null && !key.equals(str)) {
                            AppForegroundSession.reportHeartBeat(mapForJson);
                        }
                    }
                }
            }
        });
    }

    private void stopToReport() {
        stopToReport(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void triggerTiming() {
        this.mCurrentHeartBeatProcessor.stop();
        this.mForegroundDuration += this.mCurrentHeartBeatProcessor.getForegroundDuration();
        this.mCurrentHeartBeatProcessor.reset();
        if (this.mProcessorState == 0) {
            this.mCurrentHeartBeatProcessor.start();
        }
    }

    public String getAppSessionId() {
        return this.mAppSessionId;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor
    public synchronized long getBackgroundDuration() {
        return 0L;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor
    public synchronized long getForegroundDuration() {
        return this.mForegroundDuration;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor
    public synchronized void reset() {
        if (this.mProcessorState == 0) {
            stopToReport();
        }
        this.mProcessorState = -1;
        this.mAppSessionId = ReportUtils.generateSessionId();
        this.mForegroundDuration = 0L;
        this.mHeartBeatTaskKey = null;
        this.mCurrentHeartBeatProcessor.reset();
        this.mCurrentHeartBeatProcessor.setSessionId(this.mAppSessionId);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor
    public synchronized void setInForeground(boolean z16) {
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor
    public synchronized void start() {
        if (this.mProcessorState == 0) {
            stopToReport();
        }
        this.mProcessorState = 0;
        this.mAppStartTime = SystemClock.uptimeMillis();
        this.mInterceptorMonitor.onAppIn();
        this.mInterceptDuration = this.mInterceptorMonitor.getInterceptDuration();
        TimerTaskManager timerTaskManager = TimerTaskManager.getInstance();
        Runnable runnable = new Runnable() { // from class: com.tencent.qqlive.module.videoreport.dtreport.time.app.AppForegroundSession.1
            @Override // java.lang.Runnable
            public void run() {
                AppForegroundSession.this.triggerTiming();
            }
        };
        long j3 = this.mHeartBeatInterval;
        this.mHeartBeatTaskKey = timerTaskManager.addUIThreadTimerTask(runnable, j3, j3);
        this.mCurrentHeartBeatProcessor.start();
        reportAppIn();
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor
    public synchronized void stop() {
        if (this.mProcessorState == 0) {
            this.mProcessorState = 1;
            TimerTaskManager.getInstance().cancelTimerTask(this.mHeartBeatTaskKey);
            this.mHeartBeatTaskKey = null;
            triggerTiming();
        }
    }

    public synchronized void stopToReport(long j3) {
        if (this.mProcessorState == 0) {
            stop();
            reportAppOut(j3);
        }
    }
}
