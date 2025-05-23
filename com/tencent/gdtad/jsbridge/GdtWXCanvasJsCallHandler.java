package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ad.tangram.wechat.AdWXCanvas;
import com.tencent.gdtad.log.GdtLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtWXCanvasJsCallHandler implements GdtJsCallHandler {
    private static final String TAG = "GdtWXCanvasJsCallHandler";

    @Override // com.tencent.gdtad.jsbridge.GdtJsCallHandler
    public boolean handleJsCallRequest(GdtAdWebPlugin gdtAdWebPlugin, String str, String... strArr) {
        Activity activity;
        AdError adError;
        if (gdtAdWebPlugin != null) {
            activity = gdtAdWebPlugin.getActivity();
        } else {
            activity = null;
        }
        if (gdtAdWebPlugin != null && activity != null) {
            AdWXCanvas.Params params = new AdWXCanvas.Params();
            params.context = new WeakReference<>(activity);
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                GdtLog.i(TAG, jSONObject.toString());
                JSONObject jSONObject2 = jSONObject.getJSONObject("options");
                params.channelAppID = jSONObject2.getString("wechatAppId");
                params.extInfo = jSONObject2.getString("wechatExtInfo");
                if (!TextUtils.isEmpty(jSONObject2.getString("posId"))) {
                    adError = AdWXCanvas.getInstance().show(params);
                } else {
                    adError = new AdError(4);
                }
            } catch (Throwable th5) {
                GdtLog.e(TAG, "handleJsCallRequest", th5);
                adError = new AdError(4);
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("error_code", adError.getErrorCode());
                gdtAdWebPlugin.callJs(str, jSONObject3.toString());
            } catch (Throwable th6) {
                try {
                    GdtLog.e(TAG, "handleJsCallRequest error", th6);
                    gdtAdWebPlugin.callJs(str, jSONObject3.toString());
                } catch (Throwable th7) {
                    gdtAdWebPlugin.callJs(str, jSONObject3.toString());
                    throw th7;
                }
            }
            AdAnalysisHelperForUtil.reportForJSBridgeInvoked(activity, false, "openWeChatCanvas", gdtAdWebPlugin.getCurrentUrl());
            return true;
        }
        GdtLog.e(TAG, "handleJsCallRequest error");
        return true;
    }
}
