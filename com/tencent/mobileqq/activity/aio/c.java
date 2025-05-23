package com.tencent.mobileqq.activity.aio;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.aio.utils.StopWatch;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dpc.IDPCApiConstant;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ei;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.SplashAIOFragment;
import com.tencent.qqperf.tools.PerformanceReportUtils;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c implements Handler.Callback {
    private static final c C = new c();

    /* renamed from: f, reason: collision with root package name */
    public static boolean f178324f = true;

    /* renamed from: h, reason: collision with root package name */
    public static int f178325h = 0;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f178326i = false;

    /* renamed from: m, reason: collision with root package name */
    public static long f178327m = -1;

    /* renamed from: d, reason: collision with root package name */
    private final Handler f178328d = new WeakReferenceHandler(Looper.getMainLooper(), this);

    /* renamed from: e, reason: collision with root package name */
    private boolean f178329e = false;

    static {
        c();
    }

    c() {
    }

    @TargetApi(17)
    private void a(Activity activity) {
        if (!(activity instanceof SplashActivity)) {
            QLog.i("Q.aio.AIOPreLoadEngine", 1, "activity is not splashActivity");
            return;
        }
        if (f178325h != 1 && !this.f178329e) {
            SplashActivity splashActivity = (SplashActivity) activity;
            QQAppInterface qQAppInterface = splashActivity.app;
            if (qQAppInterface != null && qQAppInterface.isRunning() && splashActivity.app.isLogin()) {
                if (splashActivity.getSupportFragmentManager().findFragmentByTag(SplashAIOFragment.class.getName()) != null) {
                    QLog.i("Q.aio.AIOPreLoadEngine", 1, "AIO cannot preload: SplashAIOFragment is existed");
                    return;
                }
                if (!activity.isDestroyed() && !activity.isFinishing()) {
                    QLog.d("Q.aio.AIOPreLoadEngine", 1, "doRealPreLoadAIO");
                    f178327m = SystemClock.uptimeMillis();
                    ei.a(null, "AIO_preLoad_Cost");
                    try {
                        splashActivity.setIntent(new Intent());
                        splashActivity.preloadAIO();
                        f178325h = 1;
                        PerformanceReportUtils.f363382b = 1;
                        this.f178329e = true;
                        return;
                    } catch (Exception e16) {
                        QLog.e("Q.aio.AIOPreLoadEngine", 1, "AIO preLoad:", e16);
                        return;
                    }
                }
                QLog.i("Q.aio.AIOPreLoadEngine", 1, "AIO cannot preload: activity destroyed");
                return;
            }
            QLog.e("Q.aio.AIOPreLoadEngine", 1, "app is not valid");
            return;
        }
        QLog.e("Q.aio.AIOPreLoadEngine", 1, "sPreloadedAIOType:" + f178325h + "|AIO_HAD_OPEN:" + this.f178329e);
    }

    public static synchronized c b() {
        c cVar;
        synchronized (c.class) {
            cVar = C;
        }
        return cVar;
    }

    public static synchronized void c() {
        synchronized (c.class) {
            if (f178326i) {
                return;
            }
            try {
                String featureValueWithoutAccountManager = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.aio_config.name(), IDPCApiConstant.AIO_PRELOAD_OPEN);
                if (QLog.isColorLevel()) {
                    QLog.i("Q.aio.AIOPreLoadEngine", 2, "initAIOPreloadFlagByDpc thumbConfig:" + featureValueWithoutAccountManager);
                }
                String[] split = featureValueWithoutAccountManager.split("\\|");
                if (split.length > 2) {
                    f178324f = "1".equals(split[2]);
                }
            } catch (Exception unused) {
                f178324f = false;
                QLog.d("Q.aio.AIOPreLoadEngine", 1, "initAIOPreloadFlagByDpc error");
            }
            f178326i = true;
            QLog.i("Q.aio.AIOPreLoadEngine", 1, "initAIOPreloadFlagByDpc|" + f178324f);
        }
    }

    private void d() {
        Iterator<WeakReference<Activity>> it = Foreground.getResumedActivity().iterator();
        Activity activity = null;
        while (it.hasNext()) {
            Activity activity2 = it.next().get();
            QLog.d("Q.aio.AIOPreLoadEngine", 1, "temp " + activity2);
            if ((activity2 instanceof SplashActivity) && !activity2.isDestroyed() && !activity2.isFinishing()) {
                activity = activity2;
            }
        }
        QLog.d("Q.aio.AIOPreLoadEngine", 1, "startPreLoadAIO, topActivity:", activity);
        if (activity != null) {
            b().f(activity);
        }
    }

    public void e() {
        d();
    }

    public void f(Activity activity) {
        if (!f178324f) {
            QLog.i("Q.aio.AIOPreLoadEngine", 1, "startPreLoadAIO return");
            return;
        }
        QLog.i("Q.aio.AIOPreLoadEngine", 1, "startPreLoadAIO");
        if (activity != null) {
            Message obtainMessage = this.f178328d.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = activity;
            this.f178328d.sendMessage(obtainMessage);
        }
    }

    public void g() {
        if (this.f178328d.hasMessages(1)) {
            this.f178328d.removeMessages(1);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        if (message.what == 1 && (obj = message.obj) != null) {
            StopWatch i3 = new StopWatch("Q.aio.AIOPreLoadEngine-PreloadAIO", true).i();
            a((Activity) obj);
            i3.b("finish preloading aio");
            return false;
        }
        return false;
    }
}
