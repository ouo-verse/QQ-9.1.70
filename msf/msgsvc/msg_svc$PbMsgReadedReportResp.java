package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes28.dex */
public final class msg_svc$PbMsgReadedReportResp extends MessageMicro<msg_svc$PbMsgReadedReportResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"grp_read_report", "dis_read_report", "c2c_read_report", "bind_uin_read_report"}, new Object[]{null, null, null, null}, msg_svc$PbMsgReadedReportResp.class);
    public final PBRepeatMessageField<msg_svc$PbGroupReadedReportResp> grp_read_report = PBField.initRepeatMessage(msg_svc$PbGroupReadedReportResp.class);
    public final PBRepeatMessageField<msg_svc$PbDiscussReadedReportResp> dis_read_report = PBField.initRepeatMessage(msg_svc$PbDiscussReadedReportResp.class);
    public msg_svc$PbC2CReadedReportResp c2c_read_report = new msg_svc$PbC2CReadedReportResp();
    public msg_svc$PbBindUinMsgReadedConfirmResp bind_uin_read_report = new msg_svc$PbBindUinMsgReadedConfirmResp();
}
