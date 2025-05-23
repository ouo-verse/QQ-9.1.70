package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class META_PROTOCOL$StAccountInfo extends MessageMicro<META_PROTOCOL$StAccountInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, new String[]{"email", "passwordMd5", "activateTicket", "activateEmailTime", "activateState"}, new Object[]{"", "", "", 0, 0}, META_PROTOCOL$StAccountInfo.class);
    public final PBStringField email = PBField.initString("");
    public final PBStringField passwordMd5 = PBField.initString("");
    public final PBStringField activateTicket = PBField.initString("");
    public final PBUInt32Field activateEmailTime = PBField.initUInt32(0);
    public final PBUInt32Field activateState = PBField.initUInt32(0);
}
