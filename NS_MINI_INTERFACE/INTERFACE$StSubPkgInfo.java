package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class INTERFACE$StSubPkgInfo extends MessageMicro<INTERFACE$StSubPkgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50, 58, 66, 74}, new String[]{"subPkgName", "dowLoadUrl", "independent", "file_size", "version", "versionId", "mainPackVersion", "version_type", "prefetch_config"}, new Object[]{"", "", 0, 0, "", "", "", "", ""}, INTERFACE$StSubPkgInfo.class);
    public final PBStringField subPkgName = PBField.initString("");
    public final PBStringField dowLoadUrl = PBField.initString("");
    public final PBInt32Field independent = PBField.initInt32(0);
    public final PBInt32Field file_size = PBField.initInt32(0);
    public final PBStringField version = PBField.initString("");
    public final PBStringField versionId = PBField.initString("");
    public final PBStringField mainPackVersion = PBField.initString("");
    public final PBStringField version_type = PBField.initString("");
    public final PBStringField prefetch_config = PBField.initString("");
}
