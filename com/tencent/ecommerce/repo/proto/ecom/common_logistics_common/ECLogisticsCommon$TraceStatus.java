package com.tencent.ecommerce.repo.proto.ecom.common_logistics_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECLogisticsCommon$TraceStatus extends MessageMicro<ECLogisticsCommon$TraceStatus> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"status", "sub_status", "status_desc"}, new Object[]{0, 0, ""}, ECLogisticsCommon$TraceStatus.class);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBUInt32Field sub_status = PBField.initUInt32(0);
    public final PBStringField status_desc = PBField.initString("");
}
