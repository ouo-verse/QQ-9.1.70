package com.tencent.smtt.sdk;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes23.dex */
public class WebViewDatabase {

    /* renamed from: a, reason: collision with root package name */
    private static WebViewDatabase f369244a;

    /* renamed from: b, reason: collision with root package name */
    private Context f369245b;

    protected WebViewDatabase(Context context) {
        this.f369245b = context;
    }

    private static synchronized WebViewDatabase a(Context context) {
        WebViewDatabase webViewDatabase;
        synchronized (WebViewDatabase.class) {
            if (f369244a == null) {
                f369244a = new WebViewDatabase(context);
            }
            webViewDatabase = f369244a;
        }
        return webViewDatabase;
    }

    public static WebViewDatabase getInstance(Context context) {
        return a(context);
    }

    public void clearFormData() {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().g(this.f369245b);
        } else {
            android.webkit.WebViewDatabase.getInstance(this.f369245b).clearFormData();
        }
    }

    public void clearHttpAuthUsernamePassword() {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().e(this.f369245b);
        } else {
            android.webkit.WebViewDatabase.getInstance(this.f369245b).clearHttpAuthUsernamePassword();
        }
    }

    @Deprecated
    public void clearUsernamePassword() {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().c(this.f369245b);
        } else {
            android.webkit.WebViewDatabase.getInstance(this.f369245b).clearUsernamePassword();
        }
    }

    public boolean hasFormData() {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return a16.c().f(this.f369245b);
        }
        return android.webkit.WebViewDatabase.getInstance(this.f369245b).hasFormData();
    }

    public boolean hasHttpAuthUsernamePassword() {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return a16.c().d(this.f369245b);
        }
        return android.webkit.WebViewDatabase.getInstance(this.f369245b).hasHttpAuthUsernamePassword();
    }

    @Deprecated
    public boolean hasUsernamePassword() {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return a16.c().b(this.f369245b);
        }
        return android.webkit.WebViewDatabase.getInstance(this.f369245b).hasUsernamePassword();
    }
}
