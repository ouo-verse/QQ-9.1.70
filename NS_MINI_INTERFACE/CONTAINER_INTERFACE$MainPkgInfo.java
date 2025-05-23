package NS_MINI_INTERFACE;

import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class CONTAINER_INTERFACE$MainPkgInfo extends MessageMicro<CONTAINER_INTERFACE$MainPkgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"down_load_url", "version", StartupReportKey.VERSION_ID, "version_update_time", "version_type"}, new Object[]{"", "", "", 0, ""}, CONTAINER_INTERFACE$MainPkgInfo.class);
    public final PBStringField down_load_url = PBField.initString("");
    public final PBStringField version = PBField.initString("");
    public final PBStringField version_id = PBField.initString("");
    public final PBUInt32Field version_update_time = PBField.initUInt32(0);
    public final PBStringField version_type = PBField.initString("");
}
