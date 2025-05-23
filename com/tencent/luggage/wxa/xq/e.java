package com.tencent.luggage.wxa.xq;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.print.PrintDocumentAdapter;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textclassifier.TextClassifier;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.HttpAuthHandler;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.luggage.wxa.ar.h0;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.wq.i;
import com.tencent.luggage.wxa.xq.b;
import com.tencent.mobileqq.R;
import com.tencent.qimei.webview.QmWebview;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.xweb.CommandCfg;
import com.tencent.xweb.GetImageBitmapToFileFinishedCallback;
import com.tencent.xweb.VideoControl;
import com.tencent.xweb.VideoJsCallback;
import com.tencent.xweb.WebDebugCfg;
import com.tencent.xweb.WebSettings;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebViewCallbackClient;
import com.tencent.xweb.WebViewDatabase;
import com.tencent.xweb.WebViewJSExceptionListener;
import com.tencent.xweb.WebViewRenderProcessClient;
import com.tencent.xweb.XWebKeyEventHandler;
import com.tencent.xweb.XWebSdk;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.ProxyWebViewClientExtension;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes9.dex */
public class e implements IWebView {
    public static volatile boolean G = false;
    public final WebChromeClient C;
    public final WebViewClient D;
    public g E;
    public final String F;

    /* renamed from: a, reason: collision with root package name */
    public final WebView f145378a;

    /* renamed from: b, reason: collision with root package name */
    public final f f145379b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.xweb.WebViewClient f145380c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.xweb.WebChromeClient f145381d;

    /* renamed from: e, reason: collision with root package name */
    public WebViewCallbackClient f145382e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.xq.g f145383f;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.luggage.wxa.sq.a f145386i;

    /* renamed from: k, reason: collision with root package name */
    public final Looper f145388k;

    /* renamed from: g, reason: collision with root package name */
    public long f145384g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f145385h = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f145387j = -1;

    /* renamed from: l, reason: collision with root package name */
    public WebChromeClient.CustomViewCallback f145389l = null;

