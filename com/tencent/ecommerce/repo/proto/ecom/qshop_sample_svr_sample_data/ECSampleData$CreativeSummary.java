package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data;

import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_delivery_address.ECDeliveryAddress$Address;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECSampleData$CreativeSummary extends MessageMicro<ECSampleData$CreativeSummary> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 58, 66, 72, 80, 88, 96, 104, 112, 800}, new String[]{"uin", "media_id", "allowed", "contact_details", "address", "nick", "logo", "cate_name", "fans_cnt", "post_cnt", "finished_order_count", "unfinished_order_count", "last_apply_time", "update_time", "version"}, new Object[]{0L, "", Boolean.FALSE, "", null, "", "", "", 0, 0, 0, 0, 0L, 0L, 0L}, ECSampleData$CreativeSummary.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField media_id = PBField.initString("");
    public final PBBoolField allowed = PBField.initBool(false);
    public final PBStringField contact_details = PBField.initString("");
    public ECDeliveryAddress$Address address = new ECDeliveryAddress$Address();
    public final PBStringField nick = PBField.initString("");
    public final PBStringField logo = PBField.initString("");
    public final PBStringField cate_name = PBField.initString("");
    public final PBUInt32Field fans_cnt = PBField.initUInt32(0);
    public final PBUInt32Field post_cnt = PBField.initUInt32(0);
    public final PBUInt32Field finished_order_count = PBField.initUInt32(0);
    public final PBUInt32Field unfinished_order_count = PBField.initUInt32(0);
    public final PBInt64Field last_apply_time = PBField.initInt64(0);
    public final PBInt64Field update_time = PBField.initInt64(0);
    public final PBInt64Field version = PBField.initInt64(0);
}
