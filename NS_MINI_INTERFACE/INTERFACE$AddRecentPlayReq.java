package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class INTERFACE$AddRecentPlayReq extends MessageMicro<INTERFACE$AddRecentPlayReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"appid", "versionType", "timestamp", "source"}, new Object[]{"", 0, 0L, 0}, INTERFACE$AddRecentPlayReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBInt32Field versionType = PBField.initInt32(0);
    public final PBInt64Field timestamp = PBField.initInt64(0);
    public final PBInt32Field source = PBField.initInt32(0);
}
