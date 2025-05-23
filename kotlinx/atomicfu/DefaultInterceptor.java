package kotlinx.atomicfu;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lkotlinx/atomicfu/DefaultInterceptor;", "Lkotlinx/atomicfu/AtomicOperationInterceptor;", "()V", "toString", "", "atomicfu"}, k = 1, mv = {1, 4, 3})
/* loaded from: classes28.dex */
final class DefaultInterceptor extends AtomicOperationInterceptor {

    @NotNull
    public static final DefaultInterceptor INSTANCE = new DefaultInterceptor();

    DefaultInterceptor() {
    }

    @NotNull
    public String toString() {
        return "DefaultInterceptor";
    }
}
