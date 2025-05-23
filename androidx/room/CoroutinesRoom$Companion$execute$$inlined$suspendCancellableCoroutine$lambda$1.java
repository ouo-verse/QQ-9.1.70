package androidx.room;

import android.os.CancellationSignal;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", BdhLogUtil.LogTag.Tag_Req, "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "androidx/room/CoroutinesRoom$Companion$execute$4$job$1"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$execute$4$job$1", f = "CoroutinesRoom.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class CoroutinesRoom$Companion$execute$$inlined$suspendCancellableCoroutine$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Callable $callable$inlined;
    final /* synthetic */ CancellationSignal $cancellationSignal$inlined;
    final /* synthetic */ ContinuationInterceptor $context$inlined;
    final /* synthetic */ CancellableContinuation $continuation;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutinesRoom$Companion$execute$$inlined$suspendCancellableCoroutine$lambda$1(CancellableContinuation cancellableContinuation, Continuation continuation, ContinuationInterceptor continuationInterceptor, Callable callable, CancellationSignal cancellationSignal) {
        super(2, continuation);
        this.$continuation = cancellableContinuation;
        this.$context$inlined = continuationInterceptor;
        this.$callable$inlined = callable;
        this.$cancellationSignal$inlined = cancellationSignal;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new CoroutinesRoom$Companion$execute$$inlined$suspendCancellableCoroutine$lambda$1(this.$continuation, completion, this.$context$inlined, this.$callable$inlined, this.$cancellationSignal$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoroutinesRoom$Companion$execute$$inlined$suspendCancellableCoroutine$lambda$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                this.$continuation.resumeWith(Result.m476constructorimpl(this.$callable$inlined.call()));
            } catch (Throwable th5) {
                CancellableContinuation cancellableContinuation = this.$continuation;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(th5)));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
