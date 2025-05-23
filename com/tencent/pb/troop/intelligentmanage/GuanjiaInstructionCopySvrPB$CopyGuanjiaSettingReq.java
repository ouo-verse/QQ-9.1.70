package com.tencent.pb.troop.intelligentmanage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class GuanjiaInstructionCopySvrPB$CopyGuanjiaSettingReq extends MessageMicro<GuanjiaInstructionCopySvrPB$CopyGuanjiaSettingReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"guanjia_settings", "from_group", "to_groups"}, new Object[]{0, 0L, 0L}, GuanjiaInstructionCopySvrPB$CopyGuanjiaSettingReq.class);
    public final PBRepeatField<Integer> guanjia_settings = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBUInt64Field from_group = PBField.initUInt64(0);
    public final PBRepeatField<Long> to_groups = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
