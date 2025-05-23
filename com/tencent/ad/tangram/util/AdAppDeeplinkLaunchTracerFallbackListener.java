package com.tencent.ad.tangram.util;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.AdFetcherFromClickUrl;
import com.tencent.ad.tangram.util.AdAppDeeplinkLaunchTracer;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.ad.tangram.videoceiling.AdVideoCeiling;
import com.tencent.ad.tangram.web.AdBrowser;
import com.tencent.biz.common.util.WebViewConstants;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdAppDeeplinkLaunchTracerFallbackListener implements AdAppDeeplinkLaunchTracer.IFallbackListener {
    private static final String TAG = "AdAppDeeplinkLaunchTracerFallbackListener";
    private volatile AdBrowser.Params mBrowserParams;
    private volatile AdClickUtil.Params mClickParams;
    private volatile String mUUID;
    private volatile AdVideoCeiling.Params mVideoCeilingParams;

    public AdAppDeeplinkLaunchTracerFallbackListener(AdClickUtil.Params params, AdVideoCeiling.Params params2, AdBrowser.Params params3, String str) {
        this.mClickParams = params;
        this.mVideoCeilingParams = params2;
        this.mBrowserParams = params3;
        this.mUUID = str;
    }

    private static String getUrl(Ad ad5, String str) {
        String str2;
        if (ad5 != null) {
            str2 = ad5.getUrlForRewardLandingPage();
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        AdFetcherFromClickUrl.Result queryByCache = AdFetcherFromClickUrl.getInstance().queryByCache(str, ad5);
        if (queryByCache != null && queryByCache.isSuccess()) {
            return queryByCache.getUrl();
        }
        AdLog.e(TAG, "[getUrl] error");
        return null;
    }

    @Override // com.tencent.ad.tangram.util.AdAppDeeplinkLaunchTracer.IFallbackListener
    public AdError fallback() {
        Activity activity;
        Ad ad5;
        long j3;
        AdError adError;
        int i3;
        WeakReference<Activity> weakReference;
        AdClickUtil.Params params = this.mClickParams;
        AdVideoCeiling.Params params2 = this.mVideoCeilingParams;
        AdBrowser.Params params3 = this.mBrowserParams;
        String str = this.mUUID;
        String str2 = null;
        if (params != null && (weakReference = params.activity) != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (params != null) {
            ad5 = params.f61334ad;
        } else {
            ad5 = null;
        }
        if (ad5 != null) {
            j3 = ad5.getAId();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        if (ad5 != null) {
            str2 = ad5.getTraceId();
        }
        if (!isValid(params, params2, params3, str)) {
            AdLog.e(TAG, "[fallback] error, not valid, uuid:" + str + " aid:" + j3 + " traceId:" + str2 + " activity:" + activity);
            return new AdError(4);
        }
        String url = getUrl(params.f61334ad, str);
        if (TextUtils.isEmpty(url)) {
            AdLog.e(TAG, "[fallback] error, url is empty, uuid:" + str + " aid:" + j3 + " traceId:" + str2 + " activity:" + activity);
            return new AdError(16);
        }
        if (params2 != null && params2.isValid()) {
            params2.webUrl = url;
            params2.actionCode = 502;
            adError = AdVideoCeiling.getInstance().show(params2);
        } else if (params3 != null && params3.isValid()) {
            params3.url = url;
            params3.actionCode = 502;
            adError = AdBrowser.getInstance().show(params3);
        } else {
            AdLog.e(TAG, "[fallback] error, videoCeilingParams or browserParams not valid, uuid:" + str + " aid:" + j3 + " traceId:" + str2 + " activity:" + activity);
            adError = new AdError(1);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[fallback] error:");
        if (adError != null) {
            i3 = adError.getErrorCode();
        } else {
            i3 = Integer.MIN_VALUE;
        }
        sb5.append(i3);
        sb5.append(" uuid:");
        sb5.append(str);
        sb5.append(" aid:");
        sb5.append(j3);
        sb5.append(" traceId:");
        sb5.append(str2);
        sb5.append(" activity:");
        sb5.append(activity);
        AdLog.i(TAG, sb5.toString());
        return adError;
    }

    public boolean isValid() {
        return isValid(this.mClickParams, this.mVideoCeilingParams, this.mBrowserParams, this.mUUID);
    }

    @Override // com.tencent.ad.tangram.util.AdAppDeeplinkLaunchTracer.IFallbackListener
    public void reset() {
        AdLog.i(TAG, "[reset]");
        this.mClickParams = null;
        this.mVideoCeilingParams = null;
        this.mBrowserParams = null;
        this.mUUID = null;
    }

    private static boolean isValid(AdClickUtil.Params params, AdVideoCeiling.Params params2, AdBrowser.Params params3, String str) {
        return params != null && params.isValid() && params.f61334ad.isDeeplinkFallbackToUrl() && ((params2 != null && params2.isValid()) || (params3 != null && params3.isValid())) && !(TextUtils.isEmpty(params.f61334ad.getUrlForRewardLandingPage()) && TextUtils.isEmpty(str));
    }
}
