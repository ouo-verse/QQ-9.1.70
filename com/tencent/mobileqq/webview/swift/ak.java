package com.tencent.mobileqq.webview.swift;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.mobileqq.widget.bx;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.PermissionRequest;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ak implements com.tencent.mobileqq.webview.swift.utils.t, com.tencent.mobileqq.webviewplugin.q {
    static IPatchRedirector $redirector_;
    private com.tencent.mobileqq.webview.swift.component.v C;
    private r D;
    private SwiftIphoneTitleBarUI E;
    private com.tencent.mobileqq.webview.swift.component.f F;
    private SwiftBrowserStatistics G;
    private View H;
    private boolean I;
    private FrameLayout J;
    private View K;
    private int L;
    private int M;
    private int N;
    private int P;
    private View Q;
    private IX5WebChromeClient.CustomViewCallback R;
    private boolean S;
    private boolean T;
    private int U;
    private int V;
    View.OnTouchListener W;

    /* renamed from: d, reason: collision with root package name */
    private boolean f314198d;

    /* renamed from: e, reason: collision with root package name */
    private final com.tencent.mobileqq.webview.swift.injector.y f314199e;

    /* renamed from: f, reason: collision with root package name */
    private WebViewProvider f314200f;

    /* renamed from: h, reason: collision with root package name */
    private TouchWebView f314201h;

    /* renamed from: i, reason: collision with root package name */
    private String f314202i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f314203m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ak.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    return false;
                }
                if (view == ak.this.E.M) {
                    if (QLog.isColorLevel()) {
                        QLog.d("WebViewSurface", 2, "vg onTouch");
                    }
                    HashMap hashMap = new HashMap(2);
                    hashMap.put("X", Integer.valueOf((int) motionEvent.getX()));
                    hashMap.put("Y", Integer.valueOf((int) motionEvent.getY()));
                    if (ak.this.f314201h != null) {
                        ak.this.f314201h.getPluginEngine().s(ak.this.f314201h.getUrl(), 8589934606L, hashMap);
                    }
                }
            }
            return true;
        }
    }

    public ak(@NonNull WebViewProvider webViewProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) webViewProvider);
            return;
        }
        this.f314198d = false;
        this.f314202i = "";
        this.f314203m = false;
        this.S = true;
        this.T = true;
        this.U = 0;
        this.V = 0;
        this.W = new a();
        this.f314200f = webViewProvider;
        com.tencent.mobileqq.webview.swift.component.v vVar = (com.tencent.mobileqq.webview.swift.component.v) webViewProvider.getComponentProvider().a(2);
        this.C = vVar;
        vVar.X(webViewProvider.getOnclickListener());
        this.C.m();
        com.tencent.mobileqq.webview.swift.component.v vVar2 = this.C;
        this.D = vVar2.f314512m;
        this.E = vVar2.C;
        this.F = (com.tencent.mobileqq.webview.swift.component.f) webViewProvider.getComponentProvider().a(-1);
        this.G = (SwiftBrowserStatistics) webViewProvider.getComponentProvider().a(-2);
        this.f314199e = (com.tencent.mobileqq.webview.swift.injector.y) com.tencent.mobileqq.webview.swift.injector.aa.d(com.tencent.mobileqq.webview.swift.injector.y.class);
    }

    private void f() {
        if (((com.tencent.mobileqq.webview.swift.injector.c) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).isSwitchOn("105731", false)) {
            Window window = this.f314200f.getHostActivity().getWindow();
            int navigationBarColor = window.getNavigationBarColor();
            if (navigationBarColor == 0 || ((navigationBarColor >> 24) & 255) == 0) {
                RFWImmersiveUtils.setNavigationBarColor(window, ie0.a.f().g(this.f314200f.getHostActivity(), R.color.qui_common_bg_bottom_light, 1000));
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("WebViewSurface", 1, String.format("adjustBottomNaviBar window navigation color=#%x model=%s", Integer.valueOf(navigationBarColor), DeviceInfoMonitor.getModel()));
            }
        }
    }

    private void l() {
        com.tencent.mobileqq.webview.util.s.a("Web_qqbrowser_createtabbar");
        Activity hostActivity = this.f314200f.getHostActivity();
        if (hostActivity instanceof QQBrowserActivity) {
            ((QQBrowserActivity) hostActivity).createTabBarView();
            boolean webViewMenuNeedBlock = ZhuoXusManager.instance().webViewMenuNeedBlock();
            boolean booleanExtra = this.f314200f.getIntent().getBooleanExtra("fromAio", false);
            if (webViewMenuNeedBlock && booleanExtra) {
                this.E.E.setVisibility(8);
            }
        }
        com.tencent.mobileqq.webview.util.s.b("Web_qqbrowser_createtabbar");
    }

    private void m() {
        WebViewTitleStyle webViewTitleStyle = this.D.T;
        if (webViewTitleStyle == null) {
            com.tencent.mobileqq.webview.swift.utils.o.e(this.E.M, R.drawable.qui_bg_nav_secondary);
            return;
        }
        this.E.M.setBackgroundColor(webViewTitleStyle.f313798e);
        this.E.W(this.D.T.f313799f);
        this.E.S(this.D.T.f313800h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(String str, String str2, String str3, String str4, long j3) {
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setData(Uri.parse(str));
        Activity hostActivity = this.f314200f.getHostActivity();
        if (hostActivity != null) {
            hostActivity.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        this.f314199e.e(this.f314200f);
    }

    private void v(int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.d("WebViewSurface", 1, "onUpdateOrientation ori: " + i3 + " lastOri: " + this.U);
        }
        if (this.U != i3) {
            this.U = i3;
            if (i3 == 2) {
                this.V = an.d(this.f314200f.getHostActivity());
                an.a(this.f314200f.getHostActivity());
            } else {
                an.b(this.f314200f.getHostActivity(), this.V);
            }
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.q
    public void Ad(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, z16);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("WebViewSurface", 2, "setImmersiveStatus trans=" + this.S + " immersive=" + this.T + " needStatusMask=" + z16);
        }
        if (this.S && ImmersiveUtils.isSupporImmersive() == 1) {
            this.f314200f.getHostActivity().getWindow().addFlags(67108864);
            if (this.T) {
                if (this.Q == null) {
                    this.Q = new View(this.f314200f.getHostActivity());
                }
                WebViewTitleStyle webViewTitleStyle = this.D.T;
                if (webViewTitleStyle != null) {
                    this.Q.setBackgroundColor(webViewTitleStyle.f313797d);
                    SimpleUIUtil.adjustColorForQQBrowserActivity(true, this.D.T.f313797d, this.f314200f.getHostActivity().getWindow());
                } else {
                    this.f314199e.u(this.Q, this.f314200f);
                }
                if (this.Q.getParent() == null) {
                    if (z16) {
                        View view = new View(this.f314200f.getHostActivity());
                        view.setId(R.id.b_3);
                        view.setBackgroundColor(-16777216);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()));
                        layoutParams.addRule(10, -1);
                        this.C.V.addView(view, layoutParams);
                    }
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()));
                    layoutParams2.addRule(10, -1);
                    this.C.V.addView(this.Q, layoutParams2);
                }
            }
            ImmersiveUtils.clearCoverForStatus(this.f314200f.getHostActivity().getWindow(), true);
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.q
    public void Hf(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            iPatchRedirector.redirect((short) 71, (Object) this, i3);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("WebViewSurface", 2, "adjustContentView webviewPostion:" + i3);
        }
        int dimensionPixelSize = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.f158465gi);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            i16 = ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
        } else {
            i16 = 0;
        }
        int dimensionPixelSize2 = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.f159599b02) + i16;
        if (i3 == 1) {
            this.f314200f.getWebTitleBarInterface().Kb(dimensionPixelSize + i16, i16);
        } else if (i3 == 2) {
            this.f314200f.getWebTitleBarInterface().Kb(dimensionPixelSize + (i16 * 2), dimensionPixelSize2);
        } else {
            this.f314200f.getWebTitleBarInterface().Kb(dimensionPixelSize + i16, 0);
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.q
    public void Kb(int i3, int i16) {
        LinearLayout.LayoutParams layoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        TextView textView = (TextView) this.C.V.findViewById(R.id.aeb);
        if (textView != null && (layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams()) != null) {
            layoutParams.topMargin = i3;
            textView.setLayoutParams(layoutParams);
        }
        View findViewById = this.C.V.findViewById(R.id.l2a);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.topMargin = i16;
            findViewById.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.q
    public void Pg(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, z16);
        } else {
            this.T = z16;
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.q
    public void Sc(boolean z16, int i3, int i16) {
        SwiftIphoneTitleBarUI swiftIphoneTitleBarUI;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        com.tencent.mobileqq.webview.swift.component.v vVar = this.C;
        if (vVar != null && (swiftIphoneTitleBarUI = vVar.C) != null) {
            swiftIphoneTitleBarUI.b0(z16, i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.q
    public View a3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            return (View) iPatchRedirector.redirect((short) 67, (Object) this);
        }
        return this.Q;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean afterWebViewEngineHandleOverrideUrl(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this, (Object) webView, (Object) str)).booleanValue();
        }
        return this.f314199e.r(this.f314200f, webView, str);
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean beforeWebViewEngineHandleOverrideUrl(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this, (Object) webView, (Object) str)).booleanValue();
        }
        return this.f314199e.y(this.f314200f, this.f314201h, str);
    }

    public void e() {
        WebViewPluginEngine pluginEngine;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, (Object) this);
            return;
        }
        TouchWebView touchWebView = this.f314201h;
        if (touchWebView == null) {
            pluginEngine = null;
        } else {
            pluginEngine = touchWebView.getPluginEngine();
        }
        if (pluginEngine != null) {
            pluginEngine.s(this.f314200f.getCurrentUrl(), 8589934598L, null);
        }
        if (pluginEngine != null) {
            pluginEngine.s(this.f314200f.getCurrentUrl(), 8589934599L, null);
        }
        this.f314199e.s(this.f314200f);
    }

    public void g(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (this.f314199e.z(this.f314200f, i3, i16, intent)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("requestCode", Integer.valueOf(i3));
        hashMap.put(QzoneIPCModule.RESULT_CODE, Integer.valueOf(i16));
        hashMap.put("data", intent);
        TouchWebView touchWebView = this.f314201h;
        if (touchWebView != null && touchWebView.getPluginEngine().s(this.f314201h.getUrl(), 8589934600L, hashMap)) {
            return;
        }
        int d16 = com.tencent.mobileqq.webview.swift.utils.i.d(i3);
        int c16 = com.tencent.mobileqq.webview.swift.utils.i.c(i3);
        QLog.w("WebViewSurface", 1, String.format("doOnActivityResult [%d,%d,%d]", Integer.valueOf(i3), Integer.valueOf(d16), Integer.valueOf(c16)));
        if (c16 > 0) {
            TouchWebView touchWebView2 = this.f314201h;
            if (touchWebView2 != null) {
                WebViewPluginEngine pluginEngine = touchWebView2.getPluginEngine();
                if (pluginEngine != null) {
                    WebViewPlugin l3 = pluginEngine.l(c16, true);
                    if (l3 != null) {
                        l3.onActivityResult(intent, (byte) d16, i16);
                        return;
                    }
                    i17 = 2;
                } else {
                    i17 = 1;
                }
            }
            QLog.w("WebViewSurface", 1, "Caution! activity result not handled! step=" + i17);
            return;
        }
        if (((com.tencent.mobileqq.webview.swift.component.y) this.f314200f.getComponentProvider().a(128)).g(i3, i16, intent)) {
            if (QLog.isColorLevel()) {
                QLog.w("WebViewSurface", 2, "Activity result handled by FileChooserHelper.");
            }
        } else if (i16 == -1 && this.f314201h != null) {
            this.f314199e.B(this.f314200f, i3, intent);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.webview.swift.utils.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getCacheMode(ad adVar) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this, (Object) adVar)).intValue();
        }
        if (!adVar.a()) {
            i3 = -1;
            int intExtra = this.f314200f.getIntent().getIntExtra("reqType", -1);
            if (intExtra != 1) {
                if (intExtra == 4) {
                    i3 = 0;
                }
                if (!((com.tencent.mobileqq.webview.swift.injector.c) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).j()) {
                    return 2;
                }
                return i3;
            }
        }
        i3 = 2;
        if (!((com.tencent.mobileqq.webview.swift.injector.c) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).j()) {
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public DownloadListener getDownloadListener(CustomWebView customWebView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (DownloadListener) iPatchRedirector.redirect((short) 4, (Object) this, (Object) customWebView);
        }
        if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isGooglePlayVersion()) {
            return new DownloadListener() { // from class: com.tencent.mobileqq.webview.swift.ai
                @Override // com.tencent.smtt.sdk.DownloadListener
                public final void onDownloadStart(String str, String str2, String str3, String str4, long j3) {
                    ak.this.o(str, str2, str3, str4, j3);
                }
            };
        }
        return ((com.tencent.mobileqq.webview.swift.injector.f) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.f.class)).j(this.f314200f.getHostActivity(), this.f314200f.getAppRuntime(), customWebView, this.f314200f.getIntent());
    }

    @Override // com.tencent.mobileqq.webviewplugin.q
    public int getTitleBarHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Integer) iPatchRedirector.redirect((short) 57, (Object) this)).intValue();
        }
        return this.f314200f.getResource().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    @Override // com.tencent.mobileqq.webviewplugin.q
    public View getTitleBarView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return (View) iPatchRedirector.redirect((short) 60, (Object) this);
        }
        return this.E.M;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public String getUAMark() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public String getUserAgent(String str, String str2, Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, this, str, str2, bool);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public View getVideoLoadingProgressView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (View) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        if (this.H == null) {
            this.H = LayoutInflater.from(this.f314200f.getHostActivity()).inflate(R.layout.c2u, (ViewGroup) null);
        }
        return this.H;
    }

    public void h(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) configuration);
            return;
        }
        QLog.d("WebViewSurface", 1, "doOnConfigurationChanged");
        v(configuration.orientation);
        Bundle bundle = new Bundle();
        bundle.putParcelable("Configuration", configuration);
        bundle.putBoolean("is_initView", this.f314203m);
        this.f314200f.getComponentProvider().b(4, bundle);
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void handlePreloadCallback(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public Object handlerMiscCallback(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) bundle);
        }
        if ("handleImage".equals(str)) {
            return Boolean.valueOf(this.f314199e.j((b.C8976b) this.f314200f.getComponentProvider().a(8)));
        }
        return null;
    }

    public void i(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) bundle);
            return;
        }
        this.f314199e.d(this.f314200f, bundle);
        Bundle bundle2 = new Bundle();
        bundle2.putString("url", this.f314200f.getCurrentUrl());
        this.f314200f.getComponentProvider().b(6, bundle2);
    }

    @Override // com.tencent.mobileqq.webview.swift.utils.t
    public boolean interceptInitUIFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.utils.t
    public boolean interceptStartLoadUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this)).booleanValue();
        }
        this.f314199e.b(this.f314200f);
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.utils.t
    public boolean interceptTouchEvent(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean interceptUserAgentGenerate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean isFinishing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        Activity hostActivity = this.f314200f.getHostActivity();
        if (hostActivity != null && hostActivity.isFinishing()) {
            return true;
        }
        return false;
    }

    public boolean j(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            return ((Boolean) iPatchRedirector.redirect((short) 69, (Object) this, (Object) intent)).booleanValue();
        }
        if (this.f314199e.t(this.f314200f, intent)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webviewplugin.q
    public void jg(String str, String str2, String str3, boolean z16, int i3, int i16, View.OnClickListener onClickListener, com.tencent.mobileqq.webview.nativeapi.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, this, str, str2, str3, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), onClickListener, aVar);
            return;
        }
        this.E.G(str, str2, str3, z16, i3, i16, null, onClickListener, aVar);
        this.f314199e.e(this.f314200f);
        this.C.f0();
    }

    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Boolean) iPatchRedirector.redirect((short) 53, (Object) this)).booleanValue();
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("WebViewSurface", 2, "hide custom view called");
        }
        if (!this.I) {
            return false;
        }
        this.K.setKeepScreenOn(false);
        this.J.setVisibility(8);
        this.R.onCustomViewHidden();
        try {
            this.J.removeAllViews();
        } catch (Exception unused) {
        }
        Activity hostActivity = this.f314200f.getHostActivity();
        if (!this.D.N) {
            hostActivity.getWindow().setFlags(this.M, 1024);
            an.b(hostActivity, this.N);
            hostActivity.getWindow().getDecorView().setSystemUiVisibility(this.P);
        }
        this.f314201h.requestFocusFromTouch();
        hostActivity.setRequestedOrientation(this.L);
        this.K = null;
        this.R = null;
        this.H = null;
        this.I = false;
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.utils.t
    public void loadUrlFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
        }
    }

    public boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return ((Boolean) iPatchRedirector.redirect((short) 66, (Object) this)).booleanValue();
        }
        return this.S;
    }

    public void onClick(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, (Object) this, (Object) view);
            return;
        }
        if (this.f314201h == null) {
            return;
        }
        SwiftIphoneTitleBarUI swiftIphoneTitleBarUI = this.E;
        if (view != swiftIphoneTitleBarUI.f314054i && view != swiftIphoneTitleBarUI.G && view != this.C.L) {
            this.f314199e.v(this.f314200f, view);
            return;
        }
        this.f314200f.doOnBackEvent();
        if (view == this.E.G) {
            ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).e(null, "dc00898", "", "", "0X8009B1F", "0X8009B1F", 0, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.utils.t
    public void onDataInit(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) bundle);
            return;
        }
        this.T = false;
        this.S = false;
        "Xiaomi_MI 2".equals(Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel());
        this.f314199e.l(this.f314200f, bundle);
        this.F.h("web_view_long_click", this.f314200f.getIntent().getBooleanExtra(VasWebviewConstants.KEY_VAS_USE_PREWEBVIEW, false) ^ true);
        String stringExtra = this.f314200f.getIntent().getStringExtra("title");
        this.f314202i = stringExtra;
        this.C.f314504e0 = stringExtra;
        if ((this.D.f314620c & 67108864) == 0) {
            this.F.h("image_long_click", true);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onDetectedBlankScreen(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.utils.t
    public void onFinalState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) bundle);
        } else {
            this.f314199e.p(this.f314200f, bundle);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, (Object) geolocationPermissionsCallback);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WebViewSurface", 2, "onGeolocationPermissionsShowPrompt:" + str);
        }
        this.f314199e.a(this.f314200f, str, geolocationPermissionsCallback);
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onHideCustomView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this);
        } else {
            k();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.utils.t
    public void onInitBottomBar(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) bundle);
        } else {
            this.C.x(this.f314200f.getIntent(), this.f314200f.getCurrentUrl());
            this.C.v();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.utils.t
    public void onInitTitleBar(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) bundle);
            return;
        }
        this.C.A(this.f314200f.getIntent(), this.f314200f.getCurrentUrl());
        this.C.z();
        l();
        this.f314199e.f(this.f314200f, bundle);
        this.f314200f.getHostActivity().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.aj
            @Override // java.lang.Runnable
            public final void run() {
                ak.this.p();
            }
        });
    }

    @Override // com.tencent.mobileqq.webview.swift.utils.t
    public void onInitUIContent(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) bundle);
            return;
        }
        if (!this.f314203m) {
            this.f314203m = true;
            this.C.y(this.f314200f.getContentView(), this.f314200f.getIntent(), this.f314201h);
            TouchWebView touchWebView = this.f314201h;
            if (touchWebView.isPaused) {
                touchWebView.onResume();
                return;
            }
            return;
        }
        r rVar = this.D;
        if (rVar.f314618a && rVar.f314622e != 0) {
            this.C.D.j(this.f314200f.getContentView());
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 12, this, webView, str, str2, jsResult)).booleanValue();
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean onLongClick(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) view)).booleanValue();
        }
        return this.f314199e.A((b.C8976b) this.f314200f.getComponentProvider().a(8), view);
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onPageCommitVisible(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) webView, (Object) str);
        } else {
            this.f314199e.n(this.f314200f, webView, str);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onPageFinished(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) webView, (Object) str);
            return;
        }
        if (this.G.f314381y0) {
            this.f314200f.getWebShareInterface().getShare();
        }
        this.f314199e.q(this.f314200f, webView, str);
        try {
            Intent intent = this.f314200f.getHostActivity().getIntent();
            if (intent.hasExtra("key_scroll_y")) {
                int intExtra = intent.getIntExtra("key_scroll_y", 0);
                if (this.f314201h.getX5WebViewExtension() != null) {
                    this.f314201h.getX5WebViewExtension().scrollTo(this.f314201h.getWebScrollX(), intExtra);
                } else {
                    TouchWebView touchWebView = this.f314201h;
                    touchWebView.scrollTo(touchWebView.getScrollX(), intExtra);
                }
                intent.removeExtra("key_scroll_y");
            }
        } catch (RuntimeException e16) {
            QLog.e("WebViewSurface", 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, webView, str, bitmap);
        } else {
            this.f314199e.m(this.f314200f, webView, str, bitmap);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onPermissionRequest(PermissionRequest permissionRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) permissionRequest);
        } else {
            new com.tencent.mobileqq.webview.swift.utils.y(this.f314200f.getHostActivity(), permissionRequest).j();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onProgressChanged(WebView webView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) webView, i3);
            return;
        }
        bx bxVar = this.C.U;
        if (bxVar != null && bxVar.c() == 0) {
            this.C.U.a((byte) 1);
        }
        if (i3 == 100) {
            this.C.Z.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onReceivedError(WebView webView, int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, webView, Integer.valueOf(i3), str, str2);
        } else {
            this.C.Z.setVisibility(8);
            this.f314199e.x(this.f314200f, webView, i3, str, str2);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, this, webView, sslErrorHandler, sslError)).booleanValue();
        }
        this.f314199e.i(this.f314200f, webView, sslError);
        if (((com.tencent.mobileqq.webview.swift.injector.c) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).w()) {
            return false;
        }
        String url = sslError.getUrl();
        String currentUrl = this.f314200f.getCurrentUrl();
        if (url == null || url.equals(currentUrl)) {
            return false;
        }
        QLog.w("WebViewSurface", 1, "onReceivedSslError: cancel load because errUrl != curUrl:" + com.tencent.mobileqq.webview.util.s.d(currentUrl, new String[0]));
        sslErrorHandler.cancel();
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onReceivedTitle(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) webView, (Object) str);
        } else if (TextUtils.isEmpty(this.f314202i) && (this.D.f314621d & 8) <= 0 && !com.tencent.mobileqq.webview.util.r.a(str) && str != null) {
            this.E.s(webView, str, this.f314198d);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean onShowFileChooser(ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) valueCallback, (Object) fileChooserParams)).booleanValue();
        }
        return ((com.tencent.mobileqq.webview.swift.component.y) this.f314200f.getComponentProvider().a(128)).h(valueCallback, fileChooserParams);
    }

    @Override // com.tencent.mobileqq.webview.swift.utils.t
    public void onShowPreview(Bundle bundle) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) bundle);
            return;
        }
        if (this.C.R) {
            return;
        }
        com.tencent.mobileqq.webview.util.s.a("Web_qqbrowser_ShowPreview");
        long nanoTime = System.nanoTime();
        this.C.C(this.f314200f.getIntent());
        this.C.B(this.f314200f.getIntent());
        this.f314200f.getContentView().d(!this.C.f314512m.Q);
        this.f314199e.c(this.f314200f, bundle);
        com.tencent.mobileqq.webview.swift.component.v vVar = this.C;
        if (vVar.f314512m.f314618a) {
            this.f314200f.getHostActivity().getWindow().setFlags(1024, 1024);
            an.e(this.f314200f.getHostActivity());
            an.a(this.f314200f.getHostActivity());
        } else {
            vVar.V = this.f314200f.getContentView();
            this.E.j(this.f314200f.getIntent(), this.f314200f.getOnclickListener());
            this.E.M.setOnTouchListener(this.W);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.E.M.getLayoutParams();
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                i3 = ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
            } else {
                i3 = 0;
            }
            layoutParams.height = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.f159599b02) + i3;
            r rVar = this.D;
            rVar.P = true;
            if (!this.C.f314512m.f314619b && !rVar.f314641x) {
                this.S = true;
                this.T = true;
                Hf(2);
            } else {
                rVar.f314642y = true;
                this.E.M.setBackgroundDrawable(this.f314200f.getResource().getDrawable(R.drawable.trans));
                this.E.W(-1);
                this.E.S(-1);
                if (this.D.f314643z) {
                    Hf(1);
                } else {
                    this.S = true;
                }
                if (this.D.f314641x) {
                    this.E.M.setOnTouchListener(null);
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("WebViewSurface", 2, "onShowPreview trans=" + this.S + " immersive=" + this.T + " needStatusMask=" + this.D.f314643z);
            }
            try {
                if (ImmersiveUtils.isSupporImmersive() == 1) {
                    this.E.M.setPadding(0, ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()), 0, 0);
                    this.f314200f.getHostActivity().getWindow().addFlags(67108864);
                    this.f314200f.getWebTitleBarInterface().Ad(this.D.f314643z);
                    ImmersiveUtils.clearCoverForStatus(this.f314200f.getHostActivity().getWindow(), true);
                    f();
                }
            } catch (ClassCastException e16) {
                an.c(this.f314200f.getHostActivity(), e16);
            }
            if (!this.C.f314512m.f314619b && !this.D.f314641x) {
                m();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("WebViewSurface", 2, "init view 1, cost = " + ((System.nanoTime() - nanoTime) / 1000000));
        }
        com.tencent.mobileqq.webview.swift.component.v vVar2 = this.C;
        vVar2.R = true;
        vVar2.Z = this.f314200f.getContentView().b();
        this.f314200f.getContentView().c().setVisibility(8);
        this.C.H(this.f314200f.getCurrentUrl());
        this.C.d0();
        y();
        com.tencent.mobileqq.webview.util.s.b("Web_qqbrowser_ShowPreview");
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onUrlChange(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onWebViewClientImplPageStarted(WebView webView, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, webView, str, bitmap);
        } else {
            this.f314199e.o(this.f314200f, webView, str, bitmap);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.utils.t
    public void onWebViewInit(Bundle bundle, TouchWebView touchWebView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) bundle, (Object) touchWebView);
        } else {
            this.f314201h = touchWebView;
            this.f314199e.h(this.f314200f, bundle, touchWebView);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.utils.t
    public void onX5Init(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) bundle);
        } else {
            this.f314199e.w(this.f314200f, bundle);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, valueCallback, str, str2);
        } else {
            ((com.tencent.mobileqq.webview.swift.component.y) this.f314200f.getComponentProvider().a(128)).i(valueCallback, str, str2);
        }
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("url", this.f314200f.getCurrentUrl());
        this.f314200f.getComponentProvider().b(3, bundle);
        this.E.t();
        com.tencent.mobileqq.webview.swift.utils.c.b(this.f314200f.getIntent());
        this.f314199e.k(this.f314200f);
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        onHideCustomView();
        this.f314200f.getComponentProvider().b(1, null);
        this.f314199e.C(this.f314200f);
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, (Object) this);
            return;
        }
        View view = this.Q;
        if (view != null && !this.D.f314637t) {
            this.f314199e.u(view, this.f314200f);
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.q
    public void sc(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this, (Object) jSONObject);
            return;
        }
        com.tencent.mobileqq.webview.swift.component.v vVar = this.C;
        vVar.f314512m.K = jSONObject;
        vVar.o(jSONObject, true);
    }

    @Override // com.tencent.mobileqq.webviewplugin.q
    public void setRightButton(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, z16);
            return;
        }
        this.E.H(z16);
        this.f314199e.e(this.f314200f);
        this.C.f0();
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this, (Object) webView, (Object) str)).booleanValue();
        }
        if (str.startsWith("file://") || str.startsWith("data:") || str.startsWith("http://") || str.startsWith("https://")) {
            this.f314200f.getWebShareInterface().reset();
            if (str.startsWith("http://") || str.startsWith("https://")) {
                this.f314200f.setCurUrl(str);
                Bundle bundle = new Bundle();
                bundle.putString("url", str);
                this.f314200f.getComponentProvider().b(10, bundle);
            }
        }
        if (this.f314200f.getHostActivity().isFinishing()) {
            this.C.Z.setVisibility(8);
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    @SuppressLint({"WrongConstant"})
    public void showCustomView(View view, int i3, IX5WebChromeClient.CustomViewCallback customViewCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, this, view, Integer.valueOf(i3), customViewCallback);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("WebViewSurface", 2, "show custom view called");
        }
        if (this.R != null) {
            customViewCallback.onCustomViewHidden();
            return;
        }
        Activity hostActivity = this.f314200f.getHostActivity();
        this.L = hostActivity.getRequestedOrientation();
        this.M = hostActivity.getWindow().getAttributes().flags & 1024;
        if (this.J == null) {
            FrameLayout frameLayout = new FrameLayout(BaseApplication.getContext());
            this.J = frameLayout;
            frameLayout.setBackgroundColor(-16777216);
            ((ViewGroup) hostActivity.getWindow().getDecorView()).addView(this.J, new ViewGroup.LayoutParams(-1, -1));
        }
        if (!this.D.N) {
            hostActivity.getWindow().setFlags(1024, 1024);
            this.N = an.d(hostActivity);
            an.a(hostActivity);
            View decorView = hostActivity.getWindow().getDecorView();
            this.P = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(6);
        }
        hostActivity.setRequestedOrientation(i3);
        this.J.addView(view);
        this.K = view;
        this.R = customViewCallback;
        this.J.setVisibility(0);
        this.J.requestFocusFromTouch();
        this.I = true;
    }

    @Override // com.tencent.mobileqq.webview.swift.utils.t
    public boolean softKeyboardResizeCompactOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this)).booleanValue();
        }
        return true;
    }

    public void t(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, i3);
            return;
        }
        v(this.f314200f.getResource().getConfiguration().orientation);
        Bundle bundle = new Bundle();
        bundle.putInt("state_machine_step", i3);
        this.f314200f.getComponentProvider().b(2, bundle);
        this.f314199e.g(this.f314200f);
        if (this.C.f314512m.f314618a) {
            an.e(this.f314200f.getHostActivity());
            an.a(this.f314200f.getHostActivity());
        }
    }

    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        if ((this.D.f314620c & 33554432) != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("WebViewSurface", 2, "close on hide by wv param");
            }
            this.f314200f.getHostActivity().finish();
        }
        this.f314200f.getComponentProvider().b(9, null);
        SwiftBrowserStatistics.L();
    }

    @Override // com.tencent.mobileqq.webviewplugin.q
    public void u5(boolean z16) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this, z16);
            return;
        }
        ViewGroup viewGroup = this.E.M;
        if (viewGroup == null) {
            return;
        }
        int dimensionPixelSize = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.f158465gi);
        if (!z16) {
            this.f314200f.getWebTitleBarInterface().Kb(dimensionPixelSize, 0);
            viewGroup.setVisibility(8);
            View view = this.Q;
            if (view != null) {
                view.setVisibility(8);
                View findViewById = this.C.V.findViewById(R.id.b_3);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                    return;
                }
                return;
            }
            return;
        }
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            i3 = ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
        } else {
            i3 = 0;
        }
        if (this.D.f314642y) {
            i16 = dimensionPixelSize + i3;
        } else {
            i16 = dimensionPixelSize + (i3 * 2);
            i3 += BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.f159599b02);
        }
        this.f314200f.getWebTitleBarInterface().Kb(i16, i3);
        viewGroup.setVisibility(0);
        View view2 = this.Q;
        if (view2 != null) {
            view2.setVisibility(0);
            View findViewById2 = this.C.V.findViewById(R.id.b_3);
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.q
    public void u6(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, z16);
        } else {
            this.S = z16;
        }
    }

    public void x(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this, (Object) view);
        } else {
            this.Q = view;
        }
    }

    public void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this);
            return;
        }
        if (!this.f314200f.getWebViewKernelCallBack().softKeyboardResizeCompactOn()) {
            return;
        }
        if (this.C.f314512m.f314618a || (this.S && ImmersiveUtils.isSupporImmersive() == 1)) {
            com.tencent.mobileqq.webview.swift.utils.b.b(this.f314200f.getHostActivity());
        }
    }
}
