package com.tencent.mobileqq.qqgamepub.web.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class QQGamePubWebView extends BaseNestScrollWebView {
    static IPatchRedirector $redirector_;
    private a C;

    /* loaded from: classes16.dex */
    public interface a {
        void Ve(int i3, int i16);
    }

    public QQGamePubWebView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
    }

    @Override // com.tencent.mobileqq.qqgamepub.web.view.BaseNestScrollWebView
    public void onPageFinish(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqgamepub.web.view.BaseNestScrollWebView, com.tencent.biz.pubaccount.CustomWebView, android.view.View
    public void onScrollChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            super.onScrollChanged(i3, i16, i17, i18);
        } else {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        }
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.C = null;
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.web.view.BaseNestScrollWebView
    public void setPaddingTop(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            super.setPaddingTop(i3);
        }
    }

    public void setViewVisibleListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.C = aVar;
        }
    }

    public QQGamePubWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) attributeSet);
    }

    @Override // com.tencent.mobileqq.qqgamepub.web.view.BaseNestScrollWebView, com.tencent.biz.ui.TouchWebView, com.tencent.smtt.sdk.WebViewCallbackClient
    public void onScrollChanged(int i3, int i16, int i17, int i18, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), view);
            return;
        }
        super.onScrollChanged(i3, i16, i17, i18, view);
        a aVar = this.C;
        if (aVar != null) {
            aVar.Ve(i16, i18);
        }
    }
}
