package com.tencent.mobileqq.triton.internal.render.monitor;

import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.render.RenderContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\u0002\u0010\u0007J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/render/monitor/FirstScreenMonitor;", "Lcom/tencent/mobileqq/triton/render/RenderContext$SwapListener;", "firstFameHolder", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "", "accumulatedDrawCallHolder", "", "(Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;)V", "isFirstScreen", "onSwap", "", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class FirstScreenMonitor implements RenderContext.SwapListener {
    private final ValueHolder<Long> accumulatedDrawCallHolder;
    private final ValueHolder<Boolean> firstFameHolder;
    private boolean isFirstScreen;

    public FirstScreenMonitor(@NotNull ValueHolder<Boolean> firstFameHolder, @NotNull ValueHolder<Long> accumulatedDrawCallHolder) {
        Intrinsics.checkParameterIsNotNull(firstFameHolder, "firstFameHolder");
        Intrinsics.checkParameterIsNotNull(accumulatedDrawCallHolder, "accumulatedDrawCallHolder");
        this.firstFameHolder = firstFameHolder;
        this.accumulatedDrawCallHolder = accumulatedDrawCallHolder;
        this.isFirstScreen = true;
    }

    @Override // com.tencent.mobileqq.triton.render.RenderContext.SwapListener
    public void onSwap() {
        if (this.isFirstScreen && this.accumulatedDrawCallHolder.getValue().longValue() > 0) {
            this.isFirstScreen = false;
            this.firstFameHolder.setValue(Boolean.TRUE);
        }
    }
}
