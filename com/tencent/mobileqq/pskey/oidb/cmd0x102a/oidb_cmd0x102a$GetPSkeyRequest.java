package com.tencent.mobileqq.pskey.oidb.cmd0x102a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes16.dex */
public final class oidb_cmd0x102a$GetPSkeyRequest extends MessageMicro<oidb_cmd0x102a$GetPSkeyRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"domains", "flag"}, new Object[]{"", 0}, oidb_cmd0x102a$GetPSkeyRequest.class);
    public final PBRepeatField<String> domains = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field flag = PBField.initUInt32(0);
}
