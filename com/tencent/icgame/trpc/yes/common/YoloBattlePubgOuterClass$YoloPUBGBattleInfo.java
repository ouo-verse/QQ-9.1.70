package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes7.dex */
public final class YoloBattlePubgOuterClass$YoloPUBGBattleInfo extends MessageMicro<YoloBattlePubgOuterClass$YoloPUBGBattleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 66, 74, 82, 90, 800, 810}, new String[]{"status", "pubg_config", "team_id", "leader_role_id", "pubg_schema", "team_mate_wrapper", "last_event_type", "last_event"}, new Object[]{1, null, "", "", null, null, 0, null}, YoloBattlePubgOuterClass$YoloPUBGBattleInfo.class);
    public final PBEnumField status = PBField.initEnum(1);
    public YoloBattlePubgOuterClass$YoloPUBGBattleConfig pubg_config = new YoloBattlePubgOuterClass$YoloPUBGBattleConfig();
    public final PBStringField team_id = PBField.initString("");
    public final PBStringField leader_role_id = PBField.initString("");
    public YoloBattlePubgOuterClass$YoloPUBGSchema pubg_schema = new YoloBattlePubgOuterClass$YoloPUBGSchema();
    public YoloBattlePubgOuterClass$PUBGTeamMateWrapper team_mate_wrapper = new MessageMicro<YoloBattlePubgOuterClass$PUBGTeamMateWrapper>() { // from class: com.tencent.icgame.trpc.yes.common.YoloBattlePubgOuterClass$PUBGTeamMateWrapper
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"team_mate"}, new Object[]{null}, YoloBattlePubgOuterClass$PUBGTeamMateWrapper.class);
        public final PBRepeatMessageField<PubgDataOuterClass$PUBGTeamMate> team_mate = PBField.initRepeatMessage(PubgDataOuterClass$PUBGTeamMate.class);
    };
    public final PBEnumField last_event_type = PBField.initEnum(0);
    public YoloBattlePubgOuterClass$YoloOnePUBGBattleEvent last_event = new YoloBattlePubgOuterClass$YoloOnePUBGBattleEvent();
}
