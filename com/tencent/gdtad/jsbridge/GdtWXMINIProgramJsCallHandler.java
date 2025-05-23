package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ad.tangram.wechat.AdWXMINIProgram;
import com.tencent.gdtad.log.GdtLog;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class GdtWXMINIProgramJsCallHandler implements GdtJsCallHandler {
    private static final String TAG = "GdtWXMINIProgramJsCallHandler";

    @Override // com.tencent.gdtad.jsbridge.GdtJsCallHandler
    public boolean handleJsCallRequest(@Nullable GdtAdWebPlugin gdtAdWebPlugin, String str, String... strArr) {
        Activity activity;
        AdError adError;
        if (gdtAdWebPlugin != null) {
            activity = gdtAdWebPlugin.getActivity();
        } else {
            activity = null;
        }
        if (gdtAdWebPlugin != null && activity != null) {
            AdWXMINIProgram.Params params = new AdWXMINIProgram.Params();
            params.weakActivity = new WeakReference<>(activity);
            new AdError(1);
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                GdtLog.i(TAG, jSONObject.toString());
                JSONObject jSONObject2 = jSONObject.getJSONObject("options");
                params.channelAppID = jSONObject2.getString("wechatAppId");
                params.token = jSONObject2.optString("wechatToken");
                params.userName = jSONObject2.getString("wechatUserName");
                params.path = jSONObject2.optString("wechatPath");
                params.traceData = jSONObject2.optString("wechatAdTraceData");
                if (TextUtils.isEmpty(jSONObject2.getString("posId"))) {
                    adError = new AdError(4);
                } else {
                    adError = AdWXMINIProgram.getInstance().show(params);
                }
            } catch (Throwable th5) {
                GdtLog.e(TAG, "handleJsCallRequest", th5);
                adError = new AdError(4);
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("error_code", adError.getErrorCode());
            } catch (JSONException e16) {
                GdtLog.e(TAG, "handleJsCallRequest error", e16);
            }
            try {
                gdtAdWebPlugin.callJs(str, jSONObject3.toString());
            } catch (Throwable th6) {
                GdtLog.e(TAG, "handleJsCallRequest error", th6);
            }
            AdAnalysisHelperForUtil.reportForJSBridgeInvoked(activity, false, "openWechatMiniApp", gdtAdWebPlugin.getCurrentUrl());
            return true;
        }
        GdtLog.e(TAG, "handleJsCallRequest error");
        return true;
    }
}
