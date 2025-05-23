package com.tencent.robot.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class Oidb_0x937b$BotAIOEventReq extends MessageMicro<Oidb_0x937b$BotAIOEventReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"bot_uin", "opt", "aio_data", "bot_uid"}, new Object[]{0L, 0, null, ""}, Oidb_0x937b$BotAIOEventReq.class);
    public final PBUInt64Field bot_uin = PBField.initUInt64(0);
    public final PBUInt32Field opt = PBField.initUInt32(0);
    public Oidb_0x937b$AIOData aio_data = new Oidb_0x937b$AIOData();
    public final PBStringField bot_uid = PBField.initString("");
}
