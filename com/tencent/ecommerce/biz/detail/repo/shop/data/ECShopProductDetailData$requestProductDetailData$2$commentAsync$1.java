package com.tencent.ecommerce.biz.detail.repo.shop.data;

import com.tencent.ecommerce.biz.detail.repo.shop.IECShopProductDetailRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/a;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailData$requestProductDetailData$2$commentAsync$1", f = "ECShopProductDetailData.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
final class ECShopProductDetailData$requestProductDetailData$2$commentAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ECShopProductCommentInfo>, Object> {
    int label;
    final /* synthetic */ ECShopProductDetailData$requestProductDetailData$2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopProductDetailData$requestProductDetailData$2$commentAsync$1(ECShopProductDetailData$requestProductDetailData$2 eCShopProductDetailData$requestProductDetailData$2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCShopProductDetailData$requestProductDetailData$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShopProductDetailData$requestProductDetailData$2$commentAsync$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ECShopProductCommentInfo> continuation) {
        return ((ECShopProductDetailData$requestProductDetailData$2$commentAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        IECShopProductDetailRepository iECShopProductDetailRepository;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            iECShopProductDetailRepository = this.this$0.this$0.repository;
            String optString = this.this$0.$requestParams.optString("spu_id");
            this.label = 1;
            obj = iECShopProductDetailRepository.getShopProductCommentData(optString, 5, "", this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
