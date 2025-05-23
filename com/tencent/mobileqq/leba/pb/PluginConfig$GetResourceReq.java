package com.tencent.mobileqq.leba.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes15.dex */
public final class PluginConfig$GetResourceReq extends MessageMicro<PluginConfig$GetResourceReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40}, new String[]{"reqinfo_list", "plugin_type", "plugin_layout_seq", "style", "mode"}, new Object[]{null, 0, 0, 0, 0}, PluginConfig$GetResourceReq.class);
    public final PBRepeatMessageField<PluginConfig$GetResourceReqInfo> reqinfo_list = PBField.initRepeatMessage(PluginConfig$GetResourceReqInfo.class);
    public final PBUInt32Field plugin_type = PBField.initUInt32(0);
    public final PBUInt32Field plugin_layout_seq = PBField.initUInt32(0);
    public final PBEnumField style = PBField.initEnum(0);
    public final PBEnumField mode = PBField.initEnum(0);
}
