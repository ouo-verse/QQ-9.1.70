package com.tencent.filament.zplan.app.impl;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.filament.zplanservice.util.log.FLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u001c\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bJ\u0014\u0010\r\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bJ$\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bJ\u001c\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bJ\u0006\u0010\u0013\u001a\u00020\u0012R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/filament/zplan/app/impl/FilamentThreadHandler;", "", "Ljava/lang/Runnable;", "task", "", "b", h.F, "i", "j", "", "taskName", "Lkotlin/Function0;", "d", "e", "", "delay", "g", "f", "Lkotlinx/coroutines/CoroutineDispatcher;", "c", "", "a", "Ljava/util/List;", "pendingTaskQueue", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "canExecute", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "", "threadPriority", "<init>", "(I)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentThreadHandler {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<Runnable> pendingTaskQueue = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean canExecute = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Handler handler;

    public FilamentThreadHandler(int i3) {
        HandlerThread b16;
        b16 = a.b(i3);
        this.handler = new Handler(b16.getLooper());
    }

    private final void b(Runnable task) {
        synchronized (this.pendingTaskQueue) {
            this.pendingTaskQueue.add(task);
        }
    }

    private final void h() {
        if (!this.canExecute.get()) {
            return;
        }
        synchronized (this.pendingTaskQueue) {
            Iterator<Runnable> it = this.pendingTaskQueue.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            this.pendingTaskQueue.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    @NotNull
    public final CoroutineDispatcher c() {
        return ExecutorsKt.from(new Executor() { // from class: com.tencent.filament.zplan.app.impl.FilamentThreadHandler$asCoroutineDispatcher$1
            @Override // java.util.concurrent.Executor
            public final void execute(final Runnable runnable) {
                FilamentThreadHandler.this.e(new Function0<Unit>() { // from class: com.tencent.filament.zplan.app.impl.FilamentThreadHandler$asCoroutineDispatcher$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        runnable.run();
                    }
                });
            }
        });
    }

    public final void d(@NotNull final String taskName, @NotNull final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        Intrinsics.checkNotNullParameter(task, "task");
        FLog.INSTANCE.i("FilamentThreadHandler", "addTask. name: " + taskName + ", " + this);
        b(new Runnable() { // from class: com.tencent.filament.zplan.app.impl.FilamentThreadHandler$post$1
            @Override // java.lang.Runnable
            public final void run() {
                Handler handler;
                handler = FilamentThreadHandler.this.handler;
                handler.post(new Runnable() { // from class: com.tencent.filament.zplan.app.impl.FilamentThreadHandler$post$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        FLog fLog = FLog.INSTANCE;
                        fLog.i("FilamentThreadHandler", "before doTask: " + taskName + ", " + FilamentThreadHandler.this);
                        task.invoke();
                        fLog.i("FilamentThreadHandler", "after doTask: " + taskName + ", " + FilamentThreadHandler.this);
                    }
                });
            }
        });
        h();
    }

    public final void e(@NotNull final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        b(new Runnable() { // from class: com.tencent.filament.zplan.app.impl.FilamentThreadHandler$post$2
            @Override // java.lang.Runnable
            public final void run() {
                Handler handler;
                handler = FilamentThreadHandler.this.handler;
                handler.post(new Runnable() { // from class: com.tencent.filament.zplan.app.impl.FilamentThreadHandler$post$2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        task.invoke();
                    }
                });
            }
        });
        h();
    }

    public final void f(final long delay, @NotNull final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        b(new Runnable() { // from class: com.tencent.filament.zplan.app.impl.FilamentThreadHandler$postDelayed$2
            @Override // java.lang.Runnable
            public final void run() {
                Handler handler;
                handler = FilamentThreadHandler.this.handler;
                handler.postDelayed(new Runnable() { // from class: com.tencent.filament.zplan.app.impl.FilamentThreadHandler$postDelayed$2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        task.invoke();
                    }
                }, delay);
            }
        });
        h();
    }

    public final void g(@NotNull final String taskName, final long delay, @NotNull final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        Intrinsics.checkNotNullParameter(task, "task");
        FLog.INSTANCE.i("FilamentThreadHandler", "addTaskDelayed. name: " + taskName + ", delay: " + delay + ", " + this);
        b(new Runnable() { // from class: com.tencent.filament.zplan.app.impl.FilamentThreadHandler$postDelayed$1
            @Override // java.lang.Runnable
            public final void run() {
                Handler handler;
                handler = FilamentThreadHandler.this.handler;
                handler.postDelayed(new Runnable() { // from class: com.tencent.filament.zplan.app.impl.FilamentThreadHandler$postDelayed$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        FLog fLog = FLog.INSTANCE;
                        fLog.i("FilamentThreadHandler", "before doTask: " + taskName + ", " + FilamentThreadHandler.this);
                        task.invoke();
                        fLog.i("FilamentThreadHandler", "after doTask: " + taskName + ", " + FilamentThreadHandler.this);
                    }
                }, delay);
            }
        });
        h();
    }

    public final void i() {
        this.canExecute.set(true);
        h();
    }

    public final void j() {
        this.canExecute.set(false);
        this.handler.getLooper().quitSafely();
    }
}
