package com.qzone.feed.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.misc.web.webview.QzoneWebViewPluginManager;
import com.qzone.proxy.feedcomponent.manager.QZoneVideoLoader;
import com.qzone.widget.RedTouchWebView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.webview.m;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.af;
import com.tencent.mobileqq.webview.swift.ao;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.mobileqq.webviewplugin.n;
import com.tencent.mobileqq.webviewplugin.r;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.bx;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.QzoneJumpQBrowserInterface;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneVisitorH5Activity extends BaseActivity implements r, b.e, n, af, QzoneJumpQBrowserInterface {

    /* renamed from: a0, reason: collision with root package name */
    private LinearLayout f47323a0;

    /* renamed from: b0, reason: collision with root package name */
    private TouchWebView f47324b0;

    /* renamed from: c0, reason: collision with root package name */
    private WebViewProgressBar f47325c0;

    /* renamed from: d0, reason: collision with root package name */
    private bx f47326d0;

    /* renamed from: e0, reason: collision with root package name */
    private s7.b f47327e0;

    /* renamed from: g0, reason: collision with root package name */
    private String f47329g0;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f47330h0;

    /* renamed from: k0, reason: collision with root package name */
    protected Share f47333k0;

    /* renamed from: f0, reason: collision with root package name */
    private ActionSheet f47328f0 = null;

    /* renamed from: i0, reason: collision with root package name */
    public final com.tencent.mobileqq.webview.swift.component.b f47331i0 = createComponentsProvider();

    /* renamed from: j0, reason: collision with root package name */
    public long f47332j0 = 8996;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a extends com.tencent.biz.ui.b {
        a(WebViewPluginEngine webViewPluginEngine) {
            super(webViewPluginEngine);
        }

        @Override // com.tencent.biz.ui.b, com.tencent.smtt.sdk.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (QzoneVisitorH5Activity.this.f47326d0 != null && QzoneVisitorH5Activity.this.f47326d0.c() != 2) {
                QzoneVisitorH5Activity.this.f47326d0.a((byte) 2);
            }
            QzoneVisitorH5Activity.this.f47325c0.setVisibility(8);
        }

        @Override // com.tencent.biz.ui.b, com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (QzoneVisitorH5Activity.this.f47326d0 == null || QzoneVisitorH5Activity.this.f47326d0.c() == 0) {
                return;
            }
            QzoneVisitorH5Activity.this.f47326d0.a((byte) 0);
        }

        @Override // com.tencent.biz.ui.b, com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (super.shouldOverrideUrlLoading(webView, str)) {
                return true;
            }
            if (!str.startsWith("mqqzone:") && !str.startsWith("mqq:") && !str.startsWith("mqqapi:")) {
                webView.loadUrl(str);
                return true;
            }
            Intent intent = new Intent();
            intent.setData(Uri.parse(str));
            QzoneVisitorH5Activity.this.startActivity(intent);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements View.OnKeyListener {
        b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i3, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0 || i3 != 4 || !QzoneVisitorH5Activity.this.f47324b0.canGoBack()) {
                return false;
            }
            QzoneVisitorH5Activity.this.f47324b0.goBack();
            return true;
        }
    }

    private Share T2() {
        if (this.f47333k0 == null) {
            this.f47333k0 = new Share(QzoneWebViewPluginManager.getInstance().getRuntime(), this);
        }
        return this.f47333k0;
    }

    private void initUI() {
        QZoneVideoLoader.l();
        this.f47323a0 = (LinearLayout) findViewById(R.id.h8k);
        this.f47325c0 = (WebViewProgressBar) findViewById(R.id.h8l);
        bx bxVar = new bx();
        this.f47326d0 = bxVar;
        this.f47325c0.setController(bxVar);
        this.f47326d0.k(this.f47325c0);
        if (this.f47330h0) {
            this.f47324b0 = new TouchWebView(BaseApplication.getContext());
        } else {
            this.f47324b0 = new RedTouchWebView(BaseApplication.getContext());
        }
        this.f47323a0.addView(this.f47324b0, -1, -1);
        s7.c cVar = new s7.c(this, this, getIntent(), QzoneWebViewPluginManager.getInstance().getRuntime(), true);
        this.f47327e0 = cVar;
        cVar.setWebView(this.f47324b0);
        this.f47324b0.getSettings().setMediaPlaybackRequiresUserGesture(false);
        new m(this.f47327e0).a(null, QzoneWebViewPluginManager.getInstance().getRuntime(), null);
        this.f47324b0.getPluginEngine();
        this.f47324b0.loadUrl(this.f47329g0);
        TouchWebView touchWebView = this.f47324b0;
        touchWebView.setWebViewClient(new a(touchWebView.getPluginEngine()));
        this.f47323a0.setOnKeyListener(new b());
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    /* renamed from: U2, reason: merged with bridge method [inline-methods] */
    public Share getShare() {
        return T2();
    }

    public com.tencent.mobileqq.webview.swift.component.b createComponentsProvider() {
        return new com.tencent.mobileqq.webview.swift.component.b(this, 575, null);
    }

    @Override // com.tencent.mobileqq.webviewplugin.r
    public String getCurrentUrl() {
        TouchWebView touchWebView = this.f47324b0;
        if (touchWebView != null) {
            return touchWebView.getUrl();
        }
        return "";
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.e
    public WebView getHostWebView() {
        return this.f47324b0;
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public QQProgressDialog getSharePD() {
        return T2().getSharePD();
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public String getShareUrl() {
        return null;
    }

    @Override // com.tencent.mobileqq.webviewplugin.r
    public CustomWebView getWebView() {
        return this.f47324b0;
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.e
    public WebViewProvider getWebViewProvider() {
        return null;
    }

    @Override // com.tencent.mobileqq.webviewplugin.r
    public boolean isActivityResume() {
        return super.isResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i16 != -1 || this.f47324b0 == null) {
            return;
        }
        switch (i3) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                String stringExtra = intent.getStringExtra("callbackSn");
                String stringExtra2 = intent.getStringExtra("result");
                this.f47324b0.loadUrl("javascript:window.JsBridge&&JsBridge.callback('" + stringExtra + "',{'r':0,'result':" + stringExtra2 + "});");
                return;
            default:
                return;
        }
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        TouchWebView touchWebView = this.f47324b0;
        if (touchWebView != null && touchWebView.canGoBack()) {
            this.f47324b0.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bhm);
        this.f47329g0 = getIntent().getStringExtra("url");
        this.f47330h0 = getIntent().getBooleanExtra("RightFling", true);
        initUI();
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ViewParent parent;
        s7.b bVar = this.f47327e0;
        if (bVar != null) {
            bVar.onDestroy();
        }
        TouchWebView touchWebView = this.f47324b0;
        if (touchWebView != null && (parent = touchWebView.getParent()) != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeAllViewsInLayout();
        }
        super.onDestroy();
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        s7.b bVar = this.f47327e0;
        if (bVar != null) {
            bVar.onPause();
        }
        super.onPause();
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        s7.b bVar = this.f47327e0;
        if (bVar != null) {
            bVar.onResume();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.af
    public int pluginStartActivityForResult(WebViewPlugin webViewPlugin, Intent intent, byte b16) {
        int switchRequestCode = switchRequestCode(webViewPlugin, b16);
        if (switchRequestCode == -1) {
            if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, "pluginStartActivityForResult not handled");
            }
        } else {
            startActivityForResult(intent, switchRequestCode);
        }
        return switchRequestCode;
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public boolean setShareUrl(String str) {
        return T2().setShareUrl(str);
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public boolean setSummary(String str, String str2, String str3, String str4, Bundle bundle) {
        return T2().setSummary(str, str2, str3, str4, bundle);
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public boolean shareStructMsgForH5(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        return false;
    }

    @Override // com.tencent.mobileqq.webviewplugin.r
    public void showActionSheet() {
        SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler) this.f47331i0.a(4);
        if (swiftBrowserShareMenuHandler != null) {
            swiftBrowserShareMenuHandler.F = false;
            swiftBrowserShareMenuHandler.G = true;
            swiftBrowserShareMenuHandler.S(T2(), this.f47332j0);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.af
    public int switchRequestCode(WebViewPlugin webViewPlugin, byte b16) {
        CustomWebView e16 = webViewPlugin.mRuntime.e();
        if (e16 == null || e16.getPluginEngine() == null) {
            return -1;
        }
        int a16 = ao.a(webViewPlugin);
        if (a16 != -1) {
            return ((a16 << 8) & 65280) | 0 | (b16 & 255);
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "switchRequestCode failed: webview index=0, pluginIndex=" + a16);
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public void destroy() {
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.e
    public Activity getHostActivity() {
        return this;
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public void reset() {
    }
}
