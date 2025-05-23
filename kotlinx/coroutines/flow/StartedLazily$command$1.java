package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/flow/SharingCommand;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedLazily$command$1", f = "SharingStarted.kt", i = {}, l = {210}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes28.dex */
final class StartedLazily$command$1 extends SuspendLambda implements Function2<FlowCollector<? super SharingCommand>, Continuation<? super Unit>, Object> {
    final /* synthetic */ StateFlow<Integer> $subscriptionCount;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartedLazily$command$1(StateFlow<Integer> stateFlow, Continuation<? super StartedLazily$command$1> continuation) {
        super(2, continuation);
        this.$subscriptionCount = stateFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        StartedLazily$command$1 startedLazily$command$1 = new StartedLazily$command$1(this.$subscriptionCount, continuation);
        startedLazily$command$1.L$0 = obj;
        return startedLazily$command$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            StateFlow<Integer> stateFlow = this.$subscriptionCount;
            StartedLazily$command$1$invokeSuspend$$inlined$collect$1 startedLazily$command$1$invokeSuspend$$inlined$collect$1 = new StartedLazily$command$1$invokeSuspend$$inlined$collect$1(booleanRef, flowCollector);
            this.label = 1;
            if (stateFlow.collect(startedLazily$command$1$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super SharingCommand> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((StartedLazily$command$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
