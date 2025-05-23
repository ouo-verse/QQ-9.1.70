package com.tencent.bugly.battery;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.bugly.battery.utils.Utils;
import com.tencent.bugly.common.hotpatch.HotPatchWrapper;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.bugly.common.trace.TraceGenerator;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.bugly.common.utils.ContextUtil;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.db.e;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import com.tencent.rmonitor.common.lifecycle.a;
import com.tencent.rmonitor.common.lifecycle.b;
import com.tencent.rmonitor.common.logger.Logger;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BatteryMetricMonitor implements b {
    private static final int APP_STATE_BACKGROUND = 2;
    private static final int APP_STATE_FOREGROUND = 1;
    private static final int BATTERY_METRIC_MESSAGE = 1;
    private static final String TAG = "BatteryMetricMonitor";
    private static int checkDelayInMinute = 1;
    private BatteryManager batteryManager;
    private final BatteryMetricItem batteryMetricItem;
    private int currentAppState;
    private final Handler handler;
    private final IntentFilter intentFilter;
    private long lastAppStateUpdateTime;
    private ReportData mReportData;
    private long processAliveInMs;
    private long processBackInMs;
    private long processForeInMs;
    private e reportDataCacheMng;
    private boolean started;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class SInstanceHolder {
        public static final BatteryMetricMonitor INSTANCE = new BatteryMetricMonitor();
    }

    private float getCurrentInternal() {
        BatteryManager batteryManager = this.batteryManager;
        if (batteryManager != null) {
            float longProperty = (float) batteryManager.getLongProperty(2);
            if (longProperty >= -1.0E7f && longProperty <= 1.0E7f) {
                if (!Utils.isKirin() && !Utils.isSamsung()) {
                    if (Utils.isOppo()) {
                        if (longProperty > 10000.0f) {
                            return longProperty / 1000.0f;
                        }
                        return longProperty;
                    }
                    return longProperty / 1000.0f;
                }
                if (longProperty < -10000.0f) {
                    longProperty /= 1000.0f;
                }
                return -longProperty;
            }
            return -1.0f;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAndSaveData(long j3) {
        Intent registerReceiver;
        int intExtra;
        if (this.currentAppState != 2 && (registerReceiver = ContextUtil.getGlobalContext().registerReceiver(null, this.intentFilter)) != null && (intExtra = registerReceiver.getIntExtra("status", 1)) != 2 && intExtra != 5) {
            boolean z16 = false;
            float intExtra2 = registerReceiver.getIntExtra("temperature", 0) / 10.0f;
            float current = getCurrent(ContextUtil.getGlobalContext());
            Logger.f365497g.d(TAG, "temperature = " + intExtra2 + ",current = " + current + ",status = " + intExtra);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timestamp", j3);
                jSONObject.put("scene", a.f());
                jSONObject.put("foreground_duration_in_ms", this.processForeInMs);
                jSONObject.put("average_foreground_current_value", current);
                jSONObject.put("average_battery_temperature", intExtra2);
                if (this.currentAppState == 1) {
                    z16 = true;
                }
                jSONObject.put(com.tencent.mobileqq.msf.core.net.r.a.f248963o, z16);
                this.batteryMetricItem.details.mo162put(jSONObject);
            } catch (Throwable th5) {
                Logger.f365497g.c(TAG, th5);
            }
            BatteryMetricItem batteryMetricItem = this.batteryMetricItem;
            int i3 = batteryMetricItem.collectCount + 1;
            batteryMetricItem.collectCount = i3;
            batteryMetricItem.processAliveInMs = this.processAliveInMs;
            batteryMetricItem.processForeInMs = this.processForeInMs;
            batteryMetricItem.foreAverageCurrent = ((batteryMetricItem.foreAverageCurrent * (i3 - 1)) + current) / i3;
            batteryMetricItem.averageTemperature = ((batteryMetricItem.averageTemperature * (i3 - 1)) + intExtra2) / i3;
            updateAndSaveReportData();
        }
    }

    private void updateAndSaveReportData() {
        try {
            if (this.mReportData == null) {
                Application application = BaseInfo.app;
                UserMeta userMeta = BaseInfo.userMeta;
                JSONObject makeParam = ReportDataBuilder.makeParam(application, "resource", BuglyMonitorName.BATTERY_METRIC, userMeta);
                JSONObject makeAttributes = ReportDataBuilder.makeAttributes(new String[]{"stage"});
                makeAttributes.put(ReportDataBuilder.KEY_USER_CUSTOM, this.batteryMetricItem.userData);
                makeAttributes.put(ReportDataBuilder.KEY_HOT_PATCH, this.batteryMetricItem.hotPatchNum);
                makeParam.put(ReportDataBuilder.KEY_ATTRIBUTES, makeAttributes);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("last_process_name", this.batteryMetricItem.processName);
                jSONObject.put("last_launch_id", this.batteryMetricItem.launchID);
                jSONObject.put("last_process_launch_id", this.batteryMetricItem.processLaunchID);
                makeParam.put(ReportDataBuilder.KEY_BODY, jSONObject);
                ReportData reportData = new ReportData(userMeta.uin, 1, "Battery", makeParam);
                this.mReportData = reportData;
                this.reportDataCacheMng.insertReportDataToCache(reportData);
            }
            JSONObject params = this.mReportData.getParams();
            JSONObject jSONObject2 = params.getJSONObject(ReportDataBuilder.KEY_BODY);
            jSONObject2.put("foreground_duration_in_ms", this.batteryMetricItem.processForeInMs);
            jSONObject2.put("average_battery_temperature", this.batteryMetricItem.averageTemperature);
            jSONObject2.put("average_foreground_current_value", this.batteryMetricItem.foreAverageCurrent);
            jSONObject2.put("process_alive_time_in_ms", this.batteryMetricItem.processAliveInMs);
            jSONObject2.put("collect_count", this.batteryMetricItem.collectCount);
            jSONObject2.put("collect_interval_in_minute", this.batteryMetricItem.collectIntervalInMinute);
            jSONObject2.put("detail", this.batteryMetricItem.details);
            this.mReportData.setParams(params);
            this.reportDataCacheMng.updateReportDataToCache(this.mReportData);
        } catch (Throwable th5) {
            Logger.f365497g.c(TAG, th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAppStateTime(long j3) {
        if (this.currentAppState == 2) {
            long j16 = this.processBackInMs + (j3 - this.lastAppStateUpdateTime);
            this.processBackInMs = j16;
            this.processAliveInMs += j16;
        } else {
            long j17 = this.processForeInMs + (j3 - this.lastAppStateUpdateTime);
            this.processForeInMs = j17;
            this.processAliveInMs += j17;
        }
        this.lastAppStateUpdateTime = j3;
    }

    public float getCurrent(Context context) {
        if (!AndroidVersion.isOverL()) {
            return 0.0f;
        }
        if (this.batteryManager == null) {
            this.batteryManager = (BatteryManager) context.getSystemService("batterymanager");
        }
        return getCurrentInternal();
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

    public void start() {
        if (this.started) {
            return;
        }
        this.handler.sendEmptyMessage(1);
        this.started = true;
    }

    public void stop() {
        if (!this.started) {
            return;
        }
        this.handler.removeMessages(1);
        this.started = false;
    }

    BatteryMetricMonitor() {
        this.batteryManager = null;
        this.processBackInMs = 0L;
        this.processAliveInMs = 0L;
        this.processForeInMs = 0L;
        BatteryMetricItem batteryMetricItem = new BatteryMetricItem();
        this.batteryMetricItem = batteryMetricItem;
        this.reportDataCacheMng = new e();
        this.mReportData = null;
        this.handler = new Handler(ThreadManager.getMonitorThreadLooper()) { // from class: com.tencent.bugly.battery.BatteryMetricMonitor.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    BatteryMetricMonitor.this.updateAppStateTime(currentTimeMillis);
                    BatteryMetricMonitor.this.updateAndSaveData(currentTimeMillis);
                    sendMessageDelayed(obtainMessage(1), BatteryMetricMonitor.checkDelayInMinute * 60 * 1000);
                }
            }
        };
        this.intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        int i3 = ConfigProxy.INSTANCE.getConfig().k(BuglyMonitorName.BATTERY_METRIC).threshold;
        checkDelayInMinute = i3;
        if (i3 < 1) {
            checkDelayInMinute = 1;
        }
        LifecycleCallback.r(this);
        if (LifecycleCallback.G.m()) {
            this.currentAppState = 1;
        } else {
            this.currentAppState = 2;
        }
        this.lastAppStateUpdateTime = System.currentTimeMillis();
        batteryMetricItem.appVersion = BaseInfo.userMeta.appVersion;
        batteryMetricItem.launchID = TraceGenerator.getLaunchId(BaseInfo.app);
        batteryMetricItem.processLaunchID = TraceGenerator.getProcessLaunchId();
        batteryMetricItem.processName = com.tencent.rmonitor.common.util.a.e(BaseInfo.app);
        batteryMetricItem.collectIntervalInMinute = checkDelayInMinute;
        batteryMetricItem.collectCount = 0;
        batteryMetricItem.hotPatchNum = HotPatchWrapper.getInstance().getAppHotPatchNum();
        batteryMetricItem.userData = com.tencent.rmonitor.custom.b.a().o();
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

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onStop(@NonNull Activity activity) {
    }
}
