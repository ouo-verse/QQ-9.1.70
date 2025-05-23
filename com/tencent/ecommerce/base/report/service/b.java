package com.tencent.ecommerce.base.report.service;

import android.view.View;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016JH\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J@\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J8\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016JB\u0010\u0017\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u00022\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J&\u0010\u0018\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u001a\u0010\u001a\u001a\f\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\u00042\u0006\u0010\u000b\u001a\u00020\u0005H\u0016R\u0016\u0010\u001d\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/ecommerce/base/report/service/b;", "Lcom/tencent/ecommerce/base/report/api/IECDataReport;", "", "action", "", "", "params", "", "useNewMethod", "", "dataReport", "target", "pageId", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "autoReport", "extAction", "attachDtReport", "Landroid/view/View;", "elementId", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "bindDtReportInfo", "updateDtReportInfo", "eventId", "reportCustomDtEvent", "invokeDtExtAction", "resetDtReportInfo", "getElementParams", "a", "Lcom/tencent/ecommerce/base/report/api/IECDataReport;", "reporter", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class b implements IECDataReport {

    /* renamed from: b, reason: collision with root package name */
    public static final b f100913b = new b();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static IECDataReport reporter = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getReporter();

    b() {
    }

    @Override // com.tencent.ecommerce.base.report.api.IECDtReport
    public void attachDtReport(Object target, String pageId, Map<String, String> pageParams, boolean autoReport, Map<String, ? extends Object> extAction) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(pageParams);
        linkedHashMap.putAll(a.f100911a.a(pageParams.get("bus_id")));
        reporter.attachDtReport(target, pageId, linkedHashMap, autoReport, extAction);
    }

    @Override // com.tencent.ecommerce.base.report.api.IECDtReport
    public void bindDtReportInfo(View target, String elementId, Map<String, String> reportParams, Map<String, ? extends Object> extAction) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(reportParams);
        linkedHashMap.putAll(a.f100911a.a(reportParams.get("bus_id")));
        reporter.bindDtReportInfo(target, elementId, linkedHashMap, extAction);
    }

    @Override // com.tencent.ecommerce.base.report.api.IECDataReport
    public void dataReport(String action, Map<Object, ? extends Object> params, boolean useNewMethod) {
        String valueOf;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (params != null) {
            linkedHashMap.putAll(params);
        }
        a aVar = a.f100911a;
        if ((params != null ? params.get("bus_id") : null) == null) {
            valueOf = "";
        } else {
            valueOf = String.valueOf(params.get("bus_id"));
        }
        linkedHashMap.putAll(aVar.a(valueOf));
        if (QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getRuntime().isDebug()) {
            cg0.a.b("ECDataReport", "[dataReport] action=" + action + " params=" + params + " reportData=" + linkedHashMap);
        }
        reporter.dataReport(action, linkedHashMap, useNewMethod);
    }

    @Override // com.tencent.ecommerce.base.report.api.IECDtReport
    public Map<String, ?> getElementParams(Object target) {
        return reporter.getElementParams(target);
    }

    @Override // com.tencent.ecommerce.base.report.api.IECDtReport
    public void invokeDtExtAction(Object target, Map<String, ? extends Object> extAction) {
        reporter.invokeDtExtAction(target, extAction);
    }

    @Override // com.tencent.ecommerce.base.report.api.IECDtReport
    public void reportCustomDtEvent(Object target, String eventId, Map<String, String> reportParams, Map<String, ? extends Object> extAction) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(reportParams);
        linkedHashMap.putAll(a.f100911a.a(reportParams.get("bus_id")));
        reporter.reportCustomDtEvent(target, eventId, linkedHashMap, extAction);
    }

    @Override // com.tencent.ecommerce.base.report.api.IECDtReport
    public void resetDtReportInfo(Object target) {
        reporter.resetDtReportInfo(target);
    }

    @Override // com.tencent.ecommerce.base.report.api.IECDtReport
    public void updateDtReportInfo(Object target, Map<String, String> reportParams, Map<String, ? extends Object> extAction) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(reportParams);
        linkedHashMap.putAll(a.f100911a.a(reportParams.get("bus_id")));
        reporter.updateDtReportInfo(target, linkedHashMap, extAction);
    }
}
