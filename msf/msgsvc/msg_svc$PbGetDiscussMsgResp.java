package msf.msgsvc;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgcomm.msg_comm$Msg;

/* loaded from: classes28.dex */
public final class msg_svc$PbGetDiscussMsgResp extends MessageMicro<msg_svc$PbGetDiscussMsgResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 50, 56, 64}, new String[]{"result", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "discuss_uin", "return_end_seq", "return_begin_seq", "msg", "last_get_time", "discuss_info_seq"}, new Object[]{0, "", 0L, 0L, 0L, null, 0L, 0L}, msg_svc$PbGetDiscussMsgResp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt64Field discuss_uin = PBField.initUInt64(0);
    public final PBUInt64Field return_end_seq = PBField.initUInt64(0);
    public final PBUInt64Field return_begin_seq = PBField.initUInt64(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBRepeatMessageField<msg_comm$Msg> f417533msg = PBField.initRepeatMessage(msg_comm$Msg.class);
    public final PBUInt64Field last_get_time = PBField.initUInt64(0);
    public final PBUInt64Field discuss_info_seq = PBField.initUInt64(0);
}
