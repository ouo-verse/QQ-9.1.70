package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.smtt.sdk.WebView;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_browser_component_map.yml", version = 1)
    public static HashMap<String, Class<? extends C8976b>> f314434f;

    /* renamed from: a, reason: collision with root package name */
    final e f314435a;

    /* renamed from: b, reason: collision with root package name */
    final int f314436b;

    /* renamed from: c, reason: collision with root package name */
    final ConcurrentHashMap<Integer, Object> f314437c;

    /* renamed from: d, reason: collision with root package name */
    final d f314438d;

    /* renamed from: e, reason: collision with root package name */
    private c f314439e;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.component.b.c
        public Activity getActivity() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Activity) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return b.this.f314435a.getHostActivity();
        }

        @Override // com.tencent.mobileqq.webview.swift.component.b.c
        public b getProvider() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (b) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return b.this;
        }

        @Override // com.tencent.mobileqq.webview.swift.component.b.c
        public WebView getWebView() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (WebView) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return b.this.f314435a.getHostWebView();
        }

        @Override // com.tencent.mobileqq.webview.swift.component.b.c
        public WebViewProvider getWebViewProvider() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (WebViewProvider) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return b.this.f314435a.getWebViewProvider();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.webview.swift.component.b$b, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static class C8976b {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        protected c f314441d;

        public C8976b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        public void f(int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) bundle);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface c {
        Activity getActivity();

        b getProvider();

        WebView getWebView();

        WebViewProvider getWebViewProvider();
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface d {
        Object a(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface e {
        Activity getHostActivity();

        WebView getHostWebView();

        WebViewProvider getWebViewProvider();
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface f {
        b getComponentProvider();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49185);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        HashMap<String, Class<? extends C8976b>> hashMap = new HashMap<>();
        f314434f = hashMap;
        hashMap.put("512", com.tencent.mobileqq.webview.swift.component.a.class);
        f314434f.put("256", z.class);
        f314434f.put("128", y.class);
        f314434f.put(IPreloadResource.ABI_64, SwiftBrowserScreenShotHandler.class);
        f314434f.put("32", SwiftBrowserMiscHandler.class);
        f314434f.put("16", SwiftBrowserTBSHandler.class);
        f314434f.put("8", SwiftBrowserLongClickHandler.class);
        f314434f.put("4", SwiftBrowserShareMenuHandler.class);
        f314434f.put("2", v.class);
        f314434f.put("1", com.tencent.mobileqq.webview.swift.component.e.class);
        f314434f.put("-3", com.tencent.mobileqq.webview.swift.component.c.class);
        f314434f.put("-2", SwiftBrowserStatistics.class);
        f314434f.put("-1", com.tencent.mobileqq.webview.swift.component.f.class);
    }

    public b(e eVar, int i3, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, eVar, Integer.valueOf(i3), dVar);
            return;
        }
        this.f314439e = new a();
        this.f314435a = eVar;
        this.f314436b = i3;
        this.f314438d = dVar;
        int i16 = 0;
        for (int i17 = 0; i17 < 32; i17++) {
            if (((1 << i17) & i3) != 0) {
                i16++;
            }
        }
        this.f314437c = new ConcurrentHashMap<>(i16);
    }

    public synchronized <T> T a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        if (i3 >= 0 && (this.f314436b & i3) == 0) {
            return null;
        }
        T t16 = (T) this.f314437c.get(Integer.valueOf(i3));
        if (t16 == null) {
            d dVar = this.f314438d;
            if (dVar != null) {
                t16 = (T) dVar.a(i3);
            }
            if (t16 == null) {
                Class<? extends C8976b> cls = f314434f.get(String.valueOf(i3));
                if (cls != null) {
                    try {
                        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion() || i3 != -3) {
                            t16 = (T) cls.newInstance();
                        }
                    } catch (IllegalAccessException e16) {
                        e16.printStackTrace();
                    } catch (InstantiationException e17) {
                        e17.printStackTrace();
                    }
                } else {
                    throw new InvalidParameterException("componentFlag:" + i3 + " cannot create, please check!");
                }
            }
            if (t16 instanceof C8976b) {
                C8976b c8976b = t16;
                c8976b.f314441d = this.f314439e;
                c8976b.e();
            }
            this.f314437c.put(Integer.valueOf(i3), t16);
        }
        return t16;
    }

    public void b(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) bundle);
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        for (Object obj : this.f314437c.values()) {
            if (obj instanceof C8976b) {
                ((C8976b) obj).f(i3, bundle);
            }
        }
    }
}
