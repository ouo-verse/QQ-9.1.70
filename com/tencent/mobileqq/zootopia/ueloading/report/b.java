package com.tencent.mobileqq.zootopia.ueloading.report;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.zootopia.download.mod.hotpatch.ZPlanModHotPatchConfig;
import com.tencent.mobileqq.zplan.event.api.Event;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.HashMap;
import java.util.Map;
import k74.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b5\u00106J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JL\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0005J.\u0010\u001a\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0005J.\u0010\u001c\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0007J\u0016\u0010\u001e\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0005J\u0016\u0010\u001f\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0005J.\u0010 \u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\fJ\u001e\u0010!\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\"\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010#\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010$\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002J\"\u0010&\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u0005J\u000e\u0010'\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002J*\u0010*\u001a\u00020\u00142\u0006\u0010)\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010,\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\fJ\u000e\u0010-\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010.\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\fJ\u000e\u0010/\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u00100\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u00101\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u00104\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ueloading/report/b;", "", "Lcom/tencent/mobileqq/zootopia/ueloading/report/c;", "params", "", "", "b", "", "mapId", "", VasPerfReportUtils.WHILE_COST_TOTAL, "stepCost", "", "background", "isNewLoading", "source", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_IS_DOWNLOADED, "a", "isSuccess", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "d", QCircleWeakNetReporter.KEY_COST, "url", "errorCode", "errorMsg", "c", "resType", "u", "fromSource", "v", "w", HippyTKDListViewAdapter.X, "y", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, h.F, "o", "code", "p", "r", "Lcom/tencent/mobileqq/zootopia/download/mod/hotpatch/ZPlanModHotPatchConfig;", "modConfig", ReportConstant.COSTREPORT_PREFIX, "f", "g", "j", "k", "l", DomainData.DOMAIN_NAME, "i", "status", "type", "e", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f329531a = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/report/b$a", "Lrh3/b;", "", "onSuccess", "", "errorCode", "", "msg", "onFailed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements rh3.b {
        a() {
        }

        @Override // rh3.b
        public void onFailed(int errorCode, String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.i("ZPlanUETechReportHelper_", 1, "reportModResDownloadError to event. onFailed " + errorCode + " " + msg2);
        }

        @Override // rh3.b
        public void onSuccess() {
            QLog.i("ZPlanUETechReportHelper_", 1, "reportModResDownloadError to event. onSuccess");
        }
    }

    b() {
    }

    private final Map<String, String> a(int mapId, long totalCost, long stepCost, boolean background, boolean isNewLoading, String source, boolean isDownloaded) {
        HashMap hashMap = new HashMap();
        hashMap.put("k_mod_map_id", String.valueOf(mapId));
        hashMap.put("k_total_cost", String.valueOf(totalCost));
        hashMap.put("k_cost_time", String.valueOf(stepCost));
        hashMap.put("k_background_load", z(background));
        hashMap.put("k_is_new_loading", z(isNewLoading));
        hashMap.put("k_loading_enter_source", source);
        hashMap.put("k_loading_download_status", z(isDownloaded));
        return hashMap;
    }

    private final Map<String, String> b(ZPlanUETechReportParams params) {
        return a(params.getMapId(), params.getTotalCost(), params.getStepCost(), params.getBackground(), params.getIsNewLoading(), params.getSource(), params.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_IS_DOWNLOADED java.lang.String());
    }

    public final void c(int mapId, long cost, String url, int errorCode, String errorMsg) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        HashMap hashMap = new HashMap();
        hashMap.put("k_mod_map_id", String.valueOf(mapId));
        hashMap.put("k_total_cost", String.valueOf(cost));
        hashMap.put("k_download_task_url", url);
        hashMap.put("k_error_code", String.valueOf(errorCode));
        hashMap.put("k_error_message", errorMsg);
        mb4.c.c(mb4.c.f416532a, "e_zplan_loading_download_finish", hashMap, false, 4, null);
    }

    public final void d(String mapId) {
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        HashMap hashMap = new HashMap();
        hashMap.put("k_mod_map_id", mapId);
        mb4.c.c(mb4.c.f416532a, "e_zplan_loading_start_download", hashMap, false, 4, null);
    }

    public final void e(ZPlanUETechReportParams params, int status, int type) {
        Intrinsics.checkNotNullParameter(params, "params");
        Map<String, String> b16 = b(params);
        b16.put("k_loading_exit_type ", String.valueOf(type));
        b16.put("k_loading_status", String.valueOf(status));
        mb4.c.c(mb4.c.f416532a, "e_zplan_loading_exit", b16, false, 4, null);
    }

    public final void f(ZPlanUETechReportParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        mb4.c.c(mb4.c.f416532a, "e_zplan_loading_get_dress_info", b(params), false, 4, null);
    }

    public final void g(ZPlanUETechReportParams params, boolean isSuccess) {
        Intrinsics.checkNotNullParameter(params, "params");
        Map<String, String> b16 = b(params);
        b16.put("k_loading_get_dress_info_result", z(isSuccess));
        mb4.c.c(mb4.c.f416532a, "e_zplan_loading_get_dress_info", b16, false, 4, null);
    }

    public final void h(ZPlanUETechReportParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        mb4.c.c(mb4.c.f416532a, "e_zplan_loading_loader_init", b(params), false, 4, null);
    }

    public final void i(ZPlanUETechReportParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        mb4.c.c(mb4.c.f416532a, "e_zplan_loading_close", b(params), false, 4, null);
    }

    public final void j(ZPlanUETechReportParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        mb4.c.c(mb4.c.f416532a, "e_zplan_loading_run_enter_avater", b(params), false, 4, null);
    }

    public final void k(ZPlanUETechReportParams params, boolean isSuccess) {
        Intrinsics.checkNotNullParameter(params, "params");
        Map<String, String> b16 = b(params);
        b16.put("k_n2l_result", z(isSuccess));
        mb4.c.c(mb4.c.f416532a, "e_zplan_loading_run_enter_avater", b16, false, 4, null);
    }

    public final void l(ZPlanUETechReportParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        mb4.c.c(mb4.c.f416532a, "e_zplan_loading_first_frame", b(params), false, 4, null);
    }

    public final void m(ZPlanUETechReportParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        mb4.c.c(mb4.c.f416532a, "e_zplan_loading_loading_init", b(params), false, 4, null);
    }

    public final void n(ZPlanUETechReportParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        mb4.c.c(mb4.c.f416532a, "e_zplan_loading_close_event", b(params), false, 4, null);
    }

    public final void o(ZPlanUETechReportParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        mb4.c.c(mb4.c.f416532a, "e_zplan_loading_check_base_info", b(params), false, 4, null);
    }

    public final void p(ZPlanUETechReportParams params, int code, String errorMsg) {
        String str;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100233", false);
        Map<String, String> b16 = b(params);
        b16.put("k_check_base_info_result", String.valueOf(code));
        String str2 = "1";
        if (params.getNeedDownloadCommonMod()) {
            str = "1";
        } else {
            str = "0";
        }
        b16.put("k_need_download", str);
        if (!isSwitchOn) {
            str2 = "0";
        }
        b16.put("k_switch_state", str2);
        b16.put("k_download_source", String.valueOf(params.getDownloadCommonModSource()));
        b16.put("k_error_code", String.valueOf(code));
        b16.put("k_error_message", errorMsg);
        mb4.c.c(mb4.c.f416532a, "e_zplan_loading_check_base_info", b16, false, 4, null);
    }

    public final void r(ZPlanUETechReportParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        mb4.c.c(mb4.c.f416532a, "e_zplan_loading_native_hot_patch", b(params), false, 4, null);
    }

    public final void s(ZPlanModHotPatchConfig modConfig, ZPlanUETechReportParams params, int code, String errorMsg) {
        String str;
        Intrinsics.checkNotNullParameter(modConfig, "modConfig");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        boolean enableHotPatch = modConfig.getEnableHotPatch();
        Map<String, String> b16 = b(params);
        b16.put("k_error_code", String.valueOf(code));
        b16.put("k_error_message", errorMsg);
        if (enableHotPatch) {
            str = "1";
        } else {
            str = "0";
        }
        b16.put("k_switch_state", str);
        mb4.c.c(mb4.c.f416532a, "e_zplan_loading_native_hot_patch", b16, false, 4, null);
    }

    public final void u(String mapId, String url, int errorCode, String errorMsg, int resType) {
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        HashMap hashMap = new HashMap();
        hashMap.put("k_download_task_url", url);
        hashMap.put("k_mod_map_id", mapId);
        hashMap.put("k_error_code", String.valueOf(errorCode));
        hashMap.put("k_error_message", errorMsg);
        hashMap.put("k_mod_res_type", String.valueOf(resType));
        mb4.c.c(mb4.c.f416532a, "e_zplan_loading_mod_res_download_error", hashMap, false, 4, null);
        ((rh3.a) i.INSTANCE.a(rh3.a.class)).report(new Event("e_zplan_loading_mod_res_download_error", 0, errorCode, errorMsg, hashMap, 2, null), new a());
    }

    public final void v(int mapId, String fromSource) {
        Intrinsics.checkNotNullParameter(fromSource, "fromSource");
        HashMap hashMap = new HashMap();
        hashMap.put("k_mod_map_id", String.valueOf(mapId));
        hashMap.put("k_loading_enter_source", fromSource);
        mb4.c.c(mb4.c.f416532a, "e_zplan_loading_run_start_mod", hashMap, false, 4, null);
    }

    public final void w(int mapId, String fromSource) {
        Intrinsics.checkNotNullParameter(fromSource, "fromSource");
        HashMap hashMap = new HashMap();
        hashMap.put("k_mod_map_id", String.valueOf(mapId));
        hashMap.put("k_loading_enter_source", fromSource);
        mb4.c.c(mb4.c.f416532a, "e_zplan_loading_loading_start_engine", hashMap, false, 4, null);
    }

    public final void x(int mapId, String fromSource, String cost, String totalCost, boolean isSuccess) {
        Intrinsics.checkNotNullParameter(fromSource, "fromSource");
        Intrinsics.checkNotNullParameter(cost, "cost");
        Intrinsics.checkNotNullParameter(totalCost, "totalCost");
        HashMap hashMap = new HashMap();
        hashMap.put("k_mod_map_id", String.valueOf(mapId));
        hashMap.put("k_loading_enter_source", fromSource);
        hashMap.put("k_cost_time", cost);
        hashMap.put("k_total_cost", totalCost);
        hashMap.put("k_engine_result", z(isSuccess));
        mb4.c.c(mb4.c.f416532a, "e_zplan_loading_loading_start_engine", hashMap, false, 4, null);
    }

    public final void y(int mapId, String fromSource, String totalCost) {
        Intrinsics.checkNotNullParameter(fromSource, "fromSource");
        Intrinsics.checkNotNullParameter(totalCost, "totalCost");
        HashMap hashMap = new HashMap();
        hashMap.put("k_mod_map_id", String.valueOf(mapId));
        hashMap.put("k_loading_enter_source", fromSource);
        hashMap.put("k_total_cost", totalCost);
        mb4.c.c(mb4.c.f416532a, "e_zplan_loading_loading_start_container", hashMap, false, 4, null);
    }

    private final String z(boolean isSuccess) {
        if (isSuccess) {
            return "1";
        }
        return "0";
    }

    public static /* synthetic */ void q(b bVar, ZPlanUETechReportParams zPlanUETechReportParams, int i3, String str, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        if ((i16 & 4) != 0) {
            str = "";
        }
        bVar.p(zPlanUETechReportParams, i3, str);
    }

    public static /* synthetic */ void t(b bVar, ZPlanModHotPatchConfig zPlanModHotPatchConfig, ZPlanUETechReportParams zPlanUETechReportParams, int i3, String str, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        if ((i16 & 8) != 0) {
            str = "";
        }
        bVar.s(zPlanModHotPatchConfig, zPlanUETechReportParams, i3, str);
    }
}
