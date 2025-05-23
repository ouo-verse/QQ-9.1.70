package com.tencent.icgame.trpc.yes.common;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05507;

/* loaded from: classes7.dex */
public final class CodmDataOuterClass$CODMPlayerSettleData extends MessageMicro<CodmDataOuterClass$CODMPlayerSettleData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField user_id = PBField.initString("");
    public final PBStringField nick_name = PBField.initString("");
    public final PBInt32Field times_assist = PBField.initInt32(0);
    public final PBInt32Field camp = PBField.initInt32(0);
    public final PBInt32Field times_kill = PBField.initInt32(0);
    public final PBInt32Field times_be_killed = PBField.initInt32(0);
    public final PBInt32Field times_shot = PBField.initInt32(0);
    public final PBInt32Field times_hit_target = PBField.initInt32(0);
    public final PBInt32Field ladder_score = PBField.initInt32(0);
    public final PBInt32Field spvp_ladder_level = PBField.initInt32(0);
    public final PBBoolField is_mvp = PBField.initBool(false);
    public final PBInt32Field score = PBField.initInt32(0);
    public CodmDataOuterClass$CODMPlayerAccountInfo account_info = new MessageMicro<CodmDataOuterClass$CODMPlayerAccountInfo>() { // from class: com.tencent.icgame.trpc.yes.common.CodmDataOuterClass$CODMPlayerAccountInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"open_id"}, new Object[]{""}, CodmDataOuterClass$CODMPlayerAccountInfo.class);
        public final PBStringField open_id = PBField.initString("");
    };
    public final PBInt32Field cur_level = PBField.initInt32(0);
    public final PBFloatField forward_distance = PBField.initFloat(0.0f);
    public final PBInt32Field game_time = PBField.initInt32(0);
    public final PBInt32Field hp_score = PBField.initInt32(0);
    public final PBBoolField is_ai_player = PBField.initBool(false);
    public final PBBoolField is_fail_mvp = PBField.initBool(false);
    public CodmDataOuterClass$CODMPlayerPicInfo pic_info = new MessageMicro<CodmDataOuterClass$CODMPlayerPicInfo>() { // from class: com.tencent.icgame.trpc.yes.common.CodmDataOuterClass$CODMPlayerPicInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"selected_frame_id", "selected_pic_id", "selected_pic_url"}, new Object[]{0, 0, ""}, CodmDataOuterClass$CODMPlayerPicInfo.class);
        public final PBInt32Field selected_frame_id = PBField.initInt32(0);
        public final PBInt32Field selected_pic_id = PBField.initInt32(0);
        public final PBStringField selected_pic_url = PBField.initString("");
    };
    public final PBInt32Field player_game_state = PBField.initInt32(0);
    public final PBStringField player_guid = PBField.initString("");
    public final PBUInt64Field role_id = PBField.initUInt64(0);
    public final PBInt32Field survival_time = PBField.initInt32(0);
    public final PBInt32Field team_id = PBField.initInt32(0);
    public final PBInt32Field times_hit_weak_target = PBField.initInt32(0);
    public final PBStringField total_take_damage = PBField.initString("");
    public final PBUInt64Field yes_uid = PBField.initUInt64(0);

    static {
        String[] strArr = {"user_id", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, "times_assist", "camp", "times_kill", "times_be_killed", "times_shot", "times_hit_target", "ladder_score", "spvp_ladder_level", "is_mvp", LocalPhotoFaceInfo.SCORE, "account_info", "cur_level", "forward_distance", "game_time", "hp_score", "is_ai_player", "is_fail_mvp", QCircleLpReportDc05507.KEY_PIC_INFO, "player_game_state", "player_guid", "role_id", "survival_time", "team_id", "times_hit_weak_target", "total_take_damage", "yes_uid"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 106, 112, 125, 128, 136, 144, 152, 162, 168, 178, 184, 192, 200, 208, 218, 800}, strArr, new Object[]{"", "", 0, 0, 0, 0, 0, 0, 0, 0, bool, 0, null, 0, Float.valueOf(0.0f), 0, 0, bool, bool, null, 0, "", 0L, 0, 0, 0, "", 0L}, CodmDataOuterClass$CODMPlayerSettleData.class);
    }
}
