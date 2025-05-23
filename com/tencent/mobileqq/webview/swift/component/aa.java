package com.tencent.mobileqq.webview.swift.component;

import com.tencent.mobileqq.data.PreloadCookie;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class aa {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public AppRuntime f314432a;

    /* renamed from: b, reason: collision with root package name */
    public EntityManager f314433b;

    public aa(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
            return;
        }
        this.f314432a = appRuntime;
        EntityManagerFactory entityManagerFactory = appRuntime.getEntityManagerFactory();
        if (entityManagerFactory != null) {
            this.f314433b = entityManagerFactory.createEntityManager();
        }
    }

    public void a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (this.f314433b == null) {
            QLog.i("SwiftPreloadCookieManager", 1, "getTopDomain mEM empty");
            if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
                return;
            } else {
                throw new RuntimeException("SwiftPreloadCookieManager deleteHost mEM empty");
            }
        }
        synchronized (aa.class) {
            PreloadCookie preloadCookie = (PreloadCookie) DBMethodProxy.find(this.f314433b, (Class<? extends Entity>) PreloadCookie.class, str, str2);
            if (preloadCookie != null) {
                if (QLog.isColorLevel()) {
                    QLog.i("SwiftPreloadCookieManager", 2, "delete host: " + str + ", type: " + str2);
                }
                this.f314433b.remove(preloadCookie);
            }
        }
    }

    public List<String> b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (this.f314433b == null) {
            QLog.i("SwiftPreloadCookieManager", 1, "getTopDomain mEM empty");
            if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
                return null;
            }
            throw new RuntimeException("SwiftPreloadCookieManager getTopDomain mEM empty");
        }
        synchronized (aa.class) {
            int i3 = 0;
            List<? extends Entity> query = this.f314433b.query(PreloadCookie.class, false, "cookieKey=?", new String[]{str}, null, null, "hitCount DESC", "10");
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[2];
                objArr[0] = str;
                if (query != null) {
                    i3 = query.size();
                }
                objArr[1] = Integer.valueOf(i3);
                QLog.i("SwiftPreloadCookieManager", 2, String.format("now select records for cookieKey: %s, size: %d", objArr));
            }
            if (query == null || query.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<? extends Entity> it = query.iterator();
            while (it.hasNext()) {
                arrayList.add(((PreloadCookie) it.next()).host);
            }
            return arrayList;
        }
    }

    public void c(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (this.f314433b == null) {
            QLog.i("SwiftPreloadCookieManager", 1, "getTopDomain mEM empty");
            if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
                return;
            } else {
                throw new RuntimeException("SwiftPreloadCookieManager insertOrUpdateHost mEM empty");
            }
        }
        synchronized (aa.class) {
            PreloadCookie preloadCookie = (PreloadCookie) DBMethodProxy.find(this.f314433b, (Class<? extends Entity>) PreloadCookie.class, str, str2);
            if (preloadCookie != null) {
                if (QLog.isColorLevel()) {
                    QLog.i("SwiftPreloadCookieManager", 2, String.format("update host: %s, cookieKey: %s , hitCount: %d ", str, str2, Long.valueOf(preloadCookie.hitCount + 1)));
                }
                preloadCookie.hitCount++;
                this.f314433b.update(preloadCookie);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i("SwiftPreloadCookieManager", 2, String.format("insert host: %s, cookieKey: %s", str, str2));
                }
                PreloadCookie preloadCookie2 = new PreloadCookie();
                preloadCookie2.host = str;
                preloadCookie2.cookieKey = str2;
                preloadCookie2.hitCount = 1L;
                this.f314433b.persist(preloadCookie2);
            }
        }
    }
}
