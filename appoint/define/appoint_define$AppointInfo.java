package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class appoint_define$AppointInfo extends MessageMicro<appoint_define$AppointInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 48, 56, 64, 72, 82, 88, 96, 106}, new String[]{"msg_appoint_id", "msg_appointment", "uint32_appoint_status", "str_join_wording", "str_view_wording", "uint32_unread_count", "uint32_owner", "uint32_join", "uint32_view", "str_comment_wording", "uint32_comment_num", "uint32_attend_status", "msg_appointment_ex"}, new Object[]{null, null, 0, "", "", 0, 0, 0, 0, "", 0, 0, null}, appoint_define$AppointInfo.class);
    public appoint_define$AppointID msg_appoint_id = new appoint_define$AppointID();
    public appoint_define$AppointContent msg_appointment = new appoint_define$AppointContent();
    public final PBUInt32Field uint32_appoint_status = PBField.initUInt32(0);
    public final PBStringField str_join_wording = PBField.initString("");
    public final PBStringField str_view_wording = PBField.initString("");
    public final PBUInt32Field uint32_unread_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_owner = PBField.initUInt32(0);
    public final PBUInt32Field uint32_join = PBField.initUInt32(0);
    public final PBUInt32Field uint32_view = PBField.initUInt32(0);
    public final PBStringField str_comment_wording = PBField.initString("");
    public final PBUInt32Field uint32_comment_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_attend_status = PBField.initUInt32(0);
    public appoint_define$AppointInfoEx msg_appointment_ex = new MessageMicro<appoint_define$AppointInfoEx>() { // from class: appoint.define.appoint_define$AppointInfoEx
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 58, 64}, new String[]{"str_feeds_pic_url", "str_feeds_url", "str_detail_title", "str_detail_describe", "uint32_show_publisher", "str_detail_pic_url", "str_detail_url", "uint32_show_attend"}, new Object[]{"", "", "", "", 0, "", "", 0}, appoint_define$AppointInfoEx.class);
        public final PBStringField str_feeds_pic_url = PBField.initString("");
        public final PBStringField str_feeds_url = PBField.initString("");
        public final PBStringField str_detail_title = PBField.initString("");
        public final PBStringField str_detail_describe = PBField.initString("");
        public final PBUInt32Field uint32_show_publisher = PBField.initUInt32(0);
        public final PBStringField str_detail_pic_url = PBField.initString("");
        public final PBStringField str_detail_url = PBField.initString("");
        public final PBUInt32Field uint32_show_attend = PBField.initUInt32(0);
    };
}
