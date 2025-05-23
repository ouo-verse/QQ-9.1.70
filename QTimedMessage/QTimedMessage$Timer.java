package QTimedMessage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QTimedMessage$Timer extends MessageMicro<QTimedMessage$Timer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_time"}, new Object[]{0L}, QTimedMessage$Timer.class);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0);
}
