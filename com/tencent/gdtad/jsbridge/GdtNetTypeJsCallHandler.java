package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.net.AdNet;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.gdtad.log.GdtLog;
import org.json.JSONObject;

/* compiled from: P */
@Deprecated
/* loaded from: classes6.dex */
final class GdtNetTypeJsCallHandler implements GdtJsCallHandler {
    private static final String TAG = "GdtNetTypeJsCallHandler";

    GdtNetTypeJsCallHandler() {
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
                jSONObject.put("netType", AdNet.getType(activity));
            } catch (Throwable th5) {
                GdtLog.e(TAG, "handleJsCallRequest error", th5);
            }
            try {
                gdtAdWebPlugin.callJs(str, jSONObject.toString());
            } catch (Throwable th6) {
                GdtLog.e(TAG, "handleJsCallRequest error", th6);
            }
            AdAnalysisHelperForUtil.reportForJSBridgeInvoked(activity, false, "getNetType", gdtAdWebPlugin.getCurrentUrl());
            return true;
        }
        GdtLog.e(TAG, "handleJsCallRequest error");
        return true;
    }
}
