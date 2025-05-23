package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.tencent.gdtad.log.GdtLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtBannerJsCallHandler implements GdtJsCallHandler {
    private static final String TAG = "GdtBannerJsCallHandler";

    @Override // com.tencent.gdtad.jsbridge.GdtJsCallHandler
    public boolean handleJsCallRequest(@Nullable GdtAdWebPlugin gdtAdWebPlugin, String str, String... strArr) {
        Activity activity;
        if (gdtAdWebPlugin != null) {
            activity = gdtAdWebPlugin.getActivity();
        } else {
            activity = null;
        }
        if (gdtAdWebPlugin != null && activity != null) {
            try {
                GdtBaseBannerFragment.start(activity, new JSONObject(strArr[0]), GdtButtonDemoFragment.class);
            } catch (JSONException e16) {
                GdtLog.e(TAG, "handleJsCallRequest error", e16);
            }
            return true;
        }
        GdtLog.e(TAG, "handleJsCallRequest error");
        return true;
    }
}
