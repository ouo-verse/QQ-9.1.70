package com.tencent.biz.qqcircle.richframework.part;

import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper;
import com.tencent.biz.richframework.monitor.local.RFWAbsMonitorProxy;
import com.tencent.biz.richframework.monitor.local.fps.RFWDropFrameCollector;
import com.tencent.biz.richframework.part.utils.RFSafeMapUtils;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.ASEngineQualityReport;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import uq3.c;

/* loaded from: classes5.dex */
public class QCircleMonitorProxyImpl extends RFWAbsMonitorProxy {

    /* renamed from: h, reason: collision with root package name */
    private static final Map<Integer, String> f91922h;

    /* renamed from: i, reason: collision with root package name */
    private static volatile QCircleMonitorProxyImpl f91923i;

    /* renamed from: e, reason: collision with root package name */
    private IAppSettingApi f91928e;

    /* renamed from: a, reason: collision with root package name */
    private boolean f91924a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f91925b = false;

    /* renamed from: c, reason: collision with root package name */
    private float f91926c = 0.0f;

    /* renamed from: d, reason: collision with root package name */
    private float f91927d = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    private String f91929f = null;

    /* renamed from: g, reason: collision with root package name */
    private boolean f91930g = false;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f91922h = concurrentHashMap;
        concurrentHashMap.put(503, QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_IMMERSIVE_ALL_PUSH_PAGE());
        concurrentHashMap.put(501, QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_IMMERSIVE_FOLLOW_PAGE());
        concurrentHashMap.put(591, QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_IMMERSIVE_NEARBY_PAGE());
        concurrentHashMap.put(59, QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_IMMERSIVE_MESSAGE_PAGE());
        concurrentHashMap.put(80001, QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_IMMERSIVE_PRIVATE_CHAT_PAGE());
        concurrentHashMap.put(Integer.valueOf(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARE_FAILED), QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_IMMERSIVE_PERSONAGE_PAGE());
        concurrentHashMap.put(80000, QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_IMMERSIVE_MUSIC_POLYMERIZATION_PAGE());
        concurrentHashMap.put(73, QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_IMMERSIVE_LOCATION_POLYMERIZATION_PAGE());
        concurrentHashMap.put(71, QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_IMMERSIVE_TOPIC_POLYMERIZATION_PAGE());
        concurrentHashMap.put(80003, QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_IMMERSIVE_COMMENT_LIST());
        concurrentHashMap.put(57, QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_IMMERSIVE_LAYER_LIST());
    }

    QCircleMonitorProxyImpl() {
        initializeSharePreference();
        this.f91928e = (IAppSettingApi) QRoute.api(IAppSettingApi.class);
    }

    private int a() {
        return c.X0("qqcircle", "qcircle_report_calculate_frame_count", 20).intValue();
    }

    public static QCircleMonitorProxyImpl b() {
        if (f91923i == null) {
            synchronized (QCircleMonitorProxyImpl.class) {
                if (f91923i == null) {
                    f91923i = new QCircleMonitorProxyImpl();
                }
            }
        }
        return f91923i;
    }

    private long getCurrentDropFrameCount(long[] jArr) {
        if (jArr == null || jArr.length <= 0) {
            return 0L;
        }
        return jArr[0];
    }

    private void initializeSharePreference() {
        if (this.f91924a) {
            return;
        }
        this.f91925b = com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_ENABLED_PERFORMANCE_CONTROLLER, 0);
        this.f91924a = true;
    }

    private void printDebugLogInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QLog.isColorLevel() || QLog.isDebugVersion()) {
            QLog.d("FAM-QCircleMonitorProxy", 1, "[printDebugLogInfo] msg: ", str);
        }
    }

    private void reportFrameRateInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f91927d = Math.min(this.f91927d, 100.0f);
        float min = Math.min(this.f91926c, 60.0f);
        this.f91926c = min;
        if (this.f91927d != 0.0f && min != 0.0f) {
            if (QLog.isColorLevel()) {
                QLog.d("FAM-QCircleMonitorProxy", 1, "[reportFrameRateInfo] current sm: ", Float.valueOf(this.f91927d), " | fps: ", Float.valueOf(this.f91926c));
            }
            ASEngineQualityReport.report(new ASEngineQualityReport.ReportData().setEventId(ASEngineQualityReport.EVENT_SCROLL_PAGE_FRAME).setTimeCost(String.valueOf(this.f91927d)).setExt1(String.valueOf(this.f91926c)).setExt2(str));
            return;
        }
        printDebugLogInfo("[reportFrameRateInfo] current sm(" + this.f91927d + ") is zero or pfs(" + this.f91926c + ")");
    }

    private void reportToDcTable(String str) {
        if (!isWnsEnabledCollect()) {
            printDebugLogInfo("[reportToDcTable] current wns enabled collect close.");
        } else {
            reportFrameRateInfo(str);
        }
    }

    public void c(boolean z16) {
        this.f91925b = z16;
    }

    @Override // com.tencent.biz.richframework.monitor.local.RFWAbsMonitorProxy, com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public boolean isEnabledPerformanceUI() {
        return this.f91925b;
    }

    @Override // com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public boolean isEnabledTracePrint() {
        return false;
    }

    @Override // com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public boolean isWnsEnabledCollect() {
        String str;
        IAppSettingApi iAppSettingApi = this.f91928e;
        if (iAppSettingApi == null) {
            QLog.w("FAM-QCircleMonitorProxy", 1, "[isWnsEnabledCollect] current app setting api should not be null.");
            return false;
        }
        if (iAppSettingApi.isGrayVersion() || !this.f91928e.isPublicVersion()) {
            str = "1";
        } else {
            str = "0";
        }
        return TextUtils.equals(c.b1("qqcircle", "qcircle_analyse_enabled", str), "1");
    }

    @Override // com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public void onBeginFPSFrameMonitor(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FAM-QCircleMonitorProxy", 1, "[onBeginFPSFrameMonitor] fps start, scene: ", str);
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.part.QCircleMonitorProxyImpl.1
            @Override // java.lang.Runnable
            public void run() {
                QCircleHostDropFrameMonitorHelper.startMonitorScene(str);
            }
        });
    }

    @Override // com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public void onEndFPSFrameMonitor(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FAM-QCircleMonitorProxy", 1, "[onBeginFPSFrameMonitor] fps end, scene: ", str);
        }
        this.f91929f = str;
        if (!this.f91930g) {
            printDebugLogInfo("[onEndFPSFrameMonitor] current report fail, calculate count illegality.");
        } else {
            QCircleHostDropFrameMonitorHelper.stopMonitorScene(str, false);
        }
    }

    @Override // com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public void onFrameInfo(RFWDropFrameCollector.DropFrameInfo dropFrameInfo, boolean z16) {
        if (dropFrameInfo == null || TextUtils.isEmpty(this.f91929f)) {
            return;
        }
        this.f91926c = dropFrameInfo.getFps();
        this.f91927d = dropFrameInfo.getSmoothRate();
        if (!z16) {
            return;
        }
        long currentDropFrameCount = getCurrentDropFrameCount(dropFrameInfo.getFrameTimeArray());
        if (currentDropFrameCount == 0) {
            return;
        }
        if (currentDropFrameCount >= a()) {
            reportToDcTable(this.f91929f);
            this.f91929f = "";
            this.f91930g = true;
        } else {
            printDebugLogInfo("[onFrameInfo] current check low frame num, report fail.");
            this.f91930g = false;
        }
    }

    @Override // com.tencent.biz.richframework.monitor.local.RFWAbsMonitorProxy, com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public String onParseSceneForPageId(int i3) {
        String str = (String) RFSafeMapUtils.getVal(f91922h, Integer.valueOf(i3));
        if (TextUtils.isEmpty(str) && i3 > 0) {
            str = String.valueOf(i3);
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }
}
