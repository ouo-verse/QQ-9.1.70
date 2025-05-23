package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes7.dex */
public final class PremadesTeamServerOuterClass$GetNearbyRecommendRsp extends MessageMicro<PremadesTeamServerOuterClass$GetNearbyRecommendRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48}, new String[]{"room_list", "team_list", "user_list", "white_user_list", "yes_uid", "refresh_interval"}, new Object[]{null, null, null, null, "", 0}, PremadesTeamServerOuterClass$GetNearbyRecommendRsp.class);
    public final PBRepeatMessageField<NearbyCommonOuterClass$YoloCommRoomData> room_list = PBField.initRepeatMessage(NearbyCommonOuterClass$YoloCommRoomData.class);
    public final PBRepeatMessageField<NearbyCommonOuterClass$YesGameRecommendTeam> team_list = PBField.initRepeatMessage(NearbyCommonOuterClass$YesGameRecommendTeam.class);
    public final PBRepeatMessageField<NearbyCommonOuterClass$YesGameRecommendTeamUser> user_list = PBField.initRepeatMessage(NearbyCommonOuterClass$YesGameRecommendTeamUser.class);
    public final PBRepeatMessageField<NearbyCommonOuterClass$YesGameRecommendTeamUser> white_user_list = PBField.initRepeatMessage(NearbyCommonOuterClass$YesGameRecommendTeamUser.class);
    public final PBStringField yes_uid = PBField.initString("");
    public final PBInt32Field refresh_interval = PBField.initInt32(0);
}
