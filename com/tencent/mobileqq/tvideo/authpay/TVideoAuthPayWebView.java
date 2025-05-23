package com.tencent.mobileqq.tvideo.authpay;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.utils.i;
import com.tencent.paysdk.api.o;
import com.tencent.paysdk.jsbridge.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import zt2.e;

/* loaded from: classes19.dex */
public class TVideoAuthPayWebView extends CustomWebView implements o {
    private mq3.c C;
    private b D;
    private String E;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class a extends WebViewClient {
        a() {
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            QLog.d("TVideoAuthPayWebView", 1, "onPageFinished url = " + str);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            QLog.d("TVideoAuthPayWebView", 1, "onPageStarted url = " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onReceivedError(WebView webView, int i3, String str, String str2) {
            QLog.d("TVideoAuthPayWebView", 1, "onReceivedError errorCode : " + i3 + " description : " + str);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if ((((CustomWebView) TVideoAuthPayWebView.this).mPluginEngine != null && ((CustomWebView) TVideoAuthPayWebView.this).mPluginEngine.S(str, true)) || TVideoAuthPayWebView.this.t(str)) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    /* loaded from: classes19.dex */
    public interface b {
        void clear();
    }

    public TVideoAuthPayWebView(Context context) {
        super(context);
        QLog.d("TVideoAuthPayWebView", 1, QCircleDaTongConstant.ElementParamValue.NEW);
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t(String str) {
        boolean z16;
        if (this.C == null) {
            this.C = new d(getContext(), this, null, null, new com.tencent.mobileqq.tvideo.authpay.b(this, null));
        }
        if (this.C.c(str)) {
            QLog.d("TVideoAuthPayWebView", 1, "shouldOverrideUrlLoading handleJsbridge");
            this.C.b(str);
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || TextUtils.isEmpty(str) || str.startsWith("http") || str.startsWith("https")) {
            return false;
        }
        v(str);
        return true;
    }

    private void u() {
        CookieManager.getInstance().setAcceptCookie(e.f453199a.k());
        setPluginEngine(WebAccelerateHelper.getInstance().createWebViewPluginEngine(MobileQQ.sMobileQQ.peekAppRuntime(), Foreground.getTopActivity(), this, null));
        x();
        w();
        setWebViewClient(new a());
    }

    private void v(String str) {
        QLog.d("TVideoAuthPayWebView", 1, "openScheme url = " + str);
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str));
        intent.addFlags(268435456);
        try {
            intent.putExtra("url", this.E);
            intent.putExtra(AppConstants.Key.H5_ARK_IS_FROM_SHARE, false);
            intent.putExtra(AppConstants.Key.SHARE_REQ_APP_ID, -1);
            getContext().startActivity(intent);
        } catch (Exception e16) {
            QLog.d("TVideoAuthPayWebView", 1, "openScheme Exception = " + e16);
        }
    }

    private void w() {
        boolean z16;
        String userAgentString = getSettings().getUserAgentString();
        QLog.d("TVideoAuthPayWebView", 1, " orgin ua  = " + userAgentString);
        if (getX5WebViewExtension() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str = i.n(userAgentString, "", z16) + " TenvideoMqqPlugin/1.2.9.12";
        QLog.d("TVideoAuthPayWebView", 1, " resultUA   = " + str);
        getSettings().setUserAgent(str);
    }

    private void x() {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        settings.setDomStorageEnabled(true);
    }

    @Override // com.tencent.paysdk.api.o
    public void b(@NonNull String str) {
        QLog.d("TVideoAuthPayWebView", 1, " appendUserAgent = " + str);
    }

    @Override // com.tencent.paysdk.api.o
    public void clear() {
        QLog.d("TVideoAuthPayWebView", 1, QCircleLpReportDc05507.KEY_CLEAR);
        b bVar = this.D;
        if (bVar != null) {
            bVar.clear();
        }
    }

    @Override // com.tencent.paysdk.api.o
    public void l(@Nullable String str, @Nullable o.a aVar) {
        QLog.d("TVideoAuthPayWebView", 1, "evaluateJavascript exeJs = " + str);
        super.evaluateJavascript(str, null);
    }

    @Override // com.tencent.biz.pubaccount.SuperWebView, com.tencent.qimei.webview.QmX5Webview, com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView, com.tencent.smtt.sdk.WebView
    public void loadUrl(@Nullable String str, @Nullable Map<String, String> map) {
        QLog.d("TVideoAuthPayWebView", 1, "loadUrl url = " + str);
        loadUrl(str);
    }

    @Override // com.tencent.paysdk.api.o
    @Nullable
    public mq3.c m() {
        return this.C;
    }

    @Override // com.tencent.paysdk.api.o
    public void setBgTransparent() {
        QLog.d("TVideoAuthPayWebView", 1, "setBgTransparent");
        setBackgroundColor(0);
    }

    @Override // com.tencent.paysdk.api.o
    public void setJsbridgeHandler(@Nullable mq3.c cVar) {
        this.C = cVar;
    }

    public void setWebViewPartListener(b bVar) {
        this.D = bVar;
    }

    @Override // com.tencent.biz.pubaccount.CustomWebView, com.tencent.biz.pubaccount.SuperWebView, com.tencent.qimei.webview.QmX5Webview, com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView, com.tencent.smtt.sdk.WebView
    public void loadUrl(String str) {
        super.loadUrl(str);
        this.E = str;
    }

    public TVideoAuthPayWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        u();
    }

    @Override // com.tencent.paysdk.api.o
    @NonNull
    public View k() {
        return this;
    }
}
