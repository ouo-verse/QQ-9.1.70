package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B+\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bR\u0010\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lkotlinx/coroutines/flow/SharingConfig;", "T", "", "upstream", "Lkotlinx/coroutines/flow/Flow;", "extraBufferCapacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/flow/Flow;ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/coroutines/CoroutineContext;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class SharingConfig<T> {

    @JvmField
    @NotNull
    public final CoroutineContext context;

    @JvmField
    public final int extraBufferCapacity;

    @JvmField
    @NotNull
    public final BufferOverflow onBufferOverflow;

    @JvmField
    @NotNull
    public final Flow<T> upstream;

    /* JADX WARN: Multi-variable type inference failed */
    public SharingConfig(@NotNull Flow<? extends T> flow, int i3, @NotNull BufferOverflow bufferOverflow, @NotNull CoroutineContext coroutineContext) {
        this.upstream = flow;
        this.extraBufferCapacity = i3;
        this.onBufferOverflow = bufferOverflow;
        this.context = coroutineContext;
    }
}
