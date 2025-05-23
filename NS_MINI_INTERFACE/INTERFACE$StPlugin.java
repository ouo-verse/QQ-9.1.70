package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class INTERFACE$StPlugin extends MessageMicro<INTERFACE$StPlugin> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"plugin_id", "inner_version"}, new Object[]{"", ""}, INTERFACE$StPlugin.class);
    public final PBStringField plugin_id = PBField.initString("");
    public final PBStringField inner_version = PBField.initString("");
}
