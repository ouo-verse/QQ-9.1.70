package com.tencent.raft.component;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import java.lang.reflect.Field;

/* loaded from: classes25.dex */
public class TxchPage {
    static IPatchRedirector $redirector_ = null;
    public static final String serverUrl = "https://support.qq.com/products/%s";
    public String appName;
    public String openId;
    public String productId;
    public String userAvatar;
    public String userID;
    public String userNickname;
    public String userType;

    public TxchPage(String str, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4);
            return;
        }
        this.productId = str;
        this.openId = str2;
        this.appName = str3;
        this.userAvatar = str4;
    }

    public WebView getTucaoPage(WebView webView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (WebView) iPatchRedirector.redirect((short) 3, (Object) this, (Object) webView);
        }
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        String format = String.format(serverUrl, this.productId);
        webView.setWebViewClient(new WebViewClient() { // from class: com.tencent.raft.component.TxchPage.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TxchPage.this);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView2, String str, Bitmap bitmap) {
                JsInjector.getInstance().onPageStarted(webView2);
                super.onPageStarted(webView2, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) webView2, (Object) str)).booleanValue();
                }
                super.shouldOverrideUrlLoading(webView2, str);
                webView2.loadUrl(str);
                return true;
            }
        });
        webView.loadUrl(format);
        return webView;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Field field : getClass().getFields()) {
            try {
                stringBuffer.append(field.getName());
                stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                stringBuffer.append(field.get(this));
                stringBuffer.append(",");
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
            }
        }
        return stringBuffer.toString();
    }
}
