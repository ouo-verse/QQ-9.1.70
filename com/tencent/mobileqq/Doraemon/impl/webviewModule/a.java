package com.tencent.mobileqq.Doraemon.impl.webviewModule;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.Doraemon.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.u;
import com.tencent.mobileqq.webview.swift.y;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class a extends e {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    protected C7083a f154219b;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.Doraemon.impl.webviewModule.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C7083a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        WeakReference<CustomWebView> f154220a;

        /* renamed from: b, reason: collision with root package name */
        WeakReference<AppInterface> f154221b;

        /* renamed from: c, reason: collision with root package name */
        WeakReference<Activity> f154222c;

        /* renamed from: d, reason: collision with root package name */
        WeakReference<y> f154223d;

        /* renamed from: e, reason: collision with root package name */
        WeakReference<WebViewFragment> f154224e;

        public C7083a(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
                return;
            }
            this.f154223d = null;
            this.f154224e = null;
            this.f154222c = new WeakReference<>(activity);
        }

        public Activity a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Activity) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f154222c.get();
        }

        public AppInterface b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AppInterface) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            if (this.f154221b == null) {
                AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                if (runtime instanceof ToolAppRuntime) {
                    this.f154221b = new WeakReference<>((AppInterface) runtime.getAppRuntime("modular_web"));
                } else if (runtime instanceof AppInterface) {
                    this.f154221b = new WeakReference<>((AppInterface) runtime);
                } else {
                    this.f154221b = new WeakReference<>(null);
                }
            }
            return this.f154221b.get();
        }

        public WebViewFragment c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (WebViewFragment) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            if (this.f154224e == null) {
                ComponentCallbacks2 a16 = a();
                if (a16 instanceof u) {
                    this.f154224e = new WeakReference<>(((u) a16).getCurrentWebViewFragment());
                } else {
                    this.f154224e = new WeakReference<>(null);
                }
            }
            return this.f154224e.get();
        }

        public y d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (y) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            if (this.f154223d == null) {
                ComponentCallbacks2 a16 = a();
                if (a16 instanceof y) {
                    this.f154223d = new WeakReference<>((y) a16);
                } else {
                    this.f154223d = new WeakReference<>(c());
                }
            }
            return this.f154223d.get();
        }

        public CustomWebView e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CustomWebView) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            if (this.f154220a == null) {
                WebViewFragment c16 = c();
                if (c16 != null) {
                    this.f154220a = new WeakReference<>(c16.getWebView());
                } else {
                    this.f154220a = new WeakReference<>(null);
                }
            }
            return this.f154220a.get();
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.Doraemon.e
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f154219b = new C7083a(this.f154095a.j());
        }
    }
}
