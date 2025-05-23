package com.tencent.trpcprotocol.gamecenter.metadream;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes11.dex */
public final class metadream_qgroup_datacard$UserProfile extends MessageMicro<metadream_qgroup_datacard$UserProfile> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 48, 56, 66, 74, 82, 88, 96, 106, 112, 120, 160, 168, 176, 184, 192, 200, 208, 216, 242}, new String[]{"nickname", "avatar", "gender", "user_labels", "inner_game_images", "level", "artisan_level", "current_qualifying", "history_highest_qualifying", "gopenid", "online_status", "uid", "ugc_level", GdtGetUserInfoHandler.KEY_AREA, "platid", "total_battle_times", "final_battle_times", "championship_battle_times", "battle_likes", "played_maps", "active_days", "costume_count", "season_fashion_score", "user_tag_names"}, new Object[]{"", "", 0, null, "", 0, 0, null, null, "", 0, 0L, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ""}, metadream_qgroup_datacard$UserProfile.class);
    public final PBInt32Field active_days;
    public final PBInt32Field area;
    public final PBInt32Field artisan_level;
    public final PBInt32Field battle_likes;
    public final PBInt32Field championship_battle_times;
    public final PBInt32Field costume_count;
    public metadream_qgroup_datacard$QualifyingDegreeInfo current_qualifying;
    public final PBInt32Field final_battle_times;
    public final PBStringField gopenid;
    public metadream_qgroup_datacard$QualifyingDegreeInfo history_highest_qualifying;
    public final PBRepeatField<String> inner_game_images;
    public final PBInt32Field level;
    public final PBEnumField online_status;
    public final PBInt32Field platid;
    public final PBInt32Field played_maps;
    public final PBInt32Field season_fashion_score;
    public final PBInt32Field total_battle_times;
    public metadream_qgroup_datacard$QualifyingDegreeInfo ugc_level;
    public final PBUInt64Field uid;
    public final PBRepeatField<String> user_tag_names;
    public final PBStringField nickname = PBField.initString("");
    public final PBStringField avatar = PBField.initString("");
    public final PBEnumField gender = PBField.initEnum(0);
    public final PBRepeatMessageField<metadream_qgroup_datacard$UserLabel> user_labels = PBField.initRepeatMessage(metadream_qgroup_datacard$UserLabel.class);

    public metadream_qgroup_datacard$UserProfile() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.inner_game_images = PBField.initRepeat(pBStringField);
        this.level = PBField.initInt32(0);
        this.artisan_level = PBField.initInt32(0);
        this.current_qualifying = new metadream_qgroup_datacard$QualifyingDegreeInfo();
        this.history_highest_qualifying = new metadream_qgroup_datacard$QualifyingDegreeInfo();
        this.gopenid = PBField.initString("");
        this.online_status = PBField.initEnum(0);
        this.uid = PBField.initUInt64(0L);
        this.ugc_level = new metadream_qgroup_datacard$QualifyingDegreeInfo();
        this.area = PBField.initInt32(0);
        this.platid = PBField.initInt32(0);
        this.total_battle_times = PBField.initInt32(0);
        this.final_battle_times = PBField.initInt32(0);
        this.championship_battle_times = PBField.initInt32(0);
        this.battle_likes = PBField.initInt32(0);
        this.played_maps = PBField.initInt32(0);
        this.active_days = PBField.initInt32(0);
        this.costume_count = PBField.initInt32(0);
        this.season_fashion_score = PBField.initInt32(0);
        this.user_tag_names = PBField.initRepeat(pBStringField);
    }
}
