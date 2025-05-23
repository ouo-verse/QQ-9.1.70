package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StMDebugInfo extends MessageMicro<INTERFACE$StMDebugInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"roomId", "wsUrl"}, new Object[]{"", ""}, INTERFACE$StMDebugInfo.class);
    public final PBStringField roomId = PBField.initString("");
    public final PBStringField wsUrl = PBField.initString("");
}
