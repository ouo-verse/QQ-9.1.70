package com.tencent.mobileqq.tvideo.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.tvideo.pullqqlive.h;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TVideoChannelWebView extends TouchWebView {
    private boolean C;
    private int D;
    private int E;
    private int F;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b extends WebChromeClient {
        b() {
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            return super.onJsAlert(webView, str, str2, jsResult);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onProgressChanged(WebView webView, int i3) {
            JsInjector.getInstance().onProgressChanged(webView, i3);
            super.onProgressChanged(webView, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface c {
    }

    public TVideoChannelWebView(Context context) {
        this(context, null);
    }

    private void B() {
        setPluginEngine(WebAccelerateHelper.getInstance().createWebViewPluginEngine(MobileQQ.sMobileQQ.peekAppRuntime(), Foreground.getTopActivity(), this, null));
        setWebViewClient(new a());
        setWebChromeClient(new b());
        setBackgroundColor(0);
        D();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (viewConfiguration != null) {
            this.F = viewConfiguration.getScaledTouchSlop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("txvideo://") && !str.startsWith("tenvideo2://") && !str.startsWith("tenvideo3://")) {
            return false;
        }
        return true;
    }

    private void D() {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        settings.setDomStorageEnabled(true);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 2) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            int x16 = (int) (motionEvent.getX() + 0.5f);
            int y16 = (int) (motionEvent.getY() + 0.5f);
            int i3 = x16 - this.D;
            int abs = (int) (Math.abs(i3) * 0.5f);
            int abs2 = Math.abs(y16 - this.E);
            int i16 = this.F;
            if ((abs >= i16 || abs2 >= i16) && abs2 < abs) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        } else {
            this.D = (int) (motionEvent.getX() + 0.5f);
            this.E = (int) (motionEvent.getY() + 0.5f);
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.smtt.sdk.WebView, android.view.View
    public void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
    }

    public TVideoChannelWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = true;
        B();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends WebViewClient {
        a() {
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (((CustomWebView) TVideoChannelWebView.this).mPluginEngine != null) {
                ((CustomWebView) TVideoChannelWebView.this).mPluginEngine.s(str, 8589934594L, null);
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            super.onPageStarted(webView, str, bitmap);
            if (((CustomWebView) TVideoChannelWebView.this).mPluginEngine != null) {
                ((CustomWebView) TVideoChannelWebView.this).mPluginEngine.s(str, 8589934593L, null);
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onReceivedError(WebView webView, int i3, String str, String str2) {
            if (((CustomWebView) TVideoChannelWebView.this).mPluginEngine != null) {
                ((CustomWebView) TVideoChannelWebView.this).mPluginEngine.q(str2, 8589934595L, i3);
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            TVideoChannelWebView.this.C = webResourceRequest.isForMainFrame();
            boolean shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, webResourceRequest);
            TVideoChannelWebView.this.C = true;
            return shouldOverrideUrlLoading;
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            QLog.i("TVideoChannelWebView", 1, "shouldOverrideUrlLoading url = " + str);
            if (!TVideoChannelWebView.this.C(str)) {
                return ((CustomWebView) TVideoChannelWebView.this).mPluginEngine != null && ((CustomWebView) TVideoChannelWebView.this).mPluginEngine.S(str, TVideoChannelWebView.this.C);
            }
            QLog.i("TVideoChannelWebView", 1, "startActionUrl url = " + str);
            h.p(webView.getContext(), str);
            return true;
        }
    }

    public void setVisibilityChangeListener(c cVar) {
    }
}
