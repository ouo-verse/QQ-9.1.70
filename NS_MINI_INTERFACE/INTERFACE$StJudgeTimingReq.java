package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StJudgeTimingReq extends MessageMicro<INTERFACE$StJudgeTimingReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56, 64, 72, 82, 90, 96, 106, 114}, new String[]{"extInfo", "appid", "factType", "duration", "reportTime", "afterCertify", "appType", "scene", "totalTime", "launchId", "via", "AdsTotalTime", "hostExtInfo", "sourceID"}, new Object[]{null, "", 0, 0, 0L, 0, 0, 0, 0, "", "", 0, "", ""}, INTERFACE$StJudgeTimingReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField appid = PBField.initString("");
    public final PBInt32Field factType = PBField.initInt32(0);
    public final PBInt32Field duration = PBField.initInt32(0);
    public final PBInt64Field reportTime = PBField.initInt64(0);
    public final PBInt32Field afterCertify = PBField.initInt32(0);
    public final PBInt32Field appType = PBField.initInt32(0);
    public final PBInt32Field scene = PBField.initInt32(0);
    public final PBInt32Field totalTime = PBField.initInt32(0);
    public final PBStringField launchId = PBField.initString("");
    public final PBStringField via = PBField.initString("");
    public final PBInt32Field AdsTotalTime = PBField.initInt32(0);
    public final PBStringField hostExtInfo = PBField.initString("");
    public final PBStringField sourceID = PBField.initString("");
}
