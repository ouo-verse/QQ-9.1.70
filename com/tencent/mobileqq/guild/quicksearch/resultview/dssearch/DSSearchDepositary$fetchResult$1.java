package com.tencent.mobileqq.guild.quicksearch.resultview.dssearch;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "psKey", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.DSSearchDepositary$fetchResult$1", f = "DSSearchDepositary.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class DSSearchDepositary$fetchResult$1 extends SuspendLambda implements Function2<String, Continuation<? super Flow<? extends q>>, Object> {
    final /* synthetic */ String $searchKey;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DSSearchDepositary this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DSSearchDepositary$fetchResult$1(DSSearchDepositary dSSearchDepositary, String str, Continuation<? super DSSearchDepositary$fetchResult$1> continuation) {
        super(2, continuation);
        this.this$0 = dSSearchDepositary;
        this.$searchKey = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DSSearchDepositary$fetchResult$1 dSSearchDepositary$fetchResult$1 = new DSSearchDepositary$fetchResult$1(this.this$0, this.$searchKey, continuation);
        dSSearchDepositary$fetchResult$1.L$0 = obj;
        return dSSearchDepositary$fetchResult$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Flow q16;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            q16 = this.this$0.q(this.$searchKey, (String) this.L$0);
            return q16;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull String str, @Nullable Continuation<? super Flow<? extends q>> continuation) {
        return ((DSSearchDepositary$fetchResult$1) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
