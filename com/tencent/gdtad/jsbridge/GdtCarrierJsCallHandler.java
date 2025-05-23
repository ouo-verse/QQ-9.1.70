package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.transfile.CarrierImgDownloader;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Deprecated
/* loaded from: classes6.dex */
final class GdtCarrierJsCallHandler implements GdtJsCallHandler {
    private static final String TAG = "GdtCarrierJsCallHandler";

    GdtCarrierJsCallHandler() {
    }

    @Override // com.tencent.gdtad.jsbridge.GdtJsCallHandler
    public boolean handleJsCallRequest(@Nullable GdtAdWebPlugin gdtAdWebPlugin, String str, String... strArr) {
        Activity activity;
        if (gdtAdWebPlugin != null) {
            activity = gdtAdWebPlugin.getActivity();
        } else {
            activity = null;
        }
        if (gdtAdWebPlugin != null && activity != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(CarrierImgDownloader.PROTOCAL_CARRIER_IMG, 0);
            } catch (JSONException e16) {
                GdtLog.e(TAG, "handleJsCallRequest error", e16);
            }
            try {
                gdtAdWebPlugin.callJs(str, jSONObject.toString());
            } catch (Throwable th5) {
                GdtLog.e(TAG, "handleJsCallRequest error", th5);
            }
            AdAnalysisHelperForUtil.reportForJSBridgeInvoked(activity, false, "getCarrier", gdtAdWebPlugin.getCurrentUrl());
            return true;
        }
        GdtLog.e(TAG, "handleJsCallRequest error");
        return true;
    }
}
