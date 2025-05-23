package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes28.dex */
public final class msg_svc$PbMsgReadedReportReq extends MessageMicro<msg_svc$PbMsgReadedReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"grp_read_report", "dis_read_report", "c2c_read_report", "bind_uin_read_report"}, new Object[]{null, null, null, null}, msg_svc$PbMsgReadedReportReq.class);
    public final PBRepeatMessageField<msg_svc$PbGroupReadedReportReq> grp_read_report = PBField.initRepeatMessage(msg_svc$PbGroupReadedReportReq.class);
    public final PBRepeatMessageField<msg_svc$PbDiscussReadedReportReq> dis_read_report = PBField.initRepeatMessage(msg_svc$PbDiscussReadedReportReq.class);
    public msg_svc$PbC2CReadedReportReq c2c_read_report = new msg_svc$PbC2CReadedReportReq();
    public msg_svc$PbBindUinMsgReadedConfirmReq bind_uin_read_report = new msg_svc$PbBindUinMsgReadedConfirmReq();
}
