package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class PremadesTeamServerOuterClass$GetUserCurrentTeamInfoRsp extends MessageMicro<PremadesTeamServerOuterClass$GetUserCurrentTeamInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"team_id", "name", "desc", "pag_url", "gift_config"}, new Object[]{0L, "", "", "", null}, PremadesTeamServerOuterClass$GetUserCurrentTeamInfoRsp.class);
    public final PBUInt64Field team_id = PBField.initUInt64(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBStringField pag_url = PBField.initString("");
    public YoloRoomOuterClass$YoloGiftConfig gift_config = new YoloRoomOuterClass$YoloGiftConfig();
}
