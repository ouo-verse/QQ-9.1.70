package com.tencent.tfd.sdk.wxa;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.Window;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class ComaBerenices {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f375557a = false;

    /* renamed from: b, reason: collision with root package name */
    public static Cnew f375558b;

    /* renamed from: c, reason: collision with root package name */
    public static final Set<Crux> f375559c;

    /* renamed from: d, reason: collision with root package name */
    public static final Set<com.tencent.tfd.sdk.wxa.Cfor> f375560d;

    /* renamed from: e, reason: collision with root package name */
    public static Celse f375561e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f375562f;

    /* renamed from: g, reason: collision with root package name */
    public static final Set<String> f375563g;

    /* renamed from: h, reason: collision with root package name */
    public static final Cdo f375564h;

    /* renamed from: i, reason: collision with root package name */
    public static final Cif f375565i;

    /* renamed from: j, reason: collision with root package name */
    public static final Cfor f375566j;

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.ComaBerenices$do, reason: invalid class name */
    /* loaded from: classes26.dex */
    public class Cdo extends com.tencent.tfd.sdk.wxa.Cdo {
        static IPatchRedirector $redirector_;

        public Cdo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.HashSet, java.util.Set<java.lang.String>] */
        @Override // com.tencent.tfd.sdk.wxa.Cdo
        public final void a(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
                return;
            }
            if (ComaBerenices.f375563g.contains(activity.getClass().getName()) || ComaBerenices.f375562f) {
                try {
                    Cif cif = ComaBerenices.f375565i;
                    Window window = activity.getWindow();
                    String name = activity.getClass().getName();
                    Window.Callback callback = window.getCallback();
                    if (callback != null && !(callback instanceof Gooseberry)) {
                        window.setCallback(new Gooseberry(callback, cif, name));
                    }
                    Window window2 = activity.getWindow();
                    window2.getDecorView().getViewTreeObserver().addOnPreDrawListener(new com.tencent.tfd.sdk.wxa.Cnew(window2, activity.getClass().getName(), ComaBerenices.f375566j));
                } catch (Throwable unused) {
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            } else {
                ComaBerenices.f375561e.onActivityPaused(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            } else {
                a(activity);
                ComaBerenices.f375561e.onActivityResumed(activity);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.ComaBerenices$for, reason: invalid class name */
    /* loaded from: classes26.dex */
    public class Cfor implements com.tencent.tfd.sdk.wxa.Cfor {
        static IPatchRedirector $redirector_;

        public Cfor() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Set<com.tencent.tfd.sdk.wxa.for>, java.util.concurrent.CopyOnWriteArraySet] */
        @Override // com.tencent.tfd.sdk.wxa.Cfor
        public final void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            Iterator it = ComaBerenices.f375560d.iterator();
            while (it.hasNext()) {
                ((com.tencent.tfd.sdk.wxa.Cfor) it.next()).a(str);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.ComaBerenices$if, reason: invalid class name */
    /* loaded from: classes26.dex */
    public class Cif implements Berry {
        static IPatchRedirector $redirector_;

        public Cif() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final void a(String str, MotionEvent motionEvent) {
            Cygnus cygnus;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) motionEvent);
                return;
            }
            synchronized (Cygnus.f375577m) {
                int i3 = Cygnus.f375576l;
                if (i3 > 0) {
                    cygnus = Cygnus.f375575k;
                    Cygnus.f375575k = cygnus.f375578a;
                    cygnus.f375578a = null;
                    cygnus.f375579b = false;
                    Cygnus.f375576l = i3 - 1;
                } else {
                    cygnus = new Cygnus();
                }
            }
            cygnus.f375587j = str;
            cygnus.f375580c = motionEvent.getAction();
            cygnus.f375581d = motionEvent.getDeviceId();
            cygnus.f375582e = motionEvent.getToolType(0);
            cygnus.f375583f = motionEvent.getRawX();
            cygnus.f375584g = motionEvent.getRawY();
            cygnus.f375585h = motionEvent.getPressure();
            cygnus.f375586i = motionEvent.getSize();
            ComaBerenices.f375558b.obtainMessage(1, cygnus).sendToTarget();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.ComaBerenices$new, reason: invalid class name */
    /* loaded from: classes26.dex */
    public static class Cnew extends Handler {
        static IPatchRedirector $redirector_;

        public Cnew(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper);
            }
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Set<com.tencent.tfd.sdk.wxa.Crux>, java.util.concurrent.CopyOnWriteArraySet] */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Object obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            if (message.what == 1 && (obj = message.obj) != null && (obj instanceof Cygnus)) {
                Cygnus cygnus = (Cygnus) obj;
                Iterator it = ComaBerenices.f375559c.iterator();
                while (it.hasNext()) {
                    ((Crux) it.next()).a(cygnus);
                }
                if (!cygnus.f375579b) {
                    synchronized (Cygnus.f375577m) {
                        cygnus.f375580c = 0;
                        cygnus.f375581d = 0;
                        cygnus.f375582e = 0;
                        cygnus.f375583f = 0.0f;
                        cygnus.f375584g = 0.0f;
                        cygnus.f375585h = 0.0f;
                        cygnus.f375586i = 0.0f;
                        cygnus.f375587j = "";
                        int i3 = Cygnus.f375576l;
                        if (i3 < 20) {
                            cygnus.f375578a = Cygnus.f375575k;
                            cygnus.f375579b = true;
                            Cygnus.f375575k = cygnus;
                            Cygnus.f375576l = i3 + 1;
                        }
                    }
                    return;
                }
                throw new IllegalStateException("Already recycled.");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62530);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f375559c = new CopyOnWriteArraySet();
        f375560d = new CopyOnWriteArraySet();
        f375562f = false;
        f375563g = new HashSet();
        f375564h = new Cdo();
        f375565i = new Cif();
        f375566j = new Cfor();
    }

    public static void a(Context context, Celse celse) {
        f375561e = celse;
        if (f375557a) {
            return;
        }
        f375557a = true;
        synchronized (ComaBerenices.class) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("TuringDispatch");
            baseHandlerThread.start();
            f375558b = new Cnew(baseHandlerThread.getLooper());
        }
        Application application = (Application) context;
        synchronized (ComaBerenices.class) {
            Cdo cdo = f375564h;
            application.unregisterActivityLifecycleCallbacks(cdo);
            application.registerActivityLifecycleCallbacks(cdo);
        }
    }
}
