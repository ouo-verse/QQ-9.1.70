package NS_MINI_INTERFACE;

import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$MiniGameBoxRedDot extends MessageMicro<INTERFACE$MiniGameBoxRedDot> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48}, new String[]{"display", "adID", "adPosID", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "ext", "source"}, new Object[]{Boolean.FALSE, 0, 0, "", "", 0}, INTERFACE$MiniGameBoxRedDot.class);
    public final PBBoolField display = PBField.initBool(false);
    public final PBUInt32Field adID = PBField.initUInt32(0);
    public final PBUInt32Field adPosID = PBField.initUInt32(0);
    public final PBStringField traceInfo = PBField.initString("");
    public final PBStringField ext = PBField.initString("");
    public final PBUInt32Field source = PBField.initUInt32(0);
}
