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
public final class msg_svc$PbGetGroupMsgResp extends MessageMicro<msg_svc$PbGetGroupMsgResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 50, 72}, new String[]{"result", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "group_code", "return_begin_seq", "return_end_seq", "msg", "uint32_has_share_history_msg"}, new Object[]{0, "", 0L, 0L, 0L, null, 0}, msg_svc$PbGetGroupMsgResp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt64Field return_begin_seq = PBField.initUInt64(0);
    public final PBUInt64Field return_end_seq = PBField.initUInt64(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBRepeatMessageField<msg_comm$Msg> f417534msg = PBField.initRepeatMessage(msg_comm$Msg.class);
    public final PBUInt32Field uint32_has_share_history_msg = PBField.initUInt32(0);
}
