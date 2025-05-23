package com.tencent.rmonitor.launch;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.rmonitor.common.logger.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes25.dex */
public class ActivityThreadHacker {

    /* renamed from: a, reason: collision with root package name */
    private final IApplicationCreateListener f365593a;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f365594b = false;

    /* renamed from: c, reason: collision with root package name */
    private long f365595c = 0;

    /* renamed from: d, reason: collision with root package name */
    private HackCallback f365596d = null;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class HackCallback implements Handler.Callback {

        /* renamed from: i, reason: collision with root package name */
        protected static int f365597i = 10;

        /* renamed from: d, reason: collision with root package name */
        private final Handler.Callback f365598d;

        /* renamed from: e, reason: collision with root package name */
        private final ActivityThreadHacker f365599e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f365600f = false;

        /* renamed from: h, reason: collision with root package name */
        private Method f365601h = null;

        HackCallback(Handler.Callback callback, ActivityThreadHacker activityThreadHacker) {
            this.f365598d = callback;
            this.f365599e = activityThreadHacker;
        }

        private void a(boolean z16, boolean z17, boolean z18) {
            AppLaunchMode appLaunchMode;
            if (z16 || z17 || z18) {
                if (z16) {
                    appLaunchMode = AppLaunchMode.APP_LAUNCH_BY_ACTIVITY;
                } else if (z17) {
                    appLaunchMode = AppLaunchMode.APP_LAUNCH_BY_SERVICE;
                } else if (z18) {
                    appLaunchMode = AppLaunchMode.APP_LAUNCH_BY_BROADCAST;
                } else {
                    appLaunchMode = AppLaunchMode.APP_LAUNCH_BY_CONTENT_PROVIDER;
                }
                this.f365599e.f(appLaunchMode);
            }
        }

        private boolean b(Message message) {
            boolean z16;
            if (AndroidVersion.isOverP() && message.what == 159 && message.obj != null) {
                z16 = c(message);
            } else {
                z16 = false;
            }
            if (!z16 && message.what != 100) {
                return false;
            }
            return true;
        }

        private boolean c(Message message) {
            f();
            Method method = this.f365601h;
            if (method == null) {
                return false;
            }
            try {
                List list = (List) method.invoke(message.obj, new Object[0]);
                if (list.isEmpty()) {
                    return false;
                }
                return list.get(0).getClass().getName().endsWith(".LaunchActivityItem");
            } catch (Exception e16) {
                Logger.f365497g.b("RMonitor_launch_Hacker", "isLaunchActivity", e16);
                return false;
            }
        }

        private boolean d(Message message) {
            if (message.what == 113) {
                return true;
            }
            return false;
        }

        private boolean e(Message message) {
            if (message.what == 114) {
                return true;
            }
            return false;
        }

        private void f() {
            if (this.f365601h == null && !this.f365600f) {
                try {
                    Method declaredMethod = Class.forName("android.app.servertransaction.ClientTransaction").getDeclaredMethod("getCallbacks", new Class[0]);
                    this.f365601h = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Throwable unused) {
                    this.f365600f = true;
                }
            }
        }

        public Handler.Callback getOriginalCallback() {
            return this.f365598d;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (!this.f365599e.f365594b) {
                Handler.Callback callback = this.f365598d;
                if (callback == null || !callback.handleMessage(message)) {
                    return false;
                }
                return true;
            }
            boolean b16 = b(message);
            boolean e16 = e(message);
            boolean d16 = d(message);
            if (f365597i > 0) {
                Logger.f365497g.w("RMonitor_launch_Hacker", "handleMessage, msg.what: ", String.valueOf(message.what), ", isLaunchActivity: ", String.valueOf(b16), ", isLaunchService: ", String.valueOf(e16), ", isLaunchBroadcastReceiver: ", String.valueOf(d16));
                f365597i--;
            }
            if (b16) {
                this.f365599e.f365595c = SystemClock.uptimeMillis();
            }
            a(b16, e16, d16);
            Handler.Callback callback2 = this.f365598d;
            if (callback2 == null || !callback2.handleMessage(message)) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface IApplicationCreateListener {
        void onApplicationLaunchEnd(AppLaunchMode appLaunchMode);
    }

    public ActivityThreadHacker(IApplicationCreateListener iApplicationCreateListener) {
        this.f365593a = iApplicationCreateListener;
    }

    private Field c(Object obj) throws NoSuchFieldException {
        Class<?> superclass;
        if (obj.getClass() == Handler.class) {
            superclass = obj.getClass();
        } else {
            superclass = obj.getClass().getSuperclass();
        }
        Field declaredField = superclass.getDeclaredField("mCallback");
        declaredField.setAccessible(true);
        return declaredField;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(AppLaunchMode appLaunchMode) {
        Logger.f365497g.w("RMonitor_launch_Hacker", "notifyOnApplicationCreateEnd, isLaunchActivity: ", appLaunchMode.toString());
        IApplicationCreateListener iApplicationCreateListener = this.f365593a;
        if (iApplicationCreateListener != null) {
            iApplicationCreateListener.onApplicationLaunchEnd(appLaunchMode);
        }
    }

    protected Object d() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class<?> cls = Class.forName("android.app.ActivityThread");
        Field declaredField = cls.getDeclaredField("sCurrentActivityThread");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(cls);
        Field declaredField2 = cls.getDeclaredField("mH");
        declaredField2.setAccessible(true);
        return declaredField2.get(obj);
    }

    public boolean e() {
        return this.f365594b;
    }

    protected void g(Object obj) throws NoSuchFieldException, IllegalAccessException {
        Field c16 = c(obj);
        Handler.Callback callback = (Handler.Callback) c16.get(obj);
        HackCallback hackCallback = new HackCallback(callback, this);
        this.f365596d = hackCallback;
        c16.set(obj, hackCallback);
        Logger.f365497g.w("RMonitor_launch_Hacker", "replaceHandlerCallback, originalCallback: " + callback + ", hackCallback: " + this.f365596d);
    }

    protected void h(Object obj) throws NoSuchFieldException, IllegalAccessException {
        Field c16 = c(obj);
        Handler.Callback callback = (Handler.Callback) c16.get(obj);
        HackCallback hackCallback = this.f365596d;
        if (hackCallback != null && hackCallback == callback) {
            c16.set(obj, hackCallback.getOriginalCallback());
            Logger.f365497g.w("RMonitor_launch_Hacker", "resetHandlerCallback success.");
        } else {
            Logger.f365497g.w("RMonitor_launch_Hacker", "resetHandlerCallback fail for current Callback is not hack Callback");
        }
    }

    public void i() {
        try {
            g(d());
            this.f365594b = true;
            Logger.f365497g.w("RMonitor_launch_Hacker", "startTrace success.");
        } catch (Throwable th5) {
            Logger.f365497g.b("RMonitor_launch_Hacker", "startTrace fail.", th5);
        }
    }

    public void j() {
        if (!e()) {
            return;
        }
        Logger.f365497g.w("RMonitor_launch_Hacker", "stopTrace");
        try {
            h(d());
        } catch (Throwable th5) {
            Logger.f365497g.b("RMonitor_launch_Hacker", "stopTrace fail.", th5);
        }
        this.f365594b = false;
        this.f365596d = null;
    }
}
