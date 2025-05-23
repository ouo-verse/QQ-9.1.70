package com.tencent.qimei.webview;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.ad.c;
import com.tencent.qimei.jsbridge.JsBridgeInterface;
import com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QmX5Webview extends DtX5WebView {
    static IPatchRedirector $redirector_;
    private final JsBridgeInterface jsBridgeInterface;
    private AtomicBoolean mJsInterfaceInjected;

    public QmX5Webview(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        this.mJsInterfaceInjected = new AtomicBoolean(false);
        this.jsBridgeInterface = new JsBridgeInterface(this);
        onLoad();
    }

    private void onLoad() {
        if (!this.mJsInterfaceInjected.get()) {
            this.mJsInterfaceInjected.set(true);
            addJavascriptInterface(this.jsBridgeInterface, JsBridgeInterface.JS_OBJECT_NAME);
            c.b("QmX5Webview", "webview inject success!", new Object[0]);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView, com.tencent.smtt.sdk.WebView
    public void loadData(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, str2, str3);
        } else {
            super.loadData(str, str2, str3);
            onLoad();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView, com.tencent.smtt.sdk.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, str2, str3, str4, str5);
        } else {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            onLoad();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView, com.tencent.smtt.sdk.WebView
    public void loadUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            super.loadUrl(str);
            onLoad();
        }
    }

    public QmX5Webview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.mJsInterfaceInjected = new AtomicBoolean(false);
            this.jsBridgeInterface = new JsBridgeInterface(this);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView, com.tencent.smtt.sdk.WebView
    public void loadUrl(String str, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) map);
        } else {
            super.loadUrl(str, map);
            onLoad();
        }
    }

    public QmX5Webview(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.mJsInterfaceInjected = new AtomicBoolean(false);
            this.jsBridgeInterface = new JsBridgeInterface(this);
        }
    }

    public QmX5Webview(Context context, AttributeSet attributeSet, int i3, Map<String, Object> map, boolean z16) {
        super(context, attributeSet, i3, map, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, attributeSet, Integer.valueOf(i3), map, Boolean.valueOf(z16));
        } else {
            this.mJsInterfaceInjected = new AtomicBoolean(false);
            this.jsBridgeInterface = new JsBridgeInterface(this);
        }
    }

    public QmX5Webview(Context context, AttributeSet attributeSet, int i3, boolean z16) {
        super(context, attributeSet, i3, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, attributeSet, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            this.mJsInterfaceInjected = new AtomicBoolean(false);
            this.jsBridgeInterface = new JsBridgeInterface(this);
        }
    }

    public QmX5Webview(Context context, boolean z16) {
        super(context, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Boolean.valueOf(z16));
        } else {
            this.mJsInterfaceInjected = new AtomicBoolean(false);
            this.jsBridgeInterface = new JsBridgeInterface(this);
        }
    }
}
