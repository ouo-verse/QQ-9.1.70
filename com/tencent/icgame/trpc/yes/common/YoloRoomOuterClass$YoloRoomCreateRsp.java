package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qqlive.common.api.AegisLogger;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$YoloRoomCreateRsp extends MessageMicro<YoloRoomOuterClass$YoloRoomCreateRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 50, 66, 74, 82}, new String[]{AegisLogger.ROOM_INFO, "room_speaking_pos_list", "speaking_pos_list_version", "room_conf", "rotate_messsage_list", "room_user_data", "safe_check_result", "ieg_real_name_result"}, new Object[]{null, null, 0, null, null, null, null, null}, YoloRoomOuterClass$YoloRoomCreateRsp.class);
    public YoloRoomOuterClass$YoloRoomInfo room_info = new YoloRoomOuterClass$YoloRoomInfo();
    public final PBRepeatMessageField<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> room_speaking_pos_list = PBField.initRepeatMessage(YoloRoomOuterClass$YoloRoomSpeakingPosInfo.class);
    public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
    public YoloRoomOuterClass$YoloRoomConf room_conf = new YoloRoomOuterClass$YoloRoomConf();
    public final PBRepeatMessageField<YoloRoomOuterClass$YoloRoomRotateMessage> rotate_messsage_list = PBField.initRepeatMessage(YoloRoomOuterClass$YoloRoomRotateMessage.class);
    public YoloRoomOuterClass$YoloRoomUserData room_user_data = new YoloRoomOuterClass$YoloRoomUserData();
    public SafeOuterClass$SafeCheckResult safe_check_result = new SafeOuterClass$SafeCheckResult();
    public SafeOuterClass$SafeCheckResult ieg_real_name_result = new SafeOuterClass$SafeCheckResult();
}
