package com.tencent.mobileqq.leba.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes15.dex */
public final class UserSetDynamicPlugin$GetListResponse extends MessageMicro<UserSetDynamicPlugin$GetListResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40}, new String[]{"plugin_data", "max_dynamic_num", "sequence", "reson_code", "style"}, new Object[]{null, 0, 0L, 0, 0}, UserSetDynamicPlugin$GetListResponse.class);
    public final PBRepeatMessageField<UserSetDynamicPlugin$PluginData> plugin_data = PBField.initRepeatMessage(UserSetDynamicPlugin$PluginData.class);
    public final PBUInt32Field max_dynamic_num = PBField.initUInt32(0);
    public final PBUInt64Field sequence = PBField.initUInt64(0);
    public final PBUInt32Field reson_code = PBField.initUInt32(0);
    public final PBEnumField style = PBField.initEnum(0);
}
