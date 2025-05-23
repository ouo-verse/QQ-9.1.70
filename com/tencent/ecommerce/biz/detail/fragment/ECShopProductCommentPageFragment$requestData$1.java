package com.tencent.ecommerce.biz.detail.fragment;

import com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopProductCommentViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.fragment.ECShopProductCommentPageFragment$requestData$1", f = "ECShopProductCommentPageFragment.kt", i = {}, l = {138}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECShopProductCommentPageFragment$requestData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isFetchBackground;
    final /* synthetic */ boolean $isRefreshFetch;
    int label;
    final /* synthetic */ ECShopProductCommentPageFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopProductCommentPageFragment$requestData$1(ECShopProductCommentPageFragment eCShopProductCommentPageFragment, boolean z16, boolean z17, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCShopProductCommentPageFragment;
        this.$isRefreshFetch = z16;
        this.$isFetchBackground = z17;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShopProductCommentPageFragment$requestData$1(this.this$0, this.$isRefreshFetch, this.$isFetchBackground, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECShopProductCommentPageFragment$requestData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        int i3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 == 0) {
            ResultKt.throwOnFailure(obj);
            ECShopProductCommentViewModel Rh = this.this$0.Rh();
            i3 = this.this$0.currentSortType;
            boolean z16 = this.$isRefreshFetch;
            boolean z17 = this.$isFetchBackground;
            this.label = 1;
            if (Rh.W1(i3, z16, z17, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i16 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
