package com.tencent.ecommerce.biz.orders.address.picker;

import com.tencent.ecommerce.biz.orders.address.IECAddressRepository;
import com.tencent.ecommerce.biz.orders.address.picker.model.ECCityInfo;
import com.tencent.ecommerce.repo.ServiceLocator;
import com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr.ECQshopAddressSvr$HotItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/tencent/ecommerce/biz/orders/address/picker/model/g;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.address.picker.ECAddressPickerViewModel$requestHotCityList$1", f = "ECAddressPickerViewModel.kt", i = {0}, l = {138, 144}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* loaded from: classes31.dex */
final class ECAddressPickerViewModel$requestHotCityList$1 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends ECCityInfo>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ECAddressPickerViewModel$requestHotCityList$1 eCAddressPickerViewModel$requestHotCityList$1 = new ECAddressPickerViewModel$requestHotCityList$1(continuation);
        eCAddressPickerViewModel$requestHotCityList$1.L$0 = obj;
        return eCAddressPickerViewModel$requestHotCityList$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super List<? extends ECCityInfo>> flowCollector, Continuation<? super Unit> continuation) {
        return ((ECAddressPickerViewModel$requestHotCityList$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        FlowCollector flowCollector;
        Collection emptyList;
        int collectionSizeOrDefault;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            IECAddressRepository b16 = ServiceLocator.f104891i.b();
            this.L$0 = flowCollector;
            this.label = 1;
            obj = b16.getHotCity(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        List list = (List) obj;
        if (list == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            List<ECQshopAddressSvr$HotItem> list2 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            emptyList = new ArrayList(collectionSizeOrDefault);
            for (ECQshopAddressSvr$HotItem eCQshopAddressSvr$HotItem : list2) {
                emptyList.add(new ECCityInfo(eCQshopAddressSvr$HotItem.province.get(), eCQshopAddressSvr$HotItem.city.get()));
            }
        }
        this.L$0 = null;
        this.label = 2;
        if (flowCollector.emit(emptyList, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECAddressPickerViewModel$requestHotCityList$1(Continuation continuation) {
        super(2, continuation);
    }
}
