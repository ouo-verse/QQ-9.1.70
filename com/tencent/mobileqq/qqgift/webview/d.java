package com.tencent.mobileqq.qqgift.webview;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.api.IJsApi;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.util.m;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d extends AbsWebView implements m {
    static IPatchRedirector $redirector_;

    public d(Activity activity, AppInterface appInterface, TouchWebView touchWebView) {
        super(activity, activity, appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, appInterface, touchWebView);
        } else {
            this.mWebview = touchWebView;
        }
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public void bindJavaScript(ArrayList<WebViewPlugin> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList);
            return;
        }
        super.bindJavaScript(arrayList);
        if (QLog.isColorLevel()) {
            QLog.i("QQGiftWebViewBuilder", 2, "[bindJavaScript]");
        }
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getQWalletPayJsPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getPayJsPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getQWalletCommonJsPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getQWalletBluetoothJsPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getQQApiPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getUIApiPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getSensorAPIJavaScript());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getDataApiPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getMediaApiPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getVasCommonJsPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getQWalletCommonHbJsPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getQWalletMixJsPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getSSOWebviewPlugin());
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildBottomBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildContentView(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildTitleBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildWebView(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) appRuntime);
        } else {
            super.buildBaseWebView(appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void preInitWebviewPlugin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
