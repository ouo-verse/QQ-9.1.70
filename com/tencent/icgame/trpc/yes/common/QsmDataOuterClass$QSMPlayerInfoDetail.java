package com.tencent.icgame.trpc.yes.common;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class QsmDataOuterClass$QSMPlayerInfoDetail extends MessageMicro<QsmDataOuterClass$QSMPlayerInfoDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 58, 64, 72, 80, 88, 98, 104, 112, 122, 128}, new String[]{GdtGetUserInfoHandler.KEY_AREA, "partition", "platid", "openid", "register_time", "last_login_time", "player_name", "ladder_rank_index", "ladder_rank_score", "player_level", "player_driver_license", "player_pic_url", "history_best_ladder_rank_index", "history_best_ladder_rank_score", "history_best_area_rank", "uid"}, new Object[]{0, 0, 0, "", 0L, 0L, "", 0, 0, 0, 0, "", 0, 0, null, 0L}, QsmDataOuterClass$QSMPlayerInfoDetail.class);
    public final PBInt32Field area = PBField.initInt32(0);
    public final PBInt32Field partition = PBField.initInt32(0);
    public final PBInt32Field platid = PBField.initInt32(0);
    public final PBStringField openid = PBField.initString("");
    public final PBUInt64Field register_time = PBField.initUInt64(0);
    public final PBUInt64Field last_login_time = PBField.initUInt64(0);
    public final PBStringField player_name = PBField.initString("");
    public final PBUInt32Field ladder_rank_index = PBField.initUInt32(0);
    public final PBUInt32Field ladder_rank_score = PBField.initUInt32(0);
    public final PBUInt32Field player_level = PBField.initUInt32(0);
    public final PBUInt32Field player_driver_license = PBField.initUInt32(0);
    public final PBStringField player_pic_url = PBField.initString("");
    public final PBUInt32Field history_best_ladder_rank_index = PBField.initUInt32(0);
    public final PBUInt32Field history_best_ladder_rank_score = PBField.initUInt32(0);
    public QsmDataOuterClass$QSMIDIPPlayerAreaRank history_best_area_rank = new QsmDataOuterClass$QSMIDIPPlayerAreaRank();
    public final PBUInt64Field uid = PBField.initUInt64(0);
}
