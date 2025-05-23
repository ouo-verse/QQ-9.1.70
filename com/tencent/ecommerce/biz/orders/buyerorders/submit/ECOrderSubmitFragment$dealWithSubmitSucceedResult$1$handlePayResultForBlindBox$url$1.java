package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import com.tencent.ecommerce.biz.orders.span.ECOrderSpanScene;
import com.tencent.ecommerce.biz.pay.api.IECPayApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$url$1", f = "ECOrderSubmitFragment.kt", i = {}, l = {1003, 1011}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$url$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ IECPayApi.PayResult $payResult;
    final /* synthetic */ Ref.BooleanRef $showRefundDialog;
    final /* synthetic */ Ref.ObjectRef $spuId;
    int label;
    final /* synthetic */ ECOrderSubmitFragment$dealWithSubmitSucceedResult$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$url$1(ECOrderSubmitFragment$dealWithSubmitSucceedResult$1 eCOrderSubmitFragment$dealWithSubmitSucceedResult$1, IECPayApi.PayResult payResult, Ref.ObjectRef objectRef, Ref.BooleanRef booleanRef, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCOrderSubmitFragment$dealWithSubmitSucceedResult$1;
        this.$payResult = payResult;
        this.$spuId = objectRef;
        this.$showRefundDialog = booleanRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$url$1(this.this$0, this.$payResult, this.$spuId, this.$showRefundDialog, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((ECOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$url$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00ac A[ORIG_RETURN, RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ECBlindBoxViewModel Fi;
        String str;
        ECBlindBoxViewModel Fi2;
        Pair pair;
        Boolean bool;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
                return (String) obj;
            }
            if (i3 == 2) {
                ResultKt.throwOnFailure(obj);
                pair = (Pair) obj;
                this.$showRefundDialog.element = (pair != null || (bool = (Boolean) pair.getFirst()) == null) ? false : bool.booleanValue();
                if (pair == null) {
                    return (String) pair.getSecond();
                }
                return null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (this.this$0.f103472a.Li().O2()) {
            Fi2 = this.this$0.f103472a.Fi();
            IECPayApi.PayResult payResult = this.$payResult;
            List<String> b16 = this.this$0.f103473b.b();
            String str2 = (String) this.$spuId.element;
            ECOrderSpanScene eCOrderSpanScene = ECOrderSpanScene.OrderSubmit;
            this.label = 1;
            obj = Fi2.L1(payResult, b16, str2, eCOrderSpanScene, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            return (String) obj;
        }
        Fi = this.this$0.f103472a.Fi();
        IECPayApi.PayResult payResult2 = this.$payResult;
        List<String> b17 = this.this$0.f103473b.b();
        String str3 = (String) this.$spuId.element;
        str = this.this$0.f103472a.groupId;
        if (str == null) {
            str = "";
        }
        ECOrderSpanScene eCOrderSpanScene2 = ECOrderSpanScene.OrderSubmit;
        this.label = 2;
        obj = Fi.M1(payResult2, b17, str3, str, eCOrderSpanScene2, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        pair = (Pair) obj;
        this.$showRefundDialog.element = (pair != null || (bool = (Boolean) pair.getFirst()) == null) ? false : bool.booleanValue();
        if (pair == null) {
        }
    }
}