    /* renamed from: m, reason: collision with root package name */
    public boolean f145390m = false;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements VideoControl {
        public a() {
        }

        @Override // com.tencent.xweb.VideoControl
        public boolean supportSetRequestedOrientationCallback() {
            if (e.this.f145386i != null) {
                return e.this.f145386i.supportSetRequestedOrientationCallback();
            }
            return false;
        }

        @Override // com.tencent.xweb.VideoControl
        public void videoChangeStatus() {
            if (e.this.f145386i != null) {
                e.this.f145386i.videoChangeStatus();
            }
        }

        @Override // com.tencent.xweb.VideoControl
        public void videoExitFullscreen() {
            if (e.this.f145386i != null) {
                e.this.f145386i.videoExitFullscreen();
            }
        }

        @Override // com.tencent.xweb.VideoControl
        public void videoMute(boolean z16) {
            if (e.this.f145386i != null) {
                e.this.f145386i.videoMute(z16);
            }
        }

        @Override // com.tencent.xweb.VideoControl
        public void videoPause() {
            if (e.this.f145386i != null) {
                e.this.f145386i.videoPause();
            }
        }

        @Override // com.tencent.xweb.VideoControl
        public void videoPlay() {
            if (e.this.f145386i != null) {
                e.this.f145386i.videoPlay();
            }
        }

        @Override // com.tencent.xweb.VideoControl
        public void videoPlaybackRate(double d16) {
            if (e.this.f145386i != null) {
                e.this.f145386i.videoPlaybackRate(d16);
            }
        }

        @Override // com.tencent.xweb.VideoControl
        public void videoSeek(double d16) {
            if (e.this.f145386i != null) {
                e.this.f145386i.videoSeek(d16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b extends WebChromeClient {
        public b() {
        }

        @Override // android.webkit.WebChromeClient
        public View getVideoLoadingProgressView() {
            if (e.this.f145381d != null) {
                return e.this.f145381d.getVideoLoadingProgressView();
            }
            return LayoutInflater.from(e.this.f145378a.getContext()).inflate(R.layout.i8q, (ViewGroup) null);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (e.this.f145381d != null) {
                return e.this.f145381d.onConsoleMessage(consoleMessage);
            }
            return super.onConsoleMessage(consoleMessage);
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsHidePrompt() {
            x0.d("SysWebView", "onGeolocationPermissionsHidePrompt");
            if (e.this.f145381d != null) {
                e.this.f145381d.onGeolocationPermissionsHidePrompt();
            } else {
                super.onGeolocationPermissionsHidePrompt();
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            x0.d("SysWebView", "onGeolocationPermissionsShowPrompt");
            if (e.this.f145381d != null) {
                e.this.f145381d.onGeolocationPermissionsShowPrompt(str, callback);
            } else {
                super.onGeolocationPermissionsShowPrompt(str, callback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            x0.d("SysWebView", "onHideCustomView");
            e.this.f145389l = null;
            boolean z16 = false;
            e.this.f145390m = false;
            if (e.this.f145381d != null) {
                z16 = e.this.f145381d.onExitFullscreen();
            }
            if (z16) {
                x0.d("SysWebView", "onHideCustomView, isHandled:true");
                return;
            }
            if (e.this.f145386i != null) {
                e.this.f145386i.a();
            } else if (e.this.f145381d != null) {
                e.this.f145381d.onHideCustomView();
            } else {
                super.onHideCustomView();
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(android.webkit.WebView webView, String str, String str2, JsResult jsResult) {
            x0.d("SysWebView", "onJsAlert");
            if (e.this.f145381d != null) {
                return e.this.f145381d.onJsAlert(e.this.f145378a, str, str2, new b.f(jsResult));
            }
            return super.onJsAlert(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(android.webkit.WebView webView, String str, String str2, JsResult jsResult) {
            x0.d("SysWebView", "onJsConfirm");
            if (e.this.f145381d != null) {
                return e.this.f145381d.onJsConfirm(e.this.f145378a, str, str2, new b.f(jsResult));
            }
            return super.onJsConfirm(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(android.webkit.WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            x0.d("SysWebView", "onJsPrompt");
            if (e.this.f145381d != null) {
                return e.this.f145381d.onJsPrompt(e.this.f145378a, str, str2, str3, new b.e(jsPromptResult));
            }
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }

        @Override // android.webkit.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            x0.d("SysWebView", "onPermissionRequest");
            if (e.this.f145381d != null) {
                e.this.f145381d.onPermissionRequest(permissionRequest);
            } else {
                super.onPermissionRequest(permissionRequest);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
            x0.d("SysWebView", "onPermissionRequestCanceled");
            if (e.this.f145381d != null) {
                e.this.f145381d.onPermissionRequestCanceled(permissionRequest);
            } else {
                super.onPermissionRequestCanceled(permissionRequest);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(android.webkit.WebView webView, int i3) {
            if (e.this.f145381d != null) {
                e.this.f145381d.onProgressChanged(e.this.f145378a, i3);
            } else {
                super.onProgressChanged(webView, i3);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(android.webkit.WebView webView, String str) {
            boolean z16;
            x0.d("SysWebView", "onReceivedTitle: " + str);
            if (e.this.f145386i != null) {
                com.tencent.luggage.wxa.sq.a aVar = e.this.f145386i;
                if (e.this.f145378a.getFullscreenVideoKind() == WebView.FullscreenVideoKind.HOOK_EVALUTE_JS) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                aVar.a(true, z16);
            }
            if (e.this.f145381d != null) {
                e.this.f145381d.onReceivedTitle(e.this.f145378a, str);
            } else {
                super.onReceivedTitle(webView, str);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            boolean z16;
            x0.d("SysWebView", "onShowCustomView");
            e.this.f145389l = customViewCallback;
            e.this.f145390m = true;
            if (e.this.f145381d != null) {
                z16 = e.this.f145381d.onEnterFullscreen(view, customViewCallback);
            } else {
                z16 = false;
            }
            n0.M();
            if (z16) {
                x0.d("SysWebView", "onShowCustomView, isHandled:true");
                return;
            }
            if (e.this.f145386i != null) {
                n0.a(WebView.WebViewKind.WV_KIND_SYS, e.this.f145386i instanceof com.tencent.luggage.wxa.sq.d, e.this.getUrl());
                e.this.f145386i.a(view, customViewCallback);
            } else if (e.this.f145381d != null) {
                e.this.f145381d.onShowCustomView(view, customViewCallback);
            } else {
                super.onShowCustomView(view, customViewCallback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(android.webkit.WebView webView, ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            x0.d("SysWebView", "onShowFileChooser last method");
            if (e.this.f145381d != null) {
                return e.this.f145381d.onShowFileChooser(e.this.f145378a, valueCallback, new b.d(fileChooserParams));
            }
            return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IWebView.ICaptureBitmapCallback f145396a;

        public d(IWebView.ICaptureBitmapCallback iCaptureBitmapCallback) {
            this.f145396a = iCaptureBitmapCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap createBitmap = Bitmap.createBitmap(e.this.f145379b.getWidth(), e.this.f145379b.getHeight(), Bitmap.Config.ARGB_8888);
            e.this.f145379b.draw(new Canvas(createBitmap));
            this.f145396a.onBitmapCaptureFinished(createBitmap);
            x0.b("SysWebView", "bitmapCaptureFinished");
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.xq.e$e, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C6931e extends WebView.VisualStateCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebView.VisualStateCallback f145398a;

        public C6931e(WebView.VisualStateCallback visualStateCallback) {
            this.f145398a = visualStateCallback;
        }

        @Override // android.webkit.WebView.VisualStateCallback
        public void onComplete(long j3) {
            this.f145398a.onComplete(j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f extends QmWebview {
        public f(Context context) {
            super(context);
        }

        public int a() {
            return computeVerticalScrollRange();
        }

        @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && e.this.hasEnteredFullscreen()) {
                e.this.leaveFullscreen();
                return true;
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.View
        public void invalidate() {
            super.invalidate();
            int contentHeight = getContentHeight();
            if (contentHeight != e.this.f145387j) {
                e.this.f145387j = contentHeight;
                if (e.this.f145382e != null) {
                    x0.d("SysWebView", "onContentHeightChanged, height:" + contentHeight);
                    e.this.f145382e.onContentHeightChanged(contentHeight);
                }
            }
        }

        @Override // android.webkit.WebView, android.view.View
        public void onOverScrolled(int i3, int i16, boolean z16, boolean z17) {
            super.onOverScrolled(i3, i16, z16, z17);
            if (e.this.f145382e != null) {
                e.this.f145382e.onOverScrolled(i3, i16, z16, z17, this);
            }
        }

        @Override // android.webkit.WebView, android.view.View
        public void onScrollChanged(int i3, int i16, int i17, int i18) {
            super.onScrollChanged(i3, i16, i17, i18);
            if (e.this.f145378a != null) {
                e.this.f145378a.onWebViewScrollChanged(i3, i16, i17, i18);
            }
            if (e.this.f145382e != null) {
                e.this.f145382e.onScrollChanged(i3, i16, i17, i18, this);
            }
        }

        @Override // android.view.View
        public boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16) {
            if (e.this.f145382e != null) {
                e.this.f145382e.overScrollBy(i3, i16, i17, i18, i19, i26, i27, i28, z16, this);
            }
            return super.overScrollBy(i3, i16, i17, i18, i19, i26, i27, i28, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public HashMap f145401a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public int f145402b = 0;

        public String a(ValueCallback valueCallback) {
            if (valueCallback == null) {
                return "";
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("");
            int i3 = this.f145402b;
            this.f145402b = i3 + 1;
            sb5.append(i3);
            String sb6 = sb5.toString();
            this.f145401a.put(sb6, valueCallback);
            return sb6;
        }

        @JavascriptInterface
        public void notifyJava(String str, String str2) {
            ValueCallback valueCallback = (ValueCallback) this.f145401a.get(str);
            if (valueCallback != null) {
                valueCallback.onReceiveValue(str2);
                this.f145401a.remove(str);
            }
        }
    }

    public e(com.tencent.xweb.WebView webView) {
        boolean z16;
        b bVar = new b();
        this.C = bVar;
        c cVar = new c();
        this.D = cVar;
        this.F = "xwalkTempCallBack";
        this.f145378a = webView;
        this.f145388k = Looper.myLooper();
        if (webView.getContext().getApplicationInfo().targetSdkVersion >= 18) {
            z16 = true;
        } else {
            z16 = false;
        }
        G = z16;
        f fVar = new f(webView.getContext());
        this.f145379b = fVar;
        fVar.setBackgroundColor(0);
        getSettings();
        fVar.setWebChromeClient(bVar);
        fVar.setWebViewClient(cVar);
        if (webView.getContext() instanceof Activity) {
            a((Activity) webView.getContext());
        } else {
            a((Activity) null);
        }
    }

    @Override // com.tencent.xweb.internal.IWebView
    public int addDocumentStartJavaScript(String str, String[] strArr) {
        x0.f("SysWebView", "addDocumentStartJavaScript not implemented");
        return 0;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void addJavascriptInterface(Object obj, String str) {
        this.f145379b.addJavascriptInterface(obj, str);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean canGoBack() {
        return this.f145379b.canGoBack();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean canGoBackOrForward(int i3) {
        return this.f145379b.canGoBackOrForward(i3);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean canGoForward() {
        return this.f145379b.canGoForward();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public Bitmap captureBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(this.f145379b.getWidth(), this.f145379b.getHeight(), Bitmap.Config.ARGB_8888);
        this.f145379b.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void clearCache(boolean z16) {
        this.f145379b.clearCache(z16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void clearHistory() {
        this.f145379b.clearHistory();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void clearMatches() {
        this.f145379b.clearMatches();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void clearSslPreferences() {
        this.f145379b.clearSslPreferences();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void clearView() {
        this.f145379b.clearView();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public WebBackForwardList copyBackForwardList() {
        return this.f145379b.copyBackForwardList();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public PrintDocumentAdapter createPrintDocumentAdapter(String str) {
        return this.f145379b.createPrintDocumentAdapter(str);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public WebMessagePort[] createWebMessageChannel() {
        return this.f145379b.createWebMessageChannel();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void destroy() {
        this.f145379b.destroy();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void disablePlatformNotifications() {
        h0.a("android.webkit.WebView", "disablePlatformNotifications");
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void disableVideoJsCallback(boolean z16) {
        com.tencent.luggage.wxa.sq.a aVar = this.f145386i;
        if (aVar != null) {
            aVar.a(z16);
        }
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void documentHasImages(Message message) {
        this.f145379b.documentHasImages(message);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void enablePlatformNotifications() {
        h0.a("android.webkit.WebView", "enablePlatformNotifications");
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void evaluateJavascript(String str, ValueCallback valueCallback) {
        if (str == null) {
            return;
        }
        this.f145379b.evaluateJavascript(str, valueCallback);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void findAllAsync(String str) {
        this.f145379b.findAllAsync(str);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void findNext(boolean z16) {
        this.f145379b.findNext(z16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void flingScroll(int i3, int i16) {
        this.f145379b.flingScroll(i3, i16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public String getAbstractInfo() {
        return getVersionInfo();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public SslCertificate getCertificate() {
        return this.f145379b.getCertificate();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public int getContentHeight() {
        return this.f145379b.getContentHeight();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public Bitmap getFavicon() {
        return this.f145379b.getFavicon();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public WebView.FullscreenVideoKind getFullscreenVideoKind() {
        return CommandCfg.getInstance().getFullscreenVideoKind(com.tencent.xweb.WebView.getModuleName());
    }

    @Override // com.tencent.xweb.internal.IWebView
    public WebView.HitTestResult getHitTestResult() {
        WebView.HitTestResult hitTestResult = this.f145379b.getHitTestResult();
        WebView.HitTestResult hitTestResult2 = new WebView.HitTestResult();
        hitTestResult2.setType(hitTestResult.getType());
        hitTestResult2.setExtra(hitTestResult.getExtra());
        return hitTestResult2;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        return WebViewDatabase.getInstance(this.f145379b.getContext()).getHttpAuthUsernamePassword(str, str2);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean getImageBitmapToFile(String str, String str2, String str3, GetImageBitmapToFileFinishedCallback getImageBitmapToFileFinishedCallback) {
        return false;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public String getOriginalUrl() {
        return this.f145379b.getOriginalUrl();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public int getProgress() {
        return this.f145379b.getProgress();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public float getScale() {
        return this.f145379b.getScale();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public int getScrollHeight() {
        return this.f145379b.a();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public WebSettings getSettings() {
        if (WebDebugCfg.getInst().getEnableCheckThread()) {
            a();
        }
        com.tencent.luggage.wxa.xq.g gVar = this.f145383f;
        if (gVar != null) {
            return gVar;
        }
        f fVar = this.f145379b;
        if (fVar == null) {
            return null;
        }
        com.tencent.luggage.wxa.xq.g gVar2 = new com.tencent.luggage.wxa.xq.g(fVar);
        this.f145383f = gVar2;
        return gVar2;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public TextClassifier getTextClassifier() {
        TextClassifier textClassifier;
        if (Build.VERSION.SDK_INT >= 27) {
            textClassifier = this.f145379b.getTextClassifier();
            return textClassifier;
        }
        return null;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public String getTitle() {
        return this.f145379b.getTitle();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public ViewGroup getTopView() {
        return this.f145379b;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public String getUrl() {
        return this.f145379b.getUrl();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public String getVersionInfo() {
        return "sys, sdkver:" + XWebSdk.getXWebSdkVersion() + ", sysver:" + com.tencent.luggage.wxa.ar.g.a();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public View getView() {
        return this.f145379b;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public int getVisibleTitleHeight() {
        Object a16 = h0.a(this.f145379b, "getVisibleTitleHeight");
        if (a16 == null) {
            return 0;
        }
        return ((Integer) a16).intValue();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public com.tencent.xweb.WebChromeClient getWebChromeClient() {
        return this.f145381d;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public int getWebScrollX() {
        return getWebViewUI().getScrollX();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public int getWebScrollY() {
        return this.f145379b.getScrollY();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public WebViewCallbackClient getWebViewCallbackClient() {
        return this.f145382e;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public com.tencent.xweb.WebViewClient getWebViewClient() {
        return this.f145380c;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public Looper getWebViewLooper() {
        return this.f145388k;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public WebViewRenderProcessClient getWebViewRenderProcessClient() {
        return null;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public View getWebViewUI() {
        return this.f145379b;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void goBack() {
        this.f145379b.goBack();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void goBackOrForward(int i3) {
        this.f145379b.goBackOrForward(i3);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void goForward() {
        this.f145379b.goForward();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean hasEnteredFullscreen() {
        return this.f145390m;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public Bundle invokeMiscMethod(String str, Bundle bundle) {
        if (str != null && str.length() != 0) {
            if (!str.equals("supportTranslateWebSite")) {
                return null;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("result", false);
            x0.d("SysWebView", "sys web is not supportTranslateWebSite");
            return bundle2;
        }
        x0.b("SysWebView", " method string is null or empty");
        return null;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean isOverScrollStart() {
        if (getWebViewUI().getScrollY() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void leaveFullscreen() {
        WebChromeClient.CustomViewCallback customViewCallback = this.f145389l;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
        }
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void loadData(String str, String str2, String str3) {
        this.f145379b.loadData(str, str2, str3);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.f145379b.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void loadUrl(String str) {
        this.f145379b.loadUrl(str);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void onHide() {
        this.f145379b.onPause();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void onPause() {
        this.f145379b.onPause();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void onResume() {
        this.f145379b.onResume();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void onShow() {
        this.f145379b.onPause();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean overlayHorizontalScrollbar() {
        return this.f145379b.overlayHorizontalScrollbar();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean overlayVerticalScrollbar() {
        return this.f145379b.overlayVerticalScrollbar();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean pageDown(boolean z16) {
        return this.f145379b.pageDown(z16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean pageUp(boolean z16) {
        return this.f145379b.pageUp(z16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void pauseTimers() {
        this.f145379b.pauseTimers();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void postUrl(String str, byte[] bArr) {
        if (URLUtil.isNetworkUrl(str)) {
            this.f145379b.postUrl(str, bArr);
        } else {
            this.f145379b.loadUrl(str);
        }
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void postVisualStateCallback(long j3, WebView.VisualStateCallback visualStateCallback) {
        this.f145379b.postVisualStateCallback(j3, new C6931e(visualStateCallback));
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void postWebMessage(WebMessage webMessage, Uri uri) {
        this.f145379b.postWebMessage(webMessage, uri);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void reload() {
        this.f145379b.reload();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void removeDocumentStartJavaScript(int i3) {
        x0.f("SysWebView", "removeDocumentStartJavaScript not implemented");
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void removeJavascriptInterface(String str) {
        this.f145379b.removeJavascriptInterface(str);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void requestFocusNodeHref(Message message) {
        this.f145379b.requestFocusNodeHref(message);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void requestImageRef(Message message) {
        this.f145379b.requestImageRef(message);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public WebBackForwardList restoreState(Bundle bundle) {
        return this.f145379b.restoreState(bundle);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void resumeTimers() {
        this.f145379b.resumeTimers();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean savePage(String str, String str2, int i3) {
        return false;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public WebBackForwardList saveState(Bundle bundle) {
        return this.f145379b.saveState(bundle);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void saveWebArchive(String str) {
        this.f145379b.saveWebArchive(str);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setBottomHeight(int i3) {
        x0.c("SysWebView", "setBottomHeight not implement");
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setDownloadListener(DownloadListener downloadListener) {
        this.f145379b.setDownloadListener(downloadListener);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setFindListener(WebView.FindListener findListener) {
        this.f145379b.setFindListener(findListener);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setHorizontalScrollBarEnabled(boolean z16) {
        this.f145379b.setHorizontalScrollBarEnabled(z16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setHorizontalScrollbarOverlay(boolean z16) {
        this.f145379b.setHorizontalScrollbarOverlay(z16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        WebViewDatabase.getInstance(this.f145379b.getContext()).setHttpAuthUsernamePassword(str, str2, str3, str4);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setInitialScale(int i3) {
        this.f145379b.setInitialScale(i3);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setNetworkAvailable(boolean z16) {
        this.f145379b.setNetworkAvailable(z16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setTextClassifier(TextClassifier textClassifier) {
        if (Build.VERSION.SDK_INT >= 27) {
            this.f145379b.setTextClassifier(textClassifier);
        }
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setVerticalScrollBarEnabled(boolean z16) {
        this.f145379b.setVerticalScrollBarEnabled(z16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setVerticalScrollbarOverlay(boolean z16) {
        this.f145379b.setVerticalScrollbarOverlay(z16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public VideoControl setVideoJsCallback(VideoJsCallback videoJsCallback) {
        com.tencent.luggage.wxa.sq.a aVar = this.f145386i;
        if (aVar != null && aVar.a(videoJsCallback)) {
            return new a();
        }
        x0.d("SysWebView", "setVideoJsCallback not support");
        return null;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setWebChromeClient(com.tencent.xweb.WebChromeClient webChromeClient) {
        this.f145381d = webChromeClient;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setWebViewCallbackClient(WebViewCallbackClient webViewCallbackClient) {
        this.f145382e = webViewCallbackClient;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setWebViewClient(com.tencent.xweb.WebViewClient webViewClient) {
        this.f145380c = webViewClient;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void stopLoading() {
        this.f145379b.stopLoading();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean supportFeature(int i3) {
        if (i3 == 2006 || i3 == 2012) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean supportSetWebContentsSize() {
        return false;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void zoomBy(float f16) {
        this.f145379b.zoomBy(f16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean zoomIn() {
        return this.f145379b.zoomIn();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean zoomOut() {
        return this.f145379b.zoomOut();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void clearHistory(int i3, int i16) {
        x0.f("SysWebView", "Clear history failed. Only support in xweb core.");
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void loadUrl(String str, Map map) {
        this.f145379b.loadUrl(str, map);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void saveWebArchive(String str, boolean z16, ValueCallback valueCallback) {
        this.f145379b.saveWebArchive(str, z16, valueCallback);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c extends WebViewClient {

        /* renamed from: a, reason: collision with root package name */
        public String f145393a = null;

        /* renamed from: b, reason: collision with root package name */
        public final String f145394b = null;

        public c() {
        }

        @Override // android.webkit.WebViewClient
        public void doUpdateVisitedHistory(android.webkit.WebView webView, String str, boolean z16) {
            if (e.this.f145380c != null) {
                e.this.f145380c.doUpdateVisitedHistory(e.this.f145378a, str, z16);
            } else {
                super.doUpdateVisitedHistory(webView, str, z16);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(android.webkit.WebView webView, String str) {
            if (e.this.f145380c != null) {
                e.this.f145380c.onLoadResource(e.this.f145378a, str);
            } else {
                super.onLoadResource(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageCommitVisible(android.webkit.WebView webView, String str) {
            x0.d("SysWebView", "onPageCommitVisible s = " + str);
            if (e.this.f145380c != null) {
                e.this.f145380c.onPageCommitVisible(e.this.f145378a, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(android.webkit.WebView webView, String str) {
            boolean z16;
            x0.d("SysWebView", "onPageFinished " + str);
            if (e.this.f145386i != null) {
                com.tencent.luggage.wxa.sq.a aVar = e.this.f145386i;
                if (e.this.f145378a.getFullscreenVideoKind() == WebView.FullscreenVideoKind.HOOK_EVALUTE_JS) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                aVar.a(false, z16);
            }
            if (e.this.f145380c != null) {
                e.this.f145380c.onPageFinished(e.this.f145378a, str);
            } else {
                super.onPageFinished(webView, str);
            }
            long currentTimeMillis = System.currentTimeMillis() - e.this.f145384g;
            n0.g(currentTimeMillis);
            n0.e(currentTimeMillis);
            i.a(n0.a(str), this.f145394b, 1, 0, (int) currentTimeMillis, e.this.f145385h, str, WebView.WebViewKind.WV_KIND_SYS);
            e.this.f145384g = System.currentTimeMillis();
            e.this.f145378a.getDebugView().f();
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(android.webkit.WebView webView, String str, Bitmap bitmap) {
            boolean z16;
            x0.d("SysWebView", "onPageStarted " + str);
            if (e.this.f145380c != null) {
                e.this.f145380c.onPageStarted(e.this.f145378a, str, bitmap);
            } else {
                super.onPageStarted(webView, str, bitmap);
            }
            String str2 = this.f145393a;
            if (str2 != null && str != null && !str.equals(str2) && n0.a(str) != n0.a(this.f145393a)) {
                if (n0.a(this.f145393a) == 1 && n0.a(str) == 2) {
                    e.this.f145385h = 1;
                } else if (n0.a(this.f145393a) == 2 && n0.a(str) == 1) {
                    e.this.f145385h = 2;
                }
            }
            this.f145393a = str;
            e.this.f145384g = System.currentTimeMillis();
            n0.e(str);
            n0.Q();
            i.a(n0.a(str), this.f145394b, 0, 0, 0, e.this.f145385h, str, WebView.WebViewKind.WV_KIND_SYS);
            if (e.this.f145386i != null) {
                com.tencent.luggage.wxa.sq.a aVar = e.this.f145386i;
                if (e.this.f145378a.getFullscreenVideoKind() == WebView.FullscreenVideoKind.HOOK_EVALUTE_JS) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                aVar.a(true, z16);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(android.webkit.WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            x0.d("SysWebView", "onReceivedError2");
            if (e.this.f145380c != null) {
                if (webResourceRequest.isForMainFrame() && webResourceError != null) {
                    e.this.f145380c.onReceivedError(e.this.f145378a, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl() != null ? webResourceRequest.getUrl().toString() : null);
                }
                e.this.f145380c.onReceivedError(e.this.f145378a, new b.g(webResourceRequest), com.tencent.luggage.wxa.xq.b.a(webResourceError));
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(android.webkit.WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            x0.d("SysWebView", "onReceivedHttpAuthRequest host:" + str + ", realm:" + str2);
            if (e.this.f145380c != null) {
                e.this.f145380c.onReceivedHttpAuthRequest(e.this.f145378a, new b.c(httpAuthHandler), str, str2);
            } else {
                super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(android.webkit.WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            x0.d("SysWebView", "onReceivedHttpError code:" + String.valueOf(webResourceResponse.getStatusCode()));
            if (e.this.f145380c != null) {
                e.this.f145380c.onReceivedHttpError(e.this.f145378a, new b.g(webResourceRequest), com.tencent.luggage.wxa.xq.b.a(webResourceResponse));
            } else {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(android.webkit.WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            x0.d("SysWebView", "onReceivedSslError " + sslError.getPrimaryError());
            if (e.this.f145380c != null) {
                e.this.f145380c.onReceivedSslError(e.this.f145378a, new b.C6929b(sslErrorHandler), sslError);
            } else {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(android.webkit.WebView webView, float f16, float f17) {
            if (e.this.f145380c != null) {
                e.this.f145380c.onScaleChanged(e.this.f145378a, f16, f17);
            } else {
                super.onScaleChanged(webView, f16, f17);
            }
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, String str) {
            if (e.this.f145380c != null) {
                return com.tencent.luggage.wxa.xq.b.a(e.this.f145380c.shouldInterceptRequest(e.this.f145378a, str));
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, WebResourceRequest webResourceRequest) {
            x0.d("SysWebView", "shouldOverrideUrlLoading " + webResourceRequest.getUrl().toString());
            if (e.this.f145380c != null) {
                boolean shouldOverrideUrlLoading = e.this.f145380c.shouldOverrideUrlLoading(e.this.f145378a, new b.g(webResourceRequest));
                Uri url = webResourceRequest.getUrl();
                String scheme = url != null ? url.getScheme() : "";
                if (scheme == null || !scheme.toLowerCase(Locale.ROOT).startsWith("javascript")) {
                    return shouldOverrideUrlLoading;
                }
                return false;
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, WebResourceRequest webResourceRequest) {
            if (e.this.f145380c != null) {
                b.g gVar = new b.g(webResourceRequest);
                Bundle a16 = gVar.a();
                com.tencent.xweb.WebResourceResponse shouldInterceptRequest = a16 != null ? e.this.f145380c.shouldInterceptRequest(e.this.f145378a, gVar, a16) : null;
                if (shouldInterceptRequest == null) {
                    shouldInterceptRequest = e.this.f145380c.shouldInterceptRequest(e.this.f145378a, gVar);
                }
                return com.tencent.luggage.wxa.xq.b.a(shouldInterceptRequest);
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, String str) {
            if (e.this.f145378a.getDebugView().b(str)) {
                return true;
            }
            x0.d("SysWebView", "shouldOverrideUrlLoading " + str);
            if (e.this.f145380c != null) {
                boolean shouldOverrideUrlLoading = e.this.f145380c.shouldOverrideUrlLoading(e.this.f145378a, str);
                if (str == null || !str.toLowerCase(Locale.ROOT).startsWith("javascript")) {
                    return shouldOverrideUrlLoading;
                }
                return false;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(android.webkit.WebView webView, int i3, String str, String str2) {
            if (e.this.f145380c != null) {
                e.this.f145380c.onReceivedError(e.this.f145378a, i3, str, str2);
            } else {
                super.onReceivedError(webView, i3, str, str2);
            }
            n0.T();
            n0.R();
            i.a(n0.a(str2), this.f145394b, 1, i3, (int) (System.currentTimeMillis() - e.this.f145384g), e.this.f145385h, str2, WebView.WebViewKind.WV_KIND_SYS);
        }
    }

    public final void a(Activity activity) {
        x0.d("SysWebView", "initFullscreenVideo, kind:" + getFullscreenVideoKind() + ", activity:" + activity);
        if (getFullscreenVideoKind() == WebView.FullscreenVideoKind.NOT_HOOK) {
            return;
        }
        this.f145386i = com.tencent.luggage.wxa.sq.e.a(this.f145378a.getCurrentInstanceWebCoreType(), activity, this.f145378a, this.f145379b, com.tencent.luggage.wxa.sq.c.a());
        if (getFullscreenVideoKind() == WebView.FullscreenVideoKind.HOOK_EVALUTE_JS) {
            this.f145386i.b(this.f145379b);
        }
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void captureBitmap(IWebView.ICaptureBitmapCallback iCaptureBitmapCallback) {
        new BaseThread(new d(iCaptureBitmapCallback)).start();
    }

    public final void a() {
        if (this.f145388k == null || Looper.myLooper() == this.f145388k) {
            return;
        }
        Throwable th5 = new Throwable("A WebView method was called on thread '" + Thread.currentThread().getName() + "'. All WebView methods must be called on the same thread. (Expected Looper " + this.f145388k + " called on " + Looper.myLooper() + ", FYI main Looper is " + Looper.getMainLooper() + ")");
        String stackTraceString = Log.getStackTraceString(th5);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("checkThread error:");
        sb5.append(stackTraceString);
        x0.f("SysWebView", sb5.toString());
        com.tencent.luggage.wxa.wq.f.a(3, stackTraceString, WebView.WebViewKind.WV_KIND_SYS.ordinal());
        if (G) {
            throw new RuntimeException(th5);
        }
    }

    public static void a(Runnable runnable) {
        android.webkit.WebView.clearClientCertPreferences(runnable);
    }

    public static String a(String str) {
        return android.webkit.WebView.findAddress(str);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setAudioMuted(boolean z16) {
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setJSExceptionListener(WebViewJSExceptionListener webViewJSExceptionListener) {
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setPictureListener(WebView.PictureListener pictureListener) {
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setWebViewClientExtension(ProxyWebViewClientExtension proxyWebViewClientExtension) {
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setXWebKeyEventHandler(XWebKeyEventHandler xWebKeyEventHandler) {
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setWebContentsSize(int i3, int i16) {
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setWebViewRenderProcessClient(Executor executor, WebViewRenderProcessClient webViewRenderProcessClient) {
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void smoothScroll(int i3, int i16, long j3) {
    }
}
