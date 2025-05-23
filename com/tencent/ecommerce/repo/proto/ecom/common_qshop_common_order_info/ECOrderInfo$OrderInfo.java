package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.ecommerce.repo.proto.ecom.common_logistics_common.ECLogisticsCommon$LogisticsInfo;
import com.tencent.ecommerce.repo.proto.ecom.common_order.ECOrder$LinkInfo;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_delivery_address.ECDeliveryAddress$Address;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$ProductCart;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$Promo;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$ShopInfo;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$TicketInfo;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$UsedCouponItem;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$VirtualAccount;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.uf.n;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.qqlive.module.videoreport.dtreport.api.DefaultTVKDataProvider;
import com.tencent.state.map.MapItemKt;
import com.tencent.view.FilterEnum;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrderInfo$OrderInfo extends MessageMicro<ECOrderInfo$OrderInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField order_id = PBField.initString("");
    public final PBUInt32Field state = PBField.initUInt32(0);
    public final PBBoolField has_comment = PBField.initBool(false);
    public ECDeliveryAddress$Address address = new ECDeliveryAddress$Address();
    public final PBRepeatMessageField<ECLogisticsCommon$LogisticsInfo> shipping_info = PBField.initRepeatMessage(ECLogisticsCommon$LogisticsInfo.class);
    public ECOrderCommon$ShopInfo shop_info = new ECOrderCommon$ShopInfo();
    public final PBRepeatMessageField<ECOrderCommon$ProductCart> product_carts = PBField.initRepeatMessage(ECOrderCommon$ProductCart.class);
    public final PBUInt64Field order_price = PBField.initUInt64(0);
    public final PBUInt64Field ori_price = PBField.initUInt64(0);
    public final PBUInt32Field discount = PBField.initUInt32(0);
    public final PBUInt32Field pay_type = PBField.initUInt32(0);
    public final PBStringField pay_url_params = PBField.initString("");
    public final PBStringField remarks = PBField.initString("");
    public final PBStringField after_sales_id = PBField.initString("");
    public final PBInt64Field create_time = PBField.initInt64(0);
    public final PBInt64Field pay_time = PBField.initInt64(0);
    public final PBInt64Field cancel_time = PBField.initInt64(0);
    public final PBInt64Field received_time = PBField.initInt64(0);
    public final PBInt64Field refund_time = PBField.initInt64(0);
    public final PBInt64Field pay_deadline = PBField.initInt64(0);
    public final PBInt64Field deliver_deadline = PBField.initInt64(0);
    public final PBInt64Field receipt_deadline = PBField.initInt64(0);
    public final PBStringField spu_link = PBField.initString("");
    public final PBBoolField show_buy_one_more = PBField.initBool(false);
    public final PBStringField buy_more_link = PBField.initString("");
    public final PBInt32Field cancel_or_refund_source = PBField.initInt32(0);
    public final PBInt64Field apply_after_sales_deadline = PBField.initInt64(0);
    public final PBBoolField free_shipping = PBField.initBool(false);
    public final PBUInt32Field shipping_cost = PBField.initUInt32(0);
    public final PBInt64Field update_address_deadline = PBField.initInt64(0);
    public ECOrder$LinkInfo link_info = new ECOrder$LinkInfo();
    public ECOrderInfo$SaasExtendInfo saas_extend_info = new MessageMicro<ECOrderInfo$SaasExtendInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info.ECOrderInfo$SaasExtendInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"display_order_id", "pindao_id", "show_window_product_id"}, new Object[]{"", "", ""}, ECOrderInfo$SaasExtendInfo.class);
        public final PBStringField display_order_id = PBField.initString("");
        public final PBStringField pindao_id = PBField.initString("");
        public final PBStringField show_window_product_id = PBField.initString("");
    };
    public final PBUInt32Field refund_state = PBField.initUInt32(0);
    public final PBUInt32Field trade_type = PBField.initUInt32(0);
    public ECOrderCommon$VirtualAccount virtual_account = new ECOrderCommon$VirtualAccount();
    public final PBRepeatMessageField<ECOrderCommon$Promo> promos = PBField.initRepeatMessage(ECOrderCommon$Promo.class);
    public ECOrderInfo$Bulletin bulletin = new ECOrderInfo$Bulletin();
    public final PBRepeatMessageField<ECOrderCommon$UsedCouponItem> coupon_items = PBField.initRepeatMessage(ECOrderCommon$UsedCouponItem.class);
    public ECOrderCommon$TicketInfo ticket_info = new ECOrderCommon$TicketInfo();
    public final PBRepeatMessageField<ECOrderInfo$LabelInfo> labels = PBField.initRepeatMessage(ECOrderInfo$LabelInfo.class);
    public final PBRepeatMessageField<ECOrderInfo$ExtraJmpPage> extra_jmp_pages = PBField.initRepeatMessage(ECOrderInfo$ExtraJmpPage.class);
    public final PBStringField warehouse_link = PBField.initString("");
    public final PBStringField remarks_for_buyer = PBField.initString("");
    public final PBStringField saas_id = PBField.initString("");
    public final PBUInt32Field goods_type = PBField.initUInt32(0);
    public final PBStringField saas_name = PBField.initString("");
    public final PBUInt32Field channel = PBField.initUInt32(0);
    public final PBStringField channel_name = PBField.initString("");
    public ECOrderInfo$OrderUIData order_ui_data = new ECOrderInfo$OrderUIData();

    static {
        int[] iArr = {10, 16, 24, 34, 42, 50, 58, 64, 72, 80, 88, 98, 106, 114, 120, 128, 136, 144, 152, 160, 168, 176, 186, 192, 202, 208, 216, 224, 232, 240, 250, 258, 264, 272, FilterEnum.MIC_PTU_BAIXI, 290, 298, 306, 314, 322, MapItemKt.ITEM_AVATAR_MIN_WIDTH, 338, 346, n.CTRL_INDEX, 800, 810, 816, BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO, 834};
        String[] strArr = {"order_id", "state", "has_comment", "address", "shipping_info", "shop_info", "product_carts", "order_price", "ori_price", "discount", DefaultTVKDataProvider.KEY_PAY_TYPE, "pay_url_params", "remarks", "after_sales_id", AlbumCacheData.CREATE_TIME, "pay_time", "cancel_time", "received_time", "refund_time", "pay_deadline", "deliver_deadline", "receipt_deadline", "spu_link", "show_buy_one_more", "buy_more_link", "cancel_or_refund_source", "apply_after_sales_deadline", "free_shipping", "shipping_cost", "update_address_deadline", "link_info", "saas_extend_info", "refund_state", "trade_type", "virtual_account", "promos", "bulletin", "coupon_items", "ticket_info", "labels", "extra_jmp_pages", "warehouse_link", "remarks_for_buyer", "saas_id", "goods_type", "saas_name", WadlProxyConsts.CHANNEL, "channel_name", "order_ui_data"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(iArr, strArr, new Object[]{"", 0, bool, null, null, null, null, 0L, 0L, 0, 0, "", "", "", 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, "", bool, "", 0, 0L, bool, 0, 0L, null, null, 0, 0, null, null, null, null, null, null, null, "", "", "", 0, "", 0, "", null}, ECOrderInfo$OrderInfo.class);
    }
}
