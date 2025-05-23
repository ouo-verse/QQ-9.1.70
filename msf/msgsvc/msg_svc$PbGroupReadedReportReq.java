package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class msg_svc$PbGroupReadedReportReq extends MessageMicro<msg_svc$PbGroupReadedReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"group_code", "last_read_seq"}, new Object[]{0L, 0L}, msg_svc$PbGroupReadedReportReq.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt64Field last_read_seq = PBField.initUInt64(0);
}
