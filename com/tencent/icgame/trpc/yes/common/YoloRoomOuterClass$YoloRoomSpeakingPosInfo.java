package com.tencent.icgame.trpc.yes.common;

import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;

/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$YoloRoomSpeakingPosInfo extends MessageMicro<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 58, 64, 72, 80, 88, 96, 104, 112, 122, 128, 136, 146, 152, 162, 170, 178, 800, 808, 816}, new String[]{c.G, "status", "uid", QzoneCameraConst.Tag.ARG_PARAM_VOICE_ID, "voice_switch", "ready_status", "user_game_data", "last_ready_status_change_time", "last_remind_time", "leave_status", "unready_timeout_time", "leave_status_time", WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, "guild_id", "user_id", "from_room_id", "channel_id", "channel_name", "sub_user_from", "yolo_room_user_white_list", "show_nick", "channel_tinyid", "index", "in_speaking_time", "last_host_out_speaking_time"}, new Object[]{0, 0, 0L, "", 0, 0, null, 0, 0, 0, 0, 0, 0, 0L, null, 0L, 0L, "", 0, null, "", "", 0, 0, 0}, YoloRoomOuterClass$YoloRoomSpeakingPosInfo.class);
    public final PBUInt32Field pos = PBField.initUInt32(0);
    public final PBInt32Field status = PBField.initInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBStringField voice_id = PBField.initString("");
    public final PBInt32Field voice_switch = PBField.initInt32(0);
    public final PBInt32Field ready_status = PBField.initInt32(0);
    public YoloRoomOuterClass$YoloUserGameData user_game_data = new YoloRoomOuterClass$YoloUserGameData();
    public final PBUInt32Field last_ready_status_change_time = PBField.initUInt32(0);
    public final PBUInt32Field last_remind_time = PBField.initUInt32(0);
    public final PBInt32Field leave_status = PBField.initInt32(0);
    public final PBUInt32Field unready_timeout_time = PBField.initUInt32(0);
    public final PBUInt32Field leave_status_time = PBField.initUInt32(0);
    public final PBInt32Field user_from = PBField.initInt32(0);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
    public final PBUInt64Field from_room_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBStringField channel_name = PBField.initString("");
    public final PBInt32Field sub_user_from = PBField.initInt32(0);
    public YoloRoomOuterClass$YoloRoomUserWhiteList yolo_room_user_white_list = new YoloRoomOuterClass$YoloRoomUserWhiteList();
    public final PBStringField show_nick = PBField.initString("");
    public final PBStringField channel_tinyid = PBField.initString("");
    public final PBUInt32Field index = PBField.initUInt32(0);
    public final PBUInt32Field in_speaking_time = PBField.initUInt32(0);
    public final PBUInt32Field last_host_out_speaking_time = PBField.initUInt32(0);
}
