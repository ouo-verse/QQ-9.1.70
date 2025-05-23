package com.tencent.mobileqq.perf.memory;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.process.config.MainProcConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0007\u001a\u00020\u0002R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/e;", "", "", "f", "Lcom/tencent/mobileqq/perf/memory/collect/a;", "memoryUsage", "d", h.F, "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "mainHandler", "", "c", "J", "lastGCTime", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final e f257732a;

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private static Handler mainHandler;

    /* renamed from: c, reason: from kotlin metadata */
    private static long lastGCTime;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28871);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f257732a = new e();
            mainHandler = new Handler(Looper.getMainLooper());
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ com.tencent.mobileqq.perf.memory.collect.a e(e eVar, com.tencent.mobileqq.perf.memory.collect.a aVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            aVar = null;
        }
        return eVar.d(aVar);
    }

    private final void f() {
        mainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.perf.memory.b
            @Override // java.lang.Runnable
            public final void run() {
                e.g();
            }
        });
    }

    public static final void g() {
        f257732a.h();
    }

    public static final boolean i() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.perf.memory.d
            @Override // java.lang.Runnable
            public final void run() {
                e.j();
            }
        }, 16, null, true);
        return false;
    }

    public static final void j() {
        if (com.tencent.cache.api.memory.a.f98606b.a().e() >= MainProcConfig.INSTANCE.e().p()) {
            QLog.d("ForegroundGC", 1, "start");
            com.tencent.mobileqq.perf.memory.util.a.f257790a.b();
        }
    }

    @Nullable
    public final com.tencent.mobileqq.perf.memory.collect.a d(@Nullable com.tencent.mobileqq.perf.memory.collect.a memoryUsage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.perf.memory.collect.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) memoryUsage);
        }
        if (com.tencent.mobileqq.perf.process.backgroud.d.f257845d.m()) {
            return memoryUsage;
        }
        MainProcConfig.Companion companion = MainProcConfig.INSTANCE;
        if (!companion.e().i()) {
            return memoryUsage;
        }
        if (lastGCTime > 0 && SystemClock.elapsedRealtime() - lastGCTime < companion.e().q()) {
            return memoryUsage;
        }
        lastGCTime = SystemClock.elapsedRealtime();
        if (memoryUsage == null) {
            memoryUsage = com.tencent.mobileqq.perf.memory.collect.a.INSTANCE.a();
        }
        if (memoryUsage.a().e() >= companion.e().p()) {
            if (Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
                h();
            } else {
                f();
            }
        }
        return memoryUsage;
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.tencent.mobileqq.perf.memory.c
                @Override // android.os.MessageQueue.IdleHandler
                public final boolean queueIdle() {
                    boolean i3;
                    i3 = e.i();
                    return i3;
                }
            });
        }
    }
}
