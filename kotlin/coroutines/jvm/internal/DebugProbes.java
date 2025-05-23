package kotlin.coroutines.jvm.internal;

import com.tencent.aekit.plugin.core.AIInput;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  classes28.dex
 */
/* compiled from: DebugProbes.kt */
@Metadata(mv = {1, 5, 1}, k = 2, xi = 48, d1 = {"\ufffd\ufffd\u0012\n\ufffd\ufffd\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\"\u0010\ufffd\ufffd\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\ufffd\ufffd\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\ufffd\ufffd\u001a\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0001H\ufffd\ufffd\u001a\u0014\u0010\u0007\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0001H\ufffd\ufffd\u00a8\u0006\b"}, d2 = {"probeCoroutineCreated", "Lkotlin/coroutines/Continuation;", "T", "completion", "probeCoroutineResumed", "", AIInput.KEY_FRAME, "probeCoroutineSuspended", "integration-testing_debugAgentTest"})
/* renamed from: kotlin.coroutines.jvm.internal.DebugProbesKt, reason: use source file name */
/* loaded from: Android_9.1.70_64.apk:DebugProbesKt.bin */
public final class DebugProbes {
    @NotNull
    public static final <T> Continuation<T> probeCoroutineCreated(@NotNull Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return DebugProbesImpl.INSTANCE.probeCoroutineCreated$kotlinx_coroutines_core(completion);
    }

    public static final void probeCoroutineResumed(@NotNull Continuation<?> frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        DebugProbesImpl.INSTANCE.probeCoroutineResumed$kotlinx_coroutines_core(frame);
    }

    public static final void probeCoroutineSuspended(@NotNull Continuation<?> frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        DebugProbesImpl.INSTANCE.probeCoroutineSuspended$kotlinx_coroutines_core(frame);
    }
}
