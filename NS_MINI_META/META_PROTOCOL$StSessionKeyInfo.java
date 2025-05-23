package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class META_PROTOCOL$StSessionKeyInfo extends MessageMicro<META_PROTOCOL$StSessionKeyInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, new String[]{"uin", "openid", "sessionKey", "createTimestamp", "renewTimestamp"}, new Object[]{"", "", "", 0, 0}, META_PROTOCOL$StSessionKeyInfo.class);
    public final PBStringField uin = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
    public final PBStringField sessionKey = PBField.initString("");
    public final PBUInt32Field createTimestamp = PBField.initUInt32(0);
    public final PBUInt32Field renewTimestamp = PBField.initUInt32(0);
}
