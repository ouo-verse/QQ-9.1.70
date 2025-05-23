package NS_MINI_INTERFACE;

import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class CONTAINER_INTERFACE$SubPkgInfo extends MessageMicro<CONTAINER_INTERFACE$SubPkgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50, 58, 66, 74}, new String[]{"sub_pkg_name", "down_load_url", "independent", "file_size", "version", StartupReportKey.VERSION_ID, "main_pack_version", "version_type", "prefetch_config"}, new Object[]{"", "", 0, 0, "", "", "", "", ""}, CONTAINER_INTERFACE$SubPkgInfo.class);
    public final PBStringField sub_pkg_name = PBField.initString("");
    public final PBStringField down_load_url = PBField.initString("");
    public final PBInt32Field independent = PBField.initInt32(0);
    public final PBInt32Field file_size = PBField.initInt32(0);
    public final PBStringField version = PBField.initString("");
    public final PBStringField version_id = PBField.initString("");
    public final PBStringField main_pack_version = PBField.initString("");
    public final PBStringField version_type = PBField.initString("");
    public final PBStringField prefetch_config = PBField.initString("");
}
