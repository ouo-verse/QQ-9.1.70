package msf.msgcomm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class msg_comm$MsgType0x210 extends MessageMicro<msg_comm$MsgType0x210> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"sub_msg_type", "msg_content"}, new Object[]{0, ByteStringMicro.EMPTY}, msg_comm$MsgType0x210.class);
    public final PBUInt32Field sub_msg_type = PBField.initUInt32(0);
    public final PBBytesField msg_content = PBField.initBytes(ByteStringMicro.EMPTY);
}
