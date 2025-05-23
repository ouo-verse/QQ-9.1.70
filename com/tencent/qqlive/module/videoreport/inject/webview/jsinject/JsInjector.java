package com.tencent.qqlive.module.videoreport.inject.webview.jsinject;

import android.text.TextUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConfigConstants;
import com.tencent.qqlive.module.videoreport.inject.webview.WebViewCompatHelper;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes22.dex */
public class JsInjector {
    private static final String JS_PATH = "js/js_api_source.js";
    private static final String TAG = "jsbridge.JsInjector";
    private static final Set<String> hasJsSourceInjectSet = new HashSet();
    private String mJsContent;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class Instance {
        static JsInjector sInstance = new JsInjector();

        Instance() {
        }
    }

    private void addJsSourceInjectRecord(String str) {
        hasJsSourceInjectSet.add(str);
    }

    private void cleanInjectRecord(String str) {
        hasJsSourceInjectSet.remove(str);
    }

    private boolean doInjectJsSource(Object obj) {
        if (!DTConfigConstants.config.webViewReportSupport()) {
            Log.d(TAG, "doInjectJsSource(), webView report not support, don't inject js source!");
            return false;
        }
        if (obj == null || TextUtils.isEmpty(getJsContent())) {
            return false;
        }
        loadJsCompat(obj, a.JAVASCRIPT_PREFIX + getJsContent());
        return true;
    }

    public static JsInjector getInstance() {
        return Instance.sInstance;
    }

    private String getJsContent() {
        if (TextUtils.isEmpty(this.mJsContent)) {
            this.mJsContent = BaseUtils.readFileFromAssets(ReportUtils.getContext(), JS_PATH);
        }
        return this.mJsContent;
    }

    private boolean hasJsSourceInjected(String str) {
        return hasJsSourceInjectSet.contains(str);
    }

    private void loadJsCompat(Object obj, String str) {
        WebViewCompatHelper.onEvaluateJavascript(obj, str);
    }

    public void onPageStarted(Object obj) {
        if (obj == null) {
            return;
        }
        cleanInjectRecord(obj.hashCode() + "");
    }

    public void onProgressChanged(Object obj, int i3) {
        if (obj == null) {
            return;
        }
        String str = obj.hashCode() + "";
        if (i3 >= 25 && !hasJsSourceInjected(str) && doInjectJsSource(obj)) {
            addJsSourceInjectRecord(str);
        }
    }

    JsInjector() {
        this.mJsContent = null;
    }
}
