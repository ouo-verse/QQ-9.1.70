package msf.msgcomm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class msg_comm$MutilTransHead extends MessageMicro<msg_comm$MutilTransHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"status", "msgId", "friend_flag", "from_anno_id", "from_face_url"}, new Object[]{0, 0, 0, "", ""}, msg_comm$MutilTransHead.class);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBUInt32Field msgId = PBField.initUInt32(0);
    public final PBUInt32Field friend_flag = PBField.initUInt32(0);
    public final PBStringField from_anno_id = PBField.initString("");
    public final PBStringField from_face_url = PBField.initString("");
}
