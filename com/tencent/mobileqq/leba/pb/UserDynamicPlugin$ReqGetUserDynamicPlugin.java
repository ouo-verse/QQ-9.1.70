package com.tencent.mobileqq.leba.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes15.dex */
public final class UserDynamicPlugin$ReqGetUserDynamicPlugin extends MessageMicro<UserDynamicPlugin$ReqGetUserDynamicPlugin> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"platform", "plugin_type"}, new Object[]{0, 0}, UserDynamicPlugin$ReqGetUserDynamicPlugin.class);
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBUInt32Field plugin_type = PBField.initUInt32(0);
}
