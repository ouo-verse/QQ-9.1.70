package com.tencent.trpcprotocol.kuolie.gray_ctrl.gray_ctrl;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class GrayCtrl$GameInfo extends MessageMicro<GrayCtrl$GameInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 48, 56, 66, 74, 80, 90}, new String[]{"game_desc", "game_pos", "back_ground", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_END_PLAY_TIME, "max_room_wait_time", "max_loading_time", "game_id", "jump_url", "icon", "color", "sub_title"}, new Object[]{"", 0, "", 0, 0L, 0L, 0, "", "", 0L, ""}, GrayCtrl$GameInfo.class);
    public final PBStringField game_desc = PBField.initString("");
    public final PBUInt32Field game_pos = PBField.initUInt32(0);
    public final PBStringField back_ground = PBField.initString("");
    public final PBUInt32Field play_time = PBField.initUInt32(0);
    public final PBUInt64Field max_room_wait_time = PBField.initUInt64(0);
    public final PBUInt64Field max_loading_time = PBField.initUInt64(0);
    public final PBEnumField game_id = PBField.initEnum(0);
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBUInt64Field color = PBField.initUInt64(0);
    public final PBStringField sub_title = PBField.initString("");
}
