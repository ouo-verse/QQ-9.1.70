package localpb.richMsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class RichMsg$ForwardExtra extends MessageMicro<RichMsg$ForwardExtra> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 48}, new String[]{"foward_orgId", "foward_orgUin", "foward_orgUinType", "foward_orgUrl", "foward_thumbPath", "foward_orgFileSizeType"}, new Object[]{0L, "", 0, "", "", 0}, RichMsg$ForwardExtra.class);
    public final PBUInt64Field foward_orgId = PBField.initUInt64(0);
    public final PBStringField foward_orgUin = PBField.initString("");
    public final PBInt32Field foward_orgUinType = PBField.initInt32(0);
    public final PBStringField foward_orgUrl = PBField.initString("");
    public final PBStringField foward_thumbPath = PBField.initString("");
    public final PBInt32Field foward_orgFileSizeType = PBField.initInt32(0);
}
