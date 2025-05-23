package com.tencent.trpcprotocol.kuolie.message_list.message_list;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class message_list$ConversationModel extends MessageMicro<message_list$ConversationModel> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 58, 66, 72}, new String[]{"peer_open_id", "nick", QCircleSchemeAttr.Detail.AVATAR_URL, "time", "msg_status", "unread_count", "msg_summary", "match_source_text", "user_type"}, new Object[]{"", "", "", 0L, 0, 0, "", "", 0}, message_list$ConversationModel.class);
    public final PBStringField peer_open_id = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public final PBStringField avatar_url = PBField.initString("");
    public final PBUInt64Field time = PBField.initUInt64(0);
    public final PBEnumField msg_status = PBField.initEnum(0);
    public final PBUInt32Field unread_count = PBField.initUInt32(0);
    public final PBStringField msg_summary = PBField.initString("");
    public final PBStringField match_source_text = PBField.initString("");
    public final PBEnumField user_type = PBField.initEnum(0);
}
