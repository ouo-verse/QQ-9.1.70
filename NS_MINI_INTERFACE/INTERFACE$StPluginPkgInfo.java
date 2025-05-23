package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class INTERFACE$StPluginPkgInfo extends MessageMicro<INTERFACE$StPluginPkgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"pluginId", "version", "pkgUrl"}, new Object[]{"", "", ""}, INTERFACE$StPluginPkgInfo.class);
    public final PBStringField pluginId = PBField.initString("");
    public final PBStringField version = PBField.initString("");
    public final PBStringField pkgUrl = PBField.initString("");
}
