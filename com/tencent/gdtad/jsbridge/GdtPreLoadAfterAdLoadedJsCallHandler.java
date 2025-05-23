package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class GdtPreLoadAfterAdLoadedJsCallHandler implements GdtJsCallHandler {
    private static final String TAG = "GdtPreLoaderJsCallHandler";

    @Override // com.tencent.gdtad.jsbridge.GdtJsCallHandler
    public boolean handleJsCallRequest(@Nullable GdtAdWebPlugin gdtAdWebPlugin, String str, String... strArr) {
        GdtAd gdtAd;
        Activity activity;
        String str2 = null;
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            GdtLog.i(TAG, jSONObject.toString());
            gdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo) qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), jSONObject.getJSONObject("adInfo"))));
        } catch (Throwable th5) {
            GdtLog.e(TAG, "handleJsCallRequest", th5);
            gdtAd = null;
        }
        try {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).preLoadAfterAdLoaded(gdtAdWebPlugin.getActivity(), gdtAd);
        } catch (Throwable th6) {
            GdtLog.e(TAG, "handleJsCallRequest", th6);
        }
        try {
            gdtAdWebPlugin.callJs(str, null);
        } catch (Throwable th7) {
            GdtLog.e(TAG, "handleJsCallRequest", th7);
        }
        if (gdtAdWebPlugin != null) {
            activity = gdtAdWebPlugin.getActivity();
        } else {
            activity = null;
        }
        if (gdtAdWebPlugin != null) {
            str2 = gdtAdWebPlugin.getCurrentUrl();
        }
        AdAnalysisHelperForUtil.reportForJSBridgeInvoked((Context) activity, true, "preLoadAfterAdLoaded", str2, (Ad) gdtAd);
        return true;
    }
}
