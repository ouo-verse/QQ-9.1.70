package com.tencent.mobileqq.qqlive.room.feedback;

import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.utils.t;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveFeedbackFragment extends WebViewFragment {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a extends com.tencent.mobileqq.webview.swift.proxy.a {
        static IPatchRedirector $redirector_;

        a(t tVar) {
            super(tVar);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveFeedbackFragment.this, (Object) tVar);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onWebViewInit(Bundle bundle, TouchWebView touchWebView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle, (Object) touchWebView);
                return;
            }
            super.onWebViewInit(bundle, touchWebView);
            if (touchWebView != null) {
                touchWebView.setMask(false);
            }
        }
    }

    public QQLiveFeedbackFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public t getWebViewKernelCallBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (t) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new a(this.webViewSurface);
    }
}
