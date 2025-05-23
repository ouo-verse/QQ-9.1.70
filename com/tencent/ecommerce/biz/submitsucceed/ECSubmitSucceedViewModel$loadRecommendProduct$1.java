package com.tencent.ecommerce.biz.submitsucceed;

import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.biz.detail.repo.shop.IECShopProductDetailRepository;
import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailRelatedInfo;
import java.util.ArrayList;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.submitsucceed.ECSubmitSucceedViewModel$loadRecommendProduct$1", f = "ECSubmitSucceedViewModel.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECSubmitSucceedViewModel$loadRecommendProduct$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $params;
    int label;
    final /* synthetic */ ECSubmitSucceedViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECSubmitSucceedViewModel$loadRecommendProduct$1(ECSubmitSucceedViewModel eCSubmitSucceedViewModel, JSONObject jSONObject, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCSubmitSucceedViewModel;
        this.$params = jSONObject;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECSubmitSucceedViewModel$loadRecommendProduct$1(this.this$0, this.$params, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECSubmitSucceedViewModel$loadRecommendProduct$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0053, code lost:
    
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList((java.util.Collection) r0);
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        List arrayList;
        MutableLiveData mutableLiveData2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            IECShopProductDetailRepository shopProductDetailRepository = com.tencent.ecommerce.biz.detail.repo.shop.a.f102322a.getShopProductDetailRepository();
            JSONObject jSONObject = this.$params;
            this.label = 1;
            obj = shopProductDetailRepository.getShopProductDetailRelatedData(jSONObject, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ECShopProductDetailRelatedInfo eCShopProductDetailRelatedInfo = (ECShopProductDetailRelatedInfo) obj;
        this.this$0.isLoadingData = false;
        if (eCShopProductDetailRelatedInfo != null) {
            mutableLiveData = this.this$0._productList;
            List list = (List) mutableLiveData.getValue();
            if (list == null || arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.addAll(ti0.a.f436377a.d(eCShopProductDetailRelatedInfo.infoData));
            mutableLiveData2 = this.this$0._productList;
            mutableLiveData2.setValue(arrayList);
            this.this$0.cookie = eCShopProductDetailRelatedInfo.infoData.optString("cookie");
            this.this$0.isEnd = eCShopProductDetailRelatedInfo.infoData.optBoolean("is_end");
            return Unit.INSTANCE;
        }
        cg0.a.a("ECSubmitSucceedViewModel", "requestRecommendProduct", "request recommend product error");
        return Unit.INSTANCE;
    }
}
