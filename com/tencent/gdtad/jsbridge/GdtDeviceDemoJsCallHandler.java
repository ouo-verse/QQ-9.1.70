package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.app.guard.GuardState;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtDeviceDemoJsCallHandler implements GdtJsCallHandler {
    private static final String TAG = "GdtDeviceDemoJsCallHandler";

    @Override // com.tencent.gdtad.jsbridge.GdtJsCallHandler
    public boolean handleJsCallRequest(@Nullable GdtAdWebPlugin gdtAdWebPlugin, String str, String... strArr) {
        Activity activity;
        Class publicFragmentActivityForMiniClass;
        if (gdtAdWebPlugin != null) {
            activity = gdtAdWebPlugin.getActivity();
        } else {
            activity = null;
        }
        if (gdtAdWebPlugin != null && activity != null) {
            try {
                String optString = new JSONObject(strArr[0]).optString("process", GuardState.PROCESS_NAME_MINIAPP);
                if (TextUtils.equals(optString, "com.tencent.mobileqq")) {
                    publicFragmentActivityForMiniClass = QPublicFragmentActivity.class;
                } else if (TextUtils.equals(optString, "com.tencent.mobileqq:tool")) {
                    publicFragmentActivityForMiniClass = QPublicFragmentActivityForTool.class;
                } else {
                    publicFragmentActivityForMiniClass = ((IMiniAppService) QRoute.api(IMiniAppService.class)).getPublicFragmentActivityForMiniClass();
                }
                GdtDeviceDemoFragment.start(activity, publicFragmentActivityForMiniClass);
            } catch (Throwable th5) {
                GdtLog.e(TAG, "handleJsCallRequest error", th5);
            }
            return true;
        }
        GdtLog.e(TAG, "handleJsCallRequest error");
        return true;
    }
}
