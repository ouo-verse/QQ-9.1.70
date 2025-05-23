package com.tencent.mobileqq.microapp.appbrand.page;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.webkit.JavascriptInterface;
import com.tencent.libra.util.ImageContentType;
import com.tencent.mobileqq.microapp.apkg.f;
import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.appbrand.b.b;
import com.tencent.mobileqq.microapp.appbrand.b.c;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* loaded from: classes15.dex */
public class PageWebview extends BaseAppBrandWebview {
    static IPatchRedirector $redirector_ = null;
    private static final String PREF_HTML_URL = "https://servicewechat.com/";
    private static final String TAG;
    a appBrandRuntime;
    private byte[] contentBytes;
    WebViewEventListener eventListener;
    private boolean hasFLoad;
    private boolean hasLoadHtmlFinish;
    public boolean isShowShare;
    PageWebViewListener listener;
    Context mContext;
    private int mLastX;
    private int mLastY;
    String mRouteUrl;
    private String mWAWebviewStr;
    private String mWxssJs;
    public OnWebviewScrollListener onWebviewScrollListener;
    String openType;
    public int scrollY;
    public SwipeRefreshLayout swipeRefreshLayout;
    private String wxssJsStr;

    /* loaded from: classes15.dex */
    public interface OnWebviewScrollListener {
        void onVerticalScroll(int i3);
    }

