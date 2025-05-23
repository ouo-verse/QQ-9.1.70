package com.tencent.mobileqq.statistics;

import android.text.TextUtils;
import com.tencent.beacon.base.util.BeaconLogger;
import com.tencent.beacon.event.immediate.BeaconImmediateReportCallback;
import com.tencent.beacon.event.immediate.BeaconTransferArgs;
import com.tencent.beacon.event.immediate.IBeaconImmediateReport;
import com.tencent.beacon.event.open.BeaconConfig;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconInitException;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventResult;
import com.tencent.beacon.event.open.EventType;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.privacy.PrivacyPolicyHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.util.UiThreadUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.LogUtil;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQBeaconReport {
    static IPatchRedirector $redirector_ = null;
    private static final String[] BEACON_MATCH_KEYS;
    private static final HashSet<String> BEACON_MATCH_KEYS_SET;
    private static final int CODE_SUC = 0;
    private static final int CODE_SUC_SAMPLING = 101;
    public static final String DEVELOP_APP_KEY = "0S200H74R907V3HE";
    public static final String KEY_BEACON_TEST_ENV_SWITCH = "beacon_test_env_switch";
    private static final String PARAM_IS_GRAY_VERSION = "param_is_gray_version";
    public static final String PUBLIC_MAIN_APP_KEY = "0S200MNJT807V3GE";
    public static final String QWALLET_APP_KEY = "000004B5DU3Q3LD1";
    public static final String SP_QQ_BEACON = "sp_qq_beacon";
    private static final String TAG = "QQBeaconReport";
    private static final long TIME_POLLING = 30000;
    private static final AtomicBoolean sInit;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements IBeaconImmediateReport {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.beacon.event.immediate.IBeaconImmediateReport
        public void reportImmediate(BeaconTransferArgs beaconTransferArgs, BeaconImmediateReportCallback beaconImmediateReportCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) beaconTransferArgs, (Object) beaconImmediateReportCallback);
                return;
            }
            AppRuntime waitAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
            if (waitAppRuntime instanceof AppInterface) {
                BeaconRealTimeReportHandler beaconRealTimeReportHandler = (BeaconRealTimeReportHandler) ((AppInterface) waitAppRuntime).getBusinessHandler(BeaconRealTimeReportHandler.f289893e);
                if (beaconRealTimeReportHandler != null) {
                    beaconRealTimeReportHandler.D2(beaconTransferArgs, beaconImmediateReportCallback);
                    return;
                }
                return;
            }
            QLog.e(QQBeaconReport.TAG, 1, "[reportImmediate] error: app not instanceof AppInterface.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements BeaconLogger {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.beacon.base.util.BeaconLogger
        public void d(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            } else if (QQBeaconReport.BEACON_MATCH_KEYS_SET.contains(str) && QLog.isColorLevel()) {
                QLog.d(str, 2, str2);
            }
        }

        @Override // com.tencent.beacon.base.util.BeaconLogger
        public void e(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
            } else {
                QLog.d(str, 1, str2);
            }
        }

        @Override // com.tencent.beacon.base.util.BeaconLogger
        public void i(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            }
        }

        @Override // com.tencent.beacon.base.util.BeaconLogger
        public void printStackTrace(Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) th5);
            } else if (QLog.isColorLevel()) {
                QLog.d(QQBeaconReport.TAG, 2, "beacon t", th5);
            }
        }

        @Override // com.tencent.beacon.base.util.BeaconLogger
        public void v(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            }
        }

        @Override // com.tencent.beacon.base.util.BeaconLogger
        public void w(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36113);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        sInit = new AtomicBoolean(false);
        String[] strArr = {"BeaconReport", TVKLiveRequestBuilder.RequestParamKey.QIMEI36, "BeaconNet", "EventReport", "EventModule"};
        BEACON_MATCH_KEYS = strArr;
        BEACON_MATCH_KEYS_SET = new HashSet<>(Arrays.asList(strArr));
    }

    public QQBeaconReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static String getAppKey() {
        return "0S200MNJT807V3GE";
    }

    private static boolean isLogAble() {
        return false;
    }

    private static void logReportResultIfNeed(EventResult eventResult) {
        if (!eventResult.isSuccess() && eventResult.errorCode != 101 && QLog.isColorLevel()) {
            QLog.d(TAG, 2, "EventResult{ eventID:" + eventResult.eventID + ", errorCode: " + eventResult.errorCode + ", errorMsg: " + eventResult.errMsg + "}");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void realReport(String str, String str2, String str3, boolean z16, Map<String, String> map, boolean z17, boolean z18) {
        if (!TextUtils.isEmpty(str3)) {
            BeaconEvent.Builder builder = BeaconEvent.builder();
            if (!TextUtils.isEmpty(str)) {
                builder.withAppKey(str);
            }
            if (map == null) {
                map = new HashMap<>();
            }
            if (!TextUtils.isEmpty(str2)) {
                map.put("user_uin", str2);
            }
            map.put(PARAM_IS_GRAY_VERSION, String.valueOf(false));
            builder.withCode(str3);
            builder.withIsSucceed(z16);
            if (z17) {
                builder.withType(EventType.REALTIME);
            }
            if (z18) {
                builder.withType(EventType.IMMEDIATE_MSF);
            }
            builder.withParams(map);
            logReportResultIfNeed(BeaconReport.getInstance().report(builder.build()));
            return;
        }
        throw new RuntimeException("report a event with a empty key!");
    }

    public static void report(String str) {
        report("", str);
    }

    private static void reportCommon(String str, String str2, String str3, boolean z16, Map<String, String> map, boolean z17, boolean z18) {
        if (UiThreadUtil.isOnUiThread()) {
            ThreadManagerV2.excute(new Runnable(str, str2, str3, z16, map, z17, z18) { // from class: com.tencent.mobileqq.statistics.QQBeaconReport.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean C;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f289903d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f289904e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f289905f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ boolean f289906h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ Map f289907i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ boolean f289908m;

                {
                    this.f289903d = str;
                    this.f289904e = str2;
                    this.f289905f = str3;
                    this.f289906h = z16;
                    this.f289907i = map;
                    this.f289908m = z17;
                    this.C = z18;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, str, str2, str3, Boolean.valueOf(z16), map, Boolean.valueOf(z17), Boolean.valueOf(z18));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        QQBeaconReport.realReport(this.f289903d, this.f289904e, this.f289905f, this.f289906h, this.f289907i, this.f289908m, this.C);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            }, 16, null, false);
        } else {
            realReport(str, str2, str3, z16, map, z17, z18);
        }
    }

    public static void reportWithAppKey(String str, String str2) {
        reportWithAppKey(str, "", str2);
    }

    public static void setBeaconPrivacyInfo() {
        l f16 = l.f(BaseApplication.getContext());
        BeaconReport.getInstance().setImei(f16.c());
        BeaconReport.getInstance().setImsi(f16.e());
        BeaconReport.getInstance().setMac(f16.g());
        BeaconReport.getInstance().setModel(f16.i());
        BeaconReport.getInstance().setWifiMacAddress(f16.m());
        BeaconReport.getInstance().setImei2(f16.d());
        BeaconReport.getInstance().setMeid(f16.h());
        BeaconReport.getInstance().setWifiSSID(f16.n());
    }

    private static void setLog() {
        BeaconReport.getInstance().setLogger(new b());
    }

    public static void setUserId(String str) {
        QLog.d(TAG, 1, "setUserId = ", LogUtil.getSafePrintUin(str), ", process: ", MobileQQ.processName);
        BeaconReport.getInstance().setUserID(getAppKey(), str);
        BeaconReport.getInstance().setOpenID(getAppKey(), str);
        BeaconReport.getInstance().setOpenID(QWALLET_APP_KEY, str);
    }

    public static void start() {
        start("");
    }

    public static void report(String str, String str2) {
        report(str, str2, new HashMap());
    }

    public static void reportWithAppKey(String str, String str2, String str3) {
        reportWithAppKey(str, str2, str3, new HashMap());
    }

    public static void start(String str) {
        if (sInit.compareAndSet(false, true)) {
            BaseApplication context = BaseApplication.getContext();
            boolean z16 = PrivacyPolicyHelper.isUserAllow();
            if (z16) {
                setBeaconPrivacyInfo();
            }
            boolean useSocket = ((IBeaconConfig) QRoute.api(IBeaconConfig.class)).getUseSocket();
            QLog.d(TAG, 1, "[start] useSocket: ", Boolean.valueOf(useSocket));
            BeaconConfig build = BeaconConfig.builder().setIsSocketMode(useSocket).auditEnable(false).setNormalPollingTime(30000L).qmspEnable(false).setNeedInitQimei(false).setNeedReportRqdEvent(false).build();
            BeaconReport beaconReport = BeaconReport.getInstance();
            if (isLogAble()) {
                beaconReport.setLogAble(true);
                setLog();
            } else {
                beaconReport.setLogAble(false);
            }
            if (!TextUtils.isEmpty(str)) {
                beaconReport.setAppVersion(str);
            }
            beaconReport.setImmediateReport(new a());
            o.e(false);
            beaconReport.setChannelID("0S200MNJT807V3GE", AppSetting.h());
            try {
                beaconReport.start(context, "0S200MNJT807V3GE", build);
                QLog.d(TAG, 1, "start Beacon & QIMEI SDK: isDebugVersion = ", Boolean.FALSE, ", appVersion: ", str, ", appKey: ", "0S200MNJT807V3GE", ", log: ", Boolean.valueOf(isLogAble()), ", userAllow: ", Boolean.valueOf(z16));
            } catch (BeaconInitException e16) {
                QLog.e(TAG, 1, "start Beacon error", e16);
            }
        }
    }

    public static void report(String str, String str2, Map<String, String> map) {
        report(str, str2, map, false);
    }

    public static void reportWithAppKey(String str, String str2, String str3, Map<String, String> map) {
        reportWithAppKey(str, str2, str3, true, map, false);
    }

    public static void report(String str, String str2, Map<String, String> map, boolean z16) {
        report(str, str2, true, map, z16);
    }

    public static void reportWithAppKey(String str, String str2, String str3, boolean z16, Map<String, String> map, boolean z17) {
        reportCommon(str, str2, str3, z16, map, z17, false);
    }

    @Deprecated
    public static void report(String str, String str2, Map<String, String> map, boolean z16, boolean z17) {
        report(str, str2, true, map, z16, z17);
    }

    public static void reportWithAppKey(String str, String str2, Map<String, String> map, EventType eventType) {
        reportCommon(str, "", str2, true, map, eventType == EventType.REALTIME, eventType == EventType.IMMEDIATE_MSF);
    }

    public static void report(String str, String str2, Map<String, String> map, EventType eventType) {
        report(str, str2, true, map, eventType == EventType.REALTIME, eventType == EventType.IMMEDIATE_MSF);
    }

    public static void report(String str, String str2, boolean z16, Map<String, String> map, boolean z17) {
        reportCommon("", str, str2, z16, map, z17, false);
    }

    public static void report(String str, String str2, boolean z16, Map<String, String> map, boolean z17, boolean z18) {
        reportCommon("", str, str2, z16, map, z17, z18);
    }
}
