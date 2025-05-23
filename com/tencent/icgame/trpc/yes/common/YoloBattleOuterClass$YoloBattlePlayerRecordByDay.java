package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class YoloBattleOuterClass$YoloBattlePlayerRecordByDay extends MessageMicro<YoloBattleOuterClass$YoloBattlePlayerRecordByDay> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 162}, new String[]{"uid", "today_begin", "smoba_record_by_day"}, new Object[]{0L, "", null}, YoloBattleOuterClass$YoloBattlePlayerRecordByDay.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBStringField today_begin = PBField.initString("");
    public YoloBattleSmobaOuterClass$SmobaPlayerRecordByDay smoba_record_by_day = new MessageMicro<YoloBattleSmobaOuterClass$SmobaPlayerRecordByDay>() { // from class: com.tencent.icgame.trpc.yes.common.YoloBattleSmobaOuterClass$SmobaPlayerRecordByDay
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"battle_num", "win_battle_num"}, new Object[]{0, 0}, YoloBattleSmobaOuterClass$SmobaPlayerRecordByDay.class);
        public final PBInt32Field battle_num = PBField.initInt32(0);
        public final PBInt32Field win_battle_num = PBField.initInt32(0);
    };
}
