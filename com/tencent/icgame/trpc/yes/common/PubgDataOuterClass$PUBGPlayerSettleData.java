package com.tencent.icgame.trpc.yes.common;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class PubgDataOuterClass$PUBGPlayerSettleData extends MessageMicro<PubgDataOuterClass$PUBGPlayerSettleData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 69, 74, 82, 90, 800, 808}, new String[]{"assist_cnt", "damage", "game_duration", "is_mvp", "kill_cnt", "plat_id", "rescue_amount", LocalPhotoFaceInfo.SCORE, "openid", "role_id", "role_name", "yes_uid", "team_type"}, new Object[]{0, 0, 0, Boolean.FALSE, 0, 0, 0, Float.valueOf(0.0f), "", "", "", 0L, 0}, PubgDataOuterClass$PUBGPlayerSettleData.class);
    public final PBInt32Field assist_cnt = PBField.initInt32(0);
    public final PBInt32Field damage = PBField.initInt32(0);
    public final PBInt32Field game_duration = PBField.initInt32(0);
    public final PBBoolField is_mvp = PBField.initBool(false);
    public final PBInt32Field kill_cnt = PBField.initInt32(0);
    public final PBInt32Field plat_id = PBField.initInt32(0);
    public final PBInt32Field rescue_amount = PBField.initInt32(0);
    public final PBFloatField score = PBField.initFloat(0.0f);
    public final PBStringField openid = PBField.initString("");
    public final PBStringField role_id = PBField.initString("");
    public final PBStringField role_name = PBField.initString("");
    public final PBUInt64Field yes_uid = PBField.initUInt64(0);
    public final PBInt32Field team_type = PBField.initInt32(0);
}
