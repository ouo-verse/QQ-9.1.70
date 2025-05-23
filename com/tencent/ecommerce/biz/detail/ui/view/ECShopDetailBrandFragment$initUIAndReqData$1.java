package com.tencent.ecommerce.biz.detail.ui.view;

import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.biz.detail.repo.shop.IECShopProductDetailRepository;
import com.tencent.ecommerce.biz.detail.repo.shop.a;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.ui.view.ECShopDetailBrandFragment$initUIAndReqData$1", f = "ECShopDetailBrandFragment.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECShopDetailBrandFragment$initUIAndReqData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ECShopDetailBrandFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopDetailBrandFragment$initUIAndReqData$1(ECShopDetailBrandFragment eCShopDetailBrandFragment, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCShopDetailBrandFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShopDetailBrandFragment$initUIAndReqData$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECShopDetailBrandFragment$initUIAndReqData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String str;
        String str2;
        int Uh;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            IECShopProductDetailRepository shopProductDetailRepository = a.f102322a.getShopProductDetailRepository();
            str = this.this$0.shopId;
            str2 = this.this$0.brandId;
            this.label = 1;
            obj = shopProductDetailRepository.getBrandQuaLinks(str, str2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject == null) {
            IStateCenterView.a.a(ECShopDetailBrandFragment.Qh(this.this$0), null, null, 0, 7, null);
        } else {
            ECShopDetailBrandFragment eCShopDetailBrandFragment = this.this$0;
            Uh = eCShopDetailBrandFragment.Uh(jSONObject);
            eCShopDetailBrandFragment.Wh(Uh);
            this.this$0.Zh(jSONObject.toString());
        }
        return Unit.INSTANCE;
    }
}
