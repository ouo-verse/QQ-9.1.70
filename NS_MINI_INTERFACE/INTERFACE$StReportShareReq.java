package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StReportShareReq extends MessageMicro<INTERFACE$StReportShareReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 48, 56, 66}, new String[]{"extInfo", "reportTime", "appid", "appType", "shareScene", "shareType", "destType", "destId"}, new Object[]{null, 0L, "", 0, 0, 0, 0, ""}, INTERFACE$StReportShareReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt64Field reportTime = PBField.initInt64(0);
    public final PBStringField appid = PBField.initString("");
    public final PBInt32Field appType = PBField.initInt32(0);
    public final PBUInt32Field shareScene = PBField.initUInt32(0);
    public final PBUInt32Field shareType = PBField.initUInt32(0);
    public final PBUInt32Field destType = PBField.initUInt32(0);
    public final PBStringField destId = PBField.initString("");
}
