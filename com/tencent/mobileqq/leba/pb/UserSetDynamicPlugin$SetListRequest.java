package com.tencent.mobileqq.leba.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes15.dex */
public final class UserSetDynamicPlugin$SetListRequest extends MessageMicro<UserSetDynamicPlugin$SetListRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"platform_type", "plugin_type", "plugin_data"}, new Object[]{0, 0, null}, UserSetDynamicPlugin$SetListRequest.class);
    public final PBUInt32Field platform_type = PBField.initUInt32(0);
    public final PBUInt32Field plugin_type = PBField.initUInt32(0);
    public final PBRepeatMessageField<UserSetDynamicPlugin$PluginData> plugin_data = PBField.initRepeatMessage(UserSetDynamicPlugin$PluginData.class);
}
