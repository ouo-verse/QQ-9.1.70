package com.tencent.gdtad.util;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.web.AdBrowser;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.activity.QQBrowserActivity;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class i {
    public static Intent a(AdBrowser.Params params) {
        long j3;
        GdtAd gdtAd = null;
        if (params != null && params.isValid() && params.f61348ad != null) {
            GdtLog.i("GdtBrowserUtil", String.format("show %s", params.url));
            Intent intent = new Intent(params.activity.get(), (Class<?>) QQBrowserActivity.class);
            if (params.forcePortrait) {
                intent.putExtra("fragmentStyle", 12);
            }
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            intent.putExtra("url", params.url);
            Bundle bundle = params.extrasForIntent;
            if (bundle != null && !bundle.isEmpty()) {
                intent.putExtras(params.extrasForIntent);
            }
            Ad ad5 = params.f61348ad;
            if (ad5 != null && ad5.isValid()) {
                Ad ad6 = params.f61348ad;
                if (ad6 instanceof GdtAd) {
                    gdtAd = (GdtAd) ad6;
                }
                if (gdtAd != null) {
                    j3 = gdtAd.getNocoId();
                } else {
                    j3 = -2147483648L;
                }
                if (j3 != 0 && j3 != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                    intent.putExtra("GdtNocoId", j3);
                }
                intent.putExtra("WebReport_TRACE_ID", params.f61348ad.getTraceId());
                intent.putExtra("WebReport_ACTION_URL", params.f61348ad.getUrlForAction());
                intent.putExtra("WebReport_CLICK_TIME", System.currentTimeMillis());
                intent.putExtra("WebReport_IS_H5", true);
                intent.putExtra("WebReport_AD_ID", String.valueOf(params.f61348ad.getAId()));
                intent.putExtra("WebReport_POS_ID", params.f61348ad.getPosId());
                intent.putExtra("WebReport_HAS_REWARD_LANDING_PAGE", !TextUtils.isEmpty(params.f61348ad.getUrlForRewardLandingPage()));
                intent.putExtra("app_market_deeplink", params.f61348ad.getAppMarketDeeplink());
                if (params.f61348ad.getAppMarketPackageName() != null) {
                    intent.putExtra("app_market_package_name", (String[]) params.f61348ad.getAppMarketPackageName().toArray(new String[0]));
                }
            }
            if (params.useVerticalTransitionBetweenActivities) {
                intent.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_UP_DOWN, true);
            }
            intent.putExtra("WebReport_ACT_CODE", params.actionCode);
            return intent;
        }
        GdtLog.e("GdtBrowserUtil", "[buildIntent] error");
        return null;
    }
}
