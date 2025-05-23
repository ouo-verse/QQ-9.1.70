package kotlinx.atomicfu;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.TraceBase;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002\u00a2\u0006\u0002\u0010\u0004\u001a)\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007\u001a\u000e\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\t\u001a\u0018\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u000e\u0010\u0000\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u000b\u001a\u0018\u0010\u0000\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u000b2\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u000e\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\r\u001a\u0018\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\r2\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u000e"}, d2 = {"atomic", "Lkotlinx/atomicfu/AtomicRef;", "T", "initial", "(Ljava/lang/Object;)Lkotlinx/atomicfu/AtomicRef;", "trace", "Lkotlinx/atomicfu/TraceBase;", "(Ljava/lang/Object;Lkotlinx/atomicfu/TraceBase;)Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/atomicfu/AtomicBoolean;", "", "Lkotlinx/atomicfu/AtomicInt;", "", "Lkotlinx/atomicfu/AtomicLong;", "", "atomicfu"}, k = 2, mv = {1, 4, 3})
@JvmName(name = "AtomicFU")
/* loaded from: classes28.dex */
public final class AtomicFU {
    @NotNull
    public static final <T> AtomicRef<T> atomic(T t16, @NotNull TraceBase trace) {
        Intrinsics.checkNotNullParameter(trace, "trace");
        return new AtomicRef<>(t16, trace);
    }

    public static /* synthetic */ AtomicBoolean atomic$default(boolean z16, TraceBase traceBase, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            traceBase = TraceBase.None.INSTANCE;
        }
        return atomic(z16, traceBase);
    }

    @NotNull
    public static final <T> AtomicRef<T> atomic(T t16) {
        return atomic(t16, TraceBase.None.INSTANCE);
    }

    public static /* synthetic */ AtomicInt atomic$default(int i3, TraceBase traceBase, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            traceBase = TraceBase.None.INSTANCE;
        }
        return atomic(i3, traceBase);
    }

    @NotNull
    public static final AtomicInt atomic(int i3, @NotNull TraceBase trace) {
        Intrinsics.checkNotNullParameter(trace, "trace");
        return new AtomicInt(i3, trace);
    }

    public static /* synthetic */ AtomicLong atomic$default(long j3, TraceBase traceBase, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            traceBase = TraceBase.None.INSTANCE;
        }
        return atomic(j3, traceBase);
    }

    @NotNull
    public static final AtomicInt atomic(int i3) {
        return atomic(i3, (TraceBase) TraceBase.None.INSTANCE);
    }

    public static /* synthetic */ AtomicRef atomic$default(Object obj, TraceBase traceBase, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            traceBase = TraceBase.None.INSTANCE;
        }
        return atomic(obj, traceBase);
    }

    @NotNull
    public static final AtomicLong atomic(long j3, @NotNull TraceBase trace) {
        Intrinsics.checkNotNullParameter(trace, "trace");
        return new AtomicLong(j3, trace);
    }

    @NotNull
    public static final AtomicLong atomic(long j3) {
        return atomic(j3, TraceBase.None.INSTANCE);
    }

    @NotNull
    public static final AtomicBoolean atomic(boolean z16, @NotNull TraceBase trace) {
        Intrinsics.checkNotNullParameter(trace, "trace");
        return new AtomicBoolean(z16, trace);
    }

    @NotNull
    public static final AtomicBoolean atomic(boolean z16) {
        return atomic(z16, TraceBase.None.INSTANCE);
    }
}
