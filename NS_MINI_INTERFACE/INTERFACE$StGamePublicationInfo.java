package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class INTERFACE$StGamePublicationInfo extends MessageMicro<INTERFACE$StGamePublicationInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"gamePublicationNumber", "gamePublicationCommpany", "gameApprovalNumber", "gameOperatingCompany"}, new Object[]{"", "", "", ""}, INTERFACE$StGamePublicationInfo.class);
    public final PBStringField gamePublicationNumber = PBField.initString("");
    public final PBStringField gamePublicationCommpany = PBField.initString("");
    public final PBStringField gameApprovalNumber = PBField.initString("");
    public final PBStringField gameOperatingCompany = PBField.initString("");
}
