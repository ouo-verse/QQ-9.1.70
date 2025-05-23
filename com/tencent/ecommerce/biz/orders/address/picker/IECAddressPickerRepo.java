package com.tencent.ecommerce.biz.orders.address.picker;

import com.tencent.ecommerce.biz.orders.address.picker.model.DistrictAddressInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/picker/IECAddressPickerRepo;", "", "", "Lcom/tencent/ecommerce/biz/orders/address/picker/model/a;", "requestProvinceDistrictList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parentDistrictAddressInfo", "requestDistrictList", "(Lcom/tencent/ecommerce/biz/orders/address/picker/model/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface IECAddressPickerRepo {
    Object requestDistrictList(DistrictAddressInfo districtAddressInfo, Continuation<? super List<DistrictAddressInfo>> continuation);

    Object requestProvinceDistrictList(Continuation<? super List<DistrictAddressInfo>> continuation);
}
