package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes35.dex */
public final class nearbyProfile$GetGreetRsp extends MessageMicro<nearbyProfile$GetGreetRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"ret_code", "ret_msg", "left_cnt", "greet_msg"}, new Object[]{0, "", 0, ""}, nearbyProfile$GetGreetRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBUInt32Field left_cnt = PBField.initUInt32(0);
    public final PBRepeatField<String> greet_msg = PBField.initRepeat(PBStringField.__repeatHelper__);
}
