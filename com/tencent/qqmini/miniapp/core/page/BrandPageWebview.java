package com.tencent.qqmini.miniapp.core.page;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.libra.util.ImageContentType;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmini.miniapp.R;
import com.tencent.qqmini.miniapp.core.EventListener;
import com.tencent.qqmini.miniapp.core.fsm.JsStatMachine;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine;
import com.tencent.qqmini.miniapp.plugin.EmbeddedVideoJsPlugin;
import com.tencent.qqmini.miniapp.util.AppBrandUtil;
import com.tencent.qqmini.miniapp.util.IPV6OnlyUtils;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.core.BaseRuntimeImpl;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.utils.FastClickUtils;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.DebugHelper;
import com.tencent.qqmini.sdk.utils.MiniLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class BrandPageWebview extends JsStatMachine implements IJsService {
    public static final int EVENT_INIT_SUCC = 3;
    public static final int EVENT_JS_APP_CONFIG_READY = 8;
    public static final int EVENT_JS_CONFIG_READY = 5;
    public static final int EVENT_JS_DEBUG_READY = 9;
    public static final int EVENT_JS_PAGE_FRAME_HTML_READY = 11;
    public static final int EVENT_JS_PAGE_FRAME_READY = 12;
    public static final int EVENT_JS_PAGE_GENERATE_FUNC_READY = 14;
    public static final int EVENT_JS_PAGE_READY = 13;
    public static final int EVENT_JS_REMOTE_DEBUG_READY = 7;
    public static final int EVENT_JS_WA_READY = 6;
    public static final int EVENT_JS_WXSS_READY = 10;
    public static final int EVENT_LOAD_PAGE = 4;
    protected static final String JS_INTERFACE_NAME = "WeixinJSCore";
    private static final String PREF_HTML_URL = "https://appservice.qq.com/";
    private static final String TAG = "BrandPageWebview";
    public FrameLayout customContainer;
    public IX5WebChromeClient.CustomViewCallback customViewCallback;
    private byte[] defaultPageHtmlBytes;
    private ApkgInfo mApkgInfo;
    private AppBrandPageContainer mAppBrandPageContainer;
    private IMiniAppContext mContext;
    private PageEventListener mEventListener;
    private StateMachine.OnStateChangeListener mOnStateChangeListener;
    private PageWebview mRealWebView;
    private String mShowingUrl;
    private String waConsoleJsStr;
    public View mFullscreenView = null;
    public boolean isFullScreen = false;
    private StateMachine.State stateInitial = new StateMachine.State(1);
    private StateMachine.State stateInited = new StateMachine.State(2);
    private StateMachine.State statePageLoadSucc = new StateMachine.State(4);
    private StateMachine.State statePageLoading = new StateMachine.State(3);
    private StateMachine.State stateDefaultConfigJsLoadSucc = new StateMachine.State(6);
    private JsStatMachine.JsState stateDefaultConfigJsLoading = new JsStatMachine.JsState(5).nextState(this.stateDefaultConfigJsLoadSucc);
    private StateMachine.State stateWaJsLoadSucc = new StateMachine.State(8);
    private JsStatMachine.JsState stateWaJsLoading = new JsStatMachine.JsState(7).nextState(this.stateWaJsLoadSucc);
    private StateMachine.State stateRemoteDebugJsLoadSucc = new StateMachine.State(10);
    private JsStatMachine.JsState stateRemoteDebugJsLoading = new JsStatMachine.JsState(9).nextState(this.stateRemoteDebugJsLoadSucc);
    private StateMachine.State stateGlobalConfigJsLoadSucc = new StateMachine.State(12);
    private JsStatMachine.JsState stateGlobalConfigJsLoading = new JsStatMachine.JsState(11).nextState(this.stateGlobalConfigJsLoadSucc);
    private StateMachine.State stateDebugJsLoadSucc = new StateMachine.State(14);
    private JsStatMachine.JsState statDebugJsLoading = new JsStatMachine.JsState(13).nextState(this.stateDebugJsLoadSucc);
    private StateMachine.State stateWxssJsLoadSucc = new StateMachine.State(16);
    private JsStatMachine.JsState stateWxssJsLoading = new JsStatMachine.JsState(15).nextState(this.stateWxssJsLoadSucc);
    private StateMachine.State statePageFrameHtmlJsLoadSucc = new StateMachine.State(18);
    private JsStatMachine.JsState statePageFrameHtmlJsLoading = new JsStatMachine.JsState(17).nextState(this.statePageFrameHtmlJsLoadSucc);
    private StateMachine.State statePageFrameJsLoadSucc = new StateMachine.State(20);
    private JsStatMachine.JsState statePageFrameJsLoading = new JsStatMachine.JsState(19).nextState(this.statePageFrameJsLoadSucc);
    private StateMachine.State stateLoadSucc = new StateMachine.State(22);
    private JsStatMachine.JsState statePageJsLoading = new JsStatMachine.JsState(21).nextState(this.stateLoadSucc);
    private StateMachine.State stateGenerateFuncReady = new StateMachine.State(23);
    private boolean mEnableNativeBuffer = false;
    private String mOpenType = EventListener.APPLAUNCH;

    /* renamed from: com.tencent.qqmini.miniapp.core.page.BrandPageWebview$5, reason: invalid class name */
    /* loaded from: classes23.dex */
    class AnonymousClass5 implements Runnable {
        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppBrandPage showingPage = BrandPageWebview.this.mAppBrandPageContainer.getShowingPage();
            showingPage.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(AppLoaderFactory.g().getContext(), R.anim.mini_sdk_page_slide_in_from_right);
            loadAnimation.setDuration(200L);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.qqmini.miniapp.core.page.BrandPageWebview.5.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AppBrandTask.runTaskOnUiThreadDelay(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.BrandPageWebview.5.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BrandPageWebview.this.mAppBrandPageContainer.onNewPageCompleted();
                        }
                    }, 10L);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            showingPage.startAnimation(loadAnimation);
        }
    }

    public BrandPageWebview(IMiniAppContext iMiniAppContext, AppBrandPageContainer appBrandPageContainer) {
        StateMachine.OnStateChangeListener onStateChangeListener = new StateMachine.OnStateChangeListener() { // from class: com.tencent.qqmini.miniapp.core.page.BrandPageWebview.1
            @Override // com.tencent.qqmini.miniapp.core.fsm.StateMachine.OnStateChangeListener
            public void onStateChanged() {
                boolean z16;
                if (BrandPageWebview.this.mRealWebView != null) {
                    PageWebview pageWebview = BrandPageWebview.this.mRealWebView;
                    if (BrandPageWebview.this.getCurrState() == BrandPageWebview.this.stateGenerateFuncReady) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    pageWebview.setPageJsLoadSucc(z16);
                }
            }
        };
        this.mOnStateChangeListener = onStateChangeListener;
        this.mContext = iMiniAppContext;
        this.mAppBrandPageContainer = appBrandPageContainer;
        addStateChangeListener(onStateChangeListener);
        setCurrState(this.stateInitial);
        initStateConfig();
        MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        if (miniAppProxy.hasTbsInitDone()) {
            QMLog.i(TAG, "Tbs has init");
            initWebView();
        } else {
            QMLog.i(TAG, "Tbs has not init");
            miniAppProxy.initTbs(new MiniAppProxy.InitTbsCallback() { // from class: com.tencent.qqmini.miniapp.core.page.b
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.InitTbsCallback
                public final void onTbsInitFinish() {
                    BrandPageWebview.this.lambda$new$0();
                }
            });
        }
    }

    private boolean checkEnableIPV6Only() {
        if (WnsConfig.getConfig("qqminiapp", "ipv6_proxy_enable", 0) != 1) {
            return false;
        }
        return true;
    }

    private WebResourceResponse doInterceptPrefFile(String str, WebResourceResponse webResourceResponse) {
        String str2;
        String str3;
        String substring = str.substring(26);
        String absolutePath = ((MiniAppFileManager) this.mContext.getManager(MiniAppFileManager.class)).getAbsolutePath(substring);
        if (!substring.startsWith("storage/emulated")) {
            substring = absolutePath;
        }
        if (!ImageUtil.isJpgFile(str) && !ImageUtil.isPngFile(str)) {
            if (str.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END) || str.endsWith(".svg")) {
                if (str.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END)) {
                    str3 = "image/gif";
                } else {
                    str3 = "image/svg+xml";
                }
                return new WebResourceResponse(str3, "UTF-8", ImageUtil.getLocalNoBitmapImageStream(substring));
            }
            return webResourceResponse;
        }
        boolean isPngFile = ImageUtil.isPngFile(str);
        if (isPngFile) {
            str2 = "image/png";
        } else {
            str2 = ImageContentType.MIME_TYPE_JPG;
        }
        return new WebResourceResponse(str2, "UTF-8", ImageUtil.getLocalImageStream(substring, isPngFile));
    }

    private WebResourceResponse doInterceptPrefHtml(WebResourceResponse webResourceResponse) {
        ByteArrayInputStream byteArrayInputStream;
        int i3;
        String basePageFrameStr = ((BaseRuntimeImpl.BaselibProvider) this.mContext.getManager(BaseRuntimeImpl.BaselibProvider.class)).getBasePageFrameStr();
        if (!TextUtils.isEmpty(basePageFrameStr)) {
            ByteArrayInputStream byteArrayInputStream2 = null;
            try {
                try {
                    byte[] bArr = this.defaultPageHtmlBytes;
                    if (bArr == null || bArr.length == 0) {
                        this.defaultPageHtmlBytes = basePageFrameStr.getBytes("UTF-8");
                    }
                    byte[] bArr2 = this.defaultPageHtmlBytes;
                    i3 = 0;
                    byteArrayInputStream = new ByteArrayInputStream(bArr2, 0, bArr2.length);
                } catch (UnsupportedEncodingException e16) {
                    e = e16;
                }
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                try {
                    WebResourceResponse webResourceResponse2 = new WebResourceResponse("text/html", "UTF-8", byteArrayInputStream);
                    try {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("load default page html. length= ");
                        byte[] bArr3 = this.defaultPageHtmlBytes;
                        if (bArr3 != null) {
                            i3 = bArr3.length;
                        }
                        sb5.append(i3);
                        QMLog.d(TAG, sb5.toString());
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                        return webResourceResponse2;
                    } catch (UnsupportedEncodingException e18) {
                        e = e18;
                        webResourceResponse = webResourceResponse2;
                        byteArrayInputStream2 = byteArrayInputStream;
                        e.printStackTrace();
                        QMLog.e(TAG, "load page html error.", e);
                        if (byteArrayInputStream2 != null) {
                            try {
                                byteArrayInputStream2.close();
                                return webResourceResponse;
                            } catch (IOException e19) {
                                e19.printStackTrace();
                                return webResourceResponse;
                            }
                        }
                        return webResourceResponse;
                    }
                } catch (UnsupportedEncodingException e26) {
                    byteArrayInputStream2 = byteArrayInputStream;
                    e = e26;
                }
            } catch (Throwable th6) {
                th = th6;
                byteArrayInputStream2 = byteArrayInputStream;
                if (byteArrayInputStream2 != null) {
                    try {
                        byteArrayInputStream2.close();
                    } catch (IOException e27) {
                        e27.printStackTrace();
                    }
                }
                throw th;
            }
        } else {
            return webResourceResponse;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebResourceResponse doInterceptRequest(WebView webView, String str) {
        String str2;
        String str3;
        if (str.startsWith(PREF_HTML_URL) && str.endsWith(".html")) {
            return doInterceptPrefHtml(null);
        }
        if (str.startsWith(PREF_HTML_URL)) {
            return doInterceptPrefFile(str, null);
        }
        if (!str.startsWith("wxfile://")) {
            return null;
        }
        String absolutePath = ((MiniAppFileManager) this.mContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str);
        if (!ImageUtil.isJpgFile(str) && !ImageUtil.isPngFile(str)) {
            if (!str.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END) && !str.endsWith(".svg")) {
                return null;
            }
            if (str.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END)) {
                str3 = "image/gif";
            } else {
                str3 = "image/svg+xml";
            }
            return new WebResourceResponse(str3, "UTF-8", ImageUtil.getLocalNoBitmapImageStream(absolutePath));
        }
        boolean isPngFile = ImageUtil.isPngFile(str);
        if (isPngFile) {
            str2 = "image/png";
        } else {
            str2 = ImageContentType.MIME_TYPE_JPG;
        }
        return new WebResourceResponse(str2, "UTF-8", ImageUtil.getLocalImageStream(absolutePath, isPngFile));
    }

    private void initPageWebview() {
        PageWebview pageWebview = new PageWebview(this.mContext, this.mAppBrandPageContainer, this);
        this.mRealWebView = pageWebview;
        pageWebview.addJavascriptInterface(this, JS_INTERFACE_NAME);
        setWebviewClient();
        setWebChromeClient();
    }

    private void initWebView() {
        initPageWebview();
        setCurrState(this.stateInited);
        loadDefaultHtml();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cleanUp$1() {
        PageWebview pageWebview = this.mRealWebView;
        if (pageWebview != null) {
            pageWebview.removeJavascriptInterface(JS_INTERFACE_NAME);
            this.mRealWebView.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        QMLog.i(TAG, "Tbs init finish");
        initWebView();
    }

    private void setWebChromeClient() {
        this.mRealWebView.setWebChromeClient(new WebChromeClient() { // from class: com.tencent.qqmini.miniapp.core.page.BrandPageWebview.2
            @Override // com.tencent.smtt.sdk.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (consoleMessage != null) {
                    if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR) {
                        if (QMLog.isColorLevel() && !FastClickUtils.isFastDoubleClick("miniapp-chromium", 500L)) {
                            QMLog.e("miniapp-chromium", "PageWebView: " + consoleMessage.message() + " line:" + consoleMessage.lineNumber() + "  page:" + BrandPageWebview.this.mShowingUrl);
                        }
                    } else if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.WARNING) {
                        if (QMLog.isColorLevel() && !FastClickUtils.isFastDoubleClick("miniapp-chromium", 500L)) {
                            QMLog.w("miniapp-chromium", "PageWebView: " + consoleMessage.message() + " line:" + consoleMessage.lineNumber() + "  page:" + BrandPageWebview.this.mShowingUrl);
                        }
                    } else if (!FastClickUtils.isFastDoubleClick("miniapp-chromium", 500L)) {
                        QMLog.i("miniapp-chromium", "PageWebView: " + consoleMessage.message());
                    }
                }
                return super.onConsoleMessage(consoleMessage);
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient
            public void onHideCustomView() {
                QMLog.d("miniapp-embedded", "onHideCustomView " + Thread.currentThread());
                BrandPageWebview brandPageWebview = BrandPageWebview.this;
                if (brandPageWebview.customViewCallback == null) {
                    return;
                }
                ((JsStatMachine) brandPageWebview).mMainHandler.postDelayed(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.BrandPageWebview.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QMLog.d("miniapp-embedded", "onHideCustomView begin");
                        FrameLayout frameLayout = BrandPageWebview.this.customContainer;
                        if (frameLayout == null) {
                            return;
                        }
                        frameLayout.setVisibility(8);
                        BrandPageWebview.this.customViewCallback.onCustomViewHidden();
                        try {
                            BrandPageWebview.this.customContainer.removeAllViews();
                        } catch (Exception unused) {
                        }
                        BrandPageWebview brandPageWebview2 = BrandPageWebview.this;
                        brandPageWebview2.customContainer = null;
                        brandPageWebview2.mFullscreenView = null;
                        brandPageWebview2.customViewCallback = null;
                        QMLog.d("miniapp-embedded", "onHideCustomView end");
                    }
                }, 200L);
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient
            public void onProgressChanged(WebView webView, int i3) {
                JsInjector.getInstance().onProgressChanged(webView, i3);
                super.onProgressChanged(webView, i3);
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient
            public void onShowCustomView(View view, IX5WebChromeClient.CustomViewCallback customViewCallback) {
                QMLog.d("miniapp-embedded", "onShowCustomView \uff1a " + view + "; " + Thread.currentThread());
                if (BrandPageWebview.this.customViewCallback != null) {
                    customViewCallback.onCustomViewHidden();
                    return;
                }
                QMLog.d("miniapp-embedded", "onShowCustomView begin");
                BrandPageWebview brandPageWebview = BrandPageWebview.this;
                if (brandPageWebview.customContainer == null && brandPageWebview.mContext != null) {
                    BrandPageWebview.this.customContainer = new FrameLayout(BrandPageWebview.this.mContext.getContext());
                    BrandPageWebview.this.customContainer.setBackgroundColor(-16777216);
                    Activity attachActivity = BrandPageWebview.this.mContext.getAttachActivity();
                    if (attachActivity != null) {
                        ((ViewGroup) attachActivity.getWindow().getDecorView()).addView(BrandPageWebview.this.customContainer, new ViewGroup.LayoutParams(-1, -1));
                    }
                }
                FrameLayout frameLayout = BrandPageWebview.this.customContainer;
                if (frameLayout != null) {
                    frameLayout.addView(view);
                    BrandPageWebview.this.customContainer.setVisibility(0);
                }
                BrandPageWebview brandPageWebview2 = BrandPageWebview.this;
                brandPageWebview2.mFullscreenView = view;
                brandPageWebview2.customViewCallback = customViewCallback;
                brandPageWebview2.isFullScreen = true;
                QMLog.d("miniapp-embedded", "onShowCustomView end");
            }
        });
    }

    private void setWebviewClient() {
        this.mRealWebView.setWebViewClient(new WebViewClient() { // from class: com.tencent.qqmini.miniapp.core.page.BrandPageWebview.3
            @Override // com.tencent.smtt.sdk.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                BrandPageWebview brandPageWebview = BrandPageWebview.this;
                brandPageWebview.setCurrState(brandPageWebview.statePageLoadSucc);
            }

            @Override // com.tencent.smtt.sdk.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                JsInjector.getInstance().onPageStarted(webView);
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // com.tencent.smtt.sdk.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                boolean isLogStringContainerHighFrequencyEvent = MiniLog.isLogStringContainerHighFrequencyEvent(webResourceRequest.getUrl().toString());
                if (QMLog.isColorLevel() && (!isLogStringContainerHighFrequencyEvent || !FastClickUtils.isFastDoubleClick("miniapp-chromium", 500L))) {
                    QMLog.d("miniapp-chromium", "shouldInterceptRequest: " + webResourceRequest.getUrl());
                }
                if (webResourceRequest.getUrl() != null) {
                    String uri = webResourceRequest.getUrl().toString();
                    if (!TextUtils.isEmpty(uri) && (uri.startsWith(BrandPageWebview.PREF_HTML_URL) || uri.startsWith("wxfile://"))) {
                        return BrandPageWebview.this.doInterceptRequest(webView, webResourceRequest.getUrl().toString());
                    }
                }
                if (webResourceRequest.getUrl() != null && IPV6OnlyUtils.isIPV6Enable(webResourceRequest.getUrl().toString())) {
                    return BrandPageWebview.this.doIPV6OnlyRequest(webView, webResourceRequest);
                }
                return null;
            }
        });
    }

    private void webviewReport() {
        StateMachine.State currState = getCurrState();
        if (currState == this.stateWaJsLoading) {
            MiniReportManager.reportEventType(this.mContext.getMiniAppInfo(), 18, "0");
            return;
        }
        if (this.stateRemoteDebugJsLoadSucc == currState) {
            MiniReportManager.reportEventType(this.mContext.getMiniAppInfo(), 19, "0");
            return;
        }
        if (this.stateInitial == currState) {
            MiniReportManager.reportEventType(this.mContext.getMiniAppInfo(), 102, "0");
            return;
        }
        if (this.stateInited == currState) {
            MiniReportManager.reportEventType(this.mContext.getMiniAppInfo(), 103, "0");
            return;
        }
        if (this.stateGlobalConfigJsLoading == currState) {
            MiniReportManager.reportEventType(this.mContext.getMiniAppInfo(), 106, "0");
        } else if (this.stateLoadSucc == currState) {
            MiniReportManager.reportEventType(this.mContext.getMiniAppInfo(), 107, "0");
            MiniReportManager.recordMiniLaunchTime(35, this.mContext.getMiniAppInfo().appId);
        }
    }

    public void cleanUp() {
        IX5WebChromeClient.CustomViewCallback customViewCallback = this.customViewCallback;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
        }
        FrameLayout frameLayout = this.customContainer;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
            try {
                this.customContainer.removeAllViews();
            } catch (Exception unused) {
            }
        }
        this.customContainer = null;
        this.mFullscreenView = null;
        this.customViewCallback = null;
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.a
            @Override // java.lang.Runnable
            public final void run() {
                BrandPageWebview.this.lambda$cleanUp$1();
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public int createNativeBuffer(byte[] bArr, long j3, long j16) {
        return 0;
    }

    public boolean doDispatchKeyEvent(KeyEvent keyEvent) {
        FrameLayout frameLayout;
        if (!this.isFullScreen || this.mFullscreenView == null || (frameLayout = this.customContainer) == null || frameLayout.getVisibility() != 0 || keyEvent.getKeyCode() != 4) {
            return false;
        }
        QMLog.d("miniapp-embedded", "KEYCODE_BACK");
        this.isFullScreen = false;
        evaluateSubscribeJS(EmbeddedVideoJsPlugin.VIDEO_EVENT_EXIT_FULLSCREEN, null, getWebViewId());
        return true;
    }

    public WebResourceResponse doIPV6OnlyRequest(WebView webView, WebResourceRequest webResourceRequest) {
        String uri = webResourceRequest.getUrl().toString();
        try {
            String str = WnsConfig.getConfig("qqminiapp", "ipv6_http_proxy_url", "https://proxy.gtimg.cn/tx_tls_gate=") + uri;
            QMLog.e(TAG, "ipv6 url = " + str);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod(webResourceRequest.getMethod());
            if (webResourceRequest.getRequestHeaders() != null) {
                for (Map.Entry<String, String> entry : webResourceRequest.getRequestHeaders().entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            httpURLConnection.setConnectTimeout(6000);
            httpURLConnection.setReadTimeout(6000);
            String str2 = "";
            if (httpURLConnection.getHeaderFields() != null && httpURLConnection.getHeaderFields().containsKey("Content-Type")) {
                str2 = httpURLConnection.getHeaderFields().get("Content-Type").get(0);
            }
            String mimeType = IPV6OnlyUtils.getMimeType(str2);
            String encoding = IPV6OnlyUtils.getEncoding(str2);
            QMLog.e(TAG, "ipv6 code:" + httpURLConnection.getResponseCode() + "  url:" + str);
            QMLog.e(TAG, "ipv6 mimeType = " + mimeType + "encoding:" + encoding);
            return new WebResourceResponse(mimeType, encoding, httpURLConnection.getInputStream());
        } catch (Exception e16) {
            QMLog.e(TAG, "shouldInterceptRequest: failed ", e16);
            return null;
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public void evaluateCallbackJs(int i3, String str) {
        evaluateJs(String.format("WeixinJSBridge.invokeCallbackHandler(%d, %s)", Integer.valueOf(i3), str), null);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public void evaluateJs(String str, ValueCallback valueCallback) {
        evaluateJs(str, valueCallback, null);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public void evaluateSubscribeJS(String str, String str2, int i3) {
        evaluateJs("WeixinJSBridge.subscribeHandler(\"" + str + "\"," + str2 + "," + i3 + ",0)", null);
    }

    public void evaluateSubscribeJSInService(String str, String str2, int i3) {
        evaluateJs("WeixinJSBridge.subscribeHandler(\"" + str + "\"," + str2 + ",0,\"" + i3 + "\")", null);
    }

    public String getJSGlobalConfig(ApkgInfo apkgInfo) {
        String str;
        String str2;
        if (apkgInfo == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", apkgInfo.appId);
            jSONObject.put("icon", apkgInfo.iconUrl);
            jSONObject.put("nickname", apkgInfo.apkgName);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        MiniAppInfo miniAppInfo = apkgInfo.mMiniAppInfo;
        if (miniAppInfo == null) {
            str = "";
            str2 = "release";
        } else {
            str2 = miniAppInfo.getVerTypeStr();
            str = apkgInfo.mMiniAppInfo.version;
        }
        String format = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig=%1$s;  __qqConfig = extend(__qqConfig, __tempConfig);__qqConfig.accountInfo=JSON.parse('%2$s');  __qqConfig.envVersion='" + str2 + "'; __qqConfig.deviceinfo='" + QUAUtil.getSimpleDeviceInfo(AppLoaderFactory.g().getContext()) + "'; __qqConfig.miniapp_version='" + str + "';", apkgInfo.mConfigStr, jSONObject.toString());
        if (DebugHelper.d().c(this.mApkgInfo.appId)) {
            format = format + "__qqConfig.debug=true;";
        }
        return (format + "__qqConfig.openDataHosts='" + WnsConfig.getConfig("qqminiapp", "opendatahosts", ".qlogo.com;.qlogo.cn;.qq.com;.tcb.qcloud.la") + "';") + "if (typeof WeixinJSBridge != 'undefined' && typeof WeixinJSBridge.subscribeHandler == 'function') {WeixinJSBridge.subscribeHandler('onWxConfigReady')};";
    }

    public String getJsDefaultConfig(boolean z16) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("USER_DATA_PATH", "qqfile://usr");
            jSONObject.put(MosaicConstants$JsProperty.PROP_ENV, jSONObject2);
            jSONObject.put("preload", z16);
            String format = String.format("function extend(obj, src) {\n    for (var key in src) {\n        if (src.hasOwnProperty(key)) obj[key] = src[key];\n    }\n    return obj;\n}\nvar window = window || {}; window.__webview_engine_version__ = 0.02; if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig = JSON.parse('%1$s');__qqConfig = extend(__qqConfig, __tempConfig);__qqConfig.QUA='" + QUAUtil.getPlatformQUA() + "';__qqConfig.platform = 'android';", jSONObject);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(format);
            sb5.append("__qqConfig.XWebVideoMinVersion=045100;");
            String sb6 = sb5.toString();
            if (getRealView() != null && getRealView().getEmbeddedState() != null) {
                boolean isEnableEmbeddedVideo = getRealView().getEmbeddedState().isEnableEmbeddedVideo();
                if (isEnableEmbeddedVideo) {
                    sb6 = sb6 + "__qqConfig.useXWebVideo=" + isEnableEmbeddedVideo + ";";
                }
                boolean isEnableEmbeddedLive = getRealView().getEmbeddedState().isEnableEmbeddedLive();
                if (isEnableEmbeddedLive) {
                    sb6 = sb6 + "__qqConfig.useXWebLive=" + isEnableEmbeddedLive + ";";
                }
                boolean isEnableEmbeddedElement = getRealView().getEmbeddedState().isEnableEmbeddedElement();
                if (isEnableEmbeddedElement) {
                    sb6 = sb6 + "__qqConfig.useXWebElement=" + isEnableEmbeddedElement + ";";
                }
            }
            QMLog.d(AppLoaderFactory.TAG, "getJsDefaultConfig pageWebview String: " + sb6);
            return sb6;
        } catch (Exception e16) {
            QMLog.e(TAG, "getJsDefaultConfig failed: " + e16);
            return "";
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public byte[] getNativeBuffer(int i3) {
        return new byte[0];
    }

    public PageEventListener getPageEventListener() {
        return this.mEventListener;
    }

    public PageWebview getRealView() {
        return this.mRealWebView;
    }

    public String getShowingUrl() {
        return this.mShowingUrl;
    }

    public int getWebViewId() {
        PageWebview pageWebview = this.mRealWebView;
        if (pageWebview == null) {
            return -1;
        }
        return pageWebview.getPageWebViewId();
    }

    public boolean handleBackPressed() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handleBackPressed : ");
        if (this.mFullscreenView != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QMLog.d("miniapp-embedded", sb5.toString());
        if (this.mFullscreenView != null) {
            return true;
        }
        return false;
    }

    public void initBaseJs(BaselibLoader.BaselibContent baselibContent) {
        this.stateDefaultConfigJsLoading.setJsContent(getJsDefaultConfig(true));
        appendEvent(5);
        this.stateWaJsLoading.setJsContent(baselibContent.waWebviewJsStr);
        appendEvent(6);
        this.stateRemoteDebugJsLoading.setJsContent(baselibContent.waRemoteDebugStr);
        appendEvent(7);
        this.waConsoleJsStr = baselibContent.waConsoleJsStr;
    }

    protected void initStateConfig() {
        addStateTransfer(new StateMachine.StateTransfer().from(this.stateInitial).next(this.stateInited).registEvent(3));
        addStateTransfer(new StateMachine.StateTransfer().from(this.statePageLoadSucc).next(this.stateDefaultConfigJsLoading).registEvent(5));
        addStateTransfer(new StateMachine.StateTransfer().from(this.stateDefaultConfigJsLoadSucc).next(this.stateWaJsLoading).registEvent(6));
        addStateTransfer(new StateMachine.StateTransfer().from(this.stateWaJsLoadSucc).next(this.stateRemoteDebugJsLoading).registEvent(7));
        addStateTransfer(new StateMachine.StateTransfer().from(this.stateRemoteDebugJsLoadSucc).next(this.stateGlobalConfigJsLoading).registEvent(8));
        addStateTransfer(new StateMachine.StateTransfer().from(this.stateGlobalConfigJsLoadSucc).next(this.statDebugJsLoading).registEvent(9));
        addStateTransfer(new StateMachine.StateTransfer().from(this.stateDebugJsLoadSucc).next(this.stateWxssJsLoading).registEvent(10));
        addStateTransfer(new StateMachine.StateTransfer().from(this.stateWxssJsLoadSucc).next(this.statePageFrameHtmlJsLoading).registEvent(11));
        addStateTransfer(new StateMachine.StateTransfer().from(this.statePageFrameHtmlJsLoadSucc).next(this.statePageFrameJsLoading).registEvent(12));
        addStateTransfer(new StateMachine.StateTransfer().from(this.statePageFrameJsLoadSucc).next(this.statePageJsLoading).registEvent(13));
        addStateTransfer(new StateMachine.StateTransfer().from(this.stateLoadSucc).next(this.stateGenerateFuncReady).registEvent(14));
        setCurrState(this.stateInitial);
    }

    @JavascriptInterface
    public String invokeHandler(String str, String str2, int i3) {
        PageEventListener pageEventListener;
        if ("initWeixinJSBridgeFinish".equals(str) || (pageEventListener = this.mEventListener) == null) {
            return "";
        }
        return pageEventListener.onWebViewNativeRequest(str, str2, this, i3, getWebViewId());
    }

    public boolean isReady() {
        if (this.stateGenerateFuncReady == getCurrState()) {
            return true;
        }
        return false;
    }

    public void loadDefaultHtml() {
        if (this.mRealWebView != null) {
            setCurrState(this.statePageLoading);
            this.mRealWebView.loadUrl("https://appservice.qq.com/page-frame.html");
        }
    }

    public void loadUrl(String str, String str2) {
        this.mShowingUrl = str;
        this.mOpenType = str2;
        this.statePageFrameHtmlJsLoading.setJsContent(this.mApkgInfo.getPageHtmlContent(((BaseRuntimeImpl.BaselibProvider) this.mContext.getManager(BaseRuntimeImpl.BaselibProvider.class)).getBasePageFrameStr()).jsStr);
        appendEvent(11);
        this.statePageFrameJsLoading.setJsContent(this.mApkgInfo.getPageFrameJSStr(str));
        appendEvent(12);
        this.statePageJsLoading.setJsContent(this.mApkgInfo.getPageJsStr(str));
        appendEvent(13);
    }

    @JavascriptInterface
    public void publishHandler(String str, String str2, String str3) {
        PageEventListener pageEventListener = this.mEventListener;
        if (pageEventListener != null) {
            pageEventListener.onWebViewEvent(str, str2, getWebViewId());
        }
        if (str.equals("custom_event_GenerateFuncReady") && this.mAppBrandPageContainer != null) {
            QMLog.i(TAG, "custom_event_GenerateFuncReady.(" + this + ") id:" + getWebViewId());
            appendEvent(14);
        }
        if (str.equals("custom_event_PAGE_EVENT") && str2.contains("DOMReady") && this.mAppBrandPageContainer != null) {
            QMLog.i(TAG, "custom_event_PAGE_EVENT __DOMReady.  Show the page.(" + this + ") id:" + getWebViewId());
            this.mContext.performAction(AppStateEvent.obtain(11));
            if (this.mAppBrandPageContainer.getAppBrandPagePool() != null) {
                AppBrandTask.runTaskOnUiThreadDelay(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.BrandPageWebview.4
                    @Override // java.lang.Runnable
                    public void run() {
                        BrandPageWebview.this.mAppBrandPageContainer.getAppBrandPagePool().preLoadAppBrandPage(BrandPageWebview.this.mContext, BrandPageWebview.this.mAppBrandPageContainer);
                    }
                }, 1000L);
            }
            if (this.mAppBrandPageContainer.getShowingPage() != null && this.mAppBrandPageContainer.getShowingPage().getVisibility() != 0 && !this.mAppBrandPageContainer.getShowingPage().isHomePage()) {
                AppBrandTask.runTaskOnUiThread(new AnonymousClass5());
            } else {
                AppBrandTask.runTaskOnUiThreadDelay(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.BrandPageWebview.6
                    @Override // java.lang.Runnable
                    public void run() {
                        BrandPageWebview.this.mAppBrandPageContainer.onNewPageCompleted();
                    }
                }, 10L);
            }
        }
    }

    public void setApkgInfo(ApkgInfo apkgInfo) {
        if (apkgInfo == null) {
            return;
        }
        this.mApkgInfo = apkgInfo;
        this.stateGlobalConfigJsLoading.setJsContent(getJSGlobalConfig(apkgInfo));
        appendEvent(8);
        String str = "";
        if (DebugHelper.d().c(this.mApkgInfo.appId)) {
            if (!TextUtils.isEmpty(this.waConsoleJsStr)) {
                str = this.waConsoleJsStr;
            }
            this.statDebugJsLoading.setJsContent(str);
        } else {
            this.statDebugJsLoading.setJsContent("");
        }
        appendEvent(9);
        this.stateWxssJsLoading.setJsContent(apkgInfo.getRootWxssJsContent());
        appendEvent(10);
    }

    @Override // com.tencent.qqmini.miniapp.core.fsm.StateMachine
    public void setCurrState(StateMachine.State state) {
        if (state == this.stateGenerateFuncReady) {
            if (this.mEventListener != null) {
                QMLog.d(TAG, "onWebViewReady  (" + this + ")");
                this.mEventListener.onWebViewReady(this.mOpenType, this.mShowingUrl, getWebViewId());
            } else {
                QMLog.d(TAG, "onWebViewReady no listener  (" + this + ")");
            }
        }
        webviewReport();
        super.setCurrState(state);
    }

    public void setWebViewEventListener(PageEventListener pageEventListener) {
        this.mEventListener = pageEventListener;
        PageWebview pageWebview = this.mRealWebView;
        if (pageWebview != null) {
            pageWebview.setPageEventListener(pageEventListener);
        }
    }

    @Override // com.tencent.qqmini.miniapp.core.fsm.JsStatMachine
    public void evaluateJs(final String str, final ValueCallback valueCallback, String str2) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            PageWebview pageWebview = this.mRealWebView;
            if (pageWebview != null) {
                pageWebview.evaluateJavascript(str, AppBrandUtil.convertValueCallback(valueCallback));
                return;
            }
            return;
        }
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.BrandPageWebview.7
            @Override // java.lang.Runnable
            public void run() {
                if (BrandPageWebview.this.mRealWebView != null) {
                    BrandPageWebview.this.mRealWebView.evaluateJavascript(str, AppBrandUtil.convertValueCallback(valueCallback));
                }
            }
        });
    }
}
