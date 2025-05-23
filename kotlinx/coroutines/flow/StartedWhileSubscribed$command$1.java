package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/flow/SharingCommand;", "", "count", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", i = {1, 2, 3}, l = {179, 181, 183, 184, 186}, m = "invokeSuspend", n = {"$this$transformLatest", "$this$transformLatest", "$this$transformLatest"}, s = {"L$0", "L$0", "L$0"})
/* loaded from: classes28.dex */
final class StartedWhileSubscribed$command$1 extends SuspendLambda implements Function3<FlowCollector<? super SharingCommand>, Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StartedWhileSubscribed this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartedWhileSubscribed$command$1(StartedWhileSubscribed startedWhileSubscribed, Continuation<? super StartedWhileSubscribed$command$1> continuation) {
        super(3, continuation);
        this.this$0 = startedWhileSubscribed;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super SharingCommand> flowCollector, Integer num, Continuation<? super Unit> continuation) {
        return invoke(flowCollector, num.intValue(), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x009c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        FlowCollector flowCollector;
        long j3;
        long j16;
        long j17;
        SharingCommand sharingCommand;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            flowCollector = (FlowCollector) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            sharingCommand = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
                            this.L$0 = null;
                            this.label = 5;
                            if (flowCollector.emit(sharingCommand, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                    } else {
                        flowCollector = (FlowCollector) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        j17 = this.this$0.replayExpiration;
                        this.L$0 = flowCollector;
                        this.label = 4;
                        if (DelayKt.delay(j17, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sharingCommand = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
                        this.L$0 = null;
                        this.label = 5;
                        if (flowCollector.emit(sharingCommand, this) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    }
                } else {
                    flowCollector = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    j16 = this.this$0.replayExpiration;
                    if (j16 > 0) {
                        SharingCommand sharingCommand2 = SharingCommand.STOP;
                        this.L$0 = flowCollector;
                        this.label = 3;
                        if (flowCollector.emit(sharingCommand2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        j17 = this.this$0.replayExpiration;
                        this.L$0 = flowCollector;
                        this.label = 4;
                        if (DelayKt.delay(j17, this) == coroutine_suspended) {
                        }
                    }
                    sharingCommand = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
                    this.L$0 = null;
                    this.label = 5;
                    if (flowCollector.emit(sharingCommand, this) == coroutine_suspended) {
                    }
                    return Unit.INSTANCE;
                }
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        flowCollector = (FlowCollector) this.L$0;
        if (this.I$0 <= 0) {
            j3 = this.this$0.stopTimeout;
            this.L$0 = flowCollector;
            this.label = 2;
            if (DelayKt.delay(j3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            j16 = this.this$0.replayExpiration;
            if (j16 > 0) {
            }
            sharingCommand = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
            this.L$0 = null;
            this.label = 5;
            if (flowCollector.emit(sharingCommand, this) == coroutine_suspended) {
            }
            return Unit.INSTANCE;
        }
        SharingCommand sharingCommand3 = SharingCommand.START;
        this.label = 1;
        if (flowCollector.emit(sharingCommand3, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super SharingCommand> flowCollector, int i3, @Nullable Continuation<? super Unit> continuation) {
        StartedWhileSubscribed$command$1 startedWhileSubscribed$command$1 = new StartedWhileSubscribed$command$1(this.this$0, continuation);
        startedWhileSubscribed$command$1.L$0 = flowCollector;
        startedWhileSubscribed$command$1.I$0 = i3;
        return startedWhileSubscribed$command$1.invokeSuspend(Unit.INSTANCE);
    }
}
