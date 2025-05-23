package com.tencent.mobileqq.wink.editor.aielimination;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.aielimination.WinkAIEliminationFragment$refreshEliminateTimes$1", f = "WinkAIEliminationFragment.kt", i = {}, l = {500, 502}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkAIEliminationFragment$refreshEliminateTimes$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WinkAIEliminationFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAIEliminationFragment$refreshEliminateTimes$1(WinkAIEliminationFragment winkAIEliminationFragment, Continuation<? super WinkAIEliminationFragment$refreshEliminateTimes$1> continuation) {
        super(2, continuation);
        this.this$0 = winkAIEliminationFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkAIEliminationFragment$refreshEliminateTimes$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableStateFlow mutableStateFlow;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
        } catch (Exception unused) {
            w53.b.c("WinkAIEliminationFragment", "refreshEliminateTimes getStatusReply fail");
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            AIEliminateDataSource aIEliminateDataSource = AIEliminateDataSource.f318757a;
            String b26 = this.this$0.hi().b2();
            this.label = 1;
            obj = aIEliminateDataSource.b(b26, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        com.tencent.mobileqq.wink.editor.aielimination.model.c cVar = (com.tencent.mobileqq.wink.editor.aielimination.model.c) obj;
        this.this$0.hi().b3(cVar);
        mutableStateFlow = this.this$0._countInfo;
        this.label = 2;
        if (mutableStateFlow.emit(cVar, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkAIEliminationFragment$refreshEliminateTimes$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
