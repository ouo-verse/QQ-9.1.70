package com.tencent.icgame.trpc.yes.common;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class MiniGameDataOuterClass$YoloBattleMiniGamePlayerResult extends MessageMicro<MiniGameDataOuterClass$YoloBattleMiniGamePlayerResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 72, 80, 90, 800, 808}, new String[]{"uid", "camp_id", "rank", "result", LocalPhotoFaceInfo.SCORE, "play_flag", "punishment_flag", "data_idx_list", "co_score", "data_obj", "quit_in_game", "check_flag"}, new Object[]{0L, 0, 0, 0, 0, 0, 0, 0, 0, "", Boolean.FALSE, 0}, MiniGameDataOuterClass$YoloBattleMiniGamePlayerResult.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBInt32Field camp_id = PBField.initInt32(0);
    public final PBInt32Field rank = PBField.initInt32(0);
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBInt32Field score = PBField.initInt32(0);
    public final PBInt32Field play_flag = PBField.initInt32(0);
    public final PBInt32Field punishment_flag = PBField.initInt32(0);
    public final PBRepeatField<Integer> data_idx_list = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBInt32Field co_score = PBField.initInt32(0);
    public final PBStringField data_obj = PBField.initString("");
    public final PBBoolField quit_in_game = PBField.initBool(false);
    public final PBEnumField check_flag = PBField.initEnum(0);
}
