package com.tencent.mobileqq.ad.landingpage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vas.api.IVasKuiklyApi;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.webview.swift.h;
import com.tencent.mobileqq.webview.swift.u;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.mobileqq.webviewplugin.q;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.smtt.sdk.WebView;

/* loaded from: classes10.dex */
public class LandingPageWebFragment extends WebViewFragment implements h {
    static IPatchRedirector $redirector_;
    private static g D;
    private View C;

    /* loaded from: classes10.dex */
    class a extends com.tencent.mobileqq.webview.swift.proxy.b {
        static IPatchRedirector $redirector_;

        a(q qVar) {
            super(qVar);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LandingPageWebFragment.this, (Object) qVar);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.b, com.tencent.mobileqq.webviewplugin.q
        public void Kb(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                super.Kb(i3, i16);
            }
        }
    }

    /* loaded from: classes10.dex */
    class b extends com.tencent.mobileqq.webview.swift.proxy.a {
        static IPatchRedirector $redirector_;

        b(t tVar) {
            super(tVar);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LandingPageWebFragment.this, (Object) tVar);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onInitUIContent(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            } else {
                QLog.e("LandingPageWebFragment", 1, "onInitUIContent ");
                super.onInitUIContent(bundle);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onPageFinished(WebView webView, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) webView, (Object) str);
            } else {
                LandingPageWebFragment.this.th(this.webViewKernelCallBack, webView, str);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onWebViewInit(Bundle bundle, TouchWebView touchWebView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle, (Object) touchWebView);
            } else {
                super.onWebViewInit(bundle, touchWebView);
                QLog.e("LandingPageWebFragment", 1, "onWebViewInit ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class c implements com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
        public void hideErrorView() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
        public void hideLoadingView() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
        public void onPageLoadComplete(boolean z16, @Nullable ErrorReason errorReason, @NonNull KuiklyRenderCoreExecuteMode kuiklyRenderCoreExecuteMode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), errorReason, kuiklyRenderCoreExecuteMode);
            } else {
                QLog.i("LandingPageWebFragment", 1, "onPageLoadComplete");
            }
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
        public void showErrorView() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
        public void showLoadingView() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }
    }

    public LandingPageWebFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void rh(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("CONTENT_BACKGROUND_IMG");
            D = ((IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class)).createKuiklyRenderView(BaseApplication.getContext(), new c());
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("src_url", stringExtra);
            Bundle bundleExtra = intent.getBundleExtra("kuiklyNsrParams");
            for (String str : bundleExtra.keySet()) {
                arrayMap.put(str, (String) bundleExtra.get(str));
            }
            D.d(((IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class)).buildVasKuiklySchema("qqnsr", "qqnsr", arrayMap), new Size((int) ah.Z(), (int) (ah.y() + getQBaseActivity().getTitleBarHeight())));
        }
    }

    public static LandingPageWebFragment sh(Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("intent", intent);
        LandingPageWebFragment landingPageWebFragment = new LandingPageWebFragment();
        landingPageWebFragment.setArguments(bundle);
        return landingPageWebFragment;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
    public void activityFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.activityFinish();
        if (getHostActivity() != null) {
            getHostActivity().setResult(-1);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public q getWebTitleBarInterface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (q) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new a(this.webViewSurface);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public t getWebViewKernelCallBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (t) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new b(this.webViewSurface);
    }

    @Override // com.tencent.mobileqq.webview.swift.h
    public WebViewFragment newInstance(int i3, u uVar, WebViewTabBarData webViewTabBarData, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (WebViewFragment) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), uVar, webViewTabBarData, intent);
        }
        return sh(intent);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        } else {
            QLog.e("LandingPageWebFragment", 1, "landing page onAttach");
            super.onAttach(activity);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            onCreateView = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            QLog.e("LandingPageWebFragment", 1, "onCreateView");
            rh(this.intent);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) bundle);
        } else {
            super.onViewCreated(view, bundle);
            uh(this.contentView);
        }
    }

    public void th(t tVar, WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, tVar, webView, str);
        } else {
            tVar.onPageFinished(webView, str);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.ad.landingpage.LandingPageWebFragment.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LandingPageWebFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (LandingPageWebFragment.D != null) {
                        LandingPageWebFragment.D.onDetach();
                    }
                    if (LandingPageWebFragment.this.C.getParent() != null) {
                        ((ViewGroup) LandingPageWebFragment.this.C.getParent()).removeView(LandingPageWebFragment.this.C);
                    }
                }
            });
        }
    }

    public void uh(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
            return;
        }
        if (getUIStyleHandler() != null) {
            getUIStyleHandler().f314499a0 = true;
        }
        QLog.e("LandingPageWebFragment", 1, "landing page onInitUIContent");
        Object obj = D;
        if (obj != null) {
            View view2 = (View) obj;
            this.C = view2;
            if (((View) view2.getParent()) != null) {
                ((ViewGroup) this.C.getParent()).removeView(this.C);
            }
            ((ViewGroup) this.contentView.getParent()).addView(this.C);
        }
    }
}
