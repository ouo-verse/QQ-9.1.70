package com.tencent.ecommerce.biz.detail.viewmodel.shop;

import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.base.share.api.ECActionItemData;
import com.tencent.ecommerce.biz.detail.repo.shop.IECShopProductDetailRepository;
import com.tencent.ecommerce.biz.shophome.repo.ECShareActionInfo;
import com.tencent.ecommerce.biz.shophome.repo.ECShareInfo;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopProductDetailCustomViewModel$getProductShareInfo$1", f = "ECShopProductDetailCustomViewModel.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECShopProductDetailCustomViewModel$getProductShareInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ECActionItemData $data;
    final /* synthetic */ int $shareAction;
    final /* synthetic */ String $spuId;
    int label;
    final /* synthetic */ ECShopProductDetailCustomViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopProductDetailCustomViewModel$getProductShareInfo$1(ECShopProductDetailCustomViewModel eCShopProductDetailCustomViewModel, String str, int i3, ECActionItemData eCActionItemData, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCShopProductDetailCustomViewModel;
        this.$spuId = str;
        this.$shareAction = i3;
        this.$data = eCActionItemData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShopProductDetailCustomViewModel$getProductShareInfo$1(this.this$0, this.$spuId, this.$shareAction, this.$data, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECShopProductDetailCustomViewModel$getProductShareInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        Integer boxInt;
        String label;
        String uin;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            IECShopProductDetailRepository shopProductDetailRepository = com.tencent.ecommerce.biz.detail.repo.shop.a.f102322a.getShopProductDetailRepository();
            String str = this.$spuId;
            int i16 = this.$shareAction;
            this.label = 1;
            obj = shopProductDetailRepository.getShopProductShareInfo(str, i16, "com.tencent.eccommerce", "eccommerce", "0.0.0.11", this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ECShareInfo eCShareInfo = (ECShareInfo) obj;
        mutableLiveData = this.this$0.shareActionInfo;
        int i17 = this.$shareAction;
        ECActionItemData eCActionItemData = this.$data;
        String str2 = (eCActionItemData == null || (uin = eCActionItemData.getUin()) == null) ? "" : uin;
        ECActionItemData eCActionItemData2 = this.$data;
        String str3 = (eCActionItemData2 == null || (label = eCActionItemData2.getLabel()) == null) ? "" : label;
        ECActionItemData eCActionItemData3 = this.$data;
        mutableLiveData.postValue(new ECShareActionInfo(i17, eCShareInfo, str2, str3, (eCActionItemData3 == null || (boxInt = Boxing.boxInt(eCActionItemData3.getUinType())) == null) ? -1 : boxInt.intValue()));
        return Unit.INSTANCE;
    }
}
