package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import com.tencent.ecommerce.base.network.api.IECNetworkPBContracts;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.IECOrderSubmitRepo;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSkuDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSubmitDetailInfo;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSubmitPriceInfo;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.PayType;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.SimpleSku;
import com.tencent.ecommerce.biz.orders.common.BulletinInfo;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info.ECOrderInfo$DeviceInfo;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$CouponInfo;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$OrderPageDetailReq;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$OrderPageDetailRsp;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\b\u0002\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB5\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0016R\u0014\u0010\u000f\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0016\u0010\u0016\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000eR\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/n;", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/SimpleSku;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/IECOrderSubmitRepo$b;", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "", "b", "rsp", "a", "", "Ljava/lang/String;", "pageExt", "Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_info/ECOrderInfo$DeviceInfo;", "Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_info/ECOrderInfo$DeviceInfo;", "deviceInfo", "c", "activityId", "d", "boxId", "", "e", "Ljava/lang/Boolean;", "isBuyAll", "()Ljava/lang/Boolean;", "<init>", "(Ljava/lang/String;Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_info/ECOrderInfo$DeviceInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "f", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class n implements IECNetworkPBContracts<SimpleSku, IECOrderSubmitRepo.OrderSubmitDetailWrapper> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String pageExt;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final ECOrderInfo$DeviceInfo deviceInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final String activityId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final String boxId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Boolean isBuyAll;

    public n(String str, ECOrderInfo$DeviceInfo eCOrderInfo$DeviceInfo, String str2, String str3, Boolean bool) {
        this.pageExt = str;
        this.deviceInfo = eCOrderInfo$DeviceInfo;
        this.activityId = str2;
        this.boxId = str3;
        this.isBuyAll = bool;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x00d9, code lost:
    
        if (r1 != null) goto L21;
     */
    @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IECOrderSubmitRepo.OrderSubmitDetailWrapper decodeResponse(byte[] rsp) {
        List emptyList;
        PayType payType;
        Integer num;
        ECQshopOrderQuerySvr$OrderPageDetailRsp mergeFrom = new ECQshopOrderQuerySvr$OrderPageDetailRsp().mergeFrom(rsp);
        OrderSkuDetail a16 = OrderSkuDetail.INSTANCE.a(mergeFrom.product_cart.get(), mergeFrom.shop_info.get(), mergeFrom.free_shipping.get(), mergeFrom.shipping_cost.get(), mergeFrom.ori_price.get(), mergeFrom.sku_buy_num_limit.buy_num_limit.get(), mergeFrom.sku_buy_num_limit.min_buy_num.get(), pj0.a.d(mergeFrom.product_cart.order_sku.spu.trade_info.get()));
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        boolean z16 = mergeFrom.show_bulletin.get();
        BulletinInfo bulletinInfo = z16 ? new BulletinInfo(mergeFrom.bulletin.title.get(), mergeFrom.bulletin.content.get()) : null;
        cg0.a.b("ECOrderSubmitRepo.FetchOrderSubmitDetailContracts", "showBulletin=" + z16 + ", bulletinInfo=" + bulletinInfo);
        ECQshopOrderQuerySvr$CouponInfo eCQshopOrderQuerySvr$CouponInfo = mergeFrom.coupon_info.has() ? mergeFrom.coupon_info.get() : null;
        List<Integer> list = mergeFrom.pay_types.get();
        if (!(!list.isEmpty())) {
            list = null;
        }
        if (list != null && (num = list.get(0)) != null) {
            payType = PayType.INSTANCE.a(num.intValue());
        }
        payType = PayType.WECHAT;
        PayType payType2 = payType;
        String str = mergeFrom.order_id.get();
        ECAddress c16 = mergeFrom.address_info.has() ? com.tencent.ecommerce.biz.orders.address.b.c(mergeFrom.address_info) : null;
        OrderSubmitPriceInfo orderSubmitPriceInfo = new OrderSubmitPriceInfo(mergeFrom.order_price.get(), mergeFrom.discount.get());
        boolean z17 = mergeFrom.enable_coupon.get();
        ii0.a.a(eCQshopOrderQuerySvr$CouponInfo);
        Unit unit = Unit.INSTANCE;
        return new IECOrderSubmitRepo.OrderSubmitDetailWrapper(new OrderSubmitDetailInfo(str, c16, a16, emptyList, payType2, orderSubmitPriceInfo, bulletinInfo, z17, eCQshopOrderQuerySvr$CouponInfo, mergeFrom.mystery_box_agreement_version.get(), mergeFrom.normal_product_agreement_version.get(), mergeFrom.qshop_privacy_agreement_version.get(), mergeFrom.labels.get(), mergeFrom.box_order_ids.get(), mergeFrom.delivery_msg.get()), mergeFrom);
    }

    @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public byte[] encodeRequestParams(SimpleSku params, int channel, JSONObject reqExt) {
        ECQshopOrderQuerySvr$OrderPageDetailReq eCQshopOrderQuerySvr$OrderPageDetailReq = new ECQshopOrderQuerySvr$OrderPageDetailReq();
        eCQshopOrderQuerySvr$OrderPageDetailReq.sku_id.set(params.skuId);
        eCQshopOrderQuerySvr$OrderPageDetailReq.sku_num.set(params.getQuantity());
        eCQshopOrderQuerySvr$OrderPageDetailReq.req_ext.set(this.pageExt);
        eCQshopOrderQuerySvr$OrderPageDetailReq.device_info.set(this.deviceInfo);
        String str = this.activityId;
        if (str != null) {
            eCQshopOrderQuerySvr$OrderPageDetailReq.active_id.set(str);
        }
        String str2 = this.boxId;
        if (str2 != null) {
            eCQshopOrderQuerySvr$OrderPageDetailReq.group_id.set(str2);
        }
        Boolean bool = this.isBuyAll;
        if (bool != null) {
            eCQshopOrderQuerySvr$OrderPageDetailReq.buy_all.set(bool.booleanValue());
        }
        return eCQshopOrderQuerySvr$OrderPageDetailReq.toByteArray();
    }
}
