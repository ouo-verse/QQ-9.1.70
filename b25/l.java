package b25;

import android.webkit.WebView;

/* compiled from: P */
/* loaded from: classes28.dex */
public class l implements c25.a {

    /* renamed from: a, reason: collision with root package name */
    private Object f27783a;

    public l(Object obj) {
        this.f27783a = obj;
    }

    @Override // c25.a
    public void a() {
        q.b(this.f27783a, null, q.c(this.f27783a, "startLoad", new Class[0]), new Object[0]);
    }

    @Override // c25.a
    public WebView getWebView() {
        return (WebView) q.b(this.f27783a, WebView.class, q.c(this.f27783a, "getWebView", new Class[0]), new Object[0]);
    }
}
