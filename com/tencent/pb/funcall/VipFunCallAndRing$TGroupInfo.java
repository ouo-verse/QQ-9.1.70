package com.tencent.pb.funcall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class VipFunCallAndRing$TGroupInfo extends MessageMicro<VipFunCallAndRing$TGroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, new String[]{"i32_group_id", "str_group_name", "i32_ring_id", "u64_group_uins", "st_src_info"}, new Object[]{0, "", 0, 0L, null}, VipFunCallAndRing$TGroupInfo.class);
    public final PBInt32Field i32_group_id = PBField.initInt32(0);
    public final PBStringField str_group_name = PBField.initString("");
    public final PBInt32Field i32_ring_id = PBField.initInt32(0);
    public final PBRepeatField<Long> u64_group_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public VipFunCallAndRing$TSourceInfo st_src_info = new VipFunCallAndRing$TSourceInfo();
}
