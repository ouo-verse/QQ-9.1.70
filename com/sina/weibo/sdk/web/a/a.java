package com.sina.weibo.sdk.web.a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.c.e;
import com.sina.weibo.sdk.common.UiError;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class a extends b {
    public a(Activity activity, com.sina.weibo.sdk.web.a aVar, com.sina.weibo.sdk.web.b.b bVar) {
        super(activity, aVar, bVar);
    }

    private boolean i(String str) {
        Bundle f16;
        AuthInfo a16 = this.aG.x().a();
        if (a16 == null || !str.startsWith(a16.getRedirectUrl()) || (f16 = e.f(str)) == null || TextUtils.isEmpty(f16.getString(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN))) {
            return false;
        }
        return true;
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        AuthInfo a16 = this.aG.x().a();
        if (a16 != null && str.startsWith(a16.getRedirectUrl())) {
            String u16 = this.aG.x().u();
            if (!TextUtils.isEmpty(u16)) {
                WbAuthListener a17 = this.aD.a(u16);
                this.aH = a17;
                if (a17 != null) {
                    Bundle f16 = e.f(str);
                    if (f16 != null) {
                        String string = f16.getString("error");
                        String string2 = f16.getString("error_code");
                        String string3 = f16.getString("error_description");
                        if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                            Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(f16);
                            AccessTokenHelper.writeAccessToken(this.aE, parseAccessToken);
                            this.aH.onComplete(parseAccessToken);
                        } else {
                            this.aH.onError(new UiError(-1, string2, string3));
                        }
                    } else {
                        this.aH.onError(new UiError(-1, "bundle is null", "parse url error"));
                    }
                    this.aD.b(u16);
                }
            }
            com.sina.weibo.sdk.web.a aVar = this.aF;
            if (aVar != null) {
                aVar.t();
            }
        }
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        JsInjector.getInstance().onPageStarted(webView);
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return i(webResourceRequest.getUrl().toString());
    }

    @Override // com.sina.weibo.sdk.web.a.b
    public final void t() {
        super.t();
        String u16 = this.aG.x().u();
        if (!TextUtils.isEmpty(u16)) {
            WbAuthListener a16 = this.aD.a(u16);
            this.aH = a16;
            if (a16 != null) {
                a16.onCancel();
            }
            this.aD.b(u16);
        }
        com.sina.weibo.sdk.web.a aVar = this.aF;
        if (aVar != null) {
            aVar.t();
        }
    }

    @Override // com.sina.weibo.sdk.web.a.b
    public final boolean v() {
        t();
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return i(str);
    }
}
