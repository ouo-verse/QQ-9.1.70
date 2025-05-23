package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.handlers;

import android.support.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.inject.webview.WebViewCompatHelper;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.entityformatter.IJsEntityFormatter;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.entityformatter.JsCallbackBuilder;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class BaseJsHandler {
    private static final String DT_RESPONSE_CALLBACK = "dtResponseCallbacks";
    public static final String JS_CALLBACKID = "callbackId";
    public static final String JS_DATA = "data";
    public static final String JS_HANDLER_NAME = "handlerName";
    public static final String JS_INSTANCE = "DtJsReporter";
    protected WeakReference<Object> mWeakWebViewImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseJsHandler(WeakReference<Object> weakReference) {
        this.mWeakWebViewImpl = weakReference;
    }

    public static String getCallbackId(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("callbackId");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCallback(String str, String str2, String str3, IJsEntityFormatter iJsEntityFormatter) {
        String format = new JsCallbackBuilder().setRet(str2).setMsg(str3).setData(iJsEntityFormatter).format();
        if (callbackType() == DTConstants.JsCallbackPolicy.JS_WINDOWS_CALLBACK) {
            handleCallbackWindows(str, format);
        } else if (callbackType() == DTConstants.JsCallbackPolicy.JS_METHOND_CALLBACK) {
            handleCallbackMethod(str, format);
        }
    }

    private void handleCallbackMethod(String str, String str2) {
        WebViewCompatHelper.loadUrl(getRealWebView(), "javascript:DtJsReporter.callback('" + str + "'," + str2 + ");");
    }

    private void handleCallbackWindows(String str, String str2) {
        String str3 = "window.dtResponseCallbacks[" + str + "]";
        WebViewCompatHelper.loadUrl(getRealWebView(), "javascript: if(" + str3 + ")" + str3 + "(" + str2 + ");");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void callback(final String str, final String str2, final String str3, final IJsEntityFormatter iJsEntityFormatter) {
        if (ThreadUtils.isMainThread()) {
            handleCallback(str, str2, str3, iJsEntityFormatter);
        } else {
            ThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.handlers.BaseJsHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    BaseJsHandler.this.handleCallback(str, str2, str3, iJsEntityFormatter);
                }
            });
        }
    }

    protected abstract DTConstants.JsCallbackPolicy callbackType();

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Object getRealWebView() {
        WeakReference<Object> weakReference = this.mWeakWebViewImpl;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
