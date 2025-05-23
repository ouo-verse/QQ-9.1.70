package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StBaseLibInfo extends MessageMicro<INTERFACE$StBaseLibInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"version", "downloadUrl", "libType", "extInfo"}, new Object[]{"", "", 0, ""}, INTERFACE$StBaseLibInfo.class);
    public final PBStringField version = PBField.initString("");
    public final PBStringField downloadUrl = PBField.initString("");
    public final PBInt32Field libType = PBField.initInt32(0);
    public final PBStringField extInfo = PBField.initString("");
}
