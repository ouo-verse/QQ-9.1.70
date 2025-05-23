package com.tencent.ecommerce.biz.orders.address.picker;

import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.biz.orders.address.picker.model.DistrictAddressInfo;
import com.tencent.ecommerce.biz.orders.address.picker.model.ECAddressPickerState;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.address.picker.ECAddressPickerViewModel$updateDistrictSelectedState$1", f = "ECAddressPickerViewModel.kt", i = {}, l = {90, 98}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECAddressPickerViewModel$updateDistrictSelectedState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DistrictAddressInfo $districtAddressInfo;
    final /* synthetic */ List $newAddressInfoList;
    final /* synthetic */ List $newDistrictListList;
    int label;
    final /* synthetic */ ECAddressPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECAddressPickerViewModel$updateDistrictSelectedState$1(ECAddressPickerViewModel eCAddressPickerViewModel, DistrictAddressInfo districtAddressInfo, List list, List list2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCAddressPickerViewModel;
        this.$districtAddressInfo = districtAddressInfo;
        this.$newDistrictListList = list;
        this.$newAddressInfoList = list2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECAddressPickerViewModel$updateDistrictSelectedState$1(this.this$0, this.$districtAddressInfo, this.$newDistrictListList, this.$newAddressInfoList, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECAddressPickerViewModel$updateDistrictSelectedState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        IECAddressPickerRepo iECAddressPickerRepo;
        List emptyList;
        MutableLiveData mutableLiveData;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z16 = true;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            iECAddressPickerRepo = this.this$0.repo;
            DistrictAddressInfo districtAddressInfo = this.$districtAddressInfo;
            this.label = 1;
            obj = iECAddressPickerRepo.requestDistrictList(districtAddressInfo, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    z16 = ((Boolean) obj).booleanValue();
                    mutableLiveData = this.this$0._addressPickerState;
                    mutableLiveData.setValue(new ECAddressPickerState(this.$newAddressInfoList, this.$newDistrictListList, z16));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        List list = (List) obj;
        if (list == null) {
            List list2 = this.$newDistrictListList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list2.add(emptyList);
        } else {
            if (list.size() == 1) {
                this.$newDistrictListList.add(list);
                ECAddressPickerViewModel eCAddressPickerViewModel = this.this$0;
                DistrictAddressInfo districtAddressInfo2 = (DistrictAddressInfo) list.get(0);
                List<DistrictAddressInfo> list3 = this.$newAddressInfoList;
                List<List<DistrictAddressInfo>> list4 = this.$newDistrictListList;
                this.label = 2;
                obj = eCAddressPickerViewModel.N1(districtAddressInfo2, list3, list4, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                z16 = ((Boolean) obj).booleanValue();
                mutableLiveData = this.this$0._addressPickerState;
                mutableLiveData.setValue(new ECAddressPickerState(this.$newAddressInfoList, this.$newDistrictListList, z16));
                return Unit.INSTANCE;
            }
            if (!list.isEmpty()) {
                this.$newDistrictListList.add(list);
            }
            mutableLiveData = this.this$0._addressPickerState;
            mutableLiveData.setValue(new ECAddressPickerState(this.$newAddressInfoList, this.$newDistrictListList, z16));
            return Unit.INSTANCE;
        }
        z16 = false;
        mutableLiveData = this.this$0._addressPickerState;
        mutableLiveData.setValue(new ECAddressPickerState(this.$newAddressInfoList, this.$newDistrictListList, z16));
        return Unit.INSTANCE;
    }
}
