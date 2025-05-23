package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtHandleClickJsCallHandler implements GdtJsCallHandler {
    private static final String TAG = "GdtHandleAdJsCallHandler";

    @Override // com.tencent.gdtad.jsbridge.GdtJsCallHandler
    public boolean handleJsCallRequest(@Nullable GdtAdWebPlugin gdtAdWebPlugin, String str, String... strArr) {
        Activity activity;
        String str2;
        String stringExtra;
        if (gdtAdWebPlugin != null) {
            activity = gdtAdWebPlugin.getActivity();
        } else {
            activity = null;
        }
        GdtHandler.Params params = new GdtHandler.Params();
        boolean fillOptions = GdtHandler.fillOptions(params, strArr[0]);
        if (gdtAdWebPlugin != null && activity != null && fillOptions) {
            try {
                str2 = new JSONObject(strArr[0]).getJSONObject("options").optString("refIdForDemo");
            } catch (Throwable th5) {
                GdtLog.e(TAG, "handleJsCallRequest error", th5);
                str2 = null;
            }
            try {
                GdtLog.i(TAG, new JSONObject(strArr[0]).toString());
                params.activity = new WeakReference<>(activity);
                Intent intent = activity.getIntent();
                if (TextUtils.isEmpty(intent.getStringExtra(LaunchParam.KEY_REF_ID))) {
                    stringExtra = intent.getStringExtra("big_brother_source_key");
                } else {
                    stringExtra = intent.getStringExtra(LaunchParam.KEY_REF_ID);
                }
                if (!TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(str2)) {
                    str2 = stringExtra;
                }
                Bundle bundle = new Bundle();
                params.extra = bundle;
                bundle.putString(LaunchParam.KEY_REF_ID, str2);
                ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
                gdtAdWebPlugin.callJs(str, null);
                AdAnalysisHelperForUtil.reportForJSBridgeInvoked((Context) activity, false, "handleClick", gdtAdWebPlugin.getCurrentUrl(), (Ad) params.f108486ad);
                return true;
            } catch (Throwable th6) {
                GdtLog.e(TAG, "handleJsCallRequest error", th6);
                return true;
            }
        }
        GdtLog.e(TAG, "handleJsCallRequest error");
        return true;
    }
}
