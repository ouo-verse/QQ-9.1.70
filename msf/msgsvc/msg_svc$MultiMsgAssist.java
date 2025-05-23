package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class msg_svc$MultiMsgAssist extends MessageMicro<msg_svc$MultiMsgAssist> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 48, 56, 64}, new String[]{"repeated_routing", "msg_use", "uint64_temp_id", "uint64_vedio_len", "bytes_redbag_id", "uint64_redbag_amount", "uint32_has_readbag", "uint32_has_vedio"}, new Object[]{null, 1, 0L, 0L, ByteStringMicro.EMPTY, 0L, 0, 0}, msg_svc$MultiMsgAssist.class);
    public final PBRepeatMessageField<msg_svc$RoutingHead> repeated_routing = PBField.initRepeatMessage(msg_svc$RoutingHead.class);
    public final PBEnumField msg_use = PBField.initEnum(1);
    public final PBUInt64Field uint64_temp_id = PBField.initUInt64(0);
    public final PBUInt64Field uint64_vedio_len = PBField.initUInt64(0);
    public final PBBytesField bytes_redbag_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_redbag_amount = PBField.initUInt64(0);
    public final PBUInt32Field uint32_has_readbag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_has_vedio = PBField.initUInt32(0);
}
