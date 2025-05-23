package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$MiniGameFloat extends MessageMicro<INTERFACE$MiniGameFloat> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"appInfo", QZoneDTLoginReporter.SCHEMA, "display", "via"}, new Object[]{null, "", Boolean.FALSE, ""}, INTERFACE$MiniGameFloat.class);
    public INTERFACE$StApiAppInfo appInfo = new INTERFACE$StApiAppInfo();
    public final PBStringField schema = PBField.initString("");
    public final PBBoolField display = PBField.initBool(false);
    public final PBStringField via = PBField.initString("");
}
