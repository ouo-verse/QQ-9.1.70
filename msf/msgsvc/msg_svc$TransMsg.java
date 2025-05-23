package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class msg_svc$TransMsg extends MessageMicro<msg_svc$TransMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"to_uin", "c2c_cmd"}, new Object[]{0L, 0}, msg_svc$TransMsg.class);
    public final PBUInt64Field to_uin = PBField.initUInt64(0);
    public final PBUInt32Field c2c_cmd = PBField.initUInt32(0);
}
