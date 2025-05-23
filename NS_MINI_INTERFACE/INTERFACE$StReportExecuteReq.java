package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StReportExecuteReq extends MessageMicro<INTERFACE$StReportExecuteReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"extInfo", "appid", "instrTraceId", "execTime", "ruleName"}, new Object[]{null, "", "", 0, ""}, INTERFACE$StReportExecuteReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField appid = PBField.initString("");
    public final PBStringField instrTraceId = PBField.initString("");
    public final PBInt32Field execTime = PBField.initInt32(0);
    public final PBStringField ruleName = PBField.initString("");
}
