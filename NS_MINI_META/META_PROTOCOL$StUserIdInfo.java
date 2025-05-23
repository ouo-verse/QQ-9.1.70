package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class META_PROTOCOL$StUserIdInfo extends MessageMicro<META_PROTOCOL$StUserIdInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"uin", "appid", "openid"}, new Object[]{"", "", ""}, META_PROTOCOL$StUserIdInfo.class);
    public final PBStringField uin = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
}
