package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class msg_svc$Dis extends MessageMicro<msg_svc$Dis> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"dis_uin"}, new Object[]{0L}, msg_svc$Dis.class);
    public final PBUInt64Field dis_uin = PBField.initUInt64(0);
}
