package com.tencent.ecommerce.repo.proto.ecom.common_logistics_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECLogisticsCommon$ShipperCompany extends MessageMicro<ECLogisticsCommon$ShipperCompany> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"code", "name", "tel"}, new Object[]{"", "", ""}, ECLogisticsCommon$ShipperCompany.class);
    public final PBStringField code = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField tel = PBField.initString("");
}
