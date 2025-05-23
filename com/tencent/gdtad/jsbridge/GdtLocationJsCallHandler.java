package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.gdtad.log.GdtLog;
import org.json.JSONObject;

/* compiled from: P */
@Deprecated
/* loaded from: classes6.dex */
final class GdtLocationJsCallHandler implements GdtJsCallHandler {
    private static final String TAG = "GdtLocationJsCallHandler";

    GdtLocationJsCallHandler() {
    }

    @Override // com.tencent.gdtad.jsbridge.GdtJsCallHandler
    public boolean handleJsCallRequest(@Nullable GdtAdWebPlugin gdtAdWebPlugin, String str, String... strArr) {
        Activity activity;
        if (gdtAdWebPlugin != null) {
            try {
                gdtAdWebPlugin.getActivity();
            } catch (Throwable th5) {
                GdtLog.e(TAG, "handleJsCallRequest", th5);
            }
        }
        JSONObject jSONObject = new JSONObject();
        Object obj = JSONObject.NULL;
        jSONObject.put(QCircleSchemeAttr.Polymerize.LAT, obj);
        jSONObject.put("lon", obj);
        if (gdtAdWebPlugin != null) {
            gdtAdWebPlugin.callJs(str, jSONObject.toString());
        }
        String str2 = null;
        if (gdtAdWebPlugin != null) {
            activity = gdtAdWebPlugin.getActivity();
        } else {
            activity = null;
        }
        if (gdtAdWebPlugin != null) {
            str2 = gdtAdWebPlugin.getCurrentUrl();
        }
        AdAnalysisHelperForUtil.reportForJSBridgeInvoked(activity, false, "getLocation", str2);
        return true;
    }
}
