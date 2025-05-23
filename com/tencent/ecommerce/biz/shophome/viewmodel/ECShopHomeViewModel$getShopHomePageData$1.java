package com.tencent.ecommerce.biz.shophome.viewmodel;

import androidx.lifecycle.MutableLiveData;
import bj0.ECShopHomeRequest;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.biz.shophome.repo.ECShopHomeDefaultRepository;
import com.tencent.ecommerce.biz.shophome.repo.IECShopHomeRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.shophome.viewmodel.ECShopHomeViewModel$getShopHomePageData$1", f = "ECShopHomeViewModel.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECShopHomeViewModel$getShopHomePageData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isFirstScreen;
    final /* synthetic */ ECShopHomeRequest $shopHomeRequest;
    int label;
    final /* synthetic */ ECShopHomeViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopHomeViewModel$getShopHomePageData$1(ECShopHomeViewModel eCShopHomeViewModel, ECShopHomeRequest eCShopHomeRequest, boolean z16, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCShopHomeViewModel;
        this.$shopHomeRequest = eCShopHomeRequest;
        this.$isFirstScreen = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShopHomeViewModel$getShopHomePageData$1(this.this$0, this.$shopHomeRequest, this.$isFirstScreen, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECShopHomeViewModel$getShopHomePageData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        JSONObject jSONObject;
        MutableLiveData mutableLiveData2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            cg0.a.b("ECShopHomeViewModel", "[getShopHomePageData] shopHomeRequest=" + this.$shopHomeRequest);
            ECShopHomeDefaultRepository repo = this.this$0.getRepo();
            ECShopHomeRequest eCShopHomeRequest = this.$shopHomeRequest;
            this.label = 1;
            obj = IECShopHomeRepository.a.b(repo, eCShopHomeRequest, null, this, 2, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ECNetworkResponse eCNetworkResponse = (ECNetworkResponse) obj;
        JSONObject jSONObject2 = (JSONObject) eCNetworkResponse.b();
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        this.this$0.N1(false, jSONObject2);
        this.this$0.k2(jSONObject2);
        mutableLiveData = this.this$0._shopInfo;
        mutableLiveData.setValue(jSONObject2.toString());
        this.this$0.t2(jSONObject2);
        this.this$0.m2(jSONObject2);
        JSONArray optJSONArray = jSONObject2.optJSONArray("order_bys");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        this.this$0.o2(optJSONArray);
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("cards");
        if (optJSONArray2 == null) {
            optJSONArray2 = new JSONArray();
        }
        this.this$0.p2(optJSONArray2, false);
        ECShopHomeViewModel eCShopHomeViewModel = this.this$0;
        JSONArray optJSONArray3 = jSONObject2.optJSONArray("categories");
        if (optJSONArray3 == null) {
            optJSONArray3 = new JSONArray();
        }
        eCShopHomeViewModel.P2(optJSONArray3);
        JSONObject optJSONObject = jSONObject2.optJSONObject("shop_info");
        if (optJSONObject == null || (jSONObject = optJSONObject.optJSONObject("default_info")) == null) {
            jSONObject = new JSONObject();
        }
        this.this$0.v2(jSONObject);
        mutableLiveData2 = this.this$0._showShareBtn;
        mutableLiveData2.setValue(Boxing.boxBoolean(!jSONObject2.optBoolean("hide_share")));
        if (this.$isFirstScreen) {
            this.this$0.N2(eCNetworkResponse.getCode() == 0, this.$shopHomeRequest.isSelect);
        }
        return Unit.INSTANCE;
    }
}
