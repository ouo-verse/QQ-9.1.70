package com.tencent.qqnt.startup;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.startup.task.NtTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J=\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042%\b\u0002\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/startup/NtStartupDispatcher;", "", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/startup/task/NtTask;", "task", "", "c", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onCompleted", "b", "Lcom/tencent/qqnt/startup/c;", "a", "Lcom/tencent/qqnt/startup/c;", "mStartupExecutor", "<init>", "()V", "nt_startup_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class NtStartupDispatcher {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mStartupExecutor;

    public NtStartupDispatcher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mStartupExecutor = new c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(Context context, NtTask task) {
        com.tencent.qqnt.startup.utils.d dVar = com.tencent.qqnt.startup.utils.d.f362285a;
        dVar.b(task.getTaskId());
        long uptimeMillis = SystemClock.uptimeMillis();
        task.onTaskStart();
        task.onWait();
        long uptimeMillis2 = SystemClock.uptimeMillis();
        task.run(context);
        task.onTaskFinish();
        long uptimeMillis3 = SystemClock.uptimeMillis();
        com.tencent.qqnt.startup.utils.a.a("[NtStartup]", "task:" + task.getTaskId() + ", wait:" + (uptimeMillis2 - uptimeMillis) + ", run:" + (uptimeMillis3 - uptimeMillis2) + ", total:" + (uptimeMillis3 - uptimeMillis) + ", thread:" + Thread.currentThread().getName());
        dVar.d(task.getTaskId());
    }

    public final void b(@NotNull final Context context, @NotNull final NtTask task, @Nullable final Function1<? super NtTask, Unit> onCompleted) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, task, onCompleted);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.runOnMainThread()) {
            if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
                c(context, task);
                if (onCompleted != null) {
                    onCompleted.invoke(task);
                    return;
                }
                return;
            }
            this.mStartupExecutor.c(new Function0<Unit>(context, task, onCompleted) { // from class: com.tencent.qqnt.startup.NtStartupDispatcher$dispatcher$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Context $context;
                final /* synthetic */ Function1<NtTask, Unit> $onCompleted;
                final /* synthetic */ NtTask $task;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$context = context;
                    this.$task = task;
                    this.$onCompleted = onCompleted;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, NtStartupDispatcher.this, context, task, onCompleted);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    NtStartupDispatcher.this.c(this.$context, this.$task);
                    Function1<NtTask, Unit> function1 = this.$onCompleted;
                    if (function1 != null) {
                        function1.invoke(this.$task);
                    }
                }
            });
            return;
        }
        this.mStartupExecutor.e(new Function0<Unit>(context, task, onCompleted) { // from class: com.tencent.qqnt.startup.NtStartupDispatcher$dispatcher$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;
            final /* synthetic */ Function1<NtTask, Unit> $onCompleted;
            final /* synthetic */ NtTask $task;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                this.$task = task;
                this.$onCompleted = onCompleted;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, NtStartupDispatcher.this, context, task, onCompleted);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                NtStartupDispatcher.this.c(this.$context, this.$task);
                Function1<NtTask, Unit> function1 = this.$onCompleted;
                if (function1 != null) {
                    function1.invoke(this.$task);
                }
            }
        });
    }
}
