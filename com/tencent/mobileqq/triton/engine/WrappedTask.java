package com.tencent.mobileqq.triton.engine;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.TritonException;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.statistic.ErrorCallback;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00060\u00060\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/triton/engine/WrappedTask;", "Ljava/lang/Runnable;", "tag", "", "realTask", EnginePathProvider.ENGINE_DIR, "Lcom/tencent/mobileqq/triton/engine/TTEngine;", "(Ljava/lang/String;Ljava/lang/Runnable;Lcom/tencent/mobileqq/triton/engine/TTEngine;)V", "engineRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", TencentLocation.RUN_MODE, "", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class WrappedTask implements Runnable {
    private final WeakReference<TTEngine> engineRef;
    private final Runnable realTask;
    private final String tag;

    public WrappedTask(@NotNull String tag, @NotNull Runnable realTask, @NotNull TTEngine engine) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(realTask, "realTask");
        Intrinsics.checkParameterIsNotNull(engine, "engine");
        this.tag = tag;
        this.realTask = realTask;
        this.engineRef = new WeakReference<>(engine);
    }

    @Override // java.lang.Runnable
    public void run() {
        TTEngine tTEngine = this.engineRef.get();
        if (tTEngine != null) {
            Intrinsics.checkExpressionValueIsNotNull(tTEngine, "engineRef.get() ?: return");
            try {
                this.realTask.run();
            } catch (Throwable th5) {
                String str = "postRunnableToMessageQueue run failed " + this.realTask;
                Logger.e(this.tag, str, th5);
                TritonException tritonException = new TritonException(str, ErrorCodes.UNKNOWN, th5);
                ErrorCallback value = tTEngine.getEngineContext().getStatisticsManager().getErrorCallback().getValue();
                if (value != null) {
                    value.onError(str, tritonException);
                }
            }
        }
    }
}
