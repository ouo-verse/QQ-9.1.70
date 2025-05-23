package com.tencent.mobileqq.triton.internal.utils;

import com.tencent.map.geolocation.TencentLocation;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000b\u0010\n\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00028\u0000X\u0082.\u00a2\u0006\u0004\n\u0002\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/utils/AsyncResult;", "T", "", "()V", "error", "", "latch", "Ljava/util/concurrent/CountDownLatch;", "result", "Ljava/lang/Object;", "awaitResult", "()Ljava/lang/Object;", TencentLocation.RUN_MODE, "", "producer", "Lkotlin/Function0;", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class AsyncResult<T> {
    private Throwable error;
    private final CountDownLatch latch = new CountDownLatch(1);
    private T result;

    @NotNull
    public final T awaitResult() {
        this.latch.await();
        Throwable th5 = this.error;
        if (th5 == null) {
            T t16 = this.result;
            if (t16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("result");
            }
            return t16;
        }
        throw th5;
    }

    public final void run(@NotNull Function0<? extends T> producer) {
        Intrinsics.checkParameterIsNotNull(producer, "producer");
        try {
            this.result = producer.invoke();
        } finally {
            try {
            } finally {
            }
        }
    }
}
