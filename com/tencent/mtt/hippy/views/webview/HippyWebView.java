package com.tencent.mtt.hippy.views.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.tencent.ams.dsdk.view.webview.DKHippyWebViewContainer;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.utils.UrlUtils;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqlive.module.videoreport.inject.webview.webclient.ReportWebChromeClient;
import java.net.URLDecoder;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyWebView extends FrameLayout implements HippyViewBase {
    private HippyViewEvent mEventOnMessage;
    protected final HippyWebViewInner mWebView;

    public HippyWebView(Context context) {
        super(context);
        this.mEventOnMessage = null;
        HippyWebViewInner hippyWebViewInner = new HippyWebViewInner(context);
        this.mWebView = hippyWebViewInner;
        addView(hippyWebViewInner);
        initWebView();
    }

    private void initWebView() {
        this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.tencent.mtt.hippy.views.webview.HippyWebView.1
            private boolean mLoadEndTriggered;
            final HippyViewEvent mEventOnError = new HippyViewEvent("onError");
            final HippyViewEvent mEventonLoad = new HippyViewEvent("onLoad");
            final HippyViewEvent mEventonLoadEnd = new HippyViewEvent(HippyQQPagView.EventName.ON_LOAD_END);
            final HippyViewEvent mEventonLoadStart = new HippyViewEvent(HippyQQPagView.EventName.ON_LOAD_START);
            final String mMessageUrlPre = DKHippyWebViewContainer.POST_MESSAGE_URL_PRE;

            private void notifyLoadEnd(String str, boolean z16, String str2) {
                if (this.mLoadEndTriggered) {
                    return;
                }
                this.mLoadEndTriggered = true;
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushString("url", str);
                hippyMap.pushBoolean("success", z16);
                hippyMap.pushString("error", str2);
                this.mEventonLoadEnd.send(HippyWebView.this, hippyMap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushString("url", str);
                this.mEventonLoad.send(HippyWebView.this, hippyMap);
                notifyLoadEnd(str, true, "");
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                JsInjector.getInstance().onPageStarted(webView);
                this.mLoadEndTriggered = false;
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushString("url", str);
                this.mEventonLoadStart.send(HippyWebView.this, hippyMap);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i3, String str, String str2) {
                notifyLoadEnd(str2, false, i3 + "," + str);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushString("error", (String) webResourceError.getDescription());
                hippyMap.pushInt("errorCode", webResourceError.getErrorCode());
                this.mEventOnError.send(HippyWebView.this, hippyMap);
                if (webResourceRequest.isForMainFrame()) {
                    notifyLoadEnd(webResourceRequest.getUrl().toString(), false, webResourceError.getErrorCode() + "," + webResourceError.getDescription().toString());
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str != null) {
                    if (str.startsWith(DKHippyWebViewContainer.POST_MESSAGE_URL_PRE)) {
                        HippyWebView.this.postMessage(URLDecoder.decode(str.substring(25)));
                        return true;
                    }
                    if (UrlUtils.isWebUrl(str) || UrlUtils.isFileUrl(str)) {
                        webView.loadUrl(str);
                        return true;
                    }
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
        });
        this.mWebView.setWebChromeClient(new ReportWebChromeClient());
        this.mWebView.addJavascriptInterface(new HippyWebViewBridge(this), "hippy");
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        return null;
    }

    public void postMessage(String str) {
        if (this.mEventOnMessage == null) {
            this.mEventOnMessage = new HippyViewEvent("onMessage");
        }
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("data", str);
        this.mEventOnMessage.send(this, hippyMap);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        this.mWebView.setBackgroundColor(i3);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
    }
}
