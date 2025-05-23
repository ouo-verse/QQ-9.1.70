package com.tencent.pb.share;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class ServicePB$Operation extends MessageMicro<ServicePB$Operation> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"op_type", "op_data"}, new Object[]{0L, ""}, ServicePB$Operation.class);
    public final PBUInt64Field op_type = PBField.initUInt64(0);
    public final PBStringField op_data = PBField.initString("");
}
