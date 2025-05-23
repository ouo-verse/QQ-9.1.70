package kotlinx.atomicfu;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u000bH\u0016J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\rH\u0016J1\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u000e2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u000f2\u0006\u0010\u0007\u001a\u0002H\u000e2\u0006\u0010\t\u001a\u0002H\u000eH\u0016\u00a2\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\rH\u0016J)\u0010\u0011\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u000e2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u000f2\u0006\u0010\t\u001a\u0002H\u000eH\u0016\u00a2\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\fH\u0016J\u001c\u0010\u0013\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u000e2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u000fH\u0016\u00a8\u0006\u0014"}, d2 = {"Lkotlinx/atomicfu/AtomicOperationInterceptor;", "", "()V", "afterRMW", "", "ref", "Lkotlinx/atomicfu/AtomicBoolean;", "oldValue", "", "newValue", "Lkotlinx/atomicfu/AtomicInt;", "", "Lkotlinx/atomicfu/AtomicLong;", "", "T", "Lkotlinx/atomicfu/AtomicRef;", "(Lkotlinx/atomicfu/AtomicRef;Ljava/lang/Object;Ljava/lang/Object;)V", "afterSet", "(Lkotlinx/atomicfu/AtomicRef;Ljava/lang/Object;)V", "beforeUpdate", "atomicfu"}, k = 1, mv = {1, 4, 3})
/* loaded from: classes28.dex */
public class AtomicOperationInterceptor {
    public void afterRMW(@NotNull AtomicBoolean ref, boolean oldValue, boolean newValue) {
        Intrinsics.checkNotNullParameter(ref, "ref");
    }

    public void afterSet(@NotNull AtomicBoolean ref, boolean newValue) {
        Intrinsics.checkNotNullParameter(ref, "ref");
    }

    public void beforeUpdate(@NotNull AtomicBoolean ref) {
        Intrinsics.checkNotNullParameter(ref, "ref");
    }

    public void afterRMW(@NotNull AtomicInt ref, int oldValue, int newValue) {
        Intrinsics.checkNotNullParameter(ref, "ref");
    }

    public void afterSet(@NotNull AtomicInt ref, int newValue) {
        Intrinsics.checkNotNullParameter(ref, "ref");
    }

    public void beforeUpdate(@NotNull AtomicInt ref) {
        Intrinsics.checkNotNullParameter(ref, "ref");
    }

    public void afterRMW(@NotNull AtomicLong ref, long oldValue, long newValue) {
        Intrinsics.checkNotNullParameter(ref, "ref");
    }

    public void afterSet(@NotNull AtomicLong ref, long newValue) {
        Intrinsics.checkNotNullParameter(ref, "ref");
    }

    public void beforeUpdate(@NotNull AtomicLong ref) {
        Intrinsics.checkNotNullParameter(ref, "ref");
    }

    public <T> void afterRMW(@NotNull AtomicRef<T> ref, T oldValue, T newValue) {
        Intrinsics.checkNotNullParameter(ref, "ref");
    }

    public <T> void afterSet(@NotNull AtomicRef<T> ref, T newValue) {
        Intrinsics.checkNotNullParameter(ref, "ref");
    }

    public <T> void beforeUpdate(@NotNull AtomicRef<T> ref) {
        Intrinsics.checkNotNullParameter(ref, "ref");
    }
}
