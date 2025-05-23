package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.gdtad.IGdtDemoAPI;
import com.tencent.mobileqq.qroute.QRoute;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtMotiveVideoDemoHandler implements GdtJsCallHandler {
    public static final String TAG = "GdtMotiveVideoDemoHandler";

    @Override // com.tencent.gdtad.jsbridge.GdtJsCallHandler
    public boolean handleJsCallRequest(@Nullable GdtAdWebPlugin gdtAdWebPlugin, String str, String... strArr) {
        Activity activity;
        if (gdtAdWebPlugin != null) {
            activity = gdtAdWebPlugin.getActivity();
        } else {
            activity = null;
        }
        if (gdtAdWebPlugin != null && activity != null) {
            ((IGdtDemoAPI) QRoute.api(IGdtDemoAPI.class)).startMotiveVideoDemoFragment(activity);
            return true;
        }
        AdLog.e(TAG, "handleJsCallRequest error");
        return false;
    }
}
