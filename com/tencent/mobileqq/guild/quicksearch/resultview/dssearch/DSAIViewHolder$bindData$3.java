package com.tencent.mobileqq.guild.quicksearch.resultview.dssearch;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/p;", "data", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.DSAIViewHolder$bindData$3", f = "DSAIViewHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class DSAIViewHolder$bindData$3 extends SuspendLambda implements Function2<DSSearchData, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DSAIViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DSAIViewHolder$bindData$3(DSAIViewHolder dSAIViewHolder, Continuation<? super DSAIViewHolder$bindData$3> continuation) {
        super(2, continuation);
        this.this$0 = dSAIViewHolder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DSAIViewHolder$bindData$3 dSAIViewHolder$bindData$3 = new DSAIViewHolder$bindData$3(this.this$0, continuation);
        dSAIViewHolder$bindData$3.L$0 = obj;
        return dSAIViewHolder$bindData$3;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull DSSearchData dSSearchData, @Nullable Continuation<? super Unit> continuation) {
        return ((DSAIViewHolder$bindData$3) create(dSSearchData, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DSSearchData dSSearchData = (DSSearchData) this.L$0;
            this.this$0.dsViewData = dSSearchData;
            this.this$0.M(dSSearchData);
            this.this$0.L(dSSearchData.h());
            this.this$0.I(dSSearchData.a());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
