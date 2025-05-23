package com.tencent.luggage.wxa.q5;

import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.zp.h;
import com.tencent.xweb.WebView;
import com.tencent.xweb.XWebSdk;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f137859a = false;

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f137860b = false;

    /* renamed from: c, reason: collision with root package name */
    public static final Set f137861c = new HashSet();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            e.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f137862a;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements WebView.PreInitCallback {
            public a() {
            }

            @Override // com.tencent.xweb.WebView.PreInitCallback
            public void onCoreInitFailed() {
                e.d();
            }

            @Override // com.tencent.xweb.WebView.PreInitCallback
            public void onCoreInitFinished() {
                h.f146825d.a(b.this.f137862a);
            }
        }

        public b(Runnable runnable) {
            this.f137862a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.a(-2);
            if (WebView.hasInited()) {
                h.f146825d.a(this.f137862a);
            } else {
                XWebSdk.initWebviewCore(z.c(), WebView.sDefaultWebViewKind, "appbrand", new a());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        void a();

        void b();
    }

    public static void c() {
        HashSet hashSet;
        synchronized (e.class) {
            f137860b = true;
            f137859a = false;
            Set set = f137861c;
            hashSet = new HashSet(set);
            set.clear();
        }
        w.d("Luggage.XWebPreloader", "notifyPreloadDone, type:%s, callbacks[%d]", WebView.getCurrentModuleWebCoreType(), Integer.valueOf(hashSet.size()));
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((c) it.next()).b();
        }
    }

    public static void d() {
        HashSet hashSet;
        synchronized (e.class) {
            f137860b = false;
            f137859a = false;
            Set set = f137861c;
            hashSet = new HashSet(set);
            set.clear();
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a();
        }
    }

    public static boolean e() {
        boolean z16;
        synchronized (e.class) {
            z16 = f137860b;
        }
        return z16;
    }

    public static boolean f() {
        boolean isXWebView = XWebSdk.isXWebView();
        int availableVersion = XWebSdk.getAvailableVersion();
        int installedNewstVersion = XWebSdk.getInstalledNewstVersion(z.c());
        w.d("Luggage.XWebPreloader", "reInitToXWeb, isXWalk:%b, xwLoadedVersion:%d, xwApkVersion:%d", Boolean.valueOf(isXWebView), Integer.valueOf(availableVersion), Integer.valueOf(installedNewstVersion));
        if (isXWebView || availableVersion > 0 || installedNewstVersion <= 0) {
            return false;
        }
        WebView.reinitToXWeb();
        return true;
    }

    public static void a(c cVar) {
        synchronized (e.class) {
            boolean z16 = f137859a;
            boolean z17 = f137860b;
            if (!z17) {
                if (cVar != null) {
                    f137861c.add(cVar);
                }
                f137859a = true;
                f137860b = false;
            }
            if (z16) {
                return;
            }
            if (!z17) {
                h.f146825d.d(new b(new a()));
            } else if (cVar != null) {
                cVar.b();
            }
        }
    }
}
