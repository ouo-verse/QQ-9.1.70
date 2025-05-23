package com.tencent.kuikly.core.render.android.scheduler;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0003\u001a\u00020\u0002J6\u0010\f\u001a\u00020\u00052\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\bJ\"\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006H\u0016J*\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006R\u001b\u0010\u0014\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/kuikly/core/render/android/scheduler/KuiklyRenderCoreContextScheduler;", "Lcom/tencent/kuikly/core/render/android/scheduler/a;", "", "e", "Lkotlin/Function0;", "", "Lcom/tencent/kuikly/core/render/android/scheduler/KuiklyRenderCoreTask;", "task", "", "delayMs", "sync", "syncTimeoutMs", "f", "a", "timeout", h.F, "Landroid/os/HandlerThread;", "Lkotlin/Lazy;", "c", "()Landroid/os/HandlerThread;", "contextQueueHandlerThread", "Landroid/os/Handler;", "b", "d", "()Landroid/os/Handler;", "handler", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KuiklyRenderCoreContextScheduler implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Lazy contextQueueHandlerThread;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy handler;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final KuiklyRenderCoreContextScheduler f118178c = new KuiklyRenderCoreContextScheduler();

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<HandlerThread>() { // from class: com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderCoreContextScheduler$contextQueueHandlerThread$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HandlerThread invoke() {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("HRContextQueueHandlerThread", -2);
                baseHandlerThread.start();
                return baseHandlerThread;
            }
        });
        contextQueueHandlerThread = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderCoreContextScheduler$handler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                HandlerThread c16;
                c16 = KuiklyRenderCoreContextScheduler.f118178c.c();
                return new Handler(c16.getLooper());
            }
        });
        handler = lazy2;
    }

    KuiklyRenderCoreContextScheduler() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HandlerThread c() {
        return (HandlerThread) contextQueueHandlerThread.getValue();
    }

    private final Handler d() {
        return (Handler) handler.getValue();
    }

    public static /* synthetic */ void g(KuiklyRenderCoreContextScheduler kuiklyRenderCoreContextScheduler, Function0 function0, long j3, boolean z16, long j16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = 0;
        }
        long j17 = j3;
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        boolean z17 = z16;
        if ((i3 & 8) != 0) {
            j16 = 500;
        }
        kuiklyRenderCoreContextScheduler.f(function0, j17, z17, j16);
    }

    @Override // com.tencent.kuikly.core.render.android.scheduler.a
    public void a(long delayMs, @NotNull final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        d().postDelayed(new Runnable() { // from class: com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderCoreContextSchedulerKt$sam$java_lang_Runnable$0
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                Intrinsics.checkNotNullExpressionValue(Function0.this.invoke(), "invoke(...)");
            }
        }, delayMs);
    }

    public final boolean e() {
        return Intrinsics.areEqual(Thread.currentThread(), c());
    }

    public final void f(@NotNull Function0<Unit> task, long delayMs, boolean sync, long syncTimeoutMs) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (sync) {
            h(delayMs, syncTimeoutMs, task);
        } else {
            a(delayMs, task);
        }
    }

    public final void h(long delayMs, long timeout, @NotNull Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        b.a(d(), delayMs, timeout, task);
    }
}
