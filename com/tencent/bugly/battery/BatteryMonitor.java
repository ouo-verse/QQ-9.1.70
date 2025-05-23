package com.tencent.bugly.battery;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.WorkSource;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.tencent.bugly.battery.data.AlarmInfo;
import com.tencent.bugly.battery.data.BaseBatteryInfo;
import com.tencent.bugly.battery.data.LocationInfo;
import com.tencent.bugly.battery.data.WakeLockInfo;
import com.tencent.bugly.battery.hook.AlarmManagerServiceHooker;
import com.tencent.bugly.battery.hook.LocationManagerServiceHooker;
import com.tencent.bugly.battery.hook.PowerManagerServiceHooker;
import com.tencent.bugly.battery.stats.AlarmStatsImpl;
import com.tencent.bugly.battery.stats.LocationStatsImpl;
import com.tencent.bugly.battery.stats.WakeLockStatsImpl;
import com.tencent.bugly.common.hotpatch.HotPatchWrapper;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.bugly.common.trace.TraceGenerator;
import com.tencent.bugly.common.utils.ContextUtil;
import com.tencent.bugly.common.utils.cpu.ProcessCpuTracker;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.data.d;
import com.tencent.rmonitor.base.db.e;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import com.tencent.rmonitor.common.lifecycle.b;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.a;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BatteryMonitor implements b {
    private static final int APP_STATE_BACKGROUND = 2;
    private static final int APP_STATE_FOREGROUND = 1;
    private static final int BATTERY_CHECK_MESSAGE = 1;
    private static final long CHECK_DELAY = 60000;
    public static final long EXCEPTION_CHECK_THRESHOLD = 600000;
    private static final String TAG = "BatteryMonitor";
    private final AlarmManagerServiceHooker.IListener alarmListener;
    private final AlarmStatsImpl alarmNodeManager;
    private final BatteryElementMetricItem batteryElementMetricItem;
    private int currentAppState;
    private boolean enableElementMetricMonitor;
    private boolean enableElementMonitor;
    private final Handler handler;
    private long lastAppStateUpdateTime;
    private long lastExceptionReportTime;
    private final LocationManagerServiceHooker.IListener locationListener;
    private final LocationStatsImpl locationNodeManager;
    private ReportData mReportData;
    private final PowerManagerServiceHooker.IListener powerListener;
    private final ProcessCpuTracker processCpuTracker;
    private e reportDataCacheMng;
    private final AtomicBoolean started;
    private final WakeLockStatsImpl wakeLockNodeManager;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class SInstanceHolder {
        public static final BatteryMonitor INSTANCE = new BatteryMonitor();
    }

    public static BatteryMonitor getInstance() {
        return SInstanceHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseExpiredNodes(long j3) {
        this.wakeLockNodeManager.clearExpiredNodes(j3);
        this.locationNodeManager.clearExpiredNodes(j3);
        this.alarmNodeManager.clearExpiredNodes(j3);
    }

    private void reportAlarmExceptionData(long j3) {
        ArrayList<BaseBatteryInfo> hasWakeUpAlarmNumExceeded = this.alarmNodeManager.hasWakeUpAlarmNumExceeded(j3);
        ArrayList<BaseBatteryInfo> hasAlarmNumExceeded = this.alarmNodeManager.hasAlarmNumExceeded(j3);
        if (!hasWakeUpAlarmNumExceeded.isEmpty() || !hasAlarmNumExceeded.isEmpty()) {
            BatteryElementReporter.reportAlarm(hasAlarmNumExceeded, hasWakeUpAlarmNumExceeded, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportElementExceptionData(long j3) {
        if (!this.enableElementMonitor || j3 - this.lastExceptionReportTime < 600000) {
            return;
        }
        this.lastExceptionReportTime = j3;
        reportWakeLockExceptionData(j3);
        reportLocationExceptionData(j3);
        reportAlarmExceptionData(j3);
    }

    private void reportLocationExceptionData(long j3) {
        ArrayList<BaseBatteryInfo> hasSingleTimeExpiredNodes = this.locationNodeManager.hasSingleTimeExpiredNodes(j3);
        ArrayList<BaseBatteryInfo> hasTotalTimeExpiredNodes = this.locationNodeManager.hasTotalTimeExpiredNodes(j3);
        ArrayList<BaseBatteryInfo> hasOpenNumExceededThreshold = this.locationNodeManager.hasOpenNumExceededThreshold(j3);
        if (!hasSingleTimeExpiredNodes.isEmpty() || !hasTotalTimeExpiredNodes.isEmpty() || !hasOpenNumExceededThreshold.isEmpty()) {
            BatteryElementReporter.reportLocation(hasSingleTimeExpiredNodes, hasTotalTimeExpiredNodes, hasOpenNumExceededThreshold, j3, this.locationNodeManager.deduplicationTotalTime);
        }
    }

    private void reportWakeLockExceptionData(long j3) {
        ArrayList<BaseBatteryInfo> hasSingleTimeExpiredNodes = this.wakeLockNodeManager.hasSingleTimeExpiredNodes(j3);
        ArrayList<BaseBatteryInfo> hasTotalTimeExpiredNodes = this.wakeLockNodeManager.hasTotalTimeExpiredNodes(j3);
        ArrayList<BaseBatteryInfo> hasOpenNumExceededThreshold = this.wakeLockNodeManager.hasOpenNumExceededThreshold(j3);
        if (!hasOpenNumExceededThreshold.isEmpty() || !hasSingleTimeExpiredNodes.isEmpty() || !hasTotalTimeExpiredNodes.isEmpty()) {
            BatteryElementReporter.reportWakeLock(hasSingleTimeExpiredNodes, hasTotalTimeExpiredNodes, hasOpenNumExceededThreshold, j3, this.wakeLockNodeManager.deduplicationTotalTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAndSaveReportData() {
        if (this.enableElementMetricMonitor) {
            try {
                if (this.mReportData == null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("last_process_name", this.batteryElementMetricItem.processName);
                    jSONObject.put("last_launch_id", this.batteryElementMetricItem.launchID);
                    jSONObject.put("last_process_launch_id", this.batteryElementMetricItem.processLaunchID);
                    JSONObject makeAttributes = ReportDataBuilder.makeAttributes(new String[]{"stage"});
                    makeAttributes.put(ReportDataBuilder.KEY_USER_CUSTOM, this.batteryElementMetricItem.userData);
                    makeAttributes.put(ReportDataBuilder.KEY_HOT_PATCH, this.batteryElementMetricItem.hotPatchNum);
                    Application application = BaseInfo.app;
                    UserMeta userMeta = BaseInfo.userMeta;
                    JSONObject makeParam = ReportDataBuilder.makeParam(application, "resource", BuglyMonitorName.BATTERY_ELEMENT_METRIC, userMeta);
                    makeParam.put(ReportDataBuilder.KEY_ATTRIBUTES, makeAttributes);
                    makeParam.put(ReportDataBuilder.KEY_BODY, jSONObject);
                    ReportData reportData = new ReportData(userMeta.uin, 1, "Battery", makeParam);
                    this.mReportData = reportData;
                    this.reportDataCacheMng.insertReportDataToCache(reportData);
                }
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("wake_lock_frequency", this.batteryElementMetricItem.wakeLockFrequency);
                jSONObject2.put("wake_lock_duration_in_ms", this.wakeLockNodeManager.calculateTotalTimeInThisProcess(currentTimeMillis));
                jSONObject2.put(DTConstants.TAG.ELEMENT, "wake_lock");
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("location_frequency", this.batteryElementMetricItem.locationFrequency);
                jSONObject3.put("location_duration_in_ms", this.locationNodeManager.calculateTotalTimeInThisProcess(currentTimeMillis));
                jSONObject3.put(DTConstants.TAG.ELEMENT, "location");
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("alarm_frequency", this.batteryElementMetricItem.alarmFrequency);
                jSONObject4.put("alarm_wake_up_frequency", this.batteryElementMetricItem.alarmWakeUpFrequency);
                jSONObject4.put("alarm_other_frequency", this.batteryElementMetricItem.alarmOtherFrequency);
                jSONObject4.put(DTConstants.TAG.ELEMENT, NotificationCompat.CATEGORY_ALARM);
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("process_alive_duration_in_ms", this.batteryElementMetricItem.processAliveInMs);
                jSONObject5.put("foreground_duration_in_ms", this.batteryElementMetricItem.processForeInMs);
                jSONObject5.put("background_duration_in_ms", this.batteryElementMetricItem.processBackInMs);
                jSONObject5.put(DTConstants.TAG.ELEMENT, "process");
                JSONArray jSONArray = new JSONArray();
                jSONArray.mo162put(jSONObject2);
                jSONArray.mo162put(jSONObject3);
                jSONArray.mo162put(jSONObject4);
                jSONArray.mo162put(jSONObject5);
                jSONArray.mo162put(this.batteryElementMetricItem.buildCpuTimeJson());
                JSONObject params = this.mReportData.getParams();
                params.getJSONObject(ReportDataBuilder.KEY_BODY).put(DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, jSONArray);
                this.mReportData.setParams(params);
                this.reportDataCacheMng.updateReportDataToCache(this.mReportData);
            } catch (Throwable th5) {
                Logger.f365497g.c(TAG, th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAppStateTime(long j3) {
        long j16 = j3 - this.lastAppStateUpdateTime;
        if (this.currentAppState == 2) {
            this.batteryElementMetricItem.processBackInMs += j16;
        } else {
            this.batteryElementMetricItem.processForeInMs += j16;
        }
        this.batteryElementMetricItem.processAliveInMs += j16;
        this.lastAppStateUpdateTime = j3;
    }

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onBackground() {
        updateAppStateTime(System.currentTimeMillis());
        this.currentAppState = 2;
    }

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onForeground() {
        updateAppStateTime(System.currentTimeMillis());
        this.currentAppState = 1;
    }

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onStop(@NonNull Activity activity) {
        if (this.enableElementMetricMonitor) {
            final String localClassName = activity.getLocalClassName();
            this.handler.postAtFrontOfQueue(new Runnable() { // from class: com.tencent.bugly.battery.BatteryMonitor.5
                @Override // java.lang.Runnable
                public void run() {
                    BatteryMonitor.this.processCpuTracker.update();
                    ProcessCpuTracker.Stats topWorkingStats = BatteryMonitor.this.processCpuTracker.getTopWorkingStats();
                    if (topWorkingStats == null) {
                        return;
                    }
                    BatteryMonitor.this.batteryElementMetricItem.addCpuItem(localClassName, topWorkingStats.rel_uptime, topWorkingStats.rel_stime + topWorkingStats.rel_utime);
                    BatteryMonitor.this.updateAndSaveReportData();
                }
            });
        }
    }

    public void setBatteryElementEnable(boolean z16) {
        this.enableElementMonitor = z16;
    }

    public void setBatteryElementMetricEnable(boolean z16) {
        this.enableElementMetricMonitor = z16;
    }

    public void start() {
        if (!this.started.get()) {
            this.started.set(true);
            Logger.f365497g.i(TAG, "BatteryMonitor start");
            PowerManagerServiceHooker.addListener(this.powerListener);
            LocationManagerServiceHooker.addListener(this.locationListener);
            AlarmManagerServiceHooker.addListener(this.alarmListener);
            this.processCpuTracker.init();
            this.processCpuTracker.update();
            this.handler.sendMessageDelayed(this.handler.obtainMessage(1), 60000L);
        }
    }

    public void stop() {
        if (this.started.get() && !this.enableElementMonitor && !this.enableElementMetricMonitor) {
            Logger.f365497g.i(TAG, "BatteryMonitor stop");
            this.started.set(false);
            PowerManagerServiceHooker.removeListener(this.powerListener);
            LocationManagerServiceHooker.removeListener(this.locationListener);
            AlarmManagerServiceHooker.removeListener(this.alarmListener);
            this.handler.removeMessages(1);
        }
    }

    BatteryMonitor() {
        this.reportDataCacheMng = new e();
        this.mReportData = null;
        BatteryElementMetricItem batteryElementMetricItem = new BatteryElementMetricItem();
        this.batteryElementMetricItem = batteryElementMetricItem;
        this.processCpuTracker = new ProcessCpuTracker(false);
        this.enableElementMetricMonitor = true;
        this.enableElementMonitor = true;
        this.started = new AtomicBoolean(false);
        this.handler = new Handler(ThreadManager.getMonitorThreadLooper()) { // from class: com.tencent.bugly.battery.BatteryMonitor.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    BatteryMonitor.this.releaseExpiredNodes(currentTimeMillis);
                    BatteryMonitor.this.updateAppStateTime(currentTimeMillis);
                    BatteryMonitor.this.updateAndSaveReportData();
                    BatteryMonitor.this.reportElementExceptionData(currentTimeMillis);
                    sendMessageDelayed(obtainMessage(1), 60000L);
                }
            }
        };
        this.powerListener = new PowerManagerServiceHooker.IListener() { // from class: com.tencent.bugly.battery.BatteryMonitor.2
            @Override // com.tencent.bugly.battery.hook.PowerManagerServiceHooker.IListener
            public void onAcquireWakeLock(WakeLockInfo wakeLockInfo, String str, @Nullable WorkSource workSource, @Nullable String str2) {
                Logger.f365497g.i(BatteryMonitor.TAG, "onAcquireWakeLock, tag = " + wakeLockInfo.tag + ", scene = " + wakeLockInfo.scene + ", token = " + wakeLockInfo.token);
                BatteryMonitor.this.wakeLockNodeManager.addLivingNode(wakeLockInfo);
                BatteryElementMetricItem batteryElementMetricItem2 = BatteryMonitor.this.batteryElementMetricItem;
                batteryElementMetricItem2.wakeLockFrequency = batteryElementMetricItem2.wakeLockFrequency + 1;
            }

            @Override // com.tencent.bugly.battery.hook.PowerManagerServiceHooker.IListener
            public void onReleaseWakeLock(IBinder iBinder, int i3) {
                Logger.f365497g.i(BatteryMonitor.TAG, "onReleaseWakeLock, token = " + iBinder);
                BatteryMonitor.this.wakeLockNodeManager.moveToCloseNode(iBinder);
            }
        };
        this.locationListener = new LocationManagerServiceHooker.IListener() { // from class: com.tencent.bugly.battery.BatteryMonitor.3
            @Override // com.tencent.bugly.battery.hook.LocationManagerServiceHooker.IListener
            public void onRemoveLocationUpdates(int i3, PendingIntent pendingIntent) {
                Logger.f365497g.i(BatteryMonitor.TAG, "onRemoveLocationUpdates, hashCode = " + i3 + ", pendingIntent = " + pendingIntent);
                BatteryMonitor.this.locationNodeManager.moveToCloseNode(i3, pendingIntent);
            }

            @Override // com.tencent.bugly.battery.hook.LocationManagerServiceHooker.IListener
            public void onRequestLocationUpdates(LocationInfo locationInfo, long j3, float f16) {
                Logger.f365497g.i(BatteryMonitor.TAG, "onRequestLocationUpdates\uff0chashCode = " + locationInfo.locationListener + ", pendingIntent = " + locationInfo.pendingIntent);
                BatteryMonitor.this.locationNodeManager.addLivingNode(locationInfo);
                BatteryElementMetricItem batteryElementMetricItem2 = BatteryMonitor.this.batteryElementMetricItem;
                batteryElementMetricItem2.locationFrequency = batteryElementMetricItem2.locationFrequency + 1;
            }
        };
        this.alarmListener = new AlarmManagerServiceHooker.IListener() { // from class: com.tencent.bugly.battery.BatteryMonitor.4
            @Override // com.tencent.bugly.battery.hook.AlarmManagerServiceHooker.IListener
            public void onAlarmRemove(PendingIntent pendingIntent, AlarmManager.OnAlarmListener onAlarmListener) {
                Logger.f365497g.i(BatteryMonitor.TAG, "onAlarmRemove, operation = " + pendingIntent);
                BatteryMonitor.this.alarmNodeManager.moveToCloseNode(pendingIntent, onAlarmListener);
            }

            @Override // com.tencent.bugly.battery.hook.AlarmManagerServiceHooker.IListener
            public void onAlarmSet(AlarmInfo alarmInfo, long j3, long j16, int i3, AlarmManager.OnAlarmListener onAlarmListener) {
                Logger.f365497g.i(BatteryMonitor.TAG, "onAlarmSet, operation = " + alarmInfo.operation);
                BatteryMonitor.this.alarmNodeManager.addLivingNode(alarmInfo);
                BatteryElementMetricItem batteryElementMetricItem2 = BatteryMonitor.this.batteryElementMetricItem;
                batteryElementMetricItem2.alarmFrequency = batteryElementMetricItem2.alarmFrequency + 1;
                int i16 = alarmInfo.type;
                if (i16 == 0 || i16 == 2) {
                    BatteryMonitor.this.batteryElementMetricItem.alarmWakeUpFrequency++;
                } else {
                    BatteryMonitor.this.batteryElementMetricItem.alarmOtherFrequency++;
                }
            }
        };
        batteryElementMetricItem.processName = a.e(BaseInfo.app);
        batteryElementMetricItem.processLaunchID = TraceGenerator.getProcessLaunchId();
        batteryElementMetricItem.launchID = TraceGenerator.getLaunchId(ContextUtil.getGlobalContext());
        batteryElementMetricItem.appVersion = BaseInfo.userMeta.appVersion;
        batteryElementMetricItem.processAliveInMs = 0L;
        batteryElementMetricItem.processForeInMs = 0L;
        batteryElementMetricItem.processBackInMs = 0L;
        batteryElementMetricItem.hotPatchNum = HotPatchWrapper.getInstance().getAppHotPatchNum();
        batteryElementMetricItem.userData = com.tencent.rmonitor.custom.b.a().o();
        LifecycleCallback.r(this);
        if (LifecycleCallback.G.m()) {
            this.currentAppState = 1;
        } else {
            this.currentAppState = 2;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.lastAppStateUpdateTime = currentTimeMillis;
        this.lastExceptionReportTime = currentTimeMillis;
        d dVar = (d) ConfigProxy.INSTANCE.getConfig().k(BuglyMonitorName.BATTERY_ELEMENT);
        this.wakeLockNodeManager = new WakeLockStatsImpl(dVar.E, dVar.G, dVar.F);
        this.locationNodeManager = new LocationStatsImpl(dVar.f365311m, dVar.D, dVar.C);
        this.alarmNodeManager = new AlarmStatsImpl(dVar.H, dVar.I);
    }

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onCreate(@NonNull Activity activity) {
    }

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onDestroy(@NonNull Activity activity) {
    }

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onPause(@NonNull Activity activity) {
    }

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onPostCreate(@NonNull Activity activity) {
    }

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onResume(@NonNull Activity activity) {
    }

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onStart(@NonNull Activity activity) {
    }
}
