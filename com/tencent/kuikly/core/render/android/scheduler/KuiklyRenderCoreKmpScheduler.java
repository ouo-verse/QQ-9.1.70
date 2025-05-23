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

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J,\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0010\u0010\b\u001a\f\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007H\u0002J6\u0010\r\u001a\u00020\u00062\u0010\u0010\b\u001a\f\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u0002R\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0017\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/kuikly/core/render/android/scheduler/KuiklyRenderCoreKmpScheduler;", "", "", "delayMs", "timeout", "Lkotlin/Function0;", "", "Lcom/tencent/kuikly/core/render/android/scheduler/KuiklyRenderCoreTask;", "task", "f", "", "sync", "syncTimeoutMs", "d", "Landroid/os/HandlerThread;", "a", "Lkotlin/Lazy;", "c", "()Landroid/os/HandlerThread;", "kmpContextQueueHandlerThread", "Landroid/os/Handler;", "b", "()Landroid/os/Handler;", "handler", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KuiklyRenderCoreKmpScheduler {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Lazy kmpContextQueueHandlerThread;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy handler;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final KuiklyRenderCoreKmpScheduler f118182c = new KuiklyRenderCoreKmpScheduler();

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<HandlerThread>() { // from class: com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderCoreKmpScheduler$kmpContextQueueHandlerThread$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HandlerThread invoke() {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("kmpContextQueueHandlerThread", -2);
                baseHandlerThread.start();
                return baseHandlerThread;
            }
        });
        kmpContextQueueHandlerThread = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderCoreKmpScheduler$handler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                HandlerThread c16;
                c16 = KuiklyRenderCoreKmpScheduler.f118182c.c();
                return new Handler(c16.getLooper());
            }
        });
        handler = lazy2;
    }

    KuiklyRenderCoreKmpScheduler() {
    }

    private final Handler b() {
        return (Handler) handler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HandlerThread c() {
        return (HandlerThread) kmpContextQueueHandlerThread.getValue();
    }

    public static /* synthetic */ void e(KuiklyRenderCoreKmpScheduler kuiklyRenderCoreKmpScheduler, Function0 function0, long j3, boolean z16, long j16, int i3, Object obj) {
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
        kuiklyRenderCoreKmpScheduler.d(function0, j17, z17, j16);
    }

    private final void f(long delayMs, long timeout, Function0<Unit> task) {
        b.a(b(), delayMs, timeout, task);
    }

    public final void d(@NotNull final Function0<Unit> task, long delayMs, boolean sync, long syncTimeoutMs) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (sync) {
            f(delayMs, syncTimeoutMs, task);
        } else {
            b().postDelayed(new Runnable() { // from class: com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderCoreKmpScheduler$sam$java_lang_Runnable$0
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Intrinsics.checkNotNullExpressionValue(Function0.this.invoke(), "invoke(...)");
                }
            }, delayMs);
        }
    }
}
