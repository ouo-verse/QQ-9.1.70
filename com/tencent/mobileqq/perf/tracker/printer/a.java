package com.tencent.mobileqq.perf.tracker.printer;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.cache.core.manager.api.c;
import com.tencent.mobileqq.perf.memory.FaultMonitor;
import com.tencent.mobileqq.perf.memory.config.a;
import com.tencent.mobileqq.perf.memory.e;
import com.tencent.mobileqq.perf.thread.proxy.ThreadProxyMonitor;
import com.tencent.mobileqq.perf.tool.CpuUtil;
import com.tencent.mobileqq.perf.tool.QQPerfHandlerThreadManager;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.perf.tracker.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\b\u0007*\u0002\u0015\u0019\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\n\u001a\u00020\u0002R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/perf/tracker/printer/a;", "", "", "j", "Lcom/tencent/mobileqq/perf/memory/collect/a;", "memoryUsage", "", "i", "l", "k", "needCheckMemory", "", h.F, "", "b", "J", "lastGetTime", "c", "gotoBackgroundTime", "d", "checkInterval", "com/tencent/mobileqq/perf/tracker/printer/a$b", "e", "Lcom/tencent/mobileqq/perf/tracker/printer/a$b;", "sceneChangedCallback", "com/tencent/mobileqq/perf/tracker/printer/a$a", "f", "Lcom/tencent/mobileqq/perf/tracker/printer/a$a;", "handler", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f258261a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long lastGetTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long gotoBackgroundTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long checkInterval;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final b sceneChangedCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HandlerC8215a handler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/perf/tracker/printer/a$a", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.perf.tracker.printer.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class HandlerC8215a extends Handler {
        static IPatchRedirector $redirector_;

        HandlerC8215a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (msg2.what == 1) {
                a aVar = a.f258261a;
                if (!aVar.j()) {
                    QLog.e("PP", 1, "no need continue check on background");
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (uptimeMillis - a.lastGetTime >= a.checkInterval) {
                    sendEmptyMessageDelayed(1, a.checkInterval);
                    com.tencent.mobileqq.perf.log.a.c("PP", aVar.h(true));
                    a.lastGetTime = uptimeMillis;
                    return;
                }
                sendEmptyMessageAtTime(1, a.lastGetTime + a.checkInterval);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/perf/tracker/printer/a$b", "Lcom/tencent/mobileqq/perf/tracker/callback/a;", "", "onProcessForeground", "onProcessBackground", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends com.tencent.mobileqq.perf.tracker.callback.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, mqq.app.QActivityLifecycleCallbacks
        public void onProcessBackground() {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            a aVar = a.f258261a;
            a.gotoBackgroundTime = System.currentTimeMillis();
            a.C8201a n3 = com.tencent.mobileqq.perf.memory.config.a.f257676a.n();
            if (n3 != null) {
                j3 = n3.b();
            } else {
                j3 = 30000;
            }
            a.checkInterval = j3;
            QLog.e("PP", 1, "onProcessBackground, checkInterval:" + a.checkInterval);
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, mqq.app.QActivityLifecycleCallbacks
        public void onProcessForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                a.gotoBackgroundTime = 0L;
                a.checkInterval = 30000L;
                a.handler.sendEmptyMessage(1);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47054);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f258261a = new a();
        checkInterval = 30000L;
        sceneChangedCallback = new b();
        handler = new HandlerC8215a(QQPerfHandlerThreadManager.INSTANCE.d().getLooper());
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void i(com.tencent.mobileqq.perf.memory.collect.a memoryUsage) {
        FaultMonitor.f257645a.b(memoryUsage);
        com.tencent.mobileqq.perf.memory.ceiling.a.f257668a.a(memoryUsage);
        l(memoryUsage);
        ThreadProxyMonitor.f258150a.b();
        e.f257732a.d(memoryUsage);
        com.tencent.mobileqq.perf.memory.largeobject.b.INSTANCE.c(memoryUsage);
        c.f98725d.a().a(memoryUsage.a(), memoryUsage.c());
        com.tencent.mobileqq.perf.memory.gc.c.f257747a.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j() {
        if (!AppSetting.isPublicVersion() || gotoBackgroundTime == 0) {
            return true;
        }
        if (com.tencent.mobileqq.perf.memory.config.a.f257676a.n() == null) {
            QLog.e("PP", 1, "MemoryConfig is null");
            return false;
        }
        if (System.currentTimeMillis() - gotoBackgroundTime < r0.c()) {
            return true;
        }
        return false;
    }

    private final void l(com.tencent.mobileqq.perf.memory.collect.a memoryUsage) {
        if (com.tencent.mobileqq.perf.memory.config.a.f257676a.p() && Build.VERSION.SDK_INT > 28) {
            g gVar = g.f258254a;
            String PACKAGE_NAME = MobileQQ.PACKAGE_NAME;
            Intrinsics.checkNotNullExpressionValue(PACKAGE_NAME, "PACKAGE_NAME");
            gVar.m(PACKAGE_NAME, memoryUsage);
        }
    }

    @NotNull
    public final String h(boolean needCheckMemory) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, needCheckMemory);
        }
        String f16 = SceneTracker.f();
        float h16 = CpuUtil.h(CpuUtil.f258160a, 0, 1, null);
        com.tencent.mobileqq.perf.memory.collect.a a16 = com.tencent.mobileqq.perf.memory.collect.a.INSTANCE.a();
        com.tencent.cache.api.memory.e f17 = com.tencent.cache.api.memory.a.f98606b.f();
        if (needCheckMemory) {
            i(a16);
        }
        return "process cpu is " + h16 + ", totalMem(KB): " + a16.c().i() + ", " + a16.a() + ", " + a16.c().r() + ", stage: " + f16 + ", appSysLaunchCost:" + com.tencent.mobileqq.startup.a.f289673n + ", system " + f17.p();
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        SceneTracker.f258213d.l(sceneChangedCallback);
        if (SceneTracker.j()) {
            handler.sendEmptyMessage(1);
        }
        QLog.d("PP", 2, "PerfPrinter is init");
    }
}
