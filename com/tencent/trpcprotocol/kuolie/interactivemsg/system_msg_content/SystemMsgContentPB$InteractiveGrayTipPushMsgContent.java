package com.tencent.trpcprotocol.kuolie.interactivemsg.system_msg_content;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes38.dex */
public final class SystemMsgContentPB$InteractiveGrayTipPushMsgContent extends MessageMicro<SystemMsgContentPB$InteractiveGrayTipPushMsgContent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"peer_tinyid", "gray_tip_content", "gray_tip_type"}, new Object[]{0L, "", 0}, SystemMsgContentPB$InteractiveGrayTipPushMsgContent.class);
    public final PBUInt64Field peer_tinyid = PBField.initUInt64(0);
    public final PBStringField gray_tip_content = PBField.initString("");
    public final PBEnumField gray_tip_type = PBField.initEnum(0);
}
