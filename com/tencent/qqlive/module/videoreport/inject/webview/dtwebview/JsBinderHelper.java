package com.tencent.qqlive.module.videoreport.inject.webview.dtwebview;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConfigConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public class JsBinderHelper {
    private static final String TAG = "jsbridge.JsBinderHelper";

    JsBinderHelper() {
    }

    public static boolean allowInjectOnLoad() {
        if (!DTConfigConstants.config.webViewReportSupport()) {
            Log.w(TAG, "allowInjectOnLoad(), webView report not support!");
            return false;
        }
        Log.d(TAG, "allowInjectOnLoad(), on bind javascript bridge");
        return true;
    }
}
