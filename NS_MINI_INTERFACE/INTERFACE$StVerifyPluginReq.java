package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class INTERFACE$StVerifyPluginReq extends MessageMicro<INTERFACE$StVerifyPluginReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"appid", "plugins"}, new Object[]{"", null}, INTERFACE$StVerifyPluginReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBRepeatMessageField<INTERFACE$StPlugin> plugins = PBField.initRepeatMessage(INTERFACE$StPlugin.class);
}
