package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtC2SJsCallHandler implements GdtJsCallHandler {
    private static final String TAG = "GdtC2SJsCallHandler";

    @Override // com.tencent.gdtad.jsbridge.GdtJsCallHandler
    public boolean handleJsCallRequest(@Nullable GdtAdWebPlugin gdtAdWebPlugin, String str, String... strArr) {
        Activity activity;
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            GdtLog.d(TAG, jSONObject.toString());
            int optInt = jSONObject.optInt("operationType");
            int optInt2 = jSONObject.optInt("businessType");
            qq_ad_get.QQAdGetRsp.AdInfo adInfo = (qq_ad_get.QQAdGetRsp.AdInfo) qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), jSONObject.getJSONObject("adInfo")));
            new GdtThirdProcessorProxy().c2sReportAsync(optInt, optInt2, adInfo);
            String str2 = null;
            if (gdtAdWebPlugin != null) {
                activity = gdtAdWebPlugin.getActivity();
            } else {
                activity = null;
            }
            if (gdtAdWebPlugin != null) {
                str2 = gdtAdWebPlugin.getCurrentUrl();
            }
            AdAnalysisHelperForUtil.reportForJSBridgeInvoked((Context) activity, false, "c2sReport", str2, (Ad) new GdtAd(adInfo));
            return true;
        } catch (Throwable th5) {
            GdtLog.e(TAG, "handleJsCallRequest", th5);
            return true;
        }
    }
}
