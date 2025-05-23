package msf.msgcomm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class msg_comm$DiscussInfo extends MessageMicro<msg_comm$DiscussInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField discuss_name;
    public final PBBytesField discuss_remark;
    public final PBUInt64Field discuss_uin = PBField.initUInt64(0);
    public final PBUInt32Field discuss_type = PBField.initUInt32(0);
    public final PBUInt64Field discuss_info_seq = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"discuss_uin", "discuss_type", "discuss_info_seq", "discuss_remark", "discuss_name"}, new Object[]{0L, 0, 0L, byteStringMicro, byteStringMicro}, msg_comm$DiscussInfo.class);
    }

    public msg_comm$DiscussInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.discuss_remark = PBField.initBytes(byteStringMicro);
        this.discuss_name = PBField.initBytes(byteStringMicro);
    }
}
