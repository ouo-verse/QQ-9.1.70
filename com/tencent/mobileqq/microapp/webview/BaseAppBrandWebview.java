package com.tencent.mobileqq.microapp.webview;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qimei.webview.QmX5Webview;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebSettings;

/* compiled from: P */
/* loaded from: classes15.dex */
public class BaseAppBrandWebview extends QmX5Webview {
    static IPatchRedirector $redirector_ = null;
    protected static final String JS_INTERFACE_NAME = "WeixinJSCore";
    public static int PAGE_WEBVIEW_ID_FACTORY;
    private static final String TAG;
    public com.tencent.mobileqq.microapp.a.c apkgInfo$5475ea27;
    public int htmlId;
    public int pageWebviewId;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16760);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            TAG = BaseAppBrandWebview.class.getSimpleName();
            PAGE_WEBVIEW_ID_FACTORY = 0;
        }
    }

    public BaseAppBrandWebview(Context context) {
        this(context, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public static int generatedWebViewId() {
        int i3 = PAGE_WEBVIEW_ID_FACTORY + 1;
        PAGE_WEBVIEW_ID_FACTORY = i3;
        return i3;
    }

    public void evaluateCallbackJs(int i3, String str, ValueCallback valueCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), str, valueCallback);
            return;
        }
        String format = String.format("WeixinJSBridge.invokeCallbackHandler(%d, %s)", Integer.valueOf(i3), str);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[evaluateCallbackJs] callbackStr=" + format);
        }
        evaluteJs(format, valueCallback);
    }

    public void evaluateSubcribeJS(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, Integer.valueOf(i3));
        } else {
            com.tencent.mobileqq.microapp.appbrand.b.a.a(new a(this, str, str2, i3));
        }
    }

    public void evaluateSubcribeJSInService(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, Integer.valueOf(i3));
        } else {
            com.tencent.mobileqq.microapp.appbrand.b.a.a(new b(this, str, str2, i3));
        }
    }

    public void evaluteJs(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            evaluteJs(str, null);
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
    }

    public void initJSGlobalConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            evaluteJs(String.format("var __wxConfig = {};__wxConfig = JSON.parse('%1$s');__wxConfig.platform='android';", this.apkgInfo$5475ea27.f245820a));
        }
    }

    public BaseAppBrandWebview(Context context, int i3) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
            return;
        }
        this.htmlId = i3;
        this.pageWebviewId = generatedWebViewId();
        WebSettings settings = getSettings();
        settings.setSupportZoom(false);
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(2);
        settings.setUserAgent(settings.getUserAgentString() + "QQ/MicroApp");
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        if (getSettingsExtension() != null) {
            getSettingsExtension().setFirstScreenDetect(false);
        }
    }

    public void evaluteJs(String str, ValueCallback valueCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            com.tencent.mobileqq.microapp.appbrand.b.a.a(new c(this, str, valueCallback));
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) valueCallback);
        }
    }

    public void evaluateCallbackJs(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            evaluateCallbackJs(i3, str, null);
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) str);
        }
    }

    public BaseAppBrandWebview(Context context, com.tencent.mobileqq.microapp.a.c cVar) {
        this(context, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.apkgInfo$5475ea27 = cVar;
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) cVar);
        }
    }
}
