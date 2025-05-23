package com.tencent.av.avsdkconfig.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class CommonConfig$Ability extends MessageMicro<CommonConfig$Ability> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"scenes", "certain_ability"}, new Object[]{0L, null}, CommonConfig$Ability.class);
    public final PBUInt64Field scenes = PBField.initUInt64(0);
    public final PBRepeatMessageField<CommonConfig$CertainAbility> certain_ability = PBField.initRepeatMessage(CommonConfig$CertainAbility.class);
}
