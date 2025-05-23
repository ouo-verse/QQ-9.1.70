package com.tencent.mobileqq.perf.rmonitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.mobileqq.perf.config.QQPerfConfigLoader;
import com.tencent.mobileqq.perf.rmonitor.QQRMonitorSDKManager;
import com.tencent.mobileqq.perf.tool.QQPerfHandlerThreadManager;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.RMonitor;
import com.tencent.util.AppSetting;
import dd2.b;
import java.util.concurrent.atomic.AtomicBoolean;
import kd2.d;
import kd2.e;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/perf/rmonitor/QQRMonitorSDKManager;", "", "", "c", h.F, "g", "f", "d", "e", "Ljava/util/concurrent/atomic/AtomicBoolean;", "b", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mStarted", "isForegroundStarted", "", "J", "uin", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QQRMonitorSDKManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QQRMonitorSDKManager f258022a = new QQRMonitorSDKManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicBoolean mStarted = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicBoolean isForegroundStarted = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static long uin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/perf/rmonitor/QQRMonitorSDKManager$a", "Lcom/tencent/mobileqq/perf/tracker/callback/a;", "", "onProcessForeground", "onProcessBackground", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends com.tencent.mobileqq.perf.tracker.callback.a {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b() {
            if (QQRMonitorSDKManager.isForegroundStarted.compareAndSet(false, true)) {
                QQRMonitorSDKManager.f258022a.h();
            }
            d.f412061a.d(BuglyMonitorName.LOOPER_STACK);
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, mqq.app.QActivityLifecycleCallbacks
        public void onProcessBackground() {
            d.f412061a.c(BuglyMonitorName.LOOPER_STACK);
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, mqq.app.QActivityLifecycleCallbacks
        public void onProcessForeground() {
            QQPerfHandlerThreadManager.INSTANCE.a(new Runnable() { // from class: com.tencent.mobileqq.perf.rmonitor.a
                @Override // java.lang.Runnable
                public final void run() {
                    QQRMonitorSDKManager.a.b();
                }
            });
        }
    }

    QQRMonitorSDKManager() {
    }

    @JvmStatic
    public static final void c() {
        if (mStarted.compareAndSet(false, true)) {
            long currentTimeMillis = System.currentTimeMillis();
            QLog.d("QQRMonitorSDKManager", 1, "RMonitor init");
            QQRMonitorSDKManager qQRMonitorSDKManager = f258022a;
            qQRMonitorSDKManager.h();
            qQRMonitorSDKManager.g();
            qQRMonitorSDKManager.f();
            QLog.d("QQRMonitorSDKManager", 1, "RMonitor init success, cost :" + (System.currentTimeMillis() - currentTimeMillis));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQRMonitorSDKManager", 2, "init , RMonitor has mStarted");
        }
    }

    private final void f() {
        SceneTracker.f258213d.l(new a());
    }

    private final void g() {
        QQPerfConfigLoader qQPerfConfigLoader = QQPerfConfigLoader.f257603a;
        com.tencent.mobileqq.perf.config.plugin.d e16 = qQPerfConfigLoader.b().e();
        if (Intrinsics.areEqual(AppSetting.getBranchName(), "master") && AppSetting.isDebugVersion() && MobileQQ.sProcessId != 4) {
            b.f393639n.n(e16, new fd2.b(e16.maintainCount, e16.threshold));
        } else {
            b.f393639n.m(e16);
        }
        dd2.a.f393635n.m(qQPerfConfigLoader.b().d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        if (SceneTracker.j()) {
            isForegroundStarted.set(true);
            d dVar = d.f412061a;
            dVar.e();
            dVar.g();
            e();
            RMonitor.startMonitor(BuglyMonitorName.PAGE_LAUNCH);
        }
    }

    public final void d() {
        String g16 = e.g();
        try {
            uin = Long.parseLong(g16);
            RMonitor.setProperty(102, g16);
            QLog.i("QQRMonitorSDKManager", 1, "setUin, " + g16);
        } catch (NumberFormatException e16) {
            QLog.e("QQRMonitorSDKManager", 1, "setUin error", e16);
        }
    }

    public final void e() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
        MobileQQ.sMobileQQ.registerReceiver(new BroadcastReceiver() { // from class: com.tencent.mobileqq.perf.rmonitor.QQRMonitorSDKManager$registerAccountReceiver$qqAccountReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                String action = intent.getAction();
                if (action != null && Intrinsics.areEqual(action, NewIntent.ACTION_ACCOUNT_CHANGED)) {
                    QQRMonitorSDKManager.f258022a.d();
                }
            }
        }, intentFilter);
    }
}
