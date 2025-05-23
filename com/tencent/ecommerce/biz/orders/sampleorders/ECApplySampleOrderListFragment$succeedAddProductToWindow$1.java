package com.tencent.ecommerce.biz.orders.sampleorders;

import com.tencent.ecommerce.repo.buyerorder.orderlist.ECOrderListItem;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListFragment$succeedAddProductToWindow$1", f = "ECApplySampleOrderListFragment.kt", i = {}, l = {549}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECApplySampleOrderListFragment$succeedAddProductToWindow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ECOrderListItem $newOrderInfo;
    final /* synthetic */ String $orderId;
    final /* synthetic */ String $spuId;
    int label;
    final /* synthetic */ ECApplySampleOrderListFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECApplySampleOrderListFragment$succeedAddProductToWindow$1(ECApplySampleOrderListFragment eCApplySampleOrderListFragment, ECOrderListItem eCOrderListItem, String str, String str2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCApplySampleOrderListFragment;
        this.$newOrderInfo = eCOrderListItem;
        this.$orderId = str;
        this.$spuId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECApplySampleOrderListFragment$succeedAddProductToWindow$1(this.this$0, this.$newOrderInfo, this.$orderId, this.$spuId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECApplySampleOrderListFragment$succeedAddProductToWindow$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        com.tencent.ecommerce.base.list.b bVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            bVar = ECApplySampleOrderListFragment.M;
            ECOrderListItem eCOrderListItem = this.$newOrderInfo;
            Function1<ECOrderListItem, Boolean> function1 = new Function1<ECOrderListItem, Boolean>() { // from class: com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListFragment$succeedAddProductToWindow$1.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(ECOrderListItem eCOrderListItem2) {
                    return Boolean.valueOf(invoke2(eCOrderListItem2));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(ECOrderListItem eCOrderListItem2) {
                    String ei5;
                    String gi5;
                    ei5 = ECApplySampleOrderListFragment$succeedAddProductToWindow$1.this.this$0.ei(eCOrderListItem2.getPtsJSONObject());
                    if (Intrinsics.areEqual(ei5, ECApplySampleOrderListFragment$succeedAddProductToWindow$1.this.$orderId)) {
                        gi5 = ECApplySampleOrderListFragment$succeedAddProductToWindow$1.this.this$0.gi(eCOrderListItem2.getPtsJSONObject());
                        if (Intrinsics.areEqual(gi5, ECApplySampleOrderListFragment$succeedAddProductToWindow$1.this.$spuId)) {
                            return true;
                        }
                    }
                    return false;
                }
            };
            this.label = 1;
            if (bVar.d(eCOrderListItem, function1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
