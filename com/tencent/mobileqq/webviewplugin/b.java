package com.tencent.mobileqq.webviewplugin;

import android.app.Activity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import u43.a;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b extends WebViewPlugin {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final String f315054d;

    /* renamed from: e, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Business/Webview/Inject_web_interceptor.yml", version = 1)
    public static ArrayList<u43.a> f315055e;

    /* renamed from: f, reason: collision with root package name */
    private static ArrayList f315056f;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private static class a implements a.InterfaceC11322a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        WeakReference<Activity> f315057a;

        /* renamed from: b, reason: collision with root package name */
        WeakReference<CustomWebView> f315058b;

        /* renamed from: c, reason: collision with root package name */
        String f315059c;

        /* renamed from: d, reason: collision with root package name */
        boolean f315060d;

        a(String str, Activity activity, CustomWebView customWebView, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, activity, customWebView, Boolean.valueOf(z16));
                return;
            }
            this.f315060d = false;
            this.f315057a = new WeakReference<>(activity);
            this.f315058b = new WeakReference<>(customWebView);
            this.f315059c = str;
            this.f315060d = z16;
        }

        @Override // u43.a.InterfaceC11322a
        public Activity getActivity() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Activity) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f315057a.get();
        }

        @Override // u43.a.InterfaceC11322a
        public void resume() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            CustomWebView customWebView = this.f315058b.get();
            Activity activity = this.f315057a.get();
            if (customWebView != null && activity != null && !activity.isFinishing()) {
                QLog.i("WebInterceptPlugin", 1, "resume loadUrl: " + com.tencent.mobileqq.webview.util.s.d(this.f315059c, new String[0]));
                if (this.f315060d) {
                    customWebView.loadUrlOriginal(this.f315059c);
                } else {
                    customWebView.loadUrl(this.f315059c);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49615);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f315056f = arrayList;
        arrayList.add(StudyModeWebInterceptor.class);
        f315054d = b.class.getSimpleName();
        f315055e = new ArrayList<>();
        p();
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @QAutoInitMethod
    private static void p() {
        com.tencent.mobileqq.qroute.utils.b.c(f315056f, f315055e);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "interceptor";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).longValue();
        }
        return 2048L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        Activity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, str, Long.valueOf(j3), map)).booleanValue();
        }
        if (j3 == 2048) {
            WebViewPlugin.b bVar = this.mRuntime;
            CustomWebView customWebView = null;
            if (bVar != null) {
                activity = bVar.a();
            } else {
                activity = null;
            }
            WebViewPlugin.b bVar2 = this.mRuntime;
            if (bVar2 != null) {
                customWebView = bVar2.e();
            }
            if (activity != null && customWebView != null) {
                if (f315055e.size() == 0) {
                    QLog.d("WebInterceptPlugin", 1, "handleEvent sGlobalInterceptors == 0, return");
                    return false;
                }
                a aVar = new a(str, activity, customWebView, ((Boolean) map.get(WebViewPlugin.KEY_ORIGINAL_LOAD)).booleanValue());
                Iterator<u43.a> it = f315055e.iterator();
                while (it.hasNext()) {
                    u43.a next = it.next();
                    if (next.a(str, activity, aVar)) {
                        QLog.i("WebInterceptPlugin", 1, "handleEvent url is intercepted by: " + next + ", url: " + com.tencent.mobileqq.webview.util.s.d(str, new String[0]));
                        return true;
                    }
                }
            } else {
                QLog.w("WebInterceptPlugin", 1, "handleEvent act|wv is null, return.");
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onDestroy();
        }
    }
}
