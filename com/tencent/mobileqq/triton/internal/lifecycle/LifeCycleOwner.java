package com.tencent.mobileqq.triton.internal.lifecycle;

import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;", "", "engineState", "Lcom/tencent/mobileqq/triton/engine/EngineState;", "getEngineState", "()Lcom/tencent/mobileqq/triton/engine/EngineState;", "observeLifeCycle", "", "lifeCycle", "Lcom/tencent/mobileqq/triton/lifecycle/LifeCycle;", "removeLifeCycleObserver", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public interface LifeCycleOwner {
    @Nullable
    EngineState getEngineState();

    void observeLifeCycle(@NotNull LifeCycle lifeCycle);

    void removeLifeCycleObserver(@NotNull LifeCycle lifeCycle);
}
