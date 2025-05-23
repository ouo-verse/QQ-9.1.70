package com.tencent.trpcprotocol.kuolie.interactivemsg.system_msg_content;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service.InteractiveMsgServicePB$MsgMetaInfo;

/* loaded from: classes38.dex */
public final class SystemMsgContentPB$InteractivemsgSystemmsgContent extends MessageMicro<SystemMsgContentPB$InteractivemsgSystemmsgContent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"cur_msg_info", "flag_cur_msg_status", "msg_unread_cnt"}, new Object[]{null, 0, 0}, SystemMsgContentPB$InteractivemsgSystemmsgContent.class);
    public InteractiveMsgServicePB$MsgMetaInfo cur_msg_info = new InteractiveMsgServicePB$MsgMetaInfo();
    public final PBEnumField flag_cur_msg_status = PBField.initEnum(0);
    public final PBUInt32Field msg_unread_cnt = PBField.initUInt32(0);
}
