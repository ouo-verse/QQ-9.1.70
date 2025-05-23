package com.tencent.ecommerce.biz.shophome.repo;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/ecommerce/base/network/api/d;", "Lorg/json/JSONObject;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.shophome.repo.ECShopHomeDefaultRepository$getShopHomeQualificationData$response$1", f = "ECShopHomeDefaultRepository.kt", i = {}, l = {132}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECShopHomeDefaultRepository$getShopHomeQualificationData$response$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ECNetworkResponse<JSONObject>>, Object> {
    final /* synthetic */ String $shopId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopHomeDefaultRepository$getShopHomeQualificationData$response$1(String str, Continuation continuation) {
        super(2, continuation);
        this.$shopId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShopHomeDefaultRepository$getShopHomeQualificationData$response$1(this.$shopId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ECNetworkResponse<JSONObject>> continuation) {
        return ((ECShopHomeDefaultRepository$getShopHomeQualificationData$response$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.$shopId);
            cg0.a.b("ECShopHomeDefaultRepository", "[getShopHomeQualificationData] reqParams = " + jSONObject);
            com.tencent.ecommerce.base.network.api.b bVar = com.tencent.ecommerce.base.network.api.b.f100803a;
            this.label = 1;
            obj = com.tencent.ecommerce.base.network.service.a.e("trpc.ecom.qq_shop_homepage_svr.QQStoreHomePage", "/trpc.ecom.qq_shop_homepage_svr.QQStoreHomePage/GetShopQualification", bVar, jSONObject, this);
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
