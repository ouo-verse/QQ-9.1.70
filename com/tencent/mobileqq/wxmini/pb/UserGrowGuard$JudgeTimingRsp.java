package com.tencent.mobileqq.wxmini.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class UserGrowGuard$JudgeTimingRsp extends MessageMicro<UserGrowGuard$JudgeTimingRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"ext_info", "next_duration", "instructions"}, new Object[]{null, 0, null}, UserGrowGuard$JudgeTimingRsp.class);
    public UserGrowGuard$CommonExt ext_info = new UserGrowGuard$CommonExt();
    public final PBInt32Field next_duration = PBField.initInt32(0);
    public final PBRepeatMessageField<UserGrowGuard$GuardInstruction> instructions = PBField.initRepeatMessage(UserGrowGuard$GuardInstruction.class);
}
