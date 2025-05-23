package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class appoint_define$DateEvent extends MessageMicro<appoint_define$DateEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 58, 66, 72}, new String[]{"uint64_event_id", "uint32_time", "uint32_type", "msg_user_info", "msg_date_info", "uint32_attend_idx", "str_event_tips", "msg_comment", "uint64_cancel_event_id"}, new Object[]{0L, 0, 0, null, null, 0, "", null, 0L}, appoint_define$DateEvent.class);
    public final PBUInt64Field uint64_event_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public appoint_define$StrangerInfo msg_user_info = new appoint_define$StrangerInfo();
    public appoint_define$AppointInfo msg_date_info = new appoint_define$AppointInfo();
    public final PBUInt32Field uint32_attend_idx = PBField.initUInt32(0);
    public final PBStringField str_event_tips = PBField.initString("");
    public appoint_define$DateComment msg_comment = new appoint_define$DateComment();
    public final PBUInt64Field uint64_cancel_event_id = PBField.initUInt64(0);
}
