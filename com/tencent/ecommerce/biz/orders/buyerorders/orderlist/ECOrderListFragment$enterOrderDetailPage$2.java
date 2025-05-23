package com.tencent.ecommerce.biz.orders.buyerorders.orderlist;

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
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListFragment$enterOrderDetailPage$2", f = "ECOrderListFragment.kt", i = {}, l = {526}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECOrderListFragment$enterOrderDetailPage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $h5Url;
    final /* synthetic */ JSONArray $priorityArray;
    final /* synthetic */ JSONObject $qqMiniAppLinkInfo;
    final /* synthetic */ JSONObject $wxMiniAppLinkInfo;
    int label;
    final /* synthetic */ ECOrderListFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECOrderListFragment$enterOrderDetailPage$2(ECOrderListFragment eCOrderListFragment, JSONArray jSONArray, JSONObject jSONObject, JSONObject jSONObject2, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCOrderListFragment;
        this.$priorityArray = jSONArray;
        this.$wxMiniAppLinkInfo = jSONObject;
        this.$qqMiniAppLinkInfo = jSONObject2;
        this.$h5Url = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECOrderListFragment$enterOrderDetailPage$2(this.this$0, this.$priorityArray, this.$wxMiniAppLinkInfo, this.$qqMiniAppLinkInfo, this.$h5Url, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECOrderListFragment$enterOrderDetailPage$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        com.tencent.ecommerce.base.ui.d dVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ECOrderListFragment eCOrderListFragment = this.this$0;
            JSONArray jSONArray = this.$priorityArray;
            JSONObject jSONObject = this.$wxMiniAppLinkInfo;
            JSONObject jSONObject2 = this.$qqMiniAppLinkInfo;
            String str = this.$h5Url;
            this.label = 1;
            obj = eCOrderListFragment.ui(jSONArray, jSONObject, jSONObject2, str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!((Boolean) obj).booleanValue()) {
            this.this$0.ki(this.$h5Url);
        }
        dVar = this.this$0.loadingDialog;
        if (dVar != null) {
            dVar.dismiss();
        }
        return Unit.INSTANCE;
    }
}
