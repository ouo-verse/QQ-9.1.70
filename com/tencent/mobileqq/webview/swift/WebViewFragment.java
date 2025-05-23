package com.tencent.mobileqq.webview.swift;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.UiModeManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.DebugTrace;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.mobileqq.webview.view.WebBrowserViewContainerKt;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WebViewFragment extends QBaseFragment implements View.OnClickListener, WebViewProvider, com.tencent.mobileqq.webviewplugin.f, com.tencent.mobileqq.webviewplugin.n {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "WebLog_WebViewFragment";
    private b accountCallback;
    public WebBrowserViewContainerKt contentView;
    protected Intent intent;
    protected boolean isDestroyed;
    protected volatile AppRuntime mApp;
    public final com.tencent.mobileqq.webview.swift.component.b mComponentsProvider;
    protected boolean mNightMode;
    private SwiftBrowserStatistics mStatistics;
    private SwiftIphoneTitleBarUI mSwiftTitleUI;
    private r mUIStyle;
    private com.tencent.mobileqq.webview.swift.component.v mUIStyleHandler;
    protected String mUrl;
    private HashSet<com.tencent.mobileqq.webviewplugin.i> runtimeUpdateObservers;
    protected com.tencent.mobileqq.webviewplugin.n share;
    protected TouchWebView webView;
    protected WebViewKernel webViewKernel;
    protected ak webViewSurface;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements View.OnLayoutChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private Rect f314090d;

        /* renamed from: e, reason: collision with root package name */
        private Rect f314091e;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WebViewFragment.this);
            } else {
                this.f314090d = new Rect();
                this.f314091e = new Rect();
            }
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28));
                return;
            }
            this.f314090d.set(this.f314091e);
            view.getWindowVisibleDisplayFrame(this.f314091e);
            if (this.f314090d.width() == this.f314091e.width()) {
                int height = this.f314090d.height() - this.f314091e.height();
                if (height < -100) {
                    WebViewFragment.this.webViewKernel.o(8589934614L, null);
                } else if (height > 100) {
                    WebViewFragment.this.webViewKernel.o(8589934613L, null);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private class b extends DefaultBaseActivityLifecycleCallback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WebViewFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void onAccountChanged(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            } else {
                WebViewFragment.this.onAccountChanged();
            }
        }
    }

    public WebViewFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mNightMode = false;
        this.mUrl = null;
        this.mComponentsProvider = createComponentsProvider();
        this.runtimeUpdateObservers = new HashSet<>(2);
    }

    private com.tencent.mobileqq.webviewplugin.n ensureShare() {
        if (this.share == null) {
            com.tencent.mobileqq.webviewplugin.n b16 = ((com.tencent.mobileqq.webview.swift.injector.x) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.x.class)).b(getAppRuntime(), super.getActivity());
            if (b16 instanceof com.tencent.mobileqq.webviewplugin.i) {
                this.runtimeUpdateObservers.add((com.tencent.mobileqq.webviewplugin.i) b16);
            }
            this.share = b16;
        }
        if (this.share == null) {
            QLog.e(TAG, 1, "share initialized failed!!!");
            if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
                throw new RuntimeException("share initialized failed!!!");
            }
        }
        return this.share;
    }

    private void release() {
        releaseUiModeManager();
        releaseConfigCallback();
    }

    private void releaseConfigCallback() {
        try {
            if (Build.VERSION.SDK_INT == 31 && CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI.equalsIgnoreCase(Build.MANUFACTURER)) {
                ViewParent parent = getHostActivity().getWindow().getDecorView().getParent();
                Field declaredField = parent.getClass().getDeclaredField("mActivityConfigCallback");
                declaredField.setAccessible(true);
                declaredField.set(parent, null);
                QLog.i(TAG, 1, "releaseConfigCallback success");
            }
        } catch (Exception e16) {
            QLog.i(TAG, 1, "releaseConfigCallback error", e16);
        }
    }

    private void releaseUiModeManager() {
        try {
            if (Build.VERSION.SDK_INT == 34) {
                UiModeManager uiModeManager = (UiModeManager) getHostActivity().getSystemService("uimode");
                Field declaredField = uiModeManager.getClass().getDeclaredField("mContext");
                declaredField.setAccessible(true);
                declaredField.set(uiModeManager, null);
                QLog.i(TAG, 1, "releaseUiModeManager success");
            }
        } catch (Exception e16) {
            QLog.i(TAG, 1, "releaseUiModeManager error", e16);
        }
    }

    public void activityFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
        } else {
            this.webViewSurface.e();
        }
    }

    public com.tencent.mobileqq.webview.swift.component.b createComponentsProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.webview.swift.component.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new com.tencent.mobileqq.webview.swift.component.b(this, 1023, null);
    }

    public WebViewWrapper createWebViewWrapper(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (WebViewWrapper) iPatchRedirector.redirect((short) 22, (Object) this, z16);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this);
            return;
        }
        com.tencent.mobileqq.webviewplugin.n nVar = this.share;
        if (nVar != null) {
            nVar.destroy();
        }
    }

    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "QQBrowserActivity onActivityResult,requestCode=" + i3 + ",resultCode=" + i16);
        }
        this.webViewSurface.g(i3, i16, intent);
    }

    public void doOnBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
        } else {
            if (handleBackEvent()) {
                return;
            }
            QLog.d(TAG, 1, "doOnBackEvent webview not handled, close activity");
            super.getActivity().finish();
        }
    }

    public void doOnConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) configuration);
        } else {
            this.webViewSurface.h(configuration);
            this.webViewKernel.o(8589934611L, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @TargetApi(11)
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) bundle)).booleanValue();
        }
        com.tencent.mobileqq.webview.swift.utils.c.i(this.intent);
        com.tencent.mobileqq.webview.swift.component.e eVar = (com.tencent.mobileqq.webview.swift.component.e) this.mComponentsProvider.a(1);
        if (eVar != null && eVar.h(this.intent)) {
            super.getActivity().finish();
            return true;
        }
        preInitData();
        this.mStatistics.g0("state_activity_create");
        this.mStatistics.D(this.intent, this.mUrl);
        com.tencent.mobileqq.webview.util.s.a("Web_qqbrowser_dooncreate");
        ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).c();
        SwiftBrowserStatistics swiftBrowserStatistics = this.mStatistics;
        this.isDestroyed = false;
        swiftBrowserStatistics.f314382z0 = false;
        this.webViewKernel.I(bundle);
        this.webViewSurface.i(bundle);
        this.mStatistics.S = System.currentTimeMillis() - this.mStatistics.f314361h;
        com.tencent.mobileqq.webview.util.s.b("Web_qqbrowser_dooncreate");
        this.mStatistics.f314367l0 = System.currentTimeMillis();
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 != 24) {
            if (i3 != 25) {
                if (i3 == 82) {
                    this.webViewKernel.o(8589934607L, null);
                    return false;
                }
                return false;
            }
            this.webViewKernel.o(8589934608L, null);
            return false;
        }
        this.webViewKernel.o(8589934609L, null);
        return false;
    }

    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) intent);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("intent", intent);
        this.webViewKernel.o(128L, hashMap);
        if (this.webViewSurface.j(intent)) {
            return;
        }
        if (intent.getDataString() == null || this.webView == null) {
            this.intent = intent;
            preInitData();
        }
        this.webViewKernel.z(intent);
    }

    public void doOnWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, z16);
            return;
        }
        QLog.d(TAG, 1, "doOnWindowFocusChanged: " + z16);
        if (z16) {
            DebugTrace.g(DebugTrace.Step.activity_onWindowFocusChanged);
            v.f(v.f314813i);
        }
        if (z16 && this.mUIStyle.f314618a) {
            an.e(super.getActivity());
            an.a(super.getActivity());
        }
        if (z16) {
            DebugTrace.e(DebugTrace.Step.activity_onWindowFocusChanged);
        }
    }

    public void flingLToR() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this);
            return;
        }
        TouchWebView touchWebView = this.webView;
        if (touchWebView == null) {
            doOnBackEvent();
            return;
        }
        if (touchWebView.canGoBack()) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("target", 2);
            if (this.webView.goBack(hashMap)) {
                reset();
                return;
            }
            return;
        }
        doOnBackEvent();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewProvider
    public AppRuntime getAppRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        if (this.mApp == null) {
            this.mApp = MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
        }
        return this.mApp;
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.f
    public com.tencent.mobileqq.webview.swift.component.b getComponentProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.webview.swift.component.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mComponentsProvider;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewProvider
    public WebBrowserViewContainerKt getContentView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            return (WebBrowserViewContainerKt) iPatchRedirector.redirect((short) 68, (Object) this);
        }
        return this.contentView;
    }

    @Override // com.tencent.mobileqq.webviewplugin.r
    public String getCurrentUrl() {
        TouchWebView touchWebView;
        String stringExtra;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return (String) iPatchRedirector.redirect((short) 55, (Object) this);
        }
        String str = this.mUrl;
        if (TextUtils.isEmpty(str) && (touchWebView = this.webView) != null) {
            if (!TextUtils.isEmpty(touchWebView.getUrl())) {
                stringExtra = this.webView.getUrl();
            } else {
                stringExtra = this.intent.getStringExtra("url");
            }
            if (stringExtra != null) {
                return stringExtra.trim();
            }
            return stringExtra;
        }
        return str;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost, com.qzone.publish.ui.controller.a
    public Activity getHostActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Activity) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return super.getActivity();
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.e
    public WebView getHostWebView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (WebView) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.webView;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewProvider
    public Intent getIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Intent) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.intent;
    }

    @Override // com.tencent.mobileqq.webviewplugin.s
    public View.OnClickListener getOnclickListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return (View.OnClickListener) iPatchRedirector.redirect((short) 60, (Object) this);
        }
        return this;
    }

    @Override // com.tencent.mobileqq.webviewplugin.e
    public String getRedirect302Url() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return (String) iPatchRedirector.redirect((short) 66, (Object) this);
        }
        WebViewKernel webViewKernel = this.webViewKernel;
        if (webViewKernel == null) {
            return "";
        }
        return webViewKernel.D();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewProvider
    public Resources getResource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            return (Resources) iPatchRedirector.redirect((short) 69, (Object) this);
        }
        return super.getResources();
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public <T> T getShare() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return (T) iPatchRedirector.redirect((short) 65, (Object) this);
        }
        return (T) ensureShare();
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public QQProgressDialog getSharePD() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (QQProgressDialog) iPatchRedirector.redirect((short) 46, (Object) this);
        }
        return ensureShare().getSharePD();
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public String getShareUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (String) iPatchRedirector.redirect((short) 45, (Object) this);
        }
        if (ensureShare() == null) {
            return "";
        }
        return ensureShare().getShareUrl();
    }

    public SwiftBrowserStatistics getStatistics() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (SwiftBrowserStatistics) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return this.mStatistics;
    }

    public SwiftIphoneTitleBarUI getSwiftTitleUI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (SwiftIphoneTitleBarUI) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        return this.mSwiftTitleUI;
    }

    public r getUIStyle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (r) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return this.mUIStyle;
    }

    public com.tencent.mobileqq.webview.swift.component.v getUIStyleHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (com.tencent.mobileqq.webview.swift.component.v) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return this.mUIStyleHandler;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewProvider
    public String getUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        if (this.mApp != null) {
            return this.mApp.getAccount();
        }
        Intent intent = this.intent;
        if (intent != null && intent.getExtras() != null) {
            return this.intent.getExtras().getString("uin");
        }
        return null;
    }

    public String getUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this.mUrl;
    }

    public String getUrlFromIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        String stringExtra = this.intent.getStringExtra("url");
        if (stringExtra == null && (stringExtra = this.intent.getStringExtra("key_params_qq")) == null) {
            stringExtra = "";
        }
        return stringExtra.trim();
    }

    @Override // com.tencent.mobileqq.webviewplugin.s
    public com.tencent.mobileqq.webviewplugin.n getWebShareInterface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return (com.tencent.mobileqq.webviewplugin.n) iPatchRedirector.redirect((short) 61, (Object) this);
        }
        return this;
    }

    public com.tencent.mobileqq.webviewplugin.q getWebTitleBarInterface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return (com.tencent.mobileqq.webviewplugin.q) iPatchRedirector.redirect((short) 58, (Object) this);
        }
        return this.webViewSurface;
    }

    @Override // com.tencent.mobileqq.webviewplugin.r
    public CustomWebView getWebView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return (CustomWebView) iPatchRedirector.redirect((short) 56, (Object) this);
        }
        return this.webView;
    }

    public com.tencent.mobileqq.webview.swift.utils.t getWebViewKernelCallBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return (com.tencent.mobileqq.webview.swift.utils.t) iPatchRedirector.redirect((short) 59, (Object) this);
        }
        return this.webViewSurface;
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.e
    public WebViewProvider getWebViewProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (WebViewProvider) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean handleBackEvent() {
        TouchWebView touchWebView;
        TouchWebView touchWebView2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this)).booleanValue();
        }
        this.mStatistics.g0("state_back");
        this.webViewKernel.k();
        if (TextUtils.isEmpty(this.mUrl) && (touchWebView2 = this.webView) != null) {
            this.mUrl = touchWebView2.getUrl();
        }
        this.mStatistics.M(getIntent(), this.mUrl);
        this.mStatistics.W(BaseApplication.getContext(), this.mUrl, this.intent);
        com.tencent.mobileqq.webview.swift.utils.c.k(this.intent);
        if (this.webViewSurface.k()) {
            return true;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("target", 3);
        if (this.webViewKernel.o(8589934601L, hashMap)) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "doOnBackEvent webview plugin engine consumed event");
            }
            return true;
        }
        r rVar = this.mUIStyle;
        if (!rVar.f314632o && (rVar.f314620c & 4) == 0 && (touchWebView = this.webView) != null && touchWebView.canGoBack()) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "doOnBackEvent webview go back to history");
            }
            this.webView.stopLoading();
            this.webView.goBack();
            WebViewPluginEngine pluginEngine = this.webView.getPluginEngine();
            if (pluginEngine != null) {
                pluginEngine.s(this.webView.getUrl(), 8589934610L, hashMap);
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webviewplugin.r
    public boolean isActivityResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Boolean) iPatchRedirector.redirect((short) 57, (Object) this)).booleanValue();
        }
        if (getQBaseActivity() != null) {
            return getQBaseActivity().isResume();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewProvider
    public boolean isDestroyed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        return this.isDestroyed;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewProvider
    public boolean isNightMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return this.mNightMode;
    }

    protected void listenKeyboardShowHide(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) view);
        } else if (view != null) {
            view.addOnLayoutChangeListener(new a());
        }
    }

    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this);
            return;
        }
        QLog.d(TAG, 1, "onAccountChanged listeners:" + this.runtimeUpdateObservers.size() + ", for" + hashCode());
        this.mApp = MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
        Iterator<com.tencent.mobileqq.webviewplugin.i> it = this.runtimeUpdateObservers.iterator();
        while (it.hasNext()) {
            it.next().onRuntimeUpdate(this.mApp);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bundle);
            return;
        }
        DebugTrace.Step step = DebugTrace.Step.fragment_onActivityCreate;
        DebugTrace.g(step);
        super.onActivityCreated(bundle);
        v.f(v.f314812h);
        if (getHostActivity() != null && getHostActivity().isFinishing()) {
            QLog.e(TAG, 1, "HostActivity " + getHostActivity() + " is finishing! Don't call WebViewFragment.doOnCreate!");
            return;
        }
        doOnCreate(bundle);
        DebugTrace.e(step);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        Bundle extras;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
            return;
        }
        Intent intent = (Intent) super.getArguments().getParcelable("intent");
        this.intent = intent;
        if (intent == null) {
            extras = null;
        } else {
            extras = intent.getExtras();
        }
        if (extras != null) {
            if (extras.getClassLoader() == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "No classloader for this fragment");
                }
                this.intent.setExtrasClassLoader(WebViewTitleStyle.class.getClassLoader());
            } else {
                QLog.d(TAG, 2, "already has classloader for this fragment: " + extras.getClassLoader());
            }
        }
        if (activity instanceof QBaseActivity) {
            if (this.accountCallback == null) {
                this.accountCallback = new b();
            }
            ((QBaseActivity) activity).registerActivityLifecycleCallbacks(this.accountCallback);
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 1, "onAttach register accountCallback for:" + hashCode());
            }
        }
        super.onAttach(activity);
    }

    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) view);
        } else {
            this.webViewSurface.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bundle);
            return;
        }
        DebugTrace.Step step = DebugTrace.Step.fragment_onCreate;
        DebugTrace.g(step);
        super.onCreate(bundle);
        v.f(v.f314811g);
        this.webViewSurface = new ak(this);
        this.mStatistics = (SwiftBrowserStatistics) this.mComponentsProvider.a(-2);
        this.mUIStyleHandler = (com.tencent.mobileqq.webview.swift.component.v) this.mComponentsProvider.a(2);
        com.tencent.mobileqq.webview.swift.component.v vVar = this.mUIStyleHandler;
        this.mUIStyle = vVar.f314512m;
        this.mSwiftTitleUI = vVar.C;
        WebViewKernel webViewKernel = new WebViewKernel(this, getWebViewKernelCallBack(), this.mUIStyle);
        this.webViewKernel = webViewKernel;
        this.runtimeUpdateObservers.add(webViewKernel);
        this.mNightMode = ((com.tencent.mobileqq.webview.swift.injector.r) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.r.class)).isNightMode();
        getComponentProvider().b(5, null);
        DebugTrace.e(step);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            view = (View) iPatchRedirector.redirect((short) 9, this, layoutInflater, viewGroup, bundle);
        } else {
            View view2 = WebAccelerateHelper.preloadBrowserView;
            if (view2 instanceof WebBrowserViewContainerKt) {
                this.contentView = (WebBrowserViewContainerKt) view2;
                WebAccelerateHelper.preloadBrowserView = null;
                this.mStatistics.F0 = true;
            } else {
                this.contentView = new WebBrowserViewContainerKt(super.getContext());
            }
            this.contentView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            listenKeyboardShowHide(this.contentView);
            view = this.contentView;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "doOnDestroy");
        }
        SwiftBrowserStatistics swiftBrowserStatistics = this.mStatistics;
        this.isDestroyed = true;
        swiftBrowserStatistics.f314382z0 = true;
        com.tencent.mobileqq.webviewplugin.n nVar = this.share;
        if (nVar != null) {
            nVar.destroy();
        }
        this.webViewSurface.q();
        this.webViewKernel.J();
        this.mApp = null;
        release();
        super.onDestroy();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        super.onDetach();
        Activity hostActivity = getHostActivity();
        if ((hostActivity instanceof QBaseActivity) && (bVar = this.accountCallback) != null) {
            ((QBaseActivity) hostActivity).unregisterActivityLifecycleCallbacks(bVar);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 1, "onDetach unregister accountCallback for:" + hashCode());
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z16) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("onHiddenChanged hidden=%b", Boolean.valueOf(z16)));
        }
        super.onHiddenChanged(z16);
        if (z16) {
            j3 = 512;
        } else {
            j3 = 256;
        }
        this.webViewKernel.o(j3, null);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        SwiftBrowserStatistics swiftBrowserStatistics;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this);
            return;
        }
        try {
            if (SwiftBrowserStatistics.f314346k1 && (swiftBrowserStatistics = this.mStatistics) != null && swiftBrowserStatistics.f314361h > 0) {
                com.tencent.mobileqq.webview.swift.injector.m mVar = (com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class);
                String u16 = SwiftBrowserStatistics.u(this.mUrl);
                SwiftBrowserStatistics swiftBrowserStatistics2 = this.mStatistics;
                mVar.b(null, "dc00899", "WV_Analysis", "", "memory_consumption", u16, swiftBrowserStatistics2.M0, 0, "", swiftBrowserStatistics2.N0, swiftBrowserStatistics2.L0, "");
            }
        } catch (OutOfMemoryError unused) {
        }
        super.onLowMemory();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        }
        this.webViewSurface.r();
        this.webViewKernel.K();
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onPostThemeChanged");
        }
        if (getAppRuntime() != null) {
            this.mNightMode = ((com.tencent.mobileqq.webview.swift.injector.r) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.r.class)).b();
            this.webViewKernel.o(8589934604L, null);
        }
        this.webViewSurface.s();
    }

    public void onPreInit(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        String v3 = com.tencent.mobileqq.webview.swift.utils.i.v(intent);
        WebAccelerateHelper.getInstance().preGetKey(v3, intent, null);
        WebAccelerateHelper.getInstance().preCheckOffline(v3);
        WebAccelerateHelper.getInstance().preFetchResource(v3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        DebugTrace.Step step = DebugTrace.Step.fragment_onResume;
        DebugTrace.g(step);
        com.tencent.mobileqq.webview.util.s.a("Web_qqbrowser_doonresume");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onResume");
        }
        this.webViewKernel.L();
        this.webViewSurface.t(this.webViewKernel.E());
        com.tencent.mobileqq.webview.util.s.b("Web_qqbrowser_doonresume");
        super.onResume();
        DebugTrace.e(step);
    }

    public void onStepDone(int i3, com.tencent.mobileqq.webview.swift.startup.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, (Object) this, i3, (Object) dVar);
            return;
        }
        WebViewKernel webViewKernel = this.webViewKernel;
        if (webViewKernel != null) {
            webViewKernel.M(i3, dVar);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            this.webViewSurface.u();
            super.onStop();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.af
    public final int pluginStartActivityForResult(WebViewPlugin webViewPlugin, Intent intent, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, this, webViewPlugin, intent, Byte.valueOf(b16))).intValue();
        }
        int switchRequestCode = switchRequestCode(webViewPlugin, b16);
        if (switchRequestCode == -1) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "pluginStartActivityForResult not handled");
            }
        } else if (getActivity() != null) {
            getActivity().startActivityFromFragment(this, intent, switchRequestCode, (Bundle) null);
        }
        return switchRequestCode;
    }

    void preInitData() {
        Intent intent;
        Intent intent2;
        Intent intent3;
        String urlFromIntent = getUrlFromIntent();
        this.mUrl = urlFromIntent;
        this.mUIStyleHandler.I(urlFromIntent);
        long j3 = this.mUIStyle.f314620c;
        if (j3 != 4) {
            if ((j3 & 2) != 0 && (intent3 = this.intent) != null) {
                intent3.putExtra("hide_more_button", true);
            }
            if ((this.mUIStyle.f314620c & 1) != 0 && (intent2 = this.intent) != null) {
                intent2.putExtra("webStyle", "noBottomBar");
            }
            if ((this.mUIStyle.f314620c & 1048576) > 0 && (intent = this.intent) != null) {
                intent.putExtra("ignoreLoginWeb", true);
            }
        }
        Intent intent4 = this.intent;
        if (intent4 != null) {
            Bundle bundleExtra = intent4.getBundleExtra("file_browser_extra_params");
            if (bundleExtra != null) {
                if (bundleExtra.getBoolean("hide_more_button", false)) {
                    QLog.d(TAG, 1, "NTScanSpaceManager into online file, hide_more_bottom is true");
                    this.intent.putExtra("hide_more_button", true);
                }
            } else {
                QLog.d(TAG, 1, "NTScanSpaceManager bundle is null");
            }
        } else {
            QLog.d(TAG, 1, "NTScanSpaceManager intent is null");
        }
        if (this.mUIStyle.f314624g) {
            Intent intent5 = this.intent;
            if (intent5 != null) {
                intent5.putExtra("fromOneCLickCLose", false);
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "revokeOneClickClose == true");
            }
        }
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
            return;
        }
        ensureShare();
        com.tencent.mobileqq.webviewplugin.n nVar = this.share;
        if (nVar != null) {
            nVar.reset();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewProvider
    public void setCurUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            this.mUrl = str.trim();
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public boolean setShareUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return ((Boolean) iPatchRedirector.redirect((short) 63, (Object) this, (Object) str)).booleanValue();
        }
        ensureShare();
        com.tencent.mobileqq.webviewplugin.n nVar = this.share;
        if (nVar == null) {
            return false;
        }
        return nVar.setShareUrl(str);
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public boolean setSummary(String str, String str2, String str3, String str4, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return ((Boolean) iPatchRedirector.redirect((short) 64, this, str, str2, str3, str4, bundle)).booleanValue();
        }
        ensureShare();
        com.tencent.mobileqq.webviewplugin.n nVar = this.share;
        if (nVar == null) {
            return false;
        }
        return nVar.setSummary(str, str2, str3, str4, bundle);
    }

    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) str);
        } else {
            this.mSwiftTitleUI.O(str);
        }
    }

    public void setWebView(TouchWebView touchWebView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) touchWebView);
        } else {
            this.webView = touchWebView;
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.n
    public boolean shareStructMsgForH5(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return ((Boolean) iPatchRedirector.redirect((short) 54, this, str, str2, str3, str4, str5, str6, str7, str8)).booleanValue();
        }
        ensureShare();
        com.tencent.mobileqq.webviewplugin.n nVar = this.share;
        if (nVar == null) {
            return false;
        }
        return nVar.shareStructMsgForH5(str, str2, str3, str4, str5, str6, str7, str8);
    }

    public void showActionSheet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this);
        } else {
            ((com.tencent.mobileqq.webview.swift.injector.x) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.x.class)).c((b.C8976b) this.mComponentsProvider.a(4), this.mUIStyle.f314620c, ensureShare());
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.af
    public final int switchRequestCode(WebViewPlugin webViewPlugin, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, this, webViewPlugin, Byte.valueOf(b16))).intValue();
        }
        CustomWebView e16 = webViewPlugin.mRuntime.e();
        if (e16 == null || e16.getPluginEngine() == null) {
            return -1;
        }
        int a16 = ao.a(webViewPlugin);
        if (a16 == -1) {
            QLog.d(TAG, 1, "switchRequestCode failed: webView index=0, pluginIndex=" + a16 + ", requestCode=" + ((int) b16));
            return -1;
        }
        int i3 = (MobileQQ.sProcessId == 7 ? ((a16 << 8) & 65280) | 0 : (a16 << 8) & 65280) | (b16 & 255);
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 2, String.format("switchRequestCode %s [%d,%d,%d] [0x%x,0x%x,0x%x] ret=%d", webViewPlugin.getNameSpace(), 0, Integer.valueOf(a16), Byte.valueOf(b16), 0, Integer.valueOf((a16 << 8) & 65280), Integer.valueOf(b16 & 255), Integer.valueOf(i3)));
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.webviewplugin.f
    public int switchRequestCode(WebViewPlugin webViewPlugin, byte b16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 53)) ? switchRequestCode(webViewPlugin, b16) : ((Integer) iPatchRedirector.redirect((short) 53, this, webViewPlugin, Byte.valueOf(b16), Boolean.valueOf(z16))).intValue();
    }
}
