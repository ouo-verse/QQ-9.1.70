package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class nearbyControl$GetMasterControlReq extends MessageMicro<nearbyControl$GetMasterControlReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"source", "req_flag"}, new Object[]{"", 0}, nearbyControl$GetMasterControlReq.class);
    public final PBStringField source = PBField.initString("");
    public final PBRepeatField<Integer> req_flag = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
