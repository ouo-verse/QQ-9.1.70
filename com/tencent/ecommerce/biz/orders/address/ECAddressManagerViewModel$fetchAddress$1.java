package com.tencent.ecommerce.biz.orders.address;

import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.biz.orders.address.ECAddressListAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.address.ECAddressManagerViewModel$fetchAddress$1", f = "ECAddressManagerViewModel.kt", i = {}, l = {22}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECAddressManagerViewModel$fetchAddress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ECAddressManagerViewModel this$0;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a<T> implements Comparator<T> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Boolean.valueOf(!((ECAddressListAdapter.ECAddressItemData) t16).getAddress().isDefaultAddress), Boolean.valueOf(!((ECAddressListAdapter.ECAddressItemData) t17).getAddress().isDefaultAddress));
            return compareValues;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECAddressManagerViewModel$fetchAddress$1(ECAddressManagerViewModel eCAddressManagerViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCAddressManagerViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECAddressManagerViewModel$fetchAddress$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECAddressManagerViewModel$fetchAddress$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        IECAddressRepository iECAddressRepository;
        List list;
        MutableLiveData mutableLiveData;
        Object first;
        MutableLiveData mutableLiveData2;
        int collectionSizeOrDefault;
        List sortedWith;
        ECAddressListAdapter.ECAddressItemData eCAddressItemData;
        MutableLiveData mutableLiveData3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            iECAddressRepository = this.this$0.repo;
            this.label = 1;
            obj = iECAddressRepository.getAllAddresses(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List list2 = (List) obj;
        if (list2 != null) {
            List<ECAddress> list3 = list2;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (ECAddress eCAddress : list3) {
                if (eCAddress.id == this.this$0.getInitSelectedAddressId()) {
                    mutableLiveData3 = this.this$0._selectedAddress;
                    mutableLiveData3.setValue(eCAddress);
                    eCAddressItemData = new ECAddressListAdapter.ECAddressItemData(eCAddress, true);
                } else {
                    eCAddressItemData = new ECAddressListAdapter.ECAddressItemData(eCAddress, false);
                }
                arrayList.add(eCAddressItemData);
            }
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new a());
            if (sortedWith != null) {
                list = CollectionsKt___CollectionsKt.toMutableList((Collection) sortedWith);
                if (list != null && (!list.isEmpty()) && this.this$0.getInitSelectedAddressId() == -1) {
                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
                    ECAddressListAdapter.ECAddressItemData eCAddressItemData2 = (ECAddressListAdapter.ECAddressItemData) first;
                    eCAddressItemData2.e(true);
                    this.this$0.X1(eCAddressItemData2.getAddress().id);
                    mutableLiveData2 = this.this$0._selectedAddress;
                    mutableLiveData2.setValue(eCAddressItemData2.getAddress());
                }
                mutableLiveData = this.this$0._allECAddress;
                mutableLiveData.postValue(list);
                return Unit.INSTANCE;
            }
        }
        list = null;
        if (list != null) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
            ECAddressListAdapter.ECAddressItemData eCAddressItemData22 = (ECAddressListAdapter.ECAddressItemData) first;
            eCAddressItemData22.e(true);
            this.this$0.X1(eCAddressItemData22.getAddress().id);
            mutableLiveData2 = this.this$0._selectedAddress;
            mutableLiveData2.setValue(eCAddressItemData22.getAddress());
        }
        mutableLiveData = this.this$0._allECAddress;
        mutableLiveData.postValue(list);
        return Unit.INSTANCE;
    }
}
