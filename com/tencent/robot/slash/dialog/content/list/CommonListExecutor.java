package com.tencent.robot.slash.dialog.content.list;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/list/CommonListExecutor;", "Ljava/util/concurrent/Executor;", "Ljava/lang/Runnable;", "command", "", "execute", "Landroidx/lifecycle/LifecycleOwner;", "d", "Landroidx/lifecycle/LifecycleOwner;", "mLifecycleOwner", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", "e", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class CommonListExecutor implements Executor {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner mLifecycleOwner;

    public CommonListExecutor(@NotNull LifecycleOwner mLifecycleOwner) {
        Intrinsics.checkNotNullParameter(mLifecycleOwner, "mLifecycleOwner");
        this.mLifecycleOwner = mLifecycleOwner;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable command) {
        Intrinsics.checkNotNullParameter(command, "command");
        Lifecycle lifecycle = this.mLifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "mLifecycleOwner.lifecycle");
        CorountineFunKt.e(LifecycleKt.getCoroutineScope(lifecycle), "SlashExecutorexecute", Boolean.FALSE, null, null, new CommonListExecutor$execute$1(command, null), 12, null);
    }
}
