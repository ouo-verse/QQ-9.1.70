package com.tencent.mobileqq.login.api.impl;

import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.login.api.ILoginReporter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.tianjige.a;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqprotect.qsec.api.IO3CollectDataApi;
import com.tencent.qqprotect.qsec.api.IO3ReportApi;
import com.tencent.util.NumberUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LoginReporterImpl implements ILoginReporter {
    static IPatchRedirector $redirector_ = null;
    private static final String EVENT_LOGIN_FINISH = "login_finish";
    private static final String EVENT_LOGIN_START = "login_start";
    private static final String EVENT_SHOW_MSG_TAB = "show_msg_tab";
    private static final String EVENT_VERIFY_DEV_LOCK = "verify_dev_lock";
    public static final String HISTOGRAM_LOGIN_COST = "login_cost_histogram";
    private static final String KEY_LOGIN_COST = "login_cost";
    private static final String KEY_LOGIN_SCENE = "login_scene";
    private static final String KEY_LOGIN_TYPE = "login_type";
    private static final String KEY_LOGIN_UIN = "login_uin";
    private static final String KEY_RET_CODE = "ret_code";
    private static final String KEY_SUCCESS = "login_success";
    private static final String KEY_VERIFY_DEV_LOCK = "verify_dev_lock";
    public static final String METRIC_LOGIN_FINISH = "login_finish_count";
    public static final String METRIC_LOGIN_START = "login_start_count";
    public static final String METRIC_SHOW_MSG_TAB = "show_msg_tab_count";
    public static final String METRIC_VERIFY_DEV_LOCK = "verify_dev_lock_count";
    private static final String SCENE_ADD_ACCOUNT = "add_account";
    private static final String SCENE_FIND_PWD = "find_pwd";
    private static final String SCENE_MAIN_LOGIN = "main_login";
    private static final String SCENE_OPEN_LOGIN = "open_login";
    private static final String SCENE_REGISTER = "register";
    private static final String SCENE_SUB_LOGIN = "sub_login";
    private static final long SESSION_TIMEOUT = 1800000;
    private static final String TAG = "LoginReporterImpl";
    private static final String TASK_LOGIN = "QLogin";
    private static final String TYPE_ACCOUNT = "account";
    private static final String TYPE_DIRECT = "direct";
    private static final String TYPE_PHONE = "phone";
    private static final String TYPE_WECHAT = "wechat";
    private final AtomicBoolean mHasInitConfig;
    private final AtomicBoolean mHasInitMetricConfig;
    private boolean mHasVerifyDevLock;
    private boolean mHasVerifyPuzzle;
    private boolean mHasWechatLoginBinding;
    private final Map<String, Long> mLoginExpoTimeMap;
    private int mLoginScene;
    private String mLoginSceneForBeacon;
    private final Map<String, Long> mLoginStartTimeMap;
    private int mLoginType;
    private String mLoginTypeForBeacon;
    private String mLoginUin;
    private String mSessionId;
    private long mSessionTimestamp;
    private String mTraceId;

    public LoginReporterImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mHasInitConfig = new AtomicBoolean(false);
        this.mHasInitMetricConfig = new AtomicBoolean(false);
        this.mSessionId = null;
        this.mSessionTimestamp = 0L;
        this.mTraceId = null;
        this.mLoginScene = 0;
        this.mLoginSceneForBeacon = null;
        this.mLoginType = 0;
        this.mLoginTypeForBeacon = null;
        this.mLoginUin = null;
        this.mHasVerifyPuzzle = false;
        this.mHasVerifyDevLock = false;
        this.mHasWechatLoginBinding = false;
        this.mLoginExpoTimeMap = new ConcurrentHashMap();
        this.mLoginStartTimeMap = new ConcurrentHashMap();
    }

    private HashMap<String, String> buildCommonParams() {
        HashMap<String, String> hashMap = new HashMap<>();
        String str = this.mLoginSceneForBeacon;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        hashMap.put(KEY_LOGIN_SCENE, str);
        String str3 = this.mLoginTypeForBeacon;
        if (str3 != null) {
            str2 = str3;
        }
        hashMap.put("login_type", str2);
        return hashMap;
    }

    private boolean checkSessionInvalid() {
        if (!TextUtils.isEmpty(this.mSessionId) && System.currentTimeMillis() - this.mSessionTimestamp < 1800000) {
            return false;
        }
        return true;
    }

    private String convertLoginSceneForBeacon(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 7) {
                                return "";
                            }
                            return SCENE_FIND_PWD;
                        }
                        return SCENE_REGISTER;
                    }
                    return SCENE_OPEN_LOGIN;
                }
                return SCENE_ADD_ACCOUNT;
            }
            return SCENE_SUB_LOGIN;
        }
        return "main_login";
    }

    private String convertLoginTypeForBeacon(int i3) {
        if (isDirectLogin()) {
            return TYPE_DIRECT;
        }
        if (isAccountLogin()) {
            return "account";
        }
        if (isPhoneLogin()) {
            return "phone";
        }
        if (isWechatLogin()) {
            return "wechat";
        }
        return "";
    }

    private String generateTimeKey(int i3, int i16) {
        return i3 + "_" + i16;
    }

    private AppRuntime getAppRuntime() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private long getLoginCostTime() {
        String generateTimeKey = generateTimeKey(this.mLoginScene, this.mLoginType);
        if (this.mLoginStartTimeMap.containsKey(generateTimeKey)) {
            long longValue = this.mLoginStartTimeMap.get(generateTimeKey).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (longValue < currentTimeMillis) {
                return currentTimeMillis - longValue;
            }
            return 0L;
        }
        return 0L;
    }

    private long getLoginCostTimeFromExpo() {
        String generateTimeKey = generateTimeKey(this.mLoginScene, this.mLoginType);
        if (this.mLoginExpoTimeMap.containsKey(generateTimeKey)) {
            long longValue = this.mLoginExpoTimeMap.get(generateTimeKey).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (longValue < currentTimeMillis) {
                return currentTimeMillis - longValue;
            }
        }
        return getLoginCostTime();
    }

    private String getLoginVerifyInfo() {
        boolean z16 = this.mHasVerifyPuzzle;
        if (z16 && this.mHasVerifyDevLock) {
            return "1";
        }
        if (z16) {
            return "2";
        }
        if (this.mHasVerifyDevLock) {
            return "3";
        }
        return "4";
    }

    private String getWechatLoginVerifyInfo() {
        boolean z16 = this.mHasWechatLoginBinding;
        if (z16 && this.mHasVerifyDevLock) {
            return "3";
        }
        if (z16) {
            return "2";
        }
        if (this.mHasVerifyDevLock) {
            return "1";
        }
        return "0";
    }

    private void initMetricConfig() {
        if (this.mHasInitMetricConfig.compareAndSet(false, true)) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                com.tencent.mobileqq.tianjige.metric.f.d(3, new a.C8649a().o("qq").m(1.0d).l(AppSetting.n()).n(false).k());
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16.toString());
            }
            QLog.d(TAG, 2, "initMetricConfig cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private void initTelemetryConfig() {
        if (this.mHasInitConfig.compareAndSet(false, true)) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                com.tencent.mobileqq.tianjige.f.e(3, new a.C8649a().o("qq").m(1.0d).l(AppSetting.n()).n(false).k());
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16.toString());
            }
            QLog.d(TAG, 2, "initTelemetryConfig cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private boolean isAccountLogin() {
        int i3 = this.mLoginType;
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            return true;
        }
        return false;
    }

    private boolean isDirectLogin() {
        if (this.mLoginType == 8) {
            return true;
        }
        return false;
    }

    private boolean isPhoneLogin() {
        int i3 = this.mLoginType;
        if (i3 != 4 && i3 != 5 && i3 != 7) {
            return false;
        }
        return true;
    }

    private boolean isWechatLogin() {
        if (this.mLoginType == 6) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportLoginDevLockVerify$1(DevlockInfo devlockInfo) {
        String str;
        reportTraceEvent("verify_dev_lock", buildCommonParams());
        com.tencent.mobileqq.tianjige.metric.f.b(3).b(METRIC_VERIFY_DEV_LOCK).c(1L, buildCommonParams());
        if (isAccountLogin()) {
            ReportController.r(getAppRuntime(), "dc00898", "", getLoginUinForReport(), "0X800ADD9", "0X800ADD9", getLoginEntranceForReport(), 0, "", "", "", "");
            if (devlockInfo == null || TextUtils.isEmpty(devlockInfo.Mobile)) {
                ReportController.r(getAppRuntime(), "dc00898", "", getLoginUinForReport(), "0X800BA0B", "0X800BA0B", getLoginEntranceForReport(), 0, "", "", "", "");
            }
        }
        if (this.mLoginType == 6) {
            AppRuntime appRuntime = getAppRuntime();
            String loginUinForReport = getLoginUinForReport();
            if (this.mHasWechatLoginBinding) {
                str = "1";
            } else {
                str = "2";
            }
            ReportController.r(appRuntime, "dc00898", "", loginUinForReport, "0X800C451", "0X800C451", 0, 0, "", str, o.c(), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportLoginDevLockVerifyEnd$2(boolean z16) {
        int i3;
        String str;
        if (this.mLoginType == 6) {
            AppRuntime appRuntime = getAppRuntime();
            String loginUinForReport = getLoginUinForReport();
            if (z16) {
                i3 = 0;
            } else {
                i3 = 2;
            }
            int i16 = i3;
            if (this.mHasWechatLoginBinding) {
                str = "1";
            } else {
                str = "2";
            }
            ReportController.r(appRuntime, "dc00898", "", loginUinForReport, "0X800C452", "0X800C452", 0, i16, "", str, o.c(), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportLoginFinish$3(String str, boolean z16) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String valueOf = String.valueOf(NumberUtil.stringToInt(str, 0));
        long loginCostTime = getLoginCostTime();
        QLog.i(TAG, 2, "report login costTime: " + loginCostTime + " costTimeFromExpo:" + getLoginCostTimeFromExpo());
        HashMap<String, String> buildCommonParams = buildCommonParams();
        String str7 = "1";
        if (z16) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        buildCommonParams.put(KEY_SUCCESS, str2);
        buildCommonParams.put("ret_code", valueOf);
        if (this.mHasVerifyDevLock) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        buildCommonParams.put("verify_dev_lock", str3);
        buildCommonParams.put(KEY_LOGIN_COST, String.valueOf(loginCostTime));
        QQBeaconReport.report(getAppRuntime().getCurrentUin(), EVENT_LOGIN_FINISH, buildCommonParams);
        HashMap<String, String> buildCommonParams2 = buildCommonParams();
        if (z16) {
            str4 = "1";
        } else {
            str4 = "0";
        }
        buildCommonParams2.put(KEY_SUCCESS, str4);
        buildCommonParams2.put("ret_code", valueOf);
        if (this.mHasVerifyDevLock) {
            str5 = "1";
        } else {
            str5 = "0";
        }
        buildCommonParams2.put("verify_dev_lock", str5);
        reportTraceEvent(EVENT_LOGIN_FINISH, buildCommonParams2);
        HashMap<String, String> buildCommonParams3 = buildCommonParams();
        if (z16) {
            str6 = "1";
        } else {
            str6 = "0";
        }
        buildCommonParams3.put(KEY_SUCCESS, str6);
        if (!this.mHasVerifyDevLock) {
            str7 = "0";
        }
        buildCommonParams3.put("verify_dev_lock", str7);
        com.tencent.mobileqq.tianjige.metric.h b16 = com.tencent.mobileqq.tianjige.metric.f.b(3);
        b16.b(METRIC_LOGIN_FINISH).c(1L, buildCommonParams3);
        b16.f(HISTOGRAM_LOGIN_COST, new Double[]{Double.valueOf(1000.0d), Double.valueOf(5000.0d), Double.valueOf(10000.0d), Double.valueOf(20000.0d), Double.valueOf(30000.0d), Double.valueOf(40000.0d), Double.valueOf(50000.0d), Double.valueOf(60000.0d), Double.valueOf(120000.0d), Double.valueOf(180000.0d)}).c(loginCostTime, buildCommonParams3);
        if (z16) {
            reportLoginSuccessByT();
        }
        if ("main_login".equals(this.mLoginSceneForBeacon) && z16) {
            return;
        }
        com.tencent.mobileqq.tianjige.f.a().b(TASK_LOGIN, 0, buildCommonParams2);
        reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportLoginShowMsgTab$4() {
        String str;
        HashMap<String, String> buildCommonParams = buildCommonParams();
        String str2 = "1";
        if (this.mHasVerifyDevLock) {
            str = "1";
        } else {
            str = "0";
        }
        buildCommonParams.put("verify_dev_lock", str);
        HashMap<String, String> buildCommonParams2 = buildCommonParams();
        if (!this.mHasVerifyDevLock) {
            str2 = "0";
        }
        buildCommonParams2.put("verify_dev_lock", str2);
        com.tencent.mobileqq.tianjige.metric.f.b(3).b(METRIC_SHOW_MSG_TAB).c(1L, buildCommonParams2);
        reportTraceEvent(EVENT_SHOW_MSG_TAB, buildCommonParams);
        com.tencent.mobileqq.tianjige.f.a().b(TASK_LOGIN, 0, buildCommonParams);
        reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportLoginStart$0(int i3, int i16, String str) {
        String str2;
        reset();
        this.mLoginScene = i3;
        this.mLoginSceneForBeacon = convertLoginSceneForBeacon(i3);
        this.mLoginType = i16;
        this.mLoginTypeForBeacon = convertLoginTypeForBeacon(i16);
        this.mLoginUin = str;
        this.mSessionId = UUID.randomUUID().toString();
        this.mSessionTimestamp = System.currentTimeMillis();
        this.mLoginStartTimeMap.put(generateTimeKey(i3, i16), Long.valueOf(System.currentTimeMillis()));
        QLog.d(TAG, 2, "reportLoginStart scene:" + i3 + " type:" + i16 + " uin:" + StringUtil.getSimpleUinForPrint(str) + " sessionId:" + this.mSessionId);
        HashMap<String, String> buildCommonParams = buildCommonParams();
        if (str != null) {
            str2 = str;
        } else {
            str2 = "";
        }
        buildCommonParams.put(KEY_LOGIN_UIN, str2);
        QQBeaconReport.report(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), EVENT_LOGIN_START, buildCommonParams);
        initTelemetryConfig();
        initMetricConfig();
        this.mTraceId = com.tencent.mobileqq.tianjige.f.a().t(TASK_LOGIN, null);
        reportTraceEvent(EVENT_LOGIN_START, buildCommonParams());
        com.tencent.mobileqq.tianjige.metric.f.b(3).b(METRIC_LOGIN_START).c(1L, buildCommonParams());
        if (isDirectLogin()) {
            ReportController.r(getAppRuntime(), "dc00898", "", "", "0X800C277", "0X800C277", getLoginEntranceForReport(), 0, "", "", "", str);
        }
        ((IO3ReportApi) QRoute.api(IO3ReportApi.class)).reportLoginClick(str, i3, i16);
    }

    private void reportLoginSuccessByT() {
        String valueOf = String.valueOf(getLoginCostTimeFromExpo());
        String c16 = o.c();
        if (isAccountLogin() && this.mHasVerifyDevLock) {
            ReportController.r(getAppRuntime(), "dc00898", "", getLoginUinForReport(), "0X800C231", "0X800C231", getLoginEntranceForReport(), 0, "", "", "", "");
        }
        if (isAccountLogin()) {
            ReportController.r(getAppRuntime(), "dc00898", "", getLoginUinForReport(), "0X800BAB7", "0X800BAB7", getLoginEntranceForReport(), 0, valueOf, getLoginVerifyInfo(), c16, getLoginUinForReport());
        }
        if (isDirectLogin()) {
            ReportController.r(getAppRuntime(), "dc00898", "", "", "0X800C278", "0X800C278", getLoginEntranceForReport(), 0, "", "", "", getLoginUinForReport());
            ReportController.r(getAppRuntime(), "dc00898", "", "", "0X800C2E4", "0X800C2E4", getLoginEntranceForReport(), 0, valueOf, "", c16, "");
        }
        if (isWechatLogin()) {
            ReportController.r(getAppRuntime(), "dc00898", "", "", "0X800C2E1", "0X800C2E1", getLoginEntranceForReport(), 0, valueOf, getWechatLoginVerifyInfo(), c16, "");
        }
        if (this.mLoginType == 5) {
            ReportController.r(getAppRuntime(), "dc00898", "", "", "0X800C31E", "0X800C31E", getLoginEntranceForReport(), 0, valueOf, getLoginVerifyInfo(), c16, getLoginUinForReport());
        }
        if (this.mLoginType == 7) {
            ReportController.r(getAppRuntime(), "dc00898", "", "", "0X800C31D", "0X800C31D", getLoginEntranceForReport(), 0, valueOf, getLoginVerifyInfo(), c16, getLoginUinForReport());
        }
        if (this.mLoginType == 4) {
            ReportController.r(getAppRuntime(), "dc00898", "", "", "0X800B8D8", "0X800B8D8", getLoginEntranceForReport(), 0, valueOf, getLoginVerifyInfo(), c16, "");
        }
    }

    private void reportTraceEvent(String str, Map<String, String> map) {
        QLog.d(TAG, 2, "reportTraceEvent traceId:" + this.mTraceId + " event:" + str);
        com.tencent.mobileqq.tianjige.f.a().h(TASK_LOGIN, str, map);
    }

    private void reset() {
        this.mSessionId = null;
        this.mSessionTimestamp = 0L;
        this.mTraceId = null;
        this.mLoginScene = 0;
        this.mLoginSceneForBeacon = null;
        this.mLoginType = 0;
        this.mLoginTypeForBeacon = null;
        this.mLoginUin = null;
        this.mHasVerifyPuzzle = false;
        this.mHasVerifyDevLock = false;
        this.mHasWechatLoginBinding = false;
    }

    @Override // com.tencent.mobileqq.login.api.ILoginReporter
    public int getLoginEntranceForReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        if (checkSessionInvalid()) {
            return 0;
        }
        return this.mLoginScene;
    }

    @Override // com.tencent.mobileqq.login.api.ILoginReporter
    public String getLoginUinForReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        if (!checkSessionInvalid() && !TextUtils.isEmpty(this.mLoginUin)) {
            try {
                return String.valueOf(Long.parseLong(this.mLoginUin));
            } catch (NumberFormatException unused) {
            }
        }
        return "";
    }

    @Override // com.tencent.mobileqq.login.api.ILoginReporter
    public void reportLoginDevLockVerify(final DevlockInfo devlockInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) devlockInfo);
            return;
        }
        if (this.mHasVerifyDevLock) {
            return;
        }
        if (checkSessionInvalid()) {
            QLog.d(TAG, 2, "reportLoginVerifyDevLock session is invalid");
            return;
        }
        QLog.d(TAG, 2, "reportLoginVerifyDevLock sessionId:" + this.mSessionId);
        this.mHasVerifyDevLock = true;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.login.api.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                LoginReporterImpl.this.lambda$reportLoginDevLockVerify$1(devlockInfo);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.login.api.ILoginReporter
    public void reportLoginDevLockVerifyEnd(final boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        if (checkSessionInvalid()) {
            QLog.d(TAG, 2, "reportLoginDevLockVerifyEnd session is invalid");
            return;
        }
        QLog.d(TAG, 2, "reportLoginDevLockVerifyEnd sessionId:" + this.mSessionId);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.login.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                LoginReporterImpl.this.lambda$reportLoginDevLockVerifyEnd$2(z16);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.login.api.ILoginReporter
    public void reportLoginFinish(final boolean z16, final String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), str);
            return;
        }
        if (checkSessionInvalid()) {
            QLog.d(TAG, 2, "reportLoginFinish session is invalid");
            return;
        }
        QLog.d(TAG, 2, "reportLoginFinish sessionId:" + this.mSessionId + " success:" + z16 + " retCode:" + str);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.login.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                LoginReporterImpl.this.lambda$reportLoginFinish$3(str, z16);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.login.api.ILoginReporter
    public void reportLoginPageExposure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        QLog.d(TAG, 2, "reportLoginPageExposure scene:" + i3 + " type:" + i16);
        this.mLoginExpoTimeMap.put(generateTimeKey(i3, i16), Long.valueOf(System.currentTimeMillis()));
        ((IO3ReportApi) QRoute.api(IO3ReportApi.class)).reportLoginExposure(i3, i16);
        ((IO3CollectDataApi) QRoute.api(IO3CollectDataApi.class)).sampling(getAppRuntime().getApplicationContext(), AegisLogger.LOGIN, AegisLogger.LOGIN);
    }

    @Override // com.tencent.mobileqq.login.api.ILoginReporter
    public void reportLoginPuzzleVerify() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.mHasVerifyPuzzle) {
            return;
        }
        if (checkSessionInvalid()) {
            QLog.d(TAG, 2, "reportLoginPuzzleVerify session is invalid");
            return;
        }
        QLog.d(TAG, 2, "reportLoginPuzzleVerify sessionId:" + this.mSessionId);
        this.mHasVerifyPuzzle = true;
    }

    @Override // com.tencent.mobileqq.login.api.ILoginReporter
    public void reportLoginShowMsgTab() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            if (checkSessionInvalid()) {
                return;
            }
            QLog.d(TAG, 2, "reportLoginShowMsgTab");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.login.api.impl.c
                @Override // java.lang.Runnable
                public final void run() {
                    LoginReporterImpl.this.lambda$reportLoginShowMsgTab$4();
                }
            }, 16, null, true);
        }
    }

    @Override // com.tencent.mobileqq.login.api.ILoginReporter
    public void reportLoginStart(final int i3, final int i16, final String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.login.api.impl.e
                @Override // java.lang.Runnable
                public final void run() {
                    LoginReporterImpl.this.lambda$reportLoginStart$0(i3, i16, str);
                }
            }, 16, null, true);
        }
    }

    @Override // com.tencent.mobileqq.login.api.ILoginReporter
    public void reportWechatLoginBinding() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.mHasWechatLoginBinding) {
            return;
        }
        if (checkSessionInvalid()) {
            QLog.d(TAG, 2, "reportWechatLoginBinding session is invalid");
            return;
        }
        QLog.d(TAG, 2, "reportWechatLoginBinding sessionId:" + this.mSessionId);
        this.mHasWechatLoginBinding = true;
    }
}
