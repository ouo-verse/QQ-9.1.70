package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlin/sequences/SequenceScope;", "Ljava/lang/StackTraceElement;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$creationStackTrace$1", f = "DebugCoroutineInfoImpl.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes28.dex */
public final class DebugCoroutineInfoImpl$creationStackTrace$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super StackTraceElement>, Continuation<? super Unit>, Object> {
    final /* synthetic */ StackTraceFrame $bottom;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DebugCoroutineInfo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugCoroutineInfoImpl$creationStackTrace$1(DebugCoroutineInfo debugCoroutineInfo, StackTraceFrame stackTraceFrame, Continuation<? super DebugCoroutineInfoImpl$creationStackTrace$1> continuation) {
        super(2, continuation);
        this.this$0 = debugCoroutineInfo;
        this.$bottom = stackTraceFrame;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DebugCoroutineInfoImpl$creationStackTrace$1 debugCoroutineInfoImpl$creationStackTrace$1 = new DebugCoroutineInfoImpl$creationStackTrace$1(this.this$0, this.$bottom, continuation);
        debugCoroutineInfoImpl$creationStackTrace$1.L$0 = obj;
        return debugCoroutineInfoImpl$creationStackTrace$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object yieldFrames;
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
            SequenceScope sequenceScope = (SequenceScope) this.L$0;
            DebugCoroutineInfo debugCoroutineInfo = this.this$0;
            CoroutineStackFrame callerFrame = this.$bottom.getCallerFrame();
            this.label = 1;
            yieldFrames = debugCoroutineInfo.yieldFrames(sequenceScope, callerFrame, this);
            if (yieldFrames == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull SequenceScope<? super StackTraceElement> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DebugCoroutineInfoImpl$creationStackTrace$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
