package com.tencent.ecommerce.biz.detail.repo.shop;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.network.api.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/ecommerce/base/network/api/d;", "Lorg/json/JSONObject;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.repo.shop.ECShopProductDetailRepository$getBrandQuaLinks$response$1", f = "ECShopProductDetailRepository.kt", i = {}, l = {356}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECShopProductDetailRepository$getBrandQuaLinks$response$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ECNetworkResponse<JSONObject>>, Object> {
    final /* synthetic */ Ref.ObjectRef $reqParams;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopProductDetailRepository$getBrandQuaLinks$response$1(Ref.ObjectRef objectRef, Continuation continuation) {
        super(2, continuation);
        this.$reqParams = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShopProductDetailRepository$getBrandQuaLinks$response$1(this.$reqParams, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ECNetworkResponse<JSONObject>> continuation) {
        return ((ECShopProductDetailRepository$getBrandQuaLinks$response$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            b bVar = b.f100803a;
            JSONObject jSONObject = (JSONObject) this.$reqParams.element;
            this.label = 1;
            obj = com.tencent.ecommerce.base.network.service.a.e("trpc.ecom.qqshop_brand_info_read.BrandInfoRead", "/trpc.ecom.qqshop_brand_info_read.BrandInfoRead/GetBrandQuaLinks", bVar, jSONObject, this);
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
