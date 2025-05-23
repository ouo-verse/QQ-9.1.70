package com.tencent.mobileqq.vashealth.hippy;

import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ads.data.AdParam;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.adv.common.data.MaskAdvName;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdRenderHelper;
import com.tencent.mobileqq.vashealth.SSOHttpUtils;
import com.tencent.mobileqq.vashealth.StepCounterPermissionUtils;
import com.tencent.mobileqq.vashealth.hippy.HealthModule;
import com.tencent.mobileqq.vashealth.step.e;
import com.tencent.mobileqq.vashealth.step.k;
import com.tencent.mobileqq.vashealth.step.l;
import com.tencent.mobileqq.vashealth.t;
import com.tencent.mobileqq.vashealth.u;
import com.tencent.mobileqq.vashealth.websso.WebSSOAgent$UniSsoServerReq;
import com.tencent.mobileqq.vashealth.websso.WebSSOAgent$UniSsoServerReqComm;
import com.tencent.mobileqq.vashealth.websso.WebSSOAgent$UniSsoServerRsp;
import com.tencent.mobileqq.vashealth.websso.a;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = HealthModule.NAME)
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0001@B\u000f\u0012\u0006\u0010<\u001a\u00020;\u00a2\u0006\u0004\b=\u0010>J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\nH\u0002J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010 \u001a\u00020\u0006H\u0002J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0002H\u0007J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010(\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R2\u0010+\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00190)j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0019`*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R2\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00190)j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0019`*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010,R2\u0010.\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00190)j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0019`*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R$\u0010/\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00105\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00100\u001a\u0004\b6\u00102\"\u0004\b7\u00104R$\u00108\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00100\u001a\u0004\b9\u00102\"\u0004\b:\u00104\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/vashealth/hippy/HealthModule;", "Lcom/tencent/hippy/qq/module/QQBaseModule;", "Lcom/tencent/mtt/hippy/modules/Promise;", "promise", "", QCircleDaTongConstant.ElementParamValue.PERMISSION, "", "callBackPermission", "", "stepInfoJson", "", "getTodayStep", "Lorg/json/JSONObject;", "reportJson", "reportPromise", "sendAgentRequest", "Lcom/tencent/mtt/hippy/common/HippyMap;", "map", "checkDataUnAvailable", "checkReportDataSize", "checkReportInternal", "getReqDataStr", "cmd", "Lcom/tencent/mobileqq/vashealth/websso/WebSSOAgent$UniSsoServerRsp;", "response", "", "anaRspComm", "msfResultCode", "getMsfFailResult", "getReportSuccessResult", "svrCostTime", "getReportTimeInfo", "notifyReportSuccess", "getStepCounterPermission", "requestStepCounterPermission", "resultPromise", "getCurrentStep", "readHKData", "jsonStr", "healthSwitch", "sendAdPositionInScreen", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mPkgSizeMap", "Ljava/util/HashMap;", "mLastRequestTimeMap", "mIntervalTimeMap", "model", "Ljava/lang/String;", "getModel", "()Ljava/lang/String;", "setModel", "(Ljava/lang/String;)V", "imei", "getImei", "setImei", "zone", "getZone", "setZone", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "context", "<init>", "(Lcom/tencent/mtt/hippy/HippyEngineContext;)V", "Companion", "a", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class HealthModule extends QQBaseModule {

    @NotNull
    public static final String CALLBACK_COLUMN_BUSINESS_RET = "retCode";

    @NotNull
    public static final String CALLBACK_COLUMN_DATA = "data";

    @NotNull
    public static final String CALLBACK_COLUMN_MSG = "msg";

    @NotNull
    public static final String CALLBACK_COLUMN_SSO_RET = "result";
    public static final int CODE_BUSINESS_RET_FAILED = -1;
    public static final int CODE_BUSINESS_RET_HELPER_CLOSED = 2;
    public static final int CODE_BUSINESS_RET_STEP_ZEO = 1;
    public static final int CODE_BUSINESS_RET_SUCCESS = 0;
    public static final int CODE_BUSINESS_RET_SWITCH_COMMAND_NO_SEND = 201;
    public static final int CODE_SSO_RET_MSF_FAILED = 201;
    public static final int CODE_SSO_RET_MSF_TIMEOUT = 202;
    public static final int CODE_SSO_RET_NO_CONNECTION = 103;
    public static final int CODE_SSO_RET_PKG_SIZE_EXCEED = 101;
    public static final int CODE_SSO_RET_REQUEST_TOO_OFTEN = 102;
    public static final int CODE_SSO_RET_SUCCESS = 0;
    public static final int CODE_SSO_RET_UNKNOWN_ERROR = 255;
    public static final long DEFAULT_AGENT_SSO_MAX_PKG_SIZE = 10240;
    public static final long DEFAULT_AGENT_SSO_MIN_INTERVAL = 1000;
    public static final long DEFAULT_SERVER_COST_TIME = -1;
    private static long LAST_REPORT_TIME = 0;

    @NotNull
    public static final String NAME = "HealthModule";

    @NotNull
    public static final String REPORT_STEP_CMD = "yundong_report.steps";

    @NotNull
    private static final String TAG = "HealthNativeModule";

    @Nullable
    private String imei;

    @NotNull
    private HashMap<String, Long> mIntervalTimeMap;

    @NotNull
    private HashMap<String, Long> mLastRequestTimeMap;

    @NotNull
    private HashMap<String, Long> mPkgSizeMap;

    @Nullable
    private String model;

    @Nullable
    private String zone;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/vashealth/hippy/HealthModule$b", "Lcom/tencent/mobileqq/vashealth/t;", "", "b", "a", "health-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements t {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Promise f312279b;

        b(Promise promise) {
            this.f312279b = promise;
        }

        @Override // com.tencent.mobileqq.vashealth.t
        public void a() {
            HealthModule.this.callBackPermission(this.f312279b, false);
            QLog.d(HealthModule.TAG, 1, "hippy callback permissionDenied");
        }

        @Override // com.tencent.mobileqq.vashealth.t
        public void b() {
            HealthModule.this.callBackPermission(this.f312279b, true);
            StepCounterPermissionUtils.q();
            QLog.d(HealthModule.TAG, 1, "hippy callback permissionAllowed");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HealthModule(@NotNull HippyEngineContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPkgSizeMap = new HashMap<>();
        this.mLastRequestTimeMap = new HashMap<>();
        this.mIntervalTimeMap = new HashMap<>();
    }

    private final long anaRspComm(String cmd, WebSSOAgent$UniSsoServerRsp response) {
        if (!TextUtils.isEmpty(cmd) && cmd != null) {
            if (response.comm.delayms.has()) {
                this.mIntervalTimeMap.put(cmd, Long.valueOf(response.comm.delayms.get()));
            }
            if (response.comm.packagesize.has()) {
                this.mPkgSizeMap.put(cmd, Long.valueOf(response.comm.packagesize.get()));
            }
            if (response.comm.proctime.has()) {
                return response.comm.proctime.get();
            }
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callBackPermission(Promise promise, boolean permission) {
        StepCounterPermissionUtils.z(permission);
        try {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushBoolean(QCircleDaTongConstant.ElementParamValue.PERMISSION, StepCounterPermissionUtils.f());
            if (StepCounterPermissionUtils.m()) {
                hippyMap.pushBoolean("systemPermission", StepCounterPermissionUtils.c());
            }
            promise.resolve(hippyMap);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "requestStepCounterPermission callBackPermission:" + permission + " JSONObject put fail:" + th5);
        }
    }

    private final boolean checkDataUnAvailable(JSONObject reportJson, Promise promise, HippyMap map) {
        if (reportJson.length() <= 0) {
            promise.resolve(map);
            return true;
        }
        if (reportJson.optInt("step", 0) == 0) {
            map.pushInt("retCode", 1);
            promise.resolve(map);
            return true;
        }
        if (getActivity() == null) {
            promise.resolve(map);
            return true;
        }
        if (reportJson.optBoolean("isStepCounterEnable", true)) {
            return false;
        }
        map.pushInt("retCode", 2);
        promise.resolve(map);
        return true;
    }

    private final boolean checkReportDataSize(JSONObject reportJson) {
        long j3;
        Long l3;
        if (this.mPkgSizeMap.containsKey(REPORT_STEP_CMD) && (l3 = this.mPkgSizeMap.get(REPORT_STEP_CMD)) != null) {
            j3 = l3.longValue();
        } else {
            j3 = 10240;
        }
        if (j3 > 0) {
            String jSONObject = reportJson.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "reportJson.toString()");
            Intrinsics.checkNotNullExpressionValue(jSONObject.getBytes(Charsets.UTF_8), "this as java.lang.String).getBytes(charset)");
            if (r5.length > j3) {
                return true;
            }
            return false;
        }
        return false;
    }

    private final boolean checkReportInternal() {
        long j3;
        long j16;
        Long l3;
        if (!this.mLastRequestTimeMap.containsKey(REPORT_STEP_CMD)) {
            return false;
        }
        Long l16 = this.mLastRequestTimeMap.get(REPORT_STEP_CMD);
        if (l16 != null) {
            j3 = l16.longValue();
        } else {
            j3 = 0;
        }
        if (this.mIntervalTimeMap.containsKey(REPORT_STEP_CMD) && (l3 = this.mIntervalTimeMap.get(REPORT_STEP_CMD)) != null) {
            j16 = l3.longValue();
        } else {
            j16 = 1000;
        }
        if (j16 <= 0 || System.currentTimeMillis() - j3 >= j16) {
            return false;
        }
        this.mLastRequestTimeMap.put(REPORT_STEP_CMD, Long.valueOf(System.currentTimeMillis()));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCurrentStep$lambda$1(HippyMap stepResult, Promise resultPromise, int i3, boolean z16, Bundle bundle) {
        HashMap hashMap;
        String obj;
        Intrinsics.checkNotNullParameter(stepResult, "$stepResult");
        Intrinsics.checkNotNullParameter(resultPromise, "$resultPromise");
        if (z16) {
            QLog.i(TAG, 1, "HealthNativeModule receive stepInfoJson: " + bundle.getString("StepInfoJSON"));
            try {
                try {
                    boolean z17 = false;
                    stepResult.pushInt("retCode", 0);
                    stepResult.pushInt("step", 0);
                    Serializable serializable = bundle.getSerializable(StepCounterConstants.ATTR_STEP_COUNT_HISTORY);
                    if (serializable instanceof HashMap) {
                        hashMap = (HashMap) serializable;
                    } else {
                        hashMap = null;
                    }
                    long d16 = SSOHttpUtils.d() / 1000;
                    if (hashMap != null && hashMap.containsKey(Long.valueOf(d16))) {
                        z17 = true;
                    }
                    if (z17) {
                        Object obj2 = hashMap.get(Long.valueOf(d16));
                        if (obj2 != null && (obj = obj2.toString()) != null) {
                            stepResult.pushInt("step", Integer.parseInt(obj));
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, " day key is: " + d16 + ", current step: " + obj2);
                        }
                    }
                } catch (JSONException e16) {
                    QLog.e(TAG, 1, "receive stepInfoJson failed exception is:" + e16);
                    resultPromise.reject(e16.toString());
                }
            } finally {
                resultPromise.resolve(stepResult);
            }
        }
    }

    private final HippyMap getMsfFailResult(int msfResultCode) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt("retCode", -1);
        if (msfResultCode != 1001) {
            if (msfResultCode != 1002 && msfResultCode != 1013) {
                hippyMap.pushInt("result", 255);
                hippyMap.pushString("msg", HardCodeUtil.qqStr(R.string.n7k));
            } else {
                hippyMap.pushInt("result", 202);
                hippyMap.pushString("msg", HardCodeUtil.qqStr(R.string.n7p));
            }
        } else {
            hippyMap.pushInt("result", 201);
            hippyMap.pushString("msg", HardCodeUtil.qqStr(R.string.n7t));
        }
        return hippyMap;
    }

    private final HippyMap getReportSuccessResult(WebSSOAgent$UniSsoServerRsp response) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt("result", 0);
        if (response.ret.has()) {
            hippyMap.pushInt("retCode", (int) response.ret.get());
        } else {
            hippyMap.pushInt("retCode", 0);
        }
        if (response.errmsg.has()) {
            hippyMap.pushString("msg", response.errmsg.get());
        } else {
            hippyMap.pushString("msg", "SSO\u53d1\u9001\u6210\u529f");
        }
        if (response.rspdata.has()) {
            hippyMap.pushString("data", response.rspdata.get());
        }
        return hippyMap;
    }

    private final JSONObject getReportTimeInfo(long svrCostTime) {
        a.f312357h = System.currentTimeMillis();
        long j3 = a.f312355e - a.f312354d;
        long j16 = a.f312356f - a.f312355e;
        long j17 = a.f312357h - a.f312356f;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("packTime", j3);
        jSONObject.put("SSONetworkTime", j16);
        jSONObject.put("unpackTime", j17);
        jSONObject.put("serverProcessTime", svrCostTime);
        return jSONObject;
    }

    private final String getReqDataStr(JSONObject reportJson) {
        int optInt = reportJson.optInt("step", 0);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", 1);
        jSONObject.put("time", NetConnInfoCenter.getServerTime());
        jSONObject.put("steps", optInt);
        reportJson.put(AdParam.CONSUMERID, 1002);
        reportJson.put("data", new JSONArray().mo162put(jSONObject));
        reportJson.put("version", AppSetting.f99551k);
        if (TextUtils.isEmpty(this.model)) {
            this.model = URLEncoder.encode(DeviceInfoMonitor.getModel(), "utf-8");
        }
        reportJson.put("model", this.model);
        if (TextUtils.isEmpty(this.zone)) {
            TimeZone timeZone = TimeZone.getDefault();
            this.zone = timeZone.getDisplayName(false, 0) + " " + timeZone.getID();
        }
        reportJson.put("zone", String.valueOf(this.zone));
        if (TextUtils.isEmpty(this.imei)) {
            this.imei = QQDeviceInfo.getQIMEI();
        }
        reportJson.put("imei", String.valueOf(this.imei));
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "report parameters is:" + reportJson);
        }
        String jSONObject2 = reportJson.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "reportJson.toString()");
        return jSONObject2;
    }

    private final int getTodayStep(String stepInfoJson) {
        if (TextUtils.isEmpty(stepInfoJson)) {
            return 0;
        }
        try {
            String valueOf = String.valueOf(SSOHttpUtils.d());
            JSONObject jSONObject = new JSONObject(stepInfoJson);
            return (jSONObject.getInt(valueOf + "_total") - jSONObject.getInt(valueOf + "_init")) + jSONObject.getInt(valueOf + "_offset");
        } catch (Exception e16) {
            QLog.e(TAG, 2, "get getTodayStep failed, Exception: " + e16);
            return 0;
        }
    }

    private final void notifyReportSuccess() {
        if (getActivity() != null && getAppInterface() != null) {
            try {
                NewIntent newIntent = new NewIntent(getActivity(), u.class);
                newIntent.putExtra("msf_cmd_type", StepCounterConstants.CMD_UPDATE_LAST_REPORT_TIME);
                newIntent.putExtra("last_report_time", NetConnInfoCenter.getServerTimeMillis());
                getAppInterface().startServlet(newIntent);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "Exception:" + e16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void readHKData$lambda$2(JSONObject stepResult, HealthModule this$0, Promise promise, int i3, boolean z16, Bundle bundle) {
        Map map;
        Intrinsics.checkNotNullParameter(stepResult, "$stepResult");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(promise, "$promise");
        if (z16) {
            try {
                try {
                    Serializable serializable = bundle.getSerializable(StepCounterConstants.ATTR_STEP_COUNT_HISTORY);
                    if (serializable instanceof Map) {
                        map = (Map) serializable;
                    } else {
                        map = null;
                    }
                    long d16 = SSOHttpUtils.d() / 1000;
                    boolean z17 = false;
                    if (map != null && map.containsKey(Long.valueOf(d16))) {
                        z17 = true;
                    }
                    if (z17) {
                        stepResult.put("step", map.get(Long.valueOf(d16)));
                        QLog.e(TAG, 1, "stepHistory step:" + map.get(Long.valueOf(d16)));
                    }
                    int[] e16 = SSOHttpUtils.e();
                    int i16 = e16[1];
                    if (i16 > 0) {
                        QLog.e(TAG, 1, "use device step:" + i16);
                        stepResult.put("step", e16[1]);
                    }
                    stepResult.put("isStepCounterEnable", bundle.getBoolean(StepCounterConstants.ATTR_STEP_COUNTER_ENABLE, true));
                } catch (JSONException e17) {
                    QLog.e(TAG, 1, "receive stepInfoJson failed exception is:" + e17);
                }
            } finally {
                this$0.sendAgentRequest(stepResult, promise);
            }
        }
    }

    private final void sendAgentRequest(JSONObject reportJson, final Promise reportPromise) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt("result", 255);
        hippyMap.pushInt("retCode", -1);
        hippyMap.pushString("msg", HardCodeUtil.qqStr(R.string.n7u));
        if (checkDataUnAvailable(reportJson, reportPromise, hippyMap)) {
            return;
        }
        try {
            if (!NetworkUtil.isNetworkAvailable(getActivity())) {
                hippyMap.pushInt("result", 103);
                hippyMap.pushString("msg", "MSF\u672a\u8fde\u63a5");
                reportPromise.resolve(hippyMap);
                return;
            }
            if (checkReportDataSize(reportJson)) {
                hippyMap.pushInt("result", 101);
                hippyMap.pushString("msg", HardCodeUtil.qqStr(R.string.n7m));
                reportPromise.resolve(hippyMap);
                return;
            }
            if (checkReportInternal()) {
                hippyMap.pushInt("result", 102);
                hippyMap.pushString("msg", HardCodeUtil.qqStr(R.string.n7l));
                reportPromise.resolve(hippyMap);
                return;
            }
            this.mLastRequestTimeMap.put(REPORT_STEP_CMD, Long.valueOf(System.currentTimeMillis()));
            WebSSOAgent$UniSsoServerReqComm webSSOAgent$UniSsoServerReqComm = new WebSSOAgent$UniSsoServerReqComm();
            webSSOAgent$UniSsoServerReqComm.platform.set(109L);
            webSSOAgent$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
            webSSOAgent$UniSsoServerReqComm.mqqver.set(AppSetting.f99551k);
            WebSSOAgent$UniSsoServerReq webSSOAgent$UniSsoServerReq = new WebSSOAgent$UniSsoServerReq();
            webSSOAgent$UniSsoServerReq.comm.set(webSSOAgent$UniSsoServerReqComm);
            webSSOAgent$UniSsoServerReq.reqdata.set(getReqDataStr(reportJson));
            BusinessObserver businessObserver = new BusinessObserver() { // from class: j43.e
                @Override // mqq.observer.BusinessObserver
                public final void onReceive(int i3, boolean z16, Bundle bundle) {
                    HealthModule.sendAgentRequest$lambda$3(HealthModule.this, reportPromise, i3, z16, bundle);
                }
            };
            if (getAppInterface() != null) {
                NewIntent newIntent = new NewIntent(getActivity(), a.class);
                newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, REPORT_STEP_CMD);
                newIntent.putExtra("extra_data", webSSOAgent$UniSsoServerReq.toByteArray());
                newIntent.setObserver(businessObserver);
                getAppInterface().startServlet(newIntent);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "Exception:" + e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendAgentRequest$lambda$3(HealthModule this$0, Promise reportPromise, int i3, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportPromise, "$reportPromise");
        try {
            HippyMap hippyMap = new HippyMap();
            long j3 = -1;
            if (z16) {
                byte[] byteArray = bundle.getByteArray("extra_data");
                if (byteArray != null) {
                    WebSSOAgent$UniSsoServerRsp webSSOAgent$UniSsoServerRsp = new WebSSOAgent$UniSsoServerRsp();
                    webSSOAgent$UniSsoServerRsp.mergeFrom(byteArray);
                    j3 = this$0.anaRspComm(bundle.getString(WadlProxyConsts.EXTRA_CMD), webSSOAgent$UniSsoServerRsp);
                    hippyMap = this$0.getReportSuccessResult(webSSOAgent$UniSsoServerRsp);
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.w(TAG, 2, "uniAgent, onReceive, ret success but no data");
                    }
                    hippyMap.pushInt("result", 255);
                    hippyMap.pushInt("retCode", -1);
                    hippyMap.pushString("msg", "SSO\u8fd4\u56de\u6570\u636e\u5305\u4e3a\u7a7a");
                }
                this$0.notifyReportSuccess();
            } else {
                hippyMap = this$0.getMsfFailResult(bundle.getInt(WadlProxyConsts.EXTRA_RESULT_CODE));
            }
            QLog.i(TAG, 1, "get report result is:" + hippyMap);
            hippyMap.pushJSONObject(this$0.getReportTimeInfo(j3));
            reportPromise.resolve(hippyMap);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "uniAgent, onReceive, Exception: " + e16);
            }
        }
    }

    @HippyMethod(name = "getCurrentStep")
    public final void getCurrentStep(@NotNull final Promise resultPromise) {
        Intrinsics.checkNotNullParameter(resultPromise, "resultPromise");
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 1, "hippy call getCurrentStep");
        }
        try {
            NewIntent newIntent = new NewIntent(getActivity().getApplication(), u.class);
            newIntent.putExtra("msf_cmd_type", StepCounterConstants.CMD_REFRESH_STEPS);
            newIntent.putExtra(StepCounterConstants.ATTR_IS_REPORT_STEP, true);
            final HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt("retCode", -1);
            hippyMap.pushInt("step", 0);
            k kVar = k.f312340a;
            if (kVar.j()) {
                int b16 = e.f312337a.b(String.valueOf(l.f312344a.a(0)));
                hippyMap.pushInt("retCode", kVar.q());
                hippyMap.pushInt("step", b16);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, " current step: " + b16);
                }
                resultPromise.resolve(hippyMap);
                return;
            }
            newIntent.setObserver(new BusinessObserver() { // from class: j43.c
                @Override // mqq.observer.BusinessObserver
                public final void onReceive(int i3, boolean z16, Bundle bundle) {
                    HealthModule.getCurrentStep$lambda$1(HippyMap.this, resultPromise, i3, z16, bundle);
                }
            });
            getAppInterface().startServlet(newIntent);
        } catch (Exception e16) {
            resultPromise.reject(e16.toString());
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    @Nullable
    public final String getImei() {
        return this.imei;
    }

    @Nullable
    public final String getModel() {
        return this.model;
    }

    @HippyMethod(name = "getStepCounterPermission")
    public final void getStepCounterPermission(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        QLog.d(TAG, 1, "hippy call getStepCounterPermission");
        try {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushBoolean(QCircleDaTongConstant.ElementParamValue.PERMISSION, StepCounterPermissionUtils.f());
            if (StepCounterPermissionUtils.m()) {
                hippyMap.pushBoolean("systemPermission", StepCounterPermissionUtils.c());
            }
            promise.resolve(hippyMap);
        } catch (Exception e16) {
            promise.reject(e16.toString());
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    @Nullable
    public final String getZone() {
        return this.zone;
    }

    @HippyMethod(name = "healthSwitch")
    public final void healthSwitch(@NotNull String jsonStr, @NotNull Promise promise) {
        boolean z16;
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 1, "hippy call healthSwitch");
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "healthSwitch:" + jsonStr);
            }
            HippyMap hippyMap = new HippyMap();
            String banInfo = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.health_ban.name(), "");
            if (!TextUtils.isEmpty(banInfo)) {
                Intrinsics.checkNotNullExpressionValue(banInfo, "banInfo");
                if (Integer.parseInt(banInfo) == 0) {
                    hippyMap.pushInt("retCode", -1);
                    hippyMap.pushString("msg", HardCodeUtil.qqStr(R.string.n7n));
                    promise.resolve(hippyMap);
                    return;
                }
            }
            boolean optBoolean = new JSONObject(jsonStr).optBoolean(h.f248218g, true);
            if (getActivity() != null) {
                StepCounterPermissionUtils.z(optBoolean);
                hippyMap.pushInt("retCode", 0);
                hippyMap.pushString("msg", HardCodeUtil.qqStr(R.string.n7o));
                promise.resolve(hippyMap);
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                hippyMap.pushInt("retCode", 201);
                hippyMap.pushString("msg", HardCodeUtil.qqStr(R.string.n7u));
                promise.resolve(hippyMap);
            }
        } catch (Exception e16) {
            promise.reject(e16.toString());
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    @HippyMethod(name = "readHKData")
    public final void readHKData(@NotNull final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 1, "hippy call readHKData");
        }
        final JSONObject jSONObject = new JSONObject();
        jSONObject.put("step", 0);
        try {
            Object systemService = getActivity().getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
            if (SensorMonitor.getDefaultSensor((SensorManager) systemService, 19) == null) {
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushInt("result", 255);
                hippyMap.pushInt("retCode", -1);
                hippyMap.pushString("msg", HardCodeUtil.qqStr(R.string.n7r));
                promise.resolve(hippyMap);
                return;
            }
            k kVar = k.f312340a;
            if (kVar.j()) {
                jSONObject.put("result", 0);
                jSONObject.put("retCode", kVar.q());
                promise.resolve(jSONObject);
            } else {
                NewIntent newIntent = new NewIntent(getAppInterface().getApplication(), u.class);
                newIntent.putExtra("msf_cmd_type", StepCounterConstants.CMD_REFRESH_STEPS);
                newIntent.putExtra(StepCounterConstants.ATTR_IS_REPORT_STEP, true);
                newIntent.setObserver(new BusinessObserver() { // from class: j43.d
                    @Override // mqq.observer.BusinessObserver
                    public final void onReceive(int i3, boolean z16, Bundle bundle) {
                        HealthModule.readHKData$lambda$2(JSONObject.this, this, promise, i3, z16, bundle);
                    }
                });
                getAppInterface().startServlet(newIntent);
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "receive stepInfoJson failed exception is:" + e16);
            promise.reject(e16.toString());
        }
    }

    @HippyMethod(name = "requestStepCounterPermission")
    public final void requestStepCounterPermission(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        QLog.d(TAG, 1, "hippy call requestStepCounterPermission");
        StepCounterPermissionUtils.x(new b(promise));
    }

    @HippyMethod(name = "sendAdPositionInScreen")
    public final void sendAdPositionInScreen(@NotNull String jsonStr, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            QLog.i(TAG, 1, "mask positionInfo is " + jsonStr);
            JSONObject jSONObject = new JSONObject(jsonStr);
            MaskAdRenderHelper.INSTANCE.getMMaskAdSizeMap().put(MaskAdvName.QQ_HEALTH, new Pair<>(Integer.valueOf(jSONObject.getInt("height")), Integer.valueOf(jSONObject.getInt("top"))));
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    public final void setImei(@Nullable String str) {
        this.imei = str;
    }

    public final void setModel(@Nullable String str) {
        this.model = str;
    }

    public final void setZone(@Nullable String str) {
        this.zone = str;
    }
}
