package com.tencent.ad.tangram.statistics;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.protocol.landing_page_collect_data;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.version.AdVersion;
import com.tencent.biz.common.util.WebViewConstants;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdReportForAction {
    public static final int ACTION_LANDINGPAGE_APP_DATA_FAILED = 37;
    public static final int ACTION_LANDINGPAGE_APP_DATA_SUCCESS = 36;
    public static final int ACTION_MOBILEAPP_AD_APP_DOWN_PAUSED = 238;
    public static final int ACTION_MOBILEAPP_MOBILE_QQ_ALREADY_DOWNLOAD = 270;
    public static final int ACTION_MOBILEAPP_MOBILE_QQ_AUTO_CREATE_DOWNLOAD = 269;
    public static final int ACTION_MOBILEAPP_MOBILE_QQ_CONTINUE_DOWNLOAD = 271;
    public static final int ACTION_MOBILEAPP_MOBILE_QQ_FINISH_DOWNLOAD = 274;
    public static final int ACTION_MOBILEAPP_MOBILE_QQ_INSTALLED_PACKAGE_MATCH = 275;
    public static final int ACTION_MOBILEAPP_MOBILE_QQ_INSTALLED_PACKAGE_NOT_MATCH = 276;
    public static final int ACTION_MOBILEAPP_MOBILE_QQ_INSTALLED_PACKAGE_UNKNOWN_MATCH = 284;
    public static final int ACTION_MOBILEAPP_MOBILE_QQ_MANUAL_CREATE_DOWNLOAD = 268;
    public static final int ACTION_MOBILEAPP_MOBILE_QQ_NEW_DOWNLOAD = 272;
    public static final int ACTION_MOBILEAPP_MOBILE_QQ_PAUSE_DOWNLOAD = 273;
    private static final String TAG = "AdReportForAction";

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Params {

        /* renamed from: ad, reason: collision with root package name */
        @Nullable
        public Ad f61333ad;

        @Nullable
        public WeakReference<Context> context;

        @NonNull
        public landing_page_collect_data.LandingPageCollectData data = new landing_page_collect_data.LandingPageCollectData();

        public boolean isValid() {
            WeakReference<Context> weakReference;
            landing_page_collect_data.LandingPageCollectData landingPageCollectData;
            if (this.f61333ad != null && (weakReference = this.context) != null && weakReference.get() != null && !TextUtils.isEmpty(this.f61333ad.getUrlForAction()) && !TextUtils.isEmpty(this.f61333ad.getTraceId()) && (landingPageCollectData = this.data) != null && landingPageCollectData.landing_page_action_type != 0) {
                return true;
            }
            return false;
        }
    }

    public static void report(@Nullable final Params params) {
        Context context;
        if (params != null && params.isValid()) {
            try {
                String replace = params.f61333ad.getUrlForAction().replace("__TRACE_ID__", URLEncoder.encode(params.f61333ad.getTraceId(), "utf-8")).replace("__PAGE_ACTION_ID__", String.valueOf(params.data.landing_page_action_type));
                long j3 = params.data.latency_ms;
                if (j3 != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                    replace = replace.replace("__PAGE_TIME__", String.valueOf(j3));
                }
                int i3 = params.data.landing_error_code;
                if (i3 != Integer.MIN_VALUE) {
                    replace = replace.replace("__LANDING_ERROR_CODE__", String.valueOf(i3));
                }
                final String replace2 = replace.replace("__OS_TYPE__", String.valueOf(2));
                String appVersion = AdVersion.getInstance().getAppVersion();
                if (!TextUtils.isEmpty(appVersion)) {
                    replace2 = replace2.replace("__VERSION__", URLEncoder.encode(appVersion, "utf-8"));
                }
                AdLog.i(TAG, "GdtActionReporter report url = " + replace2);
                WeakReference<Context> weakReference = params.context;
                if (weakReference != null) {
                    context = weakReference.get();
                } else {
                    context = null;
                }
                AdAnalysisHelperForStatistics.reportForActionStatisticsStart(context, params.f61333ad, replace2);
                AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.statistics.AdReportForAction.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Context context2;
                        AdHttp.Params params2 = new AdHttp.Params();
                        params2.setUrl(replace2);
                        params2.method = "GET";
                        AdHttp.send(params2);
                        WeakReference<Context> weakReference2 = params.context;
                        if (weakReference2 != null) {
                            context2 = weakReference2.get();
                        } else {
                            context2 = null;
                        }
                        AdAnalysisHelperForStatistics.reportForActionStatisticsEnd(context2, params.f61333ad, params2);
                    }
                }, 4);
                return;
            } catch (UnsupportedEncodingException e16) {
                AdLog.e(TAG, "report error", e16);
                return;
            }
        }
        AdLog.i(TAG, "[report] do nothing, not valid");
    }
}
