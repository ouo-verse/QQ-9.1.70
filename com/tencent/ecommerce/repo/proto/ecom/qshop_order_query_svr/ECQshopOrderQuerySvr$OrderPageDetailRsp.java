package com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr;

import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_delivery_address.ECDeliveryAddress$Address;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$BriefYiFanAward;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$ProductCart;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$ShopInfo;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info.ECOrderInfo$Bulletin;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info.ECOrderInfo$LabelInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes31.dex */
public final class ECQshopOrderQuerySvr$OrderPageDetailRsp extends MessageMicro<ECQshopOrderQuerySvr$OrderPageDetailRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public ECOrderCommon$ProductCart product_cart = new ECOrderCommon$ProductCart();
    public ECDeliveryAddress$Address address_info = new ECDeliveryAddress$Address();
    public final PBRepeatField<Integer> pay_types = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBBoolField enable_coupon = PBField.initBool(false);
    public final PBBoolField free_shipping = PBField.initBool(false);
    public final PBUInt32Field shipping_cost = PBField.initUInt32(0);
    public final PBUInt64Field order_price = PBField.initUInt64(0);
    public final PBUInt64Field ori_price = PBField.initUInt64(0);
    public ECOrderCommon$ShopInfo shop_info = new ECOrderCommon$ShopInfo();
    public final PBBoolField has_biz_error = PBField.initBool(false);
    public ECQshopOrderQuerySvr$OrderPageBizErrorMsg order_page_biz_error_msg = new ECQshopOrderQuerySvr$OrderPageBizErrorMsg();
    public ECQshopOrderQuerySvr$SkuBuyNumLimit sku_buy_num_limit = new ECQshopOrderQuerySvr$SkuBuyNumLimit();
    public final PBBoolField enable_shiped = PBField.initBool(false);
    public final PBStringField order_id = PBField.initString("");
    public final PBUInt32Field discount = PBField.initUInt32(0);
    public final PBBoolField show_bulletin = PBField.initBool(false);
    public ECOrderInfo$Bulletin bulletin = new ECOrderInfo$Bulletin();
    public ECQshopOrderQuerySvr$CouponInfo coupon_info = new ECQshopOrderQuerySvr$CouponInfo();
    public final PBBoolField has_real_name_list = PBField.initBool(false);
    public final PBStringField mystery_box_agreement_version = PBField.initString("");
    public final PBRepeatMessageField<ECOrderInfo$LabelInfo> labels = PBField.initRepeatMessage(ECOrderInfo$LabelInfo.class);
    public final PBRepeatField<String> box_order_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField delivery_msg = PBField.initString("");
    public final PBRepeatMessageField<ECOrderCommon$BriefYiFanAward> buy_all_awards = PBField.initRepeatMessage(ECOrderCommon$BriefYiFanAward.class);
    public final PBUInt32Field box_type = PBField.initUInt32(0);
    public final PBStringField normal_product_agreement_version = PBField.initString("");
    public final PBStringField qshop_privacy_agreement_version = PBField.initString("");
    public final PBStringField seller_id = PBField.initString("");
    public final PBStringField token = PBField.initString("");
    public ECQshopOrderQuerySvr$PageBizPopup page_biz_popup = new ECQshopOrderQuerySvr$PageBizPopup();

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56, 64, 74, 88, 98, 106, 112, 122, 128, 144, 154, 162, 168, 178, 186, 194, 202, 210, 216, 226, 234, 802, 810, 818}, new String[]{"product_cart", "address_info", "pay_types", "enable_coupon", "free_shipping", "shipping_cost", "order_price", "ori_price", "shop_info", "has_biz_error", "order_page_biz_error_msg", "sku_buy_num_limit", "enable_shiped", "order_id", "discount", "show_bulletin", "bulletin", "coupon_info", "has_real_name_list", "mystery_box_agreement_version", "labels", "box_order_ids", "delivery_msg", "buy_all_awards", "box_type", "normal_product_agreement_version", "qshop_privacy_agreement_version", "seller_id", "token", "page_biz_popup"}, new Object[]{null, null, 0, bool, bool, 0, 0L, 0L, null, bool, null, null, bool, "", 0, bool, null, null, bool, "", null, "", "", null, 0, "", "", "", "", null}, ECQshopOrderQuerySvr$OrderPageDetailRsp.class);
    }
}
