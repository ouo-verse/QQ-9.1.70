package com.tencent.mobileqq.webview.swift.utils;

import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.SandBoxControl;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsDownloader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SwiftBrowserIdleTaskHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static long f314708c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile int f314709d;

    /* renamed from: e, reason: collision with root package name */
    private static SwiftBrowserIdleTaskHelper f314710e;

    /* renamed from: f, reason: collision with root package name */
    static WeakReference<com.tencent.mobileqq.webview.util.j> f314711f;

    /* renamed from: g, reason: collision with root package name */
    private static final ArrayList<b> f314712g;

    /* renamed from: a, reason: collision with root package name */
    boolean f314713a;

    /* renamed from: b, reason: collision with root package name */
    final MessageQueue.IdleHandler f314714b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements TbsDownloader.TbsDownloaderCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback
        public void onNeedDownloadFinish(boolean z16, int i3) {
            WeakReference<com.tencent.mobileqq.webview.util.j> weakReference;
            com.tencent.mobileqq.webview.util.j jVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            } else if (z16 && (weakReference = SwiftBrowserIdleTaskHelper.f314711f) != null && (jVar = weakReference.get()) != null) {
                jVar.d(false);
                QLog.i("SwiftBrowserIdleTaskHelper", 1, "call downloadX5Kernel on callback:download tbs.");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static abstract class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final int f314716a;

        public b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.f314716a = i3;
            }
        }

        public abstract int a();
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class c extends b {
        static IPatchRedirector $redirector_;

        public c(int i3) {
            super(i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper.b
        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            if (WebAccelerateHelper.preloadBrowserView == null) {
                WebAccelerateHelper.preInflaterBrowserView();
                if (QLog.isColorLevel()) {
                    QLog.d("SwiftBrowserIdleTaskHelper", 2, "preloadBrowserView on idle.");
                }
                return 2;
            }
            if (SwiftReuseTouchWebView.I == 0 && m.e() && !SandBoxControl.g()) {
                QLog.d("SwiftBrowserIdleTaskHelper", 1, "[webViewReuse] preload WebView on idle.");
                SwiftReuseTouchWebView.q(BaseApplication.getContext()).t(true);
                return 2;
            }
            if (SwiftBrowserIdleTaskHelper.f314709d < 5) {
                long currentTimeMillis = System.currentTimeMillis();
                if (System.currentTimeMillis() > SwiftBrowserIdleTaskHelper.f314708c + 10000) {
                    SwiftBrowserIdleTaskHelper.g();
                    SwiftBrowserIdleTaskHelper.f314709d++;
                    SwiftBrowserIdleTaskHelper.f314708c = currentTimeMillis;
                } else if (QLog.isColorLevel()) {
                    QLog.d("SwiftBrowserIdleTaskHelper", 2, "not need check because time limit:" + currentTimeMillis + " - " + SwiftBrowserIdleTaskHelper.f314708c + " < 10s.");
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("SwiftBrowserIdleTaskHelper", 2, "not need check because count limit:" + SwiftBrowserIdleTaskHelper.f314709d + ">=5.");
            }
            return 1;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49415);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f314708c = 0L;
        f314709d = 0;
        f314712g = new ArrayList<>(5);
    }

    SwiftBrowserIdleTaskHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f314713a = false;
            this.f314714b = new MessageQueue.IdleHandler() { // from class: com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SwiftBrowserIdleTaskHelper.this);
                    }
                }

                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this)).booleanValue();
                    }
                    while (true) {
                        if (SwiftBrowserIdleTaskHelper.f314712g.isEmpty()) {
                            break;
                        }
                        b bVar = (b) SwiftBrowserIdleTaskHelper.f314712g.remove(0);
                        int a16 = bVar.a();
                        if (2 == a16) {
                            SwiftBrowserIdleTaskHelper.f314712g.add(bVar);
                            break;
                        }
                        if (1 == a16) {
                            break;
                        }
                    }
                    SwiftBrowserIdleTaskHelper.this.f314713a = !SwiftBrowserIdleTaskHelper.f314712g.isEmpty();
                    return SwiftBrowserIdleTaskHelper.this.f314713a;
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.utils.e
                @Override // java.lang.Runnable
                public final void run() {
                    SwiftBrowserIdleTaskHelper.g();
                }
            }, 16, null, true);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserIdleTaskHelper", 2, "downloadX5KernelIfNeeded on idle.");
        }
        try {
            com.tencent.mobileqq.webview.util.s.a("downloadX5KernelIfNeeded");
            com.tencent.mobileqq.webview.util.j jVar = f314711f.get();
            if (jVar != null) {
                String tBSDpcParam = WebAccelerateHelper.getInstance().getTBSDpcParam();
                if (tBSDpcParam != null && tBSDpcParam.charAt(0) == '1' && LocaleManager.MOBILE_COUNTRY_CODE_CN_STR.equals(Locale.getDefault().getCountry())) {
                    if (TbsDownloader.needDownload(BaseApplication.getContext(), false, false, new a())) {
                        jVar.d(false);
                        QLog.i("SwiftBrowserIdleTaskHelper", 1, "call downloadX5Kernel on idle:download tbs.");
                    }
                } else {
                    f314709d = 5;
                    QLog.i("SwiftBrowserIdleTaskHelper", 1, "call downloadX5Kernel on idle: no need download tbs.");
                }
            }
            com.tencent.mobileqq.webview.util.s.b("downloadX5KernelIfNeeded");
        } catch (Throwable th5) {
            QLog.e("SwiftBrowserIdleTaskHelper", 1, "downloadX5Kernel error:" + th5.getMessage());
            com.tencent.mobileqq.webview.util.s.b("downloadX5KernelIfNeeded");
        }
    }

    public static SwiftBrowserIdleTaskHelper h() {
        if (f314710e == null) {
            synchronized (SwiftBrowserIdleTaskHelper.class) {
                if (f314710e == null) {
                    f314710e = new SwiftBrowserIdleTaskHelper();
                }
            }
        }
        return f314710e;
    }

    public static void j(com.tencent.mobileqq.webview.util.j jVar) {
        f314711f = new WeakReference<>(jVar);
    }

    public void f(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Iterator<b> it = f314712g.iterator();
            while (it.hasNext()) {
                if (it.next().f314716a == bVar.f314716a) {
                    return;
                }
            }
            ArrayList<b> arrayList = f314712g;
            arrayList.add(bVar);
            if (!arrayList.isEmpty() && !this.f314713a) {
                this.f314713a = true;
                Looper.myQueue().addIdleHandler(this.f314714b);
            }
        }
    }

    public boolean i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, i3)).booleanValue();
        }
        Iterator<b> it = f314712g.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f314716a == i3) {
                f314712g.remove(next);
                return true;
            }
        }
        return false;
    }
}
