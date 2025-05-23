package NS_MINI_INTERFACE;

import com.heytap.mcssdk.a.a;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGenTaskTicketReq extends MessageMicro<INTERFACE$StGenTaskTicketReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"appid", a.f36094d}, new Object[]{"", 0}, INTERFACE$StGenTaskTicketReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBUInt32Field taskID = PBField.initUInt32(0);
}
