package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StSubscribeMessage extends MessageMicro<INTERFACE$StSubscribeMessage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"templateId", "authState", "example"}, new Object[]{"", 0, null}, INTERFACE$StSubscribeMessage.class);
    public final PBStringField templateId = PBField.initString("");
    public final PBInt32Field authState = PBField.initInt32(0);
    public INTERFACE$StExampleDetail example = new INTERFACE$StExampleDetail();
}
