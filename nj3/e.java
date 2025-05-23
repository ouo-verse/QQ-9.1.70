package nj3;

import android.view.View;
import android.widget.RelativeLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.filament.zplanservice.pbjava.QQBeaconReport$QQBeaconReportRequest;
import com.tencent.filament.zplanservice.pbjava.QQReport$QQReportRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J@\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0002JH\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J$\u0010\r\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J$\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00022\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0014H\u0016\u00a8\u0006\u0018"}, d2 = {"Lnj3/e;", "Lel0/e;", "", "pageId", "", "", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "event", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "f", "elementId", "d", "e", "eventCode", "params", "c", "Lcom/tencent/filament/zplanservice/pbjava/QQReport$QQReportRequest;", "req", "a", "Lcom/tencent/filament/zplanservice/pbjava/QQBeaconReport$QQBeaconReportRequest;", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e implements el0.e {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001\u00a8\u0006\u0005"}, d2 = {"nj3/e$b", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b extends TypeToken<Map<String, ? extends Object>> {
        b() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001\u00a8\u0006\u0005"}, d2 = {"nj3/e$c", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c extends TypeToken<Map<String, Object>> {
        c() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001\u00a8\u0006\u0005"}, d2 = {"nj3/e$d", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class d extends TypeToken<Map<String, Object>> {
        d() {
        }
    }

    private final void c(String eventCode, Map<String, String> params) {
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).reportToBeacon("0AND0YAG6R40RLM6", eventCode, params);
    }

    private final void d(String pageId, Map<String, ? extends Object> pageParams, String elementId, String event, Map<String, ? extends Object> reportParams) {
        RelativeLayout relativeLayout = new RelativeLayout(BaseApplication.context);
        View view = new View(BaseApplication.context);
        relativeLayout.addView(view);
        VideoReport.setPageId(relativeLayout, pageId);
        VideoReport.setPageParams(relativeLayout, new PageParams(pageParams));
        VideoReport.setElementId(view, elementId);
        VideoReport.reportEvent(event, view, reportParams);
    }

    private final void e(String event, Map<String, ? extends Object> reportParams) {
        VideoReport.reportEvent(event, reportParams);
    }

    private final void f(String pageId, Map<String, ? extends Object> pageParams, String event, Map<String, ? extends Object> reportParams) {
        RelativeLayout relativeLayout = new RelativeLayout(BaseApplication.context);
        VideoReport.setPageId(relativeLayout, pageId);
        VideoReport.setPageParams(relativeLayout, new PageParams(pageParams));
        VideoReport.setPageReportPolicy(relativeLayout, PageReportPolicy.REPORT_ALL);
        VideoReport.reportEvent(event, relativeLayout, reportParams);
    }

    @Override // el0.e
    public void a(QQReport$QQReportRequest req) {
        Map<String, ? extends Object> linkedHashMap;
        Map<String, ? extends Object> linkedHashMap2;
        Intrinsics.checkNotNullParameter(req, "req");
        String pageId = req.page_id.get();
        String elementId = req.element_id.get();
        String event = req.event.get();
        String str = req.params.get();
        String str2 = req.page_params.get();
        int i3 = req.report_type.get();
        try {
            linkedHashMap = (Map) new Gson().fromJson(str2, new c().getType());
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap<>();
            }
        } catch (Throwable th5) {
            QLog.e("QQReportChannelProxy", 1, "parse pageParams failed.", th5);
            linkedHashMap = new LinkedHashMap<>();
        }
        Map<String, ? extends Object> map = linkedHashMap;
        try {
            Map<String, ? extends Object> map2 = (Map) new Gson().fromJson(str, new d().getType());
            if (map2 == null) {
                map2 = new LinkedHashMap<>();
            }
            linkedHashMap2 = map2;
        } catch (Throwable th6) {
            QLog.e("QQReportChannelProxy", 1, "parse params failed.", th6);
            linkedHashMap2 = new LinkedHashMap<>();
        }
        linkedHashMap2.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        if (i3 == 0) {
            Intrinsics.checkNotNullExpressionValue(event, "event");
            e(event, linkedHashMap2);
            return;
        }
        if (i3 == 1) {
            Intrinsics.checkNotNullExpressionValue(pageId, "pageId");
            Intrinsics.checkNotNullExpressionValue(event, "event");
            f(pageId, map, event, linkedHashMap2);
        } else if (i3 != 2) {
            Intrinsics.checkNotNullExpressionValue(event, "event");
            e(event, linkedHashMap2);
        } else {
            Intrinsics.checkNotNullExpressionValue(pageId, "pageId");
            Intrinsics.checkNotNullExpressionValue(elementId, "elementId");
            Intrinsics.checkNotNullExpressionValue(event, "event");
            d(pageId, map, elementId, event, linkedHashMap2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // el0.e
    public void b(QQBeaconReport$QQBeaconReportRequest req) {
        Map emptyMap;
        int mapCapacity;
        Intrinsics.checkNotNullParameter(req, "req");
        PBStringField pBStringField = req.event;
        String str = pBStringField != null ? pBStringField.get() : null;
        if (str == null || str.length() == 0) {
            QLog.e("QQReportChannelProxy", 1, "beaconReport failed, event nullOrEmpty.");
            return;
        }
        try {
            Map map = (Map) new Gson().fromJson(req.params.get(), new b().getType());
            if (map == null) {
                map = MapsKt__MapsKt.emptyMap();
            }
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(map.size());
            emptyMap = new LinkedHashMap(mapCapacity);
            for (Object obj : map.entrySet()) {
                emptyMap.put(((Map.Entry) obj).getKey(), ((Map.Entry) obj).getValue().toString());
            }
        } catch (Throwable th5) {
            QLog.e("QQReportChannelProxy", 1, "beaconReport, parse params failed.", th5);
            emptyMap = MapsKt__MapsKt.emptyMap();
        }
        c(str, emptyMap);
    }
}
