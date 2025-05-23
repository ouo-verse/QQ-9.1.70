package com.tencent.luggage.wxa.k6;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.hn.w8;
import com.tencent.luggage.wxa.k6.f;
import com.tencent.luggage.wxa.mj.g;
import com.tencent.luggage.wxa.tk.n;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.uk.l0;
import com.tencent.mobileqq.R;
import com.tencent.xweb.WebChromeClient;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class p extends FrameLayout implements com.tencent.luggage.wxa.lh.a {
    public static final b E = new b(null);
    public final c C;
    public boolean D;

    /* renamed from: a, reason: collision with root package name */
    public final h f131732a;

    /* renamed from: b, reason: collision with root package name */
    public final m f131733b;

    /* renamed from: c, reason: collision with root package name */
    public final View f131734c;

    /* renamed from: d, reason: collision with root package name */
    public final View f131735d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f131736e;

    /* renamed from: f, reason: collision with root package name */
    public final l f131737f;

    /* renamed from: g, reason: collision with root package name */
    public final com.tencent.luggage.wxa.il.m f131738g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f131739h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f131740i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f131741j;

    /* renamed from: k, reason: collision with root package name */
    public String f131742k;

    /* renamed from: l, reason: collision with root package name */
    public q f131743l;

    /* renamed from: m, reason: collision with root package name */
    public final n f131744m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            p.this.f131744m.e();
            p.this.f131735d.setVisibility(8);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends com.tencent.luggage.wxa.k6.c {
        public c(m mVar, com.tencent.luggage.wxa.m6.d dVar) {
            super(mVar, dVar);
        }

        @Override // com.tencent.luggage.wxa.k6.b
        public void a(int i3, int i16) {
            q delegate = p.this.getDelegate();
            if (delegate != null) {
                delegate.a(i3, i16);
            }
        }

        @Override // com.tencent.luggage.wxa.k6.b
        public void b(String title) {
            Intrinsics.checkNotNullParameter(title, "title");
            WebChromeClient webChromeClient = q().getWebChromeClient();
            if (webChromeClient != null) {
                webChromeClient.onReceivedTitle(q(), title);
            }
        }

        @Override // com.tencent.luggage.wxa.k6.b
        public String g() {
            return p.this.f131744m.b();
        }

        @Override // com.tencent.luggage.wxa.k6.b
        public String h() {
            return p.this.getCurrentURL();
        }

        @Override // com.tencent.luggage.wxa.xd.d
        public boolean isRunning() {
            return true;
        }

        @Override // com.tencent.luggage.wxa.k6.b
        public void u() {
            q delegate = p.this.getDelegate();
            if (delegate != null) {
                delegate.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements Callable {
        public d() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String call() {
            return p.this.getWebView().getUrl();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements com.tencent.luggage.wxa.k6.f {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ p f131749a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(p pVar) {
                super(0);
                this.f131749a = pVar;
            }

            public final void a() {
                this.f131749a.f131735d.setVisibility(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public f() {
        }

        @Override // com.tencent.luggage.wxa.k6.h
        public /* synthetic */ void a(WebView webView, String str) {
            y21.b.a(this, webView, str);
        }

        @Override // com.tencent.luggage.wxa.k6.h
        public boolean b() {
            return p.this.f131732a.b();
        }

        @Override // com.tencent.luggage.wxa.k6.h
        public int c() {
            return p.this.f131732a.c();
        }

        @Override // com.tencent.luggage.wxa.k6.h
        public String d() {
            return p.this.f131732a.d();
        }

        @Override // com.tencent.luggage.wxa.k6.f
        public f.a e() {
            return f.a.WMPF;
        }

        @Override // com.tencent.luggage.wxa.k6.h
        public boolean f() {
            return p.this.f131732a.f();
        }

        @Override // com.tencent.luggage.wxa.k6.f
        public String g() {
            return p.this.getWebView().getUrl();
        }

        @Override // com.tencent.luggage.wxa.k6.h
        public /* synthetic */ void a(WebView webView, String str, Bitmap bitmap) {
            y21.b.b(this, webView, str, bitmap);
        }

        @Override // com.tencent.luggage.wxa.k6.f
        public /* synthetic */ void a(String str, w8 w8Var) {
            y21.a.b(this, str, w8Var);
        }

        @Override // com.tencent.luggage.wxa.k6.f
        public void a() {
            y21.a.a(this);
            com.tencent.luggage.wxa.rn.a.a(new a(p.this));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends m {
        public boolean D;
        public final /* synthetic */ p E;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f131751b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ValueCallback f131752c;

            public a(String str, ValueCallback valueCallback) {
                this.f131751b = str;
                this.f131752c = valueCallback;
            }

            @Override // java.lang.Runnable
            public final void run() {
                g.this.evaluateJavascript(this.f131751b, this.f131752c);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Context context, p pVar) {
            super(context, null, 2, null);
            this.E = pVar;
        }

        @Override // com.tencent.luggage.wxa.k6.m
        public void d(String str) {
            stopLoading();
            if (!TextUtils.isEmpty(str)) {
                this.E.f131741j = true;
                loadUrl(str);
            } else {
                reload();
            }
        }

        @Override // com.tencent.luggage.wxa.k6.m, com.tencent.xweb.WebView, com.tencent.xweb.internal.IWebView
        public void destroy() {
            if (this.D) {
                return;
            }
            if (getWebChromeClient() instanceof com.tencent.luggage.wxa.k6.g) {
                WebChromeClient webChromeClient = getWebChromeClient();
                Intrinsics.checkNotNull(webChromeClient, "null cannot be cast to non-null type com.tencent.luggage.webview.MMWebChromeClient");
                ((com.tencent.luggage.wxa.k6.g) webChromeClient).a();
            }
            w.d("Luggage.STANDALONE.WxaWebView", "webview destroy hash[%d]", Integer.valueOf(this.E.hashCode()));
            super.destroy();
            this.D = true;
        }

        @Override // com.tencent.xweb.WebView, com.tencent.xweb.internal.IWebView
        public void evaluateJavascript(String str, ValueCallback valueCallback) {
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                super.evaluateJavascript(str, valueCallback);
            } else {
                com.tencent.luggage.wxa.zp.h.f146825d.a(new a(str, valueCallback));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Context context, h webViewController) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(webViewController, "webViewController");
        this.f131732a = webViewController;
        g gVar = new g(context, this);
        this.f131733b = gVar;
        View inflate = LayoutInflater.from(context).inflate(R.layout.ffu, (ViewGroup) null);
        this.f131734c = inflate;
        this.f131735d = inflate.findViewById(R.id.f72343ql);
        TextView textView = (TextView) inflate.findViewById(R.id.f122107d2);
        this.f131736e = textView;
        l lVar = new l(context, gVar);
        this.f131737f = lVar;
        com.tencent.luggage.wxa.il.m mVar = new com.tencent.luggage.wxa.il.m(context);
        this.f131738g = mVar;
        this.f131739h = true;
        e eVar = new e(gVar, new f());
        this.f131744m = eVar;
        this.C = webViewController.f() ? new c(gVar, eVar.c()) : null;
        if (webViewController.f()) {
            gVar.getSettings().setUserAgentString(com.tencent.luggage.wxa.tk.n.a(context, gVar.getSettings().getUserAgentString(), (n.a) com.tencent.luggage.wxa.h1.e.a(n.a.class)));
        }
        gVar.setWebViewClient(eVar);
        addView(lVar, new ViewGroup.LayoutParams(-1, -1));
        lVar.setPullDownEnabled(true);
        mVar.setProgressDrawable(ContextCompat.getDrawable(context, R.drawable.k0k));
        addView(mVar, new ViewGroup.LayoutParams(-1, com.tencent.luggage.wxa.kn.a.a(context, 3)));
        addView(inflate, new ViewGroup.LayoutParams(-1, -1));
        textView.setOnClickListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentURL(String str) {
        this.f131742k = str;
        if (!w0.c(str)) {
            String host = Uri.parse(str).getHost();
            if (w0.c(host)) {
                this.f131737f.setPullDownText("");
                return;
            } else {
                this.f131737f.setPullDownText(getContext().getString(R.string.f238657kc, host));
                return;
            }
        }
        this.f131737f.setPullDownText("");
    }

    @Nullable
    public final String getCommitUrl() {
        return this.f131744m.b();
    }

    @Nullable
    public final String getCurrentURL() {
        return this.f131742k;
    }

    @Nullable
    public final q getDelegate() {
        return this.f131743l;
    }

    @Override // com.tencent.luggage.wxa.lh.a
    @NotNull
    public String getUrl() {
        String str;
        d dVar = new d();
        try {
            if (this.f131733b.isSysKernel() && !l0.a()) {
                str = (String) com.tencent.luggage.wxa.zp.h.f146825d.a(dVar).get();
            } else {
                str = (String) dVar.call();
            }
            Intrinsics.checkNotNullExpressionValue(str, "{\n            if (webVie\u2026)\n            }\n        }");
            return str;
        } catch (Exception unused) {
            String url = this.f131733b.getUrl();
            Intrinsics.checkNotNullExpressionValue(url, "{\n            webView.url\n        }");
            return url;
        }
    }

    @NotNull
    public final m getWebView() {
        return this.f131733b;
    }

    public final void setDarkMode(int i3) {
        this.f131733b.h(i3);
        if (i3 != 1) {
            if (i3 != 2) {
                this.f131737f.setBackgroundTextStyle(g.a.IGNORE.b());
                return;
            } else {
                this.f131737f.setBackgroundTextStyle(g.a.LIGHT.b());
                return;
            }
        }
        this.f131737f.setBackgroundTextStyle(g.a.DARK.b());
    }

    public final void setDelegate(@Nullable q qVar) {
        this.f131743l = qVar;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends n {
        public e(m mVar, f fVar) {
            super(mVar, fVar);
        }

        @Override // com.tencent.luggage.wxa.k6.n
        public void a(String str, Bitmap bitmap) {
            super.a(str, bitmap);
            p.this.f131738g.g();
            p.this.f131732a.a(p.this.getWebView(), str, bitmap);
        }

        @Override // com.tencent.luggage.wxa.k6.n
        public void b(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            p.this.b();
            p.this.b(url);
        }

        @Override // com.tencent.luggage.wxa.k6.n
        public void c(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            super.c(url);
            p.this.setCurrentURL(url);
            p.this.f131732a.a(p.this.getWebView(), url);
            p.this.b();
            c cVar = p.this.C;
            if (cVar != null) {
                cVar.f();
            }
            p.this.f131738g.e();
            p.this.f131739h = false;
            p.this.f131740i = false;
            p.this.b(url);
        }

        @Override // com.tencent.luggage.wxa.k6.n
        public void d() {
            super.d();
            p.this.f131738g.g();
        }

        @Override // com.tencent.luggage.wxa.k6.n, com.tencent.xweb.WebViewClient
        public void doUpdateVisitedHistory(WebView view, String url, boolean z16) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            super.doUpdateVisitedHistory(view, url, z16);
            p.this.b(url);
        }

        @Override // com.tencent.luggage.wxa.k6.n, com.tencent.xweb.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest, Bundle bundle) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
                return null;
            }
            c cVar = p.this.C;
            WebResourceResponse a16 = cVar != null ? cVar.a(view, webResourceRequest, bundle) : null;
            return a16 != null ? a16 : super.shouldInterceptRequest(view, webResourceRequest, bundle);
        }

        @Override // com.tencent.xweb.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
                return null;
            }
            c cVar = p.this.C;
            WebResourceResponse a16 = cVar != null ? cVar.a(view, webResourceRequest) : null;
            return a16 != null ? a16 : super.shouldInterceptRequest(view, webResourceRequest);
        }
    }

    @Override // com.tencent.luggage.wxa.lh.a
    public void a(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        this.f131744m.a(str);
    }

    public final void b(String str) {
        if (this.f131741j && this.f131733b.canGoBack()) {
            try {
                this.f131733b.clearHistory();
            } catch (Exception e16) {
                w.b("Luggage.STANDALONE.WxaWebView", "clearHistory url:%s, get exception %s", str, e16);
            }
            if (StringUtils.equals(str, "about:blank")) {
                return;
            }
            this.f131741j = false;
        }
    }

    public final void a() {
        if (this.D) {
            return;
        }
        this.D = true;
        c cVar = this.C;
        if (cVar != null) {
            cVar.e();
        }
        this.f131744m.a();
        this.f131733b.destroy();
    }

    public final void b() {
        this.f131733b.evaluateJavascript(com.tencent.luggage.wxa.tk.c.b("wxjs-new.js"), null);
        com.tencent.luggage.wxa.k6.a.a(this.f131733b);
    }
}
