package kotlinx.atomicfu;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0016J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0016J(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lkotlinx/atomicfu/TraceImpl;", "Lkotlinx/atomicfu/TraceBase;", "size", "", "format", "Lkotlinx/atomicfu/TraceFormat;", "(ILkotlinx/atomicfu/TraceFormat;)V", "index", "Ljava/util/concurrent/atomic/AtomicInteger;", "mask", "trace", "", "", "[Ljava/lang/Object;", "append", "", "event", "event1", "event2", "event3", "event4", "toString", "", "atomicfu"}, k = 1, mv = {1, 4, 3})
/* loaded from: classes28.dex */
final class TraceImpl extends TraceBase {
    private final TraceFormat format;
    private final AtomicInteger index;
    private final int mask;
    private final int size;
    private final Object[] trace;

    public TraceImpl(int i3, @NotNull TraceFormat format) {
        boolean z16;
        Intrinsics.checkNotNullParameter(format, "format");
        this.format = format;
        if (i3 >= 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            int highestOneBit = Integer.highestOneBit((i3 << 1) - 1);
            this.size = highestOneBit;
            this.mask = highestOneBit - 1;
            this.trace = new Object[highestOneBit];
            this.index = new AtomicInteger(0);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // kotlinx.atomicfu.TraceBase
    public void append(@NotNull Object event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.trace[this.index.getAndIncrement() & this.mask] = event;
    }

    @NotNull
    public String toString() {
        int i3;
        StringBuilder sb5 = new StringBuilder();
        int i16 = this.index.get();
        int i17 = this.mask & i16;
        int i18 = this.size;
        int i19 = 0;
        if (i16 > i18) {
            i3 = i16 - i18;
        } else {
            i3 = 0;
        }
        int i26 = i17;
        do {
            Object obj = this.trace[i26];
            if (obj != null) {
                int i27 = i19 + 1;
                if (i19 > 0) {
                    sb5.append('\n');
                }
                sb5.append(this.format.format(i3, obj));
                i3++;
                i19 = i27;
            }
            i26 = (i26 + 1) & this.mask;
        } while (i26 != i17);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        return sb6;
    }

    @Override // kotlinx.atomicfu.TraceBase
    public void append(@NotNull Object event1, @NotNull Object event2) {
        Intrinsics.checkNotNullParameter(event1, "event1");
        Intrinsics.checkNotNullParameter(event2, "event2");
        int andAdd = this.index.getAndAdd(2);
        Object[] objArr = this.trace;
        int i3 = this.mask;
        objArr[andAdd & i3] = event1;
        objArr[(andAdd + 1) & i3] = event2;
    }

    @Override // kotlinx.atomicfu.TraceBase
    public void append(@NotNull Object event1, @NotNull Object event2, @NotNull Object event3) {
        Intrinsics.checkNotNullParameter(event1, "event1");
        Intrinsics.checkNotNullParameter(event2, "event2");
        Intrinsics.checkNotNullParameter(event3, "event3");
        int andAdd = this.index.getAndAdd(3);
        Object[] objArr = this.trace;
        int i3 = this.mask;
        objArr[andAdd & i3] = event1;
        objArr[(andAdd + 1) & i3] = event2;
        objArr[(andAdd + 2) & i3] = event3;
    }

    @Override // kotlinx.atomicfu.TraceBase
    public void append(@NotNull Object event1, @NotNull Object event2, @NotNull Object event3, @NotNull Object event4) {
        Intrinsics.checkNotNullParameter(event1, "event1");
        Intrinsics.checkNotNullParameter(event2, "event2");
        Intrinsics.checkNotNullParameter(event3, "event3");
        Intrinsics.checkNotNullParameter(event4, "event4");
        int andAdd = this.index.getAndAdd(4);
        Object[] objArr = this.trace;
        int i3 = this.mask;
        objArr[andAdd & i3] = event1;
        objArr[(andAdd + 1) & i3] = event2;
        objArr[(andAdd + 2) & i3] = event3;
        objArr[(andAdd + 3) & i3] = event4;
    }
}
