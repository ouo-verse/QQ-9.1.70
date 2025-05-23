package com.tencent.mobileqq.triton.internal.render.monitor;

import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.internal.utils.Utils;
import com.tencent.mobileqq.triton.render.RenderContext;
import com.tencent.mobileqq.triton.statistic.FpsUpdateListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/render/monitor/FPSMonitor;", "Lcom/tencent/mobileqq/triton/render/RenderContext$SwapListener;", "fpsUpdateListener", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "Lcom/tencent/mobileqq/triton/statistic/FpsUpdateListener;", "(Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;)V", "fpsCount", "", "lastTime", "", "onSwap", "", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class FPSMonitor implements RenderContext.SwapListener {
    private int fpsCount;
    private final ValueHolder<FpsUpdateListener> fpsUpdateListener;
    private long lastTime;

    public FPSMonitor(@NotNull ValueHolder<FpsUpdateListener> fpsUpdateListener) {
        Intrinsics.checkParameterIsNotNull(fpsUpdateListener, "fpsUpdateListener");
        this.fpsUpdateListener = fpsUpdateListener;
    }

    @Override // com.tencent.mobileqq.triton.render.RenderContext.SwapListener
    public void onSwap() {
        this.fpsCount++;
        long timeStamp = Utils.timeStamp();
        long j3 = timeStamp - this.lastTime;
        if (j3 >= 1000) {
            FpsUpdateListener value = this.fpsUpdateListener.getValue();
            if (value != null) {
                value.onFpsUpdate((this.fpsCount * 1000.0f) / ((float) j3));
            }
            this.fpsCount = 0;
            this.lastTime = timeStamp;
        }
    }
}
