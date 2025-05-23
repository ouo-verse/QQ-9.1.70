package com.tencent.ecommerce.biz.shophome.fragment;

import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
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
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeQualificationFragment$initQualificationContent$1", f = "ECShopHomeQualificationFragment.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECShopHomeQualificationFragment$initQualificationContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ECShopHomeQualificationFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopHomeQualificationFragment$initQualificationContent$1(ECShopHomeQualificationFragment eCShopHomeQualificationFragment, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCShopHomeQualificationFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShopHomeQualificationFragment$initQualificationContent$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECShopHomeQualificationFragment$initQualificationContent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String str;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ECShopHomeDefaultRepository eCShopHomeDefaultRepository = ECShopHomeDefaultRepository.f104251a;
            str = this.this$0.shopId;
            this.label = 1;
            obj = IECShopHomeRepository.a.d(eCShopHomeDefaultRepository, str, null, this, 2, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optInt("code", 0) == 0) {
            ECShopHomeQualificationFragment.Lh(this.this$0).h(this.this$0.requireContext(), new ECBasePtsViewData(null, "shop_home_shop_qualification", jSONObject.toString(), null, 9, null));
            ECShopHomeQualificationFragment.Mh(this.this$0).setVisibility(8);
        } else {
            ECShopHomeQualificationFragment.Mh(this.this$0).setVisibility(0);
        }
        return Unit.INSTANCE;
    }
}
