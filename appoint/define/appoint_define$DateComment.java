package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class appoint_define$DateComment extends MessageMicro<appoint_define$DateComment> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 50, 56, 66}, new String[]{"str_comment_id", "msg_appoint_id", "msg_publisher_info", "uint32_time", "msg_reply_info", "uint32_flag", "msg_content"}, new Object[]{"", null, null, 0, null, 0, null}, appoint_define$DateComment.class);
    public final PBStringField str_comment_id = PBField.initString("");
    public appoint_define$AppointID msg_appoint_id = new appoint_define$AppointID();
    public appoint_define$StrangerInfo msg_publisher_info = new appoint_define$StrangerInfo();
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public appoint_define$ReplyInfo msg_reply_info = new appoint_define$ReplyInfo();
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public appoint_define$RichText msg_content = new appoint_define$RichText();
}
