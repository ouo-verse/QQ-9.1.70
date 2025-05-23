package msf.msgsvc;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class msg_svc$PbGroupMsgWithDrawResp extends MessageMicro<msg_svc$PbGroupMsgWithDrawResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 50, 58, 66}, new String[]{"result", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "uint32_sub_cmd", "uint32_group_type", "uint64_group_code", "failed_msg_list", "bytes_userdef", "msg_wording_info"}, new Object[]{0, "", 0, 0, 0L, null, ByteStringMicro.EMPTY, null}, msg_svc$PbGroupMsgWithDrawResp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBRepeatMessageField<MessageResult> failed_msg_list = PBField.initRepeatMessage(MessageResult.class);
    public final PBBytesField bytes_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
    public msg_svc$WithDrawWordingInfo msg_wording_info = new msg_svc$WithDrawWordingInfo();

    /* loaded from: classes28.dex */
    public static final class MessageResult extends MessageMicro<MessageResult> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48}, new String[]{"uint32_result", "uint32_msg_seq", "uint32_msg_time", "uint32_msg_random", "bytes_err_msg", "uint32_msg_type"}, new Object[]{0, 0, 0, 0, ByteStringMicro.EMPTY, 0}, MessageResult.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
        public final PBUInt32Field uint32_msg_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_msg_random = PBField.initUInt32(0);
        public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    }
}
