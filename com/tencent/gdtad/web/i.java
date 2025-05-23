package com.tencent.gdtad.web;

import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtActionReporter;
import java.util.Map;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
final class i implements h {

    /* renamed from: a, reason: collision with root package name */
    private k f109791a;

    public i(k kVar) {
        this.f109791a = kVar;
    }

    private void d() {
        e(103);
    }

    private void e(int i3) {
        k kVar = this.f109791a;
        if (kVar != null && kVar.getActivity() != null && this.f109791a.getActivity().getIntent() != null) {
            String stringExtra = this.f109791a.getActivity().getIntent().getStringExtra("WebReport_TRACE_ID");
            String stringExtra2 = this.f109791a.getActivity().getIntent().getStringExtra("WebReport_ACTION_URL");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo traceInfo = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
                traceInfo.traceid.set(stringExtra);
                qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
                reportInfo.landing_page_report_url.set(stringExtra2);
                reportInfo.trace_info.set(traceInfo);
                qq_ad_get.QQAdGetRsp.AdInfo adInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
                adInfo.report_info.set(reportInfo);
                GdtAd gdtAd = new GdtAd(adInfo);
                GdtActionReporter.Params params = new GdtActionReporter.Params();
                params.f109471ad = gdtAd;
                params.data.landing_page_action_type.set(i3);
                GdtActionReporter.report(params);
                return;
            }
        }
        GdtLog.e("GdtWebReportAction", String.format("reportForAction:%d error", Integer.valueOf(i3)));
    }

    private void f() {
        e(102);
    }

    @Override // com.tencent.gdtad.web.h
    public boolean a(String str, long j3, Map<String, Object> map) {
        return false;
    }

    @Override // com.tencent.gdtad.web.h
    public void b() {
        GdtLog.i("GdtWebReportAction", "onActivityReady");
        f();
    }

    @Override // com.tencent.gdtad.web.h
    public void onDestroy() {
        GdtLog.i("GdtWebReportAction", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        d();
    }

    @Override // com.tencent.gdtad.web.h
    public void c(CustomWebView customWebView) {
    }
}
