package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class appoint_define$AppointID extends MessageMicro<appoint_define$AppointID> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"str_request_id"}, new Object[]{""}, appoint_define$AppointID.class);
    public final PBStringField str_request_id = PBField.initString("");
}
