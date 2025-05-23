package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes35.dex */
public final class nearbyProfile$SetProfileRsp extends MessageMicro<nearbyProfile$SetProfileRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret_code", "ret_msg"}, new Object[]{0, ""}, nearbyProfile$SetProfileRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
}
