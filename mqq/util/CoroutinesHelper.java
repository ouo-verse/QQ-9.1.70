package mqq.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J\u001f\u0010\u0007\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"Lmqq/util/CoroutinesHelper;", "", "()V", "asyncCall", "", "block", "Lkotlin/Function0;", "suspendCall", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mqq_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class CoroutinesHelper {

    @NotNull
    public static final CoroutinesHelper INSTANCE = new CoroutinesHelper();

    CoroutinesHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object suspendCall(Function0<Unit> function0, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new CoroutinesHelper$suspendCall$2(function0, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (withContext == coroutine_suspended) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final void asyncCall(@NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        BuildersKt__BuildersKt.runBlocking$default(null, new CoroutinesHelper$asyncCall$1(block, null), 1, null);
    }
}
