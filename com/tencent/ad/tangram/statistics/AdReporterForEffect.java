package com.tencent.ad.tangram.statistics;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdReporterForEffect {
    public static final int ACTION_MOBILEAPP_AD_APP_DOWN_PAUSED = 238;
    public static final int ACTION_MOBILEAPP_DEEPLINK_APP_ALREADY_INSTALLED = 247;
    public static final int ACTION_MOBILEAPP_DEEPLINK_APP_NOT_INSTALLED = 248;
    public static final int ACTION_MOBILEAPP_DEEPLINK_CAN_NOT_GET_APP_INSTALL_INFO = 249;
    public static final int ACTION_MOBILEAPP_DEEPLINK_OPEN_APP_SUCCESS = 246;
    public static final int ACTION_MOBILEAPP_DEEPLINK_TRY_TO_OPEN_APP = 245;
    public static final int ACTION_MOBILEAPP_DELAYED_DIRECT_START = 297;
    public static final int ACTION_MOBILEAPP_DELAYED_DIRECT_SUCCESS = 295;
    public static final int ACTION_MOBILEAPP_JUMP_MARKET_DEEPLINK_SUCC = 285;
    public static final int ACTION_MOBILEAPP_MARKET_INSTALL_SUCC = 286;
    public static final int ACTION_MOBILEAPP_MOBILE_QQ_ALREADY_DOWNLOAD = 270;
    public static final int ACTION_MOBILEAPP_MOBILE_QQ_AUTO_CREATE_DOWNLOAD = 269;
    public static final int ACTION_MOBILEAPP_MOBILE_QQ_CONTINUE_DOWNLOAD = 271;
    public static final int ACTION_MOBILEAPP_MOBILE_QQ_FINISH_DOWNLOAD = 274;
    public static final int ACTION_MOBILEAPP_MOBILE_QQ_INSTALLED_PACKAGE_MATCH = 275;
    public static final int ACTION_MOBILEAPP_MOBILE_QQ_INSTALLED_PACKAGE_NOT_MATCH = 276;
    public static final int ACTION_MOBILEAPP_MOBILE_QQ_MANUAL_CREATE_DOWNLOAD = 268;
    public static final int ACTION_MOBILEAPP_MOBILE_QQ_NEW_DOWNLOAD = 272;
    public static final int ACTION_MOBILEAPP_MOBILE_QQ_PAUSE_DOWNLOAD = 273;
    public static final int ACTION_MOBILEAPP_NATIVE_LANDINGPAGE_CLICK_FIVE_ELEMENT_BAR = 322;
    public static final int ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE = 328;
    public static final int ACTION_MOBILEAPP_QUICKAPP_OPEN_SUCCESS = 327;
    public static final int ACTION_MOBILEAPP_QUICKAPP_TRY_TO_OPEN = 326;
    public static final int ACTION_MOBILEAPP_SCHEMA_SUCCESS = 290;
    private static final String TAG = "AdReporterForEffect";

    @Nullable
    private static String getUrl(@Nullable Ad ad5, int i3) {
        String str;
        if (ad5 != null && ad5.isValid()) {
            str = ad5.getUrlForEffect();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.replaceAll("__CLICK_ID__", ad5.getTraceId()).replaceAll("__ACTION_ID__", String.valueOf(i3));
    }

    public static void reportAsync(@Nullable final WeakReference<Context> weakReference, final Ad ad5, int i3) {
        Context context;
        final String url = getUrl(ad5, i3);
        if (TextUtils.isEmpty(url)) {
            AdLog.i(TAG, "[reportAsync] do nothing, url is empty, actionId:" + i3);
            return;
        }
        AdLog.i(TAG, String.format("reportAsync %s", url));
        if (weakReference != null) {
            context = weakReference.get();
        } else {
            context = null;
        }
        AdAnalysisHelperForStatistics.reportForEffectStatisticsStart(context, ad5, url);
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.statistics.AdReporterForEffect.1
            @Override // java.lang.Runnable
            public void run() {
                Context context2;
                AdHttp.Params params = new AdHttp.Params();
                params.setUrl(url);
                params.method = "GET";
                AdHttp.send(params);
                WeakReference weakReference2 = weakReference;
                if (weakReference2 != null) {
                    context2 = (Context) weakReference2.get();
                } else {
                    context2 = null;
                }
                AdAnalysisHelperForStatistics.reportForEffectStatisticsEnd(context2, ad5, params);
            }
        }, 4);
    }
}
