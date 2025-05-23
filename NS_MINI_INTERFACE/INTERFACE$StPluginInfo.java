package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class INTERFACE$StPluginInfo extends MessageMicro<INTERFACE$StPluginInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, new String[]{"pluginId", "pluginName", "version", "url", "fileSize"}, new Object[]{"", "", "", "", 0}, INTERFACE$StPluginInfo.class);
    public final PBStringField pluginId = PBField.initString("");
    public final PBStringField pluginName = PBField.initString("");
    public final PBStringField version = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBInt32Field fileSize = PBField.initInt32(0);
}
