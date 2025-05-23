package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes7.dex */
public final class PremadesTeamServerOuterClass$GetNearbyRecommendTeamRsp extends MessageMicro<PremadesTeamServerOuterClass$GetNearbyRecommendTeamRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 48}, new String[]{"team_list", "total", "page", "page_size", "yes_uid", "refresh_interval"}, new Object[]{null, 0, 0, 0, "", 0}, PremadesTeamServerOuterClass$GetNearbyRecommendTeamRsp.class);
    public final PBRepeatMessageField<NearbyCommonOuterClass$YesGameRecommendTeam> team_list = PBField.initRepeatMessage(NearbyCommonOuterClass$YesGameRecommendTeam.class);
    public final PBInt32Field total = PBField.initInt32(0);
    public final PBInt32Field page = PBField.initInt32(0);
    public final PBInt32Field page_size = PBField.initInt32(0);
    public final PBStringField yes_uid = PBField.initString("");
    public final PBInt32Field refresh_interval = PBField.initInt32(0);
}