    /* loaded from: classes15.dex */
    public interface PageWebViewListener {
        void onWebViewReady(String str, String str2);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11105);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        TAG = PageWebview.class.getSimpleName() + "111";
    }

    public PageWebview(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.isShowShare = false;
        this.hasFLoad = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initEnableDebug() {
        if (this.apkgInfo$5475ea27.h()) {
            evaluteJs(this.apkgInfo$5475ea27.g(), null);
            c.a(this.apkgInfo$5475ea27.f245823d, true);
        } else {
            c.a(this.apkgInfo$5475ea27.f245823d, false);
        }
    }

    private void onWebViewReady$164d4c8c(com.tencent.mobileqq.microapp.a.c cVar) {
        if (StringUtil.isEmpty(this.wxssJsStr)) {
            String g16 = cVar.g(this.mRouteUrl);
            if (!TextUtils.isEmpty(g16)) {
                evaluteJs(g16);
            }
        }
        String b16 = cVar.b(this.mRouteUrl);
        if (!TextUtils.isEmpty(b16)) {
            evaluteJs(b16);
        }
        PageWebViewListener pageWebViewListener = this.listener;
        if (pageWebViewListener != null) {
            pageWebViewListener.onWebViewReady(this.openType, this.mRouteUrl);
        }
    }

    public void clearUp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            removeJavascriptInterface("WeixinJSCore");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) motionEvent)).booleanValue();
        }
        try {
            if (this.apkgInfo$5475ea27.f245821b.b(this.mRouteUrl).f245863a.f245875b) {
                int x16 = (int) motionEvent.getX();
                int y16 = (int) motionEvent.getY();
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action != 2) {
                            if (action != 3) {
                            }
                        } else {
                            int i3 = x16 - this.mLastX;
                            int i16 = y16 - this.mLastY;
                            if (Math.abs(i16) > 0 && Math.abs(i3) > 0) {
                                if (Math.abs(i16) > Math.abs(i3)) {
                                    this.swipeRefreshLayout.setEnabled(true);
                                } else {
                                    this.swipeRefreshLayout.setEnabled(false);
                                }
                            }
                        }
                    }
                    this.swipeRefreshLayout.setEnabled(true);
                } else {
                    this.swipeRefreshLayout.setEnabled(true);
                }
                this.mLastX = x16;
                this.mLastY = y16;
            }
        } catch (Exception unused) {
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        addJavascriptInterface(this, "WeixinJSCore");
        setWebChromeClient(new WebChromeClient() { // from class: com.tencent.mobileqq.microapp.appbrand.page.PageWebview.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PageWebview.this);
                }
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) consoleMessage)).booleanValue();
                }
                if (QLog.isColorLevel()) {
                    QLog.i("chromium", 2, consoleMessage.message());
                }
                return super.onConsoleMessage(consoleMessage);
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient
            public void onProgressChanged(WebView webView, int i3) {
                JsInjector.getInstance().onProgressChanged(webView, i3);
                super.onProgressChanged(webView, i3);
            }
        });
        setWebViewClient(new WebViewClient() { // from class: com.tencent.mobileqq.microapp.appbrand.page.PageWebview.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PageWebview.this);
                }
            }

            @Override // com.tencent.smtt.sdk.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) webView, (Object) str);
                    return;
                }
                super.onPageFinished(webView, str);
                if (QLog.isColorLevel()) {
                    QLog.d(PageWebview.TAG, 2, "---finish loadHtml---");
                }
                if (StringUtil.isEmpty(PageWebview.this.mWAWebviewStr)) {
                    PageWebview pageWebview = PageWebview.this;
                    pageWebview.mWAWebviewStr = pageWebview.apkgInfo$5475ea27.e();
                }
                PageWebview pageWebview2 = PageWebview.this;
                pageWebview2.evaluteJs(pageWebview2.mWAWebviewStr, new ValueCallback() { // from class: com.tencent.mobileqq.microapp.appbrand.page.PageWebview.2.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                        }
                    }

                    @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
                    public void onReceiveValue(Object obj) {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this, obj);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i(PageWebview.TAG, 2, "---load wawebview ---");
                        }
                        PageWebview.this.hasLoadHtmlFinish = true;
                        PageWebview pageWebview3 = PageWebview.this;
                        if (pageWebview3.apkgInfo$5475ea27 != null) {
                            pageWebview3.initJSGlobalConfig();
                            PageWebview.this.initEnableDebug();
                            if (StringUtil.isEmpty(PageWebview.this.mWxssJs)) {
                                PageWebview pageWebview4 = PageWebview.this;
                                pageWebview4.mWxssJs = pageWebview4.apkgInfo$5475ea27.d();
                            }
                            if (!TextUtils.isEmpty(PageWebview.this.mWxssJs)) {
                                PageWebview pageWebview5 = PageWebview.this;
                                pageWebview5.evaluteJs(pageWebview5.mWxssJs);
                            }
                            if (!StringUtil.isEmpty(PageWebview.this.wxssJsStr)) {
                                PageWebview pageWebview6 = PageWebview.this;
                                pageWebview6.evaluteJs(pageWebview6.wxssJsStr);
                            }
                            PageWebview pageWebview7 = PageWebview.this;
                            pageWebview7.loadPageWebviewJs$164d4c8c(pageWebview7.apkgInfo$5475ea27);
                        }
                    }
                });
            }

            @Override // com.tencent.smtt.sdk.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                JsInjector.getInstance().onPageStarted(webView);
                super.onPageStarted(webView, str, bitmap);
            }

            /* JADX WARN: Can't wrap try/catch for region: R(12:(14:26|(3:28|(1:30)(1:32)|31)|33|34|35|37|38|(1:40)|41|(1:43)|45|46|47|48)|34|35|37|38|(0)|41|(0)|45|46|47|48) */
            /* JADX WARN: Code restructure failed: missing block: B:50:0x013e, code lost:
            
                r13 = e;
             */
            /* JADX WARN: Code restructure failed: missing block: B:51:0x0157, code lost:
            
                r13.printStackTrace();
             */
            /* JADX WARN: Code restructure failed: missing block: B:52:0x0140, code lost:
            
                r13 = e;
             */
            /* JADX WARN: Code restructure failed: missing block: B:53:0x0147, code lost:
            
                r8 = r14;
             */
            /* JADX WARN: Code restructure failed: missing block: B:54:0x014d, code lost:
            
                r13.printStackTrace();
             */
            /* JADX WARN: Code restructure failed: missing block: B:55:0x0150, code lost:
            
                if (r8 != null) goto L119;
             */
            /* JADX WARN: Code restructure failed: missing block: B:57:0x0152, code lost:
            
                r8.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:59:0x0156, code lost:
            
                r13 = e;
             */
            /* JADX WARN: Code restructure failed: missing block: B:70:0x0145, code lost:
            
                r13 = e;
             */
            /* JADX WARN: Code restructure failed: missing block: B:71:0x0146, code lost:
            
                r0 = null;
             */
            /* JADX WARN: Removed duplicated region for block: B:40:0x011d A[Catch: UnsupportedEncodingException -> 0x0140, all -> 0x0142, TryCatch #0 {all -> 0x0142, blocks: (B:35:0x010f, B:38:0x0117, B:40:0x011d, B:41:0x0127, B:43:0x0133), top: B:34:0x010f }] */
            /* JADX WARN: Removed duplicated region for block: B:43:0x0133 A[Catch: UnsupportedEncodingException -> 0x0140, all -> 0x0142, TRY_LEAVE, TryCatch #0 {all -> 0x0142, blocks: (B:35:0x010f, B:38:0x0117, B:40:0x011d, B:41:0x0127, B:43:0x0133), top: B:34:0x010f }] */
            @Override // com.tencent.smtt.sdk.WebViewClient
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                WebResourceResponse webResourceResponse;
                int i3;
                ByteArrayInputStream byteArrayInputStream;
                int i16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    return (WebResourceResponse) iPatchRedirector2.redirect((short) 3, (Object) this, (Object) webView, (Object) webResourceRequest);
                }
                if (QLog.isColorLevel()) {
                    QLog.i("chromium", 2, "shouldInterceptRequest: " + webResourceRequest.getUrl());
                }
                if (PageWebview.this.apkgInfo$5475ea27 == null) {
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
                String uri = webResourceRequest.getUrl().toString();
                String str = "image/gif";
                String str2 = "image/png";
                ByteArrayInputStream byteArrayInputStream2 = null;
                if (uri.startsWith(PageWebview.PREF_HTML_URL)) {
                    if (uri.endsWith(".html")) {
                        f c16 = PageWebview.this.apkgInfo$5475ea27.c();
                        try {
                            try {
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        } catch (UnsupportedEncodingException e16) {
                            e = e16;
                            webResourceResponse = null;
                        }
                        try {
                            if (PageWebview.this.contentBytes != null && PageWebview.this.contentBytes.length != 0) {
                                if (QLog.isColorLevel()) {
                                    String str3 = PageWebview.TAG;
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("---get cache Html content---");
                                    if (PageWebview.this.contentBytes != null) {
                                        i16 = PageWebview.this.contentBytes.length;
                                    } else {
                                        i16 = 0;
                                    }
                                    sb5.append(i16);
                                    QLog.d(str3, 2, sb5.toString());
                                }
                                byteArrayInputStream = new ByteArrayInputStream(PageWebview.this.contentBytes, 0, PageWebview.this.contentBytes.length);
                                webResourceResponse = new WebResourceResponse("text/html", "UTF-8", byteArrayInputStream);
                                if (QLog.isColorLevel()) {
                                    QLog.d(PageWebview.TAG, 2, "---new WebResourceResponse--");
                                }
                                if (StringUtil.isEmpty(PageWebview.this.wxssJsStr)) {
                                    PageWebview.this.wxssJsStr = c16.f245853b;
                                }
                                byteArrayInputStream.close();
                                return webResourceResponse;
                            }
                            webResourceResponse = new WebResourceResponse("text/html", "UTF-8", byteArrayInputStream);
                            if (QLog.isColorLevel()) {
                            }
                            if (StringUtil.isEmpty(PageWebview.this.wxssJsStr)) {
                            }
                            byteArrayInputStream.close();
                            return webResourceResponse;
                        } catch (Throwable th6) {
                            th = th6;
                            byteArrayInputStream2 = byteArrayInputStream;
                            if (byteArrayInputStream2 != null) {
                                try {
                                    byteArrayInputStream2.close();
                                } catch (IOException e17) {
                                    e17.printStackTrace();
                                }
                            }
                            throw th;
                        }
                        PageWebview.this.contentBytes = c16.f245852a.getBytes("UTF-8");
                        if (QLog.isColorLevel()) {
                            String str4 = PageWebview.TAG;
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("---get new Html content ---");
                            if (PageWebview.this.contentBytes != null) {
                                i3 = PageWebview.this.contentBytes.length;
                            } else {
                                i3 = 0;
                            }
                            sb6.append(i3);
                            QLog.d(str4, 2, sb6.toString());
                        }
                        byteArrayInputStream = new ByteArrayInputStream(PageWebview.this.contentBytes, 0, PageWebview.this.contentBytes.length);
                    } else {
                        if (!uri.endsWith(".png") && !uri.endsWith(".jpg")) {
                            if (!uri.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END) && !uri.endsWith(".svg")) {
                                return null;
                            }
                            String substring = uri.substring(26);
                            if (!uri.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END)) {
                                str = "image/svg+xml";
                            }
                            return new WebResourceResponse(str, "UTF-8", com.tencent.mobileqq.microapp.a.c.r(PageWebview.this.apkgInfo$5475ea27.j(substring)));
                        }
                        String substring2 = uri.substring(26);
                        if (!uri.endsWith(".png")) {
                            str2 = ImageContentType.MIME_TYPE_JPG;
                        }
                        return new WebResourceResponse(str2, "UTF-8", com.tencent.mobileqq.microapp.a.c.s(PageWebview.this.apkgInfo$5475ea27.j(substring2)));
                    }
                } else {
                    if (uri.startsWith("wxfile://")) {
                        if (!uri.endsWith(".png") && !uri.endsWith(".jpg")) {
                            if (!uri.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END) && !uri.endsWith(".svg")) {
                                return null;
                            }
                            if (!uri.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END)) {
                                str = "image/svg+xml";
                            }
                            return new WebResourceResponse(str, "UTF-8", com.tencent.mobileqq.microapp.a.c.r(b.a().c(uri)));
                        }
                        if (!uri.endsWith(".png")) {
                            str2 = ImageContentType.MIME_TYPE_JPG;
                        }
                        return new WebResourceResponse(str2, "UTF-8", com.tencent.mobileqq.microapp.a.c.s(b.a().c(uri)));
                    }
                    return super.shouldInterceptRequest(webView, uri);
                }
            }

            @Override // com.tencent.smtt.sdk.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) webView, (Object) webResourceRequest)).booleanValue();
                }
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
        });
    }

    @JavascriptInterface
    public String invokeHandler(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, this, str, str2, Integer.valueOf(i3));
        }
        WebViewEventListener webViewEventListener = this.eventListener;
        if (webViewEventListener != null) {
            return webViewEventListener.onWebViewNativeRequest(str, str2, this, i3);
        }
        return "";
    }

    public void loadHtml() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "---start loadHtml---");
        }
        loadUrl("https://servicewechat.com/page-frame.html");
    }

    public void loadPageWebviewJs$164d4c8c(com.tencent.mobileqq.microapp.a.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) cVar);
            return;
        }
        if (!StringUtil.isEmpty(this.mRouteUrl) && !this.hasFLoad && this.hasLoadHtmlFinish) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "----loadPageWebviewJs----");
            }
            onWebViewReady$164d4c8c(cVar);
            this.hasFLoad = true;
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onScrollChanged(i3, i16, i17, i18);
        OnWebviewScrollListener onWebviewScrollListener = this.onWebviewScrollListener;
        if (onWebviewScrollListener != null) {
            onWebviewScrollListener.onVerticalScroll(i16);
        }
        this.scrollY = i16;
    }

    @JavascriptInterface
    public void publishHandler(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, str2, str3);
            return;
        }
        WebViewEventListener webViewEventListener = this.eventListener;
        if (webViewEventListener != null) {
            webViewEventListener.onWebViewEvent(str, str2, str3, this.apkgInfo$5475ea27.f245823d, this.pageWebviewId);
        }
    }

    public void setOnWebviewScrollListener(OnWebviewScrollListener onWebviewScrollListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) onWebviewScrollListener);
        } else {
            this.onWebviewScrollListener = onWebviewScrollListener;
        }
    }

    public PageWebview(Context context, a aVar, com.tencent.mobileqq.microapp.a.c cVar, String str, String str2, PageWebViewListener pageWebViewListener, WebViewEventListener webViewEventListener) {
        super(context, cVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, aVar, cVar, str, str2, pageWebViewListener, webViewEventListener);
            return;
        }
        this.isShowShare = false;
        this.hasFLoad = false;
        this.appBrandRuntime = aVar;
        this.mContext = context;
        this.mRouteUrl = str;
        this.openType = str2;
        this.listener = pageWebViewListener;
        this.eventListener = webViewEventListener;
        init();
    }
}
