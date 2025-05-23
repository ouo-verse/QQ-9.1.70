package com.tencent.mobileqq.flashshow.api.hybird;

import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.mobileqq.webview.view.WebBrowserViewContainerKt;

/* loaded from: classes12.dex */
public class FSPublishHybirdFragment extends WebViewFragment {
    static IPatchRedirector $redirector_;

    /* loaded from: classes12.dex */
    class a extends com.tencent.mobileqq.webview.swift.proxy.a {
        static IPatchRedirector $redirector_;

        a(t tVar) {
            super(tVar);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FSPublishHybirdFragment.this, (Object) tVar);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onDataInit(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
                return;
            }
            FSPublishHybirdFragment.this.getUIStyleHandler().f314512m.Q = false;
            FSPublishHybirdFragment.this.getUIStyleHandler().f314512m.f314631n = true;
            FSPublishHybirdFragment.this.getUIStyleHandler().f314502d0 = FSPublishHybirdFragment.this.getResources().getColor(R.color.qvideo_skin_color_bg_default);
            super.onDataInit(bundle);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onFinalState(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
                return;
            }
            super.onFinalState(bundle);
            if (FSPublishHybirdFragment.this.getActivity().getRequestedOrientation() != 1) {
                FSPublishHybirdFragment.this.getActivity().setRequestedOrientation(1);
            }
            FSPublishHybirdFragment.this.getWebView().setVerticalScrollBarEnabled(false);
            FSPublishHybirdFragment.this.getWebView().setHorizontalScrollBarEnabled(false);
            FSPublishHybirdFragment.this.getWebView().getSettings().setDefaultTextEncodingName("utf-8");
            FSPublishHybirdFragment.this.getWebView().getSettings().setUserAgentString(FSPublishHybirdFragment.this.getWebView().getSettings().getUserAgentString() + " QQ_APP_Subscribe");
            if (NetworkUtil.isNetworkAvailable(FSPublishHybirdFragment.this.getActivity())) {
                FSPublishHybirdFragment.this.getWebView().getSettings().setCacheMode(2);
            }
            if (FSPublishHybirdFragment.this.getUIStyleHandler() != null && FSPublishHybirdFragment.this.getUIStyleHandler().U != null) {
                FSPublishHybirdFragment.this.getUIStyleHandler().U.l(false);
            }
            ((WebViewFragment) FSPublishHybirdFragment.this).webView.setMask(false);
        }
    }

    public FSPublishHybirdFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void setWebViewBackground() {
        if (getWebView() != null) {
            getUIStyleHandler().f314501c0 = getResources().getColor(R.color.qvideo_skin_color_bg_default);
            if (getUIStyleHandler().f314500b0 != null) {
                getUIStyleHandler().f314500b0.setBackgroundColor(getUIStyleHandler().f314501c0);
            }
            if (getWebView().getX5WebViewExtension() != null) {
                try {
                    getWebView().getView().setBackgroundColor(getResources().getColor(R.color.qvideo_skin_color_bg_default));
                    getWebView().setBackgroundColor(getResources().getColor(R.color.qvideo_skin_color_bg_default));
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            } else {
                getWebView().setBackgroundColor(getResources().getColor(R.color.qvideo_skin_color_bg_default));
            }
            WebBrowserViewContainerKt webBrowserViewContainerKt = this.contentView;
            if (webBrowserViewContainerKt != null) {
                webBrowserViewContainerKt.setBackgroundColor(getResources().getColor(R.color.qvideo_skin_color_bg_default));
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webview.swift.WebViewProvider
    public void doOnBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.doOnBackEvent();
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

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
        } else {
            super.onActivityCreated(bundle);
            setWebViewBackground();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onPause();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onResume();
        }
    }
}
