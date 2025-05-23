package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class EmosmPb$SubCmd0x6Rsp extends MessageMicro<EmosmPb$SubCmd0x6Rsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"int32_auth_detail", "str_auth_msg"}, new Object[]{0, ""}, EmosmPb$SubCmd0x6Rsp.class);
    public final PBInt32Field int32_auth_detail = PBField.initInt32(0);
    public final PBStringField str_auth_msg = PBField.initString("");
}
