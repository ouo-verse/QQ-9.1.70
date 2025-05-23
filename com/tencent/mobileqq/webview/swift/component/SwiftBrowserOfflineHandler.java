package com.tencent.mobileqq.webview.swift.component;

import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.biz.webviewplugin.OfflineWebResManager;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SwiftBrowserOfflineHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static final LruCache<String, SwiftBrowserOfflineHandler> f314264f;

    /* renamed from: g, reason: collision with root package name */
    public static final AtomicInteger f314265g;

    /* renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f314266a;

    /* renamed from: b, reason: collision with root package name */
    public final AuthorizeConfig f314267b;

    /* renamed from: c, reason: collision with root package name */
    public String f314268c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicInteger f314269d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicInteger f314270e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements ThreadExcutor.IThreadListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftBrowserOfflineHandler.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
        public void onAdded() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
        public void onPostRun() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
        public void onPreRun() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
        void onCheckOfflineFinish(int i3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49222);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f314264f = new LruCache<>(8);
            f314265g = new AtomicInteger(1);
        }
    }

    SwiftBrowserOfflineHandler(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f314266a = new CopyOnWriteArrayList<>();
        this.f314269d = new AtomicInteger(0);
        this.f314270e = new AtomicInteger(1);
        this.f314268c = str;
        this.f314267b = AuthorizeConfig.y();
    }

    public static synchronized SwiftBrowserOfflineHandler c(String str) {
        SwiftBrowserOfflineHandler swiftBrowserOfflineHandler;
        synchronized (SwiftBrowserOfflineHandler.class) {
            if (!TextUtils.isEmpty(str)) {
                LruCache<String, SwiftBrowserOfflineHandler> lruCache = f314264f;
                swiftBrowserOfflineHandler = lruCache.get(str);
                if (swiftBrowserOfflineHandler == null) {
                    swiftBrowserOfflineHandler = new SwiftBrowserOfflineHandler(str);
                    lruCache.put(str, swiftBrowserOfflineHandler);
                }
            } else {
                swiftBrowserOfflineHandler = null;
            }
        }
        return swiftBrowserOfflineHandler;
    }

    public static synchronized SwiftBrowserOfflineHandler d(String str) {
        synchronized (SwiftBrowserOfflineHandler.class) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("http") && !str.startsWith("https")) {
                return null;
            }
            String str2 = "";
            try {
                Uri parse = Uri.parse(str);
                if (parse.isHierarchical()) {
                    str2 = parse.getQueryParameter("_bid");
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            return c(str2);
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (f314265g.compareAndSet(1, 2)) {
            String x16 = this.f314267b.x("ex_offline", "");
            if (!TextUtils.isEmpty(x16)) {
                String[] split = x16.split(",");
                String str = Build.BRAND;
                String model = DeviceInfoMonitor.getModel();
                String str2 = Build.VERSION.RELEASE;
                StringBuffer stringBuffer = new StringBuffer(str);
                stringBuffer.append(" ");
                stringBuffer.append(model);
                String lowerCase = stringBuffer.toString().toLowerCase();
                stringBuffer.append(" ");
                stringBuffer.append(str2);
                String lowerCase2 = stringBuffer.toString().toLowerCase();
                for (String str3 : split) {
                    String lowerCase3 = str3.toLowerCase();
                    if (lowerCase3.contains(lowerCase) && lowerCase2.startsWith(lowerCase3)) {
                        QLog.e("SwiftBrowserOfflineHandler", 1, "*****offline can not use!!! " + lowerCase2);
                        f314265g.compareAndSet(2, 4);
                        return;
                    }
                }
            }
            f314265g.compareAndSet(2, 3);
        }
    }

    public void b(b bVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar, (Object) str);
            return;
        }
        if (this.f314270e.get() == 3 && bVar != null) {
            if (QLog.isColorLevel()) {
                QLog.i("SwiftBrowserOfflineHandler", 2, "now offline bid is ready, " + this.f314268c + ", mode is " + this.f314269d.get());
            }
            bVar.onCheckOfflineFinish(this.f314269d.get());
            return;
        }
        if (bVar != null && !this.f314266a.contains(bVar)) {
            this.f314266a.add(bVar);
        }
        Runnable runnable = new Runnable(str) { // from class: com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f314271d;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler$1$a */
            /* loaded from: classes20.dex */
            class a implements com.tencent.biz.common.offline.b {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ long f314272a;

                a(long j3) {
                    this.f314272a = j3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, AnonymousClass1.this, Long.valueOf(j3));
                    }
                }

                @Override // com.tencent.biz.common.offline.b
                public void loaded(int i3, String str) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                        return;
                    }
                    SwiftBrowserOfflineHandler.this.f314269d.set(i3);
                    if (QLog.isColorLevel()) {
                        QLog.i("SwiftBrowserOfflineHandler", 2, "now offline bid has checked, bid " + SwiftBrowserOfflineHandler.this.f314268c + ", loadMode: " + SwiftBrowserOfflineHandler.this.f314269d.get() + ", cost: " + (System.currentTimeMillis() - this.f314272a));
                    }
                    if (i3 != 0) {
                        OfflinePlugin.z(SwiftBrowserOfflineHandler.this.f314268c);
                        OfflineWebResManager.b(AnonymousClass1.this.f314271d);
                    }
                    SwiftBrowserOfflineHandler.this.f();
                }
            }

            {
                this.f314271d = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SwiftBrowserOfflineHandler.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion() && !((Boolean) com.tencent.mobileqq.webview.util.t.j().b("enableOffline", Boolean.TRUE)).booleanValue()) {
                    QLog.i("SwiftBrowserOfflineHandler", 1, "debug version can not use offline!");
                    SwiftBrowserOfflineHandler.this.f();
                    return;
                }
                SwiftBrowserOfflineHandler.this.a();
                long currentTimeMillis = System.currentTimeMillis();
                if (SwiftBrowserOfflineHandler.f314265g.get() == 3) {
                    z16 = HtmlOffline.N(BaseApplication.getContext().getApplicationContext(), this.f314271d, new a(currentTimeMillis));
                } else {
                    z16 = false;
                }
                if (!z16) {
                    SwiftBrowserOfflineHandler.this.f();
                }
            }
        };
        if (this.f314270e.compareAndSet(1, 2)) {
            if (QLog.isColorLevel()) {
                QLog.i("SwiftBrowserOfflineHandler", 2, "post thread to check offline, bid = " + this.f314268c);
            }
            ThreadManagerV2.postImmediately(runnable, new a(), false);
        }
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.f314270e.get() == 3) {
            return true;
        }
        return false;
    }

    void f() {
        this.f314270e.compareAndSet(2, 3);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftBrowserOfflineHandler.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (QLog.isColorLevel() && SwiftBrowserOfflineHandler.this.f314266a.size() != 0) {
                    QLog.i("SwiftBrowserOfflineHandler", 2, "now post offline callback, bid is " + SwiftBrowserOfflineHandler.this.f314268c + ", mode: " + SwiftBrowserOfflineHandler.this.f314269d.get());
                }
                Iterator<b> it = SwiftBrowserOfflineHandler.this.f314266a.iterator();
                while (it.hasNext()) {
                    it.next().onCheckOfflineFinish(SwiftBrowserOfflineHandler.this.f314269d.get());
                }
                SwiftBrowserOfflineHandler.this.f314266a.clear();
            }
        });
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.w("SwiftBrowserOfflineHandler", 1, "now reset bid cache! " + this.f314268c);
        this.f314269d.set(0);
        this.f314270e.set(1);
    }
}
