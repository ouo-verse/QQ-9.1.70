package com.tencent.ecommerce.biz.detail.viewmodel.shop;

import com.tencent.ecommerce.biz.retain.repo.ECRetainInfoModel;
import com.tencent.ecommerce.biz.retain.repo.ECRetainRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopProductDetailCustomViewModel$refreshPageRetainInfo$1", f = "ECShopProductDetailCustomViewModel.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
final class ECShopProductDetailCustomViewModel$refreshPageRetainInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $spuId;
    int label;
    final /* synthetic */ ECShopProductDetailCustomViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopProductDetailCustomViewModel$refreshPageRetainInfo$1(ECShopProductDetailCustomViewModel eCShopProductDetailCustomViewModel, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCShopProductDetailCustomViewModel;
        this.$spuId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShopProductDetailCustomViewModel$refreshPageRetainInfo$1(this.this$0, this.$spuId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECShopProductDetailCustomViewModel$refreshPageRetainInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String str;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ECRetainRepository eCRetainRepository = ECRetainRepository.f104121b;
            String str2 = this.$spuId;
            this.label = 1;
            obj = eCRetainRepository.asyncGetRetainInfo(str2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ECRetainInfoModel eCRetainInfoModel = (ECRetainInfoModel) obj;
        ECShopProductDetailCustomViewModel eCShopProductDetailCustomViewModel = this.this$0;
        if (eCRetainInfoModel == null || (str = eCRetainInfoModel.retainId) == null) {
            str = "";
        }
        eCShopProductDetailCustomViewModel.D2(str);
        return Unit.INSTANCE;
    }
}
