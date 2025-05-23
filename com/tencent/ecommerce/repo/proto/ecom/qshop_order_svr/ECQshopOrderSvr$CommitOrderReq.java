package com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr;

import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_delivery_address.ECDeliveryAddress$Address;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$BriefYiFanAward;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$ProductCart;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$ShopInfo;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$VirtualAccount;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info.ECOrderInfo$DeviceInfo;
import com.tencent.ecommerce.repo.proto.ecom.real_name_svr.ECRealNameSvr$User;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.dtreport.api.DefaultTVKDataProvider;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopOrderSvr$CommitOrderReq extends MessageMicro<ECQshopOrderSvr$CommitOrderReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField active_id;
    public final PBStringField aid;
    public final PBStringField auth;
    public final PBRepeatField<String> box_order_ids;
    public final PBBoolField buy_all;
    public final PBRepeatMessageField<ECOrderCommon$BriefYiFanAward> buy_all_awards;
    public final PBInt32Field channel;
    public final PBStringField click_id;
    public final PBRepeatField<String> coupon_ids;
    public ECOrderInfo$DeviceInfo device_info;
    public final PBStringField group_id;
    public final PBStringField req_ext;
    public final PBStringField token;
    public ECRealNameSvr$User user;
    public ECOrderCommon$ProductCart product_cart = new ECOrderCommon$ProductCart();
    public ECDeliveryAddress$Address address_info = new ECDeliveryAddress$Address();
    public final PBUInt32Field pay_type = PBField.initUInt32(0);
    public final PBBoolField enable_coupon = PBField.initBool(false);
    public final PBBoolField free_shipping = PBField.initBool(false);
    public final PBUInt32Field shipping_cost = PBField.initUInt32(0);
    public final PBUInt64Field order_price = PBField.initUInt64(0);
    public final PBStringField remarks = PBField.initString("");
    public ECOrderCommon$ShopInfo shop_info = new ECOrderCommon$ShopInfo();
    public ECQshopOrderSvr$CaptchaToken captcha_token = new ECQshopOrderSvr$CaptchaToken();
    public final PBStringField order_id = PBField.initString("");
    public final PBUInt64Field ori_price = PBField.initUInt64(0);
    public ECOrderCommon$VirtualAccount virtual_account = new ECOrderCommon$VirtualAccount();

    public ECQshopOrderSvr$CommitOrderReq() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.coupon_ids = PBField.initRepeat(pBStringField);
        this.active_id = PBField.initString("");
        this.user = new ECRealNameSvr$User();
        this.click_id = PBField.initString("");
        this.box_order_ids = PBField.initRepeat(pBStringField);
        this.auth = PBField.initString("");
        this.group_id = PBField.initString("");
        this.buy_all = PBField.initBool(false);
        this.buy_all_awards = PBField.initRepeatMessage(ECOrderCommon$BriefYiFanAward.class);
        this.device_info = new ECOrderInfo$DeviceInfo();
        this.token = PBField.initString("");
        this.channel = PBField.initInt32(0);
        this.req_ext = PBField.initString("");
        this.aid = PBField.initString("");
    }

    static {
        int[] iArr = {10, 18, 24, 32, 40, 48, 56, 66, 74, 82, 90, 96, 106, 122, 130, 146, 154, 162, 170, 178, 184, 194, 802, 810, 816, BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO, 836};
        String[] strArr = {"product_cart", "address_info", DefaultTVKDataProvider.KEY_PAY_TYPE, "enable_coupon", "free_shipping", "shipping_cost", "order_price", "remarks", "shop_info", "captcha_token", "order_id", "ori_price", "virtual_account", "coupon_ids", "active_id", QCircleAlphaUserReporter.KEY_USER, "click_id", "box_order_ids", WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_AUTH, "group_id", "buy_all", "buy_all_awards", "device_info", "token", WadlProxyConsts.CHANNEL, "req_ext", "aid"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(iArr, strArr, new Object[]{null, null, 0, bool, bool, 0, 0L, "", null, null, "", 0L, null, "", "", null, "", "", "", "", bool, null, null, "", 0, "", ""}, ECQshopOrderSvr$CommitOrderReq.class);
    }
}
