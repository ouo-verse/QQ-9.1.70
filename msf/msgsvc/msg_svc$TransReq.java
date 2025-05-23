package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class msg_svc$TransReq extends MessageMicro<msg_svc$TransReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"command", "req_tag", "req_buff"}, new Object[]{0, 0, ByteStringMicro.EMPTY}, msg_svc$TransReq.class);
    public final PBInt32Field command = PBField.initInt32(0);
    public final PBUInt32Field req_tag = PBField.initUInt32(0);
    public final PBBytesField req_buff = PBField.initBytes(ByteStringMicro.EMPTY);
}
