package com.tencent.mobileqq.teamwork.api.impl;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.teamwork.api.ITDocAttaReporterApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt___MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J4\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u001c\u0010\n\u001a\u00020\t2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u000bH\u0016JX\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/teamwork/api/impl/TDocAttaReporterApiImpl;", "Lcom/tencent/mobileqq/teamwork/api/ITDocAttaReporterApi;", "", TDocAttaReporterApiImpl.KEY_OPERNAME, "module", "action", "", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "report", "", "", TDocAttaReporterApiImpl.KEY_VER6, "", TDocAttaReporterApiImpl.KEY_VER7, TDocAttaReporterApiImpl.KEY_VER8, TDocAttaReporterApiImpl.KEY_VER9, TDocAttaReporterApiImpl.KEY_VER10, TDocAttaReporterApiImpl.KEY_VER11, TDocAttaReporterApiImpl.KEY_VER12, TDocAttaReporterApiImpl.KEY_OBJ2, TDocAttaReporterApiImpl.KEY_OBJ3, "fileBrowserReport", "<init>", "()V", "Companion", "a", "tencentdoc-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class TDocAttaReporterApiImpl implements ITDocAttaReporterApi {

    @NotNull
    private static final String DEVICE_LEVEL = "device_level";

    @NotNull
    private static final String HOST = "https://h.trace.qq.com/kv";

    @NotNull
    private static final String KEY_ACTION = "action";

    @NotNull
    private static final String KEY_ATTA_ID = "attaid";

    @NotNull
    private static final String KEY_ATTA_TYPE = "Atta-Type";

    @NotNull
    private static final String KEY_BAND = "band";

    @NotNull
    private static final String KEY_EVENT_CODE = "event_code";

    @NotNull
    private static final String KEY_MODEL = "model";

    @NotNull
    private static final String KEY_MODULE = "module";

    @NotNull
    private static final String KEY_OBJ1 = "obj1";

    @NotNull
    private static final String KEY_OBJ2 = "obj2";

    @NotNull
    private static final String KEY_OBJ3 = "obj3";

    @NotNull
    private static final String KEY_OPERNAME = "opername";

    @NotNull
    private static final String KEY_OS_VERSION = "os_version";

    @NotNull
    private static final String KEY_PLATFORM = "platform";

    @NotNull
    private static final String KEY_SDK_INT = "sdk_int";

    @NotNull
    private static final String KEY_SOURCE1 = "source1";

    @NotNull
    private static final String KEY_SOURCE2 = "source2";

    @NotNull
    private static final String KEY_SOURCE3 = "source3";

    @NotNull
    private static final String KEY_TOKEN = "token";

    @NotNull
    private static final String KEY_UIN = "uin";

    @NotNull
    private static final String KEY_VER10 = "ver10";

    @NotNull
    private static final String KEY_VER11 = "ver11";

    @NotNull
    private static final String KEY_VER12 = "ver12";

    @NotNull
    private static final String KEY_VER6 = "ver6";

    @NotNull
    private static final String KEY_VER7 = "ver7";

    @NotNull
    private static final String KEY_VER8 = "ver8";

    @NotNull
    private static final String KEY_VER9 = "ver9";

    @NotNull
    private static final String KEY_VERSION_CODE = "app_version";

    @NotNull
    private static final String REQUEST_TYPE = "GET";

    @NotNull
    private static final String TAG = "ITDocAttaReporterApi";

    @NotNull
    private static final String VALUE_ATTA_ID = "0e800070676";

    @NotNull
    private static final String VALUE_ATTA_PLATFORM = "Android";

    @NotNull
    private static final String VALUE_ATTA_TYPE = "batch-report";

    @NotNull
    private static final String VALUE_TOKEN = "9124528893";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void report$lambda$3(Map reportParams) {
        String message;
        List list;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(reportParams, "$reportParams");
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("reportParams: ");
            list = MapsKt___MapsKt.toList(reportParams);
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, ",", null, null, 0, null, null, 62, null);
            sb5.append(joinToString$default);
            QLog.i(TAG, 2, sb5.toString());
        }
        Uri.Builder buildUpon = Uri.parse("https://h.trace.qq.com/kv").buildUpon();
        buildUpon.appendQueryParameter("token", VALUE_TOKEN);
        buildUpon.appendQueryParameter(KEY_ATTA_ID, VALUE_ATTA_ID);
        buildUpon.appendQueryParameter("uin", MobileQQ.sMobileQQ.getLastLoginUin());
        buildUpon.appendQueryParameter("platform", "Android");
        buildUpon.appendQueryParameter(KEY_BAND, Build.BOARD);
        buildUpon.appendQueryParameter("model", DeviceInfoMonitor.getModel());
        buildUpon.appendQueryParameter("app_version", AppSetting.f99551k);
        buildUpon.appendQueryParameter("os_version", Build.VERSION.RELEASE);
        buildUpon.appendQueryParameter(KEY_SDK_INT, String.valueOf(Build.VERSION.SDK_INT));
        for (Map.Entry entry : reportParams.entrySet()) {
            buildUpon.appendQueryParameter((String) entry.getKey(), String.valueOf(entry.getValue()));
        }
        String uri = buildUpon.build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "uriBuilder.build().toString()");
        Bundle bundle = new Bundle();
        bundle.putString("Atta-Type", "batch-report");
        try {
            message = HttpUtil.openUrl(BaseApplication.getContext(), uri, "GET", null, bundle);
        } catch (IOException e16) {
            QLog.e(TAG, 1, "report atta IOException, url=" + uri, e16);
            message = e16.getMessage();
        } catch (ClassNotFoundException e17) {
            QLog.e(TAG, 1, "report atta ClassNotFoundException, url=" + uri, e17);
            message = e17.getMessage();
        }
        QLog.i(TAG, 1, "report atta, result = " + message + "  url = " + uri);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocAttaReporterApi
    public void fileBrowserReport(@NotNull String action, int ver6, long ver7, @NotNull String ver8, long ver9, int ver10, @NotNull String ver11, int ver12, @NotNull String obj2, @NotNull String obj3) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(ver8, "ver8");
        Intrinsics.checkNotNullParameter(ver11, "ver11");
        Intrinsics.checkNotNullParameter(obj2, "obj2");
        Intrinsics.checkNotNullParameter(obj3, "obj3");
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put(KEY_OPERNAME, "native_sdk");
        concurrentHashMap.put("module", "preview_page");
        concurrentHashMap.put("action", action);
        concurrentHashMap.put("event_code", "native_sdk-preview_page-" + action);
        concurrentHashMap.put(KEY_VER6, Integer.valueOf(ver6));
        concurrentHashMap.put(KEY_VER7, Long.valueOf(ver7));
        concurrentHashMap.put(KEY_VER8, ver8);
        concurrentHashMap.put(KEY_VER9, Long.valueOf(ver9));
        concurrentHashMap.put(KEY_VER10, Integer.valueOf(ver10));
        concurrentHashMap.put(KEY_VER11, ver11);
        concurrentHashMap.put(KEY_VER12, Integer.valueOf(ver12));
        concurrentHashMap.put(KEY_SOURCE3, "s_qq_file_androidsdk");
        concurrentHashMap.put(KEY_OBJ2, obj2);
        concurrentHashMap.put(KEY_OBJ3, obj3);
        report(concurrentHashMap);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocAttaReporterApi
    public void report(@NotNull String opername, @NotNull String module, @NotNull String action, @NotNull Map<String, Object> reportParams) {
        Intrinsics.checkNotNullParameter(opername, "opername");
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(reportParams, "reportParams");
        reportParams.put(KEY_OPERNAME, opername);
        reportParams.put("module", module);
        reportParams.put("action", action);
        reportParams.put("event_code", opername + '-' + module + '-' + action);
        report(reportParams);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocAttaReporterApi
    public void report(@NotNull final Map<String, ? extends Object> reportParams) {
        Intrinsics.checkNotNullParameter(reportParams, "reportParams");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.teamwork.api.impl.n
            @Override // java.lang.Runnable
            public final void run() {
                TDocAttaReporterApiImpl.report$lambda$3(reportParams);
            }
        }, 128, null, false);
    }
}
