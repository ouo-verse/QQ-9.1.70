package com.tencent.qq.minibox.proxy;

import com.tencent.minibox.proxy.ExecutorProxy;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qq/minibox/proxy/b;", "Lcom/tencent/minibox/proxy/ExecutorProxy;", "Ljava/lang/Runnable;", "runnable", "", "execute", "", "delayMillis", "executeDelay", "<init>", "()V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b implements ExecutorProxy {
    @Override // com.tencent.minibox.proxy.ExecutorProxy
    public void execute(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ThreadManagerV2.excute(runnable, 16, null, true);
    }

    @Override // com.tencent.minibox.proxy.ExecutorProxy
    public void executeDelay(@NotNull Runnable runnable, long delayMillis) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ThreadManager.getSubThreadHandler().postDelayed(runnable, delayMillis);
    }
}
