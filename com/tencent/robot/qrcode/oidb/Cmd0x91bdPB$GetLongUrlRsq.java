package com.tencent.robot.qrcode.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes25.dex */
public final class Cmd0x91bdPB$GetLongUrlRsq extends MessageMicro<Cmd0x91bdPB$GetLongUrlRsq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"long_url"}, new Object[]{""}, Cmd0x91bdPB$GetLongUrlRsq.class);
    public final PBStringField long_url = PBField.initString("");
}
