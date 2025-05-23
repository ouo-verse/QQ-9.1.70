package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class fd_comm$UinProf extends MessageMicro<fd_comm$UinProf> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uin", "nick"}, new Object[]{0L, ""}, fd_comm$UinProf.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField nick = PBField.initString("");
}
