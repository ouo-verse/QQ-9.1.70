package com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;

/* loaded from: classes38.dex */
public final class InteractiveMsgServicePB$SendInterMsgRsp extends MessageMicro<InteractiveMsgServicePB$SendInterMsgRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"rsp_head", "msg_id", ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME}, new Object[]{null, "", 0L}, InteractiveMsgServicePB$SendInterMsgRsp.class);
    public InteractiveMsgServicePB$RspHead rsp_head = new InteractiveMsgServicePB$RspHead();
    public final PBStringField msg_id = PBField.initString("");
    public final PBUInt64Field msg_time = PBField.initUInt64(0);
}
