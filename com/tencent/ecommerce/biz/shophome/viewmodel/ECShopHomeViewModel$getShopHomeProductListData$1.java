package com.tencent.ecommerce.biz.shophome.viewmodel;

import bj0.ECShopHomeProductRequest;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.biz.shophome.repo.ECShopHomeDefaultRepository;
import com.tencent.ecommerce.biz.shophome.repo.IECShopHomeRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.shophome.viewmodel.ECShopHomeViewModel$getShopHomeProductListData$1", f = "ECShopHomeViewModel.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
final class ECShopHomeViewModel$getShopHomeProductListData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ECShopHomeProductRequest $shopHomeProductRequest;
    int label;
    final /* synthetic */ ECShopHomeViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopHomeViewModel$getShopHomeProductListData$1(ECShopHomeViewModel eCShopHomeViewModel, ECShopHomeProductRequest eCShopHomeProductRequest, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCShopHomeViewModel;
        this.$shopHomeProductRequest = eCShopHomeProductRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShopHomeViewModel$getShopHomeProductListData$1(this.this$0, this.$shopHomeProductRequest, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECShopHomeViewModel$getShopHomeProductListData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            cg0.a.b("ECShopHomeViewModel", "[getShopHomeProductListData] shopId = " + this.$shopHomeProductRequest.shopId + ", cookie = " + this.$shopHomeProductRequest.cookie + ", loadMore = " + this.$shopHomeProductRequest.loadMore + ", orderByInfo = " + this.$shopHomeProductRequest.orderByInfo);
            ECShopHomeDefaultRepository repo = this.this$0.getRepo();
            ECShopHomeProductRequest eCShopHomeProductRequest = this.$shopHomeProductRequest;
            this.label = 1;
            obj = IECShopHomeRepository.a.c(repo, eCShopHomeProductRequest, null, this, 2, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        JSONObject jSONObject = (JSONObject) ((ECNetworkResponse) obj).b();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        this.this$0.N1(this.$shopHomeProductRequest.loadMore, jSONObject);
        if (jSONObject.length() > 0) {
            this.this$0.k2(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("cards");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            this.this$0.p2(optJSONArray, this.$shopHomeProductRequest.loadMore);
        }
        return Unit.INSTANCE;
    }
}
