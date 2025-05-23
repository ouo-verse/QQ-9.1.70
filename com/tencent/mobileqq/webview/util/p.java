package com.tencent.mobileqq.webview.util;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class p {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f314877a;

    /* renamed from: b, reason: collision with root package name */
    public static String f314878b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49573);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f314877a = false;
        }
    }

    public static void a() {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("x5_proxy_setting", 4);
        f314878b = sharedPreferences.getString("http_proxy_address", "");
        f314877a = sharedPreferences.contains("need_set_proxy");
        sharedPreferences.edit().remove("need_set_proxy").apply();
    }

    public static void b(WebView webView, String str) {
        if (!f314877a) {
            return;
        }
        if (webView != null && webView.getX5WebViewExtension() != null) {
            Bundle bundle = new Bundle();
            bundle.putString("address", str);
            webView.getX5WebViewExtension().invokeMiscMethod("setHttpSystemProxy", bundle);
        }
        f314877a = false;
    }
}
