package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class appoint_define$Elem extends MessageMicro<appoint_define$Elem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"str_content", "msg_face_info"}, new Object[]{"", null}, appoint_define$Elem.class);
    public final PBStringField str_content = PBField.initString("");
    public appoint_define$Face msg_face_info = new appoint_define$Face();
}
