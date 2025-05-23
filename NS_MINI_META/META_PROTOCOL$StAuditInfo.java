package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class META_PROTOCOL$StAuditInfo extends MessageMicro<META_PROTOCOL$StAuditInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"submitTime", "refuseReason"}, new Object[]{0, ""}, META_PROTOCOL$StAuditInfo.class);
    public final PBUInt32Field submitTime = PBField.initUInt32(0);
    public final PBStringField refuseReason = PBField.initString("");
}
