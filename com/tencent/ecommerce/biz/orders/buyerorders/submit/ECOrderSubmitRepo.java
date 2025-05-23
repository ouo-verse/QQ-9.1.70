package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import bi0.ECHREvent;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.IECOrderSubmitRepo;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.AddressCheckResult;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.CalculatePriceScene;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSubmitDetailInfo;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.SimpleSku;
import com.tencent.ecommerce.biz.orders.realname.IECRealNameOperateRepo;
import com.tencent.ecommerce.repo.ServiceLocator;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$BriefYiFanAward;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$ProductCart;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$VirtualAccount;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info.ECOrderInfo$DeviceInfo;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info.ECOrderInfo$Entry;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$CouponInfo;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$OrderPageDetailRsp;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr.ECQshopOrderSvr$CaptchaToken;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr.ECQshopOrderSvr$CommitOrderReq;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr.ECQshopOrderSvr$CommitOrderRsp;
import com.tencent.ecommerce.repo.proto.ecom.real_name_svr.ECRealNameSvr$User;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapWithDefaultKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.json.JSONObject;
import yg0.ECPsKey;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 52\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002JG\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJs\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ)\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\f2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!J\u0091\u0001\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\f2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010(\u001a\u0004\u0018\u00010\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\b\u0010)\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u00152\u0006\u0010,\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b.\u0010/R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u00101\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00066"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitRepo;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/IECOrderSubmitRepo;", "Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_info/ECOrderInfo$DeviceInfo;", "a", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/SimpleSku;", "simpleSku", "", "pageExt", "activityId", "groupId", "", "isBuyAll", "Lcom/tencent/ecommerce/base/network/api/d;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/IECOrderSubmitRepo$b;", "fetchOrderSubmitDetails", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/SimpleSku;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "orderGoodsId", "", "quantity", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/CalculatePriceScene;", "scene", "", "couponIds", "buyAll", "boxOrderIds", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/IECOrderSubmitRepo$a;", "calculateOrderPrice", "(Ljava/lang/String;ILjava/lang/String;Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/CalculatePriceScene;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "spuId", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "address", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/a;", "checkAddressReachable", "(Ljava/lang/String;Lcom/tencent/ecommerce/biz/orders/address/ECAddress;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/f;", "orderDetail", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$OrderPageDetailRsp;", "orderRsp", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_svr/ECQshopOrderSvr$CaptchaToken;", "captchaToken", "adClickId", "boxId", "Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_common/ECOrderCommon$BriefYiFanAward;", "allAward", "aidStr", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_svr/ECQshopOrderSvr$CommitOrderRsp;", "submit", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/f;Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$OrderPageDetailRsp;Lcom/tencent/ecommerce/biz/orders/address/ECAddress;Ljava/lang/String;Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_svr/ECQshopOrderSvr$CaptchaToken;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/biz/orders/realname/IECRealNameOperateRepo;", "Lcom/tencent/ecommerce/biz/orders/realname/IECRealNameOperateRepo;", "realNameRepo", "<init>", "()V", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOrderSubmitRepo implements IECOrderSubmitRepo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final IECRealNameOperateRepo realNameRepo = ServiceLocator.f104891i.p();

    private final ECOrderInfo$DeviceInfo a() {
        Map withDefault;
        Object value;
        Object value2;
        Object value3;
        Object value4;
        Object value5;
        Integer intOrNull;
        Object value6;
        Object value7;
        Object value8;
        Object value9;
        int collectionSizeOrDefault;
        withDefault = MapsKt__MapWithDefaultKt.withDefault(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getRuntime().getDeviceInfo(), new Function1<String, String>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitRepo$getDeviceInfo$deviceInfoMap$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String str) {
                return "";
            }
        });
        ECOrderInfo$DeviceInfo eCOrderInfo$DeviceInfo = new ECOrderInfo$DeviceInfo();
        PBStringField pBStringField = eCOrderInfo$DeviceInfo.app_version;
        value = MapsKt__MapsKt.getValue(withDefault, "app_version");
        pBStringField.set((String) value);
        eCOrderInfo$DeviceInfo.f105240os.set(1);
        PBStringField pBStringField2 = eCOrderInfo$DeviceInfo.device_id;
        value2 = MapsKt__MapsKt.getValue(withDefault, "device_id");
        pBStringField2.set((String) value2);
        PBStringField pBStringField3 = eCOrderInfo$DeviceInfo.qimei;
        value3 = MapsKt__MapsKt.getValue(withDefault, TVKLiveRequestBuilder.RequestParamKey.QIMEI36);
        pBStringField3.set((String) value3);
        PBStringField pBStringField4 = eCOrderInfo$DeviceInfo.qimei36;
        value4 = MapsKt__MapsKt.getValue(withDefault, "qimei36");
        pBStringField4.set((String) value4);
        PBInt32Field pBInt32Field = eCOrderInfo$DeviceInfo.network;
        value5 = MapsKt__MapsKt.getValue(withDefault, "network");
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull((String) value5);
        pBInt32Field.set(intOrNull != null ? intOrNull.intValue() : -1);
        PBStringField pBStringField5 = eCOrderInfo$DeviceInfo.f105239ip;
        value6 = MapsKt__MapsKt.getValue(withDefault, "ip");
        pBStringField5.set((String) value6);
        PBStringField pBStringField6 = eCOrderInfo$DeviceInfo.terminal_id;
        value7 = MapsKt__MapsKt.getValue(withDefault, "imei");
        pBStringField6.set((String) value7);
        eCOrderInfo$DeviceInfo.terminal_type.set("2");
        PBStringField pBStringField7 = eCOrderInfo$DeviceInfo.manufacturer;
        value8 = MapsKt__MapsKt.getValue(withDefault, "manufacturer");
        pBStringField7.set((String) value8);
        PBStringField pBStringField8 = eCOrderInfo$DeviceInfo.device_brand_and_model;
        value9 = MapsKt__MapsKt.getValue(withDefault, "device_brand_and_model");
        pBStringField8.set((String) value9);
        Set<Map.Entry> entrySet = withDefault.entrySet();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(entrySet, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Map.Entry entry : entrySet) {
            ECOrderInfo$Entry eCOrderInfo$Entry = new ECOrderInfo$Entry();
            eCOrderInfo$Entry.key.set((String) entry.getKey());
            eCOrderInfo$Entry.value.set((String) entry.getValue());
            arrayList.add(eCOrderInfo$Entry);
        }
        eCOrderInfo$DeviceInfo.ext.set(arrayList);
        cg0.a.b("ECOrderSubmitRepo", "getDeviceInfo map=" + withDefault);
        return eCOrderInfo$DeviceInfo;
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.IECOrderSubmitRepo
    public Object checkAddressReachable(String str, ECAddress eCAddress, Continuation<? super ECNetworkResponse<AddressCheckResult>> continuation) {
        return com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.qshop_logistics_template_svr.QshopLogisticsTemplateTrpc", "/trpc.ecom.qshop_logistics_template_svr.QshopLogisticsTemplateTrpc/CheckShipStatus", new e(), new Pair(str, eCAddress), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x025e A[PHI: r3
  0x025e: PHI (r3v15 java.lang.Object) = (r3v11 java.lang.Object), (r3v1 java.lang.Object) binds: [B:49:0x025b, B:10:0x0030] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x025d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.IECOrderSubmitRepo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object submit(OrderSubmitDetailInfo orderSubmitDetailInfo, ECQshopOrderQuerySvr$OrderPageDetailRsp eCQshopOrderQuerySvr$OrderPageDetailRsp, ECAddress eCAddress, String str, ECQshopOrderSvr$CaptchaToken eCQshopOrderSvr$CaptchaToken, String str2, String str3, List<String> list, String str4, Boolean bool, List<ECOrderCommon$BriefYiFanAward> list2, String str5, Continuation<? super ECNetworkResponse<ECQshopOrderSvr$CommitOrderRsp>> continuation) {
        ECOrderSubmitRepo$submit$1 eCOrderSubmitRepo$submit$1;
        Object coroutine_suspended;
        int i3;
        String str6;
        ECQshopOrderSvr$CaptchaToken eCQshopOrderSvr$CaptchaToken2;
        String str7;
        String str8;
        List<String> list3;
        String str9;
        Boolean bool2;
        List<ECOrderCommon$BriefYiFanAward> list4;
        Object obj;
        ECAddress eCAddress2;
        String str10;
        ECOrderCommon$ProductCart eCOrderCommon$ProductCart;
        ECOrderSubmitRepo eCOrderSubmitRepo;
        Object firstOrNull;
        ECPsKey eCPsKey;
        ECQshopOrderSvr$CommitOrderReq eCQshopOrderSvr$CommitOrderReq;
        ECOrderCommon$VirtualAccount c16;
        ECRealNameSvr$User b16;
        ECQshopOrderQuerySvr$CouponInfo eCQshopOrderQuerySvr$CouponInfo;
        List<String> a16;
        OrderSubmitDetailInfo orderSubmitDetailInfo2 = orderSubmitDetailInfo;
        ECQshopOrderQuerySvr$OrderPageDetailRsp eCQshopOrderQuerySvr$OrderPageDetailRsp2 = eCQshopOrderQuerySvr$OrderPageDetailRsp;
        if (continuation instanceof ECOrderSubmitRepo$submit$1) {
            eCOrderSubmitRepo$submit$1 = (ECOrderSubmitRepo$submit$1) continuation;
            int i16 = eCOrderSubmitRepo$submit$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCOrderSubmitRepo$submit$1.label = i16 - Integer.MIN_VALUE;
                Object obj2 = eCOrderSubmitRepo$submit$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCOrderSubmitRepo$submit$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    ECOrderCommon$ProductCart mergeFrom = new ECOrderCommon$ProductCart().mergeFrom(eCQshopOrderQuerySvr$OrderPageDetailRsp2.product_cart.toByteArray());
                    mergeFrom.sku_num.set(orderSubmitDetailInfo2.orderSkusDetail.quantity);
                    eCOrderSubmitRepo$submit$1.L$0 = this;
                    eCOrderSubmitRepo$submit$1.L$1 = orderSubmitDetailInfo2;
                    eCOrderSubmitRepo$submit$1.L$2 = eCQshopOrderQuerySvr$OrderPageDetailRsp2;
                    eCOrderSubmitRepo$submit$1.L$3 = eCAddress;
                    str6 = str;
                    eCOrderSubmitRepo$submit$1.L$4 = str6;
                    eCQshopOrderSvr$CaptchaToken2 = eCQshopOrderSvr$CaptchaToken;
                    eCOrderSubmitRepo$submit$1.L$5 = eCQshopOrderSvr$CaptchaToken2;
                    str7 = str2;
                    eCOrderSubmitRepo$submit$1.L$6 = str7;
                    str8 = str3;
                    eCOrderSubmitRepo$submit$1.L$7 = str8;
                    list3 = list;
                    eCOrderSubmitRepo$submit$1.L$8 = list3;
                    str9 = str4;
                    eCOrderSubmitRepo$submit$1.L$9 = str9;
                    bool2 = bool;
                    eCOrderSubmitRepo$submit$1.L$10 = bool2;
                    eCOrderSubmitRepo$submit$1.L$11 = list2;
                    eCOrderSubmitRepo$submit$1.L$12 = str5;
                    eCOrderSubmitRepo$submit$1.L$13 = mergeFrom;
                    eCOrderSubmitRepo$submit$1.label = 1;
                    Object c17 = zg0.a.f452502b.c(new String[]{"kandian.qq.com"}, eCOrderSubmitRepo$submit$1);
                    if (c17 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    list4 = list2;
                    obj = c17;
                    eCAddress2 = eCAddress;
                    str10 = str5;
                    eCOrderCommon$ProductCart = mergeFrom;
                    eCOrderSubmitRepo = this;
                } else {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj2);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ECOrderCommon$ProductCart eCOrderCommon$ProductCart2 = (ECOrderCommon$ProductCart) eCOrderSubmitRepo$submit$1.L$13;
                    String str11 = (String) eCOrderSubmitRepo$submit$1.L$12;
                    list4 = (List) eCOrderSubmitRepo$submit$1.L$11;
                    Boolean bool3 = (Boolean) eCOrderSubmitRepo$submit$1.L$10;
                    String str12 = (String) eCOrderSubmitRepo$submit$1.L$9;
                    List<String> list5 = (List) eCOrderSubmitRepo$submit$1.L$8;
                    str8 = (String) eCOrderSubmitRepo$submit$1.L$7;
                    String str13 = (String) eCOrderSubmitRepo$submit$1.L$6;
                    ECQshopOrderSvr$CaptchaToken eCQshopOrderSvr$CaptchaToken3 = (ECQshopOrderSvr$CaptchaToken) eCOrderSubmitRepo$submit$1.L$5;
                    String str14 = (String) eCOrderSubmitRepo$submit$1.L$4;
                    eCAddress2 = (ECAddress) eCOrderSubmitRepo$submit$1.L$3;
                    ECQshopOrderQuerySvr$OrderPageDetailRsp eCQshopOrderQuerySvr$OrderPageDetailRsp3 = (ECQshopOrderQuerySvr$OrderPageDetailRsp) eCOrderSubmitRepo$submit$1.L$2;
                    OrderSubmitDetailInfo orderSubmitDetailInfo3 = (OrderSubmitDetailInfo) eCOrderSubmitRepo$submit$1.L$1;
                    ECOrderSubmitRepo eCOrderSubmitRepo2 = (ECOrderSubmitRepo) eCOrderSubmitRepo$submit$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    str10 = str11;
                    obj = obj2;
                    eCQshopOrderQuerySvr$OrderPageDetailRsp2 = eCQshopOrderQuerySvr$OrderPageDetailRsp3;
                    eCOrderCommon$ProductCart = eCOrderCommon$ProductCart2;
                    eCOrderSubmitRepo = eCOrderSubmitRepo2;
                    orderSubmitDetailInfo2 = orderSubmitDetailInfo3;
                    bool2 = bool3;
                    str6 = str14;
                    str9 = str12;
                    eCQshopOrderSvr$CaptchaToken2 = eCQshopOrderSvr$CaptchaToken3;
                    list3 = list5;
                    str7 = str13;
                }
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) obj);
                eCPsKey = (ECPsKey) firstOrNull;
                if (eCPsKey != null || (r16 = eCPsKey.getValue()) == null) {
                    String str15 = "";
                }
                String str16 = str15;
                ECOrderSubmitRepo$submit$1 eCOrderSubmitRepo$submit$12 = eCOrderSubmitRepo$submit$1;
                StringBuilder sb5 = new StringBuilder();
                String str17 = str10;
                sb5.append("submit order psKey: ");
                sb5.append(str16);
                cg0.a.b("ECOrderSubmitRepo", sb5.toString());
                eCQshopOrderSvr$CommitOrderReq = new ECQshopOrderSvr$CommitOrderReq();
                eCQshopOrderSvr$CommitOrderReq.product_cart.set(eCOrderCommon$ProductCart);
                eCQshopOrderSvr$CommitOrderReq.enable_coupon.set(eCQshopOrderQuerySvr$OrderPageDetailRsp2.enable_coupon.get());
                eCQshopOrderSvr$CommitOrderReq.free_shipping.set(eCQshopOrderQuerySvr$OrderPageDetailRsp2.free_shipping.get());
                eCQshopOrderSvr$CommitOrderReq.shipping_cost.set(eCQshopOrderQuerySvr$OrderPageDetailRsp2.shipping_cost.get());
                eCQshopOrderSvr$CommitOrderReq.shop_info.set(eCQshopOrderQuerySvr$OrderPageDetailRsp2.shop_info);
                eCQshopOrderSvr$CommitOrderReq.token.set(eCQshopOrderQuerySvr$OrderPageDetailRsp2.token.get());
                eCQshopOrderSvr$CommitOrderReq.order_id.set(eCQshopOrderQuerySvr$OrderPageDetailRsp2.order_id.get());
                String str18 = str6;
                eCQshopOrderSvr$CommitOrderReq.order_price.set(orderSubmitDetailInfo2.priceInfo.totalPrice);
                eCQshopOrderSvr$CommitOrderReq.pay_type.set(orderSubmitDetailInfo2.selectedPayType.id);
                eCQshopOrderSvr$CommitOrderReq.remarks.set(orderSubmitDetailInfo2.orderSkusDetail.note);
                eCQshopOrderSvr$CommitOrderReq.device_info.set(eCOrderSubmitRepo.a());
                eCQshopOrderSvr$CommitOrderReq.ori_price.set(orderSubmitDetailInfo2.orderSkusDetail.originUnitPrice);
                if (eCAddress2 != null) {
                    eCQshopOrderSvr$CommitOrderReq.address_info.set(com.tencent.ecommerce.biz.orders.address.b.e(eCAddress2));
                }
                c16 = pj0.a.c(orderSubmitDetailInfo2.orderSkusDetail.productType);
                if (c16 != null) {
                    eCQshopOrderSvr$CommitOrderReq.virtual_account.set(c16);
                }
                b16 = pj0.a.b(orderSubmitDetailInfo2.orderSkusDetail.productType);
                if (b16 != null) {
                    eCQshopOrderSvr$CommitOrderReq.user.set(b16);
                }
                eCQshopOrderQuerySvr$CouponInfo = orderSubmitDetailInfo2.couponInfo;
                if (eCQshopOrderQuerySvr$CouponInfo != null && (a16 = com.tencent.ecommerce.biz.orders.buyerorders.submit.model.g.a(eCQshopOrderQuerySvr$CouponInfo)) != null) {
                    eCQshopOrderSvr$CommitOrderReq.coupon_ids.set(a16);
                }
                if (str7 != null) {
                    eCQshopOrderSvr$CommitOrderReq.active_id.set(str7);
                }
                if (str8 != null) {
                    eCQshopOrderSvr$CommitOrderReq.click_id.set(str8);
                }
                eCQshopOrderSvr$CommitOrderReq.box_order_ids.set(list3);
                eCQshopOrderSvr$CommitOrderReq.auth.set(str16);
                if (str9 != null) {
                    eCQshopOrderSvr$CommitOrderReq.group_id.set(str9);
                }
                if (bool2 != null) {
                    eCQshopOrderSvr$CommitOrderReq.buy_all.set(bool2.booleanValue());
                }
                if (!list4.isEmpty()) {
                    eCQshopOrderSvr$CommitOrderReq.buy_all_awards.set(list4);
                }
                if (eCQshopOrderSvr$CaptchaToken2 != null) {
                    eCQshopOrderSvr$CommitOrderReq.captcha_token.set(eCQshopOrderSvr$CaptchaToken2);
                }
                s sVar = new s(str18, str17, str7);
                eCOrderSubmitRepo$submit$12.L$0 = null;
                eCOrderSubmitRepo$submit$12.L$1 = null;
                eCOrderSubmitRepo$submit$12.L$2 = null;
                eCOrderSubmitRepo$submit$12.L$3 = null;
                eCOrderSubmitRepo$submit$12.L$4 = null;
                eCOrderSubmitRepo$submit$12.L$5 = null;
                eCOrderSubmitRepo$submit$12.L$6 = null;
                eCOrderSubmitRepo$submit$12.L$7 = null;
                eCOrderSubmitRepo$submit$12.L$8 = null;
                eCOrderSubmitRepo$submit$12.L$9 = null;
                eCOrderSubmitRepo$submit$12.L$10 = null;
                eCOrderSubmitRepo$submit$12.L$11 = null;
                eCOrderSubmitRepo$submit$12.L$12 = null;
                eCOrderSubmitRepo$submit$12.L$13 = null;
                eCOrderSubmitRepo$submit$12.label = 2;
                obj2 = com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.qshop_order_svr.QshopOrderSvr", "/trpc.ecom.qshop_order_svr.QshopOrderSvr/CommitOrder", sVar, eCQshopOrderSvr$CommitOrderReq, eCOrderSubmitRepo$submit$12);
                return obj2 != coroutine_suspended ? coroutine_suspended : obj2;
            }
        }
        eCOrderSubmitRepo$submit$1 = new ECOrderSubmitRepo$submit$1(this, continuation);
        Object obj22 = eCOrderSubmitRepo$submit$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCOrderSubmitRepo$submit$1.label;
        if (i3 != 0) {
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) obj);
        eCPsKey = (ECPsKey) firstOrNull;
        if (eCPsKey != null) {
        }
        String str152 = "";
        String str162 = str152;
        ECOrderSubmitRepo$submit$1 eCOrderSubmitRepo$submit$122 = eCOrderSubmitRepo$submit$1;
        StringBuilder sb52 = new StringBuilder();
        String str172 = str10;
        sb52.append("submit order psKey: ");
        sb52.append(str162);
        cg0.a.b("ECOrderSubmitRepo", sb52.toString());
        eCQshopOrderSvr$CommitOrderReq = new ECQshopOrderSvr$CommitOrderReq();
        eCQshopOrderSvr$CommitOrderReq.product_cart.set(eCOrderCommon$ProductCart);
        eCQshopOrderSvr$CommitOrderReq.enable_coupon.set(eCQshopOrderQuerySvr$OrderPageDetailRsp2.enable_coupon.get());
        eCQshopOrderSvr$CommitOrderReq.free_shipping.set(eCQshopOrderQuerySvr$OrderPageDetailRsp2.free_shipping.get());
        eCQshopOrderSvr$CommitOrderReq.shipping_cost.set(eCQshopOrderQuerySvr$OrderPageDetailRsp2.shipping_cost.get());
        eCQshopOrderSvr$CommitOrderReq.shop_info.set(eCQshopOrderQuerySvr$OrderPageDetailRsp2.shop_info);
        eCQshopOrderSvr$CommitOrderReq.token.set(eCQshopOrderQuerySvr$OrderPageDetailRsp2.token.get());
        eCQshopOrderSvr$CommitOrderReq.order_id.set(eCQshopOrderQuerySvr$OrderPageDetailRsp2.order_id.get());
        String str182 = str6;
        eCQshopOrderSvr$CommitOrderReq.order_price.set(orderSubmitDetailInfo2.priceInfo.totalPrice);
        eCQshopOrderSvr$CommitOrderReq.pay_type.set(orderSubmitDetailInfo2.selectedPayType.id);
        eCQshopOrderSvr$CommitOrderReq.remarks.set(orderSubmitDetailInfo2.orderSkusDetail.note);
        eCQshopOrderSvr$CommitOrderReq.device_info.set(eCOrderSubmitRepo.a());
        eCQshopOrderSvr$CommitOrderReq.ori_price.set(orderSubmitDetailInfo2.orderSkusDetail.originUnitPrice);
        if (eCAddress2 != null) {
        }
        c16 = pj0.a.c(orderSubmitDetailInfo2.orderSkusDetail.productType);
        if (c16 != null) {
        }
        b16 = pj0.a.b(orderSubmitDetailInfo2.orderSkusDetail.productType);
        if (b16 != null) {
        }
        eCQshopOrderQuerySvr$CouponInfo = orderSubmitDetailInfo2.couponInfo;
        if (eCQshopOrderQuerySvr$CouponInfo != null) {
            eCQshopOrderSvr$CommitOrderReq.coupon_ids.set(a16);
        }
        if (str7 != null) {
        }
        if (str8 != null) {
        }
        eCQshopOrderSvr$CommitOrderReq.box_order_ids.set(list3);
        eCQshopOrderSvr$CommitOrderReq.auth.set(str162);
        if (str9 != null) {
        }
        if (bool2 != null) {
        }
        if (!list4.isEmpty()) {
        }
        if (eCQshopOrderSvr$CaptchaToken2 != null) {
        }
        s sVar2 = new s(str182, str172, str7);
        eCOrderSubmitRepo$submit$122.L$0 = null;
        eCOrderSubmitRepo$submit$122.L$1 = null;
        eCOrderSubmitRepo$submit$122.L$2 = null;
        eCOrderSubmitRepo$submit$122.L$3 = null;
        eCOrderSubmitRepo$submit$122.L$4 = null;
        eCOrderSubmitRepo$submit$122.L$5 = null;
        eCOrderSubmitRepo$submit$122.L$6 = null;
        eCOrderSubmitRepo$submit$122.L$7 = null;
        eCOrderSubmitRepo$submit$122.L$8 = null;
        eCOrderSubmitRepo$submit$122.L$9 = null;
        eCOrderSubmitRepo$submit$122.L$10 = null;
        eCOrderSubmitRepo$submit$122.L$11 = null;
        eCOrderSubmitRepo$submit$122.L$12 = null;
        eCOrderSubmitRepo$submit$122.L$13 = null;
        eCOrderSubmitRepo$submit$122.label = 2;
        obj22 = com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.qshop_order_svr.QshopOrderSvr", "/trpc.ecom.qshop_order_svr.QshopOrderSvr/CommitOrder", sVar2, eCQshopOrderSvr$CommitOrderReq, eCOrderSubmitRepo$submit$122);
        if (obj22 != coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.IECOrderSubmitRepo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object calculateOrderPrice(String str, int i3, String str2, CalculatePriceScene calculatePriceScene, List<String> list, String str3, String str4, Boolean bool, List<String> list2, Continuation<? super ECNetworkResponse<IECOrderSubmitRepo.CalculateOrderPriceResult>> continuation) {
        ECOrderSubmitRepo$calculateOrderPrice$1 eCOrderSubmitRepo$calculateOrderPrice$1;
        Object coroutine_suspended;
        int i16;
        if (continuation instanceof ECOrderSubmitRepo$calculateOrderPrice$1) {
            eCOrderSubmitRepo$calculateOrderPrice$1 = (ECOrderSubmitRepo$calculateOrderPrice$1) continuation;
            int i17 = eCOrderSubmitRepo$calculateOrderPrice$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                eCOrderSubmitRepo$calculateOrderPrice$1.label = i17 - Integer.MIN_VALUE;
                Object obj = eCOrderSubmitRepo$calculateOrderPrice$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = eCOrderSubmitRepo$calculateOrderPrice$1.label;
                if (i16 != 0) {
                    ResultKt.throwOnFailure(obj);
                    d dVar = new d(str2, a(), calculatePriceScene, list, str3, str4, bool, list2);
                    SimpleSku simpleSku = new SimpleSku(str, i3);
                    eCOrderSubmitRepo$calculateOrderPrice$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.qshop_order_query_svr.QshopOrderQuerySvr", "/trpc.ecom.qshop_order_query_svr.QshopOrderQuerySvr/CalculateOrderPrice", dVar, simpleSku, eCOrderSubmitRepo$calculateOrderPrice$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i16 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ECNetworkResponse eCNetworkResponse = (ECNetworkResponse) obj;
                LifecycleEventBus.f100688b.f(new ECHREvent("select_coupon_info_cached_updated", new JSONObject()));
                return eCNetworkResponse;
            }
        }
        eCOrderSubmitRepo$calculateOrderPrice$1 = new ECOrderSubmitRepo$calculateOrderPrice$1(this, continuation);
        Object obj2 = eCOrderSubmitRepo$calculateOrderPrice$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = eCOrderSubmitRepo$calculateOrderPrice$1.label;
        if (i16 != 0) {
        }
        ECNetworkResponse eCNetworkResponse2 = (ECNetworkResponse) obj2;
        LifecycleEventBus.f100688b.f(new ECHREvent("select_coupon_info_cached_updated", new JSONObject()));
        return eCNetworkResponse2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.IECOrderSubmitRepo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object fetchOrderSubmitDetails(SimpleSku simpleSku, String str, String str2, String str3, Boolean bool, Continuation<? super ECNetworkResponse<IECOrderSubmitRepo.OrderSubmitDetailWrapper>> continuation) {
        ECOrderSubmitRepo$fetchOrderSubmitDetails$1 eCOrderSubmitRepo$fetchOrderSubmitDetails$1;
        Object coroutine_suspended;
        int i3;
        ECOrderSubmitRepo eCOrderSubmitRepo;
        ECNetworkResponse eCNetworkResponse;
        Boolean boxBoolean;
        if (continuation instanceof ECOrderSubmitRepo$fetchOrderSubmitDetails$1) {
            eCOrderSubmitRepo$fetchOrderSubmitDetails$1 = (ECOrderSubmitRepo$fetchOrderSubmitDetails$1) continuation;
            int i16 = eCOrderSubmitRepo$fetchOrderSubmitDetails$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCOrderSubmitRepo$fetchOrderSubmitDetails$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCOrderSubmitRepo$fetchOrderSubmitDetails$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCOrderSubmitRepo$fetchOrderSubmitDetails$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    n nVar = new n(str, a(), str2, str3, bool);
                    eCOrderSubmitRepo$fetchOrderSubmitDetails$1.L$0 = this;
                    eCOrderSubmitRepo$fetchOrderSubmitDetails$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.qshop_order_query_svr.QshopOrderQuerySvr", "/trpc.ecom.qshop_order_query_svr.QshopOrderQuerySvr/OrderPageDetail", nVar, simpleSku, eCOrderSubmitRepo$fetchOrderSubmitDetails$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCOrderSubmitRepo = this;
                } else if (i3 == 1) {
                    eCOrderSubmitRepo = (ECOrderSubmitRepo) eCOrderSubmitRepo$fetchOrderSubmitDetails$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() == 0) {
                    IECRealNameOperateRepo iECRealNameOperateRepo = eCOrderSubmitRepo.realNameRepo;
                    IECOrderSubmitRepo.OrderSubmitDetailWrapper orderSubmitDetailWrapper = (IECOrderSubmitRepo.OrderSubmitDetailWrapper) eCNetworkResponse.b();
                    iECRealNameOperateRepo.updateReadNameAccountFlag((orderSubmitDetailWrapper == null || (boxBoolean = Boxing.boxBoolean(orderSubmitDetailWrapper.originRsp.has_real_name_list.get())) == null) ? false : boxBoolean.booleanValue());
                }
                LifecycleEventBus.f100688b.f(new ECHREvent("select_coupon_info_cached_updated", new JSONObject()));
                return eCNetworkResponse;
            }
        }
        eCOrderSubmitRepo$fetchOrderSubmitDetails$1 = new ECOrderSubmitRepo$fetchOrderSubmitDetails$1(this, continuation);
        Object obj2 = eCOrderSubmitRepo$fetchOrderSubmitDetails$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCOrderSubmitRepo$fetchOrderSubmitDetails$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() == 0) {
        }
        LifecycleEventBus.f100688b.f(new ECHREvent("select_coupon_info_cached_updated", new JSONObject()));
        return eCNetworkResponse;
    }
}
