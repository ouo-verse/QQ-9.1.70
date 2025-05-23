package com.tencent.mobileqq.microapp.appbrand.page;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.build.IWebViewBuilder;
import com.tencent.mobileqq.webview.m;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;

/* loaded from: classes15.dex */
public class ProgressWebView extends TouchWebView {
    static IPatchRedirector $redirector_;
    public int htmlId;
    public m mWebViewDirector;

    /* loaded from: classes15.dex */
    public static class MiniAppWebviewBuilder extends AbsWebView implements IWebViewBuilder {
        static IPatchRedirector $redirector_;

        public MiniAppWebviewBuilder(Context context, Activity activity, AppInterface appInterface, TouchWebView touchWebView) {
            super(context, activity, appInterface);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, context, activity, appInterface, touchWebView);
            } else {
                this.mWebview = touchWebView;
            }
        }

        public void buildBottomBar() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            }
        }

        public void buildContentView(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            }
        }

        public void buildData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this);
            }
        }

        public void buildLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        public void buildTitleBar() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            }
        }

        public void buildWebView(AppInterface appInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) appInterface);
            } else {
                super.buildBaseWebView(appInterface);
            }
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView
        public void onProgressChanged(WebView webView, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) webView, i3);
            } else {
                super.onProgressChanged(webView, i3);
            }
        }

        public void preInitWebviewPlugin() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    public ProgressWebView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        WebSettings settings = getSettings();
        settings.setUserAgent(settings.getUserAgentString() + "QQ/MicroApp/H5");
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setPluginsEnabled(true);
        settings.setAllowContentAccess(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setMixedContentMode(0);
        try {
            requestFocus();
        } catch (Exception unused) {
        }
        init(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void init(Context context) {
        BaseActivity baseActivity;
        if (context instanceof MutableContextWrapper) {
            baseActivity = (BaseActivity) ((MutableContextWrapper) context).getBaseContext();
            if (baseActivity == null) {
                m mVar = new m(new MiniAppWebviewBuilder(context, baseActivity, baseActivity.getAppInterface(), this));
                this.mWebViewDirector = mVar;
                mVar.construct(null, baseActivity.app, baseActivity.getIntent());
                return;
            }
            return;
        }
        baseActivity = null;
        if (baseActivity == null) {
        }
    }
}
