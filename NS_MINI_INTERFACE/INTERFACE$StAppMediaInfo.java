package NS_MINI_INTERFACE;

import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StAppMediaInfo extends MessageMicro<INTERFACE$StAppMediaInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"type", "width", "height", Global.TRACKING_URL}, new Object[]{0, 0, 0, ""}, INTERFACE$StAppMediaInfo.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBUInt32Field width = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBStringField URL = PBField.initString("");
}
