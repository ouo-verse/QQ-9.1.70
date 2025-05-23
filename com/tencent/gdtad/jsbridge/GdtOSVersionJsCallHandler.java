package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.os.Build;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.privacy.AdPrivacyPolicyManager;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.gdtad.log.GdtLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Deprecated
/* loaded from: classes6.dex */
final class GdtOSVersionJsCallHandler implements GdtJsCallHandler {
    private static final String TAG = "GdtOSVersionJsCall";

    GdtOSVersionJsCallHandler() {
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
            boolean isAllowed = AdPrivacyPolicyManager.getInstance().isAllowed();
            JSONObject jSONObject = new JSONObject();
            if (isAllowed) {
                try {
                    jSONObject.put("osVersion", Build.VERSION.RELEASE);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            } else {
                GdtLog.e(TAG, "handleJsCallRequest not allowed");
            }
            try {
                gdtAdWebPlugin.callJs(str, jSONObject.toString());
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            AdAnalysisHelperForUtil.reportForJSBridgeInvoked(activity, false, "getOSVersion", gdtAdWebPlugin.getCurrentUrl());
            return true;
        }
        GdtLog.e(TAG, "handleJsCallRequest error");
        return true;
    }
}
