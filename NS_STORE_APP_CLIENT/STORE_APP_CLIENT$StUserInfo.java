package NS_STORE_APP_CLIENT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class STORE_APP_CLIENT$StUserInfo extends MessageMicro<STORE_APP_CLIENT$StUserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"uin", "avatar", "nick"}, new Object[]{"", "", ""}, STORE_APP_CLIENT$StUserInfo.class);
    public final PBStringField uin = PBField.initString("");
    public final PBStringField avatar = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
}
