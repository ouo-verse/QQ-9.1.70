package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StModuleLayout extends MessageMicro<INTERFACE$StModuleLayout> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"direction", "aggregate"}, new Object[]{0, ""}, INTERFACE$StModuleLayout.class);
    public final PBUInt32Field direction = PBField.initUInt32(0);
    public final PBStringField aggregate = PBField.initString("");
}
