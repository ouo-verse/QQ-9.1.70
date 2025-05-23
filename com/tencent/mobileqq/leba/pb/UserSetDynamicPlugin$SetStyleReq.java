package com.tencent.mobileqq.leba.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes15.dex */
public final class UserSetDynamicPlugin$SetStyleReq extends MessageMicro<UserSetDynamicPlugin$SetStyleReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"platform_type", "plugin_type", "style"}, new Object[]{0, 0, 0}, UserSetDynamicPlugin$SetStyleReq.class);
    public final PBUInt32Field platform_type = PBField.initUInt32(0);
    public final PBUInt32Field plugin_type = PBField.initUInt32(0);
    public final PBEnumField style = PBField.initEnum(0);
}
