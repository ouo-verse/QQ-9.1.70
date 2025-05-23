package kotlinx.coroutines.flow;

import androidx.fragment.app.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/flow/StartedWhileSubscribed;", "Lkotlinx/coroutines/flow/SharingStarted;", "stopTimeout", "", "replayExpiration", "(JJ)V", "command", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "", "equals", "", "other", "", "hashCode", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class StartedWhileSubscribed implements SharingStarted {
    private final long replayExpiration;
    private final long stopTimeout;

    public StartedWhileSubscribed(long j3, long j16) {
        boolean z16;
        this.stopTimeout = j3;
        this.replayExpiration = j16;
        if (j3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (j16 >= 0) {
                return;
            }
            throw new IllegalArgumentException(("replayExpiration(" + j16 + " ms) cannot be negative").toString());
        }
        throw new IllegalArgumentException(("stopTimeout(" + j3 + " ms) cannot be negative").toString());
    }

    @Override // kotlinx.coroutines.flow.SharingStarted
    @NotNull
    public Flow<SharingCommand> command(@NotNull StateFlow<Integer> subscriptionCount) {
        return FlowKt.distinctUntilChanged(FlowKt.dropWhile(FlowKt.transformLatest(subscriptionCount, new StartedWhileSubscribed$command$1(this, null)), new StartedWhileSubscribed$command$2(null)));
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof StartedWhileSubscribed) {
            StartedWhileSubscribed startedWhileSubscribed = (StartedWhileSubscribed) other;
            if (this.stopTimeout == startedWhileSubscribed.stopTimeout && this.replayExpiration == startedWhileSubscribed.replayExpiration) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (a.a(this.stopTimeout) * 31) + a.a(this.replayExpiration);
    }

    @NotNull
    public String toString() {
        List createListBuilder;
        List build;
        String joinToString$default;
        createListBuilder = CollectionsKt__CollectionsJVMKt.createListBuilder(2);
        if (this.stopTimeout > 0) {
            createListBuilder.add("stopTimeout=" + this.stopTimeout + "ms");
        }
        if (this.replayExpiration < Long.MAX_VALUE) {
            createListBuilder.add("replayExpiration=" + this.replayExpiration + "ms");
        }
        build = CollectionsKt__CollectionsJVMKt.build(createListBuilder);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("SharingStarted.WhileSubscribed(");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(build, null, null, null, 0, null, null, 63, null);
        sb5.append(joinToString$default);
        sb5.append(')');
        return sb5.toString();
    }
}
