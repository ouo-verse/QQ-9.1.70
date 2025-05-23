package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes31.dex */
public final class ECOrderCommon$ProductTradeInfo extends MessageMicro<ECOrderCommon$ProductTradeInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48, 56, 64, 72, 80, 88}, new String[]{"trade_type", "account_type", "account_name", "product_ticket_info", "delivery_type", "delivery_mode", "delivery_opportunity", "delivery_time_type", "delivery_day", "presale_end_time", "has_end_time"}, new Object[]{0, 0, "", null, 0, 0, 0, 0, 0L, 0L, Boolean.FALSE}, ECOrderCommon$ProductTradeInfo.class);
    public final PBUInt32Field trade_type = PBField.initUInt32(0);
    public final PBUInt32Field account_type = PBField.initUInt32(0);
    public final PBStringField account_name = PBField.initString("");
    public ECOrderCommon$ProductTicketInfo product_ticket_info = new MessageMicro<ECOrderCommon$ProductTicketInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$ProductTicketInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42}, new String[]{"name", "valid_days", "service_hotline", "announcement", "precondition"}, new Object[]{"", 0, "", "", ""}, ECOrderCommon$ProductTicketInfo.class);
        public final PBStringField name = PBField.initString("");
        public final PBInt32Field valid_days = PBField.initInt32(0);
        public final PBStringField service_hotline = PBField.initString("");
        public final PBStringField announcement = PBField.initString("");
        public final PBStringField precondition = PBField.initString("");
    };
    public final PBUInt32Field delivery_type = PBField.initUInt32(0);
    public final PBUInt32Field delivery_mode = PBField.initUInt32(0);
    public final PBUInt32Field delivery_opportunity = PBField.initUInt32(0);
    public final PBUInt32Field delivery_time_type = PBField.initUInt32(0);
    public final PBInt64Field delivery_day = PBField.initInt64(0);
    public final PBInt64Field presale_end_time = PBField.initInt64(0);
    public final PBBoolField has_end_time = PBField.initBool(false);
}
