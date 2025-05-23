package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.ui.RefreshView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.vas.pay.VasH5PayConstants;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import cooperation.vip.manager.MonitorManager;

@RoutePage(desc = "QQVasH5PayBrowserActivity", path = VasH5PayConstants.ROUTE_NAME)
/* loaded from: classes9.dex */
public class QQVasH5PayBrowserActivity extends QQBrowserActivity {
    static IPatchRedirector $redirector_;

    /* loaded from: classes9.dex */
    public static class QQVasH5PayBrowserFragment extends WebViewFragment {
        static IPatchRedirector $redirector_;

        /* loaded from: classes9.dex */
        class a extends com.tencent.mobileqq.webview.swift.proxy.a {
            static IPatchRedirector $redirector_;

            a(com.tencent.mobileqq.webview.swift.utils.t tVar) {
                super(tVar);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQVasH5PayBrowserFragment.this, (Object) tVar);
                }
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public void onFinalState(Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
                } else {
                    super.onFinalState(bundle);
                    ((WebViewFragment) QQVasH5PayBrowserFragment.this).webView.setVisibility(0);
                }
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public void onInitUIContent(Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
                } else {
                    super.onInitUIContent(bundle);
                    QQVasH5PayBrowserFragment.this.setWebViewBackground();
                }
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
            public void onReceivedError(WebView webView, int i3, String str, String str2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, webView, Integer.valueOf(i3), str, str2);
                    return;
                }
                super.onReceivedError(webView, i3, str, str2);
                com.tencent.biz.qrcode.util.h.T(1, R.string.d67);
                QQVasH5PayBrowserFragment.this.getActivity().finish();
            }
        }

        public QQVasH5PayBrowserFragment() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private void rh(ViewGroup viewGroup) {
            if (viewGroup == null) {
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt instanceof ViewGroup) {
                    childAt.setBackgroundColor(0);
                    rh((ViewGroup) childAt);
                } else {
                    childAt.setBackgroundColor(0);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @TargetApi(11)
        public void setWebViewBackground() {
            if (super.getWebView() != null) {
                if ((getUIStyle().f314620c & 524288) != 0) {
                    getUIStyleHandler().T.setVisibility(8);
                    Intent intent = getIntent();
                    if (intent != null && intent.getBooleanExtra(VasWebviewConstants.KEY_FROM_QQREADER, false)) {
                        rh((ViewGroup) getActivity().getWindow().getDecorView());
                    } else {
                        super.getActivity().getWindow().setBackgroundDrawableResource(R.color.ajr);
                    }
                    if (getUIStyleHandler().S instanceof RefreshView) {
                        ((RefreshView) getUIStyleHandler().S).a(false);
                    }
                    if (getUIStyleHandler().f314500b0 != null) {
                        getUIStyleHandler().f314500b0.setVisibility(8);
                    }
                    super.getActivity().findViewById(R.id.ae8).setBackgroundResource(R.color.ajr);
                    if (this.webView.getX5WebViewExtension() != null) {
                        try {
                            this.webView.getView().setBackgroundColor(0);
                            this.webView.setBackgroundColor(0);
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    } else {
                        this.webView.setBackgroundColor(0);
                    }
                } else if (getUIStyleHandler().f314500b0 != null) {
                    getUIStyleHandler().f314500b0.setVisibility(0);
                }
                getWebTitleBarInterface().setRightButton(true);
                super.getWebView().setVisibility(4);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
        public com.tencent.mobileqq.webview.swift.utils.t getWebViewKernelCallBack() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mobileqq.webview.swift.utils.t) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new a(this.webViewSurface);
        }
    }

    public QQVasH5PayBrowserActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mFragmentClass = QQVasH5PayBrowserFragment.class;
        }
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(QQBrowserActivity.TAG, 2, "QQVasH5PayBrowserActivity doOnCreate: ");
        }
        boolean doOnCreate = super.doOnCreate(bundle);
        overridePendingTransition(0, 0);
        MonitorManager.f().j(1, 0, "\u4f1a\u5458\uff1a\u547c\u8d77\u900f\u660e\u652f\u4ed8Activity", "");
        return doOnCreate;
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            setResult(-1);
            super.doOnDestroy();
        }
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.finish();
            overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // mqq.app.AppActivity
    public boolean showPreview() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        boolean showPreview = super.showPreview();
        getWindow().setBackgroundDrawableResource(R.color.ajr);
        findViewById(R.id.ae8).setBackgroundResource(R.color.ajr);
        return showPreview;
    }
}
