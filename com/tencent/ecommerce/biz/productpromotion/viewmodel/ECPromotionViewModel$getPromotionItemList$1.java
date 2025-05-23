package com.tencent.ecommerce.biz.productpromotion.viewmodel;

import androidx.lifecycle.MutableLiveData;
import cg0.a;
import com.tencent.ecommerce.biz.productpromotion.repo.ECPromotionSourceRepo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import yj0.ECPromoteItem;
import yj0.d;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.productpromotion.viewmodel.ECPromotionViewModel$getPromotionItemList$1", f = "ECPromotionViewModel.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECPromotionViewModel$getPromotionItemList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $userId;
    Object L$0;
    int label;
    final /* synthetic */ ECPromotionViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECPromotionViewModel$getPromotionItemList$1(ECPromotionViewModel eCPromotionViewModel, long j3, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCPromotionViewModel;
        this.$userId = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECPromotionViewModel$getPromotionItemList$1(this.this$0, this.$userId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECPromotionViewModel$getPromotionItemList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ECPromotionViewModel eCPromotionViewModel;
        ArrayList<ECPromoteItem> a16;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList<ECPromoteItem> arrayList3;
        ArrayList arrayList4;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ECPromotionViewModel eCPromotionViewModel2 = this.this$0;
            ECPromotionSourceRepo eCPromotionSourceRepo = ECPromotionSourceRepo.f103947a;
            long j3 = this.$userId;
            this.L$0 = eCPromotionViewModel2;
            this.label = 1;
            Object a17 = eCPromotionSourceRepo.a(j3, this);
            if (a17 == coroutine_suspended) {
                return coroutine_suspended;
            }
            eCPromotionViewModel = eCPromotionViewModel2;
            obj = a17;
        } else if (i3 == 1) {
            eCPromotionViewModel = (ECPromotionViewModel) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        d dVar = (d) obj;
        if (dVar != null) {
            eCPromotionViewModel.P1(dVar);
            d getPromotionResp = this.this$0.getGetPromotionResp();
            if (getPromotionResp != null && (a16 = getPromotionResp.a()) != null) {
                arrayList = this.this$0._promotionItemList;
                arrayList.clear();
                arrayList2 = this.this$0._promotionItemList;
                arrayList2.addAll(a16);
                MutableLiveData<ArrayList<ECPromoteItem>> O1 = this.this$0.O1();
                arrayList3 = this.this$0._promotionItemList;
                O1.postValue(arrayList3);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[getPromotionItemList] promotionList = ");
                arrayList4 = this.this$0._promotionItemList;
                sb5.append(arrayList4);
                a.b("ECPromotionViewModel", sb5.toString());
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
