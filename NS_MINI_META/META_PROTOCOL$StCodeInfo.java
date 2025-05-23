package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class META_PROTOCOL$StCodeInfo extends MessageMicro<META_PROTOCOL$StCodeInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48}, new String[]{"uin", "A2Key", "appid", "openid", "createTimestamp", "used"}, new Object[]{"", "", "", "", 0, 0}, META_PROTOCOL$StCodeInfo.class);
    public final PBStringField uin = PBField.initString("");
    public final PBStringField A2Key = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
    public final PBUInt32Field createTimestamp = PBField.initUInt32(0);
    public final PBInt32Field used = PBField.initInt32(0);
}
