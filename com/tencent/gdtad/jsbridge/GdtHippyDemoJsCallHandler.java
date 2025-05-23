package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.tencent.gdtad.log.GdtLog;

/* compiled from: P */
@Deprecated
/* loaded from: classes6.dex */
final class GdtHippyDemoJsCallHandler implements GdtJsCallHandler {
    private static final String TAG = "GdtHippyDemoJsCallHandler";

    GdtHippyDemoJsCallHandler() {
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
            return true;
        }
        GdtLog.e(TAG, "handleJsCallRequest error");
        return false;
    }
}
