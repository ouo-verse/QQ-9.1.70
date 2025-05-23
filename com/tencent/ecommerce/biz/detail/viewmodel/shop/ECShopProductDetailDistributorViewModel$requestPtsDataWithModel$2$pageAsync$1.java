package com.tencent.ecommerce.biz.detail.viewmodel.shop;

import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopProductDetailDistributorViewModel$requestPtsDataWithModel$2$pageAsync$1", f = "ECShopProductDetailDistributorViewModel.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
final class ECShopProductDetailDistributorViewModel$requestPtsDataWithModel$2$pageAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super JSONObject>, Object> {
    int label;
    final /* synthetic */ ECShopProductDetailDistributorViewModel$requestPtsDataWithModel$2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopProductDetailDistributorViewModel$requestPtsDataWithModel$2$pageAsync$1(ECShopProductDetailDistributorViewModel$requestPtsDataWithModel$2 eCShopProductDetailDistributorViewModel$requestPtsDataWithModel$2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCShopProductDetailDistributorViewModel$requestPtsDataWithModel$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShopProductDetailDistributorViewModel$requestPtsDataWithModel$2$pageAsync$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super JSONObject> continuation) {
        return ((ECShopProductDetailDistributorViewModel$requestPtsDataWithModel$2$pageAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ECShopProductDetailData j26 = this.this$0.this$0.j2();
            ECShopProductDetailDistributorViewModel$requestPtsDataWithModel$2 eCShopProductDetailDistributorViewModel$requestPtsDataWithModel$2 = this.this$0;
            String str = eCShopProductDetailDistributorViewModel$requestPtsDataWithModel$2.$service;
            String str2 = eCShopProductDetailDistributorViewModel$requestPtsDataWithModel$2.$method;
            JSONObject jSONObject = eCShopProductDetailDistributorViewModel$requestPtsDataWithModel$2.$requestParams;
            this.label = 1;
            obj = j26.h(str, str2, jSONObject, this);
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
