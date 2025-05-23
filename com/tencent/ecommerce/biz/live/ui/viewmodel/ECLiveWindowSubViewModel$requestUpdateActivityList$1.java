package com.tencent.ecommerce.biz.live.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import cg0.a;
import com.tencent.ecommerce.repo.live.LiveActivity;
import com.tencent.ecommerce.repo.live.LiveProduct;
import com.tencent.ecommerce.repo.live.k;
import java.util.ArrayList;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowSubViewModel$requestUpdateActivityList$1", f = "ECLiveWindowSubViewModel.kt", i = {}, l = {745}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECLiveWindowSubViewModel$requestUpdateActivityList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ECLiveWindowSubViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECLiveWindowSubViewModel$requestUpdateActivityList$1(ECLiveWindowSubViewModel eCLiveWindowSubViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCLiveWindowSubViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECLiveWindowSubViewModel$requestUpdateActivityList$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECLiveWindowSubViewModel$requestUpdateActivityList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        List n26;
        MutableLiveData mutableLiveData;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList = new ArrayList();
            n26 = this.this$0.n2();
            Iterator it = n26.iterator();
            while (it.hasNext()) {
                LiveActivity liveActivity = ((LiveProduct) it.next()).getLiveActivity();
                if (liveActivity != null) {
                    arrayList.add(liveActivity.getActivityId());
                }
            }
            a.b(ECLiveWindowSubViewModel.S1(this.this$0), "StartPollingActivity, req activityIdList:" + arrayList);
            k U1 = ECLiveWindowSubViewModel.U1(this.this$0);
            this.label = 1;
            obj = U1.b(arrayList, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        k.ActivityResponse activityResponse = (k.ActivityResponse) obj;
        if (activityResponse.isSuccess && (!activityResponse.a().isEmpty())) {
            mutableLiveData = this.this$0._liveActivityListLiveData;
            mutableLiveData.setValue(activityResponse.a());
        }
        return Unit.INSTANCE;
    }
}
