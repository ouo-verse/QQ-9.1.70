package com.tencent.mobileqq.power.cpu;

import android.content.Context;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.qcoroutine.api.a;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u0015\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/power/cpu/CpuMonitorManager;", "", "Landroid/content/Context;", "context", "", "e", h.F, "", "avgCpuUsage", "f", "Lcom/tencent/mobileqq/power/a;", "callback", "a", "i", "g", "Lcom/tencent/mobileqq/qcoroutine/api/h;", "b", "Lcom/tencent/mobileqq/qcoroutine/api/h;", "()Lcom/tencent/mobileqq/qcoroutine/api/h;", "d", "(Lcom/tencent/mobileqq/qcoroutine/api/h;)V", "frontRunnable", "Ljava/util/concurrent/atomic/AtomicBoolean;", "c", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "isFrontRun", "<init>", "()V", "power_monitor_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class CpuMonitorManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final CpuMonitorManager f259424a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.mobileqq.qcoroutine.api.h frontRunnable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicBoolean isFrontRun;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/power/cpu/CpuMonitorManager$a", "Lcom/tencent/mobileqq/qcoroutine/api/a;", "", "b", "power_monitor_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a implements com.tencent.mobileqq.qcoroutine.api.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.qcoroutine.api.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                a.C8281a.a(this);
            }
        }

        @Override // com.tencent.mobileqq.qcoroutine.api.a
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.mobileqq.perf.log.a.c("HP_CPU", "startFrontCpuMonitor callback finish");
            CpuMonitorManager cpuMonitorManager = CpuMonitorManager.f259424a;
            if (cpuMonitorManager.b() != null) {
                cpuMonitorManager.d(null);
            }
            cpuMonitorManager.c().compareAndSet(true, false);
        }

        @Override // com.tencent.mobileqq.qcoroutine.api.a
        public void onTaskStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                a.C8281a.b(this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17331);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            f259424a = new CpuMonitorManager();
            isFrontRun = new AtomicBoolean(false);
        }
    }

    CpuMonitorManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@Nullable com.tencent.mobileqq.power.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) callback);
        } else {
            com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.e(new com.tencent.mobileqq.qcoroutine.api.h("powerMonitor_CpuMonitorManager_getCpuData", i.d.f261782e, false, new CpuMonitorManager$getCpuData$qRunnable$1(callback, null)));
        }
    }

    @Nullable
    public final com.tencent.mobileqq.qcoroutine.api.h b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.qcoroutine.api.h) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return frontRunnable;
    }

    @NotNull
    public final AtomicBoolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AtomicBoolean) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return isFrontRun;
    }

    public final void d(@Nullable com.tencent.mobileqq.qcoroutine.api.h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) hVar);
        } else {
            frontRunnable = hVar;
        }
    }

    public final void e(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
        }
    }

    public final void f(double avgCpuUsage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Double.valueOf(avgCpuUsage));
            return;
        }
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null && guardManager.isApplicationForeground() && isFrontRun.compareAndSet(false, true)) {
            com.tencent.mobileqq.perf.log.a.c("HP_CPU", "startFrontCpuMonitor ,avgCpuUsage:" + avgCpuUsage);
            com.tencent.mobileqq.qcoroutine.api.h hVar = new com.tencent.mobileqq.qcoroutine.api.h("powerMonitor_CpuMonitorManager_FrontCpuMonitor", i.d.f261782e, false, new CpuMonitorManager$startFrontCpuMonitor$1(avgCpuUsage, null));
            frontRunnable = hVar;
            hVar.g(new a());
            com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.e(hVar);
        }
    }

    public final void g(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
        }
    }

    public final void h(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
        }
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        com.tencent.mobileqq.perf.log.a.c("HP_CPU", "stopFrontCpuMonitor");
        com.tencent.mobileqq.qcoroutine.api.h hVar = frontRunnable;
        if (hVar != null) {
            com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.a(hVar);
        }
        frontRunnable = null;
        isFrontRun.compareAndSet(true, false);
    }
}
