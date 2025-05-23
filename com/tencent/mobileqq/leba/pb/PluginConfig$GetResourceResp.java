package com.tencent.mobileqq.leba.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes15.dex */
public final class PluginConfig$GetResourceResp extends MessageMicro<PluginConfig$GetResourceResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"plugin_type", "respinfo_list", "plugin_layout"}, new Object[]{0, null, null}, PluginConfig$GetResourceResp.class);
    public final PBUInt32Field plugin_type = PBField.initUInt32(0);
    public final PBRepeatMessageField<PluginConfig$GetResourceRespInfo> respinfo_list = PBField.initRepeatMessage(PluginConfig$GetResourceRespInfo.class);
    public PluginConfig$PluginLayout plugin_layout = new PluginConfig$PluginLayout();
}
