package com.tenpay.sdk.net.utils;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\f"}, d2 = {"Lcom/tenpay/sdk/net/utils/ThreadUtils;", "", "()V", "createDefaultThreadPool", "Ljava/util/concurrent/ThreadPoolExecutor;", "name", "", "runOnSubThread", "", "runnable", "Ljava/lang/Runnable;", "runOnUiThread", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class ThreadUtils {

    @NotNull
    public static final ThreadUtils INSTANCE = new ThreadUtils();

    ThreadUtils() {
    }

    @NotNull
    public final ThreadPoolExecutor createDefaultThreadPool(@NotNull final String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(1, (Runtime.getRuntime().availableProcessors() * 2) + 1, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.tenpay.sdk.net.utils.ThreadUtils$createDefaultThreadPool$1

            @NotNull
            private final AtomicInteger count = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            @NotNull
            public Thread newThread(@NotNull Runnable r16) {
                Intrinsics.checkNotNullParameter(r16, "r");
                return new BaseThread(r16, name + "#" + this.count.getAndIncrement());
            }
        });
        baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
        return baseThreadPoolExecutor;
    }

    public final void runOnSubThread(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ThreadManagerV2.excute(runnable, 16, null, false);
    }

    public final void runOnUiThread(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ThreadManagerV2.getUIHandlerV2().post(runnable);
    }
}
