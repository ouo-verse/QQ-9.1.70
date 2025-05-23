package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class msg_svc$PbC2CMsgWithDrawReq extends MessageMicro<msg_svc$PbC2CMsgWithDrawReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"msg_info", "uint32_long_message_flag", "bytes_reserved", "uint32_sub_cmd"}, new Object[]{null, 0, ByteStringMicro.EMPTY, 0}, msg_svc$PbC2CMsgWithDrawReq.class);
    public final PBRepeatMessageField<MsgInfo> msg_info = PBField.initRepeatMessage(MsgInfo.class);
    public final PBUInt32Field uint32_long_message_flag = PBField.initUInt32(0);
    public final PBBytesField bytes_reserved = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);

    /* loaded from: classes28.dex */
    public static final class MsgInfo extends MessageMicro<MsgInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 162}, new String[]{"uint64_from_uin", "uint64_to_uin", "uint32_msg_seq", "uint64_msg_uid", "uint64_msg_time", "uint32_msg_random", "uint32_pkg_num", "uint32_pkg_index", "uint32_div_seq", "uint32_msg_type", "routing_head"}, new Object[]{0L, 0L, 0, 0L, 0L, 0, 0, 0, 0, 0, null}, MsgInfo.class);
        public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
        public final PBUInt64Field uint64_msg_uid = PBField.initUInt64(0);
        public final PBUInt64Field uint64_msg_time = PBField.initUInt64(0);
        public final PBUInt32Field uint32_msg_random = PBField.initUInt32(0);
        public final PBUInt32Field uint32_pkg_num = PBField.initUInt32(0);
        public final PBUInt32Field uint32_pkg_index = PBField.initUInt32(0);
        public final PBUInt32Field uint32_div_seq = PBField.initUInt32(0);
        public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
        public msg_svc$RoutingHead routing_head = new msg_svc$RoutingHead();
    }
}
