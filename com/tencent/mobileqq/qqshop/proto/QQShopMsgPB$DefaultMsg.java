package com.tencent.mobileqq.qqshop.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;

/* loaded from: classes17.dex */
public final class QQShopMsgPB$DefaultMsg extends MessageMicro<QQShopMsgPB$DefaultMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME, "msg_id", "content"}, new Object[]{0L, 0L, ""}, QQShopMsgPB$DefaultMsg.class);
    public final PBInt64Field msg_time = PBField.initInt64(0);
    public final PBInt64Field msg_id = PBField.initInt64(0);
    public final PBStringField content = PBField.initString("");
}
