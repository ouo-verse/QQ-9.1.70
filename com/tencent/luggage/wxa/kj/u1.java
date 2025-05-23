package com.tencent.luggage.wxa.kj;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import com.tencent.luggage.wxa.kj.u1;
import com.tencent.luggage.wxa.tk.n;
import com.tencent.xweb.SslErrorHandler;
import com.tencent.xweb.WebChromeClient;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebViewCallbackClient;
import com.tencent.xweb.WebViewClient;
import com.tencent.xweb.XWebSdk;
import com.tencent.xweb.internal.ProxyWebViewClientExtension;
import java.net.URL;
import java.util.LinkedList;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public class u1 extends WebView implements o0, com.tencent.luggage.wxa.z7.d, com.tencent.luggage.wxa.mj.f {
    public e0 C;
    public b0 D;
    public com.tencent.luggage.wxa.wj.d E;
    public Animator F;
    public boolean G;
    public boolean H;
    public String I;
    public String J;
    public com.tencent.luggage.wxa.m8.c K;
    public boolean L;
    public h0 M;
    public final LinkedList N;
    public WebViewClient O;
    public WebChromeClient P;
    public WebViewCallbackClient Q;
    public ProxyWebViewClientExtension R;
    public Boolean S;

    /* renamed from: l, reason: collision with root package name */
    public f0 f132428l;

    /* renamed from: m, reason: collision with root package name */
    public d0 f132429m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends ProxyWebViewClientExtension {
        public a() {
        }

        @Override // com.tencent.xweb.internal.ProxyWebViewClientExtension
        public Object onMiscCallBack(String str, Bundle bundle) {
            if (!com.tencent.luggage.wxa.tn.w0.c(str) && bundle != null) {
                com.tencent.luggage.wxa.tn.w.d("Luggage.XWebViewImpl", "onMiscCallBack method = %s", str);
                if ("onJavascriptCloseWindow".equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements View.OnLongClickListener {
        public b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements DownloadListener {
        public c() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j3) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.XWebViewImpl", "onDownloadStart called, url = %s, mimeType = %s, userAgent = %s", str, str4, str2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d extends h0 {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.kj.h0
        public com.tencent.luggage.wxa.xd.f a() {
            if (u1.this.M != null) {
                return u1.this.M.a();
            }
            return null;
        }

        @Override // com.tencent.luggage.wxa.kj.h0
        public com.tencent.luggage.wxa.xd.d b() {
            if (u1.this.M != null) {
                return u1.this.M.b();
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f132434a;

        public e(Map map) {
            this.f132434a = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            u1.super.getSettings().setAppBrandInfo(this.f132434a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f132436a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ValueCallback f132437b;

        public f(String str, ValueCallback valueCallback) {
            this.f132436a = str;
            this.f132437b = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            u1.this.c(this.f132436a, this.f132437b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        public g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            u1.this.getView().setScrollY(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i extends WebChromeClient {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements WebChromeClient.CustomViewCallback {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ WebChromeClient.CustomViewCallback f132442a;

            public a(WebChromeClient.CustomViewCallback customViewCallback) {
                this.f132442a = customViewCallback;
            }

            @Override // android.webkit.WebChromeClient.CustomViewCallback
            public void onCustomViewHidden() {
                if (u1.this.hasEnteredFullscreen()) {
                    com.tencent.luggage.wxa.tn.w.d("Luggage.XWebViewImpl", "WebChromeClient leaveFullscreen");
                    u1.this.leaveFullscreen();
                }
                WebChromeClient.CustomViewCallback customViewCallback = this.f132442a;
                if (customViewCallback != null) {
                    customViewCallback.onCustomViewHidden();
                }
            }
        }

        public i() {
        }

        @Override // com.tencent.xweb.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (consoleMessage != null && u1.this.D != null) {
                u1.this.D.a(consoleMessage);
            }
            return super.onConsoleMessage(consoleMessage);
        }

        @Override // com.tencent.xweb.WebChromeClient
        public boolean onEnterFullscreen(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            com.tencent.luggage.wxa.tn.w.f("Luggage.XWebViewImpl", "WebChromeClient onEnterFullscreen");
            if (u1.this.isXWalkKernel()) {
                if (u1.this.E != null) {
                    u1.this.E.a(new a(customViewCallback));
                    return true;
                }
                return true;
            }
            return super.onEnterFullscreen(view, customViewCallback);
        }

        @Override // com.tencent.xweb.WebChromeClient
        public boolean onExitFullscreen() {
            com.tencent.luggage.wxa.tn.w.f("Luggage.XWebViewImpl", "WebChromeClient onExitFullscreen");
            if (u1.this.isXWalkKernel()) {
                u1.this.post(new Runnable() { // from class: b31.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        u1.i.this.a();
                    }
                });
                return true;
            }
            return super.onExitFullscreen();
        }

        @Override // com.tencent.xweb.WebChromeClient
        public void onHideCustomView() {
            try {
                if (u1.this.E != null) {
                    u1.this.E.c();
                }
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.XWebViewImpl", "onHideCustomView error " + e16.getMessage());
            }
        }

        @Override // com.tencent.xweb.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            try {
                if (u1.this.E != null) {
                    u1.this.E.a(view, 90);
                    u1.this.E.a(customViewCallback);
                }
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.XWebViewImpl", "onShowCustomView error " + e16.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            if (u1.this.E != null) {
                u1.this.E.c();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class k implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f132445a;

        public /* synthetic */ k(u1 u1Var, Runnable runnable, b bVar) {
            this(runnable);
        }

        @Override // java.lang.Runnable
        public void run() {
            u1.this.N.remove(this);
            this.f132445a.run();
        }

        public k(Runnable runnable) {
            this.f132445a = runnable;
            u1.this.N.add(this);
        }
    }

    static {
        XWebSdk.initWebviewCore(com.tencent.luggage.wxa.tn.z.c(), WebView.sDefaultWebViewKind, "appbrand", null);
    }

    public u1(Context context) {
        super(new MutableContextWrapper(context));
        this.f132429m = null;
        this.G = false;
        this.H = false;
        this.L = false;
        this.N = new LinkedList();
        this.O = new h();
        this.P = new i();
        this.Q = new j();
        this.R = new a();
        this.S = null;
        this.D = null;
        G();
    }

    public static void setWebContentsDebuggingEnabled(boolean z16) {
        try {
            XWebSdk.setEnableRemoteDebug(z16);
        } catch (Throwable unused) {
        }
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public boolean A() {
        if (isXWalkKernel() && XWalkEnvironment.getAvailableVersion() >= 472) {
            return isOverScrollStart();
        }
        if (getWebScrollY() == 0) {
            return true;
        }
        return false;
    }

    public final void F() {
        com.tencent.luggage.wxa.tn.w.d("Luggage.XWebViewImpl", "fireAllPendingReRenderedTasks size=%d", Integer.valueOf(this.N.size()));
        while (!this.N.isEmpty()) {
            ((k) this.N.pollFirst()).run();
        }
    }

    public final void G() {
        getSettings().setDomStorageEnabled(true);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setMediaPlaybackRequiresUserGesture(false);
        getSettings().setMixedContentMode(0);
        this.J = getSettings().getUserAgentString();
        getSettings().setUserAgentString(com.tencent.luggage.wxa.tk.n.a(getContext(), getSettings().getUserAgentString(), (n.a) com.tencent.luggage.wxa.h1.e.a(n.a.class)));
        this.I = getSettings().getUserAgentString();
        getSettings().setTextZoom(100);
        getView().setHorizontalScrollBarEnabled(false);
        getView().setVerticalScrollBarEnabled(false);
        setWebViewClient(this.O);
        setWebChromeClient(this.P);
        setWebViewCallbackClient(this.Q);
        setWebViewClientExtension(this.R);
        getSettings().setUsingForAppBrand(1);
        H();
        setBackgroundColor(0);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setOnLongClickListener(new b());
        setDownloadListener(new c());
    }

    public final void H() {
        this.K = com.tencent.luggage.wxa.z7.f.a(this, com.tencent.luggage.wxa.m8.e.a(), com.tencent.luggage.wxa.k8.d.a(), new d());
    }

    @Override // com.tencent.xweb.WebView, com.tencent.xweb.internal.IWebView
    public Bitmap captureBitmap() {
        return super.captureBitmap();
    }

    @Override // com.tencent.xweb.WebView, com.tencent.xweb.internal.IWebView
    public void destroy() {
        if (this.H) {
            return;
        }
        F();
        try {
            super.destroy();
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("Luggage.XWebViewImpl", e16, "[CAUGHT CRASH]", new Object[0]);
        }
        Animator animator = this.F;
        if (animator != null) {
            animator.cancel();
            this.F = null;
        }
        com.tencent.luggage.wxa.wj.d dVar = this.E;
        if (dVar != null) {
            dVar.a((WebChromeClient.CustomViewCallback) null);
            this.E.release();
        }
        this.E = null;
        try {
            a(getContext().getApplicationContext());
        } catch (Exception unused) {
        }
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
        this.H = true;
        com.tencent.luggage.wxa.tn.w.d("Luggage.XWebViewImpl", "destroyed hash[%d]", Integer.valueOf(hashCode()));
    }

    @Override // com.tencent.xweb.WebView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (Exception unused) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.XWebViewImpl", "dispatchDraw %s", Log.getStackTraceString(new Throwable()));
        }
    }

    @Override // com.tencent.xweb.WebView, com.tencent.xweb.internal.IWebView
    public void evaluateJavascript(String str, ValueCallback valueCallback) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            c(str, valueCallback);
        } else {
            com.tencent.luggage.wxa.tn.c0.a(new f(str, valueCallback));
        }
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public View getContentView() {
        return super.getView();
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public com.tencent.luggage.wxa.wj.d getFullscreenImpl() {
        return this.E;
    }

    public String getOriginUserAgent() {
        return this.J;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public /* bridge */ /* synthetic */ v getPageView() {
        return b31.l.a(this);
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public String getUserAgentString() {
        return this.I;
    }

    @Override // com.tencent.luggage.wxa.z7.d
    public com.tencent.luggage.wxa.m8.c getWebViewPluginClientProxy() {
        return this.K;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        try {
            super.onAttachedToWindow();
        } catch (SecurityException unused) {
        }
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void onBackground() {
        onPause();
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void onForeground() {
        onResume();
    }

    @Override // com.tencent.xweb.WebView, com.tencent.xweb.internal.IWebView
    public final void onHide() {
        if (this.L) {
            return;
        }
        super.onHide();
        this.L = true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        d0 d0Var = this.f132429m;
        if (d0Var != null) {
            d0Var.a(z16, i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.xweb.WebView, com.tencent.xweb.internal.IWebView
    public final void onShow() {
        super.onShow();
        this.L = false;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setAppBrandInfo(Map<String, String> map) {
        e eVar = new e(map);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            eVar.run();
        } else {
            com.tencent.luggage.wxa.tn.c0.a(eVar);
        }
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setAppBrandWebViewClient(b0 b0Var) {
        this.D = b0Var;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public /* bridge */ /* synthetic */ void setDisableContextMenuItems(int i3) {
        b31.l.c(this, i3);
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setFullscreenImpl(com.tencent.luggage.wxa.wj.d dVar) {
        this.E = dVar;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setOnScrollChangedListener(f0 f0Var) {
        this.f132428l = f0Var;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setOnTrimListener(e0 e0Var) {
        this.C = e0Var;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setWebViewLayoutListener(d0 d0Var) {
        this.f132429m = d0Var;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setXWebKeyboardImpl(h0 h0Var) {
        this.M = h0Var;
    }

    @Override // com.tencent.luggage.wxa.mj.f
    public final void t() {
        onShow();
    }

    @Override // com.tencent.luggage.wxa.mj.f
    public final void v() {
        onHide();
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public boolean x() {
        Boolean bool = this.S;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean valueOf = Boolean.valueOf(XWebSdk.getEnableRemoteDebug());
            this.S = valueOf;
            return valueOf.booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void z() {
        getView().scrollTo(getView().getScrollX(), 0);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h extends WebViewClient {
        public h() {
        }

        @Override // com.tencent.xweb.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            u1.this.D.b(str);
        }

        @Override // com.tencent.xweb.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            u1.this.D.c(str);
        }

        @Override // com.tencent.xweb.WebViewClient
        public void onReceivedError(WebView webView, int i3, String str, String str2) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.XWebViewImpl", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", Integer.valueOf(i3), str, str2);
        }

        @Override // com.tencent.xweb.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            String uri;
            Uri url = webResourceRequest.getUrl();
            if (url == null) {
                uri = "null";
            } else {
                uri = url.toString();
            }
            com.tencent.luggage.wxa.tn.w.b("Luggage.XWebViewImpl", "onReceivedHttpError, WebResourceRequest url = %s, ErrWebResourceResponse mimeType = %s, status = %d", uri, webResourceResponse.getMimeType(), Integer.valueOf(webResourceResponse.getStatusCode()));
        }

        @Override // com.tencent.xweb.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (sslError.getPrimaryError() == 3) {
                if (u1.this.D.a(sslError.getCertificate())) {
                    sslErrorHandler.proceed();
                    return;
                } else {
                    sslErrorHandler.cancel();
                    return;
                }
            }
            sslErrorHandler.cancel();
        }

        @Override // com.tencent.xweb.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (com.tencent.luggage.wxa.tn.w0.c(str)) {
                return null;
            }
            return u1.this.d(str);
        }

        @Override // com.tencent.xweb.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.XWebViewImpl", "shouldOverrideUrlLoading, url = %s", str);
            return true;
        }

        @Override // com.tencent.xweb.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (webResourceRequest == null || webResourceRequest.getUrl() == null || com.tencent.luggage.wxa.tn.w0.c(webResourceRequest.getUrl().toString())) {
                return null;
            }
            return u1.this.d(webResourceRequest.getUrl().toString());
        }

        @Override // com.tencent.xweb.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
            if (webResourceRequest == null || webResourceRequest.getUrl() == null || com.tencent.luggage.wxa.tn.w0.c(webResourceRequest.getUrl().toString())) {
                return null;
            }
            return u1.this.d(webResourceRequest.getUrl().toString());
        }
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void c(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (this.H) {
            com.tencent.luggage.wxa.tn.w.h("Luggage.XWebViewImpl", "postOnReRendered webview destroyed, stack=%s", Log.getStackTraceString(new Throwable()));
            return;
        }
        k kVar = new k(this, runnable, null);
        if (isXWalkKernel()) {
            postDelayed(kVar, 200L);
        } else {
            postOnAnimation(kVar);
        }
    }

    public final WebResourceResponse d(String str) {
        return a(this.D.a(str));
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void a(Context context) {
        if (getContext() instanceof MutableContextWrapper) {
            MutableContextWrapper mutableContextWrapper = (MutableContextWrapper) getContext();
            if (mutableContextWrapper.getBaseContext() == context) {
                return;
            }
            mutableContextWrapper.setBaseContext(context);
        }
    }

    @Override // com.tencent.luggage.wxa.hp.a
    public boolean a(Canvas canvas) {
        if (isXWalkKernel()) {
            drawCanvas(canvas);
            return true;
        }
        draw(canvas);
        return true;
    }

    public final void c(String str, ValueCallback valueCallback) {
        try {
            super.evaluateJavascript(str, valueCallback);
        } catch (IllegalStateException e16) {
            com.tencent.luggage.wxa.tn.w.h("Luggage.XWebViewImpl", "evaluateJavascript get exception:%s", e16);
        }
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void a(String str, String str2) {
        this.G = false;
        super.loadDataWithBaseURL(str, str2, "text/html", "UTF-8", null);
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void a(int i3, int i16) {
        if (supportSetWebContentsSize()) {
            setWebContentsSize(i3, i16);
        }
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void a(URL url, String str, ValueCallback valueCallback) {
        evaluateJavascript(str, valueCallback);
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void a(URL url, String str, String str2, int i3, String str3, ValueCallback valueCallback) {
        evaluateJavascript(str3, valueCallback);
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public final com.tencent.luggage.wxa.ei.k a(Class cls) {
        if (cls == com.tencent.luggage.wxa.mj.f.class) {
            if (supportFeature(1040)) {
                return (com.tencent.luggage.wxa.ei.k) cls.cast(this);
            }
            return null;
        }
        if (cls.isInstance(this)) {
            return (com.tencent.luggage.wxa.ei.k) cls.cast(this);
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void a(int i3, long j3) {
        Animator animator = this.F;
        if (animator != null) {
            animator.cancel();
            this.F = null;
        }
        if (super.supportFeature(2005)) {
            super.smoothScroll(getWebScrollX(), i3, j3);
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(getView().getScrollY(), i3);
        ofInt.addUpdateListener(new g());
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(j3);
        ofInt.start();
        this.F = ofInt;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public View getWrapperView() {
        return this;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class j implements WebViewCallbackClient {
        public j() {
        }

        @Override // com.tencent.xweb.WebViewCallbackClient
        public void onScrollChanged(int i3, int i16, int i17, int i18, View view) {
            if (u1.this.f132428l != null) {
                u1.this.f132428l.onScrollChanged(i3, i16, i17, i18, view);
            }
            u1.this.D.a(i3, i16, i17, i18, view);
        }

        @Override // com.tencent.xweb.WebViewCallbackClient
        public boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16, View view) {
            return false;
        }

        @Override // com.tencent.xweb.WebViewCallbackClient
        public void onContentHeightChanged(int i3) {
        }

        @Override // com.tencent.xweb.WebViewCallbackClient
        public void onOverScrolled(int i3, int i16, boolean z16, boolean z17, View view) {
        }
    }

    public final WebResourceResponse a(android.webkit.WebResourceResponse webResourceResponse) {
        if (webResourceResponse == null) {
            return null;
        }
        return new WebResourceResponse(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), webResourceResponse.getResponseHeaders(), webResourceResponse.getData());
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void setJsExceptionHandler(com.tencent.luggage.wxa.ei.i iVar) {
    }
}
