package kotlinx.coroutines.selects;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a8\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u001f\b\u0004\u0010\u0002\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2 = {"selectUnbiased", BdhLogUtil.LogTag.Tag_Req, "builder", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class SelectUnbiasedKt {
    @Nullable
    public static final <R> Object selectUnbiased(@NotNull Function1<? super SelectBuilder<? super R>, Unit> function1, @NotNull Continuation<? super R> continuation) {
        Object coroutine_suspended;
        UnbiasedSelectBuilderImpl unbiasedSelectBuilderImpl = new UnbiasedSelectBuilderImpl(continuation);
        try {
            function1.invoke(unbiasedSelectBuilderImpl);
        } catch (Throwable th5) {
            unbiasedSelectBuilderImpl.handleBuilderException(th5);
        }
        Object initSelectResult = unbiasedSelectBuilderImpl.initSelectResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (initSelectResult == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return initSelectResult;
    }

    private static final <R> Object selectUnbiased$$forInline(Function1<? super SelectBuilder<? super R>, Unit> function1, Continuation<? super R> continuation) {
        Object coroutine_suspended;
        InlineMarker.mark(0);
        UnbiasedSelectBuilderImpl unbiasedSelectBuilderImpl = new UnbiasedSelectBuilderImpl(continuation);
        try {
            function1.invoke(unbiasedSelectBuilderImpl);
        } catch (Throwable th5) {
            unbiasedSelectBuilderImpl.handleBuilderException(th5);
        }
        Object initSelectResult = unbiasedSelectBuilderImpl.initSelectResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (initSelectResult == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return initSelectResult;
    }
}
