package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StContactInfo extends MessageMicro<INTERFACE$StContactInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"appId", "plugin_list"}, new Object[]{"", null}, INTERFACE$StContactInfo.class);
    public final PBStringField appId = PBField.initString("");
    public final PBRepeatMessageField<INTERFACE$StPluginDetail> plugin_list = PBField.initRepeatMessage(INTERFACE$StPluginDetail.class);
}
