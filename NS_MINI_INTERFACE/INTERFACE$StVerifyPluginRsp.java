package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes.dex */
public final class INTERFACE$StVerifyPluginRsp extends MessageMicro<INTERFACE$StVerifyPluginRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"pluginList"}, new Object[]{null}, INTERFACE$StVerifyPluginRsp.class);
    public final PBRepeatMessageField<INTERFACE$StPluginProfile> pluginList = PBField.initRepeatMessage(INTERFACE$StPluginProfile.class);
}
