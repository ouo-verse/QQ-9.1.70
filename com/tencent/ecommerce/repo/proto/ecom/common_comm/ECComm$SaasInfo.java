package com.tencent.ecommerce.repo.proto.ecom.common_comm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECComm$SaasInfo extends MessageMicro<ECComm$SaasInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"type_num", "type_str", "type_name"}, new Object[]{0L, "", ""}, ECComm$SaasInfo.class);
    public final PBInt64Field type_num = PBField.initInt64(0);
    public final PBStringField type_str = PBField.initString("");
    public final PBStringField type_name = PBField.initString("");
}
