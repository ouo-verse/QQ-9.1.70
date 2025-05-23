package com.tencent.luggage.wxa.kj;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.http.SslError;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.qimei.webview.QmWebview;
import java.net.URL;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j0 extends QmWebview implements o0 {

    /* renamed from: a, reason: collision with root package name */
    public String f132217a;

    /* renamed from: b, reason: collision with root package name */
    public b0 f132218b;

    /* renamed from: c, reason: collision with root package name */
    public f0 f132219c;

    /* renamed from: d, reason: collision with root package name */
    public d0 f132220d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.wj.d f132221e;

    /* renamed from: f, reason: collision with root package name */
    public Animator f132222f;

    /* renamed from: g, reason: collision with root package name */
    public WebViewClient f132223g;

    /* renamed from: h, reason: collision with root package name */
    public WebChromeClient f132224h;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f132225a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ValueCallback f132226b;

        public a(String str, ValueCallback valueCallback) {
            this.f132225a = str;
            this.f132226b = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.super.evaluateJavascript(this.f132225a, this.f132226b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            j0.this.getContentView().setScrollY(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d extends WebChromeClient {
        public d() {
        }
    }

    public j0(Context context, b0 b0Var) {
        super(context);
        this.f132223g = new c();
        this.f132224h = new d();
        this.f132218b = b0Var;
        u();
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public boolean A() {
        if (getWebScrollY() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public com.tencent.luggage.wxa.ei.k a(Class cls) {
        return null;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void c(Runnable runnable) {
        if (runnable != null) {
            postOnAnimation(runnable);
        }
    }

    @Override // android.webkit.WebView, com.tencent.luggage.wxa.kj.o0, com.tencent.luggage.wxa.ei.j
    public void destroy() {
        super.destroy();
    }

    @Override // android.webkit.WebView, com.tencent.luggage.wxa.ei.p
    public void evaluateJavascript(String str, ValueCallback valueCallback) {
        a aVar = new a(str, valueCallback);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            aVar.run();
        } else {
            com.tencent.luggage.wxa.tn.c0.a(aVar);
        }
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public com.tencent.luggage.wxa.wj.d getFullscreenImpl() {
        return this.f132221e;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public /* bridge */ /* synthetic */ v getPageView() {
        return b31.l.a(this);
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public String getUserAgentString() {
        return this.f132217a;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public int getWebScrollX() {
        return getScrollX();
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public int getWebScrollY() {
        return getScrollY();
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void onBackground() {
        super.onPause();
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void onForeground() {
        super.onResume();
    }

    @Override // android.widget.AbsoluteLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        d0 d0Var = this.f132220d;
        if (d0Var != null) {
            d0Var.a(z16, i3, i16, i17, i18);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i3, int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
        f0 f0Var = this.f132219c;
        if (f0Var != null) {
            f0Var.onScrollChanged(i3, i16, i17, i18, this);
        }
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setAppBrandWebViewClient(b0 b0Var) {
        this.f132218b = b0Var;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public /* bridge */ /* synthetic */ void setDisableContextMenuItems(int i3) {
        b31.l.c(this, i3);
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setFullscreenImpl(com.tencent.luggage.wxa.wj.d dVar) {
        this.f132221e = dVar;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setOnScrollChangedListener(f0 f0Var) {
        this.f132219c = f0Var;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setWebViewLayoutListener(d0 d0Var) {
        this.f132220d = d0Var;
    }

    public final void u() {
        getSettings().setDomStorageEnabled(true);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setMediaPlaybackRequiresUserGesture(false);
        getSettings().setMixedContentMode(0);
        getSettings().setUserAgentString(getSettings().getUserAgentString() + "/ DEMO");
        this.f132217a = getSettings().getUserAgentString();
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWebViewClient(this.f132223g);
        setWebChromeClient(this.f132224h);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public boolean x() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void z() {
        super.scrollTo(getScrollX(), 0);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c extends WebViewClient {
        public c() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            j0.this.f132218b.b(str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            j0.this.f132218b.c(str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (sslError.getPrimaryError() == 3) {
                if (j0.this.f132218b.a(sslError.getCertificate())) {
                    sslErrorHandler.proceed();
                    return;
                } else {
                    sslErrorHandler.cancel();
                    return;
                }
            }
            sslErrorHandler.cancel();
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (com.tencent.luggage.wxa.tn.w0.c(str)) {
                return null;
            }
            return j0.this.f132218b.a(str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return true;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (webResourceRequest == null || webResourceRequest.getUrl() == null || com.tencent.luggage.wxa.tn.w0.c(webResourceRequest.getUrl().toString())) {
                return null;
            }
            return j0.this.f132218b.a(webResourceRequest.getUrl().toString());
        }
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void a(int i3, int i16) {
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void a(Context context) {
        if (getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) getContext()).setBaseContext(context);
        }
    }

    public j0(Context context) {
        this(context, null);
    }

    @Override // com.tencent.luggage.wxa.hp.a
    public boolean a(Canvas canvas) {
        draw(canvas);
        return true;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void a(String str, String str2) {
        super.loadDataWithBaseURL(str, str2, "text/html", "UTF-8", null);
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void a(URL url, String str, ValueCallback valueCallback) {
        evaluateJavascript(str, valueCallback);
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void a(URL url, String str, String str2, int i3, String str3, ValueCallback valueCallback) {
        evaluateJavascript(str3, valueCallback);
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void a(int i3, long j3) {
        Animator animator = this.f132222f;
        if (animator != null) {
            animator.cancel();
            this.f132222f = null;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(getContentView().getScrollY(), i3);
        ofInt.addUpdateListener(new b());
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(j3);
        ofInt.start();
        this.f132222f = ofInt;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public View getContentView() {
        return this;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public View getWrapperView() {
        return this;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setAppBrandInfo(Map<String, String> map) {
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void setJsExceptionHandler(com.tencent.luggage.wxa.ei.i iVar) {
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setOnTrimListener(e0 e0Var) {
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setXWebKeyboardImpl(h0 h0Var) {
    }
}
