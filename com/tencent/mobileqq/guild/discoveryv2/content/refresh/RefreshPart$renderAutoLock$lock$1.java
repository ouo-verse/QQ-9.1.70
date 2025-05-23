package com.tencent.mobileqq.guild.discoveryv2.content.refresh;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.content.refresh.RefreshPart$renderAutoLock$lock$1", f = "RefreshPart.kt", i = {}, l = {266}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class RefreshPart$renderAutoLock$lock$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $lockImpl;
    final /* synthetic */ Ref.BooleanRef $locked;
    final /* synthetic */ long $timeoutMilliSeconds;
    final /* synthetic */ Ref.ObjectRef<Job> $timeoutUnlockJob;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RefreshPart$renderAutoLock$lock$1(long j3, Ref.BooleanRef booleanRef, Ref.ObjectRef<Job> objectRef, Function1<? super Boolean, Unit> function1, Continuation<? super RefreshPart$renderAutoLock$lock$1> continuation) {
        super(2, continuation);
        this.$timeoutMilliSeconds = j3;
        this.$locked = booleanRef;
        this.$timeoutUnlockJob = objectRef;
        this.$lockImpl = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RefreshPart$renderAutoLock$lock$1(this.$timeoutMilliSeconds, this.$locked, this.$timeoutUnlockJob, this.$lockImpl, continuation);
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
            long j3 = this.$timeoutMilliSeconds;
            this.label = 1;
            if (DelayKt.delay(j3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        RefreshPart.R9(this.$locked, this.$timeoutUnlockJob, this.$lockImpl, "timeout");
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RefreshPart$renderAutoLock$lock$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
