package msf.msgsvc;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class msg_svc$PbGroupReadedReportResp extends MessageMicro<msg_svc$PbGroupReadedReportResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40}, new String[]{"result", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "group_code", "member_seq", "group_msg_seq"}, new Object[]{0, "", 0L, 0L, 0L}, msg_svc$PbGroupReadedReportResp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt64Field member_seq = PBField.initUInt64(0);
    public final PBUInt64Field group_msg_seq = PBField.initUInt64(0);
}
