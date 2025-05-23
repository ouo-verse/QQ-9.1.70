package com.tencent.icgame.trpc.yes.common;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes7.dex */
public final class QsmDataOuterClass$QSMPlayerInfoSummary extends MessageMicro<QsmDataOuterClass$QSMPlayerInfoSummary> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 56, 64, 74}, new String[]{GdtGetUserInfoHandler.KEY_AREA, "partition", "platid", "openid", "player_name", "ladder_rank_index", "ladder_rank_score", "player_driver_license", "player_pic_url"}, new Object[]{0, 0, 0, "", "", 0, 0, 0, ""}, QsmDataOuterClass$QSMPlayerInfoSummary.class);
    public final PBInt32Field area = PBField.initInt32(0);
    public final PBInt32Field partition = PBField.initInt32(0);
    public final PBInt32Field platid = PBField.initInt32(0);
    public final PBStringField openid = PBField.initString("");
    public final PBStringField player_name = PBField.initString("");
    public final PBUInt32Field ladder_rank_index = PBField.initUInt32(0);
    public final PBUInt32Field ladder_rank_score = PBField.initUInt32(0);
    public final PBUInt32Field player_driver_license = PBField.initUInt32(0);
    public final PBStringField player_pic_url = PBField.initString("");
}
