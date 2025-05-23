package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class appoint_define$ReplyInfo extends MessageMicro<appoint_define$ReplyInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"str_comment_id", "msg_stranger_info"}, new Object[]{"", null}, appoint_define$ReplyInfo.class);
    public final PBStringField str_comment_id = PBField.initString("");
    public appoint_define$StrangerInfo msg_stranger_info = new appoint_define$StrangerInfo();
}
