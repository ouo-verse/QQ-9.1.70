package com.tencent.ecommerce.biz.orders.address.picker;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u00022\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u00040\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0082@"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/picker/model/a;", "districtAddressInfo", "", "selectedDistrictAddressInfoList", "", "districtListList", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "dealOnlyOneDistrictList"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.address.picker.ECAddressPickerViewModel", f = "ECAddressPickerViewModel.kt", i = {0, 0, 0}, l = {123, 131}, m = "dealOnlyOneDistrictList", n = {"this", "selectedDistrictAddressInfoList", "districtListList"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes31.dex */
public final class ECAddressPickerViewModel$dealOnlyOneDistrictList$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECAddressPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECAddressPickerViewModel$dealOnlyOneDistrictList$1(ECAddressPickerViewModel eCAddressPickerViewModel, Continuation continuation) {
        super(continuation);
        this.this$0 = eCAddressPickerViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.N1(null, null, null, this);
    }
}
