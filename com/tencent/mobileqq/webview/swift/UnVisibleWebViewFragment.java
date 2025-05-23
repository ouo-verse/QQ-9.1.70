package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.teamwork.WebViewWrapperForDoc;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;

/* compiled from: P */
/* loaded from: classes20.dex */
public class UnVisibleWebViewFragment extends WebViewFragment {
    static IPatchRedirector $redirector_;
    private WebViewWrapperForDoc C;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a extends com.tencent.mobileqq.webview.swift.proxy.a {
        static IPatchRedirector $redirector_;

        a(com.tencent.mobileqq.webview.swift.utils.t tVar) {
            super(tVar);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UnVisibleWebViewFragment.this, (Object) tVar);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public boolean interceptStartLoadUrl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            UnVisibleWebViewFragment unVisibleWebViewFragment = UnVisibleWebViewFragment.this;
            unVisibleWebViewFragment.sh(unVisibleWebViewFragment.mUrl);
            if (!TextUtils.isEmpty(UnVisibleWebViewFragment.this.mUrl)) {
                QLog.i(WebViewFragment.TAG, 1, "tendocpreload , UnVisibleWebViewFragment  preload =" + UnVisibleWebViewFragment.this.webView);
                UnVisibleWebViewFragment unVisibleWebViewFragment2 = UnVisibleWebViewFragment.this;
                unVisibleWebViewFragment2.webView.loadUrl(unVisibleWebViewFragment2.mUrl);
            }
            return true;
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onWebViewInit(Bundle bundle, TouchWebView touchWebView) {
            long j3;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle, (Object) touchWebView);
                return;
            }
            this.webViewKernelCallBack.onWebViewInit(bundle, touchWebView);
            if (touchWebView.getX5WebViewExtension() == null) {
                return;
            }
            if (UnVisibleWebViewFragment.this.getStatistics().G0) {
                j3 = 2;
            } else {
                j3 = SwiftBrowserStatistics.f314343h1 ? 1L : 0L;
            }
            long j16 = j3;
            if (touchWebView instanceof SwiftReuseTouchWebView) {
                i3 = ((SwiftReuseTouchWebView) touchWebView).s(1) ? 1 : 0;
            } else {
                i3 = 0;
            }
            if (QLog.isColorLevel()) {
                QLog.i(WebViewFragment.TAG, 2, String.format("reportInitPerformance, initType: %d, webViewType: %d, TbsAccelerator.sCostTime: %d", Long.valueOf(j16), Integer.valueOf(i3), Long.valueOf(SwiftBrowserStatistics.W0)));
            }
            System.currentTimeMillis();
            touchWebView.reportInitPerformance(j16, i3, UnVisibleWebViewFragment.this.getStatistics().f314361h, SwiftBrowserStatistics.W0);
            System.currentTimeMillis();
        }
    }

    public UnVisibleWebViewFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static WebViewFragment rh(Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("intent", intent);
        UnVisibleWebViewFragment unVisibleWebViewFragment = new UnVisibleWebViewFragment();
        unVisibleWebViewFragment.setArguments(bundle);
        return unVisibleWebViewFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sh(String str) {
        CookieManager.getInstance().setCookie(".docs.qq.com", "preloading_id=" + TeamWorkHandlerUtils.j(str));
        CookieSyncManager.createInstance(BaseApplicationImpl.getApplication());
        CookieSyncManager.getInstance().sync();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public WebViewWrapper createWebViewWrapper(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (WebViewWrapper) iPatchRedirector.redirect((short) 4, (Object) this, z16);
        }
        WebViewWrapperForDoc webViewWrapperForDoc = new WebViewWrapperForDoc(super.getActivity(), getWebViewKernelCallBack(), this.intent, z16);
        this.C = webViewWrapperForDoc;
        return webViewWrapperForDoc;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public com.tencent.mobileqq.webview.swift.utils.t getWebViewKernelCallBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.webview.swift.utils.t) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new a(this.webViewSurface);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            onCreateView = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            onCreateView.setVisibility(8);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onDestroy();
            qh();
        }
    }

    void qh() {
        if (QLog.isColorLevel()) {
            QLog.d(WebViewFragment.TAG, 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        SwiftBrowserStatistics statistics = getStatistics();
        this.isDestroyed = true;
        statistics.f314382z0 = true;
        WebViewWrapperForDoc webViewWrapperForDoc = this.C;
        if (webViewWrapperForDoc != null) {
            webViewWrapperForDoc.i();
            this.C = null;
            this.webView = null;
        }
        this.mApp = null;
    }
}
