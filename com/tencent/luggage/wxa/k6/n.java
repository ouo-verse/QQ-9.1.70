package com.tencent.luggage.wxa.k6;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.luggage.wxa.uk.w;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebViewClient;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class n extends WebViewClient {

    /* renamed from: h, reason: collision with root package name */
    public static final a f131708h = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final m f131709a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.k6.f f131710b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.m6.d f131711c;

    /* renamed from: d, reason: collision with root package name */
    public String f131712d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f131713e;

    /* renamed from: f, reason: collision with root package name */
    public String f131714f;

    /* renamed from: g, reason: collision with root package name */
    public final Set f131715g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public /* synthetic */ class b extends FunctionReferenceImpl implements Function2 {
        public b(Object obj) {
            super(2, obj, n.class, "urlCheckCallback", "urlCheckCallback(Ljava/lang/String;Ljava/lang/String;)V", 0);
        }

        public final void a(String p06, String str) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            ((n) this.receiver).a(p06, str);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((String) obj, (String) obj2);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f131717b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public /* synthetic */ class a extends FunctionReferenceImpl implements Function2 {
            public a(Object obj) {
                super(2, obj, n.class, "urlCheckCallback", "urlCheckCallback(Ljava/lang/String;Ljava/lang/String;)V", 0);
            }

            public final void a(String p06, String str) {
                Intrinsics.checkNotNullParameter(p06, "p0");
                ((n) this.receiver).a(p06, str);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((String) obj, (String) obj2);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(0);
            this.f131717b = str;
        }

        public final void a() {
            int indexOf$default;
            String b16;
            boolean endsWith$default;
            n.this.d();
            if (!n.this.f131710b.b()) {
                n.this.f131709a.loadUrl(this.f131717b);
                return;
            }
            try {
                if (n.this.f131713e.getAndSet(true)) {
                    indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) this.f131717b, "#", 0, false, 6, (Object) null);
                    if (indexOf$default >= 0 && !TextUtils.isEmpty(n.this.f131709a.getUrl())) {
                        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(this.f131717b, "#wechat_redirect", false, 2, null);
                        if (!endsWith$default) {
                            m mVar = n.this.f131709a;
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            String format = String.format(Locale.ENGLISH, "window.location=\"%s\"", Arrays.copyOf(new Object[]{w.a(this.f131717b)}, 1));
                            Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
                            mVar.evaluateJavascript(format, null);
                        }
                    }
                    if (TextUtils.isEmpty(n.this.b())) {
                        b16 = n.this.f131709a.getUrl();
                        Intrinsics.checkNotNullExpressionValue(b16, "webView.url");
                    } else {
                        b16 = n.this.b();
                        Intrinsics.checkNotNull(b16);
                    }
                    if (TextUtils.isEmpty(b16)) {
                        n.this.f131715g.add(n.this.f131714f);
                        n.this.f131709a.d(this.f131717b);
                    } else {
                        n.this.a(this.f131717b);
                    }
                } else {
                    n.this.c().a(this.f131717b, new a(n.this));
                }
            } finally {
                n.this.f131714f = this.f131717b;
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public /* synthetic */ class d extends FunctionReferenceImpl implements Function2 {
        public d(Object obj) {
            super(2, obj, n.class, "urlCheckCallback", "urlCheckCallback(Ljava/lang/String;Ljava/lang/String;)V", 0);
        }

        public final void a(String p06, String str) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            ((n) this.receiver).a(p06, str);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((String) obj, (String) obj2);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public /* synthetic */ class e extends FunctionReferenceImpl implements Function2 {
        public e(Object obj) {
            super(2, obj, n.class, "urlCheckCallback", "urlCheckCallback(Ljava/lang/String;Ljava/lang/String;)V", 0);
        }

        public final void a(String p06, String str) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            ((n) this.receiver).a(p06, str);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((String) obj, (String) obj2);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public /* synthetic */ class f extends FunctionReferenceImpl implements Function2 {
        public f(Object obj) {
            super(2, obj, n.class, "urlCheckCallback", "urlCheckCallback(Ljava/lang/String;Ljava/lang/String;)V", 0);
        }

        public final void a(String p06, String str) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            ((n) this.receiver).a(p06, str);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((String) obj, (String) obj2);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public /* synthetic */ class g extends FunctionReferenceImpl implements Function2 {
        public g(Object obj) {
            super(2, obj, n.class, "urlCheckCallback", "urlCheckCallback(Ljava/lang/String;Ljava/lang/String;)V", 0);
        }

        public final void a(String p06, String str) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            ((n) this.receiver).a(p06, str);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((String) obj, (String) obj2);
            return Unit.INSTANCE;
        }
    }

    public n(m webView, com.tencent.luggage.wxa.k6.f controller) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.f131709a = webView;
        this.f131710b = controller;
        this.f131711c = new com.tencent.luggage.wxa.m6.d(controller);
        this.f131713e = new AtomicBoolean(false);
        this.f131714f = "";
        this.f131715g = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public void a(String str, Bitmap bitmap) {
    }

    public abstract void b(String str);

    public void c(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
    }

    public void d() {
    }

    @Override // com.tencent.xweb.WebViewClient
    public void doUpdateVisitedHistory(WebView view, String url, boolean z16) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaSimpleWebViewClient", "doUpdateVisitedHistory url(%s)", url);
        super.doUpdateVisitedHistory(view, url, z16);
        if (this.f131710b.b()) {
            this.f131711c.c(view, url, new b(this));
        }
    }

    @Override // com.tencent.xweb.WebViewClient
    public void onPageCommitVisible(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaSimpleWebViewClient", "onPageCommitVisible url(%s)", url);
        super.onPageCommitVisible(view, url);
        this.f131712d = url;
        b(url);
        if (this.f131710b.b()) {
            this.f131711c.a(view, url);
        }
    }

    @Override // com.tencent.xweb.WebViewClient
    public void onPageFinished(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaSimpleWebViewClient", "onPageFinished hash:" + view.hashCode() + ", url:" + url);
        super.onPageFinished(view, url);
        c(url);
        if (this.f131710b.b()) {
            this.f131711c.b(view, url);
        }
    }

    @Override // com.tencent.xweb.WebViewClient
    public void onPageStarted(WebView view, String str, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(view, "view");
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaSimpleWebViewClient", "onPageStarted hash:" + view.hashCode() + ", url:" + str);
        if (URLUtil.isAboutUrl(str)) {
            this.f131709a.stopLoading();
            return;
        }
        super.onPageStarted(view, str, bitmap);
        a(str, bitmap);
        if (this.f131710b.b()) {
            this.f131711c.b(view, str, new d(this));
        }
    }

    @Override // com.tencent.xweb.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest, Bundle bundle) {
        Integer num;
        String str;
        Uri url;
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.f131710b.b()) {
            if (bundle != null) {
                num = Integer.valueOf(bundle.getInt("resourceType"));
            } else {
                num = null;
            }
            boolean z16 = true;
            if ((num == null || num.intValue() != 1) && (num == null || num.intValue() != 7)) {
                z16 = false;
            }
            if (z16) {
                com.tencent.luggage.wxa.m6.d dVar = this.f131711c;
                if (webResourceRequest != null && (url = webResourceRequest.getUrl()) != null) {
                    str = url.toString();
                } else {
                    str = null;
                }
                dVar.a(view, str, new e(this));
            }
        }
        return null;
    }

    @Override // com.tencent.xweb.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (!com.tencent.luggage.wxa.m6.d.f134163j.a(str)) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaSimpleWebViewClient", "shouldOverrideUrlLoading invalid url(%s)", str);
            return true;
        }
        if (this.f131710b.b() && this.f131711c.d(view, str, new f(this))) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.WxaSimpleWebViewClient", "shouldOverrideUrlLoading url(%s) intercepted by geta8key", str);
            return true;
        }
        return super.shouldOverrideUrlLoading(view, str);
    }

    public final String b() {
        return this.f131712d;
    }

    public final void e() {
        this.f131713e.set(false);
        a(this.f131714f);
    }

    public final com.tencent.luggage.wxa.m6.d c() {
        return this.f131711c;
    }

    public final void a(String str, String str2) {
        if (this.f131709a.getDestroyed()) {
            return;
        }
        boolean remove = TextUtils.isEmpty(str) ? false : this.f131715g.remove(str);
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaSimpleWebViewClient", "getA8KeyCallback loadUrl, req[%s]->new[%s], ignored[%b]", str, str2, Boolean.valueOf(remove));
        if (remove) {
            return;
        }
        this.f131709a.stopLoading();
        this.f131709a.loadUrl(str2);
    }

    @Override // com.tencent.xweb.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest webResourceRequest) {
        Intrinsics.checkNotNullParameter(view, "view");
        if ((webResourceRequest != null ? webResourceRequest.getUrl() : null) != null) {
            String uri = webResourceRequest.getUrl().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "request.url.toString()");
            if (!com.tencent.luggage.wxa.m6.d.f134163j.a(uri)) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.WxaSimpleWebViewClient", "shouldOverrideUrlLoading invalid url(%s)", uri);
                return true;
            }
            if (this.f131710b.b() && this.f131711c.d(view, uri, new g(this))) {
                com.tencent.luggage.wxa.tn.w.d("Luggage.WxaSimpleWebViewClient", "shouldOverrideUrlLoading url(%s) intercepted by geta8key", uri);
                return true;
            }
        }
        return super.shouldOverrideUrlLoading(view, webResourceRequest);
    }

    public final void a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (TextUtils.isEmpty(url)) {
            return;
        }
        com.tencent.luggage.wxa.rn.a.a(new c(url));
    }

    public final void a() {
        this.f131709a.stopLoading();
        this.f131709a.destroy();
        this.f131711c.a();
    }
}
