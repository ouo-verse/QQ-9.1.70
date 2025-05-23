package com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes38.dex */
public final class InteractiveMsgServicePB$ReadedReportReq extends MessageMicro<InteractiveMsgServicePB$ReadedReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"readed_time"}, new Object[]{0L}, InteractiveMsgServicePB$ReadedReportReq.class);
    public final PBUInt64Field readed_time = PBField.initUInt64(0);
}
