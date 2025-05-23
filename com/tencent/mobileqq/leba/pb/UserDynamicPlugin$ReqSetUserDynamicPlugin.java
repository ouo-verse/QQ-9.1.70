package com.tencent.mobileqq.leba.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes15.dex */
public final class UserDynamicPlugin$ReqSetUserDynamicPlugin extends MessageMicro<UserDynamicPlugin$ReqSetUserDynamicPlugin> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"plugin_id", "last_time", "plugin_type"}, new Object[]{0, 0, 0}, UserDynamicPlugin$ReqSetUserDynamicPlugin.class);
    public final PBRepeatField<Integer> plugin_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field last_time = PBField.initUInt32(0);
    public final PBUInt32Field plugin_type = PBField.initUInt32(0);
}
