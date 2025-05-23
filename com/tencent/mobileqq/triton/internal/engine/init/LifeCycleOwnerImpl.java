package com.tencent.mobileqq.triton.internal.engine.init;

import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.internal.lifecycle.LifeCycleOwner;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\rJ\u0006\u0010\u0014\u001a\u00020\rJ\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000bH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/engine/init/LifeCycleOwnerImpl;", "Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;", "()V", "engineState", "Lcom/tencent/mobileqq/triton/engine/EngineState;", "getEngineState", "()Lcom/tencent/mobileqq/triton/engine/EngineState;", "setEngineState", "(Lcom/tencent/mobileqq/triton/engine/EngineState;)V", "lifeCycles", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mobileqq/triton/lifecycle/LifeCycle;", "clearLifeCycles", "", "notifyOnDestroy", "notifyOnFirstFrame", "notifyOnGameLaunched", EnginePathProvider.ENGINE_DIR, "Lcom/tencent/mobileqq/triton/TritonEngine;", "notifyOnStart", "notifyOnStop", "observeLifeCycle", "lifeCycle", "removeLifeCycleObserver", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
final class LifeCycleOwnerImpl implements LifeCycleOwner {

    @Nullable
    private EngineState engineState;
    private final CopyOnWriteArrayList<LifeCycle> lifeCycles = new CopyOnWriteArrayList<>();

    public final void clearLifeCycles() {
        this.lifeCycles.clear();
    }

    @Override // com.tencent.mobileqq.triton.internal.lifecycle.LifeCycleOwner
    @Nullable
    public EngineState getEngineState() {
        return this.engineState;
    }

    public final void notifyOnDestroy() {
        Iterator<T> it = this.lifeCycles.iterator();
        while (it.hasNext()) {
            ((LifeCycle) it.next()).onDestroy();
        }
    }

    public final void notifyOnFirstFrame() {
        Iterator<T> it = this.lifeCycles.iterator();
        while (it.hasNext()) {
            ((LifeCycle) it.next()).onFirstFrame();
        }
    }

    public final void notifyOnGameLaunched(@NotNull TritonEngine engine) {
        Intrinsics.checkParameterIsNotNull(engine, "engine");
        Iterator<T> it = this.lifeCycles.iterator();
        while (it.hasNext()) {
            ((LifeCycle) it.next()).onGameLaunched(engine);
        }
    }

    public final void notifyOnStart() {
        Iterator<T> it = this.lifeCycles.iterator();
        while (it.hasNext()) {
            ((LifeCycle) it.next()).onStart();
        }
    }

    public final void notifyOnStop() {
        Iterator<T> it = this.lifeCycles.iterator();
        while (it.hasNext()) {
            ((LifeCycle) it.next()).onStop();
        }
    }

    @Override // com.tencent.mobileqq.triton.internal.lifecycle.LifeCycleOwner
    public void observeLifeCycle(@NotNull LifeCycle lifeCycle) {
        Intrinsics.checkParameterIsNotNull(lifeCycle, "lifeCycle");
        this.lifeCycles.add(lifeCycle);
    }

    @Override // com.tencent.mobileqq.triton.internal.lifecycle.LifeCycleOwner
    public void removeLifeCycleObserver(@NotNull LifeCycle lifeCycle) {
        Intrinsics.checkParameterIsNotNull(lifeCycle, "lifeCycle");
        this.lifeCycles.remove(lifeCycle);
    }

    public void setEngineState(@Nullable EngineState engineState) {
        this.engineState = engineState;
    }
}
