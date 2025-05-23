package com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr;

import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info.ECOrderInfo$DeviceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* loaded from: classes31.dex */
public final class ECQshopOrderQuerySvr$CalculateOrderPriceReq extends MessageMicro<ECQshopOrderQuerySvr$CalculateOrderPriceReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 50, 56, 66, 162, 810}, new String[]{"sku_id", "sku_num", "active_id", "coupon_ids", QCircleDaTongConstant.ElementParamValue.OPERATION, "group_id", "buy_all", "box_order_ids", "req_ext", "device_info"}, new Object[]{"", 0, "", "", 0, "", Boolean.FALSE, "", "", null}, ECQshopOrderQuerySvr$CalculateOrderPriceReq.class);
    public final PBRepeatField<String> box_order_ids;
    public final PBBoolField buy_all;
    public final PBRepeatField<String> coupon_ids;
    public ECOrderInfo$DeviceInfo device_info;
    public final PBStringField group_id;
    public final PBUInt32Field operation;
    public final PBStringField req_ext;
    public final PBStringField sku_id = PBField.initString("");
    public final PBUInt32Field sku_num = PBField.initUInt32(0);
    public final PBStringField active_id = PBField.initString("");

    public ECQshopOrderQuerySvr$CalculateOrderPriceReq() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.coupon_ids = PBField.initRepeat(pBStringField);
        this.operation = PBField.initUInt32(0);
        this.group_id = PBField.initString("");
        this.buy_all = PBField.initBool(false);
        this.box_order_ids = PBField.initRepeat(pBStringField);
        this.req_ext = PBField.initString("");
        this.device_info = new ECOrderInfo$DeviceInfo();
    }
}
