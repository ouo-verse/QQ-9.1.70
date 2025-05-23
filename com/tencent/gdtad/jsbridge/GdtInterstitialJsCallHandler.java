package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.gdtad.api.interstitial.IGdtInterstitialAPI;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtInterstitialJsCallHandler implements GdtJsCallHandler {
    private static final String TAG = "GdtInterstitialJsCallHandler";

    private int getOrientation(int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i3 == 1) {
            return 0;
        }
        if (i3 == 2) {
            return 8;
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.tencent.gdtad.jsbridge.GdtJsCallHandler
    public boolean handleJsCallRequest(@Nullable GdtAdWebPlugin gdtAdWebPlugin, String str, String... strArr) {
        Activity activity;
        String stringExtra;
        if (gdtAdWebPlugin != null) {
            activity = gdtAdWebPlugin.getActivity();
        } else {
            activity = null;
        }
        GdtHandler.Options options = new GdtHandler.Options();
        boolean fillOptions = GdtHandler.fillOptions(options, strArr[0]);
        if (gdtAdWebPlugin != null && activity != null && fillOptions) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                GdtLog.i(TAG, jSONObject.toString());
                int orientation = getOrientation(jSONObject.getJSONObject("options").optInt("orientation"));
                Intent intent = gdtAdWebPlugin.getActivity().getIntent();
                if (TextUtils.isEmpty(intent.getStringExtra(LaunchParam.KEY_REF_ID))) {
                    stringExtra = intent.getStringExtra("big_brother_source_key");
                } else {
                    stringExtra = intent.getStringExtra(LaunchParam.KEY_REF_ID);
                }
                Bundle bundle = new Bundle();
                options.extra = bundle;
                bundle.putString(LaunchParam.KEY_REF_ID, stringExtra);
                GdtLog.i(TAG, String.format("handleJsCallRequest Source.KEY_REF_ID:%s", stringExtra));
                GdtInterstitialParams gdtInterstitialParams = new GdtInterstitialParams();
                gdtInterstitialParams.clickOptions = options;
                gdtInterstitialParams.orientation = orientation;
                GdtAd gdtAd = options.f108486ad;
                if (gdtAd != null) {
                    gdtInterstitialParams.adInfoJson = gdtAd.toString();
                }
                gdtInterstitialParams.windowTranslucentStatus = true;
                ((IGdtInterstitialAPI) QRoute.api(IGdtInterstitialAPI.class)).build(activity, gdtInterstitialParams).show(activity);
                gdtAdWebPlugin.callJs(str, null);
                AdAnalysisHelperForUtil.reportForJSBridgeInvoked((Context) activity, true, "showInterstitial", gdtAdWebPlugin.getCurrentUrl(), (Ad) options.f108486ad);
                return true;
            } catch (Throwable th5) {
                GdtLog.e(TAG, "handleJsCallRequest error", th5);
                return true;
            }
        }
        GdtLog.e(TAG, "handleJsCallRequest error");
        return true;
    }
}
