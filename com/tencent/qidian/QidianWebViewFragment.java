package com.tencent.qidian;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QidianWebViewFragment extends WebViewFragment {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a extends com.tencent.mobileqq.webview.swift.proxy.a {
        static IPatchRedirector $redirector_;

        a(t tVar) {
            super(tVar);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QidianWebViewFragment.this, (Object) tVar);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) webView, (Object) str)).booleanValue();
            }
            if (str.startsWith("mqqwpa://") && str.contains("request=videochat")) {
                try {
                    ax c16 = bi.c(null, QidianWebViewFragment.this.getActivity(), str);
                    if (c16 != null) {
                        return c16.b();
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QidianWebViewFragment", 2, "shouldOverrideUrlLoading " + e16.getMessage());
                    }
                }
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    public QidianWebViewFragment() {
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
