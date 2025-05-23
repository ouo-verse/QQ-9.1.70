package com.tencent.kuikly.core.render.android.scheduler;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a.\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006H\u0000\u00a8\u0006\n"}, d2 = {"Landroid/os/Handler;", "", "delayMs", "timeout", "Lkotlin/Function0;", "", "Lcom/tencent/kuikly/core/render/android/scheduler/KuiklyRenderCoreTask;", "task", "", "a", "core-render-android_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class b {
    public static final boolean a(@NotNull Handler runTaskSyncUnsafely, long j3, long j16, @NotNull Function0<Unit> task) {
        boolean z16;
        Intrinsics.checkNotNullParameter(runTaskSyncUnsafely, "$this$runTaskSyncUnsafely");
        Intrinsics.checkNotNullParameter(task, "task");
        if (j16 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (Intrinsics.areEqual(Looper.myLooper(), runTaskSyncUnsafely.getLooper())) {
                task.invoke();
                return true;
            }
            return new BlockingRunnable(task).a(runTaskSyncUnsafely, j3, j16);
        }
        throw new IllegalArgumentException("timeout must be non-negative".toString());
    }
}
