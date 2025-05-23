package msf.msgcomm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class msg_comm$Uin2Nick extends MessageMicro<msg_comm$Uin2Nick> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_uin", "str_nick"}, new Object[]{0L, ""}, msg_comm$Uin2Nick.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBStringField str_nick = PBField.initString("");
}
