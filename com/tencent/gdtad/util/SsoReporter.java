package com.tencent.gdtad.util;

import android.os.Build;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.abtest.AdABTestConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0012j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0013H\u0002J2\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\"\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0012j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/gdtad/util/SsoReporter;", "", "()V", "AD_REPORT_RETURN", "", "AD_REPORT_START", "AD_REQUEST_RETURN_FAILED", "AD_REQUEST_RETURN_SUCCESS", "AD_REQUEST_START", "APP_KEY", "COST_TIME_KEY", "POS_ID_KEY", "RESULT_KEY", "SSO_SUCCESS_CODE", "", "TAB_EXPERIMENT_KEY", "TAG", "getReportParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "reportAdRequestEvent", "", "eventId", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "qqad-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class SsoReporter {

    @NotNull
    public static final String AD_REPORT_RETURN = "";

    @NotNull
    public static final String AD_REPORT_START = "";

    @NotNull
    public static final String AD_REQUEST_RETURN_FAILED = "ad_request_return_failed";

    @NotNull
    public static final String AD_REQUEST_RETURN_SUCCESS = "ad_request_return_success";

    @NotNull
    public static final String AD_REQUEST_START = "ad_request_start";

    @NotNull
    public static final String APP_KEY = "0DOU0J4CUI43WCQ1";

    @NotNull
    public static final String COST_TIME_KEY = "cost_time";

    @NotNull
    public static final SsoReporter INSTANCE = new SsoReporter();

    @NotNull
    public static final String POS_ID_KEY = "pos_id";

    @NotNull
    public static final String RESULT_KEY = "retCode";
    public static final int SSO_SUCCESS_CODE = 0;

    @NotNull
    public static final String TAB_EXPERIMENT_KEY = "assignment";

    @NotNull
    public static final String TAG = "SsoReporter";

    SsoReporter() {
    }

    private final HashMap<String, String> getReportParams() {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            String currentUin = VasUtil.getCurrentUin();
            Intrinsics.checkNotNullExpressionValue(currentUin, "getCurrentUin()");
            hashMap.put("uin", currentUin);
            String qimei = QQDeviceInfo.getQIMEI();
            Intrinsics.checkNotNullExpressionValue(qimei, "getQIMEI()");
            hashMap.put("imei", qimei);
            hashMap.put(StartupReportKey.PLATFORM_ID, "2");
            String MODEL = DeviceInfoMonitor.getModel();
            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
            hashMap.put("phone_model", MODEL);
            String BRAND = Build.BRAND;
            Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
            hashMap.put("phone_brands", BRAND);
            String subVersion = AppSetting.f99551k;
            Intrinsics.checkNotNullExpressionValue(subVersion, "subVersion");
            hashMap.put(AppConstants.Preferences.QQ_VERSION, subVersion);
            hashMap.put(TAB_EXPERIMENT_KEY, AdABTestConstants.EXP_QQ_AD_SSO_TEST);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "get msgType failed, error is " + e16);
        }
        return hashMap;
    }

    public final void reportAdRequestEvent(@NotNull String eventId, @NotNull HashMap<String, String> reportParams) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(reportParams, "reportParams");
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 2, "report ad request, event is " + eventId);
        }
        HashMap<String, String> reportParams2 = getReportParams();
        reportParams2.putAll(reportParams);
        QQBeaconReport.reportWithAppKey(APP_KEY, VasUtil.getCurrentUin(), eventId, reportParams2);
    }
}
