package com.tencent.ecommerce.base.threadpool.api;

import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/base/threadpool/api/ECDefaultThreadPool;", "Lcom/tencent/ecommerce/base/threadpool/api/IECThreadPoolProxy;", "Lkotlin/Function0;", "", "runnable", "execOnSubThread", "", "a", "J", "KEEP_ALIVE_TIME", "", "b", "I", "BLOCKING_QUEUE_SIZE", "c", "CPU_COUNT", "d", "NET_MAX_POOL_SIZE", "Ljava/util/concurrent/ThreadPoolExecutor;", "e", "Lkotlin/Lazy;", "()Ljava/util/concurrent/ThreadPoolExecutor;", "subThreadPoolExecutor", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class ECDefaultThreadPool implements IECThreadPoolProxy {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long KEEP_ALIVE_TIME = 1;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int BLOCKING_QUEUE_SIZE = 128;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int CPU_COUNT;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int NET_MAX_POOL_SIZE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy subThreadPoolExecutor;

    public ECDefaultThreadPool() {
        Lazy lazy;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.CPU_COUNT = availableProcessors;
        this.NET_MAX_POOL_SIZE = availableProcessors * 2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ThreadPoolExecutor>() { // from class: com.tencent.ecommerce.base.threadpool.api.ECDefaultThreadPool$subThreadPoolExecutor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ThreadPoolExecutor invoke() {
                int i3;
                int i16;
                long j3;
                int i17;
                i3 = ECDefaultThreadPool.this.CPU_COUNT;
                i16 = ECDefaultThreadPool.this.NET_MAX_POOL_SIZE;
                j3 = ECDefaultThreadPool.this.KEEP_ALIVE_TIME;
                TimeUnit timeUnit = TimeUnit.SECONDS;
                i17 = ECDefaultThreadPool.this.BLOCKING_QUEUE_SIZE;
                return new BaseThreadPoolExecutor(i3, i16, j3, timeUnit, new LinkedBlockingQueue(i17));
            }
        });
        this.subThreadPoolExecutor = lazy;
    }

    private final ThreadPoolExecutor e() {
        return (ThreadPoolExecutor) this.subThreadPoolExecutor.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.tencent.ecommerce.base.threadpool.api.ECDefaultThreadPool$sam$java_lang_Runnable$0] */
    @Override // com.tencent.ecommerce.base.threadpool.api.IECThreadPoolProxy
    public void execOnSubThread(@NotNull final Function0<Unit> runnable) {
        ThreadPoolExecutor e16 = e();
        if (runnable != null) {
            runnable = new Runnable() { // from class: com.tencent.ecommerce.base.threadpool.api.ECDefaultThreadPool$sam$java_lang_Runnable$0
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Function0.this.invoke();
                }
            };
        }
        e16.execute((Runnable) runnable);
    }
}
