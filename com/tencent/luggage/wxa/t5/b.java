package com.tencent.luggage.wxa.t5;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.wxa.eo.d;
import com.tencent.luggage.wxa.kj.u1;
import com.tencent.luggage.wxa.u1.g;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebSettings;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebViewClient;

/* compiled from: P */
@com.tencent.luggage.wxa.fo.b
/* loaded from: classes8.dex */
public class b extends d implements g {

    /* renamed from: h, reason: collision with root package name */
    public WebView f140852h;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements g.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebSettings f140853a;

        public a(WebSettings webSettings) {
            this.f140853a = webSettings;
        }

        @Override // com.tencent.luggage.wxa.u1.g.a
        public void setJavaScriptEnabled(boolean z16) {
            this.f140853a.setJavaScriptEnabled(z16);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.t5.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6736b extends WebViewClient {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.b f140855a;

        public C6736b(g.b bVar) {
            this.f140855a = bVar;
        }

        public final WebResourceResponse a(String str) {
            if (this.f140855a.c(str)) {
                g.b.a a16 = this.f140855a.a(g.b.f142068a);
                return new WebResourceResponse(a16.f142069a, a16.f142070b, a16.f142071c);
            }
            return null;
        }

        @Override // com.tencent.xweb.WebViewClient
        public void onPageCommitVisible(WebView webView, String str) {
            this.f140855a.a();
        }

        @Override // com.tencent.xweb.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            this.f140855a.b();
        }

        @Override // com.tencent.xweb.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            return a(str);
        }

        @Override // com.tencent.xweb.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
            return a(webResourceRequest.getUrl().toString());
        }

        @Override // com.tencent.xweb.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            return a(webResourceRequest.getUrl().toString());
        }
    }

    @Override // com.tencent.luggage.wxa.u1.g
    public void a(g.b bVar) {
        this.f140852h.setWebViewClient(new C6736b(bVar));
    }

    @Override // com.tencent.luggage.wxa.u1.g
    public void d(Context context) {
        this.f140852h = new u1(context);
    }

    @Override // com.tencent.luggage.wxa.u1.g
    public void destroy() {
        this.f140852h.destroy();
    }

    @Override // com.tencent.luggage.wxa.u1.g
    public void g(String str) {
        this.f140852h.evaluateJavascript(str, null);
    }

    @Override // com.tencent.luggage.wxa.u1.g
    public View getView() {
        return this.f140852h;
    }

    @Override // com.tencent.luggage.wxa.u1.g
    public void loadUrl(String str) {
        this.f140852h.loadUrl(str);
    }

    @Override // com.tencent.luggage.wxa.u1.g
    public g.a o() {
        return new a(this.f140852h.getSettings());
    }

    @Override // com.tencent.luggage.wxa.u1.g
    public void requestLayout() {
        this.f140852h.requestLayout();
    }

    @Override // com.tencent.luggage.wxa.u1.g
    public void setVisibility(int i3) {
        this.f140852h.setVisibility(i3);
    }

    @Override // com.tencent.luggage.wxa.u1.g
    public void a(float f16) {
        this.f140852h.setTranslationY(f16);
    }
}
