package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$UseUserInfo extends MessageMicro<INTERFACE$UseUserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"uin", "avatar", "nick"}, new Object[]{"", "", ""}, INTERFACE$UseUserInfo.class);
    public final PBStringField uin = PBField.initString("");
    public final PBStringField avatar = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
}
