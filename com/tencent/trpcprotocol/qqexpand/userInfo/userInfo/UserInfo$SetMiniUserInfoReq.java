package com.tencent.trpcprotocol.qqexpand.userInfo.userInfo;

import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class UserInfo$SetMiniUserInfoReq extends MessageMicro<UserInfo$SetMiniUserInfoReq> {
    public static final int AchievementsID = 9;
    public static final int AvatarID = 2;
    public static final int BaseInfoID = 1;
    public static final int ExpandInfoID = 3;
    public static final int IdolsID = 10;
    public static final int LongNickID = 5;
    public static final int MatchSrcID = 6;
    public static final int PersonalLabelsID = 4;
    public static final int PicturesWallID = 12;
    public static final int QuestionAndAnswerListID = 8;
    public static final int Reserve = 0;
    public static final int SelectedPicID = 7;
    public static final int WangzheRecordID = 11;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"mini_info_ids", "infos"}, new Object[]{0, null}, UserInfo$SetMiniUserInfoReq.class);
    public final PBRepeatField<Integer> mini_info_ids = PBField.initRepeat(PBEnumField.__repeatHelper__);
    public UserInfo$MiniInfo infos = new MessageMicro<UserInfo$MiniInfo>() { // from class: com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo$MiniInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, MessageHandlerConstants.NOTIFY_TYPE_DANCE_MACHINE}, new String[]{"base_info", "avatar", "expand_info", "personal_labels", "long_nick", "match_src", "selected_pic", "question_and_answer_list", "achievements", "idols", "wangzhe_record", "pictures_wall_urls", "personalized_labels"}, new Object[]{null, "", null, "", "", null, "", null, null, null, null, null, null}, UserInfo$MiniInfo.class);
        public final PBRepeatMessageField<UserInfo$Achievements> achievements;
        public final PBRepeatMessageField<UserInfo$Idols> idols;
        public final PBStringField long_nick;
        public UserInfo$MatchSrc match_src;
        public final PBRepeatField<String> personal_labels;
        public UserInfo$PersonalizedLabels personalized_labels;
        public UserInfo$PicturesWall pictures_wall_urls;
        public UserInfo$QuestionAndAnswerList question_and_answer_list;
        public final PBRepeatField<String> selected_pic;
        public UserInfo$WangzheRecord wangzhe_record;
        public UserInfo$BaseInfo base_info = new MessageMicro<UserInfo$BaseInfo>() { // from class: com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo$BaseInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42, 50, 58, 66, 74}, new String[]{"nick", "age", LpReport_UserInfo_dc02148.CONSTELLATION, "gender", "birthday", "self_birthday", "age_group", "city", "location"}, new Object[]{"", 0, "", 0, null, null, "", "", null}, UserInfo$BaseInfo.class);
            public final PBStringField nick = PBField.initString("");
            public final PBUInt32Field age = PBField.initUInt32(0);
            public final PBStringField constellation = PBField.initString("");
            public final PBUInt32Field gender = PBField.initUInt32(0);
            public UserInfo$Birthday birthday = new MessageMicro<UserInfo$Birthday>() { // from class: com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo$Birthday
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"year", "month", "day"}, new Object[]{0, 0, 0}, UserInfo$Birthday.class);
                public final PBUInt32Field year = PBField.initUInt32(0);
                public final PBUInt32Field month = PBField.initUInt32(0);
                public final PBUInt32Field day = PBField.initUInt32(0);
            };
            public UserInfo$Birthday self_birthday = new MessageMicro<UserInfo$Birthday>() { // from class: com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo$Birthday
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"year", "month", "day"}, new Object[]{0, 0, 0}, UserInfo$Birthday.class);
                public final PBUInt32Field year = PBField.initUInt32(0);
                public final PBUInt32Field month = PBField.initUInt32(0);
                public final PBUInt32Field day = PBField.initUInt32(0);
            };
            public final PBStringField age_group = PBField.initString("");
            public final PBStringField city = PBField.initString("");
            public UserInfo$LocationInfo location = new MessageMicro<UserInfo$LocationInfo>() { // from class: com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo$LocationInfo
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"country", "province", "city", "district"}, new Object[]{0, 0, 0, 0}, UserInfo$LocationInfo.class);
                public final PBUInt32Field country = PBField.initUInt32(0);
                public final PBUInt32Field province = PBField.initUInt32(0);
                public final PBUInt32Field city = PBField.initUInt32(0);
                public final PBUInt32Field district = PBField.initUInt32(0);
            };
        };
        public final PBStringField avatar = PBField.initString("");
        public UserInfo$ExpandInfo expand_info = new MessageMicro<UserInfo$ExpandInfo>() { // from class: com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo$ExpandInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"declarationa", "voice_url", "voice_duration", "voice_color"}, new Object[]{"", "", 0, ""}, UserInfo$ExpandInfo.class);
            public final PBStringField declarationa = PBField.initString("");
            public final PBStringField voice_url = PBField.initString("");
            public final PBUInt32Field voice_duration = PBField.initUInt32(0);
            public final PBStringField voice_color = PBField.initString("");
        };

        /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo$BaseInfo] */
        /* JADX WARN: Type inference failed for: r0v10, types: [com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo$WangzheRecord] */
        /* JADX WARN: Type inference failed for: r0v11, types: [com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo$PicturesWall] */
        /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo$MatchSrc] */
        /* JADX WARN: Type inference failed for: r0v5, types: [com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo$QuestionAndAnswerList] */
        /* JADX WARN: Type inference failed for: r1v1, types: [com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo$ExpandInfo] */
        /* JADX WARN: Type inference failed for: r2v1, types: [com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo$PersonalizedLabels] */
        {
            PBStringField pBStringField = PBStringField.__repeatHelper__;
            this.personal_labels = PBField.initRepeat(pBStringField);
            this.personalized_labels = new MessageMicro<UserInfo$PersonalizedLabels>() { // from class: com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo$PersonalizedLabels
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"personal_labels", "same_personal_labels"}, new Object[]{"", ""}, UserInfo$PersonalizedLabels.class);
                public final PBRepeatField<String> personal_labels;
                public final PBRepeatField<String> same_personal_labels;

                {
                    PBStringField pBStringField2 = PBStringField.__repeatHelper__;
                    this.personal_labels = PBField.initRepeat(pBStringField2);
                    this.same_personal_labels = PBField.initRepeat(pBStringField2);
                }
            };
            this.long_nick = PBField.initString("");
            this.match_src = new MessageMicro<UserInfo$MatchSrc>() { // from class: com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo$MatchSrc
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"id", "description"}, new Object[]{0, ""}, UserInfo$MatchSrc.class);

                /* renamed from: id, reason: collision with root package name */
                public final PBUInt32Field f381599id = PBField.initUInt32(0);
                public final PBStringField description = PBField.initString("");
            };
            this.selected_pic = PBField.initRepeat(pBStringField);
            this.question_and_answer_list = new MessageMicro<UserInfo$QuestionAndAnswerList>() { // from class: com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo$QuestionAndAnswerList
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"question_and_answer"}, new Object[]{null}, UserInfo$QuestionAndAnswerList.class);
                public final PBRepeatMessageField<UserInfo$QuestionAndAnswer> question_and_answer = PBField.initRepeatMessage(UserInfo$QuestionAndAnswer.class);
            };
            this.achievements = PBField.initRepeatMessage(UserInfo$Achievements.class);
            this.idols = PBField.initRepeatMessage(UserInfo$Idols.class);
            this.wangzhe_record = new MessageMicro<UserInfo$WangzheRecord>() { // from class: com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo$WangzheRecord
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{QQPermissionConstants.Permission.AUIDO_GROUP, "use_cache", "update_time"}, new Object[]{null, Boolean.FALSE, 0L}, UserInfo$WangzheRecord.class);
                public UserInfo$Record record = new MessageMicro<UserInfo$Record>() { // from class: com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo$Record
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 17, 24, 32, 40, 50}, new String[]{"grade", "win_rate", "games_total", "mvp_total", "best_occupation", "best_heros"}, new Object[]{0L, Double.valueOf(0.0d), 0L, 0L, 0, null}, UserInfo$Record.class);
                    public static final int assassin = 3;
                    public static final int assist = 6;
                    public static final int mage = 4;
                    public static final int occupation_unset = 0;
                    public static final int shooter = 5;
                    public static final int tank = 1;
                    public static final int warrior = 2;
                    public final PBInt64Field grade = PBField.initInt64(0);
                    public final PBDoubleField win_rate = PBField.initDouble(0.0d);
                    public final PBInt64Field games_total = PBField.initInt64(0);
                    public final PBInt64Field mvp_total = PBField.initInt64(0);
                    public final PBEnumField best_occupation = PBField.initEnum(0);
                    public final PBRepeatMessageField<UserInfo$UserHeroInfo> best_heros = PBField.initRepeatMessage(UserInfo$UserHeroInfo.class);
                };
                public final PBBoolField use_cache = PBField.initBool(false);
                public final PBUInt64Field update_time = PBField.initUInt64(0);
            };
            this.pictures_wall_urls = new MessageMicro<UserInfo$PicturesWall>() { // from class: com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo$PicturesWall
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"pictures_wall_pic"}, new Object[]{""}, UserInfo$PicturesWall.class);
                public final PBRepeatField<String> pictures_wall_pic = PBField.initRepeat(PBStringField.__repeatHelper__);
            };
        }
    };
}
