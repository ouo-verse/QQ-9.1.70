package com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info;

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
import com.tencent.trpcprotocol.kuolie.common.signal.SignalPB$SignalMeta;
import com.tencent.view.FilterEnum;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;

/* loaded from: classes38.dex */
public final class QqstrangerUserInfoPB$UserInfo extends MessageMicro<QqstrangerUserInfoPB$UserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42, 48, 58, 66, 82, 90, 98, 106, 114, 122, 128, 136, 146, 154, 162, 168, 176, 186, 194, 200, 208, 216, 226, 234, 242, 250, 256, 266, 274, FilterEnum.MIC_PTU_BAIXI, 298, 306}, new String[]{"open_id", INetChannelCallback.KEY_TINY_ID, "nick", "age", LpReport_UserInfo_dc02148.CONSTELLATION, "gender", "birthday", "city", "avatar", "declaration", "pictures_wall_pic", "age_group", "my_tags", "hope_tags", "match_obj", "shield_qq_friend", "origin_info", "same_tags", "my_ark_tags", "my_tag_nums", "hope_tag_nums", "deafult_value_fields", "dating_purposes", "gender_fix_flag", "verified_flag", "user_type", "user_status", "user_mood", "limit_info", "tacit_info", "head_type", "zplan_head", "avatar_info", "signal_meta", "same_detail_tags", "my_ark_detail_tags"}, new Object[]{"", 0L, "", 0, "", 0, null, "", "", "", "", "", null, null, 0, Boolean.FALSE, null, "", "", 0, 0, "", null, 0, 0, 0, "", null, null, null, 0, "", null, null, null, null}, QqstrangerUserInfoPB$UserInfo.class);
    public final PBStringField age_group;
    public QqstrangerUserInfoPB$AvatarInfo avatar_info;
    public final PBRepeatMessageField<QqstrangerUserInfoPB$DatingPurpose> dating_purposes;
    public final PBRepeatField<String> deafult_value_fields;
    public final PBEnumField gender_fix_flag;
    public final PBEnumField head_type;
    public final PBUInt32Field hope_tag_nums;
    public final PBRepeatMessageField<QqstrangerUserInfoPB$Tag> hope_tags;
    public QqstrangerUserInfoPB$LimitInfo limit_info;
    public final PBEnumField match_obj;
    public final PBRepeatMessageField<QqstrangerUserInfoPB$Tag> my_ark_detail_tags;
    public final PBRepeatField<String> my_ark_tags;
    public final PBUInt32Field my_tag_nums;
    public final PBRepeatMessageField<QqstrangerUserInfoPB$Tag> my_tags;
    public QqstrangerUserInfoPB$FirstRelationOriginInfo origin_info;
    public final PBRepeatField<String> pictures_wall_pic;
    public final PBRepeatMessageField<QqstrangerUserInfoPB$Tag> same_detail_tags;
    public final PBRepeatField<String> same_tags;
    public final PBBoolField shield_qq_friend;
    public SignalPB$SignalMeta signal_meta;
    public QqstrangerUserInfoPB$TacitInfo tacit_info;
    public QqstrangerUserInfoPB$UserMood user_mood;
    public final PBStringField user_status;
    public final PBEnumField user_type;
    public final PBEnumField verified_flag;
    public final PBStringField zplan_head;
    public final PBStringField open_id = PBField.initString("");
    public final PBUInt64Field tiny_id = PBField.initUInt64(0);
    public final PBStringField nick = PBField.initString("");
    public final PBUInt32Field age = PBField.initUInt32(0);
    public final PBStringField constellation = PBField.initString("");
    public final PBUInt32Field gender = PBField.initUInt32(0);
    public QqstrangerUserInfoPB$Birthday birthday = new MessageMicro<QqstrangerUserInfoPB$Birthday>() { // from class: com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.QqstrangerUserInfoPB$Birthday
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"year", "month", "day"}, new Object[]{0, 0, 0}, QqstrangerUserInfoPB$Birthday.class);
        public final PBUInt32Field year = PBField.initUInt32(0);
        public final PBUInt32Field month = PBField.initUInt32(0);
        public final PBUInt32Field day = PBField.initUInt32(0);
    };
    public final PBStringField city = PBField.initString("");
    public final PBStringField avatar = PBField.initString("");
    public final PBStringField declaration = PBField.initString("");

    /* JADX WARN: Type inference failed for: r0v2, types: [com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.QqstrangerUserInfoPB$AvatarInfo] */
    /* JADX WARN: Type inference failed for: r2v15, types: [com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.QqstrangerUserInfoPB$UserMood] */
    /* JADX WARN: Type inference failed for: r2v16, types: [com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.QqstrangerUserInfoPB$LimitInfo] */
    /* JADX WARN: Type inference failed for: r2v17, types: [com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.QqstrangerUserInfoPB$TacitInfo] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.QqstrangerUserInfoPB$Birthday] */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.QqstrangerUserInfoPB$FirstRelationOriginInfo] */
    public QqstrangerUserInfoPB$UserInfo() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.pictures_wall_pic = PBField.initRepeat(pBStringField);
        this.age_group = PBField.initString("");
        this.my_tags = PBField.initRepeatMessage(QqstrangerUserInfoPB$Tag.class);
        this.hope_tags = PBField.initRepeatMessage(QqstrangerUserInfoPB$Tag.class);
        this.match_obj = PBField.initEnum(0);
        this.shield_qq_friend = PBField.initBool(false);
        this.origin_info = new MessageMicro<QqstrangerUserInfoPB$FirstRelationOriginInfo>() { // from class: com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.QqstrangerUserInfoPB$FirstRelationOriginInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"origin_id", "tag_text", "tinyid"}, new Object[]{0, "", 0L}, QqstrangerUserInfoPB$FirstRelationOriginInfo.class);
            public final PBEnumField origin_id = PBField.initEnum(0);
            public final PBStringField tag_text = PBField.initString("");
            public final PBUInt64Field tinyid = PBField.initUInt64(0);
        };
        this.same_tags = PBField.initRepeat(pBStringField);
        this.my_ark_tags = PBField.initRepeat(pBStringField);
        this.my_tag_nums = PBField.initUInt32(0);
        this.hope_tag_nums = PBField.initUInt32(0);
        this.deafult_value_fields = PBField.initRepeat(pBStringField);
        this.dating_purposes = PBField.initRepeatMessage(QqstrangerUserInfoPB$DatingPurpose.class);
        this.gender_fix_flag = PBField.initEnum(0);
        this.verified_flag = PBField.initEnum(0);
        this.user_type = PBField.initEnum(0);
        this.user_status = PBField.initString("");
        this.user_mood = new MessageMicro<QqstrangerUserInfoPB$UserMood>() { // from class: com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.QqstrangerUserInfoPB$UserMood
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"mood_id", "mood_text"}, new Object[]{0, ""}, QqstrangerUserInfoPB$UserMood.class);
            public final PBUInt32Field mood_id = PBField.initUInt32(0);
            public final PBStringField mood_text = PBField.initString("");
        };
        this.limit_info = new MessageMicro<QqstrangerUserInfoPB$LimitInfo>() { // from class: com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.QqstrangerUserInfoPB$LimitInfo
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBoolField limit_gender = PBField.initBool(false);
            public final PBBoolField limit_birth = PBField.initBool(false);
            public final PBStringField open_id = PBField.initString("");

            static {
                Boolean bool = Boolean.FALSE;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"limit_gender", "limit_birth", "open_id"}, new Object[]{bool, bool, ""}, QqstrangerUserInfoPB$LimitInfo.class);
            }
        };
        this.tacit_info = new MessageMicro<QqstrangerUserInfoPB$TacitInfo>() { // from class: com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.QqstrangerUserInfoPB$TacitInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"tacit_relation", "tacit_title", "tacit_content"}, new Object[]{0, "", null}, QqstrangerUserInfoPB$TacitInfo.class);
            public final PBEnumField tacit_relation = PBField.initEnum(0);
            public final PBStringField tacit_title = PBField.initString("");
            public final PBRepeatMessageField<QqstrangerUserInfoPB$TacitContent> tacit_content = PBField.initRepeatMessage(QqstrangerUserInfoPB$TacitContent.class);
        };
        this.head_type = PBField.initEnum(0);
        this.zplan_head = PBField.initString("");
        this.avatar_info = new MessageMicro<QqstrangerUserInfoPB$AvatarInfo>() { // from class: com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.QqstrangerUserInfoPB$AvatarInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"zplan_info", "item_ids"}, new Object[]{"", 0}, QqstrangerUserInfoPB$AvatarInfo.class);
            public final PBStringField zplan_info = PBField.initString("");
            public final PBRepeatField<Integer> item_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
        };
        this.signal_meta = new SignalPB$SignalMeta();
        this.same_detail_tags = PBField.initRepeatMessage(QqstrangerUserInfoPB$Tag.class);
        this.my_ark_detail_tags = PBField.initRepeatMessage(QqstrangerUserInfoPB$Tag.class);
    }
}
