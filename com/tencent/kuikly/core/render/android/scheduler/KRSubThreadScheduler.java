package com.tencent.kuikly.core.render.android.scheduler;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import d01.n;
import d01.u;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J \u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006J\u0018\u0010\t\u001a\u00020\u00052\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0013\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/kuikly/core/render/android/scheduler/KRSubThreadScheduler;", "", "", "delayMs", "Lkotlin/Function0;", "", "Lcom/tencent/kuikly/core/render/android/scheduler/KRSubThreadTask;", "task", "d", "e", "Landroid/os/HandlerThread;", "a", "Lkotlin/Lazy;", "c", "()Landroid/os/HandlerThread;", "logQueueHandlerThread", "Landroid/os/Handler;", "b", "()Landroid/os/Handler;", "handler", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRSubThreadScheduler {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Lazy logQueueHandlerThread;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy handler;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final KRSubThreadScheduler f118174c = new KRSubThreadScheduler();

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<HandlerThread>() { // from class: com.tencent.kuikly.core.render.android.scheduler.KRSubThreadScheduler$logQueueHandlerThread$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HandlerThread invoke() {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("KRSubThreadScheduler", 0);
                baseHandlerThread.start();
                return baseHandlerThread;
            }
        });
        logQueueHandlerThread = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.kuikly.core.render.android.scheduler.KRSubThreadScheduler$handler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                HandlerThread c16;
                c16 = KRSubThreadScheduler.f118174c.c();
                return new Handler(c16.getLooper());
            }
        });
        handler = lazy2;
    }

    KRSubThreadScheduler() {
    }

    private final Handler b() {
        return (Handler) handler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HandlerThread c() {
        return (HandlerThread) logQueueHandlerThread.getValue();
    }

    public final void d(long delayMs, @NotNull final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        u uVar = u.f392615m;
        if (uVar.k() != null) {
            n k3 = uVar.k();
            if (k3 != null) {
                k3.a(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.scheduler.KRSubThreadScheduler$scheduleTask$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Function0.this.invoke();
                    }
                });
                return;
            }
            return;
        }
        b().postDelayed(new KRSubThreadSchedulerKt$sam$java_lang_Runnable$0(task), delayMs);
    }

    public final void e(@NotNull Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        n k3 = u.f392615m.k();
        if (k3 != null) {
            k3.b(task);
        } else {
            b().post(new KRSubThreadSchedulerKt$sam$java_lang_Runnable$0(task));
        }
    }
}
