package androidx.compose.runtime;

import android.os.Looper;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a/\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u0002H\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\f0\u000fH\u0000\u00a2\u0006\u0002\u0010\u0010\"!\u0010\u0000\u001a\u00020\u00018FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000*\f\b\u0000\u0010\u0011\"\u00020\u00122\u00020\u0012\u00a8\u0006\u0013"}, d2 = {"DefaultMonotonicFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;", "getDefaultMonotonicFrameClock$annotations", "()V", "getDefaultMonotonicFrameClock", "()Landroidx/compose/runtime/MonotonicFrameClock;", "DefaultMonotonicFrameClock$delegate", "Lkotlin/Lazy;", "DisallowDefaultMonotonicFrameClock", "", "createSnapshotMutableState", "Landroidx/compose/runtime/snapshots/SnapshotMutableState;", "T", "value", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "(Ljava/lang/Object;Landroidx/compose/runtime/SnapshotMutationPolicy;)Landroidx/compose/runtime/snapshots/SnapshotMutableState;", "CheckResult", "Landroidx/annotation/CheckResult;", "runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class ActualAndroid_androidKt {
    private static final Lazy DefaultMonotonicFrameClock$delegate;
    private static final boolean DisallowDefaultMonotonicFrameClock = false;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MonotonicFrameClock>() { // from class: androidx.compose.runtime.ActualAndroid_androidKt$DefaultMonotonicFrameClock$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MonotonicFrameClock invoke() {
                return Looper.getMainLooper() != null ? DefaultChoreographerFrameClock.INSTANCE : SdkStubsFallbackFrameClock.INSTANCE;
            }
        });
        DefaultMonotonicFrameClock$delegate = lazy;
    }

    public static final <T> SnapshotMutableState<T> createSnapshotMutableState(T t16, SnapshotMutationPolicy<T> policy) {
        Intrinsics.checkNotNullParameter(policy, "policy");
        return new ParcelableSnapshotMutableState(t16, policy);
    }

    public static final MonotonicFrameClock getDefaultMonotonicFrameClock() {
        return (MonotonicFrameClock) DefaultMonotonicFrameClock$delegate.getValue();
    }

    @Deprecated(message = "MonotonicFrameClocks are not globally applicable across platforms. Use an appropriate local clock.")
    public static /* synthetic */ void getDefaultMonotonicFrameClock$annotations() {
    }
}
