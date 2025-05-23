package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data;

import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_delivery_address.ECDeliveryAddress$Address;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECSampleData$CreativeSnapshot extends MessageMicro<ECSampleData$CreativeSnapshot> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 64, 72}, new String[]{"uin", "media_id", "nick", "logo", "contact_details", "address", "cate_name", "fans_cnt", "post_cnt"}, new Object[]{0L, "", "", "", "", null, "", 0, 0}, ECSampleData$CreativeSnapshot.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField media_id = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public final PBStringField logo = PBField.initString("");
    public final PBStringField contact_details = PBField.initString("");
    public ECDeliveryAddress$Address address = new ECDeliveryAddress$Address();
    public final PBStringField cate_name = PBField.initString("");
    public final PBUInt32Field fans_cnt = PBField.initUInt32(0);
    public final PBUInt32Field post_cnt = PBField.initUInt32(0);
}
