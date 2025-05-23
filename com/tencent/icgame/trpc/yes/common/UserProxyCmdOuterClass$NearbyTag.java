package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$NearbyTag extends MessageMicro<UserProxyCmdOuterClass$NearbyTag> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"type", "name"}, new Object[]{0, ""}, UserProxyCmdOuterClass$NearbyTag.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBRepeatField<String> name = PBField.initRepeat(PBStringField.__repeatHelper__);
}
