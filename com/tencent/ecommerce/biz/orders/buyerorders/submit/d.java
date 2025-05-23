package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import com.tencent.ecommerce.base.network.api.IECNetworkPBContracts;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.IECOrderSubmitRepo;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.CalculatePriceScene;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSubmitPriceInfo;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.SimpleSku;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info.ECOrderInfo$DeviceInfo;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$CalculateOrderPriceReq;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$CalculateOrderPriceRsp;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$CouponInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BY\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u0017\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\r\u0012\b\u0010 \u001a\u0004\u0018\u00010\r\u0012\b\u0010$\u001a\u0004\u0018\u00010!\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\r0\u0017\u00a2\u0006\u0004\b(\u0010)J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0016R\u0014\u0010\u000f\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u000eR\u0016\u0010 \u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u000eR\u0016\u0010$\u001a\u0004\u0018\u00010!8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\r0\u00178\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u0019\u001a\u0004\b&\u0010\u001b\u00a8\u0006*"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/d;", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/SimpleSku;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/IECOrderSubmitRepo$a;", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "", "b", "rsp", "a", "", "Ljava/lang/String;", "pageExt", "Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_info/ECOrderInfo$DeviceInfo;", "Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_info/ECOrderInfo$DeviceInfo;", "deviceInfo", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/CalculatePriceScene;", "c", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/CalculatePriceScene;", "scene", "", "d", "Ljava/util/List;", "getCouponIds", "()Ljava/util/List;", "couponIds", "e", "activityId", "f", "groupId", "", "g", "Ljava/lang/Boolean;", "buyAll", tl.h.F, "getBoxOrderIds", "boxOrderIds", "<init>", "(Ljava/lang/String;Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_info/ECOrderInfo$DeviceInfo;Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/CalculatePriceScene;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class d implements IECNetworkPBContracts<SimpleSku, IECOrderSubmitRepo.CalculateOrderPriceResult> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String pageExt;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final ECOrderInfo$DeviceInfo deviceInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final CalculatePriceScene scene;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<String> couponIds;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final String activityId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final String groupId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Boolean buyAll;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final List<String> boxOrderIds;

    public d(String str, ECOrderInfo$DeviceInfo eCOrderInfo$DeviceInfo, CalculatePriceScene calculatePriceScene, List<String> list, String str2, String str3, Boolean bool, List<String> list2) {
        this.pageExt = str;
        this.deviceInfo = eCOrderInfo$DeviceInfo;
        this.scene = calculatePriceScene;
        this.couponIds = list;
        this.activityId = str2;
        this.groupId = str3;
        this.buyAll = bool;
        this.boxOrderIds = list2;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public IECOrderSubmitRepo.CalculateOrderPriceResult decodeResponse(byte[] rsp) {
        ECQshopOrderQuerySvr$CalculateOrderPriceRsp mergeFrom = new ECQshopOrderQuerySvr$CalculateOrderPriceRsp().mergeFrom(rsp);
        ECQshopOrderQuerySvr$CouponInfo eCQshopOrderQuerySvr$CouponInfo = mergeFrom.coupon_info.has() ? mergeFrom.coupon_info.get() : null;
        int i3 = mergeFrom.sku_num.get();
        OrderSubmitPriceInfo orderSubmitPriceInfo = new OrderSubmitPriceInfo(mergeFrom.order_price.get(), mergeFrom.discount.get());
        int i16 = mergeFrom.sku_buy_num_limit.buy_num_limit.get();
        boolean z16 = mergeFrom.sku_buy_num_limit.exceed_limit.get();
        String str = mergeFrom.sku_buy_num_limit.excceed_limit_msg.get();
        long j3 = mergeFrom.ori_price.get();
        ii0.a.a(eCQshopOrderQuerySvr$CouponInfo);
        Unit unit = Unit.INSTANCE;
        return new IECOrderSubmitRepo.CalculateOrderPriceResult(i3, orderSubmitPriceInfo, i16, z16, str, j3, eCQshopOrderQuerySvr$CouponInfo);
    }

    @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public byte[] encodeRequestParams(SimpleSku params, int channel, JSONObject reqExt) {
        ECQshopOrderQuerySvr$CalculateOrderPriceReq eCQshopOrderQuerySvr$CalculateOrderPriceReq = new ECQshopOrderQuerySvr$CalculateOrderPriceReq();
        eCQshopOrderQuerySvr$CalculateOrderPriceReq.sku_id.set(params.skuId);
        eCQshopOrderQuerySvr$CalculateOrderPriceReq.sku_num.set(params.getQuantity());
        eCQshopOrderQuerySvr$CalculateOrderPriceReq.req_ext.set(this.pageExt);
        eCQshopOrderQuerySvr$CalculateOrderPriceReq.device_info.set(this.deviceInfo);
        eCQshopOrderQuerySvr$CalculateOrderPriceReq.coupon_ids.set(this.couponIds);
        eCQshopOrderQuerySvr$CalculateOrderPriceReq.operation.set(this.scene.value);
        String str = this.activityId;
        if (str != null) {
            eCQshopOrderQuerySvr$CalculateOrderPriceReq.active_id.set(str);
        }
        String str2 = this.groupId;
        if (str2 != null) {
            eCQshopOrderQuerySvr$CalculateOrderPriceReq.group_id.set(str2);
        }
        Boolean bool = this.buyAll;
        if (bool != null) {
            bool.booleanValue();
            eCQshopOrderQuerySvr$CalculateOrderPriceReq.buy_all.set(this.buyAll.booleanValue());
        }
        eCQshopOrderQuerySvr$CalculateOrderPriceReq.box_order_ids.set(this.boxOrderIds);
        return eCQshopOrderQuerySvr$CalculateOrderPriceReq.toByteArray();
    }
}
