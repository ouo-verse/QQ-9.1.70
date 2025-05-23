package com.tencent.ecommerce.biz.commission.subsidy;

import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.repo.ServiceLocator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import tj0.ECSubsidyExpectedProfitInfo;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.commission.subsidy.ECSubsidyListViewModel$loadSubsidyFirstPageList$1", f = "ECSubsidyListViewModel.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECSubsidyListViewModel$loadSubsidyFirstPageList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ECSubsidyListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECSubsidyListViewModel$loadSubsidyFirstPageList$1(ECSubsidyListViewModel eCSubsidyListViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCSubsidyListViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECSubsidyListViewModel$loadSubsidyFirstPageList$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECSubsidyListViewModel$loadSubsidyFirstPageList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        int collectionSizeOrDefault;
        JSONObject W1;
        MutableLiveData mutableLiveData2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            com.tencent.ecommerce.repo.commission.subsidy.a r16 = ServiceLocator.f104891i.r();
            this.label = 1;
            obj = r16.d("", this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ECSubsidyExpectedProfitInfo eCSubsidyExpectedProfitInfo = (ECSubsidyExpectedProfitInfo) obj;
        if (eCSubsidyExpectedProfitInfo == null) {
            mutableLiveData2 = this.this$0._profitList;
            mutableLiveData2.setValue(null);
        } else {
            this.this$0.cookie = eCSubsidyExpectedProfitInfo.cookie;
            this.this$0.isEnd = eCSubsidyExpectedProfitInfo.isEnd;
            mutableLiveData = this.this$0._profitList;
            List<JSONObject> a16 = eCSubsidyExpectedProfitInfo.a();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(a16, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = a16.iterator();
            while (it.hasNext()) {
                W1 = this.this$0.W1((JSONObject) it.next());
                arrayList.add(W1);
            }
            mutableLiveData.setValue(arrayList);
        }
        this.this$0.job = null;
        return Unit.INSTANCE;
    }
}
