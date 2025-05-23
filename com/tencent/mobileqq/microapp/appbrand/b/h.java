package com.tencent.mobileqq.microapp.appbrand.b;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import com.tencent.mobileqq.microapp.appbrand.page.ProgressWebView;
import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final String f245986a;

    /* renamed from: e, reason: collision with root package name */
    private static volatile h f245987e;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap f245988b;

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap f245989c;

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap f245990d;

    /* renamed from: f, reason: collision with root package name */
    private MutableContextWrapper f245991f;

    /* renamed from: g, reason: collision with root package name */
    private int f245992g;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14761);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f245986a = h.class.getSimpleName();
        }
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f245988b = new ConcurrentHashMap();
        this.f245989c = new ConcurrentHashMap();
        this.f245990d = new ConcurrentHashMap();
    }

    public static h a() {
        if (f245987e == null) {
            synchronized (h.class) {
                if (f245987e == null) {
                    f245987e = new h();
                }
            }
        }
        return f245987e;
    }

    public PageWebview b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (PageWebview) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        PageWebview pageWebview = (PageWebview) this.f245988b.remove(str);
        if (pageWebview == null) {
            if (QLog.isColorLevel()) {
                QLog.d(f245986a, 2, "create new PageWebview when getPageWebview");
            }
            pageWebview = new PageWebview(this.f245991f);
            pageWebview.loadHtml();
        } else if (QLog.isColorLevel()) {
            QLog.d(f245986a, 2, "get cache PageWebview when getPageWebview");
        }
        int i3 = this.f245992g + 1;
        this.f245992g = i3;
        pageWebview.pageWebviewId = i3;
        return pageWebview;
    }

    public void a(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f245986a, 2, "---initFistWebview----");
        }
        this.f245991f = new MutableContextWrapper(activity);
        new ServiceWebview(this.f245991f);
        new PageWebview(this.f245991f);
        new ProgressWebView(this.f245991f);
    }

    public synchronized void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        ConcurrentHashMap concurrentHashMap = this.f245988b;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
            this.f245988b = null;
        }
        ConcurrentHashMap concurrentHashMap2 = this.f245989c;
        if (concurrentHashMap2 != null) {
            concurrentHashMap2.clear();
            this.f245989c = null;
        }
        this.f245992g = 0;
    }

    public ServiceWebview a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ServiceWebview) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        ServiceWebview serviceWebview = (ServiceWebview) this.f245989c.remove(str);
        if (serviceWebview != null) {
            return serviceWebview;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f245986a, 2, "create new PageWebview when getServiceWebview");
        }
        return new ServiceWebview(this.f245991f);
    }

    public ProgressWebView a(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ProgressWebView) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3);
        }
        ProgressWebView progressWebView = (ProgressWebView) this.f245990d.remove(str);
        if (progressWebView == null) {
            if (QLog.isColorLevel()) {
                QLog.d(f245986a, 2, "create new PageWebview when getPageWebview");
            }
            progressWebView = new ProgressWebView(this.f245991f);
        } else if (QLog.isColorLevel()) {
            QLog.d(f245986a, 2, "get cache PageWebview when getPageWebview");
        }
        progressWebView.htmlId = i3;
        return progressWebView;
    }

    public void a(Activity activity, com.tencent.mobileqq.microapp.a.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity, (Object) cVar);
            return;
        }
        MutableContextWrapper mutableContextWrapper = new MutableContextWrapper(activity);
        PageWebview pageWebview = new PageWebview(mutableContextWrapper);
        pageWebview.apkgInfo$5475ea27 = cVar;
        pageWebview.loadHtml();
        this.f245988b.put(cVar.f245823d, pageWebview);
        if (this.f245990d.isEmpty()) {
            this.f245990d.put(cVar.f245823d, new ProgressWebView(mutableContextWrapper));
        }
    }

    private void a(WebView webView) {
        webView.stopLoading();
        webView.loadUrl("about:blank");
        webView.clearHistory();
        webView.clearView();
        webView.destroy();
        ((MutableContextWrapper) webView.getContext()).setBaseContext(BaseApplication.context);
    }

    public void a(ServiceWebview serviceWebview, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) serviceWebview, (Object) context);
            return;
        }
        if (!"about:blank".equals(serviceWebview.getUrl())) {
            try {
                serviceWebview.clearUp();
                a(serviceWebview);
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e(f245986a, 1, "destroy error:" + th5.getMessage());
                }
            }
        }
        ConcurrentHashMap concurrentHashMap = this.f245989c;
        if (concurrentHashMap == null || !concurrentHashMap.contains(serviceWebview)) {
            return;
        }
        this.f245989c.remove(serviceWebview);
    }

    public void a(PageWebview pageWebview, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) pageWebview, (Object) context);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(f245986a, 2, "----recyclePageWebview----");
        }
        com.tencent.mobileqq.microapp.app.b.a().a("hideKeyboard");
        if (pageWebview == null) {
            return;
        }
        if (!"about:blank".equals(pageWebview.getUrl())) {
            try {
                pageWebview.clearUp();
                a(pageWebview);
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e(f245986a, 1, "destroy error:" + th5.getMessage());
                }
            }
        }
        ConcurrentHashMap concurrentHashMap = this.f245988b;
        if (concurrentHashMap == null || !concurrentHashMap.contains(pageWebview)) {
            return;
        }
        this.f245988b.remove(pageWebview);
    }

    public void a(ProgressWebView progressWebView, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) progressWebView, (Object) context);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(f245986a, 2, "----recyclePageWebview----");
        }
        com.tencent.mobileqq.microapp.app.b.a().a("hideKeyboard");
        if (progressWebView == null) {
            return;
        }
        if (!"about:blank".equals(progressWebView.getUrl())) {
            try {
                a(progressWebView);
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e(f245986a, 1, "destroy error:" + th5.getMessage());
                }
            }
        }
        ConcurrentHashMap concurrentHashMap = this.f245990d;
        if (concurrentHashMap == null || !concurrentHashMap.contains(progressWebView)) {
            return;
        }
        this.f245990d.remove(progressWebView);
    }
}
