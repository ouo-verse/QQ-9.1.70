package QTimedMessage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QTimedMessage$Client extends MessageMicro<QTimedMessage$Client> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_PC", "uint32_Mobile"}, new Object[]{0, 0}, QTimedMessage$Client.class);
    public final PBUInt32Field uint32_PC = PBField.initUInt32(0);
    public final PBUInt32Field uint32_Mobile = PBField.initUInt32(0);
}
