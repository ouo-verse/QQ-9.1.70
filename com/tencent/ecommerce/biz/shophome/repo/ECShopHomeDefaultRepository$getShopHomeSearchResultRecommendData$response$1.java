package com.tencent.ecommerce.biz.shophome.repo;

import bj0.ECShopHomeSearchResultRecommendRequest;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.network.api.IECNetworkJsonContracts;
import com.tencent.ecommerce.base.network.api.c;
import com.tencent.ecommerce.biz.recommend.models.ECShopRecommendScene;
import java.util.List;
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
@DebugMetadata(c = "com.tencent.ecommerce.biz.shophome.repo.ECShopHomeDefaultRepository$getShopHomeSearchResultRecommendData$response$1", f = "ECShopHomeDefaultRepository.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECShopHomeDefaultRepository$getShopHomeSearchResultRecommendData$response$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ECNetworkResponse<JSONObject>>, Object> {
    final /* synthetic */ ECShopHomeSearchResultRecommendRequest $searchResultRecommendRequest;
    int label;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/shophome/repo/ECShopHomeDefaultRepository$getShopHomeSearchResultRecommendData$response$1$a", "Lcom/tencent/ecommerce/base/network/api/IECNetworkJsonContracts;", "Lbj0/d;", "Lorg/json/JSONObject;", "params", "b", "", "rsp", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements IECNetworkJsonContracts<ECShopHomeSearchResultRecommendRequest, JSONObject> {
        a() {
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkJsonContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public JSONObject decodeResponse(byte[] rsp) {
            return c.c(rsp);
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkJsonContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public JSONObject encodeRequestParams(ECShopHomeSearchResultRecommendRequest params) {
            ECShopRecommendScene eCShopRecommendScene;
            JSONObject b16;
            ti0.a aVar = ti0.a.f436377a;
            List<String> b17 = params.b();
            ECShopRecommendScene[] values = ECShopRecommendScene.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    eCShopRecommendScene = null;
                    break;
                }
                eCShopRecommendScene = values[i3];
                if (eCShopRecommendScene.value == params.searchScene) {
                    break;
                }
                i3++;
            }
            b16 = aVar.b((r13 & 1) != 0 ? "" : null, b17, eCShopRecommendScene != null ? eCShopRecommendScene : ECShopRecommendScene.UNKNOWN_TYPE, (r13 & 8) != 0 ? "" : params.searchQuery, params.cookie);
            b16.put("shop_id", params.shopId);
            b16.put("is_select", params.isSelect);
            b16.put("is_distributor", params.isDistributor);
            b16.put("source", params.getSource());
            cg0.a.b("ECShopHomeDefaultRepository", "[getShopHomeSearchResultRecommendData] reqParams = " + b16);
            return b16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopHomeDefaultRepository$getShopHomeSearchResultRecommendData$response$1(ECShopHomeSearchResultRecommendRequest eCShopHomeSearchResultRecommendRequest, Continuation continuation) {
        super(2, continuation);
        this.$searchResultRecommendRequest = eCShopHomeSearchResultRecommendRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShopHomeDefaultRepository$getShopHomeSearchResultRecommendData$response$1(this.$searchResultRecommendRequest, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ECNetworkResponse<JSONObject>> continuation) {
        return ((ECShopHomeDefaultRepository$getShopHomeSearchResultRecommendData$response$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            a aVar = new a();
            ECShopHomeSearchResultRecommendRequest eCShopHomeSearchResultRecommendRequest = this.$searchResultRecommendRequest;
            this.label = 1;
            obj = com.tencent.ecommerce.base.network.service.a.e("trpc.ecom.qshop_similar_recom_svr.QshopSimilarRecomSvr", "/trpc.ecom.qshop_similar_recom_svr.QshopSimilarRecomSvr/SimilarProductRecom", aVar, eCShopHomeSearchResultRecommendRequest, this);
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
