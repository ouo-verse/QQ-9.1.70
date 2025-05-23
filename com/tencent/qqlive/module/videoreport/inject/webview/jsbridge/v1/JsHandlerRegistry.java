package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.v1;

import android.webkit.JavascriptInterface;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.IJsHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class JsHandlerRegistry {
    private static final String KEY_GET_SDK_INFO = "getSdkInfo";
    private static final String KEY_REPORT_EVENT = "reportEvent";
    private final Map<String, IJsHandler> mJsHandlers = new HashMap();

    public JsHandlerRegistry(Object obj) {
        registerHandlers(new WeakReference<>(obj));
    }

    private IJsHandler getHandlerByName(String str) {
        return this.mJsHandlers.get(str);
    }

    private void registerHandlers(WeakReference<Object> weakReference) {
        this.mJsHandlers.put(KEY_REPORT_EVENT, new JsReportHandler(weakReference));
        this.mJsHandlers.put(KEY_GET_SDK_INFO, new JsSdkInfoHandler(weakReference));
    }

    @JavascriptInterface
    public void getSdkVersion(JSONObject jSONObject) {
        getHandlerByName(KEY_GET_SDK_INFO).handle("getSdkVersion", jSONObject);
    }

    @JavascriptInterface
    public void reportEvent(JSONObject jSONObject) {
        getHandlerByName(KEY_REPORT_EVENT).handle(KEY_REPORT_EVENT, jSONObject);
    }
}
