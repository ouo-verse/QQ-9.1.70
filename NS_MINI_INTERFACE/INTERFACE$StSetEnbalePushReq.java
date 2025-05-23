package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class INTERFACE$StSetEnbalePushReq extends MessageMicro<INTERFACE$StSetEnbalePushReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"appid", "enablePush"}, new Object[]{"", 0}, INTERFACE$StSetEnbalePushReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBUInt32Field enablePush = PBField.initUInt32(0);
}
