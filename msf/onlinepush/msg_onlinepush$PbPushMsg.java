package msf.onlinepush;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgcomm.msg_comm$Msg;

/* loaded from: classes28.dex */
public final class msg_onlinepush$PbPushMsg extends MessageMicro<msg_onlinepush$PbPushMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 72, 80}, new String[]{"msg", "svrip", "bytes_push_token", "ping_flag", "uint32_general_flag", "uint64_bind_uin"}, new Object[]{null, 0, ByteStringMicro.EMPTY, 0, 0, 0L}, msg_onlinepush$PbPushMsg.class);

    /* renamed from: msg, reason: collision with root package name */
    public msg_comm$Msg f417541msg = new msg_comm$Msg();
    public final PBInt32Field svrip = PBField.initInt32(0);
    public final PBBytesField bytes_push_token = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field ping_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_general_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_bind_uin = PBField.initUInt64(0);
}
