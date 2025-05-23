package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.trpcprotocol.kuolie.user_config.user_config.UserConfig$UserMoodOption;
import com.tencent.trpcprotocol.qqstranger.relation.relation.Relation$FirstRelationOriginInfo;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$MiniInfo extends MessageMicro<userInfo$MiniInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42, 48, 58, 66, 74, 82, 90, 98, 106, 114, 122, 128, 136, 146, 154, 162, 168, 176, 186, 194, 200, 208, 216, 226, 234, 242, 250, 256}, new String[]{"open_id", INetChannelCallback.KEY_TINY_ID, "nick", "age", LpReport_UserInfo_dc02148.CONSTELLATION, "gender", "birthday", "city", "location", "avatar", "declaration", "pictures_wall_pic", "age_group", "my_tags", "hope_tags", "match_obj", "shield_qq_friend", "origin_info", "same_tags", "my_ark_tags", "my_tag_nums", "hope_tag_nums", "deafult_value_fields", "dating_purposes", "gender_first_flag", "verified_flag", "user_type", "user_status", "user_mood", "limit_info", "tacit_info", "head_type"}, new Object[]{"", 0L, "", 0, "", 0, null, "", null, "", "", "", "", null, null, 0, Boolean.FALSE, null, "", "", 0, 0, "", null, 0, 0, 0, "", null, null, null, 0}, userInfo$MiniInfo.class);
    public final PBStringField age_group;
    public final PBRepeatMessageField<userInfo$DatingPurpose> dating_purposes;
    public final PBRepeatField<String> deafult_value_fields;
    public final PBEnumField gender_first_flag;
    public final PBEnumField head_type;
    public final PBUInt32Field hope_tag_nums;
    public final PBRepeatMessageField<userInfo$Tag> hope_tags;
    public userInfo$LimitInfo limit_info;
    public final PBEnumField match_obj;
    public final PBRepeatField<String> my_ark_tags;
    public final PBUInt32Field my_tag_nums;
    public final PBRepeatMessageField<userInfo$Tag> my_tags;
    public Relation$FirstRelationOriginInfo origin_info;
    public final PBRepeatField<String> pictures_wall_pic;
    public final PBRepeatField<String> same_tags;
    public final PBBoolField shield_qq_friend;
    public userInfo$TacitInfo tacit_info;
    public UserConfig$UserMoodOption user_mood;
    public final PBStringField user_status;
    public final PBEnumField user_type;
    public final PBEnumField verified_flag;
    public final PBStringField open_id = PBField.initString("");
    public final PBUInt64Field tiny_id = PBField.initUInt64(0);
    public final PBStringField nick = PBField.initString("");
    public final PBUInt32Field age = PBField.initUInt32(0);
    public final PBStringField constellation = PBField.initString("");
    public final PBUInt32Field gender = PBField.initUInt32(0);
    public userInfo$Birthday birthday = new userInfo$Birthday();
    public final PBStringField city = PBField.initString("");
    public userInfo$LocationInfo location = new MessageMicro<userInfo$LocationInfo>() { // from class: com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$LocationInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"country", "province", "city", "district"}, new Object[]{0, 0, 0, 0}, userInfo$LocationInfo.class);
        public final PBUInt32Field country = PBField.initUInt32(0);
        public final PBUInt32Field province = PBField.initUInt32(0);
        public final PBUInt32Field city = PBField.initUInt32(0);
        public final PBUInt32Field district = PBField.initUInt32(0);
    };
    public final PBStringField avatar = PBField.initString("");
    public final PBStringField declaration = PBField.initString("");

    /* JADX WARN: Type inference failed for: r0v4, types: [com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$TacitInfo] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$LocationInfo] */
    public userInfo$MiniInfo() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.pictures_wall_pic = PBField.initRepeat(pBStringField);
        this.age_group = PBField.initString("");
        this.my_tags = PBField.initRepeatMessage(userInfo$Tag.class);
        this.hope_tags = PBField.initRepeatMessage(userInfo$Tag.class);
        this.match_obj = PBField.initEnum(0);
        this.shield_qq_friend = PBField.initBool(false);
        this.origin_info = new Relation$FirstRelationOriginInfo();
        this.same_tags = PBField.initRepeat(pBStringField);
        this.my_ark_tags = PBField.initRepeat(pBStringField);
        this.my_tag_nums = PBField.initUInt32(0);
        this.hope_tag_nums = PBField.initUInt32(0);
        this.deafult_value_fields = PBField.initRepeat(pBStringField);
        this.dating_purposes = PBField.initRepeatMessage(userInfo$DatingPurpose.class);
        this.gender_first_flag = PBField.initEnum(0);
        this.verified_flag = PBField.initEnum(0);
        this.user_type = PBField.initEnum(0);
        this.user_status = PBField.initString("");
        this.user_mood = new UserConfig$UserMoodOption();
        this.limit_info = new userInfo$LimitInfo();
        this.tacit_info = new MessageMicro<userInfo$TacitInfo>() { // from class: com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$TacitInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"tacit_relation", "tacit_title", "tacit_content"}, new Object[]{0, "", null}, userInfo$TacitInfo.class);
            public final PBEnumField tacit_relation = PBField.initEnum(0);
            public final PBStringField tacit_title = PBField.initString("");
            public final PBRepeatMessageField<userInfo$TacitContent> tacit_content = PBField.initRepeatMessage(userInfo$TacitContent.class);
        };
        this.head_type = PBField.initEnum(0);
    }
}
