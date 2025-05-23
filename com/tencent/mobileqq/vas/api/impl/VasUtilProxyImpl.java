package com.tencent.mobileqq.vas.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasLogReportProxy;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.mobileqq.vas.api.IVasUtilProxy;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateAdapter;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J,\u0010\u000b\u001a\u00020\u00062\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\tH\u0016J\u001c\u0010\r\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\fH\u0016J,\u0010\u0012\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J \u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0004H\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasUtilProxyImpl;", "Lcom/tencent/mobileqq/vas/api/IVasUtilProxy;", "", "isUseNewEventCode", "", "getVasCommonEventCode", "", "checkBusinessList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "collectPerformance", "", "reportCommonReal", "", "elapse", "Lcom/tencent/mobileqq/vas/VasLogReportProxy$LEVEL;", "logLevel", "reportLogReal", "Landroid/content/Context;", "context", "handleIceBreakVipClick", "srcFile", "patchFile", "dstFile", "patch", "url", "openSchema", "<init>", "()V", "Companion", "b", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasUtilProxyImpl implements IVasUtilProxy {

    @NotNull
    private static final String LOG_EVENT_CODE = "vas_log";

    @NotNull
    private static final String TAG = "VasUtilProxyImpl";
    private static volatile boolean isWeakNet;

    @NotNull
    private static String MSG_API = String.valueOf(Build.VERSION.SDK_INT);

    @NotNull
    private static String MSG_LEVEL = String.valueOf(DeviceInfoUtils.getPerfLevel());
    private static final String MSG_SUB_VERSION = AppSetting.f99551k;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/vas/api/impl/VasUtilProxyImpl$a", "Lcom/tencent/mobileqq/msf/sdk/handler/IWeakNetStatusHandler;", "", "weakReason", "", "onNormalToWeakNet", "lastWeakReason", "onWeakNetToNormal", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements IWeakNetStatusHandler {
        a() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler
        public void onNormalToWeakNet(int weakReason) {
            QLog.i(VasUtilProxyImpl.TAG, 1, "onNormalToWeakNet: " + weakReason);
            VasUtilProxyImpl.isWeakNet = true;
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler
        public void onWeakNetToNormal(int lastWeakReason) {
            QLog.i(VasUtilProxyImpl.TAG, 1, "onWeakNetToNormal: " + lastWeakReason);
            VasUtilProxyImpl.isWeakNet = false;
        }
    }

    public VasUtilProxyImpl() {
        AppNetConnInfo.registerWeakNetStatusHandler(BaseApplication.context, new a());
    }

    private final String getVasCommonEventCode(boolean isUseNewEventCode) {
        if (isUseNewEventCode) {
            return "vas_tech_common";
        }
        return "vas_common";
    }

    @Override // com.tencent.mobileqq.vas.api.IVasUtilProxy
    public void collectPerformance(@NotNull HashMap<String, String> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", ((IVasQuickUpdateAdapter) QRoute.api(IVasQuickUpdateAdapter.class)).getUpdateReportAppid(), false, 0L, -1L, params, "", true);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasUtilProxy
    public void handleIceBreakVipClick(@Nullable Context context) {
        if (context == null) {
            return;
        }
        String config = QzoneConfig.getInstance().getConfig("qqsetting", "addgroupvasjumpurl", "https://m.vip.qq.com/freedom/newbird.html?_cwv=1&_wv=553648133&g_ch=aio");
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", config);
        context.startActivity(intent);
        ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A4F7", 3, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.vas.api.IVasUtilProxy
    public void openSchema(@NotNull Context context, @NotNull String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        VasUtil.getService().getVasHybridRoute().openSchema(context, url);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasUtilProxy
    public boolean patch(@NotNull String srcFile, @NotNull String patchFile, @NotNull String dstFile) {
        Intrinsics.checkNotNullParameter(srcFile, "srcFile");
        Intrinsics.checkNotNullParameter(patchFile, "patchFile");
        Intrinsics.checkNotNullParameter(dstFile, "dstFile");
        return ((IVasQuickUpdateAdapter) QRoute.api(IVasQuickUpdateAdapter.class)).patch(srcFile, patchFile, dstFile);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasUtilProxy
    public void reportCommonReal(@NotNull Map<String, String> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        params.put(DTConstants.TAG.API, MSG_API);
        params.put("level", MSG_LEVEL);
        String MSG_SUB_VERSION2 = MSG_SUB_VERSION;
        Intrinsics.checkNotNullExpressionValue(MSG_SUB_VERSION2, "MSG_SUB_VERSION");
        params.put("sub_version", MSG_SUB_VERSION2);
        String currentUin = VasUtil.getCurrentUin(false);
        Intrinsics.checkNotNullExpressionValue(currentUin, "currentUin");
        params.put("qquin", currentUin);
        int netWorkType = NetworkUtil.getNetWorkType();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(netWorkType);
        params.put("netType", sb5.toString());
        boolean z16 = isWeakNet;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(z16 ? 1 : 0);
        params.put("weakNet", sb6.toString());
        boolean areEqual = Intrinsics.areEqual(params.get("useNewEventCode"), "1");
        params.remove("useNewEventCode");
        QQBeaconReport.reportWithAppKey(VasStatisticCollector.APP_KEY, currentUin, getVasCommonEventCode(areEqual), params);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasUtilProxy
    public void reportLogReal(@NotNull Map<String, String> params, long elapse, @NotNull VasLogReportProxy.LEVEL logLevel) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "elapse=" + elapse + ", params=" + params);
        }
        params.put(DTConstants.TAG.API, MSG_API);
        params.put("level", MSG_LEVEL);
        String currentUin = VasUtil.getCurrentUin(false);
        Intrinsics.checkNotNullExpressionValue(currentUin, "currentUin");
        params.put("qquin", currentUin);
        if (elapse >= 0) {
            params.put("consume_time", String.valueOf(elapse));
        }
        QQBeaconReport.reportWithAppKey(VasStatisticCollector.APP_KEY, currentUin, LOG_EVENT_CODE, params);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasUtilProxy
    public void checkBusinessList() {
    }
}
