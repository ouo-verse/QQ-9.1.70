package com.qzone.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class SocialTree$GettWaterTaskListReq extends MessageMicro<SocialTree$GettWaterTaskListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uin", "id_list"}, new Object[]{0L, 0}, SocialTree$GettWaterTaskListReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBRepeatField<Integer> id_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
