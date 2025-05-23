package com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes38.dex */
public final class InteractiveMsgServicePB$MsgInfo extends MessageMicro<InteractiveMsgServicePB$MsgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 58, 66, 72}, new String[]{"feed_id", "feed_source", "content", "pic", "comment_id", "comment_content", "feed_owner_uid", "reply_id", "is_feed_delete"}, new Object[]{"", 0, "", "", "", "", "", "", 0}, InteractiveMsgServicePB$MsgInfo.class);
    public final PBStringField feed_id = PBField.initString("");
    public final PBEnumField feed_source = PBField.initEnum(0);
    public final PBStringField content = PBField.initString("");
    public final PBStringField pic = PBField.initString("");
    public final PBStringField comment_id = PBField.initString("");
    public final PBStringField comment_content = PBField.initString("");
    public final PBStringField feed_owner_uid = PBField.initString("");
    public final PBStringField reply_id = PBField.initString("");
    public final PBUInt32Field is_feed_delete = PBField.initUInt32(0);
}
