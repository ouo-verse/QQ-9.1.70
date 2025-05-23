package ch3;

import android.app.Dialog;
import android.view.View;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004J\u0010\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lch3/b;", "", "Landroid/app/Dialog;", "dialog", "", "source", "", "d", "Landroid/view/View;", "btnView", TuxUIConstants.POP_BTN_TEXT, "e", "g", "b", "c", h.F, "i", "k", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_TYPE, "j", "l", "I", "opensource", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f30847a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int opensource;

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map f(int i3, String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zplan_text_type", Integer.valueOf(i3));
        return linkedHashMap;
    }

    public final void b(@Nullable Dialog dialog) {
        Map mapOf;
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("dt_pgid", "pg_zplan_ue_download");
        hashMap.put("dt_eid", "em_zplan_download_complete_toast");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("zplan_ue_download_source", Integer.valueOf(opensource)));
        hashMap.put("cur_pg", mapOf);
        VideoReport.reportEvent("dt_imp", hashMap);
    }

    public final void c(@Nullable Dialog dialog) {
        Map mapOf;
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("dt_pgid", "pg_zplan_ue_download");
        hashMap.put("dt_eid", "em_zplan_download_complete_toast");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("zplan_ue_download_source", Integer.valueOf(opensource)));
        hashMap.put("cur_pg", mapOf);
        VideoReport.reportEvent("dt_imp_end", hashMap);
    }

    public final void d(@NotNull Dialog dialog, int source) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        opensource = source;
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("zplan_ue_download_source", Integer.valueOf(source));
        VideoReport.setPageId(dialog, "pg_zplan_ue_download");
        VideoReport.setPageParams(dialog, new PageParams(hashMap));
    }

    public final void e(@NotNull View btnView, final int btnText) {
        Intrinsics.checkNotNullParameter(btnView, "btnView");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("zplan_text_type", Integer.valueOf(btnText));
        VideoReport.setElementId(btnView, "em_zplan_download_btn");
        VideoReport.setElementParams(btnView, hashMap);
        VideoReport.setEventDynamicParams(this, new IDynamicParams() { // from class: ch3.a
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map f16;
                f16 = b.f(btnText, str);
                return f16;
            }
        });
    }

    public final void g(@NotNull View btnView, int btnText) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(btnView, "btnView");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("dt_pgid", "pg_zplan_ue_download");
        hashMap.put("dt_eid", "em_zplan_download_btn");
        hashMap.put("zplan_text_type", Integer.valueOf(btnText));
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("zplan_ue_download_source", Integer.valueOf(opensource)));
        hashMap.put("cur_pg", mapOf);
        VideoReport.reportEvent("dt_imp", hashMap);
    }

    public final void h(@NotNull Dialog dialog) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("dt_pgid", "pg_zplan_ue_download");
        hashMap.put("dt_eid", "em_zplan_server_download_toast");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("zplan_ue_download_source", Integer.valueOf(opensource)));
        hashMap.put("cur_pg", mapOf);
        VideoReport.reportEvent("dt_imp", hashMap);
    }

    public final void i(@NotNull Dialog dialog) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("dt_pgid", "pg_zplan_ue_download");
        hashMap.put("dt_eid", "em_zplan_server_download_toast");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("zplan_ue_download_source", Integer.valueOf(opensource)));
        hashMap.put("cur_pg", mapOf);
        VideoReport.reportEvent("dt_imp_end", hashMap);
    }

    public final void j(@NotNull Dialog dialog, @NotNull String clickType) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(clickType, "clickType");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("dt_pgid", "pg_zplan_ue_download");
        hashMap.put("dt_eid", "em_zplan_traffic_toast");
        hashMap.put("zplan_clck_type", clickType);
        hashMap.put("zplan_is_selected_when_clck", 0);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("zplan_ue_download_source", Integer.valueOf(opensource)));
        hashMap.put("cur_pg", mapOf);
        VideoReport.reportEvent("dt_clck", hashMap);
    }

    public final void k(@NotNull Dialog dialog) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("dt_pgid", "pg_zplan_ue_download");
        hashMap.put("dt_eid", "em_zplan_traffic_toast");
        hashMap.put("zplan_clck_type", "");
        hashMap.put("zplan_is_selected_when_clck", 0);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("zplan_ue_download_source", Integer.valueOf(opensource)));
        hashMap.put("cur_pg", mapOf);
        VideoReport.reportEvent("dt_imp", hashMap);
    }

    public final void l(@NotNull Dialog dialog) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("dt_pgid", "pg_zplan_ue_download");
        hashMap.put("dt_eid", "em_zplan_traffic_toast");
        hashMap.put("zplan_clck_type", "");
        hashMap.put("zplan_is_selected_when_clck", 0);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("zplan_ue_download_source", Integer.valueOf(opensource)));
        hashMap.put("cur_pg", mapOf);
        VideoReport.reportEvent("dt_imp_end", hashMap);
    }
}
