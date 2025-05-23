package com.tencent.msdk.dns.c.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static List<com.tencent.msdk.dns.c.b.a> f336224a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f336225b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a implements Application.ActivityLifecycleCallbacks {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) bundle);
                return;
            }
            com.tencent.msdk.dns.base.log.c.c("%s.onCreate", activity);
            Iterator it = b.f336224a.iterator();
            while (it.hasNext()) {
                ((com.tencent.msdk.dns.c.b.a) it.next()).b(activity, bundle);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
                return;
            }
            com.tencent.msdk.dns.base.log.c.c("%s.onDestroy", activity);
            Iterator it = b.f336224a.iterator();
            while (it.hasNext()) {
                ((com.tencent.msdk.dns.c.b.a) it.next()).a(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
                return;
            }
            com.tencent.msdk.dns.base.log.c.c("%s.onPause", activity);
            Iterator it = b.f336224a.iterator();
            while (it.hasNext()) {
                ((com.tencent.msdk.dns.c.b.a) it.next()).c(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
                return;
            }
            com.tencent.msdk.dns.base.log.c.c("%s.onResume", activity);
            Iterator it = b.f336224a.iterator();
            while (it.hasNext()) {
                ((com.tencent.msdk.dns.c.b.a) it.next()).e(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity, (Object) bundle);
                return;
            }
            com.tencent.msdk.dns.base.log.c.c("%s.onSaveInstanceState", activity);
            Iterator it = b.f336224a.iterator();
            while (it.hasNext()) {
                ((com.tencent.msdk.dns.c.b.a) it.next()).d(activity, bundle);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
                return;
            }
            com.tencent.msdk.dns.base.log.c.c("%s.onStart", activity);
            Iterator it = b.f336224a.iterator();
            while (it.hasNext()) {
                ((com.tencent.msdk.dns.c.b.a) it.next()).f(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
                return;
            }
            com.tencent.msdk.dns.base.log.c.c("%s.onStop", activity);
            Iterator it = b.f336224a.iterator();
            while (it.hasNext()) {
                ((com.tencent.msdk.dns.c.b.a) it.next()).g(activity);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16433);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f336224a = Collections.emptyList();
            f336225b = false;
        }
    }

    @TargetApi(14)
    private static void b(Context context) {
        Application a16 = c.a(context);
        if (a16 != null) {
            f336225b = true;
            a16.registerActivityLifecycleCallbacks(new a());
        }
    }

    public static synchronized boolean c(com.tencent.msdk.dns.c.b.a aVar) {
        boolean z16;
        synchronized (b.class) {
            if (f336225b) {
                if (f336224a.isEmpty()) {
                    f336224a = new ArrayList();
                }
                f336224a.add(aVar);
            }
            z16 = f336225b;
        }
        return z16;
    }

    public static void d(Context context) {
        b(context);
    }
}
