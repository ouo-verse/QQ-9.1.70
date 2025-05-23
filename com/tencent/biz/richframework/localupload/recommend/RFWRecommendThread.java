package com.tencent.biz.richframework.localupload.recommend;

import android.os.Handler;
import android.os.Looper;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006R\u001b\u0010\u000f\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0013\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/RFWRecommendThread;", "", "", "threadName", "Landroid/os/Handler;", "getHandler", "Ljava/lang/Runnable;", "runnable", "", "runOnRealTimeThread", "Lcom/tencent/biz/richframework/localupload/recommend/RFWRecommendThreadPool;", "RECOMMEND_THREAD_POOL$delegate", "Lkotlin/Lazy;", "getRECOMMEND_THREAD_POOL", "()Lcom/tencent/biz/richframework/localupload/recommend/RFWRecommendThreadPool;", "RECOMMEND_THREAD_POOL", "S_REAL_TIME_HANDLER$delegate", "getS_REAL_TIME_HANDLER", "()Landroid/os/Handler;", "S_REAL_TIME_HANDLER", "S_MAIN_HANDLER", "Landroid/os/Handler;", "getS_MAIN_HANDLER", "<init>", "()V", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class RFWRecommendThread {

    @NotNull
    public static final RFWRecommendThread INSTANCE = new RFWRecommendThread();

    /* renamed from: RECOMMEND_THREAD_POOL$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy RECOMMEND_THREAD_POOL;

    @NotNull
    private static final Handler S_MAIN_HANDLER;

    /* renamed from: S_REAL_TIME_HANDLER$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy S_REAL_TIME_HANDLER;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RFWRecommendThreadPool>() { // from class: com.tencent.biz.richframework.localupload.recommend.RFWRecommendThread$RECOMMEND_THREAD_POOL$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RFWRecommendThreadPool invoke() {
                return new RFWRecommendThreadPool();
            }
        });
        RECOMMEND_THREAD_POOL = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.biz.richframework.localupload.recommend.RFWRecommendThread$S_REAL_TIME_HANDLER$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                return RFWRecommendThread.INSTANCE.getHandler("REAL_TIME_THREAD");
            }
        });
        S_REAL_TIME_HANDLER = lazy2;
        S_MAIN_HANDLER = new Handler(Looper.getMainLooper());
    }

    RFWRecommendThread() {
    }

    @NotNull
    public final Handler getHandler(@NotNull String threadName) {
        Intrinsics.checkNotNullParameter(threadName, "threadName");
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(threadName);
        baseHandlerThread.start();
        return new Handler(baseHandlerThread.getLooper());
    }

    @NotNull
    public final RFWRecommendThreadPool getRECOMMEND_THREAD_POOL() {
        return (RFWRecommendThreadPool) RECOMMEND_THREAD_POOL.getValue();
    }

    @NotNull
    public final Handler getS_MAIN_HANDLER() {
        return S_MAIN_HANDLER;
    }

    @NotNull
    public final Handler getS_REAL_TIME_HANDLER() {
        return (Handler) S_REAL_TIME_HANDLER.getValue();
    }

    public final void runOnRealTimeThread(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (Intrinsics.areEqual(getS_REAL_TIME_HANDLER().getLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            getS_REAL_TIME_HANDLER().post(runnable);
        }
    }
}
