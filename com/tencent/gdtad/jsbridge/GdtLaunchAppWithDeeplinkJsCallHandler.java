package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher;
import com.tencent.ad.tangram.util.AdAppUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtLaunchAppWithDeeplinkJsCallHandler implements GdtJsCallHandler {
    private static final String TAG = "GdtLaunchAppWithDeeplinkJsCallHandler";

    @Override // com.tencent.gdtad.jsbridge.GdtJsCallHandler
    public boolean handleJsCallRequest(@Nullable GdtAdWebPlugin gdtAdWebPlugin, String str, String... strArr) {
        Activity activity;
        int i3;
        String stringExtra;
        if (gdtAdWebPlugin != null) {
            activity = gdtAdWebPlugin.getActivity();
        } else {
            activity = null;
        }
        if (gdtAdWebPlugin != null && activity != null) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                GdtLog.i(TAG, jSONObject.toString());
                String string = jSONObject.getString(QAdVrReportParams.ParamValue.DEEPLINK);
                String optString = jSONObject.optString("packageName");
                if (!TextUtils.isEmpty(optString) && !AdAppUtil.isInstalled(activity, optString)) {
                    i3 = 12;
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("big_brother_source_key", AdDownloadConstants.DOWNLOAD_SOURCE_AD);
                    if (activity.getIntent() != null) {
                        if (TextUtils.isEmpty(activity.getIntent().getStringExtra(LaunchParam.KEY_REF_ID))) {
                            stringExtra = activity.getIntent().getStringExtra("big_brother_source_key");
                        } else {
                            stringExtra = activity.getIntent().getStringExtra(LaunchParam.KEY_REF_ID);
                        }
                        bundle.putString(LaunchParam.KEY_REF_ID, stringExtra);
                    }
                    AdAppDeeplinkLauncher.Params params = new AdAppDeeplinkLauncher.Params();
                    params.deeplink = string;
                    params.packageName = optString;
                    params.extrasForIntent = bundle;
                    params.addflags = 268435456;
                    AdAppDeeplinkLauncher.Result launch = AdAppDeeplinkLauncher.launch(activity, params);
                    if (launch != null) {
                        i3 = launch.getErrorCode();
                    } else {
                        i3 = 1;
                    }
                }
            } catch (Throwable th5) {
                GdtLog.e(TAG, "handleJsCallRequest", th5);
                i3 = 4;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("error", i3);
            } catch (JSONException e16) {
                GdtLog.e(TAG, "handleJsCallRequest error", e16);
            }
            try {
                gdtAdWebPlugin.callJs(str, jSONObject2.toString());
            } catch (Throwable th6) {
                GdtLog.e(TAG, "handleJsCallRequest error", th6);
            }
            AdAnalysisHelperForUtil.reportForJSBridgeInvoked(activity, false, "launchAppWithDeeplink", gdtAdWebPlugin.getCurrentUrl());
            return true;
        }
        GdtLog.e(TAG, "handleJsCallRequest error");
        return true;
    }
}
