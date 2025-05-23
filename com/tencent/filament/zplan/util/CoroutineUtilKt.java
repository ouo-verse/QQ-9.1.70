package com.tencent.filament.zplan.util;

import android.os.Handler;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Landroid/os/Handler;", "Lkotlinx/coroutines/CoroutineDispatcher;", "a", "zplan-android_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class CoroutineUtilKt {
    @NotNull
    public static final CoroutineDispatcher a(@NotNull final Handler asCoroutineDispatcher) {
        Intrinsics.checkNotNullParameter(asCoroutineDispatcher, "$this$asCoroutineDispatcher");
        return ExecutorsKt.from(new Executor() { // from class: com.tencent.filament.zplan.util.CoroutineUtilKt$asCoroutineDispatcher$1
            @Override // java.util.concurrent.Executor
            public final void execute(final Runnable runnable) {
                asCoroutineDispatcher.post(new Runnable() { // from class: com.tencent.filament.zplan.util.CoroutineUtilKt$asCoroutineDispatcher$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        runnable.run();
                    }
                });
            }
        });
    }
}
