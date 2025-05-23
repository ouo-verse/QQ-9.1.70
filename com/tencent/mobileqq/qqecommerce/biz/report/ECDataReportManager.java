package com.tencent.mobileqq.qqecommerce.biz.report;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.utils.ECThreadUtilKt;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqecommerce.base.runtime.ECRuntimeManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.timi.game.api.ITimiGameApi;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import nf4.d;
import tl.h;
import vf2.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b\"\u0010#J.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J&\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002J\u001c\u0010\f\u001a\u00020\t2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J\u001c\u0010\u000e\u001a\u00020\u00072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u001c\u0010\u000f\u001a\u00020\u00022\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J.\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\u0014\u001a\f\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\u00042\u0006\u0010\u0010\u001a\u00020\u0005H\u0016JH\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00022\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J@\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J8\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00052\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016JB\u0010\u001f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u00022\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J&\u0010!\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/report/ECDataReportManager;", "Lcom/tencent/ecommerce/base/report/api/IECDataReport;", "", AdMetricTag.EVENT_NAME, "", "", "params", "", "useNewMethod", "", "d", "c", "b", "extAction", "g", h.F, "target", "f", "action", "dataReport", "getElementParams", "pageId", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "autoReport", "attachDtReport", "Landroid/view/View;", "elementId", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "bindDtReportInfo", "updateDtReportInfo", "eventId", "reportCustomDtEvent", "resetDtReportInfo", "invokeDtExtAction", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECDataReportManager implements IECDataReport {
    private final void b(Map<String, String> params) {
        if (params.containsKey(DTParamKey.REPORT_KEY_APPKEY)) {
            return;
        }
        if (!TypeIntrinsics.isMutableMap(params)) {
            params = null;
        }
        if (params != null) {
            String APP_KEY = com.tencent.mobileqq.kandian.repo.report.a.f240074a;
            Intrinsics.checkNotNullExpressionValue(APP_KEY, "APP_KEY");
            params.put(DTParamKey.REPORT_KEY_APPKEY, APP_KEY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Map map, boolean z16, String eventName) {
        String str;
        Intrinsics.checkNotNullParameter(eventName, "$eventName");
        HashMap<String, String> hashMap = new HashMap<>();
        for (Map.Entry entry : map.entrySet()) {
            hashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        ECRuntimeManager eCRuntimeManager = new ECRuntimeManager();
        hashMap.putAll(eCRuntimeManager.a());
        hashMap.putAll(eCRuntimeManager.getDeviceInfo());
        QLog.d("ECDataReportManager", 1, "real call dataBeaconReport ,useNewMethod:" + z16 + ",eventName:" + eventName + ",data:" + hashMap);
        if (map.containsKey("custom_beacon_app_key")) {
            str = String.valueOf(map.get("custom_beacon_app_key"));
        } else {
            str = "0DOU0QDD2U4LOCOP";
        }
        String str2 = str;
        if (z16) {
            QQBeaconReport.reportWithAppKey(str2, String.valueOf(ECRuntimeManager.INSTANCE.e()), eventName, true, hashMap, true);
        } else {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str2, String.valueOf(ECRuntimeManager.INSTANCE.e()), eventName, true, -1L, -1L, hashMap, (String) null, true);
        }
    }

    private final Object f(Object target) {
        View view;
        return ((target instanceof Activity) || !(target instanceof Fragment) || (view = ((Fragment) target).getView()) == null) ? target : view;
    }

    private final boolean g(Map<String, ? extends Object> extAction) {
        return !Intrinsics.areEqual(extAction.get(IECDtReport.ACTION_DATA_READY), Boolean.FALSE);
    }

    private final String h(Map<String, ? extends Object> extAction) {
        Object obj = extAction.get(IECDtReport.ACTION_MULTI_SCENE);
        String str = obj instanceof String ? (String) obj : null;
        return str == null ? "" : str;
    }

    @Override // com.tencent.ecommerce.base.report.api.IECDtReport
    public void attachDtReport(Object target, String pageId, Map<String, String> pageParams, boolean autoReport, Map<String, ? extends Object> extAction) {
        Activity activity;
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(pageParams, "pageParams");
        Intrinsics.checkNotNullParameter(extAction, "extAction");
        if (target instanceof Activity) {
            activity = (Activity) target;
        } else {
            activity = target instanceof Fragment ? ((Fragment) target).getActivity() : null;
        }
        Object f16 = f(target);
        if (Intrinsics.areEqual(h(extAction), IECDtReport.INSTANCE.d())) {
            c.f441540a.a(pageParams);
            ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().b(f16, pageId, pageParams);
            if (autoReport && activity != null) {
                VideoReport.addToDetectionWhitelist(activity);
            }
        } else {
            if (autoReport && activity != null) {
                VideoReport.addToDetectionWhitelist(activity);
            }
            if (g(extAction)) {
                VideoReport.setPageId(f16, pageId);
            } else {
                VideoReport.setPageIdNotBizReady(f16, pageId);
            }
            b(pageParams);
            VideoReport.setPageParams(f16, new PageParams(pageParams));
        }
        invokeDtExtAction(f16, extAction);
    }

    @Override // com.tencent.ecommerce.base.report.api.IECDtReport
    public void bindDtReportInfo(View target, String elementId, Map<String, String> reportParams, Map<String, ? extends Object> extAction) {
        String str;
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(reportParams, "reportParams");
        Intrinsics.checkNotNullParameter(extAction, "extAction");
        if (Intrinsics.areEqual(h(extAction), IECDtReport.INSTANCE.d())) {
            c.f441540a.a(reportParams);
            String str2 = reportParams.get(IECDtReport.ACTION_IDENTIFIER);
            if (str2 != null) {
                if (Intrinsics.areEqual(str2, "")) {
                    str2 = null;
                }
                str = str2;
            } else {
                str = null;
            }
            ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(target, true, str, elementId, reportParams);
        } else {
            if (g(extAction)) {
                VideoReport.setElementId(target, elementId);
            } else {
                VideoReport.setElementIdNotBizReady(target, elementId);
            }
            b(reportParams);
            VideoReport.setElementParams(target, reportParams);
        }
        invokeDtExtAction(target, extAction);
        ECThreadUtilKt.f(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.report.ECDataReportManager$bindDtReportInfo$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                VideoReport.traverseExposure();
            }
        });
    }

    @Override // com.tencent.ecommerce.base.report.api.IECDataReport
    public void dataReport(String action, Map<Object, ? extends Object> params, boolean useNewMethod) {
        Intrinsics.checkNotNullParameter(action, "action");
        d(action, params, useNewMethod);
        c(action, params);
    }

    @Override // com.tencent.ecommerce.base.report.api.IECDtReport
    public Map<String, ?> getElementParams(Object target) {
        Intrinsics.checkNotNullParameter(target, "target");
        Map<String, ?> elementParams = VideoReport.getElementParams(target);
        Intrinsics.checkNotNullExpressionValue(elementParams, "getElementParams(target)");
        return elementParams;
    }

    @Override // com.tencent.ecommerce.base.report.api.IECDtReport
    public void invokeDtExtAction(final Object target, Map<String, ? extends Object> extAction) {
        ExposurePolicy exposurePolicy;
        EndExposurePolicy endExposurePolicy;
        ClickPolicy clickPolicy;
        Intrinsics.checkNotNullParameter(extAction, "extAction");
        for (Map.Entry<String, ? extends Object> entry : extAction.entrySet()) {
            if (target != null) {
                String key = entry.getKey();
                switch (key.hashCode()) {
                    case -1618432855:
                        if (key.equals(IECDtReport.ACTION_IDENTIFIER) && !Intrinsics.areEqual(entry.getValue(), "")) {
                            Object value = entry.getValue();
                            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.String");
                            VideoReport.setElementReuseIdentifier(target, (String) value);
                            break;
                        }
                        break;
                    case 100995873:
                        if (key.equals(IECDtReport.ACTION_TRAVERSE_PAGE) && (target instanceof View)) {
                            ECThreadUtilKt.f(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.report.ECDataReportManager$invokeDtExtAction$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    VideoReport.traversePage((View) target);
                                }
                            });
                            break;
                        }
                        break;
                    case 367444502:
                        if (key.equals(IECDtReport.ACTION_EXPOSE_POLICY)) {
                            Object value2 = entry.getValue();
                            IECDtReport.Companion companion = IECDtReport.INSTANCE;
                            if (Intrinsics.areEqual(value2, Integer.valueOf(companion.c()))) {
                                exposurePolicy = ExposurePolicy.REPORT_NONE;
                            } else if (Intrinsics.areEqual(value2, Integer.valueOf(companion.b()))) {
                                exposurePolicy = ExposurePolicy.REPORT_FIRST;
                            } else if (Intrinsics.areEqual(value2, Integer.valueOf(companion.a()))) {
                                exposurePolicy = ExposurePolicy.REPORT_ALL;
                            } else {
                                exposurePolicy = ExposurePolicy.REPORT_ALL;
                            }
                            VideoReport.setElementExposePolicy(target, exposurePolicy);
                            break;
                        } else {
                            break;
                        }
                    case 411816585:
                        if (key.equals(IECDtReport.ACTION_EXPOSE_END_POLICY)) {
                            Object value3 = entry.getValue();
                            IECDtReport.Companion companion2 = IECDtReport.INSTANCE;
                            if (Intrinsics.areEqual(value3, Integer.valueOf(companion2.c()))) {
                                endExposurePolicy = EndExposurePolicy.REPORT_NONE;
                            } else if (Intrinsics.areEqual(value3, Integer.valueOf(companion2.a()))) {
                                endExposurePolicy = EndExposurePolicy.REPORT_ALL;
                            } else {
                                endExposurePolicy = EndExposurePolicy.REPORT_ALL;
                            }
                            VideoReport.setElementEndExposePolicy(target, endExposurePolicy);
                            break;
                        } else {
                            break;
                        }
                    case 1252004058:
                        if (key.equals(IECDtReport.ACTION_CLICK_POLICY)) {
                            Object value4 = entry.getValue();
                            IECDtReport.Companion companion3 = IECDtReport.INSTANCE;
                            if (Intrinsics.areEqual(value4, Integer.valueOf(companion3.c()))) {
                                clickPolicy = ClickPolicy.REPORT_NONE;
                            } else if (Intrinsics.areEqual(value4, Integer.valueOf(companion3.a()))) {
                                clickPolicy = ClickPolicy.REPORT_ALL;
                            } else {
                                clickPolicy = ClickPolicy.REPORT_ALL;
                            }
                            VideoReport.setElementClickPolicy(target, clickPolicy);
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
    }

    @Override // com.tencent.ecommerce.base.report.api.IECDtReport
    public void reportCustomDtEvent(Object target, String eventId, Map<String, String> reportParams, Map<String, ? extends Object> extAction) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(reportParams, "reportParams");
        Intrinsics.checkNotNullParameter(extAction, "extAction");
        if (Intrinsics.areEqual(h(extAction), IECDtReport.INSTANCE.d())) {
            c.f441540a.a(reportParams);
            if (target != null) {
                d liveReportUtil = ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil();
                Object f16 = f(target);
                Intrinsics.checkNotNull(f16, "null cannot be cast to non-null type java.lang.Object");
                liveReportUtil.reportEvent(eventId, f16, reportParams);
            } else {
                ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent(eventId, reportParams);
            }
        } else {
            b(reportParams);
            if (target != null) {
                VideoReport.reportEvent(eventId, f(target), reportParams);
            } else {
                VideoReport.reportEvent(eventId, reportParams);
            }
        }
        if (target != null) {
            invokeDtExtAction(f(target), extAction);
        } else {
            invokeDtExtAction(null, extAction);
        }
    }

    @Override // com.tencent.ecommerce.base.report.api.IECDtReport
    public void resetDtReportInfo(Object target) {
        Intrinsics.checkNotNullParameter(target, "target");
        VideoReport.resetElementParams(target);
        VideoReport.setElementId(target, "");
    }

    @Override // com.tencent.ecommerce.base.report.api.IECDtReport
    public void updateDtReportInfo(Object target, Map<String, String> reportParams, Map<String, ? extends Object> extAction) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(reportParams, "reportParams");
        Intrinsics.checkNotNullParameter(extAction, "extAction");
        Object f16 = f(target);
        if (!Intrinsics.areEqual(h(extAction), IECDtReport.INSTANCE.d())) {
            b(reportParams);
            if (!(target instanceof Activity) && !(target instanceof Fragment)) {
                if (target instanceof View) {
                    VideoReport.setElementParams(f16, reportParams);
                    VideoReport.setElementBizReady(f16);
                }
            } else {
                VideoReport.setPageParams(f16, new PageParams(reportParams));
                VideoReport.setPageBizReady(f16);
            }
        }
        invokeDtExtAction(f16, extAction);
        if (target instanceof View) {
            ECThreadUtilKt.f(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.report.ECDataReportManager$updateDtReportInfo$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    VideoReport.traverseExposure();
                }
            });
        }
    }

    private final void d(final String eventName, final Map<Object, ? extends Object> params, final boolean useNewMethod) {
        if (params == null) {
            QLog.e("ECDataReportManager", 1, "dataBeaconReport params is null,eventName:" + eventName);
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.report.a
            @Override // java.lang.Runnable
            public final void run() {
                ECDataReportManager.e(params, useNewMethod, eventName);
            }
        }, 128, null, false);
    }

    private final void c(String eventName, Map<Object, ? extends Object> params) {
    }
}
