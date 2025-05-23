package com.tencent.richframework.handler;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"postIf", "", "Landroid/view/View;", "canPost", "", "runnable", "Ljava/lang/Runnable;", "threadmanager_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class HandlerExtensionKt {
    public static final void postIf(@NotNull View postIf, boolean z16, @NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(postIf, "$this$postIf");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (z16) {
            postIf.post(runnable);
        } else {
            runnable.run();
        }
    }
}
