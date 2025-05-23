package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.widget.InnerWebView;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin
/* loaded from: classes23.dex */
public class aj extends BaseJsPlugin {

    /* renamed from: d, reason: collision with root package name */
    private static final String f346283d = "aj";

    @JsEvent({"customWebviewPostMessage"})
    public void customWebviewPostMessage(RequestEvent requestEvent) {
        int i3;
        JSONObject jSONObject;
        WebView c16;
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject(requestEvent.jsonParams);
            i3 = jSONObject2.optInt("htmlId");
        } catch (JSONException e16) {
            e = e16;
            i3 = 0;
        }
        try {
            jSONObject = jSONObject2.optJSONObject("data");
        } catch (JSONException e17) {
            e = e17;
            QMLog.e(f346283d, "customWebviewPostMessage json parse error" + requestEvent.jsonParams + e.getMessage());
            jSONObject = null;
            c16 = com.tencent.qqmini.miniapp.widget.a.b().c(i3);
            if (c16 == null) {
            }
            QMLog.e(f346283d, "webview not found webview = " + c16 + "htmlId=" + i3 + "jsonParam = " + requestEvent.jsonParams);
        }
        c16 = com.tencent.qqmini.miniapp.widget.a.b().c(i3);
        if (c16 == null && (c16 instanceof InnerWebView) && jSONObject != null) {
            ((InnerWebView) c16).evaluateSubscribeJS("H5OnMessage", jSONObject.toString(), 0);
            return;
        }
        QMLog.e(f346283d, "webview not found webview = " + c16 + "htmlId=" + i3 + "jsonParam = " + requestEvent.jsonParams);
    }

    @JsEvent({"insertCustomHTMLWebView"})
    public void insertCustomHtmlWebview(RequestEvent requestEvent) {
        this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(requestEvent, 2));
    }

    @JsEvent({"insertHTMLWebView"})
    public void insertHtmlWebview(RequestEvent requestEvent) {
        this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(requestEvent, 2));
    }

    @JsEvent({"scrollWebviewTo"})
    public void pageScrollTo(RequestEvent requestEvent) {
        sendNativeViewEvent(requestEvent, 0);
    }

    @JsEvent({"removeHTMLWebView"})
    public void removeHtmlWebview(RequestEvent requestEvent) {
        this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(requestEvent, 2));
    }

    @JsEvent({"scrollWebviewTo"})
    public void scrollWebviewTo(RequestEvent requestEvent) {
        this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(requestEvent, 1));
    }

    @JsEvent({"switchFullScreen"})
    public void switchFullScreen(RequestEvent requestEvent) {
        this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(requestEvent, 2));
    }

    @JsEvent({"updateCustomHTMLWebView"})
    public void updateCustomHtmlWebview(RequestEvent requestEvent) {
        this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(requestEvent, 2));
    }

    @JsEvent({"updateHTMLWebView"})
    public void updateHtmlWebview(RequestEvent requestEvent) {
        this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(requestEvent, 2));
    }
}
