package com.tencent.mobileqq.webview.injector;

import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.webview.swift.injector.i;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes35.dex */
public class f implements com.tencent.mobileqq.webview.swift.injector.i, sd2.b {

    /* renamed from: a, reason: collision with root package name */
    private volatile WeakReference<i.a> f313973a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.webview.swift.injector.g f313974a;

        a(com.tencent.mobileqq.webview.swift.injector.g gVar) {
            this.f313974a = gVar;
        }

        @Override // sd2.a
        public void onFail(String str) {
            QLog.e("SwiftBrowserCookieMonster", 1, "PskeyFetcher [pskey] onFail " + str);
            com.tencent.mobileqq.webview.swift.injector.g gVar = this.f313974a;
            if (gVar != null) {
                gVar.onFail(str);
            }
        }

        @Override // sd2.a
        public void onSuccess(Map<String, String> map) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("PskeyFetcher [pskey] onSuccess size: ");
            sb5.append(map != null ? map.size() : 0);
            QLog.d("SwiftBrowserCookieMonster", 1, sb5.toString());
            com.tencent.mobileqq.webview.swift.injector.g gVar = this.f313974a;
            if (gVar != null) {
                gVar.onSuccess(map);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class b implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.webview.swift.injector.g f313976a;

        b(com.tencent.mobileqq.webview.swift.injector.g gVar) {
            this.f313976a = gVar;
        }

        @Override // sd2.a
        public void onFail(String str) {
            QLog.e("SwiftBrowserCookieMonster", 1, "PskeyFetcher[uskey] onFail " + str);
            com.tencent.mobileqq.webview.swift.injector.g gVar = this.f313976a;
            if (gVar != null) {
                gVar.onFail(str);
            }
        }

        @Override // sd2.a
        public void onSuccess(Map<String, String> map) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("PskeyFetcher[uskey] onSuccess size: ");
            sb5.append(map != null ? map.size() : 0);
            QLog.d("SwiftBrowserCookieMonster", 1, sb5.toString());
            com.tencent.mobileqq.webview.swift.injector.g gVar = this.f313976a;
            if (gVar != null) {
                gVar.onSuccess(map);
            }
        }
    }

    private void g(String[] strArr, com.tencent.mobileqq.webview.swift.injector.g gVar, boolean z16) {
        IPskeyManager i3 = i();
        if (i3 == null) {
            return;
        }
        a aVar = new a(gVar);
        if (z16) {
            i3.replacePskey(strArr, aVar);
        } else {
            i3.getPskey(strArr, aVar);
        }
    }

    private void h(String[] strArr, com.tencent.mobileqq.webview.swift.injector.g gVar, boolean z16) {
        IPskeyManager i3 = i();
        if (i3 == null) {
            return;
        }
        b bVar = new b(gVar);
        if (z16) {
            i3.replaceUskey(strArr, bVar);
        } else {
            i3.getUskey(strArr, bVar);
        }
    }

    private IPskeyManager i() {
        AppRuntime appRuntime = MobileQQ.sMobileQQ.peekAppRuntime().getAppRuntime("modular_web");
        if (appRuntime == null) {
            QLog.e("SwiftBrowserCookieMonster", 1, "PskeyFetcher moduleAppRuntime is null");
            return null;
        }
        return (IPskeyManager) appRuntime.getRuntimeService(IPskeyManager.class, "all");
    }

    @Override // sd2.b
    public void a() {
        i.a aVar;
        if (this.f313973a == null || (aVar = this.f313973a.get()) == null) {
            return;
        }
        aVar.a();
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.i
    public void e(i.a aVar) {
        IPskeyManager i3 = i();
        if (i3 == null) {
            return;
        }
        if (aVar != null) {
            this.f313973a = new WeakReference<>(aVar);
            i3.registerPskeyListener(this);
        } else {
            i3.unregisterPskeyListener(this);
            this.f313973a = null;
        }
        QLog.i("SwiftBrowserCookieMonster", 1, String.format("PskeyFetcher setListener %s", aVar));
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.i
    public void b(String[] strArr, com.tencent.mobileqq.webview.swift.injector.g gVar) {
        g(strArr, gVar, true);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.i
    public void c(String[] strArr, com.tencent.mobileqq.webview.swift.injector.g gVar) {
        h(strArr, gVar, false);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.i
    public void d(String[] strArr, com.tencent.mobileqq.webview.swift.injector.g gVar) {
        g(strArr, gVar, false);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.i
    public void f(String[] strArr, com.tencent.mobileqq.webview.swift.injector.g gVar) {
        h(strArr, gVar, true);
    }
}
