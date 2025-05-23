package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.ui.RefreshView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.LoadingUtil;

/* compiled from: P */
@RoutePage(desc = "\u5185\u7f6e\u6d4f\u89c8\u5668", path = RouterConstants.UI_ROUTE_TRANSLUCENT_BROWSER)
/* loaded from: classes9.dex */
public class QQTranslucentBrowserActivity extends QQBrowserActivity implements com.tencent.mobileqq.webview.swift.af {
    static IPatchRedirector $redirector_ = null;
    public static final String FLAG_HIDE_FLOAT_BAR = "flag_hide_float_bar";
    public static final String FLAG_HIDE_PROGRESS_BAR = "flag_hide_progress_bar";
    public static final String FLAG_SHOW_LOADING_DIALOG = "flag_show_loading_dialog";
    protected boolean canStartActivityForResult;
    protected AbsWebView extraAbsWebView;
    protected Dialog loadingDialog;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class QQTranslucentBrowserFragment extends WebViewFragment {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class a extends com.tencent.mobileqq.webview.swift.proxy.a {
            static IPatchRedirector $redirector_;

            a(com.tencent.mobileqq.webview.swift.utils.t tVar) {
                super(tVar);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQTranslucentBrowserFragment.this, (Object) tVar);
                }
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public void onFinalState(Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
                } else {
                    QQTranslucentBrowserFragment.this.onFinalState(bundle, this.webViewKernelCallBack);
                }
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public void onInitUIContent(Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
                } else {
                    QQTranslucentBrowserFragment.this.onInitUIContent(bundle, this.webViewKernelCallBack);
                }
            }
        }

        public QQTranslucentBrowserFragment() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
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
                onCreateView.setBackgroundColor(0);
            }
            AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
            return onCreateView;
        }

        public void onFinalState(Bundle bundle, com.tencent.mobileqq.webview.swift.utils.t tVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle, (Object) tVar);
            } else {
                tVar.onFinalState(bundle);
            }
        }

        @TargetApi(11)
        public void onInitUIContent(Bundle bundle, com.tencent.mobileqq.webview.swift.utils.t tVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle, (Object) tVar);
                return;
            }
            if (getIntent() != null && getIntent().getBooleanExtra(QQTranslucentBrowserActivity.FLAG_HIDE_FLOAT_BAR, false)) {
                getUIStyle().f314622e = 0L;
            }
            if (getIntent() != null && getIntent().getBooleanExtra(QQTranslucentBrowserActivity.FLAG_HIDE_PROGRESS_BAR, false)) {
                getUIStyleHandler().f314499a0 = true;
            }
            tVar.onInitUIContent(bundle);
            super.getActivity().getWindow().setBackgroundDrawableResource(R.color.ajr);
            if (getUIStyleHandler().S instanceof RefreshView) {
                ((RefreshView) getUIStyleHandler().S).a(false);
            }
            if (getUIStyleHandler().f314500b0 != null) {
                getUIStyleHandler().f314500b0.setVisibility(8);
            }
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
            this.contentView.setBackgroundColor(0);
        }
    }

    public QQTranslucentBrowserActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mFragmentClass = QQTranslucentBrowserFragment.class;
        }
    }

    public void attachRemoteWebView(AbsWebView absWebView) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) absWebView);
            return;
        }
        this.extraAbsWebView = absWebView;
        if (absWebView != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.canStartActivityForResult = z16;
    }

    public boolean canStartActivityForResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.canStartActivityForResult;
    }

    public void dismissLoadingDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Dialog dialog = this.loadingDialog;
        if (dialog != null && dialog.isShowing()) {
            this.loadingDialog.dismiss();
            this.loadingDialog = null;
        }
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        boolean doOnCreate = super.doOnCreate(bundle);
        Intent intent = super.getIntent();
        getWindow().setBackgroundDrawableResource(R.color.ajr);
        View findViewById = findViewById(R.id.ae8);
        if (findViewById != null) {
            findViewById.setBackgroundResource(R.color.ajr);
        }
        if (intent != null && intent.getBooleanExtra(FLAG_SHOW_LOADING_DIALOG, false)) {
            showLoadingDialog();
        }
        return doOnCreate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.doOnDestroy();
            dismissLoadingDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.doOnStop();
            dismissLoadingDialog();
        }
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, mqq.app.IBrowserThirdAppReport
    public String getCurrentUrl() {
        AbsWebView absWebView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        String currentUrl = super.getCurrentUrl();
        if (currentUrl == null && (absWebView = this.extraAbsWebView) != null && absWebView.getWebView() != null) {
            return this.extraAbsWebView.getWebView().getUrl();
        }
        return currentUrl;
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity
    public void onPageFinished(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) webView, (Object) str);
        } else {
            dismissLoadingDialog();
            super.onPageFinished(webView, str);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.af
    public int pluginStartActivityForResult(WebViewPlugin webViewPlugin, Intent intent, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, this, webViewPlugin, intent, Byte.valueOf(b16))).intValue();
        }
        int switchRequestCode = switchRequestCode(webViewPlugin, b16);
        startActivityForResult(intent, b16);
        return switchRequestCode;
    }

    public void showLoadingDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (isFinishing()) {
            return;
        }
        if (this.loadingDialog == null) {
            this.loadingDialog = LoadingUtil.showOnlyLoadingImageDialog(this, 1, false);
        }
        Dialog dialog = this.loadingDialog;
        if (dialog != null) {
            dialog.show();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.af
    public int switchRequestCode(WebViewPlugin webViewPlugin, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, this, webViewPlugin, Byte.valueOf(b16))).intValue();
        }
        return b16;
    }
}
