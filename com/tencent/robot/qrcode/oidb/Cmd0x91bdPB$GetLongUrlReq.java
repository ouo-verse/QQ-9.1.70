package com.tencent.robot.qrcode.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes25.dex */
public final class Cmd0x91bdPB$GetLongUrlReq extends MessageMicro<Cmd0x91bdPB$GetLongUrlReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"short_url"}, new Object[]{""}, Cmd0x91bdPB$GetLongUrlReq.class);
    public final PBStringField short_url = PBField.initString("");
}
