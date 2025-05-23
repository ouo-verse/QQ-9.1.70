package msf.msgsvc;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import msf.msgsvc.msg_svc$PbC2CMsgWithDrawReq;

/* loaded from: classes28.dex */
public final class msg_svc$PbC2CMsgWithDrawResp extends MessageMicro<msg_svc$PbC2CMsgWithDrawResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42}, new String[]{"result", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "msg_status", "uint32_sub_cmd", "msg_wording_info"}, new Object[]{0, "", null, 0, null}, msg_svc$PbC2CMsgWithDrawResp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBRepeatMessageField<MsgStatus> msg_status = PBField.initRepeatMessage(MsgStatus.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public msg_svc$WithDrawWordingInfo msg_wording_info = new msg_svc$WithDrawWordingInfo();

    /* loaded from: classes28.dex */
    public static final class MsgStatus extends MessageMicro<MsgStatus> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"msg_info", "uint32_status"}, new Object[]{null, 0}, MsgStatus.class);
        public msg_svc$PbC2CMsgWithDrawReq.MsgInfo msg_info = new msg_svc$PbC2CMsgWithDrawReq.MsgInfo();
        public final PBUInt32Field uint32_status = PBField.initUInt32(0);
    }
}
