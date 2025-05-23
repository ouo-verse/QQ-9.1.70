package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtDeviceInfoJsCallHandler implements GdtJsCallHandler {
    private static final String TAG = "GdtDeviceInfoJsCallHandler";

    @Override // com.tencent.gdtad.jsbridge.GdtJsCallHandler
    public boolean handleJsCallRequest(@Nullable GdtAdWebPlugin gdtAdWebPlugin, final String str, final String... strArr) {
        Activity activity;
        final WeakReference weakReference = new WeakReference(gdtAdWebPlugin);
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.jsbridge.GdtDeviceInfoJsCallHandler.1
            @Override // java.lang.Runnable
            public void run() {
                Activity activity2;
                boolean z16;
                qq_ad_get.QQAdGet.DeviceInfo deviceInfo;
                Object pbToJson;
                GdtAdWebPlugin gdtAdWebPlugin2 = (GdtAdWebPlugin) weakReference.get();
                JSONObject jSONObject = null;
                if (gdtAdWebPlugin2 != null) {
                    activity2 = gdtAdWebPlugin2.getActivity();
                } else {
                    activity2 = null;
                }
                if (gdtAdWebPlugin2 != null && activity2 != null) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(strArr[0]);
                        GdtLog.i(GdtDeviceInfoJsCallHandler.TAG, String.format("handleJsCallRequest %s", jSONObject2.toString()));
                        z16 = jSONObject2.getJSONObject("params").optBoolean("supportOpenMotiveAd", false);
                    } catch (Throwable th5) {
                        GdtLog.e(GdtDeviceInfoJsCallHandler.TAG, "handleJsCallRequest", th5);
                        z16 = false;
                    }
                    Context applicationContext = activity2.getApplicationContext();
                    GdtDeviceInfoHelper.Params params = new GdtDeviceInfoHelper.Params();
                    params.supportOpenMotiveAd = z16;
                    GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create(applicationContext, params);
                    if (create != null && (deviceInfo = create.deviceInfo) != null && (pbToJson = GdtJsonPbUtil.pbToJson(deviceInfo)) != null && (pbToJson instanceof JSONObject)) {
                        jSONObject = (JSONObject) JSONObject.class.cast(pbToJson);
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    if (jSONObject != null && !JSONObject.NULL.equals(jSONObject)) {
                        try {
                            jSONObject3.put("deviceInfo", jSONObject);
                        } catch (JSONException e16) {
                            GdtLog.e(GdtDeviceInfoJsCallHandler.TAG, "handleJsCallRequest", e16);
                        }
                    } else {
                        GdtLog.e(GdtDeviceInfoJsCallHandler.TAG, "handleJsCallRequest error");
                    }
                    try {
                        gdtAdWebPlugin2.callJs(str, jSONObject3.toString());
                        return;
                    } catch (Throwable th6) {
                        GdtLog.e(GdtDeviceInfoJsCallHandler.TAG, "handleJsCallRequest", th6);
                        return;
                    }
                }
                GdtLog.e(GdtDeviceInfoJsCallHandler.TAG, "handleJsCallRequest error");
            }
        }, 4);
        String str2 = null;
        if (gdtAdWebPlugin != null) {
            activity = gdtAdWebPlugin.getActivity();
        } else {
            activity = null;
        }
        if (gdtAdWebPlugin != null) {
            str2 = gdtAdWebPlugin.getCurrentUrl();
        }
        AdAnalysisHelperForUtil.reportForJSBridgeInvoked(activity, true, "getDeviceInfo", str2);
        return false;
    }
}
