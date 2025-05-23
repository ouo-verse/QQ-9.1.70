package kotlinx.atomicfu;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H\u0000\"\u001e\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0001@BX\u0080\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"<set-?>", "Lkotlinx/atomicfu/AtomicOperationInterceptor;", "interceptor", "getInterceptor", "()Lkotlinx/atomicfu/AtomicOperationInterceptor;", "interceptorLock", "Ljava/util/concurrent/locks/ReentrantLock;", "lockAndSetInterceptor", "", "impl", "unlockAndResetInterceptor", "atomicfu"}, k = 2, mv = {1, 4, 3})
/* loaded from: classes28.dex */
public final class InterceptorKt {

    @NotNull
    private static AtomicOperationInterceptor interceptor = DefaultInterceptor.INSTANCE;
    private static final ReentrantLock interceptorLock = new ReentrantLock();

    @NotNull
    public static final AtomicOperationInterceptor getInterceptor() {
        return interceptor;
    }

    public static final void lockAndSetInterceptor(@NotNull AtomicOperationInterceptor impl) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        if (interceptorLock.tryLock() && interceptor == DefaultInterceptor.INSTANCE) {
            interceptor = impl;
            return;
        }
        throw new IllegalStateException(("Interceptor is locked by another test: " + interceptor).toString());
    }

    public static final void unlockAndResetInterceptor(@NotNull AtomicOperationInterceptor impl) {
        boolean z16;
        Intrinsics.checkNotNullParameter(impl, "impl");
        if (interceptor == impl) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            interceptor = DefaultInterceptor.INSTANCE;
            interceptorLock.unlock();
        } else {
            throw new IllegalStateException(("Unexpected interceptor found: " + interceptor).toString());
        }
    }
}
