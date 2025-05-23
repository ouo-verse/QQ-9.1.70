package com.tencent.mobileqq.mini.manager;

import android.os.Bundle;
import com.tencent.mobileqq.ad.api.IAdApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001+B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J,\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010\u00042\b\u0010(\u001a\u0004\u0018\u00010\u0004J\"\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010(\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/mini/manager/MiniLoadingAdReportHelper;", "", "()V", "CLICK_SUFFIX", "", "EVENT_AD_CLICK", "EVENT_LOAD_CACHED", "EVENT_LOAD_FAIL", "EVENT_LOAD_START", "EVENT_LOAD_SUCCESS", "EVENT_PREFIX", "EVENT_RENDER_FAIL", "EVENT_RENDER_START", "EVENT_RENDER_SUCCESS", "EVENT_REQ_EMPTY", "EVENT_REQ_FAIL", "EVENT_REQ_START", "EVENT_REQ_SUCCESS", "EVENT_SKIP_CLICK", "FAIL_SUFFIX", "LOAD_PREFIX", "RENDER_PREFIX", "REPORT_APP_ID_KEY", "REPORT_DURATION_KEY", "REPORT_MINI_APP_KEY", "REPORT_REFER_KEY", "REPORT_TRACE_ID_KEY", "REQUEST_PREFIX", "START_SUFFIX", "SUCCESS_SUFFIX", "mLastReportParams", "Lcom/tencent/mobileqq/mini/manager/MiniLoadingAdReportHelper$ReportParams;", "mLastRequestTime", "", "reportEvent", "", "event", "bundle", "Landroid/os/Bundle;", "appId", "traceId", "miniAppInfo", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "ReportParams", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniLoadingAdReportHelper {
    private static final String CLICK_SUFFIX = "_click";
    public static final String EVENT_AD_CLICK = "miniapp_startpage#ad_loading#ad_click";
    public static final String EVENT_LOAD_CACHED = "miniapp_startpage#ad_loading#load_cached";
    public static final String EVENT_LOAD_FAIL = "miniapp_startpage#ad_loading#load_failed";
    public static final String EVENT_LOAD_START = "miniapp_startpage#ad_loading#load_start";
    public static final String EVENT_LOAD_SUCCESS = "miniapp_startpage#ad_loading#load_success";
    private static final String EVENT_PREFIX = "miniapp_startpage#ad_loading#";
    public static final String EVENT_RENDER_FAIL = "miniapp_startpage#ad_loading#render_failed";
    public static final String EVENT_RENDER_START = "miniapp_startpage#ad_loading#render_start";
    public static final String EVENT_RENDER_SUCCESS = "miniapp_startpage#ad_loading#render_success";
    public static final String EVENT_REQ_EMPTY = "miniapp_startpage#ad_loading#ad_request_empty";
    public static final String EVENT_REQ_FAIL = "miniapp_startpage#ad_loading#ad_request_failed";
    public static final String EVENT_REQ_START = "miniapp_startpage#ad_loading#ad_request_start";
    public static final String EVENT_REQ_SUCCESS = "miniapp_startpage#ad_loading#ad_request_success";
    public static final String EVENT_SKIP_CLICK = "miniapp_startpage#ad_loading#skip_click";
    private static final String FAIL_SUFFIX = "failed";
    private static final String LOAD_PREFIX = "load_";
    private static final String RENDER_PREFIX = "render_";
    private static final String REPORT_APP_ID_KEY = "appid";
    private static final String REPORT_DURATION_KEY = "loading_duration";
    private static final String REPORT_MINI_APP_KEY = "isMiniApp";
    private static final String REPORT_REFER_KEY = "refer";
    private static final String REPORT_TRACE_ID_KEY = "traceid";
    private static final String REQUEST_PREFIX = "ad_request_";
    private static final String START_SUFFIX = "start";
    private static final String SUCCESS_SUFFIX = "success";
    private static long mLastRequestTime;
    public static final MiniLoadingAdReportHelper INSTANCE = new MiniLoadingAdReportHelper();
    private static ReportParams mLastReportParams = new ReportParams("", "", "");

    MiniLoadingAdReportHelper() {
    }

    public final void reportEvent(String event, Bundle bundle, String appId, String traceId) {
        Intrinsics.checkNotNullParameter(event, "event");
        Map<String, String> params = ((IAdApi) QRoute.api(IAdApi.class)).getReportParams();
        if (Intrinsics.areEqual(event, EVENT_REQ_START)) {
            mLastRequestTime = System.currentTimeMillis();
        }
        if (bundle != null) {
            String string = bundle.getString(AdProxy.KEY_REFER);
            String string2 = bundle.getString(AdProxy.KEY_APPID);
            String str = bundle.getInt(AdProxy.KEY_AD_TYPE) == 15 ? "0" : "1";
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put("refer", string);
            params.put("appid", string2);
            params.put(REPORT_MINI_APP_KEY, str);
            params.put("traceid", traceId);
            mLastReportParams = new ReportParams(string, string2, str);
        }
        if (bundle == null) {
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put("appid", appId);
            if (Intrinsics.areEqual(mLastReportParams.getAppId(), appId)) {
                params.put("refer", mLastReportParams.getRefer());
                params.put(REPORT_MINI_APP_KEY, mLastReportParams.isMiniApp());
            }
        }
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put(REPORT_DURATION_KEY, String.valueOf(System.currentTimeMillis() - mLastRequestTime));
        ((IAdApi) QRoute.api(IAdApi.class)).report(event, params);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J+\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/mini/manager/MiniLoadingAdReportHelper$ReportParams;", "", "refer", "", "appId", MiniLoadingAdReportHelper.REPORT_MINI_APP_KEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getRefer", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    private static final /* data */ class ReportParams {
        private final String appId;
        private final String isMiniApp;
        private final String refer;

        public ReportParams(String str, String str2, String isMiniApp) {
            Intrinsics.checkNotNullParameter(isMiniApp, "isMiniApp");
            this.refer = str;
            this.appId = str2;
            this.isMiniApp = isMiniApp;
        }

        /* renamed from: component1, reason: from getter */
        public final String getRefer() {
            return this.refer;
        }

        /* renamed from: component2, reason: from getter */
        public final String getAppId() {
            return this.appId;
        }

        /* renamed from: component3, reason: from getter */
        public final String getIsMiniApp() {
            return this.isMiniApp;
        }

        public final ReportParams copy(String refer, String appId, String isMiniApp) {
            Intrinsics.checkNotNullParameter(isMiniApp, "isMiniApp");
            return new ReportParams(refer, appId, isMiniApp);
        }

        public final String getAppId() {
            return this.appId;
        }

        public final String getRefer() {
            return this.refer;
        }

        public int hashCode() {
            String str = this.refer;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.appId;
            return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.isMiniApp.hashCode();
        }

        public final String isMiniApp() {
            return this.isMiniApp;
        }

        public String toString() {
            return "ReportParams(refer=" + this.refer + ", appId=" + this.appId + ", isMiniApp=" + this.isMiniApp + ")";
        }

        public static /* synthetic */ ReportParams copy$default(ReportParams reportParams, String str, String str2, String str3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = reportParams.refer;
            }
            if ((i3 & 2) != 0) {
                str2 = reportParams.appId;
            }
            if ((i3 & 4) != 0) {
                str3 = reportParams.isMiniApp;
            }
            return reportParams.copy(str, str2, str3);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReportParams)) {
                return false;
            }
            ReportParams reportParams = (ReportParams) other;
            return Intrinsics.areEqual(this.refer, reportParams.refer) && Intrinsics.areEqual(this.appId, reportParams.appId) && Intrinsics.areEqual(this.isMiniApp, reportParams.isMiniApp);
        }
    }

    public final void reportEvent(String event, MiniAppInfo miniAppInfo, String traceId) {
        Intrinsics.checkNotNullParameter(event, "event");
        Map<String, String> params = ((IAdApi) QRoute.api(IAdApi.class)).getReportParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        String str = miniAppInfo != null ? miniAppInfo.appId : null;
        if (str == null) {
            str = "";
        }
        params.put("appid", str);
        String appId = mLastReportParams.getAppId();
        String str2 = miniAppInfo != null ? miniAppInfo.appId : null;
        if (Intrinsics.areEqual(appId, str2 != null ? str2 : "")) {
            params.put("refer", mLastReportParams.getRefer());
            params.put(REPORT_MINI_APP_KEY, mLastReportParams.isMiniApp());
        }
        params.put("traceid", traceId);
        params.put(REPORT_DURATION_KEY, String.valueOf(System.currentTimeMillis() - mLastRequestTime));
        ((IAdApi) QRoute.api(IAdApi.class)).report(event, params);
    }
}
