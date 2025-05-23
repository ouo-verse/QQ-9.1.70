package NS_MINI_INTERFACE;

import com.heytap.mcssdk.a.a;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGenTaskTicketRsp extends MessageMicro<INTERFACE$StGenTaskTicketRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"ticket", a.f36094d}, new Object[]{"", 0}, INTERFACE$StGenTaskTicketRsp.class);
    public final PBStringField ticket = PBField.initString("");
    public final PBUInt32Field taskID = PBField.initUInt32(0);
}
