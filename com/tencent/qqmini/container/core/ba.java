package com.tencent.qqmini.container.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.qimei.webview.QmX5Webview;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmini.miniapp.core.service.ServiceEventListener;
import com.tencent.qqmini.miniapp.core.worker.MiniAppWorkerManager;
import com.tencent.qqmini.miniapp.core.worker.MiniWorkerInterface;
import com.tencent.qqmini.miniapp.util.AppBrandUtil;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ba extends j {

    /* renamed from: e, reason: collision with root package name */
    private final WebView f346079e;

    /* renamed from: f, reason: collision with root package name */
    private final Handler f346080f;

    /* renamed from: h, reason: collision with root package name */
    private ServiceEventListener f346081h;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class a extends WebChromeClient {
        a() {
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (consoleMessage != null) {
                if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR) {
                    QMLog.e("Mini-SystemJsService", "console " + consoleMessage.message() + " line:" + consoleMessage.lineNumber());
                    ba.this.f346121d.performAction(AppStateEvent.obtain(71, consoleMessage));
                } else {
                    QMLog.i("Mini-SystemJsService", "console " + consoleMessage.message());
                }
            }
            return super.onConsoleMessage(consoleMessage);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onProgressChanged(WebView webView, int i3) {
            JsInjector.getInstance().onProgressChanged(webView, i3);
            super.onProgressChanged(webView, i3);
        }
    }

    public ba(IMiniAppContext iMiniAppContext) {
        super(iMiniAppContext);
        Context context = iMiniAppContext.getContext();
        this.f346080f = new Handler(Looper.getMainLooper());
        QmX5Webview qmX5Webview = new QmX5Webview(context);
        this.f346079e = qmX5Webview;
        qmX5Webview.addJavascriptInterface(this, "WeixinJSCore");
        qmX5Webview.addJavascriptInterface(new MiniWorkerInterface(iMiniAppContext), MiniAppWorkerManager.OBJ_WEIXINWORKER);
        WebSettings settings = qmX5Webview.getSettings();
        settings.setSupportZoom(false);
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(2);
        qmX5Webview.setWebChromeClient(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        WebView webView = this.f346079e;
        if (webView != null) {
            webView.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(String str, ValueCallback valueCallback) {
        WebView webView = this.f346079e;
        if (webView != null) {
            webView.evaluateJavascript(str, AppBrandUtil.convertValueCallback(valueCallback));
        }
    }

    @Override // com.tencent.qqmini.container.core.j
    public void b() {
        this.f346080f.post(new Runnable() { // from class: com.tencent.qqmini.container.core.az
            @Override // java.lang.Runnable
            public final void run() {
                ba.this.k();
            }
        });
    }

    @Override // com.tencent.qqmini.container.core.j
    protected final void c(final String str, String str2, final ValueCallback valueCallback) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            WebView webView = this.f346079e;
            if (webView != null) {
                webView.evaluateJavascript(str, AppBrandUtil.convertValueCallback(valueCallback));
                return;
            }
            return;
        }
        this.f346080f.post(new Runnable() { // from class: com.tencent.qqmini.container.core.ay
            @Override // java.lang.Runnable
            public final void run() {
                ba.this.l(str, valueCallback);
            }
        });
    }

    @Override // com.tencent.qqmini.container.core.j
    public void h(ServiceEventListener serviceEventListener) {
        this.f346081h = serviceEventListener;
    }

    @JavascriptInterface
    public String invokeHandler(String str, String str2, int i3) {
        ServiceEventListener serviceEventListener = this.f346081h;
        if (serviceEventListener != null) {
            return serviceEventListener.onServiceNativeRequest(str, str2, i3);
        }
        return "";
    }

    @JavascriptInterface
    public void publishHandler(String str, String str2, String str3) {
        ServiceEventListener serviceEventListener = this.f346081h;
        if (serviceEventListener != null) {
            serviceEventListener.onServiceEvent(str, str2, eu3.a.a(str3));
        }
    }
}
