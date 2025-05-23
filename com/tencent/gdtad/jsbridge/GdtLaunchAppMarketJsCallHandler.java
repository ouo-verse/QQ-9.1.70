package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher;
import com.tencent.ad.tangram.util.AdAppMarketLauncher;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtLaunchAppMarketJsCallHandler implements GdtJsCallHandler {
    private static final String TAG = "GdtLaunchAppMarketJsCallHandler";

    /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ae  */
    @Override // com.tencent.gdtad.jsbridge.GdtJsCallHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleJsCallRequest(@Nullable GdtAdWebPlugin gdtAdWebPlugin, String str, String... strArr) {
        Activity activity;
        String str2;
        String[] strArr2;
        AdAppMarketLauncher.Result launch;
        int i3;
        JSONArray jSONArray;
        JSONObject jSONObject;
        String stringExtra;
        List<Pair<AdAppDeeplinkLauncher.Params, AdAppDeeplinkLauncher.Result>> list = null;
        if (gdtAdWebPlugin != null) {
            activity = gdtAdWebPlugin.getActivity();
        } else {
            activity = null;
        }
        if (gdtAdWebPlugin != null && activity != null) {
            try {
                Intent intent = activity.getIntent();
                str2 = intent.getStringExtra("app_market_deeplink");
                try {
                    strArr2 = intent.getStringArrayExtra("app_market_package_name");
                } catch (Throwable th5) {
                    th = th5;
                    GdtLog.e(TAG, "handleJsCallRequest", th);
                    strArr2 = null;
                    Bundle bundle = new Bundle();
                    bundle.putString("big_brother_source_key", AdDownloadConstants.DOWNLOAD_SOURCE_AD);
                    if (activity.getIntent() != null) {
                    }
                    AdAppMarketLauncher.Params params = new AdAppMarketLauncher.Params();
                    params.list = new LinkedList();
                    if (strArr2 != null) {
                    }
                    launch = AdAppMarketLauncher.launch(new WeakReference(activity), params);
                    if (launch == null) {
                    }
                    if (launch != null) {
                    }
                    jSONArray = new JSONArray();
                    if (list != null) {
                        while (r3.hasNext()) {
                        }
                    }
                    jSONObject = new JSONObject();
                    jSONObject.put("error", i3);
                    jSONObject.put("details", jSONArray);
                    gdtAdWebPlugin.callJs(str, jSONObject.toString());
                    AdAnalysisHelperForUtil.reportForJSBridgeInvoked(activity, false, "launchAppMarket", gdtAdWebPlugin.getCurrentUrl());
                    return true;
                }
            } catch (Throwable th6) {
                th = th6;
                str2 = null;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("big_brother_source_key", AdDownloadConstants.DOWNLOAD_SOURCE_AD);
            if (activity.getIntent() != null) {
                if (TextUtils.isEmpty(activity.getIntent().getStringExtra(LaunchParam.KEY_REF_ID))) {
                    stringExtra = activity.getIntent().getStringExtra("big_brother_source_key");
                } else {
                    stringExtra = activity.getIntent().getStringExtra(LaunchParam.KEY_REF_ID);
                }
                bundle2.putString(LaunchParam.KEY_REF_ID, stringExtra);
            }
            AdAppMarketLauncher.Params params2 = new AdAppMarketLauncher.Params();
            params2.list = new LinkedList();
            if (strArr2 != null) {
                for (String str3 : strArr2) {
                    AdAppDeeplinkLauncher.Params params3 = new AdAppDeeplinkLauncher.Params();
                    params3.deeplink = str2;
                    params3.packageName = str3;
                    params3.extrasForIntent = bundle2;
                    params3.addflags = 268435456;
                    params2.list.add(params3);
                }
            }
            launch = AdAppMarketLauncher.launch(new WeakReference(activity), params2);
            if (launch == null) {
                i3 = launch.getErrorCode();
            } else {
                i3 = 1;
            }
            if (launch != null) {
                list = launch.getDetails();
            }
            jSONArray = new JSONArray();
            if (list != null && !list.isEmpty()) {
                for (Pair<AdAppDeeplinkLauncher.Params, AdAppDeeplinkLauncher.Result> pair : list) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("packageName", ((AdAppDeeplinkLauncher.Params) pair.first).packageName);
                        jSONObject2.put("error", ((AdAppDeeplinkLauncher.Result) pair.second).getErrorCode());
                        jSONArray.mo162put(jSONObject2);
                    } catch (Throwable th7) {
                        GdtLog.e(TAG, "[handleJsCallRequest]", th7);
                    }
                }
            }
            jSONObject = new JSONObject();
            try {
                jSONObject.put("error", i3);
                jSONObject.put("details", jSONArray);
                gdtAdWebPlugin.callJs(str, jSONObject.toString());
            } catch (Throwable th8) {
                try {
                    GdtLog.e(TAG, "handleJsCallRequest error", th8);
                    gdtAdWebPlugin.callJs(str, jSONObject.toString());
                } catch (Throwable th9) {
                    gdtAdWebPlugin.callJs(str, jSONObject.toString());
                    throw th9;
                }
            }
            AdAnalysisHelperForUtil.reportForJSBridgeInvoked(activity, false, "launchAppMarket", gdtAdWebPlugin.getCurrentUrl());
            return true;
        }
        GdtLog.e(TAG, "handleJsCallRequest error");
        return true;
    }
}
