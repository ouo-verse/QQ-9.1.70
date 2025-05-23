package com.tencent.mobileqq.triton.internal.engine;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0086\b\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"engineApi", "T", "Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "defaultValueOnEngineDestroyed", "action", "Lkotlin/Function0;", "(Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Triton_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class EngineContextKt {
    public static final <T> T engineApi(@NotNull EngineContext engineApi, T t16, @NotNull Function0<? extends T> action) {
        Intrinsics.checkParameterIsNotNull(engineApi, "$this$engineApi");
        Intrinsics.checkParameterIsNotNull(action, "action");
        ReentrantLock lock = engineApi.getLock();
        lock.lock();
        try {
            if (engineApi.isAlive()) {
                T invoke = action.invoke();
                InlineMarker.finallyStart(3);
                lock.unlock();
                InlineMarker.finallyEnd(3);
                return invoke;
            }
            InlineMarker.finallyStart(2);
            lock.unlock();
            InlineMarker.finallyEnd(2);
            return t16;
        } catch (Throwable th5) {
            InlineMarker.finallyStart(1);
            lock.unlock();
            InlineMarker.finallyEnd(1);
            throw th5;
        }
    }
}
