package com.tencent.comic.webbundle;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.comic.config.QQComicConfBean;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebHistoryItem;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.webbundle.sdk.IWebBundleWebView;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WebBundleWebView extends TouchWebView implements IWebBundleWebView {

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends WebViewClient {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IWebBundleWebView.OnPageFinishedListener f99503b;

        a(IWebBundleWebView.OnPageFinishedListener onPageFinishedListener) {
            this.f99503b = onPageFinishedListener;
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            this.f99503b.onPageFinished(WebBundleWebView.this, str);
        }
    }

    public WebBundleWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.smtt.sdk.WebView
    public boolean canGoBack() {
        WebHistoryItem itemAtIndex;
        WebBackForwardList copyBackForwardList = copyBackForwardList();
        if (copyBackForwardList != null && copyBackForwardList.getSize() > 0 && (itemAtIndex = copyBackForwardList.getItemAtIndex(0)) != null) {
            String url = itemAtIndex.getUrl();
            QQComicConfBean qQComicConfBean = (QQComicConfBean) am.s().x(534);
            if (qQComicConfBean != null && qQComicConfBean.f99266a.f99279b.equals(url)) {
                return super.canGoBackOrForward(-2);
            }
        }
        return super.canGoBack();
    }

    @Override // com.tencent.webbundle.sdk.IWebBundleWebView
    public void dispatchJsEvent(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        callJs(WebViewPlugin.toJsScript(str, jSONObject, jSONObject2));
    }

    @Override // com.tencent.webbundle.sdk.IWebBundleWebView
    public void enableJavaScript(boolean z16) {
        getSettings().setJavaScriptEnabled(z16);
    }

    @Override // com.tencent.webbundle.sdk.IWebBundleWebView
    public void setOnPageFinishedListener(IWebBundleWebView.OnPageFinishedListener onPageFinishedListener) {
        setWebViewClient(new a(onPageFinishedListener));
    }

    public WebBundleWebView(Context context) {
        super(context);
    }
}
