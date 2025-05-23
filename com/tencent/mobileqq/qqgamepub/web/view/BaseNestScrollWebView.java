package com.tencent.mobileqq.qqgamepub.web.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.utils.g;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class BaseNestScrollWebView extends TouchWebView {
    static IPatchRedirector $redirector_;
    public b mIHeaderView;
    private c mILoadingView;
    public int scrollY;
    public boolean useDefaultLoadingLayout;

    public BaseNestScrollWebView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.useDefaultLoadingLayout = true;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    public void attachHeaderView(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        } else {
            this.mIHeaderView = bVar;
        }
    }

    public boolean handleBack() {
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

    @Override // com.tencent.biz.pubaccount.CustomWebView, com.tencent.biz.pubaccount.SuperWebView, com.tencent.qimei.webview.QmX5Webview, com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView, com.tencent.smtt.sdk.WebView
    public void loadUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        super.loadUrl(str);
        if (!str.startsWith("http://")) {
            str.startsWith("https://");
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 == 4) {
            z16 = handleBack();
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    public void onPageFinish(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        b bVar = this.mIHeaderView;
        if (bVar != null) {
            if (bVar.isShow(str)) {
                this.mIHeaderView.show();
                setPaddingTop(this.mIHeaderView.getViewHeight());
            } else {
                this.mIHeaderView.hide();
            }
        }
    }

    @Override // com.tencent.biz.ui.TouchWebView, com.tencent.smtt.sdk.WebViewCallbackClient
    public void onScrollChanged(int i3, int i16, int i17, int i18, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), view);
            return;
        }
        super.onScrollChanged(i3, i16, i17, i18, view);
        b bVar = this.mIHeaderView;
        if (bVar != null && !bVar.isPined()) {
            this.mIHeaderView.onScrollTo(i3, i16, i17, i18);
        }
        this.scrollY = i16;
    }

    public void setLoadingView(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
            return;
        }
        if (cVar != null) {
            boolean z16 = this.useDefaultLoadingLayout;
        }
        this.useDefaultLoadingLayout = false;
    }

    public void setPaddingTop(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        loadUrl(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.JAVASCRIPT_PREFIX + ("if (document.body && document.body.style) {document.body.style.paddingTop='" + g.b(i3, getContext().getResources()) + "px';} void 0"));
    }

    public BaseNestScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.useDefaultLoadingLayout = true;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.CustomWebView, android.view.View
    public void onScrollChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onScrollChanged(i3, i16, i17, i18);
        b bVar = this.mIHeaderView;
        if (bVar != null && !bVar.isPined()) {
            this.mIHeaderView.onScrollTo(i3, i16, i17, i18);
        }
        this.scrollY = i16;
    }
}
