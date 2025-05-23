package com.tencent.ecommerce.biz.commission.detail;

import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.biz.common.ui.ECCommonFilterDialog;
import java.util.Iterator;
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
import sj0.ECFilterOptionModel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.commission.detail.ECCommissionDetailViewModel$requestFilterOption$1", f = "ECCommissionDetailViewModel.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECCommissionDetailViewModel$requestFilterOption$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ECCommissionDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECCommissionDetailViewModel$requestFilterOption$1(ECCommissionDetailViewModel eCCommissionDetailViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCCommissionDetailViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECCommissionDetailViewModel$requestFilterOption$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECCommissionDetailViewModel$requestFilterOption$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        ECCommonFilterDialog.FilterItem P1;
        List list;
        List list2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z16 = true;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            rj0.a aVar = rj0.a.f431541a;
            this.label = 1;
            obj = aVar.b(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List list3 = (List) ((ECNetworkResponse) obj).b();
        List list4 = list3;
        if (list4 != null && !list4.isEmpty()) {
            z16 = false;
        }
        if (!z16) {
            mutableLiveData = this.this$0._filterOption;
            mutableLiveData.setValue(list3);
            Iterator it = list3.iterator();
            while (it.hasNext()) {
                P1 = this.this$0.P1((ECFilterOptionModel) it.next());
                list = this.this$0._filterData;
                list.add(P1);
                list2 = this.this$0._defaultFilterData;
                list2.add(P1);
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
