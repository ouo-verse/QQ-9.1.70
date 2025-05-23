package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloBattleOuterClass$YoloBattleTimerData extends MessageMicro<YoloBattleOuterClass$YoloBattleTimerData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48, 58}, new String[]{"timeout", "pre_status_version", "next_event", "timer_type", "recycle_times", "trigger_filter_type", "pre_event_name"}, new Object[]{0L, 0, null, 0, 0, 0, ""}, YoloBattleOuterClass$YoloBattleTimerData.class);
    public final PBUInt64Field timeout = PBField.initUInt64(0);
    public final PBInt32Field pre_status_version = PBField.initInt32(0);
    public YoloBattleOuterClass$YoloBattleEventReq next_event = new MessageMicro<YoloBattleOuterClass$YoloBattleEventReq>() { // from class: com.tencent.icgame.trpc.yes.common.YoloBattleOuterClass$YoloBattleEventReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"base_info", "player_info", "event_id", "extra_data"}, new Object[]{null, null, 0, ""}, YoloBattleOuterClass$YoloBattleEventReq.class);
        public YoloBattleOuterClass$YoloBattleBaseInfo base_info = new YoloBattleOuterClass$YoloBattleBaseInfo();
        public YoloBattleOuterClass$YoloBattlePlayerInfo player_info = new YoloBattleOuterClass$YoloBattlePlayerInfo();
        public final PBUInt32Field event_id = PBField.initUInt32(0);
        public final PBStringField extra_data = PBField.initString("");
    };
    public final PBEnumField timer_type = PBField.initEnum(0);
    public final PBInt32Field recycle_times = PBField.initInt32(0);
    public final PBEnumField trigger_filter_type = PBField.initEnum(0);
    public final PBStringField pre_event_name = PBField.initString("");
}
