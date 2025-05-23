package com.tencent.trpcprotocol.qqstranger.aio_msg.aio_msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class aioMsg$SsoGreetReportRsp extends MessageMicro<aioMsg$SsoGreetReportRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret_code", "ret_msg"}, new Object[]{0, ""}, aioMsg$SsoGreetReportRsp.class);
    public final PBEnumField ret_code = PBField.initEnum(0);
    public final PBStringField ret_msg = PBField.initString("");
}
