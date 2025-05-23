package com.tencent.ecommerce.biz.orders.address.picker;

import ag0.ECLocationInfo;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tencent.ecommerce.biz.orders.address.picker.model.DistrictAddressInfo;
import com.tencent.ecommerce.biz.orders.address.picker.model.ECAddressPickerInitIntent;
import com.tencent.ecommerce.biz.orders.address.picker.model.ECAddressPickerSelectedIntent;
import com.tencent.ecommerce.biz.orders.address.picker.model.ECAddressPickerState;
import com.tencent.ecommerce.biz.orders.address.picker.model.ECCityInfo;
import com.tencent.ecommerce.biz.orders.address.picker.model.d;
import com.tencent.ecommerce.repo.ServiceLocator;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nJ=\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00020\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00020\u0013J\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0013R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001d0!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006)"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressPickerViewModel;", "Landroidx/lifecycle/ViewModel;", "", "", "addressList", "", "Q1", "Lcom/tencent/ecommerce/biz/orders/address/picker/model/a;", "districtAddressInfo", "T1", "Lcom/tencent/ecommerce/biz/orders/address/picker/model/d;", "intent", "O1", "", "selectedDistrictAddressInfoList", "districtListList", "", "N1", "(Lcom/tencent/ecommerce/biz/orders/address/picker/model/a;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/ecommerce/biz/orders/address/picker/model/g;", "S1", "Lag0/a;", "R1", "Lcom/tencent/ecommerce/biz/orders/address/picker/IECAddressPickerRepo;", "i", "Lcom/tencent/ecommerce/biz/orders/address/picker/IECAddressPickerRepo;", "repo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/ecommerce/biz/orders/address/picker/model/f;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_addressPickerState", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "P1", "()Landroidx/lifecycle/LiveData;", "addressPickerState", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECAddressPickerViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final LiveData<ECAddressPickerState> addressPickerState;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final IECAddressPickerRepo repo = ServiceLocator.f104891i.a();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<ECAddressPickerState> _addressPickerState;

    public ECAddressPickerViewModel() {
        MutableLiveData<ECAddressPickerState> mutableLiveData = new MutableLiveData<>();
        this._addressPickerState = mutableLiveData;
        this.addressPickerState = mutableLiveData;
    }

    private final void Q1(List<String> addressList) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECAddressPickerViewModel$initSelectedAddressState$1(this, addressList, null), 3, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002e, code lost:
    
        r1 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList((java.util.Collection) r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
    
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList((java.util.Collection) r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void T1(DistrictAddressInfo districtAddressInfo) {
        Iterable arrayList;
        List arrayList2;
        List mutableList;
        ECAddressPickerState value = this._addressPickerState.getValue();
        if (value == null || (r0 = value.c()) == null || arrayList == null) {
            arrayList = new ArrayList();
        }
        ECAddressPickerState value2 = this._addressPickerState.getValue();
        if (value2 == null || (r1 = value2.a()) == null || arrayList2 == null) {
            arrayList2 = new ArrayList();
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList3);
                mutableList.add(districtAddressInfo);
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECAddressPickerViewModel$updateDistrictSelectedState$1(this, districtAddressInfo, arrayList2.subList(0, mutableList.size()), mutableList, null), 3, null);
                return;
            } else {
                Object next = it.next();
                if (((DistrictAddressInfo) next).type.ordinal() < districtAddressInfo.type.ordinal()) {
                    arrayList3.add(next);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object N1(DistrictAddressInfo districtAddressInfo, List<DistrictAddressInfo> list, List<List<DistrictAddressInfo>> list2, Continuation<? super Boolean> continuation) {
        ECAddressPickerViewModel$dealOnlyOneDistrictList$1 eCAddressPickerViewModel$dealOnlyOneDistrictList$1;
        Object coroutine_suspended;
        int i3;
        ECAddressPickerViewModel eCAddressPickerViewModel;
        List<DistrictAddressInfo> list3;
        List<DistrictAddressInfo> emptyList;
        if (continuation instanceof ECAddressPickerViewModel$dealOnlyOneDistrictList$1) {
            eCAddressPickerViewModel$dealOnlyOneDistrictList$1 = (ECAddressPickerViewModel$dealOnlyOneDistrictList$1) continuation;
            int i16 = eCAddressPickerViewModel$dealOnlyOneDistrictList$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCAddressPickerViewModel$dealOnlyOneDistrictList$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCAddressPickerViewModel$dealOnlyOneDistrictList$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCAddressPickerViewModel$dealOnlyOneDistrictList$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    list.add(districtAddressInfo);
                    IECAddressPickerRepo iECAddressPickerRepo = this.repo;
                    eCAddressPickerViewModel$dealOnlyOneDistrictList$1.L$0 = this;
                    eCAddressPickerViewModel$dealOnlyOneDistrictList$1.L$1 = list;
                    eCAddressPickerViewModel$dealOnlyOneDistrictList$1.L$2 = list2;
                    eCAddressPickerViewModel$dealOnlyOneDistrictList$1.label = 1;
                    obj = iECAddressPickerRepo.requestDistrictList(districtAddressInfo, eCAddressPickerViewModel$dealOnlyOneDistrictList$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCAddressPickerViewModel = this;
                } else {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    list2 = (List) eCAddressPickerViewModel$dealOnlyOneDistrictList$1.L$2;
                    list = (List) eCAddressPickerViewModel$dealOnlyOneDistrictList$1.L$1;
                    eCAddressPickerViewModel = (ECAddressPickerViewModel) eCAddressPickerViewModel$dealOnlyOneDistrictList$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                list3 = (List) obj;
                if (list3 != null) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    list2.add(emptyList);
                    return Boxing.boxBoolean(false);
                }
                if (!list3.isEmpty()) {
                    list2.add(list3);
                    if (list3.size() == 1) {
                        DistrictAddressInfo districtAddressInfo2 = list3.get(0);
                        eCAddressPickerViewModel$dealOnlyOneDistrictList$1.L$0 = null;
                        eCAddressPickerViewModel$dealOnlyOneDistrictList$1.L$1 = null;
                        eCAddressPickerViewModel$dealOnlyOneDistrictList$1.L$2 = null;
                        eCAddressPickerViewModel$dealOnlyOneDistrictList$1.label = 2;
                        obj = eCAddressPickerViewModel.N1(districtAddressInfo2, list, list2, eCAddressPickerViewModel$dealOnlyOneDistrictList$1);
                        return obj == coroutine_suspended ? coroutine_suspended : obj;
                    }
                }
                return Boxing.boxBoolean(list3.isEmpty());
            }
        }
        eCAddressPickerViewModel$dealOnlyOneDistrictList$1 = new ECAddressPickerViewModel$dealOnlyOneDistrictList$1(this, continuation);
        Object obj2 = eCAddressPickerViewModel$dealOnlyOneDistrictList$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCAddressPickerViewModel$dealOnlyOneDistrictList$1.label;
        if (i3 != 0) {
        }
        list3 = (List) obj2;
        if (list3 != null) {
        }
    }

    public final void O1(d intent) {
        if (intent instanceof ECAddressPickerInitIntent) {
            Q1(((ECAddressPickerInitIntent) intent).a());
        } else if (intent instanceof ECAddressPickerSelectedIntent) {
            T1(((ECAddressPickerSelectedIntent) intent).getSelectedDistrictAddressInfo());
        }
    }

    public final LiveData<ECAddressPickerState> P1() {
        return this.addressPickerState;
    }

    public final Flow<ECLocationInfo> R1() {
        return FlowKt.flow(new ECAddressPickerViewModel$requestCurrentLocation$1(null));
    }

    public final Flow<List<ECCityInfo>> S1() {
        return FlowKt.flow(new ECAddressPickerViewModel$requestHotCityList$1(null));
    }
}
