package com.tencent.richframework.delegate;

import android.os.Debug;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.delegate.impl.RFWReporter;
import com.tencent.biz.richframework.util.RFWStringBuilderUtils;
import com.tencent.richframework.thread.RFWThreadPoolExecuteListener;
import com.tencent.richframework.thread.pool.RFWSubThreadPool;
import com.tencent.richframework.thread.pool.RFWThreadPool;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u0010\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/richframework/delegate/RFWThreadPoolExecuteListenerImpl;", "Lcom/tencent/richframework/thread/RFWThreadPoolExecuteListener;", "", QCircleWeakNetReporter.KEY_COST, "Lcom/tencent/richframework/thread/pool/RFWThreadPool;", "pool", "Ljava/lang/Runnable;", "runnable", "", "throwable", "", "handleCostThreshold", "", "enableMonitor", "Ljava/lang/Thread;", MosaicConstants$JsProperty.PROP_THREAD, "beforeExecute", "afterExecute", "Ljava/lang/ThreadLocal;", "threadLocal", "Ljava/lang/ThreadLocal;", "<init>", "()V", "Companion", "qq-rfw-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RFWThreadPoolExecuteListenerImpl implements RFWThreadPoolExecuteListener {

    @NotNull
    private final ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    private final boolean enableMonitor(RFWThreadPool pool) {
        if (!Debug.isDebuggerConnected() && (pool instanceof RFWSubThreadPool)) {
            return true;
        }
        return false;
    }

    private final void handleCostThreshold(long cost, RFWThreadPool pool, Runnable runnable, Throwable throwable) {
        String msg2 = RFWStringBuilderUtils.getString("[handleCostThreshold] debug cost=", Long.valueOf(cost), ", activeCount=", Integer.valueOf(pool.getActiveCount()), ", poolSize=", Integer.valueOf(pool.getPoolSize()), ", maximumPoolSize=", Integer.valueOf(pool.getMaximumPoolSize()), ", runnable=", runnable, ", error=", throwable);
        RFWLog.e("RFWThreadPoolExecuteListenerImpl", RFWLog.DEV, new Throwable(msg2));
        HashMap hashMap = new HashMap();
        Intrinsics.checkNotNullExpressionValue(msg2, "msg");
        hashMap.put("performance_data", msg2);
        RFWReporter.report("rfw_thread_performance_report", hashMap);
    }

    @Override // com.tencent.richframework.thread.RFWThreadPoolExecuteListener
    public void afterExecute(@NotNull RFWThreadPool pool, @NotNull Runnable runnable, @Nullable Throwable throwable) {
        Long l3;
        Intrinsics.checkNotNullParameter(pool, "pool");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (!enableMonitor(pool) || (l3 = this.threadLocal.get()) == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - l3.longValue();
        if (currentTimeMillis > 3000) {
            handleCostThreshold(currentTimeMillis, pool, runnable, throwable);
        }
    }

    @Override // com.tencent.richframework.thread.RFWThreadPoolExecuteListener
    public void beforeExecute(@NotNull RFWThreadPool pool, @NotNull Thread thread, @NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        Intrinsics.checkNotNullParameter(thread, "thread");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (!enableMonitor(pool)) {
            return;
        }
        this.threadLocal.set(Long.valueOf(System.currentTimeMillis()));
    }
}
