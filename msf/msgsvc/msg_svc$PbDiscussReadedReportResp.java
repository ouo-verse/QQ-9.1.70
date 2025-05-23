package msf.msgsvc;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class msg_svc$PbDiscussReadedReportResp extends MessageMicro<msg_svc$PbDiscussReadedReportResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40}, new String[]{"result", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "conf_uin", "member_seq", "conf_seq"}, new Object[]{0, "", 0L, 0L, 0L}, msg_svc$PbDiscussReadedReportResp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt64Field conf_uin = PBField.initUInt64(0);
    public final PBUInt64Field member_seq = PBField.initUInt64(0);
    public final PBUInt64Field conf_seq = PBField.initUInt64(0);
}
