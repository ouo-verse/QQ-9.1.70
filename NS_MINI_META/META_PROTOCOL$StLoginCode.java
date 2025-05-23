package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class META_PROTOCOL$StLoginCode extends MessageMicro<META_PROTOCOL$StLoginCode> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"reqFrm", "userIp", "createTimestamp", "used"}, new Object[]{0, "", 0, 0}, META_PROTOCOL$StLoginCode.class);
    public final PBInt32Field reqFrm = PBField.initInt32(0);
    public final PBStringField userIp = PBField.initString("");
    public final PBUInt32Field createTimestamp = PBField.initUInt32(0);
    public final PBInt32Field used = PBField.initInt32(0);
}
