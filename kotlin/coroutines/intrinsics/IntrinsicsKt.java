package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt", "kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsKt"}, k = 4, mv = {1, 7, 1}, xi = 49)
/* loaded from: classes28.dex */
public final class IntrinsicsKt extends IntrinsicsKt__IntrinsicsKt {
    IntrinsicsKt() {
    }

    @NotNull
    public static /* bridge */ /* synthetic */ Object getCOROUTINE_SUSPENDED() {
        return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static /* bridge */ /* synthetic */ Continuation intercepted(@NotNull Continuation continuation) {
        return IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static /* bridge */ /* synthetic */ Continuation createCoroutineUnintercepted(@NotNull Function2 function2, Object obj, @NotNull Continuation continuation) {
        return IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function2, obj, continuation);
    }
}
