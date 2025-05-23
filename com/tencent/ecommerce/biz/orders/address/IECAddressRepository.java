package com.tencent.ecommerce.biz.orders.address;

import com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr.ECQshopAddressSvr$HotItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u001f\u0010\f\u001a\u00020\r2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/IECAddressRepository;", "", "addAddress", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "address", "(Lcom/tencent/ecommerce/biz/orders/address/ECAddress;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAddresses", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDefaultAddress", "getHotCity", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_address_svr/ECQshopAddressSvr$HotItem;", "removeAddress", "", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAddress", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface IECAddressRepository {
    Object addAddress(ECAddress eCAddress, Continuation<? super ECAddress> continuation);

    Object getAllAddresses(Continuation<? super List<ECAddress>> continuation);

    Object getDefaultAddress(Continuation<? super ECAddress> continuation);

    Object getHotCity(Continuation<? super List<ECQshopAddressSvr$HotItem>> continuation);

    Object removeAddress(List<Long> list, Continuation<? super Boolean> continuation);

    Object updateAddress(ECAddress eCAddress, Continuation<? super Boolean> continuation);
}
