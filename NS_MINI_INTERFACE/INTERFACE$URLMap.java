package NS_MINI_INTERFACE;

import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$URLMap extends MessageMicro<INTERFACE$URLMap> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"code", "codeType", Global.TRACKING_URL}, new Object[]{"", 0, ""}, INTERFACE$URLMap.class);
    public final PBStringField code = PBField.initString("");
    public final PBInt32Field codeType = PBField.initInt32(0);
    public final PBStringField URL = PBField.initString("");
}
