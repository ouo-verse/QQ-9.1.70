package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.api.IPublicAccountWebviewPlugin;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IJsApi;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes12.dex */
public class CustomHeightFragment extends WebViewFragment {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements b.d {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CustomHeightFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.component.b.d
        public Object a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            if (i3 != 2) {
                return null;
            }
            return new c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b extends com.tencent.mobileqq.webview.swift.proxy.a {
        static IPatchRedirector $redirector_;

        b(com.tencent.mobileqq.webview.swift.utils.t tVar) {
            super(tVar);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CustomHeightFragment.this, (Object) tVar);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onFinalState(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
                return;
            }
            super.onFinalState(bundle);
            CustomHeightFragment.this.getSwiftTitleUI().X(false);
            CustomHeightFragment.this.getUIStyleHandler().T.setVisibility(8);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onInitUIContent(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
                return;
            }
            CustomHeightFragment.this.getUIStyle().f314622e = 0L;
            super.onInitUIContent(bundle);
            CustomHeightFragment.this.getActivity().getWindow().setBackgroundDrawableResource(R.color.ajr);
            View findViewById = CustomHeightFragment.this.getActivity().findViewById(R.id.ae8);
            if (findViewById != null) {
                findViewById.setBackgroundResource(R.color.ajr);
            }
            if (CustomHeightFragment.this.getUIStyleHandler().S instanceof RefreshView) {
                ((RefreshView) CustomHeightFragment.this.getUIStyleHandler().S).a(false);
            }
            if (CustomHeightFragment.this.getUIStyleHandler().f314500b0 != null) {
                CustomHeightFragment.this.getUIStyleHandler().f314500b0.setVisibility(8);
            }
            CustomHeightFragment.this.contentView.setBackgroundColor(0);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onReceivedError(WebView webView, int i3, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, webView, Integer.valueOf(i3), str, str2);
                return;
            }
            super.onReceivedError(webView, i3, str, str2);
            if (QLog.isColorLevel()) {
                QLog.d("CustomHeightFragment", 2, "ConfessBrowserFragment onReceivedError = ");
            }
            if (CustomHeightFragment.this.getActivity() != null) {
                CustomHeightFragment.this.getActivity().finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c extends com.tencent.mobileqq.webview.swift.component.v {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    CustomHeightFragment.this.getHostActivity().finish();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CustomHeightFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.component.v
        public void D() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (this.f314441d.getWebView() != null) {
                WebView webView = this.f314441d.getWebView();
                webView.setId(R.id.webview);
                int i16 = this.f314502d0;
                if (i16 != 1) {
                    webView.setBackgroundColor(i16);
                }
                Activity activity = (Activity) webView.getContext();
                if (activity.getIntent() != null && activity.getIntent().getExtras() != null) {
                    i3 = activity.getIntent().getExtras().getInt("customheight", 0);
                } else {
                    i3 = 0;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("SwiftBrowserUIStyleHandler", 2, "initWebViewInContentView height=" + i3);
                }
                if (i3 != 0) {
                    ViewGroup viewGroup = this.S;
                    if (viewGroup instanceof RelativeLayout) {
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i3);
                        layoutParams.addRule(12);
                        this.S.addView(webView, 0, layoutParams);
                    } else {
                        viewGroup.addView(webView, 0, new ViewGroup.LayoutParams(-1, i3));
                    }
                    this.S.setOnClickListener(new a());
                    return;
                }
                this.S.addView(webView, 0, new ViewGroup.LayoutParams(-1, -1));
            }
        }
    }

    public CustomHeightFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
    public com.tencent.mobileqq.webview.swift.component.b createComponentsProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.webview.swift.component.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new com.tencent.mobileqq.webview.swift.component.b(this, 1023, new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("CustomHeightFragment", 2, "ConfessBrowserFragment doOnCreate = ");
        }
        boolean doOnCreate = super.doOnCreate(bundle);
        TouchWebView touchWebView = this.webView;
        if (touchWebView != null && touchWebView.getPluginEngine() != null) {
            this.webView.getPluginEngine().D(new String[]{((IJsApi) QRoute.api(IJsApi.class)).getWebViewJumpPluginNameSpace(), ((IJsApi) QRoute.api(IJsApi.class)).getQQApiPluginNameSpace(), SensorJsPlugin.SENSOR_INTERVAL_UI, "share", IPublicAccountWebviewPlugin.NAME_SPACE});
        }
        return doOnCreate;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public com.tencent.mobileqq.webview.swift.utils.t getWebViewKernelCallBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.webview.swift.utils.t) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new b(this.webViewSurface);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onDestroy();
        }
    }
}
