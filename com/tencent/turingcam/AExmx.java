package com.tencent.turingcam;

import android.app.Activity;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AExmx {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final WeakHashMap<Activity, Object> f381719a;

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReference<spXPg> f381720b;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class spXPg extends tIu8Z implements XSZyU, eDqyI {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f381721a;

        /* renamed from: b, reason: collision with root package name */
        public final RCWe2 f381722b;

        public spXPg(RCWe2 rCWe2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) rCWe2);
            } else {
                this.f381721a = new AtomicBoolean(false);
                this.f381722b = rCWe2;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            } else {
                this.f381721a.set(true);
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
                    WeakHashMap<Activity, Object> weakHashMap = AExmx.f381719a;
                    if (!weakHashMap.containsKey(activity)) {
                        weakHashMap.put(activity, null);
                        Window.Callback callback = window.getCallback();
                        if (callback != null && !(callback instanceof OViPc)) {
                            window.setCallback(new OViPc(callback, name, this));
                        }
                        ViewTreeObserver viewTreeObserver = window.getDecorView().getViewTreeObserver();
                        if (viewTreeObserver != null) {
                            viewTreeObserver.addOnPreDrawListener(new yio3k(window, this, name));
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            this.f381721a.set(false);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19625);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f381719a = new WeakHashMap<>();
            f381720b = new AtomicReference<>(null);
        }
    }
}
