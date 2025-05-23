package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloBattleCodmOuterClass$YoloCODMBattleConfig extends MessageMicro<YoloBattleCodmOuterClass$YoloCODMBattleConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"room_type", "play_list"}, new Object[]{0, ""}, YoloBattleCodmOuterClass$YoloCODMBattleConfig.class);
    public final PBUInt32Field room_type = PBField.initUInt32(0);
    public final PBRepeatField<String> play_list = PBField.initRepeat(PBStringField.__repeatHelper__);
}
