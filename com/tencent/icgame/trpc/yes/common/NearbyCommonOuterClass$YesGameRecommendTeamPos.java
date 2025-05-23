package com.tencent.icgame.trpc.yes.common;

import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.weiyun.poi.PoiDbManager;

/* loaded from: classes7.dex */
public final class NearbyCommonOuterClass$YesGameRecommendTeamPos extends MessageMicro<NearbyCommonOuterClass$YesGameRecommendTeamPos> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{c.G, "status", "userinfo"}, new Object[]{0, 0, null}, NearbyCommonOuterClass$YesGameRecommendTeamPos.class);
    public final PBUInt32Field pos = PBField.initUInt32(0);
    public final PBInt32Field status = PBField.initInt32(0);
    public NearbyCommonOuterClass$YesGameRecommendTeamUser userinfo = new MessageMicro<NearbyCommonOuterClass$YesGameRecommendTeamUser>() { // from class: com.tencent.icgame.trpc.yes.common.NearbyCommonOuterClass$YesGameRecommendTeamUser
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 58, 64, 72, 82, 88, 98, 106, 114}, new String[]{"yes_uid", "avatar", "nick", "gender", "signature", "location", PoiDbManager.COL_POI_CITY_ID, "city_zone_id", "grade_level", "grade_icon", "cur_status", "achievements", "address", "team_id"}, new Object[]{"", "", "", 0, "", null, "", 0, 0, "", 0, null, null, ""}, NearbyCommonOuterClass$YesGameRecommendTeamUser.class);
        public final PBStringField yes_uid = PBField.initString("");
        public final PBStringField avatar = PBField.initString("");
        public final PBStringField nick = PBField.initString("");
        public final PBUInt32Field gender = PBField.initUInt32(0);
        public final PBStringField signature = PBField.initString("");
        public UserProxyCmdOuterClass$Location location = new UserProxyCmdOuterClass$Location();
        public final PBStringField city_id = PBField.initString("");
        public final PBUInt32Field city_zone_id = PBField.initUInt32(0);
        public final PBUInt32Field grade_level = PBField.initUInt32(0);
        public final PBStringField grade_icon = PBField.initString("");
        public final PBInt32Field cur_status = PBField.initInt32(0);
        public final PBRepeatMessageField<NearbyCommonOuterClass$YesGameRecommendUserAchievement> achievements = PBField.initRepeatMessage(NearbyCommonOuterClass$YesGameRecommendUserAchievement.class);
        public UserProxyCmdOuterClass$Address address = new UserProxyCmdOuterClass$Address();
        public final PBStringField team_id = PBField.initString("");
    };
}
