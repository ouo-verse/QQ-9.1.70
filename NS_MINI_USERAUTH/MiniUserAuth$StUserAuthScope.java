package NS_MINI_USERAUTH;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniUserAuth$StUserAuthScope extends MessageMicro<MiniUserAuth$StUserAuthScope> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"scope", "authType", "desc", "settingPageTitle"}, new Object[]{"", 0, "", ""}, MiniUserAuth$StUserAuthScope.class);
    public final PBStringField scope = PBField.initString("");
    public final PBInt32Field authType = PBField.initInt32(0);
    public final PBStringField desc = PBField.initString("");
    public final PBStringField settingPageTitle = PBField.initString("");
}
