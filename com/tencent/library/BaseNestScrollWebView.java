package com.tencent.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.webview.QmWebview;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class BaseNestScrollWebView extends QmWebview {
    static IPatchRedirector $redirector_;
    public int C;
    public boolean D;

    /* renamed from: i, reason: collision with root package name */
    private a f118840i;

    /* renamed from: m, reason: collision with root package name */
    private b f118841m;

    public BaseNestScrollWebView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.D = true;
            D();
        }
    }

    public boolean C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (canGoBack()) {
            goBack();
            return true;
        }
        return false;
    }

    protected void D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.qimei.webview.QmWebview, com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtWebView, android.webkit.WebView
    public void loadUrl(String str) {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        super.loadUrl(str);
        if ((str.startsWith("http://") || str.startsWith("https://")) && (bVar = this.f118841m) != null && this.D) {
            bVar.a(this);
        }
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 == 4) {
            z16 = C();
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onScrollChanged(i3, i16, i17, i18);
        a aVar = this.f118840i;
        if (aVar != null && !aVar.isPined()) {
            this.f118840i.onScrollTo(i3, i16, i17, i18);
        }
        this.C = i16;
    }

    public void setLoadingView(b bVar) {
        b bVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar);
            return;
        }
        if ((bVar == null || !this.D) && (bVar2 = this.f118841m) != null) {
            bVar2.b(this);
        }
        if (this.f118841m == null) {
            this.f118841m = bVar;
        }
        b bVar3 = this.f118841m;
        if (bVar3 != null) {
            bVar3.a(this);
        }
        this.D = false;
    }

    public void setPaddingTop(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        loadUrl(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.JAVASCRIPT_PREFIX + ("if (document.body && document.body.style) {document.body.style.paddingTop='" + c.a(getContext(), i3, this.f118840i) + "px';} void 0"));
    }

    public BaseNestScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.D = true;
            D();
        }
    }
}
