package com.tencent.ecommerce.biz.customerservice;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.network.api.IECNetworkPBContracts;
import com.tencent.ecommerce.biz.customerservice.IECCustomerServiceRepo;
import com.tencent.ecommerce.repo.proto.ecom.qshop_customer_reader_svr.ECQshopCustomerReaderSvr$BlockInfo;
import com.tencent.ecommerce.repo.proto.ecom.qshop_customer_reader_svr.ECQshopCustomerReaderSvr$GetLinkURLReq;
import com.tencent.ecommerce.repo.proto.ecom.qshop_customer_reader_svr.ECQshopCustomerReaderSvr$GetLinkURLRsp;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/ecommerce/biz/customerservice/IECCustomerServiceRepo$a;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.customerservice.ECCustomerServiceRepo$fetchCustomerServiceInfo$2", f = "ECCustomerServiceRepo.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
final class ECCustomerServiceRepo$fetchCustomerServiceInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IECCustomerServiceRepo.CustomerServiceResult>, Object> {
    final /* synthetic */ String $orderId;
    final /* synthetic */ CustomerServiceScene $scene;
    final /* synthetic */ String $shopId;
    final /* synthetic */ String $spuId;
    int label;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/customerservice/ECCustomerServiceRepo$fetchCustomerServiceInfo$2$a", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_customer_reader_svr/ECQshopCustomerReaderSvr$GetLinkURLReq;", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_customer_reader_svr/ECQshopCustomerReaderSvr$GetLinkURLRsp;", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "", "b", "rsp", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements IECNetworkPBContracts<ECQshopCustomerReaderSvr$GetLinkURLReq, ECQshopCustomerReaderSvr$GetLinkURLRsp> {
        a() {
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ECQshopCustomerReaderSvr$GetLinkURLRsp decodeResponse(byte[] rsp) {
            return new ECQshopCustomerReaderSvr$GetLinkURLRsp().mergeFrom(rsp);
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] encodeRequestParams(ECQshopCustomerReaderSvr$GetLinkURLReq params, int channel, JSONObject reqExt) {
            return params.toByteArray();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECCustomerServiceRepo$fetchCustomerServiceInfo$2(CustomerServiceScene customerServiceScene, String str, String str2, String str3, Continuation continuation) {
        super(2, continuation);
        this.$scene = customerServiceScene;
        this.$shopId = str;
        this.$spuId = str2;
        this.$orderId = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECCustomerServiceRepo$fetchCustomerServiceInfo$2(this.$scene, this.$shopId, this.$spuId, this.$orderId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super IECCustomerServiceRepo.CustomerServiceResult> continuation) {
        return ((ECCustomerServiceRepo$fetchCustomerServiceInfo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Map emptyMap;
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ECQshopCustomerReaderSvr$GetLinkURLReq eCQshopCustomerReaderSvr$GetLinkURLReq = new ECQshopCustomerReaderSvr$GetLinkURLReq();
            eCQshopCustomerReaderSvr$GetLinkURLReq.scene.set(this.$scene.ordinal());
            eCQshopCustomerReaderSvr$GetLinkURLReq.shop_id.set(this.$shopId);
            eCQshopCustomerReaderSvr$GetLinkURLReq.spu_id.set(this.$spuId);
            eCQshopCustomerReaderSvr$GetLinkURLReq.order_id.set(this.$orderId);
            eCQshopCustomerReaderSvr$GetLinkURLReq.dark_mode.set(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getNightManager().isNightMode());
            a aVar = new a();
            this.label = 1;
            obj = com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.qshop_customer_reader_svr.QshopCustomerReaderSvr", "/trpc.ecom.qshop_customer_reader_svr.QshopCustomerReaderSvr/GetLinkURL", aVar, eCQshopCustomerReaderSvr$GetLinkURLReq, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ECNetworkResponse eCNetworkResponse = (ECNetworkResponse) obj;
        int code = eCNetworkResponse.getCode();
        String message = eCNetworkResponse.getMessage();
        ECQshopCustomerReaderSvr$GetLinkURLRsp eCQshopCustomerReaderSvr$GetLinkURLRsp = (ECQshopCustomerReaderSvr$GetLinkURLRsp) eCNetworkResponse.b();
        cg0.a.b("ECCustomerServiceRepo", "fetchCustomerServiceUrl rsp, code=" + code + ", msg=" + message);
        if (code != 0 || eCQshopCustomerReaderSvr$GetLinkURLRsp == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return new IECCustomerServiceRepo.CustomerServiceResult(code, message, "", emptyMap);
        }
        String str = eCQshopCustomerReaderSvr$GetLinkURLRsp.chat_url.get();
        cg0.a.b("ECCustomerServiceRepo", "fetchOrderDetail rsp, url = " + str);
        List<ECQshopCustomerReaderSvr$BlockInfo> list = eCQshopCustomerReaderSvr$GetLinkURLRsp.block_info.get();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        List<ECQshopCustomerReaderSvr$BlockInfo> list2 = list;
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((ECQshopCustomerReaderSvr$BlockInfo) it.next()).scheme_params_key.get());
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (ECQshopCustomerReaderSvr$BlockInfo eCQshopCustomerReaderSvr$BlockInfo : list2) {
            Pair pair = TuplesKt.to(eCQshopCustomerReaderSvr$BlockInfo.block_url.get(), new IECCustomerServiceRepo.UrlOverrideInfo(eCQshopCustomerReaderSvr$BlockInfo.scheme.get(), eCQshopCustomerReaderSvr$BlockInfo.scheme_params_key.get()).a());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return new IECCustomerServiceRepo.CustomerServiceResult(0, "", str, linkedHashMap);
    }
}
