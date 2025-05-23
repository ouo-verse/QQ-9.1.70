package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StUserAuthInfo extends MessageMicro<INTERFACE$StUserAuthInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"scope", "desc", "authState", "settingPageTitle"}, new Object[]{"", "", 0, ""}, INTERFACE$StUserAuthInfo.class);
    public final PBStringField scope = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBInt32Field authState = PBField.initInt32(0);
    public final PBStringField settingPageTitle = PBField.initString("");
}
