package com.tencent.comic.hippy.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.tencent.ams.dsdk.view.webview.DKHippyWebViewContainer;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.webview.swift.WebViewModule;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.af;
import com.tencent.mobileqq.webview.swift.y;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.net.URLDecoder;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes32.dex */
public class HippyWebViewModule extends WebViewModule {
    private static final String HIPPY_JS_INTERFACE_NAME = "hippy";
    private static final String TAG = "HippyWebViewModule";
    private Context mContext;
    private HippyViewEvent mEventOnError;
    private HippyViewEvent mEventonLoad;
    private HippyViewEvent mEventonLoadEnd;
    private HippyViewEvent mEventonLoadStart;
    private String mMessageUrlPre;
    private QQHippyWebView mQQHippyWebView;
    private MyHippyWebUiInterface mUiInterface;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class MyHippyWebUiInterface implements y, af {
        MyHippyWebUiInterface() {
        }

        @Override // com.tencent.mobileqq.webview.swift.af
        public int pluginStartActivityForResult(WebViewPlugin webViewPlugin, Intent intent, byte b16) {
            HippyWebViewModule.this.mContext.startActivity(intent);
            return 0;
        }

        @Override // com.tencent.mobileqq.webview.swift.af
        public int switchRequestCode(WebViewPlugin webViewPlugin, byte b16) {
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    static class QQHippyWebViewBridge {
        private WeakReference<QQHippyWebView> mHippyViewRef;

        public QQHippyWebViewBridge(QQHippyWebView qQHippyWebView) {
            this.mHippyViewRef = new WeakReference<>(qQHippyWebView);
        }

        @JavascriptInterface
        public void postMessage(String str) {
            WeakReference<QQHippyWebView> weakReference = this.mHippyViewRef;
            QQHippyWebView qQHippyWebView = weakReference != null ? weakReference.get() : null;
            if (qQHippyWebView != null) {
                qQHippyWebView.postMessage(str);
            }
        }
    }

    public HippyWebViewModule(Intent intent, Context context, QQHippyWebView qQHippyWebView) {
        super(intent, context);
        this.mEventOnError = new HippyViewEvent("onError");
        this.mEventonLoad = new HippyViewEvent("onLoad");
        this.mEventonLoadEnd = new HippyViewEvent(HippyQQPagView.EventName.ON_LOAD_END);
        this.mEventonLoadStart = new HippyViewEvent(HippyQQPagView.EventName.ON_LOAD_START);
        this.mMessageUrlPre = DKHippyWebViewContainer.POST_MESSAGE_URL_PRE;
        this.mUiInterface = new MyHippyWebUiInterface();
        this.mContext = context;
        this.mQQHippyWebView = qQHippyWebView;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewModule
    protected Activity getActivity() {
        Context context = this.mContext;
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return super.getActivity();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewModule
    protected void initWebView() {
        super.initWebView();
        TouchWebView touchWebView = this.webView;
        if (touchWebView != null) {
            touchWebView.addJavascriptInterface(new QQHippyWebViewBridge(this.mQQHippyWebView), "hippy");
            if (this.mQQHippyWebView.isBackgroundTransparent()) {
                this.webView.setBackgroundColor(0);
            }
            this.mQQHippyWebView.onWebViewInited(this.webView);
            this.mPluginEngine.b(this.mUiInterface);
            return;
        }
        QLog.e(TAG, 1, "initWebView webview is null");
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewModule
    public void onDestroy() {
        TouchWebView touchWebView = this.webView;
        if (touchWebView != null) {
            touchWebView.removeJavascriptInterface("hippy");
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewModule, com.tencent.mobileqq.webview.swift.z
    public void onPageFinished(WebView webView, String str) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("url", str);
        this.mEventonLoad.send(this.mQQHippyWebView, hippyMap);
        this.mEventonLoadEnd.send(this.mQQHippyWebView, hippyMap);
        super.onPageFinished(webView, str);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewModule, com.tencent.mobileqq.webview.swift.z
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("url", str);
        this.mEventonLoadStart.send(this.mQQHippyWebView, hippyMap);
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewModule, com.tencent.mobileqq.webview.swift.z
    public void onReceivedError(WebView webView, int i3, String str, String str2) {
        if (this.mQQHippyWebView != null) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushString("error", str);
            hippyMap.pushInt("errorCode", i3);
            this.mEventOnError.send(this.mQQHippyWebView, hippyMap);
        }
        super.onReceivedError(webView, i3, str, str2);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewModule, com.tencent.mobileqq.webview.swift.z
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.mQQHippyWebView != null && !TextUtils.isEmpty(str) && str.startsWith(this.mMessageUrlPre)) {
            this.mQQHippyWebView.postMessage(URLDecoder.decode(str.substring(this.mMessageUrlPre.length())));
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
