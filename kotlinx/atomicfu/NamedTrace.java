package kotlinx.atomicfu;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lkotlinx/atomicfu/NamedTrace;", "Lkotlinx/atomicfu/TraceBase;", "trace", "name", "", "(Lkotlinx/atomicfu/TraceBase;Ljava/lang/String;)V", "append", "", "event", "", "event1", "event2", "event3", "event4", "toString", "atomicfu"}, k = 1, mv = {1, 4, 3})
/* loaded from: classes28.dex */
final class NamedTrace extends TraceBase {
    private final String name;
    private final TraceBase trace;

    public NamedTrace(@NotNull TraceBase trace, @NotNull String name) {
        Intrinsics.checkNotNullParameter(trace, "trace");
        Intrinsics.checkNotNullParameter(name, "name");
        this.trace = trace;
        this.name = name;
    }

    @Override // kotlinx.atomicfu.TraceBase
    public void append(@NotNull Object event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.trace.append(this.name + '.' + event);
    }

    @NotNull
    public String toString() {
        return this.trace.toString();
    }

    @Override // kotlinx.atomicfu.TraceBase
    public void append(@NotNull Object event1, @NotNull Object event2) {
        Intrinsics.checkNotNullParameter(event1, "event1");
        Intrinsics.checkNotNullParameter(event2, "event2");
        this.trace.append(this.name + '.' + event1, this.name + '.' + event2);
    }

    @Override // kotlinx.atomicfu.TraceBase
    public void append(@NotNull Object event1, @NotNull Object event2, @NotNull Object event3) {
        Intrinsics.checkNotNullParameter(event1, "event1");
        Intrinsics.checkNotNullParameter(event2, "event2");
        Intrinsics.checkNotNullParameter(event3, "event3");
        this.trace.append(this.name + '.' + event1, this.name + '.' + event2, this.name + '.' + event3);
    }

    @Override // kotlinx.atomicfu.TraceBase
    public void append(@NotNull Object event1, @NotNull Object event2, @NotNull Object event3, @NotNull Object event4) {
        Intrinsics.checkNotNullParameter(event1, "event1");
        Intrinsics.checkNotNullParameter(event2, "event2");
        Intrinsics.checkNotNullParameter(event3, "event3");
        Intrinsics.checkNotNullParameter(event4, "event4");
        this.trace.append(this.name + '.' + event1, this.name + '.' + event2, this.name + '.' + event3, this.name + '.' + event4);
    }
}
