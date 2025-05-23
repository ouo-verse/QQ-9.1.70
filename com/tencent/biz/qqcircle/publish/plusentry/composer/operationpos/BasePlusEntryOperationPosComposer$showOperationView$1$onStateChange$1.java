package com.tencent.biz.qqcircle.publish.plusentry.composer.operationpos;

import com.tencent.biz.qqcircle.immersive.utils.ao;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.biz.qqcircle.publish.plusentry.composer.operationpos.BasePlusEntryOperationPosComposer$showOperationView$1$onStateChange$1", f = "BasePlusEntryOperationPosComposer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class BasePlusEntryOperationPosComposer$showOperationView$1$onStateChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BasePlusEntryOperationPosComposer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasePlusEntryOperationPosComposer$showOperationView$1$onStateChange$1(BasePlusEntryOperationPosComposer basePlusEntryOperationPosComposer, Continuation<? super BasePlusEntryOperationPosComposer$showOperationView$1$onStateChange$1> continuation) {
        super(2, continuation);
        this.this$0 = basePlusEntryOperationPosComposer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new BasePlusEntryOperationPosComposer$showOperationView$1$onStateChange$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ao.b(this.this$0.getNormalView(), this.this$0.getIvOperation(), null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((BasePlusEntryOperationPosComposer$showOperationView$1$onStateChange$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
