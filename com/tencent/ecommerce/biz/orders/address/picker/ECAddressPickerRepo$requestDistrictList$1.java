package com.tencent.ecommerce.biz.orders.address.picker;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00030\u0002H\u0096@"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/picker/model/a;", "parentDistrictAddressInfo", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "requestDistrictList"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.address.picker.ECAddressPickerRepo", f = "ECAddressPickerRepo.kt", i = {0, 0}, l = {72}, m = "requestDistrictList", n = {"this", "parentDistrictAddressInfo"}, s = {"L$0", "L$1"})
/* loaded from: classes31.dex */
public final class ECAddressPickerRepo$requestDistrictList$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECAddressPickerRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECAddressPickerRepo$requestDistrictList$1(ECAddressPickerRepo eCAddressPickerRepo, Continuation continuation) {
        super(continuation);
        this.this$0 = eCAddressPickerRepo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.requestDistrictList(null, this);
    }
}
