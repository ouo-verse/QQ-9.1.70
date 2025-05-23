package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class fd_aio_msgs$GrabFDGrayMsg extends MessageMicro<fd_aio_msgs$GrabFDGrayMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"host_uin", "grab_uin", "fdid", QQHealthReportApiImpl.MSG_TYPE_KEY, "high_light_des"}, new Object[]{null, null, "", 1, null}, fd_aio_msgs$GrabFDGrayMsg.class);
    public fd_comm$UinProf host_uin = new fd_comm$UinProf();
    public fd_comm$UinProf grab_uin = new fd_comm$UinProf();
    public final PBStringField fdid = PBField.initString("");
    public final PBEnumField msg_type = PBField.initEnum(1);
    public fd_comm$TxtAndUrl high_light_des = new MessageMicro<fd_comm$TxtAndUrl>() { // from class: fudai.fd_comm$TxtAndUrl
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"txt_des", "jmp_url"}, new Object[]{"", ""}, fd_comm$TxtAndUrl.class);
        public final PBStringField txt_des = PBField.initString("");
        public final PBStringField jmp_url = PBField.initString("");
    };
}
