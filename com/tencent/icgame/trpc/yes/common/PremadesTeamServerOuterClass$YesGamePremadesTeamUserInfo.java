package com.tencent.icgame.trpc.yes.common;

import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;

/* loaded from: classes7.dex */
public final class PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo extends MessageMicro<PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 56, 64, 74, 82, 88, 98}, new String[]{c.G, "status", "uid", "avatar", WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, "gender", "from_room_id", "lane_type", "lane_type_desc", "role_achievement", "camp_id", "user_id"}, new Object[]{0, 0, 0L, "", 0, 0, 0L, 0, "", null, 0, null}, PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo.class);
    public final PBUInt32Field pos = PBField.initUInt32(0);
    public final PBInt32Field status = PBField.initInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBStringField avatar = PBField.initString("");
    public final PBInt32Field user_from = PBField.initInt32(0);
    public final PBUInt32Field gender = PBField.initUInt32(0);
    public final PBUInt64Field from_room_id = PBField.initUInt64(0);
    public final PBInt32Field lane_type = PBField.initInt32(0);
    public final PBStringField lane_type_desc = PBField.initString("");
    public final PBRepeatMessageField<YesGameInfoOuterClass$YesGameRoleAchievement> role_achievement = PBField.initRepeatMessage(YesGameInfoOuterClass$YesGameRoleAchievement.class);
    public final PBInt32Field camp_id = PBField.initInt32(0);
    public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
}
