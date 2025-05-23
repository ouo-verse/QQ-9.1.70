package com.tencent.qimei.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.ad.c;
import com.tencent.qimei.jsbridge.JsBridgeInterface;
import com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtWebView;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QmWebview extends DtWebView {
    static IPatchRedirector $redirector_;
    private final JsBridgeInterface jsBridgeInterface;
    private AtomicBoolean mJsInterfaceInjected;

    public QmWebview(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mJsInterfaceInjected = new AtomicBoolean(false);
            this.jsBridgeInterface = new JsBridgeInterface(this);
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    private void onLoad() {
        if (!this.mJsInterfaceInjected.get()) {
            this.mJsInterfaceInjected.set(true);
            addJavascriptInterface(this.jsBridgeInterface, JsBridgeInterface.JS_OBJECT_NAME);
            c.b("QmWebview", "webview inject success!", new Object[0]);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtWebView, android.webkit.WebView
    public void loadData(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, str2, str3);
        } else {
            super.loadData(str, str2, str3);
            onLoad();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtWebView, android.webkit.WebView
    public void loadDataWithBaseURL(@Nullable String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, str2, str3, str4, str5);
        } else {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            onLoad();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtWebView, android.webkit.WebView
    public void loadUrl(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            super.loadUrl(str);
            onLoad();
        }
    }

    public QmWebview(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.mJsInterfaceInjected = new AtomicBoolean(false);
            this.jsBridgeInterface = new JsBridgeInterface(this);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtWebView, android.webkit.WebView
    public void loadUrl(@NonNull String str, @NonNull Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) map);
        } else {
            super.loadUrl(str, map);
            onLoad();
        }
    }

    public QmWebview(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.mJsInterfaceInjected = new AtomicBoolean(false);
            this.jsBridgeInterface = new JsBridgeInterface(this);
        }
    }

    public QmWebview(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mJsInterfaceInjected = new AtomicBoolean(false);
            this.jsBridgeInterface = new JsBridgeInterface(this);
        }
    }

    public QmWebview(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, boolean z16) {
        super(context, attributeSet, i3, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, attributeSet, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            this.mJsInterfaceInjected = new AtomicBoolean(false);
            this.jsBridgeInterface = new JsBridgeInterface(this);
        }
    }
}
