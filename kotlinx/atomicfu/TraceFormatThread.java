package kotlinx.atomicfu;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lkotlinx/atomicfu/TraceFormatThread;", "Lkotlinx/atomicfu/TraceFormat;", "()V", "format", "", "index", "", "event", "", "atomicfu"}, k = 1, mv = {1, 4, 3})
/* loaded from: classes28.dex */
final class TraceFormatThread extends TraceFormat {
    @Override // kotlinx.atomicfu.TraceFormat
    @NotNull
    public String format(int index, @NotNull Object event) {
        Intrinsics.checkNotNullParameter(event, "event");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(index);
        sb5.append(": [");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        sb5.append(currentThread.getName());
        sb5.append("] ");
        sb5.append(event);
        return sb5.toString();
    }
}
