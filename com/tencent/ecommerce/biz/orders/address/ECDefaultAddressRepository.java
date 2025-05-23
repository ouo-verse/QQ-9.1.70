package com.tencent.ecommerce.biz.orders.address;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.network.api.IECNetworkPBContracts;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_delivery_address.ECDeliveryAddress$Address;
import com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr.ECQshopAddressSvr$AddReq;
import com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr.ECQshopAddressSvr$AddRsp;
import com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr.ECQshopAddressSvr$DeleteReq;
import com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr.ECQshopAddressSvr$GetDefaultReq;
import com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr.ECQshopAddressSvr$GetDefaultRsp;
import com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr.ECQshopAddressSvr$GetHotReq;
import com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr.ECQshopAddressSvr$GetHotRsp;
import com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr.ECQshopAddressSvr$GetListReq;
import com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr.ECQshopAddressSvr$GetListRsp;
import com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr.ECQshopAddressSvr$HotItem;
import com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr.ECQshopAddressSvr$UpdateReq;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\u0007J!\u0010\r\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0004J\u001b\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/ECDefaultAddressRepository;", "Lcom/tencent/ecommerce/biz/orders/address/IECAddressRepository;", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "getDefaultAddress", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "address", "addAddress", "(Lcom/tencent/ecommerce/biz/orders/address/ECAddress;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "updateAddress", "", "", "addressIds", "removeAddress", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAddresses", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_address_svr/ECQshopAddressSvr$HotItem;", "getHotCity", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECDefaultAddressRepository implements IECAddressRepository {

    /* renamed from: a, reason: collision with root package name */
    public static final ECDefaultAddressRepository f103000a = new ECDefaultAddressRepository();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"com/tencent/ecommerce/biz/orders/address/ECDefaultAddressRepository$a", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "", "b", "rsp", "a", "([B)Ljava/lang/Long;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements IECNetworkPBContracts<ECAddress, Long> {
        a() {
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long decodeResponse(byte[] rsp) {
            return Long.valueOf(new ECQshopAddressSvr$AddRsp().mergeFrom(rsp).address_id.get());
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] encodeRequestParams(ECAddress params, int channel, JSONObject reqExt) {
            ECQshopAddressSvr$AddReq eCQshopAddressSvr$AddReq = new ECQshopAddressSvr$AddReq();
            eCQshopAddressSvr$AddReq.address.set(com.tencent.ecommerce.biz.orders.address.b.e(params));
            return eCQshopAddressSvr$AddReq.toByteArray();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001J,\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\t0\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\tH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/ecommerce/biz/orders/address/ECDefaultAddressRepository$b", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "Lorg/json/JSONObject;", "", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "params", "", WadlProxyConsts.CHANNEL, "reqExt", "", "kotlin.jvm.PlatformType", "b", "rsp", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements IECNetworkPBContracts<JSONObject, List<? extends ECAddress>> {
        b() {
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<ECAddress> decodeResponse(byte[] rsp) {
            ECQshopAddressSvr$GetListRsp mergeFrom = new ECQshopAddressSvr$GetListRsp().mergeFrom(rsp);
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = mergeFrom.address_list.get().iterator();
            while (it.hasNext()) {
                arrayList.add(com.tencent.ecommerce.biz.orders.address.b.c((ECDeliveryAddress$Address) it.next()));
            }
            return arrayList;
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] encodeRequestParams(JSONObject params, int channel, JSONObject reqExt) {
            return new MessageMicro<ECQshopAddressSvr$GetListReq>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr.ECQshopAddressSvr$GetListReq
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ECQshopAddressSvr$GetListReq.class);
            }.toByteArray();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001J$\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/orders/address/ECDefaultAddressRepository$c", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "", "encodeRequestParams", "rsp", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements IECNetworkPBContracts<Object, ECAddress> {
        c() {
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ECAddress decodeResponse(byte[] rsp) {
            return com.tencent.ecommerce.biz.orders.address.b.c(new ECQshopAddressSvr$GetDefaultRsp().mergeFrom(rsp).address);
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        public byte[] encodeRequestParams(Object params, int channel, JSONObject reqExt) {
            return new MessageMicro<ECQshopAddressSvr$GetDefaultReq>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr.ECQshopAddressSvr$GetDefaultReq
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ECQshopAddressSvr$GetDefaultReq.class);
            }.toByteArray();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001J$\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/ecommerce/biz/orders/address/ECDefaultAddressRepository$d", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "", "", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_address_svr/ECQshopAddressSvr$HotItem;", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "", "encodeRequestParams", "rsp", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements IECNetworkPBContracts<Object, List<? extends ECQshopAddressSvr$HotItem>> {
        d() {
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<ECQshopAddressSvr$HotItem> decodeResponse(byte[] rsp) {
            return new ECQshopAddressSvr$GetHotRsp().mergeFrom(rsp).cities.get();
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        public byte[] encodeRequestParams(Object params, int channel, JSONObject reqExt) {
            return new MessageMicro<ECQshopAddressSvr$GetHotReq>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr.ECQshopAddressSvr$GetHotReq
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ECQshopAddressSvr$GetHotReq.class);
            }.toByteArray();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001J(\u0010\u000b\u001a\u00020\n2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/ecommerce/biz/orders/address/ECDefaultAddressRepository$e", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "", "", "", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "", "a", "rsp", "decodeResponse", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements IECNetworkPBContracts<List<? extends Long>, Object> {
        e() {
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public byte[] encodeRequestParams(List<Long> params, int channel, JSONObject reqExt) {
            ECQshopAddressSvr$DeleteReq eCQshopAddressSvr$DeleteReq = new ECQshopAddressSvr$DeleteReq();
            eCQshopAddressSvr$DeleteReq.address_ids.addAll(params);
            return eCQshopAddressSvr$DeleteReq.toByteArray();
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        public Object decodeResponse(byte[] rsp) {
            return null;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/orders/address/ECDefaultAddressRepository$f", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "", "a", "rsp", "decodeResponse", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements IECNetworkPBContracts<ECAddress, Object> {
        f() {
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public byte[] encodeRequestParams(ECAddress params, int channel, JSONObject reqExt) {
            ECQshopAddressSvr$UpdateReq eCQshopAddressSvr$UpdateReq = new ECQshopAddressSvr$UpdateReq();
            eCQshopAddressSvr$UpdateReq.address.set(com.tencent.ecommerce.biz.orders.address.b.e(params));
            return eCQshopAddressSvr$UpdateReq.toByteArray();
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        public Object decodeResponse(byte[] rsp) {
            return null;
        }
    }

    ECDefaultAddressRepository() {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.tencent.ecommerce.biz.orders.address.IECAddressRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getAllAddresses(Continuation<? super List<ECAddress>> continuation) {
        ECDefaultAddressRepository$getAllAddresses$1 eCDefaultAddressRepository$getAllAddresses$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        List emptyList;
        if (continuation instanceof ECDefaultAddressRepository$getAllAddresses$1) {
            eCDefaultAddressRepository$getAllAddresses$1 = (ECDefaultAddressRepository$getAllAddresses$1) continuation;
            int i16 = eCDefaultAddressRepository$getAllAddresses$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCDefaultAddressRepository$getAllAddresses$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCDefaultAddressRepository$getAllAddresses$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCDefaultAddressRepository$getAllAddresses$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    b bVar = new b();
                    eCDefaultAddressRepository$getAllAddresses$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.qshop_address_svr.QshopAddressSvr", "/trpc.ecom.qshop_address_svr.QshopAddressSvr/GetList", bVar, null, eCDefaultAddressRepository$getAllAddresses$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() == 0) {
                    cg0.a.a("ECDefaultAddressRepository", "getAllAddresses", "network error, errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
                    return null;
                }
                List list = (List) eCNetworkResponse.b();
                if (list != null) {
                    return list;
                }
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
        }
        eCDefaultAddressRepository$getAllAddresses$1 = new ECDefaultAddressRepository$getAllAddresses$1(this, continuation);
        Object obj2 = eCDefaultAddressRepository$getAllAddresses$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCDefaultAddressRepository$getAllAddresses$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.tencent.ecommerce.biz.orders.address.IECAddressRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getDefaultAddress(Continuation<? super ECAddress> continuation) {
        ECDefaultAddressRepository$getDefaultAddress$1 eCDefaultAddressRepository$getDefaultAddress$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECDefaultAddressRepository$getDefaultAddress$1) {
            eCDefaultAddressRepository$getDefaultAddress$1 = (ECDefaultAddressRepository$getDefaultAddress$1) continuation;
            int i16 = eCDefaultAddressRepository$getDefaultAddress$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCDefaultAddressRepository$getDefaultAddress$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCDefaultAddressRepository$getDefaultAddress$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCDefaultAddressRepository$getDefaultAddress$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    c cVar = new c();
                    eCDefaultAddressRepository$getDefaultAddress$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.qshop_address_svr.QshopAddressSvr", "/trpc.ecom.qshop_address_svr.QshopAddressSvr/GetDefault", cVar, null, eCDefaultAddressRepository$getDefaultAddress$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() != 0) {
                    return eCNetworkResponse.b();
                }
                cg0.a.a("ECDefaultAddressRepository", "getDefaultAddress", "get default address error, errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
                return null;
            }
        }
        eCDefaultAddressRepository$getDefaultAddress$1 = new ECDefaultAddressRepository$getDefaultAddress$1(this, continuation);
        Object obj2 = eCDefaultAddressRepository$getDefaultAddress$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCDefaultAddressRepository$getDefaultAddress$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.ecommerce.biz.orders.address.IECAddressRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getHotCity(Continuation<? super List<ECQshopAddressSvr$HotItem>> continuation) {
        ECDefaultAddressRepository$getHotCity$1 eCDefaultAddressRepository$getHotCity$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECDefaultAddressRepository$getHotCity$1) {
            eCDefaultAddressRepository$getHotCity$1 = (ECDefaultAddressRepository$getHotCity$1) continuation;
            int i16 = eCDefaultAddressRepository$getHotCity$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCDefaultAddressRepository$getHotCity$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCDefaultAddressRepository$getHotCity$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCDefaultAddressRepository$getHotCity$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    d dVar = new d();
                    eCDefaultAddressRepository$getHotCity$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.qshop_address_svr.QshopAddressSvr", "/trpc.ecom.qshop_address_svr.QshopAddressSvr/GetHot", dVar, null, eCDefaultAddressRepository$getHotCity$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() != 0) {
                    cg0.a.a("ECDefaultAddressRepository", "getHotCity", "get hot city network error, errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
                }
                return eCNetworkResponse.b();
            }
        }
        eCDefaultAddressRepository$getHotCity$1 = new ECDefaultAddressRepository$getHotCity$1(this, continuation);
        Object obj2 = eCDefaultAddressRepository$getHotCity$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCDefaultAddressRepository$getHotCity$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() != 0) {
        }
        return eCNetworkResponse.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.ecommerce.biz.orders.address.IECAddressRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object removeAddress(List<Long> list, Continuation<? super Boolean> continuation) {
        ECDefaultAddressRepository$removeAddress$1 eCDefaultAddressRepository$removeAddress$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        long[] longArray;
        if (continuation instanceof ECDefaultAddressRepository$removeAddress$1) {
            eCDefaultAddressRepository$removeAddress$1 = (ECDefaultAddressRepository$removeAddress$1) continuation;
            int i16 = eCDefaultAddressRepository$removeAddress$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCDefaultAddressRepository$removeAddress$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCDefaultAddressRepository$removeAddress$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCDefaultAddressRepository$removeAddress$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    e eVar = new e();
                    eCDefaultAddressRepository$removeAddress$1.L$0 = list;
                    eCDefaultAddressRepository$removeAddress$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.qshop_address_svr.QshopAddressSvr", "/trpc.ecom.qshop_address_svr.QshopAddressSvr/Delete", eVar, list, eCDefaultAddressRepository$removeAddress$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    list = (List) eCDefaultAddressRepository$removeAddress$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() != 0) {
                    return Boxing.boxBoolean(true);
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("remove address list(");
                longArray = CollectionsKt___CollectionsKt.toLongArray(list);
                String arrays = Arrays.toString(longArray);
                Intrinsics.checkNotNullExpressionValue(arrays, "java.util.Arrays.toString(this)");
                sb5.append(arrays);
                sb5.append(") error, errCode:");
                sb5.append(eCNetworkResponse.getCode());
                sb5.append(", errMsg:");
                sb5.append(eCNetworkResponse.getMessage());
                cg0.a.a("ECDefaultAddressRepository", "removeAddress", sb5.toString());
                return Boxing.boxBoolean(false);
            }
        }
        eCDefaultAddressRepository$removeAddress$1 = new ECDefaultAddressRepository$removeAddress$1(this, continuation);
        Object obj2 = eCDefaultAddressRepository$removeAddress$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCDefaultAddressRepository$removeAddress$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.ecommerce.biz.orders.address.IECAddressRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object updateAddress(ECAddress eCAddress, Continuation<? super Boolean> continuation) {
        ECDefaultAddressRepository$updateAddress$1 eCDefaultAddressRepository$updateAddress$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECDefaultAddressRepository$updateAddress$1) {
            eCDefaultAddressRepository$updateAddress$1 = (ECDefaultAddressRepository$updateAddress$1) continuation;
            int i16 = eCDefaultAddressRepository$updateAddress$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCDefaultAddressRepository$updateAddress$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCDefaultAddressRepository$updateAddress$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCDefaultAddressRepository$updateAddress$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    f fVar = new f();
                    eCDefaultAddressRepository$updateAddress$1.L$0 = eCAddress;
                    eCDefaultAddressRepository$updateAddress$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.qshop_address_svr.QshopAddressSvr", "/trpc.ecom.qshop_address_svr.QshopAddressSvr/Update", fVar, eCAddress, eCDefaultAddressRepository$updateAddress$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    eCAddress = (ECAddress) eCDefaultAddressRepository$updateAddress$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() != 0) {
                    return Boxing.boxBoolean(true);
                }
                cg0.a.a("ECDefaultAddressRepository", "updateAddress", "update address(" + eCAddress + ") error, errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
                return Boxing.boxBoolean(false);
            }
        }
        eCDefaultAddressRepository$updateAddress$1 = new ECDefaultAddressRepository$updateAddress$1(this, continuation);
        Object obj2 = eCDefaultAddressRepository$updateAddress$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCDefaultAddressRepository$updateAddress$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    @Override // com.tencent.ecommerce.biz.orders.address.IECAddressRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object addAddress(ECAddress eCAddress, Continuation<? super ECAddress> continuation) {
        ECDefaultAddressRepository$addAddress$1 eCDefaultAddressRepository$addAddress$1;
        Object coroutine_suspended;
        int i3;
        ECAddress eCAddress2;
        ECNetworkResponse eCNetworkResponse;
        ECAddress a16;
        ECAddress eCAddress3 = eCAddress;
        if (continuation instanceof ECDefaultAddressRepository$addAddress$1) {
            eCDefaultAddressRepository$addAddress$1 = (ECDefaultAddressRepository$addAddress$1) continuation;
            int i16 = eCDefaultAddressRepository$addAddress$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCDefaultAddressRepository$addAddress$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCDefaultAddressRepository$addAddress$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCDefaultAddressRepository$addAddress$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    a aVar = new a();
                    eCDefaultAddressRepository$addAddress$1.L$0 = eCAddress3;
                    eCDefaultAddressRepository$addAddress$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.qshop_address_svr.QshopAddressSvr", "/trpc.ecom.qshop_address_svr.QshopAddressSvr/Add", aVar, eCAddress3, eCDefaultAddressRepository$addAddress$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    eCAddress3 = (ECAddress) eCDefaultAddressRepository$addAddress$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCAddress2 = eCAddress3;
                eCNetworkResponse = (ECNetworkResponse) obj;
                Long l3 = (Long) eCNetworkResponse.b();
                if (eCNetworkResponse.getCode() != 0 && l3 != null) {
                    a16 = eCAddress2.a((r26 & 1) != 0 ? eCAddress2.id : l3.longValue(), (r26 & 2) != 0 ? eCAddress2.province : null, (r26 & 4) != 0 ? eCAddress2.city : null, (r26 & 8) != 0 ? eCAddress2.district : null, (r26 & 16) != 0 ? eCAddress2.street : null, (r26 & 32) != 0 ? eCAddress2.detailAddress : null, (r26 & 64) != 0 ? eCAddress2.consignee : null, (r26 & 128) != 0 ? eCAddress2.phoneNumber : null, (r26 & 256) != 0 ? eCAddress2.maskedPhoneNumber : null, (r26 & 512) != 0 ? eCAddress2.isDefaultAddress : false, (r26 & 1024) != 0 ? eCAddress2.label : null);
                    return a16;
                }
                cg0.a.a("ECDefaultAddressRepository", "addAddress", "add address(" + eCAddress2 + ") error, errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
                return null;
            }
        }
        eCDefaultAddressRepository$addAddress$1 = new ECDefaultAddressRepository$addAddress$1(this, continuation);
        Object obj2 = eCDefaultAddressRepository$addAddress$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCDefaultAddressRepository$addAddress$1.label;
        if (i3 != 0) {
        }
        eCAddress2 = eCAddress3;
        eCNetworkResponse = (ECNetworkResponse) obj2;
        Long l36 = (Long) eCNetworkResponse.b();
        if (eCNetworkResponse.getCode() != 0) {
        }
        cg0.a.a("ECDefaultAddressRepository", "addAddress", "add address(" + eCAddress2 + ") error, errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
        return null;
    }
}
