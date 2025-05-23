package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.webview.QmX5Webview;

/* loaded from: classes27.dex */
public class ProtectedWebView extends QmX5Webview {
    static IPatchRedirector $redirector_;
    private boolean C;

    public ProtectedWebView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            init();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private void init() {
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        this.C = false;
    }

    @Override // com.tencent.smtt.sdk.WebView
    public boolean canGoBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (!this.C) {
            return super.canGoBack();
        }
        return false;
    }

    @Override // com.tencent.smtt.sdk.WebView
    public boolean canGoBackOrForward(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, i3)).booleanValue();
        }
        if (!this.C) {
            return super.canGoBackOrForward(i3);
        }
        return false;
    }

    @Override // com.tencent.smtt.sdk.WebView
    public boolean canGoForward() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (!this.C) {
            return super.canGoForward();
        }
        return false;
    }

    @Override // com.tencent.smtt.sdk.WebView
    public void clearView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (!this.C) {
            super.clearView();
        }
    }

    @Override // com.tencent.smtt.sdk.WebView
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else if (!this.C) {
            this.C = true;
            super.destroy();
        }
    }

    @Override // com.tencent.smtt.sdk.WebView
    public void goBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (!this.C) {
            super.goBack();
        }
    }

    @Override // com.tencent.smtt.sdk.WebView
    public void goBackOrForward(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else if (!this.C) {
            super.goBackOrForward(i3);
        }
    }

    @Override // com.tencent.qimei.webview.QmX5Webview, com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView, com.tencent.smtt.sdk.WebView
    public void loadUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        } else if (!this.C) {
            super.loadUrl(str);
        }
    }

    @Override // com.tencent.smtt.sdk.WebView
    public void postUrl(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, (Object) bArr);
        } else if (!this.C) {
            super.postUrl(str, bArr);
        }
    }

    @Override // com.tencent.smtt.sdk.WebView
    public void reload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else if (!this.C) {
            super.reload();
        }
    }

    @Override // com.tencent.smtt.sdk.WebView, android.view.View
    public void setVisibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else if (!this.C) {
            super.setVisibility(i3);
        }
    }

    @Override // com.tencent.smtt.sdk.WebView
    public void stopLoading() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (!this.C) {
            super.stopLoading();
        }
    }

    public ProtectedWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            init();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public ProtectedWebView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            init();
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
