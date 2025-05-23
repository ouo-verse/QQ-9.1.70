package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class NearbyUserCenter$NearbyTag extends MessageMicro<NearbyUserCenter$NearbyTag> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"type", "name"}, new Object[]{0, ""}, NearbyUserCenter$NearbyTag.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBRepeatField<String> name = PBField.initRepeat(PBStringField.__repeatHelper__);
}
