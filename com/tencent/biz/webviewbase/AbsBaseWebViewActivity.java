package com.tencent.biz.webviewbase;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.h;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.af;
import com.tencent.mobileqq.webview.swift.ao;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.mobileqq.webview.swift.component.f;
import com.tencent.mobileqq.webview.swift.component.v;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.swift.injector.j;
import com.tencent.mobileqq.webview.swift.injector.m;
import com.tencent.mobileqq.webview.swift.r;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import com.tencent.mobileqq.webview.swift.utils.i;
import com.tencent.mobileqq.webview.swift.utils.n;
import com.tencent.mobileqq.webview.swift.utils.o;
import com.tencent.mobileqq.webview.util.s;
import com.tencent.mobileqq.webview.util.w;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.widget.TraceUtils;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class AbsBaseWebViewActivity extends QIphoneTitleBarActivity implements View.OnTouchListener, af, View.OnClickListener, b.f, b.e {
    public static final String ACTION_SELECT_PICTURE = "actionSelectPicture";
    public static final String EXTRA_ACTION = "keyAction";
    static final String TAG = "WebLog_WebViewBase";
    public static final String WEBVIEW_ADJUST_SETTINGS = "Web_AdjustSettings";
    public static final String WEBVIEW_BROWSER_INIT_WEBVIEW = "Web_qqbrowser_init_only_webview";
    public static final String WEBVIEW_SET_USER_AGENT = "Web_SetUserAgent";
    protected AuthorizeConfig authConfig;
    public FrameLayout customContainer;
    public boolean isDestroyed;
    private boolean isRecordTitleLeftDrawable;
    private boolean isRecordTitleRightDrawable;
    boolean isVideoPlaying;
    public volatile AppInterface mApp;
    public h mChromeClient;
    public final com.tencent.mobileqq.webview.swift.component.b mComponentsProvider;
    protected com.tencent.biz.common.util.c mFileChooserHelper;
    protected volatile WebViewPluginEngine mPluginEngine;
    private ImageView mRightCornerIcon;
    protected final f mSetting;
    public final SwiftBrowserStatistics mStatistics;
    public SwiftIphoneTitleBarUI mSwiftTitleUI;
    private Drawable mTitleLeftDrawable;
    public final r mUIStyle;
    public final v mUIStyleHandler;
    private WebViewClient mWebViewClient;
    public TouchWebView mWebViewInstance;
    public String uin;
    public long mRulesFromUrl = 4;
    public long mFloatBarRulesFromUrl = 5;
    public long mWWVRulesFromUrl = 0;
    public String mRedirect302Url = "";
    protected final Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean isMainFrame = true;
    protected long mLastTouchTime = 0;
    protected String mRightButtonCallback = null;
    protected JsBridgeListener mRightButtonListener = null;
    protected boolean mNightMode = false;
    protected final Object sInitEngineLock = new Object();
    private boolean mX5CoreActive = false;

    @NonNull
    private com.tencent.mobileqq.webview.swift.injector.a injector = (com.tencent.mobileqq.webview.swift.injector.a) aa.d(com.tencent.mobileqq.webview.swift.injector.a.class);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements DownloadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TouchWebView f97261d;

        a(TouchWebView touchWebView) {
            this.f97261d = touchWebView;
        }

        @Override // com.tencent.smtt.sdk.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j3) {
            if (QLog.isColorLevel()) {
                QLog.d(AbsBaseWebViewActivity.TAG, 2, "start UniformDownloadActivity");
            }
            ((com.tencent.mobileqq.webview.swift.injector.f) aa.k(com.tencent.mobileqq.webview.swift.injector.f.class)).b(str, str2, str3, str4, j3, AbsBaseWebViewActivity.this, this.f97261d.getUrl());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b extends WebViewClientImpl {
        b() {
            super();
        }

        @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity.WebViewClientImpl, com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            return a(webView, webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c extends h {

        /* renamed from: f, reason: collision with root package name */
        private View f97264f;

        /* renamed from: g, reason: collision with root package name */
        private IX5WebChromeClient.CustomViewCallback f97265g;

        /* renamed from: h, reason: collision with root package name */
        private View f97266h;

        /* renamed from: i, reason: collision with root package name */
        private int f97267i;

        /* renamed from: j, reason: collision with root package name */
        private int f97268j;

        c() {
        }

        private void c(View view, int i3, IX5WebChromeClient.CustomViewCallback customViewCallback) {
            if (QLog.isColorLevel()) {
                QLog.d(AbsBaseWebViewActivity.TAG, 2, "show custom view called");
            }
            if (this.f97265g != null) {
                customViewCallback.onCustomViewHidden();
                return;
            }
            this.f97267i = AbsBaseWebViewActivity.this.getRequestedOrientation();
            this.f97268j = AbsBaseWebViewActivity.this.getWindow().getAttributes().flags & 1024;
            AbsBaseWebViewActivity absBaseWebViewActivity = AbsBaseWebViewActivity.this;
            if (absBaseWebViewActivity.customContainer == null) {
                absBaseWebViewActivity.customContainer = new FrameLayout(AbsBaseWebViewActivity.this);
                AbsBaseWebViewActivity.this.customContainer.setBackgroundColor(-16777216);
                ((ViewGroup) AbsBaseWebViewActivity.this.getWindow().getDecorView()).addView(AbsBaseWebViewActivity.this.customContainer, new ViewGroup.LayoutParams(-1, -1));
            }
            AbsBaseWebViewActivity absBaseWebViewActivity2 = AbsBaseWebViewActivity.this;
            if (!absBaseWebViewActivity2.mUIStyle.N) {
                absBaseWebViewActivity2.getWindow().setFlags(1024, 1024);
            }
            AbsBaseWebViewActivity.this.setRequestedOrientation(i3);
            AbsBaseWebViewActivity absBaseWebViewActivity3 = AbsBaseWebViewActivity.this;
            absBaseWebViewActivity3.isVideoPlaying = true;
            absBaseWebViewActivity3.customContainer.addView(view);
            this.f97264f = view;
            this.f97265g = customViewCallback;
            AbsBaseWebViewActivity.this.customContainer.setVisibility(0);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        @SuppressLint({"InflateParams"})
        public View getVideoLoadingProgressView() {
            if (this.f97266h == null) {
                this.f97266h = LayoutInflater.from(AbsBaseWebViewActivity.this).inflate(R.layout.c2u, (ViewGroup) null);
            }
            return this.f97266h;
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
            TouchWebView touchWebView;
            if (QLog.isColorLevel()) {
                QLog.d(AbsBaseWebViewActivity.TAG, 2, "onGeolocationPermissionsShowPrompt:" + str);
            }
            if (str != null && str.indexOf(58) == -1 && (touchWebView = AbsBaseWebViewActivity.this.mWebViewInstance) != null && touchWebView.getX5WebViewExtension() != null) {
                str = "https://" + str + "/";
            }
            geolocationPermissionsCallback.invoke(str, AbsBaseWebViewActivity.this.authConfig.F(str, "publicAccount.getLocation"), false);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onHideCustomView() {
            if (QLog.isColorLevel()) {
                QLog.d(AbsBaseWebViewActivity.TAG, 2, "hide custom view called");
            }
            if (this.f97265g == null) {
                return;
            }
            this.f97264f.setKeepScreenOn(false);
            AbsBaseWebViewActivity.this.customContainer.setVisibility(8);
            this.f97265g.onCustomViewHidden();
            try {
                AbsBaseWebViewActivity.this.customContainer.removeAllViews();
            } catch (Exception unused) {
            }
            AbsBaseWebViewActivity absBaseWebViewActivity = AbsBaseWebViewActivity.this;
            if (!absBaseWebViewActivity.mUIStyle.N) {
                absBaseWebViewActivity.getWindow().setFlags(this.f97268j, 1024);
            }
            AbsBaseWebViewActivity.this.setRequestedOrientation(this.f97267i);
            this.f97264f = null;
            this.f97265g = null;
            this.f97266h = null;
            AbsBaseWebViewActivity.this.isVideoPlaying = false;
        }

        @Override // com.tencent.biz.pubaccount.h, com.tencent.smtt.sdk.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion() && (webView instanceof SwiftReuseTouchWebView)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(webView.getContext());
                builder.setMessage(str2);
                builder.show();
            }
            return super.onJsAlert(webView, str, str2, jsResult);
        }

        @Override // com.tencent.biz.pubaccount.h, com.tencent.smtt.sdk.WebChromeClient
        public void onProgressChanged(WebView webView, int i3) {
            JsInjector.getInstance().onProgressChanged(webView, i3);
            if (QLog.isColorLevel()) {
                QLog.d(AbsBaseWebViewActivity.TAG, 2, "onProgressChanged:" + i3);
            }
            AbsBaseWebViewActivity.this.onProgressChanged(webView, i3);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            AbsBaseWebViewActivity.this.onReceivedTitle(webView, str);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onShowCustomView(View view, IX5WebChromeClient.CustomViewCallback customViewCallback) {
            c(view, 10, customViewCallback);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            AbsBaseWebViewActivity absBaseWebViewActivity = AbsBaseWebViewActivity.this;
            if (absBaseWebViewActivity.mFileChooserHelper == null) {
                absBaseWebViewActivity.mFileChooserHelper = new com.tencent.biz.common.util.c();
            }
            AbsBaseWebViewActivity absBaseWebViewActivity2 = AbsBaseWebViewActivity.this;
            absBaseWebViewActivity2.mFileChooserHelper.n(absBaseWebViewActivity2, 0, valueCallback, str, str2);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onShowCustomView(View view, int i3, IX5WebChromeClient.CustomViewCallback customViewCallback) {
            c(view, i3, customViewCallback);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    return false;
                }
                if (view == ((QIphoneTitleBarActivity) AbsBaseWebViewActivity.this).f194962vg) {
                    if (QLog.isColorLevel()) {
                        QLog.d(AbsBaseWebViewActivity.TAG, 2, "vg onTouch");
                    }
                    HashMap hashMap = new HashMap(2);
                    hashMap.put("X", Integer.valueOf((int) motionEvent.getX()));
                    hashMap.put("Y", Integer.valueOf((int) motionEvent.getY()));
                    AbsBaseWebViewActivity.this.dispatchPluginEvent(8589934606L, hashMap);
                }
            }
            return true;
        }
    }

    public AbsBaseWebViewActivity() {
        com.tencent.mobileqq.webview.swift.component.b createComponentsProvider = createComponentsProvider();
        this.mComponentsProvider = createComponentsProvider;
        v vVar = (v) createComponentsProvider.a(2);
        this.mUIStyleHandler = vVar;
        this.mUIStyle = vVar.f314512m;
        this.mSwiftTitleUI = null;
        this.mSetting = (f) createComponentsProvider.a(-1);
        this.mStatistics = (SwiftBrowserStatistics) createComponentsProvider.a(-2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addContextLog(String str, String str2) {
        if (("http".equals(str2) || "data".equals(str2)) && !str.contains("/cgi-bin/httpconn?htcmd=0x6ff0080")) {
            CustomWebView.addContextLog(s.d(str, new String[0]));
        }
    }

    private h getChromeClient() {
        return new c();
    }

    private WebViewClient getWebViewClient() {
        return new b();
    }

    private void initPluginEngine() {
        WebViewPluginEngine webViewPluginEngine;
        if (this.mPluginEngine != null) {
            return;
        }
        if (this.mPluginEngine == null && (webViewPluginEngine = WebViewPluginEngine.I) != null) {
            this.mPluginEngine = webViewPluginEngine;
            WebViewPluginEngine.I = null;
            this.mPluginEngine.I(this.mApp, this);
            return;
        }
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.biz.webviewbase.AbsBaseWebViewActivity.5
            @Override // java.lang.Runnable
            public void run() {
                long uptimeMillis = SystemClock.uptimeMillis();
                synchronized (AbsBaseWebViewActivity.this.sInitEngineLock) {
                    if (AbsBaseWebViewActivity.this.mApp == null) {
                        AbsBaseWebViewActivity.this.mApp = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
                    }
                    if (AbsBaseWebViewActivity.this.mPluginEngine == null) {
                        AbsBaseWebViewActivity.this.mPluginEngine = WebAccelerateHelper.getInstance().createWebViewPluginEngine(AbsBaseWebViewActivity.this.mApp, AbsBaseWebViewActivity.this, null, null);
                        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                        if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
                            QLog.i("AutoMonitor", 1, "Web_qqbrowser_init_plugin_engine, cost=" + uptimeMillis2);
                        }
                    }
                }
            }
        }, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHttpOrHttpsScheme(String str) {
        if (!"http".equals(str) && !"https".equals(str)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValidScheme(String str) {
        if (!"http".equals(str) && !"https".equals(str) && !"data".equals(str) && !"file".equals(str)) {
            return false;
        }
        return true;
    }

    private void processIdNotNull(String str, String str2, int i3, int i16, JsBridgeListener jsBridgeListener, View.OnClickListener onClickListener, boolean z16) {
        boolean z17;
        this.rightViewText.setVisibility(8);
        this.rightViewImg.setVisibility(0);
        r rVar = this.mUIStyle;
        if (i3 != 4) {
            z17 = true;
        } else {
            z17 = false;
        }
        rVar.f314630m = z17;
        switch (i3) {
            case 1:
                this.mUIStyleHandler.T(this.rightViewImg, false, R.drawable.qb_troop_notice_edit, R.drawable.qb_troop_notice_edit);
                this.rightViewImg.setContentDescription(getResources().getString(R.string.bbm));
                break;
            case 2:
                this.mUIStyleHandler.T(this.rightViewImg, false, R.drawable.qb_troop_notice_del, R.drawable.qb_troop_notice_del);
                this.rightViewImg.setContentDescription(getResources().getString(R.string.bbl));
                break;
            case 3:
                this.mUIStyleHandler.T(this.rightViewImg, false, R.drawable.header_btn_more_nor, R.drawable.header_btn_more);
                this.rightViewImg.setContentDescription(getResources().getString(R.string.bbn));
                break;
            case 4:
                this.mUIStyleHandler.T(this.rightViewImg, false, R.drawable.common_forward_normal, R.drawable.f160527j8);
                this.rightViewImg.setContentDescription(getResources().getString(R.string.bbp));
                break;
            case 5:
                this.rightViewImg.setImageResource(R.drawable.e6e);
                this.rightViewImg.setContentDescription(getResources().getString(R.string.bbr));
                ((AnimationDrawable) this.rightViewImg.getDrawable()).start();
                break;
            case 6:
            default:
                this.rightViewImg.setVisibility(8);
                break;
            case 7:
                this.mUIStyleHandler.T(this.rightViewImg, false, R.drawable.qb_group_troop_bar_pulish_add_bt_common, R.drawable.f161431xc);
                this.rightViewImg.setContentDescription(getResources().getString(R.string.f170028dd));
                break;
            case 8:
            case 11:
                this.mUIStyleHandler.T(this.rightViewImg, false, R.drawable.skin_header_icon_single, R.drawable.b4n);
                this.rightViewImg.setContentDescription(getResources().getString(R.string.f170028dd));
                break;
            case 9:
                this.mUIStyleHandler.T(this.rightViewImg, false, R.drawable.browser_icon_search, R.drawable.browser_icon_search);
                this.rightViewImg.setContentDescription(getResources().getString(R.string.bbo));
                break;
            case 10:
                this.mUIStyleHandler.T(this.rightViewImg, false, R.drawable.skin_qvip_individuation_search_white, R.drawable.skin_qvip_individuation_search_white);
                this.rightViewImg.setContentDescription(getResources().getString(R.string.bbo));
                break;
        }
        if (i16 != 0) {
            if (this.mRightCornerIcon == null) {
                this.mRightCornerIcon = new ImageView(this);
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.f166811ie3);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(7, R.id.ivTitleBtnRightImage);
                layoutParams.addRule(6, R.id.ivTitleBtnRightImage);
                layoutParams.setMargins(0, 0, 0, 0);
                this.mRightCornerIcon.setLayoutParams(layoutParams);
                relativeLayout.addView(this.mRightCornerIcon);
            }
            this.mRightCornerIcon.setVisibility(0);
            if (i16 != 6) {
                this.mRightCornerIcon.setVisibility(8);
            } else {
                this.mRightCornerIcon.setImageResource(R.drawable.e2o);
            }
        } else {
            ImageView imageView = this.mRightCornerIcon;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            this.rightViewImg.setContentDescription(str2);
        }
        if (onClickListener != null) {
            this.rightViewImg.setOnClickListener(onClickListener);
        } else if (str != null && !z16) {
            this.rightViewImg.setOnClickListener(this);
            this.rightViewText.setOnClickListener(this);
            this.mRightButtonCallback = str.trim();
        } else {
            this.mRightButtonCallback = null;
            this.mRightButtonListener = jsBridgeListener;
        }
        this.isRecordTitleLeftDrawable = false;
        this.isRecordTitleRightDrawable = false;
    }

    public static int switchRequestCodeImpl(WebViewPlugin webViewPlugin, byte b16) {
        CustomWebView e16 = webViewPlugin.mRuntime.e();
        if (e16 == null || e16.getPluginEngine() == null) {
            return -1;
        }
        int a16 = ao.a(webViewPlugin);
        if (a16 == -1) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "switchRequestCode failed: webview index=0, pluginIndex=" + a16);
            }
            return -1;
        }
        return ((a16 << 8) & 65280) | 0 | (b16 & 255);
    }

    public com.tencent.mobileqq.webview.swift.component.b createComponentsProvider() {
        return new com.tencent.mobileqq.webview.swift.component.b(this, 639, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x012e, code lost:
    
        if (r9.hasSystemFeature("android.hardware.faketouch.multitouch.distinct") != false) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x025f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final TouchWebView createWebViewInstance(ViewGroup viewGroup) {
        TouchWebView touchWebView;
        boolean z16;
        boolean z17;
        String str;
        int lastIndexOf;
        s.a(WEBVIEW_BROWSER_INIT_WEBVIEW);
        Intent intent = getIntent();
        long currentTimeMillis = System.currentTimeMillis();
        if (0 != (this.mWWVRulesFromUrl & 64)) {
            touchWebView = SwiftReuseTouchWebView.q(this);
        } else {
            touchWebView = new TouchWebView(this);
        }
        if (touchWebView instanceof SwiftReuseTouchWebView) {
            this.mStatistics.E0 = ((SwiftReuseTouchWebView) touchWebView).s(1);
        }
        if (QLog.isColorLevel()) {
            QLog.d("webviewinit", 2, "TouchWebView cost = " + (System.currentTimeMillis() - currentTimeMillis));
        }
        touchWebView.setIntent(intent);
        s.b(WEBVIEW_BROWSER_INIT_WEBVIEW);
        if (this.mApp == null && QLog.isColorLevel()) {
            QLog.w(TAG, 2, "Caution! AppRuntime is null!");
        }
        this.mPluginEngine.Q(touchWebView);
        touchWebView.setPluginEngine(this.mPluginEngine);
        long currentTimeMillis2 = System.currentTimeMillis();
        if (this.mChromeClient == null) {
            this.mChromeClient = getChromeClient();
        }
        touchWebView.setWebChromeClient(this.mChromeClient);
        if (this.mWebViewClient == null) {
            this.mWebViewClient = getWebViewClient();
        }
        touchWebView.setWebViewClient(this.mWebViewClient);
        if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            QLog.i(TAG, 1, "Web_qqbrowser_getWebView_initWebViewClient, cost=" + (System.currentTimeMillis() - currentTimeMillis2));
            currentTimeMillis2 = System.currentTimeMillis();
        }
        touchWebView.setScrollBarStyle(0);
        if (((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        s.a(WEBVIEW_ADJUST_SETTINGS);
        WebSettings settings = touchWebView.getSettings();
        s.a(WEBVIEW_SET_USER_AGENT);
        String userAgentString = settings.getUserAgentString();
        String uAMark = getUAMark();
        if (touchWebView.getX5WebViewExtension() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        settings.setUserAgentString(i.n(userAgentString, uAMark, z16));
        s.b(WEBVIEW_SET_USER_AGENT);
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        PackageManager packageManager = getPackageManager();
        try {
            if (!packageManager.hasSystemFeature("android.hardware.touchscreen.multitouch")) {
            }
            z17 = true;
        } catch (RuntimeException unused) {
        }
        settings.setDisplayZoomControls(!z17);
        settings.setPluginsEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setAllowContentAccess(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheEnabled(true);
        String qQProcessName = MobileQQ.getMobileQQ().getQQProcessName();
        if (qQProcessName == null && (lastIndexOf = qQProcessName.lastIndexOf(58)) > -1) {
            str = "_" + qQProcessName.substring(lastIndexOf + 1);
        } else {
            str = "";
        }
        settings.setDatabasePath(getApplicationContext().getDir("database" + str, 0).getPath());
        settings.setAppCachePath(getApplicationContext().getDir("appcache" + str, 0).getPath());
        settings.setMediaPlaybackRequiresUserGesture(false);
        if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            QLog.i(TAG, 1, "Web_qqbrowser_getWebView_setWebSettings, cost=" + (System.currentTimeMillis() - currentTimeMillis2));
            currentTimeMillis2 = System.currentTimeMillis();
        }
        touchWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        try {
            touchWebView.requestFocus();
        } catch (Exception unused2) {
        }
        touchWebView.setFocusableInTouchMode(true);
        touchWebView.setDownloadListener(new a(touchWebView));
        CookieSyncManager.createInstance(getApplicationContext());
        if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            QLog.i(TAG, 1, "Web_qqbrowser_getWebView_CookieSyncManagerCreateInstance, cost=" + (System.currentTimeMillis() - currentTimeMillis2));
        }
        if (touchWebView.getX5WebViewExtension() == null) {
            this.mX5CoreActive = true;
            touchWebView.getX5WebViewExtension().setWebViewClientExtension(new e(touchWebView));
            com.tencent.mobileqq.webview.swift.utils.c.a(getIntent(), TbsDownloadConfig.TbsConfigKey.KEY_USE_X5, "1");
            if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
                QLog.i("Web_qqbrowser_core", 1, "Current WebView core is X5");
            }
        } else {
            if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
                QLog.i("Web_qqbrowser_core", 1, "Current WebView core is System");
            }
            com.tencent.mobileqq.webview.swift.utils.c.a(getIntent(), TbsDownloadConfig.TbsConfigKey.KEY_USE_X5, "2");
        }
        touchWebView.getView().setOnTouchListener(this);
        if (this.mNightMode) {
            touchWebView.setMask(true);
        }
        s.b(WEBVIEW_ADJUST_SETTINGS);
        if (viewGroup != null) {
            viewGroup.addView(touchWebView);
        }
        return touchWebView;
        z17 = false;
        settings.setDisplayZoomControls(!z17);
        settings.setPluginsEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setAllowContentAccess(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheEnabled(true);
        String qQProcessName2 = MobileQQ.getMobileQQ().getQQProcessName();
        if (qQProcessName2 == null) {
        }
        str = "";
        settings.setDatabasePath(getApplicationContext().getDir("database" + str, 0).getPath());
        settings.setAppCachePath(getApplicationContext().getDir("appcache" + str, 0).getPath());
        settings.setMediaPlaybackRequiresUserGesture(false);
        if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
        }
        touchWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        touchWebView.requestFocus();
        touchWebView.setFocusableInTouchMode(true);
        touchWebView.setDownloadListener(new a(touchWebView));
        CookieSyncManager.createInstance(getApplicationContext());
        if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
        }
        if (touchWebView.getX5WebViewExtension() == null) {
        }
        touchWebView.getView().setOnTouchListener(this);
        if (this.mNightMode) {
        }
        s.b(WEBVIEW_ADJUST_SETTINGS);
        if (viewGroup != null) {
        }
        return touchWebView;
    }

    protected boolean dispatchPluginEvent(long j3, Map<String, Object> map) {
        TouchWebView touchWebView = this.mWebViewInstance;
        if (touchWebView != null) {
            touchWebView.onResume();
            WebViewPluginEngine pluginEngine = this.mWebViewInstance.getPluginEngine();
            if (pluginEngine != null) {
                return pluginEngine.s(this.mWebViewInstance.getUrl(), j3, map);
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        WebViewPluginEngine pluginEngine;
        WebViewPlugin l3;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onActivityResult, requestCode=" + i3 + ", resultCode=" + i16);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("requestCode", Integer.valueOf(i3));
        hashMap.put(QzoneIPCModule.RESULT_CODE, Integer.valueOf(i16));
        hashMap.put("data", intent);
        if (dispatchPluginEvent(8589934600L, hashMap)) {
            return;
        }
        int i17 = i3 & 255;
        int i18 = (i3 >> 8) & 255;
        if (i18 > 0) {
            TouchWebView touchWebView = this.mWebViewInstance;
            if (touchWebView != null && (pluginEngine = touchWebView.getPluginEngine()) != null && (l3 = pluginEngine.l(i18, true)) != null) {
                l3.onActivityResult(intent, (byte) i17, i16);
                return;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.w(TAG, 2, "Caution! activity result not handled!");
                    return;
                }
                return;
            }
        }
        com.tencent.biz.common.util.c cVar = this.mFileChooserHelper;
        if (cVar != null && cVar.g(i3, i16, intent)) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "Activity result handled by FileChooserHelper.");
            }
        } else if (i16 == 4660) {
            setResult(4660);
            finish();
        } else {
            TouchWebView touchWebView2 = this.mWebViewInstance;
            if (touchWebView2 != null) {
                this.injector.d(i3, i16, intent, touchWebView2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doOnCreate");
        }
        super.doOnCreate(bundle);
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime instanceof AppInterface) {
            this.mApp = (AppInterface) appRuntime;
        }
        if (!VipWebViewReportLog.g()) {
            VipWebViewReportLog.f(this, this.mApp);
        }
        QQBrowserActivity.sQQBrowserActivityCounter++;
        this.mNightMode = ((com.tencent.mobileqq.webview.swift.injector.r) aa.k(com.tencent.mobileqq.webview.swift.injector.r.class)).isNightMode();
        setTheme(R.style.f173427d1);
        this.authConfig = AuthorizeConfig.y();
        WebAccelerateHelper.isWebViewEntered = true;
        QLog.d(TAG, 1, "doOnCreate, WebAccelerateHelper.isWebViewCache = true");
        SwiftBrowserStatistics swiftBrowserStatistics = this.mStatistics;
        this.isDestroyed = false;
        swiftBrowserStatistics.f314382z0 = false;
        this.uin = this.mApp.getAccount();
        this.injector.onCreate(this);
        initPluginEngineOnActivityCreated();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        QQBrowserActivity.sQQBrowserActivityCounter--;
        SwiftBrowserStatistics swiftBrowserStatistics = this.mStatistics;
        this.isDestroyed = true;
        swiftBrowserStatistics.f314382z0 = true;
        h hVar = this.mChromeClient;
        if (hVar != null) {
            hVar.a();
        }
        TouchWebView touchWebView = this.mWebViewInstance;
        if (touchWebView != null) {
            WebViewPluginEngine pluginEngine = touchWebView.getPluginEngine();
            if (pluginEngine != null) {
                pluginEngine.H();
            }
            if (this.mWebViewInstance.getParent() != null) {
                try {
                    ((ViewGroup) this.mWebViewInstance.getParent()).removeView(this.mWebViewInstance);
                } catch (Exception unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "remove webview error");
                    }
                }
            }
            try {
                this.mWebViewInstance.stopLoading();
            } catch (Exception unused2) {
            }
            this.mWebViewInstance.loadUrlOriginal("about:blank");
            this.mWebViewInstance.clearView();
            this.mWebViewInstance.destroy();
            this.mWebViewInstance = null;
        }
        this.mApp = null;
    }

    @Override // mqq.app.AppActivity
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 != 24) {
            if (i3 != 25) {
                if (i3 == 82) {
                    dispatchPluginEvent(8589934607L, null);
                }
            } else {
                dispatchPluginEvent(8589934608L, null);
            }
        } else {
            dispatchPluginEvent(8589934609L, null);
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        WebViewPluginEngine pluginEngine;
        WebViewPlugin l3;
        if ("actionSelectPicture".equals(intent.getStringExtra("keyAction"))) {
            int i3 = -1;
            int intExtra = intent.getIntExtra("requestCode", -1);
            int i16 = intExtra & 255;
            int i17 = (intExtra >> 8) & 255;
            if (i17 > 0) {
                TouchWebView touchWebView = this.mWebViewInstance;
                if (touchWebView != null && (pluginEngine = touchWebView.getPluginEngine()) != null && (l3 = pluginEngine.l(i17, true)) != null) {
                    if (!intent.hasExtra("PhotoConst.PHOTO_PATHS")) {
                        i3 = 0;
                    }
                    l3.onActivityResult(intent, (byte) i16, i3);
                    return;
                } else if (QLog.isColorLevel()) {
                    QLog.w(TAG, 2, "Caution! activity result not handled!");
                }
            }
        }
        this.uin = this.mApp.getAccount();
        HashMap hashMap = new HashMap();
        hashMap.put("intent", intent);
        dispatchPluginEvent(128L, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        }
        TouchWebView touchWebView = this.mWebViewInstance;
        if (touchWebView != null) {
            touchWebView.onPause();
        }
        h hVar = this.mChromeClient;
        if (hVar != null && this.isVideoPlaying) {
            hVar.onHideCustomView();
        }
        dispatchPluginEvent(8589934597L, null);
        this.injector.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onResume");
        }
        TouchWebView touchWebView = this.mWebViewInstance;
        if (touchWebView != null) {
            touchWebView.onResume();
        }
        dispatchPluginEvent(2L, null);
        this.injector.e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        super.doOnStop();
        if ((this.mRulesFromUrl & 33554432) != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "close on hide by wv param");
            }
            finish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        super.finish();
        if (getIntent().getBooleanExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_UP_DOWN, false)) {
            overridePendingTransition(0, R.anim.f154423k);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.f
    public com.tencent.mobileqq.webview.swift.component.b getComponentProvider() {
        return this.mComponentsProvider;
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.e
    public WebView getHostWebView() {
        throw new UnsupportedOperationException("must override this method getHostWebView()!");
    }

    @Override // mqq.app.AppActivity
    public String getModuleId() {
        return "modular_web";
    }

    protected String getUAMark() {
        return null;
    }

    public final TouchWebView getWebView(ViewGroup viewGroup) {
        TouchWebView touchWebView = this.mWebViewInstance;
        if (touchWebView != null) {
            return touchWebView;
        }
        TouchWebView createWebViewInstance = createWebViewInstance(viewGroup);
        this.mWebViewInstance = createWebViewInstance;
        return createWebViewInstance;
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.e
    public WebViewProvider getWebViewProvider() {
        return null;
    }

    public void gotoSelectPicture(WebViewPlugin webViewPlugin, ActivityURIRequest activityURIRequest, byte b16) {
        int switchRequestCode = switchRequestCode(webViewPlugin, b16);
        activityURIRequest.extra().putString("keyAction", "actionSelectPicture");
        activityURIRequest.extra().putInt("requestCode", switchRequestCode);
        QRoute.startUri(activityURIRequest);
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity
    public void init(Intent intent) {
        super.init(intent);
        ViewGroup viewGroup = this.f194962vg;
        if (viewGroup != null) {
            viewGroup.setOnTouchListener(new d());
            removeWebViewLayerType();
        }
        SwiftIphoneTitleBarUI swiftIphoneTitleBarUI = this.mSwiftTitleUI;
        TextView textView = this.leftView;
        swiftIphoneTitleBarUI.f314054i = textView;
        swiftIphoneTitleBarUI.f314059m = this.centerView;
        swiftIphoneTitleBarUI.C = this.rightViewText;
        swiftIphoneTitleBarUI.E = this.rightViewImg;
        swiftIphoneTitleBarUI.M = this.f194962vg;
        textView.setBackgroundDrawable(null);
        o.d(this.leftView, 2, n.token_icon_navLeftBack, this.mUIStyleHandler.F());
    }

    public final void initPluginEngineOnActivityCreated() {
        if (this.mPluginEngine == null && WebViewPluginEngine.I != null) {
            if (QLog.isColorLevel()) {
                QLog.d("AbsBaseWebViewActivity", 2, "-->web engine and plugin initialized at process preload!");
            }
            this.mPluginEngine = WebViewPluginEngine.I;
            WebViewPluginEngine.I = null;
            this.mPluginEngine.I(this.mApp, this);
            this.mPluginEngine.L();
            return;
        }
        if (this.mPluginEngine == null) {
            synchronized (this.sInitEngineLock) {
                if (this.mPluginEngine == null) {
                    this.mPluginEngine = WebAccelerateHelper.getInstance().createWebViewPluginEngine(this.mApp, this, null, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        TouchWebView touchWebView;
        h hVar = this.mChromeClient;
        if (hVar != null && this.isVideoPlaying) {
            hVar.onHideCustomView();
            return true;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("target", 3);
        if (dispatchPluginEvent(8589934601L, hashMap)) {
            return true;
        }
        if ((this.mRulesFromUrl & 4) == 0 && (touchWebView = this.mWebViewInstance) != null && touchWebView.canGoBack()) {
            this.mWebViewInstance.stopLoading();
            this.mWebViewInstance.goBack();
            WebViewPluginEngine pluginEngine = this.mWebViewInstance.getPluginEngine();
            if (pluginEngine != null) {
                pluginEngine.s(this.mWebViewInstance.getUrl(), 8589934610L, hashMap);
            }
            return true;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        h hVar2 = this.mChromeClient;
        if (hVar2 != null && this.isVideoPlaying) {
            hVar2.onHideCustomView();
            return true;
        }
        finish();
        return true;
    }

    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.rightViewImg || view == this.rightHighLView || view == this.rightViewText) {
            rightButtonCallBack();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.tencent.mobileqq.webview.e.a(this, bundle);
        SwiftWebAccelerator.h().l();
        String v3 = i.v(getIntent());
        WebAccelerateHelper.getInstance().preGetKey(v3, getIntent(), this.mApp);
        WebAccelerateHelper.getInstance().preCheckOffline(v3);
        WebAccelerateHelper.getInstance().preFetchResource(v3);
        this.mUIStyleHandler.m();
        this.mSwiftTitleUI = this.mUIStyleHandler.C;
        final boolean z16 = WebAccelerateHelper.isWebViewEntered;
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.biz.webviewbase.AbsBaseWebViewActivity.6
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d(AbsBaseWebViewActivity.TAG, 2, "start request: " + z16);
                }
                ((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).setPreloadWebProcess(true);
                i.u();
            }
        });
        super.onCreate(bundle);
        QLog.i(TAG, 1, "onCreate cache:" + z16);
        this.mApp = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
        if (this.mApp != null) {
            if (!z16 && !VipWebViewReportLog.g()) {
                VipWebViewReportLog.f(this, this.mApp);
            }
            initPluginEngine();
        }
        if (!w.f314885b.contains(Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel())) {
            getWindow().addFlags(16777216);
        }
        getWindow().setFormat(-3);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        if (this.mApp != null) {
            this.mNightMode = ((com.tencent.mobileqq.webview.swift.injector.r) aa.k(com.tencent.mobileqq.webview.swift.injector.r.class)).b();
            dispatchPluginEvent(8589934604L, null);
        }
        if (((j) aa.k(j.class)).a(this) && !this.mUIStyle.f314637t) {
            ((j) aa.k(j.class)).c(this, getResources().getColor(R.color.skin_color_title_immersive_bar));
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            this.mLastTouchTime = System.currentTimeMillis();
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.af
    public final int pluginStartActivityForResult(WebViewPlugin webViewPlugin, Intent intent, byte b16) {
        int switchRequestCode = switchRequestCode(webViewPlugin, b16);
        if (switchRequestCode == -1) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "pluginStartActivityForResult not handled");
            }
        } else {
            startActivityForResult(intent, switchRequestCode);
        }
        return switchRequestCode;
    }

    protected boolean rightButtonCallBack() {
        TouchWebView touchWebView = this.mWebViewInstance;
        if (touchWebView != null) {
            JsBridgeListener jsBridgeListener = this.mRightButtonListener;
            if (jsBridgeListener != null && jsBridgeListener.f314008c) {
                touchWebView.callJs4OpenApi(jsBridgeListener, 0, "");
                return true;
            }
            if (!TextUtils.isEmpty(this.mRightButtonCallback)) {
                this.mWebViewInstance.callJs(this.mRightButtonCallback, "");
                return true;
            }
        }
        return false;
    }

    public void setRightButton(boolean z16) {
        if (z16) {
            this.mUIStyle.f314630m = true;
            TextView textView = this.rightViewText;
            if (textView != null) {
                textView.setVisibility(8);
            }
            ImageView imageView = this.rightViewImg;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = this.mRightCornerIcon;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView2 = this.rightViewText;
        if (textView2 != null && !TextUtils.isEmpty(textView2.getText())) {
            this.rightViewText.setVisibility(0);
        }
        ImageView imageView3 = this.rightViewImg;
        if (imageView3 != null) {
            imageView3.setVisibility(0);
        }
        ImageView imageView4 = this.mRightCornerIcon;
        if (imageView4 != null) {
            imageView4.setVisibility(0);
        }
    }

    protected boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return false;
    }

    @Override // mqq.app.AppActivity
    public boolean showPreview() {
        ((j) aa.k(j.class)).b(this);
        overridePendingTransition(0, 0);
        setContentViewNoTitle(R.layout.f167680ec);
        ((TextView) findViewById(R.id.f18)).setText(R.string.f170912b21);
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void startActivityFromFragment(@NonNull Fragment fragment, Intent intent, int i3, @Nullable Bundle bundle) {
        if (i3 == -1) {
            ActivityCompat.startActivityForResult(this, intent, -1, bundle);
        } else {
            ActivityCompat.startActivityForResult(this, intent, i3, bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void startIntentSenderFromFragment(@NonNull Fragment fragment, IntentSender intentSender, int i3, @Nullable Intent intent, int i16, int i17, int i18, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        ActivityCompat.startIntentSenderForResult(this, intentSender, i3, intent, i16, i17, i18, bundle);
    }

    @Override // com.tencent.mobileqq.webview.swift.af
    public final int switchRequestCode(WebViewPlugin webViewPlugin, byte b16) {
        return switchRequestCodeImpl(webViewPlugin, b16);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private class WebViewClientImpl extends WebViewClient {

        /* renamed from: b, reason: collision with root package name */
        private ArrayMap<String, Object> f97255b;

        WebViewClientImpl() {
        }

        private void b(WebView webView, String str) {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if (AbsBaseWebViewActivity.this.isResume()) {
                long currentTimeMillis = System.currentTimeMillis();
                AbsBaseWebViewActivity absBaseWebViewActivity = AbsBaseWebViewActivity.this;
                if (currentTimeMillis - absBaseWebViewActivity.mLastTouchTime < 1000 || absBaseWebViewActivity.authConfig.G(webView.getUrl(), scheme).booleanValue()) {
                    Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, parse);
                    intent.addFlags(268435456);
                    try {
                        AbsBaseWebViewActivity.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                    }
                }
            }
        }

        private String c(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (str.startsWith("https://jsbridge/")) {
                    return str.replace("https://jsbridge/", "jsbridge://");
                }
                if (str.startsWith("http://jsbridge/")) {
                    return str.replace("http://jsbridge/", "jsbridge://");
                }
                return str;
            }
            return str;
        }

        protected WebResourceResponse a(WebView webView, final String str, final boolean z16) {
            if (AbsBaseWebViewActivity.this.injector.c(str)) {
                return AbsBaseWebViewActivity.this.injector.b(str);
            }
            final WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
            if (pluginEngine == null) {
                return null;
            }
            if (!TextUtils.isEmpty(str)) {
                if (str.startsWith("https://jsbridge/")) {
                    str = str.replace("https://jsbridge/", "jsbridge://");
                } else if (str.startsWith("http://jsbridge/")) {
                    str = str.replace("http://jsbridge/", "jsbridge://");
                }
                if (QLog.isColorLevel()) {
                    QLog.d(AbsBaseWebViewActivity.TAG, 2, "doInterceptRequest: jsapi request with http(s), url = " + str);
                }
            } else if (QLog.isColorLevel()) {
                QLog.d(AbsBaseWebViewActivity.TAG, 2, "doInterceptRequest: default request, url = " + str);
            }
            if (!TextUtils.isEmpty(str) && str.startsWith("jsbridge:")) {
                AbsBaseWebViewActivity.this.mHandler.post(new Runnable() { // from class: com.tencent.biz.webviewbase.AbsBaseWebViewActivity.WebViewClientImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        pluginEngine.S(str, z16);
                    }
                });
                WebResourceResponse webResourceResponse = new WebResourceResponse("text/html", "utf-8", null);
                Map<String, String> responseHeaders = webResourceResponse.getResponseHeaders();
                if (responseHeaders == null) {
                    responseHeaders = new HashMap<>();
                }
                responseHeaders.put("cache-control", "must-revalidate\uff0cno-store");
                webResourceResponse.setResponseHeaders(responseHeaders);
                return webResourceResponse;
            }
            try {
                Object r16 = pluginEngine.r(str, 8L);
                if (!(r16 instanceof WebResourceResponse)) {
                    return null;
                }
                return (WebResourceResponse) r16;
            } catch (Exception e16) {
                QLog.e(AbsBaseWebViewActivity.TAG, 1, "shouldInterceptRequest error:!", e16.getMessage());
                if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
                    return null;
                }
                throw new RuntimeException(e16.getMessage());
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onDetectedBlankScreen(String str, int i3) {
            QLog.i(AbsBaseWebViewActivity.TAG, 1, "onDetectedBlankScreen, status: " + i3 + ", url:" + str);
            AbsBaseWebViewActivity.this.mStatistics.E(str, i3);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            AbsBaseWebViewActivity absBaseWebViewActivity = AbsBaseWebViewActivity.this;
            if (!absBaseWebViewActivity.isDestroyed && !absBaseWebViewActivity.isFinishing()) {
                QLog.d(AbsBaseWebViewActivity.TAG, 1, "onPageFinished:" + str);
                super.onPageFinished(webView, str);
                AbsBaseWebViewActivity.this.onPageFinished(webView, str);
                WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
                if (pluginEngine != null) {
                    pluginEngine.s(str, 8589934594L, null);
                }
                AbsBaseWebViewActivity absBaseWebViewActivity2 = AbsBaseWebViewActivity.this;
                if (!absBaseWebViewActivity2.isDestroyed && absBaseWebViewActivity2.mChromeClient != null) {
                    AbsBaseWebViewActivity.this.mChromeClient.onReceivedTitle(webView, webView.getTitle());
                }
                com.tencent.mobileqq.webview.swift.utils.c.l(AbsBaseWebViewActivity.this.getIntent());
                return;
            }
            QLog.e(AbsBaseWebViewActivity.TAG, 1, "call onPageFinished after destroy.");
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            AbsBaseWebViewActivity absBaseWebViewActivity = AbsBaseWebViewActivity.this;
            if (!absBaseWebViewActivity.isDestroyed && !absBaseWebViewActivity.isFinishing()) {
                QLog.d(AbsBaseWebViewActivity.TAG, 1, "onPageStarted:" + str);
                super.onPageStarted(webView, str, bitmap);
                AbsBaseWebViewActivity.this.onPageStarted(webView, str, bitmap);
                WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
                if (pluginEngine != null) {
                    pluginEngine.s(str, 8589934593L, null);
                    return;
                }
                return;
            }
            QLog.e(AbsBaseWebViewActivity.TAG, 1, "call onPageStarted after destroy.");
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onReceivedError(WebView webView, int i3, String str, String str2) {
            AbsBaseWebViewActivity absBaseWebViewActivity = AbsBaseWebViewActivity.this;
            if (!absBaseWebViewActivity.isDestroyed && !absBaseWebViewActivity.isFinishing()) {
                QLog.e(AbsBaseWebViewActivity.TAG, 1, "onReceivedError:" + i3 + ", desc=" + str + ", url=" + str2);
                AbsBaseWebViewActivity.this.onReceivedError(webView, i3, str, str2);
                WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
                if (pluginEngine != null) {
                    pluginEngine.q(str2, 8589934595L, i3);
                    return;
                }
                return;
            }
            QLog.e(AbsBaseWebViewActivity.TAG, 1, "call onReceivedError after destroy.");
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            WebViewPluginEngine pluginEngine;
            AbsBaseWebViewActivity absBaseWebViewActivity = AbsBaseWebViewActivity.this;
            if (!absBaseWebViewActivity.isDestroyed && !absBaseWebViewActivity.isFinishing()) {
                if (webView != null && webResourceRequest != null && webResourceResponse != null) {
                    QLog.e(AbsBaseWebViewActivity.TAG, 1, "onReceivedHttpError:" + webResourceRequest.getUrl() + "Occur error, resp code=" + webResourceResponse.getStatusCode());
                    String url = webView.getUrl();
                    if (url != null && AuthorizeConfig.y().l0(url) && (pluginEngine = ((CustomWebView) webView).getPluginEngine()) != null) {
                        if (this.f97255b == null) {
                            this.f97255b = new ArrayMap<>(4);
                        }
                        this.f97255b.put(WebViewPlugin.KEY_REQUEST, webResourceRequest);
                        this.f97255b.put(WebViewPlugin.KEY_RESPONSE, webResourceResponse);
                        this.f97255b.put("errorCode", Integer.valueOf(webResourceResponse.getStatusCode()));
                        pluginEngine.s(url, 64L, this.f97255b);
                        return;
                    }
                    return;
                }
                return;
            }
            QLog.e(AbsBaseWebViewActivity.TAG, 1, "call onReceivedHttpError after destroy.");
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String sslCertificate;
            AbsBaseWebViewActivity absBaseWebViewActivity = AbsBaseWebViewActivity.this;
            if (!absBaseWebViewActivity.isDestroyed && !absBaseWebViewActivity.isFinishing()) {
                SslCertificate certificate = sslError.getCertificate();
                String url = webView.getUrl();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onReceivedSslError:");
                sb5.append(sslError.getPrimaryError());
                sb5.append(", cert=");
                if (certificate == null) {
                    sslCertificate = "null";
                } else {
                    sslCertificate = certificate.toString();
                }
                sb5.append(sslCertificate);
                sb5.append(", pageUrl=");
                sb5.append(s.d(url, new String[0]));
                QLog.e(AbsBaseWebViewActivity.TAG, 1, sb5.toString());
                if (((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
                    sslErrorHandler.proceed();
                    return;
                } else {
                    sslErrorHandler.cancel();
                    return;
                }
            }
            QLog.e(AbsBaseWebViewActivity.TAG, 1, "call onReceivedSslError after destroy.");
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            AbsBaseWebViewActivity.this.isMainFrame = webResourceRequest.isForMainFrame();
            boolean shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, webResourceRequest);
            AbsBaseWebViewActivity.this.isMainFrame = true;
            return shouldOverrideUrlLoading;
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            WebView.HitTestResult hitTestResult;
            AbsBaseWebViewActivity absBaseWebViewActivity = AbsBaseWebViewActivity.this;
            if (!absBaseWebViewActivity.isDestroyed && !absBaseWebViewActivity.isFinishing()) {
                if (QLog.isColorLevel()) {
                    QLog.d(AbsBaseWebViewActivity.TAG, 2, "shouldOverrideUrlLoading:" + s.d(str, new String[0]));
                }
                String c16 = c(str);
                com.tencent.mobileqq.webview.swift.utils.c.h(AbsBaseWebViewActivity.this.getIntent(), c16);
                if (!TextUtils.isEmpty(c16) && !"about:blank;".equals(c16) && !"about:blank".equals(c16)) {
                    String k3 = i.k(c16);
                    AbsBaseWebViewActivity.this.addContextLog(c16, k3);
                    try {
                        if (AbsBaseWebViewActivity.this.isHttpOrHttpsScheme(k3) && (hitTestResult = webView.getHitTestResult()) != null && hitTestResult.getType() == 0) {
                            QLog.i(AbsBaseWebViewActivity.TAG, 1, "shouldOverrideUrlLoading detect 302, url: " + (QLog.isColorLevel() ? c16 : s.d(c16, new String[0])));
                            AbsBaseWebViewActivity.this.mRedirect302Url = c16;
                            SwiftBrowserCookieMonster.H();
                            AbsBaseWebViewActivity.this.mStatistics.Z(c16);
                        }
                        WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
                        if (((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
                            TraceUtils.traceBegin("CheckCanHandleJsRequest");
                        }
                        if (pluginEngine != null && pluginEngine.S(c16, AbsBaseWebViewActivity.this.isMainFrame)) {
                            if (((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
                                TraceUtils.traceEnd();
                            }
                            return true;
                        }
                        if (((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
                            TraceUtils.traceEnd();
                        }
                        if (AbsBaseWebViewActivity.this.shouldOverrideUrlLoading(webView, c16)) {
                            return true;
                        }
                        if (AbsBaseWebViewActivity.this.isValidScheme(k3)) {
                            return pluginEngine != null && pluginEngine.s(c16, 16L, null);
                        }
                        b(webView, c16);
                    } catch (RuntimeException e16) {
                        String stackTraceString = QLog.getStackTraceString(e16);
                        ((m) aa.k(m.class)).a(null, "P_CliOper", "BizTechReport", "", "webview", "exception", 0, 1, 0, stackTraceString.length() > 255 ? stackTraceString.substring(0, 255) : stackTraceString, "", "", "");
                        QLog.e(AbsBaseWebViewActivity.TAG, 1, stackTraceString);
                    }
                }
                return true;
            }
            QLog.e(AbsBaseWebViewActivity.TAG, 1, "call shouldOverrideUrlLoading after destroy.");
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public final class e extends ProxyWebViewClientExtension {

        /* renamed from: b, reason: collision with root package name */
        private final TouchWebView f97271b;

        /* renamed from: c, reason: collision with root package name */
        private ArrayMap<String, Object> f97272c;

        public e(TouchWebView touchWebView) {
            this.f97271b = touchWebView;
        }

        private void a(Object obj, Object obj2, Object obj3, Object obj4) {
            WebViewPluginEngine pluginEngine = this.f97271b.getPluginEngine();
            if (pluginEngine != null) {
                if (this.f97272c == null) {
                    this.f97272c = new ArrayMap<>(4);
                }
                this.f97272c.put("performanceData", obj);
                this.f97272c.put(WebViewPlugin.KEY_REQUEST, obj2);
                this.f97272c.put(WebViewPlugin.KEY_RESPONSE, obj3);
                this.f97272c.put("errorCode", obj4);
                pluginEngine.s(this.f97271b.getUrl(), 64L, this.f97272c);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("WebCoreDump", 2, "No JS plugin engine to web core dump");
            }
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public void computeScroll(View view) {
            this.f97271b.computeScroll(view);
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
            return this.f97271b.dispatchTouchEvent(motionEvent, view);
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
            return this.f97271b.onInterceptTouchEvent(motionEvent, view);
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public Object onMiscCallBack(String str, Bundle bundle, Object obj, Object obj2, Object obj3, Object obj4) {
            if (!str.equalsIgnoreCase("onReportResourceInfo") && !str.equalsIgnoreCase("onResourcesPerformance")) {
                if (!str.equalsIgnoreCase("onReportSetCookieInfo")) {
                    return null;
                }
                i.t(bundle);
                return null;
            }
            a(obj, obj2, obj3, obj4);
            return null;
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public void onOverScrolled(int i3, int i16, boolean z16, boolean z17, View view) {
            this.f97271b.onOverScrolled(i3, i16, z16, z17, view);
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public void onPrefetchResourceHit(boolean z16) {
            QLog.i(AbsBaseWebViewActivity.TAG, 1, "now prefetchResource is hit: " + z16);
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public void onResponseReceived(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse, int i3) {
            a(null, webResourceRequest, webResourceResponse, Integer.valueOf(i3));
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public void onScrollChanged(int i3, int i16, int i17, int i18, View view) {
            this.f97271b.onScrollChanged(i3, i16, i17, i18, view);
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public boolean onTouchEvent(MotionEvent motionEvent, View view) {
            return this.f97271b.onTouchEvent(motionEvent, view);
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public void onUrlChange(String str, String str2) {
            SwiftBrowserCookieMonster.H();
            AbsBaseWebViewActivity.this.onUrlChange(str, str2);
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16, View view) {
            return this.f97271b.overScrollBy(i3, i16, i17, i18, i19, i26, i27, i28, z16, view);
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public Object onMiscCallBack(String str, Bundle bundle) {
            SwiftBrowserTBSHandler swiftBrowserTBSHandler = (SwiftBrowserTBSHandler) AbsBaseWebViewActivity.this.mComponentsProvider.a(16);
            if (swiftBrowserTBSHandler != null) {
                return swiftBrowserTBSHandler.n(str, bundle);
            }
            if (!str.equalsIgnoreCase("onReportSetCookieInfo")) {
                return null;
            }
            i.t(bundle);
            return null;
        }
    }

    public void gotoSelectPicture(WebViewPlugin webViewPlugin, Intent intent, byte b16) {
        int switchRequestCode = switchRequestCode(webViewPlugin, b16);
        intent.putExtra("keyAction", "actionSelectPicture");
        intent.putExtra("requestCode", switchRequestCode);
        startActivity(intent);
    }

    public void setRightButton(String str, String str2, String str3, boolean z16, int i3, int i16, JsBridgeListener jsBridgeListener, View.OnClickListener onClickListener) {
        int parseColor;
        boolean z17 = jsBridgeListener != null && jsBridgeListener.f314008c;
        if (z16) {
            this.mUIStyle.f314630m = true;
            this.rightViewText.setVisibility(8);
            this.rightViewImg.setVisibility(8);
            ImageView imageView = this.mRightCornerIcon;
            if (imageView != null) {
                imageView.setVisibility(8);
                return;
            }
            return;
        }
        if (i3 == 0) {
            if (!TextUtils.isEmpty(str2)) {
                this.rightViewText.setText(str2);
                this.rightViewText.setVisibility(0);
                this.rightViewText.bringToFront();
                this.rightViewImg.setImageResource(0);
                this.rightViewImg.setBackgroundColor(0);
                this.rightViewImg.setVisibility(8);
            }
            if (str3 != null) {
                if (str3.length() > 0) {
                    try {
                        parseColor = Color.parseColor(str3);
                    } catch (Exception unused) {
                    }
                    this.rightViewImg.setBackgroundColor(parseColor);
                }
                parseColor = 0;
                this.rightViewImg.setBackgroundColor(parseColor);
            }
            if (str != null && !z17) {
                this.rightViewImg.setOnClickListener(this);
                this.rightViewText.setOnClickListener(this);
                this.mRightButtonCallback = str.trim();
            } else {
                this.mRightButtonListener = jsBridgeListener;
                this.mRightButtonCallback = null;
            }
        } else {
            processIdNotNull(str, str2, i3, i16, jsBridgeListener, onClickListener, z17);
        }
        JSONObject jSONObject = this.mUIStyle.K;
        if (jSONObject == null || !jSONObject.has("txtclr")) {
            return;
        }
        String optString = this.mUIStyle.K.optString("txtclr", "");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        if (!optString.startsWith("#")) {
            optString = "#" + optString;
        }
        try {
            int parseColor2 = Color.parseColor(optString);
            Drawable maskDrawableByColor = BaseImageUtil.maskDrawableByColor(this.rightViewImg.getDrawable(), parseColor2);
            if (maskDrawableByColor != null) {
                this.rightViewImg.setImageDrawable(maskDrawableByColor);
            }
            this.rightViewText.setTextColor(parseColor2);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.e
    public Activity getHostActivity() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPageFinished(WebView webView, String str) {
    }

    protected void onProgressChanged(WebView webView, int i3) {
    }

    protected void onReceivedTitle(WebView webView, String str) {
    }

    protected void onUrlChange(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
    }

    protected void onReceivedError(WebView webView, int i3, String str, String str2) {
    }
}
