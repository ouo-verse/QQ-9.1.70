package com.qzone.reborn.tracer.monitor;

import android.text.TextUtils;
import com.qzone.report.QZonePerfReporter;
import com.tencent.biz.richframework.monitor.local.RFWAbsMonitorProxy;
import com.tencent.biz.richframework.monitor.local.fps.RFWDropFrameCollector;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;

/* loaded from: classes37.dex */
public class QZoneMonitorProxyImpl extends RFWAbsMonitorProxy {

    /* renamed from: h, reason: collision with root package name */
    private static volatile QZoneMonitorProxyImpl f59503h;

    /* renamed from: e, reason: collision with root package name */
    private IAppSettingApi f59508e;

    /* renamed from: a, reason: collision with root package name */
    private boolean f59504a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f59505b = false;

    /* renamed from: c, reason: collision with root package name */
    private float f59506c = 0.0f;

    /* renamed from: d, reason: collision with root package name */
    private float f59507d = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    private String f59509f = null;

    /* renamed from: g, reason: collision with root package name */
    private boolean f59510g = false;

    QZoneMonitorProxyImpl() {
        initializeSharePreference();
        this.f59508e = (IAppSettingApi) QRoute.api(IAppSettingApi.class);
    }

    private int a() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", "secondary_key_report_calculate_frame_count", 20, false);
    }

    public static QZoneMonitorProxyImpl b() {
        if (f59503h == null) {
            synchronized (QZoneMonitorProxyImpl.class) {
                if (f59503h == null) {
                    f59503h = new QZoneMonitorProxyImpl();
                }
            }
        }
        return f59503h;
    }

    private void initializeSharePreference() {
        if (this.f59504a) {
            return;
        }
        this.f59505b = gd.a.f401926a.c("KEY_ENABLED_MONITOR_UI", false);
        this.f59504a = true;
    }

    private void printDebugLogInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QLog.isColorLevel() || QLog.isDebugVersion()) {
            QLog.d("FAM-QZoneMonitorProxyImpl", 1, "[printDebugLogInfo] msg: ", str);
        }
    }

    private void reportFrameRateInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f59507d = Math.min(this.f59507d, 100.0f);
        float min = Math.min(this.f59506c, 60.0f);
        this.f59506c = min;
        if (this.f59507d != 0.0f && min != 0.0f) {
            if (QLog.isColorLevel()) {
                QLog.d("FAM-QZoneMonitorProxyImpl", 1, "[reportFrameRateInfo] current sm: ", Float.valueOf(this.f59507d), " | fps: ", Float.valueOf(this.f59506c));
            }
            QZonePerfReporter.f59697a.p(str, this.f59507d, this.f59506c);
            return;
        }
        printDebugLogInfo("[reportFrameRateInfo] current sm(" + this.f59507d + ") is zero or pfs(" + this.f59506c + ")");
    }

    private void reportToDcTable(String str) {
        if (!getIsEnable()) {
            printDebugLogInfo("[reportToDcTable] current wns enabled collect close.");
        } else {
            reportFrameRateInfo(str);
        }
    }

    @Override // com.tencent.biz.richframework.monitor.local.RFWAbsMonitorProxy, com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public boolean isEnabledPerformanceUI() {
        return false;
    }

    @Override // com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public boolean isEnabledTracePrint() {
        return false;
    }

    @Override // com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    /* renamed from: isWnsEnabledCollect */
    public boolean getIsEnable() {
        String str;
        IAppSettingApi iAppSettingApi = this.f59508e;
        if (iAppSettingApi == null) {
            QLog.w("FAM-QZoneMonitorProxyImpl", 1, "[isWnsEnabledCollect] current app setting api should not be null.");
            return false;
        }
        if (iAppSettingApi.isGrayVersion() || !this.f59508e.isPublicVersion()) {
            str = "1";
        } else {
            str = "0";
        }
        return TextUtils.equals(QzoneConfig.getInstance().getConfig("QZoneSetting", "secondary_key_frame_analyse_enabled", str, false), "1");
    }

    @Override // com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public void onBeginFPSFrameMonitor(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FAM-QZoneMonitorProxyImpl", 1, "[onBeginFPSFrameMonitor] fps start, scene: ", str);
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.tracer.monitor.QZoneMonitorProxyImpl.1
            @Override // java.lang.Runnable
            public void run() {
                a.a(str);
            }
        });
    }

    @Override // com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public void onEndFPSFrameMonitor(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FAM-QZoneMonitorProxyImpl", 1, "[onBeginFPSFrameMonitor] fps end, scene: ", str);
        }
        this.f59509f = str;
        if (!this.f59510g) {
            printDebugLogInfo("[onEndFPSFrameMonitor] current report fail, calculate count illegality.");
        } else {
            a.b(str, false);
        }
    }

    @Override // com.tencent.biz.richframework.monitor.local.RFWAbsMonitorProxy, com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public String onParseSceneForPageId(int i3) {
        String c16 = c(i3);
        if (TextUtils.isEmpty(c16) && i3 > 0) {
            c16 = String.valueOf(i3);
        }
        return TextUtils.isEmpty(c16) ? "" : c16;
    }

    @Override // com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public void onFrameInfo(RFWDropFrameCollector.DropFrameInfo dropFrameInfo, boolean z16) {
        if (dropFrameInfo == null || TextUtils.isEmpty(this.f59509f)) {
            return;
        }
        this.f59506c = dropFrameInfo.getFps();
        this.f59507d = dropFrameInfo.getSmoothRate();
        if (z16) {
            long currentDropFrameCount = getCurrentDropFrameCount(dropFrameInfo.getFrameTimeArray());
            if (currentDropFrameCount == 0) {
                return;
            }
            if (currentDropFrameCount >= a()) {
                reportToDcTable(this.f59509f);
                this.f59509f = "";
                this.f59510g = true;
            } else {
                printDebugLogInfo("[onFrameInfo] current check low frame num, report fail.");
                this.f59510g = false;
            }
        }
    }

    private long getCurrentDropFrameCount(long[] jArr) {
        if (jArr != null && jArr.length > 0) {
            return jArr[0];
        }
        return 0L;
    }

    public String c(int i3) {
        if (i3 == 1) {
            return "qzone_passive_message";
        }
        if (i3 == 2) {
            return "qzone_user_home";
        }
        if (i3 == 10) {
            return "qzone_mood_list";
        }
        if (i3 != 12) {
            return String.valueOf(i3);
        }
        return "qzone_friend_feed";
    }
}
