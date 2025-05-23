package msf.msgcomm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;

/* loaded from: classes28.dex */
public final class msg_comm$UinPairMsg extends MessageMicro<msg_comm$UinPairMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 64, 72, 82, 88}, new String[]{"last_read_time", ProtocolDownloaderConstants.HEADER_FRIEND_UIN, "msg_completed", "msg", "unread_msg_num", "c2c_type", "service_type", "bytes_pb_reserve", "uint64_to_tiny_id"}, new Object[]{0, 0L, 0, null, 0, 0, 0, ByteStringMicro.EMPTY, 0L}, msg_comm$UinPairMsg.class);
    public final PBUInt32Field last_read_time = PBField.initUInt32(0);
    public final PBUInt64Field peer_uin = PBField.initUInt64(0);
    public final PBUInt32Field msg_completed = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBRepeatMessageField<msg_comm$Msg> f417532msg = PBField.initRepeatMessage(msg_comm$Msg.class);
    public final PBUInt32Field unread_msg_num = PBField.initUInt32(0);
    public final PBUInt32Field c2c_type = PBField.initUInt32(0);
    public final PBUInt32Field service_type = PBField.initUInt32(0);
    public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_to_tiny_id = PBField.initUInt64(0);
}
