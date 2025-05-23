package com.tencent.trpcprotocol.qqstranger.aio_msg.aio_msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class aioMsg$SsoGreetReportReq extends MessageMicro<aioMsg$SsoGreetReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"to_tinyid"}, new Object[]{0L}, aioMsg$SsoGreetReportReq.class);
    public final PBUInt64Field to_tinyid = PBField.initUInt64(0);
}
