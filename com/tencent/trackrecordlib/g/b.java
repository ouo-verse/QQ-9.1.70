package com.tencent.trackrecordlib.g;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.trackrecordlib.core.a;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final String f381132a;

    /* renamed from: b, reason: collision with root package name */
    private static a.InterfaceC10017a f381133b;

    /* renamed from: c, reason: collision with root package name */
    private static Application.ActivityLifecycleCallbacks f381134c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11666);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f381132a = b.class.getSimpleName();
            f381134c = new Application.ActivityLifecycleCallbacks() { // from class: com.tencent.trackrecordlib.g.b.1
                static IPatchRedirector $redirector_;

                {
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
                    } else {
                        com.tencent.trackrecordlib.a.a.f().a(activity, bundle);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                        iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
                        return;
                    }
                    com.tencent.trackrecordlib.a.a.f().c(activity);
                    if (activity.getClass().getName().equals(b.a())) {
                        com.tencent.trackrecordlib.core.c.a().e();
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
                    } else {
                        com.tencent.trackrecordlib.a.a.f().e(activity);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
                        return;
                    }
                    com.tencent.trackrecordlib.a.a.f().d(activity);
                    if (b.f381133b != null && b.b().equals(b.a())) {
                        b.f381133b.a(activity.getWindow().getDecorView());
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                        iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity, (Object) bundle);
                    } else {
                        com.tencent.trackrecordlib.a.a.f().b(activity, bundle);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
                    } else {
                        com.tencent.trackrecordlib.a.a.f().f(activity);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                        iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
                    } else {
                        com.tencent.trackrecordlib.a.a.f().g(activity);
                    }
                }
            };
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(Context context, a.InterfaceC10017a interfaceC10017a) {
        f381133b = interfaceC10017a;
        ((Application) context).registerActivityLifecycleCallbacks(f381134c);
    }

    public static String b() {
        return com.tencent.trackrecordlib.a.a.f().b();
    }

    public static String c() {
        return com.tencent.trackrecordlib.a.a.f().c();
    }

    public static String d() {
        return com.tencent.trackrecordlib.a.a.f().d();
    }

    public static void a(Context context) {
        ((Application) context).unregisterActivityLifecycleCallbacks(f381134c);
    }

    public static void a(String str) {
        com.tencent.trackrecordlib.a.a.f().a(str);
    }

    public static void a(Activity activity) {
        com.tencent.trackrecordlib.a.a.f().a(activity);
        com.tencent.trackrecordlib.a.a.f().b(activity);
    }

    public static String a() {
        return com.tencent.trackrecordlib.a.a.f().a();
    }
}
