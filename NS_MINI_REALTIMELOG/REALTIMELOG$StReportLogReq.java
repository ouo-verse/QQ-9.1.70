package NS_MINI_REALTIMELOG;

import NS_COMM.COMM;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class REALTIMELOG$StReportLogReq extends MessageMicro<REALTIMELOG$StReportLogReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 58, 66}, new String[]{"extInfo", "traceid", "report_time", StartupReportKey.JSLIB_VERSION, "page", "filter_msgs", "logs", "appid"}, new Object[]{null, "", 0L, "", "", "", null, ""}, REALTIMELOG$StReportLogReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField traceid = PBField.initString("");
    public final PBInt64Field report_time = PBField.initInt64(0);
    public final PBStringField jslib_version = PBField.initString("");
    public final PBStringField page = PBField.initString("");
    public final PBRepeatField<String> filter_msgs = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatMessageField<REALTIMELOG$StLogItem> logs = PBField.initRepeatMessage(REALTIMELOG$StLogItem.class);
    public final PBStringField appid = PBField.initString("");
}
