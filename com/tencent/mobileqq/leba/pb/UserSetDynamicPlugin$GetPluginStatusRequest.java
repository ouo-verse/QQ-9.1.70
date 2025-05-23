package com.tencent.mobileqq.leba.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes15.dex */
public final class UserSetDynamicPlugin$GetPluginStatusRequest extends MessageMicro<UserSetDynamicPlugin$GetPluginStatusRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"uin", "platform_type", "plugin_type", "id"}, new Object[]{"", 0, 0, 0}, UserSetDynamicPlugin$GetPluginStatusRequest.class);
    public final PBStringField uin = PBField.initString("");
    public final PBUInt32Field platform_type = PBField.initUInt32(0);
    public final PBUInt32Field plugin_type = PBField.initUInt32(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBRepeatField<Integer> f240726id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
