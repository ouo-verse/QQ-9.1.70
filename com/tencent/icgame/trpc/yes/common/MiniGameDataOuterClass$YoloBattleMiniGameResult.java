package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class MiniGameDataOuterClass$YoloBattleMiniGameResult extends MessageMicro<MiniGameDataOuterClass$YoloBattleMiniGameResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48}, new String[]{"battle_id", "battle_result_flag", "battle_result", "battle_result_code", "has_strong_check", "strong_check_cost_ms"}, new Object[]{0L, 0, null, 0, Boolean.FALSE, 0}, MiniGameDataOuterClass$YoloBattleMiniGameResult.class);
    public final PBUInt64Field battle_id = PBField.initUInt64(0);
    public final PBInt32Field battle_result_flag = PBField.initInt32(0);
    public final PBRepeatMessageField<MiniGameDataOuterClass$YoloBattleMiniGamePlayerResult> battle_result = PBField.initRepeatMessage(MiniGameDataOuterClass$YoloBattleMiniGamePlayerResult.class);
    public final PBInt32Field battle_result_code = PBField.initInt32(0);
    public final PBBoolField has_strong_check = PBField.initBool(false);
    public final PBInt32Field strong_check_cost_ms = PBField.initInt32(0);
}
