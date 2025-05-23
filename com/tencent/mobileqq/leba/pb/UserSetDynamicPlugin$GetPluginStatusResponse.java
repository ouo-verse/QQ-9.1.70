package com.tencent.mobileqq.leba.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes15.dex */
public final class UserSetDynamicPlugin$GetPluginStatusResponse extends MessageMicro<UserSetDynamicPlugin$GetPluginStatusResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"plugin_data"}, new Object[]{null}, UserSetDynamicPlugin$GetPluginStatusResponse.class);
    public final PBRepeatMessageField<UserSetDynamicPlugin$PluginData> plugin_data = PBField.initRepeatMessage(UserSetDynamicPlugin$PluginData.class);
}
