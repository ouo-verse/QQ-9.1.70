package com.tencent.ecommerce.biz.orders.address.picker;

import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.biz.orders.address.picker.model.DistrictAddressInfo;
import com.tencent.ecommerce.biz.orders.address.picker.model.ECAddressPickerState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.address.picker.ECAddressPickerViewModel$initSelectedAddressState$1", f = "ECAddressPickerViewModel.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {47, 60, 75}, m = "invokeSuspend", n = {"selectedDistrictAddressInfoList", "districtListList", "selectedDistrictAddressInfoList", "districtListList", "i", "selectedDistrictAddressInfoList", "districtListList"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0", "L$0", "L$1"})
/* loaded from: classes31.dex */
public final class ECAddressPickerViewModel$initSelectedAddressState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List $addressList;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ECAddressPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECAddressPickerViewModel$initSelectedAddressState$1(ECAddressPickerViewModel eCAddressPickerViewModel, List list, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCAddressPickerViewModel;
        this.$addressList = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECAddressPickerViewModel$initSelectedAddressState$1(this.this$0, this.$addressList, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECAddressPickerViewModel$initSelectedAddressState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00e3 -> B:13:0x00e6). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        List<DistrictAddressInfo> arrayList;
        List<List<DistrictAddressInfo>> arrayList2;
        IECAddressPickerRepo iECAddressPickerRepo;
        List<DistrictAddressInfo> list;
        int size;
        ECAddressPickerViewModel$initSelectedAddressState$1 eCAddressPickerViewModel$initSelectedAddressState$1;
        int i3;
        List<DistrictAddressInfo> list2;
        List<List<DistrictAddressInfo>> list3;
        List<DistrictAddressInfo> emptyList;
        MutableLiveData mutableLiveData;
        Object obj2;
        IECAddressPickerRepo iECAddressPickerRepo2;
        List<List<DistrictAddressInfo>> list4;
        List<DistrictAddressInfo> list5;
        Object last;
        Object last2;
        List<DistrictAddressInfo> emptyList2;
        MutableLiveData mutableLiveData2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 == 0) {
            ResultKt.throwOnFailure(obj);
            arrayList = new ArrayList<>();
            arrayList2 = new ArrayList<>();
            iECAddressPickerRepo = this.this$0.repo;
            this.L$0 = arrayList;
            this.L$1 = arrayList2;
            this.label = 1;
            obj = iECAddressPickerRepo.requestProvinceDistrictList(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3) {
                        list4 = (List) this.L$1;
                        list5 = (List) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        eCAddressPickerViewModel$initSelectedAddressState$1 = this;
                        mutableLiveData2 = eCAddressPickerViewModel$initSelectedAddressState$1.this$0._addressPickerState;
                        mutableLiveData2.setValue(new ECAddressPickerState(list5, list4, false, 4, null));
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                size = this.I$1;
                i3 = this.I$0;
                list3 = (List) this.L$1;
                list2 = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                eCAddressPickerViewModel$initSelectedAddressState$1 = this;
                list = (List) obj;
                if (list == null) {
                    if (!list.isEmpty()) {
                        list3.add(list);
                        i3++;
                        if (i3 < size) {
                            Iterator it = list.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    obj2 = null;
                                    break;
                                }
                                obj2 = it.next();
                                if (Boxing.boxBoolean(Intrinsics.areEqual(((DistrictAddressInfo) obj2).name, (String) eCAddressPickerViewModel$initSelectedAddressState$1.$addressList.get(i3))).booleanValue()) {
                                    break;
                                }
                            }
                            DistrictAddressInfo districtAddressInfo = (DistrictAddressInfo) obj2;
                            if (districtAddressInfo != null) {
                                list2.add(districtAddressInfo);
                                iECAddressPickerRepo2 = eCAddressPickerViewModel$initSelectedAddressState$1.this$0.repo;
                                eCAddressPickerViewModel$initSelectedAddressState$1.L$0 = list2;
                                eCAddressPickerViewModel$initSelectedAddressState$1.L$1 = list3;
                                eCAddressPickerViewModel$initSelectedAddressState$1.I$0 = i3;
                                eCAddressPickerViewModel$initSelectedAddressState$1.I$1 = size;
                                eCAddressPickerViewModel$initSelectedAddressState$1.label = 2;
                                obj = iECAddressPickerRepo2.requestDistrictList(districtAddressInfo, eCAddressPickerViewModel$initSelectedAddressState$1);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                list = (List) obj;
                                if (list == null) {
                                    emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                                    list3.add(emptyList2);
                                }
                            }
                        }
                    }
                }
                list4 = list3;
                list5 = list2;
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list4);
                if (((List) last).size() == 1) {
                    last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) list4);
                    DistrictAddressInfo districtAddressInfo2 = (DistrictAddressInfo) ((List) last2).get(0);
                    ECAddressPickerViewModel eCAddressPickerViewModel = eCAddressPickerViewModel$initSelectedAddressState$1.this$0;
                    eCAddressPickerViewModel$initSelectedAddressState$1.L$0 = list5;
                    eCAddressPickerViewModel$initSelectedAddressState$1.L$1 = list4;
                    eCAddressPickerViewModel$initSelectedAddressState$1.label = 3;
                    if (eCAddressPickerViewModel.N1(districtAddressInfo2, list5, list4, eCAddressPickerViewModel$initSelectedAddressState$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                mutableLiveData2 = eCAddressPickerViewModel$initSelectedAddressState$1.this$0._addressPickerState;
                mutableLiveData2.setValue(new ECAddressPickerState(list5, list4, false, 4, null));
                return Unit.INSTANCE;
            }
            arrayList2 = (List) this.L$1;
            arrayList = (List) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        List<List<DistrictAddressInfo>> list6 = arrayList2;
        List<DistrictAddressInfo> list7 = arrayList;
        list = (List) obj;
        if (list == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list6.add(emptyList);
            mutableLiveData = this.this$0._addressPickerState;
            mutableLiveData.setValue(new ECAddressPickerState(list7, list6, false, 4, null));
            return Unit.INSTANCE;
        }
        list6.add(list);
        size = this.$addressList.size();
        eCAddressPickerViewModel$initSelectedAddressState$1 = this;
        i3 = 0;
        list2 = list7;
        list3 = list6;
        if (i3 < size) {
        }
        list4 = list3;
        list5 = list2;
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list4);
        if (((List) last).size() == 1) {
        }
        mutableLiveData2 = eCAddressPickerViewModel$initSelectedAddressState$1.this$0._addressPickerState;
        mutableLiveData2.setValue(new ECAddressPickerState(list5, list4, false, 4, null));
        return Unit.INSTANCE;
    }
}
