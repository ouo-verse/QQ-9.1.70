package com.tencent.ecommerce.biz.shophome.viewmodel;

import bj0.ECShopHomeSearchResultRecommendRequest;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.shophome.viewmodel.ECShopHomeSearchResultViewModel$getShopHomeSearchProductRecommendListData$1", f = "ECShopHomeSearchResultViewModel.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECShopHomeSearchResultViewModel$getShopHomeSearchProductRecommendListData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isFirstScreen;
    final /* synthetic */ ECShopHomeSearchResultRecommendRequest $searchResultRecommendRequest;
    int label;
    final /* synthetic */ ECShopHomeSearchResultViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopHomeSearchResultViewModel$getShopHomeSearchProductRecommendListData$1(ECShopHomeSearchResultViewModel eCShopHomeSearchResultViewModel, ECShopHomeSearchResultRecommendRequest eCShopHomeSearchResultRecommendRequest, boolean z16, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCShopHomeSearchResultViewModel;
        this.$searchResultRecommendRequest = eCShopHomeSearchResultRecommendRequest;
        this.$isFirstScreen = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShopHomeSearchResultViewModel$getShopHomeSearchProductRecommendListData$1(this.this$0, this.$searchResultRecommendRequest, this.$isFirstScreen, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECShopHomeSearchResultViewModel$getShopHomeSearchProductRecommendListData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            cg0.a.b("ECShopHomeSearchResultViewModel", "[getShopHomeSearchProductRecommendListData] shopId = " + this.$searchResultRecommendRequest.shopId + ", spuIds = " + this.$searchResultRecommendRequest.b() + ", searchScene = " + this.$searchResultRecommendRequest.searchScene + ", searchFullTxt = " + this.$searchResultRecommendRequest.searchQuery + ", cookie = " + this.$searchResultRecommendRequest.cookie);
            ECShopHomeDefaultRepository repo = this.this$0.getRepo();
            ECShopHomeSearchResultRecommendRequest eCShopHomeSearchResultRecommendRequest = this.$searchResultRecommendRequest;
            this.label = 1;
            obj = IECShopHomeRepository.a.e(repo, eCShopHomeSearchResultRecommendRequest, null, this, 2, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ECNetworkResponse eCNetworkResponse = (ECNetworkResponse) obj;
        JSONObject jSONObject = (JSONObject) eCNetworkResponse.b();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (this.$isFirstScreen) {
            this.this$0.I2(eCNetworkResponse.getCode() == 0, this.$searchResultRecommendRequest.isSelect);
        }
        this.this$0.A2(this.$searchResultRecommendRequest.loadMore, jSONObject);
        this.this$0.r2(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("recom_card");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        this.this$0.q2(optJSONArray, this.$searchResultRecommendRequest.loadMore);
        return Unit.INSTANCE;
    }
}
