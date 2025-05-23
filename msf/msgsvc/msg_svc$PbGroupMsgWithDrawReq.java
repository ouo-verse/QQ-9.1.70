package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class msg_svc$PbGroupMsgWithDrawReq extends MessageMicro<msg_svc$PbGroupMsgWithDrawReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"uint32_sub_cmd", "uint32_group_type", "uint64_group_code", "msg_list", "bytes_userdef"}, new Object[]{0, 0, 0L, null, ByteStringMicro.EMPTY}, msg_svc$PbGroupMsgWithDrawReq.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBRepeatMessageField<MessageInfo> msg_list = PBField.initRepeatMessage(MessageInfo.class);
    public final PBBytesField bytes_userdef = PBField.initBytes(ByteStringMicro.EMPTY);

    /* loaded from: classes28.dex */
    public static final class MessageInfo extends MessageMicro<MessageInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint32_msg_seq", "uint32_msg_random", "uint32_msg_type", "uint32_resv_flag"}, new Object[]{0, 0, 0, 0}, MessageInfo.class);
        public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
        public final PBUInt32Field uint32_msg_random = PBField.initUInt32(0);
        public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_resv_flag = PBField.initUInt32(0);
    }
}
