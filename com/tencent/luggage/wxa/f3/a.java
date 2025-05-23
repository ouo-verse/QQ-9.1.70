package com.tencent.luggage.wxa.f3;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.tencent.libra.util.ImageContentType;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.f3.a;
import com.tencent.luggage.wxa.h6.o;
import com.tencent.luggage.wxa.hn.w8;
import com.tencent.luggage.wxa.k6.f;
import com.tencent.luggage.wxa.k6.m;
import com.tencent.luggage.wxa.ol.q;
import com.tencent.luggage.wxa.ol.x;
import com.tencent.luggage.wxa.rc.r;
import com.tencent.luggage.wxa.tk.n;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.uk.l0;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.luggage.wxa.xd.p;
import com.tencent.mobileqq.R;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebChromeClient;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebViewClient;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends FrameLayout implements com.tencent.luggage.wxa.lh.a {
    public Map C;
    public int D;
    public final AtomicBoolean E;
    public String F;
    public final Set G;
    public boolean H;
    public final Function2 I;
    public x J;
    public final x.i K;
    public boolean L;
    public final WebViewClient M;
    public final com.tencent.luggage.wxa.k6.g N;

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.m6.d f125198a;

    /* renamed from: b, reason: collision with root package name */
    public String f125199b;

    /* renamed from: c, reason: collision with root package name */
    public m f125200c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.luggage.wxa.il.m f125201d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.m4.b f125202e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.f3.b f125203f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.mj.g f125204g;

    /* renamed from: h, reason: collision with root package name */
    public int f125205h;

    /* renamed from: i, reason: collision with root package name */
    public String f125206i;

    /* renamed from: j, reason: collision with root package name */
    public String f125207j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f125208k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f125209l;

    /* renamed from: m, reason: collision with root package name */
    public final LinkedList f125210m;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.f3.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6184a implements Function2 {
        public C6184a() {
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(String str, String str2) {
            boolean remove;
            com.tencent.luggage.wxa.er.a.b(c0.b());
            if (!TextUtils.isEmpty(str2)) {
                if (a.this.L) {
                    return Unit.INSTANCE;
                }
                if (TextUtils.isEmpty(str)) {
                    remove = false;
                } else {
                    remove = a.this.G.remove(str);
                }
                w.d("Luggage.STANDALONE.AppBrandHTMLWebView", "getA8KeyCallback loadUrl, req[%s]->new[%s], ignored[%b]", str, str2, Boolean.valueOf(remove));
                if (remove) {
                    return Unit.INSTANCE;
                }
                a.this.f125200c.stopLoading();
                a.this.c(str2);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements x.i {

        /* renamed from: a, reason: collision with root package name */
        public int f125212a = 0;

        public b() {
        }

        @Override // com.tencent.luggage.wxa.ol.x.i
        public void a(int i3) {
            this.f125212a = i3;
        }

        @Override // com.tencent.luggage.wxa.ol.x.i
        public int getHeight() {
            return this.f125212a;
        }

        @Override // com.tencent.luggage.wxa.ol.x.i
        public void a(boolean z16) {
            a.this.f125203f.a(z16, this.f125212a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c extends m {
        public boolean D;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.f3.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6185a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f125214a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ValueCallback f125215b;

            public RunnableC6185a(String str, ValueCallback valueCallback) {
                this.f125214a = str;
                this.f125215b = valueCallback;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.evaluateJavascript(this.f125214a, this.f125215b);
            }
        }

        public c(Context context) {
            super(context);
            this.D = false;
        }

        @Override // com.tencent.luggage.wxa.k6.m, com.tencent.xweb.WebView, com.tencent.xweb.internal.IWebView
        public void destroy() {
            if (this.D) {
                return;
            }
            if (getWebChromeClient() instanceof com.tencent.luggage.wxa.k6.g) {
                ((com.tencent.luggage.wxa.k6.g) getWebChromeClient()).a();
            }
            w.d("Luggage.STANDALONE.AppBrandHTMLWebView", "webview destroy hash[%d]", Integer.valueOf(a.this.hashCode()));
            super.destroy();
            this.D = true;
        }

        @Override // com.tencent.xweb.WebView, com.tencent.xweb.internal.IWebView
        public void evaluateJavascript(String str, ValueCallback valueCallback) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                super.evaluateJavascript(str, valueCallback);
            } else {
                com.tencent.luggage.wxa.zp.h.f146825d.a(new RunnableC6185a(str, valueCallback));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements g.c {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.xd.g.c
        public void onDestroy() {
            a.this.a();
            if (a.this.f125198a != null) {
                a.this.f125198a.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements com.tencent.luggage.wxa.k6.f {
        public e() {
        }

        @Override // com.tencent.luggage.wxa.k6.f
        public /* synthetic */ void a() {
            y21.a.a(this);
        }

        @Override // com.tencent.luggage.wxa.k6.h
        public /* synthetic */ boolean b() {
            return y21.b.c(this);
        }

        @Override // com.tencent.luggage.wxa.k6.h
        public int c() {
            if (((com.tencent.luggage.wxa.qj.a) a.this.getPageView().a(com.tencent.luggage.wxa.qj.a.class)).f138885c) {
                return 55;
            }
            return 49;
        }

        @Override // com.tencent.luggage.wxa.k6.h
        public String d() {
            return a.this.getPageView().getAppId();
        }

        @Override // com.tencent.luggage.wxa.k6.f
        public f.a e() {
            return f.a.WEAPP;
        }

        @Override // com.tencent.luggage.wxa.k6.h
        public boolean f() {
            return true;
        }

        @Override // com.tencent.luggage.wxa.k6.f
        public String g() {
            return a.this.f125200c.getUrl();
        }

        @Override // com.tencent.luggage.wxa.k6.h
        public /* synthetic */ void a(WebView webView, String str) {
            y21.b.a(this, webView, str);
        }

        @Override // com.tencent.luggage.wxa.k6.h
        public /* synthetic */ void a(WebView webView, String str, Bitmap bitmap) {
            y21.b.b(this, webView, str, bitmap);
        }

        @Override // com.tencent.luggage.wxa.k6.f
        public /* synthetic */ void a(String str, w8 w8Var) {
            y21.a.b(this, str, w8Var);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f125219a;

        public f(String str) {
            this.f125219a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a(this.f125219a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.L) {
                w.d("Luggage.STANDALONE.AppBrandHTMLWebView", "destroy hash[%d]", Integer.valueOf(a.this.hashCode()));
                a.this.f125210m.clear();
                a.this.f125200c.stopLoading();
                a.this.f125200c.destroy();
                a.this.f125203f.e();
                a.this.L = true;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h extends WebViewClient {
        public h() {
        }

        public final WebResourceResponse a(String str) {
            v absoluteFile;
            if (!com.tencent.luggage.wxa.m6.d.a(str)) {
                return new WebResourceResponse("image/*", "utf-8", new ByteArrayInputStream(new byte[0]));
            }
            r fileSystem = a.this.f125203f.getFileSystem();
            if (fileSystem != null && (absoluteFile = fileSystem.getAbsoluteFile(str, false)) != null) {
                try {
                    return new WebResourceResponse("", "", com.tencent.luggage.wxa.cp.x.a(absoluteFile));
                } catch (FileNotFoundException unused) {
                }
            }
            return null;
        }

        @Override // com.tencent.xweb.WebViewClient
        public void doUpdateVisitedHistory(WebView webView, String str, boolean z16) {
            w.d("Luggage.STANDALONE.AppBrandHTMLWebView", "doUpdateVisitedHistory url(%s)", str);
            super.doUpdateVisitedHistory(webView, str, z16);
            a.this.f125198a.c(webView, str, a.this.I);
            a.this.b(str);
        }

        @Override // com.tencent.xweb.WebViewClient
        public void onPageCommitVisible(WebView webView, String str) {
            w.d("Luggage.STANDALONE.AppBrandHTMLWebView", "onPageCommitVisible url(%s)", str);
            a.this.d(str);
            a.this.f125198a.a(webView, str);
        }

        @Override // com.tencent.xweb.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            w.d("Luggage.STANDALONE.AppBrandHTMLWebView", "onPageFinished hash:%d, url:%s", Integer.valueOf(a.this.hashCode()), str);
            a.this.e(str);
            w.d("Luggage.STANDALONE.AppBrandHTMLWebView", "onPageFinished: " + str);
            a.this.f125198a.b(webView, str);
        }

        @Override // com.tencent.xweb.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            w.d("Luggage.STANDALONE.AppBrandHTMLWebView", "onPageStarted hash:%d, url:%s", Integer.valueOf(a.this.hashCode()), str);
            if (!URLUtil.isAboutUrl(str)) {
                a.this.a(str, bitmap);
                a.this.f125198a.b(webView, str, a.this.I);
            } else {
                a.this.f125200c.stopLoading();
            }
        }

        @Override // com.tencent.xweb.WebViewClient
        public void onReceivedError(WebView webView, int i3, String str, String str2) {
            a.this.a(str2, i3, str);
        }

        @Override // com.tencent.xweb.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            return a(str);
        }

        @Override // com.tencent.xweb.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (webResourceRequest != null && webResourceRequest.getUrl() != null) {
                String uri = webResourceRequest.getUrl().toString();
                if (com.tencent.luggage.wxa.m6.d.a(uri)) {
                    if (a.this.f125198a.d(webView, uri, a.this.I)) {
                        w.d("Luggage.STANDALONE.AppBrandHTMLWebView", "shouldOverrideUrlLoading url(%s) intercepted by geta8key", uri);
                        return true;
                    }
                } else {
                    w.b("Luggage.STANDALONE.AppBrandHTMLWebView", "shouldOverrideUrlLoading invalid url(%s)", uri);
                    return true;
                }
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        @Override // com.tencent.xweb.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
                return null;
            }
            try {
                a.this.getHTMLResourceLoadReporter().a(a.this.getPageView(), a.this.getUrl(), new com.tencent.luggage.wxa.fm.a(webResourceRequest));
            } catch (Exception e16) {
                w.a("Luggage.STANDALONE.AppBrandHTMLWebView", e16, "", new Object[0]);
            }
            WebResourceResponse a16 = a.this.f125203f.a(webView, webResourceRequest);
            return a16 != null ? a16 : a(webResourceRequest.getUrl().toString());
        }

        @Override // com.tencent.xweb.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
            if (webResourceRequest != null && webResourceRequest.getUrl() != null) {
                try {
                    a.this.getHTMLResourceLoadReporter().a(a.this.getPageView(), a.this.getUrl(), new com.tencent.luggage.wxa.fm.a(webResourceRequest));
                } catch (Exception e16) {
                    w.a("Luggage.STANDALONE.AppBrandHTMLWebView", e16, "", new Object[0]);
                }
                WebResourceResponse a16 = a.this.f125203f.a(webView, webResourceRequest, bundle);
                if (a16 != null) {
                    return a16;
                }
                String uri = webResourceRequest.getUrl().toString();
                WebResourceResponse a17 = a(uri);
                if (a17 != null) {
                    return a17;
                }
                try {
                    int i3 = bundle.getInt("resourceType");
                    if (i3 == 1 || i3 == 7) {
                        a.this.f125198a.a(webView, uri, a.this.I);
                    }
                } catch (Throwable th5) {
                    w.b("Luggage.STANDALONE.AppBrandHTMLWebView", "shouldInterceptRequest with url(%s) and bundle, check resourceType get exception %s", uri, th5);
                }
            }
            return null;
        }

        @Override // com.tencent.xweb.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (com.tencent.luggage.wxa.m6.d.a(str)) {
                if (a.this.f125198a.d(webView, str, a.this.I)) {
                    w.d("Luggage.STANDALONE.AppBrandHTMLWebView", "shouldOverrideUrlLoading url(%s) intercepted by geta8key", str);
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            w.b("Luggage.STANDALONE.AppBrandHTMLWebView", "shouldOverrideUrlLoading invalid url(%s)", str);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j extends p {
        public static final int CTRL_INDEX = 505;
        public static final String NAME = "onWebviewFinishLoad";

        public j() {
        }

        public /* synthetic */ j(C6184a c6184a) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class k extends p {
        public static final int CTRL_INDEX = 504;
        public static final String NAME = "onWebviewStartLoad";

        public k() {
        }

        public /* synthetic */ k(C6184a c6184a) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class l extends p {
        public static final int CTRL_INDEX = 506;
        public static final String NAME = "onWebviewError";

        public l() {
        }

        public /* synthetic */ l(C6184a c6184a) {
            this();
        }
    }

    public a(Context context, com.tencent.luggage.wxa.ic.g gVar, com.tencent.luggage.wxa.m4.b bVar) {
        super(context);
        this.f125205h = 0;
        this.f125206i = "";
        this.f125207j = "";
        this.f125208k = true;
        this.f125209l = false;
        this.f125210m = new LinkedList();
        this.C = null;
        this.D = 0;
        this.E = new AtomicBoolean(false);
        this.F = "";
        this.G = Collections.newSetFromMap(new ConcurrentHashMap());
        this.H = false;
        this.I = new C6184a();
        this.J = null;
        this.K = new b();
        this.L = false;
        h hVar = new h();
        this.M = hVar;
        i iVar = new i();
        this.N = iVar;
        this.f125199b = gVar.getAppId();
        this.f125202e = bVar;
        c cVar = new c(context);
        this.f125200c = cVar;
        cVar.setWebViewClient(hVar);
        this.f125200c.setWebChromeClient(iVar);
        this.f125200c.setBackgroundColor(0);
        this.f125200c.getSettings().setDomStorageEnabled(true);
        this.f125200c.getSettings().setJavaScriptEnabled(true);
        this.f125200c.getSettings().setMediaPlaybackRequiresUserGesture(false);
        this.f125200c.getSettings().setMixedContentMode(0);
        this.f125200c.getSettings().setUserAgentString(n.a(getContext(), this.f125200c.getSettings().getUserAgentString(), (n.a) com.tencent.luggage.wxa.h1.e.a(n.a.class)) + " miniProgram/" + bVar.getAppId() + " Mobile");
        this.f125200c.setHorizontalScrollBarEnabled(false);
        this.f125200c.setVerticalScrollBarEnabled(false);
        this.f125200c.getSettings().setBuiltInZoomControls(true);
        this.f125200c.getSettings().setUseWideViewPort(true);
        this.f125200c.getSettings().setLoadWithOverviewMode(true);
        this.f125200c.getSettings().setSavePassword(false);
        this.f125200c.getSettings().setSaveFormData(false);
        this.f125200c.getSettings().setGeolocationEnabled(true);
        this.f125200c.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.f125200c.getSettings().setAppCacheMaxSize(10485760L);
        this.f125200c.getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
        this.f125200c.getSettings().setAppCacheEnabled(true);
        this.f125200c.getSettings().setDatabaseEnabled(true);
        this.f125200c.getSettings().setBackgroundAudioPause(true);
        addView(this.f125200c, new ViewGroup.LayoutParams(-1, -1));
        com.tencent.luggage.wxa.il.m mVar = new com.tencent.luggage.wxa.il.m(context);
        this.f125201d = mVar;
        mVar.setProgressDrawable(ContextCompat.getDrawable(context, R.drawable.k0k));
        addView(this.f125201d, new ViewGroup.LayoutParams(-1, com.tencent.luggage.wxa.kn.a.a(context, 3)));
        com.tencent.luggage.wxa.k0.d.a(bVar.b(com.tencent.luggage.wxa.k6.j.class));
        this.f125202e.a(new d());
        com.tencent.luggage.wxa.m6.d dVar = new com.tencent.luggage.wxa.m6.d(new e());
        this.f125198a = dVar;
        this.f125203f = new com.tencent.luggage.wxa.f3.b(this, dVar);
        try {
            getHTMLExitReporter().b();
        } catch (Exception e16) {
            w.a("Luggage.STANDALONE.AppBrandHTMLWebView", e16, "", new Object[0]);
        }
        this.f125201d.g();
    }

    public static /* synthetic */ com.tencent.luggage.wxa.k6.i d(a aVar) {
        aVar.getClass();
        return null;
    }

    public static /* synthetic */ int e(a aVar) {
        int i3 = aVar.D;
        aVar.D = i3 + 1;
        return i3;
    }

    private com.tencent.luggage.wxa.ck.k getHTMLExitReporter() {
        return getPageView().getRuntime().Y().getReporter().d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.luggage.wxa.ck.l getHTMLResourceLoadReporter() {
        return getPageView().getRuntime().Y().getReporter().b();
    }

    public String getCommitUrl() {
        return this.f125207j;
    }

    public String getCurrentURL() {
        if (TextUtils.isEmpty(this.f125206i)) {
            try {
                return this.f125200c.getUrl();
            } catch (Exception e16) {
                w.b("Luggage.STANDALONE.AppBrandHTMLWebView", "getCurrentURL e=%s", e16);
            }
        }
        return this.f125206i;
    }

    public com.tencent.luggage.wxa.m4.b getPageView() {
        return this.f125202e;
    }

    @Override // com.tencent.luggage.wxa.lh.a
    public String getUrl() {
        Callable callable = new Callable() { // from class: n21.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String d16;
                d16 = com.tencent.luggage.wxa.f3.a.this.d();
                return d16;
            }
        };
        try {
            if (getWebView().isSysKernel() && !l0.a()) {
                return (String) com.tencent.luggage.wxa.zp.h.f146825d.a(callable).get();
            }
            return (String) callable.call();
        } catch (Exception unused) {
            return getWebView().getUrl();
        }
    }

    public WebView getWebView() {
        return this.f125200c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        x c16 = q.c(this);
        this.J = c16;
        if (c16 != null) {
            c16.a(this.K);
        }
        this.f125204g = (com.tencent.luggage.wxa.mj.g) this.f125202e.f(com.tencent.luggage.wxa.mj.g.class);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!this.f125202e.isRunning()) {
            getWebView().destroy();
        }
        x xVar = this.J;
        if (xVar != null) {
            xVar.b(this.K);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        if (getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) getParent();
            int mode = View.MeasureSpec.getMode(i16);
            if (mode != Integer.MIN_VALUE) {
                if (mode != 0) {
                    if (mode == 1073741824 && View.MeasureSpec.getSize(i16) > viewGroup.getMeasuredHeight()) {
                        i16 = View.MeasureSpec.makeMeasureSpec(viewGroup.getMeasuredHeight(), 1073741824);
                    }
                } else {
                    i16 = View.MeasureSpec.makeMeasureSpec(viewGroup.getMeasuredHeight(), Integer.MIN_VALUE);
                }
            } else {
                i16 = View.MeasureSpec.makeMeasureSpec(Math.max(0, Math.min(viewGroup.getMeasuredHeight(), View.MeasureSpec.getSize(i16))), Integer.MIN_VALUE);
            }
        }
        super.onMeasure(i3, i16);
    }

    public void setCurrentURL(String str) {
        this.f125206i = str;
        if (!w0.c(str)) {
            String host = Uri.parse(str).getHost();
            if (w0.c(host)) {
                a(this.f125202e, "");
                return;
            } else {
                a(this.f125202e, host);
                return;
            }
        }
        a(this.f125202e, "");
    }

    public void setViewId(int i3) {
        this.f125205h = i3;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i extends com.tencent.luggage.wxa.k6.g {

        /* renamed from: b, reason: collision with root package name */
        public com.tencent.luggage.wxa.k6.k f125223b = new com.tencent.luggage.wxa.k6.k();

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.f3.a$i$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6186a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ GeolocationPermissions.Callback f125225a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f125226b;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.f3.a$i$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class DialogInterfaceOnClickListenerC6187a implements DialogInterface.OnClickListener {
                public DialogInterfaceOnClickListenerC6187a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    RunnableC6186a runnableC6186a = RunnableC6186a.this;
                    runnableC6186a.f125225a.invoke(runnableC6186a.f125226b, true, true);
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.f3.a$i$a$b */
            /* loaded from: classes8.dex */
            public class b implements DialogInterface.OnClickListener {
                public b() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    RunnableC6186a runnableC6186a = RunnableC6186a.this;
                    runnableC6186a.f125225a.invoke(runnableC6186a.f125226b, false, false);
                }
            }

            public RunnableC6186a(GeolocationPermissions.Callback callback, String str) {
                this.f125225a = callback;
                this.f125226b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.tencent.luggage.wxa.ml.r dialogContainer = a.this.f125203f.getDialogContainer();
                if (dialogContainer == null) {
                    this.f125225a.invoke(this.f125226b, false, false);
                    return;
                }
                com.tencent.luggage.wxa.ml.b bVar = new com.tencent.luggage.wxa.ml.b(a.this.getContext());
                bVar.setTitle(a.this.getContext().getString(R.string.f159201ro));
                bVar.setMessage(a.this.getContext().getString(R.string.f159191rn, this.f125226b));
                bVar.setPositiveButton(R.string.f170648xe, new DialogInterfaceOnClickListenerC6187a());
                bVar.setNegativeButton(R.string.f170647xd, new b());
                bVar.setCancelable(false);
                dialogContainer.a(bVar);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.tencent.luggage.wxa.ml.r dialogContainer = a.this.f125203f.getDialogContainer();
                if (dialogContainer != null) {
                    Iterator it = a.this.f125210m.iterator();
                    while (it.hasNext()) {
                        dialogContainer.b((com.tencent.luggage.wxa.ml.b) it.next());
                    }
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ JsResult f125231a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f125232b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f125233c;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.f3.a$i$c$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class DialogInterfaceOnClickListenerC6188a implements DialogInterface.OnClickListener {
                public DialogInterfaceOnClickListenerC6188a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    c.this.f125231a.confirm();
                }
            }

            public c(JsResult jsResult, String str, String str2) {
                this.f125231a = jsResult;
                this.f125232b = str;
                this.f125233c = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.tencent.luggage.wxa.ml.r dialogContainer = a.this.f125203f.getDialogContainer();
                if (dialogContainer == null) {
                    this.f125231a.cancel();
                    return;
                }
                com.tencent.luggage.wxa.ml.b bVar = new com.tencent.luggage.wxa.ml.b(a.this.getContext());
                bVar.setMessage(this.f125232b);
                String a16 = o.a(this.f125233c);
                if (!TextUtils.isEmpty(a16)) {
                    bVar.setTitle(a16);
                }
                bVar.setCancelable(false);
                bVar.setPositiveButton(R.string.f170648xe, new DialogInterfaceOnClickListenerC6188a());
                dialogContainer.a(bVar);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class d implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ JsResult f125236a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f125237b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f125238c;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.f3.a$i$d$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class DialogInterfaceOnClickListenerC6189a implements DialogInterface.OnClickListener {
                public DialogInterfaceOnClickListenerC6189a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    d.this.f125236a.confirm();
                }
            }

            /* compiled from: P */
            /* loaded from: classes8.dex */
            public class b implements DialogInterface.OnClickListener {
                public b() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    d.this.f125236a.cancel();
                }
            }

            public d(JsResult jsResult, String str, String str2) {
                this.f125236a = jsResult;
                this.f125237b = str;
                this.f125238c = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.tencent.luggage.wxa.ml.r dialogContainer = a.this.f125203f.getDialogContainer();
                if (dialogContainer == null) {
                    this.f125236a.cancel();
                    return;
                }
                com.tencent.luggage.wxa.ml.b bVar = new com.tencent.luggage.wxa.ml.b(a.this.getContext());
                bVar.setMessage(this.f125237b);
                String a16 = o.a(this.f125238c);
                if (!TextUtils.isEmpty(a16)) {
                    bVar.setTitle(a16);
                }
                bVar.setCancelable(false);
                bVar.setPositiveButton(R.string.f170648xe, new DialogInterfaceOnClickListenerC6189a());
                bVar.setNegativeButton(R.string.f170647xd, new b());
                dialogContainer.a(bVar);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class f extends com.tencent.luggage.wxa.tk.a {

            /* renamed from: a, reason: collision with root package name */
            public final Activity f125247a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Activity f125248b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ boolean[] f125249c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ boolean[] f125250d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ int f125251e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ ValueCallback f125252f;

            public f(Activity activity, boolean[] zArr, boolean[] zArr2, int i3, ValueCallback valueCallback) {
                this.f125248b = activity;
                this.f125249c = zArr;
                this.f125250d = zArr2;
                this.f125251e = i3;
                this.f125252f = valueCallback;
                this.f125247a = activity;
            }

            public final void a() {
                this.f125248b.getApplication().unregisterActivityLifecycleCallbacks(this);
                if (!this.f125249c[0] && !this.f125250d[0]) {
                    try {
                        w.d("Luggage.STANDALONE.AppBrandHTMLWebView", "onShowFileChooser tryInvokeValueCallbackIfActivityResultMissing tag:%d", Integer.valueOf(this.f125251e));
                        this.f125252f.onReceiveValue(null);
                    } finally {
                        this.f125250d[0] = true;
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(Activity activity) {
                if (this.f125247a != activity) {
                    return;
                }
                a();
            }

            @Override // com.tencent.luggage.wxa.tk.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                if (this.f125247a != activity) {
                    return;
                }
                c0.a(new Runnable() { // from class: n21.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.i.f.this.a();
                    }
                });
            }
        }

        public i() {
        }

        @Override // com.tencent.luggage.wxa.k6.g
        public boolean a(WebView webView, String str, String str2, JsResult jsResult) {
            if (a.this.L) {
                jsResult.cancel();
                return true;
            }
            a.this.a(new c(jsResult, str2, str));
            return true;
        }

        @Override // com.tencent.luggage.wxa.k6.g
        public boolean b(WebView webView, String str, String str2, JsResult jsResult) {
            if (a.this.L) {
                jsResult.cancel();
                return true;
            }
            a.this.a(new d(jsResult, str2, str));
            return true;
        }

        @Override // com.tencent.xweb.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            com.tencent.luggage.wxa.e5.i.a(consoleMessage, "Luggage.STANDALONE.AppBrandHTMLWebView");
            return super.onConsoleMessage(consoleMessage);
        }

        @Override // com.tencent.xweb.WebChromeClient
        public boolean onEnterFullscreen(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            w.f("Luggage.STANDALONE.AppBrandHTMLWebView", "WebChromeClient onEnterFullscreen");
            if (a.this.getWebView().isXWalkKernel()) {
                a.d(a.this);
            }
            return super.onEnterFullscreen(view, customViewCallback);
        }

        @Override // com.tencent.xweb.WebChromeClient
        public boolean onExitFullscreen() {
            w.f("Luggage.STANDALONE.AppBrandHTMLWebView", "WebChromeClient onExitFullscreen");
            if (a.this.getWebView().isXWalkKernel()) {
                a.d(a.this);
            }
            return super.onExitFullscreen();
        }

        @Override // com.tencent.xweb.WebChromeClient
        public void onGeolocationPermissionsHidePrompt() {
            a.this.a(new b());
        }

        @Override // com.tencent.xweb.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            if (a.this.L) {
                callback.invoke(str, false, false);
            } else {
                a.this.a(new RunnableC6186a(callback, str));
            }
        }

        @Override // com.tencent.xweb.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            Activity a16 = com.tencent.luggage.wxa.bo.a.a(a.this.f125200c.getContext());
            if (a16 == null) {
                w.b("Luggage.STANDALONE.AppBrandHTMLWebView", "onPermissionRequest NULL activity");
            } else {
                this.f125223b.a(permissionRequest, a16, a.this.f125200c.getUrl());
            }
        }

        @Override // com.tencent.xweb.WebChromeClient
        public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
            super.onPermissionRequestCanceled(permissionRequest);
        }

        @Override // com.tencent.xweb.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            w.d("Luggage.STANDALONE.AppBrandHTMLWebView", "onReceivedTitle: title[%s]", str);
            a.this.f(str);
        }

        @Override // com.tencent.xweb.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            Intent a16;
            Intent intent;
            Intent[] intentArr;
            if (fileChooserParams.getMode() != 0 && fileChooserParams.getMode() != 1) {
                w.b("Luggage.STANDALONE.AppBrandHTMLWebView", "onShowFileChooser invalid mode:%d", Integer.valueOf(fileChooserParams.getMode()));
                return false;
            }
            Intent createIntent = fileChooserParams.createIntent();
            Function1 function1 = new Function1() { // from class: n21.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return a.i.a((String) obj);
                }
            };
            if (!fileChooserParams.isCaptureEnabled()) {
                String[] acceptTypes = fileChooserParams.getAcceptTypes();
                int length = acceptTypes.length;
                int i3 = 0;
                while (true) {
                    intentArr = null;
                    if (i3 >= length) {
                        break;
                    }
                    String str = acceptTypes[i3];
                    if (StringUtils.startsWith(str, ImageContentType.IMAGE_PREFIX)) {
                        Uri uri = (Uri) function1.invoke("wv_choose_image");
                        if (uri != null) {
                            intentArr = new Intent[]{new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", uri).addFlags(2)};
                        }
                    } else if (StringUtils.startsWith(str, "video/")) {
                        Uri uri2 = (Uri) function1.invoke("wv_choose_video");
                        if (uri2 != null) {
                            intentArr = new Intent[]{new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", uri2).addFlags(2)};
                        }
                    } else {
                        i3++;
                    }
                }
                if (intentArr != null) {
                    a16 = new Intent("android.intent.action.CHOOSER");
                    a16.putExtra("android.intent.extra.INITIAL_INTENTS", intentArr);
                    a16.putExtra("android.intent.extra.TITLE", z.b(R.string.f242177tv));
                    a16.putExtra("android.intent.extra.INTENT", createIntent);
                    intent = a16;
                }
                intent = createIntent;
            } else {
                a16 = com.tencent.luggage.wxa.g3.a.a(fileChooserParams.getAcceptTypes(), function1);
                if (a16 != null) {
                    w.d("Luggage.STANDALONE.AppBrandHTMLWebView", "onShowFileChooser with fileChooserIntent(%s)", a16);
                    intent = a16;
                } else {
                    w.d("Luggage.STANDALONE.AppBrandHTMLWebView", "onShowFileChooser with legacyIntent(%s)", createIntent);
                    intent = createIntent;
                }
            }
            if (intent == null) {
                w.b("Luggage.STANDALONE.AppBrandHTMLWebView", "onShowFileChooser get invalid intent from params");
                return false;
            }
            a.this.getPageView().D();
            int hashCode = (hashCode() + a.e(a.this)) >> 16;
            if (a.this.C == null) {
                a.this.C = new HashMap(1);
            }
            a.this.C.put(Integer.valueOf(hashCode), valueCallback);
            Activity a17 = com.tencent.luggage.wxa.bo.a.a(a.this.getContext());
            com.tencent.luggage.wxa.er.a.b(a17 instanceof LuggageActivityHelper.g);
            boolean[] zArr = {false};
            boolean[] zArr2 = {false};
            LuggageActivityHelper.FOR(a17).interceptActivityResultOnce(new e(intent, zArr2, hashCode, zArr));
            w.d("Luggage.STANDALONE.AppBrandHTMLWebView", "onShowFileChooser startActivityForResult tag:%d", Integer.valueOf(hashCode));
            a17.startActivityForResult(intent, hashCode);
            if (valueCallback != null) {
                a17.getApplication().registerActivityLifecycleCallbacks(new f(a17, zArr, zArr2, hashCode, valueCallback));
                return true;
            }
            return true;
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class e implements LuggageActivityHelper.e {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Intent f125242a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ boolean[] f125243b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f125244c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ boolean[] f125245d;

            public e(Intent intent, boolean[] zArr, int i3, boolean[] zArr2) {
                this.f125242a = intent;
                this.f125243b = zArr;
                this.f125244c = i3;
                this.f125245d = zArr2;
            }

            public final Uri a() {
                Intent[] intentArr;
                Uri uri;
                try {
                    intentArr = (Intent[]) this.f125242a.getParcelableArrayExtra("android.intent.extra.INITIAL_INTENTS");
                } catch (ClassCastException unused) {
                }
                if (intentArr == null) {
                    return null;
                }
                for (Intent intent : intentArr) {
                    try {
                        uri = (Uri) intent.getParcelableExtra("output");
                    } catch (ClassCastException unused2) {
                    }
                    if (uri != null) {
                        return uri;
                    }
                }
                return null;
            }

            @Override // com.tencent.luggage.util.LuggageActivityHelper.e
            public boolean a(int i3, int i16, Intent intent) {
                Uri[] parseResult;
                Uri a16;
                try {
                    ValueCallback valueCallback = (ValueCallback) a.this.C.get(Integer.valueOf(i3));
                    Object[] objArr = new Object[4];
                    objArr[0] = Integer.valueOf(i3);
                    objArr[1] = Integer.valueOf(i16);
                    objArr[2] = intent != null ? intent.getData() : null;
                    objArr[3] = intent != null ? intent.getClipData() : null;
                    w.d("Luggage.STANDALONE.AppBrandHTMLWebView", "onShowFileChooser onResult requestCode:%d, resultCode:%d, data:%s, clipData:%s", objArr);
                    if (valueCallback == null) {
                        return false;
                    }
                    if (com.tencent.luggage.wxa.bo.c.a() && -1 == i16 && intent != null && intent.getData() == null && intent.getClipData() != null) {
                        parseResult = new Uri[intent.getClipData().getItemCount()];
                        for (int i17 = 0; i17 < intent.getClipData().getItemCount(); i17++) {
                            parseResult[i17] = intent.getClipData().getItemAt(i17).getUri();
                        }
                    } else if (-1 == i16 && intent == null && (a16 = a()) != null) {
                        w.d("Luggage.STANDALONE.AppBrandHTMLWebView", "onShowFileChooser onResult requestCode:%d use captureOutputUri:%s", Integer.valueOf(i3), a16);
                        parseResult = new Uri[]{a16};
                    } else {
                        parseResult = WebChromeClient.FileChooserParams.parseResult(i16, intent);
                    }
                    valueCallback.onReceiveValue(parseResult);
                    this.f125243b[0] = true;
                    a.this.C.remove(Integer.valueOf(this.f125244c));
                    if (a.this.C.isEmpty()) {
                        a.this.C = null;
                        a.this.D = 0;
                    }
                    return true;
                } finally {
                    this.f125245d[0] = true;
                }
            }
        }

        public static /* synthetic */ Uri a(String str) {
            String c16;
            com.tencent.luggage.wxa.er.a.a((Object) str);
            try {
                c16 = z.c().getExternalCacheDir().getAbsolutePath();
            } catch (Exception unused) {
                c16 = com.tencent.luggage.wxa.db.a.c();
            }
            String concat = FilenameUtils.concat(c16, "wxa/Temp");
            com.tencent.luggage.wxa.cp.x.m(concat);
            String concat2 = FilenameUtils.concat(concat, str + w0.c());
            com.tencent.luggage.wxa.cp.x.a(concat2);
            try {
                return com.tencent.luggage.wxa.tn.m.a(z.c(), new v(concat2));
            } catch (Exception e16) {
                w.b("Luggage.STANDALONE.AppBrandHTMLWebView", "onShowFileChooser exportCaptureOutputUri get exception %s", e16);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String d() {
        return getWebView().getUrl();
    }

    public boolean e() {
        if (getWebView().canGoBack()) {
            try {
                getHTMLExitReporter().a(getPageView(), true);
            } catch (Exception e16) {
                w.a("Luggage.STANDALONE.AppBrandHTMLWebView", e16, "", new Object[0]);
            }
            getWebView().goBack();
            this.f125209l = true;
            return true;
        }
        try {
            getHTMLExitReporter().a(getPageView(), false);
        } catch (Exception e17) {
            w.a("Luggage.STANDALONE.AppBrandHTMLWebView", e17, "", new Object[0]);
        }
        return false;
    }

    public void f() {
        this.f125203f.s();
        this.f125200c.onPause();
    }

    public void g(String str) {
        this.f125200c.stopLoading();
        if (TextUtils.isEmpty(str)) {
            this.f125200c.reload();
        } else {
            this.H = true;
            this.f125200c.loadUrl(str);
        }
    }

    public final void b(String str) {
        if (this.H && this.f125200c.canGoBack()) {
            try {
                this.f125200c.clearHistory();
            } catch (Exception e16) {
                w.b("Luggage.STANDALONE.AppBrandHTMLWebView", "clearHistory url:%s, get exception %s", str, e16);
            }
            if (StringUtils.equals(str, "about:blank")) {
                return;
            }
            this.H = false;
        }
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f125200c.loadUrl(str);
    }

    public final void d(String str) {
        b();
        c();
        this.f125207j = str;
        b(str);
    }

    public void f(String str) {
        if (URLUtil.isValidUrl(str)) {
            if (StringUtils.contains(str, this.f125206i) || StringUtils.contains(str, this.f125207j)) {
                this.f125202e.j("");
                return;
            }
            return;
        }
        this.f125202e.j(str);
    }

    public final void c() {
        this.f125200c.evaluateJavascript(com.tencent.luggage.wxa.tk.c.b("wxjs-new.js"), null);
        com.tencent.luggage.wxa.k6.a.a(this.f125200c);
    }

    @Override // com.tencent.luggage.wxa.lh.a
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            com.tencent.luggage.wxa.zp.h.f146825d.a(new f(str));
            return;
        }
        try {
            if (!this.E.getAndSet(true)) {
                this.f125198a.a(str, this.I);
            } else if (str.indexOf("#") >= 0 && !TextUtils.isEmpty(this.f125200c.getUrl()) && !str.endsWith("#wechat_redirect")) {
                this.f125200c.evaluateJavascript(String.format(Locale.ENGLISH, "window.location=\"%s\"", com.tencent.luggage.wxa.uk.w.a(str)), null);
            } else {
                if (TextUtils.isEmpty(TextUtils.isEmpty(this.f125207j) ? this.f125200c.getUrl() : this.f125207j)) {
                    this.G.add(this.F);
                    g(str);
                } else {
                    c(str);
                }
            }
        } finally {
            this.F = str;
        }
    }

    public void g() {
        this.f125200c.onResume();
        this.f125203f.t();
    }

    public final void b() {
        this.f125200c.evaluateJavascript("window.__wxjs_environment = \"miniprogram\";", null);
    }

    public final void e(String str) {
        b();
        c();
        this.f125203f.f();
        this.f125201d.e();
        if (!this.f125208k && !this.f125209l) {
            try {
                getHTMLExitReporter().a(this.f125202e, this.f125206i, str);
            } catch (Exception e16) {
                w.a("Luggage.STANDALONE.AppBrandHTMLWebView", e16, "", new Object[0]);
            }
        }
        this.f125208k = false;
        this.f125209l = false;
        setCurrentURL(str);
        new j(null).setContext(this.f125202e).setData("src", str).setData("htmlId", Integer.valueOf(this.f125205h)).dispatch();
        b(str);
    }

    public void a(Runnable runnable) {
        if (c0.b()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    public void a() {
        g gVar = new g();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            gVar.run();
        } else {
            new Handler(Looper.getMainLooper()).post(gVar);
        }
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        if (getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) getContext()).setBaseContext(context);
        }
        this.f125200c.a(context);
    }

    public final void a(String str, Bitmap bitmap) {
        b();
        this.f125201d.g();
        new k(null).setContext(this.f125202e).setData("src", str).setData("htmlId", Integer.valueOf(this.f125205h)).dispatch();
    }

    public void a(String str, int i3, String str2) {
        new l(null).setContext(this.f125202e).setData("htmlId", Integer.valueOf(this.f125205h)).setData("errorCode", Integer.valueOf(i3)).setData("description", str2).setData("src", str).dispatch();
    }

    public final void a(com.tencent.luggage.wxa.kj.v vVar, String str) {
        com.tencent.luggage.wxa.mj.g gVar = this.f125204g;
        if (gVar != null) {
            gVar.b(str);
        }
    }
}
