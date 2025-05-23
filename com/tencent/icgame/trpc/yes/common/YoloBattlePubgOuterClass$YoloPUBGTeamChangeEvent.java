package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class YoloBattlePubgOuterClass$YoloPUBGTeamChangeEvent extends MessageMicro<YoloBattlePubgOuterClass$YoloPUBGTeamChangeEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 82}, new String[]{"role_id", "yes_uid", "team_info", "join_team_schema"}, new Object[]{"", 0L, null, null}, YoloBattlePubgOuterClass$YoloPUBGTeamChangeEvent.class);
    public final PBStringField role_id = PBField.initString("");
    public final PBUInt64Field yes_uid = PBField.initUInt64(0);
    public PubgDataOuterClass$PUBGTeamData team_info = new PubgDataOuterClass$PUBGTeamData();
    public YoloBattlePubgOuterClass$YoloPUBGSchema join_team_schema = new YoloBattlePubgOuterClass$YoloPUBGSchema();
}
