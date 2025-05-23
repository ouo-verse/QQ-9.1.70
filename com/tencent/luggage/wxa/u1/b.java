package com.tencent.luggage.wxa.u1;

import android.content.Context;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.luggage.wxa.u1.g;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements g {

    /* renamed from: a, reason: collision with root package name */
    public WebView f142034a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements g.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebSettings f142035a;

        public a(WebSettings webSettings) {
            this.f142035a = webSettings;
        }

        @Override // com.tencent.luggage.wxa.u1.g.a
        public void setJavaScriptEnabled(boolean z16) {
            this.f142035a.setJavaScriptEnabled(z16);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.u1.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6779b extends WebViewClient {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.b f142037a;

        public C6779b(g.b bVar) {
            this.f142037a = bVar;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            this.f142037a.b();
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (this.f142037a.c(webResourceRequest.getUrl().toString())) {
                g.b.a a16 = this.f142037a.a(g.b.f142068a);
                return new WebResourceResponse(a16.f142069a, a16.f142070b, a16.f142071c);
            }
            return null;
        }
    }

    @Override // com.tencent.luggage.wxa.u1.g
    public void a(g.b bVar) {
        this.f142034a.setWebViewClient(new C6779b(bVar));
    }

    @Override // com.tencent.luggage.wxa.u1.g
    public void d(Context context) {
        throw null;
    }

    @Override // com.tencent.luggage.wxa.u1.g
    public void destroy() {
        this.f142034a.destroy();
    }

    @Override // com.tencent.luggage.wxa.u1.g
    public void g(String str) {
        this.f142034a.evaluateJavascript(str, null);
    }

    @Override // com.tencent.luggage.wxa.u1.g
    public View getView() {
        return this.f142034a;
    }

    @Override // com.tencent.luggage.wxa.u1.g
    public void loadUrl(String str) {
        this.f142034a.loadUrl(str);
    }

    @Override // com.tencent.luggage.wxa.u1.g
    public g.a o() {
        return new a(this.f142034a.getSettings());
    }

    @Override // com.tencent.luggage.wxa.u1.g
    public void requestLayout() {
        this.f142034a.requestLayout();
    }

    @Override // com.tencent.luggage.wxa.u1.g
    public void setVisibility(int i3) {
        this.f142034a.setVisibility(i3);
    }

    @Override // com.tencent.luggage.wxa.u1.g
    public void a(float f16) {
        this.f142034a.setTranslationY(f16);
    }
}
