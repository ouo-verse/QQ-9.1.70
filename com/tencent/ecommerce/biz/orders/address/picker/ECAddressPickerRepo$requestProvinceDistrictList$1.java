package com.tencent.ecommerce.biz.orders.address.picker;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0000H\u0096@"}, d2 = {"Lkotlin/coroutines/Continuation;", "", "Lcom/tencent/ecommerce/biz/orders/address/picker/model/a;", "continuation", "", "requestProvinceDistrictList"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.address.picker.ECAddressPickerRepo", f = "ECAddressPickerRepo.kt", i = {0}, l = {46}, m = "requestProvinceDistrictList", n = {"this"}, s = {"L$0"})
/* loaded from: classes31.dex */
public final class ECAddressPickerRepo$requestProvinceDistrictList$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECAddressPickerRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECAddressPickerRepo$requestProvinceDistrictList$1(ECAddressPickerRepo eCAddressPickerRepo, Continuation continuation) {
        super(continuation);
        this.this$0 = eCAddressPickerRepo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.requestProvinceDistrictList(this);
    }
}
