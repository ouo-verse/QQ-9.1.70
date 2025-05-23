package com.tencent.luggage.wxa.xq;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebViewDatabase;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.y0;
import com.tencent.qimei.webview.QmWebview;
import com.tencent.xweb.WebView;
import com.tencent.xweb.internal.IWebView;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c implements com.tencent.luggage.wxa.tq.f {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Callable {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.tq.a call() {
            x0.d("SysWebFactory", "getCookieManager, not yet init, try create CookieManager");
            CookieManager.getInstance();
            return new com.tencent.luggage.wxa.xq.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static boolean f145373a = false;

        /* renamed from: b, reason: collision with root package name */
        public static Boolean f145374b;

        /* renamed from: c, reason: collision with root package name */
        public static final AtomicBoolean f145375c = new AtomicBoolean(false);

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ WebView.PreInitCallback f145376a;

            public a(WebView.PreInitCallback preInitCallback) {
                this.f145376a = preInitCallback;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.b();
                    x0.d("SysWebFactory.PreIniter", "preInit, enforce main looper & finish init");
                    boolean unused = b.f145373a = true;
                    WebView.PreInitCallback preInitCallback = this.f145376a;
                    if (preInitCallback != null) {
                        preInitCallback.onCoreInitFinished();
                    }
                } catch (Throwable th5) {
                    x0.a("SysWebFactory.PreIniter", "ensureSystemWebViewGlobalLooper error", th5);
                    n0.a(577L, 233L, 1L);
                }
            }
        }

        public static void b(boolean z16) {
            y0.a("SysWebFactory.PreIniter").edit().putBoolean("isEnforceMainLooper", z16).apply();
        }

        public static boolean c() {
            return f145373a;
        }

        public static boolean d() {
            if (f145374b == null) {
                f145374b = Boolean.valueOf(y0.a("SysWebFactory.PreIniter").getBoolean("isEnforceMainLooper", false));
            }
            return f145374b.booleanValue();
        }

        public static boolean e() {
            if (!d()) {
                return true;
            }
            return f145375c.get();
        }

        public static synchronized void a(Context context, WebView.PreInitCallback preInitCallback) {
            synchronized (b.class) {
                if (f145373a) {
                    x0.d("SysWebFactory.PreIniter", "preInit, has already init");
                    return;
                }
                if (!d()) {
                    x0.d("SysWebFactory.PreIniter", "preInit, not enforce main looper");
                    f145373a = true;
                    if (preInitCallback != null) {
                        preInitCallback.onCoreInitFinished();
                    }
                    return;
                }
                if (f145375c.get()) {
                    x0.d("SysWebFactory.PreIniter", "preInit, enforce main looper & already called");
                    if (preInitCallback != null) {
                        preInitCallback.onCoreInitFinished();
                    }
                } else {
                    x0.d("SysWebFactory.PreIniter", "preInit, enforce main looper & not yet called");
                    a aVar = new a(preInitCallback);
                    if (Looper.getMainLooper() == Looper.myLooper()) {
                        aVar.run();
                    } else {
                        new Handler(Looper.getMainLooper()).post(aVar);
                    }
                }
            }
        }

        public static void b() {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                if (f145375c.getAndSet(true)) {
                    return;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                x0.d("SysWebFactory.PreIniter", "ensureSystemWebViewGlobalLooper, init system webview");
                CookieManager.getInstance();
                CookieSyncManager.createInstance(XWalkEnvironment.getApplicationContext());
                new QmWebview(XWalkEnvironment.getApplicationContext()).destroy();
                x0.d("SysWebFactory.PreIniter", "ensureSystemWebViewGlobalLooper cost=" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
                return;
            }
            throw new IllegalStateException("Calling WebView methods on another thread than the UI thread.");
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.xq.c$c, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C6930c {

        /* renamed from: a, reason: collision with root package name */
        public static final c f145377a = new c(null);
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c a() {
        return C6930c.f145377a;
    }

    @Override // com.tencent.luggage.wxa.tq.f
    public void clearAllWebViewCache(Context context, boolean z16) {
        try {
            android.webkit.WebView webView = new android.webkit.WebView(context);
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
            webView.clearCache(true);
            if (z16) {
                CookieSyncManager.createInstance(context);
                CookieManager.getInstance().removeAllCookie();
            }
            WebViewDatabase.getInstance(context).clearUsernamePassword();
            WebViewDatabase.getInstance(context).clearHttpAuthUsernamePassword();
            WebViewDatabase.getInstance(context).clearFormData();
            WebStorage.getInstance().deleteAllData();
            WebIconDatabase.getInstance().removeAllIcons();
        } catch (Throwable th5) {
            x0.a("SysWebFactory", "clearAllWebViewCache error", th5);
        }
    }

    @Override // com.tencent.luggage.wxa.tq.f
    public void clearClientCertPreferences(Runnable runnable) {
        e.a(runnable);
    }

    @Override // com.tencent.luggage.wxa.tq.f
    public IWebView createWebView(WebView webView) {
        try {
            return new e(webView);
        } catch (Throwable th5) {
            String message = th5.getMessage();
            if (message != null && message.contains("Calling View methods on another thread than the UI thread.")) {
                x0.c("SysWebFactory", "createWebView error:" + th5);
                b.b(true);
            }
            throw th5;
        }
    }

    @Override // com.tencent.luggage.wxa.tq.f
    public String findAddress(String str) {
        return e.a(str);
    }

    @Override // com.tencent.luggage.wxa.tq.f
    public com.tencent.luggage.wxa.tq.a getCookieManager() {
        if (b.e()) {
            x0.d("SysWebFactory", "getCookieManager, already init");
            return new com.tencent.luggage.wxa.xq.a();
        }
        try {
            return (com.tencent.luggage.wxa.tq.a) a(new a());
        } catch (Throwable th5) {
            x0.a("SysWebFactory", "getCookieManager error", th5);
            return new com.tencent.luggage.wxa.xq.a();
        }
    }

    @Override // com.tencent.luggage.wxa.tq.f
    public com.tencent.luggage.wxa.tq.c getWebViewContextWrapper() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.tq.f
    public com.tencent.luggage.wxa.tq.d getWebViewCoreWrapper() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.tq.f
    public com.tencent.luggage.wxa.tq.e getWebViewDatabase(Context context) {
        return new f(context);
    }

    @Override // com.tencent.luggage.wxa.tq.f
    public com.tencent.luggage.wxa.tq.b getWebviewStorage() {
        return new d();
    }

    @Override // com.tencent.luggage.wxa.tq.f
    public boolean hasInitedWebViewCore() {
        return b.c();
    }

    @Override // com.tencent.luggage.wxa.tq.f
    public boolean initWebviewCore(Context context, WebView.PreInitCallback preInitCallback) {
        x0.d("SysWebFactory", "initWebviewCore");
        b.a(context, preInitCallback);
        return true;
    }

    public c() {
    }

    public static Object a(Callable callable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return callable.call();
        }
        FutureTask futureTask = new FutureTask(callable);
        new Handler(Looper.getMainLooper()).post(futureTask);
        return futureTask.get();
    }
}
