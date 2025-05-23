package com.tencent.turingfd.sdk.xq;

import android.app.Activity;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* renamed from: com.tencent.turingfd.sdk.xq.native, reason: invalid class name */
/* loaded from: classes27.dex */
public class Cnative {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final WeakHashMap<Activity, Object> f383401a;

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReference<Cdo> f383402b;

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.native$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static class Cdo extends Cif implements Ctry, Seedless {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f383403a;

        /* renamed from: b, reason: collision with root package name */
        public final Cthrow f383404b;

        public Cdo(Cthrow cthrow) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cthrow);
            } else {
                this.f383403a = new AtomicBoolean(false);
                this.f383404b = cthrow;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            } else {
                this.f383403a.set(true);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Window window;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
                return;
            }
            if (activity != null && (window = activity.getWindow()) != null) {
                String name = activity.getClass().getName();
                try {
                    WeakHashMap<Activity, Object> weakHashMap = Cnative.f383401a;
                    if (!weakHashMap.containsKey(activity)) {
                        weakHashMap.put(activity, null);
                        Window.Callback callback = window.getCallback();
                        if (callback != null && !(callback instanceof n)) {
                            window.setCallback(new n(callback, name, this));
                        }
                        ViewTreeObserver viewTreeObserver = window.getDecorView().getViewTreeObserver();
                        if (viewTreeObserver != null) {
                            viewTreeObserver.addOnPreDrawListener(new Cimport(window, this, name));
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            this.f383403a.set(false);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14305);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f383401a = new WeakHashMap<>();
            f383402b = new AtomicReference<>(null);
        }
    }
}
