package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class META_PROTOCOL$StAdminTicketInfo extends MessageMicro<META_PROTOCOL$StAdminTicketInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50}, new String[]{"developerId", "createTimestamp", "renewTimestamp", "pwd", "uin", "A2Key"}, new Object[]{"", 0, 0, "", "", ""}, META_PROTOCOL$StAdminTicketInfo.class);
    public final PBStringField developerId = PBField.initString("");
    public final PBUInt32Field createTimestamp = PBField.initUInt32(0);
    public final PBUInt32Field renewTimestamp = PBField.initUInt32(0);
    public final PBStringField pwd = PBField.initString("");
    public final PBStringField uin = PBField.initString("");
    public final PBStringField A2Key = PBField.initString("");
}
