package com.tencent.bugly.proguard;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.s;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f98554a = false;

    /* renamed from: b, reason: collision with root package name */
    public static s f98555b = null;

    /* renamed from: c, reason: collision with root package name */
    private static int f98556c = 10;

    /* renamed from: d, reason: collision with root package name */
    private static long f98557d = 300000;

    /* renamed from: e, reason: collision with root package name */
    private static long f98558e = 30000;

    /* renamed from: f, reason: collision with root package name */
    private static long f98559f = 0;

    /* renamed from: g, reason: collision with root package name */
    private static int f98560g = 0;

    /* renamed from: h, reason: collision with root package name */
    private static long f98561h = 0;

    /* renamed from: i, reason: collision with root package name */
    private static long f98562i = 0;

    /* renamed from: j, reason: collision with root package name */
    private static long f98563j = 0;

    /* renamed from: k, reason: collision with root package name */
    private static com.tencent.rmonitor.common.lifecycle.b f98564k = null;

    /* renamed from: l, reason: collision with root package name */
    private static Class<?> f98565l = null;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f98566m = true;

    static /* synthetic */ int g() {
        int i3 = f98560g;
        f98560g = i3 + 1;
        return i3;
    }

    public static void a(final Context context, final BuglyStrategy buglyStrategy) {
        long j3;
        if (f98554a) {
            return;
        }
        f98566m = ai.a(context).f98018f;
        f98555b = new s(context, f98566m);
        try {
            ai c16 = ai.c();
            if (c16 != null && LifecycleCallback.G.l(context)) {
                c16.a(true);
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof Application) {
                LifecycleCallback.i((Application) applicationContext);
                try {
                    if (f98564k == null) {
                        f98564k = new a();
                    }
                    LifecycleCallback.r(f98564k);
                } catch (Exception e16) {
                    if (!av.a(e16)) {
                        e16.printStackTrace();
                    }
                }
            }
        } catch (Throwable th5) {
            av.b(th5);
        }
        f98554a = true;
        if (buglyStrategy != null) {
            f98565l = buglyStrategy.getUserInfoActivity();
            j3 = buglyStrategy.getAppReportDelay();
        } else {
            j3 = 0;
        }
        if (j3 <= 0) {
            c(context, buglyStrategy);
        } else {
            at.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.t.1
                @Override // java.lang.Runnable
                public final void run() {
                    t.c(context, buglyStrategy);
                }
            }, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0059 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(Context context, BuglyStrategy buglyStrategy) {
        boolean z16;
        boolean z17;
        if (buglyStrategy != null) {
            z16 = buglyStrategy.recordUserInfoOnceADay();
            buglyStrategy.isEnableUserInfo();
        } else {
            z16 = false;
        }
        if (z16) {
            ai a16 = ai.a(context);
            List<UserInfoBean> a17 = s.a(a16.f98016d);
            if (a17 != null) {
                for (int i3 = 0; i3 < a17.size(); i3++) {
                    UserInfoBean userInfoBean = a17.get(i3);
                    if (userInfoBean.f97826n.equals(a16.f98032t) && userInfoBean.f97814b == 1) {
                        long b16 = ba.b();
                        if (b16 <= 0) {
                            break;
                        }
                        if (userInfoBean.f97817e >= b16) {
                            if (userInfoBean.f97818f <= 0) {
                                f98555b.c();
                            }
                            z17 = false;
                            if (!z17) {
                                return;
                            }
                        }
                    }
                }
            }
            z17 = true;
            if (!z17) {
            }
        }
        if (f98566m) {
            f98562i = System.currentTimeMillis();
            f98555b.a(1, true);
            av.a("[session] launch app, new start", new Object[0]);
            f98555b.a();
            f98555b.a(21600000L);
        }
    }

    public static void a(StrategyBean strategyBean, boolean z16) {
        s sVar = f98555b;
        if (sVar != null && !z16) {
            sVar.c();
        }
        if (strategyBean == null) {
            return;
        }
        long j3 = strategyBean.f97851p;
        if (j3 > 0) {
            f98558e = j3;
        }
        int i3 = strategyBean.f97856u;
        if (i3 > 0) {
            f98556c = i3;
        }
        long j16 = strategyBean.f97857v;
        if (j16 > 0) {
            f98557d = j16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a implements com.tencent.rmonitor.common.lifecycle.b {
        a() {
        }

        @Override // com.tencent.rmonitor.common.lifecycle.b
        public final void onBackground() {
            ai.c().a(false);
        }

        @Override // com.tencent.rmonitor.common.lifecycle.b
        public final void onCreate(@NotNull Activity activity) {
            String name = activity.getClass().getName();
            if (t.f98565l != null && !t.f98565l.getName().equals(name)) {
                return;
            }
            av.c(">>> %s onCreated <<<", name);
        }

        @Override // com.tencent.rmonitor.common.lifecycle.b
        public final void onDestroy(@NotNull Activity activity) {
            String name = activity.getClass().getName();
            if (t.f98565l != null && !t.f98565l.getName().equals(name)) {
                return;
            }
            av.c(">>> %s onDestroyed <<<", name);
        }

        @Override // com.tencent.rmonitor.common.lifecycle.b
        public final void onForeground() {
            ai.c().a(true);
        }

        @Override // com.tencent.rmonitor.common.lifecycle.b
        public final void onPause(@NotNull Activity activity) {
            String name = activity.getClass().getName();
            if (t.f98565l != null && !t.f98565l.getName().equals(name)) {
                return;
            }
            av.c(">>> %s onPaused <<<", name);
            ai c16 = ai.c();
            if (c16 == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            c16.I = currentTimeMillis;
            c16.J = currentTimeMillis - c16.H;
            long unused = t.f98561h = currentTimeMillis;
            if (c16.J < 0) {
                c16.J = 0L;
            }
            c16.G = "background";
        }

        @Override // com.tencent.rmonitor.common.lifecycle.b
        public final void onResume(@NotNull Activity activity) {
            com.tencent.rmonitor.common.lifecycle.a.i().l(activity);
            String name = activity.getClass().getName();
            if (t.f98565l != null && !t.f98565l.getName().equals(name)) {
                return;
            }
            av.c(">>> %s onResumed <<<", name);
            ai c16 = ai.c();
            if (c16 == null) {
                return;
            }
            c16.G = name;
            long currentTimeMillis = System.currentTimeMillis();
            c16.H = currentTimeMillis;
            c16.K = currentTimeMillis - t.f98562i;
            long j3 = c16.H - t.f98561h;
            if (j3 > (t.f98559f > 0 ? t.f98559f : t.f98558e)) {
                c16.d();
                t.g();
                av.a("[session] launch app one times (app in background %d seconds and over %d seconds)", Long.valueOf(j3 / 1000), Long.valueOf(t.f98558e / 1000));
                if (t.f98560g % t.f98556c == 0) {
                    t.f98555b.a(4, t.f98566m);
                    return;
                }
                t.f98555b.a(4, false);
                long currentTimeMillis2 = System.currentTimeMillis();
                if (currentTimeMillis2 - t.f98563j > t.f98557d) {
                    long unused = t.f98563j = currentTimeMillis2;
                    av.a("add a timer to upload hot start user info", new Object[0]);
                    if (t.f98566m) {
                        at.a().a(new s.a(null, true), t.f98557d);
                    }
                }
            }
        }

        @Override // com.tencent.rmonitor.common.lifecycle.b
        public final void onStart(@NotNull Activity activity) {
            av.c(">>> %s onStart <<<", activity.getClass().getName());
        }

        @Override // com.tencent.rmonitor.common.lifecycle.b
        public final void onStop(@NotNull Activity activity) {
            av.c(">>> %s onStop <<<", activity.getClass().getName());
        }

        @Override // com.tencent.rmonitor.common.lifecycle.b
        public final void onPostCreate(@NotNull Activity activity) {
        }
    }

    public static void a() {
        s sVar = f98555b;
        if (sVar != null) {
            sVar.a(2, false);
        }
    }
}
