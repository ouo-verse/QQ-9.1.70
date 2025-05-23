package com.tencent.gdtad.web;

import android.app.Activity;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.protocol.link_report;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$BizKey;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;
import java.lang.ref.WeakReference;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class g implements h {

    /* renamed from: a, reason: collision with root package name */
    private long f109785a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f109786b = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f109787c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private k f109788d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f109789e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private String f109790f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface a {
        void onResponse(String str);
    }

    public g(@Nullable k kVar) {
        if (kVar == null) {
            return;
        }
        GdtLog.d("GdtLandingPageReport", " GdtLandingPageReport");
        this.f109788d = kVar;
    }

    @Nullable
    private String i(long j3, @NonNull String str, @NonNull String str2) {
        String str3;
        GdtLog.d("GdtLandingPageReport", " getScript== start ");
        if (this.f109788d == null) {
            str3 = "";
        } else {
            str3 = GdtLandingPageConfig.b().c(this.f109788d.getActivity());
        }
        GdtLog.d("GdtLandingPageReport", " getScript==" + str3);
        if (TextUtils.isEmpty(str3)) {
            GdtLog.d("GdtLandingPageReport", " getScript pagePerformance is close");
            return "";
        }
        if (!TextUtils.isEmpty(String.valueOf(j3))) {
            str3 = str3.replaceAll("__CLICK_TIME__", String.valueOf(j3));
        }
        if (!TextUtils.isEmpty(str)) {
            str3 = str3.replaceAll("__TRACE_ID__", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            return str3.replaceAll("__NET_LOG_REQ_ID__", str2);
        }
        return str3;
    }

    @Nullable
    private String j(String str) {
        Activity activity;
        String str2;
        k kVar = this.f109788d;
        if (kVar != null) {
            activity = kVar.getActivity();
        } else {
            activity = null;
        }
        if (activity != null && activity.getIntent() != null) {
            str2 = activity.getIntent().getStringExtra(str);
        } else {
            str2 = "";
        }
        Log.i("GdtLandingPageReport", "name = " + str + ", s = " + str2);
        return str2;
    }

    private void k(@NonNull final String str) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.web.c
            @Override // java.lang.Runnable
            public final void run() {
                g.this.p(str);
            }
        }, 3);
    }

    private void m(@Nullable final CustomWebView customWebView, final String str, final int i3, @Nullable final a aVar) {
        if (customWebView != null && !TextUtils.isEmpty(str)) {
            final long currentTimeMillis = System.currentTimeMillis();
            GdtLog.d("GdtLandingPageReport", " injectScript scene: " + i3 + " \u6ce8\u5165JS.");
            x(new Runnable() { // from class: com.tencent.gdtad.web.b
                @Override // java.lang.Runnable
                public final void run() {
                    g.r(str, customWebView, i3, currentTimeMillis, aVar);
                }
            });
            return;
        }
        GdtLog.d("GdtLandingPageReport", " injectScript webview or script is null");
    }

    private boolean n(int i3) {
        if (i3 != 4003005 && i3 != 4003007) {
            return false;
        }
        return true;
    }

    private boolean o() {
        return !TextUtils.isEmpty(j("WebReport_TRACE_ID"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(String str) {
        this.f109790f = i(this.f109785a, j("WebReport_TRACE_ID"), str);
        GdtLog.e("GdtLandingPageReport", " webviewInjectScript getScript ==" + this.f109790f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q(int i3, long j3, a aVar, String str) {
        GdtLog.d("GdtLandingPageReport", " injectScript scene: " + i3 + " \u56de\u8c03\u8017\u65f6: " + (System.currentTimeMillis() - j3) + " \u56de\u8c03. resp: " + str);
        if (aVar != null) {
            aVar.onResponse(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r(String str, CustomWebView customWebView, final int i3, final long j3, final a aVar) {
        GdtLog.d("GdtLandingPageReport", " injectScript start script =" + str);
        customWebView.evaluateJavascript(str, new ValueCallback() { // from class: com.tencent.gdtad.web.e
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                g.q(i3, j3, aVar, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(final String str) {
        GdtLog.e("GdtLandingPageReport", " webviewGetPerformanceResult onResponse ==" + str);
        if (str != null && !str.equals("null")) {
            AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.web.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.s(str);
                }
            }, 4);
            GdtLog.e("GdtLandingPageReport", " webviewGetPerformanceResult report response ==" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void s(@NonNull String str) {
        GdtLog.d("GdtLandingPageReport", " report");
        try {
            JSONObject jSONObject = new JSONObject(str);
            GdtLog.d("GdtLandingPageReport", " performanceJson: " + jSONObject);
            w(jSONObject.getJSONArray("event_report"));
        } catch (Exception e16) {
            GdtLog.e("GdtLandingPageReport", " report.", e16);
        }
    }

    private void v(int i3, int i16, int i17, int i18) {
        if (QLog.isDebugVersion()) {
            QLog.d("GdtLandingPageReport", 2, "report eventId is " + i3 + "costTime is" + i16 + "isCgi " + this.f109786b + "jsEventValue" + i18);
        }
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).initGdtContext(MobileQQ.sMobileQQ, new InitGdtContextParams());
        link_report.LinkReport.ReportBiz reportBiz = new link_report.LinkReport.ReportBiz();
        reportBiz.cost_time = i16;
        reportBiz.f61330bp = i17;
        reportBiz.js_inject_scene = i18;
        reportBiz.wv_progress = 2;
        if (!n(i3)) {
            if (this.f109786b) {
                reportBiz.click_req_type = 1;
            } else {
                reportBiz.click_req_type = 3;
            }
        }
        if (this.f109787c) {
            reportBiz.lp_type = 1;
        } else {
            reportBiz.lp_type = 4;
        }
        reportBiz.aid = j("WebReport_AD_ID");
        reportBiz.pid = j("WebReport_POS_ID");
        reportBiz.traceid = j("WebReport_TRACE_ID");
        AdReporterForLinkEvent.getInstance().reportAsync(MobileQQ.sMobileQQ, i3, null, reportBiz, null);
    }

    private void w(@NonNull JSONArray jSONArray) {
        GdtLog.d("GdtLandingPageReport", " eventReport: " + jSONArray);
        if (JSONObject.NULL.equals(jSONArray)) {
            GdtLog.e("GdtLandingPageReport", " eventReport data is null");
            return;
        }
        try {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i3);
                int i16 = jSONObject.getInt("eventId");
                JSONObject jSONObject2 = jSONObject.getJSONObject("biz");
                if (i16 != Integer.MIN_VALUE) {
                    v(i16, (int) jSONObject2.optLong("cost_time"), (int) jSONObject2.optLong(LinkReportConstant$BizKey.BP, 0L), 0);
                }
            }
        } catch (Exception e16) {
            GdtLog.e("GdtLandingPageReport", " eventReport exception.", e16);
        }
    }

    static void x(@NonNull Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            AdThreadManager.getInstance().post(runnable, 0);
        }
    }

    private boolean z() {
        k kVar = this.f109788d;
        if (kVar != null && kVar.p() != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.gdtad.web.h
    public boolean a(String str, long j3, Map<String, Object> map) {
        if (!o()) {
            return false;
        }
        GdtLog.d("GdtLandingPageReport", " handleEvent url = " + str + "==type ==" + j3);
        if (z() && ((j3 == 8589934593L || j3 == 8589934594L) && !GdtWebReportQQ.k(str))) {
            m(this.f109788d.p().get(), this.f109790f, 1, null);
            GdtLog.d("GdtLandingPageReport", " start inject url = " + str + "  type ==" + j3);
            v(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_WEB_VIEW_JS_INJECT, (int) (System.currentTimeMillis() - this.f109785a), 0, 1);
        }
        if (j3 == 8589934598L && !GdtWebReportQQ.k(str)) {
            onDestroy();
        }
        return false;
    }

    @Override // com.tencent.gdtad.web.h
    public void b() {
        if (!o()) {
            return;
        }
        l();
        v(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_WEB_VIEW_INITIALIZE_START, (int) (System.currentTimeMillis() - this.f109785a), 0, 0);
        k("");
    }

    @Override // com.tencent.gdtad.web.h
    public void c(CustomWebView customWebView) {
        if (!o()) {
            return;
        }
        v(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_WEB_VIEW_INITIALIZE_SUCCESS, (int) (System.currentTimeMillis() - this.f109785a), 0, 0);
    }

    public void l() {
        String str;
        WeakReference<CustomWebView> p16;
        CustomWebView customWebView;
        GdtLog.d("GdtLandingPageReport", " init");
        k kVar = this.f109788d;
        if (kVar == null || (p16 = kVar.p()) == null || (customWebView = p16.get()) == null) {
            str = null;
        } else {
            str = customWebView.getUrl();
        }
        k kVar2 = this.f109788d;
        if (kVar2 != null && kVar2.getActivity() != null) {
            GdtLog.d("GdtLandingPageReport", " init success");
            this.f109785a = this.f109788d.getActivity().getIntent().getLongExtra("WebReport_CLICK_TIME", System.currentTimeMillis());
            this.f109787c = this.f109788d.getActivity().getIntent().getBooleanExtra("WebReport_IS_H5", true);
            this.f109786b = GdtWebReportQQ.k(str);
        }
    }

    @Override // com.tencent.gdtad.web.h
    public void onDestroy() {
        if (z() && o() && !this.f109789e) {
            this.f109789e = true;
            y(this.f109788d.p().get());
        }
    }

    public void y(@Nullable CustomWebView customWebView) {
        if (customWebView == null) {
            GdtLog.e("GdtLandingPageReport", " webviewGetPerformanceResult webview is null");
            return;
        }
        v(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_WEB_VIEW_JS_INJECT, (int) (System.currentTimeMillis() - this.f109785a), 0, 2);
        GdtLog.d("GdtLandingPageReport", " webviewGetPerformanceResult");
        m(customWebView, "__TG_GET_PAGE_PERFORMANCE__()", 2, new a() { // from class: com.tencent.gdtad.web.d
            @Override // com.tencent.gdtad.web.g.a
            public final void onResponse(String str) {
                g.this.t(str);
            }
        });
    }
}
