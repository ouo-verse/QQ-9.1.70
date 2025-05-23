package com.tencent.ad.tangram.statistics;

import android.content.Context;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.statistics.AdFetcherFromClickUrl;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.biz.common.util.WebViewConstants;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdReporterForClick {
    private static final String TAG = "AdReporterForClick";

    public static void reportAndFetchAsync(final WeakReference<Context> weakReference, final Ad ad5, final String str, final String str2, final long j3, final int i3) {
        long j16;
        String str3;
        if (ad5 != null) {
            j16 = ad5.getAId();
        } else {
            j16 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        Context context = null;
        if (ad5 != null) {
            str3 = ad5.getTraceId();
        } else {
            str3 = null;
        }
        AdLog.i(TAG, "[reportAndFetchAsync] aid:" + j16 + " traceId:" + str3 + " uuid:" + str2);
        if (weakReference != null) {
            context = weakReference.get();
        }
        AdLinkReportForClick.linkReportForReportStart(context, ad5, j3, i3);
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.statistics.AdReporterForClick.2
            @Override // java.lang.Runnable
            public void run() {
                Context context2;
                boolean z16;
                AdFetcherFromClickUrl.Result queryByCGIOnNetworkThread = AdFetcherFromClickUrl.getInstance().queryByCGIOnNetworkThread(str2, ad5, str);
                WeakReference weakReference2 = weakReference;
                if (weakReference2 != null) {
                    context2 = (Context) weakReference2.get();
                } else {
                    context2 = null;
                }
                Context context3 = context2;
                Ad ad6 = ad5;
                if (queryByCGIOnNetworkThread != null && queryByCGIOnNetworkThread.isSuccess()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                AdLinkReportForClick.linkReportForReportEnd(context3, ad6, z16, j3, i3);
            }
        }, 4);
    }

    public static void reportAsync(final WeakReference<Context> weakReference, final Ad ad5, final String str, final long j3, final int i3) {
        String str2;
        long j16;
        String str3;
        Context context;
        Context context2 = null;
        if (ad5 != null) {
            str2 = ad5.getPosId();
        } else {
            str2 = null;
        }
        if (ad5 != null) {
            j16 = ad5.getAId();
        } else {
            j16 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        if (ad5 != null) {
            str3 = ad5.getTraceId();
        } else {
            str3 = null;
        }
        AdLog.i(TAG, "[reportAsync] posId:" + str2 + " aid:" + j16 + " traceId:" + str3);
        if (weakReference != null) {
            context = weakReference.get();
        } else {
            context = null;
        }
        AdAnalysisHelperForStatistics.reportForClickStatisticsStart(context, ad5, str);
        if (weakReference != null) {
            context2 = weakReference.get();
        }
        AdLinkReportForClick.linkReportForReportStart(context2, ad5, j3, i3);
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.statistics.AdReporterForClick.1
            @Override // java.lang.Runnable
            public void run() {
                Context context3;
                boolean z16;
                AdHttp.Params params = new AdHttp.Params();
                params.setUrl(str);
                params.method = "GET";
                AdHttp.send(params);
                WeakReference weakReference2 = weakReference;
                Context context4 = null;
                if (weakReference2 != null) {
                    context3 = (Context) weakReference2.get();
                } else {
                    context3 = null;
                }
                AdAnalysisHelperForStatistics.reportForClickStatisticsEnd(context3, ad5, params);
                WeakReference weakReference3 = weakReference;
                if (weakReference3 != null) {
                    context4 = (Context) weakReference3.get();
                }
                Context context5 = context4;
                Ad ad6 = ad5;
                int i16 = params.responseCode;
                if (i16 != 200 && i16 != 302) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                AdLinkReportForClick.linkReportForReportEnd(context5, ad6, z16, j3, i3);
            }
        }, 4);
    }
}
