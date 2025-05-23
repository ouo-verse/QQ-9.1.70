package com.tencent.mobileqq.leba.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes15.dex */
public final class UserSetDynamicPlugin$PluginData extends MessageMicro<UserSetDynamicPlugin$PluginData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"id", "type", "version", "ts"}, new Object[]{0, 0, 0, 0L}, UserSetDynamicPlugin$PluginData.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f240727id = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);

    /* renamed from: ts, reason: collision with root package name */
    public final PBInt64Field f240728ts = PBField.initInt64(0);
}
