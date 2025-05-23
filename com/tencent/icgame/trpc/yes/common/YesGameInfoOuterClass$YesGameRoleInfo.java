package com.tencent.icgame.trpc.yes.common;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YesGameInfoOuterClass$YesGameRoleInfo extends MessageMicro<YesGameInfoOuterClass$YesGameRoleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 106, 112, 120, 130, 136, 146, 154, 162, 170, 176, 186, 192, 202, 210}, new String[]{GdtGetUserInfoHandler.KEY_AREA, "partition", "display_hero_list", "display_branch_list", "win_num", "lose_num", "win_mvp", "lose_mvp", "logic_grade_level", "disp_grade_level", "ranking_star", "hero_count", "role_name", "role_level", "register_time", "head_url", "big_grade_level", "role_desc", "grade_level_name", "grade_level_short_name", "role_id", "vip_level", "smoba_ext_info", "yes_platid", "qsm_ext_info", "grade_icon"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", 0, 0, "", 0, "", "", "", "", 0, null, 0, null, ""}, YesGameInfoOuterClass$YesGameRoleInfo.class);
    public final PBUInt32Field big_grade_level;
    public final PBUInt32Field disp_grade_level;
    public final PBRepeatField<Integer> display_branch_list;
    public final PBRepeatField<Integer> display_hero_list;
    public final PBStringField grade_icon;
    public final PBStringField grade_level_name;
    public final PBStringField grade_level_short_name;
    public final PBStringField head_url;
    public final PBUInt32Field hero_count;
    public final PBUInt32Field logic_grade_level;
    public final PBUInt32Field lose_mvp;
    public final PBUInt32Field lose_num;
    public YesGameInfoOuterClass$QsmExtInfo qsm_ext_info;
    public final PBUInt32Field ranking_star;
    public final PBUInt32Field register_time;
    public final PBStringField role_desc;
    public final PBStringField role_id;
    public final PBUInt32Field role_level;
    public final PBStringField role_name;
    public YesGameInfoOuterClass$SmobaExtInfo smoba_ext_info;
    public final PBUInt32Field vip_level;
    public final PBUInt32Field win_mvp;
    public final PBUInt32Field win_num;
    public final PBInt32Field yes_platid;
    public final PBUInt32Field area = PBField.initUInt32(0);
    public final PBUInt32Field partition = PBField.initUInt32(0);

    /* JADX WARN: Type inference failed for: r0v2, types: [com.tencent.icgame.trpc.yes.common.YesGameInfoOuterClass$QsmExtInfo] */
    public YesGameInfoOuterClass$YesGameRoleInfo() {
        PBInt32Field pBInt32Field = PBInt32Field.__repeatHelper__;
        this.display_hero_list = PBField.initRepeat(pBInt32Field);
        this.display_branch_list = PBField.initRepeat(pBInt32Field);
        this.win_num = PBField.initUInt32(0);
        this.lose_num = PBField.initUInt32(0);
        this.win_mvp = PBField.initUInt32(0);
        this.lose_mvp = PBField.initUInt32(0);
        this.logic_grade_level = PBField.initUInt32(0);
        this.disp_grade_level = PBField.initUInt32(0);
        this.ranking_star = PBField.initUInt32(0);
        this.hero_count = PBField.initUInt32(0);
        this.role_name = PBField.initString("");
        this.role_level = PBField.initUInt32(0);
        this.register_time = PBField.initUInt32(0);
        this.head_url = PBField.initString("");
        this.big_grade_level = PBField.initUInt32(0);
        this.role_desc = PBField.initString("");
        this.grade_level_name = PBField.initString("");
        this.grade_level_short_name = PBField.initString("");
        this.role_id = PBField.initString("");
        this.vip_level = PBField.initUInt32(0);
        this.smoba_ext_info = new YesGameInfoOuterClass$SmobaExtInfo();
        this.yes_platid = PBField.initInt32(0);
        this.qsm_ext_info = new MessageMicro<YesGameInfoOuterClass$QsmExtInfo>() { // from class: com.tencent.icgame.trpc.yes.common.YesGameInfoOuterClass$QsmExtInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"history_best_ladder_rank", "history_best_ladder_rank_score", "history_best_area_rank", "game_info"}, new Object[]{0, 0, null, null}, YesGameInfoOuterClass$QsmExtInfo.class);
            public final PBUInt32Field history_best_ladder_rank = PBField.initUInt32(0);
            public final PBUInt32Field history_best_ladder_rank_score = PBField.initUInt32(0);
            public QsmDataOuterClass$QSMIDIPPlayerAreaRank history_best_area_rank = new QsmDataOuterClass$QSMIDIPPlayerAreaRank();
            public QsmDataOuterClass$QSMIDIPPlayerGameInfo game_info = new QsmDataOuterClass$QSMIDIPPlayerGameInfo();
        };
        this.grade_icon = PBField.initString("");
    }
}
