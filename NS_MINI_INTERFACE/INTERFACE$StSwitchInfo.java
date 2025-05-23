package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StSwitchInfo extends MessageMicro<INTERFACE$StSwitchInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"title", "key", "value", "desc"}, new Object[]{"", "", 0, ""}, INTERFACE$StSwitchInfo.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField key = PBField.initString("");
    public final PBInt32Field value = PBField.initInt32(0);
    public final PBStringField desc = PBField.initString("");
}
