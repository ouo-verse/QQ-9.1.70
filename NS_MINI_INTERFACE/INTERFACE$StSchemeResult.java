package NS_MINI_INTERFACE;

import com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StSchemeResult extends MessageMicro<INTERFACE$StSchemeResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{PreloadingFragment.KEY_APPID, QZoneDTLoginReporter.SCHEMA, "ret"}, new Object[]{"", "", 0}, INTERFACE$StSchemeResult.class);
    public final PBStringField mini_appid = PBField.initString("");
    public final PBStringField schema = PBField.initString("");
    public final PBInt32Field ret = PBField.initInt32(0);
}
