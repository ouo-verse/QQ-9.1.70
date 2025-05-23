package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DispatchersKt;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.SystemPropsKt;
import kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lkotlinx/coroutines/scheduling/DefaultScheduler;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "()V", "IO", "Lkotlinx/coroutines/CoroutineDispatcher;", "getIO", "()Lkotlinx/coroutines/CoroutineDispatcher;", "close", "", "toDebugString", "", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class DefaultScheduler extends ExperimentalCoroutineDispatcher {

    @NotNull
    public static final DefaultScheduler INSTANCE;

    @NotNull
    private static final CoroutineDispatcher IO;

    static {
        int coerceAtLeast;
        int systemProp$default;
        DefaultScheduler defaultScheduler = new DefaultScheduler();
        INSTANCE = defaultScheduler;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(64, SystemPropsKt.getAVAILABLE_PROCESSORS());
        systemProp$default = SystemPropsKt__SystemProps_commonKt.systemProp$default(DispatchersKt.IO_PARALLELISM_PROPERTY_NAME, coerceAtLeast, 0, 0, 12, (Object) null);
        IO = new LimitingDispatcher(defaultScheduler, systemProp$default, "Dispatchers.IO", 1);
    }

    DefaultScheduler() {
        super(0, 0, null, 7, null);
    }

    @Override // kotlinx.coroutines.scheduling.ExperimentalCoroutineDispatcher, kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @NotNull
    public final CoroutineDispatcher getIO() {
        return IO;
    }

    @InternalCoroutinesApi
    @NotNull
    public final String toDebugString() {
        return super.toString();
    }

    @Override // kotlinx.coroutines.scheduling.ExperimentalCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        return TasksKt.DEFAULT_DISPATCHER_NAME;
    }
}
