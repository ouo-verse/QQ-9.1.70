package com.tencent.mobileqq.richstatus;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.mini.config.AppSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.widget.ProtectedWebView;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ActionUrlActivity extends IphoneTitleBarActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private ProtectedWebView f282113a0;

    /* renamed from: b0, reason: collision with root package name */
    private View f282114b0;

    /* renamed from: c0, reason: collision with root package name */
    private ProgressBar f282115c0;

    /* renamed from: d0, reason: collision with root package name */
    private com.tencent.mobileqq.jsbridge.a f282116d0;

    /* renamed from: e0, reason: collision with root package name */
    private StatusJsHandler f282117e0;

    /* renamed from: f0, reason: collision with root package name */
    private String f282118f0;

    /* renamed from: g0, reason: collision with root package name */
    private RelativeLayout f282119g0;

    /* renamed from: h0, reason: collision with root package name */
    private View f282120h0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends WebChromeClient {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActionUrlActivity.this);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onProgressChanged(WebView webView, int i3) {
            JsInjector.getInstance().onProgressChanged(webView, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) webView, i3);
            } else {
                super.onProgressChanged(webView, i3);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) webView, (Object) str);
            } else {
                ActionUrlActivity.this.setTitle(str);
                ActionUrlActivity.this.K2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends WebViewClient {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActionUrlActivity.this);
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) webView, (Object) str);
                return;
            }
            ActionUrlActivity.this.f282115c0.setVisibility(8);
            super.onPageFinished(webView, str);
            ActionUrlActivity.this.K2();
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, webView, str, bitmap);
                return;
            }
            ActionUrlActivity.this.f282115c0.setVisibility(0);
            ActionUrlActivity.this.f282114b0.setVisibility(8);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onReceivedError(WebView webView, int i3, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, webView, Integer.valueOf(i3), str, str2);
                return;
            }
            ActionUrlActivity.this.f282113a0.clearView();
            ActionUrlActivity.this.f282115c0.setVisibility(8);
            ActionUrlActivity.this.f282114b0.setVisibility(0);
            super.onReceivedError(webView, i3, str, str2);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) webView, (Object) str)).booleanValue();
            }
            if (ActionUrlActivity.this.f282116d0.a(webView, str)) {
                return true;
            }
            return false;
        }
    }

    public ActionUrlActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f282118f0 = null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void initUI() {
        this.f282119g0 = (RelativeLayout) findViewById(R.id.kkl);
        ProtectedWebView protectedWebView = new ProtectedWebView(BaseApplicationImpl.sApplication);
        this.f282113a0 = protectedWebView;
        this.f282119g0.addView(protectedWebView, 0, new RelativeLayout.LayoutParams(-1, -1));
        this.f282113a0.removeJavascriptInterface("searchBoxJavaBridge_");
        this.f282113a0.setScrollBarStyle(0);
        WebSettings settings = this.f282113a0.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUserAgentString(settings.getUserAgentString() + " " + AppSetting.UserAgent);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(getApplicationContext().getDir("database", 0).getPath());
        settings.setDomStorageEnabled(true);
        this.f282113a0.setWebViewClient(new b());
        this.f282113a0.setWebChromeClient(new a());
        this.f282116d0 = new com.tencent.mobileqq.jsbridge.a();
        StatusJsHandler statusJsHandler = new StatusJsHandler(this, this.f282113a0, null);
        this.f282117e0 = statusJsHandler;
        this.f282116d0.c(statusJsHandler, "statusJsHandler");
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.kki);
        this.f282114b0 = linearLayout;
        linearLayout.setVisibility(0);
        this.f282115c0 = (ProgressBar) findViewById(R.id.kkj);
        this.f282118f0 = this.leftView.getText().toString();
        this.f282120h0 = findViewById(R.id.enc);
        if (ThemeUtil.isInNightMode(this.app)) {
            this.f282120h0.setVisibility(0);
        }
    }

    void K2() {
        if (this.f282113a0.canGoBack()) {
            this.leftView.setText(R.string.i9p);
        } else {
            this.leftView.setText(this.f282118f0);
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        setContentView(R.layout.c2o);
        initUI();
        this.f282113a0.loadUrl(getIntent().getStringExtra("key_params_qq"));
        this.f282115c0.setVisibility(0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.doOnDestroy();
        try {
            RelativeLayout relativeLayout = this.f282119g0;
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
        } catch (Exception unused) {
        }
        try {
            this.f282113a0.stopLoading();
        } catch (Exception unused2) {
        }
        try {
            this.f282113a0.clearView();
        } catch (Exception unused3) {
        }
        try {
            this.f282113a0.destroy();
        } catch (Exception unused4) {
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.f282113a0.canGoBack()) {
            try {
                this.f282113a0.stopLoading();
            } catch (Exception unused) {
            }
            this.f282113a0.goBack();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
