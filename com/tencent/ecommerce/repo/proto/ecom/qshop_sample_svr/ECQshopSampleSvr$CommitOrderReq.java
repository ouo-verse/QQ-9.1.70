package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr;

import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_delivery_address.ECDeliveryAddress$Address;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopSampleSvr$CommitOrderReq extends MessageMicro<ECQshopSampleSvr$CommitOrderReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"order_id", "address", "contact_details", "cooperation_notes", "token"}, new Object[]{"", null, "", "", ""}, ECQshopSampleSvr$CommitOrderReq.class);
    public final PBStringField order_id = PBField.initString("");
    public ECDeliveryAddress$Address address = new ECDeliveryAddress$Address();
    public final PBStringField contact_details = PBField.initString("");
    public final PBStringField cooperation_notes = PBField.initString("");
    public final PBStringField token = PBField.initString("");
}
