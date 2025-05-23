package kotlinx.coroutines.internal;

import com.google.common.util.concurrent.b;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@InternalCoroutinesApi
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u001dB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00028\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&\u00a2\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u000e\u0010\fR\u001a\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00008V@\u0016X\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u00058F@\u0006\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0016\u001a\u00020\u00158F@\u0006\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188V@\u0016X\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/internal/AtomicOp;", "T", "<init>", "()V", "affected", "", "failure", "", "complete", "(Ljava/lang/Object;Ljava/lang/Object;)V", "decision", "decide", "(Ljava/lang/Object;)Ljava/lang/Object;", "perform", "prepare", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "getConsensus", "()Ljava/lang/Object;", "consensus", "", "isDecided", "()Z", "", "getOpSequence", "()J", "opSequence", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/OpDescriptor;"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public abstract class AtomicOp<T> extends OpDescriptor {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _consensus$FU = AtomicReferenceFieldUpdater.newUpdater(AtomicOp.class, Object.class, "_consensus");

    @NotNull
    private volatile /* synthetic */ Object _consensus = AtomicKt.NO_DECISION;

    public abstract void complete(T affected, @Nullable Object failure);

    @Nullable
    public final Object decide(@Nullable Object decision) {
        Object obj = this._consensus;
        Object obj2 = AtomicKt.NO_DECISION;
        if (obj != obj2) {
            return obj;
        }
        if (b.a(_consensus$FU, this, obj2, decision)) {
            return decision;
        }
        return this._consensus;
    }

    @Nullable
    /* renamed from: getConsensus, reason: from getter */
    public final Object get_consensus() {
        return this._consensus;
    }

    public long getOpSequence() {
        return 0L;
    }

    public final boolean isDecided() {
        if (this._consensus != AtomicKt.NO_DECISION) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.OpDescriptor
    @Nullable
    public final Object perform(@Nullable Object affected) {
        Object obj = this._consensus;
        if (obj == AtomicKt.NO_DECISION) {
            obj = decide(prepare(affected));
        }
        complete(affected, obj);
        return obj;
    }

    @Nullable
    public abstract Object prepare(T affected);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.OpDescriptor
    @NotNull
    public AtomicOp<?> getAtomicOp() {
        return this;
    }
}
